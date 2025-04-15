pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenLocal()

        maven("https://maven.apexstudios.dev/releases")
    }

    resolutionStrategy {
        eachPlugin {
            if(requested.id.namespace == "apex-conventions") {
                useVersion("0.1.58")
            }
        }
    }
}

dependencyResolutionManagement {
    versionCatalogs.create("libs") {
        library("apexcore", "dev.apexstudios", "apexcore").version("21.5.3")
        library("itemresistance", "dev.apexstudios", "itemresistance").version("21.5.1")
        library("infusedfoods", "dev.apexstudios", "infusedfoods").version("21.5.1")
        library("fantasydice", "dev.apexstudios", "fantasydice").version("21.5.1")

        library("fantasyfurniture", "dev.apexstudios", "fantasyfurniture").version("21.5.1")
        library("fantasyfurniture_nordic", "dev.apexstudios", "fantasyfurniture-nordic").version("21.5.1")
        library("fantasyfurniture_venthyr", "dev.apexstudios", "fantasyfurniture-venthyr").version("21.5.1")
        library("fantasyfurniture_bone", "dev.apexstudios", "fantasyfurniture-bone").version("21.5.1")
        library("fantasyfurniture_dunmer", "dev.apexstudios", "fantasyfurniture-dunmer").version("21.5.1")
        library("fantasyfurniture_necrolord", "dev.apexstudios", "fantasyfurniture-necrolord").version("21.5.1")
        library("fantasyfurniture_royal", "dev.apexstudios", "fantasyfurniture-royal").version("21.5.1")

        version("rei", "19.0.805")
        library("rei", "me.shedaniel", "RoughlyEnoughItems-neoforge").versionRef("rei")
        library("rei-api", "me.shedaniel", "RoughlyEnoughItems-api-neoforge").versionRef("rei")
        library("rei-default-plugin", "me.shedaniel", "RoughlyEnoughItems-default-plugin-neoforge").versionRef("rei")
        bundle("rei-api", listOf("rei-api", "rei-default-plugin"))
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.10.0"
}

rootProject.name = "ApexCompatibilities"
