
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

     object index_Scope1 {
import security.model.UserProfile
import play.api.Play.current

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[WebJarAssets,UserProfile,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(webJarAssets: WebJarAssets, userProfile: UserProfile):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*5.2*/config/*5.8*/ = {{play.Play.application().configuration() }};
Seq[Any](format.raw/*4.56*/("""
"""),format.raw/*5.53*/("""

"""),format.raw/*7.1*/("""<!DOCTYPE html>
<html ng-app="horsley">
	<head>
		<meta charset="utf-8">
		<meta name="Description" CONTENT="This is the website for the Cotswold villages of
		Horsley Parish, Gloucestershire. We are a thriving, rural community, with a rich history
 		and a colourful reputation for doing things in a uniquely 'Horsley' way. This community includes:
		Horsley, Tickmorend, Sugley, Downend, Nupend, Tiltupsend, Washpool, Wallow Green, the Fooks,
		part of Rockness, Sandgrove, Lower &amp; Upper Lutheridge, Hartley Bridge, Hay Lane and Barton End">

		<meta name="google-site-verification" content="nbyjTQkiGZlYdvNNLwxiTv5uk3HI5SMP-PIQtP-msZQ" />

		<title>Horsley Parish (Gloucestershire)</title>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
		<meta name="viewport" content="width=device-width"/>

		<link rel='stylesheet' href='"""),_display_(/*23.33*/routes/*23.39*/.WebJarAssets.at(webJarAssets.locate("css/bootstrap.min.css"))),format.raw/*23.101*/("""'>
		<link rel='stylesheet' href='"""),_display_(/*24.33*/routes/*24.39*/.WebJarAssets.at(webJarAssets.locate("css/bootstrap-theme.css"))),format.raw/*24.103*/("""'>
		<link rel='stylesheet' href='"""),_display_(/*25.33*/routes/*25.39*/.WebJarAssets.at(webJarAssets.locate("angular-material.min.css"))),format.raw/*25.104*/("""'>
		<link rel="stylesheet" href=""""),_display_(/*26.33*/routes/*26.39*/.Assets.at("css/font-awesome-4.6.3/css/font-awesome.css")),format.raw/*26.96*/(""""/>
		<link rel="stylesheet" href=""""),_display_(/*27.33*/routes/*27.39*/.Assets.at("css/OpenSans.css")),format.raw/*27.69*/(""""/>
		<link rel="stylesheet" href=""""),_display_(/*28.33*/routes/*28.39*/.Assets.at("css/main.css")),format.raw/*28.65*/(""""/>
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

		<script type="text/javascript" src='"""),_display_(/*31.40*/routes/*31.46*/.WebJarAssets.at(webJarAssets.locate("jquery.min.js"))),format.raw/*31.100*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*32.40*/routes/*32.46*/.WebJarAssets.at(webJarAssets.locate("bootstrap.min.js"))),format.raw/*32.103*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*33.40*/routes/*33.46*/.WebJarAssets.at(webJarAssets.fullPath("angularjs", "angular.min.js"))),format.raw/*33.116*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*34.40*/routes/*34.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-animate", "angular-animate.min.js"))),format.raw/*34.130*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*35.40*/routes/*35.46*/.WebJarAssets.at(webJarAssets.locate("angular-resource.min.js"))),format.raw/*35.110*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*36.40*/routes/*36.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-route","angular-route.min.js"))),format.raw/*36.125*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*37.40*/routes/*37.46*/.WebJarAssets.at(webJarAssets.locate("angular-filter.min.js"))),format.raw/*37.108*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*38.40*/routes/*38.46*/.WebJarAssets.at(webJarAssets.locate("0.2.18/angular-ui-router.min.js"))),format.raw/*38.118*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*39.40*/routes/*39.46*/.WebJarAssets.at(webJarAssets.locate("ui-bootstrap-tpls.min.js"))),format.raw/*39.111*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*40.40*/routes/*40.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-cookies", "angular-cookies.min.js"))),format.raw/*40.130*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*41.40*/routes/*41.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-aria", "angular-aria.min.js"))),format.raw/*41.124*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*42.40*/routes/*42.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-messages","angular-messages.min.js"))),format.raw/*42.131*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*43.40*/routes/*43.46*/.Assets.at("js/angular-file-upload.min.js")),format.raw/*43.89*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*44.40*/routes/*44.46*/.WebJarAssets.at(webJarAssets.locate("angular-material.min.js"))),format.raw/*44.110*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*45.40*/routes/*45.46*/.WebJarAssets.at(webJarAssets.locate("moment.min.js"))),format.raw/*45.100*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*46.40*/routes/*46.46*/.WebJarAssets.at(webJarAssets.locate("postscribe.min.js"))),format.raw/*46.104*/("""'></script>

		<script type="text/javascript" src='"""),_display_(/*48.40*/routes/*48.46*/.Assets.at("js/controllers.module.js")),format.raw/*48.84*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*49.40*/routes/*49.46*/.Assets.at("js/services.module.js")),format.raw/*49.81*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*50.40*/routes/*50.46*/.Assets.at("js/app.js")),format.raw/*50.69*/("""'></script>

		<!-- Features -->

		<!-- Home-Page -->
		<script type="text/javascript" src='"""),_display_(/*55.40*/routes/*55.46*/.Assets.at("features/home-page/home-page.controller.js")),format.raw/*55.102*/("""'></script>

		<!-- File-Uploader -->
		<link rel="stylesheet" href='"""),_display_(/*58.33*/routes/*58.39*/.Assets.at("features/file-uploader/file-uploader.css")),format.raw/*58.93*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*59.40*/routes/*59.46*/.Assets.at("features/file-uploader/file-uploader.controller.js")),format.raw/*59.110*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*60.40*/routes/*60.46*/.Assets.at("features/file-uploader/file-uploader.service.js")),format.raw/*60.107*/("""'></script>

			<!-- Navigation Bar -->
		<link rel="stylesheet" href='"""),_display_(/*63.33*/routes/*63.39*/.Assets.at("features/navbar/navbar-button.css")),format.raw/*63.86*/("""'/>
		<link rel="stylesheet" href='"""),_display_(/*64.33*/routes/*64.39*/.Assets.at("features/navbar/navbar.css")),format.raw/*64.79*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*65.40*/routes/*65.46*/.Assets.at("features/navbar/navbar-button.directive.js")),format.raw/*65.102*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*66.40*/routes/*66.46*/.Assets.at("features/navbar/navbar.directive.js")),format.raw/*66.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*67.40*/routes/*67.46*/.Assets.at("features/navbar/navbar.service.js")),format.raw/*67.93*/("""'></script>

		<!-- Common Services -->
		<link rel="stylesheet" href='"""),_display_(/*70.33*/routes/*70.39*/.Assets.at("features/common/header.css")),format.raw/*70.79*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*71.40*/routes/*71.46*/.Assets.at("features/common/header.directive.js")),format.raw/*71.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*72.40*/routes/*72.46*/.Assets.at("features/common/footer.directive.js")),format.raw/*72.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*73.40*/routes/*73.46*/.Assets.at("features/flash/flash.service.js")),format.raw/*73.91*/("""'></script>

		<!-- Google Drive -->
		<script type="text/javascript" src='"""),_display_(/*76.40*/routes/*76.46*/.Assets.at("features/google-drive/google-drive.service.js")),format.raw/*76.105*/("""'></script>

		<!-- Page-Tabs -->
		<link rel="stylesheet" href='"""),_display_(/*79.33*/routes/*79.39*/.Assets.at("features/page-tabs/page-tabs.css")),format.raw/*79.85*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*80.40*/routes/*80.46*/.Assets.at("features/page-tabs/page-tabs.directive.js")),format.raw/*80.101*/("""'></script>

		<!-- Home-Page -->
		<script type="text/javascript" src='"""),_display_(/*83.40*/routes/*83.46*/.Assets.at("features/home-page/home-page.controller.js")),format.raw/*83.102*/("""'></script>

		<!-- The Horses Mouth -->
		<link rel="stylesheet" href='"""),_display_(/*86.33*/routes/*86.39*/.Assets.at("features/the-horses-mouth/horses-mouth.css")),format.raw/*86.95*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*87.40*/routes/*87.46*/.Assets.at("features/the-horses-mouth/horses-mouth.controller.js")),format.raw/*87.112*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*88.40*/routes/*88.46*/.Assets.at("features/the-horses-mouth/horses-mouth.service.js")),format.raw/*88.109*/("""'></script>

		<!-- History -->
		<script type="text/javascript" src='"""),_display_(/*91.40*/routes/*91.46*/.Assets.at("features/history/history.controller.js")),format.raw/*91.98*/("""'></script>

		<!-- Village Hall -->
		<link rel="stylesheet" href='"""),_display_(/*94.33*/routes/*94.39*/.Assets.at("features/village-hall/village-hall.css")),format.raw/*94.91*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*95.40*/routes/*95.46*/.Assets.at("features/village-hall/village-hall.controller.js")),format.raw/*95.108*/("""'></script>

		<!-- Login -->
		<link rel="stylesheet" href='"""),_display_(/*98.33*/routes/*98.39*/.Assets.at("features/login/login.css")),format.raw/*98.77*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*99.40*/routes/*99.46*/.Assets.at("features/login/authentication.service.js")),format.raw/*99.100*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*100.40*/routes/*100.46*/.Assets.at("features/login/login.controller.js")),format.raw/*100.94*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*101.40*/routes/*101.46*/.Assets.at("features/login/logout.controller.js")),format.raw/*101.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*102.40*/routes/*102.46*/.Assets.at("features/login/register.controller.js")),format.raw/*102.97*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*103.40*/routes/*103.46*/.Assets.at("features/login/user.service.js")),format.raw/*103.90*/("""'></script>

		<!-- Parish Council -->
		<link rel="stylesheet" href='"""),_display_(/*106.33*/routes/*106.39*/.Assets.at("features/parish-council/parish-council.css")),format.raw/*106.95*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*107.40*/routes/*107.46*/.Assets.at("features/parish-council/parish-council.controller.js")),format.raw/*107.112*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*108.40*/routes/*108.46*/.Assets.at("features/parish-council/parish-council.services.js")),format.raw/*108.110*/("""'></script>

		<!-- Animated bird -->
		<link rel="stylesheet" href='"""),_display_(/*111.33*/routes/*111.39*/.Assets.at("features/animated-bird/animated-bird.css")),format.raw/*111.93*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*112.40*/routes/*112.46*/.Assets.at("features/animated-bird/animated-bird.directive.js")),format.raw/*112.109*/("""'></script>

		<!-- Community Shop -->
		<link rel="stylesheet" href='"""),_display_(/*115.33*/routes/*115.39*/.Assets.at("features/horsley-community-shop/community-shop.css")),format.raw/*115.103*/("""'/>

		<!-- User Admin -->
		<script type="text/javascript" src='"""),_display_(/*118.40*/routes/*118.46*/.Assets.at("admin/users/users.controller.js")),format.raw/*118.91*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*119.40*/routes/*119.46*/.Assets.at("admin/users/users.service.js")),format.raw/*119.88*/("""'></script>
		<link rel="stylesheet" href='"""),_display_(/*120.33*/routes/*120.39*/.Assets.at("admin/users/users.css")),format.raw/*120.74*/("""'/>


	</head>


	<body>

		<div id="page-wrapper">
			<header></header>
			<div class="main-container">
				<div class="main-page-hdr"></div>
				<ng-view class="main-page"></ng-view>
			</div>
			<footer></footer>
		</div>

	</body>


</html>"""))
      }
    }
  }

  def render(webJarAssets:WebJarAssets,userProfile:UserProfile): play.twirl.api.HtmlFormat.Appendable = apply(webJarAssets,userProfile)

  def f:((WebJarAssets,UserProfile) => play.twirl.api.HtmlFormat.Appendable) = (webJarAssets,userProfile) => apply(webJarAssets,userProfile)

  def ref: this.type = this

}


}
}

/**/
object index extends index_Scope0.index_Scope1.index
              /*
                  -- GENERATED --
                  DATE: Tue Jul 04 20:44:08 BST 2017
                  SOURCE: /Users/jstride/Documents/workspace/repository/horsleyparish/app/views/index.scala.html
                  HASH: b655e5ce6994e624571cc2c16d4fe0c266975b58
                  MATRIX: 636->67|768->123|781->129|857->121|885->174|913->176|1796->1032|1811->1038|1895->1100|1957->1135|1972->1141|2058->1205|2120->1240|2135->1246|2222->1311|2284->1346|2299->1352|2377->1409|2440->1445|2455->1451|2506->1481|2569->1517|2584->1523|2631->1549|2791->1682|2806->1688|2882->1742|2960->1793|2975->1799|3054->1856|3132->1907|3147->1913|3239->1983|3317->2034|3332->2040|3438->2124|3516->2175|3531->2181|3617->2245|3695->2296|3710->2302|3811->2381|3889->2432|3904->2438|3988->2500|4066->2551|4081->2557|4175->2629|4253->2680|4268->2686|4355->2751|4433->2802|4448->2808|4554->2892|4632->2943|4647->2949|4747->3027|4825->3078|4840->3084|4947->3169|5025->3220|5040->3226|5104->3269|5182->3320|5197->3326|5283->3390|5361->3441|5376->3447|5452->3501|5530->3552|5545->3558|5625->3616|5704->3668|5719->3674|5778->3712|5856->3763|5871->3769|5927->3804|6005->3855|6020->3861|6064->3884|6185->3978|6200->3984|6278->4040|6375->4110|6390->4116|6465->4170|6535->4213|6550->4219|6636->4283|6714->4334|6729->4340|6812->4401|6911->4473|6926->4479|6994->4526|7057->4562|7072->4568|7133->4608|7203->4651|7218->4657|7296->4713|7374->4764|7389->4770|7459->4819|7537->4870|7552->4876|7620->4923|7719->4995|7734->5001|7795->5041|7865->5084|7880->5090|7950->5139|8028->5190|8043->5196|8113->5245|8191->5296|8206->5302|8272->5347|8375->5423|8390->5429|8471->5488|8564->5554|8579->5560|8646->5606|8716->5649|8731->5655|8808->5710|8908->5783|8923->5789|9001->5845|9101->5918|9116->5924|9193->5980|9263->6023|9278->6029|9366->6095|9444->6146|9459->6152|9544->6215|9642->6286|9657->6292|9730->6344|9826->6413|9841->6419|9914->6471|9984->6514|9999->6520|10083->6582|10172->6644|10187->6650|10246->6688|10316->6731|10331->6737|10407->6791|10486->6842|10502->6848|10572->6896|10651->6947|10667->6953|10738->7002|10817->7053|10833->7059|10906->7110|10985->7161|11001->7167|11067->7211|11166->7282|11182->7288|11260->7344|11331->7387|11347->7393|11436->7459|11515->7510|11531->7516|11618->7580|11716->7650|11732->7656|11808->7710|11879->7753|11895->7759|11981->7822|12080->7893|12096->7899|12183->7963|12277->8029|12293->8035|12360->8080|12439->8131|12455->8137|12519->8179|12591->8223|12607->8229|12664->8264
                  LINES: 24->4|28->5|28->5|29->4|30->5|32->7|48->23|48->23|48->23|49->24|49->24|49->24|50->25|50->25|50->25|51->26|51->26|51->26|52->27|52->27|52->27|53->28|53->28|53->28|56->31|56->31|56->31|57->32|57->32|57->32|58->33|58->33|58->33|59->34|59->34|59->34|60->35|60->35|60->35|61->36|61->36|61->36|62->37|62->37|62->37|63->38|63->38|63->38|64->39|64->39|64->39|65->40|65->40|65->40|66->41|66->41|66->41|67->42|67->42|67->42|68->43|68->43|68->43|69->44|69->44|69->44|70->45|70->45|70->45|71->46|71->46|71->46|73->48|73->48|73->48|74->49|74->49|74->49|75->50|75->50|75->50|80->55|80->55|80->55|83->58|83->58|83->58|84->59|84->59|84->59|85->60|85->60|85->60|88->63|88->63|88->63|89->64|89->64|89->64|90->65|90->65|90->65|91->66|91->66|91->66|92->67|92->67|92->67|95->70|95->70|95->70|96->71|96->71|96->71|97->72|97->72|97->72|98->73|98->73|98->73|101->76|101->76|101->76|104->79|104->79|104->79|105->80|105->80|105->80|108->83|108->83|108->83|111->86|111->86|111->86|112->87|112->87|112->87|113->88|113->88|113->88|116->91|116->91|116->91|119->94|119->94|119->94|120->95|120->95|120->95|123->98|123->98|123->98|124->99|124->99|124->99|125->100|125->100|125->100|126->101|126->101|126->101|127->102|127->102|127->102|128->103|128->103|128->103|131->106|131->106|131->106|132->107|132->107|132->107|133->108|133->108|133->108|136->111|136->111|136->111|137->112|137->112|137->112|140->115|140->115|140->115|143->118|143->118|143->118|144->119|144->119|144->119|145->120|145->120|145->120
                  -- GENERATED --
              */
          