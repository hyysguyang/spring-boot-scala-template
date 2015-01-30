
import com.typesafe.sbt.SbtScalariform._
import sbt.Keys._
import sbt._

object BuildSettings {
  val VERSION = "0.0.1-SNAPSHOT"

  val lifecycle=addCommandAlias("install", ";test;it:test;publishLocal") ++ addCommandAlias("testing", ";test;it:test")

  val basicSettings = Defaults.coreDefaultSettings ++ lifecycle ++ Seq(
    version := VERSION,
    homepage := Some(new URL("https://demo.com/developer/demo-customer-assistant")),
    organization := "com.demo",
    organizationHomepage := Some(new URL("https://demo.com")),
    description := "demo customer assistant.",
    startYear := Some(2015),
    scalaVersion := "2.11.4",
    scalacOptions := Seq(
      "-encoding", "utf8",
      "-feature",
      "-unchecked",
      "-deprecation",
      "-target:jvm-1.6",
      "-language:postfixOps",
      "-language:implicitConversions",
      "-Xlog-reflective-calls"
    )
  )

  import net.virtualvoid.sbt.graph.Plugin._

  lazy val projectBuildSettings = basicSettings ++ formattingSettings ++ graphSettings ++
    Seq(
      publishMavenStyle := true
    )

  lazy val noPublishing = seq(
    publish :=(),
    publishLocal :=()
  )

  import com.earldouglas.xwp.XwpPlugin._
  lazy val webappSettings = jetty()

  lazy val siteSettings = basicSettings ++ formattingSettings ++ noPublishing

  lazy val docsSettings = basicSettings ++ noPublishing ++ seq(
    unmanagedSourceDirectories in Test <<= baseDirectory {
      _ ** "code" get
    }
  )

  import scalariform.formatter.preferences._

  val formattingSettings = scalariformSettings ++ Seq(
    ScalariformKeys.preferences := ScalariformKeys.preferences.value
      .setPreference(RewriteArrowSymbols, true)
      .setPreference(AlignParameters, true)
      .setPreference(AlignSingleLineCaseStatements, true)
      .setPreference(DoubleIndentClassDeclaration, true)
      .setPreference(PreserveDanglingCloseParenthesis, true))


}