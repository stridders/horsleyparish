<?php 
//================================================================================================
//
//  Incude:  		I_EP_PT.php                                                          
//  Description:	Edit Page template PT - Image in left column, text in right			                         
//
//================================================================================================
		WriteToTraceLog(0, 'I', 'I_EP_PT.php', '', '' );

		echo '<div id="'.$WPT_ID.'_EP_PT" style="position:relative; width:700px;">';
		
			  $IMG_NBR = 1;
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_IMAGE.php'); 
			  
			  $TEXT_NBR = 2;
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_TEXT.php');

		echo '</div>';
		
		WriteToTraceLog(1, 'I', 'I_EP_PT.php', '', '' );	


?>
