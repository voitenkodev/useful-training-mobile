plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.parcelize") // For Parcelize Navigation Graph
}

apply(from = "../config/gradle/build-scripts/android.gradle")
apply(from = "../config/gradle/build-scripts/ios.gradle")
apply(from = "../config/gradle/build-scripts/kotlin.gradle")

kotlin.cocoapods { podfile = project.file("../iosApp/Podfile") }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Features
                implementation(projects.features.authentication)
                implementation(projects.features.trainings)

                // Common
                implementation(projects.dataold)
                implementation(projects.utils.designSystem)
                implementation(projects.utils.architectureComponent)

                // Compose
                implementation(compose.ui)

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