<!--  -------------------------------------------------------------------------------------   	-->
<!--  Right Booking Pane (Slides out on mouse over event)   									-->
<!--  -------------------------------------------------------------------------------------   	-->      

    <div id="BookingMenu" class="MainPage" style="display:none">
      <div class="Help" onmouseover="DisplayObject('HelpContent')" onmouseout="HideObject('HelpContent')">
          <div id="HelpContent" style="padding:4px 10px 10px 10px; display:none">
              <font size="3" color="#FFFFFF"><b>HELP:</b> Submit a Booking Request</font><br /><br />
<?php
                if (! isset($_SESSION['PHP_AUTH_USER'])) {
?>
                  <font size="2">
                  If you'd like to submit a booking request on-line then please login first. Alternatively, you can email your
                  request to <a href="mailto:bookings@horsleyparish.co.uk">bookings@horsleyparish.co.uk</a> or call Karen on
                  01453 834696.<br /><br />
                  
                  If you don't already have a login account then we can create one for you in just a couple of minutes. Registration
                  is free and the process is quite painless (all we need is your name and email address). <i>Your details
                  will be kept private and will never be shared with any other parties.</i><br><br />
                  Click <a  href="/REGISTER_NU.php">HERE</a> to regsiter.<br /><br />
                  </font>
<?php	  
                } else {              
?>
                  <font size="2">
                    Firstly, select the appropriate venue from the menu on the left (e.g. Village Hall).<br /><br />
                    
                    Next select the appropriate date from the calendar (by clicking on it). The diary will subsequently
                    display all the current bookings for the date you selected.<br /><br />
                    
                    Then select the appropriate date in the calendar (by clicking the date) in&nbsp;a calendar on the left-hand side),</em> then use the form 		
                    to select a start and end time. Enter an event title&nbsp;and description, in the comments section you can add any special 
                    requests <em>(e.g. "Please ensure the stage is available")</em> and click the submit button.<br><br />
                    If you would prefer to make a booking request by email, then please send the relevant details to <a href="mailto:bookings@horsleyparish.co.uk">bookings@horsleyparish.co.uk</a>.&nbsp;<br>
                  </font>
<?php
				}
?>
		</div>      
      </div> 
	</div>      