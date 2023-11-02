plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "../../config/gradle/build-scripts/kotlin.gradle")
apply(from = "../../config/gradle/build-scripts/android.gradle")

android { namespace = "com.voitenko.usefultraining.features.bottommenu" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.common.designSystem)
                implementation(projects.common.architectureComponent)
                implementation(projects.common.platformApi)

                // Compose
                implementation(compose.ui)
                implementation(compose.foundation)

                // Collections
                implementation(libs.immutable.collections)

                // Koin
                implementation(libs.koin.core)
            }
        }
    }
}
