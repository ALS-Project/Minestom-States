plugins {
    `kotlin-dsl`
    `maven-publish`
    java
}

var minestomVersion = "aebf72de90"

group = "fr.bretzel.minestom.states"
version = "1.0.0"

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    //Minestom
    implementation("com.github.Minestom:Minestom:$minestomVersion")
}