plugins {
    id("lib-kotlin-android-no-config")
    id("lib-kotlin-robolectric")
    id("publish-android")
}

dependencies {
    api(project(":resource-provider-api"))
    api(libs.androidx.compat)
    compileOnly(libs.common.androidAnnotation)

    testImplementation(libs.test.junit4)
    testImplementation(libs.test.powermock.core)
    testImplementation(libs.test.powermock.junit4)
    testImplementation(libs.test.powermock.mockito)
    testImplementation(libs.test.junit5)
    testImplementation(libs.test.mockito)
    testImplementation(libs.test.mockitoKotlin)
    testRuntimeOnly(libs.test.jupiterEngine)
    testRuntimeOnly(libs.test.jupiterVintage)
}