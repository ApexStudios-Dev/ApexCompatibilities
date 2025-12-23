//package dev.apexstudios.apexcompatibilities.rei.furniture;
//
//import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
//import dev.apexstudios.fantasyfurniture.common.util.FurnitureUtil;
//import dev.apexstudios.registree.api.Registree;
//import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
//import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
//import me.shedaniel.rei.api.client.registry.entry.CollapsibleEntryRegistry;
//import me.shedaniel.rei.api.common.util.EntryStacks;
//import me.shedaniel.rei.plugin.common.BuiltinPlugin;
//import net.minecraft.core.registries.Registries;
//import net.minecraft.network.chat.Component;
//
//public class FurnitureSetReiClientSetup implements REIClientPlugin {
//    private final Registree registree;
//    private final String englishName;
//
//    protected FurnitureSetReiClientSetup(Registree registree, String englishName) {
//        this.registree = registree;
//        this.englishName = englishName;
//    }
//
//    @OverridingMethodsMustInvokeSuper
//    @Override
//    public void registerCollapsibleEntries(CollapsibleEntryRegistry registry) {
//        registry.group(
//                registree.registryName("rei_group"),
//                Component.literal(englishName),
//                registree.stream(Registries.ITEM)
//                        .map(EntryStacks::of)
//                        .toList()
//        );
//    }
//
//    @OverridingMethodsMustInvokeSuper
//    @Override
//    public void registerCategories(CategoryRegistry registry) {
//        FurnitureUtil.Names.block(registree, FurnitureUtil.Names.OVEN, block -> {
//            registry.addWorkstations(BuiltinPlugin.SMOKING, EntryStacks.of(block));
//            registry.addWorkstations(BuiltinPlugin.FUEL, EntryStacks.of(block));
//        });
//    }
//}
