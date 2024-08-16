plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.core)
    alias(libs.plugins.kotlin.serialization)
}

apply(from = "$rootDir/gradle/configs/kotlin.gradle")
apply(from = "$rootDir/gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.features.authentication" }

kotlin {
    composeCompiler {
        enableStrongSkippingMode.set(true)
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.domain.authentication)
            implementation(projects.domain.user)
            implementation(projects.domain.muscles)
            implementation(projects.domain.equipments)

            implementation(projects.common.utils)
            implementation(projects.common.state)
            implementation(projects.common.architectureComponent)

            implementation(projects.designSystem.atom)
            implementation(projects.designSystem.molecule)
            implementation(projects.designSystem.components)
            implementation(projects.designSystem.resources)

            implementation(compose.ui)
            implementation(compose.foundation)

            implementation(projects.composeLibs.muscles)
            implementation(projects.composeLibs.weightPicker)
            implementation(projects.composeLibs.metricPicker)

            implementation(libs.immutable.collections)
            implementation(libs.koin.core)
            implementation(libs.serialization)
        }
    }
}
