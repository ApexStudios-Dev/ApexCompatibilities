package dev.apexstudios.apexcompatibilities;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;
import net.neoforged.fml.ModList;

public final class CompatManager<TBase> implements Iterable<TBase> {
    private final Multimap<String, TBase> mods;

    private CompatManager(Builder<TBase> builder) {
        var mods = HashMultimap.<String, TBase>create();
        var modList = ModList.get();

        builder.mods.forEach((modId, factory) -> {
            if(modList.isLoaded(modId))
                mods.put(modId, factory.get().get());
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

    public static <TBase> CompatManager<TBase> create(Consumer<Builder<TBase>> consumer) {
        var builder = new Builder<TBase>();
        consumer.accept(builder);
        return new CompatManager<>(builder);
    }

    public static final class Builder<TBase> {
        private final Multimap<String, Supplier<Supplier<? extends TBase>>> mods = HashMultimap.create();

        public Builder<TBase> with(String modId, Supplier<Supplier<? extends TBase>> factory) {
            mods.put(modId, factory);
            return this;
        }

        @SafeVarargs
        public final Builder<TBase> with(String modId, Supplier<Supplier<? extends TBase>> factory, Supplier<Supplier<? extends TBase>>... factories) {
            with(modId, factory);

            for(var other : factories) {
                with(modId, other);
            }

            return this;
        }
    }
}
