package dev.apexstudios.apexcompatibilities.rei.dice;

import dev.apexstudios.fantasydice.common.Die;
import dev.apexstudios.fantasydice.common.FantasyDice;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.entry.CollapsibleEntryRegistry;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import net.minecraft.network.chat.Component;
import org.apache.commons.lang3.StringUtils;

public final class FantasyDiceReiClientSetup implements REIClientPlugin {
    @Override
    public void registerCollapsibleEntries(CollapsibleEntryRegistry registry) {
        for(var material : Die.DEFAULT_MATERIALS) {
            registerGroup(registry, material);
        }
    }

    private void registerGroup(CollapsibleEntryRegistry registry, String material) {
        registry.group(
                FantasyDice.REGISTREE.registryName("rei_group." + material),
                Component.literal("Dice: ").append(StringUtils.capitalize(material)),
                VanillaEntryTypes.ITEM,
                stack -> {
                    var die = stack.getValue().get(FantasyDice.DIE_COMPONENT);
                    return die != null && material.equals(die.material());
                }
        );
    }
}
