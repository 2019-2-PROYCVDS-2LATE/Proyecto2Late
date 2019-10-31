CREATE TABLE IF NOT EXISTS Usuario(
  correo VARCHAR(45)NOT NULL,
  contraseña VARCHAR(45)NOT NULL,
  rol VARCHAR(45)NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  PRIMARY KEY (correo))
;

CREATE TABLE IF NOT EXISTS Recurso (
  id INT NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  tipo VARCHAR(45) NOT NULL,
  tiempo_prestamo INT NOT NULL,
  estado VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS Reserva (
  id INT NOT NULL,
  fecha_ini DATE NOT NULL,
  fecha_fin DATE NOT NULL,
  recurso INTEGER NOT NULL REFERENCES Recurso(id),
  usuario varchar(45) NOT NULL REFERENCES Usuario(correo),
  PRIMARY KEY (id));

