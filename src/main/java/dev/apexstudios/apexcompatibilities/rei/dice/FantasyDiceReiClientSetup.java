package dev.apexstudios.apexcompatibilities.rei.dice;

import dev.apexstudios.fantasydice.FantasyDice;
import dev.apexstudios.fantasydice.util.Dice;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.entry.CollapsibleEntryRegistry;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.StringUtils;

public final class FantasyDiceReiClientSetup implements REIClientPlugin {
    @Override
    public void registerCollapsibleEntries(CollapsibleEntryRegistry registry) {
        for(var material : Dice.DEFAULT_MATERIALS) {
            registerGroup(registry, material);
        }
    }

    private void registerGroup(CollapsibleEntryRegistry registry, String material) {
        registry.group(
                FantasyDice.identifier("rei_group." + material),
                Component.literal("Dice: ").append(StringUtils.capitalize(material)),
                VanillaEntryTypes.ITEM,
                stack -> hasMaterial(stack, material)
        );
    }

    private boolean hasMaterial(EntryStack<ItemStack> entryStack, String targetMaterial) {
        var stack = entryStack.getValue();
        var material = Dice.getMaterial(stack);
        return targetMaterial.equals(material);
    }
}
