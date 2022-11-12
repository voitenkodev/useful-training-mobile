@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.serialization)
}

kotlin {
    android()
    iosX64("uikitX64")
    iosArm64("uikitArm64")

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.ui)
                implementation(libs.datetime)
                implementation(libs.redux)
                implementation(libs.logger)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("androidx.activity:activity-compose:1.6.1")
                implementation("io.coil-kt:coil:2.2.2")
                implementation("io.coil-kt:coil-compose:2.2.2")
            }
        }
        val uikitMain by creating {
            dependsOn(commonMain)
            dependencies {
                implementation("io.github.qdsfdhvh:image-loader:1.1.9")
            }
        }
        val uikitX64Main by getting { dependsOn(uikitMain) }
        val uikitArm64Main by getting { dependsOn(uikitMain) }
    }

    kotlin.sourceSets.all {
        languageSettings.optIn("kotlinx.coroutines.ExperimentalCoroutinesApi")
        languageSettings.optIn("androidx.compose.ui.unit.ExperimentalUnitApi")
        languageSettings.optIn("androidx.compose.ui.text.ExperimentalTextApi")
        languageSettings.optIn("androidx.compose.foundation.ExperimentalFoundationApi")
        languageSettings.optIn("androidx.compose.ui.ExperimentalComposeUiApi")
        languageSettings.optIn("androidx.compose.material.ExperimentalMaterialApi")
        languageSettings.optIn("androidx.compose.animation.ExperimentalAnimationApi")
        languageSettings.optIn("kotlin.time.ExperimentalTime")
    }
}

android {
    namespace = "dev.voitenko.usefultraining.core"
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig { minSdk = 21 }
    buildTypes.getByName("release") { isMinifyEnabled = true }
}