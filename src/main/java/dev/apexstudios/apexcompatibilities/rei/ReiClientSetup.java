package dev.apexstudios.apexcompatibilities.rei;

import com.google.common.base.Suppliers;
import dev.apexstudios.apexcompatibilities.rei.dice.FantasyDiceReiClientSetup;
import dev.apexstudios.apexcompatibilities.rei.furniture.FantasyFurnitureReiClientSetup;
import dev.apexstudios.apexcompatibilities.rei.furniture.NordicFurnitureSetReiClientSetup;
import dev.apexstudios.apexcompatibilities.rei.infused.InfusedFoodsReiClientSetup;
import java.util.Map;
import java.util.function.Supplier;
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
    private static final Map<String, Supplier<? extends REIClientPlugin>> MODS = Map.of(
            "infusedfoods", Suppliers.memoize(InfusedFoodsReiClientSetup::new),
            "fantasydice", Suppliers.memoize(FantasyDiceReiClientSetup::new),
            "fantasyfurniture", Suppliers.memoize(FantasyFurnitureReiClientSetup::new),
            "fantasyfurniture_nordic", Suppliers.memoize(NordicFurnitureSetReiClientSetup::new)
    );

    @Override
    public void registerEntryRenderers(EntryRendererRegistry registry) {
        ReiServerSetup.setupMod(MODS, setup -> setup.registerEntryRenderers(registry));
    }

    @Override
    public void registerCategories(CategoryRegistry registry) {
        ReiServerSetup.setupMod(MODS, setup -> setup.registerCategories(registry));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        ReiServerSetup.setupMod(MODS, setup -> setup.registerDisplays(registry));
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        ReiServerSetup.setupMod(MODS, setup -> setup.registerScreens(registry));
    }

    @Override
    public void registerExclusionZones(ExclusionZones zones) {
        ReiServerSetup.setupMod(MODS, setup -> setup.registerExclusionZones(zones));
    }

    @Override
    public void registerEntries(EntryRegistry registry) {
        ReiServerSetup.setupMod(MODS, setup -> setup.registerEntries(registry));
    }

    @Override
    public void registerBasicEntryFiltering(BasicFilteringRule<?> rule) {
        ReiServerSetup.setupMod(MODS, setup -> setup.registerBasicEntryFiltering(rule));
    }

    @Override
    public void registerCollapsibleEntries(CollapsibleEntryRegistry registry) {
        ReiServerSetup.setupMod(MODS, setup -> setup.registerCollapsibleEntries(registry));
    }

    @Override
    public void registerFavorites(FavoriteEntryType.Registry registry) {
        ReiServerSetup.setupMod(MODS, setup -> setup.registerFavorites(registry));
    }

    @Override
    public void registerSubsets(SubsetsRegistry registry) {
        ReiServerSetup.setupMod(MODS, setup -> setup.registerSubsets(registry));
    }

    @Override
    public void registerTransferHandlers(TransferHandlerRegistry registry) {
        ReiServerSetup.setupMod(MODS, setup -> setup.registerTransferHandlers(registry));
    }

    @Override
    public void registerConfigAddons(ConfigAddonRegistry registry) {
        ReiServerSetup.setupMod(MODS, setup -> setup.registerConfigAddons(registry));
    }

    @Override
    public void registerInputMethods(InputMethodRegistry registry) {
        ReiServerSetup.setupMod(MODS, setup -> setup.registerInputMethods(registry));
    }
}
