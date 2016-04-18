version := "1.2.0"

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

pomExtra := <url>https://github.com/scalaone/xsbt-profile</url>
  <licenses>
    <license>
      <name>BSD-style</name>
      <url>http://www.opensource.org/licenses/bsd-license.php</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:scalaone/xsbt-profile.git</url>
    <connection>scm:git:git@github.com:scalaone/xsbt-profile.git</connection>
  </scm>
  <developers>
    <developer>
      <id>haha1903</id>
      <name>haha1903</name>
      <url>http://scalaone.com</url>
    </developer>
  </developers>
