import com.android.build.gradle.api.AndroidSourceSet

plugins {
    id("com.android.library")
    id("publish-base-lib")
}

tasks.create<Jar>("sourceJar") {
    archiveClassifier.set("sources")
    @Suppress("DEPRECATION")
    from(android.sourceSets.getByName<AndroidSourceSet>("main").java.srcDirs)
}