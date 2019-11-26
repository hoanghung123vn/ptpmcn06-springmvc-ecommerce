+function($, window){
	
	var email = {};

	email.init = function() {

		$('.email-item, .back-to-mailbox').on('click', function(e) {
			$('.email-content').toggleClass("open");
			e.preventDefault();
		});
	
		$('#send-to').selectize({
			delimiter: ',',
			persist: false,
			create: function(input) {
				return {
					value: input,
					text: input
				}
			}
		});
	};	

	window.email = email;

}(jQuery, window);

// initialize app
+function($) {
	email.init();		
}(jQuery);
	