ThisBuild / scalaVersion := "2.13.6"
ThisBuild / organization := "com.hamishdickson"

lazy val libs = Seq(
  "org.typelevel" %% "cats-core" % "2.7.0",
  "org.typelevel" %% "cats-laws" % "2.0.0" % Test,
  // "com.github.alexarchambault" %% "scalacheck-shapeless_1.14" % "1.2.3" % Test,
  // "org.scalatest" %% "scalatest" % "3.2.9" % Test
)

lazy val training = (project in file("."))
  .settings(
    name := "training",
    libraryDependencies ++= libs
  )