plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

apply(from = "../../config/gradle/build-scripts/kotlin.gradle")
apply(from = "../../config/gradle/build-scripts/android.gradle")

android { namespace = "com.voitenko.usefultraining.data.exercisesbundle" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.domain.exercisesBundle)
                implementation(projects.services.database)

                implementation(libs.coroutines)
                implementation(libs.koin.core)
            }
        }
    }
}
