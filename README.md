# xsbt env set

# config plugins.sbt

    addSbtPlugin("com.scalaone" % "xsbt-profile" % "1.1.1")

# build.sbt config

    import sbtprofile.Plugin._

    seq(profileSettings: _*)


# Change log

## Release 1.1.1

     add config -Dextra=extra.properties, include extra properties
     add config -Ddev.p1 = 1, add inline properties to profile.conf
