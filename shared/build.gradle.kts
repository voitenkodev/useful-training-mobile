plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("dev.icerock.mobile.multiplatform-resources")
}

apply(from = "../config/gradle/build-scripts/android.gradle")
apply(from = "../config/gradle/build-scripts/ios.gradle")
apply(from = "../config/gradle/build-scripts/kotlin.gradle")

multiplatformResources {
    multiplatformResourcesPackage = "com.voitenko.usefultraining"
    multiplatformResourcesClassName = "SharedRes"
}

version = "1.0"

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {

                api(projects.data)
                api(projects.utils.instruments)
                api(projects.utils.navigator)
                api(projects.utils.designSystem)
                api(projects.utils.composePlayer)

                implementation(libs.moko.resources)

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