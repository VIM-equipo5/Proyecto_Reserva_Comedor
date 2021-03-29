-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: reserva_comedor
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `bebidas`
--

DROP TABLE IF EXISTS `bebidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bebidas` (
  `IdBebida` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `PrecioUnitario` decimal(10,2) NOT NULL,
  `Imagen` varchar(255) DEFAULT NULL,
  `Descripcion` text,
  PRIMARY KEY (`IdBebida`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bebidas`
--

LOCK TABLES `bebidas` WRITE;
/*!40000 ALTER TABLE `bebidas` DISABLE KEYS */;
INSERT INTO `bebidas` VALUES (1,'Refresco',1.00,'https://pasteleriamanacor.es/wp-content/uploads/2020/04/refrescos.jpg','Coca-cola, Fanta naranja, Aquarius'),(2,'Zumo de naranja',1.50,'https://i.pinimg.com/originals/51/11/2e/51112ef236ad1842696560e0d27c554d.png','Zumo de naranja'),(3,'Zumo de melocotón',1.50,'http://www.cervezainternacional.net/images/productos/pago-melocoton-33cl_3421_4_1.jpg','Zumo de melocotón'),(4,'Zumo de manzana',1.50,'http://www.cervezainternacional.net/images/productos/pago-manzana-20cl_3423_4_1.jpg','Zumo de manzana'),(5,'Agua 0,75L',0.75,'https://sgfm.elcorteingles.es/SGFM/dctm/MEDIA03/201905/10/00118630602078____1__600x600.jpg','Agua Aquarel 0,75');
/*!40000 ALTER TABLE `bebidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `IdCategoria` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `Descripcion` text,
  PRIMARY KEY (`IdCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Entrante','Pica-pica, tablas de queso y embutidos, crudité con hummus'),(2,'Primer plato','Ensaladas, cremas y platos ligeros'),(3,'Segundo plato','Platos principales'),(4,'Postre','Platos dulces y fruta');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `franjahoraria`
--

DROP TABLE IF EXISTS `franjahoraria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `franjahoraria` (
  `IdFranja` int NOT NULL AUTO_INCREMENT,
  `CapacidadMax` int NOT NULL,
  `OcupacionTotal` int NOT NULL,
  `FranjaInicio` time DEFAULT NULL,
  `FranjaFin` time DEFAULT NULL,
  PRIMARY KEY (`IdFranja`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `franjahoraria`
--

LOCK TABLES `franjahoraria` WRITE;
/*!40000 ALTER TABLE `franjahoraria` DISABLE KEYS */;
INSERT INTO `franjahoraria` VALUES (1,10,0,'00:12:00','00:12:15'),(2,10,0,'00:12:15','00:12:30'),(3,10,0,'00:12:30','00:12:45'),(4,10,0,'00:12:45','00:13:00'),(5,10,0,'00:13:00','00:13:15'),(6,10,0,'00:13:15','00:13:30'),(7,10,0,'00:13:30','00:13:45'),(8,10,0,'00:13:45','00:14:00'),(9,10,0,'00:14:00','00:14:15'),(10,10,0,'00:14:15','00:14:30'),(11,10,0,'00:14:30','00:14:45'),(12,10,0,'00:14:45','00:15:00');
/*!40000 ALTER TABLE `franjahoraria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ofrecerbebidas`
--

DROP TABLE IF EXISTS `ofrecerbebidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ofrecerbebidas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `IdReserva` int NOT NULL,
  `IdBebida` int NOT NULL,
  `CantidadBebidas` int NOT NULL,
  PRIMARY KEY (`id`,`IdReserva`,`IdBebida`),
  KEY `IdReserva` (`IdReserva`),
  KEY `IdBebida` (`IdBebida`),
  CONSTRAINT `ofrecerbebidas_ibfk_1` FOREIGN KEY (`IdReserva`) REFERENCES `reserva` (`IdReserva`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ofrecerbebidas_ibfk_2` FOREIGN KEY (`IdBebida`) REFERENCES `bebidas` (`IdBebida`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ofrecerbebidas`
--

LOCK TABLES `ofrecerbebidas` WRITE;
/*!40000 ALTER TABLE `ofrecerbebidas` DISABLE KEYS */;
INSERT INTO `ofrecerbebidas` VALUES (1,1,5,2),(2,1,3,1),(3,2,1,1),(4,2,5,1),(5,3,1,1),(6,3,4,1),(7,4,5,1),(8,5,5,3),(9,6,1,2),(10,7,5,1),(11,7,1,1),(12,8,5,1),(13,9,5,1),(14,10,1,2),(15,11,5,2),(16,12,1,1),(17,13,4,1),(18,13,5,2),(19,14,5,2),(20,15,1,1),(21,16,1,1),(22,17,1,2),(23,18,5,3),(24,19,1,1),(25,19,2,1),(26,19,5,2),(27,20,5,2);
/*!40000 ALTER TABLE `ofrecerbebidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedirplatos`
--

DROP TABLE IF EXISTS `pedirplatos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedirplatos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `IdReserva` int NOT NULL,
  `IdPlato` int NOT NULL,
  `CantidadPlatos` int NOT NULL,
  PRIMARY KEY (`id`,`IdReserva`,`IdPlato`),
  KEY `IdReserva` (`IdReserva`),
  KEY `IdPlato` (`IdPlato`),
  CONSTRAINT `pedirplatos_ibfk_1` FOREIGN KEY (`IdReserva`) REFERENCES `reserva` (`IdReserva`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pedirplatos_ibfk_2` FOREIGN KEY (`IdPlato`) REFERENCES `platos` (`IdPlato`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedirplatos`
--

LOCK TABLES `pedirplatos` WRITE;
/*!40000 ALTER TABLE `pedirplatos` DISABLE KEYS */;
INSERT INTO `pedirplatos` VALUES (1,1,6,1),(2,1,7,2),(3,1,15,1),(4,1,18,1),(5,1,19,1),(6,2,8,1),(7,2,9,1),(8,2,20,1),(9,2,21,1),(10,3,8,2),(11,3,20,2),(12,4,10,1),(13,4,15,1),(14,5,9,2),(15,5,10,1),(16,5,18,2),(17,5,19,1),(18,6,4,1),(19,6,7,1),(20,6,8,1),(21,6,20,1),(22,6,21,1),(23,7,8,1),(24,7,22,1),(25,7,27,1),(26,8,7,1),(27,8,21,1),(28,8,27,1),(29,9,8,1),(30,9,20,1),(31,9,26,1),(32,10,9,2),(33,10,22,1),(34,10,23,1),(35,11,10,1),(36,11,16,1),(37,11,17,1),(38,12,11,1),(39,12,20,1),(40,12,27,1),(41,13,4,1),(42,13,5,1),(43,13,9,2),(44,13,10,1),(45,13,21,2),(46,13,22,1),(47,13,26,2),(48,13,27,1),(49,14,9,2),(50,14,19,1),(51,14,21,1),(52,15,11,1),(53,15,16,1),(54,15,25,1),(55,16,9,1),(56,16,17,1),(57,16,27,1),(58,17,10,2),(59,17,19,1),(60,17,21,1),(61,17,26,2),(62,18,11,2),(63,18,12,1),(64,18,20,1),(65,18,21,1),(66,18,22,1),(67,18,27,2),(68,19,1,2),(69,19,2,2),(70,19,6,1),(71,19,9,1),(72,19,12,1),(73,19,15,1),(74,19,16,2),(75,19,17,1),(76,19,18,1),(77,19,24,2),(78,19,25,2),(79,20,11,2),(80,20,22,1),(81,20,23,1);
/*!40000 ALTER TABLE `pedirplatos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platos`
--

DROP TABLE IF EXISTS `platos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `platos` (
  `IdPlato` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Descripcion` text,
  `Imagen` varchar(255) DEFAULT NULL,
  `PrecioUnitario` decimal(10,2) NOT NULL,
  `Tipo` varchar(50) NOT NULL,
  `IdCategoria` int NOT NULL,
  PRIMARY KEY (`IdPlato`),
  KEY `IdCategoria` (`IdCategoria`),
  CONSTRAINT `platos_ibfk_1` FOREIGN KEY (`IdCategoria`) REFERENCES `categoria` (`IdCategoria`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platos`
--

LOCK TABLES `platos` WRITE;
/*!40000 ALTER TABLE `platos` DISABLE KEYS */;
INSERT INTO `platos` VALUES (1,'Patatas','Patatas de bolsa al punto de sal','https://ametllerorigen.vtexassets.com/arquivos/ids/162411-800-auto?width=800&height=auto&aspect=true',1.25,'Para abrir el apetito',1),(2,'Olivas','Olivas \'Receta de la abuela\'','https://www.aceitunas92.com/wp-content/uploads/2018/06/Ali%C3%B1adas_abuela_03.jpg',1.00,'Para abrir el apetito',1),(3,'Gazpacho','Auténtico gazpacho andaluz','https://www.gazpachoandaluz.org/wp-content/uploads/2018/05/gazpacho-andaluz.jpg',2.50,'Para abrir el apetito',1),(4,'Hummus','Pasta de garbanzos acompañada de crudité de verduras para mojar','https://ep01.epimg.net/elcomidista/imagenes/2020/05/20/articulo/1589998333_192170_1590044267_media_normal.jpg',4.00,'Para abrir el apetito',1),(5,'Setas','Setas con yema de huevo','http://ellunescierroelpico.com/wp-content/uploads/2016/11/IMG_8221.jpg',4.00,'Para abrir el apetito',1),(6,'Ensalada César','Lechuga romana, queso parmesano, croutons y salsa César','https://www.ecestaticos.com/image/clipping/7e21b991db215ff4e625699b2366444c/todos-los-trucos-para-hacer-la-autentica-ensalada-cesar.jpg',6.50,'Ensaladas',2),(7,'Ensalada Caprese','Queso caprese, tomate, aceitunas negras y albahaca','https://irecetasfaciles.com/wp-content/uploads/2018/10/ENSALADA-CAPRESE-e1539307853225.jpg',5.50,'Ensaladas',2),(8,'Ensalada Waldorf','Apio, manzana, nueces, pasas y mayonesa','https://cdn1.cocina-familiar.com/recetas/ensalada-waldorf.JPG',6.25,'Ensaladas',2),(9,'Ensalada griega','Lechuga, tomate, aceitunas negras y queso feta','http://www.comedera.com/wp-content/uploads/2018/05/ensalada-griega.jpg',5.00,'Ensaladas',2),(10,'Crema de calabaza y zanahoria','Crema de calabaza y zanahoria','https://okdiario.com/img/2018/02/22/crema-calabaza-zanahoria.jpg',4.50,'Cremas',2),(11,'Crema de verduras','Crema de verduras variadas (calabacín, puerro, cebolleta, zanahoria y patata)','https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/D6D12912-ACC7-4B2A-BBE6-918927CFE9EB/Derivates/8499AB12-BCCE-455D-AA37-698ADB1AD8C0.jpg',4.50,'Cremas',2),(12,'Melón con jamón','Melón con jamón','https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2013/08/melon-jamon.jpg',6.75,'Platos ligeros',2),(13,'Ensalada templada de arroz','Ensalada de arroz templado con verduras(calabacín, pimiento, maíz dulce y aguacate)','https://supersaludables.com/blog/wp-content/uploads/2018/06/Fotolia_74797413_Subscription_Monthly_M-1170x780.jpg',5.00,'Platos ligeros',2),(14,'Tataki de atún','Cortes de atún semihechos, acompañados de algas wakame y salsa ponzu','http://elpetitchef.com/Images/299/presentacion.jpg',11.00,'Pescados',3),(15,'Dorada a la marsellesa','Cortes de dorada acompañados de tomate, alcaparras, aceitunas y anchoas','https://i.blogs.es/ed5c61/dorada2/1366_2000.jpg',12.00,'Pescados',3),(16,'Salmón de la casa','Salmón al horno con salsa de cítricos','https://i.blogs.es/0fe42f/salmon-horno-citricosdap/840_560.jpg',9.00,'Pescados',3),(17,'Milanesa de ternera invertida','Escalope de ternera, queso y tomate acompañado de brotes tiernos','https://ep01.epimg.net/elcomidista/imagenes/2017/02/16/receta/1487255209_595139_1487600950_media_normal.jpg',7.50,'Carnes',3),(18,'Pollo al estragón con verduras','Pollo al estragón con guarnición de verdura campestre','https://www.hellmanns-centroamerica.com/Images/3436/3436-1131665-Pollo_en_salsa_de_estragon_mayonesa.jpg',9.00,'Carnes',3),(19,'Entrecot al roquefort','Entrecot de buey con salsa de queso roquefort y patatas','https://www.evacook.net/wp-content/uploads/2015/05/ENTRECOT-AL-ROQUEFORT.png',12.50,'Carnes',3),(20,'Arroz a la cubana','Arroz con huevos fritos, salsa de tomate y plátano frito','https://cdn1.cocina-familiar.com/pasos/4719.JPG',6.75,'Vegetarianos',3),(21,'Poke vegano','Bol de arroz con algas wakame, aguacate y tofu','https://recetasveganas.net/wp-content/uploads/2019/04/poke-bowl-vegano-recetas-vegetarianas-saludables.jpg',8.50,'Vegetarianos',3),(22,'Melanzane alla parmigiana','Lasaña de berenjena rellena de tomate y queso parmesano','https://www.donnamoderna.com/content/uploads/2003/11/parmigiana-di-melanzane-alla-griglia-725x545.jpg',8.00,'Vegetariano',3),(23,'Flan de huevo','Huevo cuajado al baño María con canela','https://sevilla.abc.es/gurme/wp-content/uploads/sites/24/2016/06/flan-de-huevo-casero.jpg',1.25,'Dulces',4),(24,'Mousse de chocolate','Crema de leche batida con chocolate negro','https://www.hola.com/imagenes/cocina/recetas/20200130159337/mousse-chocolate-postre-facil/0-776-92/mousse-chocolate-facil-rapido-teka-m.jpg',1.00,'Dulces',4),(25,'Tarta de frutos secos','Tarta de frutos secos','https://truffle-assets.imgix.net/62bbd675-tarta-de-frutas-secas_1920x1080-thumbnail.jpg',2.00,'Dulces',4),(26,'Crema catalana','Crema pastelera con base de yema cubierta por azúcar caramelizado','https://cocina-casera.com/wp-content/uploads/2014/04/crema-catalana-receta.jpg',1.25,'Dulces',4),(27,'Fruta de temporada','Manzanas, plátanos, peras o mandarinas','https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/frutas-1552246920.jpg',0.75,'Dulces',4);
/*!40000 ALTER TABLE `platos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `IdReserva` int NOT NULL AUTO_INCREMENT,
  `CantidadComensales` int NOT NULL,
  `PrecioTotal` decimal(10,2) NOT NULL,
  `FechaReserva` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `FechaReservada` date NOT NULL,
  `IdUsuario` int DEFAULT NULL,
  `IdFranja` int DEFAULT NULL,
  PRIMARY KEY (`IdReserva`),
  KEY `IdUsuario` (`IdUsuario`),
  KEY `IdFranja` (`IdFranja`),
  CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`IdUsuario`) REFERENCES `usuario` (`IdUsuario`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`IdFranja`) REFERENCES `franjahoraria` (`IdFranja`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (1,3,54.00,'2021-03-29 04:09:03','2021-04-01',3,7),(2,2,28.25,'2021-03-29 04:09:03','2021-04-01',6,10),(3,2,28.50,'2021-03-29 04:09:03','2021-04-01',8,10),(4,1,17.25,'2021-03-29 04:09:03','2021-04-01',9,2),(5,3,47.25,'2021-03-29 04:09:03','2021-04-01',10,3),(6,2,33.00,'2021-03-29 04:09:03','2021-04-01',13,5),(7,1,16.75,'2021-03-29 04:09:03','2021-04-01',14,7),(8,1,15.50,'2021-03-29 04:09:03','2021-04-01',15,10),(9,1,40.50,'2021-03-29 04:09:03','2021-04-01',16,11),(10,2,21.25,'2021-03-29 04:09:03','2021-04-01',17,2),(11,2,22.50,'2021-03-29 04:09:03','2021-04-02',2,6),(12,1,13.00,'2021-03-29 04:09:03','2021-04-02',3,7),(13,3,52.25,'2021-03-29 04:09:03','2021-04-02',4,1),(14,2,32.50,'2021-03-29 04:09:03','2021-04-02',7,5),(15,1,16.50,'2021-03-29 04:09:03','2021-04-02',8,10),(16,1,14.25,'2021-03-29 04:09:03','2021-04-02',9,12),(17,2,34.50,'2021-03-29 04:09:03','2021-04-02',10,10),(18,3,42.75,'2021-03-29 04:09:03','2021-04-02',12,10),(19,4,58.75,'2021-03-29 04:09:03','2021-04-05',3,7),(20,2,19.75,'2021-03-29 04:09:03','2021-04-05',7,5);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `IdRol` int NOT NULL AUTO_INCREMENT,
  `NombreRol` varchar(100) NOT NULL,
  `Descripcion` text,
  PRIMARY KEY (`IdRol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'administrador','Usuario administrativo, con autorizacion para hacer gestiones internas sobre la base de datos de la aplicacion'),(2,'usuario','Usuario llano, con autorizacion solo para realizar reservas');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `IdUsuario` int NOT NULL AUTO_INCREMENT,
  `NombreUsuario` varchar(100) DEFAULT NULL,
  `Contraseña` varchar(20) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `DNI` varchar(9) NOT NULL,
  `Telefono` int NOT NULL,
  `IdRol` int NOT NULL,
  PRIMARY KEY (`IdUsuario`),
  UNIQUE KEY `DNI` (`DNI`),
  UNIQUE KEY `NombreUsuario` (`NombreUsuario`),
  KEY `IdRol` (`IdRol`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`IdRol`) REFERENCES `rol` (`IdRol`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'UsuarioAdmin1','NoMeRobesPorFavor','Alba','Álvarez','1980-01-01','A0000001',607543432,1),(2,'UsuarioAdmin2','NoMeRobesPorFavor','Benito','Bastos','1981-08-15','B0000002',634598721,1),(3,'Usuario1','NoMeRobesPorFavor','Carmen','Castaño','1982-07-14','C0000003',667246678,2),(4,'Usuario2','NoMeRobesPorFavor','Diego','Descamps','1973-06-19','D0000004',621598888,2),(5,'Usuario3','NoMeRobesPorFavor','Emma','Echavarría','1983-06-22','E0000005',607476521,2),(6,'Usuario4','NoMeRobesPorFavor','Francisco','Fuertes','1961-11-23','F0000006',645987632,2),(7,'Usuario5','NoMeRobesPorFavor','Gabriela','Genover','1977-12-09','G0000007',621478965,2),(8,'Usuario6','NoMeRobesPorFavor','Héctor','Hernández','1969-03-07','H0000008',607548652,2),(9,'Usuario7','NoMeRobesPorFavor','Ingrid','Ibarra','1989-03-23','I0000009',607159357,2),(10,'Usuario8','NoMeRobesPorFavor','Joan','Jofresa','1991-04-25','J0000010',612345687,2),(11,'Usuario9','NoMeRobesPorFavor','Kelly','Kensington','1995-09-29','K0000011',622312258,2),(12,'Usuario10','NoMeRobesPorFavor','Leorio','Lanero','1987-01-02','L0000012',667899334,2),(13,'Usuario11','NoMeRobesPorFavor','Marta','Márquez','1999-01-01','M0000013',662444512,2),(14,'Usuario12','NoMeRobesPorFavor','Néstor','Nabal','2000-05-14','N0000014',697211324,2),(15,'Usuario13','NoMeRobesPorFavor','Olga','Ortiz','1984-08-15','O0000015',612841112,2),(16,'Usuario14','NoMeRobesPorFavor','Pablo','Puerta','1984-08-12','P0000016',634559621,2),(17,'Usuario15','NoMeRobesPorFavor','Qamra','Quesille','1999-09-19','Q0000017',617999129,2),(18,'Usuario16','NoMeRobesPorFavor','Rodrigo','Requena','1972-04-28','R0000018',632646656,2),(19,'Usuario17','NoMeRobesPorFavor','Sandra','Sandoval','2000-02-01','S0000019',647802020,2),(20,'Usuario18','NoMeRobesPorFavor','Terry','Tan','1974-11-20','T0000020',622196324,2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-29  4:12:43
