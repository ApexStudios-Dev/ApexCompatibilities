package dev.apexstudios.apexcompatibilities;

import com.google.common.collect.Maps;
import com.mojang.logging.LogUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.Util;
import org.slf4j.Logger;

public final class CompatManager<TBase> implements Iterable<TBase> {
    private static final Logger LOGGER = LogUtils.getLogger();

    private final Map<String, TBase> mods;

    private CompatManager(Builder<TBase> builder) {
        mods = builder.mods
                .entrySet()
                .stream()
                .peek(entry -> LOGGER.debug("Registering {} compat: {}", builder.baseType.getSimpleName(), entry.getKey()))
                .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, entry -> entry.getValue().get()));
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

    public static <TBase> CompatManager<TBase> create(Class<TBase> baseType, Consumer<Builder<TBase>> consumer) {
        var builder = new Builder<>(baseType);
        consumer.accept(builder);
        return new CompatManager<>(builder);
    }

    public static final class Builder<TBase> {
        private final Class<TBase> baseType;
        private final Map<String, Supplier<? extends TBase>> mods = Maps.newHashMap();

        private Builder(Class<TBase> baseType) {
            this.baseType = baseType;
        }

        public Builder<TBase> with(String modId, Supplier<? extends TBase> factory) {
            if(mods.putIfAbsent(modId, factory) != null)
                throw Util.pauseInIde(new IllegalStateException("Duplicate " + baseType.getSimpleName() + " compat registration: " + modId));

            return this;
        }
    }
}
