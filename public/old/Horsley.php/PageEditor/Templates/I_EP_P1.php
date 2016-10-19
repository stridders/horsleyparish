<?php 
//================================================================================================
//
//  Incude:  		I_EP_P1.php                                                          
//  Description:	Edit Page template P1 - One single image			                         
//
//================================================================================================
		WriteToTraceLog(0, 'I', 'I_EP_P1.php', '', '' );

		echo '<div id="'.$WPT_ID.'_EP_P1" style="position:relative; width:700px;">';

			  $IMG_NBR = 1;
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_IMAGE.php'); 

		echo '</div>';
            

		WriteToTraceLog(1, 'I', 'I_EP_P1.php', '', '' );	

?>
