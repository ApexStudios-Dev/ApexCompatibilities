package dev.apexstudios.apexcompatibilities;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import net.neoforged.fml.ModList;

public final class CompatManager<TOwner, TBase> implements Iterable<TBase> {
    private final Multimap<String, TBase> mods;

    private CompatManager(TOwner owner, Builder<TOwner, TBase> builder) {
        var mods = HashMultimap.<String, TBase>create();
        var modList = ModList.get();

        builder.mods.forEach((modId, factory) -> {
            if(modList.isLoaded(modId))
                mods.put(modId, factory.get().apply(owner));
        });

        this.mods = Multimaps.unmodifiableMultimap(mods);
    }

    @Override
    public Iterator<TBase> iterator() {
        return mods.values().iterator();
    }

    @Override
    public Spliterator<TBase> spliterator() {
        return mods.values().spliterator();
    }

    public Stream<TBase> stream() {
        return mods.values().stream();
    }

    public static <TOwner, TBase> CompatManager<TOwner, TBase> create(TOwner owner, Consumer<Builder<TOwner, TBase>> consumer) {
        var builder = new Builder<TOwner, TBase>();
        consumer.accept(builder);
        return new CompatManager<>(owner, builder);
    }

    public static final class Builder<TOwner, TBase> {
        private final Multimap<String, Supplier<Function<TOwner, TBase>>> mods = HashMultimap.create();

        @CanIgnoreReturnValue
        public Builder<TOwner, TBase> owned(String modId, Supplier<Function<TOwner, TBase>> factory) {
            mods.put(modId, factory);
            return this;
        }

        @SafeVarargs
        @CanIgnoreReturnValue
        public final Builder<TOwner, TBase> owned(String modId, Supplier<Function<TOwner, TBase>> factory, Supplier<Function<TOwner, TBase>>... factories) {
            owned(modId, factory);

            for(var other : factories) {
                owned(modId, other);
            }

            return this;
        }

        @CanIgnoreReturnValue
        public Builder<TOwner, TBase> with(String modId, Supplier<Supplier<TBase>> factory) {
            return owned(modId, () -> owner -> factory.get().get());
        }

        @SafeVarargs
        @CanIgnoreReturnValue
        public final Builder<TOwner, TBase> with(String modId, Supplier<Supplier<TBase>> factory, Supplier<Supplier<TBase>>... factories) {
            with(modId, factory);

            for(var other : factories) {
                with(modId, other);
            }

            return this;
        }
    }
}
