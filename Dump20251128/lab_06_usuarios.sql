CREATE DATABASE  IF NOT EXISTS `lab_06` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `lab_06`;
-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: localhost    Database: lab_06
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rol_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `correo` (`correo`),
  KEY `rol_id` (`rol_id`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Carlos Vargas','carlos.vargas@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(2,'Xavier Ruiz','xavier.ruiz@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(3,'Victor Guerra','victor.guerra@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(4,'Diego Torres','diego.torres@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(5,'Jorge Rubio','jorge.rubio@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(6,'Paolo Mendoza','paolo.mendoza@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(7,'Alonso Llanos','alonso.llanos@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(8,'Ronald Sanchez','ronald.sanchez@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(9,'Luis Cotrina','luis.cotrina@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(10,'Jhocell Perez','jhocell.perez@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(11,'Paolo Valiente','paolo.valiente@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(12,'Mariana Rojas','mariana.rojas@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(13,'Camila Fernández','camila.fernandez@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(14,'Valeria Campos','valeria.campos@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(15,'Gabriela Paredes','gabriela.paredes@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(16,'Andrea Lozano','andrea.lozano@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(17,'Sofía Delgado','sofia.delgado@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(18,'Lucía Herrera','lucia.herrera@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(19,'Rosa Aguilar','rosa.aguilar@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(20,'Claudia Navarro','claudia.navarro@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(21,'Alejandra Cornejo','alejandra.cornejo@example.com','$2a$10$N9qo8uLOickgx2ZMRZoMye.Kb1k2Z.9pG6G9Q8J.Yb8Mq5Q2YfzS6',2),(27,'Administrador','admin@example.com','$2a$10$kBTvKi7upYpNtTv9i9xLGO/zmjyOBAe/XqpicSwan0brEAcHgBDlm',1),(28,'Usuario Test','test@example.com','$2a$10$kBTvKi7upYpNtTv9i9xLGO/zmjyOBAe/XqpicSwan0brEAcHgBDlm',2);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-28  8:07:34
