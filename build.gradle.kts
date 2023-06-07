import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))


    // Coroutines to make the HTTP requests asynchronous(In the background thread)
    // implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    // Gson (To convert raw JSON to pretty JSON)
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Okhttp3 for the POST requests
    // implementation("com.squareup.okhttp3:okhttp:4.9.0")


    implementation("org.jsoup:jsoup:1.10.3")


    implementation("mysql:mysql-connector-java:8.0.26")


}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}