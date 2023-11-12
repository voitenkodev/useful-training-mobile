plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "../../gradle/configs/kotlin.gradle")
apply(from = "../../gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.features.trainingbuilder" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.domain.trainings)
                implementation(projects.common.utils)
                implementation(projects.common.architectureComponent)
                implementation(projects.common.platformApi)

                implementation(projects.designSystem.atom)
                implementation(projects.designSystem.molecule)
                implementation(projects.designSystem.components)
                implementation(projects.designSystem.resources)

                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(libs.immutable.collections)
                implementation(libs.koin.core)
            }
        }
    }
}
