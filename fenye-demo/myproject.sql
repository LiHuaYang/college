/*
Navicat MySQL Data Transfer

Source Server         : 主机
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : myproject

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-12-07 11:10:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------


-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `sex` varchar(6) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `parentName` varchar(10) DEFAULT NULL,
  `parentPhone` varchar(15) DEFAULT NULL,
  `banji` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三', '女', '6', '张古', '13456523277', 'A');
INSERT INTO `student` VALUES ('2', '李四', '男', '5', null, '13456523277', 'B');
INSERT INTO `student` VALUES ('3', '王五', '男', '6', null, '13456523277', 'L');
INSERT INTO `student` VALUES ('4', '俞季霓', '女', '5', null, '13456523277', 'C');
INSERT INTO `student` VALUES ('5', '杨一舟', '男', '7', null, '13456523277', 'N');
INSERT INTO `student` VALUES ('6', '张煜妍', '女', '8', null, '13456523277', 'I');
INSERT INTO `student` VALUES ('7', '吴祥', '男', '9', null, '13456523277', 'J');
INSERT INTO `student` VALUES ('8', '黄依婷', '女', '10', null, '13456523277', 'K');
INSERT INTO `student` VALUES ('9', '严佳祺', '女', '11', null, '13456523277', 'Q');
INSERT INTO `student` VALUES ('10', '朱铭珂', '女', '12', null, '13456523277', 'E');
INSERT INTO `student` VALUES ('11', '刘益涵', '女', '13', null, '13456523277', 'H');
INSERT INTO `student` VALUES ('12', '程煜麒', '男', '13', null, '13456523277', 'U');
INSERT INTO `student` VALUES ('13', '顾虞宁', '男', '4', null, '13456523277', 'D');
INSERT INTO `student` VALUES ('14', '姚一诺', '女', '5', null, '13456523277', 'O');
INSERT INTO `student` VALUES ('15', '顾梦怡', '女', '6', null, '13456523277', 'R');
INSERT INTO `student` VALUES ('16', '周雨欣', '女', '7', null, '13456523277', 'P');
INSERT INTO `student` VALUES ('17', '王锦文', '男', '8', null, '13456523277', 'S');
INSERT INTO `student` VALUES ('18', '姚王好', '女', '9', null, '13456523277', 'O');
INSERT INTO `student` VALUES ('19', '周张悠然', '男', '10', null, '13456523277', 'G');
INSERT INTO `student` VALUES ('20', '周陈宇', '男', '11', null, '13456523277', 'F');
INSERT INTO `student` VALUES ('21', '戈清正', '男', '12', null, '13456523277', 'T');
INSERT INTO `student` VALUES ('22', '王书涵', '女', '10', null, '13456523277', 'M');
INSERT INTO `student` VALUES ('23', '王奕阳', '男', '8', null, '13456523277', 'A');
INSERT INTO `student` VALUES ('24', '解尹冠', '女', '7', null, '13456523277', 'C');
INSERT INTO `student` VALUES ('25', '顾子晨', '女', '8', null, '13456523277', 'T');
INSERT INTO `student` VALUES ('26', '姚子安', '男', '9', null, '13456523277', 'S');
INSERT INTO `student` VALUES ('27', '钱悦淇', '女', '10', null, '13456523277', 'H');
INSERT INTO `student` VALUES ('28', '唐浩洋', '男', '7', null, '13456523277', 'J');
INSERT INTO `student` VALUES ('29', '王天雅', '女', '8', null, '13456523277', 'K');
INSERT INTO `student` VALUES ('30', '朱煜辉', '男', '9', null, '13456523277', 'L');
INSERT INTO `student` VALUES ('31', '宋小宝', '男', '10', '宋大宝', '13456523277', 'L');
INSERT INTO `student` VALUES ('32', '李四', '男', '5', null, '13456523277', 'B');
INSERT INTO `student` VALUES ('33', '王五', '男', '6', null, '13456523277', 'L');
INSERT INTO `student` VALUES ('34', '俞季霓', '女', '5', null, '13456523277', 'C');
INSERT INTO `student` VALUES ('35', '杨一舟', '男', '7', null, '13456523277', 'N');
INSERT INTO `student` VALUES ('36', '张煜妍', '女', '8', null, '13456523277', 'I');
INSERT INTO `student` VALUES ('37', '吴祥', '男', '9', null, '13456523277', 'J');
INSERT INTO `student` VALUES ('38', '黄依婷', '女', '10', null, '13456523277', 'K');
INSERT INTO `student` VALUES ('39', '严佳祺', '女', '11', null, '13456523277', 'Q');
INSERT INTO `student` VALUES ('40', '朱铭珂', '女', '12', null, '13456523277', 'E');
INSERT INTO `student` VALUES ('41', '刘益涵', '女', '13', null, '13456523277', 'H');
INSERT INTO `student` VALUES ('42', '程煜麒', '男', '13', null, '13456523277', 'U');
INSERT INTO `student` VALUES ('43', '顾虞宁', '男', '4', null, '13456523277', 'D');
INSERT INTO `student` VALUES ('44', '姚一诺', '女', '5', null, '13456523277', 'O');
INSERT INTO `student` VALUES ('45', '顾梦怡', '女', '6', null, '13456523277', 'R');
INSERT INTO `student` VALUES ('46', '周雨欣', '女', '7', null, '13456523277', 'P');
INSERT INTO `student` VALUES ('47', '王锦文', '男', '8', null, '13456523277', 'S');
INSERT INTO `student` VALUES ('48', '姚王好', '女', '9', null, '13456523277', 'O');
INSERT INTO `student` VALUES ('49', '周张悠然', '男', '10', null, '13456523277', 'G');
INSERT INTO `student` VALUES ('50', '周陈宇', '男', '11', null, '13456523277', 'F');
INSERT INTO `student` VALUES ('51', '戈清正', '男', '12', null, '13456523277', 'T');
INSERT INTO `student` VALUES ('52', '王书涵', '女', '10', null, '13456523277', 'M');
INSERT INTO `student` VALUES ('53', '王奕阳', '男', '8', null, '13456523277', 'A');
INSERT INTO `student` VALUES ('54', '解尹冠', '女', '7', null, '13456523277', 'C');
INSERT INTO `student` VALUES ('55', '顾子晨', '女', '8', null, '13456523277', 'T');
INSERT INTO `student` VALUES ('56', '姚子安', '男', '9', null, '13456523277', 'S');
INSERT INTO `student` VALUES ('57', '钱悦淇', '女', '10', null, '13456523277', 'H');
INSERT INTO `student` VALUES ('58', '唐浩洋', '男', '7', null, '13456523277', 'J');
INSERT INTO `student` VALUES ('59', '王天雅', '女', '8', null, '13456523277', 'K');
INSERT INTO `student` VALUES ('60', '朱煜辉', '男', '9', null, '13456523277', 'L');
INSERT INTO `student` VALUES ('61', '张三', '女', '6', '张古', '13456523277', 'A');
