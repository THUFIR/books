/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java project to get you started.
 * For more details take a look at the Java Quickstart chapter in the Gradle
 * user guide available at https://docs.gradle.org/5.0/userguide/tutorial_java_projects.html
 */

plugins {
    // Apply the java plugin to add support for Java
    java

    // Apply the application plugin to add support for building an application
    application
}

repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    // This dependency is found on compile classpath of this component and consumers.
    implementation("com.google.guava:guava:26.0-jre")



    compile (group = "org.ccil.cowan.tagsoup"  , name = "tagsoup"     , version = "1.2.1")
    compile (group = "net.sf.saxon"            , name = "Saxon-HE"    , version = "9.9.0-2")
  //  compile (group = "xalan"                   , name = "xalan"       , version = "2.7.2")
 //   compile (group = "xerces"                  , name = "xercesImpl"  , version = "2.12.0")
  //  compile (group = "org.basex"               , name = "basex"       , version = "9.1.1")




    // Use TestNG framework, also requires calling test.useTestNG() below
   // testImplementation("org.testng:testng:6.14.3")
}

application {
    // Define the main class for the application
    mainClassName = "my.books.App"
}

val test by tasks.getting(Test::class) {
    // Use TestNG for unit tests
    useTestNG()
}
