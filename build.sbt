version := "1.0.0"

sbtPlugin := true

name := "xsbt-profile"

organization := "com.baidu"

scalacOptions ++= Seq("-deprecation", "-unchecked")

publishTo := Some("ma03" at "http://cq01-testing-ma03.vm.baidu.com:8304/archiva/repository/ma/")

credentials += Credentials("Repository Archiva Managed ma Repository", "cq01-testing-ma03.vm.baidu.com", "admin", "!@34QWer")
