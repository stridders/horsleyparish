
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
		<link rel='stylesheet' href='"""),_display_(/*20.33*/routes/*20.39*/.WebJarAssets.at(webJarAssets.locate("angular-material.min.css"))),format.raw/*20.104*/("""'>
		<link rel="stylesheet" href=""""),_display_(/*21.33*/routes/*21.39*/.Assets.at("css/font-awesome-4.6.3/css/font-awesome.css")),format.raw/*21.96*/(""""/>
		<link rel="stylesheet" href=""""),_display_(/*22.33*/routes/*22.39*/.Assets.at("css/OpenSans.css")),format.raw/*22.69*/(""""/>
		<link rel="stylesheet" href=""""),_display_(/*23.33*/routes/*23.39*/.Assets.at("css/main.css")),format.raw/*23.65*/(""""/>
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

		<script type="text/javascript" src='"""),_display_(/*26.40*/routes/*26.46*/.WebJarAssets.at(webJarAssets.locate("jquery.min.js"))),format.raw/*26.100*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*27.40*/routes/*27.46*/.WebJarAssets.at(webJarAssets.locate("bootstrap.min.js"))),format.raw/*27.103*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*28.40*/routes/*28.46*/.WebJarAssets.at(webJarAssets.fullPath("angularjs", "angular.min.js"))),format.raw/*28.116*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*29.40*/routes/*29.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-animate", "angular-animate.min.js"))),format.raw/*29.130*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*30.40*/routes/*30.46*/.WebJarAssets.at(webJarAssets.locate("angular-resource.min.js"))),format.raw/*30.110*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*31.40*/routes/*31.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-route","angular-route.min.js"))),format.raw/*31.125*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*32.40*/routes/*32.46*/.WebJarAssets.at(webJarAssets.locate("angular-filter.min.js"))),format.raw/*32.108*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*33.40*/routes/*33.46*/.WebJarAssets.at(webJarAssets.locate("0.2.18/angular-ui-router.min.js"))),format.raw/*33.118*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*34.40*/routes/*34.46*/.WebJarAssets.at(webJarAssets.locate("ui-bootstrap-tpls.min.js"))),format.raw/*34.111*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*35.40*/routes/*35.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-cookies", "angular-cookies.min.js"))),format.raw/*35.130*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*36.40*/routes/*36.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-aria", "angular-aria.min.js"))),format.raw/*36.124*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*37.40*/routes/*37.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-messages","angular-messages.min.js"))),format.raw/*37.131*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*38.40*/routes/*38.46*/.Assets.at("js/angular-file-upload.min.js")),format.raw/*38.89*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*39.40*/routes/*39.46*/.WebJarAssets.at(webJarAssets.locate("angular-material.min.js"))),format.raw/*39.110*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*40.40*/routes/*40.46*/.WebJarAssets.at(webJarAssets.locate("moment.min.js"))),format.raw/*40.100*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*41.40*/routes/*41.46*/.WebJarAssets.at(webJarAssets.locate("postscribe.min.js"))),format.raw/*41.104*/("""'></script>

		<script type="text/javascript" src='"""),_display_(/*43.40*/routes/*43.46*/.Assets.at("js/controllers.module.js")),format.raw/*43.84*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*44.40*/routes/*44.46*/.Assets.at("js/services.module.js")),format.raw/*44.81*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*45.40*/routes/*45.46*/.Assets.at("js/app.js")),format.raw/*45.69*/("""'></script>

		<!-- Features -->

		<!-- Home-Page -->
		<script type="text/javascript" src='"""),_display_(/*50.40*/routes/*50.46*/.Assets.at("features/home-page/home-page.controller.js")),format.raw/*50.102*/("""'></script>

		<!-- File-Uploader -->
		<link rel="stylesheet" href='"""),_display_(/*53.33*/routes/*53.39*/.Assets.at("features/file-uploader/file-uploader.css")),format.raw/*53.93*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*54.40*/routes/*54.46*/.Assets.at("features/file-uploader/file-uploader.controller.js")),format.raw/*54.110*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*55.40*/routes/*55.46*/.Assets.at("features/file-uploader/file-uploader.service.js")),format.raw/*55.107*/("""'></script>

		<!-- Common Services -->
		<link rel="stylesheet" href='"""),_display_(/*58.33*/routes/*58.39*/.Assets.at("features/common/header.css")),format.raw/*58.79*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*59.40*/routes/*59.46*/.Assets.at("features/common/header.directive.js")),format.raw/*59.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*60.40*/routes/*60.46*/.Assets.at("features/flash/flash.service.js")),format.raw/*60.91*/("""'></script>

		<!-- Navigation Bar -->
		<link rel="stylesheet" href='"""),_display_(/*63.33*/routes/*63.39*/.Assets.at("features/navbar/navbar-button.css")),format.raw/*63.86*/("""'/>
		<link rel="stylesheet" href='"""),_display_(/*64.33*/routes/*64.39*/.Assets.at("features/navbar/navbar.css")),format.raw/*64.79*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*65.40*/routes/*65.46*/.Assets.at("features/navbar/navbar-button.directive.js")),format.raw/*65.102*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*66.40*/routes/*66.46*/.Assets.at("features/navbar/navbar.directive.js")),format.raw/*66.95*/("""'></script>

		<!-- Page-Tabs -->
		<link rel="stylesheet" href='"""),_display_(/*69.33*/routes/*69.39*/.Assets.at("features/page-tabs/page-tabs.css")),format.raw/*69.85*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*70.40*/routes/*70.46*/.Assets.at("features/page-tabs/page-tabs.directive.js")),format.raw/*70.101*/("""'></script>

		<!-- Home-Page -->
		<script type="text/javascript" src='"""),_display_(/*73.40*/routes/*73.46*/.Assets.at("features/home-page/home-page.controller.js")),format.raw/*73.102*/("""'></script>

		<!-- The Horses Mouth -->
		<link rel="stylesheet" href='"""),_display_(/*76.33*/routes/*76.39*/.Assets.at("features/the-horses-mouth/horses-mouth.css")),format.raw/*76.95*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*77.40*/routes/*77.46*/.Assets.at("features/the-horses-mouth/horses-mouth.controller.js")),format.raw/*77.112*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*78.40*/routes/*78.46*/.Assets.at("features/the-horses-mouth/horses-mouth.service.js")),format.raw/*78.109*/("""'></script>

		<!-- History -->
		<script type="text/javascript" src='"""),_display_(/*81.40*/routes/*81.46*/.Assets.at("features/history/history.controller.js")),format.raw/*81.98*/("""'></script>

		<!-- Village Hall -->
		<link rel="stylesheet" href='"""),_display_(/*84.33*/routes/*84.39*/.Assets.at("features/village-hall/village-hall.css")),format.raw/*84.91*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*85.40*/routes/*85.46*/.Assets.at("features/village-hall/village-hall.controller.js")),format.raw/*85.108*/("""'></script>

		<!-- Login -->
		<link rel="stylesheet" href='"""),_display_(/*88.33*/routes/*88.39*/.Assets.at("features/login/login.css")),format.raw/*88.77*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*89.40*/routes/*89.46*/.Assets.at("features/login/authentication.service.js")),format.raw/*89.100*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*90.40*/routes/*90.46*/.Assets.at("features/login/login.controller.js")),format.raw/*90.94*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*91.40*/routes/*91.46*/.Assets.at("features/login/logout.controller.js")),format.raw/*91.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*92.40*/routes/*92.46*/.Assets.at("features/login/register.controller.js")),format.raw/*92.97*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*93.40*/routes/*93.46*/.Assets.at("features/login/user.service.js")),format.raw/*93.90*/("""'></script>

		<!-- Parish Council -->
		<link rel="stylesheet" href='"""),_display_(/*96.33*/routes/*96.39*/.Assets.at("features/parish-council/parish-council.css")),format.raw/*96.95*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*97.40*/routes/*97.46*/.Assets.at("features/parish-council/parish-council.controller.js")),format.raw/*97.112*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*98.40*/routes/*98.46*/.Assets.at("features/parish-council/parish-council.services.js")),format.raw/*98.110*/("""'></script>

		<!-- Animated bird -->
		<link rel="stylesheet" href='"""),_display_(/*101.33*/routes/*101.39*/.Assets.at("features/animated-bird/animated-bird.css")),format.raw/*101.93*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*102.40*/routes/*102.46*/.Assets.at("features/animated-bird/animated-bird.directive.js")),format.raw/*102.109*/("""'></script>

		<!-- Community Shop -->
		<link rel="stylesheet" href='"""),_display_(/*105.33*/routes/*105.39*/.Assets.at("features/horsley-community-shop/community-shop.css")),format.raw/*105.103*/("""'/>

		<!-- User Admin -->
		<script type="text/javascript" src='"""),_display_(/*108.40*/routes/*108.46*/.Assets.at("admin/users/users.controller.js")),format.raw/*108.91*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*109.40*/routes/*109.46*/.Assets.at("admin/users/users.service.js")),format.raw/*109.88*/("""'></script>
		<link rel="stylesheet" href='"""),_display_(/*110.33*/routes/*110.39*/.Assets.at("admin/users/users.css")),format.raw/*110.74*/("""'/>


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
                  DATE: Tue May 30 18:32:45 BST 2017
                  SOURCE: /Users/jstride/Documents/workspace/repository/horsleyparish/app/views/index.scala.html
                  HASH: a254aea0c9c2c7b997fe34aa9aa25858f92d5e3b
                  MATRIX: 636->67|768->123|781->129|857->121|885->174|913->176|1434->670|1449->676|1533->738|1595->773|1610->779|1696->843|1758->878|1773->884|1860->949|1922->984|1937->990|2015->1047|2078->1083|2093->1089|2144->1119|2207->1155|2222->1161|2269->1187|2429->1320|2444->1326|2520->1380|2598->1431|2613->1437|2692->1494|2770->1545|2785->1551|2877->1621|2955->1672|2970->1678|3076->1762|3154->1813|3169->1819|3255->1883|3333->1934|3348->1940|3449->2019|3527->2070|3542->2076|3626->2138|3704->2189|3719->2195|3813->2267|3891->2318|3906->2324|3993->2389|4071->2440|4086->2446|4192->2530|4270->2581|4285->2587|4385->2665|4463->2716|4478->2722|4585->2807|4663->2858|4678->2864|4742->2907|4820->2958|4835->2964|4921->3028|4999->3079|5014->3085|5090->3139|5168->3190|5183->3196|5263->3254|5342->3306|5357->3312|5416->3350|5494->3401|5509->3407|5565->3442|5643->3493|5658->3499|5702->3522|5823->3616|5838->3622|5916->3678|6013->3748|6028->3754|6103->3808|6173->3851|6188->3857|6274->3921|6352->3972|6367->3978|6450->4039|6549->4111|6564->4117|6625->4157|6695->4200|6710->4206|6780->4255|6858->4306|6873->4312|6939->4357|7037->4428|7052->4434|7120->4481|7183->4517|7198->4523|7259->4563|7329->4606|7344->4612|7422->4668|7500->4719|7515->4725|7585->4774|7678->4840|7693->4846|7760->4892|7830->4935|7845->4941|7922->4996|8022->5069|8037->5075|8115->5131|8215->5204|8230->5210|8307->5266|8377->5309|8392->5315|8480->5381|8558->5432|8573->5438|8658->5501|8756->5572|8771->5578|8844->5630|8940->5699|8955->5705|9028->5757|9098->5800|9113->5806|9197->5868|9286->5930|9301->5936|9360->5974|9430->6017|9445->6023|9521->6077|9599->6128|9614->6134|9683->6182|9761->6233|9776->6239|9846->6288|9924->6339|9939->6345|10011->6396|10089->6447|10104->6453|10169->6497|10267->6568|10282->6574|10359->6630|10429->6673|10444->6679|10532->6745|10610->6796|10625->6802|10711->6866|10809->6936|10825->6942|10901->6996|10972->7039|10988->7045|11074->7108|11173->7179|11189->7185|11276->7249|11370->7315|11386->7321|11453->7366|11532->7417|11548->7423|11612->7465|11684->7509|11700->7515|11757->7550
                  LINES: 24->4|28->5|28->5|29->4|30->5|32->7|43->18|43->18|43->18|44->19|44->19|44->19|45->20|45->20|45->20|46->21|46->21|46->21|47->22|47->22|47->22|48->23|48->23|48->23|51->26|51->26|51->26|52->27|52->27|52->27|53->28|53->28|53->28|54->29|54->29|54->29|55->30|55->30|55->30|56->31|56->31|56->31|57->32|57->32|57->32|58->33|58->33|58->33|59->34|59->34|59->34|60->35|60->35|60->35|61->36|61->36|61->36|62->37|62->37|62->37|63->38|63->38|63->38|64->39|64->39|64->39|65->40|65->40|65->40|66->41|66->41|66->41|68->43|68->43|68->43|69->44|69->44|69->44|70->45|70->45|70->45|75->50|75->50|75->50|78->53|78->53|78->53|79->54|79->54|79->54|80->55|80->55|80->55|83->58|83->58|83->58|84->59|84->59|84->59|85->60|85->60|85->60|88->63|88->63|88->63|89->64|89->64|89->64|90->65|90->65|90->65|91->66|91->66|91->66|94->69|94->69|94->69|95->70|95->70|95->70|98->73|98->73|98->73|101->76|101->76|101->76|102->77|102->77|102->77|103->78|103->78|103->78|106->81|106->81|106->81|109->84|109->84|109->84|110->85|110->85|110->85|113->88|113->88|113->88|114->89|114->89|114->89|115->90|115->90|115->90|116->91|116->91|116->91|117->92|117->92|117->92|118->93|118->93|118->93|121->96|121->96|121->96|122->97|122->97|122->97|123->98|123->98|123->98|126->101|126->101|126->101|127->102|127->102|127->102|130->105|130->105|130->105|133->108|133->108|133->108|134->109|134->109|134->109|135->110|135->110|135->110
                  -- GENERATED --
              */
          