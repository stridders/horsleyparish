<?php

if (isset($_POST['WP_Title'])) {

	WriteToTraceLog(0, 'F', 'edit_page_SUB.php', $_POST['WP_Title'], $_POST['Page_action'] );

		//--------------------------------------------------------------------------
		// Check DB connection using mysqli
		//--------------------------------------------------------------------------
		include($_SERVER['DOCUMENT_ROOT'].'/Connections/HORSLEYDB.php');
		if (mysqli_connect_errno()) {
			WriteToErrorLog('ERRC000001', 'Error connecting to DB', 'I_MAIN_LEFT_PANE.php', mysqli_connect_errno() );					  
		}


 	switch ($_POST['Page_action']) {
		
	  // Menu item has been moved up or down 
		case 'MOVE':
				if ($_POST['SMPosition'] < $_POST['OLD_Position'] || $_POST['SMPosition'] > $_POST['OLD_Position'] ) {
					$SQL = "UPDATE web_pages SET WP_MenuOrder=".$_POST['OLD_Position']." WHERE WP_SiteID=".$_SESSION['SiteID']." AND WP_Group='".$WP_Group."' AND WP_MenuOrder=".$_POST['SMPosition'];
					WriteToTraceLog(3, 'F', 'edit_page_SUB.php', 'SQL:', $SQL);	
					if (mysqli_query($HDBi, $SQL)) {
						$SQL = "UPDATE web_pages SET WP_MenuOrder=".$_POST['SMPosition']." WHERE WP_SiteID=".$_SESSION['SiteID']." AND WP_ID=".$_POST['WP_ID'];
						WriteToTraceLog(3, 'F', 'edit_page_SUB.php', 'SQL:', $SQL);
						if (mysqli_query($HDBi, $SQL)) {
							mysqli_commit($HDBi);
						} else {
							$msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
							mysqli_free_result($Result);
							mysqli_close($HDBi);
							WriteToErrorLog('ERRC000003', 'Error updating position in web_page table', 'edit_page_SUB.php', $msgText );
						}
					}
				}
				WriteToTraceLog(2, 'F', 'edit_page_SUB.php', 'Menu item relocated.', '' );
				break;
				
		// Update title (in case it's changed)			
		  case 'CHANGED':					
				$SQL = sprintf("UPDATE web_pages SET WP_Title=%s WHERE  WP_SiteID=".$_SESSION['SiteID']." AND WP_ID=%s",
										  GetSQLValueString($_POST['WP_Title'], "text"),
										  GetSQLValueString($_POST['WP_ID'], "int"));
				
				WriteToTraceLog(3, 'F', 'edit_page_SUB.php', 'SQL:', $SQL);	
				if (mysqli_query($HDBi, $SQL)) {
					mysqli_commit($HDBi);
				} else {
					$msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
					mysqli_close($HDBi);
					WriteToErrorLog('ERRC000003', 'Error updating title in web_page database', 'edit_page_SUB.php', $msgText );
				}	  
				
				WriteToTraceLog(2, 'F', 'edit_page_SUB.php', 'Updates Applied.', '' );
				break;	  
				
		  case 'INSERT_PAGE_A':					
				F_Insert_New_Page($_POST['SMPosition']);  
				WriteToTraceLog(2, 'F', 'edit_page_SUB.php', 'Inserted page above.', '' );
				break;	  

		  case 'INSERT_PAGE_B':					
				F_Insert_New_Page($_POST['SMPosition']);  
				WriteToTraceLog(2, 'F', 'edit_page_SUB.php', 'Inserted page below.', '' );
				break;	  

		  case 'DELETE_PAGE':					
				F_Delete_Page($_POST['WP_ID'],$_POST['SMPosition']); 
				WriteToTraceLog(2, 'F', 'edit_page_SUB.php', 'Delete page.', '' );
				break;	 
				
	} // End of switch statement

	WriteToTraceLog(1, 'F', 'edit_page_SUB.php', '', '' );

}
?>