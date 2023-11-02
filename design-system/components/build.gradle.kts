plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "../../config/gradle/build-scripts/kotlin.gradle")
apply(from = "../../config/gradle/build-scripts/android.gradle")

android { namespace = "com.voitenko.usefultraining.designsystem.components" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.designSystem.molecule)
                implementation(projects.designSystem.atom)
                implementation(projects.designSystem.resources)
                implementation(projects.common.platformApi)

                implementation(compose.ui)
                implementation(compose.material)
            }
        }
    }
}
