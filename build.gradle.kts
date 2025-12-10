import dev.apexstudios.gradle.ApexExtension
import dev.apexstudios.gradle.single.ApexSingleExtension

plugins {
    id("apex-conventions.neoforge") version "0.1.82"
    id("apex-conventions.maven-publishing") version "0.1.82"
}

group = "dev.apexstudios"

apex.neoVersion("21.11.0-beta", "1.21.10", "2025.10.12")
apex.extendCompilerErrors()

val single = ApexSingleExtension.getOrCreate(project)
single.withDataGen()

repositories {
    maven("https://maven.apexstudios.dev/prs/Registree/pr11")
    maven("https://maven.apexstudios.dev/prs/Placement-Visualizer/pr14")
    maven("https://maven.apexstudios.dev/prs/ApexCore-Private/pr67")
    maven("https://maven.apexstudios.dev/prs/ItemResistance-Private/pr34")
    maven("https://maven.apexstudios.dev/prs/InfusedFoods-Private/pr37")
    maven("https://maven.apexstudios.dev/prs/FantasyDice-Private/pr35")
    maven("https://maven.apexstudios.dev/prs/FantasyFurniture-Private/pr92")
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
