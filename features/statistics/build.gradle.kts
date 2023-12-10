plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "../../gradle/configs/kotlin.gradle")
apply(from = "../../gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.features.statistics" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.domain.trainings)
                implementation(projects.domain.exerciseExamplesMuscles)

                implementation(projects.common.utils)
                implementation(projects.common.architectureComponent)

                implementation(projects.designSystem.atom)
                implementation(projects.designSystem.molecule)
                implementation(projects.designSystem.components)
                implementation(projects.designSystem.resources)

                implementation(projects.composeLibs.charts)

                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(libs.immutable.collections)
                implementation(libs.koin.core)
            }
        }
    }
}
