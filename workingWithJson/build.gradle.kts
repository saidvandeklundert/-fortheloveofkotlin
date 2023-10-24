import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("kapt") version "1.9.10"
    application


}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

dependencies {
    testImplementation(kotlin("test"))
    // JSON with Jackson:
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.1")




}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}