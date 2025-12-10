//package dev.apexstudios.apexcompatibilities.rei.furniture;
//
//import dev.apexstudios.fantasyfurniture.FantasyFurniture;
//import dev.apexstudios.fantasyfurniture.station.FurnitureStationRecipe;
//import dev.apexstudios.fantasyfurniture.station.FurnitureStationSetup;
//import me.shedaniel.rei.api.common.category.CategoryIdentifier;
//import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry;
//import me.shedaniel.rei.api.common.plugins.REICommonPlugin;
//import me.shedaniel.rei.api.common.registry.display.ServerDisplayRegistry;
//
//public final class FantasyFurnitureReiServerSetup implements REICommonPlugin {
//    static final CategoryIdentifier<FurnitureStationDisplay> FURNITURE_STATION = CategoryIdentifier.of(FantasyFurniture.identifier("furniture_station"));
//
//    @Override
//    public void registerDisplaySerializer(DisplaySerializerRegistry registry) {
//        registry.register(FantasyFurniture.identifier("furniture_station_display"), FurnitureStationDisplay.SERIALIZER);
//    }
//
//    @Override
//    public void registerDisplays(ServerDisplayRegistry registry) {
//        registry.beginRecipeFiller(FurnitureStationRecipe.class)
//                .filterType(FurnitureStationSetup.RECIPE_TYPE.value())
//                .fill(FurnitureStationDisplay::of);
//    }
//}
