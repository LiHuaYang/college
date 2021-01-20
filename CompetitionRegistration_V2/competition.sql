/*
Navicat MySQL Data Transfer

Source Server         : 主机
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : competition

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-09-24 17:37:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for areabasicdata
-- ----------------------------
DROP TABLE IF EXISTS `areabasicdata`;
CREATE TABLE `areabasicdata` (
  `AreaId` int(11) NOT NULL AUTO_INCREMENT,
  `AreaAddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`AreaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of areabasicdata
-- ----------------------------

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `CollectId` int(11) NOT NULL AUTO_INCREMENT,
  `CollectName` varchar(255) DEFAULT NULL,
  `CollectTime` varchar(255) DEFAULT NULL,
  `CollectState` int(11) DEFAULT NULL,
  `TestPaperId` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`CollectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------

-- ----------------------------
-- Table structure for competition
-- ----------------------------
DROP TABLE IF EXISTS `competition`;
CREATE TABLE `competition` (
  `CompetitionId` int(11) NOT NULL AUTO_INCREMENT,
  `CompetitionName` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `CompetitionSession` int(11) DEFAULT NULL,
  `CompetitionInfo` varchar(5000) CHARACTER SET gbk DEFAULT NULL,
  `ParticularYear` int(11) DEFAULT NULL,
  `CommitteeName` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `CommitteePhone` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `CommitteeAddress` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `CompetitionSponsor` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `CompetitionTimeDescribe` varchar(1000) CHARACTER SET gbk DEFAULT NULL,
  `CompetitionPrize` varchar(1000) CHARACTER SET gbk DEFAULT NULL,
  `CompetitionObjectDescribe` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `CompetitionPriceDescribe` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `CompetitionPicture` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `CompetitionPropaganda` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `CompetitionState` int(11) DEFAULT NULL,
  `CompetitionEnrollStartTime` varchar(255) DEFAULT NULL,
  `CompetitionEnrollEndTime` varchar(255) DEFAULT NULL,
  `CompetitionBriefInfo` varchar(255) DEFAULT NULL,
  `CompetitionBriefName` varchar(255) DEFAULT NULL,
  `CompetitionPictureBig` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CompetitionId`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of competition
-- ----------------------------
INSERT INTO `competition` VALUES ('38', '2016年浙江省优尔杯英语大赛', '1', '<p style=\"text-align: center;\">&nbsp;<span style=\"font-size:16px\"><strong>&nbsp;&nbsp;第一届浙江省&ldquo;优尔杯&rdquo;小学生英语阅读能力训练活动</strong></span></p>\n\n<p>&nbsp;&nbsp;&nbsp;2016年，G20峰会；2022年，亚运会；杭州即将引来一大批国际性的活动，根据《教育部关于进一步推进长江三角洲地区教育改革与合作发展的指导意见》（教发〔2014〕7号）、《杭州市推进教育国际化行动计划》的指导思想，帮助本市学有余力的小学生提高英语水平、检验学习成果；同时也为各个优质学校提供小学生英语的实际学习能力参考评估。 &nbsp;&nbsp;</p>\n\n<p><strong>一、活动宗旨：</strong></p>\n\n<p>通过英语阅读能力测评，对学生的阶段学习进行评价，让学生对自己的英语能力有清晰的认知，并得到比较清晰的展现，鼓励学生努力学习和进步，培养学生学习兴趣，开拓学生的国际化视野，从而更好的为以后的学习和生活服务。 &nbsp;&nbsp;&nbsp;</p>\n\n<p><strong>二、主办单位：</strong></p>\n\n<p>钱江晚报</p>\n\n<p>浙江省中小学生思维能力训练活动组委会</p>\n\n<p><strong>三、承办单位：</strong></p>\n\n<p>杭州赛区：杭州孔怀教育科技有限公司</p>\n\n<p>宁波赛区：宁波资优教育科技有限公司（资优少年）</p>\n\n<p><strong>四、参加对象：</strong></p>\n\n<p>浙江省小学生三年级～五年级</p>\n\n<p><strong>五、活动时间：</strong></p>\n\n<p>每年二次，上半年参赛时间为五月，下半年参赛时间为十月</p>\n\n<p><strong>六、活动方式：</strong></p>\n\n<p>1.本届活动分为小学三、四、五年级共三个级别只进行一轮决赛；</p>\n\n<p>2.每年二次，五月份为三、四、五共三个年级组，十月份为四、五、六年级组</p>\n\n<p>3.比赛费用：参与选拔赛的学生需要交纳60元，用以组委会组织、场地租赁、监考、评审及证书制作等支出。</p>\n\n<ol>\n	<li>命题依据：赛事题目坚持趣味性、新颖性、实践性相结合的命题原则。考察课内同步学习的知识，同时也包含能力拓展类的内容。&nbsp;</li>\n</ol>\n\n<p><strong>七、报名时间：</strong></p>\n\n<p>2016年4月6日启动报名，报名截止日期为2016年5月9日，学生可向经过组委会认证的相关机构进行报名。</p>\n\n<p><strong>八、比赛时间：</strong></p>\n\n<p>2016年5月22日（周日）下午</p>\n\n<p><strong>九、奖励方法：</strong></p>\n\n<ol>\n	<li>组委会依据成绩评出各个年级组的一、二、三等奖，全市按30%比例，同时按一等奖5%，二等奖10%，三等奖15%。更特别的是，同时&ldquo;优尔杯&rdquo;英语活动将对每位参赛选手进行阅读能力评估，颁发《活动评估证书》。</li>\n	<li>组委会将设置&ldquo;优秀教师奖&rdquo;，表彰在活动组织、辅导学生等方面做出突出贡献的教师。</li>\n</ol>\n\n<p>&nbsp;</p>\n\n<p>宁波地区组委会：资优少年</p>\n\n<p>咨询热线：0574-87629722 &nbsp;15381037668 褚老师</p>\n\n<p>报名地址：宁波工程学院西校区（翠柏路89号1号教学楼306室）</p>\n\n<p>&nbsp;</p>\n\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;浙江省中小学生思维能力训练活动组委会</p>\n\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2016年4月6日</p>\n', '0', 'null', 'null', 'null', '钱江晚报\n浙江省中小学生思维能力训练活动组委会', '2016年5月22日（周日）下午', '全市按30%的比例评出各个年级组的一、二、三等奖（一等奖5%，二等奖10%，三等奖15%）；并设置优秀教师奖。', '三年级至五年级', '60元', 'Web/image/2016_04_15_152533.png', 'Show your English！', '5', '2016-04-06', '2016-05-09', '通过英语阅读能力测评，对学生的阶段学习进行评价，让学生对自己的英语能力有清晰的认知，并得到比较清晰的展现，鼓励学生努力学习和进步，培养学生学习兴趣，开拓学生的国际化视野，从而更好的为以后的学习和生活服务。', null, 'Web/image/2016_04_15_152542.jpg');
INSERT INTO `competition` VALUES ('39', '2016年全国小学生语文竞赛初赛', '9', '<p style=\"text-align: center;\"><span style=\"font-size:16px\"><strong>2016年全国小学生语文竞赛通知</strong></span></p>\n\n<p><strong>一、竞赛目的：</strong>&nbsp;</p>\n\n<p>本竞赛系全国性的小学语文学科综合检测与激励机制，旨在引导小学生在学好语文基础知识的同时适当拓宽知识面，优化知识结构，提高学习语文的兴趣，促进小学生语文能力的整体发展和综合提高；检测小学生母语综合运用能力的同时，锻炼其掌握语文知识和技能的思维能力与智力品质；通过各级奖项的设置，激励在小学语文教与学上成绩优秀的师生，同时为小学语文教师提供新鲜的教学资源和教学信息，以促进语文教学水平的进一步提高，培养出更多有创新精神的高素质小学生。</p>\n\n<p><strong>二、组织单位：</strong></p>\n\n<p>主办单位：</p>\n\n<p>中国少先队事业发展中心；</p>\n\n<p>全国小学生学习能力培养活动中心；</p>\n\n<p>天仁报业集团语文学习报社北京研发中心；</p>\n\n<p>宁波地区实施机构：</p>\n\n<p>资优少年；</p>\n\n<p><strong>三、参赛对象：</strong></p>\n\n<p>全市在校小学生均可参加；</p>\n\n<p><strong>四、组别设置：</strong></p>\n\n<p>一年级组、二年级组、三年级组、四年级组、五年级组、六年级组；</p>\n\n<p><strong>五、竞赛时间：</strong></p>\n\n<p>1、报名时间：即日起至2016年3月27日（星期天），逾期报名，一律不收；</p>\n\n<p>2、初赛时间：2016年4月23日（星期六）</p>\n\n<p>一、二年级：9:00-10:00，60分钟；</p>\n\n<p>三、四、五、六年级：9:00-10:30，90分钟；</p>\n\n<p>3、复赛时间：2016年5月21日（星期六）</p>\n\n<p>一、二年级：9:00-10:00，60分钟；</p>\n\n<p>三、四、五、六年级：9:00-10:30，90分钟；</p>\n\n<p><strong>六、参赛费用：</strong></p>\n\n<p>初赛参赛费用：50元/位；</p>\n\n<p>决赛参赛费用：60元/位；</p>\n\n<p><strong>七、竞赛形式：</strong></p>\n\n<p>初赛及决赛形式：（含听力测试）方式为闭卷，笔答，听力测试在规定时间内以播放录音的形式进行，初、决赛试题全部由全国竞赛组委会统一命制；</p>\n\n<p><strong>八、竞赛内容：</strong></p>\n\n<p>初赛命题范围：各个版本语文教材2016年4月23日前所学课本内容知识；</p>\n\n<p>决赛命题范围：各个版本语文教材2016年5月21日前所学课本内容知识；</p>\n\n<p><strong>九、晋级比例及奖项设置：</strong></p>\n\n<p>初赛：初赛由各个考点进行组织考试，由组委会统一巡考，晋级决赛比例为35%；</p>\n\n<p>决赛：决赛为宁波市统一考试，并设立全国一等奖（5%）、二等奖（10%）、三等奖（15%），师生同奖；</p>\n\n<p>十、宁波组委会：</p>\n\n<p>宁波组委会：资优少年</p>\n\n<p>联系方式：0574-87629722&nbsp;&nbsp;&nbsp;15381037668&nbsp;&nbsp;褚老师</p>\n\n<p>联系地址：宁波海曙区翠柏路89号宁波工程学院1号教学楼306-308室；</p>\n\n<p>&nbsp;</p>\n\n<p>宁波市各报名点信息：</p>\n\n<p>&nbsp;</p>\n\n<p>宁波市区：</p>\n\n<p>宁波博文教育</p>\n\n<p>联系方式：0574-27722700</p>\n\n<p>报名地址：宁波市海曙区世纪广场A座306室</p>\n\n<p>&nbsp;</p>\n\n<p>宁波全心教育</p>\n\n<p>联系方式：0574-27856248</p>\n\n<p>报名地址：宁波市海曙区卖鱼路68号（广发银行2楼，水利局旁）</p>\n\n<p>&nbsp;</p>\n\n<p>宁波智汇教育</p>\n\n<p>联系方式：0574-87248828</p>\n\n<p>报名地址：宁波市江东区百丈东路934号（鄞州越剧团3F）</p>\n\n<p>&nbsp;</p>\n\n<p>宁波乐恩教育</p>\n\n<p>联系方式：0574-87751899</p>\n\n<p>报名地址：宁波市江东区百丈路黄栀花巷67号名江新都二楼</p>\n\n<p>&nbsp;</p>\n\n<p>宁波夏昂教育</p>\n\n<p>联系方式：0574-87130101</p>\n\n<p>报名地址：宁波市海曙区中山西路11号海曙大厦5楼</p>\n\n<p>&nbsp;</p>\n\n<p>镇海地区：</p>\n\n<p>宁波弘源教育</p>\n\n<p>联系方式：15267855349</p>\n\n<p>报名地址：宁波市镇海区庄市街道聚兴路31-35号</p>\n\n<p>&nbsp;</p>\n\n<p>宁波汇贤教育</p>\n\n<p>咨询电话：0574-26863366</p>\n\n<p>报名地址：宁波市镇海区招宝广场四楼</p>\n\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\n\n<p>奉化地区：</p>\n\n<p>奉化格致教育</p>\n\n<p>联系方式：0574-88587727</p>\n\n<p>报名地址：宁波奉化岳林路12号1号楼204（银泰城南侧）</p>\n\n<p>&nbsp;</p>\n\n<p>宁海地区：</p>\n\n<p>宁海一品教育</p>\n\n<p>联系方式：0574-65528761</p>\n\n<p>报名地址：宁波宁海县跃龙街道中山中路133号</p>\n\n<p>&nbsp;</p>\n\n<p>北仑地区：</p>\n\n<p>北仑乐读学苑</p>\n\n<p>联系方式：0574-86821281</p>\n\n<p>报名地址：宁波市北仑区新大路996号1幢306乐读学苑</p>\n\n<p>&nbsp;</p>\n\n<p>余姚地区：</p>\n\n<p>贝尔学校姚江中心&nbsp;</p>\n\n<p>电话:0574-62682200&nbsp;62686556</p>\n\n<p>地址:余姚市南滨江路52号</p>\n\n<p>&nbsp;</p>\n\n<p>贝尔学校南华中心&nbsp;</p>\n\n<p>电话:0574-62790055&nbsp;&nbsp;62790066</p>\n\n<p>地址:余姚市南华大厦商务楼四明西路551号三楼</p>\n\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\n\n<p>贝尔学校泗门中心&nbsp;</p>\n\n<p>电话：0574-62780078&nbsp;</p>\n\n<p>地址：余姚市泗门河塍路201号&nbsp;</p>\n\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\n\n<p>贝尔学校东江中心&nbsp;</p>\n\n<p>电话：0574-662688228&nbsp;</p>\n\n<p>地址：余姚市中山北路东江明珠C座8楼&nbsp;</p>\n\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\n\n<p>贝尔学校洛克菲幼少天分开发中心&nbsp;</p>\n\n<p>电话：0574-62786161&nbsp;</p>\n\n<p>地址：余姚市银亿四明广场B1-308</p>\n\n<p>&nbsp;</p>\n', '0', 'null', 'null', 'null', '主办单位：\n\n中国少先队事业发展中心；\n\n全国小学生学习能力培养活动中心；\n\n天仁报业集团语文学习报社北京研发中心；\n\n宁波地区实施机构：\n\n资优少年；', '2016年4月23日（星期六）', '初赛晋级决赛比例为35%；决赛为宁波市统一考试，并设立全国一等奖（5%）、二等奖（10%）、三等奖（15%），师生同奖；', '一年级至六年级', '初赛晋级决赛比例为35%；决赛为宁波市统一考试，并设立全国一等奖（5%）、二等奖（10%）、三等奖（15%），师生同奖；', 'Web/image/2016_04_20_101855.jpg', '值得参与！', '2', '2016-05-09', '2016-05-12', '本竞赛系全国性的小学语文学科综合检测与激励机制，旨在引导小学生在学好语文基础知识的同时适当拓宽知识面，优化知识结构，提高学习语文的兴趣，促进小学生语文能力的整体发展和综合提高；检测小学生母语综合运用能力的同时，锻炼其掌握语文知识和技能的思维能力与智力品质；通过各级奖项的设置，激励在小学语文教与学上成绩优秀的师生，同时为小学语文教师提供新鲜的教学资源和教学信息，以促进语文教学水平的进一步提高，培养出更多有创新精神的高素质小学生。', null, 'Web/image/2016_04_20_101812.jpg');
INSERT INTO `competition` VALUES ('40', '2016年全国小学生语文竞赛决赛', '9', '<p style=\"text-align: center;\"><span style=\"font-size:16px\"><strong>2016年全国小学生语文竞赛通知</strong></span></p>\n\n<p><strong>一、竞赛目的：&nbsp;</strong></p>\n\n<p>本竞赛系全国性的小学语文学科综合检测与激励机制，旨在引导小学生在学好语文基础知识的同时适当拓宽知识面，优化知识结构，提高学习语文的兴趣，促进小学生语文能力的整体发展和综合提高；检测小学生母语综合运用能力的同时，锻炼其掌握语文知识和技能的思维能力与智力品质；通过各级奖项的设置，激励在小学语文教与学上成绩优秀的师生，同时为小学语文教师提供新鲜的教学资源和教学信息，以促进语文教学水平的进一步提高，培养出更多有创新精神的高素质小学生。</p>\n\n<p><strong>二、组织单位：</strong></p>\n\n<p>主办单位：</p>\n\n<p>中国少先队事业发展中心；</p>\n\n<p>全国小学生学习能力培养活动中心；</p>\n\n<p>天仁报业集团语文学习报社北京研发中心；</p>\n\n<p>宁波地区实施机构：</p>\n\n<p>资优少年；</p>\n\n<p><strong>三、参赛对象：</strong></p>\n\n<p>全市在校小学生均可参加；</p>\n\n<p><strong>四、组别设置：</strong></p>\n\n<p>一年级组、二年级组、三年级组、四年级组、五年级组、六年级组；</p>\n\n<p><strong>五、竞赛时间：</strong></p>\n\n<p>1、报名时间：即日起至2016年3月27日（星期天），逾期报名，一律不收；</p>\n\n<p>2、初赛时间：2016年4月23日（星期六）</p>\n\n<p>一、二年级：9:00-10:00，60分钟；</p>\n\n<p>三、四、五、六年级：9:00-10:30，90分钟；</p>\n\n<p>3、复赛时间：2016年5月21日（星期六）</p>\n\n<p>一、二年级：9:00-10:00，60分钟；</p>\n\n<p>三、四、五、六年级：9:00-10:30，90分钟；</p>\n\n<p><strong>六、参赛费用：</strong></p>\n\n<p>初赛参赛费用：50元/位；</p>\n\n<p>决赛参赛费用：60元/位；</p>\n\n<p><strong>七、竞赛形式：</strong></p>\n\n<p>初赛及决赛形式：（含听力测试）方式为闭卷，笔答，听力测试在规定时间内以播放录音的形式进行，初、决赛试题全部由全国竞赛组委会统一命制；</p>\n\n<p><strong>八、竞赛内容：</strong></p>\n\n<p>初赛命题范围：各个版本语文教材2016年4月23日前所学课本内容知识；</p>\n\n<p>决赛命题范围：各个版本语文教材2016年5月21日前所学课本内容知识；</p>\n\n<p><strong>九、晋级比例及奖项设置：</strong></p>\n\n<p>初赛：初赛由各个考点进行组织考试，由组委会统一巡考，晋级决赛比例为35%；</p>\n\n<p>决赛：决赛为宁波市统一考试，并设立全国一等奖（5%）、二等奖（10%）、三等奖（15%），师生同奖；</p>\n\n<p><strong>十、宁波组委会：</strong></p>\n\n<p>宁波组委会：资优少年</p>\n\n<p>联系方式：0574-87629722&nbsp;&nbsp;&nbsp;15381037668&nbsp;&nbsp;褚老师</p>\n\n<p>联系地址：宁波海曙区翠柏路89号宁波工程学院1号教学楼306-308室；</p>\n\n<p>&nbsp;</p>\n\n<p><strong>宁波市各报名点信息：</strong></p>\n\n<p>&nbsp;</p>\n\n<p>宁波市区：</p>\n\n<p>宁波博文教育</p>\n\n<p>联系方式：0574-27722700</p>\n\n<p>报名地址：宁波市海曙区世纪广场A座306室</p>\n\n<p>&nbsp;</p>\n\n<p>宁波全心教育</p>\n\n<p>联系方式：0574-27856248</p>\n\n<p>报名地址：宁波市海曙区卖鱼路68号（广发银行2楼，水利局旁）</p>\n\n<p>&nbsp;</p>\n\n<p>宁波智汇教育</p>\n\n<p>联系方式：0574-87248828</p>\n\n<p>报名地址：宁波市江东区百丈东路934号（鄞州越剧团3F）</p>\n\n<p>&nbsp;</p>\n\n<p>宁波乐恩教育</p>\n\n<p>联系方式：0574-87751899</p>\n\n<p>报名地址：宁波市江东区百丈路黄栀花巷67号名江新都二楼</p>\n\n<p>&nbsp;</p>\n\n<p>宁波夏昂教育</p>\n\n<p>联系方式：0574-87130101</p>\n\n<p>报名地址：宁波市海曙区中山西路11号海曙大厦5楼</p>\n\n<p>&nbsp;</p>\n\n<p>镇海地区：</p>\n\n<p>宁波弘源教育</p>\n\n<p>联系方式：15267855349</p>\n\n<p>报名地址：宁波市镇海区庄市街道聚兴路31-35号</p>\n\n<p>&nbsp;</p>\n\n<p>宁波汇贤教育</p>\n\n<p>咨询电话：0574-26863366</p>\n\n<p>报名地址：宁波市镇海区招宝广场四楼</p>\n\n<p>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;</p>\n\n<p>奉化地区：</p>\n\n<p>奉化格致教育</p>\n\n<p>联系方式：0574-88587727</p>\n\n<p>报名地址：宁波奉化岳林路12号1号楼204（银泰城南侧）</p>\n\n<p>&nbsp;</p>\n\n<p>宁海地区：</p>\n\n<p>宁海一品教育</p>\n\n<p>联系方式：0574-65528761</p>\n\n<p>报名地址：宁波宁海县跃龙街道中山中路133号</p>\n\n<p>&nbsp;</p>\n\n<p>北仑地区：</p>\n\n<p>北仑乐读学苑</p>\n\n<p>联系方式：0574-86821281</p>\n\n<p>报名地址：宁波市北仑区新大路996号1幢306乐读学苑</p>\n\n<p>&nbsp;</p>\n\n<p>余姚地区：</p>\n\n<p>贝尔学校姚江中心&nbsp;</p>\n\n<p>电话:0574-62682200&nbsp;62686556</p>\n\n<p>地址:余姚市南滨江路52号</p>\n\n<p>&nbsp;</p>\n\n<p>贝尔学校南华中心&nbsp;</p>\n\n<p>电话:0574-62790055&nbsp;&nbsp;62790066</p>\n\n<p>地址:余姚市南华大厦商务楼四明西路551号三楼</p>\n\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\n\n<p>贝尔学校泗门中心&nbsp;</p>\n\n<p>电话：0574-62780078&nbsp;</p>\n\n<p>地址：余姚市泗门河塍路201号&nbsp;</p>\n\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\n\n<p>贝尔学校东江中心&nbsp;</p>\n\n<p>电话：0574-662688228&nbsp;</p>\n\n<p>地址：余姚市中山北路东江明珠C座8楼&nbsp;</p>\n\n<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>\n\n<p>贝尔学校洛克菲幼少天分开发中心&nbsp;</p>\n\n<p>电话：0574-62786161&nbsp;</p>\n\n<p>地址：余姚市银亿四明广场B1-308</p>\n\n<p>&nbsp;</p>\n', '0', 'null', 'null', 'null', '\n中国少先队事业发展中心；\n\n全国小学生学习能力培养活动中心；\n\n天仁报业集团语文学习报社北京研发中心；\n\n宁波地区实施机构：\n\n资优少年；', '2016年5月21日（星期六）', '初赛晋级决赛比例为35%；决赛为宁波市统一考试，并设立全国一等奖（5%）、二等奖（10%）、三等奖（15%），师生同奖；', '一年级至六年级', '初赛晋级决赛比例为35%；决赛为宁波市统一考试，并设立全国一等奖（5%）、二等奖（10%）、三等奖（15%），师生同奖；', 'Web/image/2016_04_20_101855.jpg', '值得参加', '0', '', '2016-03-27', '本竞赛系全国性的小学语文学科综合检测与激励机制，旨在引导小学生在学好语文基础知识的同时适当拓宽知识面，优化知识结构，提高学习语文的兴趣，促进小学生语文能力的整体发展和综合提高；检测小学生母语综合运用能力的同时，锻炼其掌握语文知识和技能的思维能力与智力品质；通过各级奖项的设置，激励在小学语文教与学上成绩优秀的师生，同时为小学语文教师提供新鲜的教学资源和教学信息，以促进语文教学水平的进一步提高，培养出更多有创新精神的高素质小学生。', null, 'Web/image/2016_04_20_102649.jpg');

-- ----------------------------
-- Table structure for competitionbasicdata
-- ----------------------------
DROP TABLE IF EXISTS `competitionbasicdata`;
CREATE TABLE `competitionbasicdata` (
  `CompetitionBasicId` int(11) NOT NULL AUTO_INCREMENT,
  `CompetitionBasicName` varchar(255) DEFAULT NULL,
  `CompetitionBasicNickName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CompetitionBasicId`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of competitionbasicdata
-- ----------------------------
INSERT INTO `competitionbasicdata` VALUES ('100', '2016年浙江省优尔杯英语大赛', '优尔杯');
INSERT INTO `competitionbasicdata` VALUES ('101', '2016年全国小学生语文竞赛', '小语赛');
INSERT INTO `competitionbasicdata` VALUES ('102', '2016年全国小学生语文竞赛初赛', '小语赛');
INSERT INTO `competitionbasicdata` VALUES ('103', '2016年全国小学生语文竞赛决赛', '小语赛');
INSERT INTO `competitionbasicdata` VALUES ('104', '2016年小学“希望杯”全国数学邀请赛', '希望杯');
INSERT INTO `competitionbasicdata` VALUES ('105', '2016年中学“希望杯”全国数学邀请赛', '希望杯');

-- ----------------------------
-- Table structure for contest
-- ----------------------------
DROP TABLE IF EXISTS `contest`;
CREATE TABLE `contest` (
  `ContestId` int(11) NOT NULL AUTO_INCREMENT,
  `ContestObject` int(11) DEFAULT NULL,
  `ContestSubject` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `ContestMoney` int(11) DEFAULT NULL,
  `CompetitionId` int(11) DEFAULT NULL,
  `UserId` int(11) DEFAULT NULL,
  `ContestState` int(11) DEFAULT NULL,
  `StartTime` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `EndTime` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `ContestexamType` varchar(11) CHARACTER SET gbk DEFAULT NULL,
  PRIMARY KEY (`ContestId`)
) ENGINE=InnoDB AUTO_INCREMENT=392 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contest
-- ----------------------------
INSERT INTO `contest` VALUES ('377', '3', '英语', '60', '38', null, '0', 'null', 'null', '笔试');
INSERT INTO `contest` VALUES ('378', '4', '英语', '60', '38', null, '0', 'null', 'null', '笔试');
INSERT INTO `contest` VALUES ('379', '5', '英语', '60', '38', null, '0', 'null', 'null', '笔试');
INSERT INTO `contest` VALUES ('380', '1', '语文', '50', '39', null, '0', 'null', 'null', '笔试');
INSERT INTO `contest` VALUES ('381', '2', '语文', '50', '39', null, '0', 'null', 'null', '笔试');
INSERT INTO `contest` VALUES ('382', '3', '语文', '50', '39', null, '0', 'null', 'null', '笔试');
INSERT INTO `contest` VALUES ('383', '4', '语文', '50', '39', null, '0', 'null', 'null', '笔试');
INSERT INTO `contest` VALUES ('384', '5', '语文', '50', '39', null, '0', 'null', 'null', '笔试');
INSERT INTO `contest` VALUES ('385', '6', '语文', '50', '39', null, '0', 'null', 'null', '笔试');
INSERT INTO `contest` VALUES ('386', '1', '语文', '60', '40', null, '0', 'null', 'null', '笔试');
INSERT INTO `contest` VALUES ('387', '2', '语文', '60', '40', null, '0', 'null', 'null', '笔试');
INSERT INTO `contest` VALUES ('388', '3', '语文', '60', '40', null, '0', 'null', 'null', '笔试');
INSERT INTO `contest` VALUES ('389', '4', '语文', '60', '40', null, '0', 'null', 'null', '笔试');
INSERT INTO `contest` VALUES ('390', '5', '语文', '60', '40', null, '0', 'null', 'null', '笔试');
INSERT INTO `contest` VALUES ('391', '6', '语文', '60', '40', null, '0', 'null', 'null', '笔试');

-- ----------------------------
-- Table structure for contestcommit
-- ----------------------------
DROP TABLE IF EXISTS `contestcommit`;
CREATE TABLE `contestcommit` (
  `ContestCommitid` int(11) NOT NULL AUTO_INCREMENT,
  `ContestCommitInfo` varchar(255) DEFAULT NULL,
  `ContestCommitRank` int(11) DEFAULT NULL,
  `CompetitionId` int(11) DEFAULT NULL,
  `ContestCommitTime` varchar(255) DEFAULT NULL,
  `Userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`ContestCommitid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contestcommit
-- ----------------------------

-- ----------------------------
-- Table structure for contestcommitpicture
-- ----------------------------
DROP TABLE IF EXISTS `contestcommitpicture`;
CREATE TABLE `contestcommitpicture` (
  `ContestCommitPicid` int(11) NOT NULL AUTO_INCREMENT,
  `ContestCommitPicUrl` varchar(255) DEFAULT NULL,
  `ContestCommitid` int(11) DEFAULT NULL,
  PRIMARY KEY (`ContestCommitPicid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contestcommitpicture
-- ----------------------------

-- ----------------------------
-- Table structure for contestorganization
-- ----------------------------
DROP TABLE IF EXISTS `contestorganization`;
CREATE TABLE `contestorganization` (
  `ContestOrganizationid` int(11) NOT NULL AUTO_INCREMENT,
  `OrganizationId` int(11) DEFAULT NULL,
  `ContestId` int(11) DEFAULT NULL,
  PRIMARY KEY (`ContestOrganizationid`)
) ENGINE=InnoDB AUTO_INCREMENT=422 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contestorganization
-- ----------------------------
INSERT INTO `contestorganization` VALUES ('407', '7', '377');
INSERT INTO `contestorganization` VALUES ('408', '7', '378');
INSERT INTO `contestorganization` VALUES ('409', '7', '379');
INSERT INTO `contestorganization` VALUES ('410', '7', '380');
INSERT INTO `contestorganization` VALUES ('411', '7', '381');
INSERT INTO `contestorganization` VALUES ('412', '7', '382');
INSERT INTO `contestorganization` VALUES ('413', '7', '383');
INSERT INTO `contestorganization` VALUES ('414', '7', '384');
INSERT INTO `contestorganization` VALUES ('415', '7', '385');
INSERT INTO `contestorganization` VALUES ('416', '0', '386');
INSERT INTO `contestorganization` VALUES ('417', '0', '387');
INSERT INTO `contestorganization` VALUES ('418', '0', '388');
INSERT INTO `contestorganization` VALUES ('419', '0', '389');
INSERT INTO `contestorganization` VALUES ('420', '0', '390');
INSERT INTO `contestorganization` VALUES ('421', '0', '391');

-- ----------------------------
-- Table structure for contestpicture
-- ----------------------------
DROP TABLE IF EXISTS `contestpicture`;
CREATE TABLE `contestpicture` (
  `ContestPicId` int(11) NOT NULL AUTO_INCREMENT,
  `ContestPicUrl` varchar(255) DEFAULT NULL,
  `CompetitionId` int(11) DEFAULT NULL,
  PRIMARY KEY (`ContestPicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contestpicture
-- ----------------------------

-- ----------------------------
-- Table structure for enrollment
-- ----------------------------
DROP TABLE IF EXISTS `enrollment`;
CREATE TABLE `enrollment` (
  `enrollmentid` int(11) NOT NULL AUTO_INCREMENT,
  `ContestId` int(11) DEFAULT NULL,
  `OrganizationId` int(11) DEFAULT NULL,
  `UserId` int(11) DEFAULT NULL,
  `StudentName` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `StudentSex` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `StudentIDNumber` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `StudentSchool` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `StudentGrade` int(255) DEFAULT NULL,
  `StudentContactsMan` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `StudentContactsPhon` varchar(11) CHARACTER SET gbk DEFAULT NULL,
  `UserAddress` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `StudentTeacher` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `StudentTeacherPhon` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `StudentPicture` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `CompetitionSession` int(255) DEFAULT NULL,
  `ContestObject` int(11) DEFAULT NULL,
  `ContestMoney` int(11) DEFAULT NULL,
  `ContestState` int(11) DEFAULT NULL,
  `ContestSubject` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `StartTime` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `EndTime` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `OrganizationName` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `enrollmentState` int(11) DEFAULT '1',
  `StudentTicket` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `StudentScore` int(11) DEFAULT NULL,
  `StudentRank` int(11) DEFAULT NULL,
  `CompetitionName` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `EnrollmentTime` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `EnrollmentPassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`enrollmentid`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enrollment
-- ----------------------------
INSERT INTO `enrollment` VALUES ('23', '379', '7', '6', '杨宁宁', '女', '372929199508097228', '宁波工程学院', '5', '杨杨杨', '15757854954', '', '', '', 'image/headdd.jpg', '1', '5', '60', '2', '英语', 'null', 'null', '宁波资优少年', '2', null, '-1', null, '  2016年第一届浙江省“优尔杯”小学生英语阅读能力训练活动', '2016-04-16 13:52:47', null);
INSERT INTO `enrollment` VALUES ('26', '377', '7', '11', '张志博', '男', '310107200610100930', '宁波庄桥中心小学', '3', '李冉', '18967882577', '庄桥前姚205号', '', '', 'image/headdd.jpg', '1', '3', '60', '2', '英语', 'null', 'null', '宁波资优少年', '2', null, '-1', null, '2016年浙江省优尔杯英语大赛', '2016-04-17 13:59:03', null);
INSERT INTO `enrollment` VALUES ('27', '379', '7', '12', '谭珺天', '女', '33020320041024364X', '江北实验小学', '5', '黄玉阳', '13566526705', '', '', '', 'image/headdd.jpg', '1', '5', '60', '2', '英语', 'null', 'null', '宁波资优少年', '2', null, '-1', null, '2016年浙江省优尔杯英语大赛', '2016-04-19 13:14:31', null);
INSERT INTO `enrollment` VALUES ('30', '377', '7', '14', '陈与点', '男', '330204200703280010', '江东外国语实验小学', '3', '张寂', '13065897228', '', '', '', 'image/headdd.jpg', '1', '3', '60', '2', '英语', 'null', 'null', '宁波资优少年', '2', null, '-1', null, '2016年浙江省优尔杯英语大赛', '2016-04-20 15:10:03', null);
INSERT INTO `enrollment` VALUES ('31', '377', '7', '15', '陆双盈', '女', '330204200611171028', '江东实验小学', '3', '陆瑛瑛', '13777976094', '', '', '', 'image/headdd.jpg', '1', '3', '60', '2', '英语', 'null', 'null', '宁波资优少年', '2', null, '-1', null, '2016年浙江省优尔杯英语大赛', '2016-04-21 20:03:24', null);
INSERT INTO `enrollment` VALUES ('32', '378', '7', '23', '陆知遥', '男', '330206200511153415', '北仑华山小学', '4', '陈雪平', '13566512152', '北仑新矸', '', '', 'image/headdd.jpg', '1', '4', '60', '2', '英语', 'null', 'null', '宁波资优少年', '2', null, '-1', null, '2016年浙江省优尔杯英语大赛', '2016-04-25 10:56:10', null);
INSERT INTO `enrollment` VALUES ('33', '379', '7', '19', '杨易凡', '男', '330203200507283613', '宁波华天小学', '5', '林萌盛', '13858260088', '', '', '13858260088', 'image/headdd.jpg', '1', '5', '60', '2', '英语', 'null', 'null', '宁波资优少年', '2', null, '-1', null, '2016年浙江省优尔杯英语大赛', '2016-04-25 13:23:29', null);
INSERT INTO `enrollment` VALUES ('34', '379', '7', '19', '杨易凡', '男', '330203200507283613', '宁波华天小学', '5', '林萌盛', '13858260088', '', '', '', 'image/headdd.jpg', '1', '5', '60', '2', '英语', 'null', 'null', '宁波资优少年', '2', null, '-1', null, '2016年浙江省优尔杯英语大赛', '2016-04-25 13:36:56', null);
INSERT INTO `enrollment` VALUES ('35', '379', '7', '34', '周妤曈', '女', '330206200504190920', '孙文英小学', '5', '林丹静', '13175995995', '', '', '', 'image/headdd.jpg', '1', '5', '60', '2', '英语', 'null', 'null', '宁波资优少年', '2', null, '-1', null, '2016年浙江省优尔杯英语大赛', '2016-05-03 20:26:00', null);
INSERT INTO `enrollment` VALUES ('36', '379', '7', '35', '蔡宗翰', '男', '330203200412102410', '孙文英小学', '5', '蔡先生', '13586687711', '宁波市西湖花园8幢203室', '陈老师', '', 'image/headdd.jpg', '1', '5', '60', '2', '英语', 'null', 'null', '宁波资优少年', '2', null, '-1', null, '2016年浙江省优尔杯英语大赛', '2016-05-03 21:06:11', null);
INSERT INTO `enrollment` VALUES ('37', '378', '7', '37', '叶宁远', '男', '330203200605060632', '新芝小学', '4', '金蕾', '13505745900', '新芝小学401班', '', '', 'image/headdd.jpg', '1', '4', '60', '2', '英语', 'null', 'null', '宁波资优少年', '2', null, '-1', null, '2016年浙江省优尔杯英语大赛', '2016-05-05 19:17:04', null);
INSERT INTO `enrollment` VALUES ('38', '379', '7', '38', '谢洋', '男', '320205200410170015', '李惠利小学', '5', '谢兴平', '18668860165', '', '', '', 'image/headdd.jpg', '1', '5', '60', '2', '英语', 'null', 'null', '宁波资优少年', '2', null, '-1', null, '2016年浙江省优尔杯英语大赛', '2016-05-05 21:23:25', null);
INSERT INTO `enrollment` VALUES ('39', '377', '7', '8', '夏宁延', '女', '33020520080615702X', '镇海蛟川双语小学', '2', '李花', '13685712909', '', '', '', 'image/headdd.jpg', '1', '3', '60', '2', '英语', 'null', 'null', '宁波资优少年', '2', null, '-1', null, '2016年浙江省优尔杯英语大赛', '2016-05-06 07:40:54', null);
INSERT INTO `enrollment` VALUES ('40', '378', '7', '40', '任天易', '女', '330204200603016044', '宁波市镇明中心小学', '4', '董嫣', '13586945173', '', '', '', 'image/headdd.jpg', '1', '4', '60', '2', '英语', 'null', 'null', '宁波资优少年', '2', null, '-1', null, '2016年浙江省优尔杯英语大赛', '2016-05-06 14:39:01', null);

-- ----------------------------
-- Table structure for enrollmentorder
-- ----------------------------
DROP TABLE IF EXISTS `enrollmentorder`;
CREATE TABLE `enrollmentorder` (
  `localuserid` varchar(100) NOT NULL COMMENT '本地用户ID',
  `openid` varchar(100) NOT NULL COMMENT '微信商户要求的ID',
  `total_fee` varchar(100) NOT NULL COMMENT '用户账单总金额',
  `transaction_id` varchar(100) NOT NULL COMMENT '微信支付订单号 (由微信发给我们)',
  `out_trade_no` varchar(100) NOT NULL COMMENT '商户订单号 (我们本地生成)',
  `time_end` varchar(100) DEFAULT NULL COMMENT '支付完成时间 ',
  `attach` varchar(255) DEFAULT NULL COMMENT '商家数据包 ',
  PRIMARY KEY (`localuserid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enrollmentorder
-- ----------------------------
INSERT INTO `enrollmentorder` VALUES ('11', '111111111', '60', '11111', '1111', '2016/4/17 13:59', '11');
INSERT INTO `enrollmentorder` VALUES ('12', '111111111', '60', '11111', '1111', '2016/4/19 13:14', '12');
INSERT INTO `enrollmentorder` VALUES ('14', '111111111', '60', '11111', '1111', '2016/4/20 15:10', '14');
INSERT INTO `enrollmentorder` VALUES ('15', '111111111', '60', '11111', '1111', '2016/4/21 20:03', '15');
INSERT INTO `enrollmentorder` VALUES ('19', '111111111', '60', '11111', '1111', '2016/4/25 13:37', '19');
INSERT INTO `enrollmentorder` VALUES ('23', '111111111', '60', '11111', '1111', '2016/4/25 10:56', '23');

-- ----------------------------
-- Table structure for gradebasicdata
-- ----------------------------
DROP TABLE IF EXISTS `gradebasicdata`;
CREATE TABLE `gradebasicdata` (
  `GreadId` int(11) NOT NULL AUTO_INCREMENT,
  `GreadState` int(11) DEFAULT NULL,
  PRIMARY KEY (`GreadId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gradebasicdata
-- ----------------------------
INSERT INTO `gradebasicdata` VALUES ('6', '1');
INSERT INTO `gradebasicdata` VALUES ('7', '2');
INSERT INTO `gradebasicdata` VALUES ('8', '3');
INSERT INTO `gradebasicdata` VALUES ('9', '4');
INSERT INTO `gradebasicdata` VALUES ('10', '5');
INSERT INTO `gradebasicdata` VALUES ('11', '6');
INSERT INTO `gradebasicdata` VALUES ('12', '7');
INSERT INTO `gradebasicdata` VALUES ('13', '8');
INSERT INTO `gradebasicdata` VALUES ('14', '9');
INSERT INTO `gradebasicdata` VALUES ('15', '10');
INSERT INTO `gradebasicdata` VALUES ('16', '11');
INSERT INTO `gradebasicdata` VALUES ('17', '12');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `NewsId` int(11) NOT NULL AUTO_INCREMENT,
  `NewsTitle` varchar(1000) CHARACTER SET gbk DEFAULT NULL,
  `NewsContent` varchar(5000) CHARACTER SET gbk DEFAULT NULL,
  `NewsPicId` int(255) DEFAULT NULL,
  `NewsExtralInfo` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `NewsPutTime` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `NewsState` int(11) DEFAULT NULL,
  `NewsTop` int(11) DEFAULT NULL,
  `NewsSource` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `NewsSaveState` int(11) DEFAULT NULL,
  PRIMARY KEY (`NewsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------

-- ----------------------------
-- Table structure for newspicture
-- ----------------------------
DROP TABLE IF EXISTS `newspicture`;
CREATE TABLE `newspicture` (
  `NewsPicId` int(11) NOT NULL AUTO_INCREMENT,
  `NewsPicUrl` varchar(255) DEFAULT NULL,
  `NewsId` int(11) DEFAULT NULL,
  PRIMARY KEY (`NewsPicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of newspicture
-- ----------------------------

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `OrganizationId` int(11) NOT NULL AUTO_INCREMENT,
  `OrganizationName` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `OrganizationAddress` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `OrganizationStation` int(11) DEFAULT NULL,
  `OrganizationTel` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `OrganizationContacts` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  PRIMARY KEY (`OrganizationId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES ('7', '宁波资优少年', '海曙区翠柏路89号宁波工程学院1号教学楼306', '1', '0574-87629722', '陈老师');
INSERT INTO `organization` VALUES ('8', '宁波一聪教育', '镇明路云石街55号2218室（镇明中心小学旁）', '1', '87291832', '李老师');

-- ----------------------------
-- Table structure for squence
-- ----------------------------
DROP TABLE IF EXISTS `squence`;
CREATE TABLE `squence` (
  `contest_last_id` int(11) NOT NULL,
  `competition_last_id` int(11) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  PRIMARY KEY (`contest_last_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of squence
-- ----------------------------
INSERT INTO `squence` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for subjectbasicdata
-- ----------------------------
DROP TABLE IF EXISTS `subjectbasicdata`;
CREATE TABLE `subjectbasicdata` (
  `SubjectId` int(11) NOT NULL AUTO_INCREMENT,
  `SubjectName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`SubjectId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subjectbasicdata
-- ----------------------------
INSERT INTO `subjectbasicdata` VALUES ('6', '数学');
INSERT INTO `subjectbasicdata` VALUES ('7', '英语');
INSERT INTO `subjectbasicdata` VALUES ('8', '奥数');
INSERT INTO `subjectbasicdata` VALUES ('9', '语文');

-- ----------------------------
-- Table structure for testpaper
-- ----------------------------
DROP TABLE IF EXISTS `testpaper`;
CREATE TABLE `testpaper` (
  `TestPaperId` int(11) NOT NULL AUTO_INCREMENT,
  `TestPaperName` varchar(255) DEFAULT NULL,
  `TestPaperTime` varchar(255) DEFAULT NULL,
  `TestPaperState` int(11) DEFAULT NULL,
  `TestSubject` varchar(255) DEFAULT NULL,
  `TestDifficulty` int(11) DEFAULT NULL,
  `TestKnowledgepoint` varchar(255) DEFAULT NULL,
  `TestYear` int(11) DEFAULT NULL,
  `TestState` varchar(255) DEFAULT NULL,
  `ContestId` int(11) DEFAULT NULL,
  PRIMARY KEY (`TestPaperId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testpaper
-- ----------------------------
INSERT INTO `testpaper` VALUES ('1', '2015年全国小学生语文竞赛初赛', '2016-04-20 10:34:10', '1', '语文', '1', '语文', '2015', '小学一年级', '380');

-- ----------------------------
-- Table structure for testpaperpicture
-- ----------------------------
DROP TABLE IF EXISTS `testpaperpicture`;
CREATE TABLE `testpaperpicture` (
  `TestPaperPictureid` int(11) NOT NULL AUTO_INCREMENT,
  `TestPaperNumber` int(11) DEFAULT NULL,
  `TestPapeTitleUrl` varchar(255) DEFAULT NULL,
  `TestPaperAnswerUrl` varchar(255) DEFAULT NULL,
  `TestPaperId` int(11) DEFAULT NULL,
  PRIMARY KEY (`TestPaperPictureid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of testpaperpicture
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `UserPhone` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `UserPassage` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `UserName` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `UserSex` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `UserIDNumber` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `UserSchool` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `UserYear` int(11) DEFAULT NULL,
  `UserContactsMan` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `UserContactsPhon` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `UserAddress` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `UserTeacher` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `UserTeacherPhon` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `UserPicture` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `UserNickname` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `UserLoginTime` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `UserIntegral` int(11) DEFAULT NULL,
  `UserState` int(11) DEFAULT '1',
  `UserQQAccount` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `UsermicroAccount` varchar(255) CHARACTER SET gbk DEFAULT NULL,
  `UserGrade` int(11) DEFAULT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '15728046336', '330683', '李老师', '女', '3306831995020612', '宁波工程学院', null, null, '15728046336', '宁波市海曙区翠柏路89号', null, null, 'Web/image/2016_04_10_103711.jpg', 'AricLee', null, null, '1', null, null, '12');
INSERT INTO `user` VALUES ('2', '17855830784', '123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('3', '15728045978', '123456', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('4', '13615888121', '111111', '陈晨', '男', '33026519645862512', '你女朋友', null, '很多', '13615888121', '民族陪微信', null, null, null, '陈', null, null, '1', null, null, '1');
INSERT INTO `user` VALUES ('5', '15381037668', '376766', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('6', '15757854954', 'ning8023', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('7', '15864676965', 'timubuaumao', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('8', '13685712909', '433574', '夏宁延妈妈', '女', null, null, null, '夏宁延妈妈', '13685712909', null, null, null, null, '夏宁延妈妈', null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('9', '17855833180', '123456', '郑成栋', '男', null, null, null, null, '17855833180', null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('10', '18667412908', '123456', '刘杨书贤', '男', null, null, null, '妈妈', '18667412908', null, null, null, null, '刘杨书贤', null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('11', '18967882577', 'LIRAN985711', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('12', '13738422505', '664023', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('13', '13486067389', '581330', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('14', '13065897228', '799230', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('15', '13777976094', 'dzyhltqfcx', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('16', '13454787677', '1111', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('17', '13484278353', '940725zsd', null, '女', null, null, null, null, null, null, null, null, null, 'Miss 殷', null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('18', '15958238180', '88929582', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('19', '13858260088', 'lmsab770911', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('20', '13777211146', '13777211146', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('21', '13857479254', '866910', '赵侯涛', '男', null, null, null, null, null, null, null, null, null, '', null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('22', '15381956695', 'LVER13306683283', '王絮', '小学二年级', null, '实验小学', null, '吕尔', '15381956695', null, null, null, null, '开心果', null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('23', '13566512152', 'cxp@041128', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('24', '13957833588', '101313', null, '小学五年级', null, null, null, null, null, null, null, null, null, '双妈', null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('25', '13777135409', '12345678', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('26', '13123852715', 'Qq115163', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('27', '18069048082', '20061111', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('28', '13616590885', 'zihao080418', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('29', '13806676227', '20050201', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('30', '13958309805', '100200', null, '小学三年级', '36012420070817023423', '北仑区岷山学校', null, null, null, null, null, null, null, 'Ada', null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('31', '18606866166', 'qazwsxedc', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('32', '15867838036', 'wxx740220', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('33', '18957845168', 'CBCZ6096138', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('34', '13175995995', '939335jing', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('35', '13586687711', '201918', '蔡宗翰', '男', null, '孙文英小学', null, '蔡先生', '13586687711', null, null, null, null, '蔡宗翰', null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('36', '13566001165', '12301', null, null, null, null, null, null, '', null, null, null, null, '小路', null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('37', '13505745900', 'mulan5900', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('38', '18668860165', '760511', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('39', '13056765312', '000822', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('40', '13586945173', '060301', null, null, null, null, null, null, null, null, null, null, null, '任天易', null, null, '1', null, null, null);
INSERT INTO `user` VALUES ('41', '13566343207', 'chj0405289', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null);

-- ----------------------------
-- Table structure for websitebasicdata
-- ----------------------------
DROP TABLE IF EXISTS `websitebasicdata`;
CREATE TABLE `websitebasicdata` (
  `WebsiteBasicDataId` int(11) NOT NULL AUTO_INCREMENT,
  `mainPicture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`WebsiteBasicDataId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of websitebasicdata
-- ----------------------------
INSERT INTO `websitebasicdata` VALUES ('2', 'Web/image/2016_04_09_192929.jpg');

-- ----------------------------
-- Table structure for yearbasicdata
-- ----------------------------
DROP TABLE IF EXISTS `yearbasicdata`;
CREATE TABLE `yearbasicdata` (
  `YearBasicDataId` int(11) NOT NULL AUTO_INCREMENT,
  `YearData` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`YearBasicDataId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yearbasicdata
-- ----------------------------
INSERT INTO `yearbasicdata` VALUES ('14', '2008');
INSERT INTO `yearbasicdata` VALUES ('15', '2009');
INSERT INTO `yearbasicdata` VALUES ('16', '2010');
INSERT INTO `yearbasicdata` VALUES ('17', '2011');
INSERT INTO `yearbasicdata` VALUES ('18', '2012');
INSERT INTO `yearbasicdata` VALUES ('19', '2013');
INSERT INTO `yearbasicdata` VALUES ('20', '2014');
INSERT INTO `yearbasicdata` VALUES ('21', '2015');
INSERT INTO `yearbasicdata` VALUES ('22', '2016');

-- ----------------------------
-- Procedure structure for getAllOrganizationNumber
-- ----------------------------
DROP PROCEDURE IF EXISTS `getAllOrganizationNumber`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `getAllOrganizationNumber`()
BEGIN
	#Routine body goes here...

SELECT 

	CONCAT(
		'[',

		GROUP_CONCAT(
			CONCAT('{"OrganizationName":"', OrganizationName, '",'),
			CONCAT('"OrganizationId":"', OrganizationId, '"}')
		),

		']'

	) AS OrganizationSet

 from 
	organization;


END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for getCompetitionDeatilById
-- ----------------------------
DROP PROCEDURE IF EXISTS `getCompetitionDeatilById`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `getCompetitionDeatilById`(IN `ID` int)
BEGIN

SELECT 

CONCAT('[',
              GROUP_CONCAT(
                   CONCAT('{"ContestObject":"', cn.contestObject, '",'),
									 CONCAT('"ContestId":"', cn.ContestId, '",'),
                   CONCAT('"ContestSubject":"', cn.contestSubject, '",'),
									 CONCAT('"ContestState":"', cn.ContestState, '",'),
                   CONCAT('"ContestMoney":"', cn.contestMoney , '",'),
                   CONCAT('"StartTime":"', cn.startTime , '",'),
									 CONCAT('"EndTime":"', cn.endTime, '",'),
								   CONCAT('"ContestexamType":"',cn.contestexamType,'",'),
									 CONCAT('"OrganizerSet":',
								
(
SELECT 
											 CONCAT('[',
												 GROUP_CONCAT(
														CONCAT('{"OrganizationName":"',og.organizationName,'",' ),
														CONCAT('"OrganizationId":"',co.organizationId,'"}' )
												),']' 
												) as bbb
											FROM 
												organization as og,
												contestorganization as co
											WHERE 
												og.organizationId = co.organizationId AND
												co.contestId = cn.contestId
											
											GROUP BY cn.ContestObject
)
							,'}')
),']'
)
AS DetailContestSet,
cp.CompetitionName,
cp.CompetitionSession,
cp.CompetitionPropaganda,
cp.CompetitionEnrollStartTime,
cp.CompetitionEnrollEndTime,
cp.CompetitionInfo,
cp.CompetitionSponsor,
cp.CompetitionTimeDescribe,
cp.CompetitionPrize,
cp.CompetitionObjectDescribe,
cp.CompetitionPriceDescribe,
cp.CompetitionState,
cp.CompetitionPicture,
cp.CompetitionPictureBig,
cp.CompetitionBriefInfo

FROM 
	competition as cp,
	contest as cn  #,
	#organization as og,
	#contestorganization as co

WHERE
	cp.CompetitionState in (1, 2, 5) AND
	cp.CompetitionId = cn.CompetitionId AND
	cp.CompetitionId = ID 
	#og.organizationId = co.organizationId AND
	#co.contestId = cn.contestId;

GROUP BY cp.competitionId;
/*

(SELECT 
											 CONCAT('[', 
												 GROUP_CONCAT
												(
														CONCAT('{"OrganizationName":"',og.organizationName,'",' ),
														CONCAT('{"OrganizationName":"',og.organizationId,'"}' )
												) 
												,']')
											FROM 
												organization as og,
												contestorganization as co
											WHERE 
												og.organizationId = co.organizationId AND
												co.contestId = cn.contestId;),'"}'),
							)

*/

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for getCompetitionList
-- ----------------------------
DROP PROCEDURE IF EXISTS `getCompetitionList`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `getCompetitionList`()
BEGIN
	#Routine body goes here...


/*
	private int competitionId; // 大赛Id
	private String competitionName; //大赛名字
	private String competitionSession; // 大赛届数
	private String competitionPicture; // 大赛图片
	private String competitionObjectDescribe; // 参赛对象描述
	private	String competitionEnrollStartTime	;//	赛事开始报名时间
	private	String competitionEnrollEndTime	;//	竞赛结束报名时间
	private int competitionState; // 大赛状态
*/


SELECT 

#/*
	CONCAT(
		'[',

		GROUP_CONCAT(
			CONCAT('{"ContestSubject":"', cn.ContestSubject, '",'),
			CONCAT('"ContestMoney":"', cn.ContestMoney, '",'),
			CONCAT('"ContestId":"', cn.ContestiD, '"}')
		),

		']'

	) AS BriefContest ,
#*/
	cp.CompetitionId,
	cp.CompetitionName,
	cp.CompetitionSession,
	cp.CompetitionPicture,
	cp.CompetitionObjectDescribe,
	cp.CompetitionEnrollStartTime,
	cp.CompetitionEnrollEndTime,
	cp.CompetitionState

FROM
	competition as cp,
	contest as cn

WHERE 
	cn.CompetitionId = cp.CompetitionId AND
	cp.competitionState in (1, 2, 5)

GROUP BY cp.competitionId;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for getCompetitionListByGrade
-- ----------------------------
DROP PROCEDURE IF EXISTS `getCompetitionListByGrade`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `getCompetitionListByGrade`(IN `grade` int)
BEGIN
	#Routine body goes here...



/******************************************************************************************************

函数名：
			getCompetitionListByGrade

描述：
			根据大赛的对象的年级段来查询大赛列表

			1-6：  小学组
			7-9：  中学组
			10-12：高中组

参数：
			in ： 年级段标志（1. 小学组 2，中学组 3，高中组）

备注：
			1. 结果集：[{"CompetitionName":"2016年全国初中数学联赛","CompetitionId":"34","CompetitionState":"1"},
									{"CompetitionName":"第八届IYMC国际青少年数学竞赛(宁波赛区)","CompetitionId":"35","CompetitionState":"1"}]


			2. 大赛状态：0:未发布 1：即将开始报名 2:正在报名 3：比赛进行中 4：已结束 -1：删除 5:头条


示例：

		IF  rating  =  1  THEN
			UPDATE  EMPLOYEE  SET  salary  =  salary*1.10
				 WHERE  empno  =  i_num;（如果满足于...时，薪水调整1.1倍）
		ELSEIF  rating  =  2  THEN
			UPDATE  EMPLOYEE  SET  salary  =  salary*1.05
				 WHERE  empno  =  i_num;
		ELSE
			UPDATE  EMPLOYEE  SET  salary  =  salary*1.03
				 WHERE  empno  =  i_num;
		END  IF;


******************************************************************************************************/

DECLARE startGrade int; # 开始年纪
DECLARE endGrade int;   # 结束年纪


## 如果传进来是小学组的标志，标志为 1
IF grade = 1 THEN
SET startGrade = 1;
SET endGrade = 6;

## 如果传进来是中学组的标志，标志为 1
ELSEIF grade = 2 THEN 
SET startGrade = 7;
SET endGrade = 9;

## 如果传进来是高中组的标志，标志为 3
ELSEIF grade = 3 THEN
SET startGrade = 10;
SET endGrade = 12;

END IF;


SELECT 
	CONCAT(
		'[',

		GROUP_CONCAT(
			CONCAT('{"ContestSubject":"', cn.ContestSubject, '",'),
			CONCAT('"ContestMoney":"', cn.ContestMoney, '",'),
			CONCAT('"ContestId":"', cn.ContestiD, '"}')
		),

		']'

	) AS BriefContest ,
	cp.CompetitionId,
	cp.CompetitionName,
	cp.CompetitionSession,
	cp.CompetitionPicture,
	cp.CompetitionObjectDescribe,
	cp.CompetitionEnrollStartTime,
	cp.CompetitionEnrollEndTime,
	cp.CompetitionState

FROM
	competition as cp,
	contest as cn

WHERE 
	cn.CompetitionId = cp.CompetitionId AND
	cp.competitionState in (1, 2, 5) AND
	cn.ContestObject BETWEEN startGrade and endGrade

GROUP BY cp.competitionId;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for getCompetitionNameAndIdByState
-- ----------------------------
DROP PROCEDURE IF EXISTS `getCompetitionNameAndIdByState`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `getCompetitionNameAndIdByState`(IN `state` int)
BEGIN
	#Routine body goes here...
/******************************************************************************************************

函数名：
			getCompetitionNameAndIdByState

描述：
			根据大赛的状态来查找对应的大赛名字，ID

参数：
			in ： 大赛的状态

备注：
			1. 结果集：[{"CompetitionName":"2016年全国初中数学联赛","CompetitionId":"34","CompetitionState":"1"},
									{"CompetitionName":"第八届IYMC国际青少年数学竞赛(宁波赛区)","CompetitionId":"35","CompetitionState":"1"}]


			2. 大赛状态：0:未发布 1：即将开始报名 2:正在报名 3：比赛进行中 4：已结束 -1：删除 5:头条


******************************************************************************************************/




SELECT 
	
	CONCAT('[', 
			GROUP_CONCAT(
						CONCAT('{"CompetitionName":"', CompetitionName, 
									 '","CompetitionId":"',  CompetitionId, '",', 
									 '"CompetitionState":"', CompetitionState ,'"}'
						)
			),
	']') as jsonInfo

FROM 
	competition as c1

Where 
	CompetitionState = state #AND
	#c1.CompetitionId = c2.CompetitionId;

GROUP BY CompetitionState;

END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for getCompetitionNumberInfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `getCompetitionNumberInfo`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `getCompetitionNumberInfo`()
BEGIN
	#Routine body goes here...


/******************************************************************************************************
函数名：
			getCompetitionNumberInfo

参数：
			OUT ： json格式的大赛不同状态的数目

描述：
			返回当前数据库中不同状态

备注：
			1. 结果集：{"numberOfTobeEnro":"2","numberOfDoingEnro":"0","numberOfDoing":"0"}


			2. 大赛状态：0:未发布 1：即将开始报名 2:正在报名 3：比赛进行中 4：已结束 -1：删除 5:头条


******************************************************************************************************/




	#SELECT Count(*) From competition where CompetitionState = 1;
	# 即将开始比赛的数目
	DECLARE numberOfTobeEnro VARCHAR(20);
	# 正在报名比赛的数目
	DECLARE numberOfDoingEnro VARCHAR(20);
	# 正在进行中比赛的数目
	DECLARE numberOfDoing VARCHAR(20);

	DECLARE info VARCHAR(500);
	DECLARE jsonInfo VARCHAR(800);


	set numberOfTobeEnro = (SELECT Count(*)  From competition where CompetitionState = 1);
	set numberOfDoingEnro = (SELECT Count(*) From competition where CompetitionState = 2);
	set numberOfDoing = (SELECT Count(*) From competition where CompetitionState = 3);

	
	SET info = CONCAT('"numberOfTobeEnro":"', numberOfTobeEnro, '",', '"numberOfDoingEnro":"', numberOfDoingEnro, '",' ,'"numberOfDoing":"', numberOfDoing, '"');

	set jsonInfo = CONCAT('{', info, '}');

	SELECT jsonInfo;



END
;;
DELIMITER ;
