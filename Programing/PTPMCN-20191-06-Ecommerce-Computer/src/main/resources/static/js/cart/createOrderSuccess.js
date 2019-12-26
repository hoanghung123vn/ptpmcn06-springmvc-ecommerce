$(document).ready(function(){
    notyCreateOrder();
})

function notyCreateOrder(){
    if($(".new-order").length > 0 && document.location.pathname == "/user/orders"){
        notification.success("Successfully", "Your order has been created, check it now !!!");
<<<<<<< HEAD
    }else{
        console.log("hahah");
=======
>>>>>>> develop
    }
}