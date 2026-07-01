package dev.apexstudios.apexcompatibilities.rrv.dice;

import cc.cassian.rrv.api.ReliableRecipeViewerPlugin;
import cc.cassian.rrv.api.recipe.ItemView;
import dev.apexstudios.fantasydice.common.Die;

public final class FantasyDiceRrvServerSetup implements ReliableRecipeViewerPlugin {
    @Override
    public void onIntegrationInitialize() {
        ItemView.addServerReloadCallback(() -> Die.builtIn().map(Die::asStack).forEach(ItemView::addStackSensitive));
    }
}
