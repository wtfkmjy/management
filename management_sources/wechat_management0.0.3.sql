-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1:3306
-- 生成日期： 2023-03-19 10:21:44
-- 服务器版本： 5.7.26
-- PHP 版本： 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `wechat_management`
--

-- --------------------------------------------------------

--
-- 表的结构 `chat`
--

DROP TABLE IF EXISTS `chat`;
CREATE TABLE IF NOT EXISTS `chat` (
  `chatId` int(20) NOT NULL,
  `chatName` varchar(20) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `chat`
--

INSERT INTO `chat` (`chatId`, `chatName`) VALUES
(1, '软件工程综合实训');

-- --------------------------------------------------------

--
-- 表的结构 `connection`
--

DROP TABLE IF EXISTS `connection`;
CREATE TABLE IF NOT EXISTS `connection` (
  `staffId` int(20) NOT NULL,
  `customerId` int(20) NOT NULL,
  PRIMARY KEY (`staffId`,`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `customerId` int(20) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `customerEmail` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `customerGender` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `customerAddress` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `customerPhone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `customerJob` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `customerJointime` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `chargeStaff` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `customer`
--

INSERT INTO `customer` (`customerId`, `customerName`, `customerEmail`, `customerGender`, `customerAddress`, `customerPhone`, `customerJob`, `customerJointime`, `chargeStaff`) VALUES
(1, 'rose', '132@qq.com', '男', 'szu', '139156686', '教师', '2022-03-04', NULL),
(2, 'cris', '4454322@qq.com', '男', '南山', '13915648945', '教师', '2022-03-05', NULL),
(3, 'helloworld', 'dasd@adsa', '男', 'szu', '6154132', '教师', '2002-01-01', NULL),
(4, 'jack', 'jack@szu.edu.cn', '女', '深圳大学', '13556147', '医生', '2020-10-10', NULL),
(5, '小马', 'xiaoma@qq.com', '女', 'tencent', '139156155', '程序员', '2022-03-14', NULL),
(6, '小涛', 'zetao@qq.com', '男', 'szu', '1391498945', '学生', '2022-09-01', NULL),
(7, '峰哥', 'dulaoshi@szu.edu.cn', '男', 'szu', '11515648945', '教师', '2022-09-10', NULL),
(8, 'a8', '123@qq.com', '男', 'a8', '13549845', '会计', '2018-08-08', 'a'),
(9, '滨斌', 'asd@qq.com', '男', 'binbinhome', '1896451', '彬彬', '2022-02-22', 'sads'),
(10, '小智', 'xiaozhi@qq.com', '女', 'szu', '6154132', '智慧集团', '2002-02-02', 'sads'),
(11, 'ovo', 'abc@abc.com', '女', 'abcabc', '123123', 'abc123', '2023-01-01', '小李'),
(12, '老李', 'laoli@qq.com', '男', '李老村', '6154132', '老李村', '2002-01-01', '小明'),
(13, 'sadasd', 'dsa@qq.com', '男', 'dsadas', '123456987', 'dasdas', '2023-03-01', 'dawds'),
(14, '吉塔', 'gita@gita.com', '女', '吉塔小区', '85341354', '歌手', '2023-03-08', 'asda'),
(15, '小东', 'xd@xdxd.com', '男', '冬筑', '1897531', '运动员', '2023-03-03', 'sads'),
(16, '霄糊', 'xiaohu@qq.com', '男', '秋瑟', '1654348', '学生', '2023-03-01', 'fafs'),
(17, '污渍', 'wuzi@123.com', '男', 'wuzihome', '489654341', '电竞选手', '2023-03-02', 'fafs'),
(18, '小轩', 'xiaoxuan@szu.edu.cn', '女', 'szu', '1685423', '学生', '2023-03-01', 'sads'),
(19, 'qwq', 'qwq@qwq.com', '女', 'QwQ', '1986543121', 'QAQ', '2023-03-08', 'dasda'),
(20, '大梅', 'bigmei@qq.com', '男', '阿根廷', '165432148', '运动员', '2023-03-01', 'asd'),
(21, '大罗', 'bigluo@qq.com', '男', '巴西', '13489651', '运动员', '2023-03-08', 'dasda'),
(22, '罗哥', 'luobro@qq.com', '男', '葡萄牙', '13874653', '运动员', '2023-03-08', 'adssad'),
(23, '小坚', 'xiaojian@qq.com', '男', 'szu', '134568452', '学生', '2023-03-15', 'dsadas'),
(24, '小雄', 'szu@szu.edu.cn', '男', 'szu', '131564895123', '学生', '2023-03-05', '小李'),
(26, 'sadasd', '1213', '', '123', '123', '23', '2023-03-08', 'sada');

-- --------------------------------------------------------

--
-- 表的结构 `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `departmentId` int(20) NOT NULL,
  `departmentName` varchar(20) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `record`
--

DROP TABLE IF EXISTS `record`;
CREATE TABLE IF NOT EXISTS `record` (
  `personId` int(20) NOT NULL,
  `time` varchar(100) COLLATE utf8_bin NOT NULL,
  `chatId` int(20) NOT NULL,
  `chatName` varchar(20) COLLATE utf8_bin NOT NULL,
  `content` varchar(200) COLLATE utf8_bin NOT NULL,
  `isCustomer` int(5) NOT NULL,
  PRIMARY KEY (`personId`,`isCustomer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `record`
--

INSERT INTO `record` (`personId`, `time`, `chatId`, `chatName`, `content`, `isCustomer`) VALUES
(1, '2023-3-17 22:00:00', 1, '软件工程综合实训', '大家好啊', 1);

-- --------------------------------------------------------

--
-- 表的结构 `staff`
--

DROP TABLE IF EXISTS `staff`;
CREATE TABLE IF NOT EXISTS `staff` (
  `staffId` int(20) NOT NULL AUTO_INCREMENT,
  `staffName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `staffEmail` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `staffGender` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `staffAddress` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `staffJob` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `staffPhone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `staffAccount` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `staffPassword` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `department` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`staffId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `staff`
--

INSERT INTO `staff` (`staffId`, `staffName`, `staffEmail`, `staffGender`, `staffAddress`, `staffJob`, `staffPhone`, `staffAccount`, `staffPassword`, `department`) VALUES
(1, '小明', '', NULL, '', '主管', '', 'abc', '$2a$10$8s3BVDt9QkZ9nQLX.b2BDuJx2G89ydemg7dBjFU8CACQnTsXLzJNG', '人事部'),
(2, '小红', '', NULL, '', '', '', 'bcd', '123456', '人事部'),
(3, '小李', NULL, NULL, NULL, NULL, NULL, '2020', '12', 'management'),
(4, '小王', NULL, NULL, NULL, NULL, NULL, 'qweqw', '123', ''),
(5, '小胡', NULL, NULL, NULL, NULL, NULL, 'abc1', '123456', ''),
(6, '小刘', NULL, NULL, NULL, NULL, NULL, 'abcdefg', '123456', ''),
(7, 'sada', 'sda', 'dasd', 'sad', 'asd', 'asd', 'asd', '{noop}asd', ''),
(8, NULL, NULL, NULL, NULL, NULL, NULL, 'szu.edu', '123', ''),
(9, NULL, NULL, NULL, NULL, NULL, NULL, '1231', '23132132', ''),
(10, NULL, NULL, NULL, NULL, NULL, NULL, 'bco', '123456', ''),
(11, NULL, NULL, NULL, NULL, NULL, NULL, 'bcoo', '123456', ''),
(12, NULL, NULL, NULL, NULL, NULL, NULL, 'bcooas', '123456', ''),
(13, '小小', NULL, NULL, NULL, '职员', NULL, 'abcdeeeee', '$2a$10$QEAvNl2vMhxX.PCmHZsEgum47OMFqNjEYNwhjENSIHNGaEQ2JqidK', '销售部'),
(14, '??', 'sda@qq.com', '?', 'szu', '??', '16541321', 'xiaohu', '$2a$10$C82zmQCfH5rJ.MkZSn3sYOrTr1KNCiARRVlEAe5/1YMdJ75.3/y2y', NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
