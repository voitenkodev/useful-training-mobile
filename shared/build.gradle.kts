plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("app.cash.sqldelight")
}

apply(from = "../config/gradle/build-scripts/android.gradle")
apply(from = "../config/gradle/build-scripts/ios.gradle")
apply(from = "../config/gradle/build-scripts/kotlin.gradle")

version = "1.0"

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

                api(projects.utils.instruments)
                api(projects.utils.navigator)

                //compose
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

                //utils
                implementation(libs.uuid)
                implementation(libs.parcelize)
                implementation(libs.serialization)
                implementation(libs.datetime)
                implementation(libs.datastore)

                //ktor
                implementation(libs.ktor.core)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.serialization)
                implementation(libs.ktor.auth)
                implementation(libs.ktor.negotiation)

                //koin
                implementation(libs.koin.core)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.activity.compose)
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