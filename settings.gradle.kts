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
                    useVersion("0.1.102")
                }
            }
        }
    }
}

dependencyResolutionManagement {
    versionCatalogs.create("libs") {
        version("neoforge", "26.3.0.7-beta")

        library("registree", "dev.apexstudios", "registree").version("26.3.0")
        library("apexcore", "dev.apexstudios", "apexcore").version("26.3.0")
        bundle("apexcore", listOf("registree", "apexcore"))

        library("itemresistance", "dev.apexstudios", "itemresistance").version("26.3.0")
        library("infusedfoods", "dev.apexstudios", "infusedfoods").version("26.3.0")
        library("fantasydice", "dev.apexstudios", "fantasydice").version("26.3.0")

        version("fantasyfurniture", "26.3.0")
        library("fantasyfurniture", "dev.apexstudios", "fantasyfurniture").versionRef("fantasyfurniture")
        library("fantasyfurniture_nordic", "dev.apexstudios", "fantasyfurniture_nordic").versionRef("fantasyfurniture")
        library("fantasyfurniture_venthyr", "dev.apexstudios", "fantasyfurniture_venthyr").versionRef("fantasyfurniture")
        library("fantasyfurniture_bone", "dev.apexstudios", "fantasyfurniture_bone").versionRef("fantasyfurniture")
        library("fantasyfurniture_dunmer", "dev.apexstudios", "fantasyfurniture_dunmer").versionRef("fantasyfurniture")
        library("fantasyfurniture_necrolord", "dev.apexstudios", "fantasyfurniture_necrolord").versionRef("fantasyfurniture")
        library("fantasyfurniture_royal", "dev.apexstudios", "fantasyfurniture_royal").versionRef("fantasyfurniture")
        library("fantasyfurniture_decorations", "dev.apexstudios", "fantasyfurniture_decorations").versionRef("fantasyfurniture")

        version("rei", "26.2.820")
        library("rei", "me.shedaniel", "RoughlyEnoughItems-neoforge").versionRef("rei")
        library("rei-api", "me.shedaniel", "RoughlyEnoughItems-api-neoforge").versionRef("rei")
        library("rei-default-plugins", "me.shedaniel", "RoughlyEnoughItems-default-plugin-neoforge").versionRef("rei")
        bundle("rei", listOf("rei-api", "rei-default-plugins"))

        version("jei", "31.0.0.5")
        library("jei-api", "mezz.jei", "jei-26.3-neoforge-api").versionRef("jei")
        library("jei", "mezz.jei", "jei-26.3-neoforge").versionRef("jei")

        library("rrv", "cc.cassian.rrv", "reliable-recipe-viewer-neoforge").version("8.10.5+26.3")

        library("jade", "maven.modrinth", "jade").version("26.3.1+neoforge")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "ApexCompatibilities"
