@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.app)
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.serialization)
    alias(libs.plugins.parcelize)
}

kotlin {
    android()

    iosX64("uikitX64").binaries.executable {
        entryPoint = "main"
        freeCompilerArgs += listOf(
            "-linker-option", "-framework", "-linker-option", "Metal",
            "-linker-option", "-framework", "-linker-option", "CoreText",
            "-linker-option", "-framework", "-linker-option", "CoreGraphics"
        )
    }
    iosArm64("uikitArm64").binaries.executable {
        entryPoint = "main"
        freeCompilerArgs += listOf(
            "-linker-option", "-framework", "-linker-option", "Metal",
            "-linker-option", "-framework", "-linker-option", "CoreText",
            "-linker-option", "-framework", "-linker-option", "CoreGraphics"
        )
        // TODO: the current compose binary surprises LLVM, so disable checks for now.
        freeCompilerArgs += "-Xdisable-phases=VerifyBitcode"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":designsystem"))
                implementation(project(":core"))

                implementation(libs.coroutines)
                implementation(libs.datetime)
                implementation(libs.logger)
                implementation(libs.serialization)
                implementation(libs.uuid)
                implementation(libs.redux)
                implementation(libs.parcelize)
                implementation(libs.koin.core)

                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)
            }
        }

        val androidMain by getting {
            dependencies {
                // Common
                implementation("androidx.appcompat:appcompat:1.5.1")
                implementation("androidx.activity:activity-compose:1.6.0")
                // Firebase
                implementation("com.google.firebase:firebase-auth-ktx:21.0.8")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.6.4")
                implementation("com.google.firebase:firebase-firestore:24.3.1")
                // Accompanist
                implementation("com.google.accompanist:accompanist-systemuicontroller:0.23.1")
                // Coil
                implementation("io.coil-kt:coil:2.2.2")
                implementation("io.coil-kt:coil-compose:2.2.2")

                implementation(libs.koin.android)
            }
        }

        val iosMain by creating {
            dependsOn(commonMain)
            dependencies {
                implementation("io.github.qdsfdhvh:image-loader:1.1.9")
            }
        }
        val uikitMain by creating { dependsOn(iosMain) }
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
    namespace = "dev.voitenko.usefultraining"
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        applicationId = "dev.voitenko.usefultraining"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
}

compose.experimental.uikit.application {
    bundleIdPrefix = "dev.voitenko.usefultraining"
    projectName = "UsefulTraining"
    deployConfigurations {
        simulator("IPhone13") { // Usage: ./gradlew iosDeployIPhone13Debug
            device = org.jetbrains.compose.experimental.dsl.IOSDevices.IPHONE_13_PRO
        }
        simulator("IPadUI") { // Usage: ./gradlew iosDeployIPadUIDebug
            device = org.jetbrains.compose.experimental.dsl.IOSDevices.IPAD_MINI_6th_Gen
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}

// TODO: the current compose binary surprises LLVM, so disable checks for now.
kotlin {
    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        binaries.all { freeCompilerArgs += "-Xdisable-phases=VerifyBitcode" }
    }
}