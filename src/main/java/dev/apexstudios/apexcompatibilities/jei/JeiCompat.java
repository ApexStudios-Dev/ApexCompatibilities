package dev.apexstudios.apexcompatibilities.jei;

import mezz.jei.api.IModPlugin;
import net.minecraft.resources.Identifier;

public class JeiCompat implements IModPlugin {
    private final JeiSetup owner;

    protected JeiCompat(JeiSetup owner) {
        this.owner = owner;
    }

    @Override
    public final Identifier getPluginUid() {
        return owner.getPluginUid();
    }
}
