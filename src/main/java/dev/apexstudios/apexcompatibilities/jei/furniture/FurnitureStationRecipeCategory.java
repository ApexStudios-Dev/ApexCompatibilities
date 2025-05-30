package dev.apexstudios.apexcompatibilities.jei.furniture;

import dev.apexstudios.fantasyfurniture.station.FurnitureStationRecipe;
import dev.apexstudios.fantasyfurniture.station.FurnitureStationScreen;
import dev.apexstudios.fantasyfurniture.station.FurnitureStationSetup;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.category.AbstractRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.crafting.RecipeHolder;

public final class FurnitureStationRecipeCategory extends AbstractRecipeCategory<RecipeHolder<FurnitureStationRecipe>> {
    FurnitureStationRecipeCategory(IGuiHelper gui) {
        super(
                FantasyFurnitureJeiPlugin.RECIPE_TYPE.get(),
                FurnitureStationSetup.BLOCK.value().getName(),
                gui.createDrawableItemLike(FurnitureStationSetup.BLOCK),
                150,
                AbstractContainerMenu.SLOT_SIZE - 2
        );
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<FurnitureStationRecipe> holder, IFocusGroup focuses) {
        var recipe = holder.value();

        var maxX = getWidth();

        var woolX = AbstractContainerMenu.SLOT_SIZE;
        var bindingAgentX = woolX + AbstractContainerMenu.SLOT_SIZE;
        var resultX = maxX - AbstractContainerMenu.SLOT_SIZE + 1;

        builder.addOutputSlot(resultX, 0)
                .setStandardSlotBackground()
                .add(recipe.result());

        builder.addInputSlot(0, 0)
                .setStandardSlotBackground()
                .add(recipe.planks());

        recipe.wool().ifPresent(wool -> builder.addInputSlot(woolX, 0)
                .setStandardSlotBackground()
                .add(wool));

        builder.addInputSlot(bindingAgentX, 0)
                .setStandardSlotBackground()
                .add(recipe.bindingAgent());
    }

    @Override
    public void draw(RecipeHolder<FurnitureStationRecipe> holder, IRecipeSlotsView recipeSlotsView, GuiGraphics graphics, double mouseX, double mouseY) {
        super.draw(holder, recipeSlotsView, graphics, mouseX, mouseY);

        graphics.blitSprite(RenderType::guiTextured, FurnitureStationScreen.SPRITE_ARROW, AbstractContainerMenu.SLOT_SIZE * 3 + 8, 0, 60, 16);
    }
}
