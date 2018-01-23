/**
 * 
 */

$(document).ready(function () {
	
	// ***************************
	// Add-Update Page
	// **************************
	
	
	//get entity 
	var entity = $('#entity').val();

	// check form submission
	
	if($("#myModal").length){
		$('#myModal').modal('show');	
	}
	
	
	$("#modalButton").click(function (){
		window.location.replace(entity + "-list");
	});
	
	// show/hide  airport forms
	$('#toggle-pick-up').click(function(e){
		e.preventDefault();
		if($('#pickUpForm').length){			
			$('.pickUpFormContainer').slideToggle();
			$('#pickUpForm').detach();
		}else{
			$('.pickUpFormContainer').hide().html(pickUpForm);
			$('.pickUpFormContainer').slideToggle();
		}
	});
	
	$('#toggle-drop-off').click(function(e){
		e.preventDefault();
		if($('#dropOffForm').length){			
			$('.dropOffFormContainer').slideToggle();
			$('#dropOffForm').detach();
		}else{
			$('.dropOffFormContainer').hide().html(dropOffForm);
			$('.dropOffFormContainer').slideToggle();
		}
	});
	
	
	// date picker
	 $('.datePicker')
     .datepicker({
         format: 'dd/mm/yyyy'
     })
     .on('changeDate', function(e) {
    	 $(this).datepicker('hide');
     });
	
	// time picker
	$('.clockpicker').clockpicker({donetext: 'Done'});

	// hide aiport forms when page opens.
	var pickUpForm = $('#pickUpForm').detach();
	var dropOffForm = $('#dropOffForm').detach();
	
	
	
	// ---------------------- //
	//    Year Calendar       //
	// ---------------------- //
	
	
	
	// used variables
	var startDate;
	var currentYear = new Date().getFullYear();
	
	//initialize bootstrap year calendar
	$("#year-calendar").calendar({
		startYear: currentYear,
		//enableContextMenu: true,
        enableRangeSelection: true,
        
        clickDay: function(e) {
        	
        	if($('#start-date').val() && $('#end-date').val()){
        	}else if ($('#start-date').val()){        		
        		if(e.date >= startDate){
        			$("#end-date").removeAttr("disabled");        	
                	$("#end-date").val(e.date.toDateString());
                	$("#end-date").attr("disabled", "disabled");
                	$(e.element).addClass('selected-date'); 
        		}
        	}else{
        		$("#start-date").removeAttr("disabled");        	
            	$("#start-date").val(e.date.toDateString());
            	$("#start-date").attr("disabled", "disabled"); 
            	startDate = e.date;
            	$(e.element).addClass('selected-date');
            	 
        	}
        }
	
	 
	});
	
	// clear calendar when reset button is clicked
	$("#reset-dates").click(function (){
		$("#start-date").val("");
		$("#end-date").val("");
		$("#year-calendar td").removeClass('selected-date');
	});
	
	
	$("#selected-accomodation").change(function(){
		
		var id = $("#selected-accomodation").val();
		var year = $("#selected-year").text();
		
		var parameters = { propertyId: id, selectedYear: year};
		
		$.ajax({
			method: "GET",
			url: "GetBookedDates",
			data: parameters,
			//dataType: 'json',
		}).done(function(data){
			 console.log("SUCCESS: ", data);
			 
		}).fail(function(e){
			 console.log("ERROR: ", e);
		});
		
	});
	
		
	
	
 
	
	// ---------------------- //
	//    Form Submission     //
	// ---------------------- //
	
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
			// HTML does custom validation if type is called 'date'
			custom_date : function (el){						
				var valid = /^(\d{2}\/\d{2}\/\d{4})$/.test(el.value);
				if(!valid){setErrorMessage(el,'Please enter a valid date');}
				return valid;	
			}						
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




























