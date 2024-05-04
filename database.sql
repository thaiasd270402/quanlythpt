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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.giao_vien: ~18 rows (approximately)
INSERT INTO `giao_vien` (`id`, `ten_giao_vien`, `ngay_sinh`, `gioi_tinh`, `dia_chi`, `id_mon_hoc`) VALUES
	(1, 'Huỳnh Văn Nam', '2004-03-27', 'nam', 'Long An', 25),
	(4, 'Phạm Thị Thủy', '2000-03-27', 'nữ', 'Hà Giang', 26),
	(6, 'Phạm Minh Anh', '2000-08-15', 'nữ', 'Hà Nội', 32),
	(7, 'Phạm Ngọc Hoàng', '1999-02-03', 'nam', 'Hà Nội', 27),
	(8, 'Phan Kim Liên', '1998-08-12', 'nữ', 'Hà Nội', 25),
	(9, 'Hồ Ngọc Hà', '1996-08-09', 'nữ', 'Hà Nam', 27),
	(10, 'Phan Anh Duy', '1999-11-08', 'nam', 'Lào Cai', 1),
	(11, 'Lê Ngọc Long', '1995-02-01', 'nam', 'Yên Bái', 21),
	(12, 'Nguyễn Thị Sao Mai', '1999-07-19', 'nữ', 'Vĩnh Phúc', 2),
	(13, 'Phan Thị Linh', '2000-09-09', 'nữ', 'Cà mau', 19),
	(14, 'Nguyễn Văn Lương', '1995-03-07', 'nam', 'Kiên Giang', 21),
	(15, 'Phạm Thu Huyền', '1998-09-23', 'nữ', 'Nam Định', 24),
	(16, 'Nguyễn Phương Nga', '2001-02-21', 'nữ', 'Quảng Ninh', 25),
	(17, 'Trần Văn Đoàn', '1997-09-18', 'nam', 'Bắc Ninh', 26),
	(18, 'Nguyễn Thị Hương', '1994-01-09', 'nữ', 'Hà Nội', 27),
	(19, 'Nguyễn Thị Hải', '2000-02-06', 'nữ', 'Sơn La', 28),
	(20, 'Trần Văn Lực', '1995-09-06', 'nam', 'Hà Nội', 29),
	(21, 'Nguyễn Thị Lý', '1994-02-27', 'nữ', 'Bắc Ninh', 30),
	(22, 'Phùng Thanh Độ', '1997-12-09', 'nam', 'Hà Giang', 31),
	(23, 'Nguyễn Văn Sơn', '1993-01-31', 'nam', 'Hà Nội', 32),
	(24, 'Phạm Đông Long', '1999-02-03', 'nam', 'Hà Nam', 24);

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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.hoc_sinh: ~13 rows (approximately)
INSERT INTO `hoc_sinh` (`id`, `ten_hoc_sinh`, `ngay_sinh`, `gioi_tinh`, `dia_chi`, `id_lop`, `nien_khoa`) VALUES
	(4, 'Nguyễn Thị Nhi', '2008-02-04', 'nữ', 'Hà Nội', 5, '2023-2026'),
	(5, 'Phạm Thị Huyền', '2008-03-02', 'nữ', 'Hà Nội', 6, '2023-2026'),
	(6, 'Nguyễn Văn Mạnh', '2007-04-07', 'nam', 'Hà Nội', 7, '2022-2025'),
	(7, 'Nguyễn Thị Ly', '2007-04-07', 'nữ', 'Hà Nội', 9, '2022-2025'),
	(10, 'Phan Kim Liên', '2006-09-07', 'nữ', 'Bắc Ninh', 13, '2021-2024'),
	(11, 'Nguyễn Thị Nữ', '2008-03-05', 'nữ', 'Hà Nam', 5, '2023-2026'),
	(12, 'Nguyễn Văn Mạnh', '2006-08-17', 'nam', 'Hà Nội', 13, '2021-2024'),
	(20, 'Tạ Quang Chiến', '2006-04-05', 'nam', 'Hưng Yên', 11, '2021-2024'),
	(21, 'Phan Thị Linh', '2006-07-07', 'nữ', 'Hà Nội', 12, '2021-2024'),
	(22, 'Hoàng Hữu Ánh', '2006-09-08', 'nam', 'Hà Nam', 12, '2021-2023'),
	(23, 'Phan Văn Huy', '2008-09-08', 'nam', 'Hà Giang', 14, '2023-2025'),
	(24, 'Phạm Ánh Ngọc', '2006-04-05', 'nữ', 'Hà Nội', 11, '2021-2024'),
	(25, 'Phan Kim Liên', '2006-03-05', 'nữ', 'Hà Nam', 12, '2021-2024');

-- Dumping structure for table quanlyhocsinhtrunghoc.lop
CREATE TABLE IF NOT EXISTS `lop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten_lop` varchar(50) DEFAULT NULL,
  `khoi_hoc` varchar(50) DEFAULT NULL,
  `id_giao_vien` int(11) DEFAULT NULL,
  `si_so` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_lop_giaovien_id` (`id_giao_vien`),
  CONSTRAINT `fk_lop_giaovien_id` FOREIGN KEY (`id_giao_vien`) REFERENCES `giao_vien` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.lop: ~10 rows (approximately)
INSERT INTO `lop` (`id`, `ten_lop`, `khoi_hoc`, `id_giao_vien`, `si_so`) VALUES
	(5, '10A1', 'A', 8, 2),
	(6, '10A2', 'A', 4, 1),
	(7, '11A11', 'D', 7, 1),
	(9, '11A12', 'D', 11, 1),
	(11, '12A3', 'A', 9, 2),
	(12, '12A4', 'A', 1, 3),
	(13, '12A5', 'A', 10, 2),
	(14, '10A3', 'A', 14, 1),
	(18, '10A4', 'A', 12, 0),
	(21, '12D4', 'D', 13, 0);

-- Dumping structure for table quanlyhocsinhtrunghoc.mon_hoc
CREATE TABLE IF NOT EXISTS `mon_hoc` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten_mon_hoc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.mon_hoc: ~14 rows (approximately)
INSERT INTO `mon_hoc` (`id`, `ten_mon_hoc`) VALUES
	(1, 'Toán'),
	(2, 'Văn'),
	(19, 'Tiếng Anh'),
	(21, 'Vật Lý'),
	(24, 'Hóa Học'),
	(25, 'Sinh Học'),
	(26, 'Lịch Sử'),
	(27, 'Địa Lý'),
	(28, 'Giáo Dục Công Dân'),
	(29, 'Thể Dục'),
	(30, 'Công Nghệ'),
	(31, 'Giáo dục quốc phòng'),
	(32, 'Tin Học'),
	(41, 'hóa');

-- Dumping structure for table quanlyhocsinhtrunghoc.phieu_diem
CREATE TABLE IF NOT EXISTS `phieu_diem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_hoc_sinh` int(11) DEFAULT NULL,
  `id_mon_hoc` int(11) DEFAULT NULL,
  `ngay_kiem_tra` date DEFAULT NULL,
  `diem_so` float DEFAULT NULL,
  `hoc_ky` int(11) DEFAULT NULL,
  `id_lop_hoc` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_phieudiem_hocsinh_id` (`id_hoc_sinh`),
  KEY `fk_phieudiem_monhoc_id` (`id_mon_hoc`),
  KEY `fk_phieudiem_lophoc_id` (`id_lop_hoc`),
  CONSTRAINT `fk_phieudiem_hocsinh_id` FOREIGN KEY (`id_hoc_sinh`) REFERENCES `hoc_sinh` (`id`),
  CONSTRAINT `fk_phieudiem_lophoc_id` FOREIGN KEY (`id_lop_hoc`) REFERENCES `lop` (`id`),
  CONSTRAINT `fk_phieudiem_monhoc_id` FOREIGN KEY (`id_mon_hoc`) REFERENCES `mon_hoc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1280 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.phieu_diem: ~167 rows (approximately)
INSERT INTO `phieu_diem` (`id`, `id_hoc_sinh`, `id_mon_hoc`, `ngay_kiem_tra`, `diem_so`, `hoc_ky`, `id_lop_hoc`) VALUES
	(976, 5, 1, '2024-04-10', 7, 1, 6),
	(977, 5, 2, '2024-04-08', 9, 2, 6),
	(978, 5, 19, '2024-04-16', 8, 2, 6),
	(979, 5, 21, '2024-04-08', 6, 1, 6),
	(980, 5, 24, '2024-04-08', 6, 2, 6),
	(981, 5, 25, '2024-04-08', 7, 1, 6),
	(982, 5, 26, '2024-04-08', 6, 2, 6),
	(983, 5, 27, '2024-04-08', 7, 1, 6),
	(984, 5, 28, '2024-04-08', 8, 2, 6),
	(985, 5, 29, '2024-04-08', 6, 2, 6),
	(986, 5, 30, '2024-04-08', 5, 2, 6),
	(987, 5, 31, '2024-04-08', 6, 1, 6),
	(988, 5, 32, '2024-04-08', 8, 2, 6),
	(989, 6, 1, '2024-04-09', 7, 2, 7),
	(990, 6, 2, '2024-04-08', 9, 2, 7),
	(991, 6, 19, '2024-04-08', 7, 1, 7),
	(992, 6, 21, '2024-04-08', 8, 2, 7),
	(993, 6, 24, '2024-04-08', 7, 1, 7),
	(994, 6, 25, '2024-04-08', 8, 2, 7),
	(995, 6, 26, '2024-04-08', 7, 1, 7),
	(996, 6, 27, '2024-04-08', 5, 2, 7),
	(997, 6, 28, '2024-04-08', 6, 1, 7),
	(998, 6, 29, '2024-04-08', 8, 1, 7),
	(999, 6, 30, '2024-04-08', 8, 1, 7),
	(1000, 6, 31, '2024-04-08', 7, 2, 7),
	(1001, 6, 32, '2024-04-08', 8, 2, 7),
	(1002, 7, 1, '2024-04-08', 9, 1, 9),
	(1003, 7, 2, '2024-04-08', 6, 1, 9),
	(1004, 7, 19, '2024-04-08', 7, 2, 9),
	(1005, 7, 21, '2024-04-08', 8, 1, 9),
	(1006, 7, 24, '2024-04-08', 9, 2, 9),
	(1007, 7, 25, '2024-04-08', 9, 2, 9),
	(1008, 7, 26, '2024-04-08', 8, 1, 9),
	(1009, 7, 27, '2024-04-08', 7, 2, 9),
	(1010, 7, 28, '2024-04-08', 7, 1, 9),
	(1011, 7, 29, '2024-04-08', 8, 1, 9),
	(1012, 7, 30, '2024-04-08', 8, 2, 9),
	(1013, 7, 31, '2024-04-08', 7, 1, 9),
	(1014, 7, 32, '2024-04-08', 6, 2, 9),
	(1041, 10, 1, '2024-04-17', 8, 2, 13),
	(1042, 10, 2, '2024-04-08', 6, 1, 13),
	(1043, 10, 19, '2024-04-08', 5, 2, 13),
	(1044, 10, 21, '2024-04-08', 7, 2, 13),
	(1045, 10, 24, '2024-04-08', 8, 1, 13),
	(1046, 10, 25, '2024-04-08', 8, 2, 13),
	(1047, 10, 26, '2024-04-08', 9, 1, 13),
	(1048, 10, 27, '2024-04-08', 6, 2, 13),
	(1049, 10, 28, '2024-04-08', 6, 1, 13),
	(1050, 10, 29, '2024-04-08', 8, 2, 13),
	(1051, 10, 30, '2024-04-08', 9, 2, 13),
	(1052, 10, 31, '2024-04-08', 8, 1, 13),
	(1053, 10, 32, '2024-04-08', 8, 1, 13),
	(1054, 11, 1, '2024-04-08', 9, 1, 5),
	(1055, 11, 2, '2024-04-08', 9, 1, 5),
	(1056, 11, 19, '2024-04-08', 8, 2, 5),
	(1057, 11, 21, '2024-04-08', 8, 2, 5),
	(1058, 11, 24, '2024-04-08', 9, 2, 5),
	(1059, 11, 25, '2024-04-08', 9, 1, 5),
	(1060, 11, 26, '2024-04-08', 8, 2, 5),
	(1061, 11, 27, '2024-04-08', 9, 1, 5),
	(1062, 11, 28, '2024-04-08', 8, 2, 5),
	(1063, 11, 29, '2024-04-08', 8, 1, 5),
	(1064, 11, 30, '2024-04-08', 8, 2, 5),
	(1065, 11, 31, '2024-04-08', 8, 1, 5),
	(1066, 11, 32, '2024-04-08', 9, 2, 5),
	(1067, 12, 1, '2024-04-08', 9, 1, 13),
	(1068, 12, 2, '2024-04-08', 9, 2, 13),
	(1069, 12, 19, '2024-04-08', 7, 2, 13),
	(1070, 12, 21, '2024-04-08', 7, 1, 13),
	(1071, 12, 24, '2024-04-08', 8, 1, 13),
	(1072, 12, 25, '2024-04-08', 8, 2, 13),
	(1073, 12, 26, '2024-04-08', 8, 2, 13),
	(1074, 12, 27, '2024-04-08', 7, 1, 13),
	(1075, 12, 28, '2024-04-08', 8, 2, 13),
	(1076, 12, 29, '2024-04-08', 7, 2, 13),
	(1077, 12, 30, '2024-04-08', 8, 1, 13),
	(1078, 12, 31, '2024-04-08', 7, 2, 13),
	(1079, 12, 32, '2024-04-08', 8, 1, 13),
	(1180, 4, 1, '2024-04-08', 7, 1, 5),
	(1181, 4, 2, '2024-04-08', 8, 2, 5),
	(1182, 4, 19, '2024-04-08', 7, 2, 5),
	(1183, 4, 21, '2024-04-08', 8, 2, 5),
	(1184, 4, 24, '2024-04-08', 9, 1, 5),
	(1185, 4, 25, '2024-04-08', 8, 2, 5),
	(1186, 4, 26, '2024-04-08', 7, 2, 5),
	(1187, 4, 27, '2024-04-08', 7, 1, 5),
	(1188, 4, 28, '2024-04-08', 8, 1, 5),
	(1189, 4, 29, '2024-04-08', 9, 2, 5),
	(1190, 4, 30, '2024-04-08', 9, 2, 5),
	(1191, 4, 31, '2024-04-08', 9, 1, 5),
	(1192, 4, 32, '2024-04-08', 8, 2, 5),
	(1197, 5, 1, '2024-04-18', 6.5, 2, 6),
	(1198, 6, 1, '2024-04-17', 6, 1, 7),
	(1199, 7, 1, '2024-04-03', 8, 2, 9),
	(1200, 4, 1, '2024-04-09', 8, 2, 5),
	(1201, 11, 1, '2024-04-11', 7, 2, 5),
	(1202, 20, 1, '2024-04-11', 7, 2, 11),
	(1203, 20, 2, NULL, 0, 0, 11),
	(1204, 20, 19, NULL, 0, 0, 11),
	(1205, 20, 21, NULL, 0, 0, 11),
	(1206, 20, 24, NULL, 0, 0, 11),
	(1207, 20, 25, NULL, 0, 0, 11),
	(1208, 20, 26, NULL, 0, 0, 11),
	(1209, 20, 27, NULL, 0, 0, 11),
	(1210, 20, 28, NULL, 0, 0, 11),
	(1211, 20, 29, NULL, 0, 0, 11),
	(1212, 20, 30, NULL, 0, 0, 11),
	(1213, 20, 31, NULL, 0, 0, 11),
	(1214, 20, 32, NULL, 0, 0, 11),
	(1215, 21, 1, NULL, 0, 0, 12),
	(1216, 21, 2, NULL, 0, 0, 12),
	(1217, 21, 19, NULL, 0, 0, 12),
	(1218, 21, 21, NULL, 0, 0, 12),
	(1219, 21, 24, NULL, 0, 0, 12),
	(1220, 21, 25, NULL, 0, 0, 12),
	(1221, 21, 26, NULL, 0, 0, 12),
	(1222, 21, 27, NULL, 0, 0, 12),
	(1223, 21, 28, NULL, 0, 0, 12),
	(1224, 21, 29, NULL, 0, 0, 12),
	(1225, 21, 30, NULL, 0, 0, 12),
	(1226, 21, 31, NULL, 0, 0, 12),
	(1227, 21, 32, NULL, 0, 0, 12),
	(1228, 22, 1, NULL, 0, 0, 12),
	(1229, 22, 2, NULL, 0, 0, 12),
	(1230, 22, 19, NULL, 0, 0, 12),
	(1231, 22, 21, NULL, 0, 0, 12),
	(1232, 22, 24, NULL, 0, 0, 12),
	(1233, 22, 25, NULL, 0, 0, 12),
	(1234, 22, 26, NULL, 0, 0, 12),
	(1235, 22, 27, NULL, 0, 0, 12),
	(1236, 22, 28, NULL, 0, 0, 12),
	(1237, 22, 29, NULL, 0, 0, 12),
	(1238, 22, 30, NULL, 0, 0, 12),
	(1239, 22, 31, NULL, 0, 0, 12),
	(1240, 22, 32, NULL, 0, 0, 12),
	(1241, 23, 1, NULL, 0, 0, 14),
	(1242, 23, 2, NULL, 0, 0, 14),
	(1243, 23, 19, NULL, 0, 0, 14),
	(1244, 23, 21, NULL, 0, 0, 14),
	(1245, 23, 24, NULL, 0, 0, 14),
	(1246, 23, 25, NULL, 0, 0, 14),
	(1247, 23, 26, NULL, 0, 0, 14),
	(1248, 23, 27, NULL, 0, 0, 14),
	(1249, 23, 28, NULL, 0, 0, 14),
	(1250, 23, 29, NULL, 0, 0, 14),
	(1251, 23, 30, NULL, 0, 0, 14),
	(1252, 23, 31, NULL, 0, 0, 14),
	(1253, 23, 32, NULL, 0, 0, 14),
	(1254, 24, 1, NULL, 0, 0, 11),
	(1255, 24, 2, NULL, 0, 0, 11),
	(1256, 24, 19, NULL, 0, 0, 11),
	(1257, 24, 21, NULL, 0, 0, 11),
	(1258, 24, 24, NULL, 0, 0, 11),
	(1259, 24, 25, NULL, 0, 0, 11),
	(1260, 24, 26, NULL, 0, 0, 11),
	(1261, 24, 27, NULL, 0, 0, 11),
	(1262, 24, 28, NULL, 0, 0, 11),
	(1263, 24, 29, NULL, 0, 0, 11),
	(1264, 24, 30, NULL, 0, 0, 11),
	(1265, 24, 31, NULL, 0, 0, 11),
	(1266, 24, 32, NULL, 0, 0, 11),
	(1267, 25, 1, NULL, 0, 0, 12),
	(1268, 25, 2, NULL, 0, 0, 12),
	(1269, 25, 19, NULL, 0, 0, 12),
	(1270, 25, 21, NULL, 0, 0, 12),
	(1271, 25, 24, NULL, 0, 0, 12),
	(1272, 25, 25, NULL, 0, 0, 12),
	(1273, 25, 26, NULL, 0, 0, 12),
	(1274, 25, 27, NULL, 0, 0, 12),
	(1275, 25, 28, NULL, 0, 0, 12),
	(1276, 25, 29, NULL, 0, 0, 12),
	(1277, 25, 30, NULL, 0, 0, 12),
	(1278, 25, 31, NULL, 0, 0, 12),
	(1279, 25, 32, NULL, 0, 0, 12);

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

-- Dumping data for table quanlyhocsinhtrunghoc.phu_huynh: ~13 rows (approximately)
INSERT INTO `phu_huynh` (`id_hoc_sinh`, `ten_phu_huynh`, `ngay_sinh`, `que_quan`, `gioi_tinh`, `sdt`) VALUES
	(4, 'Nguyễn Văn Mạnh', '1980-09-04', 'Hà Nội', 'nam', '0987562695'),
	(5, 'Nguyễn Thị Lành', '1984-09-08', 'Hà Nam', 'nữ', '0325698564'),
	(6, NULL, NULL, NULL, NULL, NULL),
	(7, NULL, NULL, NULL, NULL, NULL),
	(10, NULL, NULL, NULL, NULL, NULL),
	(11, 'Nguyễn Văn Sơn', '1985-09-07', 'Hà Nội', 'nam', '0356485795'),
	(12, NULL, NULL, NULL, NULL, NULL),
	(20, NULL, NULL, NULL, NULL, NULL),
	(21, NULL, NULL, NULL, NULL, NULL),
	(22, NULL, NULL, NULL, NULL, NULL),
	(23, NULL, NULL, NULL, NULL, NULL),
	(24, NULL, NULL, NULL, NULL, NULL),
	(25, NULL, NULL, NULL, NULL, NULL);

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
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.so_dau_bai: ~11 rows (approximately)
INSERT INTO `so_dau_bai` (`id`, `id_lop_hoc`, `id_giao_vien`, `ngay_giang_day`, `noi_dung_giang_day`) VALUES
	(67, 7, 7, '2024-02-01', 'Đồng bằng sông hồng'),
	(68, 9, 11, '2024-01-22', 'tìm hiểu về con lắc'),
	(69, 11, 9, '2024-04-02', 'các tỉnh miền núi phía bắc'),
	(70, 12, 1, '2024-01-02', 'Thực vật và quang hợp'),
	(71, 13, 10, '2024-03-03', 'Phương trình đường thẳng'),
	(72, 14, 14, '2024-04-11', 'tìm hiểu về từ trường'),
	(76, 5, 4, '2024-04-16', 'lịch sử cận đại'),
	(79, 5, 10, '2024-04-09', 'hình không gian'),
	(80, 5, 11, '2024-04-10', 'vật lí cổ điển'),
	(81, 6, 6, '2024-04-03', 'Lập trình pascal - câu lệnh điều kiện'),
	(82, 5, 10, '2024-04-09', 'hình học không gian'),
	(83, 7, 1, '2024-04-03', 'Thực vật quang hợp'),
	(84, 18, 12, NULL, NULL),
	(85, 21, 13, NULL, NULL);

-- Dumping structure for table quanlyhocsinhtrunghoc.so_hoc_ba
CREATE TABLE IF NOT EXISTS `so_hoc_ba` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_hoc_sinh` int(11) DEFAULT NULL,
  `hanh_kiem` varchar(10) DEFAULT NULL,
  `nhan_xet_cua_giao_vien` varchar(255) DEFAULT NULL,
  `hoc_luc` varchar(20) DEFAULT NULL,
  `diem_trung_binh` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sohocba_hocsinh_id` (`id_hoc_sinh`),
  CONSTRAINT `fk_sohocba_hocsinh_id` FOREIGN KEY (`id_hoc_sinh`) REFERENCES `hoc_sinh` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.so_hoc_ba: ~12 rows (approximately)
INSERT INTO `so_hoc_ba` (`id`, `id_hoc_sinh`, `hanh_kiem`, `nhan_xet_cua_giao_vien`, `hoc_luc`, `diem_trung_binh`) VALUES
	(1, 4, 'giỏi', ' cố gắng nhiều hơn', 'Giỏi', 8.04),
	(2, 5, 'Tốt', 'cần cố gắng', 'Trung bình', 6.83),
	(3, 6, 'khá', 'rèn luyện thêm', 'Khá', 7.27),
	(4, 7, NULL, NULL, NULL, NULL),
	(7, 10, NULL, NULL, NULL, NULL),
	(8, 11, NULL, NULL, NULL, NULL),
	(9, 12, NULL, NULL, NULL, NULL),
	(10, 20, NULL, NULL, NULL, NULL),
	(11, 21, NULL, NULL, NULL, NULL),
	(12, 22, NULL, NULL, NULL, NULL),
	(13, 23, NULL, NULL, NULL, NULL),
	(14, 24, NULL, NULL, NULL, NULL),
	(15, 25, NULL, NULL, NULL, NULL);

-- Dumping structure for table quanlyhocsinhtrunghoc.the_hoc_sinh
CREATE TABLE IF NOT EXISTS `the_hoc_sinh` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_hoc_sinh` int(11) DEFAULT NULL,
  `anh_dai_dien` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_thehocsinh_hocsinh_id` (`id_hoc_sinh`),
  CONSTRAINT `fk_thehocsinh_hocsinh_id` FOREIGN KEY (`id_hoc_sinh`) REFERENCES `hoc_sinh` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table quanlyhocsinhtrunghoc.the_hoc_sinh: ~13 rows (approximately)
INSERT INTO `the_hoc_sinh` (`id`, `id_hoc_sinh`, `anh_dai_dien`) VALUES
	(146, 4, 'hocsinh1.png'),
	(147, 5, 'hocsinh6.png'),
	(148, 6, 'hocsinh10.png'),
	(149, 7, 'hocsinh2.png'),
	(152, 10, 'hocsinh3.png'),
	(153, 11, NULL),
	(154, 12, 'anhhocsinh10.png'),
	(155, 20, 'hocsinh4.png'),
	(156, 21, NULL),
	(157, 22, NULL),
	(158, 23, 'hocsinh5.png'),
	(159, 24, NULL),
	(160, 25, NULL);

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
