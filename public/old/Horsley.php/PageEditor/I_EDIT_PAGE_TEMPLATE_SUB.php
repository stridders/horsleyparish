<?php
//================================================================================================
//
//  Incude:  		I_EDIT_PAGE_TEMPLATE_SUB.php                                                       
//  Description:	Update a row in the web_page_template table                                  
//
//================================================================================================
 
 	if (isset($_POST['TemplateUpdated'])) {
	    WriteToTraceLog(0, 'I', 'I_EDIT_PAGE_TEMPLATE_SUB.php', '', $_POST['WPT_width'].'/'.$_POST['WPT_height'] );
		 WriteToTraceLog(2, 'I', 'I_EDIT_PAGE_TEMPLATE_SUB.php', 'TEXT:', $_POST['WPT_Text1'] );

		switch ($_POST["TemplateUpdated"]) {

			case 'UPDATE':
			//-------------------------------------------------------------------------------------
			// Update row
			//-------------------------------------------------------------------------------------			
				switch ($_POST['WPT_OLD_Template']) {
					case "P1":
					case "T1":
					case "TP":
							$SQL = sprintf("UPDATE web_page_template set WPT_Template=%s,WPT_Text1=%s,WPT_width=%s, WPT_height=%s WHERE WPT_SiteID=".$_SESSION['SiteID']." AND WPT_ID=".$_POST['WPT_ID'],
								GetSQLValueString($_POST['WPT_Template'], "text"),
								GetSQLValueString($_POST['WPT_Text1'],"RTEtext"),
								GetSQLValueString($_POST['WPT_width'], "int"),
								GetSQLValueString($_POST['WPT_height'], "int"));
							break;
					case "PT":
							$SQL = sprintf("UPDATE web_page_template set WPT_Template=%s,WPT_Text2=%s,WPT_width=%s, WPT_height=%s WHERE WPT_SiteID=".$_SESSION['SiteID']." AND WPT_ID=".$_POST['WPT_ID'],
								GetSQLValueString($_POST['WPT_Template'], "text"),
								GetSQLValueString($_POST['WPT_Text2'],"RTEtext"),
								GetSQLValueString($_POST['WPT_width'], "int"),
								GetSQLValueString($_POST['WPT_height'], "int"));
							break;
					case "P2":
					case "P1":
							$SQL = sprintf("UPDATE web_page_template set WPT_Template=%s,WPT_width=%s, WPT_height=%s WHERE WPT_SiteID=".$_SESSION['SiteID']." AND WPT_ID=".$_POST['WPT_ID'],
								GetSQLValueString($_POST['WPT_Template'], "text"),
								GetSQLValueString($_POST['WPT_width'], "int"),
								GetSQLValueString($_POST['WPT_height'], "int"));
							break;
					case "CP":
							$SQL = sprintf("UPDATE web_page_template set WPT_Template=%s,WPT_width=450,WPT_height=600, WPT_Text1=%s WHERE WPT_SiteID=".$_SESSION['SiteID']." AND WPT_ID=".$_POST['WPT_ID'],
								GetSQLValueString($_POST['WPT_Template'], "text"),
								GetSQLValueString($_POST['WPT_Text1'], "RTEtext"));
							break;
					case "AL":
							$SQL = sprintf("UPDATE web_page_template set WPT_Template=%s,WPT_width=%s,WPT_height=100 WHERE WPT_SiteID=".$_SESSION['SiteID']." AND WPT_ID=".$_POST['WPT_ID'],
								GetSQLValueString($_POST['WPT_Template'], "text"),
								GetSQLValueString($_POST['WPT_width'], "int"));
							break;
					case "BC":
					case "CT":
							$SQL = sprintf("UPDATE web_page_template set WPT_Template=%s,WPT_width=450,WPT_height=600,WPT_Text1=%s,WPT_Text2=%s WHERE WPT_SiteID=".$_SESSION['SiteID']." AND WPT_ID=".$_POST['WPT_ID'],
								GetSQLValueString($_POST['WPT_Template'], "text"),
								GetSQLValueString($_POST['WPT_Text1'], "RTEtext"),
								GetSQLValueString($_POST['WPT_Text2'], "RTEtext"));
							break;		
					default:
							$SQL = sprintf("UPDATE web_page_template set WPT_Template=%s,WPT_Text1=%s,WPT_Text2=%s,WPT_width=%s, WPT_height=%s WHERE WPT_SiteID=".$_SESSION['SiteID']." AND WPT_ID=".$_POST['WPT_ID'],
								GetSQLValueString($_POST['WPT_Template'], "text"),
								GetSQLValueString($_POST['WPT_Text1'],"RTEtext"),
								GetSQLValueString($_POST['WPT_Text2'],"RTEtext"),
								GetSQLValueString($_POST['WPT_width'], "int"),
								GetSQLValueString($_POST['WPT_height'], "int"));
				}
				
				WriteToTraceLog(3, 'I', 'I_EDIT_PAGE_TEMPLATE_SUB.php', 'Update web_page_template row', 'sql='.$SQL );
				
				if ($Result = mysqli_query($HDBi, $SQL)) {
					mysqli_commit($HDBi);	
				} else {
					//--------------------------------------------------------------------------------
					// Write error to Error log
					//--------------------------------------------------------------------------------
					$msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
					mysqli_close($HDBi);
					WriteToErrorLog('ERRC000003', 'Error updating web_page_template row', 'I_EDIT_PAGE_TEMPLATE_SUB.php', $msgText );
				}						
			break;
				
			//-------------------------------------------------------------------------------------
			// Insert row Above
			//-------------------------------------------------------------------------------------					
			case 'INSERT_ROW_A':
				F_Insert_New_Row($_POST['WPT_PageID'],$_POST['WPT_Position'],'T1','Insert text here');
				echo '<script language="javascript">window.location.href = "/PageEditor/edit_page.php?p='.$_GET['p'].'&WP_ID='.$_POST['WPT_PageID']."&ROW=".$_POST['WPT_Position'].'#ROW'.$_POST['WPT_Position'].'"</script>';
				break;
				
			//-------------------------------------------------------------------------------------
			// Insert row Below
			//-------------------------------------------------------------------------------------					
			case 'INSERT_ROW_B':
				F_Insert_New_Row($_POST['WPT_PageID'],($_POST['WPT_Position']+1),'T1','Insert text here' );
				echo '<script language="javascript">window.location.href = "/PageEditor/edit_page.php?p='.$_GET['p'].'&WP_ID='.$_POST['WPT_PageID']."&ROW=".($_POST['WPT_Position']+1).'#ROW'.($_POST['WPT_Position']+1).'"</script>';
				break;
					
			//-------------------------------------------------------------------------------------
			// Delete row 
			//-------------------------------------------------------------------------------------					
			case 'DELETE_ROW':
				if ($_POST['RowCount'] > 1) {
					F_Delete_Row(GetSQLValueString($_POST['WPT_PageID'], "int"),GetSQLValueString($_POST['WPT_ID'], "int"),GetSQLValueString($_POST['WPT_Position'], "int"));
					echo '<script language="javascript">window.location.href = "/PageEditor/edit_page.php?p='.$_GET['p'].'&WP_ID='.$_POST['WPT_PageID'].'"</script>';
				}
				break;
					 
					 
		}  // End of switch statement

			  
	    WriteToTraceLog(1, 'I', 'I_EDIT_PAGE_TEMPLATE_SUB.php', '', '' );
	}
?>
