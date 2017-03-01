
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/js/Documents/workspace/repositories/HorsleyParish/conf/routes
// @DATE:Fri Feb 24 18:04:28 GMT 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:22
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "web/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file1)})
          }
        
        }
      """
    )
  
  }

  // @LINE:24
  class ReverseWebJarAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
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
  class ReverseUuidGenerator(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
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
  
    // @LINE:25
    def version: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.version",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "version"})
        }
      """
    )
  
    // @LINE:28
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
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "web"})
        }
      """
    )
  
  }

  // @LINE:13
  class ReverseUser(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def listUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.User.listUsers",
      """
        function(surname0,firstname1,email2) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/users" + _qS([(surname0 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("surname", surname0)), (firstname1 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("firstname", firstname1)), (email2 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("email", email2))])})
        }
      """
    )
  
    // @LINE:14
    def authenticate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.User.authenticate",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/authentication"})
        }
      """
    )
  
  }

  // @LINE:15
  class ReverseDocument(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def listDocuments: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Document.listDocuments",
      """
        function(doctype0,docgroup1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/documents" + _qS([(doctype0 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("doctype", doctype0)), (docgroup1 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("docgroup", docgroup1))])})
        }
      """
    )
  
    // @LINE:15
    def createDocument: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Document.createDocument",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/documents"})
        }
      """
    )
  
    // @LINE:18
    def listDocumentTypes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Document.listDocumentTypes",
      """
        function(doctype0,role1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/document-types" + _qS([(doctype0 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("doctype", doctype0)), (role1 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("role", role1))])})
        }
      """
    )
  
    // @LINE:17
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
