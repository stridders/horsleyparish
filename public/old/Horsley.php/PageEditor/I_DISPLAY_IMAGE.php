<?php 
//================================================================================================
//
//  Incude:  		I_DISPLAY_IMAGE.php                                                          
//  Description:	Upload an image file		                         
//
//================================================================================================

		WriteToTraceLog(0, 'I', 'I_DISPLAY_IMAGE.php', 'WPT_ID='.$WPT_ID, '.IMG_NBR='.$IMG_NBR );

		$SaveFilename = $WPT_ID.'_'.$IMG_NBR . '.jpg';
		$root_path = '/PAGES/'.$WP_Group.'/images/';									// root path to image file directory 
		$upload_path = $_SERVER['DOCUMENT_ROOT'].$root_path; 					// Upload location		
		$FullFileName = $upload_path . $SaveFilename;
		if (file_exists($FullFileName)) {
			list($width, $height) = getimagesize($FullFileName);
			$x = $height/$width;
		} else {
			$SaveFilename="default.png";
			$root_path = "/PageEditor/images/";
			$x=(180/270);
		}
		
		if ($IMG_NBR == 1) {
			$ImgWidth = $Template['WPT_width'];
			if ($WPT_Template == "P1") {
				$LeftPos = (700 - $Template['WPT_width'])/2;
			} else {
				$LeftPos = 0;
			}
		} else {
			$ImgWidth = 675 - $Template['WPT_width'];
			$LeftPos = $Template['WPT_width'] + 25;
		}
		
		$ImgHeight = $ImgWidth * $x;
		
		$cachekiller = date('His');
		
 	  	//----------------------------------------------------------------------------------------	
        // Display default image if no photo uploaded, else display photo
        //----------------------------------------------------------------------------------------	

		echo '<div title="Click to edit" style="width:'.$ImgWidth.'px; height:100%; display:inline-block; position:absolute; left:'.$LeftPos.'px; top:0px;">';            			
			echo '<img src="' . $root_path . $SaveFilename . '?' . $cachekiller . '" width="'.$ImgWidth.'px;" height="'.$ImgHeight.'px;">';
				
		echo '</div>';

		WriteToTraceLog(1, 'I', 'I_DISPLAY_IMAGE.php', '', '' ); 

?>
