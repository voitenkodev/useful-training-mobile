plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.cocoapods)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlin.parcelize) // For Parcelize Navigation Graph
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
                implementation(projects.features.bottomMenu)
                implementation(projects.features.splash)
                implementation(projects.features.authentication)
                implementation(projects.features.trainings)
                implementation(projects.features.statistic)
                implementation(projects.features.trainingBuilder)

                // Services for DI
                implementation(projects.services.network)
                implementation(projects.services.database)
                implementation(projects.services.preferences)

                // Data
                implementation(projects.data.trainings)
                implementation(projects.data.authentication)

                // Other
                implementation(projects.common.platformApi)
                implementation(projects.common.designSystem)
                implementation(projects.common.architectureComponent)

                // Compose
                implementation(compose.ui)
                implementation(compose.material3) // TODO REMOVE IT

                // Koin
                implementation(libs.koin.core)

                // https://github.com/xxfast/Decompose-Router/tree/main
                implementation(libs.decompose.router)
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