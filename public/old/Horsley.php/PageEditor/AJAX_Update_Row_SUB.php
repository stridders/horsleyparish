<?php
//================================================================================================
//
//  Incude:  		AJAX_Update_Row_SUB.php                                                       
//  Description:	Update DB when row is edited, without refreshing the page                                 
//
//================================================================================================

		include($_SERVER['DOCUMENT_ROOT'].'/scripts/Common.php');
		
		WriteToTraceLog(0, 'I', 'AJAX_Update_Row_SUB.php', '', '' );
		 WriteToTraceLog(2, 'I', 'AJAX_Update_Row_SUB.php', 'TEXT:', $_POST['WPT_Text1'] );		
		//--------------------------------------------------------------------------
		// Check DB connection using mysqli
		//--------------------------------------------------------------------------
		include($_SERVER['DOCUMENT_ROOT'].'/Connections/HORSLEYDB.php');
		
		if (mysqli_connect_errno()) {
			WriteToErrorLog('ERRC000001', 'Error connecting to DB', 'edit_page.php', mysqli_connect_errno() );					  
		}	
			
		$SQL = sprintf("UPDATE web_page_template set WPT_Template=%s,WPT_Text1=%s,WPT_Text2=%s,WPT_width=%s, WPT_height=%s WHERE WPT_SiteID=".				
	$_SESSION['SiteID']." AND WPT_ID=".$_POST['WPT_ID'],
									GetSQLValueString($_POST['WPT_Template'], "text"),
									GetSQLValueString($_POST['WPT_Text1'],"RTEtext"),
									GetSQLValueString($_POST['WPT_Text2'],"RTEtext"),
									GetSQLValueString($_POST['WPT_width'], "int"),
									GetSQLValueString($_POST['WPT_height'], "int"));
		
		WriteToTraceLog(3, 'I', 'AJAX_Update_Row_SUB.php', 'Update web_page_template row', 'sql='.$SQL );
		
		if ($Result = mysqli_query($HDBi, $SQL)) {
			mysqli_commit($HDBi);	
		} else {
			//--------------------------------------------------------------------------------
			// Write error to Error log
			//--------------------------------------------------------------------------------
			$msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
			mysqli_close($HDBi);
			WriteToErrorLog('ERRC000003', 'Error updating web_page_template row', 'AJAX_Update_Row_SUB.php', $msgText );
		}
		
		WriteToTraceLog(1, 'I', 'AJAX_Update_Row_SUB.php', '', '' );

?>