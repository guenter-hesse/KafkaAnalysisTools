import Dependencies._

name := "ICPEBenchmarkingKit"

lazy val commonSettings = Seq(
  organization := "org.hpi",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.12.8",
  test in assembly := {},
  logBuffered in test := false,
  parallelExecution in Test := false
)
val flinkVersion = "1.9.0"
val beamVersion = "2.15.0"

lazy val root = (project in file(".")).
  settings(commonSettings).
  aggregate(datasender, util, commons)

lazy val commons = (project in file("tools/commons")).
  settings(commonSettings,
    name := "Commons",
    libraryDependencies ++= pureConfig,
    libraryDependencies ++= logging,
    libraryDependencies ++= csv,
    libraryDependencies ++= testUtils
  )

lazy val datasender = (project in file("tools/datasender")).
  settings(commonSettings,
    name := "DataSender",
    mainClass in assembly := Some("org.hpi.esb.datasender.Main"),
    libraryDependencies ++= kafkaClients
  ).
  dependsOn(util, commons % "test->test;compile->compile")

lazy val util = (project in file("tools/util")).
  settings(commonSettings,
    name := "Util",
    mainClass in(Compile, run) := Some("org.hpi.esb.util.Main"),
    libraryDependencies ++= kafka,
    libraryDependencies ++= json,
    libraryDependencies ++= scopt,
    libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.28"
  ).
  dependsOn(commons % "test->test;compile->compile")

