+function($, window){
	
	var task = {};

	task.init = function() {
		
		dragula([board1, board2, board3]);
	};	

	window.task = task;

}(jQuery, window);

// initialize app
+function($) {
	task.init();		
}(jQuery);
	


