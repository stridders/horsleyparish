<?php 
//================================================================================================
//
//  Incude:  		I_EDIT_IMAGE.php                                                          
//  Description:	Upload an image file		                         
//
//================================================================================================

		WriteToTraceLog(0, 'I', 'I_EDIT_IMAGE.php', '', '' );

		$SaveFilename = $WPT_ID.'_'.$COL_NBR . '.jpg';	
		$root_path = '/PAGES/'.$WP_Group.'/images/';							// root path to image file directory 
		$upload_path = $_SERVER['DOCUMENT_ROOT'].$root_path; 					// Upload location	
		$FullFileName = $upload_path . $SaveFilename;
		if (file_exists($FullFileName)) {
			list($width, $height) = getimagesize($FullFileName);
			$x = $height/$width;
		} else {
			$SaveFilename="default.png";
			$root_path ="/PageEditor/images/";
			$x=(180/270);
		}
		$ImgHeight = $ColWidth * $x;	
		$cachekiller = date('His');
		
?>	
		<div style="position:absolute; margin-bottom:-50px;">
          <form method="post" name="UploadImageForm" enctype="multipart/form-data">
            <input type="file" name="userfile" id="JPG<?php echo $COL_NBR;?>" style="display:none" onchange="$('#MM_Save_IMAGE<?php echo $COL_NBR;?>').trigger('click');"/>
            <input name="FileType" type="hidden" value="jpg" />
            <input name="ITEM_NBR" id="IMG_NBR" type="hidden" value="<?php echo $COL_NBR;?>" />
            <button name="MM_Save_IMAGE" id="MM_Save_IMAGE<?php echo $COL_NBR;?>" type="submit" value="saved" style="opacity:0"></button>                   
            <input name="WPT_ID" id="WPT_ID" type="hidden" value="<?php echo $WPT_ID;?>" />
          </form>
        </div>        
<?php		

 	  	//----------------------------------------------------------------------------------------	
        // Display image
        //----------------------------------------------------------------------------------------	
 
		echo '<a onclick="SelectEditable('.$COL_NBR.',\'image\')"  ondblclick="$(\'#JPG'. $COL_NBR . '\').trigger(\'click\');" title="Double-click to upload new image">';
		
		echo '<img id="EPimage'.$COL_NBR.'" src="' . $root_path . $SaveFilename . '?' . $cachekiller . '" width="'.$ColWidth.'px;" height="'.$ImgHeight.'px;" class="DIVNoFocus" title="Double-click to upload new image">';
			
		echo '</a>';		
		
		WriteToTraceLog(1, 'I', 'I_EDIT_IMAGE.php', $FullFileName, '' ); 

?>

