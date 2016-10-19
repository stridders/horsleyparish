<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><!-- InstanceBegin template="/Templates/TitlePage.dwt.php" codeOutsideHTMLIsLocked="false" -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- InstanceBeginEditable name="doctitle" -->
<title>Register a New Login Account</title>
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

		session_start();
		
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
		  include($_SERVER['DOCUMENT_ROOT'].'/scripts/GenPWD.php');		// Generates a user-friendly password		 
      
          //-------------------------------------------------------------------------------------
          // If a captcha code has been submitted (i.e. the form in this page has been submitted)
		  // Then start main process loop
          //-------------------------------------------------------------------------------------
		  if (!empty($_REQUEST['captcha'])) {
			  
			  //-------------------------------------------------------------------------------------
			  // If email entries are different, then set an error message and redisplay the form
			  //-------------------------------------------------------------------------------------			  
			  $Email = GetSQLValueString($_POST['Email'], "charsonly");
			  $Email2 = GetSQLValueString($_POST['Email2'], "charsonly");
			  if ($Email != $Email2) {
				  $captcha_message = "Invalid entry: Email address entries are different";

			  //-------------------------------------------------------------------------------------
			  // else,
			  //   If the captch code entered doesn't match the one generated then set an error
			  //   message and redisplay the form
			  //-------------------------------------------------------------------------------------				  
			  } else {
			  
				  if (empty($_SESSION['captcha']) || trim(strtolower($_REQUEST['captcha'])) != $_SESSION['captcha']) {
					  $captcha_message = "Invalid captcha";
					  
				  //-------------------------------------------------------------------------------------
				  // Else (form entries are all OK) so register user:
				  //-------------------------------------------------------------------------------------					  
				  } else {
					  
					  //=========================================
					  // INSERT INTO USERS TABLE
					  //=========================================
					  //--------------------------------------------------------------------------
					  // Generate userid from 1st char of first name and first 7 chars of surname
					  //--------------------------------------------------------------------------
					  $Password = GenPWD(1,true);
					  unset($message);

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
					  
					  $SQL = sprintf("INSERT INTO users (U_SiteID,U_Email,U_FirstName,U_Surname,U_Status,U_Password) VALUES (%s,'%s','%s','%s','%s','%s')",
								 $_SESSION['SiteID'],
								 $Email,
								 GetSQLValueString($_POST['FName'], "charsonly"),
								 GetSQLValueString($_POST['SName'], "charsonly"),
								 'T',
								 $Password);
						  
					  $Result = mysqli_query($HDBi, $SQL);	
					  
					  if ( (mysqli_error($HDBi)) && (strchr(mysqli_error($HDBi),Duplicate))) {										  
						  $captcha_message = 'Email address ('.$Email.') is already registered'; 
						  mysqli_close($HDBi);
						  
					  } else {
						  
						  mysqli_close($HDBi);					  
						  
						  //=========================================
						  // SEND AN EMAIL CONFIRMATION
						  //=========================================
	
						  //------------------------------------------------------------------------------
						  // Comfigure a standard email message to confirm registration details and
						  // send email out to the new user
						  //------------------------------------------------------------------------------
						  $headers = "From: info@HorsleyParish.co.uk" . "\r\n";
						  $headers .= "MIME-Version: 1.0\r\n";
						  $headers .= "Content-Type: text/html; charset=ISO-8859-1\r\n";
						  $subject = 'New user login account at HorsleyParish.co.uk';
						  $message = $_POST['FName'] . ",<br><br>Thank you for registering with HorsleyParish.co.uk.<br> To complete the process please would you log onto the website using the following credentials:<br><br>Your username: " . $Email . "<br>Your Password:  " . $Password . "<br><br>Please note that this username and password will expire if you do not logon within 24 hours.<br><br>";
						  
						  WriteToTraceLog(3, 'I', 'EMAIL_PWD.php', 'Send registration confirmation to '.$Email,' message: '.$message );	
						  
						  mail( $Email, $subject, $message, $headers );	
?>					  
						  <table width="350" height="500px">
							<tr>
							  <td width="350" valign="top">
							  <br /><br />
							  <center>
							  <font size="4">Registration Completed Successfully </font><br /><br />
							  </center>
							  We've sent you an email with your new login ID and password. Please login using
							  these credentials to complete the process. <br />
							  Please note that if you don't login within 24 hours then your ID will expire.
							  <br /><br />
							  </td>
							</tr>
						  </table>  				  
<?php					  
					  }
 				  }
				  $request_captcha = htmlspecialchars($_REQUEST['captcha']);
			  }
			  unset($_SESSION['captcha']);

		  }


          //-------------------------------------------------------------------------------------
		  // REGISTRATION FORM:
          // Display the new user registration form, along with a computer-generated captcha 
		  // image.
          //-------------------------------------------------------------------------------------
		  
		  include($_SERVER['DOCUMENT_ROOT'].'/I_REGISTER_NU_F.php');

?>		  


<!-- InstanceEndEditable -->

            </div>      
        </div>
        
</body>
<!-- InstanceEnd --></html>

