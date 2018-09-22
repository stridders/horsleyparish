
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
		<script type="text/javascript" src='"""),_display_(/*47.40*/routes/*47.46*/.WebJarAssets.at(webJarAssets.locate("4.10.2/d3.min.js"))),format.raw/*47.103*/("""'></script>

		<script type="text/javascript" src='"""),_display_(/*49.40*/routes/*49.46*/.Assets.at("js/pdf.js")),format.raw/*49.69*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*50.40*/routes/*50.46*/.Assets.at("js/controllers.module.js")),format.raw/*50.84*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*51.40*/routes/*51.46*/.Assets.at("js/services.module.js")),format.raw/*51.81*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*52.40*/routes/*52.46*/.Assets.at("js/app.js")),format.raw/*52.69*/("""'></script>

		<!-- Features -->

		<!-- Home-Page -->
		<script type="text/javascript" src='"""),_display_(/*57.40*/routes/*57.46*/.Assets.at("features/home-page/home-page.controller.js")),format.raw/*57.102*/("""'></script>

			<!-- Navigation Bar -->
		<link rel="stylesheet" href='"""),_display_(/*60.33*/routes/*60.39*/.Assets.at("features/navbar/navbar-button.css")),format.raw/*60.86*/("""'/>
		<link rel="stylesheet" href='"""),_display_(/*61.33*/routes/*61.39*/.Assets.at("features/navbar/navbar.css")),format.raw/*61.79*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*62.40*/routes/*62.46*/.Assets.at("features/navbar/navbar-button.directive.js")),format.raw/*62.102*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*63.40*/routes/*63.46*/.Assets.at("features/navbar/navbar.directive.js")),format.raw/*63.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*64.40*/routes/*64.46*/.Assets.at("features/navbar/navbar.service.js")),format.raw/*64.93*/("""'></script>

		<!-- Common Services -->
		<link rel="stylesheet" href='"""),_display_(/*67.33*/routes/*67.39*/.Assets.at("features/common/header.css")),format.raw/*67.79*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*68.40*/routes/*68.46*/.Assets.at("features/common/header.directive.js")),format.raw/*68.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*69.40*/routes/*69.46*/.Assets.at("features/common/footer.directive.js")),format.raw/*69.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*70.40*/routes/*70.46*/.Assets.at("features/flash/flash.service.js")),format.raw/*70.91*/("""'></script>

			<!-- Google Drive -->
		<script type="text/javascript" src='"""),_display_(/*73.40*/routes/*73.46*/.Assets.at("features/google-drive/google-drive.service.js")),format.raw/*73.105*/("""'></script>


		<!-- Page-Tabs -->
		<link rel="stylesheet" href='"""),_display_(/*77.33*/routes/*77.39*/.Assets.at("features/page-tabs/page-tabs.css")),format.raw/*77.85*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*78.40*/routes/*78.46*/.Assets.at("features/page-tabs/page-tabs.directive.js")),format.raw/*78.101*/("""'></script>

		<!-- Home-Page -->
		<link rel="stylesheet" href='"""),_display_(/*81.33*/routes/*81.39*/.Assets.at("features/home-page/home-page.css")),format.raw/*81.85*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*82.40*/routes/*82.46*/.Assets.at("features/home-page/home-page.controller.js")),format.raw/*82.102*/("""'></script>

			<!-- About -->
		<script type="text/javascript" src='"""),_display_(/*85.40*/routes/*85.46*/.Assets.at("features/about/about.controller.js")),format.raw/*85.94*/("""'></script>
		<link rel="stylesheet" href='"""),_display_(/*86.33*/routes/*86.39*/.Assets.at("features/about/about.css")),format.raw/*86.77*/("""'/>

		<!-- The Horses Mouth -->
		<link rel="stylesheet" href='"""),_display_(/*89.33*/routes/*89.39*/.Assets.at("features/the-horses-mouth/horses-mouth.css")),format.raw/*89.95*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*90.40*/routes/*90.46*/.Assets.at("features/the-horses-mouth/horses-mouth.controller.js")),format.raw/*90.112*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*91.40*/routes/*91.46*/.Assets.at("features/the-horses-mouth/horses-mouth.service.js")),format.raw/*91.109*/("""'></script>

		<!-- History -->
		<script type="text/javascript" src='"""),_display_(/*94.40*/routes/*94.46*/.Assets.at("features/history/history.controller.js")),format.raw/*94.98*/("""'></script>

		<!-- Village Hall -->
		<link rel="stylesheet" href='"""),_display_(/*97.33*/routes/*97.39*/.Assets.at("features/village-hall/village-hall.css")),format.raw/*97.91*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*98.40*/routes/*98.46*/.Assets.at("features/village-hall/village-hall.controller.js")),format.raw/*98.108*/("""'></script>

		<!-- Login -->
		<link rel="stylesheet" href='"""),_display_(/*101.33*/routes/*101.39*/.Assets.at("features/login/login.css")),format.raw/*101.77*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*102.40*/routes/*102.46*/.Assets.at("features/login/authentication.service.js")),format.raw/*102.100*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*103.40*/routes/*103.46*/.Assets.at("features/login/login.controller.js")),format.raw/*103.94*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*104.40*/routes/*104.46*/.Assets.at("features/login/logout.controller.js")),format.raw/*104.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*105.40*/routes/*105.46*/.Assets.at("features/login/register.controller.js")),format.raw/*105.97*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*106.40*/routes/*106.46*/.Assets.at("features/login/user.service.js")),format.raw/*106.90*/("""'></script>

		<!-- Parish Council -->
		<link rel="stylesheet" href='"""),_display_(/*109.33*/routes/*109.39*/.Assets.at("features/parish-council/parish-council.css")),format.raw/*109.95*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*110.40*/routes/*110.46*/.Assets.at("features/parish-council/parish-council.controller.js")),format.raw/*110.112*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*111.40*/routes/*111.46*/.Assets.at("features/parish-council/parish-council.services.js")),format.raw/*111.110*/("""'></script>

			<!-- Church and Cemetery -->
		<link rel="stylesheet" href='"""),_display_(/*114.33*/routes/*114.39*/.Assets.at("features/church-and-cemetery/church-and-cemetery.css")),format.raw/*114.105*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*115.40*/routes/*115.46*/.Assets.at("features/church-and-cemetery/church-and-cemetery.controller.js")),format.raw/*115.122*/("""'></script>

		<!-- Animated bird -->
		<link rel="stylesheet" href='"""),_display_(/*118.33*/routes/*118.39*/.Assets.at("features/animated-bird/animated-bird.css")),format.raw/*118.93*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*119.40*/routes/*119.46*/.Assets.at("features/animated-bird/animated-bird.directive.js")),format.raw/*119.109*/("""'></script>

		<!-- Community Shop -->
		<link rel="stylesheet" href='"""),_display_(/*122.33*/routes/*122.39*/.Assets.at("features/horsley-community-shop/community-shop.css")),format.raw/*122.103*/("""'/>

		<!-- User Admin -->
		<script type="text/javascript" src='"""),_display_(/*125.40*/routes/*125.46*/.Assets.at("admin/users/users.controller.js")),format.raw/*125.91*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*126.40*/routes/*126.46*/.Assets.at("admin/users/users.service.js")),format.raw/*126.88*/("""'></script>
		<link rel="stylesheet" href='"""),_display_(/*127.33*/routes/*127.39*/.Assets.at("admin/users/users.css")),format.raw/*127.74*/("""'/>


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
                  DATE: Fri Sep 21 17:55:34 BST 2018
                  SOURCE: /Users/js/Documents/workspace/repositories/HorsleyParish/app/views/index.scala.html
                  HASH: 9cac5cc09a67557f1dce51d697a45dc699e7d33b
                  MATRIX: 636->67|768->123|781->129|857->121|885->174|913->176|1796->1032|1811->1038|1895->1100|1957->1135|1972->1141|2058->1205|2120->1240|2135->1246|2222->1311|2284->1346|2299->1352|2377->1409|2440->1445|2455->1451|2506->1481|2569->1517|2584->1523|2631->1549|2791->1682|2806->1688|2882->1742|2960->1793|2975->1799|3054->1856|3132->1907|3147->1913|3239->1983|3317->2034|3332->2040|3438->2124|3516->2175|3531->2181|3617->2245|3695->2296|3710->2302|3811->2381|3889->2432|3904->2438|3988->2500|4066->2551|4081->2557|4175->2629|4253->2680|4268->2686|4355->2751|4433->2802|4448->2808|4554->2892|4632->2943|4647->2949|4747->3027|4825->3078|4840->3084|4947->3169|5025->3220|5040->3226|5104->3269|5182->3320|5197->3326|5283->3390|5361->3441|5376->3447|5452->3501|5530->3552|5545->3558|5625->3616|5703->3667|5718->3673|5797->3730|5876->3782|5891->3788|5935->3811|6013->3862|6028->3868|6087->3906|6165->3957|6180->3963|6236->3998|6314->4049|6329->4055|6373->4078|6494->4172|6509->4178|6587->4234|6686->4306|6701->4312|6769->4359|6832->4395|6847->4401|6908->4441|6978->4484|6993->4490|7071->4546|7149->4597|7164->4603|7234->4652|7312->4703|7327->4709|7395->4756|7494->4828|7509->4834|7570->4874|7640->4917|7655->4923|7725->4972|7803->5023|7818->5029|7888->5078|7966->5129|7981->5135|8047->5180|8151->5257|8166->5263|8247->5322|8341->5389|8356->5395|8423->5441|8493->5484|8508->5490|8585->5545|8678->5611|8693->5617|8760->5663|8830->5706|8845->5712|8923->5768|9020->5838|9035->5844|9104->5892|9175->5936|9190->5942|9249->5980|9341->6045|9356->6051|9433->6107|9503->6150|9518->6156|9606->6222|9684->6273|9699->6279|9784->6342|9882->6413|9897->6419|9970->6471|10066->6540|10081->6546|10154->6598|10224->6641|10239->6647|10323->6709|10413->6771|10429->6777|10489->6815|10560->6858|10576->6864|10653->6918|10732->6969|10748->6975|10818->7023|10897->7074|10913->7080|10984->7129|11063->7180|11079->7186|11152->7237|11231->7288|11247->7294|11313->7338|11412->7409|11428->7415|11506->7471|11577->7514|11593->7520|11682->7586|11761->7637|11777->7643|11864->7707|11969->7784|11985->7790|12074->7856|12145->7899|12161->7905|12260->7981|12358->8051|12374->8057|12450->8111|12521->8154|12537->8160|12623->8223|12722->8294|12738->8300|12825->8364|12919->8430|12935->8436|13002->8481|13081->8532|13097->8538|13161->8580|13233->8624|13249->8630|13306->8665
                  LINES: 24->4|28->5|28->5|29->4|30->5|32->7|48->23|48->23|48->23|49->24|49->24|49->24|50->25|50->25|50->25|51->26|51->26|51->26|52->27|52->27|52->27|53->28|53->28|53->28|56->31|56->31|56->31|57->32|57->32|57->32|58->33|58->33|58->33|59->34|59->34|59->34|60->35|60->35|60->35|61->36|61->36|61->36|62->37|62->37|62->37|63->38|63->38|63->38|64->39|64->39|64->39|65->40|65->40|65->40|66->41|66->41|66->41|67->42|67->42|67->42|68->43|68->43|68->43|69->44|69->44|69->44|70->45|70->45|70->45|71->46|71->46|71->46|72->47|72->47|72->47|74->49|74->49|74->49|75->50|75->50|75->50|76->51|76->51|76->51|77->52|77->52|77->52|82->57|82->57|82->57|85->60|85->60|85->60|86->61|86->61|86->61|87->62|87->62|87->62|88->63|88->63|88->63|89->64|89->64|89->64|92->67|92->67|92->67|93->68|93->68|93->68|94->69|94->69|94->69|95->70|95->70|95->70|98->73|98->73|98->73|102->77|102->77|102->77|103->78|103->78|103->78|106->81|106->81|106->81|107->82|107->82|107->82|110->85|110->85|110->85|111->86|111->86|111->86|114->89|114->89|114->89|115->90|115->90|115->90|116->91|116->91|116->91|119->94|119->94|119->94|122->97|122->97|122->97|123->98|123->98|123->98|126->101|126->101|126->101|127->102|127->102|127->102|128->103|128->103|128->103|129->104|129->104|129->104|130->105|130->105|130->105|131->106|131->106|131->106|134->109|134->109|134->109|135->110|135->110|135->110|136->111|136->111|136->111|139->114|139->114|139->114|140->115|140->115|140->115|143->118|143->118|143->118|144->119|144->119|144->119|147->122|147->122|147->122|150->125|150->125|150->125|151->126|151->126|151->126|152->127|152->127|152->127
                  -- GENERATED --
              */
          