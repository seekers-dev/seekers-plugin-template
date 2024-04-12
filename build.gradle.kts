plugins {
    kotlin("jvm") version "1.9.22"
    id("com.coditory.manifest") version "0.2.6"
}

group = "org.seekers.groovy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
    }
}

val seekersVersion = "47cfdb1"
val groovyVersion = "3.0.15"

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation(kotlin("stdlib"))
    implementation("com.github.seekers-dev:seekers-server:$seekersVersion")
    implementation("org.codehaus.groovy:groovy-all:$groovyVersion")
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
