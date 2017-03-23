$(document).ready(function() {
	
	/* Hide work-experience divs and show them if user presses the add button*/
	$('.work-experience').hide();
	$('#work-experience-0').show();
	$('.add-work-experience-btn').click(function() {
		var nextDivId = parseInt(this.id.replace('add-workExp-',''))+1;
		$('#'+this.id).hide();
		$('#work-experience-'+nextDivId).show(300);
	});

	/* Hide educations divs and show them if user presses the add button*/
	$('.education').hide();
	$('#education-0').show();
	$('.add-education-btn').click(function() {
		var nextDivId = parseInt(this.id.replace('add-education-',''))+1;
		$('#'+this.id).hide();
		$('#education-'+nextDivId).show(300);
	});
	
	$('.language').hide();
	$('#language-0').show();
	$('.add-language-btn').click(function(){
		var nextDivId =  parseInt(this.id.replace('add-language-',''))+1;
		$('#'+this.id).hide();
		$('#language-'+nextDivId).show(300);
	}); 
	

	$( ".datepicker" ).datepicker({
		dateFormat: 'dd-mm-yy' 
	});
}); 

function validateJobApplication(){
	
	return true;
	
	$("div.error").remove();
	
	var errorMsg = "";
	
	if(!$("#fname").val()){
		errorMsg = "First name must not by empty.";
		$("#fname").parent().parent().before("<div class='form-group error'><label class='control-label col-sm-12'>"+errorMsg+"</label></div>");
		$("#fname").focus();
	}
	
	if(!$("#lname").val()){
		errorMsg = "Last name must not by empty.";
		$("#lname").parent().parent().before("<div class='form-group error'><label class='control-label col-sm-12'>"+errorMsg+"</label></div>");
	}
	
	if(!isValidEmailAddress($("#email").val())){
		errorMsg = "Not valid email address";
		$("#email").parent().parent().before("<div class='form-group error'><label class='control-label col-sm-12'>"+errorMsg+"</label></div>");
	}
	
	if(!isValidPhone($("#phone").val())){
		errorMsg = "Not valid phone";
		$("#phone").parent().parent().before("<div class='form-group error'><label class='control-label col-sm-12'>"+errorMsg+"</label></div>");
	}
	
	// replace commas with dot in degree grade
	$(".degree-grade").each(function() {
		 var newValue = $(this).val().replace(',','.'); 
		 $(this).val(newValue);
	});
	
	return false;
}

function isValidEmailAddress(emailAddress) {
    var pattern = /^([a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+(\.[a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+)*|"((([ \t]*\r\n)?[ \t]+)?([\x01-\x08\x0b\x0c\x0e-\x1f\x7f\x21\x23-\x5b\x5d-\x7e\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|\\[\x01-\x09\x0b\x0c\x0d-\x7f\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))*(([ \t]*\r\n)?[ \t]+)?")@(([a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.)+([a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.?$/i;
    return pattern.test(emailAddress);
};

function isValidPhone(phone){
	if (/^\d{6}$/.test(phone)) 
	   return true;
	else
	    return false;
}