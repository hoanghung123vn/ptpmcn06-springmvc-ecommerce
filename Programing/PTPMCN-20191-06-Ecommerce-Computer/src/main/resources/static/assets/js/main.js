document.addEventListener("DOMContentLoaded", () => {
  const search = document.getElementsByClassName("form-control-sm")[1];
  const assigned_status = document.getElementById("assigned");
  const delivering_status = document.getElementById("delivering");
  const completed_status = document.getElementById("completed");
  const clear = document.getElementById("clear");
  assigned_status.addEventListener("click", () => {
    search.value = "Đã phân công";
    // search.focus();
    search.dispatchEvent(new KeyboardEvent('keyup', { 'key': 'Enter' }));
  });

  delivering_status.addEventListener("click", () => {
    search.value = "Trên đường vận chuyển";
    search.dispatchEvent(new KeyboardEvent('keyup', { 'key': 'Enter' }));
  });

  completed_status.addEventListener("click", () => {
    search.value = "Đã thu tiền";
    search.dispatchEvent(new KeyboardEvent('keyup', { 'key': 'Enter' }));
  });

  clear.addEventListener("click", () => {
    search.value = "";
    search.dispatchEvent(new KeyboardEvent("keyup", { 'key': 'Enter' }));
  })
});
