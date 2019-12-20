package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name = "id_manufacturer", nullable = false)
	private int idManufacturer;
	
	@Column(name = "id_type", nullable = false)
	private int idType;
	
	@Column(name = "pin_size", nullable = false)
	private int pinSize;
	
	@Column(name = "id_origin", nullable = false)
	private String idOrigin;

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

	public int getIdManufacturer() {
		return idManufacturer;
	}

	public void setIdManufacturer(int idManufacturer) {
		this.idManufacturer = idManufacturer;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public int getPinSize() {
		return pinSize;
	}

	public void setPinSize(int pinSize) {
		this.pinSize = pinSize;
	}	
	
}
