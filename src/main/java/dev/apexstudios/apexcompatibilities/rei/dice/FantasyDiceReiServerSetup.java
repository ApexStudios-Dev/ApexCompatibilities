package dev.apexstudios.apexcompatibilities.rei.dice;

import dev.apexstudios.fantasydice.util.DiceRegistries;
import me.shedaniel.rei.api.common.entry.comparison.ItemComparatorRegistry;
import me.shedaniel.rei.api.common.plugins.REICommonPlugin;

public final class FantasyDiceReiServerSetup implements REICommonPlugin {
    @Override
    public void registerItemComparators(ItemComparatorRegistry registry) {
        registry.registerComponents(DiceRegistries.DICE_ITEM.value());
    }
}
