plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlin.parcelize)
}

apply(from = "$rootDir/gradle/configs/kotlin.gradle")
apply(from = "$rootDir/gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.features.searchexercise" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.domain.exerciseExamples)
                implementation(projects.domain.muscles)
                implementation(projects.domain.filters)
                implementation(projects.domain.equipments)

                implementation(projects.common.utils)
                implementation(projects.common.architectureComponent)

                implementation(projects.designSystem.atom)
                implementation(projects.designSystem.molecule)
                implementation(projects.designSystem.components)
                implementation(projects.designSystem.resources)

                implementation(compose.ui)
                implementation(compose.foundation)

                implementation(projects.composeLibs.muscles)
                implementation(projects.composeLibs.equipments)

                implementation(libs.immutable.collections)
                implementation(libs.koin.core)
            }
        }
    }
}
