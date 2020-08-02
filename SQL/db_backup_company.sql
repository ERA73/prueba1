-- MySQL dump 10.16  Distrib 10.2.12-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: company
-- ------------------------------------------------------
-- Server version	10.2.12-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cost`
--

DROP TABLE IF EXISTS `cost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cost` (
  `id_cost` int(11) NOT NULL AUTO_INCREMENT,
  `id_game` int(11) NOT NULL,
  `cost` float NOT NULL,
  `cost_date` date NOT NULL,
  PRIMARY KEY (`id_cost`),
  KEY `FK_cost_game` (`id_game`),
  CONSTRAINT `FK_cost_game` FOREIGN KEY (`id_game`) REFERENCES `game` (`id_game`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cost`
--

LOCK TABLES `cost` WRITE;
/*!40000 ALTER TABLE `cost` DISABLE KEYS */;
INSERT INTO `cost` VALUES (1,1,20000,'2020-03-01'),(2,2,21000,'2020-03-03'),(3,3,22000,'2020-03-05'),(4,4,10000,'2020-03-07'),(5,5,11000,'2020-03-09');
/*!40000 ALTER TABLE `cost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `game` (
  `id_game` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(30) NOT NULL,
  `director` varchar(50) NOT NULL,
  `protagonist` varchar(50) NOT NULL,
  `producer` varchar(50) NOT NULL,
  `age` int(11) NOT NULL,
  `entry_date` date NOT NULL,
  `technology` varchar(50) NOT NULL,
  PRIMARY KEY (`id_game`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,'mass effect 1','Casey Hudson','shepard','ubisoft',18,'2007-01-01','PC, Xbox, PlayStation'),(2,'mass effect 2','Casey Hudson','shepard','ubisoft',18,'2010-01-01','PC, Xbox, PlayStation'),(3,'mass effect 3','Casey Hudson','shepard','EA',18,'2012-01-01','PC, Xbox, PlayStation'),(4,'Need for Speed','Paul Linford','player','EA',8,'2005-01-01','Xbox, PlayStation'),(5,'Halo 1','Jason Jones','JOHN-117','Microsoft',12,'2001-01-01','PC, Xbox');
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rental`
--

DROP TABLE IF EXISTS `rental`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rental` (
  `id_rental` int(11) NOT NULL AUTO_INCREMENT,
  `document` int(11) NOT NULL,
  `rental_date` date NOT NULL,
  `status` enum('En prestamo','Vencido','Finalizado') NOT NULL,
  `cost` float NOT NULL,
  PRIMARY KEY (`id_rental`),
  KEY `FK__user` (`document`),
  CONSTRAINT `FK__user` FOREIGN KEY (`document`) REFERENCES `user` (`document`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rental`
--

LOCK TABLES `rental` WRITE;
/*!40000 ALTER TABLE `rental` DISABLE KEYS */;
INSERT INTO `rental` VALUES (1,1010101010,'2020-08-01','En prestamo',11000),(2,1212121212,'2020-07-01','Vencido',21000),(3,1313131313,'2020-04-01','Finalizado',63000),(4,1212121212,'2020-07-21','En prestamo',10000),(5,1313131313,'2020-05-01','Finalizado',11000),(6,1313131313,'2020-06-01','En prestamo',10000);
/*!40000 ALTER TABLE `rental` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `selection`
--

DROP TABLE IF EXISTS `selection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `selection` (
  `id_rental` int(11) NOT NULL,
  `id_game` int(11) NOT NULL,
  KEY `id_rental` (`id_rental`),
  KEY `id_game` (`id_game`),
  CONSTRAINT `FK_selection_game` FOREIGN KEY (`id_game`) REFERENCES `game` (`id_game`),
  CONSTRAINT `FK_selection_rental` FOREIGN KEY (`id_rental`) REFERENCES `rental` (`id_rental`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `selection`
--

LOCK TABLES `selection` WRITE;
/*!40000 ALTER TABLE `selection` DISABLE KEYS */;
INSERT INTO `selection` VALUES (1,5),(2,4),(2,5),(3,1),(3,2),(3,3),(4,4),(5,5),(6,4);
/*!40000 ALTER TABLE `selection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `document` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`document`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1010101010,'user1@gmail.com','usuario1','3112223333',9),(1212121212,'user2@gmail.com','usuario2','3223334444',16),(1313131313,'user3@gmail.com','usuario3','3445557777',20);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'company'
--

--
-- Dumping routines for database 'company'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-01 22:45:03
