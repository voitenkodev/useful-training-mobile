plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.serialization)
}

apply(from = "../../gradle/configs/kotlin.gradle")
apply(from = "../../gradle/configs/android.gradle")

android { namespace = "com.voitenko.usefultraining.services.network" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // NativeContext
                implementation(projects.common.platformApi)

                // Ktor
                implementation(libs.ktor.core)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.serialization)
                implementation(libs.ktor.auth)
                implementation(libs.ktor.negotiation)

                implementation(libs.serialization)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.okhttp)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(libs.ktor.darwin)
            }
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
    }
}
