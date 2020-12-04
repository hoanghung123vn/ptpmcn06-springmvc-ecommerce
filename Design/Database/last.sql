CREATE DATABASE  IF NOT EXISTS `computerstore` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `computerstore`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: computerstore
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
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
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `price` int NOT NULL,
  `quantity` int NOT NULL,
  `id_customer` int NOT NULL,
  `product_code` int NOT NULL,
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
-- Table structure for table `goal`
--

DROP TABLE IF EXISTS `goal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `number_order` int NOT NULL,
  `revenue` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goal`
--

LOCK TABLES `goal` WRITE;
/*!40000 ALTER TABLE `goal` DISABLE KEYS */;
INSERT INTO `goal` VALUES (1,'GOAL_OF_MONTH',20,200000000);
/*!40000 ALTER TABLE `goal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (14),(14),(14),(14),(14),(14),(14),(14);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturer`
--

DROP TABLE IF EXISTS `manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manufacturer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturer`
--

LOCK TABLES `manufacturer` WRITE;
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `price` int NOT NULL,
  `quantity` int NOT NULL,
  `id_order` int NOT NULL,
  `product_code` int NOT NULL,
  PRIMARY KEY (`id_order`,`product_code`),
  KEY `fk_product` (`product_code`),
  CONSTRAINT `fk_order` FOREIGN KEY (`id_order`) REFERENCES `orders` (`id_order`),
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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id_order` int NOT NULL AUTO_INCREMENT,
  `id_shipper` int DEFAULT NULL,
  `id_customer` int NOT NULL,
  `status` int NOT NULL,
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
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `origin`
--

DROP TABLE IF EXISTS `origin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `origin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `origin`
--

LOCK TABLES `origin` WRITE;
/*!40000 ALTER TABLE `origin` DISABLE KEYS */;
/*!40000 ALTER TABLE `origin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `code` int NOT NULL AUTO_INCREMENT,
  `cpu_name` varchar(255) NOT NULL,
  `date_of_manufacture` datetime NOT NULL,
  `description` varchar(255) NOT NULL,
  `disk_name` varchar(255) NOT NULL,
  `disk_size` int NOT NULL,
  `graphic_card_name` varchar(255) NOT NULL,
  `image_link` varchar(255) NOT NULL,
  `number_in_inventory` int NOT NULL,
  `number_of_core` int NOT NULL,
  `number_of_ram` int NOT NULL,
  `pin_size` int NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `screen_size` int NOT NULL,
  `size_of_ram` int NOT NULL,
  `standard_price` int NOT NULL,
  `id_manufacturer` int DEFAULT NULL,
  `id_origin` int DEFAULT NULL,
  `id_type` int DEFAULT NULL,
  PRIMARY KEY (`code`),
  KEY `FKaywqm7ioh9o2lmj0ssglichix` (`id_manufacturer`),
  KEY `FK2ktpmpvpx5sk5qwlq0umveimr` (`id_origin`),
  KEY `FKrhxj6mgk7eb68xd7ln6epbvk9` (`id_type`),
  CONSTRAINT `FK2ktpmpvpx5sk5qwlq0umveimr` FOREIGN KEY (`id_origin`) REFERENCES `origin` (`id`),
  CONSTRAINT `FKaywqm7ioh9o2lmj0ssglichix` FOREIGN KEY (`id_manufacturer`) REFERENCES `manufacturer` (`id`),
  CONSTRAINT `FKrhxj6mgk7eb68xd7ln6epbvk9` FOREIGN KEY (`id_type`) REFERENCES `type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (8,'sdadsd','2020-12-08 17:00:00','sdadsada','sadsdad',20,'sdasdasd','/products/114838.jpg',5,2,3,9,'dsadad',6,29,1123123,NULL,NULL,NULL),(10,'ggg','2020-12-16 17:00:00','sdfds','gsdfsdfs',10,'sdasdasd','',9,5,11,10,'ggggggggg',13,10,10,NULL,NULL,NULL),(12,'sdadsd','2020-12-17 17:00:00','sdfsfd','fsdfsdf',5,'sdasdasd','/products/k61.png',6,0,6,19,'dfdsfds',0,5,6,NULL,NULL,NULL),(13,'dfsdfdsf','2020-12-09 17:00:00','dfsdfs','',0,'sdasdasd','/products/pj2-3.png',5,10,9,10,'gggggg',0,6,5,NULL,NULL,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_MEMBER'),(3,'ROLE_MANAGER'),(4,'ROLE_STOCKER'),(5,'ROLE_SHIPPER'),(6,'ROLE_EMPLOYEE');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `deposit` int DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `status` int NOT NULL,
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
INSERT INTO `user` VALUES (1,'DHBK Ha Noi',0,'member@gmail.com','member','$2a$10$l0GywKNnOJDi0txPrLEyguXKGJgh9ezsEtjJHwjZ4Al1ncvrq3bHK','0382334747',1,'TCDD-1998'),(4,'DHBK Ha Noi',0,'admin@gmail.com','hung hoang','$2a$10$2R5cDjXvF6tmBmMtsX/at.IJ1wS74j3dx1e9Xs2Z1xKdxDxAL07IW','0123456789',1,'TC-22-1119'),(5,'DHBK Ha Noi',5000000,'shipper@gmail.com','Nguyen Quang Thanh','$2a$10$BkVxUEeONKe/NHQqKaSR1ON57Ljm2cTOWEtgyWq5ehfm2zJBEGYdO','0982334748',1,'TD12345678'),(6,'DHBK Ha Noi',0,'stocker@gmail.com','Cao Van Duy','$2a$10$V6DJiYGc32boOh47TWHYke5paS9050GnWEJwIDn8QUqzEuN.piFLC','0123823347',1,'TCDD-19939'),(7,'DHBK Ha Noi',0,'manager@gmail.com','Hoang Van Hung','$2a$10$sfdu30WdCzNLMzL1LCzL9OUOZwu/S9EEXaR1PpgZHyciYW4GHP/N2','0971371901',1,'TCDD-19970');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id_user` int NOT NULL,
  `id_role` int NOT NULL,
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
INSERT INTO `user_role` VALUES (4,1),(7,2),(7,3),(6,4),(5,5);
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

-- Dump completed on 2020-12-04 23:55:25
