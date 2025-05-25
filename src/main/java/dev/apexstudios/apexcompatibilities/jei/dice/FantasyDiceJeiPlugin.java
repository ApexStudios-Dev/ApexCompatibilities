package dev.apexstudios.apexcompatibilities.jei.dice;

import dev.apexstudios.apexcompatibilities.jei.JeiCompat;
import dev.apexstudios.apexcompatibilities.jei.JeiSetup;
import dev.apexstudios.fantasydice.FantasyDice;
import mezz.jei.api.registration.ISubtypeRegistration;

public final class FantasyDiceJeiPlugin extends JeiCompat {
    public FantasyDiceJeiPlugin(JeiSetup owner) {
        super(owner);
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {
        registration.registerFromDataComponentTypes(FantasyDice.DICE_ITEM.value(), FantasyDice.MATERIAL_COMPONENT.value(), FantasyDice.SIDES_COMPONENT.value());
    }
}
