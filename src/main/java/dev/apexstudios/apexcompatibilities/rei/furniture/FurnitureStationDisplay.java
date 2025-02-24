package dev.apexstudios.apexcompatibilities.rei.furniture;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.apexstudios.fantasyfurniture.station.FurnitureStationRecipe;
import java.util.List;
import java.util.Optional;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;

final class FurnitureStationDisplay extends BasicDisplay {
    public static final DisplaySerializer<FurnitureStationDisplay> SERIALIZER = DisplaySerializer.of(
            RecordCodecBuilder.mapCodec(instance -> instance.group(
                    EntryIngredient.codec().listOf().fieldOf("inputs").forGetter(FurnitureStationDisplay::getInputEntries),
                    EntryIngredient.codec().listOf().fieldOf("outputs").forGetter(FurnitureStationDisplay::getOutputEntries),
                    ResourceLocation.CODEC.optionalFieldOf("location").forGetter(FurnitureStationDisplay::getDisplayLocation)
            ).apply(instance, FurnitureStationDisplay::new)),
            StreamCodec.composite(
                    EntryIngredient.streamCodec().apply(ByteBufCodecs.list()), FurnitureStationDisplay::getInputEntries,
                    EntryIngredient.streamCodec().apply(ByteBufCodecs.list()), FurnitureStationDisplay::getOutputEntries,
                    ByteBufCodecs.optional(ResourceLocation.STREAM_CODEC), FurnitureStationDisplay::getDisplayLocation,
                    FurnitureStationDisplay::new
            )
    );

    public FurnitureStationDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs, Optional<ResourceLocation> location) {
        super(inputs, outputs, location);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return FantasyFurnitureReiServerSetup.FURNITURE_STATION;
    }

    @Override
    public DisplaySerializer<? extends Display> getSerializer() {
        return SERIALIZER;
    }

    public static FurnitureStationDisplay of(RecipeHolder<FurnitureStationRecipe> holder) {
        var recipe = holder.value();

        return new FurnitureStationDisplay(
                List.of(
                        EntryIngredients.ofIngredient(recipe.planks()),
                        recipe.wool().map(EntryIngredients::ofIngredient).orElseGet(EntryIngredient::empty),
                        EntryIngredients.ofIngredient(recipe.bindingAgent())
                ),
                List.of(EntryIngredients.of(recipe.result())),
                Optional.of(holder.id().location())
        );
    }
}
