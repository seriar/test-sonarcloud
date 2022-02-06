import cats.implicits._
import com.monovore.decline._

object App extends CommandApp(
  name = "md-gh-linker",
  header = "Formats the links for github issues by number",
  main = {
    val repoOpt = Opts.option[String]("repo", short = "r", help = "Set name of the repository")
    val userOpt = Opts.option[String]("user", short = "u", help = "Set user name")

    (repoOpt, userOpt).mapN { (repo, user) =>
      new App(user, repo).start()
    }
  }
)

class App(user: String, repo: String) {
  def start(): Unit = {
    var exit: Boolean = false
    while (!exit) {
      val input = scala.io.StdIn.readLine("Provide issue id (or q to exit):")
      if (input == "q") {
        exit = true
      } else {
        try {
          println(createGithubLink(input.toInt))
        } catch {
          case _: Exception => println("use `q` or provide issue id to create a link")
        }
      }
    }
  }

  def createGithubLink(id: Int): String = {
    s"[$repo-$id](https://github.com/$user/$repo/issues/$id)"
  }
}