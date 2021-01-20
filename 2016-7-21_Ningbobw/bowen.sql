/*
Navicat MySQL Data Transfer

Source Server         : FTP主机--192.168.1.46
Source Server Version : 50130
Source Host           : 10.26.230.144:3306
Source Database       : bowen

Target Server Type    : MYSQL
Target Server Version : 50130
File Encoding         : 65001

Date: 2016-09-24 17:57:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `board_id` int(11) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `content` text,
  `attach` varchar(255) DEFAULT NULL,
  `time` varchar(40) NOT NULL,
  `introduce` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1054 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1021', '106', '博文热点1', 'asd', 'asdasddas', '/2016-7-21_Ningbobw/upload/计科13408-李华洋-期末实验项目-通讯录.doc', '2016-07-25', null);
INSERT INTO `article` VALUES ('1022', '103', '课程安排1', '测试文章来源', '<img src=\"/2016-7-21_Ningbobw/attached/image/20160725/20160725160017_825.png\" alt=\"\" />', '/2016-7-21_Ningbobw/upload/计科13408-李华洋-实验六数据保存报告.doc', '2016-07-25', null);
INSERT INTO `article` VALUES ('1023', '107', '博文荣誉榜1', '啊啊啊啊啊啊啊啊啊啊啊啊', '<p>\r\n	<img src=\"/2016-7-21_Ningbobw/attached/image/20160725/20160725160113_187.jpeg\" alt=\"\" />\r\n</p>\r\n<p>\r\n	<br />\r\n</p>\r\n<p>\r\n	<br />\r\n</p>\r\n<p>\r\n	<br />\r\n</p>\r\n<p>\r\n	这是文章内容\r\n</p>', '', '2016-07-25', null);
INSERT INTO `article` VALUES ('1024', '105', '博文动态1', 'sa', 'as', '/2016-7-21_Ningbobw/upload/邵洪茂臣--数据库实验六.doc', '2016-07-27', null);
INSERT INTO `article` VALUES ('1025', '111', '名师介绍1', '', '<p>\r\n	地址：北仑\r\n</p>\r\n<p>\r\n	<br />\r\n</p>\r\n<p>\r\n	时间：2016年7月25日21:12:53\r\n</p>\r\n<p>\r\n	<br />\r\n</p>\r\n<p>\r\n	联系电话：110284918493\r\n</p>', '', '2016-07-25', null);
INSERT INTO `article` VALUES ('1026', '105', '博文动态2', '博文动态2', '博文动态2', '', '2016-07-26', null);
INSERT INTO `article` VALUES ('1027', '101', '教育新闻1', '教育新闻1', '教育新闻1', '', '2016-07-26', null);
INSERT INTO `article` VALUES ('1028', '101', '教育新闻2', '教育新闻2', '教育新闻2', '', '2016-07-26', null);
INSERT INTO `article` VALUES ('1029', '117', '创智数学1', '创智数学1', '创智数学1', '', '2016-07-26', null);
INSERT INTO `article` VALUES ('1030', '118', '新概念英语1', '新概念英语1', '新概念英语1', '', '2016-07-26', null);
INSERT INTO `article` VALUES ('1031', '119', '博文读写1', '博文读写1', '博文读写1', '', '2016-07-26', null);
INSERT INTO `article` VALUES ('1032', '102', '考试技巧1', '考试技巧1', '考试技巧1', '', '2016-07-26', null);
INSERT INTO `article` VALUES ('1033', '102', '考试技巧2', '考试技巧2', '考试技巧2', '', '2016-07-26', null);
INSERT INTO `article` VALUES ('1034', '109', '关于博文', '', '<p>\r\n	宁波市海曙区博文学校创办于2006年，是宁波市唯一一所以小升初、初升高考重为培养目标的一站式综合精品培训学校。博文教育专注于学生学习能力的培养和学科知识的辅导，视教学质量为生命，深受学生和家长的认可，口口相传，成就了宁波最大规模的中小学学科教育培训机构，博文教育秉承以学生为中心，应试与素质教育并重的教育理念，致力于传播先进教学思想，研究先进教学方法，开发先进教学产品，提供先进教学服务，帮助更多学生和家庭获得更好的教育和发展机会。\r\n</p>\r\n<p>\r\n	我校每年开设有春季班、暑期班、秋季班和寒假班，年培训人次均超过千人。培训效果超群，取得斐然成绩！几年来相继有1000余名考生在小升初考试中考入省市重点中学，为广大中小学考生圆了一个名校梦。\r\n</p>', '', '2016-07-26', null);
INSERT INTO `article` VALUES ('1035', '117', '创智数学标题', '创智数学来源', '创智数学内容', '', '2016-07-26', null);
INSERT INTO `article` VALUES ('1036', '106', '古诗词提纲', '', '<p>\r\n	内容在附件中\r\n</p>\r\n<p>\r\n	<br />\r\n</p>', '/2016-7-21_Ningbobw/upload/20160721020728_6574840.doc', '2016-07-26 20:55', null);
INSERT INTO `article` VALUES ('1037', '106', '测试附件下载1', '测试附件下载1', '测试附件下载1', 'http://localhost:80/2016-7-21_Ningbobw/upload/20160721020728_6574840.doc', '2016-07-26 21:07', null);
INSERT INTO `article` VALUES ('1038', '106', '文件下载测试2', '文件下载测试2', '文件下载测试2', 'http://localhost:80/2016-7-21_Ningbobw/upload/20160721020728_6574840.doc', '2016-07-26 21:13', null);
INSERT INTO `article` VALUES ('1039', '112', '2011年圣诞节暨校庆活动照片', '2011年圣诞节暨校庆活动照片', '2011年圣诞节暨校庆活动照片', '', '2016-07-27 00:50', null);
INSERT INTO `article` VALUES ('1040', '113', '2012年新概念宁波赛区决赛照片', '2012年新概念宁波赛区决赛照片', '2012年新概念宁波赛区决赛照片', '', '2016-07-27 00:50', null);
INSERT INTO `article` VALUES ('1041', '114', '2013华杯赛照片', '2013华杯赛照片', '2013华杯赛照片', '', '2016-07-27 00:50', null);
INSERT INTO `article` VALUES ('1042', '111', '名师介绍2', '名师介绍2', '名师介绍2', '', '2016-07-27 01:21', null);
INSERT INTO `article` VALUES ('1043', '112', '博文采风1', '博文采风1', '博文采风1', '', '2016-07-27 09:57', null);
INSERT INTO `article` VALUES ('1044', '112', '博文采风2', '博文采风2', '博文采风2', '', '2016-07-27 09:57', null);
INSERT INTO `article` VALUES ('1045', '110', '试题精选1', '试题精选1', '试题精选1', '', '2016-07-27 10:01', null);
INSERT INTO `article` VALUES ('1046', '110', '试题精选2', '试题精选2', '试题精选2', '', '2016-07-27 10:01', null);
INSERT INTO `article` VALUES ('1047', '117', '培训课程1', '培训课程1', '培训课程1', '', '2016-07-27 11:02', null);
INSERT INTO `article` VALUES ('1048', '117', '培训课程2', '培训课程2', '培训课程2', '', '2016-07-27 11:02', null);
INSERT INTO `article` VALUES ('1049', '117', '博文语文', '博文语文', '博文语文', '', '2016-07-27 14:30', '博文语文');
INSERT INTO `article` VALUES ('1050', '117', '新概念英语', '新概念英语', '新概念英语', '', '2016-07-27 14:30', '新概念英语');
INSERT INTO `article` VALUES ('1051', '117', '创智数学', '创智数学', '创智数学', '', '2016-07-27 14:35', '创智数学');
INSERT INTO `article` VALUES ('1052', '117', '初中全科', '初中全科', '初中全科', '', '2016-07-27 14:35', '初中全科');
INSERT INTO `article` VALUES ('1053', '106', '阿斯顿', 'asdasd', 'asasd', 'http://localhost:80/2016-7-21_Ningbobw/upload/fps-zhblue-www.csie.nctu.edu.tw-306-310.xml', '2016-07-28 15:25', '爱上');

-- ----------------------------
-- Table structure for board
-- ----------------------------
DROP TABLE IF EXISTS `board`;
CREATE TABLE `board` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(50) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of board
-- ----------------------------
INSERT INTO `board` VALUES ('101', '教育新闻', '100');
INSERT INTO `board` VALUES ('102', '考试技巧', '100');
INSERT INTO `board` VALUES ('103', '课程安排', '100');
INSERT INTO `board` VALUES ('104', '招生专栏', '100');
INSERT INTO `board` VALUES ('105', '博文动态', '100');
INSERT INTO `board` VALUES ('106', '博文热点', '100');
INSERT INTO `board` VALUES ('107', '荣誉榜', '100');
INSERT INTO `board` VALUES ('109', '关于博文', '104');
INSERT INTO `board` VALUES ('110', '试题精选', '107');
INSERT INTO `board` VALUES ('111', '名师介绍', '102');
INSERT INTO `board` VALUES ('112', '博文采风', '103');
INSERT INTO `board` VALUES ('115', '联系方式', '105');
INSERT INTO `board` VALUES ('116', '校园风貌', '106');
INSERT INTO `board` VALUES ('117', '培训课程', '101');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `titile` varchar(100) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('博文新闻', '100');
INSERT INTO `category` VALUES ('培训课程', '101');
INSERT INTO `category` VALUES ('名师介绍', '102');
INSERT INTO `category` VALUES ('博文采风', '103');
INSERT INTO `category` VALUES ('关于我们', '104');
INSERT INTO `category` VALUES ('联系我们', '105');
INSERT INTO `category` VALUES ('校园风貌', '106');
INSERT INTO `category` VALUES ('试题精选', '107');

-- ----------------------------
-- Procedure structure for getAllCatgory
-- ----------------------------
DROP PROCEDURE IF EXISTS `getAllCatgory`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `getAllCatgory`()
BEGIN


SELECT 
CONCAT(
'[',
CAST(
		GROUP_CONCAT(
			CONCAT('{"article_id":"', bo.id, '",'),
			CONCAT('"article_title":"', bo.content, '"}')
		)
 as CHAR ),']'
	) AS item ,

	cat.id as id,
	cat.titile as titile
FROM
	board as bo,
	category as cat

WHERE 
	bo.category_id = cat.id

GROUP BY cat.id;


END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for get_board_article
-- ----------------------------
DROP PROCEDURE IF EXISTS `get_board_article`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `get_board_article`()
BEGIN



/*
"101"
"102"
"103"
"104"
"105"
"106"
"107"
*/
SELECT 
CONCAT(
'[',
CAST(
		GROUP_CONCAT(
			CONCAT('{"title":"', art.title, '",'),
			CONCAT('"link":"detail.html?article_id=', art.id, '",'),
			CONCAT('"time":"', art.time, '"}') order by art.time desc 
		)
 as CHAR ),']'
	) AS article_list,

art.board_id as board_id

FROM
	article as art

WHERE art.board_id BETWEEN "101" AND "107"

GROUP BY board_id;

#ORDER BY art.time DESC;

		












END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for get_category_article
-- ----------------------------
DROP PROCEDURE IF EXISTS `get_category_article`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `get_category_article`()
BEGIN
	#Routine body goes here...


SELECT 
CONCAT(
'[',
CAST(
		GROUP_CONCAT(
			CONCAT('{"title":"', art.title, '",'),
			CONCAT('"link":"detail.html?article_id=', art.id, '",'),
			CONCAT('"time":"', art.time, '"}') order by art.time desc 
		)
 as CHAR ),']'
	) AS article_list,

	ca.id as catgory_id

FROM
	board as boa,
	category AS ca,
	article as art

WHERE 
	boa.category_id = ca.id AND art.board_id = boa.id AND ca.id NOT IN ("100")

GROUP BY ca.id
ORDER BY ca.id;
END
;;
DELIMITER ;
