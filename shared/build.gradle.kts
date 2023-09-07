plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.parcelize")
}

apply(from = "../config/gradle/build-scripts/android.gradle")
apply(from = "../config/gradle/build-scripts/ios.gradle")
apply(from = "../config/gradle/build-scripts/kotlin.gradle")

kotlin.cocoapods {
    podfile = project.file("../iosApp/Podfile")
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.features.authentication)

                implementation(projects.data)
                implementation(projects.utils.instruments)
                implementation(projects.utils.navigator)
                implementation(projects.utils.designSystem)

                // Compose
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)

                // Utils
                implementation(libs.uuid)
                implementation(libs.parcelize)

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