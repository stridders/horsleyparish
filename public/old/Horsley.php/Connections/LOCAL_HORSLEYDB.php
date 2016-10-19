<?php
# FileName="Connection_php_mysql.htm"
# Type="MYSQL"
# HTTP="true"
$hostname_HORSLEYDB = "localhost";
$database_HORSLEYDB = "horsleydb";
$username_HORSLEYDB = "stridej";
$password_HORSLEYDB = "Summer99time";
$HORSLEYDB = mysql_pconnect($hostname_HORSLEYDB, $username_HORSLEYDB, $password_HORSLEYDB) or trigger_error(mysql_error(),E_USER_ERROR); 
$HDBi = mysqli_connect($hostname_HORSLEYDB, $username_HORSLEYDB, $password_HORSLEYDB, $database_HORSLEYDB);
?>