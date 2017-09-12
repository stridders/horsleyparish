
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
		<script type="text/javascript" src='"""),_display_(/*48.40*/routes/*48.46*/.WebJarAssets.at(webJarAssets.locate("pdf.js"))),format.raw/*48.93*/("""'></script>

		<script type="text/javascript" src='"""),_display_(/*50.40*/routes/*50.46*/.Assets.at("js/controllers.module.js")),format.raw/*50.84*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*51.40*/routes/*51.46*/.Assets.at("js/services.module.js")),format.raw/*51.81*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*52.40*/routes/*52.46*/.Assets.at("js/app.js")),format.raw/*52.69*/("""'></script>

		<!-- Features -->

		<!-- Home-Page -->
		<script type="text/javascript" src='"""),_display_(/*57.40*/routes/*57.46*/.Assets.at("features/home-page/home-page.controller.js")),format.raw/*57.102*/("""'></script>

		<!-- File-Uploader -->
		<link rel="stylesheet" href='"""),_display_(/*60.33*/routes/*60.39*/.Assets.at("features/file-uploader/file-uploader.css")),format.raw/*60.93*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*61.40*/routes/*61.46*/.Assets.at("features/file-uploader/file-uploader.controller.js")),format.raw/*61.110*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*62.40*/routes/*62.46*/.Assets.at("features/file-uploader/file-uploader.service.js")),format.raw/*62.107*/("""'></script>

			<!-- Navigation Bar -->
		<link rel="stylesheet" href='"""),_display_(/*65.33*/routes/*65.39*/.Assets.at("features/navbar/navbar-button.css")),format.raw/*65.86*/("""'/>
		<link rel="stylesheet" href='"""),_display_(/*66.33*/routes/*66.39*/.Assets.at("features/navbar/navbar.css")),format.raw/*66.79*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*67.40*/routes/*67.46*/.Assets.at("features/navbar/navbar-button.directive.js")),format.raw/*67.102*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*68.40*/routes/*68.46*/.Assets.at("features/navbar/navbar.directive.js")),format.raw/*68.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*69.40*/routes/*69.46*/.Assets.at("features/navbar/navbar.service.js")),format.raw/*69.93*/("""'></script>

		<!-- Common Services -->
		<link rel="stylesheet" href='"""),_display_(/*72.33*/routes/*72.39*/.Assets.at("features/common/header.css")),format.raw/*72.79*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*73.40*/routes/*73.46*/.Assets.at("features/common/header.directive.js")),format.raw/*73.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*74.40*/routes/*74.46*/.Assets.at("features/common/footer.directive.js")),format.raw/*74.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*75.40*/routes/*75.46*/.Assets.at("features/flash/flash.service.js")),format.raw/*75.91*/("""'></script>

		<!-- Google Drive -->
		<script type="text/javascript" src='"""),_display_(/*78.40*/routes/*78.46*/.Assets.at("features/google-drive/google-drive.service.js")),format.raw/*78.105*/("""'></script>

		<!-- Page-Tabs -->
		<link rel="stylesheet" href='"""),_display_(/*81.33*/routes/*81.39*/.Assets.at("features/page-tabs/page-tabs.css")),format.raw/*81.85*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*82.40*/routes/*82.46*/.Assets.at("features/page-tabs/page-tabs.directive.js")),format.raw/*82.101*/("""'></script>

		<!-- Home-Page -->
		<script type="text/javascript" src='"""),_display_(/*85.40*/routes/*85.46*/.Assets.at("features/home-page/home-page.controller.js")),format.raw/*85.102*/("""'></script>

		<!-- The Horses Mouth -->
		<link rel="stylesheet" href='"""),_display_(/*88.33*/routes/*88.39*/.Assets.at("features/the-horses-mouth/horses-mouth.css")),format.raw/*88.95*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*89.40*/routes/*89.46*/.Assets.at("features/the-horses-mouth/horses-mouth.controller.js")),format.raw/*89.112*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*90.40*/routes/*90.46*/.Assets.at("features/the-horses-mouth/horses-mouth.service.js")),format.raw/*90.109*/("""'></script>

		<!-- History -->
		<script type="text/javascript" src='"""),_display_(/*93.40*/routes/*93.46*/.Assets.at("features/history/history.controller.js")),format.raw/*93.98*/("""'></script>

		<!-- Village Hall -->
		<link rel="stylesheet" href='"""),_display_(/*96.33*/routes/*96.39*/.Assets.at("features/village-hall/village-hall.css")),format.raw/*96.91*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*97.40*/routes/*97.46*/.Assets.at("features/village-hall/village-hall.controller.js")),format.raw/*97.108*/("""'></script>

		<!-- Login -->
		<link rel="stylesheet" href='"""),_display_(/*100.33*/routes/*100.39*/.Assets.at("features/login/login.css")),format.raw/*100.77*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*101.40*/routes/*101.46*/.Assets.at("features/login/authentication.service.js")),format.raw/*101.100*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*102.40*/routes/*102.46*/.Assets.at("features/login/login.controller.js")),format.raw/*102.94*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*103.40*/routes/*103.46*/.Assets.at("features/login/logout.controller.js")),format.raw/*103.95*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*104.40*/routes/*104.46*/.Assets.at("features/login/register.controller.js")),format.raw/*104.97*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*105.40*/routes/*105.46*/.Assets.at("features/login/user.service.js")),format.raw/*105.90*/("""'></script>

		<!-- Parish Council -->
		<link rel="stylesheet" href='"""),_display_(/*108.33*/routes/*108.39*/.Assets.at("features/parish-council/parish-council.css")),format.raw/*108.95*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*109.40*/routes/*109.46*/.Assets.at("features/parish-council/parish-council.controller.js")),format.raw/*109.112*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*110.40*/routes/*110.46*/.Assets.at("features/parish-council/parish-council.services.js")),format.raw/*110.110*/("""'></script>

		<!-- Animated bird -->
		<link rel="stylesheet" href='"""),_display_(/*113.33*/routes/*113.39*/.Assets.at("features/animated-bird/animated-bird.css")),format.raw/*113.93*/("""'/>
		<script type="text/javascript" src='"""),_display_(/*114.40*/routes/*114.46*/.Assets.at("features/animated-bird/animated-bird.directive.js")),format.raw/*114.109*/("""'></script>

		<!-- Community Shop -->
		<link rel="stylesheet" href='"""),_display_(/*117.33*/routes/*117.39*/.Assets.at("features/horsley-community-shop/community-shop.css")),format.raw/*117.103*/("""'/>

		<!-- User Admin -->
		<script type="text/javascript" src='"""),_display_(/*120.40*/routes/*120.46*/.Assets.at("admin/users/users.controller.js")),format.raw/*120.91*/("""'></script>
		<script type="text/javascript" src='"""),_display_(/*121.40*/routes/*121.46*/.Assets.at("admin/users/users.service.js")),format.raw/*121.88*/("""'></script>
		<link rel="stylesheet" href='"""),_display_(/*122.33*/routes/*122.39*/.Assets.at("admin/users/users.css")),format.raw/*122.74*/("""'/>

		<!-- BubbleChart-Page -->
		<script type="text/javascript" src='"""),_display_(/*125.40*/routes/*125.46*/.Assets.at("features/bubble-chart/bubble-chart.controller.js")),format.raw/*125.108*/("""'></script>

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
                  DATE: Tue Sep 12 18:16:38 BST 2017
                  SOURCE: /Users/jstride/Documents/workspace/repository/horsleyparish/app/views/index.scala.html
                  HASH: f677827fa8a0493195064bf7735b70aa4b77b03f
                  MATRIX: 636->67|768->123|781->129|857->121|885->174|913->176|1796->1032|1811->1038|1895->1100|1957->1135|1972->1141|2058->1205|2120->1240|2135->1246|2222->1311|2284->1346|2299->1352|2377->1409|2440->1445|2455->1451|2506->1481|2569->1517|2584->1523|2631->1549|2791->1682|2806->1688|2882->1742|2960->1793|2975->1799|3054->1856|3132->1907|3147->1913|3239->1983|3317->2034|3332->2040|3438->2124|3516->2175|3531->2181|3617->2245|3695->2296|3710->2302|3811->2381|3889->2432|3904->2438|3988->2500|4066->2551|4081->2557|4175->2629|4253->2680|4268->2686|4355->2751|4433->2802|4448->2808|4554->2892|4632->2943|4647->2949|4747->3027|4825->3078|4840->3084|4947->3169|5025->3220|5040->3226|5104->3269|5182->3320|5197->3326|5283->3390|5361->3441|5376->3447|5452->3501|5530->3552|5545->3558|5625->3616|5703->3667|5718->3673|5797->3730|5875->3781|5890->3787|5958->3834|6037->3886|6052->3892|6111->3930|6189->3981|6204->3987|6260->4022|6338->4073|6353->4079|6397->4102|6518->4196|6533->4202|6611->4258|6708->4328|6723->4334|6798->4388|6868->4431|6883->4437|6969->4501|7047->4552|7062->4558|7145->4619|7244->4691|7259->4697|7327->4744|7390->4780|7405->4786|7466->4826|7536->4869|7551->4875|7629->4931|7707->4982|7722->4988|7792->5037|7870->5088|7885->5094|7953->5141|8052->5213|8067->5219|8128->5259|8198->5302|8213->5308|8283->5357|8361->5408|8376->5414|8446->5463|8524->5514|8539->5520|8605->5565|8708->5641|8723->5647|8804->5706|8897->5772|8912->5778|8979->5824|9049->5867|9064->5873|9141->5928|9241->6001|9256->6007|9334->6063|9434->6136|9449->6142|9526->6198|9596->6241|9611->6247|9699->6313|9777->6364|9792->6370|9877->6433|9975->6504|9990->6510|10063->6562|10159->6631|10174->6637|10247->6689|10317->6732|10332->6738|10416->6800|10506->6862|10522->6868|10582->6906|10653->6949|10669->6955|10746->7009|10825->7060|10841->7066|10911->7114|10990->7165|11006->7171|11077->7220|11156->7271|11172->7277|11245->7328|11324->7379|11340->7385|11406->7429|11505->7500|11521->7506|11599->7562|11670->7605|11686->7611|11775->7677|11854->7728|11870->7734|11957->7798|12055->7868|12071->7874|12147->7928|12218->7971|12234->7977|12320->8040|12419->8111|12435->8117|12522->8181|12616->8247|12632->8253|12699->8298|12778->8349|12794->8355|12858->8397|12930->8441|12946->8447|13003->8482|13103->8554|13119->8560|13204->8622
                  LINES: 24->4|28->5|28->5|29->4|30->5|32->7|48->23|48->23|48->23|49->24|49->24|49->24|50->25|50->25|50->25|51->26|51->26|51->26|52->27|52->27|52->27|53->28|53->28|53->28|56->31|56->31|56->31|57->32|57->32|57->32|58->33|58->33|58->33|59->34|59->34|59->34|60->35|60->35|60->35|61->36|61->36|61->36|62->37|62->37|62->37|63->38|63->38|63->38|64->39|64->39|64->39|65->40|65->40|65->40|66->41|66->41|66->41|67->42|67->42|67->42|68->43|68->43|68->43|69->44|69->44|69->44|70->45|70->45|70->45|71->46|71->46|71->46|72->47|72->47|72->47|73->48|73->48|73->48|75->50|75->50|75->50|76->51|76->51|76->51|77->52|77->52|77->52|82->57|82->57|82->57|85->60|85->60|85->60|86->61|86->61|86->61|87->62|87->62|87->62|90->65|90->65|90->65|91->66|91->66|91->66|92->67|92->67|92->67|93->68|93->68|93->68|94->69|94->69|94->69|97->72|97->72|97->72|98->73|98->73|98->73|99->74|99->74|99->74|100->75|100->75|100->75|103->78|103->78|103->78|106->81|106->81|106->81|107->82|107->82|107->82|110->85|110->85|110->85|113->88|113->88|113->88|114->89|114->89|114->89|115->90|115->90|115->90|118->93|118->93|118->93|121->96|121->96|121->96|122->97|122->97|122->97|125->100|125->100|125->100|126->101|126->101|126->101|127->102|127->102|127->102|128->103|128->103|128->103|129->104|129->104|129->104|130->105|130->105|130->105|133->108|133->108|133->108|134->109|134->109|134->109|135->110|135->110|135->110|138->113|138->113|138->113|139->114|139->114|139->114|142->117|142->117|142->117|145->120|145->120|145->120|146->121|146->121|146->121|147->122|147->122|147->122|150->125|150->125|150->125
                  -- GENERATED --
              */
          