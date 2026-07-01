package dev.apexstudios.apexcompatibilities.rrv.dice;

import cc.cassian.rrv.api.ReliableRecipeViewerClientPlugin;
import cc.cassian.rrv.api.recipe.ItemView;
import dev.apexstudios.fantasydice.common.FantasyDice;
import net.minecraft.world.item.ItemStackTemplate;

public final class FantasyDiceRrvClientSetup implements ReliableRecipeViewerClientPlugin {
    @Override
    public void onIntegrationInitialize() {
        ItemView.addClientReloadCallback(() -> ItemView.excludeItemStack(new ItemStackTemplate(FantasyDice.DICE_ITEM)));
    }
}
