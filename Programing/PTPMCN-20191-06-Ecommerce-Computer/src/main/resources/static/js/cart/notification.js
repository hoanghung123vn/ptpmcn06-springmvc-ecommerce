// notifications with adding products
+function($, window){
	var notification = {};

	const Toast = Swal.mixin({
		toast: true,
		position: 'top',
		showConfirmButton: false,
		timer: 1000,
		width: 300,
		onOpen: (toast) => {
		  toast.addEventListener('mouseenter', Swal.stopTimer)
		  toast.addEventListener('mouseleave', Swal.resumeTimer)
		}
	  })

	notification.addSuccess = function() {	
        Toast.fire({
            icon: 'success',
            title: 'Add to cart successfully'
        })
    };	

  notification.addFail = function(){
      Toast.fire({
          icon: 'error',
          title: 'Add to cart failed'
      })
  }

  
  // notifications with removing products
  const swalWithBootstrapButtons = Swal.mixin({
    customClass: {
      confirmButton: 'btn btn-success',
      cancelButton: 'btn btn-danger'
    },
      buttonsStyling: false,
      showConfirmButton: false,
      timer: 1000
    })
    
  notification.success = function(title, msg){
      swalWithBootstrapButtons.fire(
          title,
          msg,
          'success'
        )
  }

  notification.fail = function(title, msg){
      swalWithBootstrapButtons.fire(
          title,
          msg,
          'error'
        )
  }

  notification.warning = function(title, msg){
    swalWithBootstrapButtons.fire(
        title,
        msg,
        'warning'
      )
}

  window.notification = notification;

}(jQuery, window);