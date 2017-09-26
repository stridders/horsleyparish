name := """horsleyparish"""
version := "1.0-SNAPSHOT"
PlayKeys.externalizeResources := false

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  javaJdbc,
  javaWs,
  javaJpa,
  evolutions,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final",
  "org.postgresql" % "postgresql" % "9.4-1206-jdbc42",
  "javax.mail" % "mail" % "1.4.1",
  "com.google.inject" % "guice" % "4.0",
  "org.specs2" %% "specs2" % "2.3.11" % "test",
  "org.scalatest" %% "scalatest" % "2.1.5" % "test",
  "org.webjars" %% "webjars-play" % "2.5.0",
  "org.webjars.npm" % "jquery" % "2.2.4",
  "org.webjars" % "bootstrap" % "3.3.6" exclude("org.webjars", "jquery"),
  "org.webjars" % "angularjs" % "1.5.9" exclude("org.webjars", "jquery"),
  "org.webjars" % "angular-filter" % "0.4.9",
  "org.webjars" % "angular-ui-router" % "0.2.18",
  "org.webjars.npm" % "angular-animate" % "1.5.6",
  "org.webjars.npm" % "angular-aria" % "1.5.6",
  "org.webjars.npm" % "angular-messages" % "1.5.6",
  "org.webjars" % "angular-material" % "1.1.1",
  "org.webjars.npm" % "angular-route" % "1.5.6",
  "org.webjars" % "angular-ui-bootstrap" % "1.3.2" exclude("org.webjars", "jquery"),
  "org.webjars.npm" % "angular-cookies" % "1.5.6",
  "com.jayway.jsonpath" % "json-path" % "2.0.0",
  "org.webjars.npm" % "angular-ui-calendar" % "1.0.2",
  "org.webjars" % "momentjs" % "2.17.1",
  "org.webjars.bower" % "postscribe" % "1.4.0",
  "com.google.apis" % "google-api-services-drive" % "v3-rev76-1.22.0",
  "com.google.oauth-client" % "google-oauth-client-jetty" % "1.22.0",
  "com.google.api-client" % "google-api-client" % "1.22.0",
  "org.webjars" % "d3js" % "4.10.2"
)

javaOptions in Test ++= Seq("-Dlogger.resource=logback-test.xml", "-Dconfig.file=conf/test.conf")

testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")

routesGenerator := InjectedRoutesGenerator
