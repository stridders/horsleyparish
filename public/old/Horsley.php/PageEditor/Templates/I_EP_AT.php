<?php 
//================================================================================================
//
//  Incude:  		I_EP_AT.php                                                          
//  Description:	Edit Page template AT - Adobe PDF file icon with text descritpion on right			                         
//
//================================================================================================
		WriteToTraceLog(0, 'I', 'I_EP_AT.php', '', '' );

		echo '<div id="'.$WPT_ID.'_EP_AT" style="position:relative; width:700px;">';

			  $PDF_NBR = 1;
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_PDF.php'); 
			  
			  $TEXT_NBR = 2;
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_TEXT.php');

		echo '</div>';
		
		WriteToTraceLog(1, 'I', 'I_EP_AT.php', '', '' );	

?>
