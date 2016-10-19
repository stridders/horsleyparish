<?php 
//================================================================================================
//
//  Incude:  		I_UPLOAD_LIST_ITEM.php                                                          
//  Description:	Upload a PDF file		                         
//
//================================================================================================
		
	  	//----------------------------------------------------------------------------------------	
		// If a new file has been submitted for upload into a filelist then insert an new entry
		// into the database and upload the file
	  	//----------------------------------------------------------------------------------------	
		if ( isset($_POST["MM_Save_to_list"]) ) {
			
			WriteToTraceLog(0, 'I', 'I_UPLOAD_LIST_ITEM.php', '',''  );

			if (isset($_POST['WP_Group'])) {
				$WP_Group = $_POST['WP_Group'];
			}
			if (!isset($WPT_ID)) {
				$WPT_ID = $_POST['WPT_ID'];
			}
			
			$filename = $_FILES['userfile']['name']; 									// Get the name of the file (including file extension).

			//----------------------------------------------------------------------------------------------
			// Insert new entry into pdf_list table
			//---------------------------------------------------------------------------------------------- 			  
			$sql = sprintf("INSERT INTO file_list (FL_FileName,FL_SiteID,FL_WPT_ID) VALUES('%s',%s,%s)",
					  			$filename,
								$_SESSION['SiteID'],
					  			$WPT_ID);
			WriteToTraceLog(3, 'P', 'I_UPLOAD_LIST_ITEM.php', 'Insert SQL:', $sql );

			if ($ResultFileList = mysqli_query($HDBi, $sql)) {

				$FileID = mysqli_insert_id($HDBi);

				$SaveFilename = $WPT_ID.'.'.$FileID.'.pdf';	
				$root_path = '/PAGES/'.$WP_Group.'/pdf/';								// root path to image file directory 		
				$upload_path = $_SERVER['DOCUMENT_ROOT'].$root_path; 					// Upload location		
				$max_filesize = 5000000; 												// PDF file size limit							
				
				WriteToTraceLog(2, 'P', 'I_UPLOAD_LIST_ITEM.php', 'Inserting new file into list box', '' );
				
				// Check to see if root path exists
				if (!file_exists($_SERVER['DOCUMENT_ROOT'].'/PAGES/'.$WP_Group)) {
					mkdir($_SERVER['DOCUMENT_ROOT'].'/PAGES/'.$WP_Group);
				}
				// Check to see if image/pdf folder exists
				if (!file_exists($_SERVER['DOCUMENT_ROOT'].$root_path)) {
					mkdir($_SERVER['DOCUMENT_ROOT'].$root_path);
				}				
				if (filesize($_FILES['userfile']['tmp_name']) > $max_filesize) {
					$msg = "The file you attempted to upload is too large. Maximum file size is $max_filesize bytes.";
				} else {	   
					// Check if we can upload to the specified path, if not DIE and inform the user.
					if (!is_writable($upload_path)) {
						$msg = 'Insufficient access priviledges. Upload failed';
					} else {
						// Upload the file to your specified path.
						if (move_uploaded_file($_FILES['userfile']['tmp_name'],$upload_path . $SaveFilename)) {				
							mysqli_commit($HDBi);							
						} else {
							mysqli_rollback($HDBi);
							$msg = 'There was an error during the file upload. Please try again'; 	
						}
					}
				}
			} else {
				//--------------------------------------------------------------------------------
				// Write error to Error log
				//--------------------------------------------------------------------------------
				$msgText = 'SQL:' . $sql . ' --  Error: ' . mysqli_error($HDBi);
				mysqli_close($HDBi);
				WriteToErrorLog('ERRC000003', 'Error updating web_page_template row', 'I_UPLOAD_LIST_ITEM.php', $msgText );
			}
		}
		
	  	//----------------------------------------------------------------------------------------	
		// If a new file has been submitted for upload into a filelist then insert an new entry
		// into the database and upload the file
	  	//----------------------------------------------------------------------------------------	
		if ( isset($_POST["MM_Delete_PDF_from_list"]) ) {
			
			if (!isset($WPT_ID)) {
				$WPT_ID = $_POST['WPT_ID'];
			}
			
			$filename = $WPT_ID . "." . $_POST['EPpdflist'] . ".pdf";
			WriteToTraceLog(1, 'P', 'I_UPLOAD_LIST_ITEM.php', 'Delete file:', $filename );
			
			$sql = sprintf("DELETE FROM file_list WHERE FL_SiteID=%s AND FL_FileID=%s",	
						   $_SESSION['SiteID'], 
						   $_POST['EPpdflist']);
		
			WriteToTraceLog(3, 'I', 'I_UPLOAD_LIST_ITEM.php', 'Delete from PDF file list', 'sql='.$sql );
		
			if ($ResultFileList = mysqli_query($HDBi, $sql)) {
				$root_path = '/PAGES/'.$WP_Group.'/pdf/';								// root path to image file directory 		
				$upload_path = $_SERVER['DOCUMENT_ROOT'].$root_path; 					// Upload location				
				$FullFileName = $upload_path . $filename;
				if (file_exists($FullFileName)) { 
					$rc = unlink($FullFileName);
				}
				WriteToTraceLog(0, 'F', 'I_UPLOAD_LIST_ITEM.php', 'Item deleted from list box', 'File name:'.$filename);
				mysqli_commit($HDBi);
			} else {
				//--------------------------------------------------------------------------------
				// Write error to Error log
				//--------------------------------------------------------------------------------
				$msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
				mysqli_close($HDBi);
				WriteToErrorLog('ERRC000003', 'Error deleting row from file_list table', 'I_UPLOAD_LIST_ITEM.php', $msgText );
			}
		}
		
?>
