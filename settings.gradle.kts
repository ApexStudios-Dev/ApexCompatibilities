pluginManagement {
    repositories {
        maven("https://maven.apexstudios.dev/proxy")
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    versionCatalogs.create("libs") {
        library("registree", "dev.apexstudios", "registree").version("21.11.0") // match version ApexCore is compiled against
        library("apexcore", "dev.apexstudios", "apexcore").version("21.11.0")
        library("itemresistance", "dev.apexstudios", "itemresistance").version("21.11.0")
        library("infusedfoods", "dev.apexstudios", "infusedfoods").version("21.11.0")
        library("fantasydice", "dev.apexstudios", "fantasydice").version("21.11.0")

        version("fantasyfurniture", "21.11.0")
        library("fantasyfurniture", "dev.apexstudios", "fantasyfurniture").versionRef("fantasyfurniture")
        library("fantasyfurniture_nordic", "dev.apexstudios", "fantasyfurniture-nordic").versionRef("fantasyfurniture")
        library("fantasyfurniture_venthyr", "dev.apexstudios", "fantasyfurniture-venthyr").versionRef("fantasyfurniture")
        library("fantasyfurniture_bone", "dev.apexstudios", "fantasyfurniture-bone").versionRef("fantasyfurniture")
        library("fantasyfurniture_dunmer", "dev.apexstudios", "fantasyfurniture-dunmer").versionRef("fantasyfurniture")
        library("fantasyfurniture_necrolord", "dev.apexstudios", "fantasyfurniture-necrolord").versionRef("fantasyfurniture")
        library("fantasyfurniture_royal", "dev.apexstudios", "fantasyfurniture-royal").versionRef("fantasyfurniture")

        version("rei", "20.0.811")
        library("rei", "me.shedaniel", "RoughlyEnoughItems-neoforge").versionRef("rei")
        library("rei-api", "me.shedaniel", "RoughlyEnoughItems-api-neoforge").versionRef("rei")
        library("rei-default-plugins", "me.shedaniel", "RoughlyEnoughItems-default-plugin-neoforge").versionRef("rei")
        bundle("rei", listOf("rei-api", "rei-default-plugins"))

        version("jei", "26.0.0.1")
        library("jei-api", "mezz.jei", "jei-1.21.10-neoforge-api").versionRef("jei")
        library("jei", "mezz.jei", "jei-1.21.10-neoforge").versionRef("jei")

        library("jade", "maven.modrinth", "jade").version("21.0.1+neoforge")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "ApexCompatibilities"
