SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `mydb` ;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`temporada`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`temporada` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`temporada` (
  `idTemporada` INT(11) NOT NULL AUTO_INCREMENT ,
  `curso` VARCHAR(45) NOT NULL ,
  `inicio` DATE NULL DEFAULT NULL ,
  `fin` DATE NULL DEFAULT NULL ,
  `importeMensual` FLOAT NULL ,
  PRIMARY KEY (`idTemporada`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`actividades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`actividades` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`actividades` (
  `idActividades` INT(11) NOT NULL AUTO_INCREMENT ,
  `nAlumnos` INT(11) NOT NULL ,
  `descripcion` VARCHAR(123) NULL DEFAULT NULL ,
  `precioSocio` FLOAT NOT NULL ,
  `precioNoSocio` FLOAT NOT NULL ,
  `fechaInicio` DATE NOT NULL ,
  `fechaFin` DATE NOT NULL ,
  `nombre` VARCHAR(65) NOT NULL ,
  `temporada_idTemporada` INT(11) NOT NULL ,
  PRIMARY KEY (`idActividades`, `temporada_idTemporada`) ,
  INDEX `fk_actividades_temporada1_idx` (`temporada_idTemporada` ASC) ,
  CONSTRAINT `fk_actividades_temporada1`
    FOREIGN KEY (`temporada_idTemporada` )
    REFERENCES `mydb`.`temporada` (`idTemporada` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`alumno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`alumno` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`alumno` (
  `idAlumno` INT(11) NOT NULL AUTO_INCREMENT ,
  `talla` VARCHAR(12) NOT NULL ,
  `nombre` VARCHAR(45) NOT NULL ,
  `primerApellido` VARCHAR(45) NOT NULL ,
  `segundoApellido` VARCHAR(45) NOT NULL ,
  `nombrePadre` VARCHAR(100) NOT NULL ,
  `nombreMadre` VARCHAR(100) NOT NULL ,
  `numeroCuenta` VARCHAR(40) NULL DEFAULT NULL ,
  `telMovil` INT(11) NOT NULL ,
  `telFijo` INT(11) NOT NULL ,
  `observaciones` VARCHAR(300) NULL DEFAULT NULL ,
  `provincia` VARCHAR(70) NULL DEFAULT NULL ,
  `localidad` VARCHAR(45) NULL DEFAULT NULL ,
  `codigoPostal` INT(11) NULL DEFAULT NULL ,
  `colegio` VARCHAR(45) NULL DEFAULT NULL ,
  `domicilio` VARCHAR(100) NULL DEFAULT NULL ,
  `email` VARCHAR(75) NULL DEFAULT NULL ,
  `fechaNacimiento` DATE NOT NULL ,
  `sexo` CHAR NOT NULL ,
  PRIMARY KEY (`idAlumno`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`categoria` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`categoria` (
  `idCategoria` INT(11) NOT NULL AUTO_INCREMENT ,
  `tipo` VARCHAR(45) NULL DEFAULT NULL ,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`idCategoria`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`fundacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`fundacion` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`fundacion` (
  `idFundacion` INT(11) NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NOT NULL ,
  `cp` INT(11) NULL DEFAULT NULL ,
  `ccc` VARCHAR(45) NULL DEFAULT NULL ,
  `email` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`idFundacion`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`liga`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`liga` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`liga` (
  `idLiga` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NULL ,
  PRIMARY KEY (`idLiga`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`equipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`equipo` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`equipo` (
  `idEquipo` INT(11) NOT NULL AUTO_INCREMENT ,
  `Fundacion_idFundacion` INT(11) NOT NULL ,
  `Categoria_idCategoria` INT(11) NOT NULL ,
  `nombre` VARCHAR(45) NOT NULL ,
  `fundacion` TINYINT(1) NOT NULL ,
  `liga_idLiga` INT NOT NULL ,
  `temporada_idTemporada` INT(11) NOT NULL ,
  PRIMARY KEY (`idEquipo`, `Fundacion_idFundacion`, `Categoria_idCategoria`, `liga_idLiga`, `temporada_idTemporada`) ,
  INDEX `fk_Equipo_Fundacion_idx` (`Fundacion_idFundacion` ASC) ,
  INDEX `fk_Equipo_Categoria1_idx` (`Categoria_idCategoria` ASC) ,
  INDEX `fk_equipo_liga1_idx` (`liga_idLiga` ASC) ,
  INDEX `fk_equipo_temporada1_idx` (`temporada_idTemporada` ASC) ,
  CONSTRAINT `fk_Equipo_Categoria1`
    FOREIGN KEY (`Categoria_idCategoria` )
    REFERENCES `mydb`.`categoria` (`idCategoria` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Equipo_Fundacion`
    FOREIGN KEY (`Fundacion_idFundacion` )
    REFERENCES `mydb`.`fundacion` (`idFundacion` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_equipo_liga1`
    FOREIGN KEY (`liga_idLiga` )
    REFERENCES `mydb`.`liga` (`idLiga` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipo_temporada1`
    FOREIGN KEY (`temporada_idTemporada` )
    REFERENCES `mydb`.`temporada` (`idTemporada` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`alumnoequipo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`alumnoequipo` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`alumnoequipo` (
  `Alumno_idAlumno` INT(11) NOT NULL ,
  `Equipo_idEquipo` INT(11) NOT NULL ,
  `Equipo_Fundacion_idFundacion` INT(11) NOT NULL ,
  `Equipo_Categoria_idCategoria` INT(11) NOT NULL ,
  PRIMARY KEY (`Alumno_idAlumno`, `Equipo_idEquipo`, `Equipo_Fundacion_idFundacion`, `Equipo_Categoria_idCategoria`) ,
  INDEX `fk_Alumno_has_Equipo_Equipo1_idx` (`Equipo_idEquipo` ASC, `Equipo_Fundacion_idFundacion` ASC, `Equipo_Categoria_idCategoria` ASC) ,
  INDEX `fk_Alumno_has_Equipo_Alumno1_idx` (`Alumno_idAlumno` ASC) ,
  CONSTRAINT `fk_Alumno_has_Equipo_Alumno1`
    FOREIGN KEY (`Alumno_idAlumno` )
    REFERENCES `mydb`.`alumno` (`idAlumno` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alumno_has_Equipo_Equipo1`
    FOREIGN KEY (`Equipo_idEquipo` , `Equipo_Fundacion_idFundacion` , `Equipo_Categoria_idCategoria` )
    REFERENCES `mydb`.`equipo` (`idEquipo` , `Fundacion_idFundacion` , `Categoria_idCategoria` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`usuario` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(45) NOT NULL ,
  `primerApellido` VARCHAR(75) NOT NULL ,
  `segundoApellido` VARCHAR(45) NOT NULL ,
  `DNI` VARCHAR(12) NOT NULL ,
  `clave` VARCHAR(30) NULL DEFAULT '0000' ,
  `entrenador` TINYINT(1) NULL DEFAULT '0' ,
  `numeroCuenta` VARCHAR(45) NULL ,
  `telMovil` INT NULL ,
  `telFijo` INT NULL ,
  `email` VARCHAR(45) NULL ,
  `user` VARCHAR(45) NULL ,
  PRIMARY KEY (`idUsuario`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`Instalacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Instalacion` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Instalacion` (
  `idInstalacion` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(85) NOT NULL ,
  `capacidadEquipos` INT NOT NULL ,
  `localizacion` VARCHAR(140) NOT NULL ,
  PRIMARY KEY (`idInstalacion`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Horario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Horario` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`Horario` (
  `idHorario` INT NOT NULL AUTO_INCREMENT ,
  `Instalacion_idInstalacion` INT NOT NULL ,
  `dia1` VARCHAR(45) NOT NULL ,
  `dia2` VARCHAR(45) NOT NULL ,
  `hora1` TIME NOT NULL ,
  `hora2` TIME NOT NULL ,
  PRIMARY KEY (`idHorario`, `Instalacion_idInstalacion`) ,
  INDEX `fk_Horario_Instalacion1_idx` (`Instalacion_idInstalacion` ASC) ,
  CONSTRAINT `fk_Horario_Instalacion1`
    FOREIGN KEY (`Instalacion_idInstalacion` )
    REFERENCES `mydb`.`Instalacion` (`idInstalacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`grupo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`grupo` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`grupo` (
  `idGrupo` INT(11) NOT NULL AUTO_INCREMENT ,
  `n_alumnos` INT(11) NOT NULL DEFAULT '0' ,
  `Categoria_idCategoria` INT(11) NOT NULL ,
  `Usuario_idUsuario` INT(11) NOT NULL ,
  `Temporada_idTemporada` INT(11) NOT NULL ,
  `Horario_idHorario` INT NOT NULL ,
  `Horario_Instalacion_idInstalacion` INT NOT NULL ,
  PRIMARY KEY (`idGrupo`, `Categoria_idCategoria`, `Usuario_idUsuario`, `Temporada_idTemporada`, `Horario_idHorario`, `Horario_Instalacion_idInstalacion`) ,
  INDEX `fk_Grupo_Categoria1_idx` (`Categoria_idCategoria` ASC) ,
  INDEX `fk_Grupo_Usuario1_idx` (`Usuario_idUsuario` ASC) ,
  INDEX `fk_Grupo_Temporada1_idx` (`Temporada_idTemporada` ASC) ,
  INDEX `fk_grupo_Horario1_idx` (`Horario_idHorario` ASC, `Horario_Instalacion_idInstalacion` ASC) ,
  CONSTRAINT `fk_Grupo_Categoria1`
    FOREIGN KEY (`Categoria_idCategoria` )
    REFERENCES `mydb`.`categoria` (`idCategoria` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Grupo_Temporada1`
    FOREIGN KEY (`Temporada_idTemporada` )
    REFERENCES `mydb`.`temporada` (`idTemporada` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Grupo_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario` )
    REFERENCES `mydb`.`usuario` (`idUsuario` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_grupo_Horario1`
    FOREIGN KEY (`Horario_idHorario` , `Horario_Instalacion_idInstalacion` )
    REFERENCES `mydb`.`Horario` (`idHorario` , `Instalacion_idInstalacion` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`alumnogrupo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`alumnogrupo` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`alumnogrupo` (
  `Alumno_idAlumno` INT(11) NOT NULL ,
  `Grupo_idGrupo` INT(11) NOT NULL ,
  `Grupo_Categoria_idCategoria` INT(11) NOT NULL ,
  `Grupo_Usuario_idUsuario` INT(11) NOT NULL ,
  `Grupo_Temporada_idTemporada` INT(11) NOT NULL ,
  PRIMARY KEY (`Alumno_idAlumno`, `Grupo_idGrupo`, `Grupo_Categoria_idCategoria`, `Grupo_Usuario_idUsuario`, `Grupo_Temporada_idTemporada`) ,
  INDEX `fk_Alumno_has_Grupo_Grupo1_idx` (`Grupo_idGrupo` ASC, `Grupo_Categoria_idCategoria` ASC, `Grupo_Usuario_idUsuario` ASC, `Grupo_Temporada_idTemporada` ASC) ,
  INDEX `fk_Alumno_has_Grupo_Alumno1_idx` (`Alumno_idAlumno` ASC) ,
  CONSTRAINT `fk_Alumno_has_Grupo_Alumno1`
    FOREIGN KEY (`Alumno_idAlumno` )
    REFERENCES `mydb`.`alumno` (`idAlumno` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alumno_has_Grupo_Grupo1`
    FOREIGN KEY (`Grupo_idGrupo` , `Grupo_Categoria_idCategoria` , `Grupo_Usuario_idUsuario` , `Grupo_Temporada_idTemporada` )
    REFERENCES `mydb`.`grupo` (`idGrupo` , `Categoria_idCategoria` , `Usuario_idUsuario` , `Temporada_idTemporada` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`alumnotemporada`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`alumnotemporada` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`alumnotemporada` (
  `Alumno_idAlumno` INT(11) NOT NULL ,
  `Temporada_idTemporada` INT(11) NOT NULL ,
  PRIMARY KEY (`Alumno_idAlumno`, `Temporada_idTemporada`) ,
  INDEX `fk_Alumno_has_Temporada_Temporada1_idx` (`Temporada_idTemporada` ASC) ,
  INDEX `fk_Alumno_has_Temporada_Alumno1_idx` (`Alumno_idAlumno` ASC) ,
  CONSTRAINT `fk_Alumno_has_Temporada_Alumno1`
    FOREIGN KEY (`Alumno_idAlumno` )
    REFERENCES `mydb`.`alumno` (`idAlumno` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Alumno_has_Temporada_Temporada1`
    FOREIGN KEY (`Temporada_idTemporada` )
    REFERENCES `mydb`.`temporada` (`idTemporada` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`cuota`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`cuota` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`cuota` (
  `idCuota` INT(11) NOT NULL AUTO_INCREMENT ,
  `fecha` DATE NOT NULL ,
  `pagado` TINYINT(1) NULL DEFAULT NULL ,
  PRIMARY KEY (`idCuota`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`pagoactividades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`pagoactividades` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`pagoactividades` (
  `Alumno_idAlumno` INT(11) NOT NULL ,
  `Actividades_idActividades` INT(11) NOT NULL ,
  `Actividades_Temporada_idTemporada` INT(11) NOT NULL ,
  `Cuota_idCuota` INT(11) NOT NULL ,
  PRIMARY KEY (`Alumno_idAlumno`, `Actividades_idActividades`, `Actividades_Temporada_idTemporada`, `Cuota_idCuota`) ,
  INDEX `fk_Alumno_has_Actividades_Actividades1_idx` (`Actividades_idActividades` ASC, `Actividades_Temporada_idTemporada` ASC) ,
  INDEX `fk_Alumno_has_Actividades_Alumno1_idx` (`Alumno_idAlumno` ASC) ,
  INDEX `fk_PagoActividades_Cuota1_idx` (`Cuota_idCuota` ASC) ,
  CONSTRAINT `fk_Alumno_has_Actividades_Actividades1`
    FOREIGN KEY (`Actividades_idActividades` )
    REFERENCES `mydb`.`actividades` (`idActividades` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Alumno_has_Actividades_Alumno1`
    FOREIGN KEY (`Alumno_idAlumno` )
    REFERENCES `mydb`.`alumno` (`idAlumno` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_PagoActividades_Cuota1`
    FOREIGN KEY (`Cuota_idCuota` )
    REFERENCES `mydb`.`cuota` (`idCuota` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`pagotemporada`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`pagotemporada` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`pagotemporada` (
  `idPagoTemporada` INT(11) NOT NULL AUTO_INCREMENT ,
  `Cuota_idCuota` INT(11) NOT NULL ,
  `AlumnoTemporada_Alumno_idAlumno` INT(11) NOT NULL ,
  `AlumnoTemporada_Temporada_idTemporada` INT(11) NOT NULL ,
  PRIMARY KEY (`idPagoTemporada`, `Cuota_idCuota`, `AlumnoTemporada_Alumno_idAlumno`, `AlumnoTemporada_Temporada_idTemporada`) ,
  INDEX `fk_PagoTemporada_Cuota1_idx` (`Cuota_idCuota` ASC) ,
  INDEX `fk_PagoTemporada_AlumnoTemporada1_idx` (`AlumnoTemporada_Alumno_idAlumno` ASC, `AlumnoTemporada_Temporada_idTemporada` ASC) ,
  CONSTRAINT `fk_PagoTemporada_AlumnoTemporada1`
    FOREIGN KEY (`AlumnoTemporada_Alumno_idAlumno` , `AlumnoTemporada_Temporada_idTemporada` )
    REFERENCES `mydb`.`alumnotemporada` (`Alumno_idAlumno` , `Temporada_idTemporada` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PagoTemporada_Cuota1`
    FOREIGN KEY (`Cuota_idCuota` )
    REFERENCES `mydb`.`cuota` (`idCuota` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`rango`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`rango` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`rango` (
  `Usuario_idUsuario` INT(11) NOT NULL ,
  `Equipo_idEquipo` INT(11) NOT NULL ,
  `Equipo_Fundacion_idFundacion` INT(11) NOT NULL ,
  `Equipo_Categoria_idCategoria` INT(11) NOT NULL ,
  `Equipo_Temporada_idTemporada` INT(11) NOT NULL ,
  `tipo` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`Usuario_idUsuario`, `Equipo_idEquipo`, `Equipo_Fundacion_idFundacion`, `Equipo_Categoria_idCategoria`, `Equipo_Temporada_idTemporada`) ,
  INDEX `fk_Usuario_has_Equipo_Equipo1_idx` (`Equipo_idEquipo` ASC, `Equipo_Fundacion_idFundacion` ASC, `Equipo_Categoria_idCategoria` ASC, `Equipo_Temporada_idTemporada` ASC) ,
  INDEX `fk_Usuario_has_Equipo_Usuario1_idx` (`Usuario_idUsuario` ASC) ,
  CONSTRAINT `fk_Usuario_has_Equipo_Equipo1`
    FOREIGN KEY (`Equipo_idEquipo` , `Equipo_Fundacion_idFundacion` , `Equipo_Categoria_idCategoria` )
    REFERENCES `mydb`.`equipo` (`idEquipo` , `Fundacion_idFundacion` , `Categoria_idCategoria` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_Equipo_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario` )
    REFERENCES `mydb`.`usuario` (`idUsuario` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`actividadesInstalacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`actividadesInstalacion` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`actividadesInstalacion` (
  `actividades_idActividades` INT(11) NOT NULL ,
  `actividades_Temporada_idTemporada` INT(11) NOT NULL ,
  `Instalacion_idInstalacion` INT NOT NULL ,
  PRIMARY KEY (`actividades_idActividades`, `actividades_Temporada_idTemporada`, `Instalacion_idInstalacion`) ,
  INDEX `fk_actividades_has_Instalacion_Instalacion1_idx` (`Instalacion_idInstalacion` ASC) ,
  INDEX `fk_actividades_has_Instalacion_actividades1_idx` (`actividades_idActividades` ASC, `actividades_Temporada_idTemporada` ASC) ,
  CONSTRAINT `fk_actividades_has_Instalacion_actividades1`
    FOREIGN KEY (`actividades_idActividades` )
    REFERENCES `mydb`.`actividades` (`idActividades` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actividades_has_Instalacion_Instalacion1`
    FOREIGN KEY (`Instalacion_idInstalacion` )
    REFERENCES `mydb`.`Instalacion` (`idInstalacion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`partido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`partido` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`partido` (
  `idEquipo` INT(11) NOT NULL ,
  `equipo_Fundacion_idFundacion` INT(11) NOT NULL ,
  `equipo_Categoria_idCategoria` INT(11) NOT NULL ,
  `equipo_Temporada_idTemporada` INT(11) NOT NULL ,
  `equipo_liga_idLiga` INT NOT NULL ,
  `idEquipoVisitante` INT(11) NOT NULL ,
  `equipo_Fundacion_idFundacion1` INT(11) NOT NULL ,
  `equipo_Categoria_idCategoria1` INT(11) NOT NULL ,
  `equipo_Temporada_idTemporada1` INT(11) NOT NULL ,
  `equipo_liga_idLiga1` INT NOT NULL ,
  `idPartido` INT(11) NOT NULL AUTO_INCREMENT ,
  `fecha` DATE NOT NULL ,
  `resultadoLocal` INT NOT NULL ,
  `resultadoVisitante` INT NOT NULL ,
  PRIMARY KEY (`idPartido`, `idEquipo`, `equipo_Fundacion_idFundacion`, `equipo_Categoria_idCategoria`, `equipo_Temporada_idTemporada`, `equipo_liga_idLiga`, `idEquipoVisitante`, `equipo_Fundacion_idFundacion1`, `equipo_Categoria_idCategoria1`, `equipo_Temporada_idTemporada1`, `equipo_liga_idLiga1`) ,
  INDEX `fk_equipo_has_equipo_equipo2_idx` (`idEquipoVisitante` ASC, `equipo_Fundacion_idFundacion1` ASC, `equipo_Categoria_idCategoria1` ASC, `equipo_Temporada_idTemporada1` ASC, `equipo_liga_idLiga1` ASC) ,
  INDEX `fk_equipo_has_equipo_equipo1_idx` (`idEquipo` ASC, `equipo_Fundacion_idFundacion` ASC, `equipo_Categoria_idCategoria` ASC, `equipo_Temporada_idTemporada` ASC, `equipo_liga_idLiga` ASC) ,
  CONSTRAINT `fk_equipo_has_equipo_equipo1`
    FOREIGN KEY (`idEquipo` , `equipo_Fundacion_idFundacion` , `equipo_Categoria_idCategoria` , `equipo_liga_idLiga` )
    REFERENCES `mydb`.`equipo` (`idEquipo` , `Fundacion_idFundacion` , `Categoria_idCategoria` , `liga_idLiga` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipo_has_equipo_equipo2`
    FOREIGN KEY (`idEquipoVisitante` , `equipo_Fundacion_idFundacion1` , `equipo_Categoria_idCategoria1` , `equipo_liga_idLiga1` )
    REFERENCES `mydb`.`equipo` (`idEquipo` , `Fundacion_idFundacion` , `Categoria_idCategoria` , `liga_idLiga` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`EstadisticaAlumno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`EstadisticaAlumno` ;

CREATE  TABLE IF NOT EXISTS `mydb`.`EstadisticaAlumno` (
  `partido_idPartido` INT(11) NOT NULL ,
  `partido_idEquipo` INT(11) NOT NULL ,
  `partido_equipo_Fundacion_idFundacion` INT(11) NOT NULL ,
  `partido_equipo_Categoria_idCategoria` INT(11) NOT NULL ,
  `partido_equipo_Temporada_idTemporada` INT(11) NOT NULL ,
  `partido_equipo_liga_idLiga` INT NOT NULL ,
  `partido_idEquipoVisitante` INT(11) NOT NULL ,
  `partido_equipo_Fundacion_idFundacion1` INT(11) NOT NULL ,
  `partido_equipo_Categoria_idCategoria1` INT(11) NOT NULL ,
  `partido_equipo_Temporada_idTemporada1` INT(11) NOT NULL ,
  `partido_equipo_liga_idLiga1` INT NOT NULL ,
  `alumno_idAlumno` INT(11) NOT NULL ,
  `puntos` INT NULL ,
  `rebotesOfensivos` INT NULL ,
  `rebotesDefensivos` INT NULL ,
  `asistencias` INT NULL ,
  `robos` INT NULL ,
  `perdidas` INT NULL ,
  PRIMARY KEY (`partido_idPartido`, `partido_idEquipo`, `partido_equipo_Fundacion_idFundacion`, `partido_equipo_Categoria_idCategoria`, `partido_equipo_Temporada_idTemporada`, `partido_equipo_liga_idLiga`, `partido_idEquipoVisitante`, `partido_equipo_Fundacion_idFundacion1`, `partido_equipo_Categoria_idCategoria1`, `partido_equipo_Temporada_idTemporada1`, `partido_equipo_liga_idLiga1`, `alumno_idAlumno`) ,
  INDEX `fk_partido_has_alumno_alumno1_idx` (`alumno_idAlumno` ASC) ,
  INDEX `fk_partido_has_alumno_partido1_idx` (`partido_idPartido` ASC, `partido_idEquipo` ASC, `partido_equipo_Fundacion_idFundacion` ASC, `partido_equipo_Categoria_idCategoria` ASC, `partido_equipo_Temporada_idTemporada` ASC, `partido_equipo_liga_idLiga` ASC, `partido_idEquipoVisitante` ASC, `partido_equipo_Fundacion_idFundacion1` ASC, `partido_equipo_Categoria_idCategoria1` ASC, `partido_equipo_Temporada_idTemporada1` ASC, `partido_equipo_liga_idLiga1` ASC) ,
  CONSTRAINT `fk_partido_has_alumno_partido1`
    FOREIGN KEY (`partido_idPartido` , `partido_idEquipo` , `partido_equipo_Fundacion_idFundacion` , `partido_equipo_Categoria_idCategoria` , `partido_equipo_Temporada_idTemporada` , `partido_equipo_liga_idLiga` , `partido_idEquipoVisitante` , `partido_equipo_Fundacion_idFundacion1` , `partido_equipo_Categoria_idCategoria1` , `partido_equipo_Temporada_idTemporada1` , `partido_equipo_liga_idLiga1` )
    REFERENCES `mydb`.`partido` (`idPartido` , `idEquipo` , `equipo_Fundacion_idFundacion` , `equipo_Categoria_idCategoria` , `equipo_Temporada_idTemporada` , `equipo_liga_idLiga` , `idEquipoVisitante` , `equipo_Fundacion_idFundacion1` , `equipo_Categoria_idCategoria1` , `equipo_Temporada_idTemporada1` , `equipo_liga_idLiga1` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_partido_has_alumno_alumno1`
    FOREIGN KEY (`alumno_idAlumno` )
    REFERENCES `mydb`.`alumno` (`idAlumno` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `mydb` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
