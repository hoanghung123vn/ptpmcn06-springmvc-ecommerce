package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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

import com.example.demo.config.Const;
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
    private int id;
    
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
    private Set<Orders> ordersOfCustomer = new HashSet<Orders>();
    
    @OneToMany(mappedBy = "shipper")
    @OrderBy("id_order DESC")
    @JsonBackReference // prevent load products when load category (REST)
    private Set<Orders> ordersOfShipper = new HashSet<Orders>();
    
    @OneToMany(mappedBy = "pk.customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference // prevent load products when load category (REST)
    private Set<Cart> items = new HashSet<Cart>();
    
    public String getName() {
		return name;
	}

	public Set<Cart> getItems() {
        return items;
    }

    public void setItems(Set<Cart> items) {
        this.items = items;
    }

    public Set<Orders> getOrdersOfCustomer() {
        return ordersOfCustomer;
    }

    public void setOrdersOfCustomer(Set<Orders> ordersOfCustomer) {
        this.ordersOfCustomer = ordersOfCustomer;
    }

    public Set<Orders> getOrdersOfShipper() {
        return ordersOfShipper;
    }

    public void setOrdersOfShipper(Set<Orders> ordersOfShipper) {
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
    
    public void addOrderOfCustomer(Orders order) {
        ordersOfCustomer.add(order);
        order.setCustomer(this);
    }
    
    public void removeOrderofCustomer(Orders order) {
        ordersOfCustomer.remove(order);
        order.setCustomer(null);
    }
    
    public void addOrderOfShipper(Orders order) {
        ordersOfShipper.add(order);
        order.setShipper(this);
    }
  
    public void removeOrderOfShipper(Orders order) {
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
    
    public int countCompletedOrderOfShipper() {
        int count = 0;
        for (Orders order: ordersOfShipper) {
            if (order.getStatus() == Const.COMPLETED)
                count++;
        }
        return count;
    }
    
    public int countDeliveringOrderOfShipper() {
        int count = 0;
        for (Orders order: ordersOfShipper) {
            if (order.getStatus() == Const.DELIVERING)
                count++;
        }
        return count;
    }
    
    public long priceCompletedOrderOfShipper() {
        long price = 0;
        for (Orders order: ordersOfShipper) {
            if (order.getStatus() == Const.COMPLETED)
                price += order.getTotal();
        }
        return price;
    }
    
    public long priceDeliveringOrderOfShipper() {
        long price = 0;
        for (Orders order: ordersOfShipper) {
            if (order.getStatus() == Const.DELIVERING)
                price += order.getTotal();
        }
        return price;
    }
    
    public int countDelayPaymentOrderOfShipper() {
        int count = 0;
        for(Orders order: ordersOfShipper) {
            Date delayDate = new Date(order.getShipDate().getTime() + 3 * 86400 * 1000);
            if(order.getStatus() == Const.DELIVERING && delayDate.before(new Date())) {
                count++;
            }
        }
        return count;
    }
    
    public long priceDelayPaymentOrderOfShipper() {
        long price = 0;
        for(Orders order: ordersOfShipper) {
            Date delayDate = new Date(order.getShipDate().getTime() + 3 * 86400 * 1000);
            if(order.getStatus() == Const.DELIVERING && delayDate.before(new Date())) {
                price += order.getTotal();
            }
        }
        return price;
    }
    
    public int countDelayOrderOfShipper() {
        int count = 0; 
        for(Orders order: ordersOfShipper) {
            Date delayDate = new Date(order.getShipDate().getTime() - 1 * 86400 * 1000);
            if(order.getStatus() == Const.ASSIGNED && delayDate.before(new Date())) {
                count++;
            }
        }
        return count;
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