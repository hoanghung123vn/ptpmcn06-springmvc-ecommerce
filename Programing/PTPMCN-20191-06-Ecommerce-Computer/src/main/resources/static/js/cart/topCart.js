$(document).ready(function(){
    document.addEventListener('DOMNodeInserted', function(){
        removeTopCart();
    })
 })
 
 // remove products on top cart
 function removeTopCart(){
     const icons = $(".icon-close.top");
     icons.each(function(index){
         $(this).on("click", function(){
             (async() => {
                 const response = await axios ({
                     url: '/user/cart/removeProduct',
                     method: 'get',
                     params:{
                         productCode: icons[index].id.substring(14)
                     }
                 })
 
                 // hide product line in top cart
                 const code = icons[index].id.substring(14);
                 $(`#item-quantity${code}`).parents('li').hide();
 
                 // update top
                 const cartInfor = response.data; 
                 $("#cart-total").text(cartInfor.numItems+  ' Items: ' + cartInfor.total + 'VND');
                 $("#top-subtotal").text(cartInfor.total + ' VND');
 
                 var path = window.location.pathname;
                 if (path == "/user/cart"){
                     console.log(`#remove-product${code}`);
                     $(`#remove-product${code}`).parents("tr").hide(function(){
                         updateCart();
                     }) 
                 }
 
             })()
         })
     })
 }