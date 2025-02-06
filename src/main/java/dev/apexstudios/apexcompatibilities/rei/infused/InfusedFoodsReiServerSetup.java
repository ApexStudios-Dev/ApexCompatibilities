package dev.apexstudios.apexcompatibilities.rei.infused;

import dev.apexstudios.infusedfoods.fluid.PotionFluidSetup;
import me.shedaniel.rei.api.common.entry.comparison.FluidComparatorRegistry;
import me.shedaniel.rei.api.common.entry.comparison.ItemComparatorRegistry;
import me.shedaniel.rei.api.common.plugins.REICommonPlugin;

public final class InfusedFoodsReiServerSetup implements REICommonPlugin {
    @Override
    public void registerItemComparators(ItemComparatorRegistry registry) {
        registry.registerComponents(PotionFluidSetup.BUCKET.value());
    }

    @Override
    public void registerFluidComparators(FluidComparatorRegistry registry) {
        registry.registerNbt(PotionFluidSetup.FLUID.value());
    }
}
