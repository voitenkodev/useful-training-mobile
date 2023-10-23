plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

apply(from = "../../config/gradle/build-scripts/kotlin.gradle")
apply(from = "../../config/gradle/build-scripts/android.gradle")

android { namespace = "com.voitenko.usefultraining.data.trainings" }

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.domain.trainings)
                implementation(projects.services.network)
                implementation(projects.services.database)
                implementation(projects.services.preferences)

                implementation(libs.coroutines)
                implementation(libs.koin.core)
            }
        }
    }
}
