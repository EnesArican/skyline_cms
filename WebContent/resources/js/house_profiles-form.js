/**
 * 
 */

$(document).ready(function () {
	
	// ***************************
	// Add-Update Page
	// **************************
	
	
	

	// check form submission
	
	if($("#myModal").length){
		$('#myModal').modal('show');	
	}
	
	
	$("#modalButton").click(function (){
		window.location.replace("house");
	})
	
	

	// disable HTML validation
	
	$('form').submit(function(e){
		
		//e.preventDefault();
		
		var elements = this.elements; 		// collection of form controls
		var valid = {};
		var isValid;
		var isFormValid;
		
		
		
		var i;
		
		for (i= 0; i < elements.length; i++){
			
					
			isValid = validateRequired(elements[i]) && validateTypes(elements[i]);
			
			if (!isValid){
				showErrorMessage(elements[i]);
			}else{
				removeErrorMessage(elements[i]);
			}
			valid[elements[i].id] = isValid;
		}
		
		
		for (var field in valid){
			if(!valid[field]){
				isFormValid = false;
				console.log("form aint valid");
				e.preventDefault();
				break;
			}
			isFormValid = true;
		}
		
		
		if(isFormValid){
			
			var parameters = $('form').serialize();
		/*	
			$.ajax({
				method: "POST",
				url: "saveProperty",
				data: parameters
			}).done(function(data){
				 console.log("SUCCESS: ", data);
				 window.location.replace(data);
			}).fail(function(e){
				 console.log("ERROR: ", e);
			});
			
		 */
		}
				
		
	});
	
	// check if form field is required
	function validateRequired(el){
		if(isRequired(el)){
			var valid = !isEmpty(el);	
			if(!valid){		
			setErrorMessage(el, 'Field is required');
			}
			return valid;
		}
		return true;
	}
	
	
	function validateTypes(el){
		
		if(!el.value) return true;
		
		var type = $(el).data('type')||el.getAttribute('type');
		
		if(typeof validateType[type]==='function'){
			return validateType[type](el);
		}else{
			return true;
		}
	}
	
	// check if element is required
	// returns true if element is required
	function isRequired(el){
		return ((typeof el.required === 'boolean') && el.required) ||
		(typeof el.required === 'string')
	}
	
	
	function isEmpty(el){
		return !el.value || el.value === el.placeholder;
	}
	
	//--------------------------//
	// 		Error Messages		//
	//--------------------------//
	
	function setErrorMessage(el, message){
		$(el).data('errorMessage',message);
	}
	
	function getErrorMessage(el){
		return $(el).data('errorMessage') || el.title;
	}

	function showErrorMessage(el){
		var $el = $(el);
		var errorContainer = setErrorContainer(el);
				
		if (!errorContainer.length){
			$(el).parent().addClass('has-error');
			
			 if($el.parent('.input-group').length) {
				 errorContainer = $('<p class="help-block"></p>').insertAfter($el.parent());					
			 }else{
				 errorContainer = $('<p class="help-block"></p>').insertAfter($el);
			 }
			
		}
		errorContainer.text(getErrorMessage(el));
		
	}
	
	function removeErrorMessage(el){
		var $el = $(el);
		var errorContainer = setErrorContainer(el);
		 
		$(el).parent().removeClass('has-error');
		errorContainer.remove();
	}

	//--------------------------//
	// 		Type Validation  	//
	//--------------------------//
	
	
	var validateType = {
			email : function (el){
				var valid = /[^@]+@[^@]+/.test(el.value);
				if(!valid){setErrorMessage(el,'Please enter a valid email');}
				return valid;
			},
			
			number : function (el){
				var valid = /^\d+$/.test(el.value);
				if(!valid){setErrorMessage(el,'Please enter a valid number');}
				return valid;	
			},
			
			date : function (el){}						
	}
	
	
	
	// custom function
	function setErrorContainer(el){
		var $el = $(el);
		
		 if($el.parent('.input-group').length) {
			return $el.parent().siblings('.help-block');
		 }else{
			 return $el.siblings('.help-block');
		 }
	}
	
	
	
});




























