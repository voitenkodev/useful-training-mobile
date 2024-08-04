plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.core)
}

apply(from = "$rootDir/gradle/configs/kotlin.gradle")
apply(from = "$rootDir/gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.common.state" }

kotlin {
    composeCompiler {
        // Enable 'strong skipping'
        // https://medium.com/androiddevelopers/jetpack-compose-strong-skipping-mode-explained-cbdb2aa4b900
        enableStrongSkippingMode.set(true)
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.ui)
            implementation(compose.foundation)
            implementation(libs.immutable.collections)

            implementation(projects.designSystem.atom)
            implementation(projects.designSystem.resources)

            // Equip
            implementation(projects.composeLibs.equipments)
            implementation(projects.domain.equipments)

            // Muscles
            implementation(projects.composeLibs.muscles)
            implementation(projects.domain.muscles)

            // User
            implementation(projects.domain.user)

            implementation(projects.common.utils)
            implementation(projects.designSystem.molecule)
            implementation(projects.designSystem.components)

        }
    }
}