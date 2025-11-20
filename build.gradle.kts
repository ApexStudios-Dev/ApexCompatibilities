import dev.apexstudios.gradle.ApexExtension
import dev.apexstudios.gradle.single.ApexSingleExtension

plugins {
    id("apex-conventions.neoforge") version "0.1.75"
    id("apex-conventions.maven-publishing") version "0.1.75"
}

group = "dev.apexstudios"

apex.neoVersion("21.11.0-alpha.25w45a.20251119.234730", "1.21.10", "2025.10.12")
apex.extendCompilerErrors()

val single = ApexSingleExtension.getOrCreate(project)
single.withDataGen()

neoForge {
    accessTransformers.from(file("src/${ApexExtension.DATA_NAME}/datagen-at.cfg"))
}

repositories {
    maven("https://maven.shedaniel.me")
    maven("https://maven.architectury.dev")
    maven("https://maven.blamejared.com")
    maven("https://modmaven.dev")
    maven("https://api.modrinth.com/maven")

    maven("https://maven.apexstudios.dev/prs/Registree/pr10")
    maven("https://maven.apexstudios.dev/prs/PlacementVisualizer/pr13")
    maven("https://maven.apexstudios.dev/prs/ApexCore/pr64")
    maven("https://maven.apexstudios.dev/prs/ItemResistance/pr33")
    maven("https://maven.apexstudios.dev/prs/InfusedFoods/pr36")
    maven("https://maven.apexstudios.dev/prs/FantasyDice/pr34")
    maven("https://maven.apexstudios.dev/prs/FantasyFurniture/pr88")

    apex.neoPrMaven(this, 2815)
}

dependencies {
    includeMod(libs.registree, false)
    includeMod(libs.apexcore, false)
    includeMod(libs.itemresistance, true)
    includeMod(libs.infusedfoods, true)
    includeMod(libs.fantasydice, true)

    includeMod(libs.fantasyfurniture.asProvider(), true)
    includeMod(libs.fantasyfurniture.nordic, true)
    includeMod(libs.fantasyfurniture.venthyr, true)
    includeMod(libs.fantasyfurniture.bone, true)
    includeMod(libs.fantasyfurniture.dunmer, true)
    includeMod(libs.fantasyfurniture.necrolord, true)
    includeMod(libs.fantasyfurniture.royal, true)

    compileOnly(libs.bundles.rei)
    compileOnly(libs.jei.api)
    compileOnly(libs.jade)

    if(!ApexExtension.IS_CI) {
    // runtimeOnly(libs.rei)
        // runtimeOnly(libs.jei)
        // runtimeOnly(libs.jade)
    }
}

fun includeMod(mod: Provider<MinimalExternalModuleDependency>, compile: Boolean = false) {
    dependencies {
        if(compile) compileOnly(mod) { isTransitive = false }
        else implementation(mod) { isTransitive = false }

        "dataImplementation"(mod) { isTransitive = false }
    }
}
