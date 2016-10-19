<?php 
//================================================================================================
//
//  Incude:  		I_EDIT_PDFLIST.php                                                          
//  Description:	Upload a PDF file		                         
//
//================================================================================================

		WriteToTraceLog(0, 'I', 'I_EDIT_PDFLIST.php', '', '' );

		$root_path = '/PAGES/'.$WP_Group.'/pdf/';								// root path to image file directory 				
		
		$LBWidth = $Template['WPT_width'];
		
		include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/I_UPLOAD_LIST_ITEM.php');
		
		//----------------------------------------------------------------------------------------------
		// Get Page Template entries from DB
		//---------------------------------------------------------------------------------------------- 			  
		$sql = "SELECT * FROM file_list WHERE FL_SiteID=".$_SESSION['SiteID']." AND FL_WPT_ID=".$WPT_ID." ORDER BY FL_FileID DESC" ;
		WriteToTraceLog(3, 'P', 'I_EDIT_PDFLIST.php', 'Get PDF List', $sql );	
		$PDFlist = mysqli_query($HDBi, $sql);

		if ( mysqli_error($HDBi) ) {
			WriteToErrorLog('ERRC000002', 'Error while getting PDF list from database', 'I_EDIT_PDFLIST.php', mysqli_error($HDBi) );
		}	
		If ($msg <> "") {
			echo '<font color="#FF0000">'. $msg . '</font><br />';
		}
?>
          <form method="post" name="UploadPDFForm<?php echo $WPT_ID;?>" enctype="multipart/form-data">
          <table>
            <tr>
              <td>
                    <select name="EPpdflist" id="EPpdflist" size="5" style="width:<?php echo $LBWidth;?>px; font-size:16px;">
<?PHP
                      while ($Filename = mysqli_fetch_assoc($PDFlist)) {
                        $FullFileName = $root_path . $WPT_ID . '.' . $Filename['FL_FileID'] . '.pdf';
                        echo '<option value="'. $Filename['FL_FileID'] .'" ondblclick="OpenURL(\''. $FullFileName .'\')">'.$Filename['FL_FileName'].'</option>';	
                      }
?>
                    </select>                    
              </td>
              <td>
                    <input type="file" name="userfile" id="PDFList<?php echo $WPT_ID;?>" style="display:none" onchange="$('#MM_Save_to_list<?php echo $WPT_ID;?>').trigger('click');"/>
                    <button name="button" type="button" style="width:85px; position:relative; top:-10px;" onclick="$('#PDFList<?php echo $WPT_ID;?>').trigger('click');"> Add File </button>
                    <button name="MM_Save_to_list" id="MM_Save_to_list<?php echo $WPT_ID;?>" type="submit" style="opacity:0"></button><br />
                    <button name="MM_Delete_PDF_from_list" type="submit" value="Delete" style="width:85px"> Delete File </button>  
                    <input name="WPT_ID" id="WPT_ID" type="hidden" value="<?php echo $WPT_ID;?>" />
              </td>
            </tr>
          </table>
          </form>        
<?php		
		WriteToTraceLog(1, 'I', 'I_EDIT_PDFLIST.php', '', '' ); 
?>
