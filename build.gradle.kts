import java.net.URI

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        repositories {
            google()
            mavenCentral()
        }
    }
    dependencies {
        classpath(libs.plugin.kotlin)
        classpath(libs.plugin.agp)
        classpath(libs.plugin.detekt)
        classpath(libs.plugin.jacoco)
        classpath(libs.plugin.ksp)
    }
}

task("clean", Delete::class) {
    delete(rootProject.buildDir)
    delete("$rootDir/build")
}