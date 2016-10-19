<?php session_start() ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Publish dynamic web pages</title>

    <link rel="stylesheet" href="/css/main.css"/>
        
    <script src="/scripts/Misc.js"></script>

</head>

<body>
<?php
//================================================================================================
//
//  PHP Script:  	PUBLISH.php                                                          
//  Description:	Extracts the web pages and associated templates for the current menu group and
//     				builds php web pages from the results.
//
//================================================================================================

		$URL_Link = "/index.php?p=".$_GET['p'];

		include($_SERVER['DOCUMENT_ROOT'].'/scripts/Common.php');		
		  
	  //--------------------------------------------------------------------------
	  // Check DB connection using mysqli
	  //--------------------------------------------------------------------------
		include($_SERVER['DOCUMENT_ROOT'].'/Connections/HORSLEYDB.php');
		if (mysqli_connect_errno()) {
			WriteToErrorLog('ERRC000001', 'Error connecting to DB', 'Publish.php', mysqli_connect_errno() );					  
		}	
				
		//----------------------------------------------------------------------------------------------
		// Get Page Template entries from DB
		//---------------------------------------------------------------------------------------------- 			  
		$sql = "SELECT * FROM web_pages,web_page_template WHERE WP_SiteID=".$_SESSION['SiteID']." AND WPT_SiteID=WP_SiteID AND WP_Group='".$_GET['p']."' AND WP_ID=WPT_PageID ORDER BY WP_MenuOrder,WPT_Position";
		WriteToTraceLog(3, 'P', 'Publish.php', 'Get web_pages_templates from DB', $sql );	

		$Result = mysqli_query($HDBi, $sql);
		$TemplateRowCount = mysqli_num_rows($Result);
	
		if ( mysqli_error($HDBi) ) {
			WriteToErrorLog('ERRC000002', 'Error while getting web_page details from database', 'Publish.php', mysqli_error($HDBi) );
		}	
		
		// Check to see if root path exists and if not, create folder.
		if (!file_exists($_SERVER['DOCUMENT_ROOT'].'/PAGES/'.$WP_Group)) {
			mkdir($_SERVER['DOCUMENT_ROOT'].'/PAGES/'.$WP_Group);
		}		
		
		$Menu_Item = 0;
		$WP_Group = $_GET['p'];
		$MODE="PUBLISH";
		$Menu_File = $_SERVER['DOCUMENT_ROOT'] . '/PAGES/' . $WP_Group . '/menu.php' ;
		$fh_menu = fopen($Menu_File, 'w') or die("ERRS000001: Unable to open new web page menu file with WRITE permissions");
		$SM_array = '';
		$Pages_array = '';
		$root_path = '/PAGES/'.$WP_Group.'/images/';							// root path to image file directory 
		$upload_path = $_SERVER['DOCUMENT_ROOT'].$root_path; 					// Upload location
		
		echo "<br><br><br><br>   Please wait a few seconds while I publish the pages ";
		
		while ($Template = mysqli_fetch_assoc($Result)) {
			echo ".";
			// If Menu item has changed, then save last output file and open a new output file
			if ($Template['WP_ID'] != $Menu_Item) {	
				// Close the current file (to save changes)
				if (isset($FileOut)) {
					$stringData = '</table>';
					fwrite($fh, $stringData . "");
					fclose($fh);					
				}
				// If the page is locked against being edited, the skip file open step
				if ($Template['WP_LOCK']) {
					unset($FileOut);
				} else {
					// Set the name of the newext file. 
					// Open the file ('w'- option creates it if it doesn't exist, and clears out any pre-existing content)
					$FileOut = $_SERVER['DOCUMENT_ROOT'] . '/PAGES/' . $Template['WP_Group'] . '/' . $Template['WP_Group'].$Template['WP_MenuOrder'] . '.php' ;
					$fh = fopen($FileOut, 'w') or die("ERRS000001: Unable to open new web page file with WRITE permissions");
					
					$stringData = '<?php $PageNbr='.($Template['WP_MenuOrder']-1) . '; ?>';
					fwrite($fh, $stringData."\n");
					
					$stringData = '<table width="700px">';
					fwrite($fh, $stringData."\n");
				}
				
				if ($SM_array == '') {
					$SM_array = '"'.$Template['WP_Title'].'"';
				} else {
					$SM_array = $SM_array.',"'.$Template['WP_Title'].'"';
				}
				if ($Pages_array == '') {
					$Pages_array = '"'.$Template['WP_Group'].$Template['WP_MenuOrder'].'.php"';
				} else {
					$Pages_array = $Pages_array.',"'.$Template['WP_Group'].$Template['WP_MenuOrder'].'.php"';
				}
				$Menu_Item = $Template['WP_ID'];
			}
			if (! $Template['WP_LOCK']) {
				$stringData = '<tr>';
				fwrite($fh, $stringData."\n");
				$stringData = '  <td valign="top" align="left">';
				fwrite($fh, $stringData."\n");
			  
			  
				$stringData = '    <table width="700px">';
				fwrite($fh, $stringData."\n");
				$stringData = '      <tr>';
				fwrite($fh, $stringData."\n");
				$stringData = '        <td valign="top" height="'. $Template['WPT_height'] . 'px">';
				fwrite($fh, $stringData."\n");
				$stringData = '           <div style="position:relative;">';
				fwrite($fh, $stringData."\n");
				
				include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/Templates/I_EP_'.$Template['WPT_Template'].'.php');
	
				$stringData = '           </div>';
				fwrite($fh, $stringData."\n");
				
				$stringData = '        </td>';
				fwrite($fh, $stringData."\n");
				$stringData = '      </tr>';
				fwrite($fh, $stringData."\n");
				$stringData = '    </table>';
				fwrite($fh, $stringData."\n");			
	
				$stringData = '  </td>';
				fwrite($fh, $stringData."\n");
				$stringData = '</tr>';
				fwrite($fh, $stringData."\n");
			}
		}
		if (isset($FileOut)) {
			$stringData = '</table>';
			fwrite($fh, $stringData."\n");
			fclose($fh);	
		}
		$stringData = '<?php $SM = array(' . $SM_array . ');';
		fwrite($fh_menu, $stringData."\n");

		$stringData = '$Selected_pages = array('. $Pages_array . ');?>';
		fwrite($fh_menu, $stringData."\n");
		
		fclose($fh_menu);
	  
	  //----------------------------------------------------------------------------------------------
	  //  free up sql object(s)
	  //----------------------------------------------------------------------------------------------
  
		mysqli_free_result($Result);
		mysqli_close($HDBi);
		
?>

		<script language="javascript">window.location.href='<?php echo $URL_Link;?>'</script>  

</body>
