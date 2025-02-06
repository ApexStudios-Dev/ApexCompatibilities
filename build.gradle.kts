import dev.apexstudios.gradle.single.ApexSingleExtension
import me.modmuss50.mpp.ReleaseType

plugins {
    id("apex-conventions.neoforge")
    id("apex-conventions.immaculate")
    id("apex-conventions.maven-publishing")
    id("apex-conventions.mod-publishing")
}

group = "dev.apexstudios"

apex.neoVersion("21.4.50-beta", "2025.01.05")
apex.extendCompilerErrors()

val single = ApexSingleExtension.getOrCreate(project)
single.withDataGen()

repositories {
    maven("https://maven.shedaniel.me")
    maven("https://maven.architectury.dev")
}

dependencies {
    includeMod(libs.apexcore, false, true, true)
    includeMod(libs.itemresistance, true, false, false)
    includeMod(libs.infusedfoods, true, false, false)
    includeMod(libs.fantasydice, true, false, false)

    includeMod(libs.fantasyfurniture, true, true, false) {
        requireCapability("dev.apexstudios:nordic")
    }

    implementation(libs.rei)
    compileOnly(libs.rei.api)
}

publishMods {
    type = ReleaseType.ALPHA

//    modrinth {
//        projectId = "xl3myxch"
//    }

    curseforge {
        projectId = "1194521"
        projectSlug = "apexcompatibilities"
    }
}

fun includeMod(mod: Provider<MinimalExternalModuleDependency>, comple: Boolean = false, at: Boolean = false, injection: Boolean = false, caps: Action<ModuleDependencyCapabilitiesHandler> = Action { }) {
    dependencies {
        if(comple) {
            compileOnly(mod)
            compileOnly(mod) {
                capabilities {
                    caps.execute(this)
                }
            }
        } else {
            implementation(mod)
            implementation(mod) {
                capabilities {
                    caps.execute(this)
                }
            }
        }

        "dataImplementation"(mod) {
            capabilities {
                caps.execute(this)
            }
        }

        if(at)
            accessTransformers(mod)
        if(injection)
            interfaceInjectionData(mod)
    }
}
