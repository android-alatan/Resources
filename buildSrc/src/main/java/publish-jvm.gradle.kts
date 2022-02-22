import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.create

plugins {
    kotlin("jvm")
    id("publish-base-lib")
}

tasks.create<Jar>("sourceJar") {
    archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
}