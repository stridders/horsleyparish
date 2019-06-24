
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
/*2.2*/import play.api.Play.current
/*3.2*/import org.webjars.play.WebJarsUtil

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[WebJarsUtil,UserProfile,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*5.2*/(webJarsUtil: WebJarsUtil, userProfile: UserProfile):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*6.1*/("""
"""),_display_(/*7.2*/webJarsUtil/*7.13*/.locate("css/bootstrap.min.css").css()),format.raw/*7.51*/("""
"""),_display_(/*8.2*/webJarsUtil/*8.13*/.locate("css/bootstrap-theme.css").css()),format.raw/*8.53*/("""
"""),_display_(/*9.2*/webJarsUtil/*9.13*/.locate("angular-material.min.css").css()),format.raw/*9.54*/("""


"""),_display_(/*12.2*/webJarsUtil/*12.13*/.locate("bootstrap.min.js").script()),format.raw/*12.49*/("""
"""),_display_(/*13.2*/webJarsUtil/*13.13*/.locate("jquery.min.js").script()),format.raw/*13.46*/("""
"""),_display_(/*14.2*/webJarsUtil/*14.13*/.locate("bootstrap.min.js").script()),format.raw/*14.49*/("""
"""),_display_(/*15.2*/webJarsUtil/*15.13*/.locate("angularjs", "angular.min.js").script()),format.raw/*15.60*/("""
"""),_display_(/*16.2*/webJarsUtil/*16.13*/.locate("angular-animate", "angular-animate.min.js").script()),format.raw/*16.74*/("""
"""),_display_(/*17.2*/webJarsUtil/*17.13*/.locate("angular-resource.min.js").script()),format.raw/*17.56*/("""
"""),_display_(/*18.2*/webJarsUtil/*18.13*/.locate("angular-route","angular-route.min.js").script()),format.raw/*18.69*/("""
"""),_display_(/*19.2*/webJarsUtil/*19.13*/.locate("angular-filter.min.js").script()),format.raw/*19.54*/("""
"""),_display_(/*20.2*/webJarsUtil/*20.13*/.locate("0.2.18/angular-ui-router.min.js").script()),format.raw/*20.64*/("""
"""),_display_(/*21.2*/webJarsUtil/*21.13*/.locate("ui-bootstrap-tpls.min.js").script()),format.raw/*21.57*/("""
"""),_display_(/*22.2*/webJarsUtil/*22.13*/.locate("angular-cookies", "angular-cookies.min.js").script()),format.raw/*22.74*/("""
"""),_display_(/*23.2*/webJarsUtil/*23.13*/.locate("angular-aria", "angular-aria.min.js").script()),format.raw/*23.68*/("""
"""),_display_(/*24.2*/webJarsUtil/*24.13*/.locate("angular-messages","angular-messages.min.js").script()),format.raw/*24.75*/("""

"""),_display_(/*26.2*/webJarsUtil/*26.13*/.locate("angular-material.min.js").script()),format.raw/*26.56*/("""
"""),_display_(/*27.2*/webJarsUtil/*27.13*/.locate("moment.min.js").script()),format.raw/*27.46*/("""
"""),_display_(/*28.2*/webJarsUtil/*28.13*/.locate("postscribe.min.js").script()),format.raw/*28.50*/("""
"""),_display_(/*29.2*/webJarsUtil/*29.13*/.locate("4.10.2/d3.min.js").script()),format.raw/*29.49*/("""

"""),format.raw/*31.1*/("""<!DOCTYPE html>
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

		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">



		<script type="text/javascript" src='"""),_display_(/*51.40*/routes/*51.46*/.Assets.at("js/angular-file-upload.min.js")),format.raw/*51.89*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*52.40*/routes/*52.46*/.Assets.at("js/pdf.js")),format.raw/*52.69*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*53.40*/routes/*53.46*/.Assets.at("js/controllers.module.js")),format.raw/*53.84*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*54.40*/routes/*54.46*/.Assets.at("js/services.module.js")),format.raw/*54.81*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*55.40*/routes/*55.46*/.Assets.at("js/app.js")),format.raw/*55.69*/("""'></script>

		<!-- Features -->

		<!-- Home-Page -->
		<script type="text/javascript" src='"""),_display_(/*60.40*/routes/*60.46*/.Assets.at("features/home-page/home-page.controller.js")),format.raw/*60.102*/("""'></script>

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
		<link rel="stylesheet" href='"""),_display_(/*80.33*/routes/*80.39*/.Assets.at("features/page-tabs/page-tabs.css")),format.raw/*80.85*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*81.40*/routes/*81.46*/.Assets.at("features/page-tabs/page-tabs.directive.js")),format.raw/*81.101*/("""'></script>

		<!-- Home-Page -->
		<link rel="stylesheet" href='"""),_display_(/*84.33*/routes/*84.39*/.Assets.at("features/home-page/home-page.css")),format.raw/*84.85*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*85.40*/routes/*85.46*/.Assets.at("features/home-page/home-page.controller.js")),format.raw/*85.102*/("""'></script>

			<!-- About -->
		<script type="text/javascript" src='"""),_display_(/*88.40*/routes/*88.46*/.Assets.at("features/about/about.controller.js")),format.raw/*88.94*/("""'></script>
		<link rel="stylesheet" href='"""),_display_(/*89.33*/routes/*89.39*/.Assets.at("features/about/about.css")),format.raw/*89.77*/("""'/>

		<!-- The Horses Mouth -->
		<link rel="stylesheet" href='"""),_display_(/*92.33*/routes/*92.39*/.Assets.at("features/the-horses-mouth/horses-mouth.css")),format.raw/*92.95*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*93.40*/routes/*93.46*/.Assets.at("features/the-horses-mouth/horses-mouth.controller.js")),format.raw/*93.112*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*94.40*/routes/*94.46*/.Assets.at("features/the-horses-mouth/horses-mouth.service.js")),format.raw/*94.109*/("""'></script>

		<!-- History -->
		<script type="text/javascript" src='"""),_display_(/*97.40*/routes/*97.46*/.Assets.at("features/history/history.controller.js")),format.raw/*97.98*/("""'></script>

		<!-- Village Hall -->
		<link rel="stylesheet" href='"""),_display_(/*100.33*/routes/*100.39*/.Assets.at("features/village-hall/village-hall.css")),format.raw/*100.91*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*101.40*/routes/*101.46*/.Assets.at("features/village-hall/village-hall.controller.js")),format.raw/*101.108*/("""'></script>

		<!-- Login -->
		<link rel="stylesheet" href='"""),_display_(/*104.33*/routes/*104.39*/.Assets.at("features/login/login.css")),format.raw/*104.77*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*105.40*/routes/*105.46*/.Assets.at("features/login/authentication.service.js")),format.raw/*105.100*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*106.40*/routes/*106.46*/.Assets.at("features/login/login.controller.js")),format.raw/*106.94*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*107.40*/routes/*107.46*/.Assets.at("features/login/logout.controller.js")),format.raw/*107.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*108.40*/routes/*108.46*/.Assets.at("features/login/register.controller.js")),format.raw/*108.97*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*109.40*/routes/*109.46*/.Assets.at("features/login/user.service.js")),format.raw/*109.90*/("""'></script>

		<!-- Parish Council -->
		<link rel="stylesheet" href='"""),_display_(/*112.33*/routes/*112.39*/.Assets.at("features/parish-council/parish-council.css")),format.raw/*112.95*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*113.40*/routes/*113.46*/.Assets.at("features/parish-council/parish-council.controller.js")),format.raw/*113.112*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*114.40*/routes/*114.46*/.Assets.at("features/parish-council/parish-council.services.js")),format.raw/*114.110*/("""'></script>

			<!-- Church and Cemetery -->
		<link rel="stylesheet" href='"""),_display_(/*117.33*/routes/*117.39*/.Assets.at("features/church-and-cemetery/church-and-cemetery.css")),format.raw/*117.105*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*118.40*/routes/*118.46*/.Assets.at("features/church-and-cemetery/church-and-cemetery.controller.js")),format.raw/*118.122*/("""'></script>

		<!-- Animated bird -->
		<link rel="stylesheet" href='"""),_display_(/*121.33*/routes/*121.39*/.Assets.at("features/animated-bird/animated-bird.css")),format.raw/*121.93*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*122.40*/routes/*122.46*/.Assets.at("features/animated-bird/animated-bird.directive.js")),format.raw/*122.109*/("""'></script>

		<!-- Community Shop -->
		<link rel="stylesheet" href='"""),_display_(/*125.33*/routes/*125.39*/.Assets.at("features/horsley-community-shop/community-shop.css")),format.raw/*125.103*/("""'/>

		<!-- User Admin -->
		<script type="text/javascript" src='"""),_display_(/*128.40*/routes/*128.46*/.Assets.at("admin/users/users.controller.js")),format.raw/*128.91*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*129.40*/routes/*129.46*/.Assets.at("admin/users/users.service.js")),format.raw/*129.88*/("""'></script>
		<link rel="stylesheet" href='"""),_display_(/*130.33*/routes/*130.39*/.Assets.at("admin/users/users.css")),format.raw/*130.74*/("""'/>


	</head>


	<body>

		<div id="page-wrapper" ng-cloak>
			<header></header>
			<div class="main-container">
				<div class="main-page-hdr"></div>
				<ng-view class="main-page"></ng-view>
			</div>
			<footer></footer>
		</div>

		<script type="text/javascript">
			$(window).on('beforeunload', function()"""),format.raw/*148.43*/("""{"""),format.raw/*148.44*/("""
				"""),format.raw/*149.5*/("""$(window).scrollTop(0);
			"""),format.raw/*150.4*/("""}"""),format.raw/*150.5*/(""");
		</script>
	</body>


</html>"""))
      }
    }
  }

  def render(webJarsUtil:WebJarsUtil,userProfile:UserProfile): play.twirl.api.HtmlFormat.Appendable = apply(webJarsUtil,userProfile)

  def f:((WebJarsUtil,UserProfile) => play.twirl.api.HtmlFormat.Appendable) = (webJarsUtil,userProfile) => apply(webJarsUtil,userProfile)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Jun 24 14:06:25 BST 2019
                  SOURCE: /Users/js/Documents/workspace/repositories/HorsleyParish/app/views/index.scala.html
                  HASH: 8cf7a785b337f5f0185cce994248ddc835520918
                  MATRIX: 432->1|473->36|509->66|866->104|1012->157|1039->159|1058->170|1116->208|1143->210|1162->221|1222->261|1249->263|1268->274|1329->315|1359->319|1379->330|1436->366|1464->368|1484->379|1538->412|1566->414|1586->425|1643->461|1671->463|1691->474|1759->521|1787->523|1807->534|1889->595|1917->597|1937->608|2001->651|2029->653|2049->664|2126->720|2154->722|2174->733|2236->774|2264->776|2284->787|2356->838|2384->840|2404->851|2469->895|2497->897|2517->908|2599->969|2627->971|2647->982|2723->1037|2751->1039|2771->1050|2854->1112|2883->1115|2903->1126|2967->1169|2995->1171|3015->1182|3069->1215|3097->1217|3117->1228|3175->1265|3203->1267|3223->1278|3280->1314|3309->1316|4291->2271|4306->2277|4370->2320|4448->2371|4463->2377|4507->2400|4585->2451|4600->2457|4659->2495|4737->2546|4752->2552|4808->2587|4886->2638|4901->2644|4945->2667|5066->2761|5081->2767|5159->2823|5258->2895|5273->2901|5341->2948|5404->2984|5419->2990|5480->3030|5550->3073|5565->3079|5643->3135|5721->3186|5736->3192|5806->3241|5884->3292|5899->3298|5967->3345|6066->3417|6081->3423|6142->3463|6212->3506|6227->3512|6297->3561|6375->3612|6390->3618|6460->3667|6538->3718|6553->3724|6619->3769|6723->3846|6738->3852|6819->3911|6913->3978|6928->3984|6995->4030|7065->4073|7080->4079|7157->4134|7250->4200|7265->4206|7332->4252|7402->4295|7417->4301|7495->4357|7592->4427|7607->4433|7676->4481|7747->4525|7762->4531|7821->4569|7913->4634|7928->4640|8005->4696|8075->4739|8090->4745|8178->4811|8256->4862|8271->4868|8356->4931|8454->5002|8469->5008|8542->5060|8639->5129|8655->5135|8729->5187|8800->5230|8816->5236|8901->5298|8991->5360|9007->5366|9067->5404|9138->5447|9154->5453|9231->5507|9310->5558|9326->5564|9396->5612|9475->5663|9491->5669|9562->5718|9641->5769|9657->5775|9730->5826|9809->5877|9825->5883|9891->5927|9990->5998|10006->6004|10084->6060|10155->6103|10171->6109|10260->6175|10339->6226|10355->6232|10442->6296|10547->6373|10563->6379|10652->6445|10723->6488|10739->6494|10838->6570|10936->6640|10952->6646|11028->6700|11099->6743|11115->6749|11201->6812|11300->6883|11316->6889|11403->6953|11497->7019|11513->7025|11580->7070|11659->7121|11675->7127|11739->7169|11811->7213|11827->7219|11884->7254|12224->7565|12254->7566|12287->7571|12342->7598|12371->7599
                  LINES: 17->1|18->2|19->3|24->5|29->6|30->7|30->7|30->7|31->8|31->8|31->8|32->9|32->9|32->9|35->12|35->12|35->12|36->13|36->13|36->13|37->14|37->14|37->14|38->15|38->15|38->15|39->16|39->16|39->16|40->17|40->17|40->17|41->18|41->18|41->18|42->19|42->19|42->19|43->20|43->20|43->20|44->21|44->21|44->21|45->22|45->22|45->22|46->23|46->23|46->23|47->24|47->24|47->24|49->26|49->26|49->26|50->27|50->27|50->27|51->28|51->28|51->28|52->29|52->29|52->29|54->31|74->51|74->51|74->51|75->52|75->52|75->52|76->53|76->53|76->53|77->54|77->54|77->54|78->55|78->55|78->55|83->60|83->60|83->60|86->63|86->63|86->63|87->64|87->64|87->64|88->65|88->65|88->65|89->66|89->66|89->66|90->67|90->67|90->67|93->70|93->70|93->70|94->71|94->71|94->71|95->72|95->72|95->72|96->73|96->73|96->73|99->76|99->76|99->76|103->80|103->80|103->80|104->81|104->81|104->81|107->84|107->84|107->84|108->85|108->85|108->85|111->88|111->88|111->88|112->89|112->89|112->89|115->92|115->92|115->92|116->93|116->93|116->93|117->94|117->94|117->94|120->97|120->97|120->97|123->100|123->100|123->100|124->101|124->101|124->101|127->104|127->104|127->104|128->105|128->105|128->105|129->106|129->106|129->106|130->107|130->107|130->107|131->108|131->108|131->108|132->109|132->109|132->109|135->112|135->112|135->112|136->113|136->113|136->113|137->114|137->114|137->114|140->117|140->117|140->117|141->118|141->118|141->118|144->121|144->121|144->121|145->122|145->122|145->122|148->125|148->125|148->125|151->128|151->128|151->128|152->129|152->129|152->129|153->130|153->130|153->130|171->148|171->148|172->149|173->150|173->150
                  -- GENERATED --
              */
          