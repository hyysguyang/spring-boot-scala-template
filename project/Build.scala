import sbt.Keys._
import sbt._


object ProjectBuild extends Build {

  import BuildSettings._
  import Dependencies._

  lazy val root = Project("lifecosys-customer-assistant", file("."))
    .aggregate(core)
    .settings(basicSettings: _*)
    .settings(noPublishing: _*)

  lazy val core = Project("core", file("core"))
    .settings(projectBuildSettings: _*)
    .settings(libraryDependencies ++=
    SpringBoo.dependencies ++ compile(scalalogging) ++ test(scalatest)
    )

}
