<?php 
//================================================================================================
//
//  Incude:  		I_UPLOAD_IMAGE_SUB.php                                                         
//  Description:	Process photo form submission		                         
//
//================================================================================================
	
	  	//----------------------------------------------------------------------------------------	
		// If a new file has been submitted for upload then upload photo to
		// relevent location
	  	//----------------------------------------------------------------------------------------	
		if ( isset($_POST["MM_Save_IMAGE"]) || isset($_POST["MM_Save_PDF"]) ) {
			
			WriteToTraceLog(0, 'I', 'I_UPLOAD_IMAGE_SUB.php', 'Save File Type' . $_POST['FileType'], '. Item Nbr ' . $_POST['ITEM_NBR'] );
		  
		  	if (isset($_POST['ITEM_NBR']) && $_POST['ITEM_NBR'] != '') {
				$ITEM_NBR = $_POST['ITEM_NBR'];
			} else {
				$ITEM_NBR = 1;
			}
			if (isset($_POST['WP_Group'])) {
				$WP_Group = $_POST['WP_Group'];
			}
			if (!isset($WPT_ID)) {
				$WPT_ID = $_POST['WPT_ID'];
			}
			
			// Configuration - Your Options
			if (strtolower($_POST['FileType']) == "jpg") {
				$max_filesize = 500000; 											// Image file size limit	
				$SaveFilename = $WPT_ID. '_'.$ITEM_NBR.'.jpg';
				$root_path = '/PAGES/'.$WP_Group.'/images';							// root path to image file directory 
				$upload_path = $_SERVER['DOCUMENT_ROOT'].$root_path.'/'; 			// Upload location
			} else {
				$max_filesize = 8000000; 											// PDF file size limit	
				$SaveFilename =  $WPT_ID.'.pdf';
				$root_path = '/PAGES/'.$WP_Group.'/pdf';							// root path to pdf file directory 
				$upload_path = $_SERVER['DOCUMENT_ROOT'].$root_path.'/'; 			// Upload location
			}
			$filename = $_FILES['userfile']['name']; 								// Get the name of the file (including file extension).
			
			$ext = substr($filename, strlen($filename)-3, 3); 						// Get the extension from the filename.
			$msg = "";
			
			
			// Check to see if root path exists
			if (!file_exists($_SERVER['DOCUMENT_ROOT'].'/PAGES/'.$WP_Group)) {
				mkdir($_SERVER['DOCUMENT_ROOT'].'/PAGES/'.$WP_Group);
			}
			// Check to see if image/pdf folder exists
			if (!file_exists($_SERVER['DOCUMENT_ROOT'].$root_path)) {
				mkdir($_SERVER['DOCUMENT_ROOT'].$root_path);
			}
			
					  
			// Check if the filetype is allowed, if not DIE and inform the user.
			if ( strtolower($ext) != strtolower($_POST['FileType'])) {
				$msg = 'The file you attempted to upload is not allowed. Only a ' . $_POST['FileType'] . ' file can be uploaded. File:'.$filename;
			} else {
				if (strtolower($_POST['FileType']) == "jpg") {
					list($width, $height, $type, $attr) = getimagesize($_FILES['userfile']['tmp_name']);
					if ($type != IMAGETYPE_JPEG ) {
						$msg = 'The file you attempted to upload has the correct jpg extension but does not appear to be a valid JPEG file.';			
					}
				}
				if ($msg == "") {
					// Now check the filesize, if it is too large then DIE and inform the user.
					if (filesize($_FILES['userfile']['tmp_name']) > $max_filesize) {
						$msg = "The file you attempted to upload is too large. Maximum file size is $max_filesize bytes.";
					} else {	   
						// Check if we can upload to the specified path, if not DIE and inform the user.
						if (!is_writable($upload_path)) {
							$msg = 'Insufficient access priviledges. Upload failed';
						} else {
							// Upload the file to your specified path.
							if (move_uploaded_file($_FILES['userfile']['tmp_name'],$upload_path . $SaveFilename)) {
							   	$msg = 'Your file upload was successful'.$upload_path . $SaveFilename; 
							} else {
							   	$msg = 'There was an error during the file upload. Please try again'; 	
							}
						}
					}
				}
			}
			
			WriteToTraceLog(1, 'I', 'I_UPLOAD_IMAGE_SUB.php', 'Save image to' . $upload_path . $SaveFilename . '  msg=', $msg );
		}
	  	//----------------------------------------------------------------------------------------	
		// If user requested their image be deleted, then delete it
	  	//----------------------------------------------------------------------------------------	
		if (isset($_POST["MM_Delete_Image"])) {
			
			WriteToTraceLog(0, 'I', 'I_UPLOAD_IMAGE_SUB.php', 'Delete Image', $_POST['ITEM_NBR'] );
			
			if (isset($_POST['ITEM_NBR']) && $_POST['ITEM_NBR'] != '') {
				$ITEM_NBR = $_POST['ITEM_NBR'];
			} else {
				$ITEM_NBR = 1;
			}
			
			if ($_POST['FileType'] == "jpg") {	
				$SaveFilename = $_GET['R']. '_'.$ITEM_NBR.'.jpg';
				$root_path = '/PAGES/'.$WP_Group.'/images/';								// root path to image file directory 
			} else {
				$SaveFilename = $_GET['R']. '.pdf';
				$root_path = '/PAGES/'.$WP_Group.'/pdf/';									// root path to image file directory 		
			}
			$upload_path = $_SERVER['DOCUMENT_ROOT'].$root_path; 							// Upload location	
			$FullFileName = $upload_path . $SaveFilename;
			unlink($FullFileName);		
        
			WriteToTraceLog(1, 'I', 'I_UPLOAD_IMAGE_SUB.php', 'Delete Image', '' ); 
			
		}
?>