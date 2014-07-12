-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 27, 2014 at 10:30 AM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `nar_stainless_steel`
--

-- --------------------------------------------------------

--
-- Table structure for table `t_admin`
--

CREATE TABLE IF NOT EXISTS `t_admin` (
  `ADMIN_ID` varchar(255) NOT NULL,
  PRIMARY KEY (`ADMIN_ID`),
  KEY `FK15BDF84CA5CDA3A` (`ADMIN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `t_barang`
--

CREATE TABLE IF NOT EXISTS `t_barang` (
  `KODE_BARANG` varchar(255) NOT NULL,
  `DESKRIPSI` varchar(255) DEFAULT NULL,
  `HARGA_JUAL` int(11) DEFAULT NULL,
  `NAMA_BARANG` varchar(100) DEFAULT NULL,
  `SATUAN` varchar(255) DEFAULT NULL,
  `STOCK` int(11) DEFAULT NULL,
  PRIMARY KEY (`KODE_BARANG`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `t_customer`
--

CREATE TABLE IF NOT EXISTS `t_customer` (
  `nip` varchar(255) NOT NULL,
  `ALAMAT` varchar(255) DEFAULT NULL,
  `NAMA` varchar(255) DEFAULT NULL,
  `NO_TELP` varchar(255) DEFAULT NULL,
  `EMPLOYEE_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nip`),
  KEY `FK8045BF69E185A311` (`EMPLOYEE_ID`),
  KEY `FK8045BF6944DED6F5` (`EMPLOYEE_ID`),
  KEY `FK8045BF693A9C467B` (`EMPLOYEE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `t_detail_penjualan`
--

CREATE TABLE IF NOT EXISTS `t_detail_penjualan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `harga_satuan` int(11) DEFAULT NULL,
  `jumlah_barang` bigint(20) DEFAULT NULL,
  `NO_NOTA` int(11) DEFAULT NULL,
  `total` bigint(20) DEFAULT NULL,
  `BARANG_ID` varchar(255) DEFAULT NULL,
  `PENJUALAN_DETAILPENJUALAN` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK40F01DB93F0EDC1B` (`BARANG_ID`),
  KEY `FK40F01DB9D1B8B063` (`PENJUALAN_DETAILPENJUALAN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `t_employee`
--

CREATE TABLE IF NOT EXISTS `t_employee` (
  `nik` varchar(255) NOT NULL,
  `ALAMAT` varchar(255) DEFAULT NULL,
  `TANGGAL_LAHIR` date DEFAULT NULL,
  `JABATAN` varchar(255) DEFAULT NULL,
  `JENIS_KELAMIN` varchar(10) DEFAULT NULL,
  `NAMA` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `TEMPAT_LAHIR` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nik`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_employee`
--

INSERT INTO `t_employee` (`nik`, `ALAMAT`, `TANGGAL_LAHIR`, `JABATAN`, `JENIS_KELAMIN`, `NAMA`, `password`, `TEMPAT_LAHIR`, `USERNAME`) VALUES
('spv0001', 'Kalijudan', '2014-06-21', 'SUPERVISOR', 'PRIA', 'Steven Gunanto', 'gunanto', 'Surabaya', 'steven');

-- --------------------------------------------------------

--
-- Table structure for table `t_marketing`
--

CREATE TABLE IF NOT EXISTS `t_marketing` (
  `MARKETING_ID` varchar(255) NOT NULL,
  PRIMARY KEY (`MARKETING_ID`),
  KEY `FKF0BB7BDB244F1003` (`MARKETING_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `t_nota`
--

CREATE TABLE IF NOT EXISTS `t_nota` (
  `NO_NOTA` int(11) NOT NULL,
  `EMPLOYEE_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`NO_NOTA`),
  KEY `FK94B674F93A9C467B` (`EMPLOYEE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `t_nota`
--

INSERT INTO `t_nota` (`NO_NOTA`, `EMPLOYEE_ID`) VALUES
(1, 'spv0001'),
(3, 'spv0001');

-- --------------------------------------------------------

--
-- Table structure for table `t_operator`
--

CREATE TABLE IF NOT EXISTS `t_operator` (
  `OPERATOR_ID` varchar(255) NOT NULL,
  PRIMARY KEY (`OPERATOR_ID`),
  KEY `FK3E4E682FC3138C5` (`OPERATOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `t_penjualan`
--

CREATE TABLE IF NOT EXISTS `t_penjualan` (
  `noNota` int(11) NOT NULL,
  `BAYAR` int(11) DEFAULT NULL,
  `KEMBALI` int(11) DEFAULT NULL,
  `TANGGAL_PENJUALAN` date NOT NULL,
  `TOTAL_BAYAR` int(11) DEFAULT NULL,
  `CUSTOMER_PENJUALAN` varchar(255) DEFAULT NULL,
  `EMPLOYEE_PENJUALAN` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`noNota`),
  KEY `FK78989571EC43259A` (`EMPLOYEE_PENJUALAN`),
  KEY `FK789895719A769BFA` (`CUSTOMER_PENJUALAN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `t_supervisor`
--

CREATE TABLE IF NOT EXISTS `t_supervisor` (
  `SUPERVISOR_ID` varchar(255) NOT NULL,
  PRIMARY KEY (`SUPERVISOR_ID`),
  KEY `FK7EE8D8339775E781` (`SUPERVISOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `t_admin`
--
ALTER TABLE `t_admin`
  ADD CONSTRAINT `FK15BDF84CA5CDA3A` FOREIGN KEY (`ADMIN_ID`) REFERENCES `t_employee` (`nik`);

--
-- Constraints for table `t_customer`
--
ALTER TABLE `t_customer`
  ADD CONSTRAINT `FK8045BF693A9C467B` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `t_employee` (`nik`),
  ADD CONSTRAINT `FK8045BF6944DED6F5` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `t_supervisor` (`SUPERVISOR_ID`),
  ADD CONSTRAINT `FK8045BF69E185A311` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `t_marketing` (`MARKETING_ID`);

--
-- Constraints for table `t_detail_penjualan`
--
ALTER TABLE `t_detail_penjualan`
  ADD CONSTRAINT `FK40F01DB93F0EDC1B` FOREIGN KEY (`BARANG_ID`) REFERENCES `t_barang` (`KODE_BARANG`),
  ADD CONSTRAINT `FK40F01DB9D1B8B063` FOREIGN KEY (`PENJUALAN_DETAILPENJUALAN`) REFERENCES `t_penjualan` (`noNota`);

--
-- Constraints for table `t_marketing`
--
ALTER TABLE `t_marketing`
  ADD CONSTRAINT `FKF0BB7BDB244F1003` FOREIGN KEY (`MARKETING_ID`) REFERENCES `t_employee` (`nik`);

--
-- Constraints for table `t_nota`
--
ALTER TABLE `t_nota`
  ADD CONSTRAINT `FK94B674F93A9C467B` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `t_employee` (`nik`);

--
-- Constraints for table `t_operator`
--
ALTER TABLE `t_operator`
  ADD CONSTRAINT `FK3E4E682FC3138C5` FOREIGN KEY (`OPERATOR_ID`) REFERENCES `t_employee` (`nik`);

--
-- Constraints for table `t_penjualan`
--
ALTER TABLE `t_penjualan`
  ADD CONSTRAINT `FK789895719A769BFA` FOREIGN KEY (`CUSTOMER_PENJUALAN`) REFERENCES `t_customer` (`nip`),
  ADD CONSTRAINT `FK78989571EC43259A` FOREIGN KEY (`EMPLOYEE_PENJUALAN`) REFERENCES `t_employee` (`nik`);

--
-- Constraints for table `t_supervisor`
--
ALTER TABLE `t_supervisor`
  ADD CONSTRAINT `FK7EE8D8339775E781` FOREIGN KEY (`SUPERVISOR_ID`) REFERENCES `t_employee` (`nik`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
