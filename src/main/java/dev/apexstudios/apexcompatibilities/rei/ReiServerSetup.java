//package dev.apexstudios.apexcompatibilities.rei;
//
//import dev.apexstudios.apexcompatibilities.ApexCompatibilities;
//import dev.apexstudios.apexcompatibilities.CompatManager;
//import dev.apexstudios.apexcompatibilities.rei.dice.FantasyDiceReiServerSetup;
//import dev.apexstudios.apexcompatibilities.rei.furniture.FantasyFurnitureReiServerSetup;
//import dev.apexstudios.apexcompatibilities.rei.infused.InfusedFoodsReiServerSetup;
//import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry;
//import me.shedaniel.rei.api.common.entry.comparison.FluidComparatorRegistry;
//import me.shedaniel.rei.api.common.entry.comparison.ItemComparatorRegistry;
//import me.shedaniel.rei.api.common.entry.settings.EntrySettingsAdapterRegistry;
//import me.shedaniel.rei.api.common.entry.type.EntryTypeRegistry;
//import me.shedaniel.rei.api.common.fluid.FluidSupportProvider;
//import me.shedaniel.rei.api.common.plugins.REICommonPlugin;
//import me.shedaniel.rei.api.common.registry.display.ServerDisplayRegistry;
//import me.shedaniel.rei.api.common.transfer.info.stack.SlotAccessorRegistry;
//import me.shedaniel.rei.forge.REIPluginCommon;
//
//@REIPluginCommon
//public final class ReiServerSetup implements REICommonPlugin {
//    private final CompatManager<ReiServerSetup, REICommonPlugin> manager = CompatManager.create(this, builder -> builder
//                    .with(ApexCompatibilities.INFUSED_FOODS, () -> InfusedFoodsReiServerSetup::new)
//                    .with(ApexCompatibilities.FANTASY_DICE, () -> FantasyDiceReiServerSetup::new)
//                    .with(ApexCompatibilities.FANTASY_FURNITURE, () -> FantasyFurnitureReiServerSetup::new)
//    );
//
//    @Override
//    public void registerEntryTypes(EntryTypeRegistry registry) {
//        manager.forEach(compat -> compat.registerEntryTypes(registry));
//    }
//
//    @Override
//    public void registerEntrySettingsAdapters(EntrySettingsAdapterRegistry registry) {
//        manager.forEach(compat -> compat.registerEntrySettingsAdapters(registry));
//    }
//
//    @Override
//    public void registerItemComparators(ItemComparatorRegistry registry) {
//        manager.forEach(compat -> compat.registerItemComparators(registry));
//    }
//
//    @Override
//    public void registerFluidComparators(FluidComparatorRegistry registry) {
//        manager.forEach(compat -> compat.registerFluidComparators(registry));
//    }
//
//    @Override
//    public void registerFluidSupport(FluidSupportProvider support) {
//        manager.forEach(compat -> compat.registerFluidSupport(support));
//    }
//
//    @Override
//    public void registerDisplays(ServerDisplayRegistry registry) {
//        manager.forEach(compat -> compat.registerDisplays(registry));
//    }
//
//    @Override
//    public void registerDisplaySerializer(DisplaySerializerRegistry registry) {
//        manager.forEach(compat -> compat.registerDisplaySerializer(registry));
//    }
//
//    @Override
//    public void registerSlotAccessors(SlotAccessorRegistry registry) {
//        manager.forEach(compat -> compat.registerSlotAccessors(registry));
//    }
//}
