/**
 * 
 */
function myFunction(items){
    var tongTien = 0;
    for ( i = 0;i< items.size();i++){
        tongTien += items[i].price * document.getElementById("Product"+i);
    }
    document.getElementById("tongTien").innerText(tongTien);
    return tongTien;
}

const quantities = document.getElementsByClassName("quantity");
const total = document.getElementById("total");

function changeTotal(){
    totalPrice = 0;
    for(const quantity of quantities){
        const price = parseInt(document.getElementById("price" + quantity.id).innerHTML);
        totalPrice += price * parseInt(quantity.value);
    }
    total.innerHTML = totalPrice;
}

for(const quantity of quantities){
    quantity.addEventListener("change", () => {
        changeTotal();
    })
}