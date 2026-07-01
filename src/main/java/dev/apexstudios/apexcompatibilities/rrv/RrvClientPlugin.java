package dev.apexstudios.apexcompatibilities.rrv;

import cc.cassian.rrv.api.ReliableRecipeViewerClientPlugin;
import dev.apexstudios.apexcompatibilities.ApexCompatibilities;
import dev.apexstudios.apexcompatibilities.CompatManager;
import dev.apexstudios.apexcompatibilities.rrv.dice.FantasyDiceRrvClientSetup;
import dev.apexstudios.apexcompatibilities.rrv.furniture.FantasyFurnitureRrvClientSetup;

public final class RrvClientPlugin implements ReliableRecipeViewerClientPlugin {
    private final CompatManager<RrvClientPlugin, ReliableRecipeViewerClientPlugin> manager = CompatManager.create(this, builder -> builder
            .with(ApexCompatibilities.FANTASY_DICE, () -> FantasyDiceRrvClientSetup::new)
            .with(ApexCompatibilities.FANTASY_FURNITURE, () -> FantasyFurnitureRrvClientSetup::new)
    );

    @Override
    public void onIntegrationInitialize() {
        manager.forEach(ReliableRecipeViewerClientPlugin::onIntegrationInitialize);
    }
}
