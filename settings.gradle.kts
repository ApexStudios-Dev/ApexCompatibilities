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
        version("neoforge", "26.1.0.18-beta")

        library("registree", "dev.apexstudios", "registree").version("26.1.0")
        library("apexcore", "dev.apexstudios", "apexcore").version("26.1.1")
        bundle("apexcore", listOf("registree", "apexcore"))

        library("itemresistance", "dev.apexstudios", "itemresistance").version("26.1.2")
        library("infusedfoods", "dev.apexstudios", "infusedfoods").version("26.1.2")
        library("fantasydice", "dev.apexstudios", "fantasydice").version("26.1.2")

        version("fantasyfurniture", "26.1.4")
        library("fantasyfurniture", "dev.apexstudios", "fantasyfurniture").versionRef("fantasyfurniture")
        library("fantasyfurniture_nordic", "dev.apexstudios", "nordic").versionRef("fantasyfurniture")
        library("fantasyfurniture_venthyr", "dev.apexstudios", "venthyr").versionRef("fantasyfurniture")
        library("fantasyfurniture_bone", "dev.apexstudios", "bone").versionRef("fantasyfurniture")
        library("fantasyfurniture_dunmer", "dev.apexstudios", "dunmer").versionRef("fantasyfurniture")
        library("fantasyfurniture_necrolord", "dev.apexstudios", "necrolord").versionRef("fantasyfurniture")
        library("fantasyfurniture_royal", "dev.apexstudios", "royal").versionRef("fantasyfurniture")
        library("fantasyfurniture_decorations", "dev.apexstudios", "decorations").versionRef("fantasyfurniture")

        version("rei", "21.9.813")
        library("rei", "me.shedaniel", "RoughlyEnoughItems-neoforge").versionRef("rei")
        library("rei-api", "me.shedaniel", "RoughlyEnoughItems-api-neoforge").versionRef("rei")
        library("rei-default-plugins", "me.shedaniel", "RoughlyEnoughItems-default-plugin-neoforge").versionRef("rei")
        bundle("rei", listOf("rei-api", "rei-default-plugins"))

        version("jei", "29.2.0.20")
        library("jei-api", "mezz.jei", "jei-26.1-neoforge-api").versionRef("jei")
        library("jei", "mezz.jei", "jei-26.1-neoforge").versionRef("jei")

        library("jade", "maven.modrinth", "jade").version("26.0.6+neoforge")
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
            substitute(module("dev.apexstudios:nordic")).using(project(":nordic"))
            substitute(module("dev.apexstudios:venthyr")).using(project(":venthyr"))
            substitute(module("dev.apexstudios:bone")).using(project(":bone"))
            substitute(module("dev.apexstudios:dunmer")).using(project(":dunmer"))
            substitute(module("dev.apexstudios:necrolord")).using(project(":necrolord"))
            substitute(module("dev.apexstudios:royal")).using(project(":royal"))
            substitute(module("dev.apexstudios:decorations")).using(project(":decorations"))
        }
    }
}

rootProject.name = "ApexCompatibilities"
