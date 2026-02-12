package dev.apexstudios.apexcompatibilities.jei.furniture;

import dev.apexstudios.apexcompatibilities.jei.JeiSetup;
import dev.apexstudios.fantasyfurniture.bone.common.SkeletonFurnitureSet;

public final class BoneSkeletonFurnitureSetJeiPlugin extends FurnitureSetJeiPlugin {
    public BoneSkeletonFurnitureSetJeiPlugin(JeiSetup owner) {
        super(owner, SkeletonFurnitureSet.FURNITURE_SET.blocks);
    }
}
