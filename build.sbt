name := "akka-http-sample"
version := "0.0.1"
scalaVersion := "2.11.8"


libraryDependencies ++= {
  val akkaV = "2.4.7"
  val scalaTestV = "3.0.0"
  //  val slickVersion = "3.1.1"
  Seq(
    "com.typesafe.akka" %% "akka-http-core" % akkaV,
    "com.typesafe.akka" %% "akka-http-experimental" % akkaV,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaV,
    "com.typesafe.akka" %% "akka-http-xml-experimental" % akkaV,
    //    "com.typesafe.slick" %% "slick" % slickVersion,
    //    "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",
    //    "org.flywaydb" % "flyway-core" % "3.2.1",

    //    "com.zaxxer" % "HikariCP" % "2.4.5",
    "org.slf4j" % "slf4j-nop" % "1.6.4",

    "org.scalatest" %% "scalatest" % scalaTestV % "test",
    "com.typesafe.akka" %% "akka-http-testkit" % akkaV % "test"
    //    "ru.yandex.qatools.embed" % "postgresql-embedded" % "1.15" % "test"
  )
}