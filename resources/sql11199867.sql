-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Servidor: sql11.freesqldatabase.com
-- Tiempo de generación: 20-10-2017 a las 07:25:57
-- Versión del servidor: 5.5.53-0ubuntu0.14.04.1
-- Versión de PHP: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sql11199867`
--
CREATE DATABASE IF NOT EXISTS `sql11199867` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `sql11199867`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Admin`
--

CREATE TABLE `Admin` (
  `id` int(11) NOT NULL,
  `nombre` varchar(35) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Producto`
--

CREATE TABLE `Producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `precio` double NOT NULL,
  `descripcion` text NOT NULL,
  `cantidad` int(11) NOT NULL,
  `categoria` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Producto`
--

INSERT INTO `Producto` (`id`, `nombre`, `precio`, `descripcion`, `cantidad`, `categoria`) VALUES
(1, 'Colchón de látex', 300, 'Colchón de 120x90 con almohada viscoelástica.', 4, 'cama'),
(2, 'Armario empotrado', 350, 'Medidas: 60x150,Madera de roble.', 5, 'Armarios'),
(3, 'Televisor 4K', 499, 'Pulgadas: 42,USB y HDMI,SmartTV', 6, 'televisores'),
(4, 'Mesa de mármol', 450, 'Medidas: 60x110', 3, 'mesas'),
(5, 'Mesa de madera', 300, 'Medidas: 50x100', 5, 'mesas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuarios`
--

CREATE TABLE `Usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(35) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `domicilio` text NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `mail` varchar(50) NOT NULL,
  `password` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Admin`
--
ALTER TABLE `Admin`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `Producto`
--
ALTER TABLE `Producto`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `Usuarios`
--
ALTER TABLE `Usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Admin`
--
ALTER TABLE `Admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `Producto`
--
ALTER TABLE `Producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT de la tabla `Usuarios`
--
ALTER TABLE `Usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
