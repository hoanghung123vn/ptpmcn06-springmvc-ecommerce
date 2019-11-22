-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema computerstore
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema computerstore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `computerstore` DEFAULT CHARACTER SET utf8 ;
USE `computerstore` ;

-- -----------------------------------------------------
-- Table `computerstore`.`manufacturer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computerstore`.`manufacturer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `computerstore`.`type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computerstore`.`type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `computerstore`.`origin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computerstore`.`origin` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `computerstore`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computerstore`.`product` (
  `code` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(100) NOT NULL,
  `CPU_name` VARCHAR(100) NOT NULL,
  `number_of_core` INT NOT NULL,
  `number_of_RAM` INT NOT NULL,
  `size_of_RAM` INT NOT NULL,
  `disk_name` VARCHAR(100) NOT NULL,
  `disk_size` INT NOT NULL,
  `graphic_card_name` VARCHAR(100) NOT NULL,
  `image_link` VARCHAR(100) NOT NULL,
  `date_of_manufacture` DATETIME NOT NULL,
  `screen_size` INT NOT NULL,
  `number_in_inventory` INT NOT NULL,
  `description` LONGTEXT NOT NULL,
  `standard_price` INT NOT NULL,
  `id_manufacturer` INT NOT NULL,
  `id_type` INT NOT NULL,
  `pin_size` INT NOT NULL,
  `id_origin` INT NOT NULL,
  PRIMARY KEY (`code`),
  UNIQUE INDEX `idMặt Hàng_UNIQUE` (`code` ASC),
  INDEX `fk_máy_tính_hãng_sản_xuất_idx` (`id_manufacturer` ASC),
  INDEX `fk_máy_tính_thể_loại1_idx` (`id_type` ASC),
  INDEX `fk_sản_phẩm_xuất_xứ1_idx` (`id_origin` ASC),
  CONSTRAINT `fk_máy_tính_hãng_sản_xuất`
    FOREIGN KEY (`id_manufacturer`)
    REFERENCES `computerstore`.`manufacturer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_máy_tính_thể_loại1`
    FOREIGN KEY (`id_type`)
    REFERENCES `computerstore`.`type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sản_phẩm_xuất_xứ1`
    FOREIGN KEY (`id_origin`)
    REFERENCES `computerstore`.`origin` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `computerstore`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computerstore`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `phone` VARCHAR(100) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `tax_code` VARCHAR(100) NULL,
  `email` VARCHAR(100) NOT NULL,
  `pass` VARCHAR(100) NOT NULL,
  `deposit` INT NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_khách_hàng_UNIQUE` (`id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `computerstore`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computerstore`.`order` (
  `id_order` INT NOT NULL AUTO_INCREMENT,
  `creating_date` DATETIME NOT NULL,
  `id_shiper` INT NOT NULL,
  `status` INT NOT NULL,
  `ship_date` DATETIME NOT NULL,
  `ship_address` VARCHAR(200) NOT NULL,
  `id_customer` INT NOT NULL,
  PRIMARY KEY (`id_order`),
  INDEX `fk_đơn_hàng_bán_khách_hàng1_idx` (`id_customer` ASC),
  INDEX `fk_đơn_hàng_bán_shiper_idx` (`id_shiper` ASC),
  CONSTRAINT `fk_đơn_hàng_bán_khách_hàng1`
    FOREIGN KEY (`id_customer`)
    REFERENCES `computerstore`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_đơn_hàng_bán_shiper`
    FOREIGN KEY (`id_shiper`)
    REFERENCES `computerstore`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `computerstore`.`order_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computerstore`.`order_detail` (
  `id_order` INT NOT NULL AUTO_INCREMENT,
  `product_code` INT NOT NULL,
  `price` INT NOT NULL,
  `quantity` INT NOT NULL,
  INDEX `fk_chi_tiết_đơn_hàng_bán_đơn_hàng_bán1_idx` (`id_order` ASC),
  INDEX `fk_chi_tiết_đơn_hàng_sản_phẩm1_idx` (`product_code` ASC),
  CONSTRAINT `fk_chi_tiết_đơn_hàng_bán_đơn_hàng_bán1`
    FOREIGN KEY (`id_order`)
    REFERENCES `computerstore`.`order` (`id_order`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_chi_tiết_đơn_hàng_sản_phẩm`
    FOREIGN KEY (`product_code`)
    REFERENCES `computerstore`.`product` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `computerstore`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computerstore`.`cart` (
  `id` INT NOT NULL,
  `id_customer` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_giỏ_hàng_khách_hàng1_idx` (`id_customer` ASC),
  CONSTRAINT `fk_giỏ_hàng_khách_hàng1`
    FOREIGN KEY (`id_customer`)
    REFERENCES `computerstore`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `computerstore`.`cart_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computerstore`.`cart_detail` (
  `id` INT NOT NULL,
  `product_code` INT NOT NULL,
  `quantity` INT NOT NULL,
  `price` INT NOT NULL,
  INDEX `fk_chi_tiết_giỏ_hàng_giỏ_hàng1_idx` (`id` ASC),
  INDEX `fk_chi_tiết_giỏ_hàng_sản_phẩm_idx` (`product_code` ASC),
  CONSTRAINT `fk_chi_tiết_giỏ_hàng_giỏ_hàng1`
    FOREIGN KEY (`id`)
    REFERENCES `computerstore`.`cart` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_chi_tiết_giỏ_hàng_sản_phẩm`
    FOREIGN KEY (`product_code`)
    REFERENCES `computerstore`.`product` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `computerstore`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computerstore`.`role` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `computerstore`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `computerstore`.`user_role` (
  `id_user` INT NOT NULL,
  `id_role` INT NOT NULL,
  INDEX `fk_User_Role_User1_idx` (`id_user` ASC),
  INDEX `fk_User_Role_role1_idx` (`id_role` ASC),
  CONSTRAINT `fk_User_Role_User1`
    FOREIGN KEY (`id_user`)
    REFERENCES `computerstore`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_Role_role1`
    FOREIGN KEY (`id_role`)
    REFERENCES `computerstore`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
