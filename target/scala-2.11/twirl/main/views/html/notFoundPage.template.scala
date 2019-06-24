
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._
/*1.2*/import security.model.UserProfile
/*2.2*/import play.api.Play
/*3.2*/import org.webjars.play.WebJarsUtil

object notFoundPage extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[WebJarsUtil,String,UserProfile,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(webJarsUtil: WebJarsUtil, path: String, userProfile: UserProfile):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*6.1*/("""
"""),format.raw/*7.1*/("""<!DOCTYPE html>
  <html ng-app="HorsleyParish">
    <head>
      <title>Horsley Parish, Gloucestershire, Community website</title>
      <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
      <meta name="viewport" content="width=device-width, initial-scala=1"/>
      <link rel='stylesheet' href='"""),_display_(/*13.37*/webJarsUtil/*13.48*/.locate("css/bootstrap.min.css")),format.raw/*13.80*/("""'>
      <link rel='stylesheet' href='"""),_display_(/*14.37*/webJarsUtil/*14.48*/.locate("css/bootstrap-theme.css")),format.raw/*14.82*/("""'>
      <link rel="stylesheet" href=""""),_display_(/*15.37*/routes/*15.43*/.Assets.at("css/font-awesome-4.6.3/css/font-awesome.css")),format.raw/*15.100*/(""""/>
      <link rel="stylesheet" href=""""),_display_(/*16.37*/routes/*16.43*/.Assets.at("css/OpenSans.css")),format.raw/*16.73*/(""""/>
      <link rel="stylesheet" href=""""),_display_(/*17.37*/routes/*17.43*/.Assets.at("css/main.css")),format.raw/*17.69*/(""""/>

    </head>

      <body class="pace-done">
        <div>
          <div id="page-wrapper" class="gray-bg">

            <div class="middle-box text-center">
              <h1>404</h1>
              <h3 class="font-bold">Page Not Found</h3>
              <div>
                Sorry, but the page you are looking for has not been found.<br>
                Please check the URL (in the top of your browser) for any obvious errors.
                <br><br>
                <a href="web">Click here to return the Horsley Parish Home Page</a>
              </div>
            </div>

          </div>
        </div>
      </body>
    </html>"""))
      }
    }
  }

  def render(webJarsUtil:WebJarsUtil,path:String,userProfile:UserProfile): play.twirl.api.HtmlFormat.Appendable = apply(webJarsUtil,path,userProfile)

  def f:((WebJarsUtil,String,UserProfile) => play.twirl.api.HtmlFormat.Appendable) = (webJarsUtil,path,userProfile) => apply(webJarsUtil,path,userProfile)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Jun 24 09:21:27 BST 2019
                  SOURCE: /Users/js/Documents/workspace/repositories/HorsleyParish/app/views/notFoundPage.scala.html
                  HASH: 26e75e5e6b0fe97903508ba795178300fddfc342
                  MATRIX: 432->1|473->36|501->58|872->96|1032->163|1059->164|1404->482|1424->493|1477->525|1543->564|1563->575|1618->609|1684->648|1699->654|1778->711|1845->751|1860->757|1911->787|1978->827|1993->833|2040->859
                  LINES: 17->1|18->2|19->3|24->5|29->6|30->7|36->13|36->13|36->13|37->14|37->14|37->14|38->15|38->15|38->15|39->16|39->16|39->16|40->17|40->17|40->17
                  -- GENERATED --
              */
          