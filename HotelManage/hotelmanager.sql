/*
Navicat MySQL Data Transfer

Source Server         : 主机
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : hotelmanager

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-09-24 17:39:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `addressId` int(11) NOT NULL AUTO_INCREMENT,
  `addressCity` varchar(255) NOT NULL,
  `addressPicture` varchar(255) DEFAULT NULL,
  `addressProvince` varchar(255) DEFAULT NULL,
  `addressVillage` varchar(255) DEFAULT NULL,
  `roomId` int(11) NOT NULL,
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', '宁波市', 'img/address-img/haishu.jpg', '浙江省', '海曙区', '1');
INSERT INTO `address` VALUES ('2', '宁波市', 'img/address-img/zhenhai.jpg', '浙江省', '镇海区', '4');
INSERT INTO `address` VALUES ('3', '宁波市', 'img/address-img/yinzhou.jpg', '浙江省', '鄞州区', '5');
INSERT INTO `address` VALUES ('4', '宁波市', 'img/address-img/yuyao.jpg', '浙江省', '余姚市', '6');
INSERT INTO `address` VALUES ('5', '宁波市', 'img/address-img/cixi.jpg', '浙江省', '慈溪市', '7');
INSERT INTO `address` VALUES ('6', '宁波市', 'img/address-img/fenghua.jpg', '浙江省', '奉化市', '8');
INSERT INTO `address` VALUES ('7', '宁波市', 'img/address-img/xiangshan.jpg', '浙江省', '象山县', '9');
INSERT INTO `address` VALUES ('8', '宁波市', 'img/address-img/ninghai.jpg', '浙江省', '宁海市', '10');
INSERT INTO `address` VALUES ('9', '宁波市', 'img/address-img/jiangdong.jpg', '浙江省', '江东区', '11');
INSERT INTO `address` VALUES ('10', '宁波市', 'img/address-img/jiangbei.jpg', '浙江省', '江北区', '12');
INSERT INTO `address` VALUES ('11', '宁波市', 'img/address-img/beilun.jpg', '浙江省', '北仑区', '13');

-- ----------------------------
-- Table structure for cleaner
-- ----------------------------
DROP TABLE IF EXISTS `cleaner`;
CREATE TABLE `cleaner` (
  `cleanerId` int(11) NOT NULL AUTO_INCREMENT,
  `cleanerIDNumber` varchar(255) DEFAULT NULL,
  `cleanerName` varchar(255) DEFAULT NULL,
  `cleanerPassWord` varchar(255) DEFAULT NULL,
  `cleanerPhoneNumber` varchar(255) DEFAULT NULL,
  `cleanerSex` varchar(255) DEFAULT NULL,
  `cleanerState` int(11) NOT NULL,
  PRIMARY KEY (`cleanerId`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cleaner
-- ----------------------------
INSERT INTO `cleaner` VALUES ('1', '000000000000000000', '朱钰萍', '1', '1', '女', '1');
INSERT INTO `cleaner` VALUES ('2', '000000000000000000', '刘潇君', '1', '2', '女', '1');
INSERT INTO `cleaner` VALUES ('3', '000000000000000000', '黄文盛', '123', '13401010403', '女', '1');
INSERT INTO `cleaner` VALUES ('4', '000000000000000000', '何凯妮', '123', '13401010404', '女', '0');
INSERT INTO `cleaner` VALUES ('5', '000000000000000000', '林海珍', '123', '13401010405', '女', '0');
INSERT INTO `cleaner` VALUES ('6', '000000000000000000', '王雨薇', '123', '13401010406', '女', '0');
INSERT INTO `cleaner` VALUES ('7', '000000000000000000', '金海城', '123', '13401010407', '男', '0');
INSERT INTO `cleaner` VALUES ('8', '000000000000000000', '李华洋', '123', '13401010408', '男', '0');
INSERT INTO `cleaner` VALUES ('9', '000000000000000000', '李孝文', '123', '13401010409', '男', '0');
INSERT INTO `cleaner` VALUES ('10', '000000000000000000', '方畅', '123', '13401010410', '男', '-1');
INSERT INTO `cleaner` VALUES ('11', '000000000000000000', '邵洪茂臣', '123', '13401010411', '男', '0');
INSERT INTO `cleaner` VALUES ('12', '000000000000000000', '何嘉豪', '123', '13401010412', '男', '0');
INSERT INTO `cleaner` VALUES ('13', '000000000000000000', '蔡曜镫', '123', '13401010413', '男', '0');
INSERT INTO `cleaner` VALUES ('14', '000000000000000000', '张曙永', '123', '13401010414', '男', '0');
INSERT INTO `cleaner` VALUES ('15', '000000000000000000', '程旭', '123', '13401010415', '男', '0');
INSERT INTO `cleaner` VALUES ('16', '000000000000000000', '王俊杰', '123', '13401010416', '男', '0');
INSERT INTO `cleaner` VALUES ('17', '000000000000000000', '姚鑫涛', '123', '13401010417', '男', '0');
INSERT INTO `cleaner` VALUES ('18', '000000000000000000', '金凯明', '123', '13401010418', '男', '0');
INSERT INTO `cleaner` VALUES ('19', '000000000000000000', '赵儒俊', '123', '13401010419', '男', '0');
INSERT INTO `cleaner` VALUES ('20', '000000000000000000', '方艺权', '123', '13401010420', '男', '0');
INSERT INTO `cleaner` VALUES ('21', '000000000000000000', '沈昊炜', '123', '13401010421', '男', '0');
INSERT INTO `cleaner` VALUES ('22', '000000000000000000', '沈文辉', '123', '13401010422', '男', '0');
INSERT INTO `cleaner` VALUES ('23', '000000000000000000', '杨康', '123', '13401010423', '男', '0');
INSERT INTO `cleaner` VALUES ('24', '000000000000000000', '吕存全', '123', '13401010424', '男', '0');
INSERT INTO `cleaner` VALUES ('25', '000000000000000000', '刘琦', '123', '13401010425', '男', '0');
INSERT INTO `cleaner` VALUES ('26', '000000000000000000', '应尚龙', '123', '13401010426', '男', '0');
INSERT INTO `cleaner` VALUES ('27', '000000000000000000', '钟运超', '123', '13401010427', '男', '0');
INSERT INTO `cleaner` VALUES ('28', '000000000000000000', '章皓轩', '123', '13401010428', '男', '0');
INSERT INTO `cleaner` VALUES ('29', '000000000000000000', '姚佳', '123', '13401010429', '男', '0');
INSERT INTO `cleaner` VALUES ('30', '000000000000000000', '陈海锦', '123', '13401010430', '男', '0');
INSERT INTO `cleaner` VALUES ('31', '000000000000000000', '王蛟', '123', '13401010431', '男', '0');
INSERT INTO `cleaner` VALUES ('32', '000000000000000000', '舒鑫', '123', '13401010432', '男', '0');
INSERT INTO `cleaner` VALUES ('33', '000000000000000000', '秦始玉', '123', '13401010433', '男', '0');
INSERT INTO `cleaner` VALUES ('34', '000000000000000000', '尹纯建', '123', '13401010434', '男', '0');
INSERT INTO `cleaner` VALUES ('35', '000000000000000000', '韩斌', '123', '13401010435', '男', '0');
INSERT INTO `cleaner` VALUES ('36', '000000000000000000', '吴锋', '123', '13401010436', '男', '0');
INSERT INTO `cleaner` VALUES ('37', '000000000000000000', '潘晶', '123', '13401010437', '男', '0');
INSERT INTO `cleaner` VALUES ('38', '000000000000000000', '韩超级', '123', '13406030238', '男', '0');
INSERT INTO `cleaner` VALUES ('39', '', '', '', '', null, '0');
INSERT INTO `cleaner` VALUES ('40', '', '', '', '', null, '0');
INSERT INTO `cleaner` VALUES ('41', '352352353253252352353', '你hi啊电', '21312', '21341242314', '男', '0');

-- ----------------------------
-- Table structure for cleanerworkarrange
-- ----------------------------
DROP TABLE IF EXISTS `cleanerworkarrange`;
CREATE TABLE `cleanerworkarrange` (
  `cleanerWorkId` int(11) NOT NULL AUTO_INCREMENT,
  `cleanerId` int(11) NOT NULL,
  `cleanerWorkState` int(11) NOT NULL,
  `roomId` int(11) NOT NULL,
  PRIMARY KEY (`cleanerWorkId`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cleanerworkarrange
-- ----------------------------
INSERT INTO `cleanerworkarrange` VALUES ('1', '1', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('2', '1', '0', '2');
INSERT INTO `cleanerworkarrange` VALUES ('3', '1', '0', '3');
INSERT INTO `cleanerworkarrange` VALUES ('4', '1', '0', '4');
INSERT INTO `cleanerworkarrange` VALUES ('5', '1', '0', '5');
INSERT INTO `cleanerworkarrange` VALUES ('6', '1', '0', '6');
INSERT INTO `cleanerworkarrange` VALUES ('7', '1', '0', '7');
INSERT INTO `cleanerworkarrange` VALUES ('8', '1', '0', '8');
INSERT INTO `cleanerworkarrange` VALUES ('9', '1', '0', '9');
INSERT INTO `cleanerworkarrange` VALUES ('10', '1', '0', '10');
INSERT INTO `cleanerworkarrange` VALUES ('11', '2', '0', '11');
INSERT INTO `cleanerworkarrange` VALUES ('12', '2', '0', '12');
INSERT INTO `cleanerworkarrange` VALUES ('13', '2', '0', '13');
INSERT INTO `cleanerworkarrange` VALUES ('14', '2', '0', '14');
INSERT INTO `cleanerworkarrange` VALUES ('15', '2', '0', '15');
INSERT INTO `cleanerworkarrange` VALUES ('16', '2', '0', '16');
INSERT INTO `cleanerworkarrange` VALUES ('17', '2', '0', '17');
INSERT INTO `cleanerworkarrange` VALUES ('18', '2', '0', '18');
INSERT INTO `cleanerworkarrange` VALUES ('19', '2', '0', '19');
INSERT INTO `cleanerworkarrange` VALUES ('20', '2', '0', '20');
INSERT INTO `cleanerworkarrange` VALUES ('21', '3', '0', '21');
INSERT INTO `cleanerworkarrange` VALUES ('22', '3', '0', '22');
INSERT INTO `cleanerworkarrange` VALUES ('23', '3', '0', '23');
INSERT INTO `cleanerworkarrange` VALUES ('24', '3', '0', '24');
INSERT INTO `cleanerworkarrange` VALUES ('25', '3', '0', '25');
INSERT INTO `cleanerworkarrange` VALUES ('26', '3', '0', '26');
INSERT INTO `cleanerworkarrange` VALUES ('27', '3', '0', '27');
INSERT INTO `cleanerworkarrange` VALUES ('28', '3', '0', '28');
INSERT INTO `cleanerworkarrange` VALUES ('29', '3', '0', '29');
INSERT INTO `cleanerworkarrange` VALUES ('30', '3', '0', '30');
INSERT INTO `cleanerworkarrange` VALUES ('31', '4', '0', '31');
INSERT INTO `cleanerworkarrange` VALUES ('32', '4', '0', '32');
INSERT INTO `cleanerworkarrange` VALUES ('33', '4', '0', '33');
INSERT INTO `cleanerworkarrange` VALUES ('34', '4', '0', '34');
INSERT INTO `cleanerworkarrange` VALUES ('35', '4', '0', '35');
INSERT INTO `cleanerworkarrange` VALUES ('36', '4', '0', '36');
INSERT INTO `cleanerworkarrange` VALUES ('37', '4', '0', '37');
INSERT INTO `cleanerworkarrange` VALUES ('38', '4', '0', '38');
INSERT INTO `cleanerworkarrange` VALUES ('39', '4', '0', '39');
INSERT INTO `cleanerworkarrange` VALUES ('40', '4', '0', '40');
INSERT INTO `cleanerworkarrange` VALUES ('41', '5', '0', '41');
INSERT INTO `cleanerworkarrange` VALUES ('42', '5', '0', '42');
INSERT INTO `cleanerworkarrange` VALUES ('43', '5', '0', '43');
INSERT INTO `cleanerworkarrange` VALUES ('44', '5', '0', '44');
INSERT INTO `cleanerworkarrange` VALUES ('45', '5', '0', '45');
INSERT INTO `cleanerworkarrange` VALUES ('46', '5', '0', '46');
INSERT INTO `cleanerworkarrange` VALUES ('47', '5', '0', '47');
INSERT INTO `cleanerworkarrange` VALUES ('48', '5', '0', '48');
INSERT INTO `cleanerworkarrange` VALUES ('49', '5', '0', '49');
INSERT INTO `cleanerworkarrange` VALUES ('50', '5', '0', '50');
INSERT INTO `cleanerworkarrange` VALUES ('51', '6', '0', '51');
INSERT INTO `cleanerworkarrange` VALUES ('52', '6', '0', '52');
INSERT INTO `cleanerworkarrange` VALUES ('53', '6', '0', '53');
INSERT INTO `cleanerworkarrange` VALUES ('54', '6', '0', '54');
INSERT INTO `cleanerworkarrange` VALUES ('55', '6', '0', '55');
INSERT INTO `cleanerworkarrange` VALUES ('56', '6', '0', '56');
INSERT INTO `cleanerworkarrange` VALUES ('57', '6', '0', '57');
INSERT INTO `cleanerworkarrange` VALUES ('58', '6', '0', '58');
INSERT INTO `cleanerworkarrange` VALUES ('59', '6', '0', '59');
INSERT INTO `cleanerworkarrange` VALUES ('60', '6', '0', '60');
INSERT INTO `cleanerworkarrange` VALUES ('61', '7', '0', '61');
INSERT INTO `cleanerworkarrange` VALUES ('62', '7', '0', '62');
INSERT INTO `cleanerworkarrange` VALUES ('63', '7', '0', '63');
INSERT INTO `cleanerworkarrange` VALUES ('64', '7', '0', '64');
INSERT INTO `cleanerworkarrange` VALUES ('65', '7', '0', '65');
INSERT INTO `cleanerworkarrange` VALUES ('66', '7', '0', '66');
INSERT INTO `cleanerworkarrange` VALUES ('67', '7', '0', '67');
INSERT INTO `cleanerworkarrange` VALUES ('68', '7', '0', '68');
INSERT INTO `cleanerworkarrange` VALUES ('69', '7', '0', '69');
INSERT INTO `cleanerworkarrange` VALUES ('70', '7', '0', '70');
INSERT INTO `cleanerworkarrange` VALUES ('71', '8', '0', '71');
INSERT INTO `cleanerworkarrange` VALUES ('72', '8', '0', '72');
INSERT INTO `cleanerworkarrange` VALUES ('73', '8', '0', '73');
INSERT INTO `cleanerworkarrange` VALUES ('74', '8', '0', '74');
INSERT INTO `cleanerworkarrange` VALUES ('75', '8', '0', '75');
INSERT INTO `cleanerworkarrange` VALUES ('76', '8', '0', '76');
INSERT INTO `cleanerworkarrange` VALUES ('77', '8', '0', '77');
INSERT INTO `cleanerworkarrange` VALUES ('78', '8', '0', '78');
INSERT INTO `cleanerworkarrange` VALUES ('79', '8', '0', '79');
INSERT INTO `cleanerworkarrange` VALUES ('80', '8', '0', '80');
INSERT INTO `cleanerworkarrange` VALUES ('81', '9', '0', '81');
INSERT INTO `cleanerworkarrange` VALUES ('82', '9', '0', '82');
INSERT INTO `cleanerworkarrange` VALUES ('83', '9', '0', '83');
INSERT INTO `cleanerworkarrange` VALUES ('84', '9', '0', '84');
INSERT INTO `cleanerworkarrange` VALUES ('85', '9', '0', '85');
INSERT INTO `cleanerworkarrange` VALUES ('86', '9', '0', '86');
INSERT INTO `cleanerworkarrange` VALUES ('87', '9', '0', '87');
INSERT INTO `cleanerworkarrange` VALUES ('88', '9', '0', '88');
INSERT INTO `cleanerworkarrange` VALUES ('89', '9', '0', '89');
INSERT INTO `cleanerworkarrange` VALUES ('90', '9', '0', '90');
INSERT INTO `cleanerworkarrange` VALUES ('91', '10', '0', '91');
INSERT INTO `cleanerworkarrange` VALUES ('92', '10', '0', '92');
INSERT INTO `cleanerworkarrange` VALUES ('93', '10', '0', '93');
INSERT INTO `cleanerworkarrange` VALUES ('94', '10', '0', '94');
INSERT INTO `cleanerworkarrange` VALUES ('95', '10', '0', '95');
INSERT INTO `cleanerworkarrange` VALUES ('96', '10', '0', '96');
INSERT INTO `cleanerworkarrange` VALUES ('97', '10', '0', '97');
INSERT INTO `cleanerworkarrange` VALUES ('98', '10', '0', '98');
INSERT INTO `cleanerworkarrange` VALUES ('99', '10', '0', '99');
INSERT INTO `cleanerworkarrange` VALUES ('100', '10', '0', '100');
INSERT INTO `cleanerworkarrange` VALUES ('101', '2', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('102', '2', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('103', '2', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('104', '2', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('105', '2', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('106', '3', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('107', '2', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('108', '2', '0', '0');
INSERT INTO `cleanerworkarrange` VALUES ('109', '2', '0', '0');
INSERT INTO `cleanerworkarrange` VALUES ('110', '3', '0', '111');
INSERT INTO `cleanerworkarrange` VALUES ('111', '2', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('112', '4', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('113', '3', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('114', '3', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('115', '3', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('116', '1', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('117', '2', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('118', '1', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('119', '2', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('120', '2', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('121', '2', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('122', '2', '0', '1');
INSERT INTO `cleanerworkarrange` VALUES ('123', '13', '0', '1');

-- ----------------------------
-- Table structure for cleaningrecord
-- ----------------------------
DROP TABLE IF EXISTS `cleaningrecord`;
CREATE TABLE `cleaningrecord` (
  `cleaningId` int(11) NOT NULL AUTO_INCREMENT,
  `cleanerId` int(11) NOT NULL,
  `cleaningTime` varchar(255) DEFAULT NULL,
  `roomId` int(11) NOT NULL,
  PRIMARY KEY (`cleaningId`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cleaningrecord
-- ----------------------------
INSERT INTO `cleaningrecord` VALUES ('1', '1', '2014-12-14', '1');
INSERT INTO `cleaningrecord` VALUES ('2', '1', '2014-01-10', '2');
INSERT INTO `cleaningrecord` VALUES ('3', '1', '2014-01-11', '3');
INSERT INTO `cleaningrecord` VALUES ('4', '1', '2014-01-12', '4');
INSERT INTO `cleaningrecord` VALUES ('5', '1', '2014-01-13', '5');
INSERT INTO `cleaningrecord` VALUES ('6', '1', '2014-01-14', '6');
INSERT INTO `cleaningrecord` VALUES ('7', '1', '2014-01-15', '7');
INSERT INTO `cleaningrecord` VALUES ('8', '1', '2014-01-16', '8');
INSERT INTO `cleaningrecord` VALUES ('9', '1', '2014-01-17', '9');
INSERT INTO `cleaningrecord` VALUES ('10', '1', '2014-01-18', '10');
INSERT INTO `cleaningrecord` VALUES ('11', '2', '2014-01-19', '11');
INSERT INTO `cleaningrecord` VALUES ('12', '2', '2014-01-20', '12');
INSERT INTO `cleaningrecord` VALUES ('13', '2', '2014-01-21', '13');
INSERT INTO `cleaningrecord` VALUES ('14', '2', '2014-01-22', '14');
INSERT INTO `cleaningrecord` VALUES ('15', '2', '2014-01-23', '15');
INSERT INTO `cleaningrecord` VALUES ('16', '2', '2014-01-24', '16');
INSERT INTO `cleaningrecord` VALUES ('17', '2', '2014-01-25', '17');
INSERT INTO `cleaningrecord` VALUES ('18', '2', '2014-01-26', '18');
INSERT INTO `cleaningrecord` VALUES ('19', '2', '2014-01-27', '19');
INSERT INTO `cleaningrecord` VALUES ('20', '2', '2014-01-28', '20');
INSERT INTO `cleaningrecord` VALUES ('21', '3', '2014-01-29', '21');
INSERT INTO `cleaningrecord` VALUES ('22', '3', '2014-01-30', '22');
INSERT INTO `cleaningrecord` VALUES ('23', '3', '2014-01-31', '23');
INSERT INTO `cleaningrecord` VALUES ('24', '3', '2014-02-01', '24');
INSERT INTO `cleaningrecord` VALUES ('25', '3', '2014-02-02', '25');
INSERT INTO `cleaningrecord` VALUES ('26', '3', '2014-02-03', '26');
INSERT INTO `cleaningrecord` VALUES ('27', '3', '2014-02-04', '27');
INSERT INTO `cleaningrecord` VALUES ('28', '3', '2014-02-05', '28');
INSERT INTO `cleaningrecord` VALUES ('29', '3', '2014-02-06', '29');
INSERT INTO `cleaningrecord` VALUES ('30', '3', '2014-02-07', '30');
INSERT INTO `cleaningrecord` VALUES ('31', '4', '2014-02-08', '31');
INSERT INTO `cleaningrecord` VALUES ('32', '4', '2014-02-09', '32');
INSERT INTO `cleaningrecord` VALUES ('33', '4', '2014-02-10', '33');
INSERT INTO `cleaningrecord` VALUES ('34', '4', '2014-02-11', '34');
INSERT INTO `cleaningrecord` VALUES ('35', '4', '2014-02-12', '35');
INSERT INTO `cleaningrecord` VALUES ('36', '4', '2014-02-13', '36');
INSERT INTO `cleaningrecord` VALUES ('37', '4', '2014-02-14', '37');
INSERT INTO `cleaningrecord` VALUES ('38', '4', '2014-02-15', '38');
INSERT INTO `cleaningrecord` VALUES ('39', '4', '2014-02-16', '39');
INSERT INTO `cleaningrecord` VALUES ('40', '4', '2014-02-17', '40');
INSERT INTO `cleaningrecord` VALUES ('41', '5', '2014-02-18', '41');
INSERT INTO `cleaningrecord` VALUES ('42', '5', '2014-02-19', '42');
INSERT INTO `cleaningrecord` VALUES ('43', '5', '2014-02-20', '43');
INSERT INTO `cleaningrecord` VALUES ('44', '5', '2014-02-21', '44');
INSERT INTO `cleaningrecord` VALUES ('45', '5', '2014-02-22', '45');
INSERT INTO `cleaningrecord` VALUES ('46', '5', '2014-02-23', '46');
INSERT INTO `cleaningrecord` VALUES ('47', '5', '2014-02-24', '47');
INSERT INTO `cleaningrecord` VALUES ('48', '5', '2014-02-25', '48');
INSERT INTO `cleaningrecord` VALUES ('49', '5', '2014-02-26', '49');
INSERT INTO `cleaningrecord` VALUES ('50', '5', '2014-02-27', '50');
INSERT INTO `cleaningrecord` VALUES ('51', '6', '2014-02-28', '51');
INSERT INTO `cleaningrecord` VALUES ('52', '6', '2014-03-01', '52');
INSERT INTO `cleaningrecord` VALUES ('53', '6', '2014-03-02', '53');
INSERT INTO `cleaningrecord` VALUES ('54', '6', '2014-03-03', '54');
INSERT INTO `cleaningrecord` VALUES ('55', '6', '2014-03-04', '55');
INSERT INTO `cleaningrecord` VALUES ('56', '6', '2014-03-05', '56');
INSERT INTO `cleaningrecord` VALUES ('57', '6', '2014-03-06', '57');
INSERT INTO `cleaningrecord` VALUES ('58', '6', '2014-03-07', '58');
INSERT INTO `cleaningrecord` VALUES ('59', '6', '2014-03-08', '59');
INSERT INTO `cleaningrecord` VALUES ('60', '6', '2014-03-09', '60');
INSERT INTO `cleaningrecord` VALUES ('61', '7', '2014-03-10', '61');
INSERT INTO `cleaningrecord` VALUES ('62', '7', '2014-03-11', '62');
INSERT INTO `cleaningrecord` VALUES ('63', '7', '2014-03-12', '63');
INSERT INTO `cleaningrecord` VALUES ('64', '7', '2014-03-13', '64');
INSERT INTO `cleaningrecord` VALUES ('65', '7', '2014-03-14', '65');
INSERT INTO `cleaningrecord` VALUES ('66', '7', '2014-03-15', '66');
INSERT INTO `cleaningrecord` VALUES ('67', '7', '2014-03-16', '67');
INSERT INTO `cleaningrecord` VALUES ('68', '7', '2014-03-17', '68');
INSERT INTO `cleaningrecord` VALUES ('69', '7', '2014-03-18', '69');
INSERT INTO `cleaningrecord` VALUES ('70', '7', '2014-03-19', '70');
INSERT INTO `cleaningrecord` VALUES ('71', '8', '2014-03-20', '71');
INSERT INTO `cleaningrecord` VALUES ('72', '8', '2014-03-21', '72');
INSERT INTO `cleaningrecord` VALUES ('73', '8', '2014-03-22', '73');
INSERT INTO `cleaningrecord` VALUES ('74', '8', '2014-03-23', '74');
INSERT INTO `cleaningrecord` VALUES ('75', '8', '2014-03-24', '75');
INSERT INTO `cleaningrecord` VALUES ('76', '8', '2014-03-25', '76');
INSERT INTO `cleaningrecord` VALUES ('77', '8', '2014-03-26', '77');
INSERT INTO `cleaningrecord` VALUES ('78', '8', '2014-03-27', '78');
INSERT INTO `cleaningrecord` VALUES ('79', '8', '2014-03-28', '79');
INSERT INTO `cleaningrecord` VALUES ('80', '8', '2014-03-29', '80');
INSERT INTO `cleaningrecord` VALUES ('81', '9', '2014-03-30', '81');
INSERT INTO `cleaningrecord` VALUES ('82', '9', '2014-03-31', '82');
INSERT INTO `cleaningrecord` VALUES ('83', '9', '2014-04-01', '83');
INSERT INTO `cleaningrecord` VALUES ('84', '9', '2014-04-02', '84');
INSERT INTO `cleaningrecord` VALUES ('85', '9', '2014-04-03', '85');
INSERT INTO `cleaningrecord` VALUES ('86', '9', '2014-04-04', '86');
INSERT INTO `cleaningrecord` VALUES ('87', '9', '2014-04-05', '87');
INSERT INTO `cleaningrecord` VALUES ('88', '9', '2014-04-06', '88');
INSERT INTO `cleaningrecord` VALUES ('89', '9', '2014-04-07', '89');
INSERT INTO `cleaningrecord` VALUES ('90', '9', '2014-04-08', '90');
INSERT INTO `cleaningrecord` VALUES ('91', '10', '2014-04-09', '91');
INSERT INTO `cleaningrecord` VALUES ('92', '10', '2014-04-10', '92');
INSERT INTO `cleaningrecord` VALUES ('93', '10', '2014-04-11', '93');
INSERT INTO `cleaningrecord` VALUES ('94', '10', '2014-04-12', '94');
INSERT INTO `cleaningrecord` VALUES ('95', '10', '2014-04-13', '95');
INSERT INTO `cleaningrecord` VALUES ('96', '10', '2014-04-14', '96');
INSERT INTO `cleaningrecord` VALUES ('97', '10', '2014-04-15', '97');
INSERT INTO `cleaningrecord` VALUES ('98', '10', '2014-04-16', '98');
INSERT INTO `cleaningrecord` VALUES ('99', '10', '2014-04-17', '99');
INSERT INTO `cleaningrecord` VALUES ('100', '10', '2014-04-18', '100');
INSERT INTO `cleaningrecord` VALUES ('101', '1', '2015-12-02 18:34:45', '1');
INSERT INTO `cleaningrecord` VALUES ('102', '1', '2015-12-02 18:35:29', '1');
INSERT INTO `cleaningrecord` VALUES ('103', '1', '2015-12-02 18:35:52', '1');
INSERT INTO `cleaningrecord` VALUES ('104', '1', '2015-12-02 18:36:04', '1');
INSERT INTO `cleaningrecord` VALUES ('105', '1', '2015-12-02 18:44:04', '1');
INSERT INTO `cleaningrecord` VALUES ('106', '1', '2015-12-02 18:44:19', '1');
INSERT INTO `cleaningrecord` VALUES ('107', '1', '2015-12-02 18:50:15', '1');
INSERT INTO `cleaningrecord` VALUES ('108', '1', '2015-12-02 18:52:38', '1');
INSERT INTO `cleaningrecord` VALUES ('109', '1', '2015-12-02 18:53:21', '1');
INSERT INTO `cleaningrecord` VALUES ('110', '1', '2015-12-02 19:01:45', '1');
INSERT INTO `cleaningrecord` VALUES ('111', '1', '2015-12-02 19:44:22', '1');
INSERT INTO `cleaningrecord` VALUES ('112', '1', '2015-12-02 19:44:46', '1');
INSERT INTO `cleaningrecord` VALUES ('113', '1', '2015-12-02 22:27:13', '1');
INSERT INTO `cleaningrecord` VALUES ('114', '1', '2015-12-02 22:28:52', '1');
INSERT INTO `cleaningrecord` VALUES ('115', '1', '2015-12-02 22:29:22', '1');
INSERT INTO `cleaningrecord` VALUES ('116', '1', '2015-12-02 22:29:51', '1');
INSERT INTO `cleaningrecord` VALUES ('117', '1', '2015-12-02 22:30:30', '1');
INSERT INTO `cleaningrecord` VALUES ('118', '1', '2015-12-02 22:32:13', '1');
INSERT INTO `cleaningrecord` VALUES ('119', '1', '2015-12-02 22:34:02', '1');

-- ----------------------------
-- Table structure for consumptionrecord
-- ----------------------------
DROP TABLE IF EXISTS `consumptionrecord`;
CREATE TABLE `consumptionrecord` (
  `consumptionId` int(11) NOT NULL AUTO_INCREMENT,
  `consumptionAddress` varchar(255) DEFAULT NULL,
  `consumptionIDNumber` varchar(255) DEFAULT NULL,
  `consumptionMoney` int(11) NOT NULL,
  `consumptionName` varchar(255) DEFAULT NULL,
  `consumptionPhon` varchar(255) DEFAULT NULL,
  `consumptionTime` varchar(255) DEFAULT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`consumptionId`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consumptionrecord
-- ----------------------------
INSERT INTO `consumptionrecord` VALUES ('1', '宁波印象城', '111111111111111000', '10', '金超', '11401090103', '2013-01-02', '1');
INSERT INTO `consumptionrecord` VALUES ('2', '宁波印象城', '111111111111111000', '11', '曲士坤', '11401090104', '2013-01-03', '2');
INSERT INTO `consumptionrecord` VALUES ('3', '宁波印象城', '111111111111111000', '12', '张俊钺', '11401090109', '2013-01-04', '3');
INSERT INTO `consumptionrecord` VALUES ('4', '宁波印象城', '111111111111111000', '13', '肖佳杰', '11401090110', '2013-01-05', '4');
INSERT INTO `consumptionrecord` VALUES ('5', '宁波印象城', '111111111111111000', '14', '方琦', '11401090111', '2013-01-06', '5');
INSERT INTO `consumptionrecord` VALUES ('6', '宁波印象城', '111111111111111000', '15', '张曦', '11401090114', '2013-01-07', '6');
INSERT INTO `consumptionrecord` VALUES ('7', '宁波印象城', '111111111111111000', '16', '唐峰', '11401090117', '2013-01-08', '7');
INSERT INTO `consumptionrecord` VALUES ('8', '宁波印象城', '111111111111111000', '17', '诸宏杰', '11401090124', '2013-01-09', '8');
INSERT INTO `consumptionrecord` VALUES ('9', '宁波印象城', '111111111111111000', '18', '陆焯强', '11401090130', '2013-01-10', '9');
INSERT INTO `consumptionrecord` VALUES ('10', '宁波印象城', '111111111111111000', '19', '许嘉恒', '11401090135', '2013-01-11', '10');
INSERT INTO `consumptionrecord` VALUES ('11', '宁波印象城', '111111111111111000', '20', '李松林', '11401090139', '2013-01-12', '11');
INSERT INTO `consumptionrecord` VALUES ('12', '宁波印象城', '111111111111111000', '21', '刘宇航', '11401090204', '2013-01-13', '12');
INSERT INTO `consumptionrecord` VALUES ('13', '宁波印象城', '111111111111111000', '22', '章迪', '11401090205', '2013-01-14', '13');
INSERT INTO `consumptionrecord` VALUES ('14', '宁波印象城', '111111111111111000', '23', '陈汉标', '11401090206', '2013-01-15', '14');
INSERT INTO `consumptionrecord` VALUES ('15', '宁波印象城', '111111111111111000', '24', '何炎丰', '11401090207', '2013-01-16', '15');
INSERT INTO `consumptionrecord` VALUES ('16', '宁波印象城', '111111111111111000', '25', '王若晨', '11401090208', '2013-01-17', '16');
INSERT INTO `consumptionrecord` VALUES ('17', '宁波印象城', '111111111111111000', '26', '王方龙', '11401090209', '2013-01-18', '17');
INSERT INTO `consumptionrecord` VALUES ('18', '宁波印象城', '111111111111111000', '27', '包宇炀', '11401090210', '2013-01-19', '18');
INSERT INTO `consumptionrecord` VALUES ('19', '宁波印象城', '111111111111111000', '28', '包跃鸿', '11401090211', '2013-01-20', '19');
INSERT INTO `consumptionrecord` VALUES ('20', '宁波印象城', '111111111111111000', '29', '黄文杰', '11401090204', '2013-01-21', '20');
INSERT INTO `consumptionrecord` VALUES ('21', '宁波印象城', '111111111111111000', '30', '杨洋', '11401090205', '2013-01-22', '21');
INSERT INTO `consumptionrecord` VALUES ('22', '宁波印象城', '111111111111111000', '31', '王春荣', '11401090206', '2013-01-23', '22');
INSERT INTO `consumptionrecord` VALUES ('23', '宁波印象城', '111111111111111000', '32', '李国强', '11401090207', '2013-01-24', '23');
INSERT INTO `consumptionrecord` VALUES ('24', '宁波印象城', '111111111111111000', '33', '林仙豪', '11401090208', '2013-01-25', '24');
INSERT INTO `consumptionrecord` VALUES ('25', '宁波印象城', '111111111111111000', '34', '丁晓靖', '11401090209', '2013-01-26', '25');
INSERT INTO `consumptionrecord` VALUES ('26', '宁波印象城', '111111111111111000', '35', '张宏武', '11401090210', '2013-01-27', '26');
INSERT INTO `consumptionrecord` VALUES ('27', '宁波印象城', '111111111111111000', '36', '岑致远', '11401090211', '2013-01-28', '27');
INSERT INTO `consumptionrecord` VALUES ('28', '宁波印象城', '111111111111111000', '37', '冯立', '11401090204', '2013-01-29', '28');
INSERT INTO `consumptionrecord` VALUES ('29', '宁波印象城', '111111111111111000', '38', '吴敏', '11401090205', '2013-01-30', '29');
INSERT INTO `consumptionrecord` VALUES ('30', '宁波印象城', '111111111111111000', '39', '吴昊腾', '11401090206', '2013-01-31', '30');
INSERT INTO `consumptionrecord` VALUES ('31', '宁波印象城', '111111111111111000', '40', '杨勇锋', '11401090207', '2013-02-01', '31');
INSERT INTO `consumptionrecord` VALUES ('32', '宁波印象城', '111111111111111000', '41', '戴悦翰', '11401090208', '2013-02-02', '32');
INSERT INTO `consumptionrecord` VALUES ('33', '宁波印象城', '111111111111111000', '42', '冯小强', '11401090209', '2013-02-03', '33');
INSERT INTO `consumptionrecord` VALUES ('34', '宁波印象城', '111111111111111000', '43', '吴黄晨', '11401090210', '2013-02-04', '34');
INSERT INTO `consumptionrecord` VALUES ('35', '宁波印象城', '111111111111111000', '44', '马庆云', '11401090211', '2013-02-05', '35');
INSERT INTO `consumptionrecord` VALUES ('36', '宁波印象城', '111111111111111000', '45', '章梦姣', '11401090204', '2013-02-06', '36');
INSERT INTO `consumptionrecord` VALUES ('37', '宁波印象城', '111111111111111000', '46', '代超', '11401090205', '2013-02-07', '37');
INSERT INTO `consumptionrecord` VALUES ('38', '宁波印象城', '111111111111111000', '47', '沈炆', '11401090206', '2013-02-08', '38');
INSERT INTO `consumptionrecord` VALUES ('39', '宁波印象城', '111111111111111000', '48', '漆慧鹏', '11401090207', '2013-02-09', '39');
INSERT INTO `consumptionrecord` VALUES ('40', '宁波印象城', '111111111111111000', '49', '颜富铙', '11401090208', '2013-02-10', '40');
INSERT INTO `consumptionrecord` VALUES ('41', '宁波印象城', '111111111111111000', '50', '徐佳栋', '11401090209', '2013-02-11', '41');
INSERT INTO `consumptionrecord` VALUES ('42', '宁波印象城', '111111111111111000', '51', '胡军天', '11401090210', '2013-02-12', '42');
INSERT INTO `consumptionrecord` VALUES ('43', '宁波印象城', '111111111111111000', '52', '章培超', '11401090211', '2013-02-13', '43');
INSERT INTO `consumptionrecord` VALUES ('44', '宁波印象城', '111111111111111000', '53', '叶林华', '11401090204', '2013-02-14', '44');
INSERT INTO `consumptionrecord` VALUES ('45', '宁波印象城', '111111111111111000', '54', '罗玉贝', '11401090205', '2013-02-15', '45');
INSERT INTO `consumptionrecord` VALUES ('46', '宁波印象城', '111111111111111000', '55', '费晓亮', '11401090206', '2013-02-16', '46');
INSERT INTO `consumptionrecord` VALUES ('47', '宁波印象城', '111111111111111000', '56', '俞播峰', '11401090207', '2013-02-17', '47');
INSERT INTO `consumptionrecord` VALUES ('48', '宁波印象城', '111111111111111000', '57', '吴泽伟', '11401090208', '2013-02-18', '48');
INSERT INTO `consumptionrecord` VALUES ('49', '宁波印象城', '111111111111111000', '58', '徐恩慧', '11401090209', '2013-02-19', '49');
INSERT INTO `consumptionrecord` VALUES ('50', '宁波印象城', '111111111111111000', '59', '张斌', '11401090210', '2013-02-20', '50');
INSERT INTO `consumptionrecord` VALUES ('51', '宁波印象城', '111111111111111000', '60', '张泽琪', '11401090211', '2013-02-21', '51');
INSERT INTO `consumptionrecord` VALUES ('52', '宁波印象城', '111111111111111000', '61', '黄约沙', '11401090204', '2013-02-22', '52');
INSERT INTO `consumptionrecord` VALUES ('53', '宁波印象城', '111111111111111000', '62', '吴建浩', '11401090205', '2013-02-23', '53');
INSERT INTO `consumptionrecord` VALUES ('54', '宁波印象城', '111111111111111000', '63', '陈剑', '11401090206', '2013-02-24', '54');
INSERT INTO `consumptionrecord` VALUES ('55', '宁波印象城', '111111111111111000', '64', '吴瑞俊', '11401090207', '2013-02-25', '55');
INSERT INTO `consumptionrecord` VALUES ('56', '宁波印象城', '111111111111111000', '65', '张泉', '11401090208', '2013-02-26', '56');
INSERT INTO `consumptionrecord` VALUES ('57', '宁波印象城', '111111111111111000', '66', '罗鹏', '11401090209', '2013-02-27', '57');
INSERT INTO `consumptionrecord` VALUES ('58', '宁波印象城', '111111111111111000', '67', '杨杰', '11401090210', '2013-02-28', '58');
INSERT INTO `consumptionrecord` VALUES ('59', '宁波印象城', '111111111111111000', '68', '汤蓓', '11401090211', '2013-03-01', '59');
INSERT INTO `consumptionrecord` VALUES ('60', '宁波印象城', '111111111111111000', '69', '蓝柔雪', '11401090204', '2013-03-02', '60');
INSERT INTO `consumptionrecord` VALUES ('61', '宁波印象城', '111111111111111000', '70', '颜法廷', '11401090205', '2013-03-03', '61');
INSERT INTO `consumptionrecord` VALUES ('62', '宁波印象城', '111111111111111000', '71', '谢文龙', '11401090206', '2013-03-04', '62');
INSERT INTO `consumptionrecord` VALUES ('63', '宁波印象城', '111111111111111000', '72', '李炊', '11401090207', '2013-03-05', '63');
INSERT INTO `consumptionrecord` VALUES ('64', '宁波印象城', '111111111111111000', '73', '张宏', '11401090208', '2013-03-06', '64');
INSERT INTO `consumptionrecord` VALUES ('65', '宁波印象城', '111111111111111000', '74', '陈凯华', '11401090209', '2013-03-07', '65');
INSERT INTO `consumptionrecord` VALUES ('66', '宁波印象城', '111111111111111000', '75', '吴建明', '11401090210', '2013-03-08', '66');
INSERT INTO `consumptionrecord` VALUES ('67', '宁波印象城', '111111111111111000', '76', '吴建标', '11401090211', '2013-03-09', '67');
INSERT INTO `consumptionrecord` VALUES ('68', '宁波印象城', '111111111111111000', '77', '陈欢', '11401090204', '2013-03-10', '68');
INSERT INTO `consumptionrecord` VALUES ('69', '宁波印象城', '111111111111111000', '78', '曹聪聪', '11401090205', '2013-03-11', '69');
INSERT INTO `consumptionrecord` VALUES ('70', '宁波印象城', '111111111111111000', '79', '李炜俊', '11401090206', '2013-03-12', '70');
INSERT INTO `consumptionrecord` VALUES ('71', '宁波印象城', '111111111111111000', '80', '孙煜杰', '11401090207', '2013-03-13', '71');
INSERT INTO `consumptionrecord` VALUES ('72', '宁波印象城', '111111111111111000', '81', '张垚', '11401090208', '2013-03-14', '72');
INSERT INTO `consumptionrecord` VALUES ('73', '宁波印象城', '111111111111111000', '82', '顾阳宇', '11401090209', '2013-03-15', '73');
INSERT INTO `consumptionrecord` VALUES ('74', '宁波印象城', '111111111111111000', '83', '陈俊羽', '11401090210', '2013-03-16', '74');
INSERT INTO `consumptionrecord` VALUES ('75', '宁波印象城', '111111111111111000', '84', '林先娜', '11401090211', '2013-03-17', '75');
INSERT INTO `consumptionrecord` VALUES ('76', '宁波印象城', '111111111111111000', '85', '刘胜男', '11401090204', '2013-03-18', '76');
INSERT INTO `consumptionrecord` VALUES ('77', '宁波印象城', '111111111111111000', '86', '张子腾', '11401090205', '2013-03-19', '77');
INSERT INTO `consumptionrecord` VALUES ('78', '宁波印象城', '111111111111111000', '87', '沈增涛', '11401090206', '2013-03-20', '78');
INSERT INTO `consumptionrecord` VALUES ('79', '宁波印象城', '111111111111111000', '88', '陈振伟', '11401090207', '2013-03-21', '79');
INSERT INTO `consumptionrecord` VALUES ('80', '宁波印象城', '111111111111111000', '89', '包年晖', '11401090208', '2013-03-22', '80');
INSERT INTO `consumptionrecord` VALUES ('81', '宁波印象城', '111111111111111000', '90', '邵润润', '11401090209', '2013-03-23', '81');
INSERT INTO `consumptionrecord` VALUES ('82', '宁波印象城', '111111111111111000', '91', '张文涛', '11401090210', '2013-03-24', '82');
INSERT INTO `consumptionrecord` VALUES ('83', '宁波印象城', '111111111111111000', '92', '陈泓鸣', '11401090211', '2013-03-25', '83');
INSERT INTO `consumptionrecord` VALUES ('84', '宁波印象城', '111111111111111000', '93', '张杨坚', '11401090204', '2013-03-26', '84');
INSERT INTO `consumptionrecord` VALUES ('85', '宁波印象城', '111111111111111000', '94', '王磊', '11401090205', '2013-03-27', '85');
INSERT INTO `consumptionrecord` VALUES ('86', '宁波印象城', '111111111111111000', '95', '朱昊', '11401090206', '2013-03-28', '86');
INSERT INTO `consumptionrecord` VALUES ('87', '宁波印象城', '111111111111111000', '96', '王昱剑', '11401090207', '2013-03-29', '87');
INSERT INTO `consumptionrecord` VALUES ('88', '宁波印象城', '111111111111111000', '97', '蓝峥', '11401090208', '2013-03-30', '88');
INSERT INTO `consumptionrecord` VALUES ('89', '宁波印象城', '111111111111111000', '98', '黄文溪', '11401090209', '2013-03-31', '89');
INSERT INTO `consumptionrecord` VALUES ('90', '宁波印象城', '111111111111111000', '99', '范泳琦', '11401090210', '2013-04-01', '90');
INSERT INTO `consumptionrecord` VALUES ('91', '宁波印象城', '111111111111111000', '100', '戴熠赟', '11401090211', '2013-04-02', '91');
INSERT INTO `consumptionrecord` VALUES ('92', '宁波印象城', '111111111111111000', '101', '贾俊超', '11401090204', '2013-04-03', '92');
INSERT INTO `consumptionrecord` VALUES ('93', '宁波印象城', '111111111111111000', '102', '吴新伟', '11401090205', '2013-04-04', '93');
INSERT INTO `consumptionrecord` VALUES ('94', '宁波印象城', '111111111111111000', '103', '倪辉辉', '11401090206', '2013-04-05', '94');
INSERT INTO `consumptionrecord` VALUES ('95', '宁波印象城', '111111111111111000', '104', '顾贤听', '11401090207', '2013-04-06', '95');
INSERT INTO `consumptionrecord` VALUES ('96', '宁波印象城', '111111111111111000', '105', '邱亿', '11401090208', '2013-04-07', '96');
INSERT INTO `consumptionrecord` VALUES ('97', '宁波印象城', '111111111111111000', '106', '许阳峰', '11401090209', '2013-04-08', '97');
INSERT INTO `consumptionrecord` VALUES ('98', '宁波印象城', '111111111111111000', '107', '韩焱', '11401090210', '2013-04-09', '98');
INSERT INTO `consumptionrecord` VALUES ('99', '宁波印象城', '111111111111111000', '108', '郑邦杰', '11401090211', '2013-04-10', '99');
INSERT INTO `consumptionrecord` VALUES ('100', '宁波印象城', '111111111111111000', '109', '陈钊', '11401090204', '2013-04-11', '100');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `managerId` int(11) NOT NULL AUTO_INCREMENT,
  `managerAccount` varchar(255) DEFAULT NULL,
  `managerPassword` varchar(255) DEFAULT NULL,
  `managerState` int(11) NOT NULL,
  PRIMARY KEY (`managerId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', '123', '123', '1');

-- ----------------------------
-- Table structure for ordertable
-- ----------------------------
DROP TABLE IF EXISTS `ordertable`;
CREATE TABLE `ordertable` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `orderCheckinTime` varchar(255) DEFAULT NULL,
  `orderCheckoutTime` varchar(255) DEFAULT NULL,
  `orderMoney` int(11) NOT NULL,
  `orderState` int(11) NOT NULL,
  `orderStayinDay` int(11) NOT NULL,
  `orderStayinPeopleNumber` int(11) NOT NULL,
  `orderTime` varchar(255) DEFAULT NULL,
  `roomId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `orderUserIDnumber` varchar(255) DEFAULT NULL,
  `orderUsername` varchar(255) DEFAULT NULL,
  `orderUserphon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordertable
-- ----------------------------
INSERT INTO `ordertable` VALUES ('1', '2013-01-02', '2013-05-05', '9840', '1', '123', '2', '2013-01-02', '1', '1', '000000000000000000', '金超', '11401090103');
INSERT INTO `ordertable` VALUES ('2', '2013-01-03', '2013-01-05', '160', '2', '2', '2', '2013-01-03', '1', '2', '000000000000000000', '曲士坤', '11401090104');
INSERT INTO `ordertable` VALUES ('3', '2013-01-04', '2013-01-06', '160', '2', '2', '2', '2013-01-04', '1', '3', '000000000000000000', '张俊钺', '11401090109');
INSERT INTO `ordertable` VALUES ('4', '2013-01-05', '2013-01-07', '160', '2', '2', '2', '2013-01-05', '1', '4', '000000000000000000', '肖佳杰', '11401090110');
INSERT INTO `ordertable` VALUES ('5', '2013-01-06', '2013-01-08', '160', '2', '2', '2', '2013-01-06', '1', '5', '000000000000000000', '方琦', '11401090111');
INSERT INTO `ordertable` VALUES ('6', '2013-01-07', '2013-01-09', '160', '2', '2', '2', '2013-01-07', '1', '6', '000000000000000000', '张曦', '11401090114');
INSERT INTO `ordertable` VALUES ('7', '2013-01-08', '2013-01-10', '160', '2', '2', '2', '2013-01-08', '1', '7', '000000000000000000', '唐峰', '11401090117');
INSERT INTO `ordertable` VALUES ('8', '2013-01-09', '2013-01-11', '160', '2', '2', '2', '2013-01-09', '1', '8', '000000000000000000', '诸宏杰', '11401090124');
INSERT INTO `ordertable` VALUES ('9', '2013-01-10', '2013-01-12', '160', '2', '2', '2', '2013-01-10', '1', '9', '000000000000000000', '陆焯强', '11401090130');
INSERT INTO `ordertable` VALUES ('10', '2013-01-11', '2013-01-13', '160', '2', '2', '2', '2013-01-11', '1', '10', '000000000000000000', '许嘉恒', '11401090135');
INSERT INTO `ordertable` VALUES ('11', '2013-01-12', '2013-01-14', '160', '2', '2', '2', '2013-01-12', '1', '11', '000000000000000000', '李松林', '11401090139');
INSERT INTO `ordertable` VALUES ('12', '2013-01-13', '2013-01-15', '160', '2', '2', '2', '2013-01-13', '1', '12', '000000000000000000', '刘宇航', '11401090204');
INSERT INTO `ordertable` VALUES ('13', '2013-01-14', '2013-01-16', '360', '2', '2', '2', '2013-01-14', '2', '13', '000000000000000000', '章迪', '11401090207');
INSERT INTO `ordertable` VALUES ('14', '2013-01-15', '2013-01-17', '360', '2', '2', '2', '2013-01-15', '2', '14', '000000000000000000', '陈汉标', '11401090209');
INSERT INTO `ordertable` VALUES ('15', '2013-01-16', '2013-01-18', '360', '2', '2', '2', '2013-01-16', '2', '15', '000000000000000000', '何炎丰', '11401090210');
INSERT INTO `ordertable` VALUES ('16', '2013-01-17', '2013-01-19', '360', '2', '2', '2', '2013-01-17', '2', '16', '000000000000000000', '王若晨', '11401090211');
INSERT INTO `ordertable` VALUES ('17', '2013-01-18', '2013-01-20', '360', '2', '2', '2', '2013-01-18', '2', '17', '000000000000000000', '王方龙', '11401090212');
INSERT INTO `ordertable` VALUES ('18', '2013-01-19', '2013-01-21', '360', '2', '2', '2', '2013-01-19', '2', '18', '000000000000000000', '包宇炀', '11401090214');
INSERT INTO `ordertable` VALUES ('19', '2013-01-20', '2013-01-22', '360', '2', '2', '2', '2013-01-20', '2', '19', '000000000000000000', '包跃鸿', '11401090215');
INSERT INTO `ordertable` VALUES ('20', '2013-01-21', '2013-01-23', '360', '2', '2', '2', '2013-01-21', '2', '20', '000000000000000000', '黄文杰', '11401090216');
INSERT INTO `ordertable` VALUES ('21', '2013-01-22', '2013-01-24', '360', '2', '2', '2', '2013-01-22', '2', '21', '000000000000000000', '杨洋', '11401090217');
INSERT INTO `ordertable` VALUES ('22', '2013-01-23', '2013-01-25', '360', '2', '2', '2', '2013-01-23', '2', '22', '000000000000000000', '王春荣', '11401090219');
INSERT INTO `ordertable` VALUES ('23', '2013-01-24', '2013-01-26', '360', '2', '2', '2', '2013-01-24', '2', '23', '000000000000000000', '李国强', '11401090220');
INSERT INTO `ordertable` VALUES ('24', '2013-01-25', '2013-01-27', '360', '2', '2', '2', '2013-01-25', '2', '24', '000000000000000000', '林仙豪', '11401090221');
INSERT INTO `ordertable` VALUES ('25', '2013-01-26', '2013-01-28', '360', '2', '2', '2', '2013-01-26', '2', '25', '000000000000000000', '丁晓靖', '11401090223');
INSERT INTO `ordertable` VALUES ('26', '2013-01-27', '2013-01-29', '160', '2', '2', '2', '2013-01-27', '3', '26', '000000000000000000', '张宏武', '11401090226');
INSERT INTO `ordertable` VALUES ('27', '2013-01-28', '2013-01-30', '160', '2', '2', '2', '2013-01-28', '3', '27', '000000000000000000', '岑致远', '11401090228');
INSERT INTO `ordertable` VALUES ('28', '2013-01-29', '2013-01-31', '160', '2', '2', '2', '2013-01-29', '3', '28', '000000000000000000', '冯立', '11401090230');
INSERT INTO `ordertable` VALUES ('29', '2013-01-30', '2013-02-01', '160', '2', '2', '2', '2013-01-30', '3', '29', '000000000000000000', '吴敏', '11401090231');
INSERT INTO `ordertable` VALUES ('30', '2013-01-31', '2013-02-02', '160', '2', '2', '2', '2013-01-31', '3', '30', '000000000000000000', '吴昊腾', '11401090232');
INSERT INTO `ordertable` VALUES ('31', '2013-02-01', '2013-02-03', '160', '2', '2', '2', '2013-02-01', '3', '31', '000000000000000000', '杨勇锋', '11401090234');
INSERT INTO `ordertable` VALUES ('32', '2013-02-02', '2013-02-04', '160', '2', '2', '2', '2013-02-02', '3', '32', '000000000000000000', '戴悦翰', '11401090235');
INSERT INTO `ordertable` VALUES ('33', '2013-02-03', '2013-02-05', '160', '2', '2', '2', '2013-02-03', '3', '33', '000000000000000000', '冯小强', '11401090239');
INSERT INTO `ordertable` VALUES ('34', '2013-02-04', '2013-02-06', '160', '2', '2', '2', '2013-02-04', '3', '34', '000000000000000000', '吴黄晨', '11401090240');
INSERT INTO `ordertable` VALUES ('35', '2013-02-05', '2013-02-07', '160', '2', '2', '2', '2013-02-05', '3', '35', '000000000000000000', '马庆云', '11401090101');
INSERT INTO `ordertable` VALUES ('36', '2013-02-06', '2013-02-08', '160', '2', '2', '2', '2013-02-06', '3', '36', '000000000000000000', '章梦姣', '11401090102');
INSERT INTO `ordertable` VALUES ('37', '2013-02-07', '2013-02-09', '160', '2', '2', '2', '2013-02-07', '3', '37', '000000000000000000', '代超', '11401090105');
INSERT INTO `ordertable` VALUES ('38', '2013-02-08', '2013-02-10', '160', '2', '2', '2', '2013-02-08', '3', '38', '000000000000000000', '沈炆', '11401090106');
INSERT INTO `ordertable` VALUES ('39', '2013-02-09', '2013-02-11', '200', '2', '2', '2', '2013-02-09', '4', '39', '000000000000000000', '漆慧鹏', '11401090107');
INSERT INTO `ordertable` VALUES ('40', '2013-02-10', '2013-02-12', '200', '2', '2', '2', '2013-02-10', '4', '40', '000000000000000000', '颜富铙', '11401090108');
INSERT INTO `ordertable` VALUES ('41', '2013-02-11', '2013-02-13', '200', '2', '2', '2', '2013-02-11', '4', '40', '000000000000000000', '徐佳栋', '11401090112');
INSERT INTO `ordertable` VALUES ('42', '2013-02-12', '2013-02-14', '200', '2', '2', '2', '2013-02-12', '4', '4', '000000000000000000', '胡军天', '11401090115');
INSERT INTO `ordertable` VALUES ('43', '2013-02-13', '2013-02-15', '200', '2', '2', '2', '2013-02-13', '4', '4', '000000000000000000', '章培超', '11401090116');
INSERT INTO `ordertable` VALUES ('44', '2013-02-14', '2013-02-16', '200', '2', '2', '2', '2013-02-14', '4', '4', '000000000000000000', '叶林华', '11401090118');
INSERT INTO `ordertable` VALUES ('45', '2013-02-15', '2013-02-17', '200', '2', '2', '2', '2013-02-15', '4', '4', '000000000000000000', '罗玉贝', '11401090120');
INSERT INTO `ordertable` VALUES ('46', '2013-02-16', '2013-02-18', '200', '2', '2', '2', '2013-02-16', '4', '4', '000000000000000000', '费晓亮', '11401090121');
INSERT INTO `ordertable` VALUES ('47', '2013-02-17', '2013-02-19', '200', '2', '2', '2', '2013-02-17', '4', '4', '000000000000000000', '俞播峰', '11401090122');
INSERT INTO `ordertable` VALUES ('48', '2013-02-18', '2013-02-20', '200', '2', '2', '2', '2013-02-18', '4', '4', '000000000000000000', '吴泽伟', '11401090125');
INSERT INTO `ordertable` VALUES ('49', '2013-02-19', '2013-02-21', '200', '2', '2', '2', '2013-02-19', '4', '4', '000000000000000000', '徐恩慧', '11401090126');
INSERT INTO `ordertable` VALUES ('50', '2013-02-20', '2013-02-22', '200', '2', '2', '2', '2013-02-20', '4', '4', '000000000000000000', '张斌', '11401090127');
INSERT INTO `ordertable` VALUES ('51', '2013-02-21', '2013-02-23', '200', '2', '2', '2', '2013-02-21', '4', '4', '000000000000000000', '张泽琪', '11401090128');
INSERT INTO `ordertable` VALUES ('52', '2013-02-22', '2013-02-24', '120', '2', '2', '2', '2013-02-22', '5', '52', '000000000000000000', '黄约沙', '11401090129');
INSERT INTO `ordertable` VALUES ('53', '2013-02-23', '2013-02-25', '122', '2', '2', '2', '2013-02-23', '6', '53', '000000000000000000', '吴建浩', '11401090132');
INSERT INTO `ordertable` VALUES ('54', '2013-02-24', '2013-02-26', '124', '2', '2', '2', '2013-02-24', '7', '54', '000000000000000000', '陈剑', '11401090134');
INSERT INTO `ordertable` VALUES ('55', '2013-02-25', '2013-02-27', '126', '2', '2', '2', '2013-02-25', '8', '55', '000000000000000000', '吴瑞俊', '11401090136');
INSERT INTO `ordertable` VALUES ('56', '2013-02-26', '2013-02-28', '128', '2', '2', '2', '2013-02-26', '9', '56', '000000000000000000', '张泉', '11401090137');
INSERT INTO `ordertable` VALUES ('57', '2013-02-27', '2013-03-01', '130', '2', '2', '2', '2013-02-27', '10', '57', '000000000000000000', '罗鹏', '11401090138');
INSERT INTO `ordertable` VALUES ('58', '2013-02-28', '2013-03-02', '132', '2', '2', '2', '2013-02-28', '11', '58', '000000000000000000', '杨杰', '11401090140');
INSERT INTO `ordertable` VALUES ('59', '2013-03-01', '2013-03-03', '134', '2', '2', '2', '2013-03-01', '12', '59', '000000000000000000', '汤蓓', '11401090201');
INSERT INTO `ordertable` VALUES ('60', '2013-03-02', '2013-03-04', '136', '2', '2', '2', '2013-03-02', '13', '60', '000000000000000000', '蓝柔雪', '11401090203');
INSERT INTO `ordertable` VALUES ('61', '2013-03-03', '2013-03-05', '158', '2', '2', '2', '2013-03-03', '14', '61', '000000000000000000', '颜法廷', '11401090205');
INSERT INTO `ordertable` VALUES ('62', '2013-03-04', '2013-03-06', '160', '2', '2', '2', '2013-03-04', '15', '62', '000000000000000000', '谢文龙', '11401090206');
INSERT INTO `ordertable` VALUES ('63', '2013-03-05', '2013-03-07', '162', '2', '2', '2', '2013-03-05', '12', '63', '000000000000000000', '李炊', '11401090208');
INSERT INTO `ordertable` VALUES ('64', '2013-03-06', '2013-03-08', '164', '2', '2', '2', '2013-03-06', '13', '64', '000000000000000000', '张宏', '11401090213');
INSERT INTO `ordertable` VALUES ('65', '2013-03-07', '2013-03-09', '166', '2', '2', '2', '2013-03-07', '14', '65', '000000000000000000', '陈凯华', '11401090218');
INSERT INTO `ordertable` VALUES ('66', '2013-03-08', '2013-03-10', '168', '2', '2', '2', '2013-03-08', '15', '66', '000000000000000000', '吴建明', '11401090222');
INSERT INTO `ordertable` VALUES ('67', '2013-03-09', '2013-03-11', '170', '2', '2', '2', '2013-03-09', '16', '67', '000000000000000000', '吴建标', '11401090224');
INSERT INTO `ordertable` VALUES ('68', '2013-03-10', '2013-03-12', '172', '2', '2', '2', '2013-03-10', '17', '68', '000000000000000000', '陈欢', '11401090225');
INSERT INTO `ordertable` VALUES ('69', '2013-03-11', '2013-03-13', '174', '2', '2', '2', '2013-03-11', '18', '69', '000000000000000000', '曹聪聪', '11401090227');
INSERT INTO `ordertable` VALUES ('70', '2013-03-12', '2013-03-14', '176', '2', '2', '2', '2013-03-12', '19', '70', '000000000000000000', '李炜俊', '11401090229');
INSERT INTO `ordertable` VALUES ('71', '2013-03-13', '2013-03-15', '178', '2', '2', '2', '2013-03-13', '20', '71', '000000000000000000', '孙煜杰', '11401090233');
INSERT INTO `ordertable` VALUES ('72', '2013-03-14', '2013-03-16', '180', '2', '2', '2', '2013-03-14', '21', '72', '000000000000000000', '张垚', '11401090236');
INSERT INTO `ordertable` VALUES ('73', '2013-03-15', '2013-03-17', '182', '2', '2', '2', '2013-03-15', '22', '73', '000000000000000000', '顾阳宇', '11401090237');
INSERT INTO `ordertable` VALUES ('74', '2013-03-16', '2013-03-18', '184', '2', '2', '2', '2013-03-16', '23', '74', '000000000000000000', '陈俊羽', '11401090238');
INSERT INTO `ordertable` VALUES ('75', '2013-03-17', '2013-03-19', '112', '2', '2', '2', '2013-03-17', '34', '75', '000000000000000000', '林先娜', '12401090101');
INSERT INTO `ordertable` VALUES ('76', '2013-03-18', '2013-03-20', '114', '2', '2', '2', '2013-03-18', '35', '76', '000000000000000000', '刘胜男', '12401090104');
INSERT INTO `ordertable` VALUES ('77', '2013-03-19', '2013-03-21', '116', '2', '2', '2', '2013-03-19', '36', '77', '000000000000000000', '张子腾', '12401090105');
INSERT INTO `ordertable` VALUES ('78', '2013-03-20', '2013-03-22', '118', '2', '2', '2', '2013-03-20', '37', '78', '000000000000000000', '沈增涛', '12401090106');
INSERT INTO `ordertable` VALUES ('79', '2013-03-21', '2013-03-23', '120', '2', '2', '2', '2013-03-21', '38', '79', '000000000000000000', '陈振伟', '12401090107');
INSERT INTO `ordertable` VALUES ('80', '2013-03-22', '2013-03-24', '122', '2', '2', '2', '2013-03-22', '39', '80', '000000000000000000', '包年晖', '12401090108');
INSERT INTO `ordertable` VALUES ('81', '2013-03-23', '2013-03-25', '124', '2', '2', '2', '2013-03-23', '40', '81', '000000000000000000', '邵润润', '12401090109');
INSERT INTO `ordertable` VALUES ('82', '2013-03-24', '2013-03-26', '126', '2', '2', '2', '2013-03-24', '4', '82', '000000000000000000', '张文涛', '12401090110');
INSERT INTO `ordertable` VALUES ('83', '2013-03-25', '2013-03-27', '128', '2', '2', '2', '2013-03-25', '4', '83', '000000000000000000', '陈泓鸣', '12401090111');
INSERT INTO `ordertable` VALUES ('84', '2013-03-26', '2013-03-28', '130', '2', '2', '2', '2013-03-26', '4', '84', '000000000000000000', '张杨坚', '12401090112');
INSERT INTO `ordertable` VALUES ('85', '2013-03-27', '2013-03-29', '132', '2', '2', '2', '2013-03-27', '4', '85', '000000000000000000', '王磊', '12401090113');
INSERT INTO `ordertable` VALUES ('86', '2013-03-28', '2013-03-30', '134', '2', '2', '2', '2013-03-28', '4', '86', '000000000000000000', '朱昊', '12401090114');
INSERT INTO `ordertable` VALUES ('87', '2013-03-29', '2013-03-31', '200', '2', '2', '2', '2013-03-29', '4', '87', '000000000000000000', '王昱剑', '12401090115');
INSERT INTO `ordertable` VALUES ('88', '2013-03-30', '2013-04-01', '200', '2', '2', '2', '2013-03-30', '4', '88', '000000000000000000', '蓝峥', '12401090116');
INSERT INTO `ordertable` VALUES ('89', '2013-03-31', '2013-04-02', '200', '2', '2', '2', '2013-03-31', '4', '89', '000000000000000000', '黄文溪', '12401090117');
INSERT INTO `ordertable` VALUES ('90', '2013-04-01', '2013-04-03', '200', '2', '2', '2', '2013-04-01', '4', '90', '000000000000000000', '范泳琦', '12401090118');
INSERT INTO `ordertable` VALUES ('91', '2013-04-02', '2013-04-04', '200', '2', '2', '2', '2013-04-02', '4', '91', '000000000000000000', '戴熠赟', '12401090119');
INSERT INTO `ordertable` VALUES ('92', '2013-04-03', '2013-04-05', '200', '2', '2', '2', '2013-04-03', '36', '92', '000000000000000000', '贾俊超', '12401090120');
INSERT INTO `ordertable` VALUES ('93', '2013-04-04', '2013-04-06', '200', '2', '2', '2', '2013-04-04', '4', '93', '000000000000000000', '吴新伟', '12401090121');
INSERT INTO `ordertable` VALUES ('94', '2013-04-05', '2013-04-07', '200', '2', '2', '2', '2013-04-05', '38', '94', '000000000000000000', '倪辉辉', '12401090122');
INSERT INTO `ordertable` VALUES ('95', '2013-04-06', '2013-04-08', '200', '2', '2', '2', '2013-04-06', '39', '95', '000000000000000000', '顾贤听', '12401090123');
INSERT INTO `ordertable` VALUES ('96', '2013-04-07', '2013-04-09', '200', '2', '2', '2', '2013-04-07', '4', '96', '000000000000000000', '邱亿', '12401090124');
INSERT INTO `ordertable` VALUES ('97', '2013-04-08', '2013-04-10', '200', '2', '2', '2', '2013-04-08', '41', '97', '000000000000000000', '许阳峰', '12401090125');
INSERT INTO `ordertable` VALUES ('98', '2013-04-09', '2013-04-11', '200', '2', '2', '2', '2013-04-09', '4', '98', '000000000000000000', '韩焱', '12401090126');
INSERT INTO `ordertable` VALUES ('99', '2013-04-10', '2013-04-12', '200', '2', '2', '2', '2013-04-10', '4', '99', '000000000000000000', '郑邦杰', '12401090127');
INSERT INTO `ordertable` VALUES ('132', '2015-12-02', '2015-12-03', '100', '-1', '1', '1', '2015-12-05 09:09:06', '4', '1', '000000000000000000', '金超', '1');
INSERT INTO `ordertable` VALUES ('133', '2015-12-01', '2015-12-03', '200', '1', '2', '1', '2015-12-05 11:17:09', '34', '106', '3333', '小哈', '3333');
INSERT INTO `ordertable` VALUES ('137', '2015-12-02', '2015-12-06', '400', '5', '4', '1', '2015-12-05 13:54:52', '24', '1', '000000000000000000', '金超', '1');
INSERT INTO `ordertable` VALUES ('143', '2015-12-15', '2015-12-16', '180', '1', '1', '1', '2015-12-15 23:11:40', '2', '1', '22', '55', '44');
INSERT INTO `ordertable` VALUES ('144', '2015-12-15', '2015-12-16', '180', '1', '1', '1', '2015-12-15 23:12:34', '2', '1', '22', '55', '44');
INSERT INTO `ordertable` VALUES ('150', '2015-12-08', '2015-12-10', '360', '5', '2', '1', '2015-12-16 14:59:06', '40', '1', '333', '33', '333');
INSERT INTO `ordertable` VALUES ('151', '2015-12-01', '2015-12-03', '360', '1', '2', '1', '2015-12-16 15:01:39', '40', '1', '55', '55', '55');
INSERT INTO `ordertable` VALUES ('152', '2015-12-02', '2015-12-04', '360', '1', '2', '1', '2015-12-16 15:07:59', '27', '1', '1213', 'ee', 'ss');

-- ----------------------------
-- Table structure for rechargerecord
-- ----------------------------
DROP TABLE IF EXISTS `rechargerecord`;
CREATE TABLE `rechargerecord` (
  `rechargeId` int(11) NOT NULL AUTO_INCREMENT,
  `rechargeMoney` int(11) NOT NULL,
  `rechargeTime` varchar(255) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`rechargeId`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rechargerecord
-- ----------------------------
INSERT INTO `rechargerecord` VALUES ('1', '1000', '2013-01-01', '1');
INSERT INTO `rechargerecord` VALUES ('2', '1000', '2013-01-02', '25');
INSERT INTO `rechargerecord` VALUES ('3', '1000', '2013-01-03', '34');
INSERT INTO `rechargerecord` VALUES ('4', '1000', '2013-01-04', '78');
INSERT INTO `rechargerecord` VALUES ('5', '1000', '2013-01-05', '3');
INSERT INTO `rechargerecord` VALUES ('6', '1000', '2013-01-06', '56');
INSERT INTO `rechargerecord` VALUES ('7', '1000', '2013-01-07', '24');
INSERT INTO `rechargerecord` VALUES ('8', '1000', '2013-01-08', '90');
INSERT INTO `rechargerecord` VALUES ('9', '1000', '2013-01-09', '14');
INSERT INTO `rechargerecord` VALUES ('10', '1000', '2013-01-10', '76');
INSERT INTO `rechargerecord` VALUES ('11', '1000', '2013-01-11', '10');
INSERT INTO `rechargerecord` VALUES ('12', '1000', '2013-01-12', '45');
INSERT INTO `rechargerecord` VALUES ('13', '1000', '2013-01-13', '23');
INSERT INTO `rechargerecord` VALUES ('14', '1000', '2013-01-14', '53');
INSERT INTO `rechargerecord` VALUES ('15', '1000', '2013-01-15', '23');
INSERT INTO `rechargerecord` VALUES ('16', '1000', '2013-01-16', '23');
INSERT INTO `rechargerecord` VALUES ('17', '1000', '2013-01-01', '23');
INSERT INTO `rechargerecord` VALUES ('18', '1000', '2013-01-02', '23');
INSERT INTO `rechargerecord` VALUES ('19', '1000', '2013-01-03', '23');
INSERT INTO `rechargerecord` VALUES ('20', '1000', '2013-01-04', '23');
INSERT INTO `rechargerecord` VALUES ('21', '1000', '2013-01-05', '23');
INSERT INTO `rechargerecord` VALUES ('22', '1000', '2013-01-06', '23');
INSERT INTO `rechargerecord` VALUES ('23', '1000', '2013-01-07', '23');
INSERT INTO `rechargerecord` VALUES ('24', '1000', '2013-01-08', '23');
INSERT INTO `rechargerecord` VALUES ('25', '1000', '2013-01-09', '23');
INSERT INTO `rechargerecord` VALUES ('26', '1000', '2013-01-10', '23');
INSERT INTO `rechargerecord` VALUES ('27', '1000', '2013-01-11', '23');
INSERT INTO `rechargerecord` VALUES ('28', '1000', '2013-01-12', '23');
INSERT INTO `rechargerecord` VALUES ('29', '1000', '2013-01-13', '23');
INSERT INTO `rechargerecord` VALUES ('30', '1000', '2013-01-14', '23');
INSERT INTO `rechargerecord` VALUES ('31', '1000', '2013-01-15', '23');
INSERT INTO `rechargerecord` VALUES ('32', '1000', '2013-01-16', '12');
INSERT INTO `rechargerecord` VALUES ('33', '1000', '2013-01-01', '12');
INSERT INTO `rechargerecord` VALUES ('34', '1000', '2013-01-02', '12');
INSERT INTO `rechargerecord` VALUES ('35', '1000', '2013-01-03', '12');
INSERT INTO `rechargerecord` VALUES ('36', '1000', '2013-01-04', '12');
INSERT INTO `rechargerecord` VALUES ('37', '1000', '2013-01-05', '12');
INSERT INTO `rechargerecord` VALUES ('38', '1000', '2013-01-06', '12');
INSERT INTO `rechargerecord` VALUES ('39', '1000', '2013-01-07', '12');
INSERT INTO `rechargerecord` VALUES ('40', '1000', '2013-01-08', '12');
INSERT INTO `rechargerecord` VALUES ('41', '1000', '2013-01-09', '13');
INSERT INTO `rechargerecord` VALUES ('42', '1000', '2013-01-10', '14');
INSERT INTO `rechargerecord` VALUES ('43', '1000', '2013-01-11', '15');
INSERT INTO `rechargerecord` VALUES ('44', '1000', '2013-01-12', '16');
INSERT INTO `rechargerecord` VALUES ('45', '1000', '2013-01-13', '17');
INSERT INTO `rechargerecord` VALUES ('46', '1000', '2013-01-14', '18');
INSERT INTO `rechargerecord` VALUES ('47', '1000', '2013-01-15', '19');
INSERT INTO `rechargerecord` VALUES ('48', '1000', '2013-01-16', '20');
INSERT INTO `rechargerecord` VALUES ('49', '1000', '2013-01-01', '21');
INSERT INTO `rechargerecord` VALUES ('50', '1000', '2013-01-02', '22');
INSERT INTO `rechargerecord` VALUES ('51', '1000', '2013-01-03', '23');
INSERT INTO `rechargerecord` VALUES ('52', '1000', '2013-01-04', '16');
INSERT INTO `rechargerecord` VALUES ('53', '1000', '2013-01-05', '17');
INSERT INTO `rechargerecord` VALUES ('54', '1000', '2013-01-06', '18');
INSERT INTO `rechargerecord` VALUES ('55', '1000', '2013-01-07', '19');
INSERT INTO `rechargerecord` VALUES ('56', '1000', '2013-01-08', '20');
INSERT INTO `rechargerecord` VALUES ('57', '1000', '2013-01-09', '21');
INSERT INTO `rechargerecord` VALUES ('58', '1000', '2013-01-10', '22');
INSERT INTO `rechargerecord` VALUES ('59', '1000', '2013-01-11', '23');
INSERT INTO `rechargerecord` VALUES ('60', '1000', '2013-01-12', '79');
INSERT INTO `rechargerecord` VALUES ('61', '1000', '2013-01-13', '80');
INSERT INTO `rechargerecord` VALUES ('62', '1000', '2013-01-14', '81');
INSERT INTO `rechargerecord` VALUES ('63', '1000', '2013-01-15', '82');
INSERT INTO `rechargerecord` VALUES ('64', '1000', '2013-01-16', '83');
INSERT INTO `rechargerecord` VALUES ('65', '1000', '2013-01-01', '84');
INSERT INTO `rechargerecord` VALUES ('66', '1000', '2013-01-02', '85');
INSERT INTO `rechargerecord` VALUES ('67', '1000', '2013-01-03', '86');
INSERT INTO `rechargerecord` VALUES ('68', '1000', '2013-01-04', '87');
INSERT INTO `rechargerecord` VALUES ('69', '1000', '2013-01-05', '88');
INSERT INTO `rechargerecord` VALUES ('70', '1000', '2013-01-06', '89');
INSERT INTO `rechargerecord` VALUES ('71', '1000', '2013-01-07', '90');
INSERT INTO `rechargerecord` VALUES ('72', '1000', '2013-01-08', '91');
INSERT INTO `rechargerecord` VALUES ('73', '1000', '2013-01-09', '92');
INSERT INTO `rechargerecord` VALUES ('74', '1000', '2013-01-10', '93');
INSERT INTO `rechargerecord` VALUES ('75', '1000', '2013-01-11', '94');
INSERT INTO `rechargerecord` VALUES ('76', '1000', '2013-01-12', '95');
INSERT INTO `rechargerecord` VALUES ('77', '1000', '2013-01-13', '57');
INSERT INTO `rechargerecord` VALUES ('78', '1000', '2013-01-14', '58');
INSERT INTO `rechargerecord` VALUES ('79', '1000', '2013-01-15', '59');
INSERT INTO `rechargerecord` VALUES ('80', '1000', '2013-01-16', '60');
INSERT INTO `rechargerecord` VALUES ('81', '1000', '2013-01-01', '61');
INSERT INTO `rechargerecord` VALUES ('82', '1000', '2013-01-02', '62');
INSERT INTO `rechargerecord` VALUES ('83', '1000', '2013-01-03', '63');
INSERT INTO `rechargerecord` VALUES ('84', '1000', '2013-01-04', '64');
INSERT INTO `rechargerecord` VALUES ('85', '1000', '2013-01-05', '65');
INSERT INTO `rechargerecord` VALUES ('86', '1000', '2013-01-06', '66');
INSERT INTO `rechargerecord` VALUES ('87', '1000', '2013-01-07', '67');
INSERT INTO `rechargerecord` VALUES ('88', '1000', '2013-01-08', '68');
INSERT INTO `rechargerecord` VALUES ('89', '1000', '2013-01-09', '69');
INSERT INTO `rechargerecord` VALUES ('90', '1000', '2013-01-10', '70');
INSERT INTO `rechargerecord` VALUES ('91', '1000', '2013-01-11', '71');
INSERT INTO `rechargerecord` VALUES ('92', '1000', '2013-01-12', '72');
INSERT INTO `rechargerecord` VALUES ('93', '1000', '2013-01-13', '73');
INSERT INTO `rechargerecord` VALUES ('94', '1000', '2013-01-14', '74');
INSERT INTO `rechargerecord` VALUES ('95', '1000', '2013-01-15', '75');
INSERT INTO `rechargerecord` VALUES ('96', '1000', '2013-01-16', '76');
INSERT INTO `rechargerecord` VALUES ('97', '1000', '2013-01-17', '77');
INSERT INTO `rechargerecord` VALUES ('98', '1000', '2013-01-18', '78');
INSERT INTO `rechargerecord` VALUES ('99', '1000', '2013-01-19', '79');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `roomId` int(11) NOT NULL AUTO_INCREMENT,
  `addressId` int(11) NOT NULL,
  `roomDetailAddress` varchar(255) DEFAULT NULL,
  `roomEquipmentId` int(11) NOT NULL,
  `roomLatitude` varchar(255) DEFAULT NULL,
  `roomLockState` int(11) NOT NULL,
  `roomLongitude` varchar(255) DEFAULT NULL,
  `roomMassage` varchar(255) DEFAULT NULL,
  `roomNumber` int(11) NOT NULL,
  `roomPassword` varchar(255) DEFAULT NULL,
  `roomPicture` varchar(255) DEFAULT NULL,
  `roomType` int(11) NOT NULL,
  `roomUnitPrice` int(11) NOT NULL,
  `roomUsingState` int(11) NOT NULL,
  PRIMARY KEY (`roomId`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1', '10', '浙江宁波江北区1号', '1', '29865638', '0', '121.555293', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅5分钟车程，交通十分便利。', '1', '123', 'img/room-img/jiangdong3.jpg', '2', '80', '2');
INSERT INTO `room` VALUES ('2', '9', '浙江宁波江东区1号', '2', '29808072', '0', '121.245555', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅6分钟车程，交通十分便利。', '2', '123', 'img/room-img/jiangdong1.jpg', '3', '180', '1');
INSERT INTO `room` VALUES ('3', '11', '浙江宁波北仑区1号', '3', '29768452', '1', '121.052383', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅7分钟车程，交通十分便利。', '3', '123', 'img/room-img/zhenhai1.jpg', '2', '80', '1');
INSERT INTO `room` VALUES ('4', '2', '浙江宁波镇海区1号', '4', '2973233', '0', '121.033986', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅8分钟车程，交通十分便利。', '4', '123', 'img/room-img/zhenhai1.jpg', '1', '100', '1');
INSERT INTO `room` VALUES ('5', '3', '浙江宁波鄞州区1号', '5', '29745376', '1', '121.121373', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅9分钟车程，交通十分便利。', '5', '123', 'img/room-img/yinzhou1.jpg', '3', '180', '1');
INSERT INTO `room` VALUES ('6', '4', '浙江宁波余姚市1号', '6', '29660045', '1', '121.165067', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅10分钟车程，交通十分便利。', '6', '123', 'img/room-img/yuyao1.jpg', '1', '100', '1');
INSERT INTO `room` VALUES ('7', '5', '浙江宁波慈溪市1号', '7', '29679125', '0', '121.096077', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅11分钟车程，交通十分便利。', '7', '123', 'img/room-img/cixi1.jpg', '3', '180', '2');
INSERT INTO `room` VALUES ('8', '6', '浙江宁波奉化市1号', '8', '29692178', '0', '121.031686', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅12分钟车程，交通十分便利。', '8', '123', 'img/room-img/fenghua1.jpg', '3', '180', '2');
INSERT INTO `room` VALUES ('9', '7', '浙江宁波象山县1号', '9', '29715267', '0', '120.947749', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅13分钟车程，交通十分便利。', '9', '123', 'img/room-img/xiangshan1.jpg', '2', '80', '2');
INSERT INTO `room` VALUES ('10', '8', '浙江宁波宁海市1号', '10', '29779487', '0', '120.946599', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅14分钟车程，交通十分便利。', '10', '123', 'img/room-img/ninghai1.jpg', '3', '180', '2');
INSERT INTO `room` VALUES ('11', '9', '浙江宁波江东区2号', '11', '29834643', '0', '120.962697', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅15分钟车程，交通十分便利。', '11', '123', 'img/room-img/jiangdong2.jpg', '1', '100', '1');
INSERT INTO `room` VALUES ('12', '10', '浙江宁波江北区2号', '12', '29834643', '0', '121.07538', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅16分钟车程，交通十分便利。', '12', '123', 'img/room-img/jiangbei2.jpg', '3', '180', '1');
INSERT INTO `room` VALUES ('13', '11', '浙江宁波北仑区2号', '13', '29852687', '0', '121.152419', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅17分钟车程，交通十分便利。', '13', '123', 'img/room-img/beilun2.jpg', '2', '80', '1');
INSERT INTO `room` VALUES ('14', '2', '浙江宁波镇海区2号', '14', '29925833', '0', '121.069631', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅18分钟车程，交通十分便利。', '14', '123', 'img/room-img/zhenhai2.jpg', '1', '100', '1');
INSERT INTO `room` VALUES ('15', '3', '浙江宁波鄞州区2号', '15', '299068', '0', '121.154718', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅19分钟车程，交通十分便利。', '15', '123', 'img/room-img/yinzhou2.jpg', '3', '180', '1');
INSERT INTO `room` VALUES ('16', '4', '浙江宁波余姚市2号', '16', '29863713', '0', '121.217959', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅20分钟车程，交通十分便利。', '16', '123', 'img/room-img/yuyao2.jpg', '1', '100', '1');
INSERT INTO `room` VALUES ('17', '5', '浙江宁波慈溪市2号', '17', '29804562', '0', '121.203011', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅21分钟车程，交通十分便利。', '17', '123', 'img/room-img/cixi2.jpg', '3', '180', '2');
INSERT INTO `room` VALUES ('18', '6', '浙江宁波奉化市2号', '18', '2973233', '0', '121.201861', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅22分钟车程，交通十分便利。', '18', '123', 'img/room-img/fenghua2.jpg', '3', '180', '2');
INSERT INTO `room` VALUES ('19', '7', '浙江宁波象山县2号', '19', '29684146', '0', '121.215659', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅23分钟车程，交通十分便利。', '19', '123', 'img/room-img/xiangshan2.jpg', '2', '80', '2');
INSERT INTO `room` VALUES ('20', '8', '浙江宁波宁海市2号', '20', '29692178', '0', '121.2812', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅24分钟车程，交通十分便利。', '20', '123', 'img/room-img/ninghai2.jpg', '3', '180', '2');
INSERT INTO `room` VALUES ('21', '9', '浙江宁波江东区3号', '21', '29741362', '0', '121.313395', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅25分钟车程，交通十分便利。', '21', '123', 'img/room-img/jiangdong3.jpg', '1', '100', '1');
INSERT INTO `room` VALUES ('22', '10', '浙江宁波江北区3号', '22', '29815593', '0', '121.319144', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅26分钟车程，交通十分便利。', '22', '123', 'img/room-img/jiangbei3.jpg', '3', '180', '1');
INSERT INTO `room` VALUES ('23', '11', '浙江宁波北仑区3号', '23', '29873735', '0', '121.309946', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅27分钟车程，交通十分便利。', '23', '123', 'img/room-img/beilun3.jpg', '2', '80', '1');
INSERT INTO `room` VALUES ('24', '2', '浙江宁波镇海区3号', '24', '29911809', '0', '121.284649', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅28分钟车程，交通十分便利。', '24', '123', 'img/room-img/zhenhai3.jpg', '1', '100', '1');
INSERT INTO `room` VALUES ('25', '3', '浙江宁波鄞州区3号', '25', '29963888', '0', '121.182314', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅29分钟车程，交通十分便利。', '25', '123', 'img/room-img/yingzhou3.jpg', '3', '180', '1');
INSERT INTO `room` VALUES ('26', '4', '浙江宁波余姚市3号', '26', '29956879', '0', '121.091478', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅30分钟车程，交通十分便利。', '26', '123', 'img/room-img/yuyao3.jpg', '1', '100', '1');
INSERT INTO `room` VALUES ('27', '5', '浙江宁波慈溪市3号', '27', '29994921', '0', '121.130572', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅31分钟车程，交通十分便利。', '27', '123', 'img/room-img/cixi3.jpg', '3', '180', '2');
INSERT INTO `room` VALUES ('28', '6', '浙江宁波奉化市3号', '28', '29997924', '0', '121.081129', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅32分钟车程，交通十分便利。', '28', '123', 'img/room-img/fenghua3.jpg', '3', '180', '2');
INSERT INTO `room` VALUES ('29', '7', '浙江宁波象山县3号', '29', '29977904', '0', '121.020188', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅33分钟车程，交通十分便利。', '29', '123', 'img/room-img/xiangshan3.jpg', '2', '80', '2');
INSERT INTO `room` VALUES ('30', '8', '浙江宁波宁海市3号', '30', '29954876', '0', '121.013289', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅34分钟车程，交通十分便利。', '30', '123', 'img/room-img/ninghai3.jpg', '3', '180', '2');
INSERT INTO `room` VALUES ('31', '9', '浙江宁波江东区4号', '31', '29941858', '0', '121.010989', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅35分钟车程，交通十分便利。', '31', '123', 'img/room-img/jiangdong4.jpg', '1', '100', '1');
INSERT INTO `room` VALUES ('32', '10', '浙江宁波江北区4号', '32', '29916818', '0', '121.024787', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅36分钟车程，交通十分便利。', '32', '123', 'img/room-img/jiangbei4.jpg', '3', '180', '1');
INSERT INTO `room` VALUES ('33', '11', '浙江宁波北仑区4号', '33', '29909806', '0', '121.053533', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅37分钟车程，交通十分便利。', '33', '123', 'img/room-img/beilun4.jpg', '2', '80', '1');
INSERT INTO `room` VALUES ('34', '2', '浙江宁波镇海区4号', '34', '29891772', '0', '121.067331', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅38分钟车程，交通十分便利。', '34', '123', 'img/room-img/zhenhai4.jpg', '1', '100', '1');
INSERT INTO `room` VALUES ('35', '3', '浙江宁波鄞州区4号', '35', '29874737', '0', '121.07193', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅39分钟车程，交通十分便利。', '35', '123', 'img/room-img/yingzhou4.jpg', '3', '180', '1');
INSERT INTO `room` VALUES ('36', '4', '浙江宁波余姚市4号', '36', '29864715', '0', '121.096077', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅40分钟车程，交通十分便利。', '36', '123', 'img/room-img/yuyao4.jpg', '1', '100', '1');
INSERT INTO `room` VALUES ('37', '5', '浙江宁波慈溪市4号', '37', '29851685', '0', '121.042035', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅41分钟车程，交通十分便利。', '37', '123', 'img/room-img/cixi4.jpg', '3', '180', '2');
INSERT INTO `room` VALUES ('38', '6', '浙江宁波奉化市4号', '38', '29873735', '0', '121.00984', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅42分钟车程，交通十分便利。', '38', '123', 'img/room-img/fenghua4.jpg', '3', '180', '2');
INSERT INTO `room` VALUES ('39', '7', '浙江宁波象山县4号', '39', '29893776', '0', '120.956947', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅43分钟车程，交通十分便利。', '39', '123', 'img/room-img/xiangshan4.jpg', '2', '80', '2');
INSERT INTO `room` VALUES ('40', '1', '浙江宁波海曙区1号', '40', '29905799', '0', '120.916703', '位于宁波城西核心地块，距离机场15分钟、宁波站及市中心10分钟、汽车客运中心仅44分钟车程，交通十分便利。', '40', '123', 'img/room-img/ninghai4.jpg', '3', '180', '2');
INSERT INTO `room` VALUES ('41', '1', '浙江省宁波市海曙区', '0', '29865638', '0', '121.555293', '', '234', '234', 'img/room-img/jiangdong (3).jpg', '2', '342', '2');
INSERT INTO `room` VALUES ('42', '6', '2342342', '0', '29865638', '0', '121.555293', '', '324', '2342', 'img/room-img/jiangdong (3).jpg', '2', '325432', '2');
INSERT INTO `room` VALUES ('43', '10', '423424', '0', '29865638', '0', '121.555293', '', '234', '234', 'img/room-img/jiangdong (3).jpg', '2', '242', '2');

-- ----------------------------
-- Table structure for roomcommit
-- ----------------------------
DROP TABLE IF EXISTS `roomcommit`;
CREATE TABLE `roomcommit` (
  `roomcommitId` int(11) NOT NULL AUTO_INCREMENT,
  `roomCommitContent` varchar(255) DEFAULT NULL,
  `roomCommitRank` int(11) NOT NULL,
  `roomCommitTime` varchar(255) DEFAULT NULL,
  `roomId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`roomcommitId`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roomcommit
-- ----------------------------
INSERT INTO `roomcommit` VALUES ('1', '400块的价格，酒店位置在市区，离城隍庙（没啥可玩的），天一广场，月湖公园都蛮近的，两个红绿灯的距离。酒店是老牌四星，停车条件稍微差点，基本停在酒店门口，房间设施齐全，不过标准间床宽度窄点，老酒店一般都这样。早餐总类多，豆腐脑，油条，培根，面条等中西式都有，不过质量一般，主要定位吃饱，像培根口感很软，很一般。总体来说400块的价格对比宁波这个城市而言，差不多，稍微偏高了一点。', '1', '2013-01-03', '1', '1');
INSERT INTO `roomcommit` VALUES ('2', '我们一家人带小孩去宁波自驾游，由于开着车，没坐地面交通，所以不知道交通到底方便不。但是开车去吃排挡一条街和去老外滩都不远。设施服务卫生等，我只能说，住多少钱的店就给多少预期，三百多的房间不能指望特别好。我住的房间，浴缸掉漆了一块，乍一看以为是不干净。但是只住一晚，而且不贵，总的来说没什么好计较的。门口停车的服务人员态度都蛮好。酒店旁边是小区，还有一个小水果摊。酒店一楼是个日本料理，晚上去吃，味道还不错。', '2', '2013-01-04', '2', '2');
INSERT INTO `roomcommit` VALUES ('3', '位置还行，旁边还有几处吃饭的地方和电影院，房间挺不错的，洗澡很舒服，水压很大，网速简直赞，很快，唯一不足就是早餐太差了，菜没几样不说，有时候连杯子都没有，水果就西瓜和橘子，西瓜有时候还是那种看起来快坏的，而且连烤面包机都没有，醉了，还是第一次遇到。', '3', '2013-01-05', '3', '3');
INSERT INTO `roomcommit` VALUES ('4', '很不错的酒店，L型落地窗风景一览无余，外滩桥就在眼前。早餐丰富，大床双床都很舒适，只可惜停车另外收费令人感觉不爽，其实过夜最多二十元的服务酒店完全可以凭此赢得更多口碑。', '4', '2013-01-06', '4', '4');
INSERT INTO `roomcommit` VALUES ('5', '酒店在柳汀街立交桥旁边，很好找。离火车站很近。打车到火车站五分钟左右。走路十二三分钟左右吧。我住的是200元标准大床房，含双早。酒店设施为正常标配，相应的价格对比下会比其他快捷酒店设施来得好。酒店服务态度很好。酒店早餐七点开始，由于我们要赶早点的动车，吃不上早餐。酒店很有爱帮我们提前打包些面包鸡蛋矿泉水让我们带到火车上吃。非常好的服务态度。大赞', '5', '2013-01-07', '5', '5');
INSERT INTO `roomcommit` VALUES ('6', '早餐巨好，五种?，包子，豆浆，牛奶，橙汁，炒饭，炒面，煮鸡蛋，可以现做面条和煎蛋，炼乳，不下于三种咸菜，两个热菜，粥。。。水果。。。等等等，尤其推荐豆浆和牛奶。。。自己尝尝绝对比四星级的醇厚，牛奶绝对不是奶粉冲的那种。。。早上喝了四杯。。。而且不怕起晚，东西没了就加。。。早餐最晚九点', '1', '2013-01-08', '6', '6');
INSERT INTO `roomcommit` VALUES ('7', '酒店装修属于比较老式的，商务大床房空间蛮大，前台服务态度蛮好，这点很满意。早饭很有诚意，包子稀饭油条面包豆浆果汁咖啡炒面炒饭蛋糕点心色拉水果都有，豆浆浓厚，不是稀拉拉豆粉冲的那种，我说早饭有诚意是因为添的很及时，我感觉几分钟服务员就会出来把快吃光的食物填满，这点很不容易，我上次住的店恶心死了，早上去的晚都没吃的，这家早饭到九点结束，截止到我八点四十五分左右离开，吃的东西都还是装的满满的，不知道平时是不是也这样，总之，国庆期间，这个价格和服务，这家酒店让我很满意，下次还会过来', '2', '2013-01-09', '7', '7');
INSERT INTO `roomcommit` VALUES ('8', '第一次入住浙海感觉很舒服，门面气派，停车方便，前台服务优秀，尤其是客服李爱玲给人印象很深，我们是家庭游还有小孩，她热情周到的帮我们召车，4号早餐时出了一点小状况，她又及时帮我们解决了，非常感谢她。浙海让人有宾至如归的温暖，房间干净，卫生间又宽大，自助早餐丰富，晚上还有水果和酸奶，小孩很开心。我们也很满意，感谢携程，感谢浙海，让我们这次宁波之旅非常愉快！下次来宁波还会选择浙海！', '3', '2013-01-10', '8', '8');
INSERT INTO `roomcommit` VALUES ('9', '400块的价格，酒店位置在市区，离城隍庙（没啥可玩的），天一广场，月湖公园都蛮近的，两个红绿灯的距离。酒店是老牌四星，停车条件稍微差点，基本停在酒店门口，房间设施齐全，不过标准间床宽度窄点，老酒店一般都这样。早餐总类多，豆腐脑，油条，培根，面条等中西式都有，不过质量一般，主要定位吃饱，像培根口感很软，很一般。总体来说400块的价格对比宁波这个城市而言，差不多，稍微偏高了一点。', '4', '2013-01-11', '9', '9');
INSERT INTO `roomcommit` VALUES ('10', '我们一家人带小孩去宁波自驾游，由于开着车，没坐地面交通，所以不知道交通到底方便不。但是开车去吃排挡一条街和去老外滩都不远。设施服务卫生等，我只能说，住多少钱的店就给多少预期，三百多的房间不能指望特别好。我住的房间，浴缸掉漆了一块，乍一看以为是不干净。但是只住一晚，而且不贵，总的来说没什么好计较的。门口停车的服务人员态度都蛮好。酒店旁边是小区，还有一个小水果摊。酒店一楼是个日本料理，晚上去吃，味道还不错。', '5', '2013-01-12', '10', '10');
INSERT INTO `roomcommit` VALUES ('11', '位置还行，旁边还有几处吃饭的地方和电影院，房间挺不错的，洗澡很舒服，水压很大，网速简直赞，很快，唯一不足就是早餐太差了，菜没几样不说，有时候连杯子都没有，水果就西瓜和橘子，西瓜有时候还是那种看起来快坏的，而且连烤面包机都没有，醉了，还是第一次遇到。', '1', '2013-01-13', '11', '11');
INSERT INTO `roomcommit` VALUES ('12', '很不错的酒店，L型落地窗风景一览无余，外滩桥就在眼前。早餐丰富，大床双床都很舒适，只可惜停车另外收费令人感觉不爽，其实过夜最多二十元的服务酒店完全可以凭此赢得更多口碑。', '2', '2013-01-14', '12', '12');
INSERT INTO `roomcommit` VALUES ('13', '酒店在柳汀街立交桥旁边，很好找。离火车站很近。打车到火车站五分钟左右。走路十二三分钟左右吧。我住的是200元标准大床房，含双早。酒店设施为正常标配，相应的价格对比下会比其他快捷酒店设施来得好。酒店服务态度很好。酒店早餐七点开始，由于我们要赶早点的动车，吃不上早餐。酒店很有爱帮我们提前打包些面包鸡蛋矿泉水让我们带到火车上吃。非常好的服务态度。大赞', '3', '2013-01-15', '13', '13');
INSERT INTO `roomcommit` VALUES ('14', '早餐巨好，五种?，包子，豆浆，牛奶，橙汁，炒饭，炒面，煮鸡蛋，可以现做面条和煎蛋，炼乳，不下于三种咸菜，两个热菜，粥。。。水果。。。等等等，尤其推荐豆浆和牛奶。。。自己尝尝绝对比四星级的醇厚，牛奶绝对不是奶粉冲的那种。。。早上喝了四杯。。。而且不怕起晚，东西没了就加。。。早餐最晚九点', '4', '2013-01-16', '14', '14');
INSERT INTO `roomcommit` VALUES ('15', '酒店装修属于比较老式的，商务大床房空间蛮大，前台服务态度蛮好，这点很满意。早饭很有诚意，包子稀饭油条面包豆浆果汁咖啡炒面炒饭蛋糕点心色拉水果都有，豆浆浓厚，不是稀拉拉豆粉冲的那种，我说早饭有诚意是因为添的很及时，我感觉几分钟服务员就会出来把快吃光的食物填满，这点很不容易，我上次住的店恶心死了，早上去的晚都没吃的，这家早饭到九点结束，截止到我八点四十五分左右离开，吃的东西都还是装的满满的，不知道平时是不是也这样，总之，国庆期间，这个价格和服务，这家酒店让我很满意，下次还会过来', '5', '2013-01-17', '15', '15');
INSERT INTO `roomcommit` VALUES ('16', '第一次入住浙海感觉很舒服，门面气派，停车方便，前台服务优秀，尤其是客服李爱玲给人印象很深，我们是家庭游还有小孩，她热情周到的帮我们召车，4号早餐时出了一点小状况，她又及时帮我们解决了，非常感谢她。浙海让人有宾至如归的温暖，房间干净，卫生间又宽大，自助早餐丰富，晚上还有水果和酸奶，小孩很开心。我们也很满意，感谢携程，感谢浙海，让我们这次宁波之旅非常愉快！下次来宁波还会选择浙海！', '1', '2013-01-18', '16', '16');
INSERT INTO `roomcommit` VALUES ('17', '400块的价格，酒店位置在市区，离城隍庙（没啥可玩的），天一广场，月湖公园都蛮近的，两个红绿灯的距离。酒店是老牌四星，停车条件稍微差点，基本停在酒店门口，房间设施齐全，不过标准间床宽度窄点，老酒店一般都这样。早餐总类多，豆腐脑，油条，培根，面条等中西式都有，不过质量一般，主要定位吃饱，像培根口感很软，很一般。总体来说400块的价格对比宁波这个城市而言，差不多，稍微偏高了一点。', '2', '2013-01-19', '17', '17');
INSERT INTO `roomcommit` VALUES ('18', '我们一家人带小孩去宁波自驾游，由于开着车，没坐地面交通，所以不知道交通到底方便不。但是开车去吃排挡一条街和去老外滩都不远。设施服务卫生等，我只能说，住多少钱的店就给多少预期，三百多的房间不能指望特别好。我住的房间，浴缸掉漆了一块，乍一看以为是不干净。但是只住一晚，而且不贵，总的来说没什么好计较的。门口停车的服务人员态度都蛮好。酒店旁边是小区，还有一个小水果摊。酒店一楼是个日本料理，晚上去吃，味道还不错。', '3', '2013-01-20', '18', '18');
INSERT INTO `roomcommit` VALUES ('19', '位置还行，旁边还有几处吃饭的地方和电影院，房间挺不错的，洗澡很舒服，水压很大，网速简直赞，很快，唯一不足就是早餐太差了，菜没几样不说，有时候连杯子都没有，水果就西瓜和橘子，西瓜有时候还是那种看起来快坏的，而且连烤面包机都没有，醉了，还是第一次遇到。', '4', '2013-01-21', '19', '19');
INSERT INTO `roomcommit` VALUES ('20', '很不错的酒店，L型落地窗风景一览无余，外滩桥就在眼前。早餐丰富，大床双床都很舒适，只可惜停车另外收费令人感觉不爽，其实过夜最多二十元的服务酒店完全可以凭此赢得更多口碑。', '5', '2013-01-22', '20', '20');
INSERT INTO `roomcommit` VALUES ('21', '酒店在柳汀街立交桥旁边，很好找。离火车站很近。打车到火车站五分钟左右。走路十二三分钟左右吧。我住的是200元标准大床房，含双早。酒店设施为正常标配，相应的价格对比下会比其他快捷酒店设施来得好。酒店服务态度很好。酒店早餐七点开始，由于我们要赶早点的动车，吃不上早餐。酒店很有爱帮我们提前打包些面包鸡蛋矿泉水让我们带到火车上吃。非常好的服务态度。大赞', '1', '2013-01-23', '21', '21');
INSERT INTO `roomcommit` VALUES ('22', '早餐巨好，五种?，包子，豆浆，牛奶，橙汁，炒饭，炒面，煮鸡蛋，可以现做面条和煎蛋，炼乳，不下于三种咸菜，两个热菜，粥。。。水果。。。等等等，尤其推荐豆浆和牛奶。。。自己尝尝绝对比四星级的醇厚，牛奶绝对不是奶粉冲的那种。。。早上喝了四杯。。。而且不怕起晚，东西没了就加。。。早餐最晚九点', '2', '2013-01-24', '22', '22');
INSERT INTO `roomcommit` VALUES ('23', '酒店装修属于比较老式的，商务大床房空间蛮大，前台服务态度蛮好，这点很满意。早饭很有诚意，包子稀饭油条面包豆浆果汁咖啡炒面炒饭蛋糕点心色拉水果都有，豆浆浓厚，不是稀拉拉豆粉冲的那种，我说早饭有诚意是因为添的很及时，我感觉几分钟服务员就会出来把快吃光的食物填满，这点很不容易，我上次住的店恶心死了，早上去的晚都没吃的，这家早饭到九点结束，截止到我八点四十五分左右离开，吃的东西都还是装的满满的，不知道平时是不是也这样，总之，国庆期间，这个价格和服务，这家酒店让我很满意，下次还会过来', '3', '2013-01-25', '23', '23');
INSERT INTO `roomcommit` VALUES ('24', '第一次入住浙海感觉很舒服，门面气派，停车方便，前台服务优秀，尤其是客服李爱玲给人印象很深，我们是家庭游还有小孩，她热情周到的帮我们召车，4号早餐时出了一点小状况，她又及时帮我们解决了，非常感谢她。浙海让人有宾至如归的温暖，房间干净，卫生间又宽大，自助早餐丰富，晚上还有水果和酸奶，小孩很开心。我们也很满意，感谢携程，感谢浙海，让我们这次宁波之旅非常愉快！下次来宁波还会选择浙海！', '4', '2013-01-26', '24', '24');
INSERT INTO `roomcommit` VALUES ('25', '酒店在柳汀街立交桥旁边，很好找。离火车站很近。打车到火车站五分钟左右。走路十二三分钟左右吧。我住的是200元标准大床房，含双早。酒店设施为正常标配，相应的价格对比下会比其他快捷酒店设施来得好。酒店服务态度很好。酒店早餐七点开始，由于我们要赶早点的动车，吃不上早餐。酒店很有爱帮我们提前打包些面包鸡蛋矿泉水让我们带到火车上吃。非常好的服务态度。大赞', '5', '2013-01-27', '25', '25');
INSERT INTO `roomcommit` VALUES ('26', '早餐巨好，五种?，包子，豆浆，牛奶，橙汁，炒饭，炒面，煮鸡蛋，可以现做面条和煎蛋，炼乳，不下于三种咸菜，两个热菜，粥。。。水果。。。等等等，尤其推荐豆浆和牛奶。。。自己尝尝绝对比四星级的醇厚，牛奶绝对不是奶粉冲的那种。。。早上喝了四杯。。。而且不怕起晚，东西没了就加。。。早餐最晚九点', '1', '2013-01-28', '26', '26');
INSERT INTO `roomcommit` VALUES ('27', '酒店装修属于比较老式的，商务大床房空间蛮大，前台服务态度蛮好，这点很满意。早饭很有诚意，包子稀饭油条面包豆浆果汁咖啡炒面炒饭蛋糕点心色拉水果都有，豆浆浓厚，不是稀拉拉豆粉冲的那种，我说早饭有诚意是因为添的很及时，我感觉几分钟服务员就会出来把快吃光的食物填满，这点很不容易，我上次住的店恶心死了，早上去的晚都没吃的，这家早饭到九点结束，截止到我八点四十五分左右离开，吃的东西都还是装的满满的，不知道平时是不是也这样，总之，国庆期间，这个价格和服务，这家酒店让我很满意，下次还会过来', '2', '2013-01-29', '27', '27');
INSERT INTO `roomcommit` VALUES ('28', '第一次入住浙海感觉很舒服，门面气派，停车方便，前台服务优秀，尤其是客服李爱玲给人印象很深，我们是家庭游还有小孩，她热情周到的帮我们召车，4号早餐时出了一点小状况，她又及时帮我们解决了，非常感谢她。浙海让人有宾至如归的温暖，房间干净，卫生间又宽大，自助早餐丰富，晚上还有水果和酸奶，小孩很开心。我们也很满意，感谢携程，感谢浙海，让我们这次宁波之旅非常愉快！下次来宁波还会选择浙海！', '3', '2013-01-30', '28', '28');
INSERT INTO `roomcommit` VALUES ('29', '400块的价格，酒店位置在市区，离城隍庙（没啥可玩的），天一广场，月湖公园都蛮近的，两个红绿灯的距离。酒店是老牌四星，停车条件稍微差点，基本停在酒店门口，房间设施齐全，不过标准间床宽度窄点，老酒店一般都这样。早餐总类多，豆腐脑，油条，培根，面条等中西式都有，不过质量一般，主要定位吃饱，像培根口感很软，很一般。总体来说400块的价格对比宁波这个城市而言，差不多，稍微偏高了一点。', '4', '2013-01-31', '29', '29');
INSERT INTO `roomcommit` VALUES ('30', '我们一家人带小孩去宁波自驾游，由于开着车，没坐地面交通，所以不知道交通到底方便不。但是开车去吃排挡一条街和去老外滩都不远。设施服务卫生等，我只能说，住多少钱的店就给多少预期，三百多的房间不能指望特别好。我住的房间，浴缸掉漆了一块，乍一看以为是不干净。但是只住一晚，而且不贵，总的来说没什么好计较的。门口停车的服务人员态度都蛮好。酒店旁边是小区，还有一个小水果摊。酒店一楼是个日本料理，晚上去吃，味道还不错。', '5', '2013-02-01', '30', '30');
INSERT INTO `roomcommit` VALUES ('31', '位置还行，旁边还有几处吃饭的地方和电影院，房间挺不错的，洗澡很舒服，水压很大，网速简直赞，很快，唯一不足就是早餐太差了，菜没几样不说，有时候连杯子都没有，水果就西瓜和橘子，西瓜有时候还是那种看起来快坏的，而且连烤面包机都没有，醉了，还是第一次遇到。', '1', '2013-02-02', '31', '31');
INSERT INTO `roomcommit` VALUES ('32', '很不错的酒店，L型落地窗风景一览无余，外滩桥就在眼前。早餐丰富，大床双床都很舒适，只可惜停车另外收费令人感觉不爽，其实过夜最多二十元的服务酒店完全可以凭此赢得更多口碑。', '2', '2013-02-03', '32', '32');
INSERT INTO `roomcommit` VALUES ('33', '酒店在柳汀街立交桥旁边，很好找。离火车站很近。打车到火车站五分钟左右。走路十二三分钟左右吧。我住的是200元标准大床房，含双早。酒店设施为正常标配，相应的价格对比下会比其他快捷酒店设施来得好。酒店服务态度很好。酒店早餐七点开始，由于我们要赶早点的动车，吃不上早餐。酒店很有爱帮我们提前打包些面包鸡蛋矿泉水让我们带到火车上吃。非常好的服务态度。大赞', '3', '2013-02-04', '33', '33');
INSERT INTO `roomcommit` VALUES ('34', '早餐巨好，五种?，包子，豆浆，牛奶，橙汁，炒饭，炒面，煮鸡蛋，可以现做面条和煎蛋，炼乳，不下于三种咸菜，两个热菜，粥。。。水果。。。等等等，尤其推荐豆浆和牛奶。。。自己尝尝绝对比四星级的醇厚，牛奶绝对不是奶粉冲的那种。。。早上喝了四杯。。。而且不怕起晚，东西没了就加。。。早餐最晚九点', '4', '2013-02-05', '34', '34');
INSERT INTO `roomcommit` VALUES ('35', '酒店装修属于比较老式的，商务大床房空间蛮大，前台服务态度蛮好，这点很满意。早饭很有诚意，包子稀饭油条面包豆浆果汁咖啡炒面炒饭蛋糕点心色拉水果都有，豆浆浓厚，不是稀拉拉豆粉冲的那种，我说早饭有诚意是因为添的很及时，我感觉几分钟服务员就会出来把快吃光的食物填满，这点很不容易，我上次住的店恶心死了，早上去的晚都没吃的，这家早饭到九点结束，截止到我八点四十五分左右离开，吃的东西都还是装的满满的，不知道平时是不是也这样，总之，国庆期间，这个价格和服务，这家酒店让我很满意，下次还会过来', '5', '2013-02-06', '35', '35');
INSERT INTO `roomcommit` VALUES ('36', '第一次入住浙海感觉很舒服，门面气派，停车方便，前台服务优秀，尤其是客服李爱玲给人印象很深，我们是家庭游还有小孩，她热情周到的帮我们召车，4号早餐时出了一点小状况，她又及时帮我们解决了，非常感谢她。浙海让人有宾至如归的温暖，房间干净，卫生间又宽大，自助早餐丰富，晚上还有水果和酸奶，小孩很开心。我们也很满意，感谢携程，感谢浙海，让我们这次宁波之旅非常愉快！下次来宁波还会选择浙海！', '1', '2013-02-07', '36', '36');
INSERT INTO `roomcommit` VALUES ('37', '400块的价格，酒店位置在市区，离城隍庙（没啥可玩的），天一广场，月湖公园都蛮近的，两个红绿灯的距离。酒店是老牌四星，停车条件稍微差点，基本停在酒店门口，房间设施齐全，不过标准间床宽度窄点，老酒店一般都这样。早餐总类多，豆腐脑，油条，培根，面条等中西式都有，不过质量一般，主要定位吃饱，像培根口感很软，很一般。总体来说400块的价格对比宁波这个城市而言，差不多，稍微偏高了一点。', '2', '2013-02-08', '37', '37');
INSERT INTO `roomcommit` VALUES ('38', '我们一家人带小孩去宁波自驾游，由于开着车，没坐地面交通，所以不知道交通到底方便不。但是开车去吃排挡一条街和去老外滩都不远。设施服务卫生等，我只能说，住多少钱的店就给多少预期，三百多的房间不能指望特别好。我住的房间，浴缸掉漆了一块，乍一看以为是不干净。但是只住一晚，而且不贵，总的来说没什么好计较的。门口停车的服务人员态度都蛮好。酒店旁边是小区，还有一个小水果摊。酒店一楼是个日本料理，晚上去吃，味道还不错。', '3', '2013-02-09', '38', '38');
INSERT INTO `roomcommit` VALUES ('39', '位置还行，旁边还有几处吃饭的地方和电影院，房间挺不错的，洗澡很舒服，水压很大，网速简直赞，很快，唯一不足就是早餐太差了，菜没几样不说，有时候连杯子都没有，水果就西瓜和橘子，西瓜有时候还是那种看起来快坏的，而且连烤面包机都没有，醉了，还是第一次遇到。', '4', '2013-02-10', '39', '39');
INSERT INTO `roomcommit` VALUES ('40', '很不错的酒店，L型落地窗风景一览无余，外滩桥就在眼前。早餐丰富，大床双床都很舒适，只可惜停车另外收费令人感觉不爽，其实过夜最多二十元的服务酒店完全可以凭此赢得更多口碑。', '5', '2013-02-11', '40', '40');
INSERT INTO `roomcommit` VALUES ('41', '酒店在柳汀街立交桥旁边，很好找。离火车站很近。打车到火车站五分钟左右。走路十二三分钟左右吧。我住的是200元标准大床房，含双早。酒店设施为正常标配，相应的价格对比下会比其他快捷酒店设施来得好。酒店服务态度很好。酒店早餐七点开始，由于我们要赶早点的动车，吃不上早餐。酒店很有爱帮我们提前打包些面包鸡蛋矿泉水让我们带到火车上吃。非常好的服务态度。大赞', '1', '2013-02-12', '41', '41');
INSERT INTO `roomcommit` VALUES ('42', '早餐巨好，五种?，包子，豆浆，牛奶，橙汁，炒饭，炒面，煮鸡蛋，可以现做面条和煎蛋，炼乳，不下于三种咸菜，两个热菜，粥。。。水果。。。等等等，尤其推荐豆浆和牛奶。。。自己尝尝绝对比四星级的醇厚，牛奶绝对不是奶粉冲的那种。。。早上喝了四杯。。。而且不怕起晚，东西没了就加。。。早餐最晚九点', '2', '2013-02-13', '42', '42');
INSERT INTO `roomcommit` VALUES ('43', '酒店装修属于比较老式的，商务大床房空间蛮大，前台服务态度蛮好，这点很满意。早饭很有诚意，包子稀饭油条面包豆浆果汁咖啡炒面炒饭蛋糕点心色拉水果都有，豆浆浓厚，不是稀拉拉豆粉冲的那种，我说早饭有诚意是因为添的很及时，我感觉几分钟服务员就会出来把快吃光的食物填满，这点很不容易，我上次住的店恶心死了，早上去的晚都没吃的，这家早饭到九点结束，截止到我八点四十五分左右离开，吃的东西都还是装的满满的，不知道平时是不是也这样，总之，国庆期间，这个价格和服务，这家酒店让我很满意，下次还会过来', '3', '2013-02-14', '43', '43');
INSERT INTO `roomcommit` VALUES ('44', '第一次入住浙海感觉很舒服，门面气派，停车方便，前台服务优秀，尤其是客服李爱玲给人印象很深，我们是家庭游还有小孩，她热情周到的帮我们召车，4号早餐时出了一点小状况，她又及时帮我们解决了，非常感谢她。浙海让人有宾至如归的温暖，房间干净，卫生间又宽大，自助早餐丰富，晚上还有水果和酸奶，小孩很开心。我们也很满意，感谢携程，感谢浙海，让我们这次宁波之旅非常愉快！下次来宁波还会选择浙海！', '4', '2013-02-15', '44', '44');
INSERT INTO `roomcommit` VALUES ('45', '酒店装修属于比较老式的，商务大床房空间蛮大，前台服务态度蛮好，这点很满意。早饭很有诚意，包子稀饭油条面包豆浆果汁咖啡炒面炒饭蛋糕点心色拉水果都有，豆浆浓厚，不是稀拉拉豆粉冲的那种，我说早饭有诚意是因为添的很及时，我感觉几分钟服务员就会出来把快吃光的食物填满，这点很不容易，我上次住的店恶心死了，早上去的晚都没吃的，这家早饭到九点结束，截止到我八点四十五分左右离开，吃的东西都还是装的满满的，不知道平时是不是也这样，总之，国庆期间，这个价格和服务，这家酒店让我很满意，下次还会过来', '5', '2013-02-16', '45', '45');
INSERT INTO `roomcommit` VALUES ('46', '第一次入住浙海感觉很舒服，门面气派，停车方便，前台服务优秀，尤其是客服李爱玲给人印象很深，我们是家庭游还有小孩，她热情周到的帮我们召车，4号早餐时出了一点小状况，她又及时帮我们解决了，非常感谢她。浙海让人有宾至如归的温暖，房间干净，卫生间又宽大，自助早餐丰富，晚上还有水果和酸奶，小孩很开心。我们也很满意，感谢携程，感谢浙海，让我们这次宁波之旅非常愉快！下次来宁波还会选择浙海！', '1', '2013-02-17', '46', '46');
INSERT INTO `roomcommit` VALUES ('47', '400块的价格，酒店位置在市区，离城隍庙（没啥可玩的），天一广场，月湖公园都蛮近的，两个红绿灯的距离。酒店是老牌四星，停车条件稍微差点，基本停在酒店门口，房间设施齐全，不过标准间床宽度窄点，老酒店一般都这样。早餐总类多，豆腐脑，油条，培根，面条等中西式都有，不过质量一般，主要定位吃饱，像培根口感很软，很一般。总体来说400块的价格对比宁波这个城市而言，差不多，稍微偏高了一点。', '2', '2013-02-18', '47', '47');
INSERT INTO `roomcommit` VALUES ('48', '我们一家人带小孩去宁波自驾游，由于开着车，没坐地面交通，所以不知道交通到底方便不。但是开车去吃排挡一条街和去老外滩都不远。设施服务卫生等，我只能说，住多少钱的店就给多少预期，三百多的房间不能指望特别好。我住的房间，浴缸掉漆了一块，乍一看以为是不干净。但是只住一晚，而且不贵，总的来说没什么好计较的。门口停车的服务人员态度都蛮好。酒店旁边是小区，还有一个小水果摊。酒店一楼是个日本料理，晚上去吃，味道还不错。', '3', '2013-02-19', '48', '48');
INSERT INTO `roomcommit` VALUES ('49', '位置还行，旁边还有几处吃饭的地方和电影院，房间挺不错的，洗澡很舒服，水压很大，网速简直赞，很快，唯一不足就是早餐太差了，菜没几样不说，有时候连杯子都没有，水果就西瓜和橘子，西瓜有时候还是那种看起来快坏的，而且连烤面包机都没有，醉了，还是第一次遇到。', '4', '2013-02-20', '49', '49');
INSERT INTO `roomcommit` VALUES ('50', '很不错的酒店，L型落地窗风景一览无余，外滩桥就在眼前。早餐丰富，大床双床都很舒适，只可惜停车另外收费令人感觉不爽，其实过夜最多二十元的服务酒店完全可以凭此赢得更多口碑。', '5', '2013-02-21', '50', '50');
INSERT INTO `roomcommit` VALUES ('51', '路卡卡卡卡', '5', '2015-11-25', '1', '103');
INSERT INTO `roomcommit` VALUES ('52', '哦哦哦哦哦', '5', '2015-11-28', '3', '103');
INSERT INTO `roomcommit` VALUES ('53', 'kkkkkkkk', '5', '2015-11-29 11:01:42', '1', '103');
INSERT INTO `roomcommit` VALUES ('54', 'lllllllll', '5', '2015-11-29 11:01:47', '1', '103');
INSERT INTO `roomcommit` VALUES ('55', 'ffffff', '5', '2015-11-29 11:01:51', '1', '103');
INSERT INTO `roomcommit` VALUES ('56', '55555', '5', '2015-11-29 13:29:54', '1', '103');
INSERT INTO `roomcommit` VALUES ('57', 'hhhhhhhh', '5', '2015-11-29 14:14:44', '1', '103');
INSERT INTO `roomcommit` VALUES ('58', '44444', '5', '2015-11-29 14:14:52', '1', '103');
INSERT INTO `roomcommit` VALUES ('59', 'oooooo', '5', '2015-12-03 22:21:52', '32', '1');
INSERT INTO `roomcommit` VALUES ('60', '6666', '5', '2015-12-05 09:10:39', '4', '1');
INSERT INTO `roomcommit` VALUES ('61', '11111111', '3', '2015-12-15 21:44:06', '2', '1');

-- ----------------------------
-- Table structure for roomequipment
-- ----------------------------
DROP TABLE IF EXISTS `roomequipment`;
CREATE TABLE `roomequipment` (
  `roomEquipmentId` int(11) NOT NULL AUTO_INCREMENT,
  `PETFacilities` int(11) NOT NULL,
  `TV` int(11) NOT NULL,
  `airConditioner` int(11) NOT NULL,
  `breakfast` int(11) NOT NULL,
  `coatHanger` int(11) NOT NULL,
  `dryingMachine` int(11) NOT NULL,
  `heating` int(11) NOT NULL,
  `hotTub` int(11) NOT NULL,
  `indoorFirePlace` int(11) NOT NULL,
  `iron` int(11) NOT NULL,
  `kitchen` int(11) NOT NULL,
  `necessities` int(11) NOT NULL,
  `network` int(11) NOT NULL,
  `swimmingPool` int(11) NOT NULL,
  `washingMachine` int(11) NOT NULL,
  `wheelchairAccessible` int(11) NOT NULL,
  `workingSpace` int(11) NOT NULL,
  PRIMARY KEY (`roomEquipmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roomequipment
-- ----------------------------
INSERT INTO `roomequipment` VALUES ('1', '1', '0', '1', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0', '1', '0', '0', '0');
INSERT INTO `roomequipment` VALUES ('2', '1', '0', '1', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0', '1', '0', '0', '0');
INSERT INTO `roomequipment` VALUES ('3', '1', '0', '1', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0', '1', '0', '0', '0');
INSERT INTO `roomequipment` VALUES ('4', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('5', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('6', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('7', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('8', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('9', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('10', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('11', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('12', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('13', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('14', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('15', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('16', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('17', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('18', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('19', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('20', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('21', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('22', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('23', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('24', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('25', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('26', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('27', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('28', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('29', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('30', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('31', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('32', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('33', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('34', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('35', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('36', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('37', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('38', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('39', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('40', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('41', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('42', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('43', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('44', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('45', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('46', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('47', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('48', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('49', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `roomequipment` VALUES ('50', '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '0');
INSERT INTO `roomequipment` VALUES ('51', '0', '1', '1', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0', '1', '1', '1', '0');
INSERT INTO `roomequipment` VALUES ('52', '0', '0', '0', '0', '0', '0', '0', '0', '1', '0', '0', '1', '0', '0', '0', '0', '0');
INSERT INTO `roomequipment` VALUES ('53', '1', '1', '1', '1', '0', '1', '1', '0', '1', '0', '1', '1', '0', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for transaction
-- ----------------------------
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
  `transactionId` int(11) NOT NULL AUTO_INCREMENT,
  `transactionDetail` varchar(255) DEFAULT NULL,
  `transactionMoney` int(11) NOT NULL,
  `transactionState` int(11) NOT NULL,
  `transactionTime` varchar(255) DEFAULT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`transactionId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transaction
-- ----------------------------
INSERT INTO `transaction` VALUES ('1', '中国农业银行', '100', '1', '2015-12-14 21:32:20', '1');
INSERT INTO `transaction` VALUES ('2', '中国银行', '180', '1', '2015-12-15 23:14:40', '1');
INSERT INTO `transaction` VALUES ('3', '四季青藤2号房', '-180', '1', '2015-12-15 23:16:46', '1');
INSERT INTO `transaction` VALUES ('4', '四季青藤1号房', '-80', '1', '2015-12-15 23:20:03', '1');
INSERT INTO `transaction` VALUES ('5', '四季青藤2号房', '-180', '1', '2015-12-15 23:21:33', '1');
INSERT INTO `transaction` VALUES ('6', '四季青藤40号房', '-900', '1', '2015-12-16 14:59:06', '1');
INSERT INTO `transaction` VALUES ('7', '四季青藤40号房', '-360', '1', '2015-12-16 15:01:39', '1');
INSERT INTO `transaction` VALUES ('8', '四季青藤27号房', '-360', '1', '2015-12-16 15:07:59', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `userBalance` int(11) NOT NULL,
  `userBoth` varchar(255) DEFAULT NULL,
  `userEmail` varchar(255) DEFAULT NULL,
  `userIDNumber` varchar(255) DEFAULT NULL,
  `userMessage` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `userPassword` varchar(255) DEFAULT NULL,
  `userPhone` varchar(255) DEFAULT NULL,
  `userPicture` varchar(255) DEFAULT NULL,
  `userSex` varchar(255) DEFAULT NULL,
  `userState` int(11) NOT NULL,
  `userVIP` int(11) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('00000000001', '100', '05-22', '1072211372@qq.com', '000000000000000000', '我是……', '金超', '1', '1', 'img/rabbit.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000002', '101', '07-18', '1072211372@qq.com', '000000000000000000', null, '曲士坤', '123', '144', 'img/address-img/2.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000003', '102', '11-27', '1072211373@qq.com', '000000000000000000', null, '张俊钺', '123', '11401090109', 'img/address-img/3.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000004', '103', '02-20', '1072211374@qq.com', '000000000000000000', '我是….', '肖佳杰', '123', '11401090110', 'img/address-img/4.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000005', '104', '09-17', '1072211375@qq.com', '000000000000000000', '我是….', '方琦', '123', '11401090111', 'img/address-img/5.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000006', '105', '03-25', '1072211376@qq.com', '000000000000000000', '我是….', '张曦', '123', '11401090114', 'img/address-img/6.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000007', '106', '09-14', '1072211377@qq.com', '000000000000000000', '我是….', '唐峰', '123', '11401090117', 'img/address-img/7.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000008', '107', '03-29', '1072211378@qq.com', '000000000000000000', '我是….', '诸宏杰', '123', '11401090124', 'img/address-img/8.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000009', '108', '07-13', '1072211379@qq.com', '000000000000000000', '我是….', '陆焯强', '123', '11401090130', 'img/address-img/9.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000010', '109', '05-22', '1072211380@qq.com', '000000000000000000', '我是….', '许嘉恒', '123', '11401090135', 'img/address-img/10.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000011', '110', '10-09', '1072211381@qq.com', '000000000000000000', '我是….', '李松林', '123', '11401090139', 'img/address-img/11.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000012', '111', '10-12', '1072211382@qq.com', '000000000000000000', '我是….', '刘宇航', '123', '11401090204', 'img/address-img/12.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000013', '112', '12-02', '1072211383@qq.com', '000000000000000000', '我是….', '章迪', '123', '11401090205', 'img/address-img/13.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000014', '113', '08-20', '1072211384@qq.com', '000000000000000000', '我是….', '陈汉标', '123', '11401090206', 'img/address-img/14.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000015', '114', '09-21', '1072211385@qq.com', '000000000000000000', '我是….', '何炎丰', '123', '11401090207', 'img/address-img/15.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000016', '115', '05-27', '1072211386@qq.com', '000000000000000000', '我是….', '王若晨', '123', '11401090208', 'img/address-img/16.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000017', '116', '03-02', '1072211387@qq.com', '000000000000000000', '我是….', '王方龙', '123', '11401090209', 'img/address-img/17.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000018', '117', '03-18', '1072211388@qq.com', '000000000000000000', '我是….', '包宇炀', '123', '11401090210', 'img/address-img/18.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000019', '118', '02-25', '1072211389@qq.com', '000000000000000000', '我是….', '包跃鸿', '123', '11401090211', 'img/address-img/19.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000020', '119', '10-07', '1072211390@qq.com', '000000000000000000', '我是….', '黄文杰', '123', '11401090204', 'img/address-img/20.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000021', '120', '08-20', '1072211391@qq.com', '000000000000000000', '我是….', '杨洋', '123', '11401090205', 'img/address-img/21.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000022', '121', '02-07', '1072211392@qq.com', '000000000000000000', '我是….', '王春荣', '123', '11401090206', 'img/address-img/22.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000023', '122', '08-23', '1072211393@qq.com', '000000000000000000', '我是….', '李国强', '123', '11401090207', 'img/address-img/23.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000024', '123', '03-04', '1072211394@qq.com', '000000000000000000', '我是….', '林仙豪', '123', '11401090208', 'img/address-img/24.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000025', '124', '03-24', '1072211395@qq.com', '000000000000000000', '我是….', '丁晓靖', '123', '11401090209', 'img/address-img/25.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000026', '125', '05-07', '1072211396@qq.com', '000000000000000000', '我是….', '张宏武', '123', '11401090210', 'img/address-img/26.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000027', '126', '09-01', '1072211397@qq.com', '000000000000000000', '我是….', '岑致远', '123', '11401090211', 'img/address-img/27.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000028', '127', '08-22', '1072211398@qq.com', '000000000000000000', '我是….', '冯立', '123', '11401090204', 'img/address-img/28.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000029', '128', '11-01', '1072211399@qq.com', '000000000000000000', '我是….', '吴敏', '123', '11401090205', 'img/address-img/29.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000030', '129', '11-09', '1072211400@qq.com', '000000000000000000', '我是….', '吴昊腾', '123', '11401090206', 'img/address-img/30.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000031', '130', '09-10', '1072211401@qq.com', '000000000000000000', '我是….', '杨勇锋', '123', '11401090207', 'img/address-img/31.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000032', '131', '12-12', '1072211402@qq.com', '000000000000000000', '我是….', '戴悦翰', '123', '11401090208', 'img/address-img/32.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000033', '132', '02-11', '1072211403@qq.com', '000000000000000000', '我是….', '冯小强', '123', '11401090209', 'img/address-img/33.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000034', '133', '08-15', '1072211404@qq.com', '000000000000000000', '我是….', '吴黄晨', '123', '11401090210', 'img/address-img/34.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000035', '134', '06-10', '1072211405@qq.com', '000000000000000000', '我是….', '马庆云', '123', '11401090211', 'img/address-img/35.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000036', '135', '10-25', '1072211406@qq.com', '000000000000000000', '我是….', '章梦姣', '123', '11401090204', 'img/address-img/36.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000037', '136', '05-02', '1072211407@qq.com', '000000000000000000', '我是….', '代超', '123', '11401090205', 'img/address-img/37.jpg', '女', '0', '1');
INSERT INTO `user` VALUES ('00000000038', '137', '03-13', '1072211408@qq.com', '000000000000000000', '我是….', '沈炆', '123', '11401090206', 'img/address-img/38.jpg', '女', '0', '1');
INSERT INTO `user` VALUES ('00000000039', '138', '11-03', '1072211409@qq.com', '000000000000000000', '我是….', '漆慧鹏', '123', '11401090207', 'img/address-img/39.jpg', '女', '0', '1');
INSERT INTO `user` VALUES ('00000000040', '139', '02-22', '1072211410@qq.com', '000000000000000000', '我是….', '颜富铙', '123', '11401090208', 'img/address-img/40.jpg', '女', '0', '1');
INSERT INTO `user` VALUES ('00000000041', '140', '08-24', '1072211411@qq.com', '000000000000000000', '我是….', '徐佳栋', '123', '11401090209', 'img/address-img/41.jpg', '女', '0', '1');
INSERT INTO `user` VALUES ('00000000042', '141', '04-05', '1072211412@qq.com', '000000000000000000', '我是….', '胡军天', '123', '11401090210', 'img/address-img/42.jpg', '女', '0', '1');
INSERT INTO `user` VALUES ('00000000043', '142', '03-30', '1072211413@qq.com', '000000000000000000', '我是….', '章培超', '123', '11401090211', 'img/address-img/43.jpg', '女', '0', '1');
INSERT INTO `user` VALUES ('00000000044', '143', '10-23', '1072211414@qq.com', '000000000000000000', '我是….', '叶林华', '123', '11401090204', 'img/address-img/44.jpg', '女', '0', '1');
INSERT INTO `user` VALUES ('00000000045', '144', '05-01', '1072211415@qq.com', '000000000000000000', '我是….', '罗玉贝', '123', '11401090205', 'img/address-img/45.jpg', '女', '0', '1');
INSERT INTO `user` VALUES ('00000000046', '145', '06-26', '1072211416@qq.com', '000000000000000000', '我是….', '费晓亮', '123', '11401090206', 'img/address-img/46.jpg', '女', '0', '1');
INSERT INTO `user` VALUES ('00000000047', '146', '10-08', '1072211417@qq.com', '000000000000000000', '我是….', '俞播峰', '123', '11401090207', 'img/address-img/47.jpg', '女', '0', '1');
INSERT INTO `user` VALUES ('00000000048', '147', '09-09', '1072211418@qq.com', '000000000000000000', '我是….', '吴泽伟', '123', '11401090208', 'img/address-img/48.jpg', '女', '0', '1');
INSERT INTO `user` VALUES ('00000000049', '148', '01-19', '1072211419@qq.com', '000000000000000000', '我是….', '徐恩慧', '123', '11401090209', 'img/address-img/49.jpg', '女', '0', '1');
INSERT INTO `user` VALUES ('00000000050', '149', '08-28', '1072211420@qq.com', '000000000000000000', '我是….', '张斌', '123', '11401090210', 'img/address-img/50.jpg', '女', '0', '1');
INSERT INTO `user` VALUES ('00000000051', '150', '08-11', '1072211421@qq.com', '000000000000000000', '我是….', '张泽琪', '123', '11401090211', 'img/address-img/51.jpg', '女', '0', '1');
INSERT INTO `user` VALUES ('00000000052', '151', '02-27', '1072211422@qq.com', '000000000000000000', '我是….', '黄约沙', '123', '11401090204', 'img/address-img/52.jpg', '女', '0', '1');
INSERT INTO `user` VALUES ('00000000053', '152', '06-19', '1072211423@qq.com', '000000000000000000', '我是….', '吴建浩', '123', '11401090205', 'img/address-img/53.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000054', '153', '04-23', '1072211424@qq.com', '000000000000000000', '我是….', '陈剑', '123', '11401090206', 'img/address-img/54.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000055', '154', '11-05', '1072211425@qq.com', '000000000000000000', '我是….', '吴瑞俊', '123', '11401090207', 'img/address-img/55.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000056', '155', '01-24', '1072211426@qq.com', '000000000000000000', '我是….', '张泉', '123', '11401090208', 'img/address-img/56.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000057', '156', '07-25', '1072211427@qq.com', '000000000000000000', '我是….', '罗鹏', '123', '11401090209', 'img/address-img/57.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000058', '157', '08-11', '1072211428@qq.com', '000000000000000000', '我是….', '杨杰', '123', '11401090210', 'img/address-img/58.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000059', '158', '12-08', '1072211429@qq.com', '000000000000000000', '我是….', '汤蓓', '123', '11401090211', 'img/address-img/59.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000060', '159', '01-30', '1072211430@qq.com', '000000000000000000', '我是….', '蓝柔雪', '123', '11401090204', 'img/address-img/60.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000061', '160', '08-02', '1072211431@qq.com', '000000000000000000', '我是….', '颜法廷', '123', '11401090205', 'img/address-img/61.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000062', '161', '01-17', '1072211432@qq.com', '000000000000000000', '我是….', '谢文龙', '123', '11401090206', 'img/address-img/62.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000063', '162', '07-03', '1072211433@qq.com', '000000000000000000', '我是….', '李炊', '123', '11401090207', 'img/address-img/63.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000064', '163', '08-09', '1072211434@qq.com', '000000000000000000', '我是….', '张宏', '123', '11401090208', 'img/address-img/64.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000065', '164', '06-07', '1072211435@qq.com', '000000000000000000', '我是….', '陈凯华', '123', '11401090209', 'img/address-img/65.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000066', '165', '10-20', '1072211436@qq.com', '000000000000000000', '我是….', '吴建明', '123', '11401090210', 'img/address-img/66.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000067', '166', '01-18', '1072211437@qq.com', '000000000000000000', '我是….', '吴建标', '123', '11401090211', 'img/address-img/67.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000068', '167', '10-13', '1072211438@qq.com', '000000000000000000', '我是….', '陈欢', '123', '11401090204', 'img/address-img/68.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000069', '168', '07-22', '1072211439@qq.com', '000000000000000000', '我是….', '曹聪聪', '123', '11401090205', 'img/address-img/69.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000070', '169', '02-23', '1072211440@qq.com', '000000000000000000', '我是….', '李炜俊', '123', '11401090206', 'img/address-img/70.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000071', '170', '02-13', '1072211441@qq.com', '000000000000000000', '我是….', '孙煜杰', '123', '11401090207', 'img/address-img/71.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000072', '171', '06-04', '1072211442@qq.com', '000000000000000000', '我是….', '张垚', '123', '11401090208', 'img/address-img/72.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000073', '172', '08-22', '1072211443@qq.com', '000000000000000000', '我是….', '顾阳宇', '123', '11401090209', 'img/address-img/73.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000074', '173', '02-14', '1072211444@qq.com', '000000000000000000', '我是….', '陈俊羽', '123', '11401090210', 'img/address-img/74.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000075', '174', '04-20', '1072211445@qq.com', '000000000000000000', '我是….', '林先娜', '123', '11401090211', 'img/address-img/75.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000076', '175', '12-04', '1072211446@qq.com', '000000000000000000', '我是….', '刘胜男', '123', '11401090204', 'img/address-img/76.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000077', '176', '08-15', '1072211447@qq.com', '000000000000000000', '我是….', '张子腾', '123', '11401090205', 'img/address-img/77.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000078', '177', '07-08', '1072211448@qq.com', '000000000000000000', '我是….', '沈增涛', '123', '11401090206', 'img/address-img/78.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000079', '178', '07-15', '1072211449@qq.com', '000000000000000000', '我是….', '陈振伟', '123', '11401090207', 'img/address-img/79.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000080', '179', '06-11', '1072211450@qq.com', '000000000000000000', '我是….', '包年晖', '123', '11401090208', 'img/address-img/80.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000081', '180', '09-22', '1072211451@qq.com', '000000000000000000', '我是….', '邵润润', '123', '11401090209', 'img/address-img/81.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000082', '181', '09-18', '1072211452@qq.com', '000000000000000000', '我是….', '张文涛', '123', '11401090210', 'img/address-img/82.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000083', '182', '06-29', '1072211453@qq.com', '000000000000000000', '我是….', '陈泓鸣', '123', '11401090211', 'img/address-img/83.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000084', '183', '03-25', '1072211454@qq.com', '000000000000000000', '我是….', '张杨坚', '123', '11401090204', 'img/address-img/84.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000085', '184', '05-21', '1072211455@qq.com', '000000000000000000', '我是….', '王磊', '123', '11401090205', 'img/address-img/85.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000086', '185', '10-17', '1072211456@qq.com', '000000000000000000', '我是….', '朱昊', '123', '11401090206', 'img/address-img/86.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000087', '186', '07-21', '1072211457@qq.com', '000000000000000000', '我是….', '王昱剑', '123', '11401090207', 'img/address-img/87.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000088', '187', '03-14', '1072211458@qq.com', '000000000000000000', '我是….', '蓝峥', '123', '11401090208', 'img/address-img/88.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000089', '188', '07-29', '1072211459@qq.com', '000000000000000000', '我是….', '黄文溪', '123', '11401090209', 'img/address-img/89.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000090', '189', '03-12', '1072211460@qq.com', '000000000000000000', '我是….', '范泳琦', '123', '11401090210', 'img/address-img/90.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000091', '190', '10-22', '1072211461@qq.com', '000000000000000000', '我是….', '戴熠赟', '123', '11401090211', 'img/address-img/91.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000092', '191', '02-04', '1072211462@qq.com', '000000000000000000', '我是….', '贾俊超', '123', '11401090204', 'img/address-img/92.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000093', '192', '09-02', '1072211463@qq.com', '000000000000000000', '我是….', '吴新伟', '123', '11401090205', 'img/address-img/93.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000094', '193', '10-11', '1072211464@qq.com', '000000000000000000', '我是….', '倪辉辉', '123', '11401090206', 'img/address-img/94.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000095', '194', '03-29', '1072211465@qq.com', '000000000000000000', '我是….', '顾贤听', '123', '11401090207', 'img/address-img/95.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000096', '195', '08-11', '1072211466@qq.com', '000000000000000000', '我是….', '邱亿', '123', '11401090208', 'img/address-img/96.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000097', '196', '02-08', '1072211467@qq.com', '000000000000000000', '我是….', '许阳峰', '123', '11401090209', 'img/address-img/97.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000098', '197', '09-15', '1072211468@qq.com', '000000000000000000', '我是….', '韩焱', '123', '11401090210', 'img/address-img/98.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000099', '198', '08-24', '1072211469@qq.com', '000000000000000000', '我是….', '郑邦杰', '123', '11401090211', 'img/address-img/99.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000100', '199', '02-18', '1072211470@qq.com', '000000000000000000', '我是….', '陈钊', '123', '11401090204', 'img/address-img/100.jpg', '女', '0', '0');
INSERT INTO `user` VALUES ('00000000101', '0', '07-14', '99', null, null, '小花', '99', '99', 'img/address-img/101.jpg', null, '0', '0');
INSERT INTO `user` VALUES ('00000000103', '0', '05-11', '0000', '', '', '童童', '0000', '0000', 'img/address-img/103.jpg', '男', '0', '0');
INSERT INTO `user` VALUES ('00000000104', '0', null, '5555', null, null, '旺财', '5555', '5555', 'img/address-img/104.jpg', null, '0', '0');
INSERT INTO `user` VALUES ('00000000105', '0', null, 'ggg', null, null, 'ggggggg', 'ggg', 'ggg', 'img/address-img/105.jpg', null, '0', '0');
INSERT INTO `user` VALUES ('00000000106', '0', null, '2222', null, null, '小王', '2222', '2222', 'img/address-img/106.jpg', null, '0', '0');
INSERT INTO `user` VALUES ('00000000107', '0', null, '12222', null, null, '张三', '1', '1', 'img/rabbit.jpg', null, '0', '0');
INSERT INTO `user` VALUES ('00000000108', '0', null, '4', null, null, '张三', '2', '1', 'img/rabbit.jpg', null, '0', '0');
INSERT INTO `user` VALUES ('00000000109', '0', null, '4', null, null, '张三', '2', '1', 'img/rabbit.jpg', null, '0', '0');

-- ----------------------------
-- Table structure for usercommit
-- ----------------------------
DROP TABLE IF EXISTS `usercommit`;
CREATE TABLE `usercommit` (
  `userCommitId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `cleanerId` int(11) NOT NULL,
  `userCommitContent` varchar(255) DEFAULT NULL,
  `userCommitRank` int(11) NOT NULL,
  `userCommitTime` varchar(255) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`userCommitId`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usercommit
-- ----------------------------
INSERT INTO `usercommit` VALUES ('1', '1', '这是个....用户', '1', '41276', '1');
INSERT INTO `usercommit` VALUES ('2', '2', '这是个....用户', '1', '41277', '2');
INSERT INTO `usercommit` VALUES ('3', '3', '这是个....用户', '1', '41278', '3');
INSERT INTO `usercommit` VALUES ('4', '4', '这是个....用户', '1', '41279', '4');
INSERT INTO `usercommit` VALUES ('5', '5', '这是个....用户', '1', '41280', '5');
INSERT INTO `usercommit` VALUES ('6', '6', '这是个....用户', '1', '41281', '6');
INSERT INTO `usercommit` VALUES ('7', '7', '这是个....用户', '1', '41282', '7');
INSERT INTO `usercommit` VALUES ('8', '8', '这是个....用户', '1', '41283', '8');
INSERT INTO `usercommit` VALUES ('9', '9', '这是个....用户', '1', '41284', '9');
INSERT INTO `usercommit` VALUES ('10', '10', '这是个....用户', '1', '41285', '10');
INSERT INTO `usercommit` VALUES ('11', '11', '这是个....用户', '1', '41286', '11');
INSERT INTO `usercommit` VALUES ('12', '12', '这是个....用户', '1', '41287', '12');
INSERT INTO `usercommit` VALUES ('13', '13', '这是个....用户', '3', '41288', '13');
INSERT INTO `usercommit` VALUES ('14', '14', '这是个....用户', '3', '41289', '14');
INSERT INTO `usercommit` VALUES ('15', '15', '这是个....用户', '3', '41290', '15');
INSERT INTO `usercommit` VALUES ('16', '16', '这是个....用户', '3', '41291', '16');
INSERT INTO `usercommit` VALUES ('17', '17', '这是个....用户', '3', '41292', '17');
INSERT INTO `usercommit` VALUES ('18', '18', '这是个....用户', '3', '41293', '18');
INSERT INTO `usercommit` VALUES ('19', '19', '这是个....用户', '3', '41294', '19');
INSERT INTO `usercommit` VALUES ('20', '20', '这是个....用户', '3', '41676', '20');
INSERT INTO `usercommit` VALUES ('21', '21', '这是个....用户', '3', '41677', '21');
INSERT INTO `usercommit` VALUES ('22', '22', '这是个....用户', '3', '41678', '22');
INSERT INTO `usercommit` VALUES ('23', '23', '这是个....用户', '3', '41679', '23');
INSERT INTO `usercommit` VALUES ('24', '24', '这是个....用户', '4', '41680', '24');
INSERT INTO `usercommit` VALUES ('25', '25', '这是个....用户', '4', '41685', '25');
INSERT INTO `usercommit` VALUES ('26', '26', '这是个....用户', '4', '41686', '26');
INSERT INTO `usercommit` VALUES ('27', '27', '这是个....用户', '4', '41687', '27');
INSERT INTO `usercommit` VALUES ('28', '28', '这是个....用户', '4', '41688', '28');
INSERT INTO `usercommit` VALUES ('29', '29', '这是个....用户', '4', '41689', '29');
INSERT INTO `usercommit` VALUES ('30', '30', '这是个....用户', '4', '41690', '30');
INSERT INTO `usercommit` VALUES ('31', '31', '这是个....用户', '5', '41691', '31');
INSERT INTO `usercommit` VALUES ('32', '12', '这是个....用户', '5', '41692', '32');
INSERT INTO `usercommit` VALUES ('33', '13', '这是个....用户', '5', '41693', '33');
INSERT INTO `usercommit` VALUES ('34', '14', '这是个....用户', '5', '41694', '34');
INSERT INTO `usercommit` VALUES ('35', '15', '这是个....用户', '5', '41695', '35');
INSERT INTO `usercommit` VALUES ('36', '16', '这是个....用户', '5', '41696', '36');
INSERT INTO `usercommit` VALUES ('37', '17', '这是个....用户', '5', '41697', '37');
INSERT INTO `usercommit` VALUES ('38', '18', '这是个....用户', '5', '41698', '38');
INSERT INTO `usercommit` VALUES ('39', '19', '这是个....用户', '5', '41699', '39');
INSERT INTO `usercommit` VALUES ('40', '20', '这是个....用户', '5', '41700', '40');
INSERT INTO `usercommit` VALUES ('41', '21', '这是个....用户', '5', '41701', '41');
INSERT INTO `usercommit` VALUES ('42', '22', '这是个....用户', '5', '41702', '42');
INSERT INTO `usercommit` VALUES ('43', '23', '这是个....用户', '5', '41703', '43');
INSERT INTO `usercommit` VALUES ('44', '24', '这是个....用户', '5', '41704', '44');
INSERT INTO `usercommit` VALUES ('45', '25', '这是个....用户', '5', '41705', '45');
INSERT INTO `usercommit` VALUES ('46', '26', '这是个....用户', '5', '41706', '46');
INSERT INTO `usercommit` VALUES ('47', '21', '这是个....用户', '4', '41681', '47');
INSERT INTO `usercommit` VALUES ('48', '22', '这是个....用户', '4', '41682', '48');
INSERT INTO `usercommit` VALUES ('49', '23', '这是个....用户', '4', '41683', '49');
INSERT INTO `usercommit` VALUES ('50', '24', '这是个....用户', '4', '41684', '50');
