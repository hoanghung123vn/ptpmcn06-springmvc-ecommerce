+function($, window){
	var notification = {};

	const Toast = Swal.mixin({
		toast: true,
		position: 'top',
		showConfirmButton: false,
		timer: 1000,
		width: 300,
		// timerProgressBar: true,
		onOpen: (toast) => {
		  toast.addEventListener('mouseenter', Swal.stopTimer)
		  toast.addEventListener('mouseleave', Swal.resumeTimer)
		}
	  })

	notification.success = function() {	
        Toast.fire({
            icon: 'success',
            title: 'Add to cart successfully'
        })
    };	

    notification.fail = function(){
        Toast.fire({
            icon: 'error',
            title: 'Add to cart successfully'
        })
    }
    
	window.notification = notification;

}(jQuery, window);

const addButtons = document.getElementsByClassName("add-product");
for (const btn of addButtons){
    btn.addEventListener("click", function(){
        (async() => {
            const response = await axios({
                url: '/user/cart/addProduct',
                method: 'get',
                params:{
                    productCode: btn.id.substring(11)
                }
            })
            if (response.data == 'success'){
                notification.success();
            }else{
                notification.fail();
            }
        })()
      
    })
}