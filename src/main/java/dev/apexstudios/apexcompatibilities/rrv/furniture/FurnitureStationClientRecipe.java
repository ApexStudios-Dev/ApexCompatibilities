package dev.apexstudios.apexcompatibilities.rrv.furniture;

import cc.cassian.rrv.api.recipe.ReliableClientRecipe;
import cc.cassian.rrv.api.recipe.ReliableClientRecipeType;
import cc.cassian.rrv.common.recipe.inventory.RecipeViewMenu;
import cc.cassian.rrv.common.recipe.inventory.SlotContent;
import dev.apexstudios.fantasyfurniture.common.station.FurnitureStationRecipe;
import dev.apexstudios.fantasyfurniture.common.station.FurnitureStationSetup;
import java.util.List;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeHolder;

public final class FurnitureStationClientRecipe implements ReliableClientRecipe {
    private final SlotContent planks;
    private final SlotContent wool;
    private final SlotContent bindingAgent;
    private final SlotContent result;
    private final Identifier recipeId;

    public FurnitureStationClientRecipe(RecipeHolder<FurnitureStationRecipe> holder) {
        recipeId = holder.id().identifier();

        var recipe = holder.value();
        planks = SlotContent.of(recipe.planks());
        wool = recipe.wool().map(SlotContent::of).orElseGet(SlotContent::of);
        bindingAgent = SlotContent.of(recipe.bindingAgent());
        result = SlotContent.of(recipe.result());
    }

    @Override
    public ReliableClientRecipeType getType() {
        return FurnitureStationClientRecipeType.INSTANCE;
    }

    @Override
    public void bindSlots(RecipeViewMenu.SlotFillContext slotFillContext) {
        slotFillContext.bindSlot(FurnitureStationSetup.SLOT_PLANKS, planks);
        slotFillContext.bindSlot(FurnitureStationSetup.SLOT_WOOL, wool);
        slotFillContext.bindSlot(FurnitureStationSetup.SLOT_BINDING_AGENT, bindingAgent);
        slotFillContext.bindSlot(FurnitureStationSetup.SLOT_BINDING_AGENT + 1, result);
    }

    @Override
    public List<SlotContent> getIngredients() {
        return List.of(planks, wool, bindingAgent);
    }

    @Override
    public List<SlotContent> getResults() {
        return List.of(result);
    }

    @Override
    public Identifier getId() {
        return recipeId;
    }
}
