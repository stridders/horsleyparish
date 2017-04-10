
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
		<meta name="Description" CONTENT="The community website for Horsley Parish, Gloucestershire">

		<title>Horsley Parish, Gloucestershire, Community website</title>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
		<meta name="viewport" content="width=device-width"/>

		<link rel='stylesheet' href='"""),_display_(/*17.33*/routes/*17.39*/.WebJarAssets.at(webJarAssets.locate("css/bootstrap.min.css"))),format.raw/*17.101*/("""'>
		<link rel='stylesheet' href='"""),_display_(/*18.33*/routes/*18.39*/.WebJarAssets.at(webJarAssets.locate("css/bootstrap-theme.css"))),format.raw/*18.103*/("""'>
		<link rel="stylesheet" href=""""),_display_(/*19.33*/routes/*19.39*/.Assets.at("css/font-awesome-4.6.3/css/font-awesome.css")),format.raw/*19.96*/(""""/>
		<link rel="stylesheet" href=""""),_display_(/*20.33*/routes/*20.39*/.Assets.at("css/OpenSans.css")),format.raw/*20.69*/(""""/>
		<link rel="stylesheet" href=""""),_display_(/*21.33*/routes/*21.39*/.Assets.at("css/main.css")),format.raw/*21.65*/(""""/>
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

		<script type="text/javascript" src='"""),_display_(/*24.40*/routes/*24.46*/.WebJarAssets.at(webJarAssets.locate("jquery.min.js"))),format.raw/*24.100*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*25.40*/routes/*25.46*/.WebJarAssets.at(webJarAssets.locate("bootstrap.min.js"))),format.raw/*25.103*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*26.40*/routes/*26.46*/.WebJarAssets.at(webJarAssets.fullPath("angularjs", "angular.min.js"))),format.raw/*26.116*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*27.40*/routes/*27.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-animate", "angular-animate.min.js"))),format.raw/*27.130*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*28.40*/routes/*28.46*/.WebJarAssets.at(webJarAssets.locate("angular-resource.min.js"))),format.raw/*28.110*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*29.40*/routes/*29.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-route","angular-route.min.js"))),format.raw/*29.125*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*30.40*/routes/*30.46*/.WebJarAssets.at(webJarAssets.locate("angular-filter.min.js"))),format.raw/*30.108*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*31.40*/routes/*31.46*/.WebJarAssets.at(webJarAssets.locate("0.2.18/angular-ui-router.min.js"))),format.raw/*31.118*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*32.40*/routes/*32.46*/.WebJarAssets.at(webJarAssets.locate("ui-bootstrap-tpls.min.js"))),format.raw/*32.111*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*33.40*/routes/*33.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-cookies", "angular-cookies.min.js"))),format.raw/*33.130*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*34.40*/routes/*34.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-aria", "angular-aria.min.js"))),format.raw/*34.124*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*35.40*/routes/*35.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-messages","angular-messages.min.js"))),format.raw/*35.131*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*36.40*/routes/*36.46*/.Assets.at("js/angular-file-upload.min.js")),format.raw/*36.89*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*37.40*/routes/*37.46*/.WebJarAssets.at(webJarAssets.locate("angular-material.min.js"))),format.raw/*37.110*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*38.40*/routes/*38.46*/.WebJarAssets.at(webJarAssets.locate("moment.min.js"))),format.raw/*38.100*/("""'></script>

		<script type="text/javascript" src='"""),_display_(/*40.40*/routes/*40.46*/.Assets.at("js/controllers.module.js")),format.raw/*40.84*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*41.40*/routes/*41.46*/.Assets.at("js/services.module.js")),format.raw/*41.81*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*42.40*/routes/*42.46*/.Assets.at("js/app.js")),format.raw/*42.69*/("""'></script>

		<!-- Features -->

		<!-- Home-Page -->
		<script type="text/javascript" src='"""),_display_(/*47.40*/routes/*47.46*/.Assets.at("features/home-page/home-page.controller.js")),format.raw/*47.102*/("""'></script>

		<!-- File-Uploader -->
		<link rel="stylesheet" href='"""),_display_(/*50.33*/routes/*50.39*/.Assets.at("features/file-uploader/file-uploader.css")),format.raw/*50.93*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*51.40*/routes/*51.46*/.Assets.at("features/file-uploader/file-uploader.controller.js")),format.raw/*51.110*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*52.40*/routes/*52.46*/.Assets.at("features/file-uploader/file-uploader.service.js")),format.raw/*52.107*/("""'></script>

		<!-- Common Services -->
		<link rel="stylesheet" href='"""),_display_(/*55.33*/routes/*55.39*/.Assets.at("features/common/header.css")),format.raw/*55.79*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*56.40*/routes/*56.46*/.Assets.at("features/common/header.directive.js")),format.raw/*56.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*57.40*/routes/*57.46*/.Assets.at("features/flash/flash.service.js")),format.raw/*57.91*/("""'></script>

		<!-- Navigation Bar -->
		<link rel="stylesheet" href='"""),_display_(/*60.33*/routes/*60.39*/.Assets.at("features/navbar/navbar-button.css")),format.raw/*60.86*/("""'/>
		<link rel="stylesheet" href='"""),_display_(/*61.33*/routes/*61.39*/.Assets.at("features/navbar/navbar.css")),format.raw/*61.79*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*62.40*/routes/*62.46*/.Assets.at("features/navbar/navbar-button.directive.js")),format.raw/*62.102*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*63.40*/routes/*63.46*/.Assets.at("features/navbar/navbar.directive.js")),format.raw/*63.95*/("""'></script>

		<!-- Page-Tabs -->
		<link rel="stylesheet" href='"""),_display_(/*66.33*/routes/*66.39*/.Assets.at("features/page-tabs/page-tabs.css")),format.raw/*66.85*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*67.40*/routes/*67.46*/.Assets.at("features/page-tabs/page-tabs.directive.js")),format.raw/*67.101*/("""'></script>

		<!-- Home-Page -->
		<script type="text/javascript" src='"""),_display_(/*70.40*/routes/*70.46*/.Assets.at("features/home-page/home-page.controller.js")),format.raw/*70.102*/("""'></script>

		<!-- The Horses Mouth -->
		<link rel="stylesheet" href='"""),_display_(/*73.33*/routes/*73.39*/.Assets.at("features/the-horses-mouth/horses-mouth.css")),format.raw/*73.95*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*74.40*/routes/*74.46*/.Assets.at("features/the-horses-mouth/horses-mouth.controller.js")),format.raw/*74.112*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*75.40*/routes/*75.46*/.Assets.at("features/the-horses-mouth/horses-mouth.service.js")),format.raw/*75.109*/("""'></script>

		<!-- History -->
		<script type="text/javascript" src='"""),_display_(/*78.40*/routes/*78.46*/.Assets.at("features/history/history.controller.js")),format.raw/*78.98*/("""'></script>

		<!-- Village Hall -->
		<link rel="stylesheet" href='"""),_display_(/*81.33*/routes/*81.39*/.Assets.at("features/village-hall/village-hall.css")),format.raw/*81.91*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*82.40*/routes/*82.46*/.Assets.at("features/village-hall/village-hall.controller.js")),format.raw/*82.108*/("""'></script>

		<!-- Login -->
		<link rel="stylesheet" href='"""),_display_(/*85.33*/routes/*85.39*/.Assets.at("features/login/login.css")),format.raw/*85.77*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*86.40*/routes/*86.46*/.Assets.at("features/login/authentication.service.js")),format.raw/*86.100*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*87.40*/routes/*87.46*/.Assets.at("features/login/login.controller.js")),format.raw/*87.94*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*88.40*/routes/*88.46*/.Assets.at("features/login/logout.controller.js")),format.raw/*88.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*89.40*/routes/*89.46*/.Assets.at("features/login/register.controller.js")),format.raw/*89.97*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*90.40*/routes/*90.46*/.Assets.at("features/login/user.service.js")),format.raw/*90.90*/("""'></script>

		<!-- Parish Council -->
		<link rel="stylesheet" href='"""),_display_(/*93.33*/routes/*93.39*/.Assets.at("features/parish-council/parish-council.css")),format.raw/*93.95*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*94.40*/routes/*94.46*/.Assets.at("features/parish-council/parish-council.controller.js")),format.raw/*94.112*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*95.40*/routes/*95.46*/.Assets.at("features/parish-council/parish-council.services.js")),format.raw/*95.110*/("""'></script>

		<!-- Animated bird -->
		<link rel="stylesheet" href='"""),_display_(/*98.33*/routes/*98.39*/.Assets.at("features/animated-bird/animated-bird.css")),format.raw/*98.93*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*99.40*/routes/*99.46*/.Assets.at("features/animated-bird/animated-bird.directive.js")),format.raw/*99.109*/("""'></script>

		<!-- Community Shop -->
		<link rel="stylesheet" href='"""),_display_(/*102.33*/routes/*102.39*/.Assets.at("features/horsley-community-shop/community-shop.css")),format.raw/*102.103*/("""'/>

	</head>


	<body>

		<div id="page-wrapper">
			<header></header>
			<div class="main-container">
				<div class="main-page-hdr"></div>
				<ng-view class="main-page"></ng-view>
				<div ng-include="'/glos/features/common/page-footer.html'"></div>
			</div>
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
                  DATE: Mon Apr 10 09:51:38 BST 2017
                  SOURCE: /Users/js/Documents/workspace/repositories/HorsleyParish/app/views/index.scala.html
                  HASH: 4614a27979aa85bf4b60c6daa0783e21638e4110
                  MATRIX: 636->67|768->123|781->129|857->121|885->174|913->176|1337->573|1352->579|1436->641|1498->676|1513->682|1599->746|1661->781|1676->787|1754->844|1817->880|1832->886|1883->916|1946->952|1961->958|2008->984|2168->1117|2183->1123|2259->1177|2337->1228|2352->1234|2431->1291|2509->1342|2524->1348|2616->1418|2694->1469|2709->1475|2815->1559|2893->1610|2908->1616|2994->1680|3072->1731|3087->1737|3188->1816|3266->1867|3281->1873|3365->1935|3443->1986|3458->1992|3552->2064|3630->2115|3645->2121|3732->2186|3810->2237|3825->2243|3931->2327|4009->2378|4024->2384|4124->2462|4202->2513|4217->2519|4324->2604|4402->2655|4417->2661|4481->2704|4559->2755|4574->2761|4660->2825|4738->2876|4753->2882|4829->2936|4908->2988|4923->2994|4982->3032|5060->3083|5075->3089|5131->3124|5209->3175|5224->3181|5268->3204|5389->3298|5404->3304|5482->3360|5579->3430|5594->3436|5669->3490|5739->3533|5754->3539|5840->3603|5918->3654|5933->3660|6016->3721|6115->3793|6130->3799|6191->3839|6261->3882|6276->3888|6346->3937|6424->3988|6439->3994|6505->4039|6603->4110|6618->4116|6686->4163|6749->4199|6764->4205|6825->4245|6895->4288|6910->4294|6988->4350|7066->4401|7081->4407|7151->4456|7244->4522|7259->4528|7326->4574|7396->4617|7411->4623|7488->4678|7588->4751|7603->4757|7681->4813|7781->4886|7796->4892|7873->4948|7943->4991|7958->4997|8046->5063|8124->5114|8139->5120|8224->5183|8322->5254|8337->5260|8410->5312|8506->5381|8521->5387|8594->5439|8664->5482|8679->5488|8763->5550|8852->5612|8867->5618|8926->5656|8996->5699|9011->5705|9087->5759|9165->5810|9180->5816|9249->5864|9327->5915|9342->5921|9412->5970|9490->6021|9505->6027|9577->6078|9655->6129|9670->6135|9735->6179|9833->6250|9848->6256|9925->6312|9995->6355|10010->6361|10098->6427|10176->6478|10191->6484|10277->6548|10374->6618|10389->6624|10464->6678|10534->6721|10549->6727|10634->6790|10733->6861|10749->6867|10836->6931
                  LINES: 24->4|28->5|28->5|29->4|30->5|32->7|42->17|42->17|42->17|43->18|43->18|43->18|44->19|44->19|44->19|45->20|45->20|45->20|46->21|46->21|46->21|49->24|49->24|49->24|50->25|50->25|50->25|51->26|51->26|51->26|52->27|52->27|52->27|53->28|53->28|53->28|54->29|54->29|54->29|55->30|55->30|55->30|56->31|56->31|56->31|57->32|57->32|57->32|58->33|58->33|58->33|59->34|59->34|59->34|60->35|60->35|60->35|61->36|61->36|61->36|62->37|62->37|62->37|63->38|63->38|63->38|65->40|65->40|65->40|66->41|66->41|66->41|67->42|67->42|67->42|72->47|72->47|72->47|75->50|75->50|75->50|76->51|76->51|76->51|77->52|77->52|77->52|80->55|80->55|80->55|81->56|81->56|81->56|82->57|82->57|82->57|85->60|85->60|85->60|86->61|86->61|86->61|87->62|87->62|87->62|88->63|88->63|88->63|91->66|91->66|91->66|92->67|92->67|92->67|95->70|95->70|95->70|98->73|98->73|98->73|99->74|99->74|99->74|100->75|100->75|100->75|103->78|103->78|103->78|106->81|106->81|106->81|107->82|107->82|107->82|110->85|110->85|110->85|111->86|111->86|111->86|112->87|112->87|112->87|113->88|113->88|113->88|114->89|114->89|114->89|115->90|115->90|115->90|118->93|118->93|118->93|119->94|119->94|119->94|120->95|120->95|120->95|123->98|123->98|123->98|124->99|124->99|124->99|127->102|127->102|127->102
                  -- GENERATED --
              */
          