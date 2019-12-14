document.addEventListener("DOMContentLoaded", () => {
    const quantitys = document.getElementsByClassName("quantity");
    const total_tax = document.getElementById("total1");
    const total_x = document.getElementById("total2");
    const top_subtotal = document.getElementById("top-subtotal");
    const cart_total = document.getElementById("cart-total");
    let total = 0;

    function calTotal() {
        for(const quantity of quantitys) {
            const price = document.getElementById(`price${quantity.id}`);
            const n = parseInt(quantity.value);
            total += parseInt(price.innerHTML) * n;
            document.getElementById(`subtotal${quantity.id}`).textContent = parseInt(price.innerHTML) * n;
            document.getElementById(`item-quantity${quantity.id}`).textContent = n;
        };
        total_tax.innerHTML = total;
        total_x.innerHTML = total;
        top_subtotal.innerHTML = total + ' VND' ;
        cart_total.innerHTML = quantitys.length + ' Items: ' + total + ' VND'
    }

    calTotal();

    for(const quantity of quantitys) {
        quantity.addEventListener("change", () => {
            total = 0;
            calTotal();
        });
    };
    console.log(total);
});