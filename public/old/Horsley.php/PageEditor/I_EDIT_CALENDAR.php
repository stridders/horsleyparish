<?php 
//================================================================================================
//
//  Incude:  		I_EDIT_CALENDAR.php                                                          
//  Description:	Display a venue Booking calendar                
//
//================================================================================================

		WriteToTraceLog(0, 'I', 'I_DISPLAY_CALENDAR.php', '', '' );

 	  	//----------------------------------------------------------------------------------------	
        // Display default image if no photo uploaded, else display photo
        //----------------------------------------------------------------------------------------	

		echo '<div style="position:absolute; top:0px; left:0px;" title="CALENDAR">';  
		
			  include($_SERVER['DOCUMENT_ROOT'].'/I_Booking_Calendar.php');	
			  
			  // Place a div block over the booking form/calendar, so that their features are disabled
			  echo '<div style="position:absolute; top:0px; left:0px; width:420px; height:600px; opacity:0.1; background-color:#FFF; display:block;"></div>';
	
		echo '</div>';
		
		WriteToTraceLog(1, 'I', 'I_DISPLAY_CALENDAR.php', '', '' ); 

?>
