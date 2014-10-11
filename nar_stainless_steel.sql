-- phpMyAdmin SQL Dump
-- version 2.9.2
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Generation Time: Oct 11, 2014 at 03:04 PM
-- Server version: 5.0.27
-- PHP Version: 5.2.1
-- 
-- Database: `nar_stainless_steel`
-- 

-- --------------------------------------------------------

-- 
-- Table structure for table `t_admin`
-- 

CREATE TABLE `t_admin` (
  `ADMIN_ID` varchar(255) NOT NULL,
  PRIMARY KEY  (`ADMIN_ID`),
  KEY `FK15BDF84CA5CDA3A` (`ADMIN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `t_admin`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `t_barang`
-- 

CREATE TABLE `t_barang` (
  `KODE_BARANG` varchar(255) NOT NULL,
  `DESKRIPSI` varchar(255) default NULL,
  `HARGA_BELI` int(11) default NULL,
  `HARGA_JUAL` int(11) default NULL,
  `NAMA_BARANG` varchar(100) default NULL,
  `SATUAN` varchar(255) default NULL,
  `STOCK` bigint(20) default NULL,
  PRIMARY KEY  (`KODE_BARANG`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `t_barang`
-- 

INSERT INTO `t_barang` (`KODE_BARANG`, `DESKRIPSI`, `HARGA_BELI`, `HARGA_JUAL`, `NAMA_BARANG`, `SATUAN`, `STOCK`) VALUES 
('brng0001', 'Besi ukuran xl', 900000, 1000000, 'Besi', 'pcs', 0);

-- --------------------------------------------------------

-- 
-- Table structure for table `t_customer`
-- 

CREATE TABLE `t_customer` (
  `nip` varchar(255) NOT NULL,
  `ALAMAT` varchar(255) default NULL,
  `NAMA` varchar(255) default NULL,
  `NO_TELP` varchar(255) default NULL,
  `EMPLOYEE_ID` varchar(255) default NULL,
  PRIMARY KEY  (`nip`),
  KEY `FK8045BF693A9C467B` (`EMPLOYEE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `t_customer`
-- 

INSERT INTO `t_customer` (`nip`, `ALAMAT`, `NAMA`, `NO_TELP`, `EMPLOYEE_ID`) VALUES 
('cst0001', 'Tambak Bayan', 'Johan Prasetio', '12345678910', NULL);

-- --------------------------------------------------------

-- 
-- Table structure for table `t_detail_pembelian`
-- 

CREATE TABLE `t_detail_pembelian` (
  `id` int(11) NOT NULL auto_increment,
  `harga_satuan` int(11) default NULL,
  `jumlah_barang` bigint(20) default NULL,
  `total` bigint(20) default NULL,
  `BARANG_ID` varchar(255) default NULL,
  `PEMBELIAN_DETAILPEMBELIAN` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKFD869A423F0EDC1B` (`BARANG_ID`),
  KEY `FKFD869A428DEBF3FE` (`PEMBELIAN_DETAILPEMBELIAN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- 
-- Dumping data for table `t_detail_pembelian`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `t_detail_penjualan`
-- 

CREATE TABLE `t_detail_penjualan` (
  `id` int(11) NOT NULL auto_increment,
  `harga_satuan` int(11) default NULL,
  `jumlah_barang` bigint(20) default NULL,
  `total` bigint(20) default NULL,
  `BARANG_ID` varchar(255) default NULL,
  `PENJUALAN_DETAILPENJUALAN` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK40F01DB93F0EDC1B` (`BARANG_ID`),
  KEY `FK40F01DB9D1B8B063` (`PENJUALAN_DETAILPENJUALAN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- 
-- Dumping data for table `t_detail_penjualan`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `t_employee`
-- 

CREATE TABLE `t_employee` (
  `nik` varchar(255) NOT NULL,
  `ALAMAT` varchar(255) default NULL,
  `TANGGAL_LAHIR` date default NULL,
  `JABATAN` varchar(255) default NULL,
  `JENIS_KELAMIN` varchar(10) default NULL,
  `NAMA` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `TEMPAT_LAHIR` varchar(255) default NULL,
  `USERNAME` varchar(255) default NULL,
  PRIMARY KEY  (`nik`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `t_employee`
-- 

INSERT INTO `t_employee` (`nik`, `ALAMAT`, `TANGGAL_LAHIR`, `JABATAN`, `JENIS_KELAMIN`, `NAMA`, `password`, `TEMPAT_LAHIR`, `USERNAME`) VALUES 
('spv0001', 'Kalijudan', '2014-10-11', 'SUPERVISOR', 'PRIA', 'Steven Gunanto', 'gunanto', 'Surabaya', 'steven');

-- --------------------------------------------------------

-- 
-- Table structure for table `t_jurnalumum`
-- 

CREATE TABLE `t_jurnalumum` (
  `id` int(11) NOT NULL auto_increment,
  `DK` varchar(255) default NULL,
  `FAKTUR` varchar(255) default NULL,
  `SALDO` bigint(20) default NULL,
  `TANGGAL` date NOT NULL,
  `EMPLOYEE_PENJUALAN` varchar(255) default NULL,
  `JURNALUMUM_MASTERAKUN` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK76A45E2DEC43259A` (`EMPLOYEE_PENJUALAN`),
  KEY `FK76A45E2D215001A8` (`JURNALUMUM_MASTERAKUN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- 
-- Dumping data for table `t_jurnalumum`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `t_marketing`
-- 

CREATE TABLE `t_marketing` (
  `MARKETING_ID` varchar(255) NOT NULL,
  PRIMARY KEY  (`MARKETING_ID`),
  KEY `FKF0BB7BDB244F1003` (`MARKETING_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `t_marketing`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `t_masterakun`
-- 

CREATE TABLE `t_masterakun` (
  `KODE_AKUN` varchar(255) NOT NULL,
  `NAMA_AKUN` varchar(255) default NULL,
  PRIMARY KEY  (`KODE_AKUN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `t_masterakun`
-- 

INSERT INTO `t_masterakun` (`KODE_AKUN`, `NAMA_AKUN`) VALUES 
('101', 'Kas'),
('103', 'Piutang Dagang'),
('201', 'Hutang Dagang'),
('400', 'Penjualan'),
('500', 'Pembelian'),
('602', 'Beban Sewa Gedung');

-- --------------------------------------------------------

-- 
-- Table structure for table `t_nota`
-- 

CREATE TABLE `t_nota` (
  `NO_NOTA` int(11) NOT NULL,
  `EMPLOYEE_ID` varchar(255) default NULL,
  PRIMARY KEY  (`NO_NOTA`),
  KEY `FK94B674F93A9C467B` (`EMPLOYEE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `t_nota`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `t_operator`
-- 

CREATE TABLE `t_operator` (
  `OPERATOR_ID` varchar(255) NOT NULL,
  PRIMARY KEY  (`OPERATOR_ID`),
  KEY `FK3E4E682FC3138C5` (`OPERATOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `t_operator`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `t_pembelian`
-- 

CREATE TABLE `t_pembelian` (
  `noFaktur` varchar(255) NOT NULL,
  `TANGGAL_PEMBELIAN` date NOT NULL,
  `TOTAL_BAYAR` int(11) default NULL,
  `EMPLOYEE_PEMBELIAN` varchar(255) default NULL,
  `SUPPLIER_PEMBELIAN` varchar(255) default NULL,
  PRIMARY KEY  (`noFaktur`),
  KEY `FK352F11FAA8D9A223` (`EMPLOYEE_PEMBELIAN`),
  KEY `FK352F11FAAD1CFADF` (`SUPPLIER_PEMBELIAN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `t_pembelian`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `t_penjualan`
-- 

CREATE TABLE `t_penjualan` (
  `noFaktur` varchar(255) NOT NULL,
  `TANGGAL_PENJUALAN` date NOT NULL,
  `TOTAL_BAYAR` int(11) default NULL,
  `CUSTOMER_PENJUALAN` varchar(255) default NULL,
  `EMPLOYEE_PENJUALAN` varchar(255) default NULL,
  PRIMARY KEY  (`noFaktur`),
  KEY `FK78989571EC43259A` (`EMPLOYEE_PENJUALAN`),
  KEY `FK789895719A769BFA` (`CUSTOMER_PENJUALAN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `t_penjualan`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `t_supervisor`
-- 

CREATE TABLE `t_supervisor` (
  `SUPERVISOR_ID` varchar(255) NOT NULL,
  PRIMARY KEY  (`SUPERVISOR_ID`),
  KEY `FK7EE8D8339775E781` (`SUPERVISOR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `t_supervisor`
-- 


-- --------------------------------------------------------

-- 
-- Table structure for table `t_supplier`
-- 

CREATE TABLE `t_supplier` (
  `KODE_SUPPLIER` varchar(255) NOT NULL,
  `ALAMAT` varchar(255) default NULL,
  `NAMA_SUPPLIER` varchar(255) default NULL,
  `NO_TELEPON` varchar(255) default NULL,
  PRIMARY KEY  (`KODE_SUPPLIER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Dumping data for table `t_supplier`
-- 

INSERT INTO `t_supplier` (`KODE_SUPPLIER`, `ALAMAT`, `NAMA_SUPPLIER`, `NO_TELEPON`) VALUES 
('s001', 'embong malang', 'Jonathan', '031-3333333');

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
  ADD CONSTRAINT `FK8045BF693A9C467B` FOREIGN KEY (`EMPLOYEE_ID`) REFERENCES `t_employee` (`nik`);

-- 
-- Constraints for table `t_detail_pembelian`
-- 
ALTER TABLE `t_detail_pembelian`
  ADD CONSTRAINT `FKFD869A428DEBF3FE` FOREIGN KEY (`PEMBELIAN_DETAILPEMBELIAN`) REFERENCES `t_pembelian` (`noFaktur`),
  ADD CONSTRAINT `FKFD869A423F0EDC1B` FOREIGN KEY (`BARANG_ID`) REFERENCES `t_barang` (`KODE_BARANG`);

-- 
-- Constraints for table `t_detail_penjualan`
-- 
ALTER TABLE `t_detail_penjualan`
  ADD CONSTRAINT `FK40F01DB9D1B8B063` FOREIGN KEY (`PENJUALAN_DETAILPENJUALAN`) REFERENCES `t_penjualan` (`noFaktur`),
  ADD CONSTRAINT `FK40F01DB93F0EDC1B` FOREIGN KEY (`BARANG_ID`) REFERENCES `t_barang` (`KODE_BARANG`);

-- 
-- Constraints for table `t_jurnalumum`
-- 
ALTER TABLE `t_jurnalumum`
  ADD CONSTRAINT `FK76A45E2D215001A8` FOREIGN KEY (`JURNALUMUM_MASTERAKUN`) REFERENCES `t_masterakun` (`KODE_AKUN`),
  ADD CONSTRAINT `FK76A45E2DEC43259A` FOREIGN KEY (`EMPLOYEE_PENJUALAN`) REFERENCES `t_employee` (`nik`);

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
-- Constraints for table `t_pembelian`
-- 
ALTER TABLE `t_pembelian`
  ADD CONSTRAINT `FK352F11FAAD1CFADF` FOREIGN KEY (`SUPPLIER_PEMBELIAN`) REFERENCES `t_supplier` (`KODE_SUPPLIER`),
  ADD CONSTRAINT `FK352F11FAA8D9A223` FOREIGN KEY (`EMPLOYEE_PEMBELIAN`) REFERENCES `t_employee` (`nik`);

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
