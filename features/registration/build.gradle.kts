plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "../../gradle/configs/kotlin.gradle")
apply(from = "../../gradle/configs/android.gradle")

android { namespace = "com.voitenko.usefultraining.features.registration" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.domain.authentication)
                implementation(projects.common.utils)
                implementation(projects.common.platformApi)
                implementation(projects.common.architectureComponent)

                implementation(projects.designSystem.atom)
                implementation(projects.designSystem.molecule)
                implementation(projects.designSystem.components)
                implementation(projects.designSystem.resources)
                implementation(projects.designSystem.brandArtifacts)

                implementation(compose.ui)
                implementation(compose.foundation)
    implementation(libs.koin.core)
            }
        }
    }
}
