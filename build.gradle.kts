plugins {
    base
    kotlin("jvm") version "1.5.21"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

allprojects {
    group = "nl.acierto"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenLocal()
        mavenCentral()
    }
}
