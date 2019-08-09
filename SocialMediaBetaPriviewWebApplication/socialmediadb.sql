-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.24 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table polyglots_web_app.login_user
CREATE TABLE IF NOT EXISTS `login_user` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL DEFAULT '0',
  `password` varchar(50) NOT NULL DEFAULT '0',
  `reg_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`login_id`),
  KEY `FK_login_user_register_user` (`reg_id`),
  CONSTRAINT `FK_login_user_register_user` FOREIGN KEY (`reg_id`) REFERENCES `register_user` (`reg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- Dumping data for table polyglots_web_app.login_user: ~22 rows (approximately)
/*!40000 ALTER TABLE `login_user` DISABLE KEYS */;
INSERT INTO `login_user` (`login_id`, `email`, `password`, `reg_id`) VALUES
	(2, 'sachinamore.sm.97@gmail.com', 'sachin@111', 7),
	(3, 'tejas@gmail.com', 'tejas111', 8),
	(4, 'rsvyavahare333@gmail.com', 'rahul111', 9),
	(5, 'akash@gmail.com', 'akash111', 10),
	(6, 'akash@gmail.com', 'akash111', 11),
	(7, 'rahul@gmail.com', '123456', 12),
	(8, 'rahul@gmail.com', 'rahul111', 13),
	(9, 'rahul@gmail.com', 'rahul111', 14),
	(10, 'rahul@gmail.com', 'rahul111', 15),
	(11, 'rahul@gmail.com', 'rahul111', 16),
	(12, 'rahul@gmail.com', 'rahul111', 17),
	(13, 'rahul@gmail.com', 'rahul111', 18),
	(14, 'rahul@gmail.com', 'rahul111', 19),
	(15, 'rahul@gmail.com', 'rahul111', 20),
	(16, 'rahul@gmail.com', 'rahul111', 21),
	(17, 'rahul@gmail.com', 'rahul111', 22),
	(18, 'rahul', 'rahul101', 23),
	(19, 'sus', 'dfm4444@44%7', 24),
	(20, 'sus', '4444', 25),
	(21, 'sus', '4444', 26),
	(22, 'sus', '4444', 27),
	(23, 'sau@gmail.com', 'sus', 28);
/*!40000 ALTER TABLE `login_user` ENABLE KEYS */;

-- Dumping structure for table polyglots_web_app.register_user
CREATE TABLE IF NOT EXISTS `register_user` (
  `reg_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL DEFAULT '0',
  `last_name` varchar(50) NOT NULL DEFAULT '0',
  `email` varchar(50) NOT NULL DEFAULT '0',
  `password` varchar(50) NOT NULL DEFAULT '0',
  `gender` varchar(50) NOT NULL DEFAULT '0',
  `contact_number` varchar(10) NOT NULL DEFAULT '0',
  `country` varchar(20) NOT NULL DEFAULT '0',
  `state` varchar(20) NOT NULL DEFAULT '0',
  `city` varchar(20) NOT NULL DEFAULT '0',
  `address` varchar(50) NOT NULL DEFAULT '0',
  `pin` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`reg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

-- Dumping data for table polyglots_web_app.register_user: ~22 rows (approximately)
/*!40000 ALTER TABLE `register_user` DISABLE KEYS */;
INSERT INTO `register_user` (`reg_id`, `first_name`, `last_name`, `email`, `password`, `gender`, `contact_number`, `country`, `state`, `city`, `address`, `pin`) VALUES
	(7, 'Sachin', 'More', 'sachinamore.sm.97@gmail.com', 'sachin@111', 'Male', '9665335995', 'India', 'Maharashtra', 'Solapur', 'A/P:-Bhose,Teh-Mangalwedha', 413324),
	(8, 'Tejas', 'More', 'tejas@gmail.com', 'tejas111', 'Male', '7028302665', 'India', 'Maharashtra', 'Solapur', 'A/P-Kole,Teh-Athpadi', 413301),
	(9, 'Rahul', 'Vyavahare', 'rsvyavahare333@gmail.com', 'rahul111', 'Male', '9965369522', 'India', 'Maharashtra', 'Solapur', 'A/P:-Dange chowk', 413302),
	(10, 'Akash', 'Kadam', 'akash@gmail.com', 'akash111', 'Male', '8855225566', 'India', 'Maharashtra', 'Solapur', 'A/P:-Ashti,Teh-Athpadi', 413325),
	(11, 'Akash', 'Kadam', 'akash@gmail.com', 'akash111', 'Male', '8855225566', 'India', 'Maharashtra', 'Solapur', 'A/P:-Ashti,Teh-Athpadi', 413325),
	(12, 'rahu', 'kore', 'rahul@gmail.com', '123456', 'Male', '', 'India', 'Maharashtra', 'Pune', 'A/P:dange Chowk, Pune', 413302),
	(13, 'Rahul', 'kore', 'rahul@gmail.com', 'rahul111', 'Male', '9665335321', 'India', 'Maharashtra', 'Pune', 'A/P:-Dange Chowk, pune', 413302),
	(14, 'Rahul', 'kore', 'rahul@gmail.com', 'rahul111', 'Male', '9665335321', 'India', 'Maharashtra', 'Pune', 'A/P:-Dange Chowk, pune', 413302),
	(15, 'Rahul', 'kore', 'rahul@gmail.com', 'rahul111', 'Male', '9665335321', 'India', 'Maharashtra', 'Pune', 'A/P:-Dange Chowk, pune', 413302),
	(16, 'Rahul', 'kore', 'rahul@gmail.com', 'rahul111', 'Male', '9665335321', 'India', 'Maharashtra', 'Pune', 'A/P:-Dange Chowk, pune', 413302),
	(17, 'rahul', 'kore', 'rahul@gmail.com', 'rahul111', 'Male', '7702131212', 'India', 'Maharashtra', 'Pune', 'dange chowk, pune', 412232),
	(18, 'rahul', 'kore', 'rahul@gmail.com', 'rahul111', 'Male', '7702131212', 'India', 'Maharashtra', 'Pune', 'dange chowk, pune', 412232),
	(19, 'rahul', 'kore', 'rahul@gmail.com', 'rahul111', 'Male', '7702131212', 'India', 'Maharashtra', 'Pune', 'dange chowk, pune', 412232),
	(20, 'rahul', 'kore', 'rahul@gmail.com', 'rahul111', 'Male', '7702131212', 'India', 'Maharashtra', 'Pune', 'dange chowk, pune', 412232),
	(21, 'rahul', 'kore', 'rahul@gmail.com', 'rahul111', 'Male', '7702131212', 'India', 'Maharashtra', 'Pune', 'dange chowk, pune', 412232),
	(22, 'rahul', 'kore', 'rahul@gmail.com', 'rahul111', 'Male', '7702131212', 'India', 'Maharashtra', 'Pune', 'dange chowk, pune', 412232),
	(23, 'rahul', 'Kore', 'rahul@gmail.com', 'rahul101', 'Male', '7765101010', 'India', 'Maharashtra', 'Pune', 'dange chowk', 414141),
	(24, 'SUS', '', 'sus', 'dfm4444@44%7', 'Male', '555554555', 'India', 'Maharashtra', 'Mumbai', 'OJFOIUODIJAFDJKF', 965596),
	(25, 'SUS', 'bh', 'sus', '4444', 'Male', '555554555', 'India', 'Maharashtra', 'Mumbai', 'OJFOIUODIJAFDJKF', 965596),
	(26, 'SUS', 'bh', 'sus', '4444', 'Male', '555554555', 'India', 'Maharashtra', 'Mumbai', 'OJFOIUODIJAFDJKF', 965596),
	(27, 'SUS', 'bh', 'sus', '4444', 'Male', '555554555', 'India', 'Maharashtra', 'Mumbai', 'OJFOIUODIJAFDJKF', 965596),
	(28, 'sus', 'bhore', 'sau@gmail.com', 'sus', 'Male', '9999665566', 'India', 'Maharashtra', 'Pune', 'asdfghjkl', 412235);
/*!40000 ALTER TABLE `register_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
