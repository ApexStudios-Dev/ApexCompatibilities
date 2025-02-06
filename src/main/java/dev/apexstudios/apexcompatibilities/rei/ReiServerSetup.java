package dev.apexstudios.apexcompatibilities.rei;

import com.google.common.base.Suppliers;
import dev.apexstudios.apexcompatibilities.rei.dice.FantasyDiceReiServerSetup;
import dev.apexstudios.apexcompatibilities.rei.furniture.FantasyFurnitureReiServerSetup;
import dev.apexstudios.apexcompatibilities.rei.infused.InfusedFoodsReiServerSetup;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry;
import me.shedaniel.rei.api.common.entry.comparison.FluidComparatorRegistry;
import me.shedaniel.rei.api.common.entry.comparison.ItemComparatorRegistry;
import me.shedaniel.rei.api.common.entry.settings.EntrySettingsAdapterRegistry;
import me.shedaniel.rei.api.common.entry.type.EntryTypeRegistry;
import me.shedaniel.rei.api.common.fluid.FluidSupportProvider;
import me.shedaniel.rei.api.common.plugins.REICommonPlugin;
import me.shedaniel.rei.api.common.plugins.REIPlugin;
import me.shedaniel.rei.api.common.registry.display.ServerDisplayRegistry;
import me.shedaniel.rei.api.common.transfer.info.stack.SlotAccessorRegistry;
import me.shedaniel.rei.forge.REIPluginCommon;
import net.neoforged.fml.ModList;

@REIPluginCommon
public final class ReiServerSetup implements REICommonPlugin {
    private static final Map<String, Supplier<? extends REICommonPlugin>> MODS = Map.of(
            "infusedfoods", Suppliers.memoize(InfusedFoodsReiServerSetup::new),
            "fantasydice", Suppliers.memoize(FantasyDiceReiServerSetup::new),
            "fantasyfurniture", Suppliers.memoize(FantasyFurnitureReiServerSetup::new)
            // "fantasyfurniture_nordic", Suppliers.memoize(NordicFurnitureSetReiSetup::new)
    );

    @Override
    public void registerEntryTypes(EntryTypeRegistry registry) {
        setupMod(MODS, setup -> setup.registerEntryTypes(registry));
    }

    @Override
    public void registerEntrySettingsAdapters(EntrySettingsAdapterRegistry registry) {
        setupMod(MODS, setup -> setup.registerEntrySettingsAdapters(registry));
    }

    @Override
    public void registerItemComparators(ItemComparatorRegistry registry) {
        setupMod(MODS, setup -> setup.registerItemComparators(registry));
    }

    @Override
    public void registerFluidComparators(FluidComparatorRegistry registry) {
        setupMod(MODS, setup -> setup.registerFluidComparators(registry));
    }

    @Override
    public void registerFluidSupport(FluidSupportProvider support) {
        setupMod(MODS, setup -> setup.registerFluidSupport(support));
    }

    @Override
    public void registerDisplays(ServerDisplayRegistry registry) {
        setupMod(MODS, setup -> setup.registerDisplays(registry));
    }

    @Override
    public void registerDisplaySerializer(DisplaySerializerRegistry registry) {
        setupMod(MODS, setup -> setup.registerDisplaySerializer(registry));
    }

    @Override
    public void registerSlotAccessors(SlotAccessorRegistry registry) {
        setupMod(MODS, setup -> setup.registerSlotAccessors(registry));
    }

    static <TSetup extends REIPlugin<?>> void setupMod(Map<String, Supplier<? extends TSetup>> map, Consumer<? super TSetup> consumer) {
        var modList = ModList.get();

        map.forEach((modId, supplier) -> {
            if(modList.isLoaded(modId))
                consumer.accept(supplier.get());
        });
    }
}
