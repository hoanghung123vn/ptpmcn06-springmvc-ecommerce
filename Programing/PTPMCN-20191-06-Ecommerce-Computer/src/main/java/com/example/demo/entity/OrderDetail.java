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
@Table(name = "order_detail")
@AssociationOverrides({
    @AssociationOverride(
        name = "pk.order",
        joinColumns = @JoinColumn(name = "id_order")),
    @AssociationOverride(
        name = "pk.product",
        joinColumns = @JoinColumn(name = "product_code")),
})
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private PK pk = new PK();
    
    @Embeddable
    private static class PK implements Serializable {

        private static final long serialVersionUID = 1L;
            
        @ManyToOne(fetch = FetchType.LAZY)
        private Orders order;
        
        @ManyToOne(fetch = FetchType.LAZY)
        private Product product;

        public Orders getOrder() {
            return order;
        }

        public void setOrder(Orders order) {
            this.order = order;
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
            result = prime * result + ((order == null) ? 0 : order.hashCode());
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
            if (order == null) {
                if (other.order != null)
                    return false;
            } else if (!order.equals(other.order))
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
    
    public OrderDetail() {
        
    }
    
    @Transient
    public Orders getOrder() {
        return pk.getOrder();
    }
    
    public void setOrder(Orders order) {
        pk.setOrder(order);
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