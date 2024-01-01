plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.cocoapods)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.compose)
}

apply(from = "../gradle/configs/android.gradle")
apply(from = "../gradle/configs/ios.gradle")
apply(from = "../gradle/configs/kotlin.gradle")

kotlin.cocoapods {
    podfile = project.file("../iosApp/Podfile")
    framework { export(libs.decompose.router.get().toString()) }
}

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Features
                implementation(projects.features.authentication)
                implementation(projects.features.bottomMenu)
                implementation(projects.features.trainings)
                implementation(projects.features.statistics)
                implementation(projects.features.profile)
                implementation(projects.features.trainingBuilder)
                implementation(projects.features.exerciseExample)
                implementation(projects.features.searchExercise)
                implementation(projects.features.weightHistory)

                // Services
                implementation(projects.services.network)
                implementation(projects.services.database)
                implementation(projects.services.preferences)
                implementation(projects.services.imageCore)

                // Data
                implementation(projects.data)

                // Other
                api(projects.common.architectureComponent) // 'api' for bridge Decompose in iOS
                implementation(projects.common.platformApi)

                // Design
                implementation(projects.designSystem.atom)

                // Compose
                implementation(compose.ui)
                implementation(compose.foundation)

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