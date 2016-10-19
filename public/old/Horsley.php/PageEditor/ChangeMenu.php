<?php session_start() ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/TitlePage.dwt.php" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- InstanceBeginEditable name="doctitle" -->
<title>Welcome to Horsley Parish (Gloucestershire) Community Website</title>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
    <link rel="stylesheet" href="/css/main.css"/>
        
    <!-- Scripts -->
    <script src="/scripts/Misc.js"></script>

<!-- InstanceEndEditable -->
</head>

<body>

<?php 

		if ( isset($_GET['p']) ) {
			$WP_Group = $_GET['p'];
		} else {	
			$WP_Group = 'Home';
		}
		if ( isset($_GET['EM']) ) {
			if ( $_GET['EM'] == 'Y' ) {
				$_SESSION['edit'] = 'Y';
			} else {	
				$_SESSION['edit'] = 'N';
			}
		}
		
		$URL_Link = "/index.php?p=".$WP_Group;
		
		include($_SERVER['DOCUMENT_ROOT'].'/PAGES/'.$WP_Group.'/menu.php');
		$count = count($Selected_pages);
		
		include($_SERVER['DOCUMENT_ROOT'].'/scripts/Common.php');
		include($_SERVER['DOCUMENT_ROOT'].'/scripts/EP_scripts.php');
		
		WriteToTraceLog(0, 'P', 'index.php', 'Main Page build', '');	
		
		include($_SERVER['DOCUMENT_ROOT'].'/MAIN_menu.php');
		include($_SERVER['DOCUMENT_ROOT'].'/I_MAIN_TITLE.php'); 
		
?>	
		<div class="MainPage">
			<div class="wrap">

<!-- InstanceBeginEditable name="MenuPanes" -->
<?php	

		//--------------------------------------------------------------------------
		// Build left and right menu columns
		//--------------------------------------------------------------------------		
		include($_SERVER['DOCUMENT_ROOT'].'/I_MAIN_LEFT_PANE.php');

?>
<!-- InstanceEndEditable -->

<!-- InstanceBeginEditable name="Navigation" -->

<!-- InstanceEndEditable -->


<!-- InstanceBeginEditable name="body" -->

<?php
			WriteToTraceLog(0, 'I', 'ChangeMenu.php', '', '');

			if (!InGroup("webadmin")) {
				echo '<script language="javascript">window.location.href = "/AccessRefused.php"</script>';
			}			
			
			//--------------------------------------------------------------------------
			// Check DB connection using mysqli
			//--------------------------------------------------------------------------
			include($_SERVER['DOCUMENT_ROOT'].'/Connections/HORSLEYDB.php');
			if (mysqli_connect_errno()) {
				WriteToErrorLog('ERRC000001', 'Error connecting to DB', 'ChangeMenu.php', mysqli_connect_errno() );					  
			}			
								
				
			//--------------------------------------------------------------------------------------------
			// FORM BUTTON SELECTED
			//--------------------------------------------------------------------------------------------
			if ( isset( $_POST['Action'] ) ) {	
					
				switch ($_POST['Action']) {
				
				//---------------------------------------------------
				// Form submitted: Insert Page Above
				//---------------------------------------------------
					case "UPLOADIMAGE":
						$max_filesize = 100000; 										// Image file size limit	
						$SaveFilename = 'Menu.png';
						$root_path = '/PAGES/'.$_POST['G_GroupID'];						// root path to menu directory 
						$upload_path = $_SERVER['DOCUMENT_ROOT'].$root_path.'/'; 		// Upload location
		
						$filename = $_FILES['userfile']['name']; 						// Get the name of the file (including file extension).
						
						$ext = substr($filename, strlen($filename)-3, 3); 				// Get the extension from the filename.
						$msg = "";
						
						// Check if the filetype is allowed, if not DIE and inform the user.
						if ( $ext != 'png') {
							$msg = 'The file you attempted to upload is not allowed. Only a png file can be used in Menus. Ext='.$ext;
						} else {
							// Now check the filesize, if it is too large then DIE and inform the user.
							if (filesize($_FILES['userfile']['tmp_name']) > $max_filesize) {
								$msg = "The file you attempted to upload is too large. Maximum file size is $max_filesize bytes.";
							} else {	   
								// Check if we can upload to the specified path, if not DIE and inform the user.
								if (!is_writable($upload_path)) {
									$msg = 'Insufficient access priviledges. Upload failed';
								} else {
									// Upload the file to your specified path.
									if (move_uploaded_file($_FILES['userfile']['tmp_name'],$upload_path . $SaveFilename)) {
										$msg = 'Your file upload was successful'; 
									} else {
										$msg = 'There was an error during the file upload. Please try again'; 	
									}
								}
							}
						}
						break;

				//---------------------------------------------------
				// Form submitted: Delete Menu Image
				//---------------------------------------------------
					case "DELETE_IMAGE":
						$SaveFilename = 'Menu.png';
						$root_path = '/PAGES/'.$_POST['G_GroupID'];							// root path to menu directory
		
						$upload_path = $_SERVER['DOCUMENT_ROOT'].$root_path.'/'; 				// Upload location	
						$FullFileName = $upload_path . $SaveFilename;
echo "HERE:".$FullFileName;
						unlink($FullFileName);		
						$msg = 'Image file has been deleted'; 	
						break;
						
				//---------------------------------------------------
				// Form submitted: Insert Page Above
				//---------------------------------------------------
					case "DescChange":
						$SQL = "UPDATE groups SET G_Desc='".$_POST['G_Desc']."' WHERE G_SiteID=".$_SESSION['SiteID']." AND G_GroupID='".$_POST['G_GroupID']."'";							
						if (mysqli_query($HDBi, $SQL)) {
							mysqli_commit($HDBi);
						} else {
							$msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
							mysqli_free_result($Result);
							mysqli_close($HDBi);
							WriteToErrorLog('ERRC000003', 'Error updating menu description', 'ChangeMenu.php', $msgText );
						}
						F_Build_Main_Menu();
						break;	
						
				//---------------------------------------------------
				// Form submitted: Insert Page Above
				//---------------------------------------------------
					case "INSERT_A":
						
						$SQL = "UPDATE groups SET G_Order=(G_Order+1) WHERE G_SiteID=".$_SESSION['SiteID']." AND G_Order >= ".$_POST['G_Order'];
						if (mysqli_query($HDBi, $SQL)) {
							$x = 0;
							do {
								$x = $x + 1;
								$SQL = "INSERT INTO groups (G_GroupID,G_Desc,G_Order,G_SiteID) VALUES('Group".$x."','New Menu Item',".$_POST['G_Order'].",".$_SESSION['SiteID'].")";
								$RC = mysqli_query($HDBi, $SQL);
							} while ( strchr(mysqli_error($HDBi),Duplicate) );
							
							if ( ! mysqli_error($HDBi) ) {															
								mysqli_commit($HDBi);
							} else {
								$msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
								mysqli_free_result($Result);
								mysqli_close($HDBi);
								WriteToErrorLog('ERRC000003', 'Error while inserting a new menu line above', 'ChangeMenu.php', $msgText );
							}
						}
						F_Build_Main_Menu();
						break;
						
				//---------------------------------------------------
				// Form submitted: Insert Page Below
				//---------------------------------------------------
					case "INSERT_B":
					
						$SQL = "UPDATE groups SET G_Order=(G_Order+1) WHERE G_SiteID=".$_SESSION['SiteID']." AND G_Order > ".$_POST['G_Order'];
						if (mysqli_query($HDBi, $SQL)) {
							$x = 0;
							do {
								$x = $x + 1;
								$SQL = "INSERT INTO groups (G_GroupID,G_Desc,G_Order,G_SiteID) VALUES('Group".$x."','New Menu Item',(".$_POST['G_Order']."+1),".$_SESSION['SiteID'].")";
								$RC = mysqli_query($HDBi, $SQL);
							} while ( strchr(mysqli_error($HDBi),Duplicate) );
							
							if ( ! mysqli_error($HDBi) ) {															
								mysqli_commit($HDBi);
							} else {
								$msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
								mysqli_free_result($Result);
								mysqli_close($HDBi);
								WriteToErrorLog('ERRC000003', 'Error while inserting new menu line below', 'ChangeMenu.php', $msgText );
							}
						}
						F_Build_Main_Menu();
						break;

				//---------------------------------------------------
				// Form submitted: Delete a Page
				//---------------------------------------------------
					case "DELETE":

						// Switch position of selected menu item and the item above.
						$SQL = "DELETE FROM groups WHERE G_SiteID=".$_SESSION['SiteID']." AND G_GroupID='".$_POST['G_GroupID']."'";
							
						if (mysqli_query($HDBi, $SQL)) {
							mysqli_commit($HDBi);
							// Remoave associated folder from root path (if it exists)
							if (!file_exists($_SERVER['DOCUMENT_ROOT'].'/PAGES/'.$WP_Group)) {
								unlink( $_SERVER['DOCUMENT_ROOT'].'/PAGES/'.$WP_Group );
							}
							F_Build_Main_Menu();
						} else {
							$msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
							mysqli_free_result($Result);
							mysqli_close($HDBi);
							WriteToErrorLog('ERRC000003', 'Error deleting menu item', 'ChangeMenu.php', $msgText );
						}
						break;

				//---------------------------------------------------
				// Form submitted: Move Item UP in the Menu listing
				//---------------------------------------------------
					case "MOVEUP":
	
						$Item_Position = $_POST['G_Order'];
						$New_Position = $Item_Position - 1;
						if ($Item_Position > 1) {
							// Switch position of selected menu item and the item above.
							$SQL = "UPDATE groups SET G_Order=".$Item_Position." WHERE G_SiteID=".$_SESSION['SiteID']." AND G_Order=".$New_Position;
							if (mysqli_query($HDBi, $SQL)) {
								$SQL = "UPDATE groups SET G_Order=".$New_Position." WHERE G_SiteID=".$_SESSION['SiteID']." AND G_GroupID='".$_POST['G_GroupID']."'";
								
								if (mysqli_query($HDBi, $SQL)) {
									mysqli_commit($HDBi);
								} else {
									$msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
									mysqli_free_result($Result);
									mysqli_close($HDBi);
									WriteToErrorLog('ERRC000003', 'Error moving menu item upwards', 'ChangeMenu.php', $msgText );
								}
							}
						}
						F_Build_Main_Menu();
						break;

				//---------------------------------------------------
				// Form submitted: Move Item DOWN in the Menu listing
				//---------------------------------------------------
					case "MOVEDOWN":

						$Item_Position = $_POST['G_Order'];
						$New_Position = $Item_Position + 1;
						if ($Item_Position < $_POST['RowCount']) {
							// Switch position of selected menu item and the item above.
							$SQL = "UPDATE groups SET G_Order=".$Item_Position." WHERE G_SiteID=".$_SESSION['SiteID']." AND G_Order=".$New_Position;
							if (mysqli_query($HDBi, $SQL)) {
								$SQL = "UPDATE groups SET G_Order=".$New_Position." WHERE G_SiteID=".$_SESSION['SiteID']." AND G_GroupID='".$_POST['G_GroupID']."'";
								if (mysqli_query($HDBi, $SQL)) {
									mysqli_commit($HDBi);
								} else {
									$msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
									mysqli_free_result($Result);
									mysqli_close($HDBi);
									WriteToErrorLog('ERRC000003', 'Error moving menu item upwards', 'ChangeMenu.php', $msgText );
								}
							}
						}
						F_Build_Main_Menu();
						break;
				} 
				echo '<script language="javascript">window.location.href = "/PageEditor/ChangeMenu.php"</script>';
				
			}
			
			
			//----------------------------------------------------------------------------------------------
			// Get Page details from database
			//---------------------------------------------------------------------------------------------- 			  
			$sql = "SELECT * FROM groups WHERE G_SiteID=".$_SESSION['SiteID']." AND G_Order > 0 ORDER BY G_Order ASC";
			WriteToTraceLog(3, 'P', 'ChangeMenu.php', 'Get group list from DB', $sql );	
			$Result = mysqli_query($HDBi, $sql);
			$RowCount = mysqli_num_rows($Result);
			
			if ( mysqli_error($HDBi) ) {
				$msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
				mysqli_free_result($Result);
				mysqli_close($HDBi);
				WriteToErrorLog('ERRC000003', 'Error updating web_page_template row', 'ChangeMenu.php', $msgText );
			}

?>
			<div style="position:relative; left: 50px;">
			<br />
            <font size="5" color="#666600">Main Menu - Admin Page<br />
            <font size="3">Use the form below to modify the main menu (as displayed on the left of this page).<br />
            Use care when deleting items, as this will remove all saved content from the database and <br /> 
            remove all the associated published files.</font></font><br />
            
            <br />
<?php
			echo '<font color="red">'.$msg.'</font><br>';

			//----------------------------------------------------------------------------------------------
			// Display the menu items in order
			//----------------------------------------------------------------------------------------------
		    
			for ($x=1; $x<=$RowCount; $x++) { 
				$WebPage = mysqli_fetch_assoc($Result);
				
				echo '<div class="EditMainMenu">';
					
					echo '<form method="post" name="ChangeMenu'.$x.'" enctype="multipart/form-data">';
					
						echo '<input id="G_Desc" name="G_Desc" type="text" size="22" maxlength="25" value="'.$WebPage['G_Desc'].'"  style="position:absolute; left:0px; padding:4px;" onchange="SetTextBox(\'Action'.$x.'\',\'DescChange\'); Submit_form(\'ChangeMenu'.$x.'\')"/>';
						echo '<input type="hidden" name="G_GroupID" value="'.$WebPage['G_GroupID'].'" />';
						echo '<input type="hidden" name="G_Order"  value="'.$WebPage['G_Order'].'" />'; 
						echo '<input type="hidden" name="RowCount"  value="'.$RowCount.'" />';
						echo '<input type="hidden" name="Action" id="Action'.$x.'" value="" />';
	?>
						<div style="position:absolute; left:164px; top:8px; color:#FFF;">
							<a class="Upload" name="Upload" id="Upload" title="Click here to upload a PNG (image) file">
							Upload File
							<input type="file" name="userfile" style="width:120px; height:15px; position:absolute; left:0px; opacity:0" onchange="SetTextBox('Action<?php echo $x;?>','UPLOADIMAGE'); Submit_form('ChangeMenu<?php echo $x;?>');"/></a>
						</div>
<?php
					echo '</form>';

					if ($x > 1) {
						echo '<a class="ArrowUp" style="position:absolute; left:270px; top:8px;" title="Move menu item towards the top of the list" onclick="SetTextBox(\'Action'.$x.'\',\'MOVEUP\'); Submit_form(\'ChangeMenu'.$x.'\');"></a>';
					}
					if ($x < $RowCount) {
						echo '<a class="ArrowDown" style="position:absolute; left:297px; top:8px;" title="Move menu item towards the bottom of the list" onclick="SetTextBox(\'Action'.$x.'\',\'MOVEDOWN\'); Submit_form(\'ChangeMenu'.$x.'\');"></a>';
					}
					echo '<a class="InsertAbove"  style="position:absolute; left:324px; top:6px;" title="Insert above" onclick="SetTextBox(\'Action'.$x.'\',\'INSERT_A\'); Submit_form(\'ChangeMenu'.$x.'\');"></a>';
					echo '<a class="InsertBelow" style="position:absolute; left:351px; top:6px;" title="Insert below" onclick="SetTextBox(\'Action'.$x.'\',\'INSERT_B\'); Submit_form(\'ChangeMenu'.$x.'\');"></a>';
					echo '<a class="WasteBinG" style="position:absolute; left:378px; top:6px;" title="Delete Page" onclick="SetTextBox(\'Action'.$x.'\',\'DELETE\'); Submit_form(\'ChangeMenu'.$x.'\');"></a>';	
					echo '<a class="DelImage" style="position:absolute; left:407px; top:6px;" title="Delete Menu Image" onclick="SetTextBox(\'Action'.$x.'\',\'DELETE_IMAGE\'); Submit_form(\'ChangeMenu'.$x.'\');"></a>';	
				
					echo '<br><br>';
				  echo '</div>';
			}

			WriteToTraceLog(1, 'I', 'ChangeMenu.php', '', '');
?>

			</div>

<?php
				mysqli_free_result($Result);
				mysqli_close($HDBi);
?>


<!-- InstanceEndEditable -->

            </div>      
        </div>
        
</body>
<!-- InstanceEnd --></html>

