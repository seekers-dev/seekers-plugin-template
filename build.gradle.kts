plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("kapt") version "1.9.23"
}
buildscript {
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.4.21"))
    }
}

// TODO Change group
group = "org.seekers.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { // Only used for snapshot builds
        url = uri("https://jitpack.io")
    }
}

val seekersVersion = "-SNAPSHOT"

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation(kotlin("stdlib"))
    implementation("com.github.seekers-dev:seekers-server:$seekersVersion")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}

tasks.named("build") {
    dependsOn(tasks.named("plugin"))
}
tasks.register<Jar>("plugin") {
    description = "Create uber jar"
    group = "build"
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    manifest { // TODO Change manifest for your project
        attributes["Plugin-Class"] = "${project.group}.ExamplePlugin"
        attributes["Plugin-Id"] = project.name
        attributes["Plugin-Provider"] = "Seekers Contributors"
        attributes["Plugin-Version"] = version.toString()
    }

    archiveBaseName.set(project.name)
    archiveClassifier.set("uber")

    with(tasks.named<Jar>("jar").get())
    dependsOn(configurations.runtimeClasspath)
    // List of all dependencies that your project needs and that aren't already supplied by the server
    // TODO You may want to update this list depending on your added dependencies
    val libs = arrayOf("kotlin-stdlib")

    fun matchesAny(name: String): Boolean {
        for (lib in libs) {
            if (name.contains(lib)) return true
        }
        return false
    }

    from(configurations.runtimeClasspath.get().filter{ matchesAny(it.name) }
        .map { if (it.isDirectory) it else zipTree(it) })
}