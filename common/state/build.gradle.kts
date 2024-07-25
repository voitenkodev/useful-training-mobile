plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose)
}

apply(from = "$rootDir/gradle/configs/kotlin.gradle")
apply(from = "$rootDir/gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.common.state" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(libs.immutable.collections)

                implementation(projects.designSystem.atom)

                implementation(projects.composeLibs.equipments)
                implementation(projects.domain.equipments)

                implementation(projects.composeLibs.muscles)
            }
        }
    }
}