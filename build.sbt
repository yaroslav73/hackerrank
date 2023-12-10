val scala3Version = "3.3.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "hackerrank",
    version := "0.1.0",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.12" % Test
  )
