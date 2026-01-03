pluginManagement {
    repositories {
        maven("https://maven.apexstudios.dev/proxy")
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    versionCatalogs.create("libs") {
        library("registree", "dev.apexstudios", "registree").version("26.1.1-beta-pr-17") // match version ApexCore is compiled against
        library("apexcore", "dev.apexstudios", "apexcore").version("26.1.1-beta-pr-70")
        library("itemresistance", "dev.apexstudios", "itemresistance").version("26.1.3-beta-pr-37")
        library("infusedfoods", "dev.apexstudios", "infusedfoods").version("26.1.3-beta-pr-40")
        library("fantasydice", "dev.apexstudios", "fantasydice").version("26.1.2-beta-pr-38")

        version("fantasyfurniture", "26.1.1-beta-pr-100")
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

        version("jei", "27.3.0.10")
        library("jei-api", "mezz.jei", "jei-1.21.11-neoforge-api").versionRef("jei")
        library("jei", "mezz.jei", "jei-1.21.11-neoforge").versionRef("jei")

        library("jade", "maven.modrinth", "jade").version("21.0.1+neoforge")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "ApexCompatibilities"
