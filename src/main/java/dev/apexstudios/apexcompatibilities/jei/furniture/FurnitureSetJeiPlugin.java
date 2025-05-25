package dev.apexstudios.apexcompatibilities.jei.furniture;

import dev.apexstudios.apexcompatibilities.jei.JeiCompat;
import dev.apexstudios.apexcompatibilities.jei.JeiSetup;
import dev.apexstudios.fantasyfurniture.set.BlockTypes;
import dev.apexstudios.fantasyfurniture.set.FurnitureSet;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;

public class FurnitureSetJeiPlugin extends JeiCompat {
    protected final FurnitureSet furnitureSet;

    protected FurnitureSetJeiPlugin(JeiSetup owner, FurnitureSet furnitureSet) {
        super(owner);

        this.furnitureSet = furnitureSet;
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        furnitureSet.ifRegistered(BlockTypes.OVEN, block -> {
            registration.addCraftingStation(RecipeTypes.SMOKING, block);
            registration.addCraftingStation(RecipeTypes.SMOKING_FUEL, block);
        });
    }
}
