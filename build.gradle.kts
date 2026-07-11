plugins {
    id("apex-conventions.neoforge")
    id("apex-conventions.neoforge-datagen")
    id("apex-conventions.maven-publishing")
    id("apex-conventions.jspecify")
}

group = "dev.apexstudios"
neoForge.version = libs.versions.neoforge.get()

repositories {
    /*maven("https://prmaven.neoforged.net/NeoForge/pr3198") {
        content {
            includeModule("net.neoforged", "neoforge")
            includeModule("net.neoforged", "testframework")
        }
    }*/

    maven("https://maven.apexmodder.com/prs/Registree/pr33") {
        content {
            includeModule("dev.apexstudios", "registree")
        }
    }

    maven("https://maven.apexmodder.com/prs/ApexCore/pr92") {
        content {
            includeModule("dev.apexstudios", "apexcore")
        }
    }

    maven("https://maven.apexmodder.com/prs/ItemResistance/pr52") {
        content {
            includeModule("dev.apexstudios", "itemresistance")
        }
    }

    maven("https://maven.apexmodder.com/prs/InfusedFoods/pr55") {
        content {
            includeModule("dev.apexstudios", "infusedfoods")
        }
    }

    maven("https://maven.apexmodder.com/prs/FantasyDice/pr53") {
        content {
            includeModule("dev.apexstudios", "fantasydice")
        }
    }

    maven("https://maven.apexmodder.com/prs/FantasyFurniture/pr125") {
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
    compileOnly(libs.rrv)

    // runtimeOnly(libs.rei)
    runtimeOnly(libs.jei)
    runtimeOnly(libs.jade)
    // runtimeOnly(libs.rrv)
}