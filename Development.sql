-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2023 at 08:38 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coursework`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `cart_id` int(10) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Product_Name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`cart_id`, `Email`, `Product_Name`) VALUES
(1, '[ab@gmail.com]', '[Puma]'),
(2, '[s@gmail.com]', '[Anta]'),
(3, '[test@gmail.com]', '[Adidas]'),
(4, '[test@gmail.com]', '[Supreme]'),
(5, '[rc@g.com]', '[Eclipse]');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ProductName` varchar(255) NOT NULL,
  `Brand` varchar(255) NOT NULL,
  `Stock` varchar(255) NOT NULL,
  `Price` varchar(255) NOT NULL,
  `Image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ProductName`, `Brand`, `Stock`, `Price`, `Image`) VALUES
('Polo', 'Nike', '100', '1200', 'product3.jpg'),
('Anta', 'KTM', '200', '1500', 'product1.jpg'),
('Adidas', 'MountainDew', '50', '2500', 'product3.jpg'),
('Supreme', 'RED', '300', '1500', 'product4.jpg'),
('Puma', 'PumaSE', '200', '1000', 'product5.jpg'),
('Nikey', 'TRI', '200', '2000', 'product7.jpg'),
('Fima', 'Filla', '500', '1999', 'product8.jpg'),
('Playboy', 'Filas', '200', '1000', 'product9.jpg'),
('Noms', 'P.E', '100', '1000', 'product10.jpg'),
('Eclipse', 'ECJAV', '200', '2000', 'product5.jpg'),
('Eclipse', 'ECJAV', '200', '2000', 'product5.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE `register` (
  `FirstName` text NOT NULL,
  `LastName` text NOT NULL,
  `Number` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Role` text NOT NULL,
  `Image` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`FirstName`, `LastName`, `Number`, `Email`, `Password`, `Role`, `Image`) VALUES
('Ayush', 'Anush', '9823612413', 'shakyaroheet7@gmail.com', '1111', 'user', '2022-08-26 (1).png'),
('Test', 'Case', '1234567890', 'test@gmail.com', 'LÈk­¢$ÎfT×', 'user', 'test.jpg'),
('a', 'b', '1246381', 'x@gmail.com', '`LÈk­¢$ÎfT×', 'admin', '2023-02-27.png'),
('Anush', 'Shrestha', '9087231231', '9@gmail.com', '($­Fý÷ÏØÂe¬', 'user', 'product15.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cart_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `cart_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
