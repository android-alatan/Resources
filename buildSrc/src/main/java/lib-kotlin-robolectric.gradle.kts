plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

val versionCatalog = project.extensions.getByType<VersionCatalogsExtension>()
val libs = versionCatalog.named("libs")


dependencies {
    testImplementation(libs.findLibrary("test.robolectric.core").get())
    testImplementation(libs.findLibrary("test.androidxTest.core").get())
    testImplementation(libs.findLibrary("test.androidxTest.runner").get())
    testImplementation(libs.findLibrary("test.androidxTest.junit").get())
}