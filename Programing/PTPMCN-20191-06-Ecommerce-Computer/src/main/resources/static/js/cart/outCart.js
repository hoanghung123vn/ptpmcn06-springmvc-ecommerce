
$(document).ready(function(){
    addToCart();
})


// add products to cart
function addToCart(){
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
                if (response.data == 'error'){
                    notification.addFail();
                }else{
                
                    // update top cart
                    const cartInfor = response.data;
                    console.log(response.data);
                    // Ex:{"total": 700000, "numItems": 3, "code": 1 ,"name": "product 1", "imageSrc": "/products/img01.jpg", "quantity": 1, "price": 100000}
                    $("#cart-total").text(cartInfor["numItems"]+  ' Items: ' + cartInfor["total"] + 'VND');
                    notification.addSuccess();
                    
                    // if product is already on top cart then plus 1
                    if($(`#item-quantity${cartInfor.code}`).length > 0 ){
                        console.log("in if");
                        const currentQuatity = parseInt($(`#item-quantity${cartInfor.code}`).text());
                        $(`#item-quantity${cartInfor.code}`).text( currentQuatity + 1);
                    }else{
                        // create new line on top cart
                        if($("#cart-sidebar").length == 0){
                            $(".block-subtitle.hidden-xs").append(`<ul id="cart-sidebar" class="mini-products-list"> </ul>`);
                        }
                        $("#cart-sidebar").append(
                            `<li class="item odd"> <a href="#" title="${cartInfor.name}" class="product-image"><img src="/images${cartInfor.imageSrc}" alt="${cartInfor.name}" width="65"></a>
                                <div class="product-details"> <a href="#" title="Remove This Item" class="remove-cart"><i id="icon-close-top${cartInfor.code}" class="icon-close top"></i></a>
                                    <p class="product-name">${cartInfor.name}<a href="#"></a> </p>
                                <strong id="item-quantity${cartInfor.code}"> ${cartInfor.quantity}</strong> x <span class="price">${cartInfor.price}</span>
                                </div>
                            </li>`);
                    }

                    $("#top-subtotal").text(cartInfor.total + " VND");
                    $("#top-subtotal").text(cartInfor.total + " VND");
                }
                //console.log(response.data);
            })()
        
        })
    }
}