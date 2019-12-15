package com.example.demo.controller.admin;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.User;
import com.example.demo.service.user.UserService;

/**
 * @author Hung Hoang
 * @version 1.0 Nov 22, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name UserController.java
 * @description TODO
 */

@Controller
@RequestMapping(path = "/admin")
public class AdminUserController {
    @Autowired
    private UserService userService;

    @GetMapping("/customers")
    public String index(Model model, @RequestParam(name = "email", required = false) String email) {
        if (email == null) {
            model.addAttribute("customers", userService.findAll());
        } else {
            model.addAttribute("customers", userService.search(email));
        }
        return "admin/customer_list";
    }

    @GetMapping("/customer/{id}/orders")
    public String singleUser(@PathVariable("id") Integer id, Model model) {
        Optional<User> user = userService.findById(id);
        model.addAttribute("user", user.get());
        return "admin/single_customer";
    }

    @GetMapping("/addEmployee")
    public String add(Model model) {
        model.addAttribute("employee", new User());
        return "admin/add_employee";
    }

    @PostMapping("/addEmpoyee")
    public @ResponseBody String addEmployee(@ModelAttribute User empoyee) {
        return Optional.ofNullable(userService.createEmployee(empoyee)).map(t -> "success").orElse("failed");
    }

    @GetMapping("/customer/{id}/delete")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes redirect) {
        userService.deleteById(id);
        redirect.addFlashAttribute("success", "Xóa thành công, xem kết quả bên dưới");
        return "redirect:/admin/customers";
    }

    @GetMapping("/customer/{id}/toggle-status")
    public String toggle(@PathVariable("id") Integer id, RedirectAttributes redirect) {
        if(userService.toggleStatus(id)) {
            redirect.addFlashAttribute("success", "Thành công, xem kết quả bên dưới");
        } else {
            redirect.addFlashAttribute("error", "Không được phép khóa Admin");
        }   
        return "redirect:/admin/customers";
    }

    @GetMapping("/employee/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        User user = userService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));               
      model.addAttribute("user", user);
      return "admin/edit_employee";                
    }
    
    @PostMapping("/employee/update/{id}")
    public String update(@PathVariable("id") Integer id, RedirectAttributes redirect, User user) {
        userService.update(user);
        redirect.addFlashAttribute("success", "Cập nhật thành công, xem kết quả bên dưới");
        return "redirect:/admin/employee/edit/" + id;
    }
    
    @PostMapping("/employee/update-roles/{id}")
    public String updateRoles(@PathVariable("id") Integer id, RedirectAttributes redirect, @RequestParam(name = "roles", required = false) ArrayList<String> roles) {
        if(roles == null) {
            roles = new ArrayList<String>();
        }
        if(userService.setRoles(id, roles)) {
            redirect.addFlashAttribute("success", "Thực hiện thành công, xem kết quả bên dưới");
        } else {
            redirect.addFlashAttribute("error", "Thực hiện thất bại, hãy thử lại");
        }    
        return "redirect:/admin/employee/edit/" + id;
    }
}
