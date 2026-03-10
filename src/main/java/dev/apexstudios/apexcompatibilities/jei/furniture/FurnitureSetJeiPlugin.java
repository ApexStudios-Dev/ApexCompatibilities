//package dev.apexstudios.apexcompatibilities.jei.furniture;
//
//import dev.apexstudios.apexcompatibilities.jei.JeiCompat;
//import dev.apexstudios.apexcompatibilities.jei.JeiSetup;
//import dev.apexstudios.fantasyfurniture.common.util.FurnitureUtil;
//import dev.apexstudios.registree.api.Registree;
//import mezz.jei.api.constants.RecipeTypes;
//import mezz.jei.api.registration.IRecipeCatalystRegistration;
//
//public class FurnitureSetJeiPlugin extends JeiCompat {
//    protected final Registree registree;
//
//    protected FurnitureSetJeiPlugin(JeiSetup owner, Registree registree) {
//        super(owner);
//
//        this.registree = registree;
//    }
//
//    @Override
//    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
//        FurnitureUtil.Names.block(registree, FurnitureUtil.Names.OVEN, block -> {
//            registration.addCraftingStation(RecipeTypes.SMOKING, block);
//            registration.addCraftingStation(RecipeTypes.SMOKING_FUEL, block);
//        });
//    }
//}
