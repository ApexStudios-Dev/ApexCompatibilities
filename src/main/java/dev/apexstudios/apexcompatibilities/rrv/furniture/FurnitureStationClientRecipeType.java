package dev.apexstudios.apexcompatibilities.rrv.furniture;

import cc.cassian.rrv.api.recipe.ReliableClientRecipeType;
import cc.cassian.rrv.common.recipe.inventory.RecipeViewMenu;
import dev.apexstudios.fantasyfurniture.common.FantasyFurniture;
import dev.apexstudios.fantasyfurniture.common.station.FurnitureStationSetup;
import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;

public final class FurnitureStationClientRecipeType implements ReliableClientRecipeType {
    static final FurnitureStationClientRecipeType INSTANCE = new FurnitureStationClientRecipeType();
    private static final Identifier BACKGROUND = FantasyFurniture.identifier("textures/gui/rrv_furniture_station.png");
    private static final Identifier ID = FantasyFurniture.identifier("furniture_station");

    @Override
    public Component getDisplayName() {
        return FurnitureStationSetup.BLOCK.value().getName();
    }

    @Override
    public int getDisplayWidth() {
        return 112;
    }

    @Override
    public int getDisplayHeight() {
        return 26;
    }

    @Override
    public Identifier getGuiTexture() {
        return BACKGROUND;
    }

    @Override
    public int getSlotCount() {
        return FurnitureStationSetup.SLOTS + 1;
    }

    @Override
    public void placeSlots(RecipeViewMenu.SlotDefinition slotDefinition) {
        slotDefinition.addItemSlot(FurnitureStationSetup.SLOT_PLANKS, 5, 5);
        slotDefinition.addItemSlot(FurnitureStationSetup.SLOT_WOOL, 25, 5);
        slotDefinition.addItemSlot(FurnitureStationSetup.SLOT_BINDING_AGENT, 45, 5);
        slotDefinition.addItemSlot(FurnitureStationSetup.SLOT_BINDING_AGENT + 1, 91, 5);
    }

    @Override
    public Identifier getId() {
        return ID;
    }

    @Override
    public ItemStack getIcon() {
        return FurnitureStationSetup.BLOCK_ITEM.value().getDefaultInstance();
    }

    @Override
    public List<ItemStack> getCraftReferences() {
        return List.of(getIcon());
    }
}
