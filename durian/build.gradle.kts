import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import com.vanniktech.maven.publish.JavaLibrary
import com.vanniktech.maven.publish.JavadocJar

plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("com.vanniktech.maven.publish") version "0.27.0"
    signing
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
        implementation("commons-codec:commons-codec:1.17.0")
}


publishing {
    repositories {
        val repositoryDir = rootProject.file("public").resolve("fpublic")
            .resolve("repository")
        maven {
            name = "FPublicReleases"
            url = repositoryDir.resolve("releases").toURI()
        }
    }

    publications {

        mavenPublishing{
            configure(JavaLibrary(
                // configures the -javadoc artifact, possible values:
                // - `JavadocJar.None()` don't publish this artifact
                // - `JavadocJar.Empty()` publish an emprt jar
                // - `JavadocJar.Javadoc()` to publish standard javadocs
                javadocJar = JavadocJar.Javadoc(),
                // whether to publish a sources jar
                sourcesJar = true,
            ))
        }

        create<MavenPublication>("durian") {
            groupId = "com.fatherofapps"
            artifactId = "durian"
            version = "1.0"



            pom {
                name = "Durian"
                description =
                    "A library to generate route for Jetpack Compose Navigation by using KSP"
                url = "https://github.com/frank-nhatvm/fpublic"
                licenses {
                    license {
                        name = "The Apache License, Version 2.0"
                        url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }
                developers {
                    developer {
                        id = "frank_vu"
                        name = "Frank Vu"
                        email = "nhat.thtb@gmail.com"
                    }
                }
                scm {
                    connection = "scm:git@github.com:frank-nhatvm/fpublic.git"
                    developerConnection = "scm:git@github.com:frank-nhatvm/fpublic.git"
                    url = "https://github.com/frank-nhatvm/fpublic"
                }
            }
        }
    }
}

signing {
    sign(publishing.publications["durian"])
}