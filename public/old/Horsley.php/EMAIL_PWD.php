<?php session_start(); ?>
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
		 
		  $captcha_message = "";
      
          //-------------------------------------------------------------------------------------
          // If a captcha code has been submitted (i.e. the form in this page has been submitted)
		  // Then start main process loop
          //-------------------------------------------------------------------------------------
		  
		  if (!empty($_REQUEST['captcha'])) {
			  			  
			  if (empty($_SESSION['captcha']) || trim(strtolower($_REQUEST['captcha'])) != $_SESSION['captcha']) {
				  
				  $captcha_message = "Invalid captcha";
				  
			  //-------------------------------------------------------------------------------------
			  // Else (form entries are all OK) so register user:
			  //-------------------------------------------------------------------------------------					  
			  } else {
				  
				  include($_SERVER['DOCUMENT_ROOT'].'/Connections/HORSLEYDB.php');
				  
				  //--------------------------------------------------------------------------
				  // Check DB connection using mysqli
				  //--------------------------------------------------------------------------
				  if (mysqli_connect_errno()) {
					  WriteToErrorLog('ERRC000001', 'Error connecting to DB', 'EMAIL_PWD', mysqli_connect_errno() );					  
				  }
				  
				  //--------------------------------------------------------------------------
				  // Get user's password
				  //--------------------------------------------------------------------------
				  $EMAIL = GetSQLValueString($_POST['Email'], "charsonly");
				  $SQL = sprintf("SELECT U_Password FROM users WHERE U_SiteID=%s AND U_Email='%s'",
							 $_SESSION['SiteID'],
							 $EMAIL);
				  WriteToTraceLog(3, 'F', 'EMAIL_PWD.php', 'SQL', $SQL );
				  
				  $Result = mysqli_query($HDBi, $SQL);

				  if ( mysqli_error($HDBi) ) {
					  WriteToErrorLog('ERRC000004', 'Error getting password from user table', 'EMAIL_PWD', mysqli_error($HDBi) );
				  }
				  
				  $User = mysqli_fetch_assoc($Result);
				  $PWD = $User['U_Password'];

				  unset($message);
				  
				  if (mysqli_num_rows($Result) != 0) {
				  			
						  $headers = "From: bookings@HorsleyParish.co.uk" . "\r\n";
						  $headers .= "MIME-Version: 1.0\r\n";
						  $headers .= "Content-Type: text/html; charset=ISO-8859-1\r\n";
						  $subject = 'Password reminder';
						  $message = '<html><body>';
						  $message .= "You have requested a password reminder for your login at HorsleyParish.co.uk. <br>
									   Your login ID is your email address (".$EMAIL.") and your password is ".$PWD.".";		
						  $message .= '</table></body></html>';
						  
						  WriteToTraceLog(3, 'I', 'EMAIL_PWD.php', 'Send password reminder to '.$EMAIL,' message: '.$message );	
						  
						  mail( $EMAIL, $subject, $message, $headers );						
						
?>
                        <table width="350" height="500px">
                          <tr>
                            <td width="100%" valign="top">
                            <center>
                            <font size="4"><br /><br /><br />Your password has been emailed to you</font><br /><br />
                            </center>
                            </td>
                          </tr>
                        </table>
<?php
				  } else {
					    $captcha_message = "Invalid email address";
				  }
				  mysqli_free_result($Result);
				  mysqli_close($HDBi);
			  }
		  }
		  
		  include($_SERVER['DOCUMENT_ROOT'].'/I_EMAIL_PWD_F.php'); 

?>		  


<!-- InstanceEndEditable -->

            </div>      
        </div>
        
</body>
<!-- InstanceEnd --></html>

