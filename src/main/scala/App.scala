object App {

  def main(args: Array[String]): Unit = {
    println("Starting...")
    ArgsHandler.createApp(args) match {
      case Some(app) => app.start()
      case None => println("Error!")
    }

  }
}

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