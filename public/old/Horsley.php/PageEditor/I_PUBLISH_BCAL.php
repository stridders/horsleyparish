<?php 
//================================================================================================
//
//  Incude:  		I_PUBLISH_BCAL.php                                                          
//  Description:	Include a venue booking calendar		                         
//
//================================================================================================

		WriteToTraceLog(0, 'I', 'I_PUBLISH_BCAL.php', '', '' );

		$stringData = '<?php $Venue = \'' . $Template['WPT_Text1'].'\'; ?>';           
		fwrite($fh, $stringData."\n");
		
		$stringData = '<?php include($_SERVER[\'DOCUMENT_ROOT\'].\'/I_Booking.php\'); ?>';           
		fwrite($fh, $stringData."\n");
		
		WriteToTraceLog(1, 'I', 'I_PUBLISH_BCAL.php', '', '' ); 

?>
