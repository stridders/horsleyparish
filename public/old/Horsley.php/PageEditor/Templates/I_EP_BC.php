<?php 
//================================================================================================
//
//  Incude:  		I_EP_BC.php                                                          
//  Description:	Edit Page template BC - Includes a venue booking form 			                         
//
//================================================================================================
		WriteToTraceLog(0, 'I', 'I_EP_BC.php', '', '' );

		echo '<div id="'.$WPT_ID.'_EP_BC" style="position:relative; width:700px;">';
		
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_BCAL.php');

		echo '</div>';
		
		WriteToTraceLog(1, 'I', 'I_EP_BC.php', '', '' );	


?>
