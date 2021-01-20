package com.Bll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.Dao.CDaoFrame;
import com.Dao.IDaoFrame;
import com.Entity.V2.BriefCompetitionSet;
import com.Entity.V2.DetailedCompetition;
import com.EntityAndroid.ComBasicAddMoney;
import com.EntityAndroid.CompetitionBasicInfo;
import com.EntityAndroid.CompetitionNewsInfo;
import com.EntityAndroid.CompetitionStandInfo;
import com.EntityAndroid.CompetitionUserStandInfo;
import com.EntityAndroid.ContestCommitInfo;
import com.EntityAndroid.UserScoreStandInfo;
import com.EntityAndroid.YearBasicData;
import com.EntityWeb.AreaBasicData;
import com.EntityWeb.Competition;
import com.EntityWeb.CompetitionBasicData;
import com.EntityWeb.CompetitionInfo;
import com.EntityWeb.Contest;
import com.EntityWeb.ContestCommit;
import com.EntityWeb.Enrollment;
import com.EntityWeb.GradeBasicData;
import com.EntityWeb.Joiner;
import com.EntityWeb.Organization;
import com.EntityWeb.SMS;
import com.EntityWeb.StudentScoreInfo;
import com.EntityWeb.SubjectBasicData;
import com.EntityWeb.TestPaper;
import com.EntityWeb.TestPaperPicture;

//大赛管理
public class CBllCompetition {
	
	IDaoFrame iDaoFrame = CDaoFrame.getInstance();
	
//	//CBllCompetition单例
//	private volatile static CBllCompetition cBllCompetition = null;
	
	public CBllCompetition(){
		System.out.println("CBllCompetition构造函数被调用");
	};
	
//	public static CBllCompetition getInstance(){
//		if(cBllCompetition == null){
//			synchronized (CBllCompetition.class) {
//				if(cBllCompetition == null){
//					cBllCompetition = new CBllCompetition();
//				}
//			}
//		}
//		
//		return cBllCompetition;
//	}
	
	// 短信验证码
	static SMS sms = new SMS();
	
	static Queue<SMS> smsQueue = new LinkedList<SMS>();
	
	public Queue<SMS> getSMS() {
		return this.smsQueue;
	}
	
	// 出队列
	public boolean popSMS() {
		boolean flag = false;
		if (this.smsQueue.poll() != null) {
			flag = true;
		}
		return flag;
	}
	// 进队列
	public boolean pushSMS(SMS sms) {
		boolean flag = false;
		flag = this.smsQueue.offer(sms);
		return flag;
	}
	
	// 检查在内存中手机号码条目是否合格
	public int IsQualifiedSMS(String Phone, String SMSNumber) {
		SMS sms = null;
		int flag = 3;
		System.out.println("传入内存验证的手机号码为：" + Phone);
		System.out.println("传入内存验证的验证码为：" + SMSNumber);
		System.out.println("内存中已存的第一个手机条目号码：" + this.smsQueue.peek().getPhoneNumber());
        while (this.smsQueue.peek() != null) { 
        	sms = this.smsQueue.peek();
        	if(sms.getPhoneNumber().equals(Phone)) {
        		if (IsTimeOver(sms)) {
        			flag = 2; // 2为数据条目有效期已过
        			System.out.println("此节点弹出Queue：" + this.smsQueue.peek().getPhoneNumber());
        			this.smsQueue.poll();
        		}
        		else {
        			if (sms.getCheckNumber().equals(SMSNumber)) {
        				flag = 0; // 0 为验证成功
        				this.smsQueue.poll();
        			}
        			else {
        				System.out.println("验证码错误：" + this.smsQueue.peek().getPhoneNumber());
        				flag = 1; // 1 为验证码错误
        				// this.smsQueue.poll();
        			}
        		}
        	}
        } 
		return flag; // 3 在Queue中找不到所要匹配和验证的手机号码
	}
	// 判断要查询的条目是否过期--不过期为false 过期为true
	public boolean IsTimeOver(SMS sms) {
		boolean flag = false;
		String SMSBuildTime = sms.getBulidtime();
		int circle = sms.getLifecycle();
		
		System.out.println("请求手机生成条目时间为：" + SMSBuildTime);
		System.out.println("请求手机生存周期为：" + circle);
		
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间  
        String nowtime = d.format(new Date());// 按以上格式 将当前时间转换成字符串
        int result = 0;
		try {
			// 获取时间差
			result = (int) ((d.parse(nowtime).getTime() - d.parse(SMSBuildTime).getTime())/1000);
			System.out.println("生成时间和周期的时间差是：" + (result-circle));
		} catch (ParseException e) {
			flag = true;
			e.printStackTrace();
		}
		if(result >= circle) {
			System.out.println("手机条目过期");
			flag = true;
		}
		return flag;
	}
//------------------------------安卓部分-----------------------------------	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-16下午01:08:42
	 *函数名：SearchCompetitionNamePicPro
	 *功能：查询所有大赛名字，大赛图片，大赛宣传语
	 *参数：无
	 *返回值：List<CompetitionNewsInfo>
	 */
	public List<CompetitionNewsInfo> SearchCompetitionNamePicPro(){
		List<CompetitionNewsInfo> result=iDaoFrame.SearchCompetitionNamePicPro();
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-17下午04:43:49
	 *函数名：SearchCompetitionMain
	 *功能：通过比赛对象和比赛状态查询一些大赛信息
	 *参数：比赛对象:ContestexamType,比赛状态：ContestState
	 *返回值：List<CompetitionBasicInfo>
	 */
	public List<CompetitionBasicInfo> SearchCompetitionMain(int ContestObject,int ContestState){
		List<CompetitionBasicInfo> result = iDaoFrame.SearchCompetitionMain(ContestObject, ContestState);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-24下午04:33:46
	 *函数名：EnrollmentComptition
	 *功能：用户报名
	 *参数：enrollment
	 *返回值：boolean
	 */
    public boolean EnrollmentComptition(Enrollment enrollment){
		boolean result=iDaoFrame.CreateEnrollment(enrollment);
		return result;
	}

	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午02:21:23
	 *函数名：QueryUnendCompetition
	 *功能：查看成绩
	 *参数：用户id：userid；比赛状态：UserContestState
	 *返回值：List<CompetitionBasicInfo>
	 */
	public List<UserScoreStandInfo> QueryUnendCompetition(int userid,int UserContestState){
		
		return null;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午02:36:57
	 *函数名：QueryendCompetition
	 *功能：查看未结束比赛
	 *参数：用户id：userid；比赛状态：UserContestState
	 *返回值：List<CompetitionStandInfo>
	 */
	public List<CompetitionUserStandInfo> QueryendCompetition(int userid,int UserContestState){
		return null;
		
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午02:54:38
	 *函数名：QueryCompetitionMain
	 *功能：查询大赛主界面显示信息
	 *参数：参赛级别：UserContestLevel；赛事进行状态：ContestOnState
	 *返回值：List<CompetitionBasicInfo>
	 */
	public List<CompetitionBasicInfo> QueryCompetitionMain(String UserContestLevel,int ContestOnState){
		return null;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午03:03:27
	 *函数名：QueryCompetitionDetailInfo
	 *功能：查询大赛信息详情
	 *参数：大赛id：CotestId
	 *返回值：CompetitionStandInfo
	 */
	public CompetitionStandInfo QueryCompetitionDetailInfo(int ContestId){
		return null;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-15下午09:17:59
	 *函数名：SearchMainPage
	 *功能：显示手机主页面的信息
	 *参数：无
	 *返回值：List<CompetitionNewsInfo>
	 */
	public List<CompetitionNewsInfo> SearchMainPage(){
		List<CompetitionNewsInfo> result=new ArrayList<CompetitionNewsInfo>();
		return result;
		
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-26下午02:54:23
	 *函数名：QueryFinishedContest
	 *功能：查找所有结束的比赛科目
	 *参数：
	 *返回值：List<CompetitionBasicInfo>
	 */
	public List<CompetitionBasicInfo> QueryFinishedContest(){
		
		List<CompetitionBasicInfo> competitionBasicInfo=null;
		competitionBasicInfo=iDaoFrame.QueryFinishedContest();
		return competitionBasicInfo;
	}
	
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-3-5下午05:52:38
	 *函数名：QuerySearchCompetition
	 *功能：搜索大赛的显示信息
	 *参数：大赛名称：CompetitionSearchName
	 *返回值：List
	 */
	public List QuerySearchCompetition(String CompetitionSearchName){
		List result=iDaoFrame.QuerySearchCompetition(CompetitionSearchName);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-27下午06:40:31
	 *函数名：GetContestInfobyId
	 *功能：查询大赛的信息通过大赛id
	 *参数：大赛项目id
	 *返回值：List<CompetitionBasicInfo>
	 */
	public List<CompetitionBasicInfo> GetContestInfobyId(int CompetitionId){
		List<CompetitionBasicInfo> result=iDaoFrame.QueryContestInfobyId(CompetitionId);
		return result;
	}
	
	

	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-27下午06:26:54
	 *函数名：QueryContestInfobyId
	 *功能：查询网页端大赛的信息通过大赛id
	 *参数：大赛项目id
	 *返回值：CompetitionBasicInfo
	 */
	public List<CompetitionBasicInfo> GetWebContestInfobyId(int Competitionid){
		List<CompetitionBasicInfo> result=iDaoFrame.QueryWebContestInfobyId(Competitionid);
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-3-4下午05:35:15
	 *函数名：QueryTestEnrollmentbefore
	 *功能：首页即将报名比赛
	 *参数：无
	 *返回值：List<CompetitionBasicInfo>
	 */
	public List QueryWebEnrollmentbefore(){
		List result=iDaoFrame.QueryWebEnrollmentbefore();
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-27下午08:59:17
	 *函数名：GetContestCommitInfo
	 *功能：显示评论信息通过比赛项目id
	 *参数：比赛项目id：ContestId
	 *返回值：List<ContestCommitInfo>
	 */
	public List<ContestCommitInfo> GetContestCommitInfo(int CompetitionId,int page){
		List<ContestCommitInfo> result=iDaoFrame.SearchContestCommit(CompetitionId,page);
		return result;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-28下午02:30:20
	 *函数名：SearchCompetitionCludeMoney
	 *功能：首页显示已经报名且报名截止时间离现在最近的一个大赛
	 *参数：
	 *返回值：List<ComBasicAddMoney>
	 */
	public List<ComBasicAddMoney> SearchCompetitionCludeMoney(){
		
		List<ComBasicAddMoney> result=null;
		result=iDaoFrame.SearchCompetitionCludeMoney();
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-28下午01:27:52
	 *函数名：GetCountbyCopetiitonId
	 *功能：得到评论总数通过大赛id
	 *参数：大赛id：Competitionid
	 *返回值：int
	 */
	public int GetCountbyCopetiitonId(int CompetitionId){
		int result=iDaoFrame.SearchCountbyCopetiitonId(CompetitionId);
		return result;
	}
	
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-28下午03:49:12
	 *函数名：Number_Competition
	 *功能：ContestState
	 *参数：查找正在报名和即将报名赛事个数分别是多少
	 *返回值：赛事个数
	 */
	public int Number_Competition(int ContestState){
		
		int number=0;
		number=iDaoFrame.Number_Competition(ContestState);
		return number;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-3-3下午09:41:18
	 *函数名：GetCompetitionInfoEnrollmenting
	 *功能：查询正在报名的比赛的信息
	 *参数：无
	 *返回值：List<Competition>
	 */
	public List<Competition> GetCompetitionInfoEnrollmenting(){
		List<Competition> result=iDaoFrame.QueryCompetitionInfoEnrollmenting();
		return result;
	}
	
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-28下午08:22:24
	 *函数名：GetContestSubject
	 *功能：查询大赛的所有科目
	 *参数：大赛id
	 *返回值：List<String>
	 */
	public List<Contest> GetContestSubject(int Competitionid){
		List<Contest> result=iDaoFrame.SearchContestSubject(Competitionid);
		return result;
	}
	
	

	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-28下午08:57:30
	 *函数名：SearchContestObject
	 *功能：查询大赛的所有年级
	 *参数：大赛id,竞赛科目
	 *返回值：List<Integer>
	 */
	public List<Integer> SearchContestObject(int CompetitionId,String ContestSubject){
		List<Integer> result=iDaoFrame.SearchContestObject(CompetitionId, ContestSubject);
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-26下午03:52:03
	 *函数名：CalculationCommitRankAverage
	 *功能：计算大赛的评论平均星级分数
	 *参数：大赛id：Competitionid
	 *返回值：float
	 */
	public float CalculationCommitRankAverage(int CompetitionId){
		float result=iDaoFrame.CalculationCommitRankAverage(CompetitionId);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-26下午04:11:29
	 *函数名：QueryTestNameTimeInfo
	 *功能：查找试卷表的名字和发布时间
	 *参数：页数：page
	 *返回值：List<TestPaper>
	 */
	public List<TestPaper> QueryTestNameTimeInfo(int page){
		List<TestPaper> result=iDaoFrame.QueryTestNameTimeInfo(page);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-26下午07:51:24
	 *函数名：QueryTestPaperPictureById
	 *功能：通过试卷id查找试卷图片详情
	 *参数：试卷id：TestPaperid
	 *返回值：List<TestPaperPicture>
	 */
	public List<TestPaperPicture> GetTestPaperPictureById(int TestPaperId){
		List<TestPaperPicture> result=iDaoFrame.QueryTestPaperPictureById(TestPaperId);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-26下午09:48:22
	 *函数名：QueryTestPaperSearch
	 *功能：试卷列表搜索功能
	 *参数：
	 *返回值：List<TestPaper>
	 */
	public List<TestPaper> QueryTestPaperSearch(){
		List<TestPaper> result=iDaoFrame.QueryTestPaperSearch();
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-27下午02:12:42
	 *函数名：ConmmitCreate
	 *功能：新建评论
	 *参数：contestCommit
	 *返回值：boolean
	 */
	public boolean CommitCreate(ContestCommit contestCommit){
		boolean result= iDaoFrame.CommitCreate(contestCommit);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-27下午04:29:54
	 *函数名：SearchCountEnrollmentByCompetiitonId
	 *功能：得到大赛的总报名人数
	 *参数：大赛id：competitionId
	 *返回值：int
	 */
	public int GetCountEnrollmentByCompetiitonId(int competitionId){
		int result= iDaoFrame.SearchCountEnrollmentByCompetiitonId(competitionId);
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-27下午07:54:40
	 *函数名：GetWeekCountEnrollmentByCompetiitonId
	 *功能：通过大赛id得到此大赛周报名人数
	 *参数：大赛id：competitionId
	 *返回值：int
	 */
	public int GetWeekCountEnrollmentByCompetiitonId(int competitionId){
		int result= iDaoFrame.SearchWeekCountEnrollmentByCompetiitonId(competitionId);
		return result;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-2-28下午07:42:10
	 *函数名：QueryTextNumber
	 *功能：查询试卷总数
	 *参数：
	 *返回值：试卷总数
	 */
	public int QueryTextNumber(String ContestSubject,String CompetitionName,String StudentGrade){
		
		int result=iDaoFrame.QueryTextNumber(ContestSubject,CompetitionName,StudentGrade);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-29上午08:53:16
	 *函数名：SearchContestMoneybyId
	 *功能：通过ContestId获取报名费，大赛开始时间，结束时间
	 *参数：竞赛id
	 *返回值：List<Integer>
	 */
	public CompetitionBasicInfo SearchContestMoneybyId(int contestId){
		CompetitionBasicInfo result=iDaoFrame.SearchContestMoneybyId(contestId);
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-29上午09:49:32
	 *函数名：GetOrganization
	 *功能：查询大赛机构
	 *参数：竞赛Id：contestId
	 *返回值：List<Organization>
	 */
	public List<Organization> GetOrganization(int contestId){
		List<Organization> result=iDaoFrame.QueryOrganization(contestId);
		return result;
	}
	
	
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月28日14:32:22
	 *函数名：GetCompetitionNamebyNameID
	 *功能：根据大赛名字基础id查询大赛名和简称
	 *参数：@param NameId
	 *参数：@param 
	 *参数：@return
	 *返回值：CompetitionBasicData
	 */	
	public List<CompetitionBasicData> GetCompetitionNamebyNameID(){
		List<CompetitionBasicData> result=iDaoFrame.GetCompetitionNamebyNameID();
		return result;
	}
	
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月28日16:28:30
	 *函数名：GetCompetitionProjectbyProjectID
	 *功能：查询科目
	 *参数：@param 
	 *参数：@param 
	 *参数：@return
	 *返回值：SubjectBasicData
	 */	
	public List<SubjectBasicData> GetCompetitionProjectbyProjectId() 
	{
		List<SubjectBasicData>  result=iDaoFrame.GetCompetitionProjectbyProjectId();
		return result;
	}
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月28日16:33:48
	 *函数名：GetCompetitionObjectbyObjectId
	 *功能：查询竞赛对象
	 *参数：@param ObjectId
	 *参数：@param 
	 *参数：@return
	 *返回值：GradeBasicData
	 */	
	public List<GradeBasicData> GetCompetitionObjectbyObjectId()
	{
		List<GradeBasicData>  result=iDaoFrame.GetCompetitionObjectbyObjectId();
		return result;
		
	}
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月28日16:42:43
	 *函数名：GetCompetitionAreabyAreaId
	 *功能：查询地区
	 *参数：@param AreaId
	 *参数：@param 
	 *参数：@return
	 *返回值：AreaBasicData
	 */	
	public List<AreaBasicData> GetCompetitionAreabyAreaId()
	{
		List<AreaBasicData>  result=iDaoFrame.GetCompetitionAreabyAreaId();
		return result;
		
	}
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月28日18:44:46
	 *函数名：CollectStateJudge
	 *功能：根据试卷id和用户id判断是否收藏
	 *参数：@param TestPaperId
	 *参数：@param userid
	 *参数：@return
	 *返回值：boolean
	 */	
	public boolean CollectStateJudge(int TestPaperId,int userid)
	{
		boolean  result=iDaoFrame.CollectStateJudge(TestPaperId,userid);
		return result;
		
	}
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月28日19:35:42
	 *函数名：CancelCollect
	 *功能：取消收藏
	 *参数：@param TestPaperId
	 *参数：@param userid
	 *参数：@return
	 *返回值：boolean
	 */
	public boolean CancelCollect(int TestPaperId,int userid)
	{		
		boolean  result=iDaoFrame.CancelCollect(TestPaperId,userid);
		return result;
	}
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年3月7日19:30:49
	 *函数名：Changepassword(String UserPhone,String UserPWD)
	 *功能：修改密码
	 *参数：@param UserPhone
	 *参数：@param UserPWD
	 *参数：@return
	 *返回值：boolean
	 */
	public boolean Changepassword(String UserPhone,String UserPWD)
	{
		boolean  result=iDaoFrame.Changepassword(UserPhone,UserPWD);
		return result;
		
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-3-1下午08:25:20
	 *函数名：QueryBasicPictureData
	 *功能：查询首页的主图片
	 *参数：无
	 *返回值：String
	 */
	public String GetBasicPictureData(){
		String result=iDaoFrame.QueryBasicPictureData();
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-3-2下午09:00:25
	 *函数名：QuerySearchTestParperCount
	 *功能：查询试卷搜索搜索后的总数
	 *参数：科目：ContestSubject 名字：CompetitionName 年级：StudentGrade
	 *返回值：int
	 */
	
	
	public int GetSearchTestParperCount(String ContestSubject,String CompetitionName,String StudentGrade){
		int result=iDaoFrame.QuerySearchTestParperCount(ContestSubject, CompetitionName, StudentGrade);
		return result; 
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-3-3上午10:49:32
	 *函数名：GetTestPaperYearbyObjectId
	 *功能：查询基础表的年份
	 *参数：无
	 *返回值：List<YearBasicData>
	 */
	public List<YearBasicData> GetTestPaperYearbyObjectId(){
		List<YearBasicData> result=iDaoFrame.GetTestPaperYearbyObjectId();
		return result;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-3-3下午07:44:49
	 *函数名：QueryContestId
	 *功能：根据大赛id,科目，参赛年级获得唯一的ContestId
	 *参数：大赛id,科目，参赛年级
	 *返回值：ContestId
	 */
	public int QueryContestId(int CompetitionId,String ContestSubject,int ContestObject){
		
		int result=iDaoFrame.QueryContestId(CompetitionId, ContestSubject, ContestObject);
		return result;
	}
	
	/**
	 * 
	 *作者：qiumeifang
     *时间：2016-3-4下午02:45:12
     *函数名：QueryCompetitionpic
	 *功能：根据竞赛id查询详情图片
	 *参数：CompetitionId
	 *返回值：results
	 */
	public List<String> QueryCompetitionpic(int CompetitionId){
		List<String> result=iDaoFrame.QueryCompetitionpic(CompetitionId);
		return result;
	}
	
	/**
	 * 
	 *作者：QiuMeifang
     *时间：2016-3-5上午10:47:10
     *函数名：SearchCompetitionName
	 *功能：查询大赛名字
	 *参数：无
	 *返回值：List<Enrollment>
	 */

	public List<Enrollment> SearchCompetitionName(){
		List<Enrollment> result=iDaoFrame.SearchCompetitionName();
		return result;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-3-9下午07:46:40
	 *函数名：JudgeEnrollOrNot
	 *功能：通过用户身份证号，大赛名称，科目，参赛年级判断此人是否已经报名
	 *参数：用户身份证号，大赛名称，科目，参赛年级
	 *返回值：boolean
	 */
	public boolean JudgeEnrollOrNot(String UserIdNumber,String CompetitionName,String ContestSubject,int ContestObject){
		
		boolean result = iDaoFrame.JudgeEnrollOrNot(UserIdNumber, CompetitionName, ContestSubject, ContestObject);
		return result;
	}
//------------------------------web部分-----------------------------------		
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-15下午20:37:34
	 *函数名：ContestRelease
	 *功能：大赛发布
	 *参数：ContestId
	 *返回值：true/false
	 */
	public boolean ContestRelease(int ContestId){
		if(iDaoFrame.ContestRelease(ContestId))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-15下午21:47:34
	 *函数名：ContestChangeState
	 *功能：改变大赛进行状态
	 *参数：ContestId，CompetitionState
	 *返回值：true/false
	 */
	public boolean ContestChangeState(int ContestId,int CompetitionState){
		
		if(iDaoFrame.ContestChangeState(ContestId, CompetitionState)){
			return true;
		}
		return false;
	}

	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-21下午03:16:30
	 *函数名：GetJoinerList
	 *功能：
	 *参数：@return
	 *返回值：List<Joiner>
	 */
	public List<Joiner> GetJoinerList(){

		List<Joiner> joiners = new ArrayList<Joiner>();
		// TODO:GetJoinerList()
		return joiners;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-16下午16:20:34
	 *函数名：CompetitionCreate
	 *功能：大赛新建
	 *参数：CompetitionInfo(CompetitionName,StartTime,EndTime,
				CompetitionSession,ContestState,CompetitionInfo,ParticularYear,
				ContestPropaganda,ContestPicUrl,ContestObject,ContestSubject,ContestMoney,ContestexamType);
	 *返回值：true/false
	 */
	public boolean CompetitionCreate(CompetitionInfo competition){
		
		if(iDaoFrame.CompetitionCreate(competition)){
			return true;
		}
		return false;
	}
	

	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-16下午18:55:34
	 *函数名：ContestSearchInfo
	 *功能：查询大赛所有信息
	 *参数：无
	 *返回值：CompetitionName，StartTime，EndTime,ContestState,ContestObject,ContestexamType
	 */
	public List<CompetitionInfo> ContestSearchInfo(int page){
		
		List<CompetitionInfo> competitionInfo=null;
		competitionInfo=iDaoFrame.ContestSearchInfo(page);
		return competitionInfo;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-16下午19:06:34
	 *函数名：ContestSearchbyname
	 *功能：通过大赛名称查询大赛信息
	 *参数：CompetitionName
	 *返回值：CompetitionName，StartTime，EndTime,ContestState,ContestObject,ContestexamType
	 */	
	public List<CompetitionInfo> ContestSearchbyname(String CompetitionName,int page){
		
		List<CompetitionInfo> competitionInfo=null;
		competitionInfo=iDaoFrame.ContestSearchbyname(CompetitionName,page);
		return competitionInfo;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-16下午19:37:34
	 *函数名：ContestSearchbytime
	 *功能：通过大赛开始结束时间查询大赛信息
	 *参数：StartTime，EndTime
	 *返回值：CompetitionName，StartTime，EndTime,ContestState,ContestObject,ContestexamType
	 */	
	public List<CompetitionInfo> ContestSearchbytime(String StartTime,String EndTime,int page){
		
		List<CompetitionInfo> competitionInfo=null;
		competitionInfo=iDaoFrame.ContestSearchbytime(StartTime, EndTime,page);
		return competitionInfo;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-16下午19:50:34
	 *函数名：ContestSearchSingelInfo
	 *功能：通过竞赛项目id查找单个大赛的信息
	 *参数：ContestId
	 *返回值：CompetitionInfo(CompetitionName,StartTime,EndTime,
				CompetitionSession,ContestState,CompetitionInfo,ParticularYear,
				ContestPropaganda,ContestPicUrl,ContestObject,ContestSubject,ContestMoney,ContestexamType);
	 */	
	public CompetitionInfo ContestSearchSingelInfo(int ContestId){
		
		CompetitionInfo competitionInfo=null;
		competitionInfo=iDaoFrame.ContestSearchSingelInfo(ContestId);
		return competitionInfo;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-16下午20:46:34
	 *函数名：ContestSearchByOrganame
	 *功能：通过承办方查找大赛信息
	 *参数：OrganizationName
	 *返回值：CompetitionName，StartTime，EndTime,ContestState,ContestObject,ContestexamType
	 */	
	public List<CompetitionInfo> ContestSearchByOrganame(String OrganizationName,int page){
		
		List<CompetitionInfo> competitionInfo=null;
		competitionInfo=iDaoFrame.ContestSearchByOrganame(OrganizationName,page);
		return competitionInfo;
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-24下午03:11:29
	 *函数名：CreateCompetition
	 *功能：TODO:这里是创建大赛和下面的所有竞赛的BLL层
	 *参数：@param competition
	 *参数：@return
	 *返回值：int
	 */
	public boolean CreateCompetitionAndContest(Competition competition, List<Contest> contests, List orgs) {
		boolean res = true;
		
		// 1. 创建新大赛项目
		int competitionID = iDaoFrame.CreateCompetition(competition);
		if (competitionID == 0) {
			res = false;
		}
		System.out.println("CBllCompetition List<Contest> contests : 数组的大小为" + contests.size());
		// 2. 创建新大赛的各个竞赛项目
		for (int i=0; i<contests.size(); i++) {
			Contest contest = contests.get(i);
			contest.setCompetitionId(competitionID);
			contest.setContestState(0);
			int res1  = iDaoFrame.CreateContest(contest);
			
			List org = (List) orgs.get(i);
			System.out.println("此竞赛项目的承办方ID数组为：" + org);
			int orgCount = org.size();
			for (int j=0; j<orgCount; j++) {
				String orgIdStr = (String) org.get(j);
				
				// for (int k=0; k<)
				int orgId = Integer.parseInt(orgIdStr);
				
				iDaoFrame.CreateContestOrganization(res1, orgId);
			}
		}
		return res;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-28下午06:57:31
	 *函数名：QueryAllCompetitionUser
	 *功能：获取参赛人员列表
	 *参数：
	 *返回值：List<Joiner>
	 */
	public List<Joiner> QueryAllCompetitionUser(int page){
		
		List<Joiner> result=null;
		result=iDaoFrame.QueryAllCompetitionUser(page);
		return result;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-28下午08:02:04
	 *函数名：QueryStuedntByComnaSub
	 *功能：通过大赛名称和大赛科目查找参赛人员
	 *参数：CompetitionName，ContestSubject
	 *返回值：List<Joiner>
	 */
	public List<Joiner> QueryStuedntByComnaSub(String CompetitionName,String ContestSubject,int page){
		
		List<Joiner> result=null;
		result=iDaoFrame.QueryStuedntByComnaSub(CompetitionName, ContestSubject, page);
		return result;
	}
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-28下午01:35:47
	 *函数名：GetOrganizations
	 *功能：
	 *参数：@return
	 *返回值：List<Organization>
	 */
	public List<Organization> GetOrganizations() {
		List<Organization> organizations = iDaoFrame.GetOrganizations();
		return organizations;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-28下午09:35:35
	 *函数名：QueryALLCompetition
	 *功能：查找所有的大赛
	 *参数：
	 *返回值：CompetitionName
	 */
	public List<Competition> QueryALLCompetition(){
		
		List<Competition> result=null;
		result=iDaoFrame.QueryALLCompetition();
		return result;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-28下午09:50:28
	 *函数名：QueryAllSubByCompetitionName
	 *功能：根据大赛名查找大赛下的大赛科目
	 *参数：
	 *返回值：ContestSubject
	 */
	public List<Contest> QueryAllSubByCompetitionName(String CompetitionName){
		
		List<Contest> result=null;
		result=iDaoFrame.QueryAllSubByCompetitionName(CompetitionName);
		return result;
	}
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-29上午08:04:28
	 *函数名：GetStudentScore
	 *功能：
	 *参数：@return
	 *返回值：List<StudentScoreInfo>
	 */
	public List<StudentScoreInfo> GetStudentScore(String name) {
		List<StudentScoreInfo> infos = iDaoFrame.GetStudentScore(name);
		return infos;
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-29上午09:07:58
	 *函数名：ContestSearchByState
	 *功能：
	 *参数：@param state
	 *参数：@return
	 *返回值：List<CompetitionInfo>
	 */
	public List<CompetitionInfo> ContestSearchByState(int state) {
		List<CompetitionInfo> infos = iDaoFrame.ContestSearchByState(state);
		return infos;
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-29下午02:00:58
	 *函数名：GetStudentScore
	 *功能：
	 *参数：@param comname
	 *参数：@param subname
	 *参数：@return
	 *返回值：List<StudentScoreInfo>
	 */
	public List<StudentScoreInfo> GetStudentScore(String comname, String subname) {
		List<StudentScoreInfo> infos = iDaoFrame.GetStudentScore(comname, subname);
		return infos;
	}
	
	/**
	 * 
	 *作者：ZhengChengDong
	 *时间：2016年2月28日16:08:10
	 *函数名：SearchPaper
	 *功能：搜索试卷
	 *参数：@param 
	 *参数：@param 
	 *参数：@return
	 *返回值：List<TestPaper>
	 */
	public List<TestPaper> SearchPaper(String ContestSubject,String CompetitionName,String StudentGrade,int page){
		List<TestPaper> testpapers = iDaoFrame.SearchPaper(ContestSubject, CompetitionName, StudentGrade, page);
		return testpapers;
	}
	
	/**
	 * 
	 *作者：ZhengChengDong
	 *时间：2016年2月28日16:08:10
	 *函数名：SearchPaper
	 *功能：搜索试卷
	 *参数：@param 
	 *参数：@param 
	 *参数：@return
	 *返回值：List<TestPaper>
	 */
	public int WeekNumber(String StarTime, String EndTime){
		int number = iDaoFrame.WeekNumber(StarTime, EndTime);
		return  number;
	}
	
	public String IsExitUser(String UserPhone){
		String result = iDaoFrame.IsExitUser(UserPhone);
		return result;
	}
	
	public boolean Add (Organization organization) {
		boolean flag = iDaoFrame.Add(organization);
		return flag;
	}
	
	public DetailedCompetition getCompetitionDetail(int competitionId) {
		return iDaoFrame.getModel(competitionId);
	}

	
	public BriefCompetitionSet getRecentCompetition(){
		return iDaoFrame.getRecentCompetition();
	}
	
	public BriefCompetitionSet getCompetitionSet(int grade) {
		return iDaoFrame.getSet(grade);
	}
	
	public JSONArray getCompetitonNameByState (int state) {
		return iDaoFrame.getCompetitonNameByState(state);
	}
	
	
	public JSONObject getCompetitonNumber() {
		return iDaoFrame.getCompetitonNumber();
	}
	
	public BriefCompetitionSet getSet(String condition){
		return iDaoFrame.getSet(condition);
	}
	
	public boolean updateScore (String path) {
		return iDaoFrame.updateScore(path);
	}
}




