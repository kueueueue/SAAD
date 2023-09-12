-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2023 at 04:07 PM
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
-- Database: `cis2103`
--

-- --------------------------------------------------------

--
-- Table structure for table `billingaddress`
--

CREATE TABLE `billingaddress` (
  `billingID` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `emailAdd` varchar(50) NOT NULL,
  `contactNo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `employee feedback`
--

CREATE TABLE `employee feedback` (
  `feedbackID` int(11) NOT NULL,
  `message` varchar(255) NOT NULL,
  `dateAdded` timestamp NULL DEFAULT NULL,
  `userID` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `invoiceID` int(11) NOT NULL,
  `paymentMethod` varchar(20) NOT NULL,
  `shippingAdd` varchar(50) NOT NULL,
  `status` varchar(10) NOT NULL,
  `billingID` int(11) NOT NULL,
  `voucherID` int(11) NOT NULL,
  `orderID` int(11) NOT NULL,
  `userID` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE `items` (
  `itemID` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `count` int(11) NOT NULL DEFAULT -1,
  `dateAdded` timestamp NULL DEFAULT NULL,
  `dateUpdated` timestamp NULL DEFAULT NULL,
  `menuID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`itemID`, `name`, `price`, `count`, `dateAdded`, `dateUpdated`, `menuID`) VALUES
('I1', 'Juice', '34.00', -1, '2023-05-06 13:30:25', '2023-05-06 13:30:25', 3);

--
-- Triggers `items`
--
DELIMITER $$
CREATE TRIGGER `menuDeleteItem` AFTER DELETE ON `items` FOR EACH ROW BEGIN 
    DELETE FROM menu WHERE menuID = OLD.menuID;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `menuID` int(11) NOT NULL,
  `menuType` char(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`menuID`, `menuType`) VALUES
(3, 'Item'),
(4, 'Package');

-- --------------------------------------------------------

--
-- Table structure for table `orderitems`
--

CREATE TABLE `orderitems` (
  `orderItemsID` int(11) NOT NULL,
  `orderID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `notes` varchar(255) NOT NULL,
  `menuID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Triggers `orderitems`
--
DELIMITER $$
CREATE TRIGGER `update_order_total` AFTER INSERT ON `orderitems` FOR EACH ROW BEGIN
  UPDATE orders
  SET total = total + (NEW.quantity * (SELECT  price FROM items WHERE itemID = NEW.itemID) )
  WHERE orderID = NEW.orderID;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `orderID` int(11) NOT NULL,
  `menuID` int(10) NOT NULL,
  `orderMethod` varchar(10) NOT NULL,
  `deliveryMethod` varchar(10) NOT NULL,
  `status` varchar(10) NOT NULL,
  `total` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `package`
--

CREATE TABLE `package` (
  `packageID` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `count` int(11) NOT NULL DEFAULT -1,
  `dateAdded` date NOT NULL DEFAULT current_timestamp(),
  `dateUpdated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `menuID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `package`
--

INSERT INTO `package` (`packageID`, `name`, `price`, `count`, `dateAdded`, `dateUpdated`, `menuID`) VALUES
('P1', 'Package P1', '0.00', -1, '2023-05-06', '2023-05-06 13:58:22', 4);

--
-- Triggers `package`
--
DELIMITER $$
CREATE TRIGGER `menuDeletePackage` AFTER DELETE ON `package` FOR EACH ROW BEGIN 
    DELETE FROM menu WHERE menuID = OLD.menuID;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `packageitem`
--

CREATE TABLE `packageitem` (
  `packageItemID` int(10) NOT NULL,
  `quantity` int(11) NOT NULL,
  `itemID` varchar(10) NOT NULL,
  `packageID` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userID` varchar(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `contactNo` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL,
  `userCreated` timestamp NOT NULL DEFAULT current_timestamp(),
  `userUpdated` timestamp NOT NULL DEFAULT current_timestamp(),
  `editorID` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userID`, `name`, `password`, `contactNo`, `role`, `userCreated`, `userUpdated`, `editorID`) VALUES
('A1', 'admin', 'admin', '09999999999', 'ADMIN', '2023-05-04 21:25:56', '2023-05-04 21:25:56', 'A1');

-- --------------------------------------------------------

--
-- Table structure for table `vouchers`
--

CREATE TABLE `vouchers` (
  `voucherID` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `code` varchar(20) NOT NULL,
  `discountOpt` varchar(255) NOT NULL,
  `discountRate` float NOT NULL,
  `useCount` int(11) NOT NULL,
  `maxUse` int(11) NOT NULL,
  `expireDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `billingaddress`
--
ALTER TABLE `billingaddress`
  ADD PRIMARY KEY (`billingID`);

--
-- Indexes for table `employee feedback`
--
ALTER TABLE `employee feedback`
  ADD PRIMARY KEY (`feedbackID`),
  ADD KEY `userID` (`userID`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`invoiceID`),
  ADD KEY `billingID` (`billingID`),
  ADD KEY `voucherID` (`voucherID`),
  ADD KEY `orderID` (`orderID`),
  ADD KEY `userID` (`userID`);

--
-- Indexes for table `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`itemID`),
  ADD KEY `menuID` (`menuID`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`menuID`),
  ADD KEY `menuID` (`menuID`);

--
-- Indexes for table `orderitems`
--
ALTER TABLE `orderitems`
  ADD PRIMARY KEY (`orderItemsID`),
  ADD KEY `idx_order_id` (`orderID`),
  ADD KEY `menuID` (`menuID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`orderID`),
  ADD KEY `idx_menuID` (`menuID`);

--
-- Indexes for table `package`
--
ALTER TABLE `package`
  ADD PRIMARY KEY (`packageID`),
  ADD KEY `menuID` (`menuID`);

--
-- Indexes for table `packageitem`
--
ALTER TABLE `packageitem`
  ADD PRIMARY KEY (`packageItemID`),
  ADD KEY `itemID` (`itemID`),
  ADD KEY `packageID` (`packageID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userID`),
  ADD KEY `editorID` (`editorID`);

--
-- Indexes for table `vouchers`
--
ALTER TABLE `vouchers`
  ADD PRIMARY KEY (`voucherID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `billingaddress`
--
ALTER TABLE `billingaddress`
  MODIFY `billingID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `employee feedback`
--
ALTER TABLE `employee feedback`
  MODIFY `feedbackID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `invoice`
--
ALTER TABLE `invoice`
  MODIFY `invoiceID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `menuID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `orderitems`
--
ALTER TABLE `orderitems`
  MODIFY `orderItemsID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `orderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `packageitem`
--
ALTER TABLE `packageitem`
  MODIFY `packageItemID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `vouchers`
--
ALTER TABLE `vouchers`
  MODIFY `voucherID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee feedback`
--
ALTER TABLE `employee feedback`
  ADD CONSTRAINT `employee feedback_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `invoice`
--
ALTER TABLE `invoice`
  ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`voucherID`) REFERENCES `vouchers` (`voucherID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `invoice_ibfk_3` FOREIGN KEY (`billingID`) REFERENCES `billingaddress` (`billingID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `invoice_ibfk_4` FOREIGN KEY (`userID`) REFERENCES `user` (`userID`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `items`
--
ALTER TABLE `items`
  ADD CONSTRAINT `items_ibfk_1` FOREIGN KEY (`menuID`) REFERENCES `menu` (`menuID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `orderitems`
--
ALTER TABLE `orderitems`
  ADD CONSTRAINT `orderitems_ibfk_1` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `orderitems_ibfk_2` FOREIGN KEY (`menuID`) REFERENCES `menu` (`menuID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`menuID`) REFERENCES `menu` (`menuID`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `package`
--
ALTER TABLE `package`
  ADD CONSTRAINT `package_ibfk_1` FOREIGN KEY (`menuID`) REFERENCES `menu` (`menuID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `packageitem`
--
ALTER TABLE `packageitem`
  ADD CONSTRAINT `packageitem_ibfk_1` FOREIGN KEY (`itemID`) REFERENCES `items` (`itemID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `packageitem_ibfk_2` FOREIGN KEY (`packageID`) REFERENCES `package` (`packageID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`editorID`) REFERENCES `user` (`userID`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
