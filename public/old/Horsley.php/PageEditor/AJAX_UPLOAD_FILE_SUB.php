<?php
//================================================================================================
//
//  Incude:  		AJAX_UPLOAD_FILE_SUB.php                                                       
//  Description:	Update DB when row is edited, without refreshing the page                                 
//
//================================================================================================

		include($_SERVER['DOCUMENT_ROOT'].'/scripts/Common.php');


		//Filter the file types , if you want.
		if ($_FILES["file"]["error"] > 0)
		{
			WriteToTraceLog(2, 'I', 'AJAX_UPLOAD_FILE_SUB.php', 'error', $_FILES["userfile"]["error"] );
		}
		else
		{
		// move_uploaded_file($_FILES["file"]["tmp_name"],$output_dir. $_FILES["file"]["name"]);
			WriteToTraceLog(2, 'I', 'AJAX_UPLOAD_FILE_SUB.php', 'Upload', $_FILES["userfile"]["name"] );
		}
		
		//--------------------------------------------------------------------------
		// Check DB connection using mysqli
		//--------------------------------------------------------------------------
		include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_UPLOAD_IMAGE_SUB.php');
		
		WriteToTraceLog(1, 'I', 'AJAX_UPLOAD_FILE_SUB.php', '', '' );
?>