pluginManagement {
    repositories {
        maven("https://maven.apexstudios.dev/proxy")
        gradlePluginPortal()
    }

    resolutionStrategy {
        eachPlugin {
            if(requested.id.namespace == "apex-conventions") {
                useVersion("0.1.91")
            }
        }
    }
}

dependencyResolutionManagement {
    versionCatalogs.create("libs") {
        version("neoforge", "26.1.0-alpha.26.1-snapshot-3.20260119.022558")

        library("registree", "dev.apexstudios", "registree").version("26.1.12-beta-pr-17")
        library("apexcore", "dev.apexstudios", "apexcore").version("26.1.18-beta-pr-70")
        bundle("apexcore", listOf("registree", "apexcore"))

        library("itemresistance", "dev.apexstudios", "itemresistance").version("26.1.12-beta-pr-37")
        library("infusedfoods", "dev.apexstudios", "infusedfoods").version("26.1.12-beta-pr-40")
        library("fantasydice", "dev.apexstudios", "fantasydice").version("26.1.11-beta-pr-38")

        version("fantasyfurniture", "26.1.28-beta-pr-100")
        library("fantasyfurniture", "dev.apexstudios", "fantasyfurniture").versionRef("fantasyfurniture")
        library("fantasyfurniture_nordic", "dev.apexstudios", "fantasyfurniture_nordic").versionRef("fantasyfurniture")
        library("fantasyfurniture_venthyr", "dev.apexstudios", "fantasyfurniture_venthyr").versionRef("fantasyfurniture")
        library("fantasyfurniture_bone", "dev.apexstudios", "fantasyfurniture_bone").versionRef("fantasyfurniture")
        library("fantasyfurniture_dunmer", "dev.apexstudios", "fantasyfurniture_dunmer").versionRef("fantasyfurniture")
        library("fantasyfurniture_necrolord", "dev.apexstudios", "fantasyfurniture_necrolord").versionRef("fantasyfurniture")
        library("fantasyfurniture_royal", "dev.apexstudios", "fantasyfurniture_royal").versionRef("fantasyfurniture")
        library("fantasyfurniture_decorations", "dev.apexstudios", "fantasyfurniture_decorations").versionRef("fantasyfurniture")

        version("rei", "20.0.811")
        library("rei", "me.shedaniel", "RoughlyEnoughItems-neoforge").versionRef("rei")
        library("rei-api", "me.shedaniel", "RoughlyEnoughItems-api-neoforge").versionRef("rei")
        library("rei-default-plugins", "me.shedaniel", "RoughlyEnoughItems-default-plugin-neoforge").versionRef("rei")
        bundle("rei", listOf("rei-api", "rei-default-plugins"))

        version("jei", "28.3.0.11")
        library("jei-api", "mezz.jei", "jei-26.1-snapshot-2-neoforge-api").versionRef("jei")
        library("jei", "mezz.jei", "jei-26.1-snapshot-2-neoforge").versionRef("jei")

        library("jade", "maven.modrinth", "jade").version("21.0.1+neoforge")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "ApexCompatibilities"
