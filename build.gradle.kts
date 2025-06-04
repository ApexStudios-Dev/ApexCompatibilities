import dev.apexstudios.gradle.single.ApexSingleExtension

plugins {
    id("apex-conventions.neoforge")
    id("apex-conventions.immaculate")
    id("apex-conventions.maven-publishing")
}

group = "dev.apexstudios"

apex.neoVersion("21.5.0-alpha.1.21.6-pre3.20250604.191549", "2025.06.01")
apex.extendCompilerErrors()

val single = ApexSingleExtension.getOrCreate(project)
single.withDataGen()

repositories {
    maven("https://maven.shedaniel.me")
    maven("https://maven.architectury.dev")
    maven("https://maven.blamejared.com")
    maven("https://modmaven.dev")
    maven("https://maven.apexstudios.dev/private")

    maven("https://api.modrinth.com/maven") {
        content {
            includeGroup("maven.modrinth")
        }
    }

    apex.neoPrMaven(this, 2297)
}

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
