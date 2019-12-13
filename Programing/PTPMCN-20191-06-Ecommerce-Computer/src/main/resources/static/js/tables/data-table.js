+function($, window){

	var dataTables = {};

	dataTables.init = function() {
		$('#dt-opt').DataTable();
	};	
	window.dataTables = dataTables;

}(jQuery, window);

// initialize app
+function($) {
	dataTables.init();		
}(jQuery);
