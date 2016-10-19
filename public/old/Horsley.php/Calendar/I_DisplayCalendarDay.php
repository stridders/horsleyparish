<!---------------------------------------------------------------------------------------------->
<!--  Incude:  		I_DisplayCalendarDay.php                                                  -->
<!--  Description:	Render a 1 day calendar page                                              -->
<!---------------------------------------------------------------------------------------------->
<?php

	WriteToTraceLog(0, 'I', 'I_DisplayCalendarDay.php', '','' );	

	//----------------------------------------------------------------------------------------------
	// Get First booking for today (if row present)
	//---------------------------------------------------------------------------------------------- 			  
	$Booking_EOF = TRUE;
	if (InGroup('booking'.$Venue)) {
		$AdminUser = true;
	} else {
		$AdminUser = false;
	}

	if ( $TodaysBookings_count > 0 ) {
		$Booking_Row = 0;
		mysqli_data_seek($TodaysBookings,0);
		while ( ($Booking = mysqli_fetch_row($TodaysBookings)) && ($Booking[3] != $Venue) && ( ($Booking[8] == 'N') || ($Booking[6] != $_SESSION['PHP_AUTH_USER'])) ) {
			$Booking_Row = $Booking_Row + 1;
			mysqli_data_seek($TodaysBookings,$Booking_Row);
		}
		if ( $Booking_Row > $TodaysBookings_count ) {
			WriteToTraceLog(2, 'I', 'I_DisplayCalendarDay.php', 'No Bookings for Venue '.$Venue,'' );
		} else {
			$Booking_EOF = FALSE;
			WriteToTraceLog(2, 'I', 'I_DisplayCalendarDay.php', 'Venue:'.$Venue.'  First Booking:'.$Booking_Row.' of '.$TodaysBookings_count,'Title'.$Booking[5] );
		}
	}
?>			
    <font color="#666666" size="1">
    
	<table width="100%" height="390">
<?php
	  $hr=0;
	  while ($hr <= 24) {
		if ($hr < 10) {
			$hour = "0".$hr;
		} else {
			$hour = $hr;
		}
?>
		<tr>	
			<td valign="top" align="left" width="30px" style="padding: 2px 4px 2px 4px; border: solid thin #DDD;">
<?php            
				if ( !($Booking_EOF) && $Venue == $Booking[3] && $hr == substr($Booking[4],0,2)) {
					echo substr($Booking[4],0,5) . "<br>" . substr($Booking[2],0,5);
				} else {
					echo $hour.':00'; 
				}
?>
            </td>
			<td valign="top" align="left" style="padding-left:4px; padding-right:4px; border: solid thin #DDD;" bgcolor="#FFFFFF">
<?php		
				if ( !($Booking_EOF)  && $Venue == $Booking[3] && ( $hr >= substr($Booking[4],0,2) ) && ( $hr <= substr($Booking[2],0,2) ) ) {
				
					echo '<table width="100%"><tr><td>';
					if ( isset($_SESSION['PHP_AUTH_USER']) and ($Booking[6] == $_SESSION['PHP_AUTH_USER'] or $AdminUser)) {
						echo '<a href="'.$URL_Link . '&sel=' . $PageNbr . '&Date='.$Booking[0].'&st='.$Booking[4].'&locn='.$Booking[3].'" style="cursor:pointer; text-decoration:none"><b>';
						echo $Booking[5]."<br>";
						echo $Booking[4]." to ".$Booking[2].'<br>';
						echo 'Contact: '.$Booking[6];
						echo '</b></a>';
						if ($Booking[8] == 'N') {
							echo '<br>';
							echo '<i>This is a provisional booking and has yet to be confirmed</i>';
						}
					} else {
						if ($Booking[8] != 'N') {
							echo $Booking[5]."<br>";
						} else {
							echo "Provisional Booking<br>";
						}
						echo $Booking[4]." to ".$Booking[2].'<br>';
						echo 'Contact: '.$Booking[6];
					}
					if ($Booking[7] != '') {
						echo '<br>';
						echo '<a class="CalPageLink" href="'.$Booking[7].'"></a>';
					}
					if ($AdminUser) {
						echo '</td><td width="16" valign="top">';
						if ($Booking[8] == 'N') {
						echo '<a class="AcceptBooking" height="16px" title="Accept Booking" onclick="SetTextBox(\'AcceptST\',\''.$Booking[4].'\'); Submit_form(\'formBooking\');">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>';
						}
						echo '</td><td width="20" valign="top">';
						echo '<a class="WasteBin" height="16px"  title="Delete Booking" onclick="SetTextBox(\'DeleteST\',\''.$Booking[4].'\'); Submit_form(\'formBooking\');">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>';
					}
						
					while ($hr < substr($Booking[2],0,2)) {
						$hr = $hr + 1;						
					}
					
					echo '</td></tr></table>';
					
					if ( (substr($Booking[2],3,2) == 0) && ($hr != 24) ) {
						$hr = $hr - 1;
					}

					if ($Booking_Row < $TodaysBookings_count) {
						do {
							$Booking_Row = $Booking_Row + 1;
							mysqli_data_seek($TodaysBookings,$Booking_Row);
						} while ( ($Booking = mysqli_fetch_row($TodaysBookings)) && ($Booking[3] != $Venue) );	
						
						WriteToTraceLog(2, 'I', 'I_DisplayCalendarDay.php', 'Next Booking: '.$Booking_Row.' of '.$TodaysBookings_count, 'Title: '.$Booking[5] );
					} else {
						$Booking_EOF = TRUE;
					}
					
					if ( $hr == substr($Booking[4],0,2) ) {
						$hr = $hr - 1;
					}
				}
?>				
            </td>
          </tr>
<?php
		  $hr = $hr + 1;
	  }
?>
    </table>
    </font>
    
<?php
	WriteToTraceLog(1, 'I', 'I_DisplayCalendarDay.php', '','' );
?>