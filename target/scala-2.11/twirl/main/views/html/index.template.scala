
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
		<meta name="google-site-verification" content="nbyjTQkiGZlYdvNNLwxiTv5uk3HI5SMP-PIQtP-msZQ" />

		<title>Horsley Parish, Gloucestershire, Community website</title>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
		<meta name="viewport" content="width=device-width"/>

		<link rel='stylesheet' href='"""),_display_(/*18.33*/routes/*18.39*/.WebJarAssets.at(webJarAssets.locate("css/bootstrap.min.css"))),format.raw/*18.101*/("""'>
		<link rel='stylesheet' href='"""),_display_(/*19.33*/routes/*19.39*/.WebJarAssets.at(webJarAssets.locate("css/bootstrap-theme.css"))),format.raw/*19.103*/("""'>
		<link rel="stylesheet" href=""""),_display_(/*20.33*/routes/*20.39*/.Assets.at("css/font-awesome-4.6.3/css/font-awesome.css")),format.raw/*20.96*/(""""/>
		<link rel="stylesheet" href=""""),_display_(/*21.33*/routes/*21.39*/.Assets.at("css/OpenSans.css")),format.raw/*21.69*/(""""/>
		<link rel="stylesheet" href=""""),_display_(/*22.33*/routes/*22.39*/.Assets.at("css/main.css")),format.raw/*22.65*/(""""/>
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

		<script type="text/javascript" src='"""),_display_(/*25.40*/routes/*25.46*/.WebJarAssets.at(webJarAssets.locate("jquery.min.js"))),format.raw/*25.100*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*26.40*/routes/*26.46*/.WebJarAssets.at(webJarAssets.locate("bootstrap.min.js"))),format.raw/*26.103*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*27.40*/routes/*27.46*/.WebJarAssets.at(webJarAssets.fullPath("angularjs", "angular.min.js"))),format.raw/*27.116*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*28.40*/routes/*28.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-animate", "angular-animate.min.js"))),format.raw/*28.130*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*29.40*/routes/*29.46*/.WebJarAssets.at(webJarAssets.locate("angular-resource.min.js"))),format.raw/*29.110*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*30.40*/routes/*30.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-route","angular-route.min.js"))),format.raw/*30.125*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*31.40*/routes/*31.46*/.WebJarAssets.at(webJarAssets.locate("angular-filter.min.js"))),format.raw/*31.108*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*32.40*/routes/*32.46*/.WebJarAssets.at(webJarAssets.locate("0.2.18/angular-ui-router.min.js"))),format.raw/*32.118*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*33.40*/routes/*33.46*/.WebJarAssets.at(webJarAssets.locate("ui-bootstrap-tpls.min.js"))),format.raw/*33.111*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*34.40*/routes/*34.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-cookies", "angular-cookies.min.js"))),format.raw/*34.130*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*35.40*/routes/*35.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-aria", "angular-aria.min.js"))),format.raw/*35.124*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*36.40*/routes/*36.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-messages","angular-messages.min.js"))),format.raw/*36.131*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*37.40*/routes/*37.46*/.Assets.at("js/angular-file-upload.min.js")),format.raw/*37.89*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*38.40*/routes/*38.46*/.WebJarAssets.at(webJarAssets.locate("angular-material.min.js"))),format.raw/*38.110*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*39.40*/routes/*39.46*/.WebJarAssets.at(webJarAssets.locate("moment.min.js"))),format.raw/*39.100*/("""'></script>

		<script type="text/javascript" src='"""),_display_(/*41.40*/routes/*41.46*/.Assets.at("js/controllers.module.js")),format.raw/*41.84*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*42.40*/routes/*42.46*/.Assets.at("js/services.module.js")),format.raw/*42.81*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*43.40*/routes/*43.46*/.Assets.at("js/app.js")),format.raw/*43.69*/("""'></script>

		<!-- Features -->

		<!-- Home-Page -->
		<script type="text/javascript" src='"""),_display_(/*48.40*/routes/*48.46*/.Assets.at("features/home-page/home-page.controller.js")),format.raw/*48.102*/("""'></script>

		<!-- File-Uploader -->
		<link rel="stylesheet" href='"""),_display_(/*51.33*/routes/*51.39*/.Assets.at("features/file-uploader/file-uploader.css")),format.raw/*51.93*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*52.40*/routes/*52.46*/.Assets.at("features/file-uploader/file-uploader.controller.js")),format.raw/*52.110*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*53.40*/routes/*53.46*/.Assets.at("features/file-uploader/file-uploader.service.js")),format.raw/*53.107*/("""'></script>

		<!-- Common Services -->
		<link rel="stylesheet" href='"""),_display_(/*56.33*/routes/*56.39*/.Assets.at("features/common/header.css")),format.raw/*56.79*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*57.40*/routes/*57.46*/.Assets.at("features/common/header.directive.js")),format.raw/*57.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*58.40*/routes/*58.46*/.Assets.at("features/flash/flash.service.js")),format.raw/*58.91*/("""'></script>

		<!-- Navigation Bar -->
		<link rel="stylesheet" href='"""),_display_(/*61.33*/routes/*61.39*/.Assets.at("features/navbar/navbar-button.css")),format.raw/*61.86*/("""'/>
		<link rel="stylesheet" href='"""),_display_(/*62.33*/routes/*62.39*/.Assets.at("features/navbar/navbar.css")),format.raw/*62.79*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*63.40*/routes/*63.46*/.Assets.at("features/navbar/navbar-button.directive.js")),format.raw/*63.102*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*64.40*/routes/*64.46*/.Assets.at("features/navbar/navbar.directive.js")),format.raw/*64.95*/("""'></script>

		<!-- Page-Tabs -->
		<link rel="stylesheet" href='"""),_display_(/*67.33*/routes/*67.39*/.Assets.at("features/page-tabs/page-tabs.css")),format.raw/*67.85*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*68.40*/routes/*68.46*/.Assets.at("features/page-tabs/page-tabs.directive.js")),format.raw/*68.101*/("""'></script>

		<!-- Home-Page -->
		<script type="text/javascript" src='"""),_display_(/*71.40*/routes/*71.46*/.Assets.at("features/home-page/home-page.controller.js")),format.raw/*71.102*/("""'></script>

		<!-- The Horses Mouth -->
		<link rel="stylesheet" href='"""),_display_(/*74.33*/routes/*74.39*/.Assets.at("features/the-horses-mouth/horses-mouth.css")),format.raw/*74.95*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*75.40*/routes/*75.46*/.Assets.at("features/the-horses-mouth/horses-mouth.controller.js")),format.raw/*75.112*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*76.40*/routes/*76.46*/.Assets.at("features/the-horses-mouth/horses-mouth.service.js")),format.raw/*76.109*/("""'></script>

		<!-- History -->
		<script type="text/javascript" src='"""),_display_(/*79.40*/routes/*79.46*/.Assets.at("features/history/history.controller.js")),format.raw/*79.98*/("""'></script>

		<!-- Village Hall -->
		<link rel="stylesheet" href='"""),_display_(/*82.33*/routes/*82.39*/.Assets.at("features/village-hall/village-hall.css")),format.raw/*82.91*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*83.40*/routes/*83.46*/.Assets.at("features/village-hall/village-hall.controller.js")),format.raw/*83.108*/("""'></script>

		<!-- Login -->
		<link rel="stylesheet" href='"""),_display_(/*86.33*/routes/*86.39*/.Assets.at("features/login/login.css")),format.raw/*86.77*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*87.40*/routes/*87.46*/.Assets.at("features/login/authentication.service.js")),format.raw/*87.100*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*88.40*/routes/*88.46*/.Assets.at("features/login/login.controller.js")),format.raw/*88.94*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*89.40*/routes/*89.46*/.Assets.at("features/login/logout.controller.js")),format.raw/*89.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*90.40*/routes/*90.46*/.Assets.at("features/login/register.controller.js")),format.raw/*90.97*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*91.40*/routes/*91.46*/.Assets.at("features/login/user.service.js")),format.raw/*91.90*/("""'></script>

		<!-- Parish Council -->
		<link rel="stylesheet" href='"""),_display_(/*94.33*/routes/*94.39*/.Assets.at("features/parish-council/parish-council.css")),format.raw/*94.95*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*95.40*/routes/*95.46*/.Assets.at("features/parish-council/parish-council.controller.js")),format.raw/*95.112*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*96.40*/routes/*96.46*/.Assets.at("features/parish-council/parish-council.services.js")),format.raw/*96.110*/("""'></script>

		<!-- Animated bird -->
		<link rel="stylesheet" href='"""),_display_(/*99.33*/routes/*99.39*/.Assets.at("features/animated-bird/animated-bird.css")),format.raw/*99.93*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*100.40*/routes/*100.46*/.Assets.at("features/animated-bird/animated-bird.directive.js")),format.raw/*100.109*/("""'></script>

		<!-- Community Shop -->
		<link rel="stylesheet" href='"""),_display_(/*103.33*/routes/*103.39*/.Assets.at("features/horsley-community-shop/community-shop.css")),format.raw/*103.103*/("""'/>

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
                  DATE: Fri Apr 21 13:46:02 BST 2017
                  SOURCE: /Users/js/Documents/workspace/repositories/HorsleyParish/app/views/index.scala.html
                  HASH: f0ae2ff8ddd68f4cdbe7dc19cf28d95741057d95
                  MATRIX: 636->67|768->123|781->129|857->121|885->174|913->176|1434->670|1449->676|1533->738|1595->773|1610->779|1696->843|1758->878|1773->884|1851->941|1914->977|1929->983|1980->1013|2043->1049|2058->1055|2105->1081|2265->1214|2280->1220|2356->1274|2434->1325|2449->1331|2528->1388|2606->1439|2621->1445|2713->1515|2791->1566|2806->1572|2912->1656|2990->1707|3005->1713|3091->1777|3169->1828|3184->1834|3285->1913|3363->1964|3378->1970|3462->2032|3540->2083|3555->2089|3649->2161|3727->2212|3742->2218|3829->2283|3907->2334|3922->2340|4028->2424|4106->2475|4121->2481|4221->2559|4299->2610|4314->2616|4421->2701|4499->2752|4514->2758|4578->2801|4656->2852|4671->2858|4757->2922|4835->2973|4850->2979|4926->3033|5005->3085|5020->3091|5079->3129|5157->3180|5172->3186|5228->3221|5306->3272|5321->3278|5365->3301|5486->3395|5501->3401|5579->3457|5676->3527|5691->3533|5766->3587|5836->3630|5851->3636|5937->3700|6015->3751|6030->3757|6113->3818|6212->3890|6227->3896|6288->3936|6358->3979|6373->3985|6443->4034|6521->4085|6536->4091|6602->4136|6700->4207|6715->4213|6783->4260|6846->4296|6861->4302|6922->4342|6992->4385|7007->4391|7085->4447|7163->4498|7178->4504|7248->4553|7341->4619|7356->4625|7423->4671|7493->4714|7508->4720|7585->4775|7685->4848|7700->4854|7778->4910|7878->4983|7893->4989|7970->5045|8040->5088|8055->5094|8143->5160|8221->5211|8236->5217|8321->5280|8419->5351|8434->5357|8507->5409|8603->5478|8618->5484|8691->5536|8761->5579|8776->5585|8860->5647|8949->5709|8964->5715|9023->5753|9093->5796|9108->5802|9184->5856|9262->5907|9277->5913|9346->5961|9424->6012|9439->6018|9509->6067|9587->6118|9602->6124|9674->6175|9752->6226|9767->6232|9832->6276|9930->6347|9945->6353|10022->6409|10092->6452|10107->6458|10195->6524|10273->6575|10288->6581|10374->6645|10471->6715|10486->6721|10561->6775|10632->6818|10648->6824|10734->6887|10833->6958|10849->6964|10936->7028
                  LINES: 24->4|28->5|28->5|29->4|30->5|32->7|43->18|43->18|43->18|44->19|44->19|44->19|45->20|45->20|45->20|46->21|46->21|46->21|47->22|47->22|47->22|50->25|50->25|50->25|51->26|51->26|51->26|52->27|52->27|52->27|53->28|53->28|53->28|54->29|54->29|54->29|55->30|55->30|55->30|56->31|56->31|56->31|57->32|57->32|57->32|58->33|58->33|58->33|59->34|59->34|59->34|60->35|60->35|60->35|61->36|61->36|61->36|62->37|62->37|62->37|63->38|63->38|63->38|64->39|64->39|64->39|66->41|66->41|66->41|67->42|67->42|67->42|68->43|68->43|68->43|73->48|73->48|73->48|76->51|76->51|76->51|77->52|77->52|77->52|78->53|78->53|78->53|81->56|81->56|81->56|82->57|82->57|82->57|83->58|83->58|83->58|86->61|86->61|86->61|87->62|87->62|87->62|88->63|88->63|88->63|89->64|89->64|89->64|92->67|92->67|92->67|93->68|93->68|93->68|96->71|96->71|96->71|99->74|99->74|99->74|100->75|100->75|100->75|101->76|101->76|101->76|104->79|104->79|104->79|107->82|107->82|107->82|108->83|108->83|108->83|111->86|111->86|111->86|112->87|112->87|112->87|113->88|113->88|113->88|114->89|114->89|114->89|115->90|115->90|115->90|116->91|116->91|116->91|119->94|119->94|119->94|120->95|120->95|120->95|121->96|121->96|121->96|124->99|124->99|124->99|125->100|125->100|125->100|128->103|128->103|128->103
                  -- GENERATED --
              */
          