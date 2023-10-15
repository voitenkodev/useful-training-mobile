plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.parcelize")
}

apply(from = "../../config/gradle/build-scripts/kotlin.gradle")
apply(from = "../../config/gradle/build-scripts/android.gradle")

android { namespace = "com.voitenko.usefultraining.features.trainings" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.dataold)
                implementation(projects.utils.instruments)
                implementation(projects.utils.designSystem)
                implementation(projects.utils.resources) // TODO DO I NEED IT?
                implementation(projects.utils.charts)
                implementation(projects.utils.architectureComponent)

                // Compose
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material) // ICONS (mb remove)

                // Utils
                implementation(libs.uuid)
                implementation(libs.parcelize)

                // Koin
                implementation(libs.koin.core)
            }
        }
    }
}
