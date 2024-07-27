plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.cocoapods)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.core)
}

apply(from = "$rootDir/gradle/configs/android.gradle")
apply(from = "$rootDir/gradle/configs/ios.gradle")
apply(from = "$rootDir/gradle/configs/kotlin.gradle")

kotlin.cocoapods {
    podfile = project.file("../iosApp/Podfile")
    framework {
        export(libs.decompose.router.get().toString())
    }
}

kotlin {
    composeCompiler {
        // Enable 'strong skipping'
        // https://medium.com/androiddevelopers/jetpack-compose-strong-skipping-mode-explained-cbdb2aa4b900
        enableStrongSkippingMode.set(true)
    }

    sourceSets {
        commonMain.dependencies {
            // Features
            implementation(projects.features.authentication)
            implementation(projects.features.bottomMenu)
            implementation(projects.features.trainings)
            implementation(projects.features.statistics)
            implementation(projects.features.profile)
            implementation(projects.features.trainingBuilder)
            implementation(projects.features.exerciseExample)
            implementation(projects.features.searchExercise)
            implementation(projects.features.weightHistory)
            implementation(projects.features.userMuscles)
            implementation(projects.features.userEquipments)
            implementation(projects.features.exerciseExampleBuilder)

            // Services
            implementation(projects.services.network)
            implementation(projects.services.database)
            implementation(projects.services.preferences)
            implementation(projects.services.imageCore)

            // Data
            implementation(projects.data)

            // Other
            api(projects.common.architectureComponent) // 'api' for bridge Decompose in iOS
            implementation(projects.common.platformApi)

            // Design
            implementation(projects.designSystem.atom)

            // Compose
            implementation(compose.ui)
            implementation(compose.foundation)

            // Koin
            implementation(libs.koin.core)

            implementation(libs.serialization)
        }

        androidMain.dependencies {
            implementation(libs.activity.compose)
        }
    }
}