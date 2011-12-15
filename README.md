Spring Integration Gradle Plugin
================================

# Setup

## Quick Start

1. Create (if not exists) **init.gradle** (usually under *~/.gradle*)
2. Add the following lines


    gradle.beforeProject { prj ->
        prj.apply from: 'https://raw.github.com/ghillert/spring-integration-gradle-plugin/master/distribution/spring-integration-apply.groovy'
    }

## Local Install (compiling from Source) - Only for the brave

### Check out repository from Git

    $ git clone git@github.com/spring-integration-gradle-plugin.git

### Compile and Install Plugin to local Maven Repo

    $ gradle clean install

### Make Gradle aware of plugin

You can either add the plugin to a local project (adding the plugin to **build.gradle**)
or you can add the plugin to **init.gradle** (plugin will be available globally)

#### Local Install

Add to build.gradle:

    buildscript {
	    repositories {
    mavenLocal()
	    }
        dependencies {
            classpath group: 'org.springframework.integration.gradle', name: 'si-gradle-plugin', version: '1.0.BUILD-SNAPSHOT'
        }
    }
    if (!project.plugins.findPlugin(templates.TemplatesPlugin)) {
	    project.apply(plugin: templates.TemplatesPlugin)
    }

#### Global Install

Create (if not exists) **init.gradle** (usually under *~/.gradle*)

	gradle.beforeProject { prj ->
	   prj.apply from: 'file:///Users/ghillert/.gradle/spring-integration-apply.groovy'
	}

Create **spring-integration-apply.groovy**

    buildscript {
        repositories {
            mavenLocal()
        }

        dependencies {
            classpath group: 'org.springframework.integration.gradle', name: 'si-gradle-plugin', version: '1.0.BUILD-SNAPSHOT'
        }
    }

    if (!project.plugins.findPlugin(org.springframework.integration.gradle.SpringIntegrationPlugin)) {
        project.apply(plugin: org.springframework.integration.gradle.SpringIntegrationPlugin)
    }




