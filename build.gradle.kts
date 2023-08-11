plugins {
    kotlin("jvm") version "1.9.0"
    id("maven-publish")
}

group = "studio.hcmc"
version = "0.0.5"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "studio.hcmc"
            artifactId = "kotlin-format-extension"
            version = "0.0.5"
            from(components["java"])
        }
    }
}