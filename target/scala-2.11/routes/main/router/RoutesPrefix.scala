
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/js/Documents/workspace/repositories/HorsleyParish/conf/routes
// @DATE:Tue May 30 21:10:52 BST 2017


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
