package dev.apexstudios.apexcompatibilities.rrv.dice;

import cc.cassian.rrv.api.ReliableRecipeViewerClientPlugin;
import cc.cassian.rrv.api.recipe.ItemView;
import dev.apexstudios.fantasydice.common.Die;
import dev.apexstudios.fantasydice.common.FantasyDice;

public final class FantasyDiceRrvClientSetup implements ReliableRecipeViewerClientPlugin {
    @Override
    public void onIntegrationInitialize() {
        ItemView.excludeItem(FantasyDice.DICE_ITEM.value());
        ItemView.addClientReloadCallback(() -> Die.builtIn().map(Die::asStack).forEach(ItemView::addStackSensitive));
    }
}
