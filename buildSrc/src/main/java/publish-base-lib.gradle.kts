plugins {
    id("maven-publish")
}

afterEvaluate {

    val isAndroid = plugins.hasPlugin("com.android.library")

    val artifactName: String = name

    if (artifactName.contains("sample")) return@afterEvaluate

    publishing {
        publications {
            create<MavenPublication>("release") {
                if (isAndroid) {
                    from(components.getByName("release"))
                } else {
                    from(components.getByName("java"))
                }
                groupId = groupId()
                artifactId = artifactName

                artifact(tasks.getByName("sourceJar"))
            }

        }
    }
}

fun groupId(): String {
    return "io.androidalatan.libs"
}