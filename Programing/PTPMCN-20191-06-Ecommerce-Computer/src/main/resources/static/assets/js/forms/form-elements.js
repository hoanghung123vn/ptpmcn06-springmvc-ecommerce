+function($, window){

	$('#selectize-dropdown').selectize({
		create: false,
		sortField: {
			field: 'text',
			direction: 'asc'
		},
		dropdownParent: 'body'
	});

	$('#selectize-tags-1').selectize({
	    delimiter: ',',
	    persist: false,
	    create: function(input) {
	        return {
	            value: input,
	            text: input
	        }
	    }
	});

	$('#selectize-tags-2').selectize({
	    delimiter: ',',
	    persist: false,
	    create: function(input) {
	        return {
	            value: input,
	            text: input
	        }
	    }
	});

	$('#selectize-group').selectize({
	    sortField: 'text'
	});

	$("#summernote-standard").summernote({
		height: 200,
		placeholder: 'Some Text Here'
	});

	$("#summernote-airmode").summernote({
		airMode: true
	});

	$("#summernote-custom").summernote({
		toolbar: [
			// [groupName, [list of button]]
			['style', ['bold', 'italic', 'underline', 'clear']],
			['font', ['strikethrough', 'superscript', 'subscript']],
			['fontsize', ['fontsize']],
			['color', ['color']],
			['para', ['ul', 'ol', 'paragraph']],
			['height', ['height']]
		],
		placeholder: 'Some Text Here',
		height: 200
	});

	$('.input-daterange input').each(function() {
		$(this).datepicker('clearDates');
	});


	var formElements = {};

	formElements.init = function() {

	};	
	window.formElements = formElements;

}(jQuery, window);

// initialize app
+function($) {
	formElements.init();		
}(jQuery);


var edit = function() {
	$('.click2edit').summernote({
		height: 200,
		focus: true
	});
};

var save = function() {
	var markup = $('.click2edit').summernote('code');
	$('.click2edit').summernote('destroy');
};