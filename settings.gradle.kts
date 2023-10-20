pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement.repositories {
    google()
    mavenCentral()
    mavenLocal()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    // Navigation Decompose
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
}

rootProject.name = "UsefulTraining"

include(
    ":androidApp",
    ":shared",

    ":data:trainings",
    ":data:authentication",

    ":domain:trainings",
    ":domain:authentication",

    ":services:network",
    ":services:database",
    ":services:preferences",

    "common:design-system",
    "common:architecture-component",
    "common:instruments",
    "common:platform-api",
    "common:compose-player",
    "common:resources",
    "common:charts",

    "features:splash",
    "features:authentication",
    "features:bottom-menu",
    "features:trainings",
    "features:statistic",
    "features:training-builder",
)
