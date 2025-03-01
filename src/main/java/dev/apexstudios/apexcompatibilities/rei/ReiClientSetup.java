package dev.apexstudios.apexcompatibilities.rei;

import dev.apexstudios.apexcompatibilities.ApexCompatibilities;
import dev.apexstudios.apexcompatibilities.CompatManager;
import dev.apexstudios.apexcompatibilities.rei.dice.FantasyDiceReiClientSetup;
import dev.apexstudios.apexcompatibilities.rei.furniture.BoneSkeletonFurnitureSetReiClientSetup;
import dev.apexstudios.apexcompatibilities.rei.furniture.BoneWitherFurnitureSetReiClientSetup;
import dev.apexstudios.apexcompatibilities.rei.furniture.FantasyFurnitureReiClientSetup;
import dev.apexstudios.apexcompatibilities.rei.furniture.NordicFurnitureSetReiClientSetup;
import dev.apexstudios.apexcompatibilities.rei.furniture.VenthyrFurnitureSetReiClientSetup;
import dev.apexstudios.apexcompatibilities.rei.infused.InfusedFoodsReiClientSetup;
import me.shedaniel.rei.api.client.config.addon.ConfigAddonRegistry;
import me.shedaniel.rei.api.client.entry.filtering.base.BasicFilteringRule;
import me.shedaniel.rei.api.client.entry.renderer.EntryRendererRegistry;
import me.shedaniel.rei.api.client.favorites.FavoriteEntryType;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.entry.CollapsibleEntryRegistry;
import me.shedaniel.rei.api.client.registry.entry.EntryRegistry;
import me.shedaniel.rei.api.client.registry.screen.ExclusionZones;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.client.registry.transfer.TransferHandlerRegistry;
import me.shedaniel.rei.api.client.search.method.InputMethodRegistry;
import me.shedaniel.rei.api.client.subsets.SubsetsRegistry;
import me.shedaniel.rei.forge.REIPluginClient;

@REIPluginClient
public final class ReiClientSetup implements REIClientPlugin {
    private final CompatManager<REIClientPlugin> manager = CompatManager.create(builder -> builder
            .with(ApexCompatibilities.INFUSED_FOODS, () -> InfusedFoodsReiClientSetup::new)
            .with(ApexCompatibilities.FANTASY_DICE, () -> FantasyDiceReiClientSetup::new)
            .with(ApexCompatibilities.FANTASY_FURNITURE, () -> FantasyFurnitureReiClientSetup::new)
            .with(ApexCompatibilities.FANTASY_FURNITURE_NORDIC, () -> NordicFurnitureSetReiClientSetup::new)
            .with(ApexCompatibilities.FANTASY_FURNITURE_VENTHYR, () -> VenthyrFurnitureSetReiClientSetup::new)
            .with(ApexCompatibilities.FANTASY_FURNITURE_BONE, () -> BoneSkeletonFurnitureSetReiClientSetup::new, () -> BoneWitherFurnitureSetReiClientSetup::new)
    );

    @Override
    public void registerEntryRenderers(EntryRendererRegistry registry) {
        manager.forEach(compat -> compat.registerEntryRenderers(registry));
    }

    @Override
    public void registerCategories(CategoryRegistry registry) {
        manager.forEach(compat -> compat.registerCategories(registry));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        manager.forEach(compat -> compat.registerDisplays(registry));
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        manager.forEach(compat -> compat.registerScreens(registry));
    }

    @Override
    public void registerExclusionZones(ExclusionZones zones) {
        manager.forEach(compat -> compat.registerExclusionZones(zones));
    }

    @Override
    public void registerEntries(EntryRegistry registry) {
        manager.forEach(compat -> compat.registerEntries(registry));
    }

    @Override
    public void registerBasicEntryFiltering(BasicFilteringRule<?> rule) {
        manager.forEach(compat -> compat.registerBasicEntryFiltering(rule));
    }

    @Override
    public void registerCollapsibleEntries(CollapsibleEntryRegistry registry) {
        manager.forEach(compat -> compat.registerCollapsibleEntries(registry));
    }

    @Override
    public void registerFavorites(FavoriteEntryType.Registry registry) {
        manager.forEach(compat -> compat.registerFavorites(registry));
    }

    @Override
    public void registerSubsets(SubsetsRegistry registry) {
        manager.forEach(compat -> compat.registerSubsets(registry));
    }

    @Override
    public void registerTransferHandlers(TransferHandlerRegistry registry) {
        manager.forEach(compat -> compat.registerTransferHandlers(registry));
    }

    @Override
    public void registerConfigAddons(ConfigAddonRegistry registry) {
        manager.forEach(compat -> compat.registerConfigAddons(registry));
    }

    @Override
    public void registerInputMethods(InputMethodRegistry registry) {
        manager.forEach(compat -> compat.registerInputMethods(registry));
    }
}
