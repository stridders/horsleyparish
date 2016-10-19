<?php 
//================================================================================================
//
//  Incude:  		I_EP_T1.php                                                          
//  Description:	Edit Page template T1 - One column of text			                         
//
//================================================================================================
		WriteToTraceLog(0, 'I', 'I_EP_T1.php', '', '' );

		echo '<div id="'.$WPT_ID.'_EP_T1" style="position:relative; width:700px;">';

			  $TEXT_NBR = 1;
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_TEXT.php');

		echo '</div>';
		
		WriteToTraceLog(1, 'I', 'I_EP_T1.php', '', '' );	


?>
