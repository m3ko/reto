-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-05-2024 a las 11:25:09
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `rentacar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `delete_historico`
--

CREATE TABLE `delete_historico` (
  `id_acción` int(11) NOT NULL,
  `tabla_afectada` varchar(50) NOT NULL,
  `fecha` date NOT NULL,
  `datos_anteriores` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `delete_historico`
--

INSERT INTO `delete_historico` (`id_acción`, `tabla_afectada`, `fecha`, `datos_anteriores`) VALUES
(1, 'empresas', '2024-05-13', '1234, prueba, prueba');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresas`
--

CREATE TABLE `empresas` (
  `cif_empresa` varchar(50) NOT NULL,
  `nombre_empresa` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empresas`
--

INSERT INTO `empresas` (`cif_empresa`, `nombre_empresa`, `direccion`) VALUES
('ABC123', 'Rent-A-Car Express', 'Calle Principal 123'),
('CDE987', 'Rent-A-Car VIP', 'Plaza de Oro 789'),
('DEF456', 'Alquiler de Autos Veloz', 'Avenida Central 456'),
('FGH654', 'Turismo Premium', 'Avenida del Éxito 654'),
('GHI789', 'Autos Familiar S.A.', 'Plaza Mayor 789'),
('IJK321', 'Autos Elegantes S.A.', 'Calle del Lujo 321'),
('JKL321', 'Autos Rápidos S.A.', 'Calle Veloz 456'),
('MNO654', 'Alquiler Familiar', 'Plaza de la Estrella 321'),
('QRS987', 'Rent-a-Car Prestigio', 'Carrera de Lujo 987'),
('TUV654', 'Turismo Express', 'Paseo del Sol 654'),
('WXY321', 'Autos de Calidad', 'Avenida Principal 123'),
('XYZ987', 'Turismo Car Rental', 'Avenida Libertad 789'),
('ZAB654', 'Alquileres Estrella', 'Calle del Mar 456');

--
-- Disparadores `empresas`
--
DELIMITER $$
CREATE TRIGGER `trigger_delete` BEFORE DELETE ON `empresas` FOR EACH ROW BEGIN
	INSERT INTO delete_historico (tabla_afectada, fecha, datos_anteriores)
    VALUES("empresas",NOW(),CONCAT(old.cif_empresa, ", ",old.direccion, ", ", old.nombre_empresa));
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trigger_update` BEFORE UPDATE ON `empresas` FOR EACH ROW BEGIN
	INSERT INTO update_historico_historico (tabla_afectada, fecha, datos_anteriores, datos_actualizados)
    VALUES("empresas",NOW(),CONCAT(old.cif_empresa, ", ",old.direccion, ", ", old.nombre_empresa),CONCAT(new.cif_empresa, ", ",new.direccion, ", ", new.nombre_empresa));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `itinerarios`
--

CREATE TABLE `itinerarios` (
  `id_itinerario` int(11) NOT NULL,
  `cif_empresa` varchar(50) NOT NULL,
  `codigo_vehiculo` varchar(50) NOT NULL,
  `fecha_entrega` date NOT NULL,
  `fecha_recogida` date NOT NULL,
  `hora_recogida` time NOT NULL,
  `hora_entrega` time NOT NULL,
  `precio_total` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `itinerarios`
--

INSERT INTO `itinerarios` (`id_itinerario`, `cif_empresa`, `codigo_vehiculo`, `fecha_entrega`, `fecha_recogida`, `hora_recogida`, `hora_entrega`, `precio_total`) VALUES
(13, 'MNO654', 'VH060', '2024-05-18', '2024-05-16', '05:20:00', '04:20:00', 0),
(14, 'GHI789', 'VH051', '2024-05-12', '2024-05-09', '04:30:00', '04:30:00', 0),
(16, 'JKL321', 'VH044', '2024-05-11', '2024-05-10', '03:20:00', '05:25:00', 0),
(18, 'ZAB654', 'VH058', '2024-05-26', '2024-05-23', '06:35:00', '06:40:00', 0),
(19, 'WXY321', 'VH052', '2024-05-26', '2024-05-21', '22:50:00', '21:50:00', 3250),
(20, 'DEF456', 'VH066', '2024-05-31', '2024-05-30', '06:50:00', '22:40:00', 600),
(21, 'ABC123', 'VH030', '2024-08-18', '2024-08-15', '20:15:00', '20:35:00', 900),
(22, 'TUV654', 'VH024', '2027-12-25', '2027-12-10', '19:20:00', '22:40:00', 4500),
(23, 'IJK321', 'VH047', '2024-05-31', '2024-05-29', '20:35:00', '21:40:00', 1040),
(24, 'CDE987', 'VH016', '2025-12-18', '2024-09-11', '00:00:00', '00:00:00', 231500),
(25, 'MNO654', 'VH032', '2024-05-31', '2024-05-30', '21:05:00', '13:15:00', 500),
(26, 'ZAB654', 'VH007', '2024-08-10', '2024-07-10', '03:00:00', '03:00:00', 14880);

--
-- Disparadores `itinerarios`
--
DELIMITER $$
CREATE TRIGGER `trigger_delete_iti` BEFORE DELETE ON `itinerarios` FOR EACH ROW BEGIN
	INSERT INTO delete_historico (tabla_afectada, fecha, datos_anteriores)
    VALUES("itinerarios",NOW(),CONCAT(old.id_itinerario, ", ", old.cif_empresa, ", ", old.codigo_vehiculo, ", ", old.fecha_entrega, ", ", old.fecha_recogida, ", ", old.hora_recogida, ", ", old.hora_entrega, ", ", old.precio_total));
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trigger_update_iti` BEFORE UPDATE ON `itinerarios` FOR EACH ROW BEGIN
	INSERT INTO update_historico (tabla_afectada, fecha, datos_anteriores, datos_actualizados)
    VALUES("itinerarios",NOW(),CONCAT(old.id_itinerario, ", ", old.cif_empresa, ", ", old.codigo_vehiculo, ", ", old.fecha_entrega, ", ", old.fecha_recogida, ", ", old.hora_recogida, ", ", old.hora_entrega, ", ", old.precio_total),CONCAT(new.id_itinerario, ", ", new.cif_empresa, ", ", new.codigo_vehiculo, ", ", new.fecha_entrega, ", ", new.fecha_recogida, ", ", new.hora_recogida, ", ", new.hora_entrega, ", ", new.precio_total));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `rol` int(1) NOT NULL DEFAULT 0,
  `mail` varchar(50) NOT NULL,
  `contraseña` varchar(255) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `clavePrivada` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`dni`, `nombre`, `apellido`, `rol`, `mail`, `contraseña`, `telefono`, `clavePrivada`) VALUES
('01234567H', 'Elena', 'Ortega', 1, 'elenaortega@email.com', 'ortega456', '0123456789', 185359),
('11223344G', 'Javier', 'Ruiz', 1, 'javierruiz@email.com', 'jruiz777', '1122334455', 840770),
('11223344P', 'Beatriz', 'Mendoza', 0, 'beatrizmendoza@email.com', 'beatrizpass', '1122334455', 647773),
('11223344W', 'Luis', 'Reyes', 0, 'luisreyes@email.com', 'luispass', '1122334455', 716557),
('12345678Y', 'Juan', 'Pérez', 1, 'juanperez@email.com', 'contraseña123', '1234567890', 639466),
('1234567Y', 'prueba1', 'prueba2', 0, 'prueba3@gmail.com', 'prueba', '123456789', 47660),
('22446688B', 'Rosa', 'Flores', 1, 'rosaflores@email.com', 'rosa123', '2244668800', 319901),
('22446688N', 'Marina', 'Delgado', 0, 'marinadelgado@email.com', 'marinapass', '2244668800', 456525),
('22446688U', 'Mario', 'Marín', 0, 'mariomarin@email.com', 'mariopass', '2244668800', 322922),
('23456789X', 'María', 'López', 1, 'marialopez@email.com', 'clave456', '2345678901', 245035),
('33445566F', 'Isabel', 'Jiménez', 1, 'isabeljimenez@email.com', 'isabelpass', '3344556677', 256410),
('33669977Q', 'Andrés', 'Rojas', 0, 'andresrojas@email.com', 'andrespass', '3366997711', 546947),
('33669977X', 'Teresa', 'García', 1, 'teresagarcia@email.com', 'teresapass', '3366997711', 965503),
('34567890Z', 'Carlos', 'González', 1, 'carlosgonzalez@email.com', 'secreto789', '3456789012', 186677),
('44881122A', 'Pablo', 'Santos', 1, 'pablosantos@email.com', 'pablopass', '4488112244', 36875),
('44881122T', 'Sofía', 'Iglesias', 0, 'sofiaiglesias@email.com', 'sofiapass', '4488112244', 624347),
('45678901M', 'Laura', 'Martínez', 1, 'lauramartinez@email.com', 'acceso123', '4567890123', 11107),
('55667788E', 'Antonio', 'Hernández', 1, 'antoniohernandez@email.com', 'antonioclave', '5566778899', 182498),
('56739', 'aitortch', 'aitor', 0, 'aitortch@gmail.com', '123', '123', 879167),
('56789012N', 'Pedro', 'Sánchez', 1, 'pedrosanchez@email.com', 'miclave456', '5678901234', 848344),
('66229933S', 'Jorge', 'Suárez', 0, 'jorgesuarez@email.com', 'jorgepass', '6622993366', 604219),
('66229933Z', 'Silvia', 'Cruz', 1, 'silviacruz@email.com', 'silviapass', '6622993366', 476064),
('66649087A', 'Sofia', 'Cañabate', 0, 'sofia@gmail.com', '123', '666666666', 552801),
('67890123L', 'Ana', 'Díaz', 1, 'anadiaz@email.com', 'contraseñaAna', '6789012345', 567665),
('77889900D', 'Lucía', 'Torres', 1, 'luciatorres@email.com', 'luciapass', '7788990011', 410131),
('77889900O', 'Gabriel', 'Guerrero', 0, 'gabrielguerrero@email.com', 'gabrielpass', '7788990011', 347662),
('77889900V', 'Eva', 'Herrera', 0, 'evaherrera@email.com', 'evapass', '7788990011', 507916),
('78901234K', 'Sergio', 'Rodríguez', 1, 'sergiorodriguez@email.com', 'claveSergio', '7890123456', 496594),
('88663344R', 'Natalia', 'Lara', 0, 'natalialara@email.com', 'nataliapass', '8866334488', 959225),
('88663344Y', 'Manuel', 'Molina', 1, 'manuelmolina@email.com', 'manuel123', '8866334488', 306344),
('89012345J', 'Carmen', 'Sanz', 1, 'carmensanz@email.com', 'carmen123', '8901234567', 654045),
('90123456I', 'Diego', 'Gómez', 1, 'diegogomez@email.com', 'diegopass', '9012345678', 351194),
('98765432X', 'Pepito', 'grillo', 0, 'grillo123@gmail.com', '123', '123', 793837),
('99001122C', 'Miguel', 'Vega', 1, 'miguelvega@email.com', 'miguelpass', '9900112233', 915600),
('a', 'b', 'c', 0, 'd', '666', '666', 631685),
('d', '', '', 0, '', '', '', 320725),
('dcsdv', 'svfsv', 'sfvsfv', 0, 'sdvsfv', '123', '41541', 696038),
('x123', 'admin', 'admin2', 0, '123@123', '123', '123', 196492);

--
-- Disparadores `personas`
--
DELIMITER $$
CREATE TRIGGER `trigger_delete_per` BEFORE DELETE ON `personas` FOR EACH ROW BEGIN
	INSERT INTO delete_historico (tabla_afectada, fecha, datos_anteriores)
    VALUES("personas",NOW(),CONCAT(old.dni, ", ", old.nombre, ", ", old.apellido, ", ", old.rol, ", ", old.mail, ", ", old.contraseña, ", ", old.telefono, ", ", old.clavePrivada));
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trigger_update_per` BEFORE UPDATE ON `personas` FOR EACH ROW BEGIN
	INSERT INTO update_historico (tabla_afectada, fecha, datos_anteriores, datos_actualizados)
    VALUES("personas",NOW(),CONCAT(old.dni, ", ", old.nombre, ", ", old.apellido, ", ", old.rol, ", ", old.mail, ", ", old.contraseña, ", ", old.telefono, ", ", old.clavePrivada), CONCAT(new.dni, ", ", new.nombre, ", ", new.apellido, ", ", new.rol, ", ", new.mail, ", ", new.contraseña, ", ", new.telefono, ", ", new.clavePrivada));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `id_reserva` int(11) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `cif_empresa` varchar(50) NOT NULL,
  `codigo_vehiculo` varchar(50) NOT NULL,
  `id_itinerario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reservas`
--

INSERT INTO `reservas` (`id_reserva`, `dni`, `cif_empresa`, `codigo_vehiculo`, `id_itinerario`) VALUES
(4, '01234567H', 'ABC123', 'VH018', 13),
(5, '01234567H', 'MNO654', 'VH060', 13),
(6, 'a', 'GHI789', 'VH051', 14),
(10, 'a', 'ZAB654', 'VH058', 18),
(11, 'a', 'WXY321', 'VH052', 19),
(12, 'a', 'DEF456', 'VH066', 20),
(13, 'a', 'ABC123', 'VH030', 21),
(14, 'a', 'TUV654', 'VH024', 22),
(15, '23456789X', 'IJK321', 'VH047', 23),
(16, '23456789X', 'CDE987', 'VH016', 24),
(17, '23456789X', 'MNO654', 'VH032', 25),
(18, '23456789X', 'ZAB654', 'VH007', 26);

--
-- Disparadores `reservas`
--
DELIMITER $$
CREATE TRIGGER `trigger_delete_res` BEFORE DELETE ON `reservas` FOR EACH ROW BEGIN
	INSERT INTO delete_historico (tabla_afectada, fecha, datos_anteriores)
    VALUES("reservas",NOW(),CONCAT(old.id_reserva, ", ", old.dni, ", ", old.cif_empresa, ", ", old.codigo_vehiculo, ", ", old.id_itinerario));
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trigger_update_res` BEFORE UPDATE ON `reservas` FOR EACH ROW BEGIN
	INSERT INTO update_historico (tabla_afectada, fecha, datos_anteriores, datos_actualizados)
    VALUES("reservas",NOW(),CONCAT(old.id_reserva, ", ", old.dni, ", ", old.cif_empresa, ", ", old.codigo_vehiculo, ", ", old.id_itinerario),CONCAT(new.id_reserva, ", ", new.dni, ", ", new.cif_empresa, ", ", new.codigo_vehiculo, ", ", new.id_itinerario));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sugerencias`
--

CREATE TABLE `sugerencias` (
  `id_sugerencia` int(11) NOT NULL,
  `nombre_persona` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `descripcion` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sugerencias`
--

INSERT INTO `sugerencias` (`id_sugerencia`, `nombre_persona`, `email`, `fecha_creacion`, `descripcion`) VALUES
(1, 'Laura Martínez', 'lauramartinez@email.com', '2024-04-20', 'Sería genial tener más opciones de vehículos familiares.'),
(2, 'Antonio Hernández', 'antoniohernandez@email.com', '2024-04-21', '¿Podrían agregar más modelos deportivos?'),
(3, 'María López', 'marialopez@email.com', '2024-04-22', '¡Excelente servicio! ¿Tienen planes de expansión a otras ciudades?');

--
-- Disparadores `sugerencias`
--
DELIMITER $$
CREATE TRIGGER `trigger_delete_sug` BEFORE DELETE ON `sugerencias` FOR EACH ROW BEGIN
	INSERT INTO delete_historico (tabla_afectada, fecha, datos_anteriores)
    VALUES("sugerencias",NOW(),CONCAT(old.nombre_persona, ", ", old.email, ", ", old.fecha_creacion, ", ", old.descripcion));
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trigger_update_sug` BEFORE UPDATE ON `sugerencias` FOR EACH ROW BEGIN
	INSERT INTO update_historico (tabla_afectada, fecha, datos_anteriores, datos_actualizados)
    VALUES("sugerencias",NOW(),CONCAT(old.nombre_persona, ", ", old.email, ", ", old.fecha_creacion, ", ", old.descripcion),CONCAT(new.nombre_persona, ", ", new.email, ", ", new.fecha_creacion, ", ", new.descripcion));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `update_historico`
--

CREATE TABLE `update_historico` (
  `id_acción` int(11) NOT NULL,
  `tabla_afectada` varchar(50) NOT NULL,
  `fecha` date NOT NULL,
  `datos_anteriores` text NOT NULL,
  `datos_actualizados` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

CREATE TABLE `vehiculos` (
  `codigo_vehiculo` varchar(10) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `año_fabricacion` int(50) NOT NULL,
  `precio_alquiler` int(20) NOT NULL,
  `estado` varchar(15) NOT NULL,
  `cif_empresa` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vehiculos`
--

INSERT INTO `vehiculos` (`codigo_vehiculo`, `marca`, `modelo`, `tipo`, `año_fabricacion`, `precio_alquiler`, `estado`, `cif_empresa`) VALUES
('VH001', 'Toyota', 'Corolla', 'Sedán', 2019, 200, 'Disponible', 'XYZ987'),
('VH002', 'Honda', 'Civic', 'Coupé', 2018, 250, 'Vendido', 'QRS987'),
('VH003', 'Ford', 'F-150', 'Camioneta', 2020, 400, 'Disponible', 'DEF456'),
('VH004', 'Chevrolet', 'Camaro', 'Deportivo', 2017, 500, 'Disponible', 'WXY321'),
('VH005', 'Nissan', 'Altima', 'Sedán', 2018, 300, 'Disponible', 'IJK321'),
('VH006', 'Toyota', 'RAV4', 'SUV', 2021, 450, 'Disponible', 'DEF456'),
('VH007', 'Honda', 'Pilot', 'SUV', 2019, 480, 'vendido', 'ZAB654'),
('VH008', 'Ford', 'Mustang', 'Deportivo', 2016, 550, 'Disponible', 'GHI789'),
('VH009', 'Chevrolet', 'Silverado', 'Camioneta', 2022, 600, 'Disponible', 'FGH654'),
('VH010', 'Nissan', 'Rogue', 'SUV', 2020, 420, 'Disponible', 'IJK321'),
('VH011', 'Toyota', 'Camry', 'Sedán', 2017, 270, 'Disponible', 'FGH654'),
('VH012', 'Honda', 'Accord', 'Sedán', 2019, 320, 'Disponible', 'ABC123'),
('VH013', 'Ford', 'Escape', 'SUV', 2018, 330, 'Disponible', 'JKL321'),
('VH014', 'Chevrolet', 'Equinox', 'SUV', 2021, 380, 'Disponible', 'FGH654'),
('VH015', 'Nissan', 'Sentra', 'Sedán', 2016, 200, 'Disponible', 'WXY321'),
('VH016', 'Toyota', 'Highlander', 'SUV', 2020, 500, 'vendido', 'CDE987'),
('VH017', 'Honda', 'HR-V', 'SUV', 2018, 400, 'vendido', 'ZAB654'),
('VH018', 'Ford', 'Explorer', 'SUV', 2017, 450, 'Disponible', 'FGH654'),
('VH019', 'Chevrolet', 'Malibu', 'Sedán', 2019, 320, 'Disponible', 'GHI789'),
('VH020', 'Nissan', 'Frontier', 'Camioneta', 2017, 400, 'Disponible', 'CDE987'),
('VH021', 'Toyota', 'Tacoma', 'Camioneta', 2021, 480, 'Disponible', 'QRS987'),
('VH022', 'Honda', 'Fit', 'Compacto', 2018, 250, 'Disponible', 'CDE987'),
('VH023', 'Ford', 'Fusion', 'Sedán', 2020, 330, 'Disponible', 'TUV654'),
('VH024', 'Chevrolet', 'Trax', 'SUV', 2019, 300, 'vendido', 'TUV654'),
('VH025', 'Nissan', 'Kicks', 'SUV', 2018, 280, 'vendido', 'WXY321'),
('VH026', 'Toyota', 'Yaris', 'Compacto', 2017, 250, 'vendido', 'GHI789'),
('VH027', 'Honda', 'Odyssey', 'Minivan', 2019, 500, 'Disponible', 'JKL321'),
('VH028', 'Ford', 'Edge', 'SUV', 2016, 380, 'Disponible', 'WXY321'),
('VH029', 'Chevrolet', 'Colorado', 'Camioneta', 2021, 450, 'Disponible', 'CDE987'),
('VH030', 'Nissan', 'Versa', 'Sedán', 2018, 300, 'vendido', 'ABC123'),
('VH031', 'Toyota', 'Sienna', 'Minivan', 2017, 400, 'Disponible', 'GHI789'),
('VH032', 'Honda', 'Ridgeline', 'Camioneta', 2019, 500, 'vendido', 'MNO654'),
('VH033', 'Ford', 'Ranger', 'Camioneta', 2018, 350, 'Disponible', 'GHI789'),
('VH034', 'Chevrolet', 'Sonic', 'Compacto', 2020, 280, 'Disponible', 'CDE987'),
('VH035', 'Nissan', 'Maxima', 'Sedán', 2019, 380, 'Disponible', 'DEF456'),
('VH036', 'Toyota', 'Prius', 'Híbrido', 2018, 360, 'Disponible', 'FGH654'),
('VH037', 'Honda', 'Insight', 'Híbrido', 2021, 400, 'Disponible', 'FGH654'),
('VH038', 'Ford', 'EcoSport', 'SUV', 2017, 330, 'Disponible', 'FGH654'),
('VH039', 'Chevrolet', 'Trailblazer', 'SUV', 2019, 450, 'Disponible', 'TUV654'),
('VH040', 'Nissan', '370Z', 'Deportivo', 2018, 500, 'Disponible', 'DEF456'),
('VH041', 'Toyota', 'Supra', 'Deportivo', 2020, 600, 'Disponible', 'CDE987'),
('VH043', 'Ford', 'Focus', 'Compacto', 2017, 320, 'Disponible', 'FGH654'),
('VH044', 'Chevrolet', 'Impala', 'Sedán', 2018, 380, 'Disponible', 'JKL321'),
('VH045', 'Nissan', 'Armada', 'SUV', 2021, 500, 'Disponible', 'MNO654'),
('VH046', 'Toyota', 'Land Cruiser', 'SUV', 2019, 700, 'Disponible', 'FGH654'),
('VH047', 'Honda', 'Passport', 'SUV', 2018, 520, 'vendido', 'IJK321'),
('VH048', 'Ford', 'Bronco', 'SUV', 2020, 600, 'Disponible', 'FGH654'),
('VH049', 'Chevrolet', 'Suburban', 'SUV', 2017, 580, 'Disponible', 'IJK321'),
('VH050', 'Nissan', 'Titan', 'Camioneta', 2019, 550, 'Disponible', 'DEF456'),
('VH051', 'Audi', 'A5', 'Coupé', 2022, 600, 'vendido', 'GHI789'),
('VH052', 'BMW', 'Serie 4', 'Coupé', 2023, 650, 'vendido', 'WXY321'),
('VH053', 'Mercedes-Benz', 'Clase C Coupé', 'Coupé', 2021, 580, 'Disponible', 'ZAB654'),
('VH054', 'Lexus', 'RC', 'Coupé', 2022, 620, 'Disponible', 'IJK321'),
('VH055', 'Infiniti', 'Q60', 'Coupé', 2020, 570, 'Disponible', 'FGH654'),
('VH057', 'BMW', 'M4', 'Coupé', 2022, 700, 'vendido', 'JKL321'),
('VH058', 'BMW', 'M8', 'Coupé', 2021, 800, 'vendido', 'ZAB654'),
('VH060', 'Mercedes-Benz', 'Clase E Coupé', 'Coupé', 2022, 650, 'vendido', 'MNO654'),
('VH061', 'Mercedes-Benz', 'Clase S Coupé', 'Coupé', 2020, 720, 'Disponible', 'DEF456'),
('VH063', 'Lexus', 'LC', 'Coupé', 2023, 720, 'Disponible', 'MNO654'),
('VH064', 'Lexus', 'RC F', 'Coupé', 2021, 680, 'Disponible', 'ZAB654'),
('VH066', 'Infiniti', 'Q50', 'Coupé', 2022, 600, 'vendido', 'DEF456'),
('VH067', 'Infiniti', 'Q70', 'Coupé', 2021, 640, 'Disponible', 'GHI789'),
('VH070', 'Honda', 'CR-Z', 'Coupé', 2021, 600, 'Disponible', 'QRS987');

--
-- Disparadores `vehiculos`
--
DELIMITER $$
CREATE TRIGGER `trigger_delete_vehi` BEFORE DELETE ON `vehiculos` FOR EACH ROW BEGIN
	INSERT INTO delete_historico (tabla_afectada, fecha, datos_anteriores)
    VALUES("vehiculos",NOW(),CONCAT(old.codigo_vehiculo, ", ", old.marca, ", ", old.modelo, ", ", old.tipo, ", ", old.año_fabricacion, ", ", old.precio_alquiler, ", ", old.estado, ", ", old.cif_empresa));
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trigger_update_vehi` BEFORE UPDATE ON `vehiculos` FOR EACH ROW BEGIN
	INSERT INTO update_historico (tabla_afectada, fecha, datos_anteriores, datos_actualizados)
    VALUES("vehiculos",NOW(),CONCAT(old.codigo_vehiculo, ", ", old.marca, ", ", old.modelo, ", ", old.tipo, ", ", old.año_fabricacion, ", ", old.precio_alquiler, ", ", old.estado, ", ", old.cif_empresa),CONCAT(new.codigo_vehiculo, ", ", new.marca, ", ", new.modelo, ", ", new.tipo, ", ", new.año_fabricacion, ", ", new.precio_alquiler, ", ", new.estado, ", ", new.cif_empresa));
END
$$
DELIMITER ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `delete_historico`
--
ALTER TABLE `delete_historico`
  ADD PRIMARY KEY (`id_acción`);

--
-- Indices de la tabla `empresas`
--
ALTER TABLE `empresas`
  ADD PRIMARY KEY (`cif_empresa`);

--
-- Indices de la tabla `itinerarios`
--
ALTER TABLE `itinerarios`
  ADD PRIMARY KEY (`id_itinerario`),
  ADD KEY `nombre_empresa` (`cif_empresa`),
  ADD KEY `nombre_vehiculo` (`codigo_vehiculo`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`id_reserva`),
  ADD KEY `dni_persona` (`dni`),
  ADD KEY `nombre_empresa` (`cif_empresa`),
  ADD KEY `nombre_vehiculo` (`codigo_vehiculo`),
  ADD KEY `id_itinerario` (`id_itinerario`);

--
-- Indices de la tabla `sugerencias`
--
ALTER TABLE `sugerencias`
  ADD PRIMARY KEY (`id_sugerencia`);

--
-- Indices de la tabla `update_historico`
--
ALTER TABLE `update_historico`
  ADD PRIMARY KEY (`id_acción`);

--
-- Indices de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD PRIMARY KEY (`codigo_vehiculo`),
  ADD KEY `fk_empresas_vehiculos` (`cif_empresa`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `delete_historico`
--
ALTER TABLE `delete_historico`
  MODIFY `id_acción` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `itinerarios`
--
ALTER TABLE `itinerarios`
  MODIFY `id_itinerario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `id_reserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `sugerencias`
--
ALTER TABLE `sugerencias`
  MODIFY `id_sugerencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `update_historico`
--
ALTER TABLE `update_historico`
  MODIFY `id_acción` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `itinerarios`
--
ALTER TABLE `itinerarios`
  ADD CONSTRAINT `itinerarios_ibfk_1` FOREIGN KEY (`cif_empresa`) REFERENCES `empresas` (`cif_empresa`),
  ADD CONSTRAINT `itinerarios_ibfk_2` FOREIGN KEY (`codigo_vehiculo`) REFERENCES `vehiculos` (`codigo_vehiculo`);

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `personas` (`dni`),
  ADD CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`cif_empresa`) REFERENCES `empresas` (`cif_empresa`),
  ADD CONSTRAINT `reservas_ibfk_3` FOREIGN KEY (`codigo_vehiculo`) REFERENCES `vehiculos` (`codigo_vehiculo`),
  ADD CONSTRAINT `reservas_ibfk_4` FOREIGN KEY (`id_itinerario`) REFERENCES `itinerarios` (`id_itinerario`);

--
-- Filtros para la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD CONSTRAINT `fk_empresas_vehiculos` FOREIGN KEY (`cif_empresa`) REFERENCES `empresas` (`cif_empresa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
