name := """rental-parser"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.2"

libraryDependencies += guice
libraryDependencies += "org.jsoup" % "jsoup" % "1.8.3"
libraryDependencies += "com.google.code.gson" % "gson" % "2.8.6"
