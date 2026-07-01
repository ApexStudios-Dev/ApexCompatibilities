package dev.apexstudios.apexcompatibilities.rrv.furniture;

import cc.cassian.rrv.api.ReliableRecipeViewerClientPlugin;
import cc.cassian.rrv.api.recipe.ItemView;
import cc.cassian.rrv.client.recipe.ClientRecipeManager;
import dev.apexstudios.fantasyfurniture.common.station.FurnitureStationSetup;

public final class FantasyFurnitureRrvClientSetup implements ReliableRecipeViewerClientPlugin {
    @Override
    public void onIntegrationInitialize() {
        ItemView.addClientRecipeProvider(recipes -> ClientRecipeManager.INSTANCE.getRecipesForType(FurnitureStationSetup.RECIPE_TYPE.value())
                .stream()
                .map(FurnitureStationClientRecipe::new)
                .forEach(recipes::add)
        );
    }
}
