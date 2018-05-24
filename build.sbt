import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.5",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "Hello",
    libraryDependencies += scalaTest % Test,

    mainClass in assembly := Some("example.Hello"),
    assemblyJarName in assembly := "MaramaEditor.jar",
    test in assembly := {}
  )
