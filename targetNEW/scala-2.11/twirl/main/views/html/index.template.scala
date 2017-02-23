
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
<html ng-app="horsley" >
	<head>
		<title>Horsley Parish, Gloucestershire, Community website</title>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8"/>
		<meta name="viewport" content="width=device-width"/>

		<link rel='stylesheet' href='"""),_display_(/*14.33*/routes/*14.39*/.WebJarAssets.at(webJarAssets.locate("css/bootstrap.min.css"))),format.raw/*14.101*/("""'>
		<link rel='stylesheet' href='"""),_display_(/*15.33*/routes/*15.39*/.WebJarAssets.at(webJarAssets.locate("css/bootstrap-theme.css"))),format.raw/*15.103*/("""'>
		<link rel="stylesheet" href=""""),_display_(/*16.33*/routes/*16.39*/.Assets.at("css/font-awesome-4.6.3/css/font-awesome.css")),format.raw/*16.96*/(""""/>
		<link rel="stylesheet" href=""""),_display_(/*17.33*/routes/*17.39*/.Assets.at("css/OpenSans.css")),format.raw/*17.69*/(""""/>
		<link rel="stylesheet" href=""""),_display_(/*18.33*/routes/*18.39*/.Assets.at("css/main.css")),format.raw/*18.65*/(""""/>
		<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

		<script type="text/javascript" src='"""),_display_(/*21.40*/routes/*21.46*/.WebJarAssets.at(webJarAssets.locate("jquery.min.js"))),format.raw/*21.100*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*22.40*/routes/*22.46*/.WebJarAssets.at(webJarAssets.locate("bootstrap.min.js"))),format.raw/*22.103*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*23.40*/routes/*23.46*/.WebJarAssets.at(webJarAssets.fullPath("angularjs", "angular.min.js"))),format.raw/*23.116*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*24.40*/routes/*24.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-animate", "angular-animate.min.js"))),format.raw/*24.130*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*25.40*/routes/*25.46*/.WebJarAssets.at(webJarAssets.locate("angular-resource.min.js"))),format.raw/*25.110*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*26.40*/routes/*26.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-route","angular-route.min.js"))),format.raw/*26.125*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*27.40*/routes/*27.46*/.WebJarAssets.at(webJarAssets.locate("angular-filter.min.js"))),format.raw/*27.108*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*28.40*/routes/*28.46*/.WebJarAssets.at(webJarAssets.locate("0.2.18/angular-ui-router.min.js"))),format.raw/*28.118*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*29.40*/routes/*29.46*/.WebJarAssets.at(webJarAssets.locate("ui-bootstrap-tpls.min.js"))),format.raw/*29.111*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*30.40*/routes/*30.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-cookies", "angular-cookies.min.js"))),format.raw/*30.130*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*31.40*/routes/*31.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-aria", "angular-aria.min.js"))),format.raw/*31.124*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*32.40*/routes/*32.46*/.WebJarAssets.at(webJarAssets.fullPath("angular-messages","angular-messages.min.js"))),format.raw/*32.131*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*33.40*/routes/*33.46*/.Assets.at("js/angular-file-upload.min.js")),format.raw/*33.89*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*34.40*/routes/*34.46*/.WebJarAssets.at(webJarAssets.locate("angular-material.min.js"))),format.raw/*34.110*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*35.40*/routes/*35.46*/.WebJarAssets.at(webJarAssets.locate("moment.min.js"))),format.raw/*35.100*/("""'></script>

		<script type="text/javascript" src='"""),_display_(/*37.40*/routes/*37.46*/.Assets.at("js/controllers.module.js")),format.raw/*37.84*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*38.40*/routes/*38.46*/.Assets.at("js/services.module.js")),format.raw/*38.81*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*39.40*/routes/*39.46*/.Assets.at("js/app.js")),format.raw/*39.69*/("""'></script>

		<!-- Features -->

		<!-- Home-Page -->
		<script type="text/javascript" src='"""),_display_(/*44.40*/routes/*44.46*/.Assets.at("features/home-page/home-page.controller.js")),format.raw/*44.102*/("""'></script>

		<!-- File-Uploader -->
		<link rel="stylesheet" href='"""),_display_(/*47.33*/routes/*47.39*/.Assets.at("features/file-uploader/file-uploader.css")),format.raw/*47.93*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*48.40*/routes/*48.46*/.Assets.at("features/file-uploader/file-uploader.controller.js")),format.raw/*48.110*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*49.40*/routes/*49.46*/.Assets.at("features/file-uploader/file-uploader.service.js")),format.raw/*49.107*/("""'></script>

		<!-- Common Services -->
		<link rel="stylesheet" href='"""),_display_(/*52.33*/routes/*52.39*/.Assets.at("features/common/header.css")),format.raw/*52.79*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*53.40*/routes/*53.46*/.Assets.at("features/common/header.directive.js")),format.raw/*53.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*54.40*/routes/*54.46*/.Assets.at("features/flash/flash.service.js")),format.raw/*54.91*/("""'></script>

		<!-- Navigation Bar -->
		<link rel="stylesheet" href='"""),_display_(/*57.33*/routes/*57.39*/.Assets.at("features/navbar/navbar-button.css")),format.raw/*57.86*/("""'/>
		<link rel="stylesheet" href='"""),_display_(/*58.33*/routes/*58.39*/.Assets.at("features/navbar/navbar.css")),format.raw/*58.79*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*59.40*/routes/*59.46*/.Assets.at("features/navbar/navbar-button.directive.js")),format.raw/*59.102*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*60.40*/routes/*60.46*/.Assets.at("features/navbar/navbar.directive.js")),format.raw/*60.95*/("""'></script>

		<!-- Page-Tabs -->
		<link rel="stylesheet" href='"""),_display_(/*63.33*/routes/*63.39*/.Assets.at("features/page-tabs/page-tabs.css")),format.raw/*63.85*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*64.40*/routes/*64.46*/.Assets.at("features/page-tabs/page-tabs.directive.js")),format.raw/*64.101*/("""'></script>

		<!-- Home-Page -->
		<script type="text/javascript" src='"""),_display_(/*67.40*/routes/*67.46*/.Assets.at("features/home-page/home-page.controller.js")),format.raw/*67.102*/("""'></script>

		<!-- The Horses Mouth -->
		<link rel="stylesheet" href='"""),_display_(/*70.33*/routes/*70.39*/.Assets.at("features/the-horses-mouth/horses-mouth.css")),format.raw/*70.95*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*71.40*/routes/*71.46*/.Assets.at("features/the-horses-mouth/horses-mouth.controller.js")),format.raw/*71.112*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*72.40*/routes/*72.46*/.Assets.at("features/the-horses-mouth/horses-mouth.service.js")),format.raw/*72.109*/("""'></script>

		<!-- History -->
		<script type="text/javascript" src='"""),_display_(/*75.40*/routes/*75.46*/.Assets.at("features/history/history.controller.js")),format.raw/*75.98*/("""'></script>

		<!-- Village Hall -->
		<link rel="stylesheet" href='"""),_display_(/*78.33*/routes/*78.39*/.Assets.at("features/village-hall/village-hall.css")),format.raw/*78.91*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*79.40*/routes/*79.46*/.Assets.at("features/village-hall/village-hall.controller.js")),format.raw/*79.108*/("""'></script>

		<!-- Login -->
		<link rel="stylesheet" href='"""),_display_(/*82.33*/routes/*82.39*/.Assets.at("features/login/login.css")),format.raw/*82.77*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*83.40*/routes/*83.46*/.Assets.at("features/login/authentication.service.js")),format.raw/*83.100*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*84.40*/routes/*84.46*/.Assets.at("features/login/login.controller.js")),format.raw/*84.94*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*85.40*/routes/*85.46*/.Assets.at("features/login/logout.controller.js")),format.raw/*85.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*86.40*/routes/*86.46*/.Assets.at("features/login/register.controller.js")),format.raw/*86.97*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*87.40*/routes/*87.46*/.Assets.at("features/login/user.service.js")),format.raw/*87.90*/("""'></script>

		<!-- Parish Council -->
		<link rel="stylesheet" href='"""),_display_(/*90.33*/routes/*90.39*/.Assets.at("features/parish-council/parish-council.css")),format.raw/*90.95*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*91.40*/routes/*91.46*/.Assets.at("features/parish-council/parish-council.controller.js")),format.raw/*91.112*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*92.40*/routes/*92.46*/.Assets.at("features/parish-council/parish-council.services.js")),format.raw/*92.110*/("""'></script>

		<!-- Animated bird -->
		<link rel="stylesheet" href='"""),_display_(/*95.33*/routes/*95.39*/.Assets.at("features/animated-bird/animated-bird.css")),format.raw/*95.93*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*96.40*/routes/*96.46*/.Assets.at("features/animated-bird/animated-bird.directive.js")),format.raw/*96.109*/("""'></script>

		<!-- Community Shop -->
		<link rel="stylesheet" href='"""),_display_(/*99.33*/routes/*99.39*/.Assets.at("features/community-shop/community-shop.css")),format.raw/*99.95*/("""'/>

	</head>


	<body>

		<div id="page-wrapper">
			<header></header>
			<div class="main-container">
				<div class="main-page-hdr"></div>
				<ng-view class="main-page"></ng-view>
				<div ng-include="'/web/features/common/page-footer.html'"></div>
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
                  DATE: Thu Feb 23 09:35:20 GMT 2017
                  SOURCE: /Users/js/Documents/workspace/repositories/HorsleyParish/app/views/index.scala.html
                  HASH: 1e8a4bf4deb6ce396191e52a3a1f6a90a53a51f4
                  MATRIX: 636->67|768->123|781->129|857->121|885->174|913->176|1216->452|1231->458|1315->520|1377->555|1392->561|1478->625|1540->660|1555->666|1633->723|1696->759|1711->765|1762->795|1825->831|1840->837|1887->863|2047->996|2062->1002|2138->1056|2216->1107|2231->1113|2310->1170|2388->1221|2403->1227|2495->1297|2573->1348|2588->1354|2694->1438|2772->1489|2787->1495|2873->1559|2951->1610|2966->1616|3067->1695|3145->1746|3160->1752|3244->1814|3322->1865|3337->1871|3431->1943|3509->1994|3524->2000|3611->2065|3689->2116|3704->2122|3810->2206|3888->2257|3903->2263|4003->2341|4081->2392|4096->2398|4203->2483|4281->2534|4296->2540|4360->2583|4438->2634|4453->2640|4539->2704|4617->2755|4632->2761|4708->2815|4787->2867|4802->2873|4861->2911|4939->2962|4954->2968|5010->3003|5088->3054|5103->3060|5147->3083|5268->3177|5283->3183|5361->3239|5458->3309|5473->3315|5548->3369|5618->3412|5633->3418|5719->3482|5797->3533|5812->3539|5895->3600|5994->3672|6009->3678|6070->3718|6140->3761|6155->3767|6225->3816|6303->3867|6318->3873|6384->3918|6482->3989|6497->3995|6565->4042|6628->4078|6643->4084|6704->4124|6774->4167|6789->4173|6867->4229|6945->4280|6960->4286|7030->4335|7123->4401|7138->4407|7205->4453|7275->4496|7290->4502|7367->4557|7467->4630|7482->4636|7560->4692|7660->4765|7675->4771|7752->4827|7822->4870|7837->4876|7925->4942|8003->4993|8018->4999|8103->5062|8201->5133|8216->5139|8289->5191|8385->5260|8400->5266|8473->5318|8543->5361|8558->5367|8642->5429|8731->5491|8746->5497|8805->5535|8875->5578|8890->5584|8966->5638|9044->5689|9059->5695|9128->5743|9206->5794|9221->5800|9291->5849|9369->5900|9384->5906|9456->5957|9534->6008|9549->6014|9614->6058|9712->6129|9727->6135|9804->6191|9874->6234|9889->6240|9977->6306|10055->6357|10070->6363|10156->6427|10253->6497|10268->6503|10343->6557|10413->6600|10428->6606|10513->6669|10611->6740|10626->6746|10703->6802
                  LINES: 24->4|28->5|28->5|29->4|30->5|32->7|39->14|39->14|39->14|40->15|40->15|40->15|41->16|41->16|41->16|42->17|42->17|42->17|43->18|43->18|43->18|46->21|46->21|46->21|47->22|47->22|47->22|48->23|48->23|48->23|49->24|49->24|49->24|50->25|50->25|50->25|51->26|51->26|51->26|52->27|52->27|52->27|53->28|53->28|53->28|54->29|54->29|54->29|55->30|55->30|55->30|56->31|56->31|56->31|57->32|57->32|57->32|58->33|58->33|58->33|59->34|59->34|59->34|60->35|60->35|60->35|62->37|62->37|62->37|63->38|63->38|63->38|64->39|64->39|64->39|69->44|69->44|69->44|72->47|72->47|72->47|73->48|73->48|73->48|74->49|74->49|74->49|77->52|77->52|77->52|78->53|78->53|78->53|79->54|79->54|79->54|82->57|82->57|82->57|83->58|83->58|83->58|84->59|84->59|84->59|85->60|85->60|85->60|88->63|88->63|88->63|89->64|89->64|89->64|92->67|92->67|92->67|95->70|95->70|95->70|96->71|96->71|96->71|97->72|97->72|97->72|100->75|100->75|100->75|103->78|103->78|103->78|104->79|104->79|104->79|107->82|107->82|107->82|108->83|108->83|108->83|109->84|109->84|109->84|110->85|110->85|110->85|111->86|111->86|111->86|112->87|112->87|112->87|115->90|115->90|115->90|116->91|116->91|116->91|117->92|117->92|117->92|120->95|120->95|120->95|121->96|121->96|121->96|124->99|124->99|124->99
                  -- GENERATED --
              */
          