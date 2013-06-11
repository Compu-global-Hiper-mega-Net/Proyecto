

INSERT INTO rango (Usuario_idUsuario, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria, Equipo_Temporada_idTemporada, tipo) 
VALUES (2, 7, 1, 1, 1, 'PRIMERO');

INSERT INTO rango (Usuario_idUsuario, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria, Equipo_Temporada_idTemporada, tipo) 
VALUES (8, 8, 1, 2, 2, 'PRIMERO');

INSERT INTO rango (Usuario_idUsuario, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria, Equipo_Temporada_idTemporada, tipo) 
VALUES (9, 9, 1, 1, 2, 'SEGUNDO');

INSERT INTO rango (Usuario_idUsuario, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria, Equipo_Temporada_idTemporada, tipo) 
VALUES (2, 10, 1, 1, 1, 'PRIMERO');



INSERT INTO partido (idEquipo, equipo_Fundacion_idFundacion, equipo_Categoria_idCategoria, equipo_Temporada_idTemporada, 
equipo_liga_idLiga, idEquipoVisitante, equipo_Fundacion_idFundacion1, equipo_Categoria_idCategoria1, equipo_Temporada_idTemporada1,
equipo_liga_idLiga1, idPartido, fecha, resultadoLocal, resultadoVisitante) 
VALUES (7, 1, 1, 1, 1, 12, 1, 1, 1, 1, 1,'2012-05-12', 58, 74);

INSERT INTO partido (idEquipo, equipo_Fundacion_idFundacion, equipo_Categoria_idCategoria, equipo_Temporada_idTemporada, 
equipo_liga_idLiga, idEquipoVisitante, equipo_Fundacion_idFundacion1, equipo_Categoria_idCategoria1, equipo_Temporada_idTemporada1,
equipo_liga_idLiga1, idPartido, fecha, resultadoLocal, resultadoVisitante) 
VALUES (8, 1, 2, 2, 1, 12, 1, 1, 1, 1, 2,'2012-06-12', 60, 70);

INSERT INTO partido (idEquipo, equipo_Fundacion_idFundacion, equipo_Categoria_idCategoria, equipo_Temporada_idTemporada, 
equipo_liga_idLiga, idEquipoVisitante, equipo_Fundacion_idFundacion1, equipo_Categoria_idCategoria1, equipo_Temporada_idTemporada1,
equipo_liga_idLiga1, idPartido, fecha, resultadoLocal, resultadoVisitante) 
VALUES (9, 1, 1, 2, 1, 12, 1, 1, 1, 1, 3,'2012-07-12', 43, 85);

INSERT INTO partido (idEquipo, equipo_Fundacion_idFundacion, equipo_Categoria_idCategoria, equipo_Temporada_idTemporada, 
equipo_liga_idLiga, idEquipoVisitante, equipo_Fundacion_idFundacion1, equipo_Categoria_idCategoria1, equipo_Temporada_idTemporada1,
equipo_liga_idLiga1, idPartido, fecha, resultadoLocal, resultadoVisitante) 
VALUES (10, 1, 1, 1, 1, 12, 1, 1, 1, 1, 4,'2012-08-12', 87, 39);

INSERT INTO partido (idEquipo, equipo_Fundacion_idFundacion, equipo_Categoria_idCategoria, equipo_Temporada_idTemporada, 
equipo_liga_idLiga, idEquipoVisitante, equipo_Fundacion_idFundacion1, equipo_Categoria_idCategoria1, equipo_Temporada_idTemporada1,
equipo_liga_idLiga1, idPartido, fecha, resultadoLocal, resultadoVisitante) 
VALUES (7, 1, 1, 1, 1, 12, 1, 1, 1, 1, 5,'2012-03-12', 55, 78);



INSERT INTO alumno (idAlumno, talla, nombre, primerApellido, segundoApellido, nombrePadre, nombreMadre, numeroCuenta,
telMovil, telFijo, observaciones, provincia, localidad, codigoPostal, colegio, domicilio, email, fechaNacimiento, sexo) 
VALUES (1,'XL','Antonio','Ruiz','Carvajal','Juan','Juana',4354356665666364,657847765,958154741,NULL,NULL,NULL,NULL,NULL,NULL,'sucorreo','1990-12-07','V');

INSERT INTO alumno (idAlumno, talla, nombre, primerApellido, segundoApellido, nombrePadre, nombreMadre, numeroCuenta,
telMovil, telFijo, observaciones, provincia, localidad, codigoPostal, colegio, domicilio, email, fechaNacimiento, sexo) 
VALUES (2,'XL','Jose','Romero','Casta','Juan','Juana',43543645666364,657847765,958154741,NULL,NULL,NULL,NULL,NULL,NULL,'sucorreo','1990-12-07','V');

INSERT INTO alumno (idAlumno, talla, nombre, primerApellido, segundoApellido, nombrePadre, nombreMadre, numeroCuenta,
telMovil, telFijo, observaciones, provincia, localidad, codigoPostal, colegio, domicilio, email, fechaNacimiento, sexo) 
VALUES (3,'XL','Alvaro','Gomez','Cepil','Juan','Juana',43543566464566364,657847765,958154741,NULL,NULL,NULL,NULL,NULL,NULL,'sucorreo','1990-12-07','V');

INSERT INTO alumno (idAlumno, talla, nombre, primerApellido, segundoApellido, nombrePadre, nombreMadre, numeroCuenta,
telMovil, telFijo, observaciones, provincia, localidad, codigoPostal, colegio, domicilio, email, fechaNacimiento, sexo) 
VALUES (4,'XL','Juana','Ruiz','Carvajal','Juan','Juana',4354356665666364,657847765,958154741,NULL,NULL,NULL,NULL,NULL,NULL,'sucorreo','1990-12-07','H');




INSERT INTO EstadisticaAlumno (partido_idPartido, partido_idEquipo, partido_equipo_Fundacion_idFundacion, partido_equipo_Categoria_idCategoria, partido_equipo_Temporada_idTemporada, 
partido_equipo_liga_idLiga, partido_idEquipoVisitante, partido_equipo_Fundacion_idFundacion1, partido_equipo_Categoria_idCategoria1, partido_equipo_Temporada_idTemporada1,
partido_equipo_liga_idLiga1, alumno_idAlumno, puntos, rebotesOfensivos, rebotesDefensivos, asistencias, robos, perdidas) 
VALUES (1, 7, 1, 1, 1, 1, 12, 1, 1, 1, 1, 1, 45, 67, 4, 6, 5, 7);

INSERT INTO EstadisticaAlumno (partido_idPartido, partido_idEquipo, partido_equipo_Fundacion_idFundacion, partido_equipo_Categoria_idCategoria, partido_equipo_Temporada_idTemporada, 
partido_equipo_liga_idLiga, partido_idEquipoVisitante, partido_equipo_Fundacion_idFundacion1, partido_equipo_Categoria_idCategoria1, partido_equipo_Temporada_idTemporada1,
partido_equipo_liga_idLiga1, alumno_idAlumno, puntos, rebotesOfensivos, rebotesDefensivos, asistencias, robos, perdidas) 
VALUES (2, 8, 1, 2, 2, 1, 12, 1, 1, 1, 1, 2, 65, 6, 4, 9, 5, 9);

INSERT INTO EstadisticaAlumno (partido_idPartido, partido_idEquipo, partido_equipo_Fundacion_idFundacion, partido_equipo_Categoria_idCategoria, partido_equipo_Temporada_idTemporada, 
partido_equipo_liga_idLiga, partido_idEquipoVisitante, partido_equipo_Fundacion_idFundacion1, partido_equipo_Categoria_idCategoria1, partido_equipo_Temporada_idTemporada1,
partido_equipo_liga_idLiga1, alumno_idAlumno, puntos, rebotesOfensivos, rebotesDefensivos, asistencias, robos, perdidas) 
VALUES (3 ,9, 1, 1, 2, 1, 12, 1, 1, 1, 1, 3, 47, 0, 4, 4, 9, 0);

INSERT INTO EstadisticaAlumno (partido_idPartido, partido_idEquipo, partido_equipo_Fundacion_idFundacion, partido_equipo_Categoria_idCategoria, partido_equipo_Temporada_idTemporada, 
partido_equipo_liga_idLiga, partido_idEquipoVisitante, partido_equipo_Fundacion_idFundacion1, partido_equipo_Categoria_idCategoria1, partido_equipo_Temporada_idTemporada1,
partido_equipo_liga_idLiga1, alumno_idAlumno, puntos, rebotesOfensivos, rebotesDefensivos, asistencias, robos, perdidas) 
VALUES (4 ,10, 1, 1, 1, 1, 12, 1, 1, 1, 1, 4, 85, 67, 0, 9, 5, 7);





