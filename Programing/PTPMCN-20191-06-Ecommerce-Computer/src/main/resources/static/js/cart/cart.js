document.addEventListener("DOMContentLoaded", () => {
    updateCart();
});

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