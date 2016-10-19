//-------------------------------------------------------------------------------------------------
// AJAX function to update the selected ROW in the Page Editor without refreshing the page
//-------------------------------------------------------------------------------------------------
$(function() {
	$(".submit_Template_form").click(function() {
	//function AJAX_save_changes() {
		$("#flash").show();
		$("#flash").html('<span><font color="#ffffff">Loading..</font></span>');
		$.ajax({
			type: "POST",
			url: "/PageEditor/AJAX_Update_Row_SUB.php",
			data: dataString,
			cache: true,
			success: function(html){ $("#flash").hide(); }
		});
	return false;
	//}										  
	});
});
