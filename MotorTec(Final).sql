CREATE DATABASE  IF NOT EXISTS `motortec` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `motortec`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: motortec
-- ------------------------------------------------------
-- Server version	8.0.12


--
-- Table structure for table `auto`
--

DROP TABLE IF EXISTS `auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `auto` (
  `idAuto` int(11) NOT NULL UNIQUE AUTO_INCREMENT,
  `idConcesionario` int(11) NOT NULL,
  `idModelo` int(11) NOT NULL,
  `Matricula` varchar(20) DEFAULT NULL,
  `Estado` varchar(45) DEFAULT NULL,
  `Color` varchar(20) DEFAULT NULL,
  `Kilometraje` int(11) DEFAULT NULL,
  `Precio` int(11) DEFAULT NULL,
  CHECK (`Precio` >= 0) ,
  PRIMARY KEY (`idAuto`),
  KEY `idConcesionario_idx` (`idConcesionario`),
  KEY `idModelo_idx` (`idModelo`),
  CONSTRAINT `idConcesionarioAuto` FOREIGN KEY (`idConcesionario`) REFERENCES `concesionario` (`idconcesionario`),
  CONSTRAINT `idModelo` FOREIGN KEY (`idModelo`) REFERENCES `modelo` (`idmodelo`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto`
--

LOCK TABLES `auto` WRITE;
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
INSERT INTO `auto` VALUES (1,2,1,NULL,'Nuevo','Rojo',0,30000000),(2,1,2,NULL,'Nuevo','Gris',0,15000000),(3,2,3,'CFR-321','Usado','Azul',5000,18000000),(4,2,4,NULL,'Nuevo','Blanco',0,20000000),(5,1,5,'BGW-981','Usado','Azul',52000,20000000),(6,2,6,'EPR-647','Usado','Verde',15000,11000000),(7,2,7,NULL,'Nuevo','Negro',0,14000000),(8,2,8,NULL,'Nuevo','Negro Mate',0,160000000),(9,1,9,NULL,'Nuevo','Rojo',0,25000000),(10,2,10,'SQJ-749','Usado','Verde Claro',98000,10500000),(11,1,11,NULL,'Nuevo','Azul',0,25000000),(12,2,12,NULL,'Nuevo','Amarillo',0,140000000),(13,1,13,NULL,'Nuevo','Naranja',0,13000000),(14,1,14,'XLY-720','Usado','Blanco',6500,8000000),(15,2,15,'106427','Usado','Champagne',30000,6000000),(16,2,16,'907832','Usado','Azul',20000,7000000),(17,1,17,'MQG-481','Usado','Verde Oscuro',17500,10000000),(18,2,18,'720859','Usado','Rojo Mate',8000,11000000),(19,2,19,'682302','Usado','Blanco',26000,12000000),(20,2,20,'NXZ-100','Usado','Amarillo',21000,17000000),(21,1,21,'207421','Usado','Azul Oscuro',35000,9000000),(22,1,22,'689025','Usado','Gris Claro',75000,9500000),(23,1,23,'821406','Usado','Negro',40000,18500000),(24,1,24,'RMX-980','Usado','Champagne',53000,19000000),(25,1,25,'JMB-007','Usado','Negro Mate',38000,20000000);
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `canton`
--

DROP TABLE IF EXISTS `canton`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `canton` (
  `idCanton` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idCanton`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `canton`
--

LOCK TABLES `canton` WRITE;
/*!40000 ALTER TABLE `canton` DISABLE KEYS */;
INSERT INTO `canton` VALUES (1,'Acosta'),(2,'Alajuelita'),(3,'Aserrí'),(4,'Curridabat'),(5,'Dota'),(6,'Escazú'),(7,'Moravia'),(8,'Atenas'),(9,'Grecia'),(10,'Guatuso'),(11,'Los Chiles'),(12,'Naranjo'),(13,'El Guarco'),(14,'Alvarado'),(15,'Oreamuno'),(16,'La Unión'),(17,'Barva'),(18,'Belén'),(19,'Flores'),(20,'San Pablo'),(21,'San Rafaél'),(22,'Liberia'),(23,'Abangares'),(24,'Bagaces'),(25,'Cañas'),(26,'Carrillo'),(27,'Hojancha'),(28,'Quepos'),(29,'Buenos Aires'),(30,'Coto Brus'),(31,'Esparza'),(32,'Golfito'),(33,'Pococí'),(34,'Guácimo'),(35,'Siquirres');
/*!40000 ALTER TABLE `canton` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `idDireccion` int(11) DEFAULT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `PrimerApellido` varchar(45) DEFAULT NULL,
  `SegundoApellido` varchar(45) DEFAULT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `idDireccion_idx` (`idDireccion`),
  CONSTRAINT `idDireccionCliente` FOREIGN KEY (`idDireccion`) REFERENCES `direccion` (`iddireccion`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,1,'Enrique','Altamirano','García','85476392'),(2,2,'Lorenzo','Flores','Salinas','82567106'),(3,3,'Carlos','Díaz','Cruz','74521896'),(4,4,'Armando','Domínguez ','Otarola','80000896'),(5,5,'José Luis','Cuevas','Nolasco','62457837'),(6,6,'Gabriel','Fallas','Hernández','55107895'),(7,7,'Baltazar','Cortés','Avendaño','27108765'),(8,8,'Norma','Delgado','Bugarín','83340000'),(9,9,'Pedro','Picado','Mora','70986458'),(10,10,'Alejandro','Ortíz','Jiménez','63352554'),(11,11,'Axel','Estrada','Picado','68465156'),(12,12,'Leonardo','Domínguez ','Velazco','78494942'),(13,13,'Natalia','González','Víquez','89962470'),(14,14,'Verónica','López','Pérez','86325204'),(15,15,'Aníbal','Castro','Borbón','72913249'),(16,16,'Luis','Cervantes','Rivera','62587415'),(17,17,'Alicia','Montero','Chacón','80632148'),(18,18,'Ricardo','Durán','Cordero','79632842'),(19,19,'Norma','Bugarín','Morales','24452976'),(20,20,'Alberto','Gamboa','Salinas','62307894');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concesionario`
--

DROP TABLE IF EXISTS `concesionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `concesionario` (
  `idConcesionario` int(11) NOT NULL AUTO_INCREMENT,
  `idDireccion` int(11) DEFAULT NULL,
  `NombreConcesionario` varchar(45) NOT NULL,
  PRIMARY KEY (`idConcesionario`),
  KEY `idDireccion_idx` (`idDireccion`),
  CONSTRAINT `idDireccionConcesionario` FOREIGN KEY (`idDireccion`) REFERENCES `direccion` (`iddireccion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concesionario`
--

LOCK TABLES `concesionario` WRITE;
/*!40000 ALTER TABLE `concesionario` DISABLE KEYS */;
INSERT INTO `concesionario` VALUES (1,NULL,'Grupo Q'),(2,NULL,'Purdy Motor');
/*!40000 ALTER TABLE `concesionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `direccion` (
  `idDireccion` int(11) NOT NULL AUTO_INCREMENT,
  `idPais` int(11) NOT NULL,
  `idProvincia` int(11) NOT NULL,
  `idCanton` int(11) NOT NULL,
  `Detalles` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idDireccion`),
  KEY `idPais_idx` (`idPais`),
  KEY `idProvincia_idx` (`idProvincia`),
  KEY `idCanton_idx` (`idCanton`),
  CONSTRAINT `idCanton` FOREIGN KEY (`idCanton`) REFERENCES `canton` (`idcanton`),
  CONSTRAINT `idPais` FOREIGN KEY (`idPais`) REFERENCES `pais` (`idpais`),
  CONSTRAINT `idProvincia` FOREIGN KEY (`idProvincia`) REFERENCES `provincia` (`idprovincia`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccion`
--

LOCK TABLES `direccion` WRITE;
/*!40000 ALTER TABLE `direccion` DISABLE KEYS */;
INSERT INTO `direccion` VALUES (1,1,1,1,NULL),(2,1,2,8,'100 mts este de la gasolinera'),(3,1,3,13,'50 mts sur y 40 oeste de la entrada principal'),(4,1,4,17,NULL),(5,1,5,22,NULL),(6,1,6,28,'Barrio Los Pinares '),(7,1,7,33,NULL),(8,1,1,2,NULL),(9,1,2,9,NULL),(10,1,3,14,'70mts norte del almacen Don Julio'),(11,1,4,18,NULL),(12,1,5,23,NULL),(13,1,6,29,NULL),(14,1,7,34,'200 mts este de la pulpería Dos pinos'),(15,1,1,3,NULL),(16,1,2,10,NULL),(17,1,3,15,'Barrio El Molino, 150 mts sur del Asembis'),(18,1,4,19,NULL),(19,1,5,24,NULL),(20,1,6,30,NULL),(21,1,7,35,'20 mts norte del Walmart'),(22,1,1,4,'40 mts sur de la Guacamaya'),(23,1,2,11,'Centro comercial la Orquídea , contiguo a la farmacia'),(24,1,3,16,'Frente a la ferretería El Caucho'),(25,1,4,20,'60 mts oeste y 100 norte de la tienda Jazz'),(26,1,5,25,'80 mts este y 20 oeste de la intersección'),(27,1,1,5,'Contiguo al MasXMenos'),(28,1,2,12,'25 mts sur y 70 norte de Cosechas'),(29,1,4,21,'300 mts norte de Pequeño Mundo'),(30,1,5,26,'75 mts sur del Palí'),(31,1,1,6,'Costado este del edificio JM'),(32,1,1,7,'250 mts oeste del PeriMercados');
/*!40000 ALTER TABLE `direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `marca` (
  `idMarca` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`idMarca`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'Toyota'),(2,'Nissan'),(3,'Chevrolet'),(4,'Hyundai'),(5,'Izuzu'),(6,'Kia');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mecanico`
--

DROP TABLE IF EXISTS `mecanico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mecanico` (
  `idMecanico` int(11) NOT NULL AUTO_INCREMENT,
  `idTaller` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `PrimerApellido` varchar(45) DEFAULT NULL,
  `SegundoApellido` varchar(45) DEFAULT NULL,
  `FechaContratacion` date DEFAULT NULL,
  `Salario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idMecanico`),
  KEY `idTaller_idx` (`idTaller`),
  CONSTRAINT `idTallerMecanico` FOREIGN KEY (`idTaller`) REFERENCES `taller` (`idtaller`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mecanico`
--

LOCK TABLES `mecanico` WRITE;
/*!40000 ALTER TABLE `mecanico` DISABLE KEYS */;
INSERT INTO `mecanico` VALUES (1,1,'José','Álvarez','Pineda','2011-07-25',115000),(2,2,'Manuel','Quesada','Martínez','2010-03-17',125000),(3,3,'Juan','Abarca','Quirós','2011-05-01',115000),(4,4,'Andrés','López','Villalobos','2013-09-20',140000),(5,5,'Álvaro','Víquez','Estrada','2015-01-09',120000),(6,6,'Cristopher','Núñez','Chávez','2017-10-15',110000),(7,7,'Josué','Guerrero','Camacho','2015-06-28',118000),(8,8,'Pablo','Gutierrez','Brenes','2018-04-05',135000),(9,9,'Ignacio','Jiménez','López','2017-08-30',112000),(10,10,'Kevin','Morera','Zúñiga','2018-05-12',130000),(11,10,'Felix','Fernández','Zeledón','2017-12-17',150000),(12,9,'Jonathan','Juárez','Pérez','2017-05-15',115000),(13,8,'César','Cambronero','Rivas','2017-09-29',160000),(14,7,'Julio','Jiménez','Brenes','2016-06-12',145000),(15,6,'Kenneth','Tencio','Sequeira','2015-02-28',200000),(16,5,'Martin','Cassol','González','2016-10-17',160000),(17,4,'Ricardo','Gómez','Carvajal','2017-07-11',130000),(18,3,'Juan','Marín','Mesén','2018-03-21',115000),(19,2,'Daniel','Delemos','Ramírez','2017-05-09',155000),(20,1,'Matias','Esquivel','Arias','2014-01-28',210000),(21,4,'Joel','Campbell','Castro','2016-09-18',150000),(22,4,'Jesús','Lemus','Quiel','2017-01-05',140000),(23,4,'Marcos','Esquivel','Rojas','2015-11-02',190000);
/*!40000 ALTER TABLE `mecanico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelo`
--

DROP TABLE IF EXISTS `modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `modelo` (
  `idModelo` int(11) NOT NULL AUTO_INCREMENT,
  `idMarca` int(11) NOT NULL,
  `Nombre` varchar(15) NOT NULL,
  PRIMARY KEY (`idModelo`),
  KEY `idMarcaModelo_idx` (`idMarca`),
  CONSTRAINT `idMarcaModelo` FOREIGN KEY (`idMarca`) REFERENCES `marca` (`idmarca`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelo`
--

LOCK TABLES `modelo` WRITE;
/*!40000 ALTER TABLE `modelo` DISABLE KEYS */;
INSERT INTO `modelo` VALUES (1,1,'Hilux'),(2,1,'Coroya'),(3,1,'Yaris'),(4,1,'Land Cruiser'),(5,1,'Rav4'),(6,1,'Verso'),(7,2,'Tiida'),(8,2,'Note'),(9,2,'Navara'),(10,2,'Micra'),(11,2,'QashQai'),(12,2,'Murano'),(13,2,'X-Trail'),(14,3,'Cruze'),(15,3,'Aveo'),(16,3,'Trax'),(17,4,'Santa Fe'),(18,4,'Elantra'),(19,4,'i10'),(20,4,'Tucson'),(21,4,'Kona'),(22,5,'D-Max'),(23,6,'Picanto'),(24,6,'Rio'),(25,6,'Niro');
/*!40000 ALTER TABLE `modelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pais` (
  `idPais` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idPais`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'Costa Rica'),(2,'Panamá'),(3,'Nicaragua'),(4,'Colombia'),(5,'Honduras'),(6,'Guatemala');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `provincia` (
  `idProvincia` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idProvincia`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
INSERT INTO `provincia` VALUES (1,'San José'),(2,'Alajuela'),(3,'Cartago'),(4,'Heredia'),(5,'Guanacaste'),(6,'Puntarenas'),(7,'Limón');
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reparacion`
--

DROP TABLE IF EXISTS `reparacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reparacion` (
  `idReparacion` int(11) NOT NULL AUTO_INCREMENT,
  `idAuto` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idMecanico` int(11) NOT NULL,
  `idTaller` int(11) NOT NULL,
  `HorasReparando` int(11) DEFAULT NULL,
  `FechaReparacion` date DEFAULT NULL,
  PRIMARY KEY (`idReparacion`),
  KEY `idAuto_idx` (`idAuto`),
  KEY `idCliente_idx` (`idCliente`),
  KEY `idMecanico_idx` (`idMecanico`),
  KEY `idTaller_idx` (`idTaller`),
  CONSTRAINT `idAutoReparacion` FOREIGN KEY (`idAuto`) REFERENCES `auto` (`idauto`),
  CONSTRAINT `idClienteReparacion` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `idMecanicoReparacion` FOREIGN KEY (`idMecanico`) REFERENCES `mecanico` (`idmecanico`),
  CONSTRAINT `idTallerReparacion` FOREIGN KEY (`idTaller`) REFERENCES `taller` (`idtaller`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reparacion`
--

LOCK TABLES `reparacion` WRITE;
/*!40000 ALTER TABLE `reparacion` DISABLE KEYS */;
INSERT INTO `reparacion` VALUES (1,3,2,1,1,4,'2018-04-23'),(2,5,1,1,1,12,'2015-09-11'),(3,6,7,5,5,2,'2017-02-01'),(4,10,6,3,3,5,'2014-11-22'),(5,14,18,9,9,27,'2016-12-02'),(6,5,1,4,4,12,'2015-09-11'),(7,5,1,7,7,12,'2015-09-11'),(8,17,4,8,8,1,'2018-06-30'),(9,18,14,2,2,3,'2011-12-10'),(10,20,3,7,7,15,'2017-08-13'),(11,24,15,4,4,49,'2018-03-06'),(12,24,15,21,4,49,'2018-03-06'),(13,24,15,22,4,32,'2018-03-06'),(14,24,15,23,4,18,'2018-03-06'),(15,24,15,17,4,42,'2018-03-06'),(16,24,15,21,4,5,'2018-04-01'),(17,24,15,4,4,12,'2018-04-28'),(18,24,15,23,4,6,'2018-09-16'),(19,19,12,5,5,15,'2016-12-11'),(20,19,12,16,5,11,'2016-12-11'),(21,19,12,1,1,2,'2017-02-14'),(22,6,7,13,8,5,'2016-07-06'),(23,18,14,20,1,72,'2018-04-25'),(24,18,14,1,1,72,'2018-04-25'),(25,16,3,19,2,19,'2018-01-30'),(26,16,3,2,2,15,'2018-01-30'),(27,10,6,18,3,4,'2016-12-29'),(28,10,6,3,3,4,'2016-12-29'),(29,16,3,9,9,1,'2018-05-11'),(30,18,14,6,6,7,'2017-10-10'),(31,14,18,21,4,96,'2018-01-14'),(32,14,18,17,4,48,'2018-01-14'),(33,14,18,22,4,96,'2018-01-14'),(34,14,18,4,4,72,'2018-01-14'),(35,14,18,23,4,60,'2018-01-14'),(36,17,4,14,7,5,'2017-12-31'),(37,3,2,11,10,4,'2018-11-26'),(38,3,2,10,10,4,'2018-11-26'),(39,5,1,13,8,10,'2017-03-03'),(40,6,7,12,9,5,'2018-04-04'),(41,6,7,9,9,2,'2018-04-04'),(42,18,14,15,6,9,'2018-07-22'),(43,18,14,6,6,3,'2018-09-09'),(44,6,7,2,2,13,'2017-11-03'),(45,22,5,23,4,15,'2018-05-28'),(46,22,5,17,4,15,'2018-05-28'),(47,22,5,4,4,10,'2018-05-28'),(48,5,1,7,7,2,'2018-12-02'),(49,18,14,13,8,12,'2017-12-15'),(50,18,14,8,8,6,'2017-12-15');
/*!40000 ALTER TABLE `reparacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taller`
--

DROP TABLE IF EXISTS `taller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `taller` (
  `idTaller` int(11) NOT NULL AUTO_INCREMENT,
  `idDireccion` int(11) DEFAULT NULL,
  `idConcesionario` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idTaller`),
  KEY `idDireccion_idx` (`idDireccion`),
  KEY `idConcesionario_idx` (`idConcesionario`),
  CONSTRAINT `idConcesionarioTaller` FOREIGN KEY (`idConcesionario`) REFERENCES `concesionario` (`idconcesionario`),
  CONSTRAINT `idDireccionTaller` FOREIGN KEY (`idDireccion`) REFERENCES `direccion` (`iddireccion`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taller`
--

LOCK TABLES `taller` WRITE;
/*!40000 ALTER TABLE `taller` DISABLE KEYS */;
INSERT INTO `taller` VALUES (1,21,1,'ReparAuto'),(2,22,1,'ServiRuedas'),(3,23,2,'Tecniautos'),(4,24,1,'Todo Repuesto'),(5,25,2,'Súper Radiador'),(6,26,2,'Reparo Express'),(7,27,1,'Mecanicos24 '),(8,28,2,'Servimovil  Express'),(9,29,2,'Servimecanicos'),(10,30,1,'El Repara todo');
/*!40000 ALTER TABLE `taller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL AUTO_INCREMENT,
  `idConcesionario` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idAuto` int(11) NOT NULL,
  `FechaVenta` datetime DEFAULT NULL,
  `PrecioDeVenta` int(11) DEFAULT NULL,
  PRIMARY KEY (`idVenta`),
  KEY `idConcesionario_idx` (`idConcesionario`),
  KEY `idCliente_idx` (`idCliente`),
  KEY `idAuto_idx` (`idAuto`),
  CONSTRAINT `idAutoVenta` FOREIGN KEY (`idAuto`) REFERENCES `auto` (`idauto`),
  CONSTRAINT `idClienteVenta` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `idConcesionarioVenta` FOREIGN KEY (`idConcesionario`) REFERENCES `concesionario` (`idconcesionario`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,1,1,5,'2014-11-26 00:00:00',20000000),(2,2,2,3,'2017-09-14 00:00:00',18000000),(3,2,7,6,'2016-12-02 00:00:00',11000000),(4,2,6,10,'2014-05-28 00:00:00',10500000),(5,1,18,14,'2016-02-06 00:00:00',8000000),(6,1,4,17,'2017-10-11 00:00:00',10000000),(7,2,14,18,'2011-05-05 00:00:00',11000000),(8,2,3,20,'2016-12-27 00:00:00',17000000),(9,1,15,24,'2017-02-18 00:00:00',19000000),(10,2,12,19,'2015-08-12 00:00:00',12000000),(11,2,3,16,'2018-01-03 00:00:00',7000000),(12,1,5,22,'2017-06-27 00:00:00',9500000),(13,2,8,1,'2018-09-21 00:00:00',30000000),(14,2,8,15,'2016-10-30 00:00:00',6000000),(15,1,9,2,'2017-11-24 00:00:00',15000000),(16,2,11,4,'2017-03-22 00:00:00',20000000),(17,2,13,8,'2015-12-29 00:00:00',160000000),(18,2,17,7,'2017-08-03 00:00:00',14000000),(19,1,13,9,'2018-02-15 00:00:00',25000000),(20,2,16,12,'2016-06-06 00:00:00',140000000),(21,1,19,11,'2017-07-28 00:00:00',25000000),(22,1,19,23,'2017-11-03 00:00:00',18500000),(23,2,19,12,'2018-04-26 00:00:00',140000000),(24,1,20,2,'2017-12-01 00:00:00',15000000),(25,1,20,9,'2018-08-21 00:00:00',25000000);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-26 22:06:20
