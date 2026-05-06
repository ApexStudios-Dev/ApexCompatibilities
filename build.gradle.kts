plugins {
    id("apex-conventions.neoforge")
    id("apex-conventions.neoforge-datagen")
    id("apex-conventions.maven-publishing")
    id("apex-conventions.jspecify")
}

group = "dev.apexstudios"
neoForge.version = libs.versions.neoforge.get()

dependencies {
    implementation(libs.bundles.apexcore)
    "dataImplementation"(libs.bundles.apexcore)
    accessTransformers(libs.apexcore)

    implementation(libs.bundles.apexcore)
    "dataImplementation"(libs.bundles.apexcore)
    accessTransformers(libs.apexcore)

    compileOnly(libs.itemresistance)
    implementation(libs.infusedfoods)
    implementation(libs.fantasydice)

    implementation(libs.fantasyfurniture)
    implementation(libs.fantasyfurniture.nordic)
    implementation(libs.fantasyfurniture.venthyr)
    implementation(libs.fantasyfurniture.bone)
    implementation(libs.fantasyfurniture.dunmer)
    implementation(libs.fantasyfurniture.necrolord)
    implementation(libs.fantasyfurniture.royal)
    implementation(libs.fantasyfurniture.decorations)

    compileOnly(libs.bundles.rei)
    compileOnly(libs.jei.api)
    compileOnly(libs.jade)

    // runtimeOnly(libs.rei)
    runtimeOnly(libs.jei)
    runtimeOnly(libs.jade)
}