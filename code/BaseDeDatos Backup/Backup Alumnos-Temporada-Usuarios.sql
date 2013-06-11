CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 5.6.10, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.6.10

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
-- Table structure for table `actividades`
--

DROP TABLE IF EXISTS `actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividades` (
  `idActividades` int(11) NOT NULL AUTO_INCREMENT,
  `nAlumnos` int(11) NOT NULL,
  `descripcion` varchar(123) DEFAULT NULL,
  `precioSocio` float NOT NULL,
  `precioNoSocio` float NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `nombre` varchar(65) NOT NULL,
  `temporada_idTemporada` int(11) NOT NULL,
  PRIMARY KEY (`idActividades`,`temporada_idTemporada`),
  KEY `fk_actividades_temporada1_idx` (`temporada_idTemporada`),
  CONSTRAINT `fk_actividades_temporada1` FOREIGN KEY (`temporada_idTemporada`) REFERENCES `temporada` (`idTemporada`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades`
--

LOCK TABLES `actividades` WRITE;
/*!40000 ALTER TABLE `actividades` DISABLE KEYS */;
INSERT INTO `actividades` VALUES (1,25,'Pequeño torneo semana santa',50,70,'2013-06-05','2013-06-09','Torneo Semana Santa',1),(2,20,'Torneo de verano',50,70,'2013-08-01','2013-08-16','Torneo verano',2),(3,50,'Actividad de invierno',50,70,'2013-11-12','2013-12-26','Torneo Invierno',2);
/*!40000 ALTER TABLE `actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actividadesinstalacion`
--

DROP TABLE IF EXISTS `actividadesinstalacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividadesinstalacion` (
  `actividades_idActividades` int(11) NOT NULL,
  `actividades_Temporada_idTemporada` int(11) NOT NULL,
  `Instalacion_idInstalacion` int(11) NOT NULL,
  PRIMARY KEY (`actividades_idActividades`,`actividades_Temporada_idTemporada`,`Instalacion_idInstalacion`),
  KEY `fk_actividades_has_Instalacion_Instalacion1_idx` (`Instalacion_idInstalacion`),
  KEY `fk_actividades_has_Instalacion_actividades1_idx` (`actividades_idActividades`,`actividades_Temporada_idTemporada`),
  CONSTRAINT `fk_actividades_has_Instalacion_actividades1` FOREIGN KEY (`actividades_idActividades`) REFERENCES `actividades` (`idActividades`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_actividades_has_Instalacion_Instalacion1` FOREIGN KEY (`Instalacion_idInstalacion`) REFERENCES `instalacion` (`idInstalacion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividadesinstalacion`
--

LOCK TABLES `actividadesinstalacion` WRITE;
/*!40000 ALTER TABLE `actividadesinstalacion` DISABLE KEYS */;
INSERT INTO `actividadesinstalacion` VALUES (2,2,1),(3,2,1),(1,1,2);
/*!40000 ALTER TABLE `actividadesinstalacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `idAlumno` int(11) NOT NULL AUTO_INCREMENT,
  `talla` varchar(12) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `primerApellido` varchar(45) NOT NULL,
  `segundoApellido` varchar(45) NOT NULL,
  `nombrePadre` varchar(100) NOT NULL,
  `nombreMadre` varchar(100) NOT NULL,
  `numeroCuenta` varchar(40) DEFAULT NULL,
  `telMovil` int(11) NOT NULL,
  `telFijo` int(11) NOT NULL,
  `observaciones` varchar(300) DEFAULT NULL,
  `provincia` varchar(70) DEFAULT NULL,
  `localidad` varchar(45) DEFAULT NULL,
  `codigoPostal` int(11) DEFAULT NULL,
  `colegio` varchar(45) DEFAULT NULL,
  `domicilio` varchar(100) DEFAULT NULL,
  `email` varchar(75) DEFAULT NULL,
  `fechaNacimiento` date NOT NULL,
  `sexo` char(1) NOT NULL,
  PRIMARY KEY (`idAlumno`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (2,'M','carlos','Fernandez','Basso','Juan','Yolanda','12312213',667787267,977827606,'gran jugador','Granada','Granada',12345,'san idelfonso','C/ luis','carlos@gmail.com','2000-02-03','M'),(3,'L','Juan','Gomez','Gomez','Luis','Juana','23434553',666777888,968776655,NULL,'Granada','Maracena',18023,'Mulacen','C/ pedro','CDS@gmail.com','2001-02-06','M'),(4,'S','Luis','Hernandez','Sierra','Esteban','Luisa','54675545',657898734,958473277,NULL,'Granada','Granada',12098,'Francisco Ayala','C/ del Olmo','vvau@hotmail.com','2005-02-07','M'),(5,'XL','Manuel','Garcia','Fernandez','Manuel','Maria','23421451',677897654,958776898,NULL,'Granada','Granada',12089,'Generalife','C/ Galera','Maga@gmail.com','1998-02-03','M'),(6,'M','Marta','Garcia','Garrido','Luis','Julia','12342344',678398297,987325436,NULL,'Granada','Granada',12083,'Ave Maria','C/ olgoso','Mtarti@gmail.com','1999-02-09','F'),(7,'S','Luisa','Garcia','Ruano','Eladio','Carmen','23423141',678288289,958762839,NULL,'Granada','Granada',12345,'Monaita','C/ lupistre','olgora@gmail.com','2003-08-09','F'),(8,'M','Sebastian','Fernandez','Sierra','Sebastian','Isabel','43524532',653897654,968654346,NULL,'Granada','Maracena',12342,'Francisco Ayala','C/ leonor','Seba@gmail.com','2005-05-06','M'),(9,'L','Maria','Fernandez','Garcia','Luis','Maria','98984308',637824682,962747372,NULL,'Granada','Cajar',13456,'Luis Olmo','C/ Leopete','Marii@gmail.com','2007-06-04','F'),(10,'XL','Elena','Hernandez','Mesa','Juan','Eva','98676377',678265673,978525615,NULL,'Granada','Otura',14525,'Luis Crespo','C/ Gongora','Lssu@gmail.com','1997-07-08','F'),(11,'M','Eva','Fina','Segura','Esteban','Juana','97874847',693829838,978665544,NULL,'Granada','Granada',18097,'Monaita','C/ Herza','efs@gmail.com','1997-09-07','F'),(12,'L','Marcos','Mesa','Fernandez','Luis','Yolanda','98782738',675445454,987545345,'Problemas de rodilla','Granada','Alfacar',15712,'Elisuar','C/ Tensa','Marc@gmail.com','1997-09-14','M'),(13,'M','Pablo','Pozo','Mesa','Francisco','Rosa','12842988',672873872,958637267,NULL,'Granada','Otura',13122,'Generalife','C/ Sensa','Pab@hotmail.com','1998-08-17','M'),(14,'XL','Luis Manuel','Garcia','Pozo','Manuel','Francisca','43356454',687267783,958626661,NULL,'Granada','Granada',18092,'Generalife','C/ Gran capitan','ALsk@gmail.com','2003-09-25','M'),(15,'M','Alfonso','Ortega','Carrillo','Jose','Adela','56345345',678839291,958231827,NULL,'Granada','Granada',18047,'Virgen de gracia','C/ Barriada','alfo@gmail.com','2000-07-06','M'),(16,'XL','Adela','Fernandez','Gomez','Jose Maria ','Jessica','76765176',654323233,958262716,NULL,'Granada','Maracena',18290,'San Jose','C/ Consolacion','ade@hotmail.com','1999-08-12','F'),(17,'M','Carla','Fernandez','Gomez','Carlos Jesus','Jessica','59862445',662578963,958785412,NULL,'Granada','Albolote',18200,'Sagrado Corazon','C/Juan Miguel','carlafg@hotmail.com','2002-01-19','F'),(18,'L','Sergio','Rodriguez','Galvez','Juan','Aurora','87752465',668745230,958632577,NULL,'Granada','Armilla',18662,'Juan XXIII','C/Alhondiga','sergito@hotmail.com','1999-10-12','M'),(19,'S','Juan','Sanchez','Alonso','Carlos','Cristina','15788562',633258746,958548465,NULL,'Granada','Huetor',15825,'Sagrada Corazon','C/Justino','alonsofd@hotmail.com','1998-04-15','M'),(20,'M','Esther','Zamora','Lopez','Daniel','Esther','52335645',665874524,958545223,NULL,'Granada','Zagra',14788,'Emilio Carmona','C/San Sebastian','esther23@hotmail.com','1997-02-01','M'),(21,'S','Luisa','Lopez','Lopez','Sebastian','Yanira','83782890',678567566,958776452,NULL,'Granada','Granada',18019,'Monaita','C/ golear','Lui@gmail.com','1998-02-01','F'),(22,'L','Daniel','Guzman','Torres','Daniel','Luisa','43453452',677876272,958838727,NULL,'Granada','Granada',18021,'Virgen de Gracia','C/ Goleta','DAn@hotmail.com','2000-09-07','M'),(23,'XL','Sebastian','Robles','Alcantara','Juan','Maria','67267198',699837282,958273829,NULL,'Granada','Granada',18072,'Luis Crespo','C/ Alameda','Sesba@gmail.com','2001-09-13','M'),(24,'L','Esteban','Hurtado','Torres','Luis','Adela','43458974',693845475,958664636,NULL,'Granada','Maracena',18200,'Virgen de Gracia','C/ Puerta Real','Este@gmail.com','1999-06-09','M'),(25,'S','Marisa','Hernandez','Fernandez','Carlos','Juana','42343221',677823723,958662352,NULL,'Granada','Gabias',18272,'JuanXXIII','C/ Concepcion','Maris@hotmail.com','2003-07-03','F'),(26,'XL','Antonio','Ruiz','Carvajal','Juan','Juana','89274398',657847765,958154741,NULL,'Granada','Granada',18012,'Padre Majon','C/ Gran Via','jj@gmail.com','2000-12-07','M'),(27,'XL','Manuel','Casillas','Motos','Juanito','Juanita','86995994',647847765,958154269,NULL,'Granada','Granada',18012,'Padre Majon','C/ Gran Via','sucorreo','1999-12-07','M'),(28,'XL','Raul','Martinez','Campos','Pepico','Pepica','88484884',654454545,958151515,NULL,'Granada','Granada',18012,'Padre Majon','C/ Gran Via','sucorreo','1998-12-07','M'),(29,'XL','Luis','Lopez','Roca','Antonio','Antonia','48343983',654987478,958151213,NULL,'Granada','Granada',18012,'Padre Majon','C/ Gran Via','sucorreo','1997-12-07','M'),(30,'XL','Paco','Jimenez','Sevilla','Paco','Paca','23842983',698757472,958134849,NULL,'Granada','Granada',18012,'JuanXXIII','C/ Alameda','sucorreo','1998-12-07','M'),(31,'XL','Mario','Monti','Faria','Luis','Luisa','38247938',632141516,958414243,NULL,'Granada','Granada',18012,'JuanXXIII','C/ Alameda','sucorreo','1999-12-07','M'),(32,'XL','Luis','Gutierrez','Mesa','Pablo','Lucia','82938478',698858684,958191718,NULL,'Granada','Granada',18012,'JuanXXIII','C/ Alameda','sucorreo','1999-12-07','M'),(33,'XL','Alberto','Morales','Rodriguez','Ignacio','Raquel','39204839',635525655,958171819,NULL,'Granada','Granada',18018,'Sagrado Corazon','C/ Alameda','aasds@gmail.com','1990-12-07','M'),(34,'XL','Pedro','Muñoz','Fernandez','Pedro','Maria','34203844',698878889,958632514,NULL,'Granada','Granada',18018,'Sagrado Corazon','C/ Alameda','aas@gmail.com','1999-12-07','M'),(35,'XL','Sergio','Ramos','Lopez','Antonio','Carmen','32438493',654122321,698451516,NULL,'Granada','Granada',18018,'Sagrado Corazon','C/ ajasul','aas@gmail.com','1996-12-07','M'),(36,'XL','Carlos','Bailon','Perez','Antonio','Josefina','32434234',654121316,698451213,NULL,'Granada','Granada',18018,'Padre Majon','C/ ajasul','aas@gmail.com','1995-12-07','M'),(37,'M','Luisa','Fernandez','Ruiz','Antonio','Carmen','32423433',688493848,958992888,'llega tarde siempre','Granada','Granada',18018,'Padre Majon','C/ ajasul','Lui@gmail.com','2006-09-09','F'),(38,'L','Maria','Garcia','Fernandez','Juan','Luisa','67387278',677878983,958736278,NULL,'Granada','Granada',18092,'Monaita','C/ leandro','Maria@gmail.com','2005-06-07','F'),(39,'M','Gervasio','Fernandez ','Ortega','Luis','Yolanda','34934509',677873678,958776389,NULL,'Granada','Granada',18920,'Padre Majon','C/ asster','Gerva@gmail.com','2003-07-06','M'),(40,'L','Eva','Hurtado','Gomez','Francisco','Isabel','43453454',600349948,958776644,NULL,'Granada','Granada',18928,'Monaita','C/ lendoiro','ddll@gmail.com','2000-04-05','F');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnoequipo`
--

DROP TABLE IF EXISTS `alumnoequipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumnoequipo` (
  `Alumno_idAlumno` int(11) NOT NULL,
  `Equipo_idEquipo` int(11) NOT NULL,
  `Equipo_Fundacion_idFundacion` int(11) NOT NULL,
  `Equipo_Categoria_idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`Alumno_idAlumno`,`Equipo_idEquipo`,`Equipo_Fundacion_idFundacion`,`Equipo_Categoria_idCategoria`),
  KEY `fk_Alumno_has_Equipo_Equipo1_idx` (`Equipo_idEquipo`,`Equipo_Fundacion_idFundacion`,`Equipo_Categoria_idCategoria`),
  KEY `fk_Alumno_has_Equipo_Alumno1_idx` (`Alumno_idAlumno`),
  CONSTRAINT `fk_Alumno_has_Equipo_Alumno1` FOREIGN KEY (`Alumno_idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alumno_has_Equipo_Equipo1` FOREIGN KEY (`Equipo_idEquipo`, `Equipo_Fundacion_idFundacion`, `Equipo_Categoria_idCategoria`) REFERENCES `equipo` (`idEquipo`, `Fundacion_idFundacion`, `Categoria_idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnoequipo`
--

LOCK TABLES `alumnoequipo` WRITE;
/*!40000 ALTER TABLE `alumnoequipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumnoequipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnogrupo`
--

DROP TABLE IF EXISTS `alumnogrupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumnogrupo` (
  `Alumno_idAlumno` int(11) NOT NULL,
  `Grupo_idGrupo` int(11) NOT NULL,
  `Grupo_Categoria_idCategoria` int(11) NOT NULL,
  `Grupo_Usuario_idUsuario` int(11) NOT NULL,
  `Grupo_Temporada_idTemporada` int(11) NOT NULL,
  PRIMARY KEY (`Alumno_idAlumno`,`Grupo_idGrupo`,`Grupo_Categoria_idCategoria`,`Grupo_Usuario_idUsuario`,`Grupo_Temporada_idTemporada`),
  KEY `fk_Alumno_has_Grupo_Grupo1_idx` (`Grupo_idGrupo`,`Grupo_Categoria_idCategoria`,`Grupo_Usuario_idUsuario`,`Grupo_Temporada_idTemporada`),
  KEY `fk_Alumno_has_Grupo_Alumno1_idx` (`Alumno_idAlumno`),
  CONSTRAINT `fk_Alumno_has_Grupo_Alumno1` FOREIGN KEY (`Alumno_idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alumno_has_Grupo_Grupo1` FOREIGN KEY (`Grupo_idGrupo`, `Grupo_Categoria_idCategoria`, `Grupo_Usuario_idUsuario`, `Grupo_Temporada_idTemporada`) REFERENCES `grupo` (`idGrupo`, `Categoria_idCategoria`, `Usuario_idUsuario`, `Temporada_idTemporada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnogrupo`
--

LOCK TABLES `alumnogrupo` WRITE;
/*!40000 ALTER TABLE `alumnogrupo` DISABLE KEYS */;
INSERT INTO `alumnogrupo` VALUES (3,6,3,1,1),(4,7,1,3,2),(7,8,2,1,2),(8,7,1,3,2),(9,7,1,3,2),(10,9,5,1,2),(11,9,5,1,2),(12,9,5,1,2),(14,8,2,1,2),(20,9,5,1,2),(23,6,3,1,1),(25,8,2,1,2),(37,7,1,3,2);
/*!40000 ALTER TABLE `alumnogrupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumnotemporada`
--

DROP TABLE IF EXISTS `alumnotemporada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumnotemporada` (
  `Alumno_idAlumno` int(11) NOT NULL,
  `Temporada_idTemporada` int(11) NOT NULL,
  PRIMARY KEY (`Alumno_idAlumno`,`Temporada_idTemporada`),
  KEY `fk_Alumno_has_Temporada_Temporada1_idx` (`Temporada_idTemporada`),
  KEY `fk_Alumno_has_Temporada_Alumno1_idx` (`Alumno_idAlumno`),
  CONSTRAINT `fk_Alumno_has_Temporada_Alumno1` FOREIGN KEY (`Alumno_idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Alumno_has_Temporada_Temporada1` FOREIGN KEY (`Temporada_idTemporada`) REFERENCES `temporada` (`idTemporada`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnotemporada`
--

LOCK TABLES `alumnotemporada` WRITE;
/*!40000 ALTER TABLE `alumnotemporada` DISABLE KEYS */;
INSERT INTO `alumnotemporada` VALUES (3,1),(23,1),(4,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(14,2),(20,2),(25,2),(37,2);
/*!40000 ALTER TABLE `alumnotemporada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `edadmin` int(11) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'benjamín','(9-10 años)',9),(2,'alevín','(10-12 años)',10),(3,'infantil','(12-14 años)',12),(4,'cadete','(14-16 años)',14),(5,'junior','(16-18 años)',16);
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuota`
--

DROP TABLE IF EXISTS `cuota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuota` (
  `idCuota` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `pagado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idCuota`)
) ENGINE=InnoDB AUTO_INCREMENT=227 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuota`
--

LOCK TABLES `cuota` WRITE;
/*!40000 ALTER TABLE `cuota` DISABLE KEYS */;
INSERT INTO `cuota` VALUES (110,'2012-09-01',0),(111,'2012-10-01',0),(112,'2012-11-01',0),(113,'2012-12-01',0),(114,'2013-01-01',0),(115,'2013-02-01',0),(116,'2013-03-01',0),(117,'2013-04-01',0),(118,'2013-05-01',0),(119,'2012-09-01',0),(120,'2012-10-01',0),(121,'2012-11-01',0),(122,'2012-12-01',0),(123,'2013-01-01',0),(124,'2013-02-01',0),(125,'2013-03-01',0),(126,'2013-04-01',0),(127,'2013-05-01',0),(128,'2013-09-01',0),(129,'2013-10-01',0),(130,'2013-11-01',0),(131,'2013-12-01',0),(132,'2014-01-01',0),(133,'2014-02-01',0),(134,'2014-03-01',0),(135,'2014-04-01',0),(136,'2014-05-01',0),(137,'2013-09-01',0),(138,'2013-10-01',0),(139,'2013-11-01',0),(140,'2013-12-01',0),(141,'2014-01-01',0),(142,'2014-02-01',0),(143,'2014-03-01',0),(144,'2014-04-01',0),(145,'2014-05-01',0),(146,'2013-09-01',0),(147,'2013-10-01',0),(148,'2013-11-01',0),(149,'2013-12-01',0),(150,'2014-01-01',0),(151,'2014-02-01',0),(152,'2014-03-01',0),(153,'2014-04-01',0),(154,'2014-05-01',0),(155,'2013-09-01',0),(156,'2013-10-01',0),(157,'2013-11-01',0),(158,'2013-12-01',0),(159,'2014-01-01',0),(160,'2014-02-01',0),(161,'2014-03-01',0),(162,'2014-04-01',0),(163,'2014-05-01',0),(164,'2013-09-01',0),(165,'2013-10-01',0),(166,'2013-11-01',0),(167,'2013-12-01',0),(168,'2014-01-01',0),(169,'2014-02-01',0),(170,'2014-03-01',0),(171,'2014-04-01',0),(172,'2014-05-01',0),(173,'2013-09-01',0),(174,'2013-10-01',0),(175,'2013-11-01',0),(176,'2013-12-01',0),(177,'2014-01-01',0),(178,'2014-02-01',0),(179,'2014-03-01',0),(180,'2014-04-01',0),(181,'2014-05-01',0),(182,'2013-09-01',0),(183,'2013-10-01',0),(184,'2013-11-01',0),(185,'2013-12-01',0),(186,'2014-01-01',0),(187,'2014-02-01',0),(188,'2014-03-01',0),(189,'2014-04-01',0),(190,'2014-05-01',0),(191,'2013-09-01',0),(192,'2013-10-01',0),(193,'2013-11-01',0),(194,'2013-12-01',0),(195,'2014-01-01',0),(196,'2014-02-01',0),(197,'2014-03-01',0),(198,'2014-04-01',0),(199,'2014-05-01',0),(200,'2013-09-01',0),(201,'2013-10-01',0),(202,'2013-11-01',0),(203,'2013-12-01',0),(204,'2014-01-01',0),(205,'2014-02-01',0),(206,'2014-03-01',0),(207,'2014-04-01',0),(208,'2014-05-01',0),(209,'2013-09-01',0),(210,'2013-10-01',0),(211,'2013-11-01',0),(212,'2013-12-01',0),(213,'2014-01-01',0),(214,'2014-02-01',0),(215,'2014-03-01',0),(216,'2014-04-01',0),(217,'2014-05-01',0),(218,'2013-09-01',0),(219,'2013-10-01',0),(220,'2013-11-01',0),(221,'2013-12-01',0),(222,'2014-01-01',0),(223,'2014-02-01',0),(224,'2014-03-01',0),(225,'2014-04-01',0),(226,'2014-05-01',0);
/*!40000 ALTER TABLE `cuota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipo` (
  `idEquipo` int(11) NOT NULL AUTO_INCREMENT,
  `Fundacion_idFundacion` int(11) NOT NULL,
  `Categoria_idCategoria` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fundacion` tinyint(1) NOT NULL,
  `liga_idLiga` int(11) NOT NULL,
  `temporada_idTemporada` int(11) NOT NULL,
  `sexo` char(1) NOT NULL,
  PRIMARY KEY (`idEquipo`,`Fundacion_idFundacion`,`Categoria_idCategoria`,`liga_idLiga`,`temporada_idTemporada`),
  KEY `fk_Equipo_Fundacion_idx` (`Fundacion_idFundacion`),
  KEY `fk_Equipo_Categoria1_idx` (`Categoria_idCategoria`),
  KEY `fk_equipo_liga1_idx` (`liga_idLiga`),
  KEY `fk_equipo_temporada1_idx` (`temporada_idTemporada`),
  CONSTRAINT `fk_equipo_liga1` FOREIGN KEY (`liga_idLiga`) REFERENCES `liga` (`idLiga`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Equipo_Categoria1` FOREIGN KEY (`Categoria_idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Equipo_Fundacion` FOREIGN KEY (`Fundacion_idFundacion`) REFERENCES `fundacion` (`idFundacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_equipo_temporada1` FOREIGN KEY (`temporada_idTemporada`) REFERENCES `temporada` (`idTemporada`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadisticaalumno`
--

DROP TABLE IF EXISTS `estadisticaalumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadisticaalumno` (
  `partido_idPartido` int(11) NOT NULL,
  `partido_idEquipo` int(11) NOT NULL,
  `partido_equipo_Fundacion_idFundacion` int(11) NOT NULL,
  `partido_equipo_Categoria_idCategoria` int(11) NOT NULL,
  `partido_equipo_Temporada_idTemporada` int(11) NOT NULL,
  `partido_equipo_liga_idLiga` int(11) NOT NULL,
  `partido_idEquipoVisitante` int(11) NOT NULL,
  `partido_equipo_Fundacion_idFundacion1` int(11) NOT NULL,
  `partido_equipo_Categoria_idCategoria1` int(11) NOT NULL,
  `partido_equipo_Temporada_idTemporada1` int(11) NOT NULL,
  `partido_equipo_liga_idLiga1` int(11) NOT NULL,
  `alumno_idAlumno` int(11) NOT NULL,
  `puntos` int(11) DEFAULT NULL,
  `rebotesOfensivos` int(11) DEFAULT NULL,
  `rebotesDefensivos` int(11) DEFAULT NULL,
  `asistencias` int(11) DEFAULT NULL,
  `robos` int(11) DEFAULT NULL,
  `perdidas` int(11) DEFAULT NULL,
  PRIMARY KEY (`partido_idPartido`,`partido_idEquipo`,`partido_equipo_Fundacion_idFundacion`,`partido_equipo_Categoria_idCategoria`,`partido_equipo_Temporada_idTemporada`,`partido_equipo_liga_idLiga`,`partido_idEquipoVisitante`,`partido_equipo_Fundacion_idFundacion1`,`partido_equipo_Categoria_idCategoria1`,`partido_equipo_Temporada_idTemporada1`,`partido_equipo_liga_idLiga1`,`alumno_idAlumno`),
  KEY `fk_partido_has_alumno_alumno1_idx` (`alumno_idAlumno`),
  KEY `fk_partido_has_alumno_partido1_idx` (`partido_idPartido`,`partido_idEquipo`,`partido_equipo_Fundacion_idFundacion`,`partido_equipo_Categoria_idCategoria`,`partido_equipo_Temporada_idTemporada`,`partido_equipo_liga_idLiga`,`partido_idEquipoVisitante`,`partido_equipo_Fundacion_idFundacion1`,`partido_equipo_Categoria_idCategoria1`,`partido_equipo_Temporada_idTemporada1`,`partido_equipo_liga_idLiga1`),
  CONSTRAINT `fk_partido_has_alumno_alumno1` FOREIGN KEY (`alumno_idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_partido_has_alumno_partido1` FOREIGN KEY (`partido_idPartido`, `partido_idEquipo`, `partido_equipo_Fundacion_idFundacion`, `partido_equipo_Categoria_idCategoria`, `partido_equipo_Temporada_idTemporada`, `partido_equipo_liga_idLiga`, `partido_idEquipoVisitante`, `partido_equipo_Fundacion_idFundacion1`, `partido_equipo_Categoria_idCategoria1`, `partido_equipo_Temporada_idTemporada1`, `partido_equipo_liga_idLiga1`) REFERENCES `partido` (`idPartido`, `idEquipo`, `equipo_Fundacion_idFundacion`, `equipo_Categoria_idCategoria`, `equipo_Temporada_idTemporada`, `equipo_liga_idLiga`, `idEquipoVisitante`, `equipo_Fundacion_idFundacion1`, `equipo_Categoria_idCategoria1`, `equipo_Temporada_idTemporada1`, `equipo_liga_idLiga1`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadisticaalumno`
--

LOCK TABLES `estadisticaalumno` WRITE;
/*!40000 ALTER TABLE `estadisticaalumno` DISABLE KEYS */;
/*!40000 ALTER TABLE `estadisticaalumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fundacion`
--

DROP TABLE IF EXISTS `fundacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fundacion` (
  `idFundacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `cp` int(11) DEFAULT NULL,
  `ccc` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idFundacion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fundacion`
--

LOCK TABLES `fundacion` WRITE;
/*!40000 ALTER TABLE `fundacion` DISABLE KEYS */;
INSERT INTO `fundacion` VALUES (1,'Granda CB',18091,'12432134','CBGranada@GranadaBaloncesto.com'),(2,'FundacionFantasma',1000,'1000','fantas@gmail.com');
/*!40000 ALTER TABLE `fundacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo` (
  `idGrupo` int(11) NOT NULL AUTO_INCREMENT,
  `n_alumnos` int(11) NOT NULL DEFAULT '0',
  `Categoria_idCategoria` int(11) NOT NULL,
  `Usuario_idUsuario` int(11) NOT NULL,
  `Temporada_idTemporada` int(11) NOT NULL,
  `Horario_idHorario` int(11) NOT NULL,
  `Horario_Instalacion_idInstalacion` int(11) NOT NULL,
  PRIMARY KEY (`idGrupo`,`Categoria_idCategoria`,`Usuario_idUsuario`,`Temporada_idTemporada`,`Horario_idHorario`,`Horario_Instalacion_idInstalacion`),
  KEY `fk_Grupo_Categoria1_idx` (`Categoria_idCategoria`),
  KEY `fk_Grupo_Usuario1_idx` (`Usuario_idUsuario`),
  KEY `fk_Grupo_Temporada1_idx` (`Temporada_idTemporada`),
  KEY `fk_grupo_Horario1_idx` (`Horario_idHorario`,`Horario_Instalacion_idInstalacion`),
  CONSTRAINT `fk_Grupo_Categoria1` FOREIGN KEY (`Categoria_idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_grupo_Horario1` FOREIGN KEY (`Horario_idHorario`, `Horario_Instalacion_idInstalacion`) REFERENCES `horario` (`idHorario`, `Instalacion_idInstalacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Grupo_Temporada1` FOREIGN KEY (`Temporada_idTemporada`) REFERENCES `temporada` (`idTemporada`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Grupo_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` VALUES (6,2,3,1,1,6,3),(7,4,1,3,2,7,6),(8,3,2,1,2,8,6),(9,4,5,1,2,9,3);
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horario` (
  `idHorario` int(11) NOT NULL AUTO_INCREMENT,
  `Instalacion_idInstalacion` int(11) NOT NULL,
  `dia1` varchar(45) NOT NULL,
  `dia2` varchar(45) NOT NULL,
  `hora1` time NOT NULL,
  `hora2` time NOT NULL,
  PRIMARY KEY (`idHorario`,`Instalacion_idInstalacion`),
  KEY `fk_Horario_Instalacion1_idx` (`Instalacion_idInstalacion`),
  CONSTRAINT `fk_Horario_Instalacion1` FOREIGN KEY (`Instalacion_idInstalacion`) REFERENCES `instalacion` (`idInstalacion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
INSERT INTO `horario` VALUES (6,3,'Lunes','Viernes','17:00:00','17:00:00'),(7,6,'Martes','Viernes','18:00:00','18:00:00'),(8,6,'Lunes','Miercoles','16:00:00','16:00:00'),(9,3,'Martes','Jueves','17:00:00','17:00:00');
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instalacion`
--

DROP TABLE IF EXISTS `instalacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instalacion` (
  `idInstalacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(85) NOT NULL,
  `capacidadEquipos` int(11) NOT NULL,
  `localizacion` varchar(140) NOT NULL,
  PRIMARY KEY (`idInstalacion`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instalacion`
--

LOCK TABLES `instalacion` WRITE;
/*!40000 ALTER TABLE `instalacion` DISABLE KEYS */;
INSERT INTO `instalacion` VALUES (1,'Escolapios',6,'Calle Altomayor'),(2,'Polideportivo la chana',2,'Calle chana'),(3,'Soto Mayor',4,'Calle Angelical'),(4,'polideportivo Armilla',10,'Avenida Alameda Real'),(5,'Polideportivo Zaidin',12,'Plaza La Soledad'),(6,'Mulacen',6,'Carretera Cordoba');
/*!40000 ALTER TABLE `instalacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `liga`
--

DROP TABLE IF EXISTS `liga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `liga` (
  `idLiga` int(11) NOT NULL AUTO_INCREMENT,
  `Categoria_idCategoria` int(11) NOT NULL,
  `Temporada_idTemporada` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idLiga`,`Categoria_idCategoria`,`Temporada_idTemporada`),
  KEY `fk_Liga_Categoria1_idx` (`Categoria_idCategoria`),
  KEY `fk_Liga_Temporada1_idx` (`Temporada_idTemporada`),
  CONSTRAINT `fk_Liga_Categoria1` FOREIGN KEY (`Categoria_idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Liga_Temporada1` FOREIGN KEY (`Temporada_idTemporada`) REFERENCES `temporada` (`idTemporada`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liga`
--

LOCK TABLES `liga` WRITE;
/*!40000 ALTER TABLE `liga` DISABLE KEYS */;
INSERT INTO `liga` VALUES (1,2,1,'PMD 2012-2013 alevin L1'),(2,2,1,'PMD 2012-2013 alevin L2');
/*!40000 ALTER TABLE `liga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagoactividades`
--

DROP TABLE IF EXISTS `pagoactividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagoactividades` (
  `Alumno_idAlumno` int(11) NOT NULL,
  `Actividades_idActividades` int(11) NOT NULL,
  `Actividades_Temporada_idTemporada` int(11) NOT NULL,
  `Cuota_idCuota` int(11) NOT NULL,
  PRIMARY KEY (`Alumno_idAlumno`,`Actividades_idActividades`,`Actividades_Temporada_idTemporada`,`Cuota_idCuota`),
  KEY `fk_Alumno_has_Actividades_Actividades1_idx` (`Actividades_idActividades`,`Actividades_Temporada_idTemporada`),
  KEY `fk_Alumno_has_Actividades_Alumno1_idx` (`Alumno_idAlumno`),
  KEY `fk_PagoActividades_Cuota1_idx` (`Cuota_idCuota`),
  CONSTRAINT `fk_Alumno_has_Actividades_Actividades1` FOREIGN KEY (`Actividades_idActividades`) REFERENCES `actividades` (`idActividades`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Alumno_has_Actividades_Alumno1` FOREIGN KEY (`Alumno_idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_PagoActividades_Cuota1` FOREIGN KEY (`Cuota_idCuota`) REFERENCES `cuota` (`idCuota`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagoactividades`
--

LOCK TABLES `pagoactividades` WRITE;
/*!40000 ALTER TABLE `pagoactividades` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagoactividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagotemporada`
--

DROP TABLE IF EXISTS `pagotemporada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagotemporada` (
  `idPagoTemporada` int(11) NOT NULL AUTO_INCREMENT,
  `Cuota_idCuota` int(11) NOT NULL,
  `AlumnoTemporada_Alumno_idAlumno` int(11) NOT NULL,
  `AlumnoTemporada_Temporada_idTemporada` int(11) NOT NULL,
  PRIMARY KEY (`idPagoTemporada`,`Cuota_idCuota`,`AlumnoTemporada_Alumno_idAlumno`,`AlumnoTemporada_Temporada_idTemporada`),
  KEY `fk_PagoTemporada_Cuota1_idx` (`Cuota_idCuota`),
  KEY `fk_PagoTemporada_AlumnoTemporada1_idx` (`AlumnoTemporada_Alumno_idAlumno`,`AlumnoTemporada_Temporada_idTemporada`),
  CONSTRAINT `fk_PagoTemporada_Cuota1` FOREIGN KEY (`Cuota_idCuota`) REFERENCES `cuota` (`idCuota`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_PagoTemporada_AlumnoTemporada1` FOREIGN KEY (`AlumnoTemporada_Alumno_idAlumno`, `AlumnoTemporada_Temporada_idTemporada`) REFERENCES `alumnotemporada` (`Alumno_idAlumno`, `Temporada_idTemporada`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=226 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagotemporada`
--

LOCK TABLES `pagotemporada` WRITE;
/*!40000 ALTER TABLE `pagotemporada` DISABLE KEYS */;
INSERT INTO `pagotemporada` VALUES (109,110,3,1),(110,111,3,1),(111,112,3,1),(112,113,3,1),(113,114,3,1),(114,115,3,1),(115,116,3,1),(116,117,3,1),(117,118,3,1),(118,119,23,1),(119,120,23,1),(120,121,23,1),(121,122,23,1),(122,123,23,1),(123,124,23,1),(124,125,23,1),(125,126,23,1),(126,127,23,1),(127,128,4,2),(128,129,4,2),(129,130,4,2),(130,131,4,2),(131,132,4,2),(132,133,4,2),(133,134,4,2),(134,135,4,2),(135,136,4,2),(136,137,8,2),(137,138,8,2),(138,139,8,2),(139,140,8,2),(140,141,8,2),(141,142,8,2),(142,143,8,2),(143,144,8,2),(144,145,8,2),(145,146,9,2),(146,147,9,2),(147,148,9,2),(148,149,9,2),(149,150,9,2),(150,151,9,2),(151,152,9,2),(152,153,9,2),(153,154,9,2),(154,155,37,2),(155,156,37,2),(156,157,37,2),(157,158,37,2),(158,159,37,2),(159,160,37,2),(160,161,37,2),(161,162,37,2),(162,163,37,2),(163,164,7,2),(164,165,7,2),(165,166,7,2),(166,167,7,2),(167,168,7,2),(168,169,7,2),(169,170,7,2),(170,171,7,2),(171,172,7,2),(172,173,14,2),(173,174,14,2),(174,175,14,2),(175,176,14,2),(176,177,14,2),(177,178,14,2),(178,179,14,2),(179,180,14,2),(180,181,14,2),(181,182,25,2),(182,183,25,2),(183,184,25,2),(184,185,25,2),(185,186,25,2),(186,187,25,2),(187,188,25,2),(188,189,25,2),(189,190,25,2),(190,191,10,2),(191,192,10,2),(192,193,10,2),(193,194,10,2),(194,195,10,2),(195,196,10,2),(196,197,10,2),(197,198,10,2),(198,199,10,2),(199,200,11,2),(200,201,11,2),(201,202,11,2),(202,203,11,2),(203,204,11,2),(204,205,11,2),(205,206,11,2),(206,207,11,2),(207,208,11,2),(208,209,12,2),(209,210,12,2),(210,211,12,2),(211,212,12,2),(212,213,12,2),(213,214,12,2),(214,215,12,2),(215,216,12,2),(216,217,12,2),(217,218,20,2),(218,219,20,2),(219,220,20,2),(220,221,20,2),(221,222,20,2),(222,223,20,2),(223,224,20,2),(224,225,20,2),(225,226,20,2);
/*!40000 ALTER TABLE `pagotemporada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partido`
--

DROP TABLE IF EXISTS `partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partido` (
  `idEquipo` int(11) NOT NULL,
  `equipo_Fundacion_idFundacion` int(11) NOT NULL,
  `equipo_Categoria_idCategoria` int(11) NOT NULL,
  `equipo_Temporada_idTemporada` int(11) NOT NULL,
  `equipo_liga_idLiga` int(11) NOT NULL,
  `idEquipoVisitante` int(11) NOT NULL,
  `equipo_Fundacion_idFundacion1` int(11) NOT NULL,
  `equipo_Categoria_idCategoria1` int(11) NOT NULL,
  `equipo_Temporada_idTemporada1` int(11) NOT NULL,
  `equipo_liga_idLiga1` int(11) NOT NULL,
  `idPartido` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `resultadoLocal` int(11) DEFAULT NULL,
  `resultadoVisitante` int(11) DEFAULT NULL,
  `hora` time DEFAULT NULL,
  PRIMARY KEY (`idPartido`,`idEquipo`,`equipo_Fundacion_idFundacion`,`equipo_Categoria_idCategoria`,`equipo_Temporada_idTemporada`,`equipo_liga_idLiga`,`idEquipoVisitante`,`equipo_Fundacion_idFundacion1`,`equipo_Categoria_idCategoria1`,`equipo_Temporada_idTemporada1`,`equipo_liga_idLiga1`),
  KEY `fk_equipo_has_equipo_equipo2_idx` (`idEquipoVisitante`,`equipo_Fundacion_idFundacion1`,`equipo_Categoria_idCategoria1`,`equipo_Temporada_idTemporada1`,`equipo_liga_idLiga1`),
  KEY `fk_equipo_has_equipo_equipo1_idx` (`idEquipo`,`equipo_Fundacion_idFundacion`,`equipo_Categoria_idCategoria`,`equipo_Temporada_idTemporada`,`equipo_liga_idLiga`),
  KEY `fk_equipo_has_equipo_equipo1` (`idEquipo`,`equipo_Fundacion_idFundacion`,`equipo_Categoria_idCategoria`,`equipo_liga_idLiga`),
  KEY `fk_equipo_has_equipo_equipo2` (`idEquipoVisitante`,`equipo_Fundacion_idFundacion1`,`equipo_Categoria_idCategoria1`,`equipo_liga_idLiga1`),
  CONSTRAINT `fk_equipo_has_equipo_equipo1` FOREIGN KEY (`idEquipo`, `equipo_Fundacion_idFundacion`, `equipo_Categoria_idCategoria`, `equipo_liga_idLiga`) REFERENCES `equipo` (`idEquipo`, `Fundacion_idFundacion`, `Categoria_idCategoria`, `liga_idLiga`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipo_has_equipo_equipo2` FOREIGN KEY (`idEquipoVisitante`, `equipo_Fundacion_idFundacion1`, `equipo_Categoria_idCategoria1`, `equipo_liga_idLiga1`) REFERENCES `equipo` (`idEquipo`, `Fundacion_idFundacion`, `Categoria_idCategoria`, `liga_idLiga`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partido`
--

LOCK TABLES `partido` WRITE;
/*!40000 ALTER TABLE `partido` DISABLE KEYS */;
/*!40000 ALTER TABLE `partido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rango`
--

DROP TABLE IF EXISTS `rango`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rango` (
  `Usuario_idUsuario` int(11) NOT NULL,
  `Equipo_idEquipo` int(11) NOT NULL,
  `Equipo_Fundacion_idFundacion` int(11) NOT NULL,
  `Equipo_Categoria_idCategoria` int(11) NOT NULL,
  `Equipo_Temporada_idTemporada` int(11) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`Usuario_idUsuario`,`Equipo_idEquipo`,`Equipo_Fundacion_idFundacion`,`Equipo_Categoria_idCategoria`,`Equipo_Temporada_idTemporada`),
  KEY `fk_Usuario_has_Equipo_Equipo1_idx` (`Equipo_idEquipo`,`Equipo_Fundacion_idFundacion`,`Equipo_Categoria_idCategoria`,`Equipo_Temporada_idTemporada`),
  KEY `fk_Usuario_has_Equipo_Usuario1_idx` (`Usuario_idUsuario`),
  CONSTRAINT `fk_Usuario_has_Equipo_Equipo1` FOREIGN KEY (`Equipo_idEquipo`, `Equipo_Fundacion_idFundacion`, `Equipo_Categoria_idCategoria`) REFERENCES `equipo` (`idEquipo`, `Fundacion_idFundacion`, `Categoria_idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_Equipo_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rango`
--

LOCK TABLES `rango` WRITE;
/*!40000 ALTER TABLE `rango` DISABLE KEYS */;
/*!40000 ALTER TABLE `rango` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temporada`
--

DROP TABLE IF EXISTS `temporada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `temporada` (
  `idTemporada` int(11) NOT NULL AUTO_INCREMENT,
  `curso` varchar(45) NOT NULL,
  `inicio` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `importeMensual` float DEFAULT NULL,
  PRIMARY KEY (`idTemporada`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temporada`
--

LOCK TABLES `temporada` WRITE;
/*!40000 ALTER TABLE `temporada` DISABLE KEYS */;
INSERT INTO `temporada` VALUES (1,'2012/2013','2012-09-01','2012-05-31',91),(2,'2013/2014','2013-09-15','2014-05-17',95);
/*!40000 ALTER TABLE `temporada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `primerApellido` varchar(75) NOT NULL,
  `segundoApellido` varchar(45) NOT NULL,
  `DNI` varchar(12) NOT NULL,
  `clave` varchar(30) DEFAULT '0000',
  `entrenador` tinyint(1) DEFAULT '0',
  `numeroCuenta` varchar(45) DEFAULT NULL,
  `telMovil` int(11) DEFAULT NULL,
  `telFijo` int(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `user` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Jose','Mouriño','Garcia','22331133F','123',1,'123112311',667879878,967884324,'top@gmail.com','mou'),(2,'Jesus','Garcia','Domingo','33786754C','clave',0,'678873978',678954532,958776689,'xus@gmail.com','jesus'),(3,'Ruben','Fernandez','Gomez','34562439S','clave',1,'890027928',667827828,958772652,'Rus@gmail.com','ruben'),(4,'Daniel','Ruiz','Basso','23432523G','clave',1,'848238743',678524314,958776162,'Danii@gmail.com','dani'),(5,'Jose Luis','Torejon','Pareja','12331231K','jose',1,'884988398',668738201,957882718,'joselillo@gmail.com','jose'),(6,'Francisco','Fernandez','Pozo','43423498L','clave',0,'987726567',677867256,982781772,'Frr@gmail.com','Paco');
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

-- Dump completed on 2013-06-11 20:59:16
