import Dependencies._

  
homepage := Some(url("https://github.com/LuneCoding/marama-editor/"))

licenses += "GPLv3" -> url("https://www.gnu.org/licenses/gpl-3.0.html")


lazy val root = (project in file(".")) // .enablePlugins(DockerPlugin)
.
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.5",
      version      := "0.0.1"
    )),
    name := "Marama-Editor",
    libraryDependencies += scalaTest % Test,

    mainClass in assembly := Some("example.Hello"),
    assemblyJarName in assembly := "MaramaEditor.jar",
    test in assembly := {}
  )


  // Define a Dockerfile
//dockerfile in docker := {
  //val jarFile = Keys.`package`.in(Compile, packageBin).value
 // val classpath = (managedClasspath in Compile).value
 // val mainclass = mainClass.in(Compile, packageBin).value.get
 // val libs = "/app/libs"
//  val jarTarget = "/app/" + jarFile.name
//  val SBT_Version = "1.1.2"
//  val SBT_JAR   =   https://repo.typesafe.com/typesafe/ivy-releases/org.scala-sbt/sbt-launch/$SBT_VERSION/sbt-launch.jar

  

//  new Dockerfile {
//    // Use a base image that contain Java
//    from("openjdk:8-nanoserver ")
    // Expose port 8080
//    expose(8080)
//	cmd("touch",  "/usr/lib/jvm/java-8-openjdk-amd64/release")

    // Copy all dependencies to 'libs' in the staging directory
//    classpath.files.foreach { depFile =>
//      val target = file(libs) / depFile.name
//      stageFile(depFile, target)
//    }
    // Add the libs dir from the
//    addRaw(libs, libs)

    // Add the generated jar file
//    add(jarFile, jarTarget)
    // The classpath is the 'libs' dir and the produced jar file
//    val classpathString = s"$libs/*:$jarTarget"
    // Set the entry point to start the application using the main class
//    cmd("java", "-cp", classpathString, mainclass)
//  }
//}

