import org.slf4j.event.Level

plugins {
    `java-library`
    `maven-publish`

    id("net.neoforged.moddev") version "2.0.141"
    id("apex-conventions.jspecify")
}

group = "dev.apexstudios"
base.archivesName = "apexcompatibilities"
version = providers.environmentVariable("VERSION").getOrElse("0.0NONE")

sourceSets {
    main {
        resources {
            exclude(".cache")
            srcDir("src/data/generated")
        }
    }

    create("data") {
        resources.setSrcDirs(files())

        compileClasspath += sourceSets[SourceSet.MAIN_SOURCE_SET_NAME].output
        runtimeClasspath += sourceSets[SourceSet.MAIN_SOURCE_SET_NAME].output
    }
}

neoForge {
    version = libs.versions.neoforge.get()
    addModdingDependenciesTo(sourceSets["data"])

    mods.create("data") {
        sourceSet(sourceSets[SourceSet.MAIN_SOURCE_SET_NAME])
        sourceSet(sourceSets["data"])
    }

    runs {
        listOf(true, false).forEach { isClient ->
            val id = if(isClient) "client" else "server"

            create(id) {
                if(isClient) {
                    client()
                } else {
                    server()
                }

                logLevel.set(Level.DEBUG)
                gameDirectory.set(layout.projectDirectory.dir("run/$id"))
                systemProperty("terminal.ansi", "true") // fix terminal not having colors

                jvmArguments.addAll(
                    "-XX:+AllowEnhancedClassRedefinition",
                    "-XX:+IgnoreUnrecognizedVMOptions",
                    "-XX:+AllowRedefinitionToAddDeleteMethods",
                    "-XX:+ClassUnloading"
                )
            }
        }

        create("data") {
            clientData()

            sourceSet.set(sourceSets["data"])
            loadedMods.set(listOf(mods["data"]))

            programArguments.addAll(
                "--mod", "apexcompatibilities",
                "--all",
                "--output", file("src/data/generated").absolutePath,
                "--existing", file("src/${SourceSet.MAIN_SOURCE_SET_NAME}/resources").absolutePath
            )
        }
    }
}

repositories {
    maven("https://maven.apexmodder.com/releases")
    maven("https://maven.shedaniel.me")
    maven("https://maven.blamejared.com")

    exclusiveContent {
        forRepository {
            maven("https://api.modrinth.com/maven")
        }

        filter {
            includeGroup("maven.modrinth")
        }
    }
}

dependencies {
    implementation(libs.bundles.apexcore) { isTransitive = false }
    "dataImplementation"(libs.bundles.apexcore) { isTransitive = false }
    accessTransformers(libs.apexcore) { isTransitive = false }

    compileOnly(libs.itemresistance) { isTransitive = false }
    implementation(libs.infusedfoods) { isTransitive = false }
    implementation(libs.fantasydice) { isTransitive = false }

    implementation(libs.fantasyfurniture) { isTransitive = false }
    implementation(libs.fantasyfurniture.nordic) { isTransitive = false }
    compileOnly(libs.fantasyfurniture.venthyr) { isTransitive = false }
    compileOnly(libs.fantasyfurniture.bone) { isTransitive = false }
    compileOnly(libs.fantasyfurniture.dunmer) { isTransitive = false }
    compileOnly(libs.fantasyfurniture.necrolord) { isTransitive = false }
    compileOnly(libs.fantasyfurniture.royal) { isTransitive = false }
    implementation(libs.fantasyfurniture.decorations) { isTransitive = false }

    compileOnly(libs.bundles.rei)
    compileOnly(libs.jei.api)
    compileOnly(libs.jade)

    // runtimeOnly(libs.rei)
    runtimeOnly(libs.jei)
    runtimeOnly(libs.jade)
}

java {
    toolchain.vendor.set(JvmVendorSpec.JETBRAINS)
    withSourcesJar()
}

publishing {
    publications.create("release", MavenPublication::class.java) {
        afterEvaluate {
            groupId = "dev.apexstudios"
            artifactId = "apexcompatibilities"
            version = project.version as String
        }

        from(components["java"])
    }

    repositories {
        if(System.getenv("MAVEN_USERNAME") != null && System.getenv("MAVEN_PASSWORD") != null) {
            maven("https://maven.apexmodder.com/releases") {
                name = "ApexStudios-Releases"

                credentials {
                    username = System.getenv("MAVEN_USERNAME")
                    password = System.getenv("MAVEN_PASSWORD")
                }

                authentication.create<BasicAuthentication>("basic")
            }
        }
    }
}