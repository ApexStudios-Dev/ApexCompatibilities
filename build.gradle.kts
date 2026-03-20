import dev.apexstudios.gradle.ApexExtension

plugins {
    id("apex-conventions.neoforge")
    id("apex-conventions.neoforge-datagen")
    id("apex-conventions.maven-publishing")
    id("apex-conventions.jspecify")
}

group = "dev.apexstudios"
neoForge.version = libs.versions.neoforge.get()

repositories {
    maven("https://prmaven.neoforged.net/NeoForge/pr2993") {
        content {
            includeModule("net.neoforged", "neoforge")
            includeModule("net.neoforged", "testframework")
        }
    }

    maven("https://maven.apexmodder.com/prs/Registree/pr17") {
        content {
            includeModule("dev.apexstudios", "registree")
        }
    }

    maven("https://maven.apexmodder.com/prs/ApexCore-Private/pr70") {
        content {
            includeModule("dev.apexstudios", "apexcore")
        }
    }

    maven("https://maven.apexmodder.com/prs/ItemResistance-Private/pr37") {
        content {
            includeModule("dev.apexstudios", "itemresistance")
        }
    }

    maven("https://maven.apexmodder.com/prs/InfusedFoods-Private/pr40") {
        content {
            includeModule("dev.apexstudios", "infusedfoods")
        }
    }

    maven("https://maven.apexmodder.com/prs/FantasyDice-Private/pr38") {
        content {
            includeModule("dev.apexstudios", "fantasydice")
        }
    }

    maven("https://maven.apexmodder.com/prs/FantasyFurniture-Private/pr100") {
        content {
            includeModule("dev.apexstudios", "fantasyfurniture")
            includeModule("dev.apexstudios", "fantasyfurniture_bone")
            includeModule("dev.apexstudios", "fantasyfurniture_decorations")
            includeModule("dev.apexstudios", "fantasyfurniture_dunmer")
            includeModule("dev.apexstudios", "fantasyfurniture_necrolord")
            includeModule("dev.apexstudios", "fantasyfurniture_nordic")
            includeModule("dev.apexstudios", "fantasyfurniture_royal")
            includeModule("dev.apexstudios", "fantasyfurniture_venthyr")
        }
    }
}

dependencies {
    implementation(libs.bundles.apexcore)
    "dataImplementation"(libs.bundles.apexcore)
    accessTransformers(libs.apexcore)

    compileOnly(libs.itemresistance)
    compileOnly(libs.infusedfoods)
    compileOnly(libs.fantasydice)

    compileOnly(libs.fantasyfurniture)
    compileOnly(libs.fantasyfurniture.nordic)
    compileOnly(libs.fantasyfurniture.venthyr)
    compileOnly(libs.fantasyfurniture.bone)
    compileOnly(libs.fantasyfurniture.dunmer)
    compileOnly(libs.fantasyfurniture.necrolord)
    compileOnly(libs.fantasyfurniture.royal)
    compileOnly(libs.fantasyfurniture.decorations)

    compileOnly(libs.bundles.rei)
    compileOnly(libs.jei.api)
    compileOnly(libs.jade)

    if(!ApexExtension.IS_CI) {
        // runtimeOnly(libs.rei)
        // runtimeOnly(libs.jei)
        // runtimeOnly(libs.jade)
    }
}
