plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.core)
    alias(libs.plugins.kotlin.serialization)
}

apply(from = "$rootDir/gradle/configs/kotlin.gradle")
apply(from = "$rootDir/gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.features.trainings" }

kotlin {
    composeCompiler {
        // Enable 'strong skipping'
        // https://medium.com/androiddevelopers/jetpack-compose-strong-skipping-mode-explained-cbdb2aa4b900
        enableStrongSkippingMode.set(true)
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.domain.trainings)

            implementation(projects.common.utils)
            implementation(projects.common.state)
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
            implementation(libs.serialization)
        }
    }
}
