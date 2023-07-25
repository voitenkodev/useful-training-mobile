plugins {
    kotlin("jvm") apply false
    kotlin("multiplatform") apply false
    kotlin("android") apply false
    kotlin("plugin.parcelize") apply false
    id("com.android.application") apply false
    id("com.android.library") apply false
    id("org.jetbrains.compose") apply false
    id("app.cash.sqldelight") apply false
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


tasks.register("clean", Delete::class) {
    delete(".gradle")
    delete(".idea")
    delete("build")

    delete("androidApp/build")
    delete("data/build")
    delete("shared/build")
    delete("utils/instruments/build")
    delete("utils/navigator/build")
}