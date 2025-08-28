import dev.apexstudios.gradle.ApexExtension
import dev.apexstudios.gradle.single.ApexSingleExtension

plugins {
    id("apex-conventions.neoforge") version "0.1.74"
    id("apex-conventions.maven-publishing") version "0.1.74"
}

group = "dev.apexstudios"

apex.neoVersion("21.9.0-alpha.25w34b.20250827.140505", "1.21.8", "2025.07.20")
apex.extendCompilerErrors()

val single = ApexSingleExtension.getOrCreate(project)
single.withDataGen()

dependencies {
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
        if(compile)
            compileOnly(mod)
        else
            implementation(mod)

        "dataImplementation"(mod)

        if(at)
            accessTransformers(mod)
    }
}
