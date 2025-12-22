package dev.apexstudios.apexcompatibilities.jei.furniture;

import dev.apexstudios.apexcompatibilities.jei.JeiCompat;
import dev.apexstudios.apexcompatibilities.jei.JeiSetup;
import dev.apexstudios.fantasyfurniture.station.FurnitureStationRecipe;
import dev.apexstudios.fantasyfurniture.station.FurnitureStationSetup;
import java.util.Objects;
import java.util.function.Supplier;
import mezz.jei.api.recipe.types.IRecipeHolderType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;

public final class FantasyFurnitureJeiPlugin extends JeiCompat {
    public static final Supplier<IRecipeHolderType<FurnitureStationRecipe>> RECIPE_TYPE = IRecipeHolderType.createDeferred(FurnitureStationSetup.RECIPE_TYPE::value);

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
        var level = Objects.requireNonNull(Minecraft.getInstance().level);
        registration.addRecipes(RECIPE_TYPE.get(), FurnitureStationSetup.recipes(level).toList());
    }
}
