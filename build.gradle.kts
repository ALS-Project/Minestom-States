plugins {
    id("java")
    id("maven-publish")
}

group = "fr.bretzel.minestom.states"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    implementation("com.github.Minestom:Minestom:18c46481f4")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.properties["group"] as? String?
            artifactId = project.name
            version = project.properties["version"] as? String?

            from(components["java"])
        }
    }
}