plugins {
    id("io.gitlab.arturbosch.detekt")
}

val versionCatalog = project.extensions.getByType<VersionCatalogsExtension>()
val libs = versionCatalog.named("libs")

dependencies {
    "detektPlugins"(libs.findLibrary("verify.detektFormatting").get().get())
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt> {
    jvmTarget = "1.8"

    autoCorrect = true
    config.setFrom(files("$rootDir/config/detekt/detekt.yml"))
    reports {
        file("$rootDir/build/reports/detekt/${project.name}/").mkdirs()
        xml {
            required.set(true)
            outputLocation.set(file("$rootDir/build/reports/detekt/${project.name}.xml"))
        }
        html {
            required.set(true)
            outputLocation.set(file("$rootDir/build/reports/detekt/${project.name}.html"))
        }
    }
}

