val kotest_version: String by project
val strikt_version: String by project
val kotlin_logging_version: String by project
val coroutines_version: String by project
val kotlin_reflect: String by project
val serialization_version: String by project

plugins {
    kotlin("jvm") version "1.8.0"
    kotlin("plugin.serialization") version "1.8.0"
    `java-test-fixtures`
    `maven-publish`
}

group = "com.szastarek"
version = "0.0.2"

repositories {
    mavenCentral()
    maven("https://maven.pkg.github.com/arkadiuszSzast") {
        credentials {
            username = System.getenv("GITHUB_ACTOR")
            password = System.getenv("GITHUB_TOKEN")
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("kotlin-acl-kotlinx-serializer") {
            from(components["kotlin"])
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/arkadiuszSzast/kotlin-acl-kotlinx-serializer")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlin_reflect")
    implementation("io.github.microutils:kotlin-logging-jvm:$kotlin_logging_version")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json-jvm:${serialization_version}")

    testImplementation("io.kotest:kotest-runner-junit5:$kotest_version")
    testImplementation("io.strikt:strikt-core:$strikt_version")
}
