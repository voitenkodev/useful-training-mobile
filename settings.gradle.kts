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
}

rootProject.name = "UsefulTraining"

include(
    ":androidApp",
    ":shared",
    ":dataold",

    ":data:trainings",

    ":domain:trainings",

    ":services:network",
    ":services:database",
    ":services:preferences",

    "utils:design-system",
    "utils:architecture-component",
    "utils:instruments",
    "utils:platform-api",
    "utils:compose-player",
    "utils:resources",
    "utils:charts",

    "features:authentication",
    "features:trainings",
)
