<?php 
//================================================================================================
//
//  Incude:  		I_EP_CT.php                                                          
//  Description:	Edit Page template CT - Booking Calendar with text on right			                         
//
//================================================================================================
		WriteToTraceLog(0, 'I', 'I_EP_CT.php', '', '' );

		echo '<div id="'.$WPT_ID.'_EP_CT" style="position:relative; width:700px;">';

			  $CAL_NBR = 1;
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_CALENDAR.php'); 
			  
			  $TEXT_NBR = 2;
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_TEXT.php');

		echo '</div>';
		
		WriteToTraceLog(1, 'I', 'I_EP_CT.php', '', '' );	

?>
