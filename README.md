# xsbt env set

# config plugins.sbt

    addSbtPlugin("com.scalaone" % "xsbt-profile" % "1.2.0")

# build.sbt config

    enablePlugins(ProfilePlugin)

# Change log

## Release 1.2.0

     rename Plugin to ProfilePlugin
     change to sbt AutoPlugin

## Release 1.1.1

     add config -Dextra=extra.properties, include extra properties
     add config -Ddev.p1 = 1, add inline properties to profile.conf
