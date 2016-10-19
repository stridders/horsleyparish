<?php session_start();?>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<title></title>

<link rel="stylesheet" href="/css/main.css"/>
        
<script src="/jquery-ui-1.11.2/external/jquery/jquery.js"></script>
<script src="/jquery-ui-1.11.2/jquery-ui.js"></script>

<style>

  /* Parallax base styles
  --------------------------------------------- */

  .parallax {
    height: 500px; /* fallback for older browsers */
    height: 100vh;
    overflow-x: hidden;
    overflow-y: auto;
    -webkit-perspective: 300px;
    perspective: 300px;
  }

  .parallax__group {
    position: relative;
    height: 500px; /* fallback for older browsers */
    height: 100vh;
    -webkit-transform-style: preserve-3d;
    transform-style: preserve-3d;
  }

  .parallax__layer {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
  }

  .parallax__layer--220 {
    -webkit-transform: translateZ(220px) scale(0.267);
    transform: translateZ(220px) scale(0.267);
  }
  
  .parallax__layer--180 {
    -webkit-transform: translateZ(180px) scale(0.467);
    transform: translateZ(180px) scale(0.467);
  }

  .parallax__layer--150 {
    -webkit-transform: translateZ(150px) scale(0.50);
    transform: translateZ(150px) scale(0.50);
  }
  
  .parallax__layer--120 {
    -webkit-transform: translateZ(120px) scale(0.6);
    transform: translateZ(120px) scale(0.6);
  }

  .parallax__layer--0 {
    -webkit-transform: translateZ(0);
    transform: translateZ(0);
  }

  .parallax__layer--minus-300 {
    -webkit-transform: translateZ(-300px) scale(2);
    transform: translateZ(-300px) scale(2);
  }

  .parallax__layer--minus-600 {
    -webkit-transform: translateZ(-600px) scale(3);
    transform: translateZ(-600px) scale(3);
  }

  .parallax__group {
    -webkit-transition: -webkit-transform 0.5s;
    transition: transform 0.5s;
  }


  /* demo styles
  --------------------------------------------- */

  html {
	overflow: hidden;
  }
  body {
	background-image:url(/images/bg_blackboard.jpg);
	overflow:hidden;
	/* scrollbar formatting for IE */
	scrollbar-face-color: #fff;
	scrollbar-highlight-color: #FF0;
	scrollbar-3dlight-color: #ccc;
	scrollbar-darkshadow-color: #fff;
	scrollbar-shadow-color: #aaa;
	scrollbar-arrow-color: #000000;
	scrollbar-track-color:  #404040;
	}
	
  * {
    margin:0;
    padding:0;
  }

   /* centre the content in the parallax layers */
  .layer {
    text-align: center;
    position: absolute;
    left: 50%;
    top: 50%;
    -webkit-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
  }



  /* Main front page (Group 1)
  --------------------------------------------- */
  #group1 {
    z-index: 1; /* slide under group 2 */
  }

  #group1 .layersky {
	   height:100%; 
	   width:2400px; 
	   background:url(/images/hl0.png) top center repeat-x;
	   display:block; 
	   margin-left:auto; 
	   margin-right:auto;
  }
  #group1 .layersky #cloud1 {
	  position:absolute;
	  top:5px;
	  left:-80px;
  }
  #title {
	  position:relative;
	  top:-50px;
  }
  #group1 .layer1 {
	  position:absolute;
	  top:150px;
	  width:100%;
	  height:180px;
	  display:block;
	  background:url(/images/hl1.png) no-repeat top center;
	  z-index:1;
  }
  #group1 #layer2 {
	  position:absolute;
	  top:215px;
	  width:100%;
	  height:300px;
	  display:block;
	  background:url(/images/hl2.png) no-repeat top center;
	  z-index:2;
  }
  #group1 #layer3 {
	  position:absolute;
	  top:290px;
	  width:100%;
	  height:419px;
	  display:block;
	  background:url(/images/hl3.png) no-repeat top center;
  	  z-index:3;
  }
  #group1 #layer5 {
	  position:absolute;
	  top:830px;
	  width:100%;
	  height:1400px;
	  display:block;
	  background:url(/images/hl5.png) no-repeat top center;
	  z-index:5;
	  
  }
  #group1 #layer6 {
	  position:absolute;
	  width:900px;
	  height:150px;
	  top:580px;
	  z-index:6;
  }
  #group1 #layer7 {
	  position:absolute;
	  width:900px;
	  height:100%;
	  z-index:7;
  }

  /* Front page - Group 2
  --------------------------------------------- */
  
  #group2 {
    z-index: 2; /* slide over group 1 */
	position:relative;
	background-image:url(/images/bg_blackboard.jpg);
  }
  
  #group2 #layer1 {
	  position:absolute;
	  top:-20px;
	  width:100%;
	  height:60px;
	  display:block;
	  background:url(/images/hl6.png) no-repeat center;
  }
  #group2 #layer2 {
	  position:absolute;
	  top:-0px;
	  width:900px;;
	  height:100%;
  }
  /* Front page - Group 3
  --------------------------------------------- */
  #group3 {
    z-index: 3; /* slide over group 1 */
	position:relative;
	background-image:url(/images/bg_blackboard.jpg);
  }
  
  #group3 #layer1 {
	  width:900px;
	  height:100%;
  }
  #group3 #layer2 {
	  position:absolute;
	  top:650px;
	  width:100%;
	  height:41px;
	  display:block;
	  background:url(/images/sausages.png) repeat-x center;
  }
  #group3 #shop1s {
    -ms-transform: rotate(7deg); /* IE 9 */
    -webkit-transform: rotate(7deg); /* Chrome, Safari, Opera */
    transform: rotate(7deg);
  }
	
  /* Sheep
  ------------------------------------------------ */
	.sheepSmall {
		position:absolute;
		width:75px;
		height:100px;
		z-index:2;
	}
	.sheepLarge {
		position:absolute;
		width:150px;
		height:200px;
		z-index:1;
	}

  /* Main Menu
  ------------------------------------------------ */
  .MainMenu {
	  position:absolute;
	  left:-250px;
	  top:0px;
	  background-image:url(/images/bg_blackboard.jpg);
	  opacity:0.8;
	  width:250px;
	  height:900px;
	  display:block;
	  font:Arial, Helvetica, sans-serif;
	  font-size:10px;
	  color:#FFF;
	  z-index:10;
  }
  .showMainMenu {
	  position:absolute;
	  left:0px;
	  background:#333;
	  opacity:0.95;
	  width:250px;
	  height:1200px;
	  display:block;
	  font:Arial, Helvetica, sans-serif;
	  font-size:10px;
	  color:#FFF;
	  z-index:10;
  }
  .MainMenu .MenuTab {
	   position:absolute;
	   left:0px;
	   top:0px;
  }
  #MenuTab #Tab {
	  position:absolute;
	  top:20px;
	  left:250px;
	  border: 2px solid;
      border-radius: 25px;
	  font-family:Arial, Helvetica, sans-serif;
	  font-weight:bold;
	  text-align:center;
	  font-size:18px;
	  color:#000;
	  padding:3px 10px 3px 10px;
	  white-space:nowrap;
	  background:#fff;
	  display:block;
  } 
  .MainMenu .Menu {
	  position:absolute;
	  top:0px;
  }
  .MainMenu .Menu div {
	  padding:5px 5px 5px 5px;
  }
  
  /*  Scrollbar
  -------------------------------------------------------------------- */
  ::-webkit-scrollbar {
	  width: 16px;
  }
   
  ::-webkit-scrollbar-track {
	  -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
	  background-image:url(/images/bg_blackboard.jpg);
	  border-left: 1px solid #ccc; 
	  border-radius: 10px;
  }
   
  ::-webkit-scrollbar-thumb {
	  border-radius: 2px;
	  -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.5); 
	  background-image:url(/images/bg_BoardRubber.jpg);
  }
  
  /*  Fonts
  -------------------------------------------------------------------- */
  .chalk {
	  font-family:"Segoe UI", "Segoe Script";
	  color:#FFF;
	  font-size:12px;
  }
  .chalk a {
	  text-decoration:none;
	  border:none;
  }
  .chalk a:hover {
	  cursor:pointer;
  }  
  .purple {
	  color:#C5B6BB;
  }
  .blue {
	  color:#A6BAC5
  }
  .h1 {
	  font-size:22px;
	  font-weight:bold;
  }	  
  .h2 {
	  font-size:18px;
	  font-weight:bold;
  }
  .normal {
	  font-size:10px;
  }

</style>


</head>

<body>
      
<?php
		
		if ( isset($_GET['p']) ) {
			$WP_Group = $_GET['p'];
		} else {	
			$WP_Group = 'Home';
		}
		if ( isset($_GET['EM']) ) {
			if ( $_GET['EM'] == 'Y' ) {
				$_SESSION['edit'] = 'Y';
			} else {	
				$_SESSION['edit'] = 'N';
			}
		}
		
		$URL_Link = "/index.php?p=".$WP_Group;
				
		include($_SERVER['DOCUMENT_ROOT'].'/scripts/Common.php');
				
		include($_SERVER['DOCUMENT_ROOT'].'/MAIN_menu.php');
		
?>

  
  
  <div class="parallax">

  <!--------------------------------------------------------------------
    Group 1 
  ---------------------------------------------------------------------->

    <div id="group1" class="parallax__group">
      
      <div class="parallax__layer parallax__layer--minus-600">
        <div class="layer layersky">
        	<img id="cloud1" src="/images/cloud1.png" width="100" height="56">
        </div>
        <div class="layer layer1">
            <center>
        	<img id="title" src="/images/welcome_title.png" width="530" height="82">
        	</center>       
        </div>
      </div>
      
      <div class="parallax__layer parallax__layer--minus-300">
        <div class="layer" id="layer2"></div>
      </div>
      
      <div class="parallax__layer parallax__layer--0">
        <div class="layer" id="layer3">
        </div>
      </div>
      
      <div class="parallax__layer parallax__layer--150">
        <div class="layer" id="layer5">      
        </div>
      </div>

      <div class="parallax__layer parallax__layer--150">
        <div class="layer" id="layer6">
<?php

			$max_depth = 400;
			$max_width = 850;
			$nbr_sheep = date('d');
			$wally_set = false;
			$wally_x = mt_rand(0,$max_width);
			$wally_y = mt_rand(120,$max_depth);
			$y = 130;
			for ($j = 0; $j <= $nbr_sheep; $j++) {
			  $y = $y + mt_rand(0,($max_depth / $nbr_sheep));		  
			  $x = mt_rand(0, $max_width);
			  if ($y >= $wally_y and !$wally_set) {
				echo '<img class="sheepSmall" src="/images/sheep4.gif" style="left:'.$wally_x.'px; top:'.$wally_y.'px;">';  
				$wally_set = true;
			  } else {
			  	echo '<img class="sheepSmall" src="/images/sheepa.gif" style="left:'.$x.'px; top:'.$y.'px;">';
			  }
			}
?>
           <font color="#ffffff" size="2">
            <div style="position:absolute; left:0px; top:-100px; width:400px; height:120px; text-align:left;">
              <p>Best viewed using one of the following web browsers:</p>
              <p>Google Chrome (version 40.0.2214.93 or higher)</p>
              <p>Google Chrome (version 40.0.2214.93 or higher)</p>
              <p>Safari 7.1.2 (or higher)</p>
              <p>Mozilla Firefox (version 31.34.0 of higher)</p>
              Don't even think about using Internet Explorer <br>
              (since its pants)!               
            </div>

            	<div style="position:absolute; left:470px; top:0px; text-align:left;">
                  This site is managed and maintained on a voluntary basis on behalf of<br>
                  the Horsley community. If you'd like to post something to the site,<br>
                  or would like to learn how to manage your own community pages within this <br>
                  site, then please email: info@horsleyparish.co.uk.<br>
                  <br>
            	</div>
            </font>

        </div>
      </div> 
      
    </div>
    
  <!--------------------------------------------------------------------
    Group 2 
  ---------------------------------------------------------------------->
    
    <div id="group2" class="parallax__group"> 
             
      <div class="parallax__layer parallax__layer--0">
          <div class="layer" id="layer1">
<?php
			include($_SERVER['DOCUMENT_ROOT'].'/I_FP2.php');	
?>          
          </div>  
          <div class="layer" style="position:absolute; top:0px; width:900px;">
              <img class="sheepLarge" src="/images/sheepa.gif" style="left:300px; bottom:-10px;">
          </div> 
        
      </div>     
      

      
  </div>
  
    <!--------------------------------------------------------------------
    Group 3 
    ---------------------------------------------------------------------->
    
    <div id="group3" class="parallax__group"> 
             
      <div class="parallax__layer parallax__layer--0">
          <div class="layer" id="layer1">
<?php
			include($_SERVER['DOCUMENT_ROOT'].'/I_FP3.php');	
?>          
          </div>  
        
      </div>     
      
      <div class="parallax__layer parallax__layer--120">
        <div class="layer" id="layer2">      
        </div>
      </div>
      
  </div>

  <!--------------------------------------------------------------------
    Group 3 
  ---------------------------------------------------------------------->
  <div id="group1" class="parallax__group">
  
  </div>

</div>


<?php
		include($_SERVER['DOCUMENT_ROOT'].'/I_MAIN_MENU.php');	
?>
            <!--------------------------------------------------------------- 
             JQuery scripts: 	Load object CSS features and event handlers. 
            ----------------------------------------------------------------> 
<script>

			  
			  $(document).ready(function(){
				$("#MainMenu").click(function(){
				  $("#MainMenu").toggleClass("showMainMenu",200);
				  if ($("#Tab").text() == "Click here to hide menu") {
					$("#MainMenu").prop('title', 'Click here to view the main menu');
				  } else {
					$("#MainMenu").prop('title', 'Click here to hide the main menu');
				  }
				});
			  });
  
  
  			  $('#cloud1').animate({'marginLeft' : "+=1200", 'opacity' : '0' },100000);
			  
			  function slideMenu(obj) {
				  alert("message");
			  }

</script>

</body>
</html>