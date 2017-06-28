
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
		<meta name="Description" CONTENT="The community website for Horsley, Gloucestershire">
		<meta name="google-site-verification" content="nbyjTQkiGZlYdvNNLwxiTv5uk3HI5SMP-PIQtP-msZQ" />

		<title>Horsley (Gloucestershire) Community website</title>
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
                  DATE: Wed Jun 28 08:48:59 BST 2017
                  SOURCE: /Users/js/Documents/workspace/repositories/HorsleyParish/app/views/index.scala.html
                  HASH: 4c3b993a9ceaad96d844d2be6b881c43ee97e239
                  MATRIX: 636->67|768->123|781->129|857->121|885->174|913->176|1420->656|1435->662|1519->724|1581->759|1596->765|1682->829|1744->864|1759->870|1846->935|1908->970|1923->976|2001->1033|2064->1069|2079->1075|2130->1105|2193->1141|2208->1147|2255->1173|2415->1306|2430->1312|2506->1366|2584->1417|2599->1423|2678->1480|2756->1531|2771->1537|2863->1607|2941->1658|2956->1664|3062->1748|3140->1799|3155->1805|3241->1869|3319->1920|3334->1926|3435->2005|3513->2056|3528->2062|3612->2124|3690->2175|3705->2181|3799->2253|3877->2304|3892->2310|3979->2375|4057->2426|4072->2432|4178->2516|4256->2567|4271->2573|4371->2651|4449->2702|4464->2708|4571->2793|4649->2844|4664->2850|4728->2893|4806->2944|4821->2950|4907->3014|4985->3065|5000->3071|5076->3125|5154->3176|5169->3182|5249->3240|5328->3292|5343->3298|5402->3336|5480->3387|5495->3393|5551->3428|5629->3479|5644->3485|5688->3508|5809->3602|5824->3608|5902->3664|5999->3734|6014->3740|6089->3794|6159->3837|6174->3843|6260->3907|6338->3958|6353->3964|6436->4025|6535->4097|6550->4103|6611->4143|6681->4186|6696->4192|6766->4241|6844->4292|6859->4298|6925->4343|7023->4414|7038->4420|7106->4467|7169->4503|7184->4509|7245->4549|7315->4592|7330->4598|7408->4654|7486->4705|7501->4711|7571->4760|7664->4826|7679->4832|7746->4878|7816->4921|7831->4927|7908->4982|8008->5055|8023->5061|8101->5117|8201->5190|8216->5196|8293->5252|8363->5295|8378->5301|8466->5367|8544->5418|8559->5424|8644->5487|8742->5558|8757->5564|8830->5616|8926->5685|8941->5691|9014->5743|9084->5786|9099->5792|9183->5854|9272->5916|9287->5922|9346->5960|9416->6003|9431->6009|9507->6063|9585->6114|9600->6120|9669->6168|9747->6219|9762->6225|9832->6274|9910->6325|9925->6331|9997->6382|10075->6433|10090->6439|10155->6483|10253->6554|10268->6560|10345->6616|10415->6659|10430->6665|10518->6731|10596->6782|10611->6788|10697->6852|10795->6922|10811->6928|10887->6982|10958->7025|10974->7031|11060->7094|11159->7165|11175->7171|11262->7235|11356->7301|11372->7307|11439->7352|11518->7403|11534->7409|11598->7451|11670->7495|11686->7501|11743->7536
                  LINES: 24->4|28->5|28->5|29->4|30->5|32->7|43->18|43->18|43->18|44->19|44->19|44->19|45->20|45->20|45->20|46->21|46->21|46->21|47->22|47->22|47->22|48->23|48->23|48->23|51->26|51->26|51->26|52->27|52->27|52->27|53->28|53->28|53->28|54->29|54->29|54->29|55->30|55->30|55->30|56->31|56->31|56->31|57->32|57->32|57->32|58->33|58->33|58->33|59->34|59->34|59->34|60->35|60->35|60->35|61->36|61->36|61->36|62->37|62->37|62->37|63->38|63->38|63->38|64->39|64->39|64->39|65->40|65->40|65->40|66->41|66->41|66->41|68->43|68->43|68->43|69->44|69->44|69->44|70->45|70->45|70->45|75->50|75->50|75->50|78->53|78->53|78->53|79->54|79->54|79->54|80->55|80->55|80->55|83->58|83->58|83->58|84->59|84->59|84->59|85->60|85->60|85->60|88->63|88->63|88->63|89->64|89->64|89->64|90->65|90->65|90->65|91->66|91->66|91->66|94->69|94->69|94->69|95->70|95->70|95->70|98->73|98->73|98->73|101->76|101->76|101->76|102->77|102->77|102->77|103->78|103->78|103->78|106->81|106->81|106->81|109->84|109->84|109->84|110->85|110->85|110->85|113->88|113->88|113->88|114->89|114->89|114->89|115->90|115->90|115->90|116->91|116->91|116->91|117->92|117->92|117->92|118->93|118->93|118->93|121->96|121->96|121->96|122->97|122->97|122->97|123->98|123->98|123->98|126->101|126->101|126->101|127->102|127->102|127->102|130->105|130->105|130->105|133->108|133->108|133->108|134->109|134->109|134->109|135->110|135->110|135->110
                  -- GENERATED --
              */
          