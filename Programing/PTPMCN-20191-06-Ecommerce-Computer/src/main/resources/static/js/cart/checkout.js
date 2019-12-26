$(document).ready(function(){
    $("#checkout-btn-empty-order").on("click", function(){
        warningEmptyOrder();
    });
})

function warningEmptyOrder(){
    notification.warning("Unable to create order", "The cart is empty");
}

