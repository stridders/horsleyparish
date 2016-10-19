<?php
		if (!isset($UserBookings_Row)) {
			$UserBookings_Row = 0;
		}
		while ( ($UserBookings_Row < $AllUserBookings_count) && ( $JDUserBooking < $JDLoopDate ) ) {
			$UserBookings_Row = $UserBookings_Row + 1;
			mysqli_data_seek($AllUserBookings,$UserBookings_Row);
			$UserBookings = mysqli_fetch_row($AllUserBookings);
			$JDUserBooking = gregoriantojd(substr($UserBookings[0],5,2),substr($UserBookings[0],8,2),substr($UserBookings[0],0,4));
		} 
		if ( isset($JDUserBooking) and $JDUserBooking == $JDLoopDate ) {
			$DayMatch = "SmallCalBooked";
		} else {
			$DayMatch = "";
		}
?>
      	<table class="CalDay">
          <tr>
<?php
				if ($DayClass == "OutsideMonth") {
?>
              <td class="OutsideMonth">
<?php
				} else {
					if ($JDLoopDate == $JDToday) {
						$class='CalToday';
					} else {
						if ($LoopDay >= 6) { 
							$class="WE";
						} else {
							$class="MW";
						}
					}
?>
			  <td class="<?php echo $class;?>">
<?php	
	
					$TempClass = '';
					if ($JDSel == $JDLoopDate) {
						$TempClass = 'Selected';
					}
	
					echo '<p id=\'p' . $JDLoopDate . '\' class="' . $TempClass . '">';
					echo '<a id=\'' . $JDLoopDate . '\'  class="' . $DayMatch . '" href="'.$URL_Link.'&sel='.$PageNbr.'&d='.$Day.'&m='.$LoopMonth.'&y='.$LoopYear.'&locn='.$Venue.'">' . $Day  . '</a>';									  
					echo '</p>';
	
				}
?>		
            </td>
          </tr>
        </table>


