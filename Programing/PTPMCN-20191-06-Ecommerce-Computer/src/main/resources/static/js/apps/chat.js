+function($, window){
	
	var chat = {};

	chat.init = function() {

		$('.chat-app .list-media .list-item, .chat-app .chat-content .conversation-toggler').on('click', function(e) {
			$('.chat-content').toggleClass("open");
			e.preventDefault();
		});
	};	

	window.chat = chat;

}(jQuery, window);

// initialize app
+function($) {
	chat.init();		
}(jQuery);
	