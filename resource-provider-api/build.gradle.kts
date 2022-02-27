plugins {
    id("lib-kotlin-android-no-config")
    id("publish-android")
}

dependencies {
    compileOnly(libs.common.androidAnnotation)
}