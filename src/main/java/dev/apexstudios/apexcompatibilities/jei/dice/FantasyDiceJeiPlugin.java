package dev.apexstudios.apexcompatibilities.jei.dice;

import dev.apexstudios.apexcompatibilities.jei.JeiCompat;
import dev.apexstudios.apexcompatibilities.jei.JeiSetup;
import dev.apexstudios.fantasydice.common.FantasyDice;
import mezz.jei.api.registration.ISubtypeRegistration;

public final class FantasyDiceJeiPlugin extends JeiCompat {
    public FantasyDiceJeiPlugin(JeiSetup owner) {
        super(owner);
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {
        registration.registerFromDataComponentTypes(FantasyDice.DICE_ITEM.value(), FantasyDice.DIE_COMPONENT.value());
    }
}
