import sbt._

object MyBuild extends Build {

  lazy val root = Project("root", file(".")) dependsOn(phonebook)
  lazy val phonebook = RootProject(uri("git://github.com/andreafey/phonebook.git#v0.9"))

}
