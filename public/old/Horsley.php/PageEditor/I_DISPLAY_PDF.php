<?php 
//================================================================================================
//
//  Incude:  		I_DISPLAY_PDF.php                                                          
//  Description:	Upload a PDF file		                         
//
//================================================================================================

		WriteToTraceLog(0, 'I', 'I_DISPLAY_PDF.php', '', '' );
		
		$SaveFilename = $WPT_ID.'.pdf';
		$root_path = '/PAGES/'.$WP_Group.'/pdf/';									// root path to image file directory 		
		$upload_path = $_SERVER['DOCUMENT_ROOT'].$root_path; 					    // Upload location				
		$FullFileName = $upload_path . $SaveFilename;
		
		$LeftPos = ($Template['WPT_width'] - 60)/2;

		echo '<div title="Click to edit"  style="width:50px; height:50px; display:inline-block; position:absolute; left:'.$LeftPos.'px; top:0px;">';            
		  	if (file_exists($FullFileName)) {
				echo '<img id="EPpdf'.$WPT_ID.'" onclick="'.$FullFileName.'" title="Click to edit" src="/images/PDF_icon.png" width="50px;" height="50px;" class="DIVNoFocus" >';				
			} else {
				echo '<img id="EPpdf'.$WPT_ID.'" src="/images/PDF_nofile_icon.png" width="50px;" height="50px;" class="DIVNoFocus" >';	
			}				
				
		echo '</div>';

		WriteToTraceLog(1, 'I', 'I_DISPLAY_PDF.php', '', '' ); 

?>
