<?php 
//================================================================================================
//
//  Incude:  		I_EP_CP.php                                                          
//  Description:	Edit Page template CP - Booking Calendar with picture on right			                         
//
//================================================================================================
		WriteToTraceLog(0, 'I', 'I_EP_CP.php', '', '' );

		echo '<div id="'.$WPT_ID.'_EP_CP" style="position:relative; width:700px;">';

			  $CAL_NBR = 1;
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_CALENDAR.php'); 
			  
			  $IMG_NBR = 2;
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_IMAGE.php');

		echo '</div>';
		
		WriteToTraceLog(1, 'I', 'I_EP_CP.php', '', '' );	

?>
