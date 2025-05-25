package dev.apexstudios.apexcompatibilities.jei.furniture;

import com.google.common.collect.Lists;
import dev.apexstudios.apexcompatibilities.jei.JeiCompat;
import dev.apexstudios.apexcompatibilities.jei.JeiSetup;
import dev.apexstudios.fantasyfurniture.station.FurnitureStationRecipe;
import dev.apexstudios.fantasyfurniture.station.FurnitureStationSetup;
import java.util.List;
import java.util.function.Supplier;
import mezz.jei.api.recipe.types.IRecipeHolderType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;

@EventBusSubscriber(modid = "apexcompatibilities")
public final class FantasyFurnitureJeiPlugin extends JeiCompat {
    public static final Supplier<IRecipeHolderType<FurnitureStationRecipe>> RECIPE_TYPE = IRecipeHolderType.createDeferred(FurnitureStationSetup.RECIPE_TYPE::value);
    private static final List<RecipeHolder<FurnitureStationRecipe>> RECIPES = Lists.newArrayList();

    public FantasyFurnitureJeiPlugin(JeiSetup owner) {
        super(owner);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new FurnitureStationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addCraftingStation(RECIPE_TYPE.get(), FurnitureStationSetup.BLOCK);
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(RECIPE_TYPE.get(), RECIPES);
    }

    @SubscribeEvent
    public static void onDatapackSync(OnDatapackSyncEvent event) {
        event.sendRecipes(FurnitureStationSetup.RECIPE_TYPE.value());
    }

    @SubscribeEvent
    public static void onRecipesReceived(RecipesReceivedEvent event) {
        RECIPES.clear();
        RECIPES.addAll(event.getRecipeMap().byType(FurnitureStationSetup.RECIPE_TYPE.value()));
    }
}
