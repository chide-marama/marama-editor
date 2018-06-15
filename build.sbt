import Dependencies._

  
homepage := Some(url("https://github.com/LuneCoding/marama-editor/"))

licenses += "GPLv3" -> url("https://www.gnu.org/licenses/gpl-3.0.html")


lazy val root = (project in file("."))
.
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.5",
      version      := "0.0.1"
    )),
    name := "Marama-Editor",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.spire-math" %% "jawn-parser" % "0.12.1",
    libraryDependencies += "org.spire-math" %% "jawn-ast" % "0.12.1",
      mainClass in assembly := Some("example.Hello"),
    assemblyJarName in assembly := "MaramaEditor.jar",
    test in assembly := {},
    assemblyOption in assembly := (assemblyOption in assembly).value.copy(appendContentHash = true)
  )