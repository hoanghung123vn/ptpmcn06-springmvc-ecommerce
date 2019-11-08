-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`hãng_sản_xuất`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`hãng_sản_xuất` (
  `id_hãng_sản_xuất` INT NOT NULL AUTO_INCREMENT,
  `tên_hãng_sản_xuất` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_hãng_sản_xuất`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`thể loại`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`thể loại` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tên_thể_loại` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`xuất_xứ`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`xuất_xứ` (
  `id_quoc_gia` INT NOT NULL,
  `ten` VARCHAR(30) NULL,
  PRIMARY KEY (`id_quoc_gia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`sản_phẩm`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`sản_phẩm` (
  `mã_sản_phẩm` INT NOT NULL AUTO_INCREMENT,
  `tên_CPU` VARCHAR(100) NULL,
  `số_lõi_CPU` INT NULL,
  `số_thanh_RAM` INT NULL,
  `dung_lượng_RAM` INT NULL,
  `tên_ổ_cứng` VARCHAR(100) NULL,
  `dung_lượng_ổ_cứng` INT NULL,
  `tên_card_đồ_họa` VARCHAR(100) NULL,
  `đường_dẫn_ảnh` VARCHAR(100) NULL,
  `ngày_sản_xuất` DATETIME NULL,
  `kích_thước_màn_hình` INT NOT NULL,
  `số_lượng_tồn` INT NOT NULL,
  `mô_tả` LONGTEXT NOT NULL,
  `giá_chuẩn` INT NOT NULL,
  `id_hãng_sản_xuất` INT NOT NULL,
  `id_thể_loại` INT NOT NULL,
  `dung_luong_pin` INT NULL,
  `bộ_nhớ_trong` INT NULL,
  `tên_mặt_hàng` VARCHAR(100) NOT NULL,
  `id_quoc_gia` INT NOT NULL,
  PRIMARY KEY (`mã_sản_phẩm`),
  UNIQUE INDEX `idMặt Hàng_UNIQUE` (`mã_sản_phẩm` ASC),
  INDEX `fk_máy_tính_hãng_sản_xuất_idx` (`id_hãng_sản_xuất` ASC),
  INDEX `fk_máy_tính_thể_loại1_idx` (`id_thể_loại` ASC),
  INDEX `fk_sản_phẩm_xuất_xứ1_idx` (`id_quoc_gia` ASC),
  CONSTRAINT `fk_máy_tính_hãng_sản_xuất`
    FOREIGN KEY (`id_hãng_sản_xuất`)
    REFERENCES `mydb`.`hãng_sản_xuất` (`id_hãng_sản_xuất`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_máy_tính_thể_loại1`
    FOREIGN KEY (`id_thể_loại`)
    REFERENCES `mydb`.`thể loại` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sản_phẩm_xuất_xứ1`
    FOREIGN KEY (`id_quoc_gia`)
    REFERENCES `mydb`.`xuất_xứ` (`id_quoc_gia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`người_dùng`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`người_dùng` (
  `id_người_dùng` INT NOT NULL AUTO_INCREMENT,
  `tên_người_dùng` VARCHAR(100) NOT NULL,
  `SĐT` VARCHAR(100) NOT NULL,
  `địa_chỉ` VARCHAR(100) NOT NULL,
  `mã_số_thuế` VARCHAR(100) NULL,
  `email` VARCHAR(100) NOT NULL,
  `mật_khẩu` VARCHAR(100) NOT NULL,
  `số_tiền_cọc` INT NULL,
  `vai_trò` INT NOT NULL,
  `trạng_thái` INT NOT NULL,
  PRIMARY KEY (`id_người_dùng`),
  UNIQUE INDEX `id_khách_hàng_UNIQUE` (`id_người_dùng` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`đơn_hàng`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`đơn_hàng` (
  `id_đơn_hàng` INT NOT NULL AUTO_INCREMENT,
  `ngày_phát_sinh` DATETIME NOT NULL,
  `id_shiper` INT NOT NULL,
  `trạng_thái` INT NOT NULL,
  `ngày_giao_hàng` DATETIME NOT NULL,
  `địa_chỉ_giao_hàng` VARCHAR(200) NOT NULL,
  `id_khách_hàng` INT NOT NULL,
  PRIMARY KEY (`id_đơn_hàng`),
  INDEX `fk_đơn_hàng_bán_khách_hàng1_idx` (`id_khách_hàng` ASC),
  INDEX `fk_đơn_hàng_bán_shiper_idx` (`id_shiper` ASC),
  CONSTRAINT `fk_đơn_hàng_bán_khách_hàng1`
    FOREIGN KEY (`id_khách_hàng`)
    REFERENCES `mydb`.`người_dùng` (`id_người_dùng`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_đơn_hàng_bán_shiper`
    FOREIGN KEY (`id_shiper`)
    REFERENCES `mydb`.`người_dùng` (`id_người_dùng`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`chi_tiết_đơn_hàng`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`chi_tiết_đơn_hàng` (
  `giá_bán` INT NOT NULL,
  `id_đơn_hàng` INT NOT NULL,
  `số_lượng` INT NULL,
  `mã_sản_phẩm` INT NOT NULL,
  INDEX `fk_chi_tiết_đơn_hàng_bán_đơn_hàng_bán1_idx` (`id_đơn_hàng` ASC),
  INDEX `fk_chi_tiết_đơn_hàng_sản_phẩm1_idx` (`mã_sản_phẩm` ASC),
  CONSTRAINT `fk_chi_tiết_đơn_hàng_bán_đơn_hàng_bán1`
    FOREIGN KEY (`id_đơn_hàng`)
    REFERENCES `mydb`.`đơn_hàng` (`id_đơn_hàng`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_chi_tiết_đơn_hàng_sản_phẩm`
    FOREIGN KEY (`mã_sản_phẩm`)
    REFERENCES `mydb`.`sản_phẩm` (`mã_sản_phẩm`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`giỏ_hàng`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`giỏ_hàng` (
  `id_giỏ_hàng` INT NOT NULL,
  `id_khách_hàng` INT NOT NULL,
  PRIMARY KEY (`id_giỏ_hàng`),
  INDEX `fk_giỏ_hàng_khách_hàng1_idx` (`id_khách_hàng` ASC),
  CONSTRAINT `fk_giỏ_hàng_khách_hàng1`
    FOREIGN KEY (`id_khách_hàng`)
    REFERENCES `mydb`.`người_dùng` (`id_người_dùng`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`chi_tiết_giỏ_hàng`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`chi_tiết_giỏ_hàng` (
  `mã_sản_phẩm` INT NOT NULL,
  `id_giỏ_hàng` INT NOT NULL,
  `số_lượng` INT NOT NULL,
  `giá_bán` INT NOT NULL,
  INDEX `fk_chi_tiết_giỏ_hàng_giỏ_hàng1_idx` (`id_giỏ_hàng` ASC),
  INDEX `fk_chi_tiết_giỏ_hàng_sản_phẩm_idx` (`mã_sản_phẩm` ASC),
  CONSTRAINT `fk_chi_tiết_giỏ_hàng_giỏ_hàng1`
    FOREIGN KEY (`id_giỏ_hàng`)
    REFERENCES `mydb`.`giỏ_hàng` (`id_giỏ_hàng`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_chi_tiết_giỏ_hàng_sản_phẩm`
    FOREIGN KEY (`mã_sản_phẩm`)
    REFERENCES `mydb`.`sản_phẩm` (`mã_sản_phẩm`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
