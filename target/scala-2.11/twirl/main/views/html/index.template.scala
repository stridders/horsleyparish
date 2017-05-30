
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
		<script type="text/javascript" src='"""),_display_(/*40.40*/routes/*40.46*/.WebJarAssets.at(webJarAssets.locate("postscribe.min.js"))),format.raw/*40.104*/("""'></script>

		<script type="text/javascript" src='"""),_display_(/*42.40*/routes/*42.46*/.Assets.at("js/controllers.module.js")),format.raw/*42.84*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*43.40*/routes/*43.46*/.Assets.at("js/services.module.js")),format.raw/*43.81*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*44.40*/routes/*44.46*/.Assets.at("js/app.js")),format.raw/*44.69*/("""'></script>

		<!-- Features -->

		<!-- Home-Page -->
		<script type="text/javascript" src='"""),_display_(/*49.40*/routes/*49.46*/.Assets.at("features/home-page/home-page.controller.js")),format.raw/*49.102*/("""'></script>

		<!-- File-Uploader -->
		<link rel="stylesheet" href='"""),_display_(/*52.33*/routes/*52.39*/.Assets.at("features/file-uploader/file-uploader.css")),format.raw/*52.93*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*53.40*/routes/*53.46*/.Assets.at("features/file-uploader/file-uploader.controller.js")),format.raw/*53.110*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*54.40*/routes/*54.46*/.Assets.at("features/file-uploader/file-uploader.service.js")),format.raw/*54.107*/("""'></script>

		<!-- Common Services -->
		<link rel="stylesheet" href='"""),_display_(/*57.33*/routes/*57.39*/.Assets.at("features/common/header.css")),format.raw/*57.79*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*58.40*/routes/*58.46*/.Assets.at("features/common/header.directive.js")),format.raw/*58.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*59.40*/routes/*59.46*/.Assets.at("features/flash/flash.service.js")),format.raw/*59.91*/("""'></script>

		<!-- Navigation Bar -->
		<link rel="stylesheet" href='"""),_display_(/*62.33*/routes/*62.39*/.Assets.at("features/navbar/navbar-button.css")),format.raw/*62.86*/("""'/>
		<link rel="stylesheet" href='"""),_display_(/*63.33*/routes/*63.39*/.Assets.at("features/navbar/navbar.css")),format.raw/*63.79*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*64.40*/routes/*64.46*/.Assets.at("features/navbar/navbar-button.directive.js")),format.raw/*64.102*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*65.40*/routes/*65.46*/.Assets.at("features/navbar/navbar.directive.js")),format.raw/*65.95*/("""'></script>

		<!-- Page-Tabs -->
		<link rel="stylesheet" href='"""),_display_(/*68.33*/routes/*68.39*/.Assets.at("features/page-tabs/page-tabs.css")),format.raw/*68.85*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*69.40*/routes/*69.46*/.Assets.at("features/page-tabs/page-tabs.directive.js")),format.raw/*69.101*/("""'></script>

		<!-- Home-Page -->
		<script type="text/javascript" src='"""),_display_(/*72.40*/routes/*72.46*/.Assets.at("features/home-page/home-page.controller.js")),format.raw/*72.102*/("""'></script>

		<!-- The Horses Mouth -->
		<link rel="stylesheet" href='"""),_display_(/*75.33*/routes/*75.39*/.Assets.at("features/the-horses-mouth/horses-mouth.css")),format.raw/*75.95*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*76.40*/routes/*76.46*/.Assets.at("features/the-horses-mouth/horses-mouth.controller.js")),format.raw/*76.112*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*77.40*/routes/*77.46*/.Assets.at("features/the-horses-mouth/horses-mouth.service.js")),format.raw/*77.109*/("""'></script>

		<!-- History -->
		<script type="text/javascript" src='"""),_display_(/*80.40*/routes/*80.46*/.Assets.at("features/history/history.controller.js")),format.raw/*80.98*/("""'></script>

		<!-- Village Hall -->
		<link rel="stylesheet" href='"""),_display_(/*83.33*/routes/*83.39*/.Assets.at("features/village-hall/village-hall.css")),format.raw/*83.91*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*84.40*/routes/*84.46*/.Assets.at("features/village-hall/village-hall.controller.js")),format.raw/*84.108*/("""'></script>

		<!-- Login -->
		<link rel="stylesheet" href='"""),_display_(/*87.33*/routes/*87.39*/.Assets.at("features/login/login.css")),format.raw/*87.77*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*88.40*/routes/*88.46*/.Assets.at("features/login/authentication.service.js")),format.raw/*88.100*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*89.40*/routes/*89.46*/.Assets.at("features/login/login.controller.js")),format.raw/*89.94*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*90.40*/routes/*90.46*/.Assets.at("features/login/logout.controller.js")),format.raw/*90.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*91.40*/routes/*91.46*/.Assets.at("features/login/register.controller.js")),format.raw/*91.97*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*92.40*/routes/*92.46*/.Assets.at("features/login/user.service.js")),format.raw/*92.90*/("""'></script>

		<!-- Parish Council -->
		<link rel="stylesheet" href='"""),_display_(/*95.33*/routes/*95.39*/.Assets.at("features/parish-council/parish-council.css")),format.raw/*95.95*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*96.40*/routes/*96.46*/.Assets.at("features/parish-council/parish-council.controller.js")),format.raw/*96.112*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*97.40*/routes/*97.46*/.Assets.at("features/parish-council/parish-council.services.js")),format.raw/*97.110*/("""'></script>

		<!-- Animated bird -->
		<link rel="stylesheet" href='"""),_display_(/*100.33*/routes/*100.39*/.Assets.at("features/animated-bird/animated-bird.css")),format.raw/*100.93*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*101.40*/routes/*101.46*/.Assets.at("features/animated-bird/animated-bird.directive.js")),format.raw/*101.109*/("""'></script>

		<!-- Community Shop -->
		<link rel="stylesheet" href='"""),_display_(/*104.33*/routes/*104.39*/.Assets.at("features/horsley-community-shop/community-shop.css")),format.raw/*104.103*/("""'/>

		<!-- User Admin -->
		<link rel="stylesheet" href='"""),_display_(/*107.33*/routes/*107.39*/.Assets.at("admin/users/users.css")),format.raw/*107.74*/("""'/>


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
                  DATE: Mon May 29 11:09:50 BST 2017
                  SOURCE: /Users/js/Documents/workspace/repositories/HorsleyParish/app/views/index.scala.html
                  HASH: 64cf37d7a639fef7fed39eda6775b3dc58beb824
                  MATRIX: 636->67|768->123|781->129|857->121|885->174|913->176|1434->670|1449->676|1533->738|1595->773|1610->779|1696->843|1758->878|1773->884|1851->941|1914->977|1929->983|1980->1013|2043->1049|2058->1055|2105->1081|2265->1214|2280->1220|2356->1274|2434->1325|2449->1331|2528->1388|2606->1439|2621->1445|2713->1515|2791->1566|2806->1572|2912->1656|2990->1707|3005->1713|3091->1777|3169->1828|3184->1834|3285->1913|3363->1964|3378->1970|3462->2032|3540->2083|3555->2089|3649->2161|3727->2212|3742->2218|3829->2283|3907->2334|3922->2340|4028->2424|4106->2475|4121->2481|4221->2559|4299->2610|4314->2616|4421->2701|4499->2752|4514->2758|4578->2801|4656->2852|4671->2858|4757->2922|4835->2973|4850->2979|4926->3033|5004->3084|5019->3090|5099->3148|5178->3200|5193->3206|5252->3244|5330->3295|5345->3301|5401->3336|5479->3387|5494->3393|5538->3416|5659->3510|5674->3516|5752->3572|5849->3642|5864->3648|5939->3702|6009->3745|6024->3751|6110->3815|6188->3866|6203->3872|6286->3933|6385->4005|6400->4011|6461->4051|6531->4094|6546->4100|6616->4149|6694->4200|6709->4206|6775->4251|6873->4322|6888->4328|6956->4375|7019->4411|7034->4417|7095->4457|7165->4500|7180->4506|7258->4562|7336->4613|7351->4619|7421->4668|7514->4734|7529->4740|7596->4786|7666->4829|7681->4835|7758->4890|7858->4963|7873->4969|7951->5025|8051->5098|8066->5104|8143->5160|8213->5203|8228->5209|8316->5275|8394->5326|8409->5332|8494->5395|8592->5466|8607->5472|8680->5524|8776->5593|8791->5599|8864->5651|8934->5694|8949->5700|9033->5762|9122->5824|9137->5830|9196->5868|9266->5911|9281->5917|9357->5971|9435->6022|9450->6028|9519->6076|9597->6127|9612->6133|9682->6182|9760->6233|9775->6239|9847->6290|9925->6341|9940->6347|10005->6391|10103->6462|10118->6468|10195->6524|10265->6567|10280->6573|10368->6639|10446->6690|10461->6696|10547->6760|10645->6830|10661->6836|10737->6890|10808->6933|10824->6939|10910->7002|11009->7073|11025->7079|11112->7143|11199->7202|11215->7208|11272->7243
                  LINES: 24->4|28->5|28->5|29->4|30->5|32->7|43->18|43->18|43->18|44->19|44->19|44->19|45->20|45->20|45->20|46->21|46->21|46->21|47->22|47->22|47->22|50->25|50->25|50->25|51->26|51->26|51->26|52->27|52->27|52->27|53->28|53->28|53->28|54->29|54->29|54->29|55->30|55->30|55->30|56->31|56->31|56->31|57->32|57->32|57->32|58->33|58->33|58->33|59->34|59->34|59->34|60->35|60->35|60->35|61->36|61->36|61->36|62->37|62->37|62->37|63->38|63->38|63->38|64->39|64->39|64->39|65->40|65->40|65->40|67->42|67->42|67->42|68->43|68->43|68->43|69->44|69->44|69->44|74->49|74->49|74->49|77->52|77->52|77->52|78->53|78->53|78->53|79->54|79->54|79->54|82->57|82->57|82->57|83->58|83->58|83->58|84->59|84->59|84->59|87->62|87->62|87->62|88->63|88->63|88->63|89->64|89->64|89->64|90->65|90->65|90->65|93->68|93->68|93->68|94->69|94->69|94->69|97->72|97->72|97->72|100->75|100->75|100->75|101->76|101->76|101->76|102->77|102->77|102->77|105->80|105->80|105->80|108->83|108->83|108->83|109->84|109->84|109->84|112->87|112->87|112->87|113->88|113->88|113->88|114->89|114->89|114->89|115->90|115->90|115->90|116->91|116->91|116->91|117->92|117->92|117->92|120->95|120->95|120->95|121->96|121->96|121->96|122->97|122->97|122->97|125->100|125->100|125->100|126->101|126->101|126->101|129->104|129->104|129->104|132->107|132->107|132->107
                  -- GENERATED --
              */
          