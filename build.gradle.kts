import com.bmuschko.gradle.docker.tasks.image.*

plugins {
    base
    kotlin("jvm") version "1.5.21"
    id("com.bmuschko.docker-remote-api") version "6.7.0"
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

tasks.create("buildDockerImage", DockerBuildImage::class) {
    inputDir.set(file("${project.rootDir}"))
    images.add("acierto/k8s-webshop-kotlin:${properties["version"]}")
}
