import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    kotlin("jvm") version "1.9.10"
    id("org.springframework.boot") version "3.1.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("groovy")
    id("jacoco")
    id("org.openapi.generator") version "7.0.0"
    id("org.liquibase.gradle") version "2.2.0"
}

group = "com.rviewer.skeletons"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-webflux:3.1.1")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    // Swagger
    implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.1.0")
    // Map Struct
    implementation("org.mapstruct:mapstruct:1.4.0.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.4.0.Final")
    // API First
    implementation("org.openapitools:jackson-databind-nullable:0.2.4")
    // Testing
    testImplementation("org.spockframework:spock-spring:2.4-M1-groovy-4.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test:3.5.6")
    // Security
    implementation("org.springframework.boot:spring-boot-starter-security")
    testImplementation("org.springframework.security:spring-security-test:6.1.1")
    // Database
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("io.r2dbc:r2dbc-postgresql:0.8.13.RELEASE")
    testImplementation("io.r2dbc:r2dbc-h2")
    testImplementation("com.h2database:h2:2.1.214")
    // Liquibase
    implementation("org.liquibase:liquibase-core")
}

tasks.register<GenerateTask>("buildServer") {
    generatorName.set("kotlin-spring")
    inputSpec.set("$rootDir/api/open-api.spec.yaml")
    apiPackage.set("com.rviewer.skeletons.infrastructure.controller")
    modelPackage.set("com.rviewer.skeletons.application.model")
    outputDir.set("$buildDir/generated/sources")
    modelNameSuffix.set("Dto")
    configOptions = mapOf(
        "interfaceOnly" to "true",
        "skipDefaultInterface" to "true",
        "performBeanValidation" to "true",
        "useSpringBoot3" to "true",
        "reactive" to "true",
        "additionalModelTypeAnnotations" to "@lombok.Generated"
    )
}

tasks.withType<KotlinCompile> {
    dependsOn("buildServer")

    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

sourceSets {
    main {
        kotlin {
            srcDir("${buildDir}/generated/sources/src/main/kotlin")
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()

    testLogging {
        events("PASSED", "SKIPPED", "FAILED")
    }
    ignoreFailures = true
    finalizedBy(tasks.named("jacocoTestReport"))
}

jacoco {
    toolVersion = "0.8.10"
    reportsDirectory = file("$buildDir/reports/jacoco")
}

tasks.jacocoTestReport {
    reports {
        xml.required = true
        html.required = true
        csv.required = false
    }
}