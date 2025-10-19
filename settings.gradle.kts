pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.apexstudios.dev/releases")
        maven("https://maven.apexstudios.dev/private")
    }
}

dependencyResolutionManagement {
    versionCatalogs.create("libs") {
        library("registree", "dev.apexstudios", "registree").version("21.10.2-beta-pr-1") // match version ApexCore is compiled against
        library("apexcore", "dev.apexstudios", "apexcore").version("21.10.2-beta-pr-54")
        library("itemresistance", "dev.apexstudios", "itemresistance").version("21.10.3-beta-pr-30")
        library("infusedfoods", "dev.apexstudios", "infusedfoods").version("21.10.3-beta-pr-33")
        library("fantasydice", "dev.apexstudios", "fantasydice").version("21.10.3-beta-pr-31")

        library("fantasyfurniture", "dev.apexstudios", "fantasyfurniture").version("21.10.3-beta-pr-84")
        library("fantasyfurniture_nordic", "dev.apexstudios", "fantasyfurniture-nordic").version("21.10.3-beta-pr-84")
        library("fantasyfurniture_venthyr", "dev.apexstudios", "fantasyfurniture-venthyr").version("21.10.3-beta-pr-84")
        library("fantasyfurniture_bone", "dev.apexstudios", "fantasyfurniture-bone").version("21.10.3-beta-pr-84")
        library("fantasyfurniture_dunmer", "dev.apexstudios", "fantasyfurniture-dunmer").version("21.10.3-beta-pr-84")
        library("fantasyfurniture_necrolord", "dev.apexstudios", "fantasyfurniture-necrolord").version("21.10.3-beta-pr-84")
        library("fantasyfurniture_royal", "dev.apexstudios", "fantasyfurniture-royal").version("21.10.3-beta-pr-84")

        version("rei", "20.0.811")
        library("rei", "me.shedaniel", "RoughlyEnoughItems-neoforge").versionRef("rei")
        library("rei-api", "me.shedaniel", "RoughlyEnoughItems-api-neoforge").versionRef("rei")
        library("rei-default-plugins", "me.shedaniel", "RoughlyEnoughItems-default-plugin-neoforge").versionRef("rei")
        bundle("rei", listOf("rei-api", "rei-default-plugins"))

        version("jei", "26.0.0.1")
        library("jei-api", "mezz.jei", "jei-1.21.10-neoforge-api").versionRef("jei")
        library("jei", "mezz.jei", "jei-1.21.10-neoforge").versionRef("jei")

        library("jade", "maven.modrinth", "jade").version("20.0.5+neoforge")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "ApexCompatibilities"
