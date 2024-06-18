import java.io.FileInputStream
import java.util.Properties

include(":durian")


pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}


dependencyResolutionManagement {
 //   repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
//            repository/releases/com/fatherofapps/fpublic/maven-metadata.xml
            setUrl("https://raw.githubusercontent.com/frank-nhatvm/fpublic/main/repository/releases")
        }
    }
}

rootProject.name = "FLib"
include(":app")
include(":flib")


