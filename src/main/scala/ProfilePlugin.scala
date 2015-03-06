package sbtprofile

import sbt.Keys._
import sbt._

object Plugin extends sbt.Plugin {

  object ProfileKeys {
    val setProfile = Def.taskKey[Unit]("Set Profile")
    val profile = Def.settingKey[String]("profile")
  }

  import Plugin.ProfileKeys._

  def setProfileTask = setProfile <<= (classDirectory in Compile, profile) map { (d, v) =>
    val profile = sys.props.getOrElse("profile", v)
    IO.write(d / "profile.conf", s"profile = $profile")
  } runBefore compile

  lazy val profileSettings = inConfig(Compile)(Seq(setProfileTask, profile := "dev"))
}