import sbt._
import Keys._
import play.Project._

import sbt._
import Keys._
import play.Project._

object Resolvers {
  lazy val nexusSnapshots        = "Sonatype Nexus Repository Manager Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  lazy val sprayIoReleases       = "Spray IO Release Repo" at "http://repo.spray.io"
  lazy val typesafeReleases      = "Typesafe Releases Repository"  at "http://repo.typesafe.com/typesafe/releases/"
  lazy val typesafeSnapshots     = "Typesafe Snapshots Repository" at "http://repo.typesafe.com/typesafe/snapshots/"
  lazy val typesafeResolvers     = Seq(typesafeReleases, typesafeSnapshots, sprayIoReleases, nexusSnapshots)

  lazy val sunRepo               = "Sun Maven2 Repo"               at "http://download.java.net/maven/2"
  lazy val glassfishRepo         = "Sun GF Maven2 Repo"            at "http://download.java.net/maven/glassfish"
  lazy val oracleRepo            = "Oracle Maven2 Repo"            at "http://download.oracle.com/maven"
  lazy val oracleResolvers       = Seq(sunRepo, oracleRepo)

  lazy val springRelease         = "EBR Spring Release Repository" at "http://repository.springsource.com/maven/bundles/release"
  lazy val springExternalRelease = "EBR Spring External Release"   at "http://repository.springsource.com/maven/bundles/external"
  lazy val springMilestoneRepo   = "Spring Milestone Repository"   at "https://repo.springsource.org/libs-milestone"
  lazy val springAppResolvers    = Seq(springRelease, springExternalRelease, springMilestoneRepo)

  lazy val jBossRepo             = "JBoss Public Maven Repo"       at "https://repository.jboss.org/nexus/content/groups/public-jboss/"

  lazy val allResolvers          = typesafeResolvers ++ springAppResolvers ++ oracleResolvers ++ Seq(jBossRepo)
}

object Versions {
  lazy val scalaVer  = "2.10.4"
  lazy val akkaVer   = "2.1.0"
  lazy val springVer = "3.1.2.RELEASE"

  lazy val playVer       = play.core.PlayVersion.current
  lazy val junitVer      = "4.10"
  lazy val junitVer      = "4.10"
  lazy val scalaTestVer  = "2.1.0"
  lazy val scalaCheckVer = "1.10.1"
  lazy val scalazVer     = "7.0.0"
  lazy val scalazVer     = "7.0.0"
  lazy val scalaStmVer   = "0.6"

}

// Add your project dependencies here,
object Dependencies {
  import Versions._
  
  lazy val provided = "provided"
  lazy val test     = "test"
  lazy val runtime  = "runtime"

  lazy val junit                = "junit"            %  "junit"           % junitVer      % test
  lazy val mockito              = "org.mockito"      %  "mockito-core"    % "1.9.5"       % test
  lazy val scalaCheck           = "org.scalacheck"   %% "scalacheck"      % scalaCheckVer % test
  lazy val scalaTest            = "org.scalatest"    %% "scalatest"       % scalaTestVer  % test
  lazy val testDependencies     = Seq(junit, scalaTest, scalaCheck, mockito)

  lazy val akkaOrg              = "com.typesafe.akka"
  lazy val akkaPersistArt       = "akka-persistence-experimental"

  lazy val akkaActor            = akkaOrg            %% "akka-actor"      % akkaVer
  lazy val akkaTestkit          = akkaOrg            %% "akka-testkit"    % akkaVer  % test
  lazy val akkaRemote           = akkaOrg            %% "akka-remote"     % akkaVer
  lazy val akkaSlf4j            = akkaOrg            %% "akka-slf4j"      % akkaVer
  lazy val akkaCamel            = akkaOrg            %% "akka-camel"      % akkaVer
  lazy val akkaPersistence      = akkaOrg            %% akkaPersistArt    % akkaVer
  
  lazy val akkaDependencies     = Seq(akkaActor, akkaTestkit, akkaRemote, akkaSlf4j, akkaCamel)

  lazy val springOrg            = "org.springframework"
  lazy val springScalaOrg       = springOrg + ".scala"
  lazy val javaxInject          = "javax.inject"      % "javax.inject"                    % "1"
  lazy val springAsm            = springOrg           % "org.springframework.asm"         % springVer
  lazy val springAop            = springOrg           % "org.springframework.aop"         % springVer
  lazy val springBeans          = springOrg           % "org.springframework.beans"       % springVer
  lazy val springCore           = springOrg           % "org.springframework.core"        % springVer
  lazy val springContext        = springOrg           % "org.springframework.context"     % springVer
  lazy val springExpression     = springOrg           % "org.springframework.expression"  % springVer
  lazy val springTxn            = springOrg           % "org.springframework.transaction" % springVer
  lazy val springOrm            = springOrg           % "org.springframework.orm"         % springVer
  lazy val springScala          = springScalaOrg      % "spring-scala"                    % "1.0.0.M2"
  
  lazy val springDependencies   = Seq(javaxInject, springBeans, springCore, springContext, springScala)

  lazy val rxScala        = "com.netflix.rxjava"     %  "rxjava-scala"   % "0.14.6"
  lazy val scalaAsync     = "org.scala-lang.modules" %% "scala-async"    % "0.9.0-M2"
  lazy val squeryl        = "org.squeryl"            %% "squeryl"        % "0.9.5-6"
  lazy val utilDependencies = Seq(rxScala, scalaAsync, squeryl)

  lazy val basicDependencies    = testDependencies ++ springDependencies
}

object ApplicationBuild extends Build {
  import Resolvers._
  import Dependencies._
  import Versions._
  
  lazy val appName         = "play-eventsourced"
  lazy val appVersion      = "1.0-SNAPSHOT"

  lazy val appDependencies = Seq(jdbc, anorm) ++ basicDependencies

  lazy val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
    scalaVersion := scalaVer,
    resolvers ++= allResolvers
  )

}
