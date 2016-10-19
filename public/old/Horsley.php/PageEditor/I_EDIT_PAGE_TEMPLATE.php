<?php
//================================================================================================
//
//  Incude:  		I_EDIT_PAGE_TEMPLATE.php                                                          
//  Description:	Displays a page template in edit mode
//
//================================================================================================

		WriteToTraceLog(0, 'P', 'I_EDIT_PAGE_TEMPLATE.php', '', '' );		

		//----------------------------------------------------------------------------------------
		// Set Control Variables
		//----------------------------------------------------------------------------------------
		$cachekiller = time();
		
		$WPT_Template = $Template['WPT_Template'];
		$WPT_ID = $Template['WPT_ID'];
		$WPT_PageID = $Template['WPT_PageID'];
		$IMG_NBR = 1;
		$OrigText1 = "";
		$OrigText2 = "";
?>

<!-- 
		//----------------------------------------------------------------------------------------------------
		// Javascript to instantiate niceditors (in-line rich text editor) to replace textarea inputs
        // Display the niceditor panel at the top of the page so that it can be shared by all editors.
		//----------------------------------------------------------------------------------------------------
-->
		<script language="javascript">
		
			  bkLib.onDomLoaded(function() { 
				  var myNicEditor = new nicEditor({buttonList : ['fontSize', 'fontFamily','fontFormat','bold','italic','underline','left','center','right','justify','strikeThrough','subscript','superscript','hr','forecolor','bgcolor','link','unlink']}).panelInstance('myNicPanel');
				   
				  myNicEditor.addEvent("blur", function () {
						if ($OrigText1 != document.getElementById('EPtext1').innerHTML || $OrigText2 != document.getElementById('EPtext2').innerHTML) {
							document.getElementById('WPT_Text1').value = document.getElementById('EPtext1').innerHTML;
							document.getElementById('WPT_Text2').value = document.getElementById('EPtext2').innerHTML;
							ResizeColumns(0);
							AJAX_save_changes();
						}
					});
				  myNicEditor.addEvent("focus", function () {
						$OrigText1 = document.getElementById('EPtext1').innerHTML;
						$OrigText2 = document.getElementById('EPtext2').innerHTML;
					});
				  myNicEditor.addInstance('EPtext1');
				  myNicEditor.addInstance('EPtext2');				  
			  });
			 
		</script>
 
<!-- 
		//----------------------------------------------------------------------------------------------------
		// Display template format options
		//----------------------------------------------------------------------------------------------------
-->        
          <table width="700px">
            <tr>
              <td valign="middle" align="left" width="130px" bgcolor="#EFEFEF">
                    <font size="2" color="#666666">
                    <?php echo "&nbsp; (P/".$WP_ID."  R/".$WPT_ID;?><span id="HDR_TT"><?php echo "  ".$WPT_Template.") ";?></span> 
                    </font> 
              </td>
              <td valign="top" align="left" width="570px" >
<?php
				if ($WPT_Template == 'BC' or $WPT_Template == 'CP' or $WPT_Template == 'CT') { 
					  //----------------------------------------------------------------------------------------------
					  // Get bookable location details from database
					  //---------------------------------------------------------------------------------------------- 			  
					  $sql = "SELECT * FROM bookable_locations";
					  WriteToTraceLog(3, 'P', 'I_EDIT_BCAL.php', 'Get bookable_locations from DB', $sql );	
					  $Locns = mysqli_query($HDBi, $sql);							
					  if ( mysqli_error($HDBi) ) {
						  WriteToErrorLog('ERRC000002', 'Error while getting bookable location details from database', 'I_EDIT_PAGE_TEMPLATE.php', mysqli_error($HDBi) );
					  }

					  echo '<form name="BookingLocations">';
						
							echo '<span>&nbsp;&nbsp;<select name="BL_Venues" size="3" multiple onchange="BL_Changed(this)">';
							while  ($Location = mysqli_fetch_assoc($Locns) ) {
								  echo '<option value="'.$Location['BL_Locn'].'"';
								  if (strstr($Template['WPT_Text1'],$Location['BL_Locn'])) {
									  echo " selected=selected";
								  }
								  echo '>'.$Location['BL_Name'].'</option>';
							}
							echo '</select></span>';
							echo '<span style="position:relative; top:-15px;"><font color="#666666" size="2">&nbsp;&nbsp;&nbsp;Add new venue: </font></span>';
							echo '<span style="position:relative; top:-15px;"><input name="BL_NewVenue" type="text" size="25" maxlength="50"/></span>';						
					  echo '</form>';

					  mysqli_free_result($Locns);
				}
				  			
?>
                <div id="myNicPanel" class="myNicPanel"></div>
			  </td>
            </tr>
            <tr>
              <td colspan="2" bgcolor="#666666" width="100%" align="left" valign="top">
                    <table width="100%">
                      <tr>
                        <td width="40px">
                        	<div id="flash"></div>
                        </td>
                        <td style="padding:2px 2px 2px 2px;" align="center" valign="top">
                              <a class="Save" title="Save Changes" onclick="ResizeColumns(0); AJAX_save_changes();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;  
                              <a class="InsertAbove" title="Insert above" onclick="SetTextBox('TemplateUpdated','INSERT_ROW_A'); Submit_form('Template_Form');">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;
                              <a class="InsertBelow" title="Insert below" onclick="SetTextBox('TemplateUpdated','INSERT_ROW_B'); Submit_form('Template_Form');">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;
                              <a class="WasteBinG" title="Delete this row in the page" onclick="SetTextBox('TemplateUpdated','DELETE_ROW'); Submit_form('Template_Form');">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                              <a class="EditPageMenuText" title="Review page" onclick="Submit_form('Template_Form'); window.location.href='/PageEditor/edit_page.php?p=<?php echo $WP_Group;?>&WP_ID=<?php echo $_GET['WP_ID'];?>'" >Review</a>                    
					    </td>
                        <td style="padding:2px 2px 12px 2px;" align="center" valign="top">
                                  <input name="ColSize" id="ColSize" type="hidden" value="<?php echo $Template['WPT_width'];?>"/>
                                  <p id="SlideImgSize" style="position:relative; top:4px; width:140px; display:inline-block;"></p>						
                        </td> 
                        <td width="170px" align="middle">
                        	<div style="height:18px;" onmouseover="DisplayObject('TemplateOptions');" onmouseout="HideObject('TemplateOptions');"><a class="EditPageMenuText">Change Layout</a>
                                <table width="100%" bgcolor="#666666" id="TemplateOptions" style="display:none; position:relative; z-index:11">         
                                  <tr>
                                      <td>
                                         <a class="TemplateImage" onclick="ChangeTemplate('P1')"><img src="/PageEditor/images/P1.jpg" width="50" height="27" title="Single image (up to whole page width)" <?php if ($WPT_Template == 'P1') echo 'border="2px"';?> ></a>
                                      </td>
                                      <td>
                                        <a class="TemplateImage" onclick="ChangeTemplate('T2')"><img src="/PageEditor/images/T2.jpg" width="50" height="27" title="Two separate columns of text" <?php if ($WPT_Template == 'T2') echo 'border="2px"';?>></a>
                                      </td>
                                      <td>
                                        <a class="TemplateImage" onclick="ChangeTemplate('P2')"><img src="/PageEditor/images/P2.jpg" width="50" height="27" title="Two images, side-by-side" <?php if ($WPT_Template == 'P2') echo 'border="2px"';?>></a>
                                      </td>
                                  </tr>
                                  <tr>                                
                                      <td>
                                        <a class="TemplateImage" onclick="ChangeTemplate('PT')"><img src="/PageEditor/images/PT.jpg" width="50" height="27" title="An image on the left and text on the right" <?php if ($WPT_Template == 'PT') echo 'border="2px"';?> ></a>
                                      </td>                   
                                      <td>
                                        <a class="TemplateImage" onclick="ChangeTemplate('T1')"><img src="/PageEditor/images/T1.jpg" width="50" height="27" title="Text only" <?php if ($WPT_Template == 'T1') echo 'border="2px"';?> ></a>
                                      </td>
                                      <td>
                                        <a class="TemplateImage" onclick="ChangeTemplate('TP')"><img src="/PageEditor/images/TP.jpg" width="50" height="27" title="Text on the left and an image on the right" <?php if ($WPT_Template == 'TP') echo 'border="2px"';?> ></a>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td>
                                        <a class="TemplateImage" onclick="ChangeTemplate('AT')"><img src="/PageEditor/images/AT.jpg" width="50" height="27" title="PDF attachment with description on right-hand side" <?php if ($WPT_Template == 'AT') echo 'border="2px"';?> ></a>
                                      </td>
                                      <td>
                                        <a class="TemplateImage" onclick="ChangeTemplate('AL')"><img src="/PageEditor/images/AL.jpg" width="50" height="27" title="PDF Listbox (e.g. for magazine issues)" <?php if ($WPT_Template == 'AL') echo 'border="2px"';?> ></a>
                                      </td>
                                      <td><td>
                                  </tr>
        <?php 					  if  ( InGroup('webadmin') ) {  ?>  
                                  <tr>
                                      <td>
                                        <a class="TemplateImage" onclick="ChangeTemplate('CT')"><img src="/PageEditor/images/CT.jpg" width="50" height="27" title="Booking Calendar with text on the right-hand side" <?php if ($WPT_Template == 'CT') echo 'border="2px"';?> ></a>
                                      </td>
                                      <td>
                                        <a class="TemplateImage" onclick="ChangeTemplate('CP')"><img src="/PageEditor/images/CP.jpg" width="50" height="27" title="Booking Calendar with a picture on the right-hand side" <?php if ($WPT_Template == 'TA') echo 'border="2px"';?> ></a>
                                      </td>
                                      <td>
                                        <a class="TemplateImage" onclick="ChangeTemplate('BC')"><img src="/PageEditor/images/BC.jpg" width="50" height="27" title="Include a venue booking form" <?php if ($WPT_Template == 'BC') echo 'border="2px"';?> ></a>
                                      </td>
                                  </tr>                          
        <?php 					  } ?>
                                </table> 
                            </div>               
                        </td>                                                             
                      </tr>
                    </table>
                    <div id="EPIstats1">replaced</div>
                    <div id="EPIstats2">replaced</div>
              </td>
            </tr>  
            <tr>
              <td colspan="2" bgcolor="#FFFFFF">
<?php 
				  echo '<p style="width:700px; text-align:center; color:red;">'. $msg . '</p>';
?>
              </td>
            </tr>            

            <tr>
              <td colspan="2" valign="top" align="middle" height="<?php echo $Template['WPT_height'];?>px" id="EPmain" style="z-index:2">
<!-- 
              //----------------------------------------------------------------------------------------------------
              // Display the row itself, in the appropriate template format
              //----------------------------------------------------------------------------------------------------
-->                                  
<?php 
					$MODE="EDIT";
			
					include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/Templates/I_EP.php');
?>					
					<script language="javascript">DispayTemplate('<?php echo $WPT_Template;?>')</script>

                    <form name="Template_Form" id="Template_Form" method="post">
                        <input name="WPT_PageID" id="WPT_PageID" type="hidden" value="<?php echo $WPT_PageID;?>" />
                        <input name="WPT_ID" id="WPT_ID" type="hidden" value="<?php echo $WPT_ID;?>" />
                        <input name="WPT_OLD_Template" id="WPT_OLD_Template" type="hidden" value="<?php echo $WPT_Template;?>" />
                        <input name="WPT_Template" id="WPT_Template" type="hidden" value="<?php echo $WPT_Template;?>" />
                        <input name="WPT_Text1" id="WPT_Text1" type="hidden" value="<?php echo htmlspecialchars($Template['WPT_Text1']);?>" />
                        <input name="WPT_Text2" id="WPT_Text2" type="hidden" value='<?php echo htmlspecialchars($Template['WPT_Text2']);?>' />
                        <input name="WPT_width" id="WPT_width" type="hidden" value="<?php echo $Template['WPT_width'];?>" /> 
                        <input name="WPT_height" id="WPT_height" type="hidden" value="<?php echo $Template['WPT_height'];?>" />
                        <input name="WPT_height_OLD" id="WPT_height_OLD" type="hidden" value="<?php echo $Template['WPT_height'];?>" />
                        <input name="WPT_Position" id="WPT_Position" type="hidden" value="<?php echo $Template['WPT_Position'];?>" />
                        <input name="RowCount" id="RowCount" type="hidden" value="<?php echo $TemplateRowCount;?>" />
                        <input name="TemplateUpdated" id="TemplateUpdated" type="hidden" value="UPDATE" />
                    </form> 
              </td>              
            </tr>                  
            
          </table> 
  
          <script>
			  $( "#SlideImgSize" ).slider({ min: 50, max: 700, step: 25, round: 1, 
				  value: <?php echo $Template['WPT_width'];?>,
				  slide: function(event, ui) {
						$("#ColSize").val(ui.value);
						ResizeColumns(ui.value)
				  },
				  stop: function(event, ui) {
						$("#WPT_width").val(ui.value);
						$("#ColSize").event(Submit_form('Template_Form'))
				  }
			   });
          </script>          
                               
          <script language="javascript">ResizeColumns(<?php echo $Template['WPT_width']; ?>)</script> 
          <script language="javascript">nicEditors.allTextAreas(); </script>     
<?php	

        WriteToTraceLog(1, 'P', 'I_EDIT_PAGE_TEMPLATE.php', '', '' );
?>