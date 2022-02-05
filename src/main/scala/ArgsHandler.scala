object ArgsHandler {

  def validateArgs(args: Array[String]): Boolean = {
    args.length == 2
  }

  def createApp(args: Array[String]): Option[App] = {
    if (validateArgs(args)) {
      Some(new App(args.head, args.tail.head))
    } else {
      None
    }
  }

}
