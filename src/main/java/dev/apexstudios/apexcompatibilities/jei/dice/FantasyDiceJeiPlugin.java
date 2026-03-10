//package dev.apexstudios.apexcompatibilities.jei.dice;
//
//import dev.apexstudios.apexcompatibilities.jei.JeiCompat;
//import dev.apexstudios.apexcompatibilities.jei.JeiSetup;
//import dev.apexstudios.fantasydice.common.util.DiceRegistries;
//import mezz.jei.api.registration.ISubtypeRegistration;
//
//public final class FantasyDiceJeiPlugin extends JeiCompat {
//    public FantasyDiceJeiPlugin(JeiSetup owner) {
//        super(owner);
//    }
//
//    @Override
//    public void registerItemSubtypes(ISubtypeRegistration registration) {
//        registration.registerFromDataComponentTypes(DiceRegistries.DICE_ITEM.value(), DiceRegistries.MATERIAL_COMPONENT.value(), DiceRegistries.SIDES_COMPONENT.value());
//    }
//}
