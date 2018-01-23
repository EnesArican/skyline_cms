/**
 * 
 */

$(document).ready(function () {
	
	// ***************************
	// Add-Update Page
	// **************************
	
	//======================================================================================================//
	
	// ==================================================================================================== //
	
	
	// ------------------------ //
	//    Add Student Form      //
	// ------------------------ //
	
	
	

	// modal buttons
	//-------------------------------------------
	if($("#myModal").length){
		$('#myModal').modal('show');	
	}
	//get entity 
	var entity = $('#entity').val();
	$("#modalButton").click(function (){
		window.location.replace(entity + "-list");
	});
	//---------------------------------------------
	
	
	
	// show/hide  add accomodation
	//---------------------------------------------
	var accomodation_id;
	$('#toggle-accomodation').click(function(e){
		e.preventDefault();
		accomodation_id = propertiesCount;
		
		if($('#accomodationForm').length){			
			$('.accomodationFormContainer').slideToggle();
			$('#accomodationForm').detach();
			$('#year-calendar').detach();
		}else{
			setIdNumber(accomodation_id);
			$('#accomodation :input').prop("readonly", true);
			$("select[id*='selected-accomodation-']").prop("disabled", true);	
			$('#year-calendar').detach();
			$('.accomodationFormContainer').hide().html(accomodationForm);
			$('.accomodationFormContainer').hide().append(yearCalendar);
			$('.accomodationFormContainer').find('input').val('');
			$('.accomodationFormContainer').find('select').val('');
			
			initializeYearCalendar(null);
			$('.accomodationFormContainer').slideToggle();
		}
	});
	//---------------------------------------------
	 
	// intialize date picker & time picker
	//---------------------------------------------
	 $('.datePicker')
     .datepicker({
         format: 'dd/mm/yyyy'
     })
     .on('changeDate', function(e) {
    	 $(this).datepicker('hide');
     });
	
	$('.clockpicker').clockpicker({donetext: 'Done'});
	//----------------------------------------------
	
	
	
	// hide 'add accomodation' fields
	//----------------------------------------------
	var accomodationForm = $('#accomodationForm').detach();
	var yearCalendar = $('#year-calendar').detach();
	//-------------------------------------------------
	
	
	
	
	// ==================================================================================================== //
	
	// ---------------------- //
	//    Year Calendar       //
	// ---------------------- //
	
	
	
	// used variables
	//var startDate;
	var currentYear = new Date().getFullYear();
	
	//initialize bootstrap year calendar
	//--------------------------------------------------
	function initializeYearCalendar(year){
	$("#year-calendar").calendar({
		startYear: year == null ? currentYear : year,
        enableRangeSelection: true,
        // click function
        clickDay: function(e) {
        	removeHighlightedDates();
        	setDate(e);
        },
        style:'background',   	
	});
	}
	//--------------------------------------------------
	
	// make ajax call to find booked dates when selected year or 
	// selected property has changed.
	//--------------------------------------------------
	$(document).on('click', '.year-neighbor, .year-neighbor2', function() {
	    var year = $(this).text();
	    getBookings(year);
	});
	
	$(document).on('change', ".accomodation-select", function(){
		var year = $("#selected-year").text();
		getBookings(year);
		var id = '#property-price-' + $("#selected-accomodation-" + idNumber).find(":selected").val();
		getPropertyPrice(id);
		
	});	
	//--------------------------------------------------
	
	
	function removeHighlightedDates(){
		var data = $('#year-calendar').data('calendar').getDataSource();
		
		for(var i in data) {
			if(data[i].color == 'green'){
				data.splice(i,1);
				$('#year-calendar').data('calendar').setDataSource(data);
				break;
			} 
		 }
	}
	
	
	var idNumber;
	function setIdNumber(number){
		idNumber = number;
	}
	
	//function call (){}
	//--------------------------------------------------	
	
	// AJAX call to get bookings
	//--------------------------------------------------
	function getBookings(year){
		var id = $("#selected-accomodation-" + idNumber).val();
		var studentID = $("#id").val()
		var parameters = { propertyId: id, selectedYear: year, studentId: studentID};
		console.log(parameters);
		$.ajax({
			method: "GET",
			url: "GetBookedDates",
			data: parameters,
			//dataType: 'json',
			async: false
		}).done(function(data){
			 console.log("SUCCESS: ");
			data = JSON.parse(data);
			 
			 for(var i in data) {
				 data[i].startDate = new Date(data[i].startDate);
				 data[i].endDate = new Date(data[i].endDate);
				 data[i].color = 'salmon';
			 }
			 
			 $('#year-calendar').data('calendar').setDataSource(data);
			 console.log("godosh");
			 	 
		}).fail(function(e){
			 console.log("ERROR: ", e);
		});
		
	};
	//--------------------------------------------------
	
	// put date into format for javascript to identify the correct date
	//--------------------------------------------------
    function changeDateFormat(date){
    	dateArray = date.split('/');
    	return dateArray[1] + '/' + dateArray[0] + '/' + dateArray[2];
    }
  //--------------------------------------------------
	
	// Auto populate price and comission from selected property
  //--------------------------------------------------
	function getPropertyPrice(id){
		var pricing = $(id).text();
		
		var price = pricing.split('/')[0];
		var comission = pricing.split('/')[1];
		
		$('#price-' + accomodation_id).val(price);
		$('#comission-' + accomodation_id).val(comission);		
	};
	//--------------------------------------------------
	
	var prevFocus;
	//set previously focused element
	$("#accomodation").on('focus', "input", function() {
      prevFocus = $(this);
    });
	
	
	
	// Global selected dates key value pairs
	// stores the selected date element
	var selectedDates = [];
	
	// input date into previously focused field
	function setDate(e){
		if($('#selected-accomodation-' + idNumber).val() == null){return;}
		var id = prevFocus ? prevFocus.attr('id') : null;
		var secondElementId;
		var elementDate;
		var dataSource = $('#year-calendar').data('calendar').getDataSource();
		var isDateValid;
		
	    if(~id.indexOf("start-date")){
	    	secondElementId = "#end-date-" + idNumber;
	    	secondElementDate = new Date(changeDateFormat($(secondElementId).val()));	
	    	isDateValid = validateSelectedDates(dataSource, e.date, secondElementDate);	
	    	if ((isNaN(secondElementDate) || e.date < secondElementDate) && (isDateValid)){setSelectedDate(id, e);}	
	    }else if(~id.indexOf("end-date")){
	    	secondElementId = "#start-date-" + idNumber;
	    	secondElementDate = new Date(changeDateFormat($(secondElementId).val()));
	    	isDateValid = validateSelectedDates(dataSource, secondElementDate, e.date);
	    	if (!(isNaN(secondElementDate)) && (e.date >= secondElementDate) && (isDateValid)){	setSelectedDate(id, e);}	
	    }else{
	    	return;
	    }
	}
	
	function setSelectedDate(id, e){
		var itemIndex = selectedDates.findIndex(i => i.id == id);
		var changedDate = selectedDates[itemIndex];
		if (changedDate !== undefined){ 
			selectedDates.splice(itemIndex,1);
			$(changedDate.dateElement).removeClass('selected-date'); 
		}
		$(e.element).addClass('selected-date');
		var myDateString = ('0' + e.date.getDate()).slice(-2) + '/'
        + ('0' + (e.date.getMonth()+1)).slice(-2) + '/'
        + e.date.getFullYear();

		$('#' + id).val(myDateString);		
		var data = {}
		data.id = id;
		data.dateElement = e.element;
		
		selectedDates.push(data);
	}
	
	//check selected dates do not contain booked dates between them
	function validateSelectedDates(dataSource, startDate, endDate){
		 for(var i in dataSource) {	
 	    	if((dataSource[i].startDate.getTime() >= startDate.getTime() && dataSource[i].startDate.getTime() <= endDate.getTime())	||
 	    	   (dataSource[i].endDate.getTime() <= endDate.getTime() && dataSource[i].endDate.getTime() >= startDate.getTime()) ||
 	    	   (startDate.getTime() >= dataSource[i].startDate.getTime() && startDate.getTime() <= dataSource[i].endDate.getTime())){
 	    		return false;
 	    	}
         }
		 return true;
	}
	
	function clearDates(){
		
	}
	function displaySelectedDates(startDate, endDate){
		
		var dataSource = $('#year-calendar').data('calendar').getDataSource();
		
		console.log("neyney");
		
		console.log(dataSource);
		
		var data = {};
		 data.startDate = startDate;
		 data.endDate = endDate;
		 data.color = 'green';
		
		dataSource.push(data);
		
		$('#year-calendar').data('calendar').setDataSource(dataSource);
	}
	
	
	// Edit Accomodation
	//--------------------------------------------------------
	$("a[id*='edit-accomodation']").click(function(e){
		e.preventDefault();
		$('#accomodation :input').prop("readonly", true);
		
		
		var idNumber = $(this).attr('id').split('-')[2];
			setIdNumber(idNumber);
			
		if($('#selected-accomodation-' + idNumber).prop('disabled')){
			$('#selected-accomodation-' + idNumber).prop("disabled", false);
			$('#price-' + idNumber).prop("readonly", false);
			$('#comission-' + idNumber).prop("readonly", false);
			$('#property-row-' + idNumber).after(yearCalendar);
			
			
			var startDate = $('#start-date-' + idNumber).val().split('/');
			startDate = new Date(startDate[2],(startDate[1]-1),startDate[0]);
			var endDate = $('#end-date-' + idNumber).val().split('/');
			endDate = new Date(endDate[2],(endDate[1]-1),endDate[0]);
			
			initializeYearCalendar(startDate.getFullYear());
			getBookings(startDate.getFullYear());
			
			displaySelectedDates(startDate, endDate);
			
			
		}else{
			$('#selected-accomodation-' + idNumber).prop("disabled", true);
			$('#price-' + idNumber).prop("readonly", true);
			$('#comission-' + idNumber).prop("readonly", true);
			$('#year-calendar').detach();
		}
	});
	//--------------------------------------------------------
	
	// Delete Accomodation
	//--------------------------------------------------------
	$("a[id*='delete-accomodation']").click(function(e){
		e.preventDefault();
		
		if (window.confirm("Are you sure you want to delete this item?")){
			var idNumber = $(this).attr('id').split('-')[2];
			setIdNumber(idNumber);
			
			
			$('#property-row-' + idNumber).remove();
			
		}
	});
	
	//--------------------------------------------------------
	
	//======================================================================================================//
	
	// ==================================================================================================== //
	
	
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
			
			$("select[id*='selected-accomodation-']").prop("disabled", false);		
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
				var valid = /\d+(\.\d{1,2})?/.test(el.value);
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




























