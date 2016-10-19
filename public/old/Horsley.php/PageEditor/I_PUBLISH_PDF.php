<?php 
//================================================================================================
//
//  Incude:  		I_PUBLISH_PDF.php                                                          
//  Description:	Upload a PDF file		                         
//
//================================================================================================

		WriteToTraceLog(0, 'I', 'I_PUBLISH_PDF.php', '', '' );
	
		$SaveFilename = $Template['WPT_ID'].'.pdf';
		$root_path = '/PAGES/'.$WP_Group.'/pdf/';									// root path to image file directory 		
		$upload_path = $_SERVER['DOCUMENT_ROOT'].$root_path; 					// Upload location				
		$FullFileName = $upload_path . $SaveFilename;
		
		$LeftPos = ($Template['WPT_width'] - 60)/2;
		
		$stringData = '<div title="PDF Document" style="width:50px; height:50px; display:inline-block; position:absolute; left:'.$LeftPos.'px; top:0px;">';           
		fwrite($fh, $stringData."\n");
		
		if (file_exists($FullFileName)) {
			$stringData = '<a href="'.$root_path.$SaveFilename.'" ><img src="/images/PDF_icon.png" style="border:0px;" width="50px;" height="50px;"></a>';				
		} else {
			$stringData = '<img title=\'PDF file is missing.\' src="/images/PDF_nofile_icon.png" width="50px;" height="50px;">';	
		}	
			
		fwrite($fh, $stringData."\n");
		
		$stringData = '</div>';
		fwrite($fh, $stringData."\n");

		WriteToTraceLog(1, 'I', 'I_PUBLISH_PDF.php', '', '' ); 

?>
