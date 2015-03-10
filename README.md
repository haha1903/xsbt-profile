# xsbt env set

# config plugins.sbt

    addSbtPlugin("com.scalaone" % "xsbt-profile" % "1.1.0")

# build.sbt config

    import sbtprofile.Plugin._

    seq(profileSettings: _*)
