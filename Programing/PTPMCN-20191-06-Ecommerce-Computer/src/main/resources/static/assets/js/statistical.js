document.addEventListener("DOMContentLoaded", () => {
  const revenue = document.getElementById("revenue");
  const revenue_show = document.getElementById("revenue_show");
  revenue_show.innerHTML = (revenue.value + "").substring(0, (revenue.value + "").length - 6) + " triệu";
});
