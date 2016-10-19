<?php 
//================================================================================================
//
//  Incude:  		I_EP_AL.php                                                          
//  Description:	Edit Page template AL - Adobe PDF file listbox			                         
//
//================================================================================================
		WriteToTraceLog(0, 'I', 'I_EP_AL.php', '', '' );

		echo '<div id="'.$WPT_ID.'_EP_AL" style="position:relative; width:700px;">';

			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_PDFLIST.php'); 

		echo '</div>';
		
		WriteToTraceLog(1, 'I', 'I_EP_AL.php', '', '' );	

?>
