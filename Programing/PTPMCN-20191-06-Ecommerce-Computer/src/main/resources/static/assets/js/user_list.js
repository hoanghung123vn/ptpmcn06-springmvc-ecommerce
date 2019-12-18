document.addEventListener("DOMContentLoaded", () => {
  const search = document.getElementsByClassName("form-control-sm")[1];
  const role_member = document.getElementById("role_member");
  const role_employee = document.getElementById("role_employee");
  const role_shipper = document.getElementById("role_shipper");
  const role_stocker = document.getElementById("role_stocker");
  const role_manager = document.getElementById("role_manager");
  const role_admin = document.getElementById("role_admin");
  const clear = document.getElementById("clear");

  function filter(element, msg) {
    element.addEventListener("click", () => {
      search.value = msg;
      search.dispatchEvent(new KeyboardEvent('keyup', { 'key': 'Enter' }));
    });
  }

  filter(role_member, "Khách hàng");

  filter(role_employee, "Nhân viên");

  filter(role_shipper, "Shipper");

  filter(role_stocker, "Thủ kho");

  filter(role_manager, "Quản lý");

  filter(role_admin, "Admin");

  filter(clear, "");
});
