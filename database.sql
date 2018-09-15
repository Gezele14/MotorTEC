
-- Table: Carrera
CREATE TABLE Carrera (
    idCarrera INTEGER PRIMARY KEY
                      NOT NULL,
    Nombre    VARCHAR
);

INSERT INTO Carrera (idCarrera, Nombre) VALUES (1, 'Computadores');
INSERT INTO Carrera (idCarrera, Nombre) VALUES (2, 'Materiales');
INSERT INTO Carrera (idCarrera, Nombre) VALUES (3, 'Biotec');
INSERT INTO Carrera (idCarrera, Nombre) VALUES (4, 'Administración');
INSERT INTO Carrera (idCarrera, Nombre) VALUES (5, 'Diseño');
INSERT INTO Carrera (idCarrera, Nombre) VALUES (6, 'Electronica');
INSERT INTO Carrera (idCarrera, Nombre) VALUES (7, 'Física');

-- Table: Estudiante
CREATE TABLE Estudiante (
    idEstudiante     INTEGER NOT NULL
                             PRIMARY KEY,
    idInstitución    INTEGER REFERENCES Institución (idInstitución),
    idCarrera        INTEGER REFERENCES Carrera (idCarrera),
    Nombre           VARCHAR,
    Primer_Apellido  VARCHAR,
    Segundo_Apellido VARCHAR,
    Correo           VARCHAR,
    Telefono         INTEGER
);

INSERT INTO Estudiante (idEstudiante, idInstitución, idCarrera, Nombre, Primer_Apellido, Segundo_Apellido, Correo, Telefono) 
                VALUES (2009126783, 4, 6, 'Sebastian', 'Solis', 'Villareal', 'sebsol@gmail.com', 89998959);
INSERT INTO Estudiante (idEstudiante, idInstitución, idCarrera, Nombre, Primer_Apellido, Segundo_Apellido, Correo, Telefono) 
                VALUES (2010234188, 3, 4, 'Marco', 'Villalobos', 'Saldaña', 'ppmar@gmail.com', 88975531);
INSERT INTO Estudiante (idEstudiante, idInstitución, idCarrera, Nombre, Primer_Apellido, Segundo_Apellido, Correo, Telefono) 
                VALUES (2011546721, 2, 3, 'Santos', 'Rodriguez', 'Picado', 'santos123@gmail.com', 88985564);
INSERT INTO Estudiante (idEstudiante, idInstitución, idCarrera, Nombre, Primer_Apellido, Segundo_Apellido, Correo, Telefono) 
                VALUES (2011697852, 3, 4, 'María', 'Espinoza ', 'Piedra', 'mespi@gmail.com', 75389645);
INSERT INTO Estudiante (idEstudiante, idInstitución, idCarrera, Nombre, Primer_Apellido, Segundo_Apellido, Correo, Telefono) 
                VALUES (2012223895, 1, 5, 'Pablo', 'Marin', 'Madrigal', 'madri11@gmail.com', 87334533);
INSERT INTO Estudiante (idEstudiante, idInstitución, idCarrera, Nombre, Primer_Apellido, Segundo_Apellido, Correo, Telefono) 
                VALUES (2012364852, 2, 4, 'Fernanda', 'Esquivel', 'Rojas', 'FerE@gmail.com', 75860489);
INSERT INTO Estudiante (idEstudiante, idInstitución, idCarrera, Nombre, Primer_Apellido, Segundo_Apellido, Correo, Telefono) 
                VALUES (2013254678, 4, 3, 'Mario', 'Ramirez', 'Perez', 'Mper@gmail.com', 86542763);
INSERT INTO Estudiante (idEstudiante, idInstitución, idCarrera, Nombre, Primer_Apellido, Segundo_Apellido, Correo, Telefono) 
                VALUES (2013568742, 1, 1, 'Pedro ', 'Zeledon', 'Gutierrez', 'Pguti@gmail.com', 86457896);
INSERT INTO Estudiante (idEstudiante, idInstitución, idCarrera, Nombre, Primer_Apellido, Segundo_Apellido, Correo, Telefono) 
                VALUES (2016167796, 1, 1, 'Juan', 'Esquivel', 'Rojas', 'ju.esq@gmail.com', 86074143);
INSERT INTO Estudiante (idEstudiante, idInstitución, idCarrera, Nombre, Primer_Apellido, Segundo_Apellido, Correo, Telefono) 
                VALUES (2016243863, 1, 2, 'Gerardo', 'Zeledon', 'Martinez', 'gera@gmail.com', 78789898);
INSERT INTO Estudiante (idEstudiante, idInstitución, idCarrera, Nombre, Primer_Apellido, Segundo_Apellido, Correo, Telefono) 
                VALUES (2016539867, 2, 5, 'Jose', 'Fernandez', 'Rodriguez', 'Jfer@gmail.com', 89673645);
INSERT INTO Estudiante (idEstudiante, idInstitución, idCarrera, Nombre, Primer_Apellido, Segundo_Apellido, Correo, Telefono) 
                VALUES (2017256345, 1, 5, 'Paola ', 'Martinez', 'Rojas ', 'Pmar@hotmail.com', 75286345);
INSERT INTO Estudiante (idEstudiante, idInstitución, idCarrera, Nombre, Primer_Apellido, Segundo_Apellido, Correo, Telefono) 
                VALUES (2018997118, 1, 7, 'Ramses', 'Sanabria', 'Avendaño', 'ramsana@gmail.com', 76433223);

-------- UPDATE Statement----------------
UPDATE Estudiante
   SET Nombre = "Andres"
 WHERE idEstudiante == 2016243863


--------DELETE Statement-----------

DELETE FROM Estudiante
      WHERE idEstudiante == 2012223895

-- Table: Horario
CREATE TABLE Horario (
    idMenu        INTEGER REFERENCES Menu (idMenu) ON DELETE CASCADE
                                                   ON UPDATE CASCADE
                          NOT NULL,
    idRestaurante INTEGER REFERENCES Restaurante (idRestaurante) ON DELETE CASCADE
                                                                 ON UPDATE CASCADE,
    Fecha         DATE    NOT NULL,
    Semestre      VARCHAR NOT NULL
);

INSERT INTO Horario (idMenu, idRestaurante, Fecha, Semestre) 
            VALUES (1, 2, '2018-08-05', 'Primer semestre');
INSERT INTO Horario (idMenu, idRestaurante, Fecha, Semestre) 
            VALUES (2, 4, '2018-08-03', 'Segundo semestre');
INSERT INTO Horario (idMenu, idRestaurante, Fecha, Semestre) 
            VALUES (2, 5, '2018-08-07', 'Segundo semestre');

-- Table: Institución
CREATE TABLE Institución (
    idInstitución INTEGER PRIMARY KEY
                          NOT NULL,
    Nombre        VARCHAR NOT NULL,
    Sede          VARCHAR NOT NULL
);

INSERT INTO Institución (idInstitución, Nombre, Sede) 
            VALUES (1, 'TEC', 'Cartago');
INSERT INTO Institución (idInstitución, Nombre, Sede) 
            VALUES (2, 'TEC', 'San José');
INSERT INTO Institución (idInstitución, Nombre, Sede) 
            VALUES (3, 'TEC', 'San Carlos');
INSERT INTO Institución (idInstitución, Nombre, Sede) 
            VALUES (4, 'TEC', 'Limón');

-- Table: Menu
CREATE TABLE Menu (
    idMenu     INTEGER PRIMARY KEY
                       NOT NULL,
    HoraComida TIME    NOT NULL,
    Tipo       VARCHAR NOT NULL,
    idPlatillo INTEGER NOT NULL
                       REFERENCES Platillo (idPlatillo) ON DELETE CASCADE
                                                        ON UPDATE CASCADE
);

INSERT INTO Menu (idMenu, HoraComida, Tipo, idPlatillo) 
            VALUES (1, '12:00', 'Almuerzo', 1);
INSERT INTO Menu (idMenu, HoraComida, Tipo, idPlatillo) 
            VALUES (2, '9:00', 'Desayuno', 2);
INSERT INTO Menu (idMenu, HoraComida, Tipo, idPlatillo) 
            VALUES (3, '12:00', 'Almuerzo', 3);
INSERT INTO Menu (idMenu, HoraComida, Tipo, idPlatillo) 
            VALUES (4, '12:00', 'Almuerzo', 4);
INSERT INTO Menu (idMenu, HoraComida, Tipo, idPlatillo) 
            VALUES (5, '15:00', 'Café de la Tarde', 5);

-- Table: Platillo
CREATE TABLE Platillo (
    idPlatillo  INTEGER PRIMARY KEY
                        NOT NULL,
    Nombre      VARCHAR NOT NULL,
    Precio      DECIMAL NOT NULL,
    Descripción VARCHAR NOT NULL
);

INSERT INTO Platillo (idPlatillo, Nombre, Precio, Descripción) 
                VALUES (1, 'Casado', 2500, 'Arroz,Frijoles,Carne y ensalada con Refresco');
INSERT INTO Platillo (idPlatillo, Nombre, Precio, Descripción) 
                VALUES (2, 'Pinto', 1500, 'Arroz y frijoles mezclados con huevo y café');
INSERT INTO Platillo (idPlatillo, Nombre, Precio, Descripción) 
                VALUES (3, 'Sopa', 1500, 'CAldo de pollo con vejetales Alv :v');
INSERT INTO Platillo (idPlatillo, Nombre, Precio, Descripción) 
                VALUES (4, 'Sopa Azteca ', 4000, 'Mae es sopa Azteca :v');
INSERT INTO Platillo (idPlatillo, Nombre, Precio, Descripción) 
                VALUES (5, 'Reposteria', 1750, 'Pacito de todos los sabores');

-- Table: PlatilloRating
CREATE TABLE PlatilloRating (
    idPlatillo    INTEGER REFERENCES Platillo (idPlatillo) ON DELETE CASCADE
                                                           ON UPDATE CASCADE
                          NOT NULL,
    idEstudiante  INTEGER REFERENCES Estudiante (idEstudiante) ON DELETE CASCADE
                                                               ON UPDATE CASCADE
                          NOT NULL,
    idRestaurante INTEGER REFERENCES Restaurante (idRestaurante),
    Puntuacion    BOOLEAN NOT NULL,
    Fecha         DATE,
    Comentario    VARCHAR NOT NULL
);

INSERT INTO PlatilloRating (idPlatillo, idEstudiante, idRestaurante, Puntuacion, Fecha, Comentario) 
                    VALUES (4, 2016539867, 3, 0, '2018-09-02', 'Prometio');
INSERT INTO PlatilloRating (idPlatillo, idEstudiante, idRestaurante, Puntuacion, Fecha, Comentario) 
                    VALUES (4, 2016243863, 1, 1, '2018-04-29', 'Estaba fría');
INSERT INTO PlatilloRating (idPlatillo, idEstudiante, idRestaurante, Puntuacion, Fecha, Comentario) 
                    VALUES (4, 2013254678, 5, 1, '2018-02-02', 'Rico si prros');
INSERT INTO PlatilloRating (idPlatillo, idEstudiante, idRestaurante, Puntuacion, Fecha, Comentario) 
                    VALUES (1, 2017256345, 2, 0, '2018-09-02', 'Muy caro :v');
INSERT INTO PlatilloRating (idPlatillo, idEstudiante, idRestaurante, Puntuacion, Fecha, Comentario) 
                    VALUES (1, 2013254678, 5, 1, '2018-05-02', 'Promete');
INSERT INTO PlatilloRating (idPlatillo, idEstudiante, idRestaurante, Puntuacion, Fecha, Comentario) 
                    VALUES (1, 2016243863, 6, 0, '2018-05-02', 'Malo');

-- Table: Restaurante
CREATE TABLE Restaurante (
    idRestaurante INTEGER PRIMARY KEY
                          NOT NULL,
    Nombre        VARCHAR NOT NULL,
    Tipo          VARCHAR NOT NULL,
    idIstitución          REFERENCES Institución (idInstitución) ON DELETE CASCADE
                                                                 ON UPDATE CASCADE,
    idUbicación   INTEGER NOT NULL
                          REFERENCES Ubicación (idUbicacón) ON DELETE CASCADE
                                                            ON UPDATE CASCADE
);

INSERT INTO Restaurante (idRestaurante, Nombre, Tipo, idIstitución, idUbicación) 
                VALUES (1, 'Casa Luna', 'Soda', 1, 1);
INSERT INTO Restaurante (idRestaurante, Nombre, Tipo, idIstitución, idUbicación) 
                VALUES (2, 'Institucional Cartago', 'Comedor', 1, 2);
INSERT INTO Restaurante (idRestaurante, Nombre, Tipo, idIstitución, idUbicación) 
                VALUES (3, 'Institucional San José', 'Comedor', 2, 6);
INSERT INTO Restaurante (idRestaurante, Nombre, Tipo, idIstitución, idUbicación) 
                VALUES (4, 'Institucional San Carlos', 'Comedor', 3, 4);
INSERT INTO Restaurante (idRestaurante, Nombre, Tipo, idIstitución, idUbicación) 
                VALUES (5, 'Institucional Limón', 'Comedor', 4, 5);
INSERT INTO Restaurante (idRestaurante, Nombre, Tipo, idIstitución, idUbicación) 
                VALUES (6, 'El lago', 'Soda', 1, 3);

-- Table: RestauranteRaiting
CREATE TABLE RestauranteRaiting (
    idEstudiante  INTEGER REFERENCES Estudiante (idEstudiante) 
                          NOT NULL,
    idRestaurante INTEGER NOT NULL
                          REFERENCES Restaurante (idRestaurante),
    Puntuación    DECIMAL NOT NULL,
    Comentario    VARCHAR NOT NULL
);

INSERT INTO RestauranteRaiting (idEstudiante, idRestaurante, Puntuación, Comentario) 
                        VALUES (2013568742, 2, 1, 'Excelente servicio y comida');
INSERT INTO RestauranteRaiting (idEstudiante, idRestaurante, Puntuación, Comentario) 
                        VALUES (2017256345, 1, 0, 'Buena Comida');
INSERT INTO RestauranteRaiting (idEstudiante, idRestaurante, Puntuación, Comentario) 
                        VALUES (2016539867, 3, 1, 'Muy mal servicio');
INSERT INTO RestauranteRaiting (idEstudiante, idRestaurante, Puntuación, Comentario) 
                        VALUES (2016243863, 2, 1, 'Exelente Comida');
INSERT INTO RestauranteRaiting (idEstudiante, idRestaurante, Puntuación, Comentario) 
                        VALUES (2013568742, 6, 1, 'Buena Comida');
INSERT INTO RestauranteRaiting (idEstudiante, idRestaurante, Puntuación, Comentario) 
                        VALUES (2013254678, 5, 0, 'Servicio Regular');
INSERT INTO RestauranteRaiting (idEstudiante, idRestaurante, Puntuación, Comentario) 
                        VALUES (2011697852, 4, 0, 'Buena comida');
INSERT INTO RestauranteRaiting (idEstudiante, idRestaurante, Puntuación, Comentario) 
                        VALUES (2016243863, 3, 1, 'Buena comida');
INSERT INTO RestauranteRaiting (idEstudiante, idRestaurante, Puntuación, Comentario) 
                        VALUES (2016539867, 5, 0, 'Mala Comida');

-- Table: RestauranteXPlatillo
CREATE TABLE RestauranteXPlatillo (
    idPlatillo    INTEGER REFERENCES Platillo (idPlatillo) ON DELETE CASCADE
                                                           ON UPDATE CASCADE
                          NOT NULL,
    idRestaurante INTEGER NOT NULL
                          REFERENCES Restaurante (idRestaurante) ON DELETE CASCADE
                                                                 ON UPDATE CASCADE
);

INSERT INTO RestauranteXPlatillo (idPlatillo, idRestaurante) VALUES (5, 2);
INSERT INTO RestauranteXPlatillo (idPlatillo, idRestaurante) VALUES (5, 6);
INSERT INTO RestauranteXPlatillo (idPlatillo, idRestaurante) VALUES (5, 1);
INSERT INTO RestauranteXPlatillo (idPlatillo, idRestaurante) VALUES (4, 4);
INSERT INTO RestauranteXPlatillo (idPlatillo, idRestaurante) VALUES (4, 2);
INSERT INTO RestauranteXPlatillo (idPlatillo, idRestaurante) VALUES (3, 5);
INSERT INTO RestauranteXPlatillo (idPlatillo, idRestaurante) VALUES (2, 5);
INSERT INTO RestauranteXPlatillo (idPlatillo, idRestaurante) VALUES (2, 4);
INSERT INTO RestauranteXPlatillo (idPlatillo, idRestaurante) VALUES (2, 3);
INSERT INTO RestauranteXPlatillo (idPlatillo, idRestaurante) VALUES (2, 2);
INSERT INTO RestauranteXPlatillo (idPlatillo, idRestaurante) VALUES (1, 6);
INSERT INTO RestauranteXPlatillo (idPlatillo, idRestaurante) VALUES (1, 1);

-- Table: Ubicación
CREATE TABLE Ubicación (
    idUbicacón INTEGER PRIMARY KEY
                       NOT NULL,
    Ubicación  VARCHAR NOT NULL,
    Detalle    VARCHAR NOT NULL
);

INSERT INTO Ubicación (idUbicacón, Ubicación, Detalle) 
                VALUES (1, 'Cartago', 'A la par del Gimnasio');
INSERT INTO Ubicación (idUbicacón, Ubicación, Detalle) 
                VALUES (2, 'Cartago', 'En el Pretil');
INSERT INTO Ubicación (idUbicacón, Ubicación, Detalle) 
                VALUES (3, 'Cartago', 'A la par del Lago');
INSERT INTO Ubicación (idUbicacón, Ubicación, Detalle) 
                VALUES (4, 'San Carlos', 'En el centro');
INSERT INTO Ubicación (idUbicacón, Ubicación, Detalle) 
                VALUES (5, 'Limón', 'En el centro');
INSERT INTO Ubicación (idUbicacón, Ubicación, Detalle) 
                VALUES (6, 'San José', 'En el centro');