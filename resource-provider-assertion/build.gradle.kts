plugins {
    id("lib-kotlin-android-no-config")
    id("publish-android")
}

dependencies {
    api(project(":resource-provider-api"))
    api(libs.test.mockito)
    compileOnly(libs.common.androidAnnotation)
}