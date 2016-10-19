<?php 
//================================================================================================
//
//  Incude:  		I_PUBLISH_CALENDAR.php                                                          
//  Description:	Include a venue booking calendar		                         
//
//================================================================================================

		WriteToTraceLog(0, 'I', 'I_PUBLISH_CALENDAR.php', '', '' );

		$stringData = '<?php $Venue = \'' . $Template['WPT_Text1'].'\'; ?>';           
		fwrite($fh, $stringData."\n");
		
		$stringData = '<div style="width:420px; height:100%; display:inline-block; position:absolute; left:0px; top:0px;">'; 
		fwrite($fh, $stringData."\n");
		
		$stringData = '<?php include($_SERVER[\'DOCUMENT_ROOT\'].\'/I_Booking_Calendar.php\'); ?>';           
		fwrite($fh, $stringData."\n");
		
		$stringData = '</div>';
		fwrite($fh, $stringData."\n");
		
		WriteToTraceLog(1, 'I', 'I_PUBLISH_CALENDAR.php', '', '' ); 

?>
