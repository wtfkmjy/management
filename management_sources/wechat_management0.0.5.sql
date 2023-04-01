-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- 主机： 127.0.0.1:3306
-- 生成日期： 2023-04-01 09:02:54
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
  `chatName` varchar(20) COLLATE utf8_bin NOT NULL,
  `number` int(5) DEFAULT NULL,
  `buildTime` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `degree` varchar(10) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `chat`
--

INSERT INTO `chat` (`chatId`, `chatName`, `number`, `buildTime`, `degree`) VALUES
(1, '软件工程综合实训', NULL, NULL, NULL);

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
  `customerQQ` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `nickname` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `customer`
--

INSERT INTO `customer` (`customerId`, `customerName`, `customerEmail`, `customerGender`, `customerAddress`, `customerPhone`, `customerJob`, `customerJointime`, `chargeStaff`, `customerQQ`, `nickname`) VALUES
(1, 'roserose', 'rose@rose.com', '女', 'roseszu', '13249845', '学生', '2022-03-04', NULL, '315647', 'roooose'),
(2, 'cris', '4454322@qq.com', '男', '南山', '13915648945', '教师', '2022-03-05', NULL, '231654', 'wow'),
(3, 'helloworld', 'dasd@adsa', '男', 'szu', '6154132', '教师', '2002-01-01', NULL, NULL, ''),
(4, 'Jack', '256654@qq.com', '男', '南山', '163249845', '教师', '2022-10-10', 'asd', NULL, ''),
(5, '小马', 'xiaoma@qq.com', '女', 'tencent', '139156155', '程序员', '2022-03-14', NULL, NULL, ''),
(6, '小涛', 'zetao@qq.com', '男', 'szu', '1391498945', '学生', '2022-09-01', NULL, NULL, ''),
(7, '峰哥', 'dulaoshi@szu.edu.cn', '男', 'szu', '11515648945', '教师', '2022-09-10', NULL, NULL, ''),
(8, 'a8', '123@qq.com', '男', 'a8', '13549845', '会计', '2018-08-08', 'a', NULL, ''),
(9, '滨斌', 'asd@qq.com', '男', 'binbinhome', '1896451', '彬彬', '2022-02-22', 'sads', NULL, ''),
(10, '小智', 'xiaozhi@qq.com', '女', 'szu', '6154132', '智慧集团', '2002-02-02', 'sads', NULL, ''),
(11, 'ovo', 'abc@abc.com', '女', 'abcabc', '123123', 'abc123', '2023-01-01', '小李', NULL, ''),
(12, '老李', 'laoli@qq.com', '男', '李老村', '6154132', '老李村', '2002-01-01', '小明', NULL, ''),
(13, 'sadasd', 'dsa@qq.com', '男', 'dsadas', '123456987', 'dasdas', '2023-03-01', 'dawds', NULL, ''),
(14, '吉塔', 'gita@gita.com', '女', '吉塔小区', '85341354', '歌手', '2023-03-08', 'asda', NULL, ''),
(15, '小东', 'xd@xdxd.com', '男', '冬筑', '1897531', '运动员', '2023-03-03', 'sads', NULL, ''),
(16, '霄糊', 'xiaohu@qq.com', '男', '秋瑟', '1654348', '学生', '2023-03-01', 'fafs', NULL, ''),
(17, '污渍', 'wuzi@123.com', '男', 'wuzihome', '489654341', '电竞选手', '2023-03-02', 'fafs', NULL, ''),
(18, '小轩', 'xiaoxuan@szu.edu.cn', '女', 'szu', '1685423', '学生', '2023-03-01', 'sads', NULL, ''),
(19, 'qwq', 'qwq@qwq.com', '女', 'QwQ', '1986543121', 'QAQ', '2023-03-08', 'dasda', NULL, ''),
(20, '大梅', 'bigmei@qq.com', '男', '阿根廷', '165432148', '运动员', '2023-03-01', 'asd', NULL, ''),
(21, '大罗', 'bigluo@qq.com', '男', '巴西', '13489651', '运动员', '2023-03-08', 'dasda', NULL, ''),
(22, '罗哥', 'luobro@qq.com', '男', '葡萄牙', '13874653', '运动员', '2023-03-08', 'adssad', NULL, ''),
(23, '小坚', 'xiaojian@qq.com', '男', 'szu', '134568452', '学生', '2023-03-15', 'dsadas', NULL, ''),
(24, '小雄', 'szu@szu.edu.cn', '男', 'szu', '131564895123', '学生', '2023-03-05', '小李', NULL, ''),
(26, '霄霄', 'xx@qq.com', '女', '深圳市', '123842314', '教师', '2023-03-08', 'sada', NULL, ''),
(27, '小小马er', 'xiaomaer@szu.edu.cn', '男', '深圳大学', '164895132', '教师', '2023-04-01 15:35:54', 'asd', '12645651', 'horse');

-- --------------------------------------------------------

--
-- 表的结构 `deleted`
--

DROP TABLE IF EXISTS `deleted`;
CREATE TABLE IF NOT EXISTS `deleted` (
  `customerId` int(20) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `customerEmail` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `customerGender` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `customerAddress` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `customerPhone` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `customerJob` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `customerJointime` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `chargeStaff` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `customerQQ` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `deleteTime` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
-- 表的结构 `followup`
--

DROP TABLE IF EXISTS `followup`;
CREATE TABLE IF NOT EXISTS `followup` (
  `staffId` int(10) NOT NULL,
  `staffName` varchar(30) COLLATE utf8_bin NOT NULL,
  `staffQQ` varchar(20) COLLATE utf8_bin NOT NULL,
  `customerId` int(10) NOT NULL,
  `customerName` varchar(30) COLLATE utf8_bin NOT NULL,
  `customerQQ` varchar(20) COLLATE utf8_bin NOT NULL,
  `entryTime` varchar(20) COLLATE utf8_bin NOT NULL,
  `contactWay` varchar(100) COLLATE utf8_bin NOT NULL,
  `result` varchar(300) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`staffId`,`customerId`,`entryTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `followup`
--

INSERT INTO `followup` (`staffId`, `staffName`, `staffQQ`, `customerId`, `customerName`, `customerQQ`, `entryTime`, `contactWay`, `result`) VALUES
(27, '小虎hu', '2316548', 2, 'cris', '231654', '2023-04-01 15:59:39', '电话联系', '很好很好很好！');

-- --------------------------------------------------------

--
-- 表的结构 `manu`
--

DROP TABLE IF EXISTS `manu`;
CREATE TABLE IF NOT EXISTS `manu` (
  `manuId` int(10) NOT NULL AUTO_INCREMENT,
  `manuName` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`manuId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `manu`
--

INSERT INTO `manu` (`manuId`, `manuName`) VALUES
(1, '获取客户信息'),
(2, '添加与修改客户'),
(3, '删除客户'),
(4, '联系跟进'),
(5, '获取员工信息'),
(6, '添加与修改员工'),
(7, '设置权限'),
(8, '获取群聊信息'),
(9, '查找聊天记录'),
(10, '导入新群聊'),
(11, '聊天记录备注');

-- --------------------------------------------------------

--
-- 表的结构 `member`
--

DROP TABLE IF EXISTS `member`;
CREATE TABLE IF NOT EXISTS `member` (
  `memberQQ` varchar(30) COLLATE utf8_bin NOT NULL,
  `nickname` varchar(30) COLLATE utf8_bin NOT NULL,
  `isCustomer` int(5) NOT NULL,
  `avatarURL` varchar(100) COLLATE utf8_bin NOT NULL
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
  PRIMARY KEY (`personId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- 表的结构 `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `roleId` int(10) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `role`
--

INSERT INTO `role` (`roleId`, `roleName`) VALUES
(1, '人事部'),
(2, '销售部'),
(3, '营销部'),
(4, '服务部'),
(5, '主管'),
(6, '经理'),
(7, '员工'),
(8, '管理员'),
(9, '群聊管理者'),
(10, '超级管理员'),
(11, '销售组长');

-- --------------------------------------------------------

--
-- 表的结构 `role_manu`
--

DROP TABLE IF EXISTS `role_manu`;
CREATE TABLE IF NOT EXISTS `role_manu` (
  `roleId` int(10) NOT NULL,
  `roleName` varchar(30) COLLATE utf8_bin NOT NULL,
  `manuId` int(10) NOT NULL,
  `manuName` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`roleId`,`manuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `role_manu`
--

INSERT INTO `role_manu` (`roleId`, `roleName`, `manuId`, `manuName`) VALUES
(10, '超级管理员', 1, '获取客户信息'),
(10, '超级管理员', 2, '添加与修改客户'),
(10, '超级管理员', 3, '删除客户'),
(10, '超级管理员', 4, '联系跟进'),
(10, '超级管理员', 5, '获取员工信息'),
(10, '超级管理员', 6, '添加与修改员工'),
(10, '超级管理员', 7, '设置权限'),
(10, '超级管理员', 8, '获取群聊信息'),
(10, '超级管理员', 9, '查找聊天记录'),
(10, '超级管理员', 10, '导入新群聊'),
(10, '超级管理员', 11, '聊天记录备注'),
(11, '销售组长', 1, '获取客户信息');

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
  `staffQQ` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`staffId`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `staff`
--

INSERT INTO `staff` (`staffId`, `staffName`, `staffEmail`, `staffGender`, `staffAddress`, `staffJob`, `staffPhone`, `staffAccount`, `staffPassword`, `department`, `staffQQ`) VALUES
(1, '小明', 'xiaoming@qq.com', '男', '深圳市', '主管', '13534985', 'abc', '$2a$10$8s3BVDt9QkZ9nQLX.b2BDuJx2G89ydemg7dBjFU8CACQnTsXLzJNG', '人事部', NULL),
(13, '小溪', 'xiaoxi@xiaoxi.com', '女', 'xiaoxiszu', '主管', '45623115', 'xiaoxi', '123456', '销售部', '1234564'),
(15, '雷洋', 'q.lwlleo@lrjnlgw.ng', '男', '开封市', '职员', '18125221555', 'lysykf', '$2a$10$OZlqDWs9BA3OcDtZvopGmuD2o74b8fiKStvTTl4iNmIA/3/TE7YpK', NULL, NULL),
(16, '魏明', 'c.xaqs@hhskwii.an', '男', '承德市', '职员', '18112033835', 'cbyvvwm', '$2a$10$itAeHEqBtuVcoeM1HbKrcekih76yEyVgftjPg3K3onnfYcTP4XW1e', NULL, NULL),
(17, '石刚', 'r.cvpqj@txyemece.ye', '男', '佛山市', '主管', '18184693063', 'fku', '$2a$10$xUl2MgmRDapIZ1dCtoF8eeUinEmMCg.R.8Md.QsnydFSwE2qk6yyS', NULL, NULL),
(18, '孙芳', 'z.aueir@jlpf.lb', '男', '高雄市', '主管', '18187580651', 'hwdizhpf', '$2a$10$YNrwZP900EPkyBblG43Y4eCN.lsIZfwQhr5V7uTTR7XsNc9RJnMI6', NULL, NULL),
(19, '何秀兰', 'k.kvbds@omspgtbq.gn', '女', '海南藏族自治州', '主管', '18666876899', 'dodyzh', '$2a$10$qg6sq2m71CRP6Q6FO218R.MT8/SI2EWiHuVpNqm.aPhopZyEKa9nG', '人事部', NULL),
(20, '曾平', 'x.lbdv@wdfwd.mm', '女', '佳木斯市', '主管', '18166248869', 'ddnybprid', '$2a$10$O90/s.PV11D5fVOaZ2/6fONHNZfnGfH7GP5yE0gwvqE4WOIsYBKGm', '营销部', NULL),
(21, '汤秀兰', 'o.ctcj@rjpfevaf.ws', '女', '澳门半岛', '主管', '13346465399', 'nkuvy', '$2a$10$NGDWJKN2ZsfRTrbGtALKuOHO0lBSu3gFsHhkdbbCrl4bGXACEZFTS', '销售部', NULL),
(22, '姚秀兰', 'i.dqkyqx@lazbk.nz', '女', '贵阳市', '主管', '18126378078', 'xcce', '$2a$10$V5zIjcayNzbeUO2jrj9.hOLBlwJef4jzXYNzpAimzDkOeMORanAHS', '服务部', NULL),
(23, '陆静', 'z.ywdnbrs@fpyf.ie', '男', '长治市', '职员', '19844593571', 'yooripfm', '$2a$10$LrVdh9ReRTw589g1XswBS.sZaMabxQEFHD4jFGH5bl33Ay43bC2Oi', '服务部', NULL),
(24, '邱桂英', 'o.wtydjkd@rmkckyu.sr', '男', '九江市', '职员', '19847388150', 'dfxvvlixkw', '$2a$10$i056sKAEuCSJ3LWsLFYH7eA7BYHDD/Q.MNUieCxNWbwfYd3262pmW', '服务部', NULL),
(25, '锺杰', 'h.tmmwrdwl@qtfds.pa', '男', '眉山市', '职员', '18138318775', 'mjb', '$2a$10$PkOQE5L/0NxwB5ptxfQoV.RSX72tiNPjvhZtp2Fwpm1blFXJWHItW', '销售部', NULL),
(26, '吴芳', 'e.dhucqd@ovdejl.hr', '女', '通化市', '职员', '18196632873', 'ymu', '$2a$10$/cLcT6oXncPYjfoliXYGOeXI8MMVkhkSrqtjRTFbkwgmWgjIj8niu', '人事部', NULL),
(27, '小虎hu', 'sdaxiaohu@qq.com', '男', 'szu', '部长', '16541321', 'xiaohuhu', '$2a$10$RqnW6HWYLgRGKKLP4m.Esu/YcnaWQiuAMlwfmVe0dLx21b6Gy0Vpi', '人事部', '2316548');

-- --------------------------------------------------------

--
-- 表的结构 `staff_role`
--

DROP TABLE IF EXISTS `staff_role`;
CREATE TABLE IF NOT EXISTS `staff_role` (
  `staffId` int(10) NOT NULL,
  `staffName` varchar(30) COLLATE utf8_bin NOT NULL,
  `roleId` int(10) NOT NULL,
  `roleName` varchar(30) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`staffId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- 转存表中的数据 `staff_role`
--

INSERT INTO `staff_role` (`staffId`, `staffName`, `roleId`, `roleName`) VALUES
(1, '小明', 10, '超级管理员'),
(27, '小虎hu', 11, '销售组长');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
