package dev.apexstudios.apexcompatibilities.rei.infused;

import dev.apexstudios.infusedfoods.common.util.InfusionEntries;
import me.shedaniel.rei.api.common.entry.comparison.FluidComparatorRegistry;
import me.shedaniel.rei.api.common.plugins.REICommonPlugin;

public final class InfusedFoodsReiServerSetup implements REICommonPlugin {
    @Override
    public void registerFluidComparators(FluidComparatorRegistry registry) {
        registry.registerNbt(InfusionEntries.POTION_FLUID.value());
    }
}
