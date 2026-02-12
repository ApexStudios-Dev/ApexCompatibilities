package dev.apexstudios.apexcompatibilities.jei.furniture;

import dev.apexstudios.apexcompatibilities.jei.JeiCompat;
import dev.apexstudios.apexcompatibilities.jei.JeiSetup;
import dev.apexstudios.fantasyfurniture.common.util.FurnitureUtil;
import dev.apexstudios.registree.registrar.BlockRegistrar;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;

public class FurnitureSetJeiPlugin extends JeiCompat {
    protected final BlockRegistrar blocks;

    protected FurnitureSetJeiPlugin(JeiSetup owner, BlockRegistrar blocks) {
        super(owner);

        this.blocks = blocks;
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        FurnitureUtil.Names.block(blocks, FurnitureUtil.Names.OVEN, block -> {
            registration.addCraftingStation(RecipeTypes.SMOKING, block);
            registration.addCraftingStation(RecipeTypes.SMOKING_FUEL, block);
        });
    }
}
