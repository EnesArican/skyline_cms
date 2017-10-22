/**
 * 
 */

$(document).ready(function () {
	
	// get entity name
	var entity = $('#entity').val();	
	entity = entity.charAt(0).toUpperCase() + entity.slice(1);
	
	
	// enable scrolling
	
	 $('#template-table').DataTable({
		
			"scrollX": true,
			"ordering": true
	});
	 
	 
	 // enable  row 'select'
	 
	 var table = $('#template-table').DataTable(); 
	 
	$('#template-table tbody').on( 'click', 'tr', function () {
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
		
		
		$('#update').attr('href', 'Update' + entity + '?theId=' + id);
		$('#deleteModalButton').attr('href', 'Delete' + entity + '?theId=' + id);
		$('#delete').attr('data-toggle', 'modal');
		
		
     
		
		
		
	}
	
	
	
	
	
	
});


