package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author le minh nguyen
 * @version 1.0 Nov 19, 2019
 * @project_name PTPMCN-20191-06-Ecommerce-Computer
 * @teacher_name Duc Vuong Vu
 * @class_name Product.java
 * @description TODO
 */
@Entity
@Table(name = "product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "code", nullable = false)
	private int code;
	
	@Column(name = "product_name", nullable = false)
	private String productName;
	
	@Column(name = "cpu_name", nullable = false)
	private String cpuName;
	
	@Column(name = "number_of_core", nullable = false)
	private int numberOfCore;
	
	@Column(name = "number_of_ram", nullable = false)
	private int numberOfRam;
	
	@Column(name = "size_of_ram", nullable = false)
	private int sizeOfRam;
	
	@Column(name = "disk_name", nullable = false)
	private String diskName;
	
	@Column(name = "disk_size", nullable = false)
	private int diskSize;
	
	@Column(name = "graphic_card_name", nullable = false)
	private String graphicCardName;
	
	@Column(name = "image_link", nullable = false)
	private String imageLink;
	
	@Column(name = "date_of_manufacture", nullable = false)
	private Date dateOfManufacture;
	
	@Column(name = "screen_size", nullable = false)
	private int screenSize;
	
	@Column(name = "number_in_inventory", nullable = false)
	private int numberInInventory;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "standard_price", nullable = false)
	private int standardPrice;

    @Column(name = "pin_size", nullable = false)
    private int pinSize;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_manufacturer", referencedColumnName = "id")
	private Manufacturer manufacturer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_type", referencedColumnName = "id")
	@JsonBackReference
	private Type type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_origin", referencedColumnName = "id")
	@JsonBackReference
	private Origin origin;
	
	@OneToMany(mappedBy = "pk.product")
	@JsonBackReference
    private Set<OrderDetail> orderItems = new HashSet<>();
	
	@OneToMany(mappedBy = "pk.product")
    @JsonBackReference
    private Set<Cart> cartItems = new HashSet<>();

    public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCpuName() {
		return cpuName;
	}

	public void setCpuName(String cpuName) {
		this.cpuName = cpuName;
	}

	public int getNumberOfCore() {
		return numberOfCore;
	}

	public void setNumberOfCore(int numberOfCore) {
		this.numberOfCore = numberOfCore;
	}

	public int getNumberOfRam() {
		return numberOfRam;
	}

	public void setNumberOfRam(int numberOfRam) {
		this.numberOfRam = numberOfRam;
	}

	public int getSizeOfRam() {
		return sizeOfRam;
	}

	public void setSizeOfRam(int sizeOfRam) {
		this.sizeOfRam = sizeOfRam;
	}

	public String getDiskName() {
		return diskName;
	}

	public void setDiskName(String diskName) {
		this.diskName = diskName;
	}

	public int getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(int diskSize) {
		this.diskSize = diskSize;
	}

	public String getGraphicCardName() {
		return graphicCardName;
	}

	public void setGraphicCardName(String graphicCardName) {
		this.graphicCardName = graphicCardName;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public Date getDateOfManufacture() {
		return dateOfManufacture;
	}

	public void setDateOfManufacture(Date dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	public int getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(int screenSize) {
		this.screenSize = screenSize;
	}

	public int getNumberInInventory() {
		return numberInInventory;
	}

	public void setNumberInInventory(int numberInInventory) {
		this.numberInInventory = numberInInventory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStandardPrice() {
		return standardPrice;
	}

	public void setStandardPrice(int standardPrice) {
		this.standardPrice = standardPrice;
	}

	public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPinSize() {
		return pinSize;
	}

	public void setPinSize(int pinSize) {
		this.pinSize = pinSize;
	}	
	
	public void addOrderItem(OrderDetail item) {
        orderItems.add(item);
    }
    
    public void removeOrderItem(OrderDetail item) {
        orderItems.remove(item);
    }
    
    public void addCartItem(Cart item) {
        cartItems.add(item);
    }
    
    public Set<OrderDetail> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderDetail> orderItems) {
        this.orderItems = orderItems;
    }

    public Set<Cart> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<Cart> cartItems) {
        this.cartItems = cartItems;
    }

    public void removeCartItem(Cart item) {
        cartItems.remove(item);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + code;
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
        Product other = (Product) obj;
        if (code != other.code)
            return false;
        return true;
    }
}
