import dev.apexstudios.gradle.ApexExtension
import dev.apexstudios.gradle.single.ApexSingleExtension

plugins {
    id("apex-conventions.neoforge") version "0.1.88"
    id("apex-conventions.maven-publishing") version "0.1.88"
    id("apex-conventions.jspecify") version "0.1.88"
}

group = "dev.apexstudios"

apex.neoVersion("26.1.0.0-alpha.1+snapshot-1")
apex.extendCompilerErrors()

val single = ApexSingleExtension.getOrCreate(project)
single.withDataGen()

repositories {
    maven("https://maven.apexstudios.dev/prs/Registree/pr17") {
        content {
            includeModule("dev.apexstudios", "registree")
        }
    }

    maven("https://maven.apexstudios.dev/prs/Placement-Visualizer/pr19") {
        content {
            includeModule("dev.apexstudios", "placementvisualizer")
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
            includeModule("dev.apexstudios", "fantasyfurniture-bone")
            includeModule("dev.apexstudios", "fantasyfurniture-decorations")
            includeModule("dev.apexstudios", "fantasyfurniture-dunmer")
            includeModule("dev.apexstudios", "fantasyfurniture-necrolord")
            includeModule("dev.apexstudios", "fantasyfurniture-nordic")
            includeModule("dev.apexstudios", "fantasyfurniture-royal")
            includeModule("dev.apexstudios", "fantasyfurniture-venthyr")
        }
    }
}

dependencies {
    includeMod(libs.registree, false, false)
    includeMod(libs.apexcore, false, true)
    includeMod(libs.itemresistance, true, false)
    includeMod(libs.infusedfoods, true, false)
    includeMod(libs.fantasydice, true, false)

    includeMod(libs.fantasyfurniture.asProvider(), true, false)
    includeMod(libs.fantasyfurniture.nordic, true, false)
    includeMod(libs.fantasyfurniture.venthyr, true, false)
    includeMod(libs.fantasyfurniture.bone, true, false)
    includeMod(libs.fantasyfurniture.dunmer, true, false)
    includeMod(libs.fantasyfurniture.necrolord, true, false)
    includeMod(libs.fantasyfurniture.royal, true, false)

    compileOnly(libs.bundles.rei)
    compileOnly(libs.jei.api)
    compileOnly(libs.jade)

    if(!ApexExtension.IS_CI) {
        // runtimeOnly(libs.rei)
        // runtimeOnly(libs.jei)
        // runtimeOnly(libs.jade)
    }
}

fun includeMod(mod: Provider<MinimalExternalModuleDependency>, compile: Boolean = false, at: Boolean = false) {
    dependencies {
        if(compile) compileOnly(mod) { isTransitive = false }
        else implementation(mod) { isTransitive = false }

        "dataImplementation"(mod) { isTransitive = false }

        if(at) accessTransformers(mod) { isTransitive = false }
    }
}
