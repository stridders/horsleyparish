
	 	var rowCount=0;
	
        //-------------------------------------------------------------------------------------------------
		// Function to submit a form
		// 
		// If the Template_Form is being submitted, call function to recalibrate text box dimensions
        //-------------------------------------------------------------------------------------------------
		function Submit_form(ObjName) {
			document.forms[ObjName].submit();	
		}
	

        //-------------------------------------------------------------------------------------------------
		// AJAX function to save page updates without refreshing the page
        //-------------------------------------------------------------------------------------------------		
		function AJAX_save_changes() {
			var formData = $("#Template_Form").serializeArray();
			var URL = "/PageEditor/AJAX_Update_Row_SUB.php";
			$("#flash").show();
			$("#flash").html('<span><font color="#ffffff">Saving..</font></span>');
			$.post(URL,
				formData,
				function(data, textStatus, jqXHR)
				{	
					$("#flash").hide();
				}).fail(function(jqXHR, textStatus, errorThrown) 
				{
					$("#flash").html('<span><font color="#ffffff">Error</font></span>');
				});	
		}
		
        //-------------------------------------------------------------------------------------------------
		// Function to submit a form and then open URL
		// 
		// If the Template_Form is being submitted, call function to recalibrate text box dimensions
        //-------------------------------------------------------------------------------------------------
		function Submit_and_Open(ObjName,URLLink) {

			document.getElementById('Template_Form').action = URLLink;
			document.forms[ObjName].submit();	
		}

        //-------------------------------------------------------------------------------------------------
		// Function to change label text in the booking form, when rpt_freq changes
        //-------------------------------------------------------------------------------------------------
		function ChangeBookingFreq(RptFreq) {
			
			obj = document.getElementById('rpt_period');
			
			for(i=document.getElementById('rpt_period').options.length-1;i>=0;i--) {
			   document.getElementById('rpt_period').remove(i);
			}
							
			switch(RptFreq) {
				case 'D':	for (i = 1; i <= 31; i++) {
							   opt = document.createElement("option");	
							   opt.value = i;
							   if (i == 1) {
									 opt.textContent = "Day";
							   } else {
							   		opt.textContent = i + " Day(s)";
							   }
							   document.getElementById('rpt_period').appendChild(opt);
							}
							document.getElementById('wk_nbr').style.display = "none";
							document.getElementById('SelectedDays').style.display = "none";
							break;
				case 'W':	for (i = 1; i <= 12; i++) {
							   opt = document.createElement("option");	
							   opt.value = i;
							   if (i == 1) {
							   		opt.textContent = "Week";
							   } else {
								   	opt.textContent = i + " Week(s)";
							   }
							   document.getElementById('rpt_period').appendChild(opt);
							}
							document.getElementById('wk_nbr').style.display = "none";
							document.getElementById('SelectedDays').style.display = "block";
							break;
				case 'M':	for (i = 1; i <= 12; i++) {
							   opt = document.createElement("option");	
							   opt.value = i;
							   if (i == 1) {
							   		opt.textContent = "Month";
							   } else {
								   	opt.textContent = i + " Month(s)";
							   }
							   document.getElementById('rpt_period').appendChild(opt);
							}
							document.getElementById('wk_nbr').style.display = "block";
							document.getElementById('SelectedDays').style.display = "block";
							break;
			}	
		}
		
        //-------------------------------------------------------------------------------------------------
		// Function to change label text in the booking form, when rpt_freq changes
        //-------------------------------------------------------------------------------------------------
		function ShowRptBookingForm(IsChecked) {
			
			if (IsChecked) {
				document.getElementById('rptBookingForm').style.display = 'block';
				document.getElementById('BookingDate').style.display = 'none';
			} else {
				document.getElementById('rptBookingForm').style.display = 'none';
				document.getElementById('BookingDate').style.display = 'block';
			}
		}
		
        //----------------------------------------------------------------------------
		// Function to display an Object
        //----------------------------------------------------------------------------
		function DisplayObject(ObjName) {
			document.getElementById(ObjName).style.display='block';
		}	

        //----------------------------------------------------------------------------
		// Function to Hide an Object
        //----------------------------------------------------------------------------
		function HideObject(ObjName) {
			document.getElementById(ObjName).style.display='none';
		}	
		
		//----------------------------------------------------------------------------
		// Function to place value of one form object into another
        //----------------------------------------------------------------------------
		function printValue(Source1,Target1) {
			var x = document.getElementById(Source1);
			var y = document.getElementById(Target1);
			y.value = x.value;
		}

		//----------------------------------------------------------------------------
		// Function to display/hide booking form and provisional booking list
        //----------------------------------------------------------------------------
		function ShowHide(Item1,Item2) {
			document.getElementById(Item1).style.display='block';
			document.getElementById(Item2).style.display='none';
		}

		//----------------------------------------------------------------------------
		// Function to change the template value in the form and submit the form.
		// Save any text edit changes, then change the template and save again
        //----------------------------------------------------------------------------			
		function ChangeTemplate(WPT_Template) {

				document.getElementById('WPT_Template').value = WPT_Template;
				DispayTemplate(WPT_Template);
				document.getElementById('HDR_TT').innerHTML = "  " + WPT_Template;
				ResizeColumns(0);
				AJAX_save_changes();
		}
		
		//----------------------------------------------------------------------------
		// Function to display the selected edit template objects and hide the others
        //----------------------------------------------------------------------------
		function DispayTemplate(TemplateType) {
			
			document.getElementById('EDIT_P1').style.display='none';
			document.getElementById('EDIT_T1').style.display='none';
			document.getElementById('EDIT_A1').style.display='none';
			document.getElementById('EDIT_AL').style.display='none';
//			document.getElementById('EDIT_C1').style.display='none';
//			document.getElementById('EDIT_B1').style.display='none';
			document.getElementById('EDIT_P2').style.display='none';
			document.getElementById('EDIT_T2').style.display='none';
			document.getElementById('TDcol2').style.display='inline-block';
			document.getElementById('EPIstats1').style.display='inline-block';
			document.getElementById('EPIstats2').style.display='inline-block';
			
			switch (TemplateType) {
				case 'TP': 	document.getElementById('EDIT_T1').style.display='inline-block'; 
							document.getElementById('EDIT_P2').style.display='inline-block'; 
							break;
				case 'TA': 	document.getElementById('EDIT_T1').style.display='inline-block'; 
				  			document.getElementById('EDIT_A2').style.display='inline-block'; 
							break;
				case 'T2': 	document.getElementById('EDIT_T1').style.display='inline-block'; 
				  			document.getElementById('EDIT_T2').style.display='inline-block'; 
							break;
				case 'T1': 	document.getElementById('EDIT_T1').style.display='inline-block'; 
							document.getElementById('EPIstats2').style.display='none';
							document.getElementById('TDcol2').style.display='none';
							break;
				case 'PT': 	document.getElementById('EDIT_P1').style.display='inline-block'; 
				  			document.getElementById('EDIT_T2').style.display='inline-block'; 
							break;
				case 'P2': 	document.getElementById('EDIT_P1').style.display='inline-block'; 
				  			document.getElementById('EDIT_P2').style.display='inline-block'; 
							break;
				case 'P1': 	document.getElementById('EDIT_P1').style.display='inline-block';
							document.getElementById('EPIstats2').style.display='none';
							document.getElementById('TDcol2').style.display='none';
							break;
//				case 'CT': 	document.getElementById('EDIT_C1').style.display='inline-block'; 
//				  			document.getElementById('EDIT_T2').style.display='inline-block'; 
//						break;
//				case 'CP': 	document.getElementById('EDIT_C1').style.display='inline-block'; 
//				  			document.getElementById('EDIT_P2').style.display='inline-block'; 
//							break;
//				case 'BC': 	document.getElementById('EDIT_B1').style.display='inline-block'; 
//							break;
				case 'AT': 	document.getElementById('EDIT_A1').style.display='inline-block'; 
				  			document.getElementById('EDIT_T2').style.display='inline-block'; 
							break;
				case 'AL': 	document.getElementById('EDIT_AL').style.display='inline-block';  
							document.getElementById('EPIstats2').style.display='none';
							document.getElementById('TDcol2').style.display='none';
							break;
			}
		}
		
		//----------------------------------------------------------------------------
		// Function to Highlight selected booking venue and grey out the others
        //----------------------------------------------------------------------------
		function HighlightVenue(Item) {
			for (i=1; i <= 3; i++) {
				ObjName = "Venue" + i;
				DiaryObjName = "Diary" + i;
				if (i == parseInt(Item)) {
					document.getElementById(ObjName).className = "";
					document.getElementById(DiaryObjName).style.display='block';
				} else {
					document.getElementById(ObjName).className = "Transparent_40";
					document.getElementById(DiaryObjName).style.display='none';
				}
			}
		}	

		//----------------------------------------------------------------------------
		// Function to select an image box in the page editor 
        //----------------------------------------------------------------------------
		function SelectEditable(ID,ObjType) {
			
			document.getElementById("EPimage1").className = "DIVNoFocus";
			document.getElementById("EPimage1").className = "DIVNoFocus";
			document.getElementById("EPpdf1").className = "DIVNoFocus";
			document.getElementById("EPpdflist").className = "DIVNoFocus";
			document.getElementById("EPtext1").className = "DIVNoFocus";
			document.getElementById("EPtext1").className = "DIVNoFocus";
			
			ObjID='EP' + ObjType + ID;
			document.getElementById('IMG_NBR').value = ID;
			document.getElementById('PDF_NBR').value = ID;
			if (document.getElementById(ObjID).className == "DIVFocus") {
				//document.getElementById(ObjID).className = "DIVNoFocus";
			} else {
				document.getElementById(ObjID).className = "DIVFocus";
			}
			if (ID == 1) {
				ObjID='EP' + ObjType + '2';
				document.getElementById('EPimage2').className = "DIVNoFocus";
			} else {
				ObjID='EP' + ObjType + '1';
				document.getElementById('EPimage1').className = "DIVNoFocus";
			}
		}
		
		//----------------------------------------------------------------------------
		// Function to set a specific form textbox value 
        //----------------------------------------------------------------------------
		function SetTextBox(ObjName,ObjValue) {
			document.getElementById(ObjName).value = ObjValue;
		}

		//----------------------------------------------------------------------------
		// Function to set a WPT_Text1 to selected values in Booking DDL  
        //----------------------------------------------------------------------------
		function BL_Changed(Obj) {
			
			var str="",i,x=0;
			
			for (i=0;i<Obj.options.length;i++) {
				if (Obj.options[i].selected) {
					((x++));
					if (x>1) {
						document.getElementById('WPT_Text1').value = document.getElementById('WPT_Text1').value + ',' + (i+1);
					} else {
						document.getElementById('WPT_Text1').value = (i+1);
					}
				}
			}
		}

		//----------------------------------------------------------------------------
		// Function to set the B_EndTime drop-down list in the Bookings form, based
		// on the selection in B_StartTime
        //----------------------------------------------------------------------------
		function SetEndTimes(StartTime,SelectedValue) {
			var ddl_start = document.getElementById('B_StartTime');
			var ddl_end = document.getElementById("B_EndTime");	
			var i;
			var x=0;

			// First clear out existing option values from DDL
			for(i=ddl_end.options.length-1;i>=0;i--)
			{
				ddl_end.remove(i);
			}
	
			// Add new options based on available times in the B_StartTime DDL
			
			for (i = 0; i < ddl_start.options.length; i++) {
			   if ( ddl_start.options[i].value > StartTime ) {
					   opt = document.createElement("option");	
					   opt.value = ddl_start.options[i].value;
					   opt.textContent = ddl_start.options[i].value;
					   ddl_end.appendChild(opt);
					   if (ddl_start.options[i].textContent == "Booked") {
					   		exit; 
					   }
					   if ( SelectedValue == ddl_start.options[i].value ) {
							ddl_end.selectedIndex = x;
					   }
					   x = x + 1;
			   }
			}

		}
	
		//----------------------------------------------------------------------------
		// Function to open a new page 
        //----------------------------------------------------------------------------		
		function OpenURL(Link) {
//			URL_Link = Link + '&' + Parm + '=' + ParmValue;
			window.location.href = Link;
			exit;
		}	

		//----------------------------------------------------------------------------
		// Function to extract URL parms 
        //----------------------------------------------------------------------------		
		function getUrlVars() {
			var vars = {};
			var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
				vars[key] = value;
			});
			return vars;
		}
		
		//----------------------------------------------------------------------------
		// Function to repositions edit template rows after a change of template or
		// object resize.
        //----------------------------------------------------------------------------		
		function RepositionRows(RowHeight) {

			var NbrRows=0,a=0,CurObj="",CurPos=0,CurHeight=0,Offset=0,i=0;
			
			NbrRows = parseInt(document.getElementById('RowCount').value);
			a = parseInt(document.getElementById('WPT_Position').value);
			Offset = document.getElementById('WPT_height_OLD').value;
			Offset = RowHeight - Offset;
							
			for (i = (a + 1); i <= NbrRows; i++) {
				CurObj = "ROW_TD" + i;
				document.getElementById(CurObj).style.top = Offset + "px";
				document.getElementById('WPT_height').value = RowHeight;
			}
		}


		//----------------------------------------------------------------------------
		// Function to Resize columns in Template Edit view 
        //----------------------------------------------------------------------------		
		function ResizeColumns(NewWidth) {
			  
			  var LeftPos=0,OrigHeight=0,OrigWidth=0,RowHeight=0,y=0,ColWidth=0;
			  
			  if ( document.getElementById('WPT_Template').value == "CT" || document.getElementById('WPT_Template').value == "CP" ) {
					return;
			  }  
			  if (NewWidth == 0) {
				  NewWidth = document.getElementById('WPT_width').value;
			  }
			  if ( document.getElementById('WPT_Template').value == "P1" || document.getElementById('WPT_Template').value == "T1" || document.getElementById('WPT_Template').value == "AL") {
				  LeftPos = (700 - NewWidth)/2;
				  document.getElementById('TDcol1').style.left = LeftPos+"px"; 
			  } else {				  
				  if ( document.getElementById('WPT_Template').value == "AT") {
					  LeftPos = 0;
					  if (NewWidth > 600) NewWidth = 600;
					  document.getElementById('TDcol1').style.left = LeftPos+"px"; 
				  } else {
					  document.getElementById('TDcol1').style.left = "0px"; 
					  if (NewWidth > 625) NewWidth = 625; 
					  if (NewWidth < 50) NewWidth = 50;
				  }
			  }
			  
			  // 1st Column
			  if ( document.getElementById('EDIT_P1').style.display == "inline-block" ) {
				  OrigHeight=parseInt(document.getElementById('EPimage1').height);
				  OrigWidth=parseInt(document.getElementById('EPimage1').width);
				  RowHeight = parseInt((OrigHeight / OrigWidth) * NewWidth);
				  document.getElementById('EPimage1').style.width=NewWidth+"px";
				  document.getElementById('EPimage1').style.height=RowHeight+"px";
			  } else {
				  if ( document.getElementById('EDIT_AL').style.display == "inline-block" ) {
					  document.getElementById('EPpdflist').style.width = NewWidth+"px";
					  RowHeight = 100;
				  } else {					  
					  if ( document.getElementById('EDIT_A1').style.display == "inline-block" ) {
						  document.getElementById('EDIT_A1').style.height == "50px";
						  RowHeight = 50;
					  } else {	
						  if ( document.getElementById('EDIT_T1').style.display == "inline-block" ) {
							  document.getElementById('EPtext1').style.width = NewWidth+"px";
							  RowHeight = document.getElementById('EPtext1').offsetHeight;
						  }
					  }
				  }
			  }
			  if (RowHeight < 40) RowHeight = 40;
			  document.getElementById('TDcol1').style.width=NewWidth+"px"; 
			  document.getElementById('TDcol1').style.height=RowHeight+"px"; 
			  document.getElementById('EPIstats1').innerHTML = 'width:' + NewWidth + '   height:' + RowHeight;
				
				
			  // 2nd Column
			  if ( document.getElementById('WPT_Template').value != "P1" && document.getElementById('WPT_Template').value != "T1" && document.getElementById('WPT_Template').value != "AL") {
				  ColWidth = 675 - parseInt(NewWidth);
				  LeftPos = parseInt(NewWidth) + 25;
				  document.getElementById('TDcol2').style.left = LeftPos + "px";
				  document.getElementById('TDcol2').style.width = ColWidth + "px";
				  //---------------------------------------------------------
				  // Determine width, height and position of 2nd column 
				  //---------------------------------------------------------
				  if ( document.getElementById('EDIT_P2').style.display == "inline-block" ) {
					  OrigHeight=parseInt(document.getElementById('EPimage2').height,10);
					  OrigWidth=parseInt(document.getElementById('EPimage2').width,10);
	
					  y = parseInt((OrigHeight / OrigWidth) * ColWidth);
					  document.getElementById('EPimage2').style.height=y+"px";
					  document.getElementById('EPimage2').style.width=ColWidth+"px";
				  } else {
					  if ( document.getElementById('EDIT_A1').style.display == "inline-block" ) {	
						  ColWidth = (670 - NewWidth);
						  if (ColWidth < 50) {
							  ColWidth = 50;
						  }
						  document.getElementById('EPtext2').style.width = ColWidth+"px";
						  document.getElementById('TDcol2').style.left = (390 - (ColWidth/2))+"px";
						  y = document.getElementById('EPtext2').offsetHeight;
					  } else {
						  if ( document.getElementById('EDIT_T2').style.display == "inline-block" ) {
							  document.getElementById('EPtext2').style.width = ColWidth+"px";
							  y = document.getElementById('EPtext2').offsetHeight;
						  }
					  }
				  }
				  if (y > RowHeight) {
					  RowHeight = y;
				  }
				  if (RowHeight < 40) RowHeight = 40;
				  
				  document.getElementById('TDcol2').style.width=ColWidth+"px"; 
				  document.getElementById('TDcol2').style.height=RowHeight+"px"; 
				  
				  document.getElementById('EPIstats2').innerHTML = 'width:' + ColWidth + '   height:' + y;
			  }
			  
			  document.getElementById('WPT_width').value = NewWidth;
			  document.getElementById('WPT_height').value = RowHeight;
				  
			  RepositionRows(RowHeight);

		}

		//--------------------------------------------------------------------------------
		// Function to post PDF file details to I_UPLOAD_IMAGE_SUB.php routine
		// when file is dragged & dropped onto a PDF icon 
        //--------------------------------------------------------------------------------		
		function sendPDFFileToServer(formData,WPT_ID,WP_Group)	
		{
			var uploadURL ="/PageEditor/AJAX_UPLOAD_FILE_SUB.php"; 
			formData.append('FileType', 'pdf');
			formData.append('ITEM_NBR', '1');
			formData.append('WPT_ID', WPT_ID);
			formData.append('MM_Save_PDF', 'save');
			formData.append('WP_Group', WP_Group);
			var jqXHR=$.ajax({
            xhr: function() {
				var xhrobj = $.ajaxSettings.xhr();
				if (xhrobj.upload) {
						xhrobj.upload.addEventListener('progress', function(event) {
							var percent = 0;
							var position = event.loaded || event.position;
							var total = event.total;
							if (event.lengthComputable) {
								percent = Math.ceil(position / total * 100);
							}
							//Set progress
							ShowProgress(percent);
						}, false);
					}
				  return xhrobj;
			  },							 
			  url: uploadURL,
			  type: "POST",
			  contentType:false,
			  processData: false,
				  cache: false,
				  data: formData,
				  success: function(data){
					  var objName = 'EPpdf' + WPT_ID;
					  document.getElementById(objName).src="/images/PDF_icon.png";
				  }
			}); 
		 
		}		
		

		//--------------------------------------------------------------------------------
		// Function to display a file upload status bar for drag/drop events 
        //--------------------------------------------------------------------------------		
		function ShowStatusbar(name,size)
		{
			$("#statusbar").show();
		 
			var sizeStr="";
			var sizeKB = size/1024;;
			
			if(parseInt(sizeKB) > 1024)
			{
				var sizeMB = sizeKB/1024;
				sizeStr = sizeMB.toFixed(2)+" MB";
			}
			else
			{
				sizeStr = sizeKB.toFixed(2)+" KB";
			}
	
			$("#filename").html(name);
			$("#filesize").html(sizeStr);
		}
			
		//--------------------------------------------------------------------------------
		// Function to hide the status bar (written as function so it can be called
		// with a settimout delay.
        //--------------------------------------------------------------------------------		
		function HideStatusBar() {
			
				$("#statusbar").hide()
		}

		//--------------------------------------------------------------------------------
		// Function to animate a status bar as file uploads
        //--------------------------------------------------------------------------------		
		function ShowProgress(progress) {
			
				var progressBarWidth = progress * $("#progressbar").width()/ 100;  
				$("#progressbar").find('div').animate({ width: progressBarWidth }, 10).html(progress + "% ");
		}

		//--------------------------------------------------------------------------------
		// Function called when PDF file is dropped onto div
        //--------------------------------------------------------------------------------		
		function handlePDFUpload(files,WPT_ID,WP_Group)
		{
		   for (var i = 0; i < files.length; i++) 
		   {
				var fd = new FormData();
				fd.append('userfile', files[i]);
				 
				ShowStatusbar(files[i].name,files[i].size);
				sendPDFFileToServer(fd,WPT_ID,WP_Group);
				window.setTimeout(HideStatusBar, 500);
		   }			
		}
		
		//--------------------------------------------------------------------------------
		// Function called when a file is dropped onto edit-page, to insert new image or PDF
        //--------------------------------------------------------------------------------		
		function InsertDroppedFile(files,Position,WPT_ID,WP_Group,WP_ID)
		{
				
		   for (var i = 0; i < files.length; i++) 
		   {
				var formData = new FormData();
				formData.append('userfile', files[i]);
		
				var uploadURL = "/PageEditor/AJAX_INSERT_DRAGGED_FILE_SUB.php"; 
				formData.append('FileType', 'pdf');
				formData.append('ITEM_NBR', '1');
				formData.append('WPT_ID', WPT_ID);
				formData.append('WP_ID', WP_ID);
				formData.append('WPT_Position',Position);
				formData.append('MM_Save_PDF', 'save');
				formData.append('WP_Group', WP_Group);
				formData.append('MM_Save_PDF','');

				var jqXHR=$.ajax({							 
				  url: uploadURL,
				  type: "POST",
				  contentType:false,
				  processData: false,
					  cache: false,
					  data: formData,
					  success: function(data){
							window.location.href = "/PageEditor/edit_page.php?p=" + WP_Group + "&WP_ID=" + WP_ID;
					  }
				}); 

		   }
		}		

