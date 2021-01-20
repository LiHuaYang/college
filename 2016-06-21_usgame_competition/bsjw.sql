/*
Navicat MySQL Data Transfer

Source Server         : FTP主机--192.168.1.46
Source Server Version : 50130
Source Host           : 10.26.230.144:3306
Source Database       : bsjw

Target Server Type    : MYSQL
Target Server Version : 50130
File Encoding         : 65001

Date: 2016-09-24 17:57:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for applyorder
-- ----------------------------
DROP TABLE IF EXISTS `applyorder`;
CREATE TABLE `applyorder` (
  `openid` varchar(30) NOT NULL DEFAULT ' ',
  `total_fee` int(255) NOT NULL DEFAULT '0',
  `transaction_id` varchar(30) NOT NULL DEFAULT '0',
  `out_trade_no` varchar(40) NOT NULL DEFAULT '0',
  `time_end` varchar(30) NOT NULL DEFAULT '0',
  `attach` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of applyorder
-- ----------------------------
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468123677wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468124158wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468124251wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468125452wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468125934wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES ('oe_BRwjVpqlaw3aXIBm4xcGqphkI', '1', '4004952001201607108697418713', '1468126619wxbd2420d3a7c050d6', '20160710132220', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468130494wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468131145wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468131514wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468132017wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468132287wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468132339wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468137175wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468147943wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468151802wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468153738wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468412084wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468412189wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468580080wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468580112wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1468580323wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES ('oe_BRwissQN2EinQQkgCykg6FidY', '1', '4004052001201607219455547056', '1469089560wxbd2420d3a7c050d6', '20160721162626', null);
INSERT INTO `applyorder` VALUES ('oe_BRwsjMlUN_Os5D5N9iHUy5hSg', '1', '4009392001201607219455938583', '1469090311wxbd2420d3a7c050d6', '20160721163851', null);
INSERT INTO `applyorder` VALUES ('oe_BRwsjMlUN_Os5D5N9iHUy5hSg', '1', '4009392001201607219458409851', '1469091165wxbd2420d3a7c050d6', '20160721165317', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469091406wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469091572wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES ('oe_BRwsjMlUN_Os5D5N9iHUy5hSg', '1', '4009392001201607219458889155', '1469092066wxbd2420d3a7c050d6', '20160721170805', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469092526wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES ('oe_BRwsjMlUN_Os5D5N9iHUy5hSg', '1', '4009392001201607219472914683', '1469103238wxbd2420d3a7c050d6', '20160721201442', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469103671wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469104301wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469105705wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469105789wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469106709wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES ('oe_BRwsjMlUN_Os5D5N9iHUy5hSg', '1', '4009392001201607229517605798', '1469163852wxbd2420d3a7c050d6', '20160722130432', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469166569wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES ('oe_BRwsjMlUN_Os5D5N9iHUy5hSg', '1', '4009392001201607229524847534', '1469169507wxbd2420d3a7c050d6', '20160723210858', null);
INSERT INTO `applyorder` VALUES ('oe_BRwsjMlUN_Os5D5N9iHUy5hSg', '1', '4009392001201607239591698660', '1469250574wxbd2420d3a7c050d6', '20160723131000', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469349899wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469349942wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469350020wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES ('oe_BRwmxFdaZt2bfz8g81v8YwwxY', '1', '4006352001201607289967732598', '1469686252wxbd2420d3a7c050d6', '20160729210917', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469693076wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469795165wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469795296wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469795911wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469796308wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469796618wxbd2420d3a7c050d6', '0', null);
INSERT INTO `applyorder` VALUES (' ', '0', '0', '1469800020wxbd2420d3a7c050d6', '0', null);

-- ----------------------------
-- Table structure for applyreport
-- ----------------------------
DROP TABLE IF EXISTS `applyreport`;
CREATE TABLE `applyreport` (
  `applyReportId` int(11) NOT NULL,
  `applyReportState` int(4) unsigned zerofill NOT NULL DEFAULT '0000',
  `name` varchar(20) NOT NULL,
  `idCard` varchar(20) NOT NULL,
  `school` varchar(50) DEFAULT NULL,
  `grade` int(11) NOT NULL,
  `competitionName` varchar(50) NOT NULL,
  `competitionSubject` varchar(10) NOT NULL,
  `competitionGrade` int(10) NOT NULL,
  `contectName` varchar(20) DEFAULT NULL,
  `contectPhone` varchar(20) NOT NULL,
  `out_trade_no` varchar(40) NOT NULL DEFAULT '0',
  `phoneNumber` varchar(20) NOT NULL,
  `money` int(10) NOT NULL,
  `applyReportTime` datetime NOT NULL,
  PRIMARY KEY (`idCard`,`grade`,`competitionName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of applyreport
-- ----------------------------
INSERT INTO `applyreport` VALUES ('728141052', '0001', '陈银杰', '330283198506280019', '宁波实验小学', '9', '2016年全国初中数学联赛', '数学', '2', '陈银杰', '13615888121', '1469686252wxbd2420d3a7c050d6', '13615888121', '40', '2016-07-28 14:10:52');
INSERT INTO `applyreport` VALUES ('728160436', '0000', '陆锦烨', '330621199601187758', '宁工', '3', '第十七届“中环杯”浙江省中小学生思维能力训练活动', '奥数', '1', '陆锦烨', '17855833136', '1469693076wxbd2420d3a7c050d6', '17855833136', '120', '2016-07-28 16:04:36');
INSERT INTO `applyreport` VALUES ('721162600', '0001', '小李', '330683199502065316', '宁波工程学院', '2', '2016年全国初中数学联赛', '数学', '2', '李华洋', '15728046336', '1469089560wxbd2420d3a7c050d6', '15728046336', '40', '2016-07-21 16:26:00');
INSERT INTO `applyreport` VALUES ('729214700', '0000', '郑成栋', '331002199512173118', '1', '1', '2016年全国初中数学联赛', '数学', '1', '郑成栋', '17855833180', '1469800020wxbd2420d3a7c050d6', '17855833180', '40', '2016-07-29 21:47:00');
INSERT INTO `applyreport` VALUES ('729205018', '0000', '郑成栋', '331002199512173118', 'ningbogc', '1', '第十七届“中环杯”浙江省中小学生思维能力训练活动', '奥数', '1', '17855833180', '17855833180', '1469796618wxbd2420d3a7c050d6', '17855833180', '120', '2016-07-29 20:50:18');
INSERT INTO `applyreport` VALUES ('715185440', '0000', '梁晴', '342422198510126401', '实验中学', '1', '2016年第三届世界趣味数学挑战赛', '奥数', '1', '梁', '13856981550', '1468580080wxbd2420d3a7c050d6', '13856981550', '56', '2016-07-15 18:54:40');
INSERT INTO `applyreport` VALUES ('715185512', '0000', '杜明娟', '411522199309094521', '江北实验小学', '1', '2016年全国初中数学联赛', '数学', '1', '杜明娟', '15757854729', '1468580112wxbd2420d3a7c050d6', '15757854729', '40', '2016-07-15 18:55:12');
INSERT INTO `applyreport` VALUES ('715185843', '0000', '杨宁宁', '411522199309094521', '江北实验学校', '2', '2016年第三届世界趣味数学挑战赛', '奥数', '1', '杨宁宁', '15757854729', '1468580323wxbd2420d3a7c050d6', '17757480173', '56', '2016-07-15 18:58:43');

-- ----------------------------
-- Table structure for competition
-- ----------------------------
DROP TABLE IF EXISTS `competition`;
CREATE TABLE `competition` (
  `competitionId` int(11) NOT NULL AUTO_INCREMENT,
  `competitionName` varchar(50) NOT NULL,
  `competitionSubject` char(10) NOT NULL,
  `competitionApplyStartTime` datetime NOT NULL,
  `competitionApplyEndTime` datetime NOT NULL,
  `competitionJoinerDes` varchar(255) NOT NULL,
  `competitionMoney` int(10) NOT NULL,
  `competitionType` int(4) NOT NULL,
  `competitionPrizeDes` varchar(200) NOT NULL,
  `competitionTestTimeDes` varchar(1000) NOT NULL,
  `competitionApplyAddress` text NOT NULL,
  `competitionTestAddress` varchar(200) NOT NULL,
  `competitionDetail` text,
  `competitionState` int(4) NOT NULL DEFAULT '0',
  `competitionSupportDesc` varchar(200) NOT NULL,
  `competitionForm` int(4) NOT NULL DEFAULT '1',
  `competitionGrade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`competitionId`)
) ENGINE=InnoDB AUTO_INCREMENT=2041 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of competition
-- ----------------------------
INSERT INTO `competition` VALUES ('1007', '2016年第二十一届“华罗庚金杯”少年数学邀请赛', '奥数', '2016-06-23 19:01:27', '2016-06-23 19:01:27', '小学四年级至初中九年级', '56', '0', '初赛晋级决赛	从参加初赛选手中选拔不超过30%的优胜者进入决赛决赛获奖比例	设个人一、二、三等奖，比例为不超过本市参加决赛人数的36％。其中：一等奖为不超过参加决赛人数的6%，二等奖不超过12%，三等奖不超过18%。其他奖项	获决赛一、二等奖选手的基层辅导教师荣获“优秀教练员”奖，获决赛三等奖选手的基层辅导教师荣获“优秀辅导员奖', '2016年3月20日（星期日）上午8∶30至10∶00', '宁波博文教育 </br>0574-27722770 27722780 </br>华楼街14号世纪广场A座3层0304-0305', '宁波博文教育 </br>0574-27722770 27722780 </br>华楼街14号世纪广场A座3层0304-0305', '宁波博文教育 </br>0574-27722770 27722780 </br>华楼街14号世纪广场A座3层0304-0305', '3', '资优少年', '1', '1，2');
INSERT INTO `competition` VALUES ('1009', '2016年全国初中数学联赛', '数学', '2016-07-05 15:40:05', '2016-07-05 15:40:05', '七年级至九年级', '40', '0', '评奖方式按年级设立全国初中数学联赛一、二、三等奖，奖励比例按参赛学生的10%评定全国一、二、三等奖（比例为1.5：3.5：5）设立优秀教练员奖，奖励获得全国一等奖学生的指导老师；同时，按照参赛学生的10%评定浙江省一、二、三等奖（比例为1.5：3.5：5），并按照各校参赛学生前五名的总成绩，评选出十个团体优胜奖（以学校为单位）', '2015/12/20', '宁波学智教育培训学校</br> 0574-87509151、87509152</br>  宁波环城西路南段171号（宁波学智教育培训学校）</br> 北仑区学智教育培训学校</br> 0574—86860037 / 86860057</br> 北仑区明州路500号太平洋国际大厦1508室</br> 杭州奥林教育宁波分校-启真教育</br>  0574-87735536</br>  镇海区庄市街道陈倪路450号<r> 杭州奥林教育宁波分校-启真教育</br>   0574-87735536</br>   江东区桑田路688号生产力促进中心6楼</br>  宁波资优少年</br>  0574-87629722<r>  海曙区翠柏路89号宁波工程学院1号教学楼306</br>', '（暂未定）', '\"2016年全国初中数学联赛报名通知\n\n　　根据全国初中数学联赛组委会《举办2016 年全国初中数学联赛》文件精神，将在全省举办2016 年全国初中数学联赛。浙江赛区组织委员会本着“激发中学生学习数学的兴趣，培养和选拔优秀人才”的宗旨，并结合我省具体情况，将竞赛时间作了重新调整，目的是更好地满足广大学校的实际需求。同时，继续设立七、八和九年级三个不同层次的竞赛。\n\n　　一、竞赛时间\n\n　　2015年12月20日（星期日）\n\n　　七年级：8：30—9：30\n\n　　八、九年级：一试8：30—9：30；二试9：50—11：20\n\n　　二、试题范围及题型\n\n　　2016 年全国初中数学联赛的试题范围及题型依据中国数学会制订的《初中数学竞赛大纲（2006年修订稿）》，并结合浙江省初中教学实际情况，坚持“大众化、普及型、不超纲、不超前”的原则。\n\n　　七年级竞赛试卷不设一试、二试，采用综合试卷，题型为选择题6道、填空题6道，满分100分。\n\n　　八、九年级竞赛试卷分一试和二试，第一试着重考查基础知识和基本技能，题型为选择题6题、填空题4题共70分；第二试着重考查分析问题与解决问题的能力，题型为三道解答题共70分，两试合计为140分。\n三、评奖\n\n　　评奖方式按年级设立全国初中数学联赛一、二、三等奖，奖励比例按参赛学生的10%评定全国一、二、三等奖（比例为1.5：3.5：5），并设立优秀教练员奖，奖励获得全国一等奖学生的指导老师，上述所有获奖证书由全国初中数学联赛组委会颁发。同时，按照参赛学生的10%评定浙江省一、二、三等奖（比例为1.5：3.5：5），并按照各校参赛学生前五名的总成绩，评选出十个团体优胜奖（以学校为单位），上述获奖证书由浙江赛区组织委员会颁发。\n\n　　四、日程安排\n\n　　1、报名时间2015 年11月22日截止。\n\n　　2、2015年12 月20 日下午网上公布答案。\n\n　　3、2016 年1 月3 日网上查询成绩，如有异议于1 月9 日前向组委会提出。\n\n　　4、2016 年1 月11 日公布获奖名单(网址： www.aolinedu.com )。\n\n　　五、报名方式\n\n　　宁波报名点\n\n　　报名地址：宁波环城西路南段171号（宁波学智教育培训学校）\n\n　　报名电话：0574-87509151、87509152\n\n　　北仑报名点\n\n　　报名地址：北仑区明州路500号太平洋国际大厦1508室（ 北仑区学智教育培训学校）\n\n　　报名电话：0574—86860037、 86860057\n镇海报名点\n\n　　报名地址：镇海区庄市街道陈倪路450号（杭州奥林教育宁波分校-启真教育）\n\n　　报名电话：0574-87735536\n\n　　江东报名点\n\n　　报名地址：江东区桑田路688号生产力促进中心6楼（杭州奥林教育宁波分校-启真教育）\n\n　　报名电话：0574-87735536\n\n　　海曙报名点\n\n　　报名地址：海曙区翠柏路89号宁波工程学院1号教学楼306（资优少年）\n\n　　报名电话：0574-87629722\n\n　　报名费用：40元/人\n\n　　1、宁波赛区组委会：杭州奥林教育宁波分校（启真教育）\n\n　　镇海报名点1：镇海区庄市街道陈倪路450号；          电话：0574-87735536\n\n　　江东报名点2：江东区桑田路688号生产力促进中心6楼；电话：0574-87735536\n\n　　2、合作单位：宁波资优少年\n\n　　地址：海曙区翠柏路89号宁波工程学院1号教学楼306   电话：0574-87629722\n镇海报名点\n\n　　报名地址：镇海区庄市街道陈倪路450号（杭州奥林教育宁波分校-启真教育）\n\n　　报名电话：0574-87735536\n\n　　江东报名点\n\n　　报名地址：江东区桑田路688号生产力促进中心6楼（杭州奥林教育宁波分校-启真教育）\n\n　　报名电话：0574-87735536\n\n　　海曙报名点\n\n　　报名地址：海曙区翠柏路89号宁波工程学院1号教学楼306（资优少年）\n\n　　报名电话：0574-87629722\n\n　　报名费用：40元/人\n\n　　1、宁波赛区组委会：杭州奥林教育宁波分校（启真教育）\n\n　　镇海报名点1：镇海区庄市街道陈倪路450号；          电话：0574-87735536\n\n　　江东报名点2：江东区桑田路688号生产力促进中心6楼；电话：0574-87735536\n\n　　2、合作单位：宁波资优少年\n\n　　地址：海曙区翠柏路89号宁波工程学院1号教学楼306   电话：0574-87629722\"		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n		\r\n', '1', '宁波资优少年</br> 0574-87629722</br> 海曙区翠柏路89号宁波工程学院1号教学楼306   </br>', '1', '1，2，3，4，5，6，7');
INSERT INTO `competition` VALUES ('2040', '第十七届“中环杯”浙江省中小学生思维能力训练活动', '奥数', '2016-07-24 17:58:31', '2016-10-15 17:58:54', '宁波市中小学二年级至八年级学生。', '120', '0', '二、三、四、五、六、初一、初二各年级组分别设选拔赛相关奖项及决赛一、二、三等奖。', '1、选拔赛阶段\r\n时间：2016年12月17日\r\n第一场：四年级，8：00～9：30；\r\n第二场：五年级，10：30～12：00；\r\n第三场：二年级、三年级，13：30～15：00；\r\n第四场：六年级、初一、初二，16：00～17：30。\r\n2、决赛阶段：\r\n时间：2017年3月11日\r\n第一场：二年级、四年级，9：30～11：00；\r\n第二场：三年级、五年级，12：30～14：00；\r\n第三场：六年级、初一、初二，15：00～17：00。', '资优少年\r\n报名地址：宁波工程学院西校区一号楼306室（翠柏路89号）\r\n报名地址：宁波市海曙区华楼街14号世纪广场A幢3楼A322\r\n联系电话：0574-87629722\r\n注：宁波地区其他机构报名点正在陆续开放中，具体请联系13858380521   陈老师', '暂未定', '一、 主办单位 \r\n上海市科技传播学会；\r\n上海青少年思维能力训练活动组委会。\r\n\r\n二、支持单位 \r\n联合国国际科学与和平周中国组委会。\r\n \r\n三、浙江赛区主办单位\r\n浙江省中小学思维能力训练活动组委会；\r\n宁波地区承办单位：资优少年。\r\n  \r\n\r\n 四、参加对象\r\n宁波市中小学二年级至八年级学生。\r\n \r\n 五、活动时间\r\n活动全程时间：2016年7月——2017年4月；\r\n报名截止时间：即日起——2016年10月17日。\r\n\r\n六、活动方法\r\n1、活动分小学二、三、四、五、六、初一、初二年级七个级别分别进行\r\n2、活动分选拔赛和决赛两个阶段。\r\n \r\n七、报名方法\r\n1、集体参加的学生，请联系学校负责组织的老师，由学校组织集体报名；请邮件：zhonghuanbei@foxmail.com联系相关报名事宜！\r\n2、对于学校没有组织报名的学生，可至组委会指定报名点报名（报名点详见资优少年官方网站）。\r\n注：本届活动选拔赛评奖划定宁波市统一分数线，不受报名点影响。\r\n\r\n八、报名费用\r\n初赛：参与选拔赛的学生需要交纳120元，包含报名费70元，全年报款50元，其中报名费用以组委会组织、场地租赁、监考、评审及证书制作等支出。\r\n决赛：参与总决赛的学生需要交纳参赛费70元，用以组委会组织、场地租赁、监考、评审及证书制作等支出。\r\n\r\n九、比赛时间\r\n1、选拔赛阶段\r\n时间：2016年12月17日\r\n第一场：四年级，8：00～9：30；\r\n第二场：五年级，10：30～12：00；\r\n第三场：二年级、三年级，13：30～15：00；\r\n第四场：六年级、初一、初二，16：00～17：30。\r\n2、决赛阶段：\r\n时间：2017年3月11日\r\n第一场：二年级、四年级，9：30～11：00；\r\n第二场：三年级、五年级，12：30～14：00；\r\n第三场：六年级、初一、初二，15：00～17：00。\r\n\r\n 十、竞赛内容\r\n本届思维能力训练活动内容60％可参考《青少年科技报》的思维能力训练活动版面、历届思维能力训练活动内容、思维100网上刊登的辅导资料；40％为其他内容，包括动手动脑、应用实践等。\r\n \r\n十一、奖励方法\r\n二、三、四、五、六、初一、初二各年级组分别设选拔赛相关奖项及决赛一、二、三等奖。\r\n\r\n十二、中环杯宁波地区承办单位及报名地址\r\n资优少年\r\n报名地址：宁波工程学院西校区一号楼306室（翠柏路89号）\r\n报名地址：宁波市海曙区华楼街14号世纪广场A幢3楼A322\r\n联系电话：0574-87629722\r\n注：宁波地区其他机构报名点正在陆续开放中，具体请联系13858380521   陈老师', '2', '一、 主办单位 \r\n上海市科技传播学会；\r\n上海青少年思维能力训练活动组委会。\r\n\r\n二、支持单位 \r\n联合国国际科学与和平周中国组委会。\r\n \r\n三、浙江赛区主办单位\r\n浙江省中小学思维能力训练活动组委会；\r\n宁波地区承办单位：资优少年。', '1', '2，3，4，5，6，7，8');

-- ----------------------------
-- Table structure for competitiongrade
-- ----------------------------
DROP TABLE IF EXISTS `competitiongrade`;
CREATE TABLE `competitiongrade` (
  `competitionName` varchar(255) DEFAULT NULL,
  `admissionTicket` varchar(255) NOT NULL,
  `competitionSubject` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `userGrade` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `competitionGrade` varchar(255) DEFAULT NULL,
  `promotion` varchar(255) DEFAULT NULL,
  `award` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admissionTicket`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of competitiongrade
-- ----------------------------
INSERT INTO `competitiongrade` VALUES ('2016年全国初中数学联赛', '0280670', '数学', '李泉成', '初二', '123456', '79', '很遗憾，未晋级，下次继续努力！', '', '复赛时间为：2016.3.22.9:00a.m.');
INSERT INTO `competitiongrade` VALUES ('2016年全国初中数学联赛', '0280698', '数学', '秦星海', '初二', '123463', '85', '恭喜您，成功晋级复赛！', null, '复赛时间为：2016.3.22.9:00a.m.');
INSERT INTO `competitiongrade` VALUES ('2016年全国初中数学联赛', '0280721', '数学', '金泽缘', '初二', '123456', '78', '很遗憾，未晋级，下次继续努力！', null, '复赛时间为：2016.3.22.9:00a.m.');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(255) NOT NULL,
  `phonenumber` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `iDcard` varchar(255) DEFAULT NULL,
  `contactNumber` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `motto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`phonenumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('e200a6d9-1505-432a-8603-d71536704510', '13454787677', '12345', '王雨薇', '', '', '', '', '', '', '');
INSERT INTO `user` VALUES ('bed2bec7-6a79-4673-a406-d66710f46a5b', '13615888121', '123456', '陈银杰', '宁波小学', '二年级', '330283198506280019', '', '浙江省宁波海曙区翠柏路一号', '男', '海纳百川');
INSERT INTO `user` VALUES ('8976b66b-0d30-454d-8a8c-a21c9e18f3c8', '13856981550', '123456', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('92f67f58-14ba-4aa1-8a06-e7c386680403', '15706806187', ' 406441817538', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('09795268-a8a8-41a7-88da-e5c78b83d05c', '15728046198', 'aaaa2222', '姚鑫涛', '宁波工程学院', '准大四', '', '', '', '', '');
INSERT INTO `user` VALUES ('34af6123-7fe9-49b9-9200-ec0bc3b32aa7', '15728046336', '330683', '李华洋', '', '', '', '', '', '', '');
INSERT INTO `user` VALUES ('c856ac57-5849-4ae8-9ae6-85e284ce18ed', '15728046464', '123456', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('6b034ae0-12a6-4558-82c2-c4b2e0f9190c', '15757854729', 'shzdmj99', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('1fd6e5f9-c23b-4889-8848-25b054b1d16a', '15757854954', 'ning8023', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('2afadb47-7294-4d35-8a2c-6fa19d95ca35', '17757480173', '123456', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('bab47d54-feb3-4bc3-9f6b-d60865cf30f2', '17855833136', '123456', '陆锦烨', '宁工', '初中三年级', '330621199601187758', null, '', '男', '没有');
INSERT INTO `user` VALUES ('269e8504-45b8-4af9-b2c8-b56c73939e9c', '17855833180', '1', '郑成栋', 'ningbogc', '小学一年级', '331002199512173118', null, '123', '男', '1435dsfdsg');
