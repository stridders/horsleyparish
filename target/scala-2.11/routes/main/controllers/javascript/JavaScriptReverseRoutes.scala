
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/jstride/Documents/workspace/repository/horsleyparish/conf/routes
// @DATE:Tue Jul 04 20:24:50 BST 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:25
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "glos/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
          }
        
        }
      """
    )
  
  }

  // @LINE:27
  class ReverseWebJarAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.WebJarAssets.at",
      """
        function(file0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "webjars/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file0)})
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseGoogle(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def getFile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Google.getFile",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/google/file/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id0))})
        }
      """
    )
  
    // @LINE:12
    def listDocuments: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Google.listDocuments",
      """
        function(folder0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/google/list" + _qS([(folder0 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("folder", folder0))])})
        }
      """
    )
  
  }

  // @LINE:15
  class ReverseUuidGenerator(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def randomUUID: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UuidGenerator.randomUUID",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/uuid"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def redirect: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.redirect",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:28
    def version: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.version",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "version"})
        }
      """
    )
  
    // @LINE:31
    def anything: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.anything",
      """
        function(stuff0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("stuff", stuff0)})
        }
      """
    )
  
    // @LINE:6
    def untrail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.untrail",
      """
        function(somePath0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("somePath", somePath0) + "/"})
        }
      """
    )
  
    // @LINE:9
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "glos"})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseUser(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def listUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.User.listUsers",
      """
        function(surname0,firstname1,email2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users" + _qS([(surname0 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("surname", surname0)), (firstname1 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("firstname", firstname1)), (email2 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("email", email2))])})
        }
      """
    )
  
    // @LINE:17
    def authenticate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.User.authenticate",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/authentication"})
        }
      """
    )
  
  }

  // @LINE:18
  class ReverseDocument(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def listDocuments: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Document.listDocuments",
      """
        function(doctype0,docgroup1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/documents" + _qS([(doctype0 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("doctype", doctype0)), (docgroup1 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("docgroup", docgroup1))])})
        }
      """
    )
  
    // @LINE:18
    def createDocument: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Document.createDocument",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/documents"})
        }
      """
    )
  
    // @LINE:21
    def listDocumentTypes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Document.listDocumentTypes",
      """
        function(doctype0,role1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/document-types" + _qS([(doctype0 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("doctype", doctype0)), (role1 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("role", role1))])})
        }
      """
    )
  
    // @LINE:20
    def getDocument: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Document.getDocument",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/documents/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id0)})
        }
      """
    )
  
  }


}
