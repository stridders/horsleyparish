
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/js/Documents/workspace/repositories/HorsleyParish/conf/routes
// @DATE:Mon Dec 11 08:37:25 GMT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
