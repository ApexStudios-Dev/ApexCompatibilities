pluginManagement {
    if(file("../ApexGradle/build.gradle.kts").exists()) {
        includeBuild("../ApexGradle")
    }

    repositories {
        gradlePluginPortal()
        mavenLocal()

        maven("https://maven.apexstudios.dev/releases")

        val GITHUB_ACTOR = providers.gradleProperty("gpr.user").orElse(providers.environmentVariable("GITHUB_ACTOR"))
        val GITHUB_TOKEN = providers.gradleProperty("gpr.token").orElse(providers.environmentVariable("GITHUB_TOKEN"))

        if(GITHUB_ACTOR.isPresent && GITHUB_TOKEN.isPresent) {
            maven("https://maven.pkg.github.com/ApexStudios-Dev/ApexGradle") {
                credentials {
                    username = GITHUB_ACTOR.get()
                    password = GITHUB_TOKEN.get()
                }
            }
        }
    }

    resolutionStrategy {
        eachPlugin {
            if(requested.id.namespace == "apex-conventions") {
                useVersion("0.1-SNAPSHOT")
            }
        }
    }
}

dependencyResolutionManagement {
    versionCatalogs.create("libs") {
        version("apexstudios") {
            strictly("[21.4.0,21.5.0)")
        }

        library("apexcore", "dev.apexstudios", "apexcore").versionRef("apexstudios")
        library("itemresistance", "dev.apexstudios", "itemresistance").versionRef("apexstudios")
        library("infusedfoods", "dev.apexstudios", "infusedfoods").versionRef("apexstudios")
        library("fantasydice", "dev.apexstudios", "fantasydice").versionRef("apexstudios")
        library("fantasyfurniture", "dev.apexstudios", "fantasyfurniture").versionRef("apexstudios")

        version("rei") {
            strictly("[18.0,19.0)")
        }

        library("rei", "me.shedaniel", "RoughlyEnoughItems-neoforge").versionRef("rei")
        library("rei-api", "me.shedaniel", "RoughlyEnoughItems-api-neoforge").versionRef("rei")
        library("rei-default-plugin", "me.shedaniel", "RoughlyEnoughItems-default-plugin-neoforge").versionRef("rei")
        bundle("rei-api", listOf("rei-api", "rei-default-plugin"))
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
}

rootProject.name = "ApexCompatibilities"
