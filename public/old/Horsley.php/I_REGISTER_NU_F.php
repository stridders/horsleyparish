<?php 
//================================================================================================
//
//  Incude:  		I_REGSITER_NU_F.php                                                          
//  Description:	Prompt user to enter name and a captcha code
//
//================================================================================================

		if (!isset($message)) {
?>
          <center>
          <br /><br />
          <font size="5">Registering a new user account:</font><br /><br />
  		  <br /><br />

		  <table width="600" height="500px" border="0" cellspacing="0" cellpadding="0" style="position:relative; left:100px;">
            <tr>
              <td width="250" valign="top" align="right">
                      <font color="#FF0000"><?PHP if (isset($captcha_message)) { echo $captcha_message; } ?></font><br>                             
                      <form action="#" method="post" name="NewUser" class="form">
                          <table>
                              <tr>
                                <td class="label">First Name:</td>
                                <td><input name="FName" class="text_long" type="text" maxlength="50" value="<?php if (isset($_POST['FName'])) {echo $_POST['FName']; } ?>" /></td>
                              </tr>
                              <tr>
                                <td class="label">Surname:</td>
                                <td><input name="SName" class="text_long" type="text" maxlength="50" value="<?php if (isset($_POST['SName'])) { echo $_POST['SName']; } ?>" /></td>
                              </tr>
                              <tr>
                                <td class="label">Email Address:</td>
                                <td><input name="Email" class="text_long" type="text" maxlength="100" value="<?php if (isset($_POST['Email'])) { echo $_POST['Email']; } ?>" /></td>
                              </tr> 
                              <tr>
                                <td class="label">Confirm Email Address:</td>
                                <td><input name="Email2" class="text_long" type="text" maxlength="100" value="<?php if (isset($_POST['Email2'])) { echo $_POST['Email2']; } ?>" /></td>
                              </tr>  
                              <tr>
                                <td></td>
                                <td align="left"><img src="/Captcha/captcha.php" id="captcha" /></td>
                              </tr>            
                              <tr>
                                <td></td>
                                <td align="left">
                                      <a href="#" onclick="
                                      document.getElementById('captcha').src='/Captcha/captcha.php?'+Math.random();
                                      document.getElementById('captcha-form').focus();">Not readable? Change text.</a><br /><br />
                                </td>
                              </tr>
                              <tr>
                                <td class="label">Enter the text (as above):</td>
                                <td><input type="text" name="captcha" class="text_long" autocomplete="off" /></td>
                              </tr>            
                              <tr>
                                <td></td>
                                <td>
                                	<br />
                                    <input type="submit" />
                                	<input name="UserType" type="hidden" value="<?PHP echo $UserType; ?>" /><br /><br />
                                </td>
                              </tr>                                 
                          </table>
                      </form>
            
              </td>
              <td width="20">&nbsp;</td>
    		  <td width="330" valign="top" align="left">
				  <br />
                  You'll need a login account to make bookings on-line or to edit community web pages 
                  within this site. <br />
                  Once you've entered your details here we will email you
                  a password (which you are free to change). <br />
                  Please follow the instructions in the email to complete the registration
                  process. 
			  </td>
            </tr>
          </table>
     </center>     
<?php
		}
?>