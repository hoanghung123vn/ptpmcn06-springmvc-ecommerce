-- MySQL dump 10.17  Distrib 10.3.16-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: computerstore
-- ------------------------------------------------------
-- Server version	10.3.16-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `id_customer` int(11) NOT NULL,
  `product_code` int(11) NOT NULL,
  PRIMARY KEY (`id_customer`,`product_code`),
  KEY `FK4t4ine8kc0j62qqubhnop41l4` (`product_code`),
  CONSTRAINT `FK4t4ine8kc0j62qqubhnop41l4` FOREIGN KEY (`product_code`) REFERENCES `product` (`code`),
  CONSTRAINT `FKr0axs00qalaavayx235al19dy` FOREIGN KEY (`id_customer`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (8),(8),(8),(8),(8),(8),(8);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturer`
--

DROP TABLE IF EXISTS `manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manufacturer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturer`
--

LOCK TABLES `manufacturer` WRITE;
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
INSERT INTO `manufacturer` VALUES (1,'Apple'),(2,'Asus'),(3,'Dell'),(4,'Lenovo');
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id_order` int(11) NOT NULL,
  `id_shipper` int(11) DEFAULT NULL,
  `id_customer` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `note` varchar(200) DEFAULT NULL,
  `ship_date` datetime NOT NULL,
  `creating_date` datetime NOT NULL,
  `ship_address` varchar(200) NOT NULL,
  PRIMARY KEY (`id_order`),
  KEY `fk_customer_idx` (`id_customer`),
  KEY `fk_shipper_idx` (`id_shipper`),
  KEY `fk_customer_idxas` (`id_customer`),
  CONSTRAINT `fk_customerabc` FOREIGN KEY (`id_customer`) REFERENCES `user` (`id`),
  CONSTRAINT `fk_shipper` FOREIGN KEY (`id_shipper`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_detail` (
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `id_order` int(11) NOT NULL,
  `product_code` int(11) NOT NULL,
  PRIMARY KEY (`id_order`,`product_code`),
  KEY `fk_product` (`product_code`),
  CONSTRAINT `fk_order` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`),
  CONSTRAINT `fk_product` FOREIGN KEY (`product_code`) REFERENCES `product` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `origin`
--

DROP TABLE IF EXISTS `origin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `origin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `origin`
--

LOCK TABLES `origin` WRITE;
/*!40000 ALTER TABLE `origin` DISABLE KEYS */;
INSERT INTO `origin` VALUES (1,'VietNam'),(2,'United Kingdom'),(3,'China'),(4,'Japan');
/*!40000 ALTER TABLE `origin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `code` int(11) NOT NULL,
  `cpu_name` varchar(255) NOT NULL,
  `date_of_manufacture` datetime NOT NULL,
  `description` varchar(255) NOT NULL,
  `disk_name` varchar(255) NOT NULL,
  `disk_size` int(11) NOT NULL,
  `graphic_card_name` varchar(255) NOT NULL,
  `image_link` varchar(255) NOT NULL,
  `number_in_inventory` int(11) NOT NULL,
  `number_of_core` int(11) NOT NULL,
  `number_of_ram` int(11) NOT NULL,
  `pin_size` int(11) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `screen_size` int(11) NOT NULL,
  `size_of_ram` int(11) NOT NULL,
  `standard_price` int(11) NOT NULL,
  `id_manufacturer` int(11) DEFAULT NULL,
  `id_origin` int(11) DEFAULT NULL,
  `id_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `FKaywqm7ioh9o2lmj0ssglichix` (`id_manufacturer`),
  KEY `FK2ktpmpvpx5sk5qwlq0umveimr` (`id_origin`),
  KEY `FKrhxj6mgk7eb68xd7ln6epbvk9` (`id_type`),
  CONSTRAINT `FK2ktpmpvpx5sk5qwlq0umveimr` FOREIGN KEY (`id_origin`) REFERENCES `origin` (`id`),
  CONSTRAINT `FKaywqm7ioh9o2lmj0ssglichix` FOREIGN KEY (`id_manufacturer`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKrhxj6mgk7eb68xd7ln6epbvk9` FOREIGN KEY (`id_type`) REFERENCES `type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'cpu 1','2019-11-01 00:00:00','this is product 1','disk 1',1000,'graphic 1','/products/img01.jpg',100,1,1,1000,'product 1',1000,1000,100000,1,1,1),(2,'cpu 2','2019-11-01 00:00:00','this is product 2','disk 2',1000,'graphic 2','/products/img02.jpg',200,2,2,1000,'product 2',2000,2000,200000,2,2,2),(3,'cpu 3','2019-11-01 00:00:00','this is product 3','disk 3',1000,'graphic 3','/products/img03.jpg',300,3,3,1000,'product 3',3000,3000,300000,3,3,1),(4,'cpu 4','2019-11-01 00:00:00','this is product 4','disk 4',1000,'graphic 4','/products/img04.jpg',400,4,4,1000,'product 4',4000,4000,400000,4,4,1),(5,'cpu 5','2019-11-01 00:00:00','this is product 5','disk 5',1000,'graphic 5','/products/img05.jpg',500,5,5,1000,'product 5',5000,5000,500000,1,4,2);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_MEMBER'),(3,'ROLE_MANAGER'),(4,'ROLE_STOCKER'),(5,'ROLE_SHIPPER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'gaming'),(2,'office');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `deposit` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `status` int(11) NOT NULL,
  `tax_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (6,'DHBK Ha Noi',100000,'admin@gmail.com','hung hoang','$2a$10$bwybFYKAcJwZJegA2gmDleptDIuGShGk84uHsG8b.vajci/0VQmki','0123456789',1,'TC-22-11-19'),(7,'DHBK Ha Noi',0,'member@gmail.com','minh nguyen le','$2a$10$FsXl9hO5mESrrWpyvyqZH.fIRMkoHpmgv4OgiTHPNe6uhn10.k6Aq','0382334747',1,'TCDD-1998');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id_user` int(11) NOT NULL,
  `id_role` int(11) NOT NULL,
  PRIMARY KEY (`id_user`,`id_role`),
  KEY `FK2aam9nt2tv8vcfymi3jo9c314` (`id_role`),
  CONSTRAINT `FK2aam9nt2tv8vcfymi3jo9c314` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`),
  CONSTRAINT `FKfhxaael2m459kbk8lv8smr5iv` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (6,1),(6,2),(7,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-29 17:05:58
