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
        version("neoforge", "26.2.0-alpha.0+pre-2.20260602.164726")

        library("registree", "dev.apexstudios", "registree").version("26.2.1-beta-pr-29")
        library("apexcore", "dev.apexstudios", "apexcore").version("26.2.1-beta-pr-88")
        bundle("apexcore", listOf("registree", "apexcore"))

        library("itemresistance", "dev.apexstudios", "itemresistance").version("26.2.0-beta-pr-48")
        library("infusedfoods", "dev.apexstudios", "infusedfoods").version("26.2.0-beta-pr-51")
        library("fantasydice", "dev.apexstudios", "fantasydice").version("26.2.0-beta-pr-49")

        version("fantasyfurniture", "26.2.2-beta-pr-120")
        library("fantasyfurniture", "dev.apexstudios", "fantasyfurniture").versionRef("fantasyfurniture")
        library("fantasyfurniture_nordic", "dev.apexstudios", "fantasyfurniture_nordic").versionRef("fantasyfurniture")
        library("fantasyfurniture_venthyr", "dev.apexstudios", "fantasyfurniture_venthyr").versionRef("fantasyfurniture")
        library("fantasyfurniture_bone", "dev.apexstudios", "fantasyfurniture_bone").versionRef("fantasyfurniture")
        library("fantasyfurniture_dunmer", "dev.apexstudios", "fantasyfurniture_dunmer").versionRef("fantasyfurniture")
        library("fantasyfurniture_necrolord", "dev.apexstudios", "fantasyfurniture_necrolord").versionRef("fantasyfurniture")
        library("fantasyfurniture_royal", "dev.apexstudios", "fantasyfurniture_royal").versionRef("fantasyfurniture")
        library("fantasyfurniture_decorations", "dev.apexstudios", "fantasyfurniture_decorations").versionRef("fantasyfurniture")

        version("rei", "21.9.813")
        library("rei", "me.shedaniel", "RoughlyEnoughItems-neoforge").versionRef("rei")
        library("rei-api", "me.shedaniel", "RoughlyEnoughItems-api-neoforge").versionRef("rei")
        library("rei-default-plugins", "me.shedaniel", "RoughlyEnoughItems-default-plugin-neoforge").versionRef("rei")
        bundle("rei", listOf("rei-api", "rei-default-plugins"))

        version("jei", "29.5.0.28")
        library("jei-api", "mezz.jei", "jei-26.1.2-neoforge-api").versionRef("jei")
        library("jei", "mezz.jei", "jei-26.1.2-neoforge").versionRef("jei")

        library("jade", "maven.modrinth", "jade").version("26.0.6+neoforge")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "ApexCompatibilities"
