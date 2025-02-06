package dev.apexstudios.apexcompatibilities.rei.furniture;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import dev.apexstudios.fantasyfurniture.set.BlockType;
import dev.apexstudios.fantasyfurniture.set.FurnitureSet;
import java.util.function.Consumer;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.entry.CollapsibleEntryRegistry;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.plugin.common.BuiltinPlugin;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.StringUtils;

public class FurnitureSetReiClientSetup implements REIClientPlugin {
    protected final FurnitureSet furnitureSet;
    private final String englishName;

    protected FurnitureSetReiClientSetup(FurnitureSet furnitureSet, String englishName) {
        this.furnitureSet = furnitureSet;
        this.englishName = englishName;
    }

    protected FurnitureSetReiClientSetup(FurnitureSet furnitureSet) {
        this(furnitureSet, StringUtils.capitalize(furnitureSet.registree().namespace()));
    }

    @OverridingMethodsMustInvokeSuper
    @Override
    public void registerCollapsibleEntries(CollapsibleEntryRegistry registry) {
        registry.group(
                furnitureSet.registree().registryName("rei_group"),
                Component.literal(englishName),
                VanillaEntryTypes.ITEM,
                entry -> {
                    var stack = entry.getValue();
                    return furnitureSet.registree().listElements(Registries.ITEM).anyMatch(stack::is);
                }
        );
    }

    @OverridingMethodsMustInvokeSuper
    @Override
    public void registerCategories(CategoryRegistry registry) {
        run(BlockType.OVEN, block -> {
            registry.addWorkstations(BuiltinPlugin.SMOKING, EntryStacks.of(block));
            registry.addWorkstations(BuiltinPlugin.FUEL, EntryStacks.of(block));
        });
    }

    protected final <TBlock extends Block> void run(BlockType<TBlock, ?> blockType, Consumer<? super TBlock> consumer) {
        var block = furnitureSet.block(blockType);

        if(block != null)
            consumer.accept(block.value());
    }
}
