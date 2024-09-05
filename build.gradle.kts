plugins {
    kotlin("jvm") version "1.9.23"
}

group = "me.sno0wfl4ke"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(kotlin("stdlib"))
    implementation("org.apache.logging.log4j:log4j-core:2.17.1")
    implementation("org.apache.logging.log4j:log4j-api:2.17.1")
    implementation("com.opencsv:opencsv:5.5.2")
}

tasks.test {
    useJUnitPlatform()
}


