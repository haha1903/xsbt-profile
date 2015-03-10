version := "1.1.0"

sbtPlugin := true

name := "xsbt-profile"

organization := "com.scalaone"

scalacOptions ++= Seq("-deprecation", "-unchecked")

publishTo := {
  if (isSnapshot.value)
    Some("snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")
  else
    Some("releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")
