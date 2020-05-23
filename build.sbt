ThisBuild/version := "0.0.7snap"
name := "OpenStrat"
ThisBuild/scalaVersion := "2.13.2"
ThisBuild/organization := "OpenStratOrg"
ThisBuild/autoAPIMappings := true

def commonSettings = List(
  scalacOptions ++= Seq("-feature", "-language:higherKinds,implicitConversions", "-deprecation", "-Ywarn-value-discard", "-target:jvm-1.8", "-encoding", "UTF-8", "-unchecked", "-Xlint"),
  libraryDependencies += scalaOrganization.value % "scala-reflect" % scalaVersion.value,
  libraryDependencies += "com.lihaoyi" %% "utest" % "0.7.2" % "test",
  testFrameworks += new TestFramework("utest.runner.Framework"), 
)

def stdSettings(name: String) = commonSettings ::: List(
  scalaSource := (ThisBuild/baseDirectory).value / name / "/src",
  Compile/scalaSource := (ThisBuild/baseDirectory).value / name / "/src",
  resourceDirectory := (ThisBuild/baseDirectory).value / name / "/res",
  Test/scalaSource := (ThisBuild/baseDirectory).value / name / "test/src",
  Test/unmanagedSourceDirectories := List((Test/scalaSource).value, (ThisBuild/baseDirectory).value / name / "learn/src"),
  Test/resourceDirectory :=  (ThisBuild/baseDirectory).value / name / "test/res",
  Test/unmanagedResourceDirectories := List((Test/resourceDirectory).value),
  version := (ThisBuild/version).value
)

lazy val UtilMacros = Project("UtilMacros", file("target/JvmUtilMacros")).settings(commonSettings).settings(
  scalaSource := (ThisBuild/baseDirectory).value / "Util/Macros/src",
  Compile/scalaSource := (ThisBuild/baseDirectory).value / "Util/Macros/src",
  Compile/unmanagedSourceDirectories := List(scalaSource.value),
  Test/scalaSource :=  (ThisBuild/baseDirectory).value / "Util/Macros/test/src",
  Test/unmanagedSourceDirectories := List((Test/scalaSource).value),
)

def stdJvmProj(name: String) = Project(name, file("target/Jvm" + name)).settings(stdSettings(name))

lazy val Util = stdJvmProj("Util").dependsOn(UtilMacros).settings(
  Compile/unmanagedSourceDirectories := List(scalaSource.value),	
)

lazy val Graphic = stdJvmProj("Graphic").dependsOn(Util).settings(
  Compile/unmanagedSourceDirectories := List("src").map(str => (ThisBuild/baseDirectory).value / "Graphic" / str),  
)

lazy val Tiling = stdJvmProj("Tiling").dependsOn(Graphic).settings(
  Compile/unmanagedSourceDirectories := List("src").map(str => (ThisBuild/baseDirectory).value / "Tiling" / str),  
)

lazy val Strat = stdJvmProj("Strat").dependsOn(Tiling).settings(
  Compile/unmanagedSourceDirectories := List("src", "jvm/src").map(str => (ThisBuild/baseDirectory).value / "Strat" / str),
  assemblyJarName in assembly := "strat" + (ThisBuild/version).value + ".jar"
)

lazy val Dev = stdJvmProj("Dev").dependsOn(Strat).enablePlugins(ScalaUnidocPlugin).settings(commonSettings).settings(
  
  Compile/unmanagedSourceDirectories := List("Dev/src", "Dev/jvm/src", "Strat/learn/src", "Tiling/learn/src", "Graphic/learn/src").map(s => (ThisBuild/baseDirectory).value / s),
  Compile/unmanagedResourceDirectories := List(resourceDirectory.value, (ThisBuild/baseDirectory).value / "Dev/User"),
  Compile/mainClass	:= Some("ostrat.pFx.DevApp"),
  libraryDependencies += "org.openjfx" % "javafx-controls" % "13",
)

val docDirs: List[String] = List("Util", "Graphic", "Tiling", "Strat", "Dev")

lazy val DocMain = (project in file("target/DocMain")).dependsOn(UtilMacros).settings(commonSettings).settings(
  name := "OpenStrat",
  Compile/unmanagedSourceDirectories := docDirs.flatMap(el => List(el + "/src", el + "/jvm/src", el + "/learn/src")).map(s => (ThisBuild/baseDirectory).value / s),
  version := "0.0.7snap",
  autoAPIMappings := true,
  apiURL := Some(url("https://richstrat.com/api/")),
  libraryDependencies += "org.openjfx" % "javafx-controls" % "13",
)

lazy val DocJs = (project in file("target/DocJs")).dependsOn(JsUtilMacros).settings(commonSettings).settings(
  name := "OpenStrat",
  Compile/unmanagedSourceDirectories := docDirs.flatMap(el => List(el + "/src", el + "/js/src", el + "/learn/src")).map(s => (ThisBuild/baseDirectory).value / s),
  version := "0.0.7snap",
  autoAPIMappings := true,
  apiURL := Some(url("https://richstrat.com/api/")),
)

def jsProj(name: String) = Project("Js" + name, file("target/Js" + name)).enablePlugins(ScalaJSPlugin).settings(commonSettings).settings(
  libraryDependencies += scalaOrganization.value % "scala-reflect" % scalaVersion.value, 
  libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "1.0.0",
  scalaSource := (ThisBuild/baseDirectory).value / name / "src",
)

lazy val JsUtilMacros = jsProj("UtilMacros").settings(
  scalaSource := (ThisBuild/baseDirectory).value / "Util/Macros/src",
  Compile/unmanagedSourceDirectories := List(scalaSource.value),
)

lazy val JsUtil = jsProj("Util").dependsOn(JsUtilMacros).settings(  
  Compile/unmanagedSourceDirectories := List(scalaSource.value),
)

lazy val JsGraphic = jsProj("Graphic").dependsOn(JsUtil).settings(  
  Compile/unmanagedSourceDirectories := List("Graphic/src", "Graphic/js/src").map(s => (ThisBuild/baseDirectory).value / s)
)

lazy val JsTiling = jsProj("Tiling").dependsOn(JsGraphic).settings(  
  Compile/unmanagedSourceDirectories := List("Tiling/src", "Tiling/js/src").map(s => (ThisBuild/baseDirectory).value / s)
)

lazy val JsStrat = jsProj("Strat").dependsOn(JsTiling).settings(  
  Compile/unmanagedSourceDirectories := List("Strat/src", "Strat/js/src").map(s => (ThisBuild/baseDirectory).value / s)
)

lazy val JsDev = jsProj("Dev").dependsOn(JsStrat).settings(  
  Compile/unmanagedSourceDirectories := List("Dev/src", "Dev/js/src", "Graphic/learn/src", "Strat/learn/src").map(s => (ThisBuild/baseDirectory).value / s),
)

def dottySettings = List(
	scalaVersion := "0.24.0-RC1",
  resolvers += Resolver.url("typesafe", url("http://repo.typesafe.com/typesafe/ivy-releases/"))(Resolver.ivyStylePatterns),
  scalacOptions ++= Seq("-feature", "-language:higherKinds,implicitConversions", "-deprecation", "-Ywarn-value-discard", "-target:jvm-1.8", "-encoding", "UTF-8", "-unchecked", "-Xlint"),
)

/*lazy val DotMacros = Project("DotModule", file("target/DotModule")).settings(dottySettings).settings(  
  scalaSource := (ThisBuild/baseDirectory).value / "Util/Macros/srcDot",
  Compile/scalaSource := (ThisBuild/baseDirectory).value / "Util/Macros/srcDot",
  Compile/unmanagedSourceDirectories := List(scalaSource.value),
  Test/scalaSource :=  (ThisBuild/baseDirectory).value / "Util/Macros/test/srcDot",
  Test/unmanagedSourceDirectories := List((Test/scalaSource).value),  
)

lazy val DotUtil = Project("DotUtil", file("target/DotUtil")).dependsOn(DotMacros).settings(dottySettings).settings(
  scalaSource := (ThisBuild/baseDirectory).value / "Util/src",
  Compile/scalaSource := (ThisBuild/baseDirectory).value / "Util/src",
  Compile/unmanagedSourceDirectories := List(scalaSource.value),
  Test/scalaSource :=  (ThisBuild/baseDirectory).value / "Util/test/src",
  Test/unmanagedSourceDirectories := List((Test/scalaSource).value),
)*/