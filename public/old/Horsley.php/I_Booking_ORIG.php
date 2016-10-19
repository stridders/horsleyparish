	<script src="/scripts/jQuery2.0.3.js"></script>
	<script src="/scripts/jquery.ui.core.js"></script>
	<script src="/scripts/jquery.ui.widget.js"></script>
	<script src="/scripts/jquery.ui.datepicker.js"></script>
    <link rel="stylesheet" href="/css/jquery-ui.min.css">
    
    <script>
	$(function() {
		$( "#startDate" ).datepicker({
			dateFormat: "yy-mm-dd",				
			defaultDate: null,
			changeMonth: true,
			numberOfMonths: 1
		});
		$( "#rpt_from" ).datepicker({
			dateFormat: "yy-mm-dd",				
			defaultDate: null,
			changeMonth: true,
			numberOfMonths: 1,
			onClose: function( selectedDate ) {
				$( "#rpt_to" ).datepicker( "option", "minDate", selectedDate );
			}
		});
		$( "#rpt_to" ).datepicker({
			dateFormat: "yy-mm-dd",	
			defaultDate: "+1w",
			changeMonth: true,
			numberOfMonths: 1,
			onClose: function( selectedDate ) {
				$( "#rpt_from" ).datepicker( "option", "maxDate", selectedDate );
			}
		});
	});
	</script>
    
<?php 
//================================================================================================
//
//  Incude:  		I_Booking.php                                                          
//  Description:	Make a provisional reservation for the selected venue
//================================================================================================
		WriteToTraceLog(0, 'P', 'I_Booking.php', '', '' ); ?>   
                
<?php
		if (! isset($_SESSION['PHP_AUTH_USER'])) {
?>
		  <center>
          <table width="500px">
            <tr>
            	<td valign="top" align="left" bgcolor="#FFFFFF" style="padding:20px; position:relative; top:50px;">
                    <br><font size="3">
                    <b>Please login first, to enable this feature.</b><br /><br />
                    
                    If you don't already have a login account then we can create one for you in just a couple of minutes. Registration
                    is free and the process is quite painless (all we need is your name and email address). <i>Your details
                    will be kept private and will never be shared with any other parties.</i><br><br />
                    Click <a href="/REGISTER_NU.php">HERE</a> to regsiter.<br /><br />
                    </font>
				</td>
            </tr>
          </table>
          </center>              			
<?php	  
		} else {
			
	
			//-------------------------------------------------------------------------------------
			// Save Name of selected COTS product (if applicable)
			//-------------------------------------------------------------------------------------			
			$URL_Link = "/index.php?p=".$_GET['p'];
			$msg = "";

			// set booking display mode (set to 'L' if admin tab has been selected, to list provisional bookings)
			if ( isset($_GET['BDM']) ) {
				$_SESSION['BookingDisplayMode'] = $_GET['BDM'];
			}
			if (! isset($_SESSION['BookingDisplayMode'])) {
				$_SESSION['BookingDisplayMode'] = 'B';
			}
			
			WriteToTraceLog(2, 'F', 'I_Booking.php', 'Connect to DB', '' );
	
			include($_SERVER['DOCUMENT_ROOT'].'/Connections/HORSLEYDB.php');
				  
			//--------------------------------------------------------------------------
			// Check DB connection using mysqli
			//--------------------------------------------------------------------------
			if (mysqli_connect_errno()) {
				//--------------------------------------------------------------------------------
				// Write error to Error log
				//--------------------------------------------------------------------------------
				$msgText = 'SQL Error: ' . mysqli_connect_error();  
				WriteToErrorLog('ERRC000003', 'Error connecting to DB', 'I_Booking.php', $msgText );
				exit;						  
			}
			
			//--------------------------------------------------------------------------
			// Disable autocommit
			//--------------------------------------------------------------------------
			mysqli_autocommit($HDBi,FALSE);
			
			//-------------------------------------------------------------------------
			// Set dates and variables for availability calendar
			//-------------------------------------------------------------------------
			WriteToTraceLog(2, 'F', 'I_Booking.php', 'Initialisation', '' );	
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

			if (isset($_GET['locn'])) {
				$Venue = $_GET['locn'];
			}
			if (!isset($Venue)) {
				if (isset($Template['WPT_Text1'])) {
					$Venue = intval($Template['WPT_Text1']);
				} else {
					$Venue = 1;
				}
			}
			if (! is_numeric($Venue) || $Venue == 0) {
				$Venue = 1;
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
			
			$_SESSION['B_UserEmail'] = $_SESSION['PHP_AUTH_USER'];

			WriteToTraceLog(2, 'F', 'I_Booking.php', 'Competed initialisation', '' );	

			//-------------------------------------------------------------------------------------
			// Include subroutine to process form submission
			//-------------------------------------------------------------------------------------   
			include($_SERVER['DOCUMENT_ROOT'].'/I_Booking_SUB.php');
			
			//----------------------------------------------------------------------------------------------
			// Get Bookings for selected day and location
			//---------------------------------------------------------------------------------------------- 			  
			$sql = "SELECT B_Date,B_Desc,B_EndTime,B_Locn,B_StartTime,B_Title,B_UserEmail,B_PageLink,B_Approved FROM booking WHERE B_SiteID=".$_SESSION['SiteID']." AND B_Date='".date('Y-m-d', $SelTimeStamp)."' AND B_Locn=".$Venue." ORDER BY B_StartTime";
			WriteToTraceLog(3, 'I', 'I_Booking.php', 'Get bookings','SQL: '.$sql );	
			if ($TodaysBookings = mysqli_query($HDBi, $sql) ) {
    			$TodaysBookings_count = mysqli_num_rows($TodaysBookings);
			} else {
				$TodaysBookings_count = 0;
			}

			//----------------------------------------------------------------------------------------------
			// If a specific booking has been selected, then get the details from DB 
			//---------------------------------------------------------------------------------------------- 
			if (isset($_GET['st']) && $_GET['st'] != '') {
				$sql = "SELECT * FROM booking WHERE B_SiteID=".$_SESSION['SiteID']." AND B_Date='".$_GET['Date']."' AND B_StartTime='".$_GET['st']."' AND B_Locn=".$Venue;
				WriteToTraceLog(3, 'I', 'I_Booking.php', 'Get Selected booking','SQL: '.$sql );	
				$SelectedBookings = mysqli_query($HDBi, $sql); 
				$SelectedBooking = mysqli_fetch_assoc($SelectedBookings);
			  
				if ( mysqli_error($HDBi) ) {
					  WriteToErrorLog('ERRC000003', 'Error while getting Selected Booking from database', 'I_Booking.php. SQL:'.$sql, mysqli_error($HDBi) );
				}	

				$_SESSION['BookingTitle'] = $SelectedBooking['B_Title'];
				$_SESSION['BookingDesc'] = $SelectedBooking['B_Desc'];
				$_SESSION['BookingComment'] = $SelectedBooking['B_Comment'];
				$_SESSION['BookingStartTime'] = $SelectedBooking['B_StartTime'];
				$_SESSION['BookingEndTime'] = $SelectedBooking['B_EndTime'];	
				$_SESSION['BookingLocn'] = $SelectedBooking['B_Locn'];
				$_SESSION['B_UserEmail'] = $SelectedBooking['B_UserEmail'];
			}		
			
			//----------------------------------------------------------------------------------------------
			// Get details for current booking location 
			//---------------------------------------------------------------------------------------------- 			  
			$sql = "SELECT * FROM bookable_locations WHERE BL_SiteID=".$_SESSION['SiteID'];
			WriteToTraceLog(3, 'I', 'I_Booking.php', 'Get Location Details','SQL: '.$sql );	
			$Locations = mysqli_query($HDBi, $sql); 
		  
			if ( mysqli_error($HDBi) ) {
				  WriteToErrorLog('ERRC000003', 'Error while getting location details from DB', 'I_Booking.php. SQL:'.$sql, mysqli_error($HDBi) );
			}
			
			//----------------------------------------------------------------------------------------------
			// Get All User's Booking Dates for current location
			//---------------------------------------------------------------------------------------------- 			  
			$sql = "SELECT B_Date,B_RptRef  FROM booking WHERE B_SiteID=".$_SESSION['SiteID']." AND B_UserEmail='".$_SESSION['PHP_AUTH_USER']."' AND B_Locn=".$Venue." ORDER BY B_Date";
			WriteToTraceLog(3, 'I', 'I_Booking.php', 'Get User bookings','SQL: '.$sql );	
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
	
			//----------------------------------------------------------------------------------------------
			// If user is a booking administrator, then get a list of provisional bookings for this venue
			//----------------------------------------------------------------------------------------------
			$BookingGroup = 'booking' . $Venue;
			if (InGroup($BookingGroup)) {
				$sql = "SELECT * FROM booking WHERE B_SiteID=".$_SESSION['SiteID']." AND B_Locn=".$Venue ." AND B_Approved='N'";
				WriteToTraceLog(3, 'I', 'I_Booking.php', 'Get provisional bookings','SQL: '.$sql );	
				$ProvResult = mysqli_query($HDBi, $sql); 
			  
				if ( mysqli_error($HDBi) ) {
					  WriteToErrorLog('ERRC000003', 'Error while getting provisional bookings from DB', 'I_Booking.php. SQL:'.$sql, mysqli_error($HDBi) );
				}			
			}
				
			//--------------------------------------------
			// MAIN PROCESSING
			//--------------------------------------------
	?>
            <form method="post" name="formBooking" class="form">
            
            <input name="B_Date" id="B_Date" type="hidden" value="<?php echo $CDate;?>" />
            <input name="B_Locn" type="hidden" value="<?php echo $Venue;?>" />
            <input name="AcceptST" id="AcceptST" type="hidden" value="" />
            <input name="DeleteST" id="DeleteST" type="hidden" value="" />
            
			<table width="720px" height="600px" style="position:relative; top:-25px; left:-15px;">
			  <tr>
                <td width="420" valign="top" align="left">
                  <img src="/images/bg_cal_top.png" width="420" height="36" />
                </td>
				<td width="300">				
				</td>
			  </tr>
			  <tr>
				<td valign="top" style="padding-right:10px">   
                           
<!-- 			//--------------------------------------------------------------------------------------
                // Calendar
                //--------------------------------------------------------------------------------------
-->	                  				 
                  <table valign="top" width="420" height="560px" background="/images/bg_cal_middle.jpg" style="position:relative; top:-4px;">
                    <tr>
                      <td width="140" valign="top" style="padding-left:10px; padding-top:10px">
                         <span style="position:relative; font-size:12pt; font-weight:bold; left:120px; top:-9px;"> Venue: </span><br />
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
                      </td>

<!-- 				//--------------------------------------------------------------------------------------
                    // Display Calendar entries for the selected day
                    //--------------------------------------------------------------------------------------
-->	
                      <td width="260" valign="top" align="center" style="padding-left:10px; padding-right:5px; padding-top:0px"> 
						<?php
						echo '<select name="Location" size="1" style="background-color:#FFFFFF; font-size:12pt; color:#775000; margin-bottom:10px; width:220px;" onchange="OpenURL(\''.$URL_Link . '&sel=' . $PageNbr . '&d='.$SelDay. '&m='.$SelMonth. '&y='.$SelYear.'&locn=\'+this.value)">';
						while ($Location = mysqli_fetch_assoc($Locations)) {
							echo '<option value='.$Location['BL_Locn'];
							if ($Location['BL_Locn'] == $Venue) {
								echo ' selected="selected"';
							}
							echo '>'.$Location['BL_Name'].'</option>';
						}
						echo '     	</select><br>'; 
?>

                        <font size="3"><?php echo date('l jS M  Y', $SelTimeStamp);?></font><br />          
<?php
                        include($_SERVER['DOCUMENT_ROOT'].'/Calendar/I_DisplayCalendarDay.php');
?>
                        
                      </td>
                    </tr>
                    <tr>
                      <td colspan="2">&nbsp;&nbsp;&nbsp; <span style="position:relative; top:-5px">Dates that you've booked are marked with a </span><img src="/images/CalBooking.png" width="19" height="17" /></td>
                  </table>
                  <img src="/images/bg_cal_bottom.jpg" width="420" height="15" style="position:relative; top:-4px;" /> 
                </td>

<!-- 		  //--------------------------------------------------------------------------------------
              // Booking Form
              //--------------------------------------------------------------------------------------
-->		
                <td valign="top" align="left" style="position:relative; top:-16px;">
<?php
                      mysqli_data_seek($TodaysBookings,0);
                      $Booking = mysqli_fetch_row($TodaysBookings);
?>                
                    <a class="LB_tab" href="<?php echo $URL_Link . '&sel=' . $PageNbr . '&Date='.$CDate.'&locn='.$Venue.'&BDM=B';?>">
                      Booking Form
                    </a>

<!-- 		  //--------------------------------------------------------------------------------------
              // Display a provisional booking list
              //--------------------------------------------------------------------------------------
-->	
<?php				
					if ( InGroup($BookingGroup) ) {   
						echo '<a class="LG_tab" href="'.$URL_Link . '&sel=' . $PageNbr . '&Date='.$CDate.'&locn='.$Venue.'&BDM=L" >';
						echo 'Admin';
						echo '</a><br />';
					}  else { 
						echo '<br>'; 
					}
						
					if ( $_SESSION['BookingDisplayMode'] == 'L' && InGroup($BookingGroup) ) {
						echo '<table width="100%" bgcolor="#F5F5F5" style="padding:10px;" align="left" id="ProvBookings">';

							while ($ProvisionalBookings = mysqli_fetch_assoc($ProvResult)) {

							  echo '<tr bgcolor="#FFFFFF">';                           
							  echo '  <td valign="top">';
							  echo '    <a style="text-decoration:none;" href="'.$URL_Link . '&sel=' . $PageNbr . '&Date='.$ProvisionalBookings['B_Date'].'&locn='.$Venue.'">';
							  echo      $ProvisionalBookings['B_Date']."    ".$ProvisionalBookings['B_StartTime']."-".$ProvisionalBookings['B_EndTime']."   ";
							  echo 		$ProvisionalBookings['B_Title'].'<br>';
							  echo 		$ProvisionalBookings['B_UserEmail'].'<br>';
							  echo '    </a>';
  
							  echo '  </td>';
							  echo '  <td valign="middle">';
							  echo '	<a class="AcceptBooking" height="16px" title="Accept Booking" onclick="SetTextBox(\'B_Date\',\''.$ProvisionalBookings['B_Date'].'\'); SetTextBox(\'AcceptST\',\''.$ProvisionalBookings['B_StartTime'].'\'); Submit_form(\'formBooking\');">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>';						
							  echo '  </td>';
							  echo '  <td width="20" valign="middle">';
							  echo '	<a class="WasteBin" height="16px" title="Delete Booking" onclick="SetTextBox(\'B_Date\',\''.$ProvisionalBookings['B_Date'].'\'); SetTextBox(\'DeleteST\',\''.$ProvisionalBookings['B_StartTime'].'\'); Submit_form(\'formBooking\');">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>';
							  echo '  </td>';
							  echo '</tr>';
							}
						echo '</table>';
						
					} else {
					
?>
                    
<!-- 		  //--------------------------------------------------------------------------------------
              // Display the Booking Form
              //--------------------------------------------------------------------------------------
-->	
                      <table bgcolor="#E7DFD1" align="left" id="BookingForm" width="280px" class="bookingForm">
                        
<?php					if ( InGroup($BookingGroup) ) {   ?>                        
                        <tr>
                          <td style="padding:2px 8px 2px 8px;">
                          	<input id="rpt_booking" type="checkbox" onchange="ShowRptBookingForm(this.checked);" /> Repeat Booking
                          </td>
                        </tr>

    					<tr>
                          <td width="100%">
                            <table width="100%" id="rptBookingForm" style="display:none;">                     
                              <tr>
                                <td style="padding:2px 8px 2px 8px;">
                                    <label for="rpt_freq">Freq:</label>
                                    <select name="rpt_freq" size="1" onchange="ChangeBookingFreq(this.value);">
                                        <option value="D" selected="selected">Daily</option>
                                        <option value="W">Weekly</option>
                                        <option value="M">Monthly</option>
                                    </select>
                                    <label for="rpt_period">Every:</label>
                                    <select name="rpt_period" id="rpt_period" size="1" />
                                    <script language="javascript">ChangeBookingFreq('D' );</script>
                                </td>
                              </tr>
                              <tr id="SelectedDays" style="display:none;">
                                <td>
                                    <Table width="100%" height="30px">
                                      <tr>
                                        <td align="center"></td>                                    
                                        <td align="center" width="20px">Mon</td>
                                        <td align="center" width="20px">Tue</td>
                                        <td align="center" width="20px">Wed</td>
                                        <td align="center" width="20px">Thu</td>
                                        <td align="center" width="20px">Fri</td>
                                        <td align="center" width="20px">Sat</td>
                                        <td align="center" width="20px">Sun</td>
                                      </tr>                            
                                      <tr>
                                        <td>
                                           <select name="wk_nbr" id="wk_nbr" size="1" style="display:none;">
                                              <option value="1" selected="selected">1st</option>
                                              <option value="2">2nd</option>
                                              <option value="3">3rd</option>
                                              <option value="4">4th</option>
                                              <option value="5">Last</option>
                                           </select>
                                        </td>                                    
                                        <td align="center"><input name="rpt_day_mon" type="checkbox" value="" /></td>
                                        <td align="center"><input name="rpt_day_tue" type="checkbox" value="" /></td>
                                        <td align="center"><input name="rpt_day_wed" type="checkbox" value="" /></td>
                                        <td align="center"><input name="rpt_day_thu" type="checkbox" value="" /></td>
                                        <td align="center"><input name="rpt_day_fri" type="checkbox" value="" /></td>
                                        <td align="center"><input name="rpt_day_sat" type="checkbox" value="" /></td>
                                        <td align="center"><input name="rpt_day_sun" type="checkbox" value="" /></td>
                                      </tr>
                                    </Table>
                                  </td>
                                </tr>
                                <tr>
                                  <td valign="top" height="30px">
                                      <label for="rpt_from">From</label>
                                      <input type="text" id="rpt_from" name="rpt_from" size="8" value="<?php echo $CDate;?>"/>
                                      <label for="rpt_to">to</label>
                                      <input type="text" id="rpt_to" name="rpt_to"  size="8"/>
                                  </td>
                                </tr>
                              </Table>
                            </td>
                          </tr>
                          						
<?php					}?>
  
                          <tr id="BookingDate">
                            <td>
                              <label for="startDate">Date:</label>
                              <input type="text" id="startDate" name="startDate" size="8" value="<?php echo $CDate;?>"/>
                            </td>
                          </tr>         
                          
                          <tr>
                            <td valign="top">
                              <table>
                                <tr>
                                  <td align="left" valign="top" style="padding-top:5px;">
                                      Start Time:
                                      <br />
                                      <select name="B_StartTime" id="B_StartTime" size="1" style="border:none; height:25px; font-size:14px; width:70px;" onchange="SetEndTimes(this.value);">
        <?php
                                        $x=0;
                                        $h='00';
                                        while ($h < 25 ) {
                                            $m='00';
                                            while ($m < 60) {
                                                $Time=$h.':'.$m;
                                                if ( ($TodaysBookings_count > 0) && ($Time >= $Booking[4]) && ($Time < $Booking[2]) ) {
                                                    if ($Time == $Booking[4]) { 
                                                        echo '<option disabled="disabled" value="'.$Time.'">Booked</option>';
                                                    }
                                                        
                                                } else {
                                                    if ( ($x < $TodaysBookings_count) && ($Time >= $Booking[2]) ) {
                                                        $x = $x + 1;
                                                        mysqli_data_seek($TodaysBookings,$x);
                                                        $Booking = mysqli_fetch_row($TodaysBookings);
                                                    }											
                                                    if ( ($TodaysBookings_count == 0) || (($TodaysBookings_count > 0) && ($Time < $Booking[4] || $Time >= $Booking[2] || $SelectedBooking['B_StartTime'] == $Booking[4] ) ) ) {
                                                        echo '<option value="'.$Time.'"';
                                                        if ( isset($_SESSION['BookingStartTime']) ) {
                                                            if ( $_SESSION['BookingStartTime'] == $Time ) { echo ' selected="selected" '; }
                                                            echo '> '.$Time;
                                                        } else {
                                                            echo '> '.$Time;
                                                        }
                                                        echo '</option>';
                                                    } 
                                                }
                                                $m = $m + 15;
                                                if ($h == 24) {
                                                    $m = 60;
                                                }
                                            }
                                            $h = $h + 1;
                                            if ($h < 10) {
                                                $h = '0'.$h;
                                            }
                                        }
        ?>
                                      </select>
                                  </td>
                                  <td align="left" valign="top" style="padding-left:20px; padding-top:5px;">
                                      End Time:
                                      <br />
                                      <select name="B_EndTime" id="B_EndTime" size="1" style="border:none; height:25px; font-size:14px; width:70px;">                           
                                      </select>  
                                      <script language="javascript">SetEndTimes(document.getElementById('B_StartTime').value,'<?php echo $_SESSION['BookingEndTime'];?>' );</script>
                                  </td>
                                </tr>
                              </table>                                                        
                          </td>
                        </tr>
                        <tr>
                          <td>
                          	<font color="#FF0000"><?php echo $msg;?></font>
                          </td>
                        </tr>
                        

                        <tr>
                          <td valign="top">

                              Title of Event:<br />
                              <input name="B_Title" type="text" size="29" maxlength="60" style="padding:4px 4px 4px 4px; border:none; height:20px; font-size:14px; position:relative; top:5px;" value="<?php echo $_SESSION['BookingTitle'];?>"/>
                              
                              <br /><br />
                              Description:<br />									  
                              <textarea name="B_Desc" cols="27" rows="4" style="border:none; position:relative; top:5px; padding:4px 4px 4px 4px; font-size:14px"><?php echo $_SESSION['BookingDesc'];?></textarea>
                              
                              <br /><br />
                              Contact Name or Email:<br />
                              <input name="B_UserEmail" type="text" size="29" maxlength="60" style="padding:4px 4px 4px 4px; border:none; height:20px; font-size:14px; position:relative; top:5px;" value="<?php echo $_SESSION['B_UserEmail'];?>"/>
                              
                              <br /><br />
                              Comments (<i>optional</i>):<br />
                              <font size="1">If you have any special requirements, then please include them here.
                              If you'd like to book the stage (which has to be assembled manually, but is free to use when
                              booking the Village Hall) then please add a comment to this effect. 
                              </font><br />
                                     
                              <textarea name="B_Comment" cols="27" rows="4" style="border:none; position:relative; top:5px; padding:4px 4px 4px 4px; font-size:14px"><?php echo $_SESSION['BookingComment'];?></textarea>
                              
                              <br /><br /><br />
                              
                              <a style="width:260px; margin-left:5px;" class="smallbutton" onclick="Submit_form('formBooking');"> Submit New Booking Request </a>                                                   
                          </td>
                        </tr>
                      </table>
<?php				} ?>
                </td>
              </tr>
            </table>
			</form>
	<?php	
	
		//----------------------------------------------------------------------------------------------
		//  free up sql object(s)
		//----------------------------------------------------------------------------------------------
	
			mysqli_free_result($TodaysBookings);
			mysqli_free_result($AllUserBookings);
			if (isset($ProvResult)) {
				mysqli_free_result($ProvResult);
			}
			mysqli_free_result($Locations);
			mysqli_close($HDBi);
			
		}
		
		WriteToTraceLog(1, 'I', 'I_Booking.php', '', '' ); 
?>