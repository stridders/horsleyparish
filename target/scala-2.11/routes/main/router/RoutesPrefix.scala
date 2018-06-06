
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/js/Documents/workspace/repositories/HorsleyParish/conf/routes
// @DATE:Wed Jun 06 07:44:49 BST 2018


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
