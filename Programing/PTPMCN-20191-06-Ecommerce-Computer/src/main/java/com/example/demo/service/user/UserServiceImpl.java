package com.example.demo.service.user;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public User findByEmail(String email){
    	return userRepository.findByEmail(email);
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
            roles.add(roleRepository.findByName("ROLE_MEMBER"));
            customer.setRoles(roles);
            userRepository.save(customer);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public User createEmployee(User user) {
        // TODO Auto-generated method stub
        return null;
    }

	@Override
	@Transactional
	public void save(User user) {
		userRepository.save(user);
		
	}
    
    

    
}
