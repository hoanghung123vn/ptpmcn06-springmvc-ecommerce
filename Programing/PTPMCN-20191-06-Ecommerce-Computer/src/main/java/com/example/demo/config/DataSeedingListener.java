package com.example.demo.config;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.dao.GoalRepository;
import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.Goal;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;

/**
 * @author Hung Hoang
 * @version 1.0 Nov 16, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name DataSeedingListener.java
 * @description TODO: Fake data
 */
@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired 
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private GoalRepository goalRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        // Goal
        if(goalRepository.findByName("GOAL_OF_MONTH") == null) {
            Goal goal = new Goal();
            goal.setName("GOAL_OF_MONTH");
            goal.setNumberOrder(20);
            goal.setRevenue(200000000);
            goalRepository.save(goal);
        }
        // Roles
        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            roleRepository.save(new Role("ROLE_ADMIN"));
        }

        if (roleRepository.findByName("ROLE_MEMBER") == null) {
            roleRepository.save(new Role("ROLE_MEMBER"));
        }
        
        if (roleRepository.findByName("ROLE_MANAGER") == null) {
            roleRepository.save(new Role("ROLE_MANAGER"));
        }

        if (roleRepository.findByName("ROLE_STOCKER") == null) {
            roleRepository.save(new Role("ROLE_STOCKER"));
        }
        
        if (roleRepository.findByName("ROLE_SHIPPER") == null) {
            roleRepository.save(new Role("ROLE_SHIPPER"));
        }
        
        if (roleRepository.findByName("ROLE_EMPLOYEE") == null) {
            roleRepository.save(new Role("ROLE_EMPLOYEE"));
        }

        // Admin account
        if (userRepository.findByEmail("admin@gmail.com") == null) {
            User admin = new User();
            admin.setEmail("admin@gmail.com");
            admin.setName("hung hoang");
            admin.setPhone("0123456789");
            admin.setAddress("DHBK Ha Noi");
            admin.setTaxCode("TC-22-1119");
            admin.setStatus(1);
            admin.setPassword(passwordEncoder.encode("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_ADMIN"));
            admin.setRoles(roles);
            userRepository.save(admin);
        }

        // Member account
        if (userRepository.findByEmail("member@gmail.com") == null) {
            User user = new User();
            user.setEmail("member@gmail.com");
            user.setName("minh nguyen le");
            user.setPhone("0382334747");
            user.setAddress("DHBK Ha Noi");
            user.setStatus(1);
            user.setPassword(passwordEncoder.encode("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            user.setRoles(roles);
            userRepository.save(user);
        }
        
        // Shipper account
        if (userRepository.findByEmail("shipper@gmail.com") == null) {
            User user = new User();
            user.setEmail("shipper@gmail.com");
            user.setName("Nguyen Quang Thanh");
            user.setPhone("0982334748");
            user.setAddress("DHBK Ha Noi");
            user.setTaxCode("TCDD-1995");
            user.setStatus(1);
            user.setPassword(passwordEncoder.encode("123456"));
            user.setTaxCode("TD12345678");
            user.setDeposit(5000000);
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_SHIPPER"));
            user.setRoles(roles);
            userRepository.save(user);
        }
        
        // Stocker account
        if (userRepository.findByEmail("stocker@gmail.com") == null) {
            User user = new User();
            user.setEmail("stocker@gmail.com");
            user.setName("Cao Van Duy");
            user.setPhone("0123823347");
            user.setAddress("DHBK Ha Noi");
            user.setTaxCode("TCDD-19939");
            user.setStatus(1);
            user.setPassword(passwordEncoder.encode("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_STOCKER"));
            user.setRoles(roles);
            userRepository.save(user);
        }
        
        // Manager account
        if (userRepository.findByEmail("manager@gmail.com") == null) {
            User user = new User();
            user.setEmail("manager@gmail.com");
            user.setName("Hoang Van Hung");
            user.setPhone("0971371901");
            user.setAddress("DHBK Ha Noi");
            user.setTaxCode("TCDD-19970");
            user.setStatus(1);
            user.setPassword(passwordEncoder.encode("123456"));
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_MANAGER"));
            user.setRoles(roles);
            userRepository.save(user);
        }
    }

}