<?php 
//================================================================================================
//
//  Incude:  		I_EDIT_PDF.php                                                          
//  Description:	Upload a PDF file		                         
//
//================================================================================================

		WriteToTraceLog(0, 'I', 'I_EDIT_PDF.php', '', '' );

		$SaveFilename = $WPT_ID.'.pdf';	
		$root_path = '/PAGES/'.$WP_Group.'/pdf/';								// root path to image file directory 		
		$upload_path = $_SERVER['DOCUMENT_ROOT'].$root_path; 					// Upload location			
		$FullFileName = $upload_path . $SaveFilename;

?>	
		<div style="position:absolute; margin-bottom:-50px;">
          <form method="post" name="UploadPDFForm<?php echo $WPT_ID;?>" id="UploadPDFForm<?php echo $WPT_ID;?>" enctype="multipart/form-data">
            <input type="file" name="userfile" id="PDF<?php echo $COL_NBR;?>" style="display:none" onchange="$('#MM_Save_PDF<?php echo $COL_NBR;?>').trigger('click');"/>
            <input name="FileType" type="hidden" value="pdf" />
            <input name="ITEM_NBR" id="PDF_NBR" type="hidden" value="<?php echo $COL_NBR;?>" />
            <button name="MM_Save_PDF" id="MM_Save_PDF<?php echo $COL_NBR;?>" type="submit" value="saved" style="opacity:0"></button>      
            <input name="WPT_ID" id="WPT_ID" type="hidden" value="<?php echo $WPT_ID;?>" />
          </form>
        </div>        
<?php		
		echo '<a title="Double-click to upload PDF file" onclick="SelectEditable('.$COL_NBR.',\'pdf\')" ondblclick="$(\'#PDF'. $COL_NBR . '\').trigger(\'click\');" >';
		
		if (file_exists($FullFileName)) {
			echo '<img id="EPpdf'.$WPT_ID.'" src="/images/PDF_icon.png" width="50px" height="50px" class="DIVNoFocus">';				
		} else {
			echo '<img id="EPpdf'.$WPT_ID.'" src="/images/PDF_nofile_icon.png" width="50px;" height="50px;" class="DIVNoFocus">';	
		}
		echo '</a>';
		
		WriteToTraceLog(1, 'I', 'I_EDIT_PDF.php', '', '' ); 

?>
