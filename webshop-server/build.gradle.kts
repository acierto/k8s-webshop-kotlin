import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.5"
    id("io.spring.dependency-management")
    id("org.asciidoctor.convert") version "1.5.8"
    kotlin("jvm")
    kotlin("plugin.spring") version "1.5.21"
}


java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

extra["snippetsDir"] = file("build/generated-snippets")

val springCloudVersion: String by project
val springGeodeVersion: String by project

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    developmentOnly("org.springframework.boot:spring-boot-devtools")

    runtimeOnly("com.h2database:h2")
    runtimeOnly("io.micrometer:micrometer-registry-prometheus")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.springframework.kafka:spring-kafka-test")
    testImplementation("org.springframework.restdocs:spring-restdocs-webtestclient")
    testImplementation("org.springframework.security:spring-security-test")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.geode:spring-geode-bom:${property("springGeodeVersion")}")
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val snippetsDir by extra { file("build/generated-snippets") }

tasks.test {
    outputs.dir(project.property("snippetsDir") as Any)
}

tasks.asciidoctor {
    inputs.dir(project.property("snippetsDir") as Any)
    dependsOn(tasks.test)
}

tasks.register<Sync>("staticResourcesSync") {
    from("${rootProject.projectDir}/webshop-frontend/dist")
    into("${rootProject.projectDir}/webshop-server/src/main/resources/static")
}

tasks.processResources {
    dependsOn("staticResourcesSync")
}
