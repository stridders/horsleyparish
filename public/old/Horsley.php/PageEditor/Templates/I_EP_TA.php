<?php 
//================================================================================================
//
//  Incude:  		I_EP_TA.php                                                          
//  Description:	Edit Page template TA - Adobe PDF file icon with text descritpion on left			                         
//
//================================================================================================
		WriteToTraceLog(0, 'I', 'I_EP_TA.php', '', '' );

		echo '<div id="'.$WPT_ID.'_EP_TA" style="position:relative; width:700px;">';
		
			  $TEXT_NBR = 1;
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_TEXT.php');
			  
			  $PDF_NBR = 2;
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_PDF.php'); 
			  
		echo '</div>';
		
		WriteToTraceLog(1, 'I', 'I_EP_TA.php', '', '' );	


?>
