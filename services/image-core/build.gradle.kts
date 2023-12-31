plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "../../gradle/configs/android.gradle")
apply(from = "../../gradle/configs/kotlin.gradle")

android { namespace = "com.voitenko.alienworkout.services.imagecore" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.ktor.core)
                implementation(libs.coil3)
                implementation(libs.coil3.network)
                api("io.coil-kt.coil3:coil-compose:3.0.0-alpha01")
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.okhttp)
                implementation(libs.coil3.gif)
                implementation(libs.coil3.svg)
                implementation(libs.coil3.video)
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
