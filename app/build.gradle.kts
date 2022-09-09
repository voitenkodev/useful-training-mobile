@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.app)
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.serialization)
}

kotlin {
    jvm("desktop")
    android()
    macosX64().binaries.executable {
        entryPoint = "main"
        freeCompilerArgs += listOf("-linker-option", "-framework", "-linker-option", "Metal")
    }
    macosArm64().binaries.executable {
        entryPoint = "main"
        freeCompilerArgs += listOf("-linker-option", "-framework", "-linker-option", "Metal")
    }
    iosX64("uikitX64").binaries.executable {
        entryPoint = "main"
        freeCompilerArgs += listOf(
            "-linker-option", "-framework", "-linker-option", "Metal",
            "-linker-option", "-framework", "-linker-option", "CoreText",
            "-linker-option", "-framework", "-linker-option", "CoreGraphics"
        )
    }
//    iosArm64("uikitArm64").binaries.executable {
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
                implementation(libs.coroutines)
                implementation(libs.datetime)
                implementation(libs.logger)
                implementation(libs.serialization)
                implementation(libs.uuid)

                implementation(compose.ui)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.runtime)
            }
        }

        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("androidx.appcompat:appcompat:1.5.0")
                implementation("androidx.activity:activity-compose:1.5.1")
                implementation("androidx.navigation:navigation-compose:2.5.2")

                // Firebase
                implementation("com.google.firebase:firebase-auth-ktx:21.0.8")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.6.4")
                implementation("com.google.firebase:firebase-firestore:24.3.0")
            }
        }

        val iosMain by creating { dependsOn(commonMain) }
        val macosMain by creating { dependsOn(iosMain) }
        val macosX64Main by getting { dependsOn(macosMain) }
        val macosArm64Main by getting { dependsOn(macosMain) }
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
    }
}

android {
    namespace = "dev.voitenko.usefultraining"
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        applicationId = "dev.voitenko.usefultraining"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
}

compose.desktop {
    application {
        mainClass = "Main_desktopKt"
        nativeDistributions {
            targetFormats(
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb
            )
            packageName = "usefultraining"
            packageVersion = "1.0.0"

            windows {
                menuGroup = "UsefulTraining"
                // see https://wixtoolset.org/documentation/manual/v3/howtos/general/generate_guids.html
                upgradeUuid = "18159995-d967-4CD2-8885-77BFA97CFA9F"
            }
        }
    }
}

compose.experimental.uikit.application {
    bundleIdPrefix = "dev.voitenko.usefultraining"
    projectName = "UsefulTraining"
    deployConfigurations {
        simulator("IPhone13") {
            //Usage: ./gradlew iosDeployIPhone13Debug
            device = org.jetbrains.compose.experimental.dsl.IOSDevices.IPHONE_13_PRO
        }
        simulator("IPadUI") {
            //Usage: ./gradlew iosDeployIPadUIDebug
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

compose.desktop.nativeApplication {
    targets(kotlin.targets.getByName("macosX64"))
    distributions {
        targetFormats(org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg)
        packageName = "UsefulTraining"
        packageVersion = "1.0.0"
    }
}