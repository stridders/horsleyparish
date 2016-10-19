<?php session_start(); ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/TitlePage.dwt.php" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- InstanceBeginEditable name="doctitle" -->
<title>Change log-in password</title>
<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
    <link rel="stylesheet" href="css/main.css"/>
        
    <!-- Scripts -->
    <script src="scripts/Misc.js"></script>
    <script src="scripts/jquery.min.js"></script>
    <script src="scripts/plugins.js"></script>
    <script src="scripts/sly.min.js"></script>
    <script src="scripts/horizontal.js"></script>
<!-- InstanceEndEditable -->
</head>

<body>

<?php 

		if ( isset($_GET['p']) ) {
			$WP_Group = $_GET['p'];
		} else {	
			$WP_Group = 'Home';
		}
		if ( isset($_GET['EM']) ) {
			if ( $_GET['EM'] == 'Y' ) {
				$_SESSION['edit'] = 'Y';
			} else {	
				$_SESSION['edit'] = 'N';
			}
		}
		
		$URL_Link = "/index.php?p=".$WP_Group;
		
		include($_SERVER['DOCUMENT_ROOT'].'/PAGES/'.$WP_Group.'/menu.php');
		$count = count($Selected_pages);
		
		include($_SERVER['DOCUMENT_ROOT'].'/scripts/Common.php');
		include($_SERVER['DOCUMENT_ROOT'].'/scripts/EP_scripts.php');
		
		WriteToTraceLog(0, 'P', 'index.php', 'Main Page build', '');	
		
		include($_SERVER['DOCUMENT_ROOT'].'/MAIN_menu.php');
		include($_SERVER['DOCUMENT_ROOT'].'/I_MAIN_TITLE.php'); 
		
?>	
		<div class="MainPage">
			<div class="wrap">

<!-- InstanceBeginEditable name="MenuPanes" -->
<?php
		include($_SERVER['DOCUMENT_ROOT'].'/I_MAIN_LEFT_PANE.php');
?>
<!-- InstanceEndEditable -->

<!-- InstanceBeginEditable name="Navigation" -->




<!-- InstanceEndEditable -->


<!-- InstanceBeginEditable name="body" -->
<?php
      
          //-------------------------------------------------------------------------------------
          // If the password reset form has been submitted
          //-------------------------------------------------------------------------------------
		  if (isset($_POST['password'])) {
			  
			  //-------------------------------------------------------------------------------------
			  // If passwords do not match, set error message
			  //-------------------------------------------------------------------------------------			  
			  if ($_POST['password'] != $_POST['password2']) {
				  $msg = "Passwords do not match";
			  
			  } else {
					  
					  //=========================================
					  // UPDATE USER PASSWORD in DB
					  //=========================================

					  include($_SERVER['DOCUMENT_ROOT'].'/Connections/HORSLEYDB.php');
					  
					  //--------------------------------------------------------------------------
					  // Check DB connection using mysqli
					  //--------------------------------------------------------------------------
					  if (mysqli_connect_errno()) {
						  WriteToErrorLog('ERRC000001', 'Error connecting to DB', 'EMAIL_PWD', mysqli_connect_errno() );					  
					  }
					  					  
					  //--------------------------------------------------------------------------
					  // Insert user into the users table (set U_Status to 'T' - temporary user)
					  //--------------------------------------------------------------------------

					  $SQL = sprintf("UPDATE users SET U_Password=%s WHERE U_SiteID=%s AND U_Email='%s'",
								 GetSQLValueString($_POST['password'], "text"),
								 $_SESSION['SiteID'],
								 $_SESSION['PHP_AUTH_USER']);
						  
					  WriteToTraceLog(3, 'F', 'Change_pwd.php', 'Updating user password', $SQL);	
					  
					  if (mysqli_query($HDBi, $SQL)) {
					  
						  //=========================================
						  // SEND AN EMAIL CONFIRMATION
						  //=========================================
	
						  $headers = "From: info@HorsleyParish.co.uk" . "\r\n";
						  $headers .= "MIME-Version: 1.0\r\n";
						  $headers .= "Content-Type: text/html; charset=ISO-8859-1\r\n";
						  $subject = 'Login password changed';
						  $message = '<html><body>';
						  $message .= 'We have received a request to change your login password at HorsleyParish.co.uk <br>';
						  $message .= 'If you did not make this request then please would you reply back to this email address and let us know.<br><br>';		  
						  $message .= "<table><tr>";
						  $message .= "<td>User ID:</td><td>".$_SESSION['PHP_AUTH_USER']."</td></tr>";
						  $message .= "<tr><td>Password:</td><td>".GetSQLValueString($_POST['password'], "text")."</td></tr>";
						  $message .= '</table><br>Thank-you</body></html>';
						  
						  WriteToTraceLog(2, 'I', 'I_Booking_SUB.php', 'Send confirmation email to '.$_SESSION['PHP_AUTH_USER'],' message:: '.$message );	
						  
						  mail( $_SESSION['PHP_AUTH_USER'], $subject, $message, $headers );
						  
?>					  
						  <table width="350" height="500px">
							<tr>
							  <td width="350" valign="top">
							  <br /><br />
							  <center>
							  <font size="4">Password has been changed </font><br /><br />
							  </center>
							  We've sent you an email to confirm your new password
							  <br /><br />
							  </td>
							</tr>
						  </table>  				  
<?php	
						  
					  } else {
						  $msg = mysqli_error($HDBi);
						  mysqli_close($HDBi);
						  WriteToErrorLog('ERRC000010', 'Error updating user password', 'Change_pwd.php', 'Error:'.$msg );
					  }
					  
					  mysqli_close($HDBi);
			  }
		  } 
		  
		  if ( ($msg != "") or (!isset($_POST['password'])) ) {


          //-------------------------------------------------------------------------------------
		  // Password Reset FORM:
          //-------------------------------------------------------------------------------------
?>
              <center>
              <br /><br />
              <font size="5">Change login password:</font><br /><br />
              <br /><br />
    
              <font color="#FF0000"><?PHP echo $msg; ?></font><br>                             
              <form  method="post" name="ChangePWD" class="form">
                  <table>
                      <tr>
                        <td class="label">Password:</td>
                        <td><input name="password" class="text_long" type="password" maxlength="50" value="" /></td>
                      </tr>
                      <tr>
                        <td class="label">Surname:</td>
                        <td><input name="password2" class="text_long" type="password" maxlength="50" value="" /></td>
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
              </center>
<?php
		  }
?>


<!-- InstanceEndEditable -->

            </div>      
        </div>
        
</body>
<!-- InstanceEnd --></html>

