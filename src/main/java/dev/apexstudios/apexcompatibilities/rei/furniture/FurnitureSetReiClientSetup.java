package dev.apexstudios.apexcompatibilities.rei.furniture;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import dev.apexstudios.fantasyfurniture.set.BlockTypes;
import dev.apexstudios.fantasyfurniture.set.FurnitureSet;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.entry.CollapsibleEntryRegistry;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.plugin.common.BuiltinPlugin;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.apache.commons.lang3.StringUtils;

public class FurnitureSetReiClientSetup implements REIClientPlugin {
    protected final FurnitureSet furnitureSet;
    private final String englishName;

    protected FurnitureSetReiClientSetup(FurnitureSet furnitureSet, String englishName) {
        this.furnitureSet = furnitureSet;
        this.englishName = englishName;
    }

    protected FurnitureSetReiClientSetup(FurnitureSet furnitureSet) {
        this(furnitureSet, StringUtils.capitalize(furnitureSet.name()));
    }

    @OverridingMethodsMustInvokeSuper
    @Override
    public void registerCollapsibleEntries(CollapsibleEntryRegistry registry) {
        registry.group(
                ResourceLocation.fromNamespaceAndPath(furnitureSet.ownerNamespace(), "rei_group/" + furnitureSet.name()),
                Component.literal(englishName),
                VanillaEntryTypes.ITEM,
                entry -> furnitureSet.is(entry.getValue())
        );
    }

    @OverridingMethodsMustInvokeSuper
    @Override
    public void registerCategories(CategoryRegistry registry) {
        furnitureSet.ifRegistered(BlockTypes.OVEN, block -> {
            registry.addWorkstations(BuiltinPlugin.SMOKING, EntryStacks.of(block));
            registry.addWorkstations(BuiltinPlugin.FUEL, EntryStacks.of(block));
        });
    }
}
