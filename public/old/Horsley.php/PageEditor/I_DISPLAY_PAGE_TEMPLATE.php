<?php
//================================================================================================
//
//  Incude:  		I_DISPLAY_PAGE_TEMPLATE.php                                                          
//  Description:	Displays a page template in edit mode
//
//================================================================================================

		WriteToTraceLog(0, 'P', 'I_DISPLAY_PAGE_TEMPLATE.php', '', '' );		

		//----------------------------------------------------------------------------------------
		// Set Control Variables
		//----------------------------------------------------------------------------------------
		
		$WPT_Template = $Template['WPT_Template'];
		$WPT_ID = $Template['WPT_ID'];
		$WPT_PageID = $Template['WPT_PageID'];

?>
 
<!-- 
		//----------------------------------------------------------------------------------------------------
		// Display template format options
		//----------------------------------------------------------------------------------------------------
-->        
          <table width="700px">
            <tr>
              <td valign="top" height="<?php echo $Template['WPT_height'];?>px">
<?php 
					$MODE="DISPLAY";
					include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/Templates/I_EP_'.$WPT_Template.'.php'); 
?>                            
              </td>                           
            </tr>                     
          
          </table> 


<?php	

        WriteToTraceLog(1, 'P', 'I_DISPLAY_PAGE_TEMPLATE.php', '', '' );
?>