package dev.apexstudios.apexcompatibilities.rei.infused;

import dev.apexstudios.infusedfoods.InfusedFoods;
import dev.apexstudios.infusedfoods.fluid.PotionFluidSetup;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.entry.CollapsibleEntryRegistry;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;

public final class InfusedFoodsReiClientSetup implements REIClientPlugin {
    @Override
    public void registerCollapsibleEntries(CollapsibleEntryRegistry registry) {
        registry.group(
                InfusedFoods.identifier("rei_group.bucket"),
                Component.literal("Potion Buckets"),
                VanillaEntryTypes.ITEM,
                stack -> stack.getValue().is(PotionFluidSetup.BUCKET)
        );

        registry.group(
                InfusedFoods.identifier("rei_group.infused"),
                Component.literal("Infused Food"),
                VanillaEntryTypes.ITEM,
                entry -> {
                    var stack = entry.getValue();
                    return InfusedFoods.isValidFood(stack) && stack.has(DataComponents.POTION_CONTENTS);
                }
        );
    }
}
