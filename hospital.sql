-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 25, 2020 at 04:37 PM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hospital`
--

-- --------------------------------------------------------

--
-- Table structure for table `assign`
--

DROP TABLE IF EXISTS `assign`;
CREATE TABLE IF NOT EXISTS `assign` (
  `docid` varchar(60) NOT NULL,
  `patid` varchar(60) NOT NULL,
  `invoiceNo` varchar(60) NOT NULL,
  `serviceCharge` varchar(60) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`docid`,`patid`),
  KEY `patid` (`patid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `checkups`
--

DROP TABLE IF EXISTS `checkups`;
CREATE TABLE IF NOT EXISTS `checkups` (
  `name` varchar(60) NOT NULL,
  `cost` int(11) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `do`
--

DROP TABLE IF EXISTS `do`;
CREATE TABLE IF NOT EXISTS `do` (
  `checkupName` varchar(60) NOT NULL,
  `patid` varchar(60) NOT NULL,
  `invoiceNo` varchar(60) NOT NULL,
  `date` date NOT NULL,
  `description` varchar(200) NOT NULL,
  PRIMARY KEY (`checkupName`,`patid`),
  KEY `patid` (`patid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
CREATE TABLE IF NOT EXISTS `doctor` (
  `EID` varchar(60) NOT NULL,
  `name` varchar(60) NOT NULL,
  `specialization` varchar(60) NOT NULL,
  `deptName` varchar(60) NOT NULL,
  `date` date NOT NULL,
  `tel` int(11) NOT NULL,
  `startTime` time NOT NULL,
  `endTime` time NOT NULL,
  `charge` int(11) NOT NULL,
  `username` varchar(60) NOT NULL,
  `pass` varchar(60) NOT NULL,
  `ReId` varchar(60) NOT NULL,
  `isDeleted` varchar(10) NOT NULL,
  PRIMARY KEY (`EID`),
  KEY `ReId` (`ReId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`EID`, `name`, `specialization`, `deptName`, `date`, `tel`, `startTime`, `endTime`, `charge`, `username`, `pass`, `ReId`, `isDeleted`) VALUES
('doc1', 'swad', 'sadas', 'sad', '2012-11-23', 35654, '00:00:04', '00:00:04', 2545, 'dco', '1234', 'sd', 'true');

-- --------------------------------------------------------

--
-- Table structure for table `handle`
--

DROP TABLE IF EXISTS `handle`;
CREATE TABLE IF NOT EXISTS `handle` (
  `medid` varchar(60) NOT NULL,
  `Eid` varchar(60) NOT NULL,
  PRIMARY KEY (`medid`,`Eid`),
  KEY `Eid` (`Eid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `have`
--

DROP TABLE IF EXISTS `have`;
CREATE TABLE IF NOT EXISTS `have` (
  `invoiceNo` varchar(60) NOT NULL,
  `id` varchar(60) NOT NULL,
  `qty` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`invoiceNo`,`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `issued_to`
--

DROP TABLE IF EXISTS `issued_to`;
CREATE TABLE IF NOT EXISTS `issued_to` (
  `invoiceNo` varchar(60) NOT NULL,
  `medid` varchar(60) NOT NULL,
  `patid` varchar(60) NOT NULL,
  `price` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `date` date NOT NULL,
  `dosage` int(11) NOT NULL,
  `days` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  PRIMARY KEY (`medid`,`patid`),
  KEY `patid` (`patid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `laboratorian`
--

DROP TABLE IF EXISTS `laboratorian`;
CREATE TABLE IF NOT EXISTS `laboratorian` (
  `EID` varchar(60) NOT NULL,
  `name` varchar(60) NOT NULL,
  `tel` int(12) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `username` varchar(60) NOT NULL,
  `pass` varchar(60) NOT NULL,
  `isDeleted` varchar(20) NOT NULL,
  `ReId` varchar(60) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`EID`),
  KEY `ReId` (`ReId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
CREATE TABLE IF NOT EXISTS `medicine` (
  `medid` varchar(60) NOT NULL,
  `name` varchar(60) NOT NULL,
  `price` int(11) NOT NULL,
  `total_stock` int(11) NOT NULL,
  PRIMARY KEY (`medid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `med_inventory`
--

DROP TABLE IF EXISTS `med_inventory`;
CREATE TABLE IF NOT EXISTS `med_inventory` (
  `invoiceNo` varchar(60) NOT NULL,
  `date` date NOT NULL,
  `discount` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  PRIMARY KEY (`invoiceNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `patid` varchar(60) NOT NULL,
  `first_name` varchar(60) NOT NULL,
  `last_name` varchar(60) NOT NULL,
  `dob` date NOT NULL,
  `sex` varchar(10) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`patid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pharmacist`
--

DROP TABLE IF EXISTS `pharmacist`;
CREATE TABLE IF NOT EXISTS `pharmacist` (
  `EID` varchar(60) NOT NULL,
  `name` varchar(60) NOT NULL,
  `tel` int(12) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `username` varchar(60) NOT NULL,
  `pass` varchar(60) NOT NULL,
  `isDeleted` varchar(20) NOT NULL,
  `ReId` varchar(20) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`EID`),
  KEY `ReId` (`ReId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `receptionist`
--

DROP TABLE IF EXISTS `receptionist`;
CREATE TABLE IF NOT EXISTS `receptionist` (
  `EID` varchar(60) NOT NULL,
  `name` varchar(60) NOT NULL,
  `tel` int(12) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `username` varchar(60) NOT NULL,
  `pass` varchar(60) NOT NULL,
  `isDeleted` varchar(20) NOT NULL,
  `ReId` varchar(60) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`EID`),
  KEY `ReId` (`ReId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `receptionist`
--

INSERT INTO `receptionist` (`EID`, `name`, `tel`, `sex`, `username`, `pass`, `isDeleted`, `ReId`, `date`) VALUES
('sd', 'sddd', 1232, 'cs', 'scs', 'scsc', 'no', 'sd', '2019-12-02');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `assign`
--
ALTER TABLE `assign`
  ADD CONSTRAINT `assign_ibfk_1` FOREIGN KEY (`docid`) REFERENCES `doctor` (`EID`),
  ADD CONSTRAINT `assign_ibfk_2` FOREIGN KEY (`patid`) REFERENCES `patient` (`patid`);

--
-- Constraints for table `do`
--
ALTER TABLE `do`
  ADD CONSTRAINT `do_ibfk_1` FOREIGN KEY (`patid`) REFERENCES `patient` (`patid`),
  ADD CONSTRAINT `do_ibfk_2` FOREIGN KEY (`checkupName`) REFERENCES `checkups` (`name`);

--
-- Constraints for table `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `doctor_ibfk_1` FOREIGN KEY (`ReId`) REFERENCES `receptionist` (`EID`);

--
-- Constraints for table `handle`
--
ALTER TABLE `handle`
  ADD CONSTRAINT `handle_ibfk_1` FOREIGN KEY (`Eid`) REFERENCES `pharmacist` (`EID`),
  ADD CONSTRAINT `handle_ibfk_2` FOREIGN KEY (`medid`) REFERENCES `medicine` (`medid`);

--
-- Constraints for table `have`
--
ALTER TABLE `have`
  ADD CONSTRAINT `have_ibfk_1` FOREIGN KEY (`id`) REFERENCES `medicine` (`medid`),
  ADD CONSTRAINT `have_ibfk_2` FOREIGN KEY (`invoiceNo`) REFERENCES `med_inventory` (`invoiceNo`);

--
-- Constraints for table `issued_to`
--
ALTER TABLE `issued_to`
  ADD CONSTRAINT `issued_to_ibfk_1` FOREIGN KEY (`medid`) REFERENCES `medicine` (`medid`),
  ADD CONSTRAINT `issued_to_ibfk_2` FOREIGN KEY (`patid`) REFERENCES `patient` (`patid`);

--
-- Constraints for table `laboratorian`
--
ALTER TABLE `laboratorian`
  ADD CONSTRAINT `laboratorian_ibfk_1` FOREIGN KEY (`ReId`) REFERENCES `receptionist` (`EID`);

--
-- Constraints for table `pharmacist`
--
ALTER TABLE `pharmacist`
  ADD CONSTRAINT `pharmacist_ibfk_1` FOREIGN KEY (`ReId`) REFERENCES `receptionist` (`EID`);

--
-- Constraints for table `receptionist`
--
ALTER TABLE `receptionist`
  ADD CONSTRAINT `receptionist_ibfk_1` FOREIGN KEY (`ReId`) REFERENCES `receptionist` (`EID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
