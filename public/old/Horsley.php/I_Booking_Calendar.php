<?php 
//================================================================================================
//
//  Incude:  		I_Booking_Calendar.php                                                          
//  Description:	Make a provisional reservation for the selected venue
//================================================================================================
		WriteToTraceLog(0, 'P', 'I_Booking_Calendar.php', '', '' );   
			
		//-------------------------------------------------------------------------------------
		// Save Name of selected COTS product (if applicable)
		//-------------------------------------------------------------------------------------			
		$URL_Link = "/index.php?p=".$_GET['p'];
		
		WriteToTraceLog(2, 'F', 'I_Booking_Calendar.php', 'Connect to DB', '' );
		
		include($_SERVER['DOCUMENT_ROOT'].'/Connections/HORSLEYDB.php');
			  
		//--------------------------------------------------------------------------
		// Check DB connection using mysqli
		//--------------------------------------------------------------------------
		if (mysqli_connect_errno()) {
			//--------------------------------------------------------------------------------
			// Write error to Error log
			//--------------------------------------------------------------------------------
			$msgText = 'SQL Error: ' . mysqli_connect_error();  
			WriteToErrorLog('ERRC000003', 'Error connecting to DB', 'I_Booking_Calendar.php', $msgText );
			exit;						  
		}
		
		//-------------------------------------------------------------------------
		// Set dates and variables for availability calendar
		//-------------------------------------------------------------------------

		$TodayDay = date('d');												// Current Day
		$TodayMonth = date('m');											// Current Month
		$TodayYear = date('Y');												// Current Year
		$JDToday = gregoriantojd($TodayMonth,$TodayDay,$TodayYear);			// Today in julian format
		
		if (isset($_GET['d'])) {
			$SelDay = $_GET['d'];											// Selected Day (01-31)
		} else {
			$SelDay = $TodayDay;
		}
		if (isset($_GET['m'])) {
			$SelMonth = $_GET['m'];											// Selected Month (01-12)
		} else {
			$SelMonth = $TodayMonth;	
		}
		if (isset($_GET['y'])) {
			$SelYear = $_GET['y'];											// Selected year (4 digit)
		} else {
			$SelYear = $TodayYear;	
		}
		if (isset($_GET['Date'])) {
			$SelYear = substr($_GET['Date'],0,4);
			$SelMonth = substr($_GET['Date'],5,2);
			$SelDay = substr($_GET['Date'],8,2);
		}
		
		$SelTimeStamp = mktime(0,0,0,$SelMonth,$SelDay,$SelYear);			// Save selected date in timestamp format
		$JDSel = gregoriantojd($SelMonth,$SelDay,$SelYear);					// Selected date julian format
		$CDate = $SelYear."-".$SelMonth."-".$SelDay;
		
		if (!isset($Venue)) {
			if (isset($Template['WPT_Text1'])) {
				$Venue = intval($Template['WPT_Text1']);
			} else {
				$Venue = 0;
			}
		}
		if (! is_numeric($Venue)) {
			$Venue = 0;
		}
		
		// Set link for previous month
		$pmonth = $SelMonth - 1;
		if ($pmonth < 1) {
			$pmonth = 12;
			$pyear = $SelYear - 1;
		} else {
			$pyear = $SelYear;
		}
		$PDate = "&d=1&m=".$pmonth."&y=".$pyear;
		$DB_P = $pyear."-".$pmonth."-01";
		
		// Set link for next month
		$nmonth = $SelMonth + 1;
		if ($nmonth > 12) {
			$nmonth = 1;
			$nyear = $SelYear + 1;
		} else {
			$nyear = $SelYear;
		}
		$NDate = "&d=1&m=".$nmonth."&y=".$nyear;
		$DB_N = $nyear."-".$nmonth."-31";
		
		$DateList =' ';		

		//----------------------------------------------------------------------------------------------
		// Get Bookings for selected day and location
		//---------------------------------------------------------------------------------------------- 			  
		$sql = "SELECT B_Date,B_Desc,B_EndTime,B_Locn,B_StartTime,B_Title,B_UserEmail,B_PageLink,B_Approved FROM booking WHERE B_SiteID=".$_SESSION['SiteID']." AND B_Date='".date('Y-m-d', $SelTimeStamp)."' AND B_Locn=".$Venue." ORDER BY B_StartTime";
		WriteToTraceLog(3, 'I', 'I_Booking_Calendar.php', 'Get bookings','SQL: '.$sql );	
		if ($TodaysBookings = mysqli_query($HDBi, $sql) ) {
			$TodaysBookings_count = mysqli_num_rows($TodaysBookings);
		} else {
			$TodaysBookings_count = 0;
		}
		
		//----------------------------------------------------------------------------------------------
		// Get details for current booking location 
		//---------------------------------------------------------------------------------------------- 			  
		$sql = "SELECT * FROM bookable_locations WHERE BL_SiteID=".$_SESSION['SiteID']." AND BL_Locn=".$Venue;
		WriteToTraceLog(3, 'I', 'I_Booking_Calendar.php', 'Get Location Details','SQL: '.$sql );	
		$Result = mysqli_query($HDBi, $sql); 
		$Location = mysqli_fetch_assoc($Result);
	  
		if ( mysqli_error($HDBi) ) {
			  WriteToErrorLog('ERRC000003', 'Error while getting location details from DB', 'I_Booking_Calendar.php. SQL:'.$sql, mysqli_error($HDBi) );
		}
		
		//----------------------------------------------------------------------------------------------
		// Get All User's Booking Dates for current location
		//----------------------------------------------------------------------------------------------
		if (isset($_SESSION['PHP_AUTH_USER'])) {
				$B_Email = $_SESSION['PHP_AUTH_USER'];
		} else {
				$B_Email = '';
		}
		
		$sql = "SELECT B_Date FROM booking WHERE B_SiteID=".$_SESSION['SiteID']." AND B_UserEmail='".$B_Email."' AND B_Locn=".$Venue." ORDER BY B_Date";
		WriteToTraceLog(3, 'I', 'I_Booking_Calendar.php', 'Get User bookings','SQL: '.$sql );	
		if ($AllUserBookings = mysqli_query($HDBi, $sql) ) {
			$AllUserBookings_count = mysqli_num_rows($AllUserBookings);
		} else {
			$AllUserBookings_count = 0;
		}
		
		//----------------------------------------------------------------------------------------------
		// Get User's first booking from 1st of last month
		//---------------------------------------------------------------------------------------------- 			  
		if ( $AllUserBookings_count > 0 ) {
			$UserBookings_Row = 0;
			mysqli_data_seek($AllUserBookings,$UserBookings_Row);
			$UserBookings = mysqli_fetch_row($AllUserBookings);
			$UserBookings_EOF = FALSE;
			$JDUserBooking = gregoriantojd(substr($UserBookings[0],5,2),substr($UserBookings[0],8,2),substr($UserBookings[0],0,4));
			WriteToTraceLog(2, 'I', 'I_DisplayCalendarDay.php', 'First User Booking: '.$UserBookings_Row.' of '.$AllUserBookings_count,'Date'.$UserBookings[0] );
		} else {
			$UserBookings_EOF = TRUE;
		}	
			
		//--------------------------------------------
		// MAIN PROCESSING
		//--------------------------------------------
?>	
<!-- 	//--------------------------------------------------------------------------------------
		// Call function to display the booking form and help tab
		//--------------------------------------------------------------------------------------
                  	        
		<script language="javascript">DisplayObject('BookingMenu');</script>
-->	

<!-- 	//--------------------------------------------------------------------------------------
		// Display calendars on left and details for the day on the right
		//--------------------------------------------------------------------------------------
-->	                  	

		<table width="420px" height="600px" style="position:relative; top:0px">
		  <tr>
			<td width="420" valign="top" align="left">
			  <img src="/images/bg_cal_top.jpg" width="420" height="36" />
			</td>
		  </tr>
		  <tr>
			<td valign="top">   
					   
<!-- 		//--------------------------------------------------------------------------------------
			// Calendar
			//--------------------------------------------------------------------------------------
-->	                  				 
			  <table valign="top" width="420" height="560px" background="/images/bg_cal_middle.jpg" style="position:relative; top:-4px;">
				<tr>
				  <td width="140" valign="top" style="padding-left:10px; padding-top:10px">
<!--						
                        &nbsp;&nbsp;<a style="width:40px" class="smallbutton" onclick="OpenURL('/PAGES/BookLocn<?php echo $Venue;?>.php?d=<?php echo $SelDay;?>&m=<?php echo $SelMonth;?>&y=<?php echo $SelYear;?>&locn=<?php echo $Venue;?>');"> REQUEST A BOOKING </a><br /><br /> 
-->
<?php	
						echo '<div class="tcal">';
						  $JDLoopDate = gregoriantojd($pmonth,1,$pyear);					// Set loop date to 1st of the month	
						  $LoopMonth = $pmonth;												// Calendar Month (to display)
						  $LoopYear = $pyear;												// Calendar Year (to display)
						  include($_SERVER['DOCUMENT_ROOT'].'/Calendar.php');
						echo '</div>';
						echo '<br>';
						echo '<div>';
						$JDLoopDate = gregoriantojd($SelMonth,1,$SelYear);					// Set loop date to 1st of the month	
						$LoopMonth = $SelMonth;												// Calendar Month (to display)
						$LoopYear = $SelYear;												// Calendar Year (to display)
						include($_SERVER['DOCUMENT_ROOT'].'/Calendar.php');
						echo '</div>';
						echo '<br>';
						echo '<div class="tcal">';
						  $JDLoopDate = gregoriantojd($nmonth,1,$nyear);					// Set loop date to 1st of the month	
						  $LoopMonth = $nmonth;												// Calendar Month (to display)
						  $LoopYear = $nyear;												// Calendar Year (to display)
						  include($_SERVER['DOCUMENT_ROOT'].'/Calendar.php');
						echo '</div>';
?>     
						<br />
                  
				  </td>

<!-- 			//--------------------------------------------------------------------------------------
				// Display Calendar entries for the selected day
				//--------------------------------------------------------------------------------------
-->	
				  <td width="280" valign="top" align="center" style="padding-left:10px; padding-right:5px; padding-top:0px"> 
					
					<font size="3"><?php echo date('l jS M  Y', $SelTimeStamp);?></font><br />
					<br />
					<font size="2"><b><?php echo $Location['BL_Name'];?></b></font><br />           
<?php
					include($_SERVER['DOCUMENT_ROOT'].'/Calendar/I_DisplayCalendarDay.php');
?>
					
				  </td>
				</tr>
			  </table>
			</td>
		  </tr>
		  <tr>
			<td height="17px" style="position:relative; top:-6px" valign="top"  align="left">
				<img src="/images/bg_cal_bottom.jpg" width="420" height="15" /> 
			</td>
		  </tr>
		</table>

<?php	
	//----------------------------------------------------------------------------------------------
	//  free up sql object(s)
	//----------------------------------------------------------------------------------------------

		mysqli_free_result($TodaysBookings);
		mysqli_free_result($AllUserBookings);
		mysqli_free_result($Result);
		mysqli_close($HDBi);
		
		WriteToTraceLog(1, 'I', 'I_Booking_Calendar.php', '', '' ); 
?>