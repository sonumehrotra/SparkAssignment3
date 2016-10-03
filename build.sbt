name := "spark-assignment3"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.11" % "2.0.0",
  "org.apache.spark" % "spark-sql_2.11" % "2.0.0",
  "org.apache.spark" % "spark-streaming_2.11" % "2.0.0",
  "org.scalaj" %% "scalaj-http" % "2.3.0",
  "org.jfarcand" % "wcs" % "1.5",
  "net.liftweb" %% "lift-json" % "2.6"
)

    