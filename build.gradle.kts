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
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    //json
    implementation("org.glassfish.jersey.core:jersey-server:3.0.1")
    implementation("org.glassfish.jersey.inject:jersey-hk2:3.0.1")
    implementation("org.glassfish.jersey.containers:jersey-container-netty-http:3.0.1")
    implementation("org.glassfish.jersey.media:jersey-media-json-jackson:3.0.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.1")
    implementation("ch.qos.logback:logback-classic:1.2.3")    
    // dagger
    implementation("com.google.dagger:dagger:2.0")
    annotationProcessor("com.google.dagger:dagger-compiler:2.0")
    kapt("com.google.dagger:dagger-compiler:2.0")


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