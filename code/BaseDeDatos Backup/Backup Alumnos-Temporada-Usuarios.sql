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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades`
--

LOCK TABLES `actividades` WRITE;
/*!40000 ALTER TABLE `actividades` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (2,'M','carlos','Fernandez','Basso','Juan','Yolanda','12312213',667787267,977827606,'gran jugador','Granada','Granada',12345,'san idelfonso','C/ luis','carlos@gmail.com','2000-02-03','M'),(3,'L','Juan','Gomez','Gomez','Luis','Juana','23434553',666777888,968776655,NULL,'Granada','Maracena',18023,'Mulacen','C/ pedro','CDS@gmail.com','2001-02-06','M'),(4,'S','Luis','Hernandez','Sierra','Esteban','Luisa','54675545',657898734,958473277,NULL,'Granada','Granada',12098,'Francisco Ayala','C/ del Olmo','vvau@hotmail.com','2005-02-07','M'),(5,'XL','Manuel','Garcia','Fernandez','Manuel','Maria','23421451',677897654,958776898,NULL,'Granada','Granada',12089,'Generalife','C/ Galera','Maga@gmail.com','1998-02-03','M'),(6,'M','Marta','Garcia','Garrido','Luis','Julia','12342344',678398297,987325436,NULL,'Granada','Granada',12083,'Ave Maria','C/ olgoso','Mtarti@gmail.com','1999-02-09','F'),(7,'S','Luisa','Garcia','Ruano','Eladio','Carmen','23423141',678288289,958762839,NULL,'Granada','Granada',12345,'Monaita','C/ lupistre','olgora@gmail.com','2003-08-09','F'),(8,'M','Sebastian','Fernandez','Sierra','Sebastian','Isabel','43524532',653897654,968654346,NULL,'Granada','Maracena',12342,'Francisco Ayala','C/ leonor','Seba@gmail.com','2005-05-06','M'),(9,'L','Maria','Fernandez','Garcia','Luis','Maria','98984308',637824682,962747372,NULL,'Granada','Cajar',13456,'Luis Olmo','C/ Leopete','Marii@gmail.com','2007-06-04','F'),(10,'XL','Elena','Hernandez','Mesa','Juan','Eva','98676377',678265673,978525615,NULL,'Granada','Otura',14525,'Luis Crespo','C/ Gongora','Lssu@gmail.com','1997-07-08','F'),(11,'M','Eva','Fina','Segura','Esteban','Juana','97874847',693829838,978665544,NULL,'Granada','Granada',18097,'Monaita','C/ Herza','efs@gmail.com','1997-09-07','F'),(12,'L','Marcos','Mesa','Fernandez','Luis','Yolanda','98782738',675445454,987545345,'Problemas de rodilla','Granada','Alfacar',15712,'Elisuar','C/ Tensa','Marc@gmail.com','1997-09-14','M'),(13,'M','Pablo','Pozo','Mesa','Francisco','Rosa','12842988',672873872,958637267,NULL,'Granada','Otura',13122,'Generalife','C/ Sensa','Pab@hotmail.com','1998-08-17','M'),(14,'XL','Luis Manuel','Garcia','Pozo','Manuel','Francisca','43356454',687267783,958626661,NULL,'Granada','Granada',18092,'Generalife','C/ Gran capitan','ALsk@gmail.com','2003-09-25','M'),(15,'M','Alfonso','Ortega','Carrillo','Jose','Adela','56345345',678839291,958231827,NULL,'Granada','Granada',18047,'Virgen de gracia','C/ Barriada','alfo@gmail.com','2000-07-06','M'),(16,'XL','Adela','Fernandez','Gomez','Jose Maria ','Jessica','76765176',654323233,958262716,NULL,'Granada','Maracena',18290,'San Jose','C/ Consolacion','ade@hotmail.com','1999-08-12','F'),(17,'M','Carla','Fernandez','Gomez','Carlos Jesus','Jessica','59862445',662578963,958785412,NULL,'Granada','Albolote',18200,'Sagrado Corazon','C/Juan Miguel','carlafg@hotmail.com','2002-01-19','F'),(18,'L','Sergio','Rodriguez','Galvez','Juan','Aurora','87752465',668745230,958632577,NULL,'Granada','Armilla',18662,'Juan XXIII','C/Alhondiga','sergito@hotmail.com','1999-10-12','M'),(19,'S','Juan','Sanchez','Alonso','Carlos','Cristina','15788562',633258746,958548465,NULL,'Granada','Huetor',15825,'Sagrada Corazon','C/Justino','alonsofd@hotmail.com','1998-04-15','M'),(20,'M','Esther','Zamora','Lopez','Daniel','Esther','52335645',665874524,958545223,NULL,'Granada','Zagra',14788,'Emilio Carmona','C/San Sebastian','esther23@hotmail.com','1997-02-01','M'),(21,'S','Luisa','Lopez','Lopez','Sebastian','Yanira','83782890',678567566,958776452,NULL,'Granada','Granada',18019,'Monaita','C/ golear','Lui@gmail.com','1998-02-01','F'),(22,'L','Daniel','Guzman','Torres','Daniel','Luisa','43453452',677876272,958838727,NULL,'Granada','Granada',18021,'Virgen de Gracia','C/ Goleta','DAn@hotmail.com','2000-09-07','M'),(23,'XL','Sebastian','Robles','Alcantara','Juan','Maria','67267198',699837282,958273829,NULL,'Granada','Granada',18072,'Luis Crespo','C/ Alameda','Sesba@gmail.com','2001-09-13','M'),(24,'L','Esteban','Hurtado','Torres','Luis','Adela','43458974',693845475,958664636,NULL,'Granada','Maracena',18200,'Virgen de Gracia','C/ Puerta Real','Este@gmail.com','1999-06-09','M'),(25,'S','Marisa','Hernandez','Fernandez','Carlos','Juana','42343221',677823723,958662352,NULL,'Granada','Gabias',18272,'JuanXXIII','C/ Concepcion','Maris@hotmail.com','2003-07-03','F');
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
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuota`
--

LOCK TABLES `cuota` WRITE;
/*!40000 ALTER TABLE `cuota` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
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
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idLiga`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `liga`
--

LOCK TABLES `liga` WRITE;
/*!40000 ALTER TABLE `liga` DISABLE KEYS */;
INSERT INTO `liga` VALUES (1,'PMD 2012-2013 alevin'),(2,'PMD 2011-2012 alevin');
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
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagotemporada`
--

LOCK TABLES `pagotemporada` WRITE;
/*!40000 ALTER TABLE `pagotemporada` DISABLE KEYS */;
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

-- Dump completed on 2013-06-09 21:16:41
