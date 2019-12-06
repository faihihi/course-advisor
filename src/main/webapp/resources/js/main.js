//function to determine if a field is blank
function isBlank(inputField){
  if(inputField.type=="checkbox"){
	   if(inputField.checked){return false;}
	    return true;
    }
    if (inputField.value==""){return true;}
  return false;
}

//Validate Unikey
function validateUnikey(){
  var unikey = document.getElementById("unikey");
  var unikeyregex = /[a-z]{4}[0-9]{4}/;
  if(unikey.value.match(unikeyregex)){
    return true;
  }
  else{
    return false;
  }
}

//Validate for strong password: must have at least 8 characters, contain at least 1 upper and 1 lower case letter and 1 number
function validatePassword(){
  var password = document.getElementById("password");
  var pwregex = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])(?=.{8,})");
  if(password.value.match(pwregex)){
    return true;
  }
  else{
    return false;
  }
}




$(document).ready(function($) {
	console.log("document readyyyy");
	
	//Authentication part: validate all fields before submitting the form
	var loginRequiredInputs = document.querySelectorAll(".loginrequired");
	$( "#loginForm" ).submit(function(e) {
		console.log("Login submitted on frontend");
	    for (var i=0; i < loginRequiredInputs.length; i++){
	      if(isBlank(loginRequiredInputs[i])){
	        e.preventDefault();
	        loginerrorresult.innerHTML = "Please input all the required fields";
	      }
//	      else if(!validateUnikey()){
//	        e.preventDefault();
//	        loginerrorresult.innerHTML = "Invalid Unikey. Please input unikey in the correct format.";
//	        return false;
//	      }
//	      else if(!validatePassword()){
//	    	  e.preventDefault();
//		        loginerrorresult.innerHTML = "Password is not in the correct format.";
//		        return false;
//	      }
		    else{
	        loginerrorresult.innerHTML = "";
	        console.log("pass!");
	        
		    }
	    }
		});
	
	$( "#regForm" ).submit(function(e) {
		console.log("Registration submitted on frontend");
	    for (var i=0; i < loginRequiredInputs.length; i++){
	      if(isBlank(loginRequiredInputs[i])){
	        e.preventDefault();
	        errorresult.innerHTML = "Please input all the required fields";
	      }
		    else{
	        errorresult.innerHTML = "";
	        console.log("pass!");        
		    }
	    }
		});
	
	$( "#feedbackForm" ).submit(function(e) {
		console.log("Feedback form submitted on frontend");
		for(var i=1;i<=10;i++){
			var radioName = "q" + i;
			if(!$("input[name='" + radioName + "']:checked").val()){
				console.log(radioName + " is not checked");
				e.preventDefault();
				errorresult.innerHTML = "Please input all the required fields";
			} else{
				console.log("pass!");
			}
		}
		});
	
	
	// Search table functions
	$(".search").keyup(function () {
	    var searchTerm = $(".search").val();
	    var listItem = $('.results tbody').children('tr');
	    var searchSplit = searchTerm.replace(/ /g, "'):containsi('")
	    
	  $.extend($.expr[':'], {'containsi': function(elem, i, match, array){
	        return (elem.textContent || elem.innerText || '').toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
	    }
	  });
	    
	  $(".results tbody tr").not(":containsi('" + searchSplit + "')").each(function(e){
	    $(this).attr('visible','false');
	  });

	  $(".results tbody tr:containsi('" + searchSplit + "')").each(function(e){
	    $(this).attr('visible','true');
	  });

	  var jobCount = $('.results tbody tr[visible="true"]').length;
	    $('.counter').text(jobCount + ' item');

	  if(jobCount == '0') {$('.no-result').show();}
	    else {$('.no-result').hide();}
			  });
	

	// Modal controls: close when close button
	$( ".close" ).click(function() {
		console.log("works");
		$("#surveyModal").css("display", "none");
		$("#surveyModal2").css("display", "none");	
		});
	
	// Modal controls: close when click outside of Modal
	window.onclick = function(event) {
		  if (event.target.id == "surveyModal") {
			  $("#surveyModal").css("display", "none");
		  }
		  if (event.target.id == "surveyModal2") {
			  $("#surveyModal2").css("display", "none");
		  }
		}
	
	  
});