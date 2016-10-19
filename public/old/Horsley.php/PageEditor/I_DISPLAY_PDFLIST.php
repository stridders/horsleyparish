<?php 
//================================================================================================
//
//  Incude:  		I_DISPLAY_PDFLIST.php                                                          
//  Description:	Upload a PDF file		                         
//
//================================================================================================

		WriteToTraceLog(0, 'I', 'I_DISPLAY_PDFLIST.php', '', '' );	
		
		$LBWidth = $Template['WPT_width'];
		$LeftPos = (700 - $Template['WPT_width'])/2;
				
		//----------------------------------------------------------------------------------------------
		// Get Page Template entries from DB
		//---------------------------------------------------------------------------------------------- 			  
		$sql = "SELECT * FROM file_list WHERE FL_SiteID=".$_SESSION['SiteID']." AND FL_WPT_ID=".$WPT_ID." ORDER BY FL_FileID DESC";
		WriteToTraceLog(3, 'P', 'I_DISPLAY_PDFLIST.php', 'Get PDF List', $sql );	
		$PDFlist = mysqli_query($HDBi, $sql);

		if ( mysqli_error($HDBi) ) {
			WriteToErrorLog('ERRC000002', 'Error while getting PDF list from database', 'I_DISPLAY_PDFLIST.php', mysqli_error($HDBi) );
		}	
?>	
		<div style="position:absolute; margin-bottom:-50px;"> 
            <select name="PDF_List" size="5" style="position:relative; width:<?php echo $LBWidth;?>px; left:<?php echo $LeftPos;?>px; font-size:16px;">
<?PHP
			  while ($Filename = mysqli_fetch_assoc($PDFlist)) {
				  $FullFileName = $root_path . $WPT_ID . '.' . $Filename['FL_FileID'] . '.pdf';
				  echo '<option value="'. $Filename['FL_FileID'] .'" ondblclick="OpenURL(\''. $FullFileName .'\')">'.$Filename['FL_FileName'].'</option>';				
			  }
?>
            </select>
        </div>        
<?php		
		WriteToTraceLog(1, 'I', 'I_DISPLAY_PDFLIST.php', '', '' ); 
?>
