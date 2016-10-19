<?php 
//================================================================================================
//
//  Incude:  		I_DISPLAY_BCAL.php                                                          
//  Description:	Display a venue Booking calendar		                         
//
//================================================================================================

		WriteToTraceLog(0, 'I', 'I_DISPLAY_BCAL.php', '', '' );

 	  	//----------------------------------------------------------------------------------------	
        // Display default image if no photo uploaded, else display photo
        //----------------------------------------------------------------------------------------	

		echo '<div style="position:relative;" onclick="Submit_form(\'Template_Form\');" title="BCAL">';  
		
			  include($_SERVER['DOCUMENT_ROOT'].'/I_Booking.php');	
			  
			  // Place a div block over the booking form/calendar, so that their features are disabled
			  echo '<div style="position:absolute; top:0px; left:0px; width:700px; height:600px; opacity:0.1; background-color:#FFF; display:block;"></div>';
	
		echo '</div>';
		
		WriteToTraceLog(1, 'I', 'I_DISPLAY_BCAL.php', '', '' ); 

?>
