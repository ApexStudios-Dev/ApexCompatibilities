package dev.apexstudios.apexcompatibilities.rei.furniture;

import dev.apexstudios.fantasyfurniture.common.station.FurnitureStationSetup;
import java.util.List;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.AbstractContainerMenu;

final class FurnitureStationDisplayCategory implements DisplayCategory<FurnitureStationDisplay> {
    @Override
    public CategoryIdentifier<FurnitureStationDisplay> getCategoryIdentifier() {
        return FantasyFurnitureReiServerSetup.FURNITURE_STATION;
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(FurnitureStationSetup.BLOCK_ITEM.value());
    }

    @Override
    public Component getTitle() {
        return FurnitureStationSetup.BLOCK.value().getName();
    }

    @Override
    public List<Widget> setupDisplay(FurnitureStationDisplay display, Rectangle bounds) {
        var centerY = bounds.getCenterY() - 8;
        var planksX = bounds.x + 8;
        var woolX = planksX + AbstractContainerMenu.SLOT_SIZE;
        var bindingAgentX = woolX + AbstractContainerMenu.SLOT_SIZE;
        var resultX = bounds.getMaxX() - AbstractContainerMenu.SLOT_SIZE - 8;

        var bindingAgentMaxX = bindingAgentX + AbstractContainerMenu.SLOT_SIZE;
        var dist = resultX - bindingAgentMaxX;
        var arrowWidth = 24;
        var arrowX = bindingAgentMaxX + (dist / 2) - (arrowWidth / 2);

        return List.of(
                Widgets.createRecipeBase(bounds),
                Widgets.createArrow(new Point(arrowX, centerY)),
                Widgets.createSlot(new Point(resultX, centerY))
                        .entries(display.getOutputEntries().getFirst())
                        .markOutput(),
                Widgets.createSlot(new Point(planksX, centerY))
                        .entries(display.getInputEntries().get(FurnitureStationSetup.SLOT_PLANKS))
                        .markInput(),
                Widgets.createSlot(new Point(woolX, centerY))
                        .entries(display.getInputEntries().get(FurnitureStationSetup.SLOT_WOOL))
                        .markInput(),
                Widgets.createSlot(new Point(bindingAgentX, centerY))
                        .entries(display.getInputEntries().get(FurnitureStationSetup.SLOT_BINDING_AGENT))
                        .markInput()
        );
    }

    @Override
    public int getDisplayHeight() {
        return 36;
    }
}
