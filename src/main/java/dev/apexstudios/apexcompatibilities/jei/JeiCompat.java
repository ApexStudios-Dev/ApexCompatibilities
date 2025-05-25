package dev.apexstudios.apexcompatibilities.jei;

import mezz.jei.api.IModPlugin;
import net.minecraft.resources.ResourceLocation;

public class JeiCompat implements IModPlugin {
    private final JeiSetup owner;

    protected JeiCompat(JeiSetup owner) {
        this.owner = owner;
    }

    @Override
    public final ResourceLocation getPluginUid() {
        return owner.getPluginUid();
    }
}
