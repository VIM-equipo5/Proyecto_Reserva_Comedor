drop database if exists reserva_comedor;
CREATE DATABASE IF NOT EXISTS `reserva_comedor` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `reserva_comedor`;

-- --------------------------------------------------------

DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `IdRol` int(11) NOT NULL AUTO_INCREMENT,
  `NombreRol` varchar(100) NOT NULL,
  `Descripcion` text,
  PRIMARY KEY (`IdRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `bebidas`;
CREATE TABLE IF NOT EXISTS `bebidas` (
  `IdBebida` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `PrecioUnitario` decimal(10,2) NOT NULL,
  /* Tipo cambiando de blob a varchar, 18:50 ,28 marzo 2021*/
  `Imagen` VARCHAR(255),
  `Descripcion` text,
  PRIMARY KEY (`IdBebida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `IdCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `Descripcion` text,
  PRIMARY KEY (`IdCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `franjahoraria`;
CREATE TABLE IF NOT EXISTS `franjahoraria` (
  `IdFranja` int(11) NOT NULL AUTO_INCREMENT,
  `CapacidadMax` int(11) NOT NULL,
  `OcupacionTotal` int(11) NOT NULL,
  `FranjaInicio` TIME,
  `FranjaFin` TIME,
  PRIMARY KEY (`IdFranja`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



DROP TABLE IF EXISTS `platos`;
CREATE TABLE IF NOT EXISTS `platos` (
  `IdPlato` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Descripcion` text,
  /* Tipo cambiando de blob a varchar, 18:50 ,28 marzo 2021*/
  `Imagen` varchar(255),
  `PrecioUnitario` decimal(10,2) NOT NULL,
  `Tipo` varchar(50) NOT NULL,
  `IdCategoria` int(11) NOT NULL,
  PRIMARY KEY (`IdPlato`),
  FOREIGN KEY (`IdCategoria`) REFERENCES  `categoria` (`IdCategoria`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `IdUsuario` int(11) NOT NULL AUTO_INCREMENT,
  /* nombreUsuario ahora es UNIQUE , 18:50 ,28 marzo 2021*/
  `NombreUsuario` varchar(100) UNIQUE,
  `Contraseña` varchar(20) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `DNI` VARCHAR(9) NOT NULL UNIQUE,
  `Telefono` int(9) NOT NULL,
  `IdRol` int(11) NOT NULL,
  PRIMARY KEY (`IdUsuario`),
  FOREIGN KEY (`IdRol`) REFERENCES  `rol` (`IdRol`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `reserva`;
CREATE TABLE IF NOT EXISTS `reserva` (
  `IdReserva` int(11) NOT NULL AUTO_INCREMENT,
  `CantidadComensales` int(11) NOT NULL,
  `PrecioTotal` decimal(10,2) NOT NULL,
  `FechaReserva` timestamp NOT NULL DEFAULT current_timestamp,
  `FechaReservada` date NOT NULL,
  `IdUsuario` int(11), -- Se deja nula para poder borrar usuarios sin tener que perder reservas (para uso estadístico)
  `IdFranja` int(11), -- Se deja nula para poder modificar franjas horarias
  PRIMARY KEY (`IdReserva`),
  FOREIGN KEY (`IdUsuario`) REFERENCES  `usuario` (`IdUsuario`)
  ON UPDATE CASCADE
  ON DELETE SET NULL,
  FOREIGN KEY (`IdFranja`) REFERENCES  `franjahoraria` (`IdFranja`)
  ON UPDATE CASCADE
  ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `pedirplatos`;
CREATE TABLE IF NOT EXISTS `pedirplatos` (
	id INT AUTO_INCREMENT,
  `IdReserva` int(11) NOT NULL,
  `IdPlato` int(11),
  `CantidadPlatos` int(11) NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (`IdReserva`) REFERENCES  `reserva` (`IdReserva`)
  ON UPDATE CASCADE
  ON DELETE CASCADE,
  FOREIGN KEY (`IdPlato`) REFERENCES  `platos` (`IdPlato`)
  ON UPDATE CASCADE
  ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `ofrecerbebidas`;
CREATE TABLE IF NOT EXISTS `ofrecerbebidas` (
	id INT AUTO_INCREMENT,
  `IdReserva` int(11) NOT NULL,
  `IdBebida` int(11),
  `CantidadBebidas` int(11) NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY (`IdReserva`) REFERENCES  `reserva` (`IdReserva`)
  ON UPDATE CASCADE
  ON DELETE CASCADE,
  FOREIGN KEY (`IdBebida`) REFERENCES  `bebidas` (`IdBebida`)
  ON UPDATE CASCADE
  ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
