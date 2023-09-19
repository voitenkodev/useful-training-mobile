plugins {
    kotlin("jvm") apply false
    kotlin("multiplatform") apply false
    kotlin("android") apply false
    kotlin("plugin.parcelize") apply false
    id("com.android.application") apply false
    id("com.android.library") apply false
    id("org.jetbrains.compose") apply false
    id("app.cash.sqldelight") apply false
    id("dev.icerock.mobile.multiplatform-resources") apply false
}

repositories { mavenCentral() }

subprojects {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}