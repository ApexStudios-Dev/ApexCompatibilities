package dev.apexstudios.apexcompatibilities.rei.furniture;

import dev.apexstudios.fantasyfurniture.decorations.common.DecorationsFurnitureModule;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;

public final class DecorationsFurnitureModuleReiClientSetup extends FurnitureSetReiClientSetup {
    public DecorationsFurnitureModuleReiClientSetup() {
        super(DecorationsFurnitureModule.REGISTREE, "Decorations");
    }

    @Override
    public void registerCategories(CategoryRegistry registry) {
    }
}
