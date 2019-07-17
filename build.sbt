name := "userservice"
maintainer := "Yanyi.x.chen@ericsson.com"

version := "1.0"

scalaVersion := "2.12.8"

// These options will be used for *all* versions.
scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-encoding",
  "UTF-8",
  "-Xlint"
)

val catsVersion                     = "0.9.0"
val circeVersion                    = "0.11.1"
val akkaVersion                     = "2.5.23"
val akkaHttpVersion                 = "10.1.3"
val akkaKafkaVersion                = "1.0.4"
val akkaPersistenceCassandraVersion = "0.97"

libraryDependencies ++= Seq(
  "ch.qos.logback"       % "logback-classic"             % "1.2.3",
  "net.logstash.logback" % "logstash-logback-encoder"    % "4.11",
  "org.typelevel"        %% "cats"                       % catsVersion,
  "io.circe"             %% "circe-core"                 % circeVersion,
  "io.circe"             %% "circe-generic"              % circeVersion,
  "io.circe"             %% "circe-parser"               % circeVersion,
  "com.typesafe.akka"    %% "akka-actor"                 % akkaVersion,
  "com.typesafe.akka"    %% "akka-stream"                % akkaVersion,
  "com.typesafe.akka"    %% "akka-slf4j"                 % akkaVersion,
  "com.typesafe.akka"    %% "akka-cluster-tools"         % akkaVersion,
  "com.typesafe.akka"    %% "akka-cluster-sharding"      % akkaVersion,
  "com.typesafe.akka"    %% "akka-persistence"           % akkaVersion,
  "com.typesafe.akka"    %% "akka-persistence-cassandra" % akkaPersistenceCassandraVersion,
  "com.typesafe.akka"    %% "akka-http"                  % akkaHttpVersion,
  "com.typesafe.akka"    %% "akka-stream-kafka"          % akkaKafkaVersion
)
runMain := "info.galudisu.userserivce.Boot"
packageName in Docker := "userservice"
version in Docker := "latest"

enablePlugins(JavaAppPackaging)
