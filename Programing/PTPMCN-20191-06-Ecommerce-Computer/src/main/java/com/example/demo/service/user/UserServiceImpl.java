package com.example.demo.service.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.config.Const;
import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;

/**
 * @author Hung Hoang
 * @version 1.0 Nov 20, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name UserServiceImpl.java
 * @description TODO
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired 
    private PasswordEncoder passwordEncoder;
    
//    @Autowired
//    private CartRepository cartRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public long countAll() {
        return userRepository.count();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public boolean register(User customer) {
        if (userRepository.findByEmail(customer.getEmail()) == null) {
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            customer.setStatus(1);
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName(Const.ROLE_MEMBER));
            customer.setRoles(roles);
            userRepository.save(customer);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean createEmployee(User user) {
        if (userRepository.findByEmail(user.getEmail()) == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setStatus(1);
            HashSet<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName(Const.ROLE_EMPLOYEE));
            user.setRoles(roles);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean toggleStatus(Integer id) {
        User user = userRepository.findById(id).get();
        // Can not block admin
        for(Role role: user.getRoles()) {
            if(role.getName().equals("ROLE_ADMIN"))
                return false;
        }
        if (user.getStatus() == 1) {
            user.setStatus(2);
        } else if (user.getStatus() == 2) {
            user.setStatus(1);
        }
        userRepository.save(user);
        return true;
    }

    @Override
    public List<User> search(String email) {
        return userRepository.findByEmailContaining(email);
    }

    @Override
    public void update(User user) {
        User oldUser = userRepository.findById(user.getId()).get();
        oldUser.setAddress(user.getAddress());
        oldUser.setDeposit(user.getDeposit());
        oldUser.setEmail(user.getEmail());
        oldUser.setName(user.getName());
        oldUser.setPhone(user.getPhone());
        oldUser.setPassword(passwordEncoder.encode(user.getPassword()));
        oldUser.setTaxCode(user.getTaxCode());
        userRepository.save(oldUser);
    }

    @Override
    public boolean setRoles(Integer id, ArrayList<String> roles) {
        User oldUser = userRepository.findById(id).get();
        HashSet<Role> newRoles = new HashSet<Role>();
        Set<Role> oldRoles = oldUser.getRoles();
        
        for(String role: roles) {
            Role roleUser = roleRepository.findByName(role);
            if(roleUser == null)
                return false;
            newRoles.add(roleUser);
        }
        
        for(Role oldRole: oldRoles) {
            if(oldRole.getName().equals("ROLE_ADMIN"))
                newRoles.add(oldRole);
            if(oldRole.getName() == "ROLE_MEMBER")
                return false;        
        }
        
        for(Role role: newRoles) {
            System.out.println(role.getName());
        }
        oldUser.setRoles(newRoles);
        userRepository.save(oldUser);
        return true;
    }

	@Override
	@Transactional
	public void save(User user) {
		userRepository.save(user);
		
	}
    
    

    @Override
    public long countMember() {
        int count = 0;
        List<User> list = userRepository.findAll();
        Role roleMember = roleRepository.findByName(Const.ROLE_MEMBER);
        for (User user : list) {
            if (user.getRoles().contains(roleMember)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public long countEmployee() {
        return userRepository.count() - countMember() - 1;
    }
    
}
