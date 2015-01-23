import sbt._

object Dependencies {


  def compile(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "compile")

  def provided(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "provided")

  def test(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "test")

  def runtime(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "runtime")

  def container(deps: ModuleID*): Seq[ModuleID] = deps map (_ % "container")


  object SpringBoot {
    val springBootVersion = "1.2.1.RELEASE"

    lazy val dependencies = compile(security, aop, jdbc, dataJpa, solr,
      batch, integration, web, websocket, ws, dataRest, mobile, thymleaf,
      socialFacebook, socialLinkedin, socialTwitter, actuator, remoteShell) ++
      provided(jetty) ++
      test(testing)

    val security = "org.springframework.boot" % "spring-boot-starter-security" % springBootVersion
    val aop = "org.springframework.boot" % "spring-boot-starter-aop" % springBootVersion
    val jdbc = "org.springframework.boot" % "spring-boot-starter-jdbc" % springBootVersion
    val dataJpa = "org.springframework.boot" % "spring-boot-starter-data-jpa" % springBootVersion
    val solr = "org.springframework.boot" % "spring-boot-starter-data-solr" % springBootVersion
    val batch = "org.springframework.boot" % "spring-boot-starter-batch" % springBootVersion
    val integration = "org.springframework.boot" % "spring-boot-starter-integration" % springBootVersion
    val web = "org.springframework.boot" % "spring-boot-starter-web" % springBootVersion
    val websocket = "org.springframework.boot" % "spring-boot-starter-websocket" % springBootVersion
    val ws = "org.springframework.boot" % "spring-boot-starter-ws" % springBootVersion
    val dataRest = "org.springframework.boot" % "spring-boot-starter-data-rest" % springBootVersion
    val mobile = "org.springframework.boot" % "spring-boot-starter-mobile" % springBootVersion
    val thymleaf = "org.springframework.boot" % "spring-boot-starter-thymeleaf" % springBootVersion
    val socialFacebook = "org.springframework.boot" % "spring-boot-starter-social-facebook" % springBootVersion
    val socialLinkedin = "org.springframework.boot" % "spring-boot-starter-social-linkedin" % springBootVersion
    val socialTwitter = "org.springframework.boot" % "spring-boot-starter-social-twitter" % springBootVersion
    val actuator = "org.springframework.boot" % "spring-boot-starter-actuator" % springBootVersion
    val remoteShell = "org.springframework.boot" % "spring-boot-starter-remote-shell" % springBootVersion
    val jetty = "org.springframework.boot" % "spring-boot-starter-jetty" % springBootVersion


    val testing = "org.springframework.boot" % "spring-boot-starter-test" % springBootVersion
  }


  val scalalogging = "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"

  val scalatest = "org.scalatest" % "scalatest_2.11" % "2.2.1"


}
