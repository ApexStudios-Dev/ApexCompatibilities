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
        library("apexcore", "dev.apexstudios", "apexcore").version("21.5.41-beta-pr-40")
        library("itemresistance", "dev.apexstudios", "itemresistance").version("21.5.13-beta-pr-18")
        library("infusedfoods", "dev.apexstudios", "infusedfoods").version("21.5.19-beta-pr-22")
        library("fantasydice", "dev.apexstudios", "fantasydice").version("21.5.13-beta-pr-17")

        library("fantasyfurniture", "dev.apexstudios", "fantasyfurniture").version("21.5.62-beta-pr-55")
        library("fantasyfurniture_nordic", "dev.apexstudios", "fantasyfurniture-nordic").version("21.5.62-beta-pr-55")
        library("fantasyfurniture_venthyr", "dev.apexstudios", "fantasyfurniture-venthyr").version("21.5.62-beta-pr-55")
        library("fantasyfurniture_bone", "dev.apexstudios", "fantasyfurniture-bone").version("21.5.62-beta-pr-55")
        library("fantasyfurniture_dunmer", "dev.apexstudios", "fantasyfurniture-dunmer").version("21.5.62-beta-pr-55")
        library("fantasyfurniture_necrolord", "dev.apexstudios", "fantasyfurniture-necrolord").version("21.5.62-beta-pr-55")
        library("fantasyfurniture_royal", "dev.apexstudios", "fantasyfurniture-royal").version("21.5.62-beta-pr-55")

        version("rei", "19.0.806")
        library("rei", "me.shedaniel", "RoughlyEnoughItems-neoforge").versionRef("rei")
        library("rei-api", "me.shedaniel", "RoughlyEnoughItems-api-neoforge").versionRef("rei")
        library("rei-default-plugins", "me.shedaniel", "RoughlyEnoughItems-default-plugin-neoforge").versionRef("rei")
        bundle("rei", listOf("rei-api", "rei-default-plugins"))

        version("jei", "21.3.2.22")
        library("jei-api", "mezz.jei", "jei-1.21.5-neoforge-api").versionRef("jei")
        library("jei", "mezz.jei", "jei-1.21.5-neoforge").versionRef("jei")

        library("jade", "maven.modrinth", "jade").version("18.2.0+neoforge")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "ApexCompatibilities"
