<?php 
//================================================================================================
//
//  Incude:  		I_PUBLISH_TEXT.php                                                          
//  Description:	Display a text area		                         
//
//================================================================================================

		WriteToTraceLog(0, 'I', 'I_PUBLISH_TEXT.php', '', '' );

		if ($TEXT_NBR == 1) {
			$TextWidth = $Template['WPT_width'];
			if ($Template['WPT_Template'] == "T1") {
				$LeftPos = (700 - $Template['WPT_width'])/2;
			} else {
				$LeftPos = 0;		
			}
		} else {
			if ($Template['WPT_Template'] == "AT") {
				$TextWidth = (670 - $Template['WPT_width']);
				$LeftPos = 385 - ($TextWidth/2);
			} else {
				$TextWidth = 675 - $Template['WPT_width'];
				$LeftPos = $Template['WPT_width'] + 25;
			}
		}
		$TextField='WPT_Text'.$TEXT_NBR;
		
 	  	//----------------------------------------------------------------------------------------	
        // Display default image if no photo uploaded, else display photo
        //----------------------------------------------------------------------------------------	

		$stringData = '<div style="width:'.$TextWidth.'px; height:'.$Template['WPT_height'].'px; display:inline-block; position:absolute; left:'.$LeftPos.'px; top:0px">';  
		fwrite($fh, $stringData."\n");
		
		fwrite($fh, $Template[$TextField]."\n");
		
		$stringData = '</div>';
		fwrite($fh, $stringData."\n");
		
		WriteToTraceLog(1, 'I', 'I_PUBLISH_TEXT.php', '', '' ); 

?>
