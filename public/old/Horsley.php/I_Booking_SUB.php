<?php
//================================================================================================
//
//  Incude:  		I_Booking_SUB.php                                                       
//  Description:	Update resource's availability and preferences                                  
//
//================================================================================================
 
	    WriteToTraceLog(0, 'I', 'I_Booking_SUB.php', '', '' );
		
		if (isset($_POST["B_Date"])) {
			
			  //-------------------------------------------------------------------------------------
			  // If a booking is being deleted, then delete the entry from the DB
			  //-------------------------------------------------------------------------------------			
			  if (isset($_POST['DeleteST']) && $_POST['DeleteST'] != NULL) {
				  $SQL = sprintf("DELETE from booking WHERE B_SiteID=%s AND B_Date=%s AND B_StartTime=%s AND B_Locn=%s",
												$_SESSION['SiteID'],
												GetSQLValueString($_POST['B_Date'], "text"),
												GetSQLValueString($_POST['DeleteST'], "text"),
												$_POST['B_Locn']);
				  
				  WriteToTraceLog(3, 'I', 'I_Booking_SUB.php', 'Delete booking', 'sql='.$SQL );
				  
				  if ($Result = mysqli_query($HDBi, $SQL)) {
					  mysqli_commit($HDBi);	
				  } else {
					  //--------------------------------------------------------------------------------
					  // Write error to Error log
					  //--------------------------------------------------------------------------------
					  $msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
					  mysqli_close($HDBi);
					  WriteToErrorLog('ERRC000003', 'Error deleting booking', 'I_Booking_SUB.php', $msgText );					  
				  }						
              }	else {  
				  //-------------------------------------------------------------------------------------
				  // If a booking is being deleted, then delete the entry from the DB
				  //-------------------------------------------------------------------------------------			
				  if (isset($_POST['AcceptST']) && $_POST['AcceptST'] != NULL) {
					  $SQL = sprintf("UPDATE booking set B_Approved='Y' WHERE B_SiteID=%s AND B_Date=%s AND B_StartTime=%s AND B_Locn=%s",
													$_SESSION['SiteID'],
													GetSQLValueString($_POST['B_Date'], "text"),
													GetSQLValueString($_POST['AcceptST'], "text"),
													$_POST['B_Locn']);
					  
					  WriteToTraceLog(3, 'I', 'I_Booking_SUB.php', 'Accept provisional booking', 'sql='.$SQL );
					  
					  if ($Result = mysqli_query($HDBi, $SQL)) {
						  mysqli_commit($HDBi);	
					  } else {
						  //--------------------------------------------------------------------------------
						  // Write error to Error log
						  //--------------------------------------------------------------------------------
						  $msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
						  mysqli_close($HDBi);
						  WriteToErrorLog('ERRC000003', 'Error updating provisional booking', 'I_Booking_SUB.php', $msgText );
						  exit;						  
					  }						
				  } else {
					  //-------------------------------------------------------------------------------------
					  // Else, booking is being added
					  //-------------------------------------------------------------------------------------
					  
					  //-------------------------------------------------------------------------------------
					  // Verify that the booking title and description have been set
					  //-------------------------------------------------------------------------------------
					  
					  if (GetSQLValueString($_POST['B_Title'], "text") == "NULL") {
						  $msg = "Invalid value in Title (e.g. Can not be blank)";
						  return;
					  }
					  if (GetSQLValueString($_POST['B_Desc'], "text") == "NULL") {
						  $msg = "Invalid value in Description (e.g. Can not be blank)";
						  return;
					  }
					  
					  //-------------------------------------------------------------------------------------
					  // If this is a repeat booking then insert a new entry into the repeat_booking table
					  //-------------------------------------------------------------------------------------
					  
					  if (GetSQLValueString($_POST['rpt_period'], "text") != "NULL") {
						  
						  $SQL = sprintf("INSERT INTO repeat_booking (rb_Apt_Comment,rb_Apt_Desc,rb_Apt_End,rb_Apt_Locn,rb_Apt_Start,rb_Apt_Title,rb_Pattern_Freq,rb_Pattern_Fri,rb_Pattern_Mon,rb_Pattern_Period,rb_Pattern_Sat,rb_Pattern_Sun,rb_Pattern_Thu, rb_Pattern_Tue, rb_Pattern_Wed, rb_Week_Nbr, rb_Range_Start, rb_Range_End, rb_SiteID, rb_UserEmail) VALUES(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)",
								  GetSQLValueString($_POST['B_Comment'], "text"),
								  GetSQLValueString($_POST['B_Desc'], "text"),
								  GetSQLValueString($_POST['B_EndTime'], "text"),
								  $_POST['B_Locn'],
								  GetSQLValueString($_POST['B_StartTime'], "text"),
								  GetSQLValueString($_POST['B_Title'], "text"),
								  GetSQLValueString($_POST['rpt_freq'], "int"),
								  GetSQLValueString($_POST['rpt_day_fri'], "checkbox"),
								  GetSQLValueString($_POST['rpt_day_mon'], "checkbox"),
								  GetSQLValueString($_POST['rpt_period'], "int"),
								  GetSQLValueString($_POST['rpt_day_sat'], "checkbox"),
								  GetSQLValueString($_POST['rpt_day_sun'], "checkbox"),
								  GetSQLValueString($_POST['rpt_day_thu'], "checkbox"),
								  GetSQLValueString($_POST['rpt_day_tue'], "checkbox"),
								  GetSQLValueString($_POST['rpt_day_wed'], "checkbox"),
								  GetSQLValueString($_POST['wk_nbr'], "int"),
								  GetSQLValueString($_POST['rpt_from'], "text"),
								  GetSQLValueString($_POST['rpt_to'], "text"),
								  $_SESSION['SiteID'],
								  GetSQLValueString($_POST['B_UserEmail'], "text"));
					  
							WriteToTraceLog(3, 'I', 'I_Booking_SUB.php', 'Insert new repeat booking', 'sql='.$SQL );										
							mysqli_query($HDBi, $SQL);	
							$rpt_bk_ref = mysqli_insert_id($HDBi);
					  }
							
					  //-------------------------------------------------------------------------------------
					  // Insert the booking details
					  //-------------------------------------------------------------------------------------
						  
					  $SQL = sprintf("INSERT INTO booking (B_SiteID, B_Comment, B_Date, B_Desc, B_EndTime, B_Locn, B_Approved, B_PageLink, B_StartTime, B_Title, B_UserEmail, B_RptRef) VALUES(%s,%s,%s,%s,%s,%s,'N','',%s,%s,%s,%s)",
							$_SESSION['SiteID'],
							GetSQLValueString($_POST['B_Comment'], "text"),
							GetSQLValueString($_POST['B_Date'], "text"),
							GetSQLValueString($_POST['B_Desc'], "text"),
							GetSQLValueString($_POST['B_EndTime'], "text"),
							$_POST['B_Locn'],
							GetSQLValueString($_POST['B_StartTime'], "text"),
							GetSQLValueString($_POST['B_Title'], "text"),
							GetSQLValueString($_POST['B_UserEmail'], "text"),
							GetSQLValueString($rpt_bk_ref, "text"));
					
					  WriteToTraceLog(3, 'I', 'I_Booking_SUB.php', 'Insert new booking', 'sql='.$SQL );
					  
					  if (mysqli_query($HDBi, $SQL)) {
						  
						  mysqli_commit($HDBi);	
						  
						  //----------------------------------------------------------------------------------------------
						  // Get details for current booking location 
						  //---------------------------------------------------------------------------------------------- 			  
						  $sql = "SELECT * FROM bookable_locations WHERE BL_SiteID=".$_SESSION['SiteID']." AND BL_Locn=".$_POST['B_Locn'];
						  WriteToTraceLog(3, 'I', 'I_Booking_SUB.php', 'Get Location Details (for confirmation email)','SQL: '.$sql );	
						  $Result1 = mysqli_query($HDBi, $sql); 
						  $Locn = mysqli_fetch_assoc($Result1);					  
						
						  if ( mysqli_error($HDBi) ) {
								WriteToErrorLog('ERRC000003', 'Error while getting location details from DB', 'I_Booking_SUB.php. SQL:'.$sql, mysqli_error($HDBi) );
						  }
  
						  $headers = "From: bookings@HorsleyParish.co.uk" . "\r\n";
						  $headers .= "MIME-Version: 1.0\r\n";
						  $headers .= "Content-Type: text/html; charset=ISO-8859-1\r\n";
						  $subject = 'Provisional Booking for '.$Locn['BL_Name'].' on '.GetSQLValueString($_POST['B_Date'], "text");
						  $message = '<html><body>';
						  $message .= "A provisional booking for the ".$Locn['BL_Name']." has been received. Details as follows: <br>";
						  $message .= "<table><tr>";
						  $message .= "<td>Date:</td><td>".GetSQLValueString($_POST['B_Date'], "text")."</td></tr>";
						  $message .= "<tr><td>Start Time:</td><td>".GetSQLValueString($_POST['B_StartTime'], "text")."</td></tr>";
						  $message .= "<tr><td>End Time:</td><td>".GetSQLValueString($_POST['B_EndTime'], "text")."</td></tr>";
						  $message .= "<tr><td>User:</td><td>".	GetSQLValueString($_POST['B_UserEmail'], "text") ."</td></tr>";
						  $message .= "<tr><td>Title:</td><td>".GetSQLValueString($_POST['B_Title'], "text")."</td></tr>";
						  $message .= "<tr><td>Description:</td><td>". GetSQLValueString($_POST['B_Desc'], "text") ."</td></tr>";
						  $message .= "<tr><td>Comments:</td><td>". GetSQLValueString($_POST['B_Comment'], "text")."</td></tr>";		
						  $message .= '</table></body></html>';
						  
						  WriteToTraceLog(2, 'I', 'I_Booking_SUB.php', 'Send confirmation email to '.$Locn['BL_ContactEmail'],' message:: '.$message );	
						  
						  mail( $Locn['BL_ContactEmail'], $subject, $message, $headers );
  
						  mysqli_free_result($Result1);
						
					  } else {
						  //--------------------------------------------------------------------------------
						  // Write error to Error log
						  //--------------------------------------------------------------------------------
						  $msgText = 'SQL:' . $SQL . ' --  Error: ' . mysqli_error($HDBi);  
						  mysqli_rollback($HDBi);
						  mysqli_close($HDBi);
						  WriteToErrorLog('ERRC000014', 'Error inserting new booking request', 'I_Booking_SUB.php', $msgText );					  
					  }						
				  }
			  }
			  WriteToTraceLog(1, 'I', 'I_Booking_SUB.php', '', '' );
			  echo '<script language="javascript">window.location.href = "'.$URL_Link . '&sel=' . $PageNbr . '&Date='.$CDate.'&locn='.$Venue.'&BDM=B'.'"</script>';
		}
			  
	    WriteToTraceLog(1, 'I', 'I_Booking_SUB.php', '', '' );
?>
