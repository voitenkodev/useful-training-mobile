plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "../../gradle/configs/kotlin.gradle")
apply(from = "../../gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.features.authentication" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.domain.authentication)
                implementation(projects.domain.user)

                implementation(projects.common.utils)
                implementation(projects.common.platformApi)
                implementation(projects.common.architectureComponent)

                implementation(projects.designSystem.molecule)
                implementation(projects.designSystem.components)

                implementation(compose.ui)
                implementation(compose.foundation)

                implementation(libs.koin.core)
            }
        }
    }
}
