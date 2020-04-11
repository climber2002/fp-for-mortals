scalaVersion in ThisBuild := "2.12.10" 

scalacOptions in ThisBuild ++= Seq(
  "-language:_",
  "-Ypartial-unification",
  "-Xfatal-warnings"
)

libraryDependencies ++= Seq( 
  "com.github.mpilquist"  %% "simulacrum"   % "0.13.0",
  "org.scalaz"            %% "scalaz-core"  % "7.2.26",
  "com.propensive"        %% "contextual"   % "1.1.0",

  "org.scalatest"         %% "scalatest"    % "3.1.1" % "test"
)
 
addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.7")
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)
addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.2.4")

initialCommands in (Compile, console) := Seq(
  "scalaz._, Scalaz._"
).mkString("import ", ",", "")
