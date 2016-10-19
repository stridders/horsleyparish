<?php 
//================================================================================================
//
//  Incude:  		I_EP_TP.php                                                          
//  Description:	Edit Page template TP - Text in the left column and Image in the right			                         
//
//================================================================================================
		WriteToTraceLog(0, 'I', 'I_EP_TP.php', '', '' );

		echo '<div id="'.$WPT_ID.'_EP_TP" style="position:relative; width:700px;">';
		
			  $TEXT_NBR = 1;
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_TEXT.php');
			  
			  $IMG_NBR = 2;
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_IMAGE.php'); 

		echo '</div>';
		
		WriteToTraceLog(1, 'I', 'I_EP_TP.php', '', '' );	


?>
