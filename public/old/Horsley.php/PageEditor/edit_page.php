<?php session_start() ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Update Web Content</title>
    <link rel="stylesheet" href="/css/main.css"/>
    <link rel="stylesheet" href="/css/jquery-ui-1.10.3.custom.min.css"/> 
    <!-- Scripts -->
    <script src="/scripts/Misc.js"></script>
    <script src="/scripts/jQuery2.0.3.js" type="text/javascript"></script>
    <script src="/scripts/nicEdit.js" type="text/javascript"></script>
	<script src="/scripts/jquery.ui.js" type="text/javascript"></script>
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

		<div id="statusbar" class="statusbar" style="display:none">
        	<div id="filename" class="filename"></div>
            <div id="filesize" class="filesize"></div>
            <div id="progressbar" class="progressBar"><div></div></div>
        </div>
             
		<div class="MainPage">
			<div class="wrap">
<?php
		WriteToTraceLog(0, 'P', 'edit_page.php', '', '' );
		
		AuthenticateUser();
		
		//--------------------------------------------------------------------------
		// Process form changes
		//--------------------------------------------------------------------------
		include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/edit_page_SUB.php'); 
		
		//--------------------------------------------------------------------------
		// Build left and right menu columns
		//--------------------------------------------------------------------------		
		include($_SERVER['DOCUMENT_ROOT'].'/I_MAIN_LEFT_PANE.php');
        include($_SERVER['DOCUMENT_ROOT'].'/I_MAIN_HELP_PANE.php'); 
		
?>
<?php

		//----------------------------------------------------------------------//
		// Capture URL parms													//
		//----------------------------------------------------------------------//
		
		if ( isset($_GET['ROW']) ) {
			$WPT_Position = $_GET['ROW'];
		} else {
			$WPT_Position = 1;
		}

		if ( isset($_GET['WP_ID']) ) {
			$WP_ID = $_GET['WP_ID'];
		}
		if ( isset($_GET['p']) ) {
			$WP_Group = $_GET['p'];
		} else {	
			$WP_Group = 'Home';
		}

		//----------------------------------------------------------------------//
		// Set control vars for FileLoader (to import images)					//
		//----------------------------------------------------------------------//
		
		$IMG_NBR = 1;
		
		$editFormAction = $_SERVER['PHP_SELF'];									// Save current URL
		if (isset($_SERVER['QUERY_STRING'])) {
			$editFormAction .= "?" . htmlentities($_SERVER['QUERY_STRING']);
		}
		
	  //--------------------------------------------------------------------------
	  // Check DB connection using mysqli
	  //--------------------------------------------------------------------------
		include($_SERVER['DOCUMENT_ROOT'].'/Connections/HORSLEYDB.php');
		if (mysqli_connect_errno()) {
			WriteToErrorLog('ERRC000001', 'Error connecting to DB', 'edit_page.php', mysqli_connect_errno() );					  
		}	
		
		include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_UPLOAD_IMAGE_SUB.php'); 
		include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_EDIT_PAGE_TEMPLATE_SUB.php');
		
		//----------------------------------------------------------------------------------------------
		// Get Page Template entries from DB
		//---------------------------------------------------------------------------------------------- 			  
		$sql = "SELECT * FROM web_pages,web_page_template WHERE WP_SiteID=".$_SESSION['SiteID']." AND WPT_SiteID=WP_SiteID AND WP_Group='".$WP_Group."' AND WP_ID='".$WP_ID."' AND WP_ID=WPT_PageID ORDER BY WPT_Position";
		WriteToTraceLog(3, 'P', 'edit_page.php', 'Get web_pages_templates from DB', $sql );	
		$Result = mysqli_query($HDBi, $sql);
		$TemplateRowCount = mysqli_num_rows($Result);

		if ( mysqli_error($HDBi) ) {
			WriteToErrorLog('ERRC000002', 'Error while getting web_page details from database', 'edit_page.php', mysqli_error($HDBi) );
		}	
?>
		<table width="700px" style="position:absolute; left:196px;">
<?php					
			while ($Template = mysqli_fetch_assoc($Result)) {
       
	   		  WriteToTraceLog(3, 'P', 'edit_page.php', 'Row:'.$Template['WPT_Position'], '' );

			  // Determine whether to edit line or just display it, based on row selected by 'SM' URL parm
				if ($Template['WPT_Position'] == $WPT_Position) {
					
					echo '<tr style="border:thin solid #999;" id="ROW'.$Template['WPT_Position'].'" >';
					echo '  <td valign="top" align="left" height="'.$Template['WPT_height'].'px" style="position:relative" id="ROW_TD'.$Template['WPT_Position'].'" >';					
						include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_EDIT_PAGE_TEMPLATE.php');
					echo '    </td>';
					echo '  </tr>';
				
				} else {
					
					echo '<tr id="ROW'.$Template['WPT_Position'].'">';
					echo '  <td id="ROW_TD'.$Template['WPT_Position'].'" style="position:relative;" valign="top" align="left" height="'.$Template['WPT_height'].'px" >';
					echo '    <a class="DisplayRow" onClick="Submit_and_Open(\'Template_Form\',\'/PageEditor/edit_page.php?p='.$WP_Group.'&WP_ID='.$WP_ID.'&R='.$Template['WPT_ID'].'&ROW='.$Template['WPT_Position'].'#ROW'.$Template['WPT_Position'].'\');">';
					
					include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_DISPLAY_PAGE_TEMPLATE.php');
					echo '    </a>';
					echo '  </td>';
					echo '</tr>';
				}
			}
?>
        </table>        
        
<?php
	  //----------------------------------------------------------------------------------------------
	  //  free up sql object(s)
	  //----------------------------------------------------------------------------------------------
  
		  mysqli_free_result($Result);
		  mysqli_close($HDBi);
		  WriteToTraceLog(1, 'P', 'edit_page.php', '', '' );
?>            
            </div>      
</div>
 

      
     
        
</body>
</html>            