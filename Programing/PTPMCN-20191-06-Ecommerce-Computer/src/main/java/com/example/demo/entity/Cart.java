package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Hung Hoang
 * @version 1.0 Nov 24, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name OrderDetail.java
 * @description TODO
 */
@Entity
@Table(name = "cart")
@AssociationOverrides({
    @AssociationOverride(
        name = "pk.customer",
        joinColumns = @JoinColumn(name = "id_customer")),
    @AssociationOverride(
        name = "pk.product",
        joinColumns = @JoinColumn(name = "product_code")),
})
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private PK pk = new PK();
    
    public PK getPk() {
		return this.pk;
	}

	public void setPk(PK pk) {
		this.pk = pk;
	}

	@Embeddable
    private static class PK implements Serializable {

        private static final long serialVersionUID = 1L;
            
        @ManyToOne(fetch = FetchType.LAZY)
        private User customer;
        
        @ManyToOne(fetch = FetchType.LAZY)
        private Product product;

        public User getCustomer() {
            return customer;
        }

        public void setCustomer(User customer) {
            this.customer = customer;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((customer == null) ? 0 : customer.hashCode());
            result = prime * result + ((product == null) ? 0 : product.hashCode());
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
            PK other = (PK) obj;
            if (customer == null) {
                if (other.customer != null)
                    return false;
            } else if (!customer.equals(other.customer))
                return false;
            if (product == null) {
                if (other.product != null)
                    return false;
            } else if (!product.equals(other.product))
                return false;
            return true;
        }
        
    }
    
    @Column(name = "quantity", nullable = false)
    private int quantity;
    
    @Column(name = "price", nullable = false)
    private int price;
    
    public Cart() {
        
    }
    
    
    @Transient
    public User getCustomer() {
        return pk.getCustomer();
    }
    
    public void setCustomer(User customer) {
        pk.setCustomer(customer);
    }
    
    @Transient
    public Product getProduct() {
        return pk.getProduct();
    }

    public void setProduct(Product product) {
        pk.setProduct(product);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSubTotal() {
        return price * quantity;
    }

}