<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- TemplateBeginEditable name="doctitle" -->
<title>Welcome to Horsley Parish (Gloucestershire) Community Website</title>
<!-- TemplateEndEditable -->
<!-- TemplateBeginEditable name="head" -->
    <link rel="stylesheet" href="css/main.css"/>
        
    <!-- Scripts -->
    <script src="/scripts/Misc.js"></script>
    <script src="/scripts/jquery.min.js"></script>
    <script src="/scripts/plugins.js"></script>
    <script src="/scripts/sly.min.js"></script>
    <script src="/scripts/horizontal.js"></script>
<!-- TemplateEndEditable -->
</head>

<body>

<?php 

		session_start();
		
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
		
		include($_SERVER['DOCUMENT_ROOT'].'/PAGES/'.$WP_Group.'/menu.php');
		$count = count($Selected_pages);
		
		include($_SERVER['DOCUMENT_ROOT'].'/scripts/Common.php');
		include($_SERVER['DOCUMENT_ROOT'].'/scripts/EP_scripts.php');
		
		WriteToTraceLog(0, 'P', 'index.php', 'Main Page build', '');	
		
		include($_SERVER['DOCUMENT_ROOT'].'/MAIN_menu.php');
		include($_SERVER['DOCUMENT_ROOT'].'/I_MAIN_TITLE.php'); 
		
?>	
		<div class="MainPage">
			<div class="wrap">

<!-- TemplateBeginEditable name="MenuPanes" -->
<?php
		include($_SERVER['DOCUMENT_ROOT'].'/I_MAIN_LEFT_PANE.php');
        include($_SERVER['DOCUMENT_ROOT'].'/I_MAIN_RIGHT_PANE.php'); 
?>
<!-- TemplateEndEditable -->

<!-- TemplateBeginEditable name="Navigation" -->
<?php
			  include($_SERVER['DOCUMENT_ROOT'].'/I_MAIN_NAV.php');
?>
<!-- TemplateEndEditable -->


<!-- TemplateBeginEditable name="body" -->







<!-- TemplateEndEditable -->

            </div>      
        </div>
        
</body>
</html>

