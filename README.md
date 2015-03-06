# xsbt env set

# config plugins.sbt

    addSbtPlugin("com.baidu" % "xsbt-profile" % "1.0.0")

# build.sbt config

    import sbtprofile.Plugin._

    seq(profileSettings: _*)
