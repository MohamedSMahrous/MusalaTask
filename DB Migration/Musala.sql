-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 11, 2021 at 03:03 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Musala`
--

-- --------------------------------------------------------

--
-- Table structure for table `gateway`
--

CREATE TABLE `gateway` (
  `id` int(11) NOT NULL,
  `ipv4` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `serial_number` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gateway`
--

INSERT INTO `gateway` (`id`, `ipv4`, `name`, `serial_number`) VALUES
(2, '192.168.10.20', 'gateway2', '123456790'),
(3, '192.168.10.30', 'gateway3', '123456791'),
(4, '192.168.10.40', 'gateway4', '123456792'),
(5, '192.168.10.50', 'GateWayNew', '123456795'),
(6, '192.168.10.60', 'GateWay254', '123456797'),
(7, '192.168.10.60', 'GateWay254', '123456797'),
(8, '192.168.10.70', 'GateWay612', '123456798'),
(9, '192.168.10.70', 'GateWay621', '123456888'),
(10, '192.168.10.75', 'GateWay62', '123456881'),
(11, '192.168.10.75', 'GateWay62', '123456881'),
(12, '192.168.10.75', 'GateWay62', '123456881');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(4);

-- --------------------------------------------------------

--
-- Table structure for table `peripheral`
--

CREATE TABLE `peripheral` (
  `id` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `created` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `vendor` varchar(255) DEFAULT NULL,
  `gateway_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `peripheral`
--

INSERT INTO `peripheral` (`id`, `uid`, `created`, `status`, `vendor`, `gateway_id`) VALUES
(6, 1005, '2021-08-10 17:11:19', 'online', 'TMS', 2),
(7, 1006, '2021-08-10 17:11:19', 'offline', 'TMS', 2),
(8, 1007, '2021-08-10 17:11:19', 'online', 'TMS', 2),
(9, 1008, '2021-08-10 17:11:19', 'online', 'TMS', 4),
(10, 1009, '2021-08-10 17:11:19', 'online', 'TMS', 4),
(11, 1010, '2021-08-10 17:11:19', 'offline', 'TMS', 4),
(12, 1011, '2021-08-10 17:11:19', 'online', 'TMS', 4),
(13, 1012, '2021-08-10 17:11:19', 'offline', 'TMS', 3),
(14, 1013, '2021-08-10 17:11:19', 'online', 'TMS', 3),
(15, 1014, '2021-08-10 17:11:19', 'offline', 'TMS', 3),
(16, 1015, '2021-08-10 17:11:19', 'online', 'TMS', 3),
(17, 0, '2021-08-10 02:00:00', 'online', 'TMS', 5),
(18, 0, '2021-08-10 02:00:00', 'online', 'TMS', 5),
(19, 0, '2021-08-10 02:00:00', 'offline', 'TMS', 5),
(20, 0, '2021-08-10 02:00:00', 'online', 'TMS', 6),
(21, 0, '2021-08-10 02:00:00', 'online', 'TMS', 6),
(22, 0, '2021-08-10 02:00:00', 'offline', 'TMS', 6),
(23, 1025, '2021-08-10 02:00:00', 'online', 'TMS', 7),
(24, 1035, '2021-08-10 02:00:00', 'online', 'TMS', 7),
(25, 1037, '2021-08-10 02:00:00', 'offline', 'TMS', 7),
(26, 1027, '2021-08-10 02:00:00', 'online', 'TMS', 8),
(27, 1036, '2021-08-10 02:00:00', 'online', 'TMS', 8),
(28, 1038, '2021-08-10 02:00:00', 'offline', 'TMS', 8),
(29, 1100, '2021-08-10 02:00:00', 'online', 'TMS', 9),
(30, 1101, '2021-08-10 02:00:00', 'online', 'TMS', 9),
(31, 1102, '2021-08-10 02:00:00', 'offline', 'TMS', 9),
(32, 1103, '2021-08-10 02:00:00', 'online', 'TMS', 10),
(33, 1104, '2021-08-10 02:00:00', 'online', 'TMS', 10),
(34, 1105, '2021-08-10 02:00:00', 'offline', 'TMS', 10),
(35, 1103, '2021-08-10 02:00:00', 'online', 'TMS', 11),
(36, 1104, '2021-08-10 02:00:00', 'online', 'TMS', 11),
(37, 1105, '2021-08-10 02:00:00', 'offline', 'TMS', 11),
(38, 1103, '2021-08-10 02:00:00', 'online', 'TMS', 12),
(39, 1104, '2021-08-10 02:00:00', 'online', 'TMS', 12),
(40, 1105, '2021-08-10 02:00:00', 'offline', 'TMS', 12),
(0, 1105, '2021-08-10 02:00:00', 'online', 'TMS', 12),
(41, 1106, '2021-08-10 02:00:00', 'offline', 'TMS', 12);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gateway`
--
ALTER TABLE `gateway`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `peripheral`
--
ALTER TABLE `peripheral`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5jmmc4fnfkoqnmn8uxjwnemqr` (`gateway_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
