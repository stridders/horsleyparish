<?php session_start();?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/TitlePage.dwt.php" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- InstanceBeginEditable name="doctitle" -->
<title>Welcome to Horsley Parish (Gloucestershire) Community Website</title>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
    <link rel="stylesheet" href="/css/main.css"/>
        
    <!-- Scripts -->
    <script src="scripts/Misc.js"></script>
    <script src="scripts/jquery.min.js"></script>
    <script src="scripts/plugins.js"></script>
    <script src="scripts/sly.min.js"></script>
    <script src="scripts/horizontal.js"></script>
<!-- InstanceEndEditable -->
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

<!-- InstanceBeginEditable name="MenuPanes" -->
<?php
		include($_SERVER['DOCUMENT_ROOT'].'/I_MAIN_LEFT_PANE.php');	
		include($_SERVER['DOCUMENT_ROOT'].'/I_Booking_Help.php');
?>
<!-- InstanceEndEditable -->

<!-- InstanceBeginEditable name="Navigation" -->
<?php
		// If more than 1 page to display in selected menu, then show navigator keys
		if (count($SM) > 1) {	
			include($_SERVER['DOCUMENT_ROOT'].'/I_MAIN_NAV.php');
		}
?>
<!-- InstanceEndEditable -->


<!-- InstanceBeginEditable name="body" -->

<?php
		WriteToTraceLog(2, 'P', 'index.php', 'Included menu items', 'count: '.$count);

		$count = count($Selected_pages);
		
		if (count($SM) > 1) { 
			echo '<div class="frame" id="forcecentered">';
			echo '  <ul>';
					for ($i = 0; $i < $count; $i++) {
						$Page = $WP_Group.'/'.$Selected_pages[$i];
						WriteToTraceLog(2, 'P', 'index.php', 'Build scrollable web page', $Page);
						echo '<li>';
						include($_SERVER['DOCUMENT_ROOT'].'/PAGES/'.$Page);
						echo '</li>';
					}
			echo '  </ul>';
			echo '</div>';	
		} else {
			echo '<div style="position:relative; left:98px;">';
				$Page = $WP_Group.'/'.$Selected_pages[0];
				WriteToTraceLog(2, 'P', 'index.php', 'Build single web page', $Page);
				include($_SERVER['DOCUMENT_ROOT'].'/PAGES/'.$Page);
			echo '</div>';
		}
?>

<!-- InstanceEndEditable -->

            </div>      
        </div>
        
</body>
<!-- InstanceEnd --></html>

