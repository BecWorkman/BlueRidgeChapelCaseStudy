/**
 * This JavaScript file validate the contact form  
 */
 
 
function validateContactForm(){
	
	 if(document.contact_form.name.value ==""){
		 alert("Please enter your full name");
		 document.contact_form.name.focus();
		 return false;
		 
	 }else{
		 var UNAME = document.getElementById("name").value;
		
	 }
	 
	 if(document.contact_form.email.value == ""){
		alert("Please enter your email address");
		 document.contact_form.email.focus();
		 return false;
	 }
	 
	 if(document.contact_form.email.value !=""){
		 if(validateContactEmail() == true){
		 	var UEMAIL = document.getElementById("email").value;
		 }else{
			alert("Please enter valid email address");
		 	document.contact_form.email.focus();
		 	return false;
	 	 }
	 }
	 
	 if(document.getElementById("message").value == ""){
		 alert("Please enter your message");
		 document.contact_form.message.focus();
		 return false;
	 }else{
		 var UMESSAGE = document.getElementById("message").value;
	 }
	 
	 if(UNAME != "" && UEMAIL != "" && UMESSAGE !=""){
		 var element = document.getElementById("contact-success-alert");
  		 element.classList.remove("hidden");
			return false;
	 }else{
		 var element = document.getElementById("contact-error-alert");
  		 element.classList.remove("hidden");
  		 return false;
	 }
	 
	 
 };
 
 
 
function validateContactEmail(){
	let index_pass = true;
	var emailId = document.contact_form.email.value;
	atpos = emailId.indexOf("@");
	dotpos = emailId.lastIndexOf(".");
	
	if(atpos < 1 || (dotpos - atpos < 2)){
		index_pass = false;
	}
	
	let email_pass = true;
	let email_regex = /^[a-zA-Z0-9.!#$%&‘+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)$/;
	if(!email_regex.test(emailId)){
		email_pass = false;
	}
	
	if(index_pass && email_pass){
		return true;
	}else{
		return false;
	}
}






