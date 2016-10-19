<?php 
//================================================================================================
//
//  Incude:  		I_EP_T2.php                                                          
//  Description:	Edit Page template T2 - Two columns of text			                         
//
//================================================================================================
		WriteToTraceLog(0, 'I', 'I_EP_T2.php', '', '' );
                                 
		echo '<div id="'.$WPT_ID.'_EP_T2" style="position:relative; width:700px;">';
		
			  $TEXT_NBR = 1;
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_TEXT.php'); 
			  
			  $TEXT_NBR = 2;
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_TEXT.php');

		echo '</div>';          		
          
          
		WriteToTraceLog(1, 'I', 'I_EP_T2.php', '', '' );	

?>
