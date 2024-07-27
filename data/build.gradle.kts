plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

apply(from = "$rootDir/gradle/configs/kotlin.gradle")
apply(from = "$rootDir/gradle/configs/android.gradle")

android { namespace = "com.voitenko.alienworkout.data" }

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.domain.authentication)
            implementation(projects.domain.user)
            implementation(projects.domain.trainings)
            implementation(projects.domain.exerciseExamples)
            implementation(projects.domain.muscles)
            implementation(projects.domain.statistics)
            implementation(projects.domain.equipments)
            implementation(projects.domain.filters)

            implementation(projects.services.network)
            implementation(projects.services.database)
            implementation(projects.services.preferences)

            implementation(libs.coroutines)
            implementation(libs.koin.core)
        }
    }
}
