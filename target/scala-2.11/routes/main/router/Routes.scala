
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/js/Documents/workspace/repositories/HorsleyParish/conf/routes
// @DATE:Wed Jun 06 07:44:49 BST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_6: controllers.Application,
  // @LINE:12
  Google_0: controllers.Google,
  // @LINE:15
  UuidGenerator_1: controllers.UuidGenerator,
  // @LINE:16
  User_3: controllers.User,
  // @LINE:18
  Document_2: controllers.Document,
  // @LINE:25
  Assets_4: controllers.Assets,
  // @LINE:27
  WebJarAssets_5: controllers.WebJarAssets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_6: controllers.Application,
    // @LINE:12
    Google_0: controllers.Google,
    // @LINE:15
    UuidGenerator_1: controllers.UuidGenerator,
    // @LINE:16
    User_3: controllers.User,
    // @LINE:18
    Document_2: controllers.Document,
    // @LINE:25
    Assets_4: controllers.Assets,
    // @LINE:27
    WebJarAssets_5: controllers.WebJarAssets
  ) = this(errorHandler, Application_6, Google_0, UuidGenerator_1, User_3, Document_2, Assets_4, WebJarAssets_5, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_6, Google_0, UuidGenerator_1, User_3, Document_2, Assets_4, WebJarAssets_5, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """somePath<.+>/""", """controllers.Application.untrail(somePath:String)"""),
    ("""GET""", this.prefix, """controllers.Application.redirect()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """glos""", """controllers.Application.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/google/list""", """controllers.Google.listDocuments(folder:String ?= null)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/google/file/""" + "$" + """id<[^/]+>""", """controllers.Google.getFile(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/uuid""", """controllers.UuidGenerator.randomUUID()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users""", """controllers.User.listUsers(surname:String ?= null, firstname:String ?= null, email:String ?= null)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/authentication""", """controllers.User.authenticate()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/documents""", """controllers.Document.createDocument()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/documents""", """controllers.Document.listDocuments(doctype:String ?= null, docgroup:String ?= null)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/documents/""" + "$" + """id<[^/]+>""", """controllers.Document.getDocument(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/document-types""", """controllers.Document.listDocumentTypes(doctype:String ?= null, role:String ?= null)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """glos/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """webjars/""" + "$" + """file<.+>""", """controllers.WebJarAssets.at(file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """version""", """controllers.Application.version()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """stuff<.*>""", """controllers.Application.anything(stuff:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_untrail0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("somePath", """.+""",false), StaticPart("/")))
  )
  private[this] lazy val controllers_Application_untrail0_invoker = createInvoker(
    Application_6.untrail(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "untrail",
      Seq(classOf[String]),
      "GET",
      """ Home page""",
      this.prefix + """""" + "$" + """somePath<.+>/"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_Application_redirect1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_redirect1_invoker = createInvoker(
    Application_6.redirect(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "redirect",
      Nil,
      "GET",
      """""",
      this.prefix + """"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Application_index2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("glos")))
  )
  private[this] lazy val controllers_Application_index2_invoker = createInvoker(
    Application_6.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """glos"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Google_listDocuments3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/google/list")))
  )
  private[this] lazy val controllers_Google_listDocuments3_invoker = createInvoker(
    Google_0.listDocuments(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Google",
      "listDocuments",
      Seq(classOf[String]),
      "GET",
      """GET    /api                           controllers.Root.apiRoot()""",
      this.prefix + """api/google/list"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Google_getFile4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/google/file/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Google_getFile4_invoker = createInvoker(
    Google_0.getFile(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Google",
      "getFile",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """api/google/file/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:15
  private[this] lazy val controllers_UuidGenerator_randomUUID5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/uuid")))
  )
  private[this] lazy val controllers_UuidGenerator_randomUUID5_invoker = createInvoker(
    UuidGenerator_1.randomUUID(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UuidGenerator",
      "randomUUID",
      Nil,
      "GET",
      """""",
      this.prefix + """api/uuid"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_User_listUsers6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users")))
  )
  private[this] lazy val controllers_User_listUsers6_invoker = createInvoker(
    User_3.listUsers(fakeValue[String], fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.User",
      "listUsers",
      Seq(classOf[String], classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """api/users"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_User_authenticate7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/authentication")))
  )
  private[this] lazy val controllers_User_authenticate7_invoker = createInvoker(
    User_3.authenticate(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.User",
      "authenticate",
      Nil,
      "GET",
      """""",
      this.prefix + """api/authentication"""
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Document_createDocument8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/documents")))
  )
  private[this] lazy val controllers_Document_createDocument8_invoker = createInvoker(
    Document_2.createDocument(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Document",
      "createDocument",
      Nil,
      "POST",
      """""",
      this.prefix + """api/documents"""
    )
  )

  // @LINE:19
  private[this] lazy val controllers_Document_listDocuments9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/documents")))
  )
  private[this] lazy val controllers_Document_listDocuments9_invoker = createInvoker(
    Document_2.listDocuments(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Document",
      "listDocuments",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """api/documents"""
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Document_getDocument10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/documents/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Document_getDocument10_invoker = createInvoker(
    Document_2.getDocument(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Document",
      "getDocument",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """api/documents/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:21
  private[this] lazy val controllers_Document_listDocumentTypes11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/document-types")))
  )
  private[this] lazy val controllers_Document_listDocumentTypes11_invoker = createInvoker(
    Document_2.listDocumentTypes(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Document",
      "listDocumentTypes",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """api/document-types"""
    )
  )

  // @LINE:25
  private[this] lazy val controllers_Assets_at12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("glos/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at12_invoker = createInvoker(
    Assets_4.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """glos/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:26
  private[this] lazy val controllers_Assets_at13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at13_invoker = createInvoker(
    Assets_4.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:27
  private[this] lazy val controllers_WebJarAssets_at14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("webjars/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_WebJarAssets_at14_invoker = createInvoker(
    WebJarAssets_5.at(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WebJarAssets",
      "at",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """webjars/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:28
  private[this] lazy val controllers_Application_version15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("version")))
  )
  private[this] lazy val controllers_Application_version15_invoker = createInvoker(
    Application_6.version(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "version",
      Nil,
      "GET",
      """""",
      this.prefix + """version"""
    )
  )

  // @LINE:31
  private[this] lazy val controllers_Application_anything16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("stuff", """.*""",false)))
  )
  private[this] lazy val controllers_Application_anything16_invoker = createInvoker(
    Application_6.anything(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "anything",
      Seq(classOf[String]),
      "GET",
      """Everything else""",
      this.prefix + """""" + "$" + """stuff<.*>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_untrail0_route(params) =>
      call(params.fromPath[String]("somePath", None)) { (somePath) =>
        controllers_Application_untrail0_invoker.call(Application_6.untrail(somePath))
      }
  
    // @LINE:7
    case controllers_Application_redirect1_route(params) =>
      call { 
        controllers_Application_redirect1_invoker.call(Application_6.redirect())
      }
  
    // @LINE:9
    case controllers_Application_index2_route(params) =>
      call { 
        controllers_Application_index2_invoker.call(Application_6.index())
      }
  
    // @LINE:12
    case controllers_Google_listDocuments3_route(params) =>
      call(params.fromQuery[String]("folder", Some(null))) { (folder) =>
        controllers_Google_listDocuments3_invoker.call(Google_0.listDocuments(folder))
      }
  
    // @LINE:13
    case controllers_Google_getFile4_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Google_getFile4_invoker.call(Google_0.getFile(id))
      }
  
    // @LINE:15
    case controllers_UuidGenerator_randomUUID5_route(params) =>
      call { 
        controllers_UuidGenerator_randomUUID5_invoker.call(UuidGenerator_1.randomUUID())
      }
  
    // @LINE:16
    case controllers_User_listUsers6_route(params) =>
      call(params.fromQuery[String]("surname", Some(null)), params.fromQuery[String]("firstname", Some(null)), params.fromQuery[String]("email", Some(null))) { (surname, firstname, email) =>
        controllers_User_listUsers6_invoker.call(User_3.listUsers(surname, firstname, email))
      }
  
    // @LINE:17
    case controllers_User_authenticate7_route(params) =>
      call { 
        controllers_User_authenticate7_invoker.call(User_3.authenticate())
      }
  
    // @LINE:18
    case controllers_Document_createDocument8_route(params) =>
      call { 
        controllers_Document_createDocument8_invoker.call(Document_2.createDocument())
      }
  
    // @LINE:19
    case controllers_Document_listDocuments9_route(params) =>
      call(params.fromQuery[String]("doctype", Some(null)), params.fromQuery[String]("docgroup", Some(null))) { (doctype, docgroup) =>
        controllers_Document_listDocuments9_invoker.call(Document_2.listDocuments(doctype, docgroup))
      }
  
    // @LINE:20
    case controllers_Document_getDocument10_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Document_getDocument10_invoker.call(Document_2.getDocument(id))
      }
  
    // @LINE:21
    case controllers_Document_listDocumentTypes11_route(params) =>
      call(params.fromQuery[String]("doctype", Some(null)), params.fromQuery[String]("role", Some(null))) { (doctype, role) =>
        controllers_Document_listDocumentTypes11_invoker.call(Document_2.listDocumentTypes(doctype, role))
      }
  
    // @LINE:25
    case controllers_Assets_at12_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at12_invoker.call(Assets_4.at(path, file))
      }
  
    // @LINE:26
    case controllers_Assets_at13_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at13_invoker.call(Assets_4.at(path, file))
      }
  
    // @LINE:27
    case controllers_WebJarAssets_at14_route(params) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_WebJarAssets_at14_invoker.call(WebJarAssets_5.at(file))
      }
  
    // @LINE:28
    case controllers_Application_version15_route(params) =>
      call { 
        controllers_Application_version15_invoker.call(Application_6.version())
      }
  
    // @LINE:31
    case controllers_Application_anything16_route(params) =>
      call(params.fromPath[String]("stuff", None)) { (stuff) =>
        controllers_Application_anything16_invoker.call(Application_6.anything(stuff))
      }
  }
}
