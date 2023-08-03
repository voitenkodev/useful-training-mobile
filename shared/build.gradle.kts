plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.parcelize")
}

apply(from = "../config/gradle/build-scripts/android.gradle")
apply(from = "../config/gradle/build-scripts/ios.gradle")
apply(from = "../config/gradle/build-scripts/kotlin.gradle")

version = "1.0"

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {

                implementation(projects.data)
                implementation(projects.utils.instruments)
                implementation(projects.utils.navigator)
                implementation(projects.utils.designSystem)
                implementation(projects.utils.composePlayer)
                implementation(projects.utils.resources)


                // Compose
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)

                // Utils
                implementation(libs.uuid)
                implementation(libs.parcelize)
                implementation(libs.serialization)
                implementation(libs.datetime)
                implementation(libs.datastore)

                // Koin
                implementation(libs.koin.core)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.activity.compose)
            }
        }
        val iosMain by getting {
            dependencies {}
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
    }
}