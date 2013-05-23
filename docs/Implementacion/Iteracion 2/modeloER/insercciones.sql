INSERT INTO usuario (nombre, primerapellido, segundoapellido, dni, user, clave)
VALUES ("paco", "fernandez" , "fernandez2", "77777777q", "paco","clave");
INSERT INTO usuario (nombre, primerapellido, segundoapellido, dni, user, clave, entrenador)
VALUES ("reinaldo", "fernandez" , "fernandez2", "77777777q", "trainerman", "clave", true);
INSERT INTO usuario (nombre, primerapellido, segundoapellido, dni, user, clave, entrenador)
VALUES ("mourinho", "fernandez" , "fernandez2", "77777777q","mourino","clave", true);

INSERT INTO temporada ( curso, inicio, fin) values ('2012/2013', null, null);
INSERT INTO temporada ( curso, inicio, fin) values ('2013/2014', null, null);

INSERT INTO categoria (tipo,descripcion) VALUES ("alevin", "");
INSERT INTO categoria (tipo,descripcion) VALUES ("benjamin", "");
INSERT INTO categoria (tipo,descripcion) VALUES ("cadete", "");
INSERT INTO categoria (tipo,descripcion) VALUES ("infantil", "");
INSERT INTO categoria (tipo,descripcion) VALUES ("junior", "");

/*
-- Query: SELECT * FROM mydb.alumno
LIMIT 0, 1000

-- Date: 2013-05-22 18:54
*/
INSERT INTO `alumno` (`idAlumno`,`talla`,`nombre`,`primerApellido`,`segundoApellido`,`nombrePadre`,`nombreMadre`,`numeroCuenta`,`telMovil`,`telFijo`,`observaciones`,`provincia`,`localidad`,`codigoPostal`,`colegio`,`domicilio`,`email`,`fechaNacimiento`,`Alumnocol`) VALUES (3,'XL','Antonio','Ruiz','Carvajal','Juan','Juana',NULL,657847765,958154741,NULL,NULL,NULL,NULL,NULL,NULL,'sucorreo','1990-12-07',NULL);
INSERT INTO `alumno` (`idAlumno`,`talla`,`nombre`,`primerApellido`,`segundoApellido`,`nombrePadre`,`nombreMadre`,`numeroCuenta`,`telMovil`,`telFijo`,`observaciones`,`provincia`,`localidad`,`codigoPostal`,`colegio`,`domicilio`,`email`,`fechaNacimiento`,`Alumnocol`) VALUES (4,'XL','Manuel','Casillas','Motos','Juanito','Juanita',NULL,647847765,958154269,NULL,NULL,NULL,NULL,NULL,NULL,'sucorreo','1990-12-07',NULL);
INSERT INTO `alumno` (`idAlumno`,`talla`,`nombre`,`primerApellido`,`segundoApellido`,`nombrePadre`,`nombreMadre`,`numeroCuenta`,`telMovil`,`telFijo`,`observaciones`,`provincia`,`localidad`,`codigoPostal`,`colegio`,`domicilio`,`email`,`fechaNacimiento`,`Alumnocol`) VALUES (5,'XL','Raul','Martinez','Campos','Pepico','Pepica',NULL,654454545,958151515,NULL,NULL,NULL,NULL,NULL,NULL,'sucorreo','1990-12-07',NULL);
INSERT INTO `alumno` (`idAlumno`,`talla`,`nombre`,`primerApellido`,`segundoApellido`,`nombrePadre`,`nombreMadre`,`numeroCuenta`,`telMovil`,`telFijo`,`observaciones`,`provincia`,`localidad`,`codigoPostal`,`colegio`,`domicilio`,`email`,`fechaNacimiento`,`Alumnocol`) VALUES (6,'XL','Luis','Lopez','Roca','Antonio','Antonia',NULL,654987478,958151213,NULL,NULL,NULL,NULL,NULL,NULL,'sucorreo','1990-12-07',NULL);
INSERT INTO `alumno` (`idAlumno`,`talla`,`nombre`,`primerApellido`,`segundoApellido`,`nombrePadre`,`nombreMadre`,`numeroCuenta`,`telMovil`,`telFijo`,`observaciones`,`provincia`,`localidad`,`codigoPostal`,`colegio`,`domicilio`,`email`,`fechaNacimiento`,`Alumnocol`) VALUES (7,'XL','Paco','Jimenez','Sevilla','Paco','Paca',NULL,698757472,958134849,NULL,NULL,NULL,NULL,NULL,NULL,'sucorreo','1990-12-07',NULL);
INSERT INTO `alumno` (`idAlumno`,`talla`,`nombre`,`primerApellido`,`segundoApellido`,`nombrePadre`,`nombreMadre`,`numeroCuenta`,`telMovil`,`telFijo`,`observaciones`,`provincia`,`localidad`,`codigoPostal`,`colegio`,`domicilio`,`email`,`fechaNacimiento`,`Alumnocol`) VALUES (8,'XL','Mario','Monti','Faria','Luis','Luisa',NULL,632141516,958414243,NULL,NULL,NULL,NULL,NULL,NULL,'sucorreo','1990-12-07',NULL);
INSERT INTO `alumno` (`idAlumno`,`talla`,`nombre`,`primerApellido`,`segundoApellido`,`nombrePadre`,`nombreMadre`,`numeroCuenta`,`telMovil`,`telFijo`,`observaciones`,`provincia`,`localidad`,`codigoPostal`,`colegio`,`domicilio`,`email`,`fechaNacimiento`,`Alumnocol`) VALUES (9,'XL','Luis','Gutierrez','Mesa','Pablo','Lucia',NULL,698858684,958191718,NULL,NULL,NULL,NULL,NULL,NULL,'sucorreo','1990-12-07',NULL);
INSERT INTO `alumno` (`idAlumno`,`talla`,`nombre`,`primerApellido`,`segundoApellido`,`nombrePadre`,`nombreMadre`,`numeroCuenta`,`telMovil`,`telFijo`,`observaciones`,`provincia`,`localidad`,`codigoPostal`,`colegio`,`domicilio`,`email`,`fechaNacimiento`,`Alumnocol`) VALUES (10,'XL','Alberto','Morales','Rodriguez','Ignacio','Raquel',NULL,635525655,958171819,NULL,NULL,NULL,NULL,NULL,NULL,'sucorreo','1990-12-07',NULL);
INSERT INTO `alumno` (`idAlumno`,`talla`,`nombre`,`primerApellido`,`segundoApellido`,`nombrePadre`,`nombreMadre`,`numeroCuenta`,`telMovil`,`telFijo`,`observaciones`,`provincia`,`localidad`,`codigoPostal`,`colegio`,`domicilio`,`email`,`fechaNacimiento`,`Alumnocol`) VALUES (11,'XL','Pedro','Muñoz','Fernandez','Pedro','Maria',NULL,698878889,958632514,NULL,NULL,NULL,NULL,NULL,NULL,'sucorreo','1990-12-07',NULL);
INSERT INTO `alumno` (`idAlumno`,`talla`,`nombre`,`primerApellido`,`segundoApellido`,`nombrePadre`,`nombreMadre`,`numeroCuenta`,`telMovil`,`telFijo`,`observaciones`,`provincia`,`localidad`,`codigoPostal`,`colegio`,`domicilio`,`email`,`fechaNacimiento`,`Alumnocol`) VALUES (12,'XL','Sergio','Ramos','Lopez','Antonio','Carmen',NULL,654122321,698451516,NULL,NULL,NULL,NULL,NULL,NULL,'sucorreo','1990-12-07',NULL);
INSERT INTO `alumno` (`idAlumno`,`talla`,`nombre`,`primerApellido`,`segundoApellido`,`nombrePadre`,`nombreMadre`,`numeroCuenta`,`telMovil`,`telFijo`,`observaciones`,`provincia`,`localidad`,`codigoPostal`,`colegio`,`domicilio`,`email`,`fechaNacimiento`,`Alumnocol`) VALUES (13,'XL','Carlos','Bailon','Perez','Antonio','Josefina',NULL,654121316,698451213,NULL,NULL,NULL,NULL,NULL,NULL,'sucorreo','1990-12-07',NULL);



insert into fundacion (nombre,cp,ccc,email) values ('lafundacion' , 12, 'no se que es ccc pero hay lo llevas', 'correo@fundacion');

insert into equipo (Fundacion_idFundacion, Categoria_idCategoria, Temporada_idTemporada, nombre) values (1, 1, 1, 'Granada A');

insert into alumnoequipo (Alumno_idAlumno, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria) 
values (1, 1, 1, 1);
update alumno set 
fechaNacimiento='1990-07-12'
where alumno.idalumno<1000;
insert into rango (Usuario_idUsuario, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria, 
					Equipo_Temporada_idTemporada, tipo)
values (2, 1, 1, 1, 1, 'primer entrenador');
