<?php
//================================================================================================
//
//  Incude:  		AJAX_INSERT_DRAGGED_FILE_SUB.php                                                       
//  Description:	Update DB when row is edited, without refreshing the page                                 
//
//================================================================================================

		include($_SERVER['DOCUMENT_ROOT'].'/scripts/Common.php');
		include($_SERVER['DOCUMENT_ROOT'].'/scripts/EP_scripts.php');

		WriteToTraceLog(0, 'F', 'AJAX_INSERT_DRAGGED_FILE_SUB.php', '', '');

		$filename = $_FILES['userfile']['name']; 								// Get the name of the file (including file extension).	
		$ext = substr($filename, (strlen($filename)-3), 3); 						// Get the extension from the filename.

		WriteToTraceLog(1, 'F', 'AJAX_INSERT_DRAGGED_FILE_SUB.php', 'Upload file type:', $ext);

		if ($ext == "pdf") {
		
			$filename = substr($filename,0,strlen($filename)-4);				// Strip the extension from file name
			$Text = '<p><font size="4">'. $filename .'</font></p>';
			
			$WPT_ID = F_Insert_New_Row($_POST['WP_ID'],($_POST['WPT_Position']+1),'AT',$Text);

			include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_UPLOAD_IMAGE_SUB.php');	

		}

		WriteToTraceLog(1, 'F', 'AJAX_INSERT_DRAGGED_FILE_SUB.php', 'WPT_ID:', $WPT_ID);
?>

