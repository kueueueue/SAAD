-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2023 at 03:43 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cis2103`
--

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `itemID` int(11) NOT NULL,
  `itemName` varchar(50) NOT NULL,
  `itemPrice` int(11) NOT NULL,
  `itemCount` int(11) NOT NULL,
  `listID` int(11) NOT NULL,
  `itemAdded` timestamp NOT NULL DEFAULT current_timestamp(),
  `itemUpdated` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`itemID`, `itemName`, `itemPrice`, `itemCount`, `listID`, `itemAdded`, `itemUpdated`) VALUES
(1, 'Soup', 200, 0, 1, '2023-03-29 03:31:19', '2023-03-29 05:06:19'),
(2, 'Fried Chicken', 200, 0, 2, '2023-03-29 03:31:19', '2023-03-29 05:06:31'),
(3, 'Choco Milkshake', 200, 0, 3, '2023-03-29 03:31:19', '2023-03-29 05:10:21'),
(4, 'Coke', 50, 0, 4, '2023-03-29 03:31:19', '2023-03-29 03:31:19'),
(5, 'Sisig', 150, 0, 5, '2023-03-29 03:35:07', '2023-03-29 03:35:07'),
(6, 'Pinakbet', 80, 0, 6, '2023-03-29 03:41:44', '2023-03-29 08:05:56'),
(7, 'Coffee', 100, 0, 7, '2023-03-29 03:43:24', '2023-03-29 03:43:24'),
(8, 'French Fries', 50, 0, 8, '2023-03-29 03:49:14', '2023-03-29 03:49:14'),
(9, 'Burger', 90, 0, 9, '2023-03-29 04:10:18', '2023-03-29 08:05:23'),
(10, 'French Toast', 80, 0, 10, '2023-03-29 04:10:47', '2023-03-29 08:05:51'),
(11, 'Pancake', 150, 0, 11, '2023-03-29 04:14:14', '2023-03-29 08:09:42'),
(12, 'Spaghetti', 200, 0, 12, '2023-03-29 04:15:20', '2023-03-29 04:15:20'),
(13, 'Coffee Jelly', 102, 0, 13, '2023-03-29 10:57:56', '2023-04-01 03:59:20'),
(14, 'Test', 500, 0, 17, '2023-04-04 07:35:51', '2023-04-04 07:36:10');

-- --------------------------------------------------------

--
-- Table structure for table `list`
--

CREATE TABLE `list` (
  `listID` int(11) NOT NULL,
  `ID` int(11) NOT NULL,
  `type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `list`
--

INSERT INTO `list` (`listID`, `ID`, `type`) VALUES
(1, 1, 'single'),
(2, 2, 'single'),
(3, 3, 'single'),
(4, 4, 'single'),
(5, 5, 'single'),
(6, 6, 'single'),
(7, 7, 'single'),
(8, 8, 'single'),
(9, 9, 'single'),
(10, 10, 'single'),
(11, 11, 'single'),
(12, 12, 'single'),
(13, 13, 'single'),
(14, 1, 'package'),
(15, 2, 'package'),
(16, 3, 'package'),
(17, 14, 'single');

-- --------------------------------------------------------

--
-- Table structure for table `packages`
--

CREATE TABLE `packages` (
  `packageID` int(11) NOT NULL,
  `packageName` varchar(50) NOT NULL,
  `packagePrice` varchar(50) NOT NULL,
  `itemCount` int(11) NOT NULL,
  `packageCount` int(11) NOT NULL,
  `listID` int(11) NOT NULL,
  `packageCreated` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `packages`
--

INSERT INTO `packages` (`packageID`, `packageName`, `packagePrice`, `itemCount`, `packageCount`, `listID`, `packageCreated`) VALUES
(1, 'Package 1', '600', 3, 0, 14, '2023-03-29 13:53:56'),
(2, 'Package 2', '100', 3, 0, 15, '2023-03-29 14:46:23'),
(3, 'Package 3', '200', 2, 0, 16, '2023-04-01 10:08:32');

-- --------------------------------------------------------

--
-- Table structure for table `packitem`
--

CREATE TABLE `packitem` (
  `packItemID` int(11) NOT NULL,
  `itemID` int(11) NOT NULL,
  `packageID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `packitem`
--

INSERT INTO `packitem` (`packItemID`, `itemID`, `packageID`) VALUES
(2, 5, 1),
(3, 2, 2),
(4, 2, 1),
(5, 4, 2),
(6, 1, 2),
(10, 1, 1),
(11, 4, 3),
(12, 6, 3);

-- --------------------------------------------------------

--
-- Table structure for table `saleitem`
--

CREATE TABLE `saleitem` (
  `saleitemID` int(11) NOT NULL,
  `saleID` int(11) NOT NULL,
  `items` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `saleitem`
--

INSERT INTO `saleitem` (`saleitemID`, `saleID`, `items`) VALUES
(1, 1, 'nyok'),
(2, 2, 'Coffee - Package 2 - '),
(3, 3, 'Spaghetti - Package 1 - ');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `saleID` int(11) NOT NULL,
  `custName` varchar(50) NOT NULL,
  `custAdd` varchar(50) NOT NULL,
  `custNum` varchar(11) NOT NULL,
  `custOrder` varchar(20) NOT NULL,
  `custMode` varchar(20) NOT NULL,
  `itemCount` int(11) NOT NULL,
  `total` float NOT NULL,
  `amount` float NOT NULL,
  `cchange` float NOT NULL,
  `saleProcessed` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`saleID`, `custName`, `custAdd`, `custNum`, `custOrder`, `custMode`, `itemCount`, `total`, `amount`, `cchange`, `saleProcessed`) VALUES
(1, 'Janica Pino', 'Lapu-Lapu City', '09232576116', 'physical', 'pickup', 2, 1000, 500, 500, '2023-04-01 05:38:03'),
(2, 'Test Pino', 'Somewhere', '01234567890', 'digital', 'deliver', 2, 300, 1000, 700, '2023-04-30 13:35:09'),
(3, 'Nyok Pino', 'somewhere again', '0123456789', 'digital', 'deliver', 2, 800, 1000, 200, '2023-04-30 13:37:48');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `contact` varchar(11) NOT NULL,
  `usertype` varchar(10) NOT NULL,
  `userCreated` timestamp NOT NULL DEFAULT current_timestamp(),
  `userUpdated` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `username`, `password`, `contact`, `usertype`, `userCreated`, `userUpdated`) VALUES
(1, 'janica', 'password', '09232576116', 'admin', '2023-03-29 11:15:36', '2023-03-29 11:15:36'),
(2, 'jempai', 'password', '09232576116', 'regular', '2023-03-29 12:51:08', '2023-03-29 13:08:34');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`itemID`);

--
-- Indexes for table `list`
--
ALTER TABLE `list`
  ADD PRIMARY KEY (`listID`);

--
-- Indexes for table `packages`
--
ALTER TABLE `packages`
  ADD PRIMARY KEY (`packageID`);

--
-- Indexes for table `packitem`
--
ALTER TABLE `packitem`
  ADD PRIMARY KEY (`packItemID`),
  ADD KEY `itemID` (`itemID`),
  ADD KEY `packageID` (`packageID`);

--
-- Indexes for table `saleitem`
--
ALTER TABLE `saleitem`
  ADD PRIMARY KEY (`saleitemID`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`saleID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `items`
--
ALTER TABLE `items`
  MODIFY `itemID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `list`
--
ALTER TABLE `list`
  MODIFY `listID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `packages`
--
ALTER TABLE `packages`
  MODIFY `packageID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `packitem`
--
ALTER TABLE `packitem`
  MODIFY `packItemID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `saleitem`
--
ALTER TABLE `saleitem`
  MODIFY `saleitemID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `saleID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `packitem`
--
ALTER TABLE `packitem`
  ADD CONSTRAINT `packitem_ibfk_1` FOREIGN KEY (`itemID`) REFERENCES `items` (`itemID`),
  ADD CONSTRAINT `packitem_ibfk_2` FOREIGN KEY (`packageID`) REFERENCES `packages` (`packageID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
