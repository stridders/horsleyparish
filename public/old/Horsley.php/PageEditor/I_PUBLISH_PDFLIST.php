<?php 
//================================================================================================
//
//  Incude:  		I_PUBLISH_PDFLIST.php                                                          
//  Description:	Displays a lisbox of PDF links		                         
//
//================================================================================================

		WriteToTraceLog(0, 'I', 'I_PUBLISH_PDFLIST.php', '', '' );
	
		$root_path = '/PAGES/'.$WP_Group.'/pdf/';									// root path to image file directory 		
		$upload_path = $_SERVER['DOCUMENT_ROOT'].$root_path; 					// Upload location				
		$FullFileName = $upload_path . $SaveFilename;
		
		$LBWidth = $Template['WPT_width'];
		$LeftPos = (700 - $Template['WPT_width'])/2;

		$WPT_ID = $Template['WPT_ID'];
		
		//----------------------------------------------------------------------------------------------
		// Get Page Template entries from DB
		//---------------------------------------------------------------------------------------------- 			  
		$sql = "SELECT * FROM file_list WHERE FL_SiteID=".$_SESSION['SiteID']." AND FL_WPT_ID=".$WPT_ID." ORDER BY FL_FileID DESC" ;
		WriteToTraceLog(3, 'P', 'I_EDIT_PDFLIST.php', 'Get PDF List', $sql );	
		$PDFlist = mysqli_query($HDBi, $sql);

		if ( mysqli_error($HDBi) ) {
			WriteToErrorLog('ERRC000002', 'Error while getting PDF list from database', 'I_EDIT_PDFLIST.php', mysqli_error($HDBi) );
		}	

		$stringData = '<div style="width:'.$LBWidth.'px; height:100px; display:inline-block; position:absolute; left:'.$LeftPos.'px; top:0px;">';
		fwrite($fh, $stringData."\n");
		
		$stringData = '<select name="EPpdflist" id="EPpdflist" size="5" style="width:' . $LBWidth . 'px; font-size:16px;">';
		fwrite($fh, $stringData."\n");
		
		while ($Filename = mysqli_fetch_assoc($PDFlist)) {
			$FullFileName = $root_path . $WPT_ID . '.' . $Filename['FL_FileID'] . '.pdf';
			$stringData = '<option value="'. $Filename['FL_FileID'] .'" ondblclick="OpenURL(\''. $FullFileName .'\')">'.$Filename['FL_FileName'].'</option>';	
			fwrite($fh, $stringData."\n");
		}
		
		$stringData =  '</select>';
		fwrite($fh, $stringData."\n");
		
		$stringData = '</div>';
		fwrite($fh, $stringData."\n");

		WriteToTraceLog(1, 'I', 'I_PUBLISH_PDFLIST.php', '', '' ); 

?>
