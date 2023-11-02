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
    ":data:exercise-examples",
    ":data:authentication",

    ":domain:trainings",
    ":domain:authentication",
    ":domain:exercise-examples",

    ":services:network",
    ":services:database",
    ":services:preferences",

    "common:design-system",

    "common:architecture-component",
    "common:utils",
    "common:platform-api",
    "common:compose-player",
    "common:charts",

    "design-system:atom",
    "design-system:molecule",
    "design-system:components",
    "design-system:resources",

    "features:splash",
    "features:authentication",
    "features:registration",
    "features:bottom-menu",
    "features:trainings",
    "features:statistics",
    "features:profile",
    "features:training-builder",
    "features:exercise-example-builder"
)
