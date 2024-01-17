import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    `maven-publish`
    signing

    kotlin("jvm") version "1.6.0"

    id("org.jetbrains.dokka") version "1.9.10"
}

repositories {
    mavenCentral()
}

group = "io.github.eendroroy"
version = "0.0.1-beta2"
description = "SDK for BKash APIs"

val isReleaseVersion = !"$version".endsWith("SNAPSHOT")

dependencies {
    api("com.squareup.retrofit2:retrofit:2.9.0")
    api("com.squareup.retrofit2:converter-jackson:2.9.0")
}

tasks.withType<JavaCompile> { options.encoding = "UTF-8" }
tasks.withType<Javadoc> { options.encoding = "UTF-8" }

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8

    withSourcesJar()
    withJavadocJar()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

tasks.named<Jar>("javadocJar") {
    from(tasks.named("dokkaJavadoc"))
}

tasks {
    dokkaJavadoc {
        outputDirectory.set(file(layout.buildDirectory.dir("docs")))
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = "opensdk-bkash"
            from(components["java"])

            pom {
                name.set(project.name)
                description.set(project.description)
                url.set("https://github.com/eendroroy/opensdk-bkash.git")

                licenses {
                    license {
                        name.set("MIT")
                        url.set("http://opensource.org/licenses/MIT")
                        distribution.set("repo")
                    }
                }

                scm {
                    connection.set("scm:git:https://github.com/eendroroy/opensdk-bkash.git")
                    developerConnection.set("scm:git:https://github.com/eendroroy/opensdk-bkash.git")
                    url.set("https://github.com/eendroroy/opensdk-bkash.git")
                }

                developers {
                    developer {
                        id.set("eendroroy")
                        name.set("indrajit")
                        email.set("eendroroy@gmail.com")
                    }
                }
            }
        }
    }

    repositories {
        maven {
            val releaseRepo = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
            val snapshotRepo = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
            url = uri(if (isReleaseVersion) releaseRepo else snapshotRepo)
            credentials {
                username = project.findProperty("oss.user")?.toString() ?: System.getenv("OSS_USERNAME")
                password = project.findProperty("oss.key")?.toString() ?: System.getenv("OSS_TOKEN")
            }
        }
    }
}

signing {
    gradle.taskGraph.whenReady { isRequired = isReleaseVersion }
    sign(publishing.publications["mavenJava"])
}
