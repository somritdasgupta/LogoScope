-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 01, 2022 at 06:03 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `user_database`
--

CREATE TABLE `user_database` (
  `user_id` int(11) NOT NULL COMMENT 'for storing user id',
  `username` varchar(255) NOT NULL COMMENT 'for storing username',
  `email` varchar(255) NOT NULL COMMENT 'for storing user email',
  `password` varchar(255) NOT NULL COMMENT 'for storing user password',
  `isAdmin` int(1) NOT NULL COMMENT 'Deciding between admin or user'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_database`
--

INSERT INTO `user_database` (`user_id`, `username`, `email`, `password`, `isAdmin`) VALUES
(1, 'admin', 'admin@mail', 'admin', 1),
(5, 'new', 'new@mail', 'new', 0),
(19, 'aman', 'aman@mail', 'kumar', 0),
(21, 'harshit', 'harshit@mail', 'anant', 1),
(22, 'somrit', 'somrit@mail', 'dasgupta', 1),
(23, 'anjali', 'anjali@mail', 'burnwal', 1),
(24, 'normal', 'user@mail', 'user', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user_database`
--
ALTER TABLE `user_database`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user_database`
--
ALTER TABLE `user_database`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'for storing user id', AUTO_INCREMENT=25;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
