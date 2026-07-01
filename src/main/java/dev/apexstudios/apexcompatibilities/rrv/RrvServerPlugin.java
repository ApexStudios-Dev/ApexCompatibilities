package dev.apexstudios.apexcompatibilities.rrv;

import cc.cassian.rrv.api.ReliableRecipeViewerPlugin;
import dev.apexstudios.apexcompatibilities.ApexCompatibilities;
import dev.apexstudios.apexcompatibilities.CompatManager;
import dev.apexstudios.apexcompatibilities.rrv.dice.FantasyDiceRrvServerSetup;

public final class RrvServerPlugin implements ReliableRecipeViewerPlugin {
    private final CompatManager<RrvServerPlugin, ReliableRecipeViewerPlugin> manager = CompatManager.create(this, builder -> builder
            .with(ApexCompatibilities.FANTASY_DICE, () -> FantasyDiceRrvServerSetup::new)
    );

    @Override
    public void onIntegrationInitialize() {
        manager.forEach(ReliableRecipeViewerPlugin::onIntegrationInitialize);
    }
}
