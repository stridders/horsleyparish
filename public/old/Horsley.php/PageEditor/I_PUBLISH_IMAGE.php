<?php 
//================================================================================================
//
//  Incude:  		I_PUBLISH_IMAGE.php                                                          
//  Description:	Upload an image file		                         
//
//================================================================================================

		WriteToTraceLog(0, 'I', 'I_PUBLISH_IMAGE.php', '', '' );

		$SaveFilename = $Template['WPT_ID'].'_'.$IMG_NBR . '.jpg';
		$root_path = '/PAGES/'.$WP_Group.'/images/';							// root path to image file directory 
		$upload_path = $_SERVER['DOCUMENT_ROOT'].$root_path; 					// Upload location		
		$FullFileName = $upload_path . $SaveFilename;
		if (file_exists($FullFileName)) {
			list($width, $height) = getimagesize($FullFileName);
			$x = $height/$width;
		} else {
			$SaveFilename="default.png";
			$root_path ="/PageEditor/images/";
			$x=(180/270);
		}
		
		if ($IMG_NBR == 1) {
			$ImgWidth = $Template['WPT_width'];
			if ($Template['WPT_Template'] == "P1") {
				$LeftPos = (700 - $Template['WPT_width'])/2;
			} else {
				$LeftPos = 0;
			}
		} else {
			$ImgWidth = 675 - $Template['WPT_width'];
			$LeftPos = $Template['WPT_width'] + 25;
		}
		
		$ImgHeight = $ImgWidth * $x;
		
 	  	//----------------------------------------------------------------------------------------	
        // Display default image if no photo uploaded, else display photo
        //----------------------------------------------------------------------------------------	

		$stringData = '<div style="width:'.$ImgWidth.'px; height:100%; display:inline-block; position:absolute; left:'.$LeftPos.'px; top:0px;">'; 
		fwrite($fh, $stringData."\n");
		
		$stringData = '<img src="' . $root_path . $SaveFilename . '?' . time() . '" width="'.$ImgWidth.'px;" height="'.$ImgHeight.'px;">';
		fwrite($fh, $stringData."\n");
				
		$stringData = '</div>';
		fwrite($fh, $stringData."\n");

		WriteToTraceLog(1, 'I', 'I_PUBLISH_IMAGE.php', '', '' ); 

?>
