plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
     id("com.vanniktech.maven.publish") version "0.27.0"
    signing
   // id("maven-publish")
}

android {
    namespace = "com.fatherofapps.flib"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("commons-codec:commons-codec:1.17.0")
}


publishing {
    repositories {
        val repositoryDir = rootProject.file("public") .resolve("fpublic")
            .resolve("repository")
        maven {
            name = "FPublicReleases"
            url = repositoryDir.resolve("releases").toURI()
        }
    }

    publications {

        create<MavenPublication>("flib"){
            groupId = "com.fatherofapps"
            artifactId = "fpublic"
            version = "1.4"

            artifact("${project.buildDir}/outputs/aar/flib-release.aar")
            pom{
                name = "Flib"
                description = "A library to generate route for Jetpack Compose Navigation by using KSP"
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
//                scm {
//                    connection = "scm:git@github.com:frank-nhatvm/fpublic.git"
//                    developerConnection = "scm:git@github.com:frank-nhatvm/fpublic.git"
//                    url = "https://github.com/frank-nhatvm/fpublic"
//                }
                packaging = "aar"
//                publishFlibPublicationToFPublicReleasesRepository
                dependencies{
                    implementation("androidx.core:core-ktx:1.13.1")
                    implementation("commons-codec:commons-codec:1.17.0")
                }
            }
        }
    }
}

signing {
sign(publishing.publications["flib"])
}

