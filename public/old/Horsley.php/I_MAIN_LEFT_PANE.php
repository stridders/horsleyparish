<!--  -------------------------------------------------------------------------------------   -->
<!--  Left Column menu area   -->
<!--  -------------------------------------------------------------------------------------   -->
<?php
	  WriteToTraceLog(0, 'I', 'I_MAIN_LEFT_PANE.php', '', '');
		
?>

	  <center>
      <div class="MainPage" style="display:inline-block;">
<?php

	  if ( $_SESSION['edit'] == 'Y' ) {
		  echo '<div class="MenuItems" id="editmenu" style="position:absolute; left:0px; text-align:left;">';
	  } else {
		  echo '<div class="MenuItems" id="noeditmenu" style="position:absolute; left:0px; text-align:left;">';
	  }
      echo '<div class="controls center">';

                  $count = count($MAIN_menu);
				  
				  WriteToTraceLog(2, 'I', 'I_MAIN_LEFT_PANE.php', 'Menu Count', $count);
				  
                  for ($i = 0; $i < $count; $i++) {
					  
					  if ($MAIN_pages[$i] == $WP_Group) {
						  echo '<table><tr><td class="Selected" valign="top">';
					  }					  

					  // Check to see if root path exists
					  WriteToTraceLog(3, 'I', 'I_MAIN_LEFT_PANE.php', 'Checking menu image:', $_SERVER['DOCUMENT_ROOT'].'/PAGES/'.$MAIN_pages[$i].'/Menu.png');
					  if (file_exists($_SERVER['DOCUMENT_ROOT'].'/PAGES/'.$MAIN_pages[$i].'/Menu.png')) {
						  echo '<a class="image" href="/index.php?p='.$MAIN_pages[$i].'" title="'.$MAIN_menu[$i].'"><img src="/PAGES/'.$MAIN_pages[$i].'/Menu.png" width="170" style="border:none;" /></a><br>';
					  } else {
						  echo '<a href="/index.php?p='.$MAIN_pages[$i].'">&nbsp; ' . $MAIN_menu[$i] . "</a><br>";
					  }

					  WriteToTraceLog(2, 'I', 'I_MAIN_LEFT_PANE.php', 'Main Menu Item: '.$MAIN_pages[$i],'' );

					  if ($WP_Group == $MAIN_pages[$i]) {
						  
						  	WriteToTraceLog(2, 'I', 'I_MAIN_LEFT_PANE.php', 'SM required', '');
						  
							//-------------------------------------------------------------------------------
							// If this is an edit session and user has authority to edit this catagory
							//-------------------------------------------------------------------------------

							if  ( $_SESSION['edit'] == 'Y' and InGroup($WP_Group) ) {

								WriteToTraceLog(2, 'I', 'I_MAIN_LEFT_PANE.php', 'Build editable menu', '');

								echo '<div class="EDITSM">';

								//--------------------------------------------------------------------------
								// Check DB connection using mysqli
								//--------------------------------------------------------------------------
								include($_SERVER['DOCUMENT_ROOT'].'/Connections/HORSLEYDB.php');
								if (mysqli_connect_errno()) {
									WriteToErrorLog('ERRC000001', 'Error connecting to DB', 'I_MAIN_LEFT_PANE.php', mysqli_connect_errno() );					  
								}
								
								//----------------------------------------------------------------------------------------------
								// Get Page details from database
								//---------------------------------------------------------------------------------------------- 			  
								$sql = "SELECT * FROM web_pages WHERE WP_SiteID=".$_SESSION['SiteID']." AND WP_Group='".$WP_Group."' ORDER BY WP_MenuOrder";
								WriteToTraceLog(3, 'P', 'I_MAIN_LEFT_PANE.php', 'Get web_pages from DB', $sql );	
								$Result = mysqli_query($HDBi, $sql);
								$RowCount = mysqli_num_rows($Result);
								
								if ( mysqli_error($HDBi) ) {
									WriteToErrorLog('ERRC000002', 'Error while getting web_page details from database', 'I_MAIN_LEFT_PANE.php', mysqli_error($HDBi) );
								}
								
								//----------------------------------------------------------------------------------------------
								// If there are no pages associated with this menu item (i.e. it is a new menu item) then
								// call function to insert a new web_page entry and also a new row in the web_page_template table
								// Refresh the web site to pick up the changes.
								//---------------------------------------------------------------------------------------------- 								
								if ( $RowCount == 0 ) {
									$WP_ID = F_Insert_New_Page(1);
									echo '<script language="javascript">window.location.href = "/PageEditor/edit_page.php?p='.$_GET['p'].'&WP_ID='.$WP_ID.'"</script>';
								}
									
								$x=1;
								echo '<p>';
							
								while  ($WebPage = mysqli_fetch_assoc($Result) ) {
								
									  if ( ( ! isset($_POST['WP_ID']) and isset($_GET['WP_ID']) and $_GET['WP_ID'] == $WebPage['WP_ID']) or (isset($_POST['WP_ID']) and $_POST['WP_ID'] == $WebPage['WP_ID'])) {

										       WriteToTraceLog(3, 'P', 'I_MAIN_LEFT_PANE.php', 'EditedSM:', $WebPage['WP_Title'] );
											   echo '<form method="post" name="F_MenuItem">';
											   echo '<input id="WP_Title" name="WP_Title" class="TextEdit" type="text" size="22" maxlength="25" value="'.$WebPage['WP_Title'].'" onchange="Submit_form(\'F_MenuItem\')"/>';
											   echo '<input type="hidden" name="WP_ID"  value="'.$WebPage['WP_ID'].'" />';
											   echo '<input type="hidden" name="OLD_Position"  value="'.$WebPage['WP_MenuOrder'].'" />';
											   echo '<input type="hidden" id="SMPosition" name="SMPosition"  value="'.$WebPage['WP_MenuOrder'].'" />';
											   echo '<input type="hidden" id="Page_action" name="Page_action" value="CHANGED"/>'; 
											   echo '</form>';

											   echo '<div class="SubMenuEdit">'; 
												   if ($x > 1) {
														echo '<a class="ArrowUp" title="Move menu item towards the top of the list" onclick="SetTextBox(\'SMPosition\',\''.($x-1).'\'); SetTextBox(\'Page_action\',\'MOVE\'); Submit_form(\'F_MenuItem\');"></a>';
												   }
												   if ($x < mysqli_num_rows($Result)) {
														echo '<a class="ArrowDown" title="Move menu item towards the bottom of the list" onclick="SetTextBox(\'SMPosition\',\''.($x+1).'\'); SetTextBox(\'Page_action\',\'MOVE\'); Submit_form(\'F_MenuItem\');"></a>';
												   }
												   echo '<a class="InsertAbove" title="Insert above" onclick="SetTextBox(\'Page_action\',\'INSERT_PAGE_A\'); Submit_form(\'F_MenuItem\');"></a>';
												   echo '<a class="InsertBelow" title="Insert below" onclick="SetTextBox(\'SMPosition\',\''.($WebPage['WP_MenuOrder']+1).'\'); SetTextBox(\'Page_action\',\'INSERT_PAGE_B\'); Submit_form(\'F_MenuItem\');"></a>';
												   echo '<a class="WasteBin" title="Delete Page" onclick="SetTextBox(\'Page_action\',\'DELETE_PAGE\'); Submit_form(\'F_MenuItem\');"></a>';
												 echo '</div>';

									  } else {
										WriteToTraceLog(3, 'P', 'I_MAIN_LEFT_PANE.php', 'SM:', $WebPage['WP_Title'] ); 
										echo '<a href="/PageEditor/edit_page.php?p='.$WP_Group.'&WP_ID='.$WebPage['WP_ID'].'">'.$WebPage['WP_Title'].'</a><br>';
									  }
								      $x=$x+1;
									  
								} 
								echo '</p>';
								
							//----------------------------------------------------------------------------------------------
							//  free up sql object(s)
							//----------------------------------------------------------------------------------------------
								mysqli_free_result($Result);
								mysqli_close($HDBi);
								
								echo '</div>';	  
							
							} else {
							  //-------------------------------------------------------------------------------
							  // If this is not an edit session
							  //-------------------------------------------------------------------------------
								if (isset($SM)) {
									
									WriteToTraceLog(2, 'I', 'I_MAIN_LEFT_PANE.php', 'Build standard SubMenu', '');
									$Subcount = count($SM);	  
									echo '<div class="SM">';  
									if ( $Subcount > 1 ) {
										echo '<p>';
										for ($x = 1; $x < $Subcount; $x++) {  
											echo '<a class="toCenter" data-item="'.$x.'">' . $SM[$x] . "</a><br>";
										}
										echo '</p>';
									}
									echo '</div>';
								}
							}

						  if ($MAIN_pages[$i] == $WP_Group) {
							  echo '</td></tr></table>';
						  }
						  
					  }  
				  }
                  echo '<br>';
                  include($_SERVER['DOCUMENT_ROOT']."/I_LOGIN.php");					
?>
        </div>
      </div>
      </center>
<?php
	  WriteToTraceLog(1, 'I', 'I_MAIN_LEFT_PANE.php', '', '');
?>
