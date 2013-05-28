
INSERT INTO usuario (nombre, primerapellido, segundoapellido, dni, clave, user)
VALUES ("paco", "fernandez" , "fernandez2", "77777777q","clave", "paco");
INSERT INTO usuario (nombre, primerapellido, segundoapellido, dni, clave, entrenador)
VALUES ("trainerman", "fernandez" , "fernandez2", "77777777q","clave", true);
INSERT INTO usuario (nombre, primerapellido, segundoapellido, dni, clave, entrenador)
VALUES ("mourino", "fernandez" , "fernandez2", "77777777q","clave", true);

INSERT INTO temporada ( curso, inicio, fin) values ('2012-2013', '2012-02-02', '2013-03-03');
INSERT INTO temporada ( curso, inicio, fin) values ('2013-2014', '2012-02-02', '2013-03-03');

INSERT INTO categoria (tipo,descripcion) VALUES ("alevin", "");
INSERT INTO categoria (tipo,descripcion) VALUES ("benjamin", "");

insert into instalacion (nombre,capacidadEquipos, localizacion) values ('la xana ', 2, 'retirao de grana');

insert into horario (Instalacion_idInstalacion,dia1,dia2,hora1,hora2) values (1, 'lunes', 'martes', 12.00, 13.00);

INSERT INTO grupo (n_alumnos,Categoria_idCategoria,Usuario_idUsuario, Temporada_idTemporada, Horario_idHorario,
Horario_Instalacion_idInstalacion) VALUES (20, 1,1, 1,1,1);
INSERT INTO grupo (n_alumnos,Categoria_idCategoria,Usuario_idUsuario, Temporada_idTemporada, Horario_idHorario,
Horario_Instalacion_idInstalacion) VALUES (20, 2,2, 2,1,1);
INSERT INTO grupo (n_alumnos,Categoria_idCategoria,Usuario_idUsuario, Temporada_idTemporada, Horario_idHorario,
Horario_Instalacion_idInstalacion) VALUES (20, 1,1, 2,1,1);

INSERT INTO alumno (nombre,  primerapellido, segundoapellido, 
fechanacimiento, telmovil, email, talla, nombrepadre, nombremadre, telfijo)
VALUES ("alumno1",  "apellido1", "apellido2", '1990-07-12', 677677677, "sucorreo", 'XL', 'eladio', 'juana', 95888888);
INSERT INTO alumno (nombre,  primerapellido, segundoapellido, 
fechanacimiento, telmovil, email, talla, nombrepadre, nombremadre, telfijo)
VALUES ("alumno2",  "apellido1", "apellido2", '1990-07-12', 677677677, "sucorreo", 'XL', 'eladio', 'juana', 95888888);
INSERT INTO alumno (nombre,  primerapellido, segundoapellido, 
fechanacimiento, telmovil, email, talla, nombrepadre, nombremadre, telfijo)
VALUES ("alumno3",  "apellido1", "apellido2", '1990-07-12', 677677677, "sucorreo", 'XL', 'eladio', 'juana', 95888888);
INSERT INTO alumno (nombre,  primerapellido, segundoapellido, 
fechanacimiento, telmovil, email, talla, nombrepadre, nombremadre, telfijo)
VALUES ("alumno4",  "apellido1", "apellido2", '1990-07-12', 677677677, "sucorreo", 'XL', 'eladio', 'juana', 95888888);
INSERT INTO alumno (nombre,  primerapellido, segundoapellido, 
fechanacimiento, telmovil, email, talla, nombrepadre, nombremadre, telfijo)
VALUES ("alumno5",  "apellido1", "apellido2", '1990-07-12', 677677677, "sucorreo", 'XL', 'eladio', 'juana', 95888888);
INSERT INTO alumno (nombre,  primerapellido, segundoapellido, 
fechanacimiento, telmovil, email, talla, nombrepadre, nombremadre, telfijo)
VALUES ("alumno6",  "apellido1", "apellido2", '1990-07-12', 677677677, "sucorreo", 'XL', 'eladio', 'juana', 95888888);
INSERT INTO alumno (nombre,  primerapellido, segundoapellido, 
fechanacimiento, telmovil, email, talla, nombrepadre, nombremadre, telfijo)
VALUES ("alumno7",  "apellido1", "apellido2", '1990-07-12', 677677677, "sucorreo", 'XL', 'eladio', 'juana', 95888888);
INSERT INTO alumno (nombre,  primerapellido, segundoapellido, 
fechanacimiento, telmovil, email, talla, nombrepadre, nombremadre, telfijo)
VALUES ("alumno8",  "apellido1", "apellido2", '1990-07-12', 677677677, "sucorreo", 'XL', 'eladio', 'juana', 95888888);
INSERT INTO alumno (nombre,  primerapellido, segundoapellido, 
fechanacimiento, telmovil, email, talla, nombrepadre, nombremadre, telfijo)
VALUES ("alumno9",  "apellido1", "apellido2", '1990-07-12', 677677677, "sucorreo", 'XL', 'eladio', 'juana', 95888888);
INSERT INTO alumno (nombre,  primerapellido, segundoapellido, 
fechanacimiento, telmovil, email, talla, nombrepadre, nombremadre, telfijo)
VALUES ("alumno10",  "apellido1", "apellido2", '1990-07-12', 677677677, "sucorreo", 'XL', 'eladio', 'juana', 95888888);
INSERT INTO alumno (nombre,  primerapellido, segundoapellido, 
fechanacimiento, telmovil, email, talla, nombrepadre, nombremadre, telfijo)
VALUES ("alumno11",  "apellido1", "apellido2", '1990-07-12', 677677677, "sucorreo", 'XL', 'eladio', 'juana', 95888888);
INSERT INTO alumno (nombre,  primerapellido, segundoapellido, 
fechanacimiento, telmovil, email, talla, nombrepadre, nombremadre, telfijo)
VALUES ("alumno12",  "apellido1", "apellido2", '1990-07-12', 677677677, "sucorreo", 'XL', 'eladio', 'juana', 95888888);
INSERT INTO alumno (nombre,  primerapellido, segundoapellido, 
fechanacimiento, telmovil, email, talla, nombrepadre, nombremadre, telfijo)
VALUES ("alumno13",  "apellido1", "apellido2", '1990-07-12', 677677677, "sucorreo", 'XL', 'eladio', 'juana', 95888888);
INSERT INTO alumno (nombre,  primerapellido, segundoapellido, 
fechanacimiento, telmovil, email, talla, nombrepadre, nombremadre, telfijo)
VALUES ("alumno14",  "apellido1", "apellido2", '1990-07-12', 677677677, "sucorreo", 'XL', 'eladio', 'juana', 95888888);
INSERT INTO alumno (nombre,  primerapellido, segundoapellido, 
fechanacimiento, telmovil, email, talla, nombrepadre, nombremadre, telfijo)
VALUES ("alumno15",  "apellido1", "apellido2", '1990-07-12', 677677677, "sucorreo", 'XL', 'eladio', 'juana', 95888888);
INSERT INTO alumno (nombre,  primerapellido, segundoapellido, 
fechanacimiento, telmovil, email, talla, nombrepadre, nombremadre, telfijo)
VALUES ("alumno16",  "apellido1", "apellido2", '1990-07-12', 677677677, "sucorreo", 'XL', 'eladio', 'juana', 95888888);
update alumno set 
fechaNacimiento='1990-07-12'
where alumno.idalumno<1000;


INSERT INTO alumnogrupo (Alumno_idAlumno, Grupo_idGrupo, Grupo_Categoria_idCategoria, 
Grupo_Usuario_idUsuario, Grupo_Temporada_idTemporada) VALUES (2, 1, 1, 1, 1);
INSERT INTO alumnogrupo (Alumno_idAlumno, Grupo_idGrupo, Grupo_Categoria_idCategoria, 
Grupo_Usuario_idUsuario, Grupo_Temporada_idTemporada) VALUES (3, 1, 1, 1, 1);
INSERT INTO alumnogrupo (Alumno_idAlumno, Grupo_idGrupo, Grupo_Categoria_idCategoria, 
Grupo_Usuario_idUsuario, Grupo_Temporada_idTemporada) VALUES (4, 1, 1, 1, 1);
INSERT INTO alumnogrupo (Alumno_idAlumno, Grupo_idGrupo, Grupo_Categoria_idCategoria, 
Grupo_Usuario_idUsuario, Grupo_Temporada_idTemporada) VALUES (5, 1, 1, 1, 1);
INSERT INTO alumnogrupo (Alumno_idAlumno, Grupo_idGrupo, Grupo_Categoria_idCategoria, 
Grupo_Usuario_idUsuario, Grupo_Temporada_idTemporada) VALUES (6, 2, 2, 2, 2);
INSERT INTO alumnogrupo (Alumno_idAlumno, Grupo_idGrupo, Grupo_Categoria_idCategoria, 
Grupo_Usuario_idUsuario, Grupo_Temporada_idTemporada) VALUES (7, 2, 2, 2, 2);
INSERT INTO alumnogrupo (Alumno_idAlumno, Grupo_idGrupo, Grupo_Categoria_idCategoria, 
Grupo_Usuario_idUsuario, Grupo_Temporada_idTemporada) VALUES (8, 2, 2, 2, 2);
INSERT INTO alumnogrupo (Alumno_idAlumno, Grupo_idGrupo, Grupo_Categoria_idCategoria, 
Grupo_Usuario_idUsuario, Grupo_Temporada_idTemporada) VALUES (9, 2, 2, 2, 2);
INSERT INTO alumnogrupo (Alumno_idAlumno, Grupo_idGrupo, Grupo_Categoria_idCategoria, 
Grupo_Usuario_idUsuario, Grupo_Temporada_idTemporada) VALUES (10, 3, 1, 1, 2);
INSERT INTO alumnogrupo (Alumno_idAlumno, Grupo_idGrupo, Grupo_Categoria_idCategoria, 
Grupo_Usuario_idUsuario, Grupo_Temporada_idTemporada) VALUES (11, 3, 1, 1, 2);
INSERT INTO alumnogrupo (Alumno_idAlumno, Grupo_idGrupo, Grupo_Categoria_idCategoria, 
Grupo_Usuario_idUsuario, Grupo_Temporada_idTemporada) VALUES (12, 3, 1, 1, 2);
INSERT INTO alumnogrupo (Alumno_idAlumno, Grupo_idGrupo, Grupo_Categoria_idCategoria, 
Grupo_Usuario_idUsuario, Grupo_Temporada_idTemporada) VALUES (13, 3, 1, 1, 2);
INSERT INTO alumnogrupo (Alumno_idAlumno, Grupo_idGrupo, Grupo_Categoria_idCategoria, 
Grupo_Usuario_idUsuario, Grupo_Temporada_idTemporada) VALUES (14, 3, 1, 1, 2);
INSERT INTO alumnogrupo (Alumno_idAlumno, Grupo_idGrupo, Grupo_Categoria_idCategoria, 
Grupo_Usuario_idUsuario, Grupo_Temporada_idTemporada) VALUES (15, 3, 1, 1, 2);
INSERT INTO alumnogrupo (Alumno_idAlumno, Grupo_idGrupo, Grupo_Categoria_idCategoria, 
Grupo_Usuario_idUsuario, Grupo_Temporada_idTemporada) VALUES (16, 3, 1, 1, 2);

insert into fundacion (nombre,cp,ccc,email) values ('lafundacion' , 12, 'no se que es ccc pero hay lo llevas', 'correo@fundacion');

insert into liga (idLiga, nombre) values (1, 'liga bbva');

insert into equipo (Fundacion_idFundacion, Categoria_idCategoria, Temporada_idTemporada, nombre, fundacion, liga_idliga) 
values (1, 1, 1, "equipazo", 1, 1);


insert into equipo (Fundacion_idFundacion, Categoria_idCategoria, Temporada_idTemporada, nombre, fundacion, liga_idliga) 
values (1, 2, 2, "equipazo2", 1, 1);
insert into equipo (Fundacion_idFundacion, Categoria_idCategoria, Temporada_idTemporada, nombre, fundacion, liga_idliga) 
values (1, 1, 2, "equipazo3", 1, 1);


insert into alumnoequipo (Alumno_idAlumno, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria) 
values (2, 1, 1, 1);
insert into alumnoequipo (Alumno_idAlumno, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria) 
values (3, 1, 1, 1);
insert into alumnoequipo (Alumno_idAlumno, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria) 
values (4, 1, 1, 1);
insert into alumnoequipo (Alumno_idAlumno, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria) 
values (5, 1, 1, 1);
insert into alumnoequipo (Alumno_idAlumno, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria) 
values (6, 1, 1, 1);
insert into alumnoequipo (Alumno_idAlumno, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria) 
values (7, 2, 1, 2);
insert into alumnoequipo (Alumno_idAlumno, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria) 
values (8, 2, 1, 2);
insert into alumnoequipo (Alumno_idAlumno, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria) 
values (9, 2, 1, 2);
insert into alumnoequipo (Alumno_idAlumno, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria) 
values (10, 2, 1, 2);
insert into alumnoequipo (Alumno_idAlumno, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria) 
values (11, 2, 1, 2);
insert into alumnoequipo (Alumno_idAlumno, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria) 
values (12, 2, 1, 2);
insert into alumnoequipo (Alumno_idAlumno, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria) 
values (13, 3, 1, 1);
insert into alumnoequipo (Alumno_idAlumno, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria) 
values (14, 3, 1, 1);
insert into alumnoequipo (Alumno_idAlumno, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria) 
values (15, 3, 1, 1);
insert into alumnoequipo (Alumno_idAlumno, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria) 
values (16, 3, 1, 1);


insert into rango (Usuario_idUsuario, Equipo_idEquipo, Equipo_Fundacion_idFundacion, Equipo_Categoria_idCategoria, 
					Equipo_Temporada_idTemporada, tipo)
values (2, 1, 1, 1, 1, 'primer entrenador');

insert into actividades (nAlumnos, descripcion, precioSocio,precioNoSocio, Temporada_idTemporada, fechaInicio, fechaFin, nombre) 
values (20, 'actividad q lo parte y reparte', 40, 60, 1, '12-02-12', '12-03-12', 'juventudes del papa');

insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);
insert into cuota (fecha, pagado) values ('12-01-12', false);


insert into pagoactividades (Alumno_idAlumno, Actividades_idActividades, Actividades_Temporada_idTemporada, Cuota_idCuota) 
values (2, 1, 1, 1);
insert into pagoactividades (Alumno_idAlumno, Actividades_idActividades, Actividades_Temporada_idTemporada, Cuota_idCuota) 
values (3, 1, 1, 2);
insert into pagoactividades (Alumno_idAlumno, Actividades_idActividades, Actividades_Temporada_idTemporada, Cuota_idCuota) 
values (4, 1, 1, 3);
insert into pagoactividades (Alumno_idAlumno, Actividades_idActividades, Actividades_Temporada_idTemporada, Cuota_idCuota) 
values (5, 1, 1, 4);
insert into pagoactividades (Alumno_idAlumno, Actividades_idActividades, Actividades_Temporada_idTemporada, Cuota_idCuota) 
values (6, 1, 1, 5);
insert into pagoactividades (Alumno_idAlumno, Actividades_idActividades, Actividades_Temporada_idTemporada, Cuota_idCuota) 
values (7, 1, 1, 6);
insert into pagoactividades (Alumno_idAlumno, Actividades_idActividades, Actividades_Temporada_idTemporada, Cuota_idCuota) 
values (8, 1, 1, 7);
insert into pagoactividades (Alumno_idAlumno, Actividades_idActividades, Actividades_Temporada_idTemporada, Cuota_idCuota) 
values (9, 1, 1, 8);
insert into pagoactividades (Alumno_idAlumno, Actividades_idActividades, Actividades_Temporada_idTemporada, Cuota_idCuota) 
values (10, 1, 1, 9);


insert into alumnotemporada (Alumno_idAlumno,Temporada_idTemporada) values (2, 1);
insert into alumnotemporada (Alumno_idAlumno,Temporada_idTemporada) values (3, 1);
insert into alumnotemporada (Alumno_idAlumno,Temporada_idTemporada) values (4, 1);
insert into alumnotemporada (Alumno_idAlumno,Temporada_idTemporada) values (5, 1);
insert into alumnotemporada (Alumno_idAlumno,Temporada_idTemporada) values (6, 1);
insert into alumnotemporada (Alumno_idAlumno,Temporada_idTemporada) values (7, 1);
insert into alumnotemporada (Alumno_idAlumno,Temporada_idTemporada) values (8, 1);
insert into alumnotemporada (Alumno_idAlumno,Temporada_idTemporada) values (9, 1);
insert into alumnotemporada (Alumno_idAlumno,Temporada_idTemporada) values (10, 1);
insert into alumnotemporada (Alumno_idAlumno,Temporada_idTemporada) values (10, 2);
insert into alumnotemporada (Alumno_idAlumno,Temporada_idTemporada) values (11, 2);
insert into alumnotemporada (Alumno_idAlumno,Temporada_idTemporada) values (12, 2);
insert into alumnotemporada (Alumno_idAlumno,Temporada_idTemporada) values (13, 2);
insert into alumnotemporada (Alumno_idAlumno,Temporada_idTemporada) values (14, 2);
insert into alumnotemporada (Alumno_idAlumno,Temporada_idTemporada) values (15, 2);
insert into alumnotemporada (Alumno_idAlumno,Temporada_idTemporada) values (16, 2);
insert into alumnotemporada (Alumno_idAlumno,Temporada_idTemporada) values (17, 2);

insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (10, 2, 1);


insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (11, 2, 1);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (12, 2, 1);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (13, 2, 1);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (14, 2, 1);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (15, 2, 1);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (16, 2, 1);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (17, 2, 1);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (18, 2, 1);

insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (19, 10, 1);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (20, 10, 1);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (21, 10, 1);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (22, 10, 1);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (23, 10, 1);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (24, 10, 1);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (25, 10, 1);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (26, 10, 1);


insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (19, 10, 2);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (20, 10, 2);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (21, 10, 2);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (22, 10, 2);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (23, 10, 2);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (24, 10, 2);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (25, 10, 2);
insert into pagotemporada (Cuota_idCuota,AlumnoTemporada_Alumno_idAlumno, AlumnoTemporada_Temporada_idTemporada) 
values (26, 10, 2);