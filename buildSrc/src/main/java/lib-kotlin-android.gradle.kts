@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.library")
    id("code-quality")
    id("lib-tasks")
    kotlin("android")
    id("libs-detekt")
}

val versionCatalog = project.extensions.getByType<VersionCatalogsExtension>()
val libs = versionCatalog.named("libs")


android {
    compileSdk = libs.findVersion("androidCompile").get().requiredVersion.toInt()
    buildToolsVersion = libs.findVersion("androidBuildTool").get().requiredVersion

    defaultConfig {
        minSdk = libs.findVersion("minSdk").get().requiredVersion.toInt()
        targetSdk = libs.findVersion("targetSdk").get().requiredVersion.toInt()

    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    lint {
        lintConfig = File("${project.rootDir}/config/lint/lint_rule.xml")
        xmlOutput = File("${project.rootDir}/build/reports/lint/${project.name}/lint-results.xml")
        htmlOutput = File("${project.rootDir}/build/reports/lint/${project.name}/lint-results.html")
    }
}


dependencies {

    testImplementation(libs.findLibrary("test.junit5").get())
    testImplementation(libs.findLibrary("test.mockito").get())
    testImplementation(libs.findLibrary("test.mockitoKotlin").get())
    testRuntimeOnly(libs.findLibrary("test.jupiterEngine").get())
    testRuntimeOnly(libs.findLibrary("test.jupiterVintage").get())
}