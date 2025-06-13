package dev.apexstudios.apexcompatibilities.jei.furniture;

import dev.apexstudios.apexcompatibilities.jei.JeiSetup;
import dev.apexstudios.fantasyfurniture.bone.SkeletonFurnitureSet;

public final class BoneSkeletonFurnitureSetJeiPlugin extends FurnitureSetJeiPlugin {
    public BoneSkeletonFurnitureSetJeiPlugin(JeiSetup owner) {
        super(owner, SkeletonFurnitureSet.get().registree);
    }
}
