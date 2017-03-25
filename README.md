# Overview

I was recently asked to hack some sample programs for an interview using Java.  Very simple programs that can use the default package, require only a single file and, preferably, can be compiled and run from the command line.

My first attempt was to use the command line (bash).  It is OK, but going back and forth between the editor and bash is a nuisance. Next up was to use the M-x compile facility in Emacs.  Better but still clunky.  In this story, the only computer resident IDE is Android Studio which, while excellent for Android development, is clunky with a simple Java program.  Maintaining a long lived IDE apart from Android Studio for this purpose is overkill and undesirable.

The next approximation was to use the Gradle Application plugin.  This turned out to be a very effective solution.  There is a small boilerplate setup at the top level to support the Gradle wrapper, e.g.

    ~/java-examples/
      gradle/
      gradlew
      gradlew.bat

The *gradle* directory provides the Gradle wrapper classes.  *gradlew* and *gradlew.bat* are scripts that run the wrapper. [Wrapper details and download information link.](https://docs.gradle.org/current/userguide/gradle_wrapper.html)

Next up is a top level *build.gradle* file and a *settings.gradle* file:

    ~/java-examples/
      build.gradle
      gradle/
      gradlew
      gradlew.bat
      settings.gradle


build.gradle:

    // Top-level build file where you can add configuration options common to all sub-projects/modules.

    buildscript {
        repositories {
            jcenter()
        }
        dependencies {
            // NOTE: Do not place your application dependencies here; they belong
            // in the individual module build.gradle files
        }
    }

    allprojects {
        repositories {
            jcenter()
            mavenLocal()
        }

    // Define versions in a single place
    ext {
        // App dependencies
    }

settings.gradle contains the sub-projects:

    include ':ex1', ':ex2', ...

With this structure in place a new example (project) can be added very simply.  For example, _ex1_ would add the following to *java-examples* folder:

    ~/java-examples/
      ex1/
        build.gradle
        src/
          main/
            java/
              Ex1.java

build.gradle:

    // Project build script ... cannot be any simpler:
    apply plugin: 'application'
    mainClassName = "Ex1"


Ex1.java:

    /** A most basic class. */
    public class Ex1 {
        public static void main(String[] args) {
            System.out.println("Hello World");
        }
    }

And now, to build and run using the Emacs M-x compile facility is:

    M-x compile
    cd ~/java-examples && gradlew :ex1:run

which will generate the output:

    -*- mode: compilation; default-directory: "~/java-examples/" -*-
    Compilation started at Sat Mar 25 04:03:35

    cd ~/java-examples && gradle ex1:run
    Starting a new Gradle Daemon for this build (subsequent builds will be faster).
    Parallel execution with configuration on demand is an incubating feature.
    :ex1:compileJava UP-TO-DATE
    :ex1:processResources UP-TO-DATE
    :ex1:classes UP-TO-DATE
    :ex1:run
    Hello World

    BUILD SUCCESSFUL

    Total time: 2.882 secs

    Compilation finished at Sat Mar 25 04:03:39

And away you go...
