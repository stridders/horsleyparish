<?php
//----------------------------------------------------------------------------------------------
// FUNCTION:	F_Build_Main_Menu
// DESCRIPTION: Rebuild the MAIN_Menu.php file (following a change to the groups table)
//----------------------------------------------------------------------------------------------
  function F_Build_Main_Menu()
  {
		WriteToTraceLog(0, 'F', 'EP_scripts.php', 'F_Build_Main_Menu', '');

		//--------------------------------------------------------------------------
		// Check DB connection using mysqli
		//--------------------------------------------------------------------------
		include($_SERVER['DOCUMENT_ROOT'].'/Connections/HORSLEYDB.php');
		if (mysqli_connect_errno()) {
			WriteToErrorLog('ERRC000001', 'Error connecting to DB', 'ChangeMenu.php', mysqli_connect_errno() );					  
		}	
		
		//----------------------------------------------------------------------------------------------
		// Loop through each row in the Group table and create a menu item for each one
		//---------------------------------------------------------------------------------------------- 			  
		$sql = "SELECT * FROM groups WHERE G_SiteID=".$_SESSION['SiteID']." AND G_Order > 0 ORDER BY G_Order ASC";
		WriteToTraceLog(3, 'P', 'EP_scripts.php', 'Get group list from DB', $sql );	
		$Result = mysqli_query($HDBi, $sql);
		$RowCount = mysqli_num_rows($Result);
		
		if ( mysqli_error($HDBi) ) {
			$msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
			mysqli_free_result($Result);
			mysqli_close($HDBi);
			WriteToErrorLog('ERRC000003', 'Error building MAIN_menu.php file', 'EP_scripts.php', $msgText );
		}

		$Menu_File = $_SERVER['DOCUMENT_ROOT'] . '/MAIN_menu.php' ;
		$fh_menu = fopen($Menu_File, 'w') or die("ERRS000001: Unable to open MAIN_menu.php file with WRITE permissions");
		
		$Menu_array = '';
		$Page_array = '';													

		for ($x=1; $x<=$RowCount; $x++) { 
			$WebPage = mysqli_fetch_assoc($Result);
			
			if ($Menu_array == '') {
				$Menu_array = '"'.$WebPage['G_Desc'].'"';
			} else {
				$Menu_array = $Menu_array.',"'.$WebPage['G_Desc'].'"';
			}
			
			if ($Page_array == '') {
				$Page_array = '"'.$WebPage['G_GroupID'].'"';
			} else {
				$Page_array = $Page_array.',"'.$WebPage['G_GroupID'].'"';
			}
		}

		$stringData = '<?php $MAIN_menu = array(' . $Menu_array . ');';
		fwrite($fh_menu, $stringData."\n");

		$stringData = '$MAIN_pages = array('. $Page_array . ');?>';
		fwrite($fh_menu, $stringData."\n");

		fclose($fh_menu);
		mysqli_free_result($Result);
		mysqli_close($HDBi);
		
		WriteToTraceLog(1, 'F', 'EP_scripts.php', 'F_Build_Main_Menu', '');
  }
  
//----------------------------------------------------------------------------------------------
// FUNCTION:	F_Insert_New_Page
// DESCRIPTION: Inserts a new row into the web page template table, at the position specified
//----------------------------------------------------------------------------------------------
  function F_Insert_New_Page($Pos)
  {
		WriteToTraceLog(0, 'F', 'EP_scripts.php', 'F_Insert_New_Page', 'Pos='.$Pos);
	
		if ( isset($_GET['p']) ) {
			$WP_Group = $_GET['p'];
		} else {	
			$WP_Group = 'Home';
		}
		
		if (! InGroup($WP_Group)) {
			return;
		}
		
		include($_SERVER['DOCUMENT_ROOT'].'/Connections/HORSLEYDB.php');
		
		// Check to see if root path exists
		if (!file_exists($_SERVER['DOCUMENT_ROOT'].'/PAGES/'.$WP_Group)) {
			mkdir($_SERVER['DOCUMENT_ROOT'].'/PAGES/'.$WP_Group);
		}

	  // Shift any other rows beneath position $Pos down 1 position
		$sql = sprintf("UPDATE web_pages SET WP_MenuOrder=(WP_MenuOrder+1) WHERE WP_SiteID=%s AND WP_Group='%s' AND WP_MenuOrder >=%s",
						   $_SESSION['SiteID'],
						   $WP_Group,
						   $Pos);
		WriteToTraceLog(3, 'P', 'EP_scripts.php', 'F_Insert_New_Page', 'Update position of existing web_pages. SQL: '.$sql );
  
		if ( $Result = mysqli_query($HDBi, $sql) ) {
			
			$sql = sprintf("INSERT INTO web_pages (WP_SiteID,WP_Group,WP_MenuOrder,WP_Title) VALUES(%s,'%s',%s,'New Page')",
					  $_SESSION['SiteID'],
					  $WP_Group,
					  $Pos);
			WriteToTraceLog(3, 'P', 'EP_scripts.php', 'F_Insert_New_Page','Insert new web_page. SQL: '.$sql );	
			
			if ( $Result = mysqli_query($HDBi, $sql) ) {
				$WP_ID = mysqli_insert_id($HDBi);
				F_Insert_New_Row($WP_ID,1,"P1","Insert text here");
			}
		}
		
		if (mysqli_error($HDBi)) {
				$msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
				mysqli_rollback($HDBi);
				mysqli_close($HDBi);
				WriteToErrorLog('ERRC000003', 'Error inserting or retrieving new webPage details', 'EP_scripts.php/F_Insert_New_Page', $msgText );
		}
		mysqli_close($HDBi);
		
		WriteToTraceLog(1, 'F', 'EP_scripts.php', 'F_Insert_New_Page', '');
		return $WP_ID;
  }
  
//----------------------------------------------------------------------------------------------
// FUNCTION:	F_Insert_New_Row
// DESCRIPTION: Inserts a new row into the web page template table, at the position specified
//----------------------------------------------------------------------------------------------
  function F_Insert_New_Row($WP_ID,$Pos,$Template,$Text)
  {
	  	WriteToTraceLog(0, 'F', 'EP_scripts.php', 'F_Insert_New_Row', 'Position:' . $Pos);

		include($_SERVER['DOCUMENT_ROOT'].'/Connections/HORSLEYDB.php');
		$WPT_ID = 0;
	  
	  // Shift any other rows beneath position $Pos down 1 position
		$sql = sprintf("UPDATE web_page_template SET WPT_Position=(WPT_Position+1) WHERE WPT_SiteID=%s AND WPT_PageID=%s AND WPT_Position >=%s",
						   $_SESSION['SiteID'],$WP_ID,$Pos);
		WriteToTraceLog(3, 'P', 'EP_scripts.php', 'F_Insert_New_Row', 'Update existing row positions. SQL: '.$sql );
  
		if ( $Result = mysqli_query($HDBi, $sql) ) {
		    if ( $Template == 'AT' ) {
				$colwidth = 450;
				$Text1 = '';
				$Text2 = $Text;
			} else {
				$colwidth = 650;
				$Text1 = $Text;
				$Text2 = '';
			}
			// Insert new row
			$sql = sprintf("INSERT INTO web_page_template (WPT_SiteID,WPT_PageID,WPT_Position,WPT_Template,WPT_Text1, 	
							WPT_Text2, WPT_width, WPT_height) VALUES(%s,%s,%s,'%s','%s','%s',%s,50)",
						   $_SESSION['SiteID'],$WP_ID,$Pos,$Template,$Text1,$Text2,$colwidth);
			WriteToTraceLog(3, 'P', 'EP_scripts.php', 'F_Insert_New_Row', 'Insert New row into web_page_template. SQL: '.$sql );
			
			if ( $Result = mysqli_query($HDBi, $sql) ) {
				$WPT_ID = mysqli_insert_id($HDBi);
				mysqli_commit($HDBi);
			}
		}
		if ( mysqli_error($HDBi) ) {
			$msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
			mysqli_rollback($HDBi);
			mysqli_close($HDBi);
			WriteToErrorLog('ERRC000003', 'Error inserting new row into web_page_template', 'EP_scripts.php/F_Insert_New_Row', $msgText );
		}
  
		mysqli_close($HDBi);

	WriteToTraceLog(1, 'F', 'EP_scripts.php', 'F_Insert_New_Row', 'WPT_ID:' . $WPT_ID);
	
	return $WPT_ID;
  }
  
//----------------------------------------------------------------------------------------------
// FUNCTION:	F_Delete_Row
// DESCRIPTION: Deletes a row from the web page template table
//----------------------------------------------------------------------------------------------
  function F_Delete_Page($WP_ID,$WP_MenuOrder)
  {
	  WriteToTraceLog(0, 'F', 'EP_scripts.php', 'F_Delete_Page', $WP_ID.'/'.$WP_MenuOrder);

		if ( isset($_GET['p']) ) {
			$WP_Group = $_GET['p'];
		} else {	
			$WP_Group = 'Home';
		}
		
		if (! InGroup($WP_Group)) {
			return;
		}
		
		include($_SERVER['DOCUMENT_ROOT'].'/Connections/HORSLEYDB.php');

	// Shift any other rows beneath position $Pos down 1 position
		$sql = sprintf("SELECT WPT_ID,WPT_Position from web_page_template WHERE WPT_SiteID=%s AND WPT_PageID=%s",
						   $_SESSION['SiteID'],
						   $WP_ID);
		WriteToTraceLog(3, 'P', 'EP_scripts.php', 'F_Delete_Page', 'Select all rows for this page. SQL: '.$sql );
  
		if ( $Result = mysqli_query($HDBi, $sql) ) {
			while  ($Row = mysqli_fetch_assoc($Result) ) {
					F_Delete_Row($WP_ID,$Row['WPT_ID'],$Row['WPT_Position']);
			}

			$sql = sprintf("DELETE from web_pages WHERE WP_ID=%s",
						   $WP_ID);
			if ( $Result = mysqli_query($HDBi, $sql) ) {
				WriteToTraceLog(2, 'F', 'EP_scripts.php', 'F_Delete_Page', 'Committing deleted page');
				mysqli_commit($HDBi);
				
			  // Reset the menu order of all subequent menut items
				$sql = sprintf("UPDATE web_pages SET WP_MenuOrder=(WP_MenuOrder-1) WHERE WP_SiteID=%s AND WP_Group='%s' AND WP_MenuOrder >%s",
								   $_SESSION['SiteID'],
								   $WP_Group,
								   $WP_MenuOrder);
				WriteToTraceLog(3, 'P', 'EP_scripts.php', 'F_Delete_Page', 'Update position of existing web_pages. SQL: '.$sql );
		  
				$Result = mysqli_query($HDBi, $sql);
			}
		}
		if ( mysqli_error($HDBi) ) {
			$msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi); 
			mysqli_rollback($HDBi);
			mysqli_close($HDBi);
			WriteToErrorLog('ERRC000003', 'Error getting rows for current page', 'EP_scripts.php/F_Delete_Page', $msgText );
		}
		
		mysqli_close($HDBi);

	  WriteToTraceLog(1, 'F', 'EP_scripts.php', 'F_Delete_Page', '');

  }
//----------------------------------------------------------------------------------------------
// FUNCTION:	F_Delete_Row
// DESCRIPTION: Deletes a row from the web page template table
//----------------------------------------------------------------------------------------------
  function F_Delete_Row($WP_ID,$WPT_ID,$Pos)
  {
	  WriteToTraceLog(0, 'F', 'EP_scripts.php', 'F_Delete_Row', $WP_ID.'/'.$WPT_ID.'/'.$Pos);

		include($_SERVER['DOCUMENT_ROOT'].'/Connections/HORSLEYDB.php');

		$SQL = sprintf("DELETE FROM web_page_template WHERE WPT_ID=%s",	$WPT_ID);
		
		WriteToTraceLog(3, 'I', 'I_EDIT_PAGE_TEMPLATE_SUB.php', 'Delete WPT row', 'sql='.$SQL );
		
		if ($Result = mysqli_query($HDBi, $SQL)) {
			//----------------------------------------------------------------------------------------	
			// Remove all possible image and PDF files associated with this row
			//----------------------------------------------------------------------------------------	
			$root_path = '/PAGES/'.$_GET['p'].'/images';						// root path to image file directory 
			$upload_path = $_SERVER['DOCUMENT_ROOT'].$root_path.'/'; 			// Upload location
			$DeleteFilename = $WPT_ID. '_1.jpg';
			$FullFileName = $upload_path . $DeleteFilename;
			if (file_exists($FullFileName)) { 
				$rc = unlink($FullFileName);
			}
			$DeleteFilename = $WPT_ID. '_2.jpg';
			$FullFileName = $upload_path . $DeleteFilename;
			if (file_exists($FullFileName)) { 
				$rc = unlink($FullFileName);
			}
			$root_path = '/PAGES/'.$_GET['p'].'/pdf';						// root path to image file directory 
			$upload_path = $_SERVER['DOCUMENT_ROOT'].$root_path.'/'; 			// Upload location
			$DeleteFilename = $WPT_ID. '.pdf';
			$FullFileName = $upload_path . $DeleteFilename;			
			if (file_exists($FullFileName)) { 
				$rc = unlink($FullFileName);
			}
			
			WriteToTraceLog(0, 'F', 'EP_scripts.php', 'F_Delete_Row', 'Committing delete. WPD_ID='.$WPT_ID);
			mysqli_commit($HDBi);
			
		  // Reset the positions of all subequent rows
			$sql = sprintf("UPDATE web_page_template SET WPT_Position=(WPT_Position-1) WHERE  WPT_SiteID=%s AND WPT_PageID=%s AND WPT_Position >%s",
							   $_SESSION['SiteID'],
							   $WP_ID,
							   $Pos);
			WriteToTraceLog(3, 'P', 'EP_scripts.php', 'F_Delete_Row', 'Update position of existing templates. SQL: '.$sql );
	  
			if ( $Result = mysqli_query($HDBi, $sql) ) {
				mysqli_commit($HDBi);
			}
		}
		if ( mysqli_error($HDBi) ) {
			//--------------------------------------------------------------------------------
			// Write error to Error log
			//--------------------------------------------------------------------------------
			$msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
			mysqli_close($HDBi);
			WriteToErrorLog('ERRC000003', 'Error deleting row from web_page_template table', 'EP_scripts.php/F_Delete_Row', $msgText );
		}						
		
		mysqli_close($HDBi);
				
  	WriteToTraceLog(1, 'F', 'EP_scripts.php', 'F_Delete_Row', '');
  }
?>