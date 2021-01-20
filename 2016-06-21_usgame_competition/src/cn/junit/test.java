package cn.junit;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import cn.usgame.dao.dbutils_impl.CompetitionDaoImply;
import cn.usgame.dao.dbutils_impl.UserDaoImply;
import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Competition;
import cn.usgame.entity.User;
import cn.usgame.service.CompetitionService;
import cn.usgame.service.ServiceFactory;
import cn.usgame.service.UserService;
import cn.usgame.service.impl.UserServiceImpl;

public class test {

	
	private static CompetitionDaoImply comDao = new CompetitionDaoImply();
	@Test
	public void test1 () {
		Competition com = new Competition();
		
		com.setCompetitionName("2016年全国初中数学联赛");
		com.setCompetitionSubject("数学");
		com.setCompetitionApplyStartTime(new Date());
		com.setCompetitionApplyEndTime(new Date());
		com.setCompetitionJoinerDes("七年级至九年级");
		com.setCompetitionMoney("40");
		com.setCompetitionType(0);
		com.setCompetitionPrizeDes("评奖方式按年级设立全国初中数学联赛一、二、三等奖，奖励比例按参赛学生的10%评定全国一、二、三等奖（比例为1.5：3.5：5）设立优秀教练员奖，奖励获得全国一等奖学生的指导老师；同时，按照参赛学生的10%评定浙江省一、二、三等奖（比例为1.5：3.5：5），并按照各校参赛学生前五名的总成绩，评选出十个团体优胜奖（以学校为单位）");
		com.setCompetitionTestTimeDes("2015/12/20");
		com.setCompetitionApplyAddress("宁波学智教育培训学校<\br>  0574-87509151、87509152<\br>  宁波环城西路南段171号（宁波学智教育培训学校）<\br> 北仑区学智教育培训学校<\br> 0574—86860037 / 86860057<\br> 北仑区明州路500号太平洋国际大厦1508室<\br> 杭州奥林教育宁波分校-启真教育<\br>  0574-87735536<\br>  镇海区庄市街道陈倪路450号<\br> 杭州奥林教育宁波分校-启真教育<\br>  0574-87735536<\br>  江东区桑田路688号生产力促进中心6楼<\br> 宁波资优少年<\br>  0574-87629722<\br>  海曙区翠柏路89号宁波工程学院1号教学楼306<\br>");
		com.setCompetitionTestAddress("（暂未定）");
		com.setCompetitionDetail("2016年全国初中数学联赛报名通知 　　根据全国初中数学联赛组委会《举办2016 年全国初中数学联赛》文件精神，将在全省举办2016 年全国初中数学联赛。浙江赛区组织委员会本着“激发中学生学习数学的兴趣，培养和选拔优秀人才”的宗旨，并结合我省具体情况，将竞赛时间作了重新调整，目的是更好地满足广大学校的实际需求。同时，继续设立七、八和九年级三个不同层次的竞赛。 　　一、竞赛时间 　　2015年12月20日（星期日） 　　七年级：8：30—9：30 　　八、九年级：一试8：30—9：30；二试9：50—11：20 　　二、试题范围及题型 　　2016 年全国初中数学联赛的试题范围及题型依据中国数学会制订的《初中数学竞赛大纲（2006年修订稿）》，并结合浙江省初中教学实际情况，坚持“大众化、普及型、不超纲、不超前”的原则。 　　七年级竞赛试卷不设一试、二试，采用综合试卷，题型为选择题6道、填空题6道，满分100分。 　　八、九年级竞赛试卷分一试和二试，第一试着重考查基础知识和基本技能，题型为选择题6题、填空题4题共70分；第二试着重考查分析问题与解决问题的能力，题型为三道解答题共70分，两试合计为140分。 三、评奖 　　评奖方式按年级设立全国初中数学联赛一、二、三等奖，奖励比例按参赛学生的10%评定全国一、二、三等奖（比例为1.5：3.5：5），并设立优秀教练员奖，奖励获得全国一等奖学生的指导老师，上述所有获奖证书由全国初中数学联赛组委会颁发。同时，按照参赛学生的10%评定浙江省一、二、三等奖（比例为1.5：3.5：5），并按照各校参赛学生前五名的总成绩，评选出十个团体优胜奖（以学校为单位），上述获奖证书由浙江赛区组织委员会颁发。 　　四、日程安排 　　1、报名时间2015 年11月22日截止。 　　2、2015年12 月20 日下午网上公布答案。 　　3、2016 年1 月3 日网上查询成绩，如有异议于1 月9 日前向组委会提出。 　　4、2016 年1 月11 日公布获奖名单(网址： www.aolinedu.com )。 　　五、报名方式 　　宁波报名点 　　报名地址：宁波环城西路南段171号（宁波学智教育培训学校） 　　报名电话：0574-87509151、87509152 　　北仑报名点 　　报名地址：北仑区明州路500号太平洋国际大厦1508室（ 北仑区学智教育培训学校） 　　报名电话：0574—86860037、 86860057 镇海报名点 　　报名地址：镇海区庄市街道陈倪路450号（杭州奥林教育宁波分校-启真教育） 　　报名电话：0574-87735536 　　江东报名点 　　报名地址：江东区桑田路688号生产力促进中心6楼（杭州奥林教育宁波分校-启真教育） 　　报名电话：0574-87735536 　　海曙报名点 　　报名地址：海曙区翠柏路89号宁波工程学院1号教学楼306（资优少年） 　　报名电话：0574-87629722 　　报名费用：40元/人 　　1、宁波赛区组委会：杭州奥林教育宁波分校（启真教育） 　　镇海报名点1：镇海区庄市街道陈倪路450号；          电话：0574-87735536 　　江东报名点2：江东区桑田路688号生产力促进中心6楼；电话：0574-87735536 　　2、合作单位：宁波资优少年 　　地址：海曙区翠柏路89号宁波工程学院1号教学楼306   电话：0574-87629722 镇海报名点 　　报名地址：镇海区庄市街道陈倪路450号（杭州奥林教育宁波分校-启真教育） 　　报名电话：0574-87735536 　　江东报名点 　　报名地址：江东区桑田路688号生产力促进中心6楼（杭州奥林教育宁波分校-启真教育） 　　报名电话：0574-87735536 　　海曙报名点 　　报名地址：海曙区翠柏路89号宁波工程学院1号教学楼306（资优少年） 　　报名电话：0574-87629722 　　报名费用：40元/人 　　1、宁波赛区组委会：杭州奥林教育宁波分校（启真教育） 　　镇海报名点1：镇海区庄市街道陈倪路450号；          电话：0574-87735536 　　江东报名点2：江东区桑田路688号生产力促进中心6楼；电话：0574-87735536 　　2、合作单位：宁波资优少年 　　地址：海曙区翠柏路89号宁波工程学院1号教学楼306   电话：0574-87629722");
		com.setCompetitionSupportDesc("宁波资优少年</br> 0574-87629722</br> 海曙区翠柏路89号宁波工程学院1号教学楼306   </br>");
		comDao.addCompetition(com);
	}
	@Test
	public void test2 () {
		
		Properties pro = new Properties();
		pro.put("ss", "sss");
		
		System.out.println(pro.getProperty("ssss"));
	}
	
	
	@Test
	public void test3 () {
		
	    try {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse("2016-06-24"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test4 () {
		Animal an = new Cat();
		an.eat();
		
		try {
			Method method = an.getClass().getMethod("SaJiao");
			method.invoke(an);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	@Test
	public void test5() {
		CompetitionService comService = ServiceFactory.getInstance().getProgramManage();
		List<Competition> list = comService.getCompetitionList(1,1);
		JsonArray jsonData = new JsonArray();
		for(int i =0;i<list.size();i++) {
			System.out.println(1111);
			jsonData.add(list.get(i).toJSON());
		}
		System.out.println(jsonData.toString());
	}
	@Test
	public void test6() {
		Competition competition = comDao.getCompetitionById(1000);
		System.out.println(competition.toString());
	}
	@Test
	public void test7() {
		UserService user = ServiceFactory.getInstance().getUserManage();
		boolean result = user.registerUser("1","12434562315","948gbhfsdu");
		System.out.println(result);
	}
	@Test
	public void test8() {
		UserService user = ServiceFactory.getInstance().getUserManage();
		User result =user.login("1243456","948gbhfsdu");
		System.out.println(result);
	}
	@Test
	public void test9() {
		String a = comDao.getCompetitionDetailDes(1004);
		System.out.println(a);
	}
	@Test
	public void test10() {
		UserService user = ServiceFactory.getInstance().getUserManage();
		
	}
	@Test
	public void test11() {
		JsonObject json = new JsonObject();
		Gson gson = new Gson();
		
		String stu = "{\"age:\":12, \"name\":xiaoli}";
		
		json = gson.fromJson(stu, JsonObject.class);
		System.out.println(json.get("name"));
		JsonElement name = json.get("name");
		System.out.println(name.getAsString());
	}
	
	@Test
	public void test12() {
		System.out.println("1");
		List<ApplyReport> applyreports = null;
		UserService user = ServiceFactory.getInstance().getUserManage();
		applyreports = user.getUserCompetition("17855833180");
		System.out.println("2");
		System.out.println(applyreports.toString());
	}
	@Test
	public void test13() {
		ApplyReport applyreport = null;
		UserService user = ServiceFactory.getInstance().getUserManage();
		applyreport = user.applyreportInfo("17855833180","709105840");
		System.out.println(applyreport);
	}
	@Test
	public void test14() {
		boolean num = comDao.updateCompetitionState(1000, 2);
		System.out.println(num);
	}
	@Test
	public void test15() {
		List<ApplyReport> re = comDao.getApplyReport("2016-07-10", "2016-07-29", "1", "17855833180", 0, 1);
		System.out.println(re.toString());
	}
	

	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
