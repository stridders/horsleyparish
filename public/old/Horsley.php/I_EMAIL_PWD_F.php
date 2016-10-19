<?php 
//================================================================================================
//
//  Incude:  		I_EMAIL_PWD_F.php                                                          
//  Description:	Prompt user to enter email address and a captcha code, before calling function
// 					to lookup and email password to user.
//
//================================================================================================

		if (! isset($message) ) {
?>
		  <table width="350" height="500px" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td width="100%" valign="top" align="right">

                      <center>
                      <br /><br />
                      <font size="5">Forgotten your password?<br />No Problem.</font><br />
                      <br />
                      Please enter your email address and the code you see on the screen. We will
                      then email you your password.<br />
                      </center>
                      <br />
                                    
                      <font color="#FF0000"><?PHP echo $captcha_message; ?></font><br>                             
                      <form method="post" name="ResendPwd" class="form">
                          <table>
                              <tr>
                                <td class="label">Email Address:</td>
                                <td><input name="Email" class="text_long" type="text" maxlength="100" value="<?php if (isset($_POST['Email'])) {echo $_POST['Email']; } ?>" /></td>
                              </tr> 
                              <tr>
                                <td></td>
                                <td><img src="/Captcha/captcha.php" id="captcha" /></td>
                              </tr>            
                              <tr>
                                <td></td>
                                <td>
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
                                </td>
                              </tr>                                 
                          </table>
                      </form>
              
                  </div>             
              </td>
            </tr>
          </table>  
<?php		  
		}
?>