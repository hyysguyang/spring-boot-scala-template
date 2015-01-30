import sbt.Keys._
import sbt._


object ProjectBuild extends Build {

  import BuildSettings._
  import Dependencies._

  lazy val root = Project("demo", file("."))
    .aggregate(core, integrationTest)
    .settings(basicSettings: _*)
    .settings(noPublishing: _*)

  lazy val core = Project("core", file("core"))
    .settings(projectBuildSettings: _*)
    .settings(webappSettings: _*)
    .settings(libraryDependencies ++=
    SpringBoot.dependencies ++ compile(scalalogging) ++ test(scalatest)
    )
  lazy val integrationTest = Project("integration-test", file("integration-test"))
    .dependsOn(core)
    .configs(IntegrationTest)
    .settings(projectBuildSettings: _*)
    .settings(Defaults.itSettings: _*)
    .settings(fork in IntegrationTest := true)
    .settings(libraryDependencies ++= it(SpringBoot.testing, scalatest) ++ test(SpringBoot.testing, scalatest))
}
