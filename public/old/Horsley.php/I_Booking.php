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
            	<td valign="top" align="left" bgcolor="#FFFFCC" style="padding:20px;">
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
				$Result = mysqli_query($HDBi, $sql); 
				$SelectedBooking = mysqli_fetch_assoc($Result);
			  
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
			} else {
				if (!isset($_SESSION['BookingTitle'])) {
					$_SESSION['BookingTitle'] = "";
					$_SESSION['BookingDesc'] = "";
					$_SESSION['BookingComment'] = "";
					$_SESSION['BookingStartTime'] = "";
					$_SESSION['BookingEndTime'] = "";	
					$_SESSION['BookingLocn'] = "";
					$_SESSION['B_UserEmail'] = "";
				}
			}
			
			//----------------------------------------------------------------------------------------------
			// Get details for current booking location 
			//---------------------------------------------------------------------------------------------- 			  
			$sql = "SELECT * FROM bookable_locations WHERE BL_SiteID=".$_SESSION['SiteID']." AND BL_Locn=".$Venue;
			WriteToTraceLog(3, 'I', 'I_Booking.php', 'Get Location Details','SQL: '.$sql );	
			$Result = mysqli_query($HDBi, $sql); 
			$Location = mysqli_fetch_assoc($Result);
		  
			if ( mysqli_error($HDBi) ) {
				  WriteToErrorLog('ERRC000003', 'Error while getting location details from DB', 'I_Booking.php. SQL:'.$sql, mysqli_error($HDBi) );
			}
			
			//----------------------------------------------------------------------------------------------
			// Get All User's Booking Dates for current location
			//---------------------------------------------------------------------------------------------- 			  
			$sql = "SELECT B_Date FROM booking WHERE B_SiteID=".$_SESSION['SiteID']." AND B_UserEmail='".$_SESSION['PHP_AUTH_USER']."' AND B_Locn=".$Venue." ORDER BY B_Date";
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
            
			<table width="700px" height="600px" style="position:relative;">
			  <tr>
                <td width="420" valign="top" align="left">
                  <img src="/images/bg_cal_top.jpg" width="420" height="36" />
                </td>
				<td width="280">				
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

<!-- 		  //--------------------------------------------------------------------------------------
              // Booking Form
              //--------------------------------------------------------------------------------------
-->		
                <td valign="top" align="left">
<?php
                      mysqli_data_seek($TodaysBookings,0);
                      $Booking = mysqli_fetch_row($TodaysBookings);
?>                
                    <a class="LB_tab" href="<?php echo $URL_Link . '&sel=' . $PageNbr . '&Date='.$CDate.'&locn='.$Venue.'&BDM=B';?>">
                      Make a Booking
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
						
					if ( $_SESSION['BookingDisplayMode'] == 'L' && InGroup('booking'.$Venue) ) {
						echo '<table width="100%" bgcolor="#F5F5F5" style="padding:10px;" align="left" id="ProvBookings">';
						echo '  <tr>';
						echo '    <td colspan="3">';
						echo       $Location['BL_Name']; 
						echo '    </td>';
						echo '  </tr>';

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
                      <table bgcolor="#E7DFD1" style="padding:10px;" align="left" id="BookingForm">
                        <tr>
                          <td valign="top">
                              <font size="4"><b>
							  <?php echo $Location['BL_Name']; ?>
                              </b><br />
                              <?php echo date('l jS M  Y', $SelTimeStamp);?>
                              </font>
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
                              <input name="B_Title" type="text" size="34" maxlength="60" style="padding:4px 4px 4px 4px; border:none; height:20px; font-size:14px; position:relative; top:5px;" value="<?php echo $_SESSION['BookingTitle'];?>"/>
                              
                              <br /><br />
                              Description:<br />									  
                              <textarea name="B_Desc" cols="27" rows="4" style="border:none; position:relative; top:5px; padding:4px 4px 4px 4px; font-size:14px"><?php echo $_SESSION['BookingDesc'];?></textarea>
                              
                              <br /><br />
                              Contact Name or Email:<br />
                              <input name="B_UserEmail" type="text" size="34" maxlength="60" style="padding:4px 4px 4px 4px; border:none; height:20px; font-size:14px; position:relative; top:5px;" value="<?php echo $_SESSION['B_UserEmail'];?>"/>
                              
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
              <tr>
                <td height="17px" style="position:relative; top:-6px" valign="top"  align="left">
                	<img src="/images/bg_cal_bottom.jpg" width="420" height="15" /> 
                </td>
                <td></td>
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
			mysqli_free_result($Result);
			mysqli_close($HDBi);
			
		}
		
		WriteToTraceLog(1, 'I', 'I_Booking.php', '', '' ); 
?>