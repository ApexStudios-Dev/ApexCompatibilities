package dev.apexstudios.apexcompatibilities.rei.infused;

import dev.apexstudios.infusedfoods.InfusedFoods;
import me.shedaniel.rei.api.common.entry.comparison.FluidComparatorRegistry;
import me.shedaniel.rei.api.common.plugins.REICommonPlugin;

public final class InfusedFoodsReiServerSetup implements REICommonPlugin {
    @Override
    public void registerFluidComparators(FluidComparatorRegistry registry) {
        registry.registerNbt(InfusedFoods.POTION_FLUID.value());
    }
}
