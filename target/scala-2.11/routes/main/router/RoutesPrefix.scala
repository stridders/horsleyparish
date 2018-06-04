
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/jstride/Documents/workspace/repository/horsleyparish/conf/routes
// @DATE:Mon Jun 04 20:27:20 BST 2018


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
