<?php 
//================================================================================================
//
//  Incude:  		Calendar.php                                                          
//  Description:	Presents a form for user to select booking dates from calendar
//
//================================================================================================
		WriteToTraceLog(0, 'I', 'Calendar.php', '', '' ); 

		$FirstDayInMonth =  date('N',mktime(0,0,0,$LoopMonth,1,$LoopYear) );// First Day of the selected month (1-7)
		$LoopTimeStamp = mktime(0,0,0,$LoopMonth,$SelDay,$LoopYear);		// Save selected date in timestamp format
		$DaysInMonth = date('t',$LoopTimeStamp);							// Number of days in the selected month (1-31)
	
		$Day = 1;
		$LoopDay = 1;
		$LoopWeek = 1;	
		$DayClass = "OutsideMonth";											// Assume 1st date in calendar is in previous month.
?>        
            	
			  <table width="100%" class="CalDayTitle">
                <tr>
                  <td class="arrowLEFT" width="40">
                      <a onclick="OpenURL('<?php echo $URL_Link . '&sel=' . $PageNbr . $PDate . '&locn=' . $Venue;?>')" title="Previous month">&nbsp;&nbsp;&nbsp;</a>	
                  </td>
                
                  <td align="center">
                      <font size="2" color="#666666">
                          <?php echo date('M',$LoopTimeStamp) . " " . $LoopYear; ?>
                      </font>
                  </td>		
                  <td class="arrowRIGHT" width="40">
                      <a onclick="OpenURL('<?php echo $URL_Link . '&sel=' . $PageNbr . $NDate . '&locn=' . $Venue; ?>')" title="Next month">&nbsp;&nbsp;&nbsp;</a>		
                  </td>
                </tr>
              </table>

			  <table width="100%" class="CalDayTitle">	
			  	<tr>
                	<td align="center">Mon</td>
                    <td align="center">Tue</td>
                    <td align="center">Wed</td>
                    <td align="center">Thu</td>
                    <td align="center">Fri</td>
                    <td align="center">Sat</td>
                    <td align="center">Sun</td>
                </tr>
<?php                	


			  do {
				  echo '<tr>';
				  do {
					  //------------------------------------------------------------
					  // If this is the first week in the month and we've just hit
					  // the end of last month, then reset the Day to '1'.
					  //-----------------------------------------------------------			
					  if ($LoopWeek == 1 and $LoopDay == $FirstDayInMonth) {	
							$Day = 1;
							$DayClass = "InsideMonth";
					  }
					  
					  //-----------------------------------------------------------
					  // If this is the selected date then highlight in blue
					  //-----------------------------------------------------------			
		  
					  echo '<td align="center" width="250px">';

					  include($_SERVER['DOCUMENT_ROOT'].'/Calendar/I_CalStandard.php');
					  
					  echo "</td>";					  
					  
		  			  if ($DayClass == "InsideMonth") {
						  $Day = $Day + 1;
						  $JDLoopDate = $JDLoopDate + 1;
					  }
		  
					  if ($LoopWeek != 1) {
					  //------------------------------------------------------------
					  // If we've just reached the end of the selected month
					  // then close down loop.
					  //-----------------------------------------------------------			
						  if ($Day > $DaysInMonth) {
							  $LoopWeek = 6;
							  $DayClass = "OutsideMonth";
						  }
					  }
					  $LoopDay++;
				  } while ($LoopDay <= 7);
				  echo '</tr>';
				  $LoopWeek++;
				  $LoopDay = 1;
			  } while ($LoopWeek <= 6);
?>    
 			  </table>            
                                       
        

		

<?php     
      	WriteToTraceLog(1, 'I', 'Calendar.php', '', '' ); 
?>
