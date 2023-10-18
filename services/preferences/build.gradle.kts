plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

apply(from = "../../config/gradle/build-scripts/kotlin.gradle")
apply(from = "../../config/gradle/build-scripts/android.gradle")

android { namespace = "com.voitenko.usefultraining.services.preferences" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Platform Context
                implementation(projects.common.platformApi)

                implementation(libs.datastore)
            }
        }

        val androidMain by getting {
            dependencies {
            }
        }
        val iosMain by getting {
            dependencies {
            }
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
    }
}
