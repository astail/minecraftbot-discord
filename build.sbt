organization := "net.astail"

name := "minecraftbot-discord"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.8"

resolvers += Resolver.JCenterRepository

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.3",
  "ch.qos.logback" % "logback-classic" % "1.2.1",
  "org.slf4j" % "slf4j-api" % "1.7.12",
  "net.katsstuff" %% "ackcord" % "0.14.0",
  "net.katsstuff" %% "ackcord-core" % "0.14.0",
  "net.katsstuff" %% "ackcord-commands-core" % "0.14.0",
  "net.katsstuff" %% "ackcord-lavaplayer-core" % "0.14.0"
)
