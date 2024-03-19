-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.28-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table quanlyhocsinhtrunghoc.bang_diem
CREATE TABLE IF NOT EXISTS `bang_diem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_hoc_sinh` int(11) DEFAULT NULL,
  `id_mon_hoc` int(11) DEFAULT NULL,
  `hoc_ky` int(11) DEFAULT NULL,
  `diem_so` float DEFAULT NULL,
  `id_hoc_ba` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bangdiem_monhoc_id` (`id_mon_hoc`),
  KEY `fk_bangdiem_hocsinh_id` (`id_hoc_sinh`),
  KEY `fk_bangdiem_sohocba_id` (`id_hoc_ba`),
  CONSTRAINT `fk_bangdiem_hocsinh_id` FOREIGN KEY (`id_hoc_sinh`) REFERENCES `hoc_sinh` (`id`),
  CONSTRAINT `fk_bangdiem_monhoc_id` FOREIGN KEY (`id_mon_hoc`) REFERENCES `mon_hoc` (`id`),
  CONSTRAINT `fk_bangdiem_sohocba_id` FOREIGN KEY (`id_hoc_ba`) REFERENCES `so_hoc_ba` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.bang_diem: ~0 rows (approximately)

-- Dumping structure for table quanlyhocsinhtrunghoc.giao_vien
CREATE TABLE IF NOT EXISTS `giao_vien` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten_giao_vien` varchar(50) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `gioi_tinh` varchar(10) DEFAULT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `id_mon_hoc` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_giaovien_monhoc_id` (`id_mon_hoc`),
  CONSTRAINT `fk_giaovien_monhoc_id` FOREIGN KEY (`id_mon_hoc`) REFERENCES `mon_hoc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.giao_vien: ~0 rows (approximately)

-- Dumping structure for table quanlyhocsinhtrunghoc.hoc
CREATE TABLE IF NOT EXISTS `hoc` (
  `id_mon_hoc` int(11) NOT NULL,
  `id_hoc_sinh` int(11) NOT NULL,
  PRIMARY KEY (`id_mon_hoc`,`id_hoc_sinh`),
  KEY `fk_hoc_hocsinh_id` (`id_hoc_sinh`),
  CONSTRAINT `fk_hoc_hocsinh_id` FOREIGN KEY (`id_hoc_sinh`) REFERENCES `hoc_sinh` (`id`),
  CONSTRAINT `fk_hoc_monhoc_id` FOREIGN KEY (`id_mon_hoc`) REFERENCES `mon_hoc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.hoc: ~0 rows (approximately)

-- Dumping structure for table quanlyhocsinhtrunghoc.hoc_sinh
CREATE TABLE IF NOT EXISTS `hoc_sinh` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten_hoc_sinh` varchar(50) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `gioi_tinh` varchar(10) DEFAULT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `id_lop` int(11) DEFAULT NULL,
  `nien_khoa` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_hocsinh_lop_id` (`id_lop`),
  CONSTRAINT `fk_hocsinh_lop_id` FOREIGN KEY (`id_lop`) REFERENCES `lop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.hoc_sinh: ~0 rows (approximately)

-- Dumping structure for table quanlyhocsinhtrunghoc.lop
CREATE TABLE IF NOT EXISTS `lop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten_lop` varchar(50) DEFAULT NULL,
  `khoi_hoc` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.lop: ~0 rows (approximately)

-- Dumping structure for table quanlyhocsinhtrunghoc.mon_hoc
CREATE TABLE IF NOT EXISTS `mon_hoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten_mon_hoc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.mon_hoc: ~2 rows (approximately)
INSERT INTO `mon_hoc` (`id`, `ten_mon_hoc`) VALUES
	(1, 'Toán'),
	(2, 'Văn');

-- Dumping structure for table quanlyhocsinhtrunghoc.phieu_diem
CREATE TABLE IF NOT EXISTS `phieu_diem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_hoc_sinh` int(11) DEFAULT NULL,
  `id_mon_hoc` int(11) DEFAULT NULL,
  `ngay_kiem_tra` date DEFAULT NULL,
  `diem_so` float DEFAULT NULL,
  `hoc_ky` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_phieudiem_hocsinh_id` (`id_hoc_sinh`),
  KEY `fk_phieudiem_monhoc_id` (`id_mon_hoc`),
  CONSTRAINT `fk_phieudiem_hocsinh_id` FOREIGN KEY (`id_hoc_sinh`) REFERENCES `hoc_sinh` (`id`),
  CONSTRAINT `fk_phieudiem_monhoc_id` FOREIGN KEY (`id_mon_hoc`) REFERENCES `mon_hoc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.phieu_diem: ~0 rows (approximately)

-- Dumping structure for table quanlyhocsinhtrunghoc.phu_huynh
CREATE TABLE IF NOT EXISTS `phu_huynh` (
  `id_hoc_sinh` int(11) NOT NULL,
  `ten_phu_huynh` varchar(50) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `que_quan` varchar(200) DEFAULT NULL,
  `gioi_tinh` varchar(10) DEFAULT NULL,
  `sdt` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_hoc_sinh`),
  CONSTRAINT `phu_huynh_ibfk_1` FOREIGN KEY (`id_hoc_sinh`) REFERENCES `hoc_sinh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.phu_huynh: ~0 rows (approximately)

-- Dumping structure for table quanlyhocsinhtrunghoc.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `id` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `id` (`id`,`role`),
  CONSTRAINT `fk_id` FOREIGN KEY (`id`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.roles: ~20 rows (approximately)
INSERT INTO `roles` (`id`, `role`) VALUES
	('admin', 'ROLE_ADMIN'),
	('giaovien1', 'ROLE_TEACHER'),
	('giaovien2', 'ROLE_TEACHER'),
	('giaovien3', 'ROLE_TEACHER'),
	('giaovien4', 'ROLE_TEACHER'),
	('giaovien5', 'ROLE_TEACHER'),
	('giaovien6', 'ROLE_TEACHER'),
	('giaovien7', 'ROLE_TEACHER'),
	('giaovien8', 'ROLE_TEACHER'),
	('giaovien9', 'ROLE_TEACHER'),
	('phuhuynh1', 'ROLE_USER'),
	('phuhuynh10', 'ROLE_USER'),
	('phuhuynh2', 'ROLE_USER'),
	('phuhuynh3', 'ROLE_USER'),
	('phuhuynh4', 'ROLE_USER'),
	('phuhuynh5', 'ROLE_USER'),
	('phuhuynh6', 'ROLE_USER'),
	('phuhuynh7', 'ROLE_USER'),
	('phuhuynh8', 'ROLE_USER'),
	('phuhuynh9', 'ROLE_USER');

-- Dumping structure for table quanlyhocsinhtrunghoc.so_dau_bai
CREATE TABLE IF NOT EXISTS `so_dau_bai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_lop_hoc` int(11) DEFAULT NULL,
  `id_giao_vien` int(11) DEFAULT NULL,
  `ngay_giang_day` date DEFAULT NULL,
  `noi_dung_giang_day` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sodaubai_lop_id` (`id_lop_hoc`),
  KEY `fk_sodaubai_giaovien_id` (`id_giao_vien`),
  CONSTRAINT `fk_sodaubai_giaovien_id` FOREIGN KEY (`id_giao_vien`) REFERENCES `giao_vien` (`id`),
  CONSTRAINT `fk_sodaubai_lop_id` FOREIGN KEY (`id_lop_hoc`) REFERENCES `lop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.so_dau_bai: ~0 rows (approximately)

-- Dumping structure for table quanlyhocsinhtrunghoc.so_hoc_ba
CREATE TABLE IF NOT EXISTS `so_hoc_ba` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_hoc_sinh` int(11) DEFAULT NULL,
  `hanh_kiem` varchar(10) DEFAULT NULL,
  `nhan_xet_cua_giao_vien` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sohocba_hocsinh_id` (`id_hoc_sinh`),
  CONSTRAINT `fk_sohocba_hocsinh_id` FOREIGN KEY (`id_hoc_sinh`) REFERENCES `hoc_sinh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.so_hoc_ba: ~0 rows (approximately)

-- Dumping structure for table quanlyhocsinhtrunghoc.tham_gia
CREATE TABLE IF NOT EXISTS `tham_gia` (
  `id_giao_vien` int(11) NOT NULL,
  `id_lop_hoc` int(11) NOT NULL,
  PRIMARY KEY (`id_giao_vien`,`id_lop_hoc`),
  KEY `fk_thamgia_lop_id` (`id_lop_hoc`),
  CONSTRAINT `fk_thamgia_giaovien_id` FOREIGN KEY (`id_giao_vien`) REFERENCES `giao_vien` (`id`),
  CONSTRAINT `fk_thamgia_lop_id` FOREIGN KEY (`id_lop_hoc`) REFERENCES `lop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.tham_gia: ~0 rows (approximately)

-- Dumping structure for table quanlyhocsinhtrunghoc.the_hoc_sinh
CREATE TABLE IF NOT EXISTS `the_hoc_sinh` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_hoc_sinh` int(11) DEFAULT NULL,
  `anh_dai_dien` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_thehocsinh_hocsinh_id` (`id_hoc_sinh`),
  CONSTRAINT `fk_thehocsinh_hocsinh_id` FOREIGN KEY (`id_hoc_sinh`) REFERENCES `hoc_sinh` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.the_hoc_sinh: ~0 rows (approximately)

-- Dumping structure for table quanlyhocsinhtrunghoc.users
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT 0,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.users: ~20 rows (approximately)
INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
	('admin', '{bcrypt}$2a$12$RkTUj4wHz8jPkcNSOlX5dOUhkcPxZQE0QKIVfjAi.PRWcGCrjvfPi', 1),
	('giaovien1', '{bcrypt}$2a$12$rLoRYz3MBrrVhoV8JxcVfuTghv.7LrihzwlCU.HVwNmKRUxNjaSRm', 1),
	('giaovien2', '{bcrypt}$2a$12$8/0ZoyOpieaN1kS3OKYIK.7qhwK7ievsxg1oFW3eubqzhDoId2Qfu', 1),
	('giaovien3', '{bcrypt}$2a$12$z9/QfXhjHs6P/79yk3OyJeFbsVu7jabns86G2sFT.07H6.aMVfIl.', 1),
	('giaovien4', '{bcrypt}$2a$12$cYyT4VO.6pxNkX671DFM6OUAswSunOGalmMMTBRyZVb/weieNR6oi', 1),
	('giaovien5', '{bcrypt}$2a$12$TUq0yVbliKeP/z7zhIj9pOS8/GGDRtJKF3Ifctit9PabThNIc/p6O', 1),
	('giaovien6', '{bcrypt}$2a$12$Byl3D4M3BJqkDTTPi3taI.rtjtP2p7TVxZobIarAzELkULLoMe.h6', 1),
	('giaovien7', '{bcrypt}$2a$12$7E1xP6850EeANT6XVxFwoeCnPMl.0DAS0VrM28V/q4o31pS14qtwC', 1),
	('giaovien8', '{bcrypt}$2a$12$7OekbvXJMw.rYj4c81bDD.IIc9/wE51w5vsg8cS2.hlVWtSSYeXHa', 1),
	('giaovien9', '{bcrypt}$2a$12$YniKEBjeAsEqb0VMTcOCr.NEj09VL2.XpVnjqkmx.BNnVVDTTr8qO', 1),
	('phuhuynh1', '{bcrypt}$2a$12$LKBCyCjtMfWJxrdrmwzqQOk2aThPadbj.8YMkTuRa.JKohWD2twVG', 1),
	('phuhuynh10', '{bcrypt}$2a$12$kBRQQQRhrsGV7Ing6Vk9gePPrcxyrx0foBMMBRCrUOpd6KerfJh0K', 1),
	('phuhuynh2', '{bcrypt}$2a$12$AJMSUXelBCZJfYM002X6W.NBXtlYsQdM1rqH1ZSAprl/AgCsrnBiK', 1),
	('phuhuynh3', '{bcrypt}$2a$12$vA7Z35u5ASXDsGotoe6IzeK6fpGio8BZKWZL/vXNxcec7Dc8vr8EG', 1),
	('phuhuynh4', '{bcrypt}$2a$12$4WGd.tF5vc4Nl2ukCm2XW.B/pgp5yMr/EOWjG3mGMmMTHL.sDwhHa', 1),
	('phuhuynh5', '{bcrypt}$2a$12$HGG7NOcGn/ZfoKodHe44I.xRd9HEXL1V6JtQmiRlUhn00IsAn5RS2', 1),
	('phuhuynh6', '{bcrypt}$2a$12$59Sb7WDsxzY.s5MsEzsKgels4XcMsSl1QHJmZ.zzHooJGB0fM/TsK', 1),
	('phuhuynh7', '{bcrypt}$2a$12$wzmV4tMlVWMFsqYMDPKICOOi73FWWHrKXVMgR03MbFxpdaz/uzzXy', 1),
	('phuhuynh8', '{bcrypt}$2a$12$NYTCgT5/Pn7lyI7Bg9IXMeijjte.rw5xEeodOf/G4/J6GyfckGZUW', 1),
	('phuhuynh9', '{bcrypt}$2a$12$dUMxJRVDGyeGwPx5HxFktefIm26xgJfl9Kbwi6Z.xDENg/veyeRRG', 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
