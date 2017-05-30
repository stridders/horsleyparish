
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/jstride/Documents/workspace/repository/horsleyparish/conf/routes
// @DATE:Tue May 30 17:35:53 BST 2017

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:22
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def at(file:String): Call = {
    
      (file: @unchecked) match {
      
        // @LINE:22
        case (file)  =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
          Call("GET", _prefix + { _defaultPrefix } + "glos/" + implicitly[PathBindable[String]].unbind("file", file))
      
      }
    
    }
  
  }

  // @LINE:24
  class ReverseWebJarAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def at(file:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "webjars/" + implicitly[PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:12
  class ReverseUuidGenerator(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def randomUUID(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/uuid")
    }
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def redirect(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
    // @LINE:25
    def version(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "version")
    }
  
    // @LINE:28
    def anything(stuff:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("stuff", stuff))
    }
  
    // @LINE:6
    def untrail(somePath:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("somePath", somePath) + "/")
    }
  
    // @LINE:9
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "glos")
    }
  
  }

  // @LINE:13
  class ReverseUser(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def listUsers(surname:String = null, firstname:String = null, email:String = null): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users" + queryString(List(if(surname == null) None else Some(implicitly[QueryStringBindable[String]].unbind("surname", surname)), if(firstname == null) None else Some(implicitly[QueryStringBindable[String]].unbind("firstname", firstname)), if(email == null) None else Some(implicitly[QueryStringBindable[String]].unbind("email", email)))))
    }
  
    // @LINE:14
    def authenticate(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/authentication")
    }
  
  }

  // @LINE:15
  class ReverseDocument(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def listDocuments(doctype:String = null, docgroup:String = null): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/documents" + queryString(List(if(doctype == null) None else Some(implicitly[QueryStringBindable[String]].unbind("doctype", doctype)), if(docgroup == null) None else Some(implicitly[QueryStringBindable[String]].unbind("docgroup", docgroup)))))
    }
  
    // @LINE:15
    def createDocument(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/documents")
    }
  
    // @LINE:18
    def listDocumentTypes(doctype:String = null, role:String = null): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/document-types" + queryString(List(if(doctype == null) None else Some(implicitly[QueryStringBindable[String]].unbind("doctype", doctype)), if(role == null) None else Some(implicitly[QueryStringBindable[String]].unbind("role", role)))))
    }
  
    // @LINE:17
    def getDocument(id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/documents/" + implicitly[PathBindable[Long]].unbind("id", id))
    }
  
  }


}
