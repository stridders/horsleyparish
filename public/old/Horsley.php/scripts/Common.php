<?php		  
	  //------------------------------------------------------------
	  // Set SiteID = 1 for HorsleyParish.co.uk
	  //------------------------------------------------------------
	  $_SESSION['SiteID'] = 1;
		
	  //--------------------
	  // Trace Options
	  //--------------------
	  $_SESSION['TraceIndent'] = 0;									// Indent control for trace output
	  $_SESSION['TraceEnabled'] = TRUE;								// Enable/Disable tracing
	  $_SESSION['TraceLevel'] = 3;									// Controls level of detail in Trace output
	  $_SESSION['Trace_F'] = FALSE;									// Enable trace of Functions
	  $_SESSION['Trace_LS'] = FALSE;									// Enable trace of Login pages
	  $_SESSION['Trace_I'] = FALSE;									// Enable trace of Include pages
	  
	  //---------------------
	  // Edit Options
	  //---------------------
	  if (!isset($_SESSION['edit'])) {
		  $_SESSION['edit'] = 'N';
	  }
	  
	  date_default_timezone_set('Europe/London');

//----------------------------------------------------------------------------------------------
// FUNCTION:	FailedAttempt
// DESCRIPTION: Called when either a blank user ID is entered, or no matching UID found
//  	 	 	Increments a failed login count. 
//           	If 5 invalid login attempts then display 'Access Refused' page
//				Else display login page
//----------------------------------------------------------------------------------------------
  function FailedAttempt()
  {
	  WriteToTraceLog(0, 'F', 'Common.php', 'FailedAttempt()', '');
	  unset($_SESSION['PHP_USER_AUTHORISED']);
	  if (! isset($_SESSION['PHP_ACCESS_ATTEMPTS'])) {
		$_SESSION['PHP_ACCESS_ATTEMPTS'] = 1;
		 echo '<script language="javascript">window.location.href = "/index.php?LoginRC=1"</script>';
	  } else {
		 $_SESSION['PHP_ACCESS_ATTEMPTS'] = $_SESSION['PHP_ACCESS_ATTEMPTS'] + 1;
		 
		 if ( $_SESSION['PHP_ACCESS_ATTEMPTS'] >= 5 ) {
			echo '<script language="javascript">window.location.href = "/AccessRefused.php?Err=Too many attempts"</script>';
		 } else {
			echo '<script language="javascript">window.location.href = "/index.php?LoginRC=1"</script>';
		 }
	  }
	  WriteToTraceLog(1, 'F', 'Common.php', 'FailedAttempt()', '');
	  exit;
  }

//----------------------------------------------------------------------------------------------
// FUNCTION:	AuthenticateUser
// DESCRIPTION: If user not logged in, then prompt user to login and verifiy login details.
//              Setup group membership list in system variable
//----------------------------------------------------------------------------------------------
	function AuthenticateUser()
	{
		
	  WriteToTraceLog(0, 'F', 'Common.php', 'AuthenticateUser', '');		
	  
	  if ( isset($_SESSION['PHP_USER_AUTHORISED']) and $_SESSION['PHP_USER_AUTHORISED'] == 'YES' ) {
		  return;
	  }
	  
	//----------------------------------------------------------------------------------------------
	// Enable session variables 
	//----------------------------------------------------------------------------------------------
	  unset($_SESSION['PHP_USER_AUTHORISED']);

	//----------------------------------------------------------------------------------------------
	//  If already had too many login attempts, then exit
	//----------------------------------------------------------------------------------------------
		
		if ( isset($_SESSION['PHP_ACCESS_ATTEMPTS']) and $_SESSION['PHP_ACCESS_ATTEMPTS'] >= 5 ) {
			WriteToTraceLog(2, 'F', 'Common.php', 'AuthenticateUser', 'Too many login attempt:'.$_SESSION['PHP_ACCESS_ATTEMPTS'] );
			FailedAttempt();
		}
				
	//----------------------------------------------------------------------------------------------
	//  Get login details (submitted by login page) if applicable
	//----------------------------------------------------------------------------------------------
		if (isset($_POST['pwd'])) {
		  $PWD = addslashes($_POST['pwd']);
		} 
		WriteToTraceLog(2, 'F', 'Common.php', 'AuthenticateUser', 'Verify email address entered:'.$_POST['user'] );
		if (isset($_POST['user'])) {
		  $_SESSION['PHP_AUTH_USER'] = addslashes($_POST['user']);
		  if ($_SESSION['PHP_AUTH_USER'] == "") {
			  FailedAttempt();
		  }
		}
		
	//----------------------------------------------------------------------------------------------
	//  If User ID session variable not set (e.g. blank user submitted in login screen) then
	//        display Error 401 page
	//----------------------------------------------------------------------------------------------
		if (! isset($_SESSION['PHP_AUTH_USER'])) {
			  WriteToTraceLog(2, 'F', 'Common.php', 'AuthenticateUser', 'User session name not set' );			
			  FailedAttempt();
		} else {
			  
	//----------------------------------------------------------------------------------------------
	//   Else (User not already authenticated)
	//----------------------------------------------------------------------------------------------

			  WriteToTraceLog(2, 'F', 'Common.php', 'AuthenticateUser', 'Connect to DB' );
			  include($_SERVER['DOCUMENT_ROOT'].'/Connections/HORSLEYDB.php');

			  //--------------------------------------------------------------------------
			  // Check DB connection using mysqli
			  //--------------------------------------------------------------------------
			  if (mysqli_connect_errno()) {
				  WriteToErrorLog('ERRC000001', 'Error connecting to DB', 'AuthenticateUser()', mysqli_connect_errno() );					  
			  }
			  
			  include($_SERVER['DOCUMENT_ROOT'].'/PageEditor/edit_page_SUB.php');
			  
	//----------------------------------------------------------------------------------------------
	//        Search for matching user ID in database
	//---------------------------------------------------------------------------------------------- 			  

			  $sql = "SELECT * FROM users WHERE U_SiteID=".$_SESSION['SiteID']." AND U_Email='$_SESSION[PHP_AUTH_USER]' AND U_Password='$PWD'" ;
			  WriteToTraceLog(3, 'F', 'Common.php', 'AuthenticateUser', 'Get user details: SQL='.$sql );	
			  $Result = mysqli_query($HDBi, $sql);
			  $user = mysqli_fetch_assoc($Result);
		  
			  if ( mysqli_error($HDBi) ) {
				  WriteToErrorLog('ERRC000002', 'Error while getting user details from database', 'AuthenticateUser()', mysqli_error($HDBi) );
			  }
					  
	//----------------------------------------------------------------------------------------------
	//  	  If no match found then display login screen again.
	//           After 5 invalid attempt display Access Refused page
	//----------------------------------------------------------------------------------------------
			  if (mysqli_num_rows($Result) == 0) {				  
				  WriteToTraceLog(2, 'F', 'Common.php', 'AuthenticateUser', 'No rows returned');	
				  FailedAttempt();
			  } else {
				  WriteToTraceLog(2, 'F', 'Common.php', 'AuthenticateUser', 'User match found');	

	//----------------------------------------------------------------------------------------------
	//		  Else (if match found)
	//				unset failed login count
	//				Set authorised session
	//				If temporary user, then change user status to 'active'
	//----------------------------------------------------------------------------------------------
				  unset($_SESSION['PHP_ACCESS_ATTEMPTS']);					// reset Invalid login count
				  $_SESSION['PHP_USER_AUTHORISED'] = "YES";					// Authorised for TIP access	
				  $_SESSION['PHP_USER_FIRSTNAME'] = $user['U_FirstName'];
				  $_SESSION['PHP_USER_SURNAME'] = $user['U_Surname'];
					  
				  if ($user['U_Status'] == 'T') {							// This is a newly registered user
					  
					  $SQL = "UPDATE users SET U_Status='A' WHERE U_SiteID=".$_SESSION['SiteID']." AND U_Email = '".$_SESSION[PHP_AUTH_USER]."'";
					  WriteToTraceLog(3, 'F', 'Common.php', 'AuthenticateUser - Temporary User', 'SQL:' . $SQL);	
					  $Result = mysqli_query($HDBi, $SQL);
					  mysqli_free_result($Result);
				  }
				  if ( mysqli_error($HDBi) ) {
					  WriteToErrorLog('ERRC000003', 'Error updating user status', 'AuthenticateUser()', mysqli_error($HDBi) );
				  }
	//----------------------------------------------------------------------------------------------
	//              Build up a string of groups that the user is a member of
	//----------------------------------------------------------------------------------------------				  
				  
				  $_SESSION['PHP_PSTATUS'] = 'A';							// Profile Status String
				  $_SESSION['PHP_USER_GROUPS'] = "";						// Clear out user group list

				  $sql = "SELECT * FROM user_groups WHERE UG_SiteID=".$_SESSION['SiteID']." AND UG_Email='$_SESSION[PHP_AUTH_USER]'";
				  WriteToTraceLog(3, 'F', 'Common.php', 'AuthenticateUser', 'Get user_groups. SQL:'.$sql);
				  
				  $Result = mysqli_query($HDBi, $sql);
				  $user_groups = mysqli_fetch_assoc($Result);
			  
				  if ( mysqli_error($HDBi) ) {
					  WriteToErrorLog('ERRC000003', 'Error while getting user groups from database', 'AuthenticateUser(). SQL:'.$sql, mysqli_error($HDBi) );
				  }
				  
				  do {
					    WriteToTraceLog(3, 'F', 'Common.php', 'AuthenticateUser', 'Add group:'.$user_groups['UG_GroupID'] );
						$_SESSION['PHP_USER_GROUPS'] .= $user_groups['UG_GroupID'] . " ";	// Append to user_group list
				  } while  ($user_groups = mysqli_fetch_assoc($Result));
				  $_SESSION['GroupArray'] = explode(" ",$_SESSION['PHP_USER_GROUPS']);

				  mysqli_free_result($Result);
				  mysqli_close($HDBi);				  			  
			  }
			  
		}
		WriteToTraceLog(1, 'F', 'Common.php', 'User: '.$_SESSION['PHP_AUTH_USER'], '');
		
	  }

//----------------------------------------------------------------------------------------------
// FUNCTION:	InGroup
// DESCRIPTION: Returns TRUE or FALSE, depending on whether the user is a member of the selected
//				group(s) (passed to this function)
//----------------------------------------------------------------------------------------------
    function InGroup($Groups) {
		
		WriteToTraceLog(0, 'F', 'Common.php', 'InGroup', 'Group=' . $Groups );
		
		if (!isset($_SESSION['GroupArray'])) {
			WriteToTraceLog(3, 'F', 'Common.php', 'InGroup', 'Rebuild group array' );
			if (isset($_SESSION['PHP_USER_GROUPS'])) {
				$_SESSION['GroupArray'] = explode(" ",$_SESSION['PHP_USER_GROUPS']);
				$GroupCount = count($_SESSION['GroupArray']);
			} else {
				$GroupCount = 0;
			}
		} else {
			$GroupCount = count($_SESSION['GroupArray']);
		}

		if (!isset($GroupCount)) {
			$GroupCount = 0;
		}
		
		WriteToTraceLog(3, 'F', 'Common.php', 'InGroup', 'GroupCount:'.$GroupCount );

		$i=0;
		while ($i < $GroupCount and $_SESSION['GroupArray'][$i] != "") {
			WriteToTraceLog(3, 'F', 'Common.php', 'InGroup', 'Compare '.$Groups.' with '.$_SESSION['GroupArray'][$i] );
			if ( strchr($Groups,$_SESSION['GroupArray'][$i]) or $Groups == 'ANY' or $_SESSION['GroupArray'][$i] == 'webadmin' ) { 
			  WriteToTraceLog(1, 'F', 'Common.php', 'InGroup', 'Group match found.' );
			  return (TRUE);
			}
			$i=$i+1;
		} 
		
		WriteToTraceLog(1, 'F', 'Common.php', 'InGroup', 'No match found.' );
		return (FALSE);

	}

//----------------------------------------------------------------------------------------------
// FUNCTION:	WriteToErrorLog
// DESCRIPTION: Appends a log entry to the daily error file (file name set in $_SESSION['ErrorLog']
//				at the top of this page).
//----------------------------------------------------------------------------------------------
  function WriteToErrorLog($msgID, $msgTitle, $appName, $msgText) {
	  
	  $ErrorLog = $_SERVER['DOCUMENT_ROOT'] . '/LOG/ERROR.' . date('Y M j') . '.txt' ;		// Name of error log
			  
	  echo '<table width="100%" height="100%" border="0" bgcolor="#FFFFFF" cellspacing="0" cellpadding="0" style="z-index:450; opacity:0.8; position:absolute; margin-top:0px; margin-left:0px;"><tr><td valign="middle" align="center">';
	  echo '</td></tr></table>';
	  echo '<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" style="position:absolute; margin-top:0px; margin-left:0px;"><tr><td valign="middle" align="center">';
	  
	  echo '<table width="420" height="50" style="z-index:500; border:thin; border-color:#FFFFFF; border-style:ridge" bgcolor="#F6F0F0" cellspacing="0" cellpadding="0"><tr><td align="left" width="50">&nbsp;&nbsp;&nbsp;<img src="/images/warning_triangle.gif" width="32" height="29" />';
	 
	  echo '<td align="left">&nbsp;&nbsp;&nbsp;  <font size="3"><b>Woops!</b> Just hit a problem.';
	  echo '</td></tr></table>';
	  
	  echo '<table width="420" height="160" style="z-index:500; border:thin; border-color:#FFFFFF; border-style:ridge" bgcolor="#F6F0F0" cellspacing="0" cellpadding="0"><tr><td align="left">';
	 
	  echo '&nbsp;&nbsp; Error Code: <font color="#FF0000"><i>' . $msgID . '</i></font><br>';
	  echo '</font><br>';
	  echo "&nbsp;&nbsp;&nbsp;  We've recorded the event and will investigate the cause of the problem<br>";
	  echo "&nbsp;&nbsp;&nbsp;  in due course. Meanwhile, if you'd like to try and continue then please <br>";
	  echo '&nbsp;&nbsp;&nbsp;  press the BACK button on your browser and REFRESH the page.<br><br>';
	       
	  echo '</td></tr></table>';
	  echo '</td></tr></table>';

	  $fh = fopen($ErrorLog, 'a') or die("ERRS000001: Unable to apend to trace log");
	  if (isset($_SESSION['PHP_AUTH_USER'])) {
		  $stringData = "[" . date('Y/m/j H:i:s') . "] [" . $_SESSION['PHP_AUTH_USER'] . "] [" . $msgID . "][" . $appName . "]";
	  } else {
		  $stringData = "[" . date('Y/m/j H:i:s') . "] [Public User] [" . $msgID . "][" . $appName . "]";
	  }
	  fwrite($fh, $stringData . "\n");
	  fwrite($fh, $msgTitle . "\n");
	  fwrite($fh, $msgText . "\n");
	  fwrite($fh, "___________________________________________________________________" . "\n");
	  fclose($fh);	  
	  
	  WriteToTraceLog(2, 'E', $appName , '**** ERROR ****', $msgTitle );			  			  

	  exit;
	  
  }
	
//----------------------------------------------------------------------------------------------
// FUNCTION:	WriteToTraceLog
// DESCRIPTION: Appends a log entry to the daily trace file (file name set in $_SESSION['TraceLog']
//				at the top of this page).
//----------------------------------------------------------------------------------------------
  function WriteToTraceLog($level, $service, $appName, $msgTitle, $msgText) {

		  $TraceLog = $_SERVER['DOCUMENT_ROOT'] . '/LOG/TRACE.' . date('Y_M_j') . '.txt' ;		// Name of trace log
		  
	  if ($_SESSION['TraceEnabled']) {
		  
//		  switch ($service)
//		  {
//			  case "F": 
//			  			if (!$_SESSION['Trace_F']) return;
//						break;
//			  case "LS": 
//			  			if (!$_SESSION['Trace_LS']) return;
//			  			break;
//			  case "I": 
//			  			if (!$_SESSION['Trace_I']) return;
//						break;
//		  }
		  
		  if (isset($_SESSION['PHP_AUTH_USER'])) {
			  $UserName = $_SESSION['PHP_AUTH_USER'];
		  } else {
			  $UserName = "UNKNOWN";
		  }
		  $indent = '                    ';
		  if (!isset($_SESSION['trc_indent'])) $_SESSION['trc_indent'] = 0;
		  		  
		  if (! $fh = fopen($TraceLog, 'a')) return;
		  $stringData = "[" . $UserName . "][" . date('H:i:s') . "]";
		  fwrite($fh, $stringData);
		  
		  if ($level == 0) {
			  if ($_SESSION['TraceLevel'] > 0) $_SESSION['trc_indent'] += 2;
			  if ($appName == 'index.php') $_SESSION['trc_indent'] = 0; // reset indent if start of main index page
			  $stringData = substr($indent,0,$_SESSION['trc_indent']) . '[' . $appName . "][START]" . $msgTitle . "." . $msgText . "";
		  }  else {
			  if ($_SESSION['TraceLevel'] > 0 && $level == 1) {
				  $stringData = substr($indent,0,$_SESSION['trc_indent']) . '[' . $appName . "][ END ]" . $msgTitle . "." . $msgText . "";
				  $_SESSION['trc_indent'] -= 2;
			  } else {
				  if ( $_SESSION['TraceLevel'] > 1 ) { 
					  $stringData = substr($indent,0,$_SESSION['trc_indent']) . '[' . $appName . "]" . $msgTitle . "." . $msgText . "";
				  }
			  }
		  }
		  fwrite($fh, $stringData . "\n");
		  fclose($fh);
	  }
  }
  
//----------------------------------------------------------------------------------------------
// FUNCTION:	DisplayMenuOption
// DESCRIPTION: Displays a menu item using the input parms provided. If the current URL page 
//				options match this function's input parms then the menu item is highlighted.
//----------------------------------------------------------------------------------------------

  function DisplayMenuOption($sel, $action, $MiscParms, $WP_Group, $Desc) {
		WriteToTraceLog(0, 'F', 'Common.php', 'DisplayMenuOption', '(' . $sel . ')(' . $action . ')(' . $MiscParms . ')(' . $WP_Group . ')(' . $Desc . ')' );
		echo '<a ';
		if ( ( $sel == $_GET['sel'] ) and ( ! isset($action) or ($action == $_GET['action']) ) ) {
		  	echo 'style="font-weight: bold" ';
		}
		echo 'href="' . $_SESSION['PHP_USER_TYPE'] . 'php?sel=' . $sel;
		if ( $action != "" ) echo '&action=' . $action;
		echo $MiscParms . '" title="' . $Desc . '">' . $WP_Group . '</a><br />';
		WriteToTraceLog(1, 'F', 'Common.php', 'DisplayMenuOption', '' );
  }


  
//----------------------------------------------------------------------------------------------
// FUNCTION:	GetSQLValueString
// DESCRIPTION: Formats form values into a format suitable for DB inserts/updates
//----------------------------------------------------------------------------------------------

  function GetSQLValueString($theValue, $theType, $theDefinedValue = "", $theNotDefinedValue = "")  {

		if (PHP_VERSION < 6) {
		  $theValue = get_magic_quotes_gpc() ? stripslashes($theValue) : $theValue;
		}
		//str_replace("'", "%27", $theValue);
		//$theValue = mysql_escape_string($theValue);	 
		//$theValue = function_exists("mysql_real_escape_string") ? mysql_real_escape_string($theValue) : mysql_escape_string($theValue);	  
	    //$theValue = json_encode($theValue);
		
		switch ($theType) {
		  case "RTEtext":
		    $theValue = json_encode($theValue);	
		  break;  
		  case "text":
			$theValue = ($theValue != "") ? "'" . $theValue . "'" : "NULL";
			$theValue = htmlspecialchars($theValue);
		  break;   
		  case "charsonly":
			$theValue = ($theValue != "") ? $theValue : "NULL";
			$theValue = htmlspecialchars($theValue);
		  break; 		  
		  case "long":
		  case "int":
			$theValue = ($theValue != "") ? intval($theValue) : "NULL";
			break;
		  case "double":
			$theValue = ($theValue != "") ? doubleval($theValue) : "NULL";
			break;
		  case "date":
			$theValue = ($theValue != "") ? "'" . $theValue . "'" : "NULL";
			break;
		  case "checkbox":
			if ($theValue != NULL) {
				$theValue = 1;
			} else {
				$theValue = 0;
			}
			break;
		  case "defined":
			$theValue = ($theValue != "") ? $theDefinedValue : $theNotDefinedValue;
			break;
		}
		
		return $theValue;
   }

?>

