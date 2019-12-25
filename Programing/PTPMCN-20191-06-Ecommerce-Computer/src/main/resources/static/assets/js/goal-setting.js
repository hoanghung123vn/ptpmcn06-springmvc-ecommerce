document.addEventListener("DOMContentLoaded", () => {
  const revenue = document.getElementById("revenue");
  const revenue_show = document.getElementById("revenue_show")
  revenue.addEventListener("change", () => {
    revenue_show.innerHTML = (parseInt(revenue.value)).toFixed(1).replace(/\d(?=(\d{3})+\.)/g, '$&,') + " VND";
    console.log(typeof revenue.value);
  })
});
