import dev.apexstudios.gradle.ApexExtension

plugins {
    id("apex-conventions.neoforge")
    id("apex-conventions.neoforge-datagen")
    id("apex-conventions.maven-publishing")
    id("apex-conventions.jspecify")
}

group = "dev.apexstudios"
neoForge.version = "26.1.0.0-alpha.5+snapshot-2"

repositories {
    maven("https://maven.apexstudios.dev/prs/Registree/pr17") {
        content {
            includeModule("dev.apexstudios", "registree")
        }
    }

    maven("https://maven.apexstudios.dev/prs/ApexCore-Private/pr70") {
        content {
            includeModule("dev.apexstudios", "apexcore")
        }
    }

    maven("https://maven.apexstudios.dev/prs/ItemResistance-Private/pr37") {
        content {
            includeModule("dev.apexstudios", "itemresistance")
        }
    }

    maven("https://maven.apexstudios.dev/prs/InfusedFoods-Private/pr40") {
        content {
            includeModule("dev.apexstudios", "infusedfoods")
        }
    }

    maven("https://maven.apexstudios.dev/prs/FantasyDice-Private/pr38") {
        content {
            includeModule("dev.apexstudios", "fantasydice")
        }
    }

    maven("https://maven.apexstudios.dev/prs/FantasyFurniture-Private/pr100") {
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
    val registree = "26.1.9-beta-pr-17"
    implementation("dev.apexstudios:registree:$registree")
    "dataImplementation"("dev.apexstudios:registree:$registree")

    val apexcore = "26.1.11-beta-pr-70"
    implementation("dev.apexstudios:apexcore:$apexcore")
    "dataImplementation"("dev.apexstudios:apexcore:$apexcore")
    accessTransformers("dev.apexstudios:apexcore:$apexcore")

    compileOnly("dev.apexstudios:itemresistance:26.1.10-beta-pr-37")
    compileOnly("dev.apexstudios:infusedfoods:26.1.10-beta-pr-40")
    compileOnly("dev.apexstudios:fantasydice:26.1.9-beta-pr-38")

    val fantasyfurniture = "26.1.21-beta-pr-100"
    compileOnly("dev.apexstudios:fantasyfurniture:$fantasyfurniture")
    compileOnly("dev.apexstudios:fantasyfurniture_nordic:$fantasyfurniture")
    compileOnly("dev.apexstudios:fantasyfurniture_venthyr:$fantasyfurniture")
    compileOnly("dev.apexstudios:fantasyfurniture_bone:$fantasyfurniture")
    compileOnly("dev.apexstudios:fantasyfurniture_dunmer:$fantasyfurniture")
    compileOnly("dev.apexstudios:fantasyfurniture_necrolord:$fantasyfurniture")
    compileOnly("dev.apexstudios:fantasyfurniture_royal:$fantasyfurniture")
    compileOnly("dev.apexstudios:fantasyfurniture_decorations:$fantasyfurniture")

    compileOnly(libs.bundles.rei)
    compileOnly(libs.jei.api)
    compileOnly(libs.jade)

    if(!ApexExtension.IS_CI) {
        // runtimeOnly(libs.rei)
        // runtimeOnly(libs.jei)
        // runtimeOnly(libs.jade)
    }
}
