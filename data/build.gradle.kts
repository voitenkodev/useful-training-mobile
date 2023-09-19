plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("app.cash.sqldelight")
    kotlin("plugin.serialization")
}

apply(from = "../config/gradle/build-scripts/kotlin.gradle")
apply(from = "../config/gradle/build-scripts/android.gradle")

android { namespace = "com.voitenko.usefultraining.data" }

sqldelight {
    databases {
        create("UsefulTrainingDatabase") {
            packageName.set("")
            schemaOutputDirectory.set(file("src/commonMain/sqldelight/data/schema"))
            migrationOutputDirectory.set(file("src/commonMain/sqldelight/migrations"))
        }
    }
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Platform Context
                api(projects.utils.platformApi)

                // Ktor
                implementation(libs.ktor.core)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.serialization)
                implementation(libs.ktor.auth)
                implementation(libs.ktor.negotiation)

                implementation(libs.serialization)
                implementation(libs.datastore)
                implementation(libs.sqldelight.coroutine)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.okhttp)
                implementation(libs.sqldelight.android)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(libs.ktor.darwin)
                implementation(libs.sqldelight.native)
            }
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
    }
}
