plugins {
    id("jacoco")
}

val excludedFiles = mutableSetOf(
    "**/R.class",
    "**/BR.class",
    "**/R$*.class",
    "**/*\$ViewInjector*.*",
    "**/*\$ViewBinder*.*",
    "**/BuildConfig.*",
    "**/Manifest*.*",
    // ignore ButterKnife generated code
    "**/**\$ViewBinder*.class",
    // ignore Dagger 2 generated code
    "**/*_MembersInjector.class",
    "**/Dagger*Component*.class",
    "**/Dagger*Subcomponent*.class",
    "**/*Subcomponent\$Builder.class",
    "**/*Module_*Factory.class",
    // Dagger declaration classes
    "**/**Module.class",
    "**/**Component.class",
    "**/*Constants.class",
    "**/**_ViewBinding*.class",
    "**/**Binding*.class",
    "**/DataBinderMapperImpl*.class",
    "android/databinding/**",
    //ignore all model classes
    "**/models/**",
    "**/model/**",
    //ignore all exceptions classes
    "**/exceptions/**",
    "**/**Exception.class",
    "**/**Exception**.class",
    //ignore all event classes
    "**/Mock**.class",
    // ignore all generated classes
    "**/generated/**",
    "**/lifecycle-handler-sample/**",
    "**/**assert*/**",
    "**/**Test*/**",

)

tasks.register<JacocoReport>("jacocoReport") {
    group = "Reporting"
    description = "Generate Jacoco coverage reports."

    reports {
        xml.required.set(true)
        xml.outputLocation.set(file("$rootDir/build/reports/jacoco/${project.name}/jacocoReport.xml"))
        html.required.set(true)
        html.outputLocation.set(file("$rootDir/build/reports/jacoco/${project.name}/"))
    }

    val kotlinPath = "tmp/kotlin-classes/debug/"
    val classPath = "intermediates/classes/debug/"
    val javacPath = "intermediates/javac/debug/compileDebugJavaWithJavac/classes/"
    val javaPath = "classes/"

    sourceDirectories.setFrom(fileTree(project.buildDir) {
        include("src/main/java")
    })
    classDirectories.setFrom(fileTree(project.buildDir) {
        include(classPath, javacPath, javaPath, kotlinPath)
        exclude(excludedFiles)
    })

    executionData.setFrom(fileTree(project.buildDir) {
        include("jacoco/test*.exec")
    })
}

tasks.withType<Test>() {
    useJUnitPlatform()
    configure<JacocoTaskExtension> {
        isIncludeNoLocationClasses = true
        excludes = listOf("jdk.internal.*")
    }

    reports {
        html.outputLocation.set(File("${project.rootDir}/build/reports/test/${project.name}"))
        html.required.set(true)
        junitXml.outputLocation.set(File("${project.rootDir}/build/reports/test/${project.name}"))
        junitXml.required.set(true)
    }


}
