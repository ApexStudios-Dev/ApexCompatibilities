import dev.apexstudios.gradle.single.ApexSingleExtension

plugins {
    id("apex-conventions.neoforge") version "0.1.69"
    id("apex-conventions.immaculate") version "0.1.69"
    id("apex-conventions.maven-publishing") version "0.1.69"
}

group = "dev.apexstudios"

apex.neoVersion("21.5.75", "2025.06.01")
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

    // runtimeOnly(libs.rei)
    compileOnly(libs.bundles.rei)

    runtimeOnly(libs.jei)
    "dataRuntimeOnly"(libs.jei)
    compileOnly(libs.jei.api)

    implementation(libs.jade)
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
