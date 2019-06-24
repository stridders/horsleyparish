name := """horsleyparish"""
version := "1.0-SNAPSHOT"
PlayKeys.externalizeResources := false

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  javaJdbc,
  guice,
  javaWs,
  javaJpa,
  evolutions,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final",
  "org.postgresql" % "postgresql" % "9.4-1206-jdbc42",
  "javax.mail" % "mail" % "1.4.1",
  "com.google.inject" % "guice" % "4.0",
  "com.jayway.jsonpath" % "json-path" % "2.0.0",
  "com.google.apis" % "google-api-services-drive" % "v3-rev76-1.22.0",
  "com.google.oauth-client" % "google-oauth-client-jetty" % "1.22.0",
  "com.google.api-client" % "google-api-client" % "1.22.0"
)

javaOptions in Test ++= Seq("-Dlogger.resource=logback-test.xml", "-Dconfig.file=conf/test.conf")

testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")

routesGenerator := InjectedRoutesGenerator
