<?php 
//================================================================================================
//
//  Incude:  		I_EDIT_TEXT.php                                                          
//  Description:	Display a text area with nicedit enabled		                         
//
//================================================================================================

		WriteToTraceLog(0, 'I', 'I_EDIT_TEXT.php', '', '' );

		$TextField='WPT_Text'.$COL_NBR;
		
 	  	//----------------------------------------------------------------------------------------	
        // Display text block
        //----------------------------------------------------------------------------------------	 

		echo '<div id="EPtext'.$COL_NBR.'" style="width:100%; border:thin solid #CCC; text-align:left; background-color:#FFF;" class="DIVNoFocus" onclick="SelectEditable('.$COL_NBR.',\'text\')">';
		  echo $Template[$TextField];
		echo '</div>';  	
	
		
		WriteToTraceLog(1, 'I', 'I_EDIT_TEXT.php', '', '' ); 

?>
