$(document).ready(function(){
    confirmCancelOrder();
})


// cancel order
function confirmCancelOrder(){
    const cancelButtons = document.getElementsByClassName("cancel-order");
    console.log(cancelButtons);
    for (const btn of cancelButtons){
        btn.addEventListener("click", function(){
            Swal.fire({
                title: 'Are you sure?',
                text: "You won't be able to revert this!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
              }).then((result) => {
                if (result.value) {
                    const resp = cancelOrder(btn);
                    if (resp == 'error'){
                        notification.fail("Delete order failed", "Something went wrong");
                    }else{
                        // hide deleted row
                        $(`#${btn.id}`).parents("tr").hide();
                        notification.success("Delete order successfully", "Your order has been deleted");
                    }
                }
              })  
        })            
    }
}

function cancelOrder(btnCancel){
    (async() => {
        const response = await axios({
            url: '/user/orders/cancelOrder',
            method: 'get',
            params:{
                orderId: btnCancel.id.substring(12)
            }
        })

        return response.data;
    })()
}