<?php 
//================================================================================================
//
//  Incude:  		I_EP_P2.php                                                          
//  Description:	Edit Page template PT - Two pictures, side-by-side			                         
//
//================================================================================================
		WriteToTraceLog(0, 'I', 'I_EP_P2.php', '', '' );

		echo '<div id="'.$WPT_ID.'_EP_P2" style="position:relative; width:700px; height:100%;">';
		
			  $IMG_NBR = 1;
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_IMAGE.php'); 
			  
			  $IMG_NBR = 2;
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_IMAGE.php'); 
                
		echo '</div>';
		
		WriteToTraceLog(1, 'I', 'I_EP_P2.php', '', '' );	


?>
