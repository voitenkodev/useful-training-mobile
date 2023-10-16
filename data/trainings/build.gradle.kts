plugins {
    kotlin("multiplatform")
    id("com.android.library")
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
            }
        }
    }
}
