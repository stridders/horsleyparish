
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/jstride/Documents/workspace/repository/horsleyparish/conf/routes
// @DATE:Thu Feb 23 18:37:11 GMT 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_5: controllers.Application,
  // @LINE:12
  UuidGenerator_0: controllers.UuidGenerator,
  // @LINE:13
  User_2: controllers.User,
  // @LINE:15
  Document_1: controllers.Document,
  // @LINE:22
  Assets_3: controllers.Assets,
  // @LINE:24
  WebJarAssets_4: controllers.WebJarAssets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_5: controllers.Application,
    // @LINE:12
    UuidGenerator_0: controllers.UuidGenerator,
    // @LINE:13
    User_2: controllers.User,
    // @LINE:15
    Document_1: controllers.Document,
    // @LINE:22
    Assets_3: controllers.Assets,
    // @LINE:24
    WebJarAssets_4: controllers.WebJarAssets
  ) = this(errorHandler, Application_5, UuidGenerator_0, User_2, Document_1, Assets_3, WebJarAssets_4, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_5, UuidGenerator_0, User_2, Document_1, Assets_3, WebJarAssets_4, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """somePath<.+>/""", """controllers.Application.untrail(somePath:String)"""),
    ("""GET""", this.prefix, """controllers.Application.redirect()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """web""", """controllers.Application.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/uuid""", """controllers.UuidGenerator.randomUUID()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/users""", """controllers.User.listUsers(surname:String ?= null, firstname:String ?= null, email:String ?= null)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/authentication""", """controllers.User.authenticate()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/documents""", """controllers.Document.createDocument()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/documents""", """controllers.Document.listDocuments(doctype:String ?= null, docgroup:String ?= null)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/documents/""" + "$" + """id<[^/]+>""", """controllers.Document.getDocument(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/document-types""", """controllers.Document.listDocumentTypes(doctype:String ?= null, role:String ?= null)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """web/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
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
    Application_5.untrail(fakeValue[String]),
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
    Application_5.redirect(),
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
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("web")))
  )
  private[this] lazy val controllers_Application_index2_invoker = createInvoker(
    Application_5.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """web"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UuidGenerator_randomUUID3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/uuid")))
  )
  private[this] lazy val controllers_UuidGenerator_randomUUID3_invoker = createInvoker(
    UuidGenerator_0.randomUUID(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UuidGenerator",
      "randomUUID",
      Nil,
      "GET",
      """GET    /api                             controllers.Root.apiRoot()""",
      this.prefix + """api/uuid"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_User_listUsers4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/users")))
  )
  private[this] lazy val controllers_User_listUsers4_invoker = createInvoker(
    User_2.listUsers(fakeValue[String], fakeValue[String], fakeValue[String]),
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

  // @LINE:14
  private[this] lazy val controllers_User_authenticate5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/authentication")))
  )
  private[this] lazy val controllers_User_authenticate5_invoker = createInvoker(
    User_2.authenticate(),
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

  // @LINE:15
  private[this] lazy val controllers_Document_createDocument6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/documents")))
  )
  private[this] lazy val controllers_Document_createDocument6_invoker = createInvoker(
    Document_1.createDocument(),
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

  // @LINE:16
  private[this] lazy val controllers_Document_listDocuments7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/documents")))
  )
  private[this] lazy val controllers_Document_listDocuments7_invoker = createInvoker(
    Document_1.listDocuments(fakeValue[String], fakeValue[String]),
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

  // @LINE:17
  private[this] lazy val controllers_Document_getDocument8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/documents/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Document_getDocument8_invoker = createInvoker(
    Document_1.getDocument(fakeValue[Long]),
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

  // @LINE:18
  private[this] lazy val controllers_Document_listDocumentTypes9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/document-types")))
  )
  private[this] lazy val controllers_Document_listDocumentTypes9_invoker = createInvoker(
    Document_1.listDocumentTypes(fakeValue[String], fakeValue[String]),
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

  // @LINE:22
  private[this] lazy val controllers_Assets_at10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("web/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at10_invoker = createInvoker(
    Assets_3.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """web/""" + "$" + """file<.+>"""
    )
  )

  // @LINE:23
  private[this] lazy val controllers_Assets_at11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at11_invoker = createInvoker(
    Assets_3.at(fakeValue[String], fakeValue[String]),
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

  // @LINE:24
  private[this] lazy val controllers_WebJarAssets_at12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("webjars/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_WebJarAssets_at12_invoker = createInvoker(
    WebJarAssets_4.at(fakeValue[String]),
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

  // @LINE:25
  private[this] lazy val controllers_Application_version13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("version")))
  )
  private[this] lazy val controllers_Application_version13_invoker = createInvoker(
    Application_5.version(),
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

  // @LINE:28
  private[this] lazy val controllers_Application_anything14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("stuff", """.*""",false)))
  )
  private[this] lazy val controllers_Application_anything14_invoker = createInvoker(
    Application_5.anything(fakeValue[String]),
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
        controllers_Application_untrail0_invoker.call(Application_5.untrail(somePath))
      }
  
    // @LINE:7
    case controllers_Application_redirect1_route(params) =>
      call { 
        controllers_Application_redirect1_invoker.call(Application_5.redirect())
      }
  
    // @LINE:9
    case controllers_Application_index2_route(params) =>
      call { 
        controllers_Application_index2_invoker.call(Application_5.index())
      }
  
    // @LINE:12
    case controllers_UuidGenerator_randomUUID3_route(params) =>
      call { 
        controllers_UuidGenerator_randomUUID3_invoker.call(UuidGenerator_0.randomUUID())
      }
  
    // @LINE:13
    case controllers_User_listUsers4_route(params) =>
      call(params.fromQuery[String]("surname", Some(null)), params.fromQuery[String]("firstname", Some(null)), params.fromQuery[String]("email", Some(null))) { (surname, firstname, email) =>
        controllers_User_listUsers4_invoker.call(User_2.listUsers(surname, firstname, email))
      }
  
    // @LINE:14
    case controllers_User_authenticate5_route(params) =>
      call { 
        controllers_User_authenticate5_invoker.call(User_2.authenticate())
      }
  
    // @LINE:15
    case controllers_Document_createDocument6_route(params) =>
      call { 
        controllers_Document_createDocument6_invoker.call(Document_1.createDocument())
      }
  
    // @LINE:16
    case controllers_Document_listDocuments7_route(params) =>
      call(params.fromQuery[String]("doctype", Some(null)), params.fromQuery[String]("docgroup", Some(null))) { (doctype, docgroup) =>
        controllers_Document_listDocuments7_invoker.call(Document_1.listDocuments(doctype, docgroup))
      }
  
    // @LINE:17
    case controllers_Document_getDocument8_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Document_getDocument8_invoker.call(Document_1.getDocument(id))
      }
  
    // @LINE:18
    case controllers_Document_listDocumentTypes9_route(params) =>
      call(params.fromQuery[String]("doctype", Some(null)), params.fromQuery[String]("role", Some(null))) { (doctype, role) =>
        controllers_Document_listDocumentTypes9_invoker.call(Document_1.listDocumentTypes(doctype, role))
      }
  
    // @LINE:22
    case controllers_Assets_at10_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at10_invoker.call(Assets_3.at(path, file))
      }
  
    // @LINE:23
    case controllers_Assets_at11_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at11_invoker.call(Assets_3.at(path, file))
      }
  
    // @LINE:24
    case controllers_WebJarAssets_at12_route(params) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_WebJarAssets_at12_invoker.call(WebJarAssets_4.at(file))
      }
  
    // @LINE:25
    case controllers_Application_version13_route(params) =>
      call { 
        controllers_Application_version13_invoker.call(Application_5.version())
      }
  
    // @LINE:28
    case controllers_Application_anything14_route(params) =>
      call(params.fromPath[String]("stuff", None)) { (stuff) =>
        controllers_Application_anything14_invoker.call(Application_5.anything(stuff))
      }
  }
}
