pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.apexmodder.com/releases")
    }

    if(file("../../ApexGradle").exists()) {
        includeBuild("../../ApexGradle")
    } else {
        resolutionStrategy {
            eachPlugin {
                if(requested.id.namespace == "apex-conventions") {
                    useVersion("0.1.94")
                }
            }
        }
    }
}

dependencyResolutionManagement {
    versionCatalogs.create("libs") {
        version("neoforge", "26.1.2.42-beta")

        library("registree", "dev.apexstudios", "registree").version("26.1.0")
        library("apexcore", "dev.apexstudios", "apexcore").version("26.1.2")
        bundle("apexcore", listOf("registree", "apexcore"))

        library("itemresistance", "dev.apexstudios", "itemresistance").version("26.1.2")
        library("infusedfoods", "dev.apexstudios", "infusedfoods").version("26.1.2")
        library("fantasydice", "dev.apexstudios", "fantasydice").version("26.1.4")

        version("fantasyfurniture", "26.1.7")
        library("fantasyfurniture", "dev.apexstudios", "fantasyfurniture").versionRef("fantasyfurniture")
        library("fantasyfurniture_nordic", "dev.apexstudios", "fantasyfurniture_nordic").versionRef("fantasyfurniture")
        library("fantasyfurniture_venthyr", "dev.apexstudios", "fantasyfurniture_venthyr").versionRef("fantasyfurniture")
        library("fantasyfurniture_bone", "dev.apexstudios", "fantasyfurniture_bone").versionRef("fantasyfurniture")
        library("fantasyfurniture_dunmer", "dev.apexstudios", "fantasyfurniture_dunmer").versionRef("fantasyfurniture")
        library("fantasyfurniture_necrolord", "dev.apexstudios", "fantasyfurniture_necrolord").versionRef("fantasyfurniture")
        library("fantasyfurniture_royal", "dev.apexstudios", "fantasyfurniture_royal").versionRef("fantasyfurniture")
        library("fantasyfurniture_decorations", "dev.apexstudios", "fantasyfurniture_decorations").versionRef("fantasyfurniture")

        version("rei", "26.1.819")
        library("rei", "me.shedaniel", "RoughlyEnoughItems-neoforge").versionRef("rei")
        library("rei-api", "me.shedaniel", "RoughlyEnoughItems-api-neoforge").versionRef("rei")
        library("rei-default-plugins", "me.shedaniel", "RoughlyEnoughItems-default-plugin-neoforge").versionRef("rei")
        bundle("rei", listOf("rei-api", "rei-default-plugins"))

        version("jei", "29.6.2.31")
        library("jei-api", "mezz.jei", "jei-26.1.2-neoforge-api").versionRef("jei")
        library("jei", "mezz.jei", "jei-26.1.2-neoforge").versionRef("jei")

        library("jade", "maven.modrinth", "jade").version("26.1.3+neoforge")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

listOf(
    "Registree",
    "ApexCore",
    "ItemResistance",
    "InfusedFoods",
    "FantasyDice"
).forEach { lib ->
    if(file("../../${lib}/26.1").exists()) {
        includeBuild("../../${lib}/26.1") {
            name = lib

            dependencySubstitution {
                substitute(module("dev.apexstudios:${lib.lowercase()}")).using(project(":"))
            }
        }
    }
}

if(file("../../FantasyFurniture/26.1").exists()) {
    includeBuild("../../FantasyFurniture/26.1") {
        name = "FantasyFurniture"

        dependencySubstitution {
            substitute(module("dev.apexstudios:fantasyfurniture")).using(project(":"))
            substitute(module("dev.apexstudios:fantasyfurniture_nordic")).using(project(":fantasyfurniture_nordic"))
            substitute(module("dev.apexstudios:fantasyfurniture_venthyr")).using(project(":fantasyfurniture_venthyr"))
            substitute(module("dev.apexstudios:fantasyfurniture_bone")).using(project(":fantasyfurniture_bone"))
            substitute(module("dev.apexstudios:fantasyfurniture_dunmer")).using(project(":fantasyfurniture_dunmer"))
            substitute(module("dev.apexstudios:fantasyfurniture_necrolord")).using(project(":fantasyfurniture_necrolord"))
            substitute(module("dev.apexstudios:fantasyfurniture_royal")).using(project(":fantasyfurniture_royal"))
            substitute(module("dev.apexstudios:fantasyfurniture_decorations")).using(project(":fantasyfurniture_decorations"))
        }
    }
}

rootProject.name = "ApexCompatibilities"
