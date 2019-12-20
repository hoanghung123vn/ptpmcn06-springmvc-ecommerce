+function($, window){
    var notification = {};
	
	const swalWithBootstrapButtons = Swal.mixin({

        customClass: {
          confirmButton: 'btn btn-success',
          cancelButton: 'btn btn-danger'
        },
        buttonsStyling: false
      })
      
    notification.deleteSuccess = function(){
        swalWithBootstrapButtons.fire(
            'Deleted!',
            'Your product has been deleted.',
            'success'
          )
    }

    notification.deleteFail = function(){
        swalWithBootstrapButtons.fire(
            'Delete product faild',
            'Some thing went wrong',
            'error'
          )
    }
    window.notification = notification;
}(jQuery, window);


$(document).ready(function(){
    $(".icon-close").each(function(index){
        $(this).on("click", function(){
            (async() => {
                const response = await axios({
                    url: '/user/cart/removeProduct',
                    method: 'get',
                    params:{
                        productCode: $(".icon-close")[index].id.substring(14)
                    }
                })
                $(".icon-close").eq(index).parents('tr').hide(function(){
                    console.log("update cart");
                    updateCart();
                });
                console.log(response);
                if (response.data == 'success'){
                    notification.deleteSuccess();
                }else{
                    notification.deleteFail();
                }
            })()
        })
    })

})

