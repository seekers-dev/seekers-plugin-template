plugins {
    kotlin("jvm") version "1.9.22"
    id("com.coditory.manifest") version "0.2.6"
}

group = "org.seekers.example" // TODO Change group
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation(kotlin("stdlib"))
    implementation("com.github.seekers-dev:seekers-server:47cfdb1")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}

manifest {
    attributes = mapOf(
        Pair("Plugin-Class", "$group.SeekersPlugin"),
        Pair("Plugin-Id", "seekers-plugin-template"),
        Pair("Plugin-Provider", "Seekers Contributors"),
        Pair("Plugin-Version", version.toString())
    )
}
