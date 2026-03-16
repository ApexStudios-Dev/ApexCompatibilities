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
        version("neoforge", "26.1.0.0-alpha.0+pre-1.20260310.230015")

        library("registree", "dev.apexstudios", "registree").version("26.1.20-beta-pr-17")
        library("apexcore", "dev.apexstudios", "apexcore").version("26.1.31-beta-pr-70")
        bundle("apexcore", listOf("registree", "apexcore"))

        library("itemresistance", "dev.apexstudios", "itemresistance").version("26.1.20-beta-pr-37")
        library("infusedfoods", "dev.apexstudios", "infusedfoods").version("26.1.21-beta-pr-40")
        library("fantasydice", "dev.apexstudios", "fantasydice").version("26.1.25-beta-pr-38")

        version("fantasyfurniture", "26.1.40-beta-pr-100")
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

        version("jei", "28.6.0.14")
        library("jei-api", "mezz.jei", "jei-26.1-snapshot-6-neoforge-api").versionRef("jei")
        library("jei", "mezz.jei", "jei-26.1-snapshot-6-neoforge").versionRef("jei")

        library("jade", "maven.modrinth", "jade").version("21.1.3+neoforge")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "ApexCompatibilities"
