<?php
//================================================================================================
//
//  WebPage:  		I_MAIN_TITLE.php                                                         
//  Description:	Main Page header/title banner for all web pages.
//
//================================================================================================
?>
<center>
<div class="MainPage" style="height:85px; background-image:url(/images/bkgrnd_title_tr.jpg); background-repeat:no-repeat; display:inline-block;">
	<div style="position:absolute; top:50px; left:180px" align="center">
    	<img src="/images/subtitle_Horsley_arial.png" width="554" height="27" />
    </div>
	<div style="position:absolute; top:7px; left:173px">
	  <img src="/images/title_Horsley_gabriola.png" width="554" height="65" />
    </div>
    <div style="position:absolute; top: 3px; right:20px;">
    	<font color="#FFFFFF" face="Arial, Helvetica, sans-serif" size="2"><b>
			<?PHP echo date('l jS F Y'); ?> &nbsp;&nbsp; (Week: <?PHP echo date('W'); ?>)
        </b></font>
    </div>
</div>


<center>