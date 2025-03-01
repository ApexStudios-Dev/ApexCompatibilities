import dev.apexstudios.gradle.single.ApexSingleExtension

plugins {
    id("apex-conventions.neoforge")
    id("apex-conventions.immaculate")
    id("apex-conventions.maven-publishing")
}

group = "dev.apexstudios"

apex.neoVersion("21.4.50-beta", "2025.01.05")
apex.extendCompilerErrors()

val single = ApexSingleExtension.getOrCreate(project)
single.withDataGen()

repositories {
    maven("https://maven.shedaniel.me")
    maven("https://maven.architectury.dev")
}

dependencies {
    includeMod(libs.apexcore, false, true, true)
    includeMod(libs.itemresistance, true, false, false)
    includeMod(libs.infusedfoods, true, false, false)
    includeMod(libs.fantasydice, true, false, false)

    includeMod(libs.fantasyfurniture.asProvider(), true, true, false)
    includeMod(libs.fantasyfurniture.nordic, true, false, false)
    includeMod(libs.fantasyfurniture.venthyr, true, false, false)
    includeMod(libs.fantasyfurniture.bone, true, false, false)
    includeMod(libs.fantasyfurniture.dunmer, true, false, false)

    implementation(libs.rei)
    compileOnly(libs.rei.api)
}

fun includeMod(mod: Provider<MinimalExternalModuleDependency>, compile: Boolean = false, at: Boolean = false, injection: Boolean = false) {
    dependencies {
        if(compile)
            compileOnly(mod)
        else
            implementation(mod)

        "dataImplementation"(mod)

        if(at)
            accessTransformers(mod)
        if(injection)
            interfaceInjectionData(mod)
    }
}
