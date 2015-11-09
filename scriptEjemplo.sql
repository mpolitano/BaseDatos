


drop schema if exists proyecto1 cascade;
CREATE schema proyecto1;

DROP TABLE IF EXISTS proyecto1.curso;
CREATE TABLE proyecto1.curso (
  nombre_curso varchar(40) NOT NULL ,
  descripcion varchar(255) NOT NULL default '',
  cantidad_maxima_alumnos integer NOT NULL default 0,
  PRIMARY KEY  (nombre_curso)
);

INSERT INTO proyecto1.curso  VALUES
 ('matematica','Matemática general',20),
 ('Ingles','Ingles general',30),
 ('Biologia','Biología Introductoria',10),
 ('Plastica','Repaso de Plastica',15);


DROP TABLE IF EXISTS proyecto1.alumno;
CREATE TABLE proyecto1.alumno (
  dni varchar(15)  NOT NULL,
  nombre_y_apellido varchar(145) NOT NULL default '',
  direccion varchar(100) NOT NULL default '',
  PRIMARY KEY  (dni)
) ;


INSERT INTO proyecto1.alumno  VALUES
 ('23545688','Carlos Gonzalez','San Martin 946'),
 ('21542382','Juan Darto','San Juan 146'),
 ('33543618','Diero Ramirez','Constitución 1200');



DROP TABLE IF EXISTS proyecto1.realiza;
CREATE TABLE proyecto1.realiza (
  nombre_curso varchar(40) NOT NULL default '',
  dni varchar(15) NOT NULL default '',
  nota numeric(4,2) NOT NULL default '0.0',
  PRIMARY KEY  (nombre_curso,dni)
) ;


INSERT INTO proyecto1.realiza  VALUES
 ('matematica','23545688','4.8'),
 ('matematica','21542382','10'),
 ('Biologia','23545688','7.5'),
 ('Biologia','33543618','8.9'),
 ('Ingles','33543618','5.9'),
 ('matematica','33543618','4.8');





