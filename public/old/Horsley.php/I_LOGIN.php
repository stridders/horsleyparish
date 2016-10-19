<?php 
//================================================================================================
//
//  Incude:  		I_LOGIN.php                                                          
//  Description:	User Login Panel		                         
//
//================================================================================================
		
		$msg = "";
		
		//----------------------------------------------------------------------------------------------
		//     If RC=1 passed to page, then no match found on previous login entry
		//----------------------------------------------------------------------------------------------

		if (isset($_GET['LoginRC'])) {
		   $URL_RC = $_GET['LoginRC'];
		   if ( $URL_RC == 1 ){
			   $msg = "Invalid user ID and/or password";
		   } else {
			  $msg = "User logged off successfully";
		   }	   
		}
		
		//------------------------------------------------------------------------------------
		// If user has entered login details, then authenticate user
		//------------------------------------------------------------------------------------
		if (isset($_POST["LoginSubmitted"])) {
			AuthenticateUser();
		} else {
			if (isset($_POST["LogOff"])) {
				WriteToTraceLog(2, 'F', 'I_LOGIN.php', 'LogOff initiated', '');
				unset($_SESSION['PHP_USER_AUTHORISED']);
				unset($_SESSION['PHP_AUTH_USER']);
				$_SESSION['edit'] = 'N';
				unset($_SESSION['PHP_USER_GROUPS']);
				unset($_SESSION['GroupArray']);
				echo '<script language="javascript">window.location.href = "/index.php"</script>';
			}
		}
	?>

        <div class="small_yellow"><?php echo  $msg;?></div>
        <div id="BlockLOGIN">
<?php
		if (isset($_SESSION['PHP_USER_AUTHORISED'])) {
?>
            <form method="post" class="form" name="Logoff">
                <table border="0" width="172px">
                  <tr>
                    <td>
                        <font color="#FFFF00" size="2">&nbsp;<?php echo $_SESSION['PHP_AUTH_USER'];?></font>
                    </td>
                  </tr>
                  <tr>
                    <td class="Small">
                        <a href="Change_pwd.php">Change your password</a><br />
                     </td>
                  </tr>                   
                  <tr>
                    <td>
                        <a style="width:40px" class="smallbutton" onclick="Submit_form('Logoff');"> Logoff </a>
                    </td>
                  </tr>                            
                </table>
                <input name="LogOff" type="hidden" value="Yes" />
            </form>
<?php			
			if ( InGroup('ANY') ) {
				
				if ( $_SESSION['edit'] == 'Y') {
					echo '<a href="/PageEditor/Publish.php?p='.$WP_Group.'" style="width:100px; margin-left:5px;" class="smallbutton" onclick="" title="Re-publish the web content that you are authorised to change and exit \'edit mode\'"> Publish </a><br>';
					if  ( InGroup('webadmin') ) {
						echo '<a style="width:100px; margin-left:5px; position:relative; top:5px;" class="smallbutton" href="/PageEditor/ChangeMenu.php" title="Insert, add, re-order or delete an item from the main menu"> Edit Main Menu </a><br>';
					}
					echo '<a style="width:100px; margin-left:5px; position:relative; top:10px;" class="smallbutton" href="/index.php?EM=N" title="Disable editing of authorised web content"> Exit Edit Mode </a>';
					
					
				} else {
					echo '<a style="width:80px; margin-left:5px; position:relative; top:5px;" class="smallbutton" href="/index.php?EM=Y" title="Enable editing of authorised web content"> Edit Mode </a>';
				}
				echo "<br>";
			}
		} else {
	
	
?>
            <form method="post" class="form" name="Login_details">
                <table border="0" cellspacing="5px" cellpadding="0">
                  <tr>
                    <td><font color="#FFFFFF" face="Arial, Helvetica, sans-serif" size="1">Login:</font></td>
                  </tr>
                  <tr>
                    <td width="160px"><input name="user" class="text_short" type="text" maxlength="100"/></td>
                  </tr>
                  <tr>
                    <td>
                        <input name="pwd" class="text_short" type="password" maxlength="12"  size="12"/>
                        &nbsp;<a style="width:40px" class="smallbutton" onclick="Submit_form('Login_details');"> Login </a>
                    </td>
                  </tr>                            
                  <tr>
                    <td class="Small">
                        <a href="/REGISTER_NU.php">Register as a New User</a><br />
                        <a href="/EMAIL_PWD.php">Forgotten your Password?</a><br />
                     </td>
                   </tr>                               
                </table>
                <input name="LoginSubmitted" type="hidden" value="Yes" />
            </form>
<?php
		}
?>
		</div>
