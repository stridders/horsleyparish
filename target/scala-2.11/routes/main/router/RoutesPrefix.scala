
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/jstride/Documents/workspace/repository/horsleyparish/conf/routes
// @DATE:Thu Feb 23 18:37:11 GMT 2017


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
