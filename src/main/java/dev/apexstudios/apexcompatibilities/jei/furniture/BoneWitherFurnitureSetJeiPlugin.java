package dev.apexstudios.apexcompatibilities.jei.furniture;

import dev.apexstudios.apexcompatibilities.jei.JeiSetup;
import dev.apexstudios.fantasyfurniture.bone.WitherFurnitureSet;

public final class BoneWitherFurnitureSetJeiPlugin extends FurnitureSetJeiPlugin {
    public BoneWitherFurnitureSetJeiPlugin(JeiSetup owner) {
        super(owner, WitherFurnitureSet.FURNITURE_SET.registree);
    }
}
