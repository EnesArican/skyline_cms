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
	            activateButtons();
	        }
	});
	
	
	function activateButtons(){
		
		$('#update').removeClass('btn-outline');
		$('#delete').removeClass('btn-outline');
		
	}
	
});


