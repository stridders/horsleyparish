
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/jstride/Documents/workspace/repository/horsleyparish/conf/routes
// @DATE:Tue Jul 04 20:24:50 BST 2017

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:25
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def at(file:String): Call = {
    
      (file: @unchecked) match {
      
        // @LINE:25
        case (file)  =>
          implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
          Call("GET", _prefix + { _defaultPrefix } + "glos/" + implicitly[PathBindable[String]].unbind("file", file))
      
      }
    
    }
  
  }

  // @LINE:27
  class ReverseWebJarAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def at(file:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "webjars/" + implicitly[PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:12
  class ReverseGoogle(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def getFile(id:String): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/google/file/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
    }
  
    // @LINE:12
    def listDocuments(folder:String = null): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/google/list" + queryString(List(if(folder == null) None else Some(implicitly[QueryStringBindable[String]].unbind("folder", folder)))))
    }
  
  }

  // @LINE:15
  class ReverseUuidGenerator(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
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
  
    // @LINE:28
    def version(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "version")
    }
  
    // @LINE:31
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

  // @LINE:16
  class ReverseUser(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def listUsers(surname:String = null, firstname:String = null, email:String = null): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/users" + queryString(List(if(surname == null) None else Some(implicitly[QueryStringBindable[String]].unbind("surname", surname)), if(firstname == null) None else Some(implicitly[QueryStringBindable[String]].unbind("firstname", firstname)), if(email == null) None else Some(implicitly[QueryStringBindable[String]].unbind("email", email)))))
    }
  
    // @LINE:17
    def authenticate(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/authentication")
    }
  
  }

  // @LINE:18
  class ReverseDocument(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def listDocuments(doctype:String = null, docgroup:String = null): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/documents" + queryString(List(if(doctype == null) None else Some(implicitly[QueryStringBindable[String]].unbind("doctype", doctype)), if(docgroup == null) None else Some(implicitly[QueryStringBindable[String]].unbind("docgroup", docgroup)))))
    }
  
    // @LINE:18
    def createDocument(): Call = {
      import ReverseRouteContext.empty
      Call("POST", _prefix + { _defaultPrefix } + "api/documents")
    }
  
    // @LINE:21
    def listDocumentTypes(doctype:String = null, role:String = null): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/document-types" + queryString(List(if(doctype == null) None else Some(implicitly[QueryStringBindable[String]].unbind("doctype", doctype)), if(role == null) None else Some(implicitly[QueryStringBindable[String]].unbind("role", role)))))
    }
  
    // @LINE:20
    def getDocument(id:Long): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "api/documents/" + implicitly[PathBindable[Long]].unbind("id", id))
    }
  
  }


}
