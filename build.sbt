name := "TwitchProject"

version := "0.1"

scalaVersion := "2.12.7"


libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.2.11"
libraryDependencies += "com.typesafe.play" %% "play-ahc-ws-standalone" % "1.0.1"
libraryDependencies += "com.typesafe.play" %% "play-ws-standalone-json" % "1.0.1"
libraryDependencies += "com.typesafe.play" %% "play-ws-standalone-xml" % "1.0.1"
libraryDependencies += "com.lihaoyi" %% "requests" % "0.6.5" // sbt
libraryDependencies += "jp.co.bizreach" %% "elastic-scala-httpclient" % "4.0.0"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.3" % Runtime
