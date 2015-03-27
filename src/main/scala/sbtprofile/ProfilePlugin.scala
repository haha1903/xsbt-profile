package sbtprofile

import java.io.FileInputStream
import java.util.Properties

import sbt.Keys._
import sbt._

import scala.collection.JavaConversions._

object Plugin extends sbt.Plugin {

  object ProfileKeys {
    val setProfile = Def.taskKey[Unit]("Set Profile")
    val profile = Def.settingKey[String]("profile")
  }

  import Plugin.ProfileKeys._

  def setProfileTask = setProfile <<= (classDirectory in Compile, profile) map { (d, v) =>
    val profile = sys.props.getOrElse("profile", v)
    val profileProps = Map("profile" -> profile)
    val extraProps = sys.props.get("extra") match {
      case Some(path) => val props = new Properties()
        val is = new FileInputStream(path)
        props.load(is)
        is.close()
        props.toMap
      case None => Map()
    }
    val inlineProps = sys.props.filterKeys(_.startsWith(s"$profile."))

    val conf = (profileProps ++ extraProps ++ inlineProps).map { case (k, v) =>
      val quoteV = if (shouldQuote(v)) "\"" + v + "\"" else v
      s"$k = $quoteV"
    }.mkString("", "\n", "\n")
    IO.write(d / "profile.conf", conf)
  } runBefore compile

  lazy val profileSettings = inConfig(Compile)(Seq(setProfileTask, profile := "dev"))

  def shouldQuote(s: String) = "(@|:|\\(|\\*|!|=|,|&)".r.findFirstIn(s).isDefined
}
