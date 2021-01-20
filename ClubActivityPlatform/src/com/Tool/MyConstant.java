package com.Tool;

public class MyConstant {
	
	
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-13下午04:32:45
	 *函数名： ActivityState
	 *功能：活动状态常量
	 *参数：
	 *返回值：
	 */
	public static final class ActivityState{
		public static final int SCHEME_STAGE=0;//策划阶段
		public static final int SCHEME_AUDIT_STAGE=1;//审核策划阶段
		public static final int PLANNING_STAGE=2;//制定任务方案阶段
		public static final int PLANNING_AUDIT_STAGE=3;//审核任务方案阶段
		public static final int GOING_STAGE=4;//活动进行阶段
		public static final int SUMMARY_STAGE=5;//活动总结阶段
		public static final int END_STAGE=6;//活动结束阶段
	}
	
	public static final class ActivityType{
		public static final int IN=1;//对内
		public static final int	out=0;//对外
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-13下午04:31:36
	 *函数名：BelongType
	 *功能：所属常量
	 *参数：
	 *返回值：
	 */
	public static final class BelongType{
		public static final int ORGANIZATION=2;//组织
		public static final int DEPARTMENT=0;//部门
		public static final int COROORATION=1;//社团
	}
	
	public static final class GradeType{
		public static final int MEMBER=1;//成员
		public static final int CADRE=2;//副部，骨干
		public static final int DEPUTY=3;//常副，副社长
		public static final int	MINISTER=4;//部长，社长
		public static final int	VICE_CHAIRMAN=5;//副主席
		public static final int	CHAIRMAN=6;//主席
		public static final int	NOTICE_MANAGER=10;//公告管理员
		public static final int	BULLETIN_MANAGER=11;//活动管理员
		public static final int	EQUIPMENY_MANAGER=12;//器材管理员
		public static final int	ECONOMICS_MANAGER=13;//资金管理员
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-13下午04:33:10
	 *函数名：MissionType
	 *功能：任务总结状态
	 *参数：
	 *返回值：
	 */
	public static final class MissionType{
		public static final int ON=1;//要写
		public static final int	OFF=0;//不要写
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-13下午04:33:37
	 *函数名：EconomicsRecordType
	 *功能：资金记录状态
	 *参数：
	 *返回值：
	 */
	public static final class EconomicsRecordType{
		public static final int EXPENDITURE=0;//消费
		public static final int INCOME=1;//收人
	}
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-13下午04:33:37
	 *函数名：EquipmentType
	 *功能：资金记录状态
	 *参数：
	 *返回值：
	 */
	public static final class EquipmentType{
		public static final int LEND=0;//借出
		public static final int RETURN=1;//返还
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-13下午04:34:49
	 *函数名：FileType
	 *功能：文件状态
	 *参数：
	 *返回值：
	 */
	public static final class FileType{
		public static final int SCHEME=0;//活动策划
		public static final int APPLICATION=1;//社团申请书
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-17下午04:06:32
	 *函数名：审核情况
	 *功能：TODO
	 *参数：
	 *返回值：
	 */
	public static final class ExamineType{
		public static final int SUCCESS=0;//成功
		public static final int FAIL=1;//失败
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午04:08:28
	 *函数名：消息内容
	 *功能：TODO
	 *参数：
	 *返回值：
	 */
	public static final class INFORMATIONCONTENT{
		public static final String JOINPARTSUCCESS="你已经成功加入了?，恭喜你成为我们的一员！";//加入部门或社团成功（组织部门 /社团 名）
		public static final String JOINPARTFAIL="很遗憾，你并没有通过我们的审核，请继续努力！——?";//加入部门或社团失败（组织部门 /社团 名）
		
		public static final String FRIENDSUCCESS="?接受了你的好友请求！";//加好友成功（用户名）
		public static final String FRIENDFAIL="?拒绝了你的好友请求！";//加好友失败（用户名）
		
		public static final String SELECTACTIVITYPLANCREATOR="恭喜你成为?活动编号为@的任务方案制定人！";//?组织名  @活动编号
		public static final String SELECTACTIVITYPLOTTER="?新活动意向建立，编号为?，恭喜你成为新活动的活动策划人！";//?组织名  @活动编号
		
		public static final String CREATESCHEME="?的编号为@的活动的活动策划已经提交，请验收！";//提交策划（?组织名 @活动编号）
		public static final String SCHEMESUCCESS="您编写的?的编号为@的活动的活动策划审核通过。";//策划审核通过（?组织名 @活动编号）
		public static final String SCHEMEFAIL="您编写的?的编号为@的活动的活动策划审核未通过，请等待上级指示。";//策划未审核通过（?组织名 @活动编号）
		
		public static final String CREATEPLAN="?的编号为@的活动的任务方案已经提交，请验收！";//提交任务方案（?组织名 @活动编号）
		public static final String PLANSUCCESS="您编写的?的编号为@的活动的任务方案审核通过。";//任务方案审核通过（?组织名 @活动编号）
		public static final String PLANEFAIL="您编写的?的编号为@的活动的任务方案审核未通过，请等待上级指示。";//任务方案未审核通过（?组织名 @活动编号）
		
		public static final String PARTCATIVITYSUCCESS="恭喜你，成功加入?活动,等待后续消息";//成功加入活动（?活动名）
		public static final String ACTIVITYMESSAGE="?——@活动管理员";//活动消息,(?消息内容  @活动名)
		
		public static final String ACTIVITYRESULT="活动进入总结状态，请提交活动总结。——?活动管理员。";//活动总结提醒（?活动名）
		
		public static final String APPLYCORPORATION="?有人申请社团，请验收";//申请社团（?组织名）
		public static final String APPLYCORPORATIONSUCCESS="你申请?社团成功";//申请社团（?社团名）
		
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-18下午04:12:00
	 *函数名：热门数量
	 *功能：TODO
	 *参数：
	 *返回值：
	 */
	public static final class HotNum{
		public static final int HOTACTIVITYNUM=5;//热门活动数量
		public static final int HOTCORPORATION=10;//热门社团数量
		public static final int HOTNOTICE=5;//热门布告数量
		
	}
	
	/**
	 * 
	 *作者：movie
	 *时间：2015-10-21上午10:44:13
	 *函数名：聊天所属状态
	 *功能：TODO
	 *参数：
	 *返回值：
	 */
	public static final class chatbelongType{
		public static final int PEOPLE=0;
		public static final int	MANYPEOPLE=1;
		
	}
	//组织
	public static final class OrganizeType{
		public static final int STUDENTUNION=1;//学生会
		public static final int	FEDERATION=3;//社联
		public static final int	YOUTH=2;//团委
		
		
	}
	public static final class UploadType{
		public static final int USER=0;
		public static final int ACTIVITY=1;
		public static final int CORPORATION=2;
		public static final int DEPARTMENT=3;
		public static final int GRADE=4;
		public static final int NOTICE=5;
		public static final int ORGANIZE=6;
	}
	public static final class UploadUrl{
		public static final String USERURL="img/user/";
		public static final String ACTIVITYURL="img/activity/";
		public static final String CORPORATIONURL="img/corporation/";
		public static final String DEPARTMENTURL="img/department/";
		public static final String GRADEURL="img/gradepic/";
		public static final String NOTICEURL="img/notice/";
		public static final String ORGANIZEURL="img/organize/";
	}
	
}
