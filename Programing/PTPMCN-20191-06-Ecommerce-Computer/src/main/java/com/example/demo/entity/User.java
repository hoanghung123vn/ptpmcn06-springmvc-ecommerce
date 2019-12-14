package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author Hung Hoang
 * @version 1.0 Nov 16, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name User.java
 * @description TODO
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "phone", nullable = false)
    private String phone;
    
    @Column(name = "address", nullable = false)
    private String address;
    
    @Column(name = "tax_code", nullable = true)
    private String taxCode;
    
    @Column(name = "deposit", nullable = true)
    private int deposit;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "pass", nullable = false)
    private String password;
    
    @Column(name = "status", nullable = false)
    private int status;
    
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private Set<Role> roles;

    @OneToMany(mappedBy = "customer")
    @OrderBy("id_order DESC")
    @JsonBackReference // prevent load products when load category (REST)
    private Set<Order> ordersOfCustomer = new HashSet<Order>();
    
    @OneToMany(mappedBy = "shipper")
    @OrderBy("id_order DESC")
    @JsonBackReference // prevent load products when load category (REST)
    private Set<Order> ordersOfShipper = new HashSet<Order>();
    
    @OneToMany(mappedBy = "pk.customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference // prevent load products when load category (REST)
    private List<Cart> items = new ArrayList<Cart>();
    
    public String getName() {
		return name;
	}

	public List<Cart> getItems() {
        return items;
    }

    public void setItems(List<Cart> items) {
        this.items = items;
    }

    public Set<Order> getOrdersOfCustomer() {
        return ordersOfCustomer;
    }

    public void setOrdersOfCustomer(Set<Order> ordersOfCustomer) {
        this.ordersOfCustomer = ordersOfCustomer;
    }

    public Set<Order> getOrdersOfShipper() {
        return ordersOfShipper;
    }

    public void setOrdersOfShipper(Set<Order> ordersOfShipper) {
        this.ordersOfShipper = ordersOfShipper;
    }

    public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    public void addRole(Role role) {
        roles.add(role);
        role.getUsers().add(this);
    }
    
    public void removeRole(Role role) {
        roles.remove(role);
        role.getUsers().remove(this);
    }
    
    public void addOrderOfCustomer(Order order) {
        ordersOfCustomer.add(order);
        order.setCustomer(this);
    }
    
    public void removeOrderofCustomer(Order order) {
        ordersOfCustomer.remove(order);
        order.setCustomer(null);
    }
    
    public void addOrderOfShipper(Order order) {
        ordersOfShipper.add(order);
        order.setShipper(this);
    }
  
    public void removeOrderOfShipper(Order order) {
        ordersOfShipper.remove(order);
        order.setShipper(null);
    }
    
    public void addItemCart(Cart item) {
        items.add(item);
    }
    
    public void removeItemCart(Cart item) {
        items.remove(item);
    }
    
    public int getCartTotalPrice() {
        int total = 0;
        for (Cart e : items) {
            total += e.getSubTotal();
        }
        return total;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id != other.id)
            return false;
        return true;
    }
}