buildscript {
    repositories {
        mavenLocal()
        maven {
            url "https://raw.github.com/ghillert/spring-integration-gradle-plugin/master/distribution"
        }
    }

    dependencies {
        classpath group: 'org.springframework.integration.gradle', name: 'si-gradle-plugin', version: '1.0.BUILD-SNAPSHOT'
    }
}

if (!project.plugins.findPlugin(org.springframework.integration.gradle.SpringIntegrationPlugin)) {
    project.apply(plugin: org.springframework.integration.gradle.SpringIntegrationPlugin)
}

