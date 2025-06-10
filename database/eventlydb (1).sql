-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 10, 2025 at 02:15 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eventlydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `card`
--

CREATE TABLE `card` (
  `event_name` varchar(255) NOT NULL,
  `event_number` varchar(255) NOT NULL,
  `card_number` varchar(255) NOT NULL,
  `expiry_date` varchar(255) NOT NULL,
  `cvv` varchar(255) NOT NULL,
  `cardholder_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `card`
--

INSERT INTO `card` (`event_name`, `event_number`, `card_number`, `expiry_date`, `cvv`, `cardholder_name`) VALUES
('anis', '09', '1234567', '4/29', '123', 'ANISH BOSVO'),
('dupee', '1234', '2334', 'y8dgcyr', 'diehfhu', 'ehfue'),
('THARA', 'GOL', '36497497194', '67/', '212', 'THARASHU'),
('THARASHU', 'GOLDEN ', '3649749719479', '67/9', '123', 'THARASHU'),
('dance', '05', '54545487866', '25/09/2027', '5546', 'malavika'),
('iebfuf', 'eubfuef', 'bcjebcb', 'jebcjbe', 'duewyvg', 'jcbjche'),
('RSRERDE', 'HVYGVYHBHVU', 'YDYTG', 'HGVFTF', '1234', 'PORCHEE');

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `EventNo` varchar(10) NOT NULL,
  `EventName` varchar(100) NOT NULL,
  `CoordinatorName` varchar(100) NOT NULL,
  `CoordinatorNo` varchar(15) NOT NULL,
  `Fee` varchar(100) NOT NULL,
  `Venue` varchar(100) NOT NULL,
  `EventDate` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`EventNo`, `EventName`, `CoordinatorName`, `CoordinatorNo`, `Fee`, `Venue`, `EventDate`) VALUES
('an', 'efef', 'ncijne', 'ejfnje', '100', 'djb', 'ndvjnd'),
('anis', 'efef', 'ncijne', 'ejfnje', '100', 'djb', 'ndvjnd'),
('anish', 'efef', 'ncijne', 'ejfnje', '100', 'djb', 'ndvjnd'),
('beast', 'efef', 'chh', 'ejfnje', 'mvugbgcg', 'vjygh', '/anish768'),
('thar', 'bo', 'maam', 'jency maam', '399', 'GJB', '14/01/2004'),
('tharshi', 'boxing', 'maam', 'jency maam', '399', 'GJB', '14/01/2004'),
('tharshini', 'boxing', 'maam', '123456789', '399', 'GJB', '14/01/2004');

-- --------------------------------------------------------

--
-- Table structure for table `plogindetails`
--

CREATE TABLE `plogindetails` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `participant_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `plogindetails`
--

INSERT INTO `plogindetails` (`username`, `password`, `participant_name`) VALUES
('1035', '123456', 'INFANT'),
('1102', '123456', 'ANISH B'),
('111', '111', 'THARSH'),
('1111', '1111', 'THARSHU'),
('111111', '111111', 'anihsubdb'),
('malavika2002', '123456', 'malavika'),
('tharshini', '123456', 'tharshini');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `card`
--
ALTER TABLE `card`
  ADD PRIMARY KEY (`card_number`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`EventNo`);

--
-- Indexes for table `plogindetails`
--
ALTER TABLE `plogindetails`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
