plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "../../config/gradle/build-scripts/kotlin.gradle")
apply(from = "../../config/gradle/build-scripts/android.gradle")

android { namespace = "com.voitenko.usefultraining.features.statistic" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.domain.trainings)

                implementation(projects.common.instruments)
                implementation(projects.common.designSystem)
                implementation(projects.common.charts)
                implementation(projects.common.architectureComponent)

                // Compose
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)

                // Koin
                implementation(libs.koin.core)
            }
        }
    }
}