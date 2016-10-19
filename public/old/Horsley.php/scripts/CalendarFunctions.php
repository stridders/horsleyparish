<?php
//----------------------------------------------------------------------------------------------
// FUNCTION:	DisplayMonthDDList
// DESCRIPTION: Displays a drop-down list to select months Jan-Dec
//----------------------------------------------------------------------------------------------
function DisplayMonthDDList($Day,$Month,$Year,$URL,$NbrTabs,$TabName) {
	echo '<select name="m" title="Skip to month" onchange="OpenURL(this.options[this.selectedIndex].value)" style="vertical-align:top; font-size:12px; width:50px; border:none; color:#333">';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=1&y=' . $Year .'"'; if ($Month == 1) echo "selected=selected"; echo '>Jan</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=2&y=' . $Year .'"'; if ($Month == 2) echo "selected=selected"; echo '>Feb</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=3&y=' . $Year .'"'; if ($Month == 3) echo "selected=selected"; echo '>Mar</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=4&y=' . $Year .'"'; if ($Month == 4) echo "selected=selected"; echo '>Apr</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=5&y=' . $Year .'"'; if ($Month == 5) echo "selected=selected"; echo '>May</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=6&y=' . $Year .'"'; if ($Month == 6) echo "selected=selected"; echo '>Jun</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=7&y=' . $Year .'"'; if ($Month == 7) echo "selected=selected"; echo '>Jul</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=8&y=' . $Year .'"'; if ($Month == 8) echo "selected=selected"; echo '>Aug</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=9&y=' . $Year .'"'; if ($Month == 9) echo "selected=selected"; echo '>Sep</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=10&y=' . $Year .'"'; if ($Month == 10) echo "selected=selected"; echo '>Oct</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=11&y=' . $Year .'"'; if ($Month == 11) echo "selected=selected"; echo '>Nov</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=12&y=' . $Year .'"'; if ($Month == 12) echo "selected=selected"; echo '>Dec</option>';
	echo '</select>';
}

//----------------------------------------------------------------------------------------------
// FUNCTION:	DisplayYearDDList
// DESCRIPTION: Displays a drop-down list to select a year from a range
//----------------------------------------------------------------------------------------------
function DisplayYearDDList($Day,$Month,$Year,$URL,$NbrTabs,$TabName) {
	echo '<select name="y" title="Skip to year" onchange="OpenURL(this.options[this.selectedIndex].value)" style="vertical-align:top; font-size:12px; width:55px; border:none; color:#333">';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=' . $Month . '&y=' . ($Year - 5) .'">' . ($Year - 5) .'</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=' . $Month . '&y=' . ($Year - 4) .'">' . ($Year - 4) .'</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=' . $Month . '&y=' . ($Year - 3) .'">' . ($Year - 3) .'</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=' . $Month . '&y=' . ($Year - 2) .'">' . ($Year - 2) .'</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=' . $Month . '&y=' . ($Year - 1) .'">' . ($Year - 1) .'</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=' . $Month . '&y=' . ($Year) .'" selected=selected>' . ($Year) .'</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=' . $Month . '&y=' . ($Year + 1) .'">' . ($Year + 1) .'</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=' . $Month . '&y=' . ($Year + 2) .'">' . ($Year + 2) .'</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=' . $Month . '&y=' . ($Year + 3) .'">' . ($Year + 3) .'</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=' . $Month . '&y=' . ($Year + 4) .'">' . ($Year + 4) .'</option>';
	echo '<option value="' . $URL . '&d=' . $Day . '&m=' . $Month . '&y=' . ($Year + 5) .'">' . ($Year + 5) .'</option>';
	echo '</select>';
}
	
//----------------------------------------------------------------------------------------------
// FUNCTION:	DisplayWeekDDList
// DESCRIPTION: Displays a drop-down list to select a Week Number from a range
//----------------------------------------------------------------------------------------------
function DisplayWeekDDList($Week,$Day,$Month,$Year,$URL,$NbrTabs,$TabName) {
	echo '<select name="W" title="Skip to week" onchange="OpenURL(this.options[this.selectedIndex].value)" style="vertical-align:top; font-size:12px; width:45px; border:none; color:#333">';
	$x = 1 - $Week;
	do {
		$WeekDate = date_fix_date( ($Day + ($x*7)),$Month,$Year,'URL' );
		echo '<option value="' . $URL . $WeekDate .'"';
		if ($Week == ($Week + $x)) echo " selected=selected";
		echo '>' . ($Week + $x) .'</option>';		
	$x++;
	} while (($Week + $x) <= 52);
	echo '</select>';
}
?>
