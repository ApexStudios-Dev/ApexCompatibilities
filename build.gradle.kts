plugins {
    id("apex-conventions.neoforge")
    id("apex-conventions.neoforge-datagen")
    id("apex-conventions.maven-publishing")
    id("apex-conventions.jspecify")
}

group = "dev.apexstudios"
neoForge.version = libs.versions.neoforge.get()

repositories {
    repositories {
        maven("https://maven.apexmodder.com/prs/ApexCore/pr82") {
            content {
                includeModule("dev.apexstudios", "apexcore")
            }
        }
    }

    repositories {
        maven("https://maven.apexmodder.com/prs/FantasyFurniture/pr112") {
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
}

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
    compileOnly(libs.fantasyfurniture.venthyr)
    compileOnly(libs.fantasyfurniture.bone)
    compileOnly(libs.fantasyfurniture.dunmer)
    compileOnly(libs.fantasyfurniture.necrolord)
    compileOnly(libs.fantasyfurniture.royal)
    implementation(libs.fantasyfurniture.decorations)

    compileOnly(libs.bundles.rei)
    compileOnly(libs.jei.api)
    compileOnly(libs.jade)

    // runtimeOnly(libs.rei)
    runtimeOnly(libs.jei)
    runtimeOnly(libs.jade)
}