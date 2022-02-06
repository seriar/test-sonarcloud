import sbt._

object Dependencies {

  val cats = "org.typelevel" %% "cats-core" % Versions.cats
  val decline = "com.monovore" %% "decline" % Versions.decline

  val all = Seq (
    cats,
    decline
  )

  object Versions {
    val cats = "2.3.0"
    val decline = "2.2.0"
  }
}
