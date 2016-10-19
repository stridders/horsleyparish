<?php 
//================================================================================================
//
//  Incude:  		I_EP.php                                                          
//  Description:	Edit Page editable template - renders all template objects (text, image, pdf, 
// 					etc) but only displays the objects required for the selected template type.
//
//================================================================================================
		WriteToTraceLog(0, 'I', 'I_EP.php', '', '' );

		echo '<div id="'.$WPT_ID.'_EP" style="position:relative; width:700px;">';

		  // Column 1		
		  $COL_NBR = 1;
		  $ColWidth = $Template['WPT_width'];
		  if ($WPT_Template == "P1" || $WPT_Template == "T1") {
			  $LeftPos = (675 - $ColWidth)/2;
		  } else {			  
			  $LeftPos = 0;
		  }
		
		  echo '<div id="TDcol1" class="EditRow" style="width:'.$ColWidth.'px; display:inline-block; position:absolute; left:'.$LeftPos.'px; top:0px">';		  
			echo '<div id="EDIT_P1" style="display:none">';	  
				include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_IMAGE.php'); 
			echo '</div>';
			echo '<div id="EDIT_T1" style="display:none">';
				include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_TEXT.php');
			echo '</div>';
//  		  echo '<div id="EDIT_C1" style="display:none">';
//  			  $CAL_NBR = 1;
//  			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_CALENDAR.php'); 
//  		  echo '</div>';
			echo '<div id="EDIT_A1" style="display:none">';
				include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_PDF.php'); 
			echo '</div>';
			echo '<div id="EDIT_AL" style="display:none">';
				include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_PDFLIST.php'); 
			echo '</div>';			
//  		   	echo '<div id="EDIT_B1" style="display:none">';	  
//  			  	include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_BCAL.php');
//  			echo '</div>';
		  echo "</div>";



		  // Column 2
		  $COL_NBR = 2;
		  if ($WPT_Template == "P1" || $WPT_Template == "T1") {
			  $ColWidth = 0;
			  $LeftPos = 700;
		  } else {
			  if ($WPT_Template == "AT") {
				  $ColWidth = (670 - $Template['WPT_width']);
				  $LeftPos = (390 - ($Template['WPT_width']/2));
			  } else {			  
				  $ColWidth = 675 - $Template['WPT_width'];
				  $LeftPos = $Template['WPT_width'] + 25;
			  }  
		  }

		  echo '<div id="TDcol2" class="EditRow" style="width:'.$ColWidth.'px; display:inline-block; position:absolute; left:'.$LeftPos.'px; top:0px;">';
			echo '<div id="EDIT_P2" style="display:none">';	  
				include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_IMAGE.php'); 
			echo '</div>';
			echo '<div id="EDIT_T2" style="display:none">';
				include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_TEXT.php');
			echo '</div>';
			echo '<div id="EDIT_A2" style="display:none">';
				include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_'.$MODE.'_PDF.php'); 
			echo '</div>';
		  echo "</div>";

		echo '</div>';
		
		WriteToTraceLog(1, 'I', 'I_EP.php', '', '' );	


?>
