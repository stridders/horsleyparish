name := """horsleyparish"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.google.inject" % "guice" % "3.0",
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "org.postgresql" % "postgresql" % "9.3-1102-jdbc4",
  "com.typesafe.slick" %% "slick" % "2.1.0",
  "com.theoryinpractise" % "halbuilder-core" % "4.0.3",
  "com.theoryinpractise" % "halbuilder-json" % "4.0.2",
  "com.theoryinpractise" % "halbuilder-api" % "4.0.1",
  "com.theoryinpractise" % "halbuilder-standard" % "4.0.1",
  "com.google.inject" % "guice" % "4.0",
  "org.specs2" %% "specs2" % "2.3.11" % "test",
  "org.scalatest" %% "scalatest" % "2.1.5" % "test",
  "org.webjars" %% "webjars-play" % "2.5.0",
  "org.webjars" % "jquery" % "3.1.1",
  "org.webjars" % "bootstrap" % "3.3.6" exclude("org.webjars", "jquery"),
  "org.webjars" % "angularjs" % "1.5.5" exclude("org.webjars", "jquery"),
  "org.webjars.npm" % "angular-animate" % "1.5.8",
  "org.webjars.npm" % "angular-aria" % "1.5.8",
  "org.webjars.npm" % "angular-messages" % "1.5.8",
  "org.webjars" % "angular-material" % "1.1.1",
  "org.webjars" % "angular-ui-bootstrap" % "1.3.2" exclude("org.webjars", "jquery")
)
