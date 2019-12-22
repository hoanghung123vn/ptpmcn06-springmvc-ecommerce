document.addEventListener("DOMContentLoaded", () => {
    updateCart();
    removeFromCart();
});


// update quantity in cart
function updateCart(){
    const quantitys = $(".quantity");
    let total = 0;
    let numItems = 0;

    function calTotal() {
        quantitys.each(function(index){
            if (quantitys.eq(index).parents('tr')[0].style['display'] != "none"){
                const price = $(`#price${quantitys[index].id}`);
                const n = parseInt(quantitys[index].value);
                total += parseInt(price.text()) * n;
                $(`#subtotal${quantitys[index].id}`).text(parseInt(price.text()) * n) ;
                $(`#item-quantity${quantitys[index].id}`).text(n);
                numItems += 1;
            }
        });

        // total at footer
        $("#total1").text(total);
        $("#total2").text(total);

        // total cart at header
        $("#top-subtotal").text(total + ' VND');
        $("#cart-total").text(numItems + ' Items: ' + total + ' VND');
    }

    calTotal();
    
    quantitys.each(function(index){
        quantitys[index].addEventListener("change", () => {
            total = 0;
            calTotal();
        })
    });
    console.log(total);
}


// remove products in cart
function removeFromCart(){
    const iconCloses = $(".icon-close");
    iconCloses.each(function(index){
        $(this).on("click", function(){
            (async() => {
                const response = await axios({
                    url: '/user/cart/removeProduct',
                    method: 'get',
                    params:{
                        productCode: iconCloses[index].id.substring(14)
                    }
                })
                // hide line deleted then update cart
                iconCloses.eq(index).parents('tr').hide(function(){
                    updateCart();
                });

                // hide product line in top cart
                const code = iconCloses[index].id.substring(14);
                $(`#item-quantity${code}`).parents('li').hide();

                if (response.data == 'error'){
                    notification.deleteFail();
                }else{
                    notification.deleteSuccess();
                }
            })()
        })
    })

}