plugins {
    base
    id("com.github.node-gradle.node") version "3.1.1"
}

tasks {
    named("yarn_build") {
        dependsOn("yarn_install")
    }

    named("yarn_test") {
        dependsOn("yarn_install")
    }

    named("yarn_dev") {
        dependsOn("yarn_install")
    }
}

node {
    version.set("14.17.6")
    yarnVersion.set("1.22.11")
}
