plugins {
    `kotlin-dsl`
    `maven-publish`
    java
}

group = "fr.bretzel.minestom.states"
version = "1.0.0"

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    //Minestom
    implementation("dev.hollowcube:minestom-ce:74ca1041f3")
}