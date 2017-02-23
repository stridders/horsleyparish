
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object notFoundPage_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

     object notFoundPage_Scope1 {
import security.model.UserProfile
import play.api.Play.current

class notFoundPage extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[WebJarAssets,String,UserProfile,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(webJarAssets: WebJarAssets, path: String, userProfile: UserProfile):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*5.2*/config/*5.8*/ = {{play.Play.application().configuration() }};
Seq[Any](format.raw/*4.70*/("""
"""),format.raw/*5.53*/("""

"""),format.raw/*7.1*/("""<!DOCTYPE html>
  <html ng-app="HorsleyParish">
    <head>
      <title>Horsley Parish, Gloucestershire, Community website</title>
      <meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
      <meta name="viewport" content="width=device-width, initial-scala=1"/>
      <link rel='stylesheet' href='"""),_display_(/*13.37*/routes/*13.43*/.WebJarAssets.at(webJarAssets.locate("css/bootstrap.min.css"))),format.raw/*13.105*/("""'>
      <link rel='stylesheet' href='"""),_display_(/*14.37*/routes/*14.43*/.WebJarAssets.at(webJarAssets.locate("css/bootstrap-theme.css"))),format.raw/*14.107*/("""'>
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

  def render(webJarAssets:WebJarAssets,path:String,userProfile:UserProfile): play.twirl.api.HtmlFormat.Appendable = apply(webJarAssets,path,userProfile)

  def f:((WebJarAssets,String,UserProfile) => play.twirl.api.HtmlFormat.Appendable) = (webJarAssets,path,userProfile) => apply(webJarAssets,path,userProfile)

  def ref: this.type = this

}


}
}

/**/
object notFoundPage extends notFoundPage_Scope0.notFoundPage_Scope1.notFoundPage
              /*
                  -- GENERATED --
                  DATE: Thu Feb 23 09:35:20 GMT 2017
                  SOURCE: /Users/js/Documents/workspace/repositories/HorsleyParish/app/views/notFoundPage.scala.html
                  HASH: 2549c005e3b13cbd032e638e432044fe1d7e2dcc
                  MATRIX: 664->67|810->137|823->143|899->135|927->188|955->190|1300->508|1315->514|1399->576|1465->615|1480->621|1566->685|1632->724|1647->730|1726->787|1793->827|1808->833|1859->863|1926->903|1941->909|1988->935
                  LINES: 24->4|28->5|28->5|29->4|30->5|32->7|38->13|38->13|38->13|39->14|39->14|39->14|40->15|40->15|40->15|41->16|41->16|41->16|42->17|42->17|42->17
                  -- GENERATED --
              */
          