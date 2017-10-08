/**
 * 
 */

$(document).ready(function () {
	
	
	// enable scrolling
	
	 $('#house-profiles-table').DataTable({
		
			"scrollX": true,
			"ordering": true
	});
	 
	 
	 // enable  row 'select'
	 
	 var table = $('#house-profiles-table').DataTable(); 
	 
	$('#house-profiles-table tbody').on( 'click', 'tr', function () {
	        if ( $(this).hasClass('selected') ) {
	            $(this).removeClass('selected');
	        }
	        else {
	            table.$('tr.selected').removeClass('selected');
	            $(this).addClass('selected');
	            
                
	            var id = $(this).find('td:first').text();	// get id of selected row
	            activateButtons(id);
	        }
	});
	
	
	function activateButtons(id){
		
		$('#update').removeClass('btn-outline');
		$('#delete').removeClass('btn-outline');
		
		
		// edit update and delete links variable
		// and enable modal to be displayed when delete button is clicked.
		
		$('#update').attr('href', 'formUpdateProperty?theId=' + id);
		$('#deleteModalButton').attr('href', 'formDeleteProperty?theId=' + id);
		$('#delete').attr('data-toggle', 'modal');
		
		
     
		
		
		
	}
	
	
	
	
	
	
});


