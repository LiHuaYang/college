package com.Bll;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.Entity.V2.BriefCompetitionSet;
import com.Entity.V2.DetailedCompetition;
import com.Entity.V2.Report;
import com.EntityAndroid.ComBasicAddMoney;
import com.EntityAndroid.CompetitionBasicInfo;
import com.EntityAndroid.CompetitionNewsInfo;
import com.EntityAndroid.CompetitionStandInfo;
import com.EntityAndroid.CompetitionUserStandInfo;
import com.EntityAndroid.ContestCommitInfo;
import com.EntityAndroid.NewsInfo;
import com.EntityAndroid.NewsStandInfo;
import com.EntityAndroid.OrderBasicInfo;
import com.EntityAndroid.OrderStandInfo;
import com.EntityAndroid.SearchScord;
import com.EntityAndroid.UserBaseInfo;
import com.EntityAndroid.UserFavoriteCompetition;
import com.EntityAndroid.UserFavoriteGoods;
import com.EntityAndroid.UserFavoriteNews;
import com.EntityAndroid.UserInfobyId;
import com.EntityAndroid.UserScoreInfo;
import com.EntityAndroid.YearBasicData;
import com.EntityWeb.AreaBasicData;
import com.EntityWeb.Collect;
import com.EntityWeb.Competition;
import com.EntityWeb.CompetitionBasicData;
import com.EntityWeb.CompetitionInfo;
import com.EntityWeb.Contest;
import com.EntityWeb.ContestCommit;
import com.EntityWeb.Enrollment;
import com.EntityWeb.GradeBasicData;
import com.EntityWeb.Joiner;
import com.EntityWeb.News;
import com.EntityWeb.Organization;
import com.EntityWeb.SMS;
import com.EntityWeb.StudentScoreInfo;
import com.EntityWeb.SubjectBasicData;
import com.EntityWeb.TestPaper;
import com.EntityWeb.TestPaperPicture;
import com.EntityWeb.User;

public class CBllFrame implements IBllFrame{

	private CBllCompetition cBllCompetition = null; // 大赛模块业务层
	private CBllNews cBllNews = null; // 新闻模块业务层
	private CBllUser cBllUser = null; // 用户模块业务层
	private CBllProduct cBllProduct = null; // 商场模块业务层
	private CBllReport cBllReport = null;     //成绩模块业务层
	// private CBllEnrollment cBllEnrollment = null; // 大赛报名业务层
	
	
	//业务逻辑框架类单例
	private static CBllFrame cBllFrame = new CBllFrame();
	
	private CBllFrame(){
		cBllCompetition = new CBllCompetition(); 
		cBllNews = new CBllNews();
		cBllUser = new CBllUser(); 
		cBllProduct = new CBllProduct();  
		cBllReport = new CBllReport();
		// cBllEnrollment = DaoFactory.getInstance().createDao("com.Dao.Imp.DaoErollmentOrderImpl",DaoErollmentOrder.class);
	};
	
	public static CBllFrame getInstance(){
		return cBllFrame;
	}
	
/***********************************安卓部分**************************************/	
	
//-----------------------------大赛管理----------------------------
	
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
		List<CompetitionNewsInfo> result=cBllCompetition.SearchCompetitionNamePicPro();
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
		List<CompetitionBasicInfo> result=cBllCompetition.SearchCompetitionMain(ContestObject, ContestState);
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
		boolean result=cBllCompetition.EnrollmentComptition(enrollment);
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
	public List<CompetitionUserStandInfo> QueryUnendCompetition(int userid,int UserContestState){
		return null;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午02:36:57
	 *函数名：QueryendCompetition
	 *功能：查看结束比赛
	 *参数：用户id：userid；比赛状态：UserContestState
	 *返回值：List<CompetitionStandInfo>
	 */
	public List<CompetitionStandInfo> QueryendCompetition(int userid,int UserContestState){
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
	 *时间：2016-1-27下午06:26:54
	 *函数名：QueryContestInfobyId
	 *功能：查询网页端大赛的信息通过大赛id
	 *参数：大赛项目id
	 *返回值：CompetitionBasicInfo
	 */
	public List<CompetitionBasicInfo> GetWebContestInfobyId(int Competitionid){
		List<CompetitionBasicInfo> result=cBllCompetition.GetWebContestInfobyId(Competitionid);
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
		competitionBasicInfo=cBllCompetition.QueryFinishedContest();
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
		List result=cBllCompetition.QuerySearchCompetition(CompetitionSearchName);
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
		List<CompetitionBasicInfo> result=cBllCompetition.GetContestInfobyId(CompetitionId);
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
		List<ContestCommitInfo> result=cBllCompetition.GetContestCommitInfo(CompetitionId,page);
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
		int result=cBllCompetition.GetCountbyCopetiitonId(CompetitionId);
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
		result=cBllCompetition.SearchCompetitionCludeMoney();
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
		number=cBllCompetition.Number_Competition(ContestState);
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
		List<Competition> result=cBllCompetition.GetCompetitionInfoEnrollmenting();
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
		List result=cBllCompetition.QueryWebEnrollmentbefore();
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
		List<Contest> result=cBllCompetition.GetContestSubject(Competitionid);
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
		List<Integer> result=cBllCompetition.SearchContestObject(CompetitionId, ContestSubject);
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
		float result=cBllCompetition.CalculationCommitRankAverage(CompetitionId);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-26下午04:11:29
	 *函数名：QueryTestNameTimeInfo
	 *功能：查找试卷表的名字和发布时间
	 *参数：无
	 *返回值：List<TestPaper>
	 */
	public List<TestPaper> QueryTestNameTimeInfo(int page){
		List<TestPaper> result=cBllCompetition.QueryTestNameTimeInfo(page);
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
		List<TestPaperPicture> result=cBllCompetition.GetTestPaperPictureById(TestPaperId);
		return result;
	}
	
	/** 
	 *作者：WangYuwei
	 *时间：2016-2-26下午09:48:22
	 *函数名：QueryTestPaperSearch
	 *功能：试卷列表搜索功能
	 *参数：
	 *返回值：List<TestPaper>
	 */
	public List<TestPaper> QueryTestPaperSearch(){
		List<TestPaper> result=cBllCompetition.QueryTestPaperSearch();
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
		boolean result= cBllCompetition.CommitCreate(contestCommit);
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-27下午04:29:54
	 *函数名：SearchCountEnrollmentByCompetiitonId
	 *功能：得到大赛的周报名人数
	 *参数：大赛id：competitionId
	 *返回值：int
	 */
	public int GetCountEnrollmentByCompetiitonId(int competitionId){
		int result= cBllCompetition.GetCountEnrollmentByCompetiitonId(competitionId);
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
		int result= cBllCompetition.GetWeekCountEnrollmentByCompetiitonId(competitionId);
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
		
		int result=cBllCompetition.QueryTextNumber(ContestSubject,CompetitionName,StudentGrade);
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
		CompetitionBasicInfo result=cBllCompetition.SearchContestMoneybyId(contestId);
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
		List<Organization> result=cBllCompetition.GetOrganization(contestId);
		return result;
	}
	
	/**
	 * 
	 *作者：lujinye
	 *时间：2016年2月28日14:32:22
	 *函数名：GetCompetitionNamebyNameID
	 *功能：查询大赛名和简称
	 *参数：@param 
	 *参数：@param 
	 *参数：@return
	 *返回值：CompetitionBasicData
	 */	
	public List<CompetitionBasicData> GetCompetitionNamebyNameID(){
		List<CompetitionBasicData> result=cBllCompetition.GetCompetitionNamebyNameID();
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
	public List<SubjectBasicData> GetCompetitionProjectbyProjectId() {
		List<SubjectBasicData>  result=cBllCompetition.GetCompetitionProjectbyProjectId();
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
		List<GradeBasicData>  result=cBllCompetition.GetCompetitionObjectbyObjectId();
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
		List<AreaBasicData>  result=cBllCompetition.GetCompetitionAreabyAreaId();
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
		boolean  result=cBllCompetition.CollectStateJudge(TestPaperId,userid);
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
		boolean  result=cBllCompetition.CancelCollect(TestPaperId,userid);
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
		boolean  result = cBllCompetition.Changepassword(UserPhone,UserPWD);
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
		String result = cBllCompetition.GetBasicPictureData();
		return result;
	}
	
	 /** 
	 *作者：WangYuwei
	 *时间：2016-3-3上午10:49:32
	 *函数名：GetTestPaperYearbyObjectId
	 *功能：查询基础表的年份
	 *参数：无
	 *返回值：List<YearBasicData>
	 */
	public List<YearBasicData> GetTestPaperYearbyObjectId(){
		List<YearBasicData> result = cBllCompetition.GetTestPaperYearbyObjectId();
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
		
		int result=cBllCompetition.QueryContestId(CompetitionId, ContestSubject, ContestObject);
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
		List<String> result=cBllCompetition.QueryCompetitionpic(CompetitionId);
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
		List<Enrollment> result=cBllCompetition.SearchCompetitionName();
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
		
		boolean result = cBllCompetition.JudgeEnrollOrNot(UserIdNumber, CompetitionName, ContestSubject, ContestObject);
		return result;
	}
//-----------------------------新闻管理----------------------------
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-16下午09:02:36
	 *函数名：SearchNewsTopStaTime
	 *功能：查询新闻的头条，发布时间和状态
	 *参数：无
	 *返回值：List<News>
	 */
	public List<News> SearchNewsTopStaTime(){
		List<News> result=cBllNews.SearchNewsTopStaTime();
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午03:09:25
	 *函数名：QueryCompetitionMain
	 *功能：查询大赛主界面显示信息
	 *参数：新闻类型：NewsType
	 *返回值：List<NewsStandInfo>
	 */
	public List<NewsStandInfo> QueryNewsMain(int NewsType){
		return null;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-29下午08:49:00
	 *函数名：SearchAllNews
	 *功能：查找所有的新闻
	 *参数：
	 *返回值：List<NewsInfo>
	 */
	public List<News> SearchAllNews(int page){
		
		List<News> result=null;
		result=cBllNews.SearchAllNews(page);
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-25上午10:26:18
	 *函数名：SearchTopNews
	 *功能： 查询头条新闻里的内容
	 *参数：无
	 *返回值：List<NewsInfo>
	 */
	public List<NewsInfo> SearchTopNews(){
		List<NewsInfo> result=null;
		result=cBllNews.SearchTopNews();
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-25下午01:20:05
	 *函数名：SearchSingleNewsbyId
	 *功能：通过id查找单个新闻内容
	 *参数：newsId:新闻id
	 *返回值：List<NewsInfo>
	 */
	public List<NewsInfo> SearchSingleNewsbyId(int newsId){
		List<NewsInfo> result=cBllNews.SearchSingleNewsbyId(newsId);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-25下午07:49:03
	 *函数名：GetNewsbyNameState
	 *功能：通过名字和状态查找新闻
	 *参数：NewsSearch:新闻名字或者状态
	 *返回值：List<News>
	 */
	public List<News> SearchNewsbyNameState(String NewsSearch){
		List<News> result=cBllNews.SearchNewsbyNameState(NewsSearch);
		return result;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-2-26下午07:24:14
	 *函数名：GetNewsNumber
	 *功能：获得所有新闻总数
	 *参数：
	 *返回值：int
	 */
	public int GetNewsNumber(){
		
		int count=0;
		count=cBllNews.GetNewsNumber();
		return count;
	}
//-----------------------------订单管理----------------------------
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午03:13:07
	 *函数名：QueryOrderMain
	 *功能：查询订单主界面显示信息
	 *参数：无
	 *返回值：List<OrderStandInfo>
	 */
	public List<OrderBasicInfo> QueryOrderMain(){
		return null;
		
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午03:17:27
	 *函数名：QueryOrderDetailInfo
	 *功能：查询订单详情
	 *参数：订单id：Orderid
	 *返回值：OrderStandInfo
	 */
	public OrderStandInfo QueryOrderDetailInfo(int OrderId){
		return null;
	}
	
//-----------------------------商城管理----------------------------
//-----------------------------用户管理----------------------------
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午03:21:34
	 *函数名：LoginAccount
	 *功能：通过账号密码登录
	 *参数：账号：account；密码：password
	 *返回值：UserBaseInfo
	 */
	public UserBaseInfo LoginAccount(String account,String password){
		UserBaseInfo user=null;
		user=cBllUser.LoginAccount(account, password);
		return user;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-24下午12:09:26
	 *函数名：LoginWeb
	 *功能：在网页端的通过账号密码登录
	 *参数：电话号码（账号）：account；密码：password
	 *返回值：int
	 */
	public int LoginWeb(String account,String password){
		int Userid=cBllUser.LoginWeb(account, password);
		return Userid;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午04:00:38
	 *函数名：UserRegister
	 *功能：用户注册
	 *参数：手机号：UserPhone；密码：UserPassword
	 *返回值：boolean
	 */
	public boolean UserRegister(User user){
		boolean result=cBllUser.UserRegister(user);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-14下午08:27:58
	 *函数名：ChangeUserNikeName
	 *功能：修改用户昵称
	 *参数：用户昵称：userNickname,用户id：userid
	 *返回值：boolean
	 */
	public boolean ChangeUserNikeName(int UserId,String UserNikeName){
		boolean result=cBllUser.ChangeUserNikeName(UserId, UserNikeName);
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-16下午04:04:13
	 *函数名：SearchUserBasicInfo
	 *功能：查询用户的昵称，性别，联系电话和学习年级
	 *参数：用户id：userid
	 *返回值：User
	 */
	public User SearchUserBasicInfo(int userid){
		User rsult=cBllUser.SearchUserBasicInfo(userid);
		return rsult;
		
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-16下午05:02:11
	 *函数名：ChangeUserContactsPhon
	 *功能：修改用户联系电话
	 *参数：用户联系电话：userContactsPhon,用户id：userid
	 *返回值：boolean
	 */
	public boolean ChangeUserContactsPhon(int UserId,String userContactsPhon){
		boolean result=cBllUser.ChangeUserContactsPhon(UserId, userContactsPhon);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-17下午05:34:52
	 *函数名：ChangeUserContactsSex
	 *功能：修改用户性别
	 *参数：用户性别：userSex,用户id：userid
	 *返回值：boolean
	 */
	public boolean ChangeUserContactsSex(int userid,String userSex){
		boolean result=cBllUser.ChangeUserContactsSex(userid, userSex);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-17下午05:47:30
	 *函数名：ChangeUserGrade
	 *功能：用户年级修改
	 *参数：用户年级：UserGrade,用户id：userid
	 *返回值：boolean
	 */
	public boolean ChangeUserGrade(int userid,int UserGrade){
		boolean result=cBllUser.ChangeUserGrade(userid, UserGrade);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-21下午12:33:03
	 *函数名：ChangeUserPassword
	 *功能：用户密码修改
	 *参数：用户新密码：UserPassword,用户旧密码：OldPassword,用户id：userid
	 *返回值：boolean
	 */
	public boolean ChangeUserPassword(int userid,String OldPassword,String UserPassword){
		boolean result=cBllUser.ChangeUserPassword(userid, OldPassword, UserPassword);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午03:21:34
	 *函数名：LoginAccount
	 *功能：通过QQ号码登录
	 *参数：QQ号码：UserQQAccount
	 *返回值：UserBaseInfo
	 */
	public UserBaseInfo LoginQQ(String UserQQAccount){
		return null;
		
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午03:21:34
	 *函数名：LoginAccount
	 *功能：通过微博账号登录
	 *参数：QQ号码：UserQQAccount
	 *返回值：UserBaseInfo
	 */
	public UserBaseInfo LoginMicro(String UserMicrobloggingAccount){
		return null;
		
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午03:30:59
	 *函数名：QueryCollectCompetition
	 *功能：查看收藏的比赛的列表
	 *参数：收藏的类型：CollectionType；用户的id：userid
	 *返回值：UserFavoriteCompetition
	 */
	public UserFavoriteCompetition QueryCollectCompetition(int CollectionType,int userid){
		return null;
		
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午03:30:59
	 *函数名：QueryCollectCompetition
	 *功能：查看收藏的新闻的列表
	 *参数：收藏的类型：CollectionType；用户的id：userid
	 *返回值：UserFavoriteCompetition
	 */
	public UserFavoriteNews QueryCollectNews(int CollectionType,int userid){
		return null;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-12下午03:30:59
	 *函数名：QueryCollectCompetition
	 *功能：查看收藏的商品的列表
	 *参数：收藏的类型：CollectionType；用户的id：userid
	 *返回值：UserFavoriteCompetition
	 */
	public UserFavoriteGoods QueryCollectGoods(int CollectionType,int userid){
		return null;
		
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-26下午01:36:15
	 *函数名：searchScord
	 *功能：查询学生成绩
	 *参数：ContestSubject,StudentName,StudentTicket
	 *返回值：SearchScord
	 */
	public SearchScord searchScord(String ContestSubject,String StudentName,String StudentTicket,String EnrollmentPassword){
		
		SearchScord searchScord=null;
		searchScord=cBllUser.searchScord(ContestSubject, StudentName, StudentTicket,EnrollmentPassword);
		return searchScord;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-26下午09:12:44
	 *函数名：GetUserInfobyId
	 *功能：通过用户id查询报名信息
	 *参数：用户id：userid
	 *返回值：UserInfobyId
	 */
	public UserInfobyId GetUserInfobyId(int UserId){
		UserInfobyId result=cBllUser.GetUserInfobyId(UserId);
		return result;
	}

	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-26下午06:40:08
	 *函数名：CollectCreate
	 *功能：收藏试卷
	 *参数：CollectName:收藏名字，TestPaperId：试卷id，Userid：用户id
	 *返回值：boolean
	 */
	public boolean CollectCreate(Collect collect){
		boolean result=cBllUser.CollectCreate(collect);
		return result;
	}

	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-26下午08:35:52
	 *函数名：QueryCollectInfoByUserid
	 *功能：通过用户id查找收藏信息
	 *参数：用户id：userid
	 *返回值：List<Collect>
	 */
	public List<Collect> QueryCollectInfoByUserid(int Userid){
		List<Collect> result=cBllUser.QueryCollectInfoByUserid(Userid);
		return result;
	}
	
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-26下午09:16:37
	 *函数名：CancelCollenctState
	 *功能：通过用户Id和试卷id改变状态
	 *参数：用户id：collectId，试卷id：TestPaperId
	 *返回值：boolean
	 */
	public boolean CancelCollenctState(int Userid,int TestPaperId){
		boolean result=cBllUser.CancelCollenctState(Userid, TestPaperId);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-2-26下午10:02:43
	 *函数名：QueryScoreByUserid
	 *功能：通过用户id查询成绩
	 *参数：
	 *返回值：List<Enrollment>
	 */
	public List<UserScoreInfo> SearchScoreByUserid(int Userid){
		List<UserScoreInfo> result=cBllUser.SearchScoreByUserid(Userid);
		return result;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-2-27下午08:39:37
	 *函数名：QueryEnrollComByUserid
	 *功能：根据用户id获取已报名比赛
	 *参数：用户Id
	 *返回值：List<UserScoreInfo>
	 */
	public List<UserScoreInfo> QueryEnrollComByUserid(int Userid){
		
		List<UserScoreInfo> result=cBllUser.QueryEnrollComByUserid(Userid);
		return result;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-2-28下午02:52:21
	 *函数名：GetUserInfoById
	 *功能：根据用户id获取个人信息
	 *参数：userid
	 *返回值：User
	 */
	public User GetUserInfoById(int UserId){
		
		User result=cBllUser.GetUserInfoById(UserId);
		return result;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-2-28下午03:17:45
	 *函数名：ChangeUserInfo
	 *功能：修改用户信息（昵称，性别，联系号码，学习阶段，地址，图片）
	 *参数：  昵称，性别，联系号码，学习阶段，地址，图片,用户id
	 *返回值：true/false
	 */
	public boolean ChangeUserInfo(String UserNickName,String UserSex,String UserPhone,int UserGrade,String UserAddress,String UserPic,int UserId){
		
		boolean result=cBllUser.ChangeUserInfo(UserNickName, UserSex, UserPhone, UserGrade, UserAddress, UserPic, UserId);
		return result;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-3-2下午08:37:21
	 *函数名：ChangeUserPicture
	 *功能：上传用户头像
	 *参数：用户id：userId,用户头像：userPictureurl
	 *返回值：boolean
	 */
	public boolean ChangeUserPicture(int userid,String userpictureurl){
		boolean result=cBllUser.ChangeUserPicture(userid, userpictureurl);
		return result;
	}
	
	/**
	 * 
	 *作者：QiuMeifang
	 *时间：2016-3-4下午07:53:12
	 *函数名：UpdataUserAddress
	 *功能：用户地址修改
	 *参数：用户地址：userAddress,用户id：userid
	 *返回值：boolean
	 * @throws SQLException 
	 */
	public boolean UpdataUserAddress(int userid,String userAddress) {
		boolean result=cBllUser.UpdataUserAddress(userid, userAddress);
		return result;	
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-3-9下午07:30:01
	 *函数名：JudgeUserPhone
	 *功能：判断用户是否已经注册
	 *参数：用户账户：UserAccount
	 *返回值：boolean
	 */
	public boolean JudgeUserPhone(String UserAccount){
		boolean result=cBllUser.JudgeUserPhone(UserAccount);
		return result;
	}
	
	/**
	 * 
	 *作者：QiuMeifang
	 *时间：2016-3-9下午03:22:16
	 *函数名：UpdataUserPassword
	 *功能：用户密码修改
	 *参数：用户密码：UserPassage,用户id：userid
	 *返回值：boolean
	 * @throws SQLException 
	 */
	public boolean UpdataUserPassword(String UserPhone,String UserPassage){
		boolean result=cBllUser.UpdataUserPassword(UserPhone, UserPassage);
		return result;	
	}
 /***********************************web部分**************************************/
	
//-----------------------------大赛管理----------------------------
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
		if(cBllCompetition.ContestRelease(ContestId))
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
		
		if(cBllCompetition.ContestChangeState(ContestId, CompetitionState)){
			return true;
		}
		return false;
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
		
		if(cBllCompetition.CompetitionCreate(competition)){
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
	 *返回值：CompetitionName，StartTime，EndTime,ContestState,ContestObject
	 */
	public List<CompetitionInfo> ContestSearchInfo(int page){
		
		List<CompetitionInfo> competitionInfo=null;
		competitionInfo = cBllCompetition.ContestSearchInfo(page);
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
		competitionInfo=cBllCompetition.ContestSearchbyname(CompetitionName,page);
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
		competitionInfo=cBllCompetition.ContestSearchbytime(StartTime, EndTime,page);
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
		competitionInfo=cBllCompetition.ContestSearchSingelInfo(ContestId);
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
		competitionInfo=cBllCompetition.ContestSearchByOrganame(OrganizationName,page);
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
	public boolean CreateCompetitionAndContest(Competition competition, List<Contest> contests, List<String> orgs) {
		boolean res = cBllCompetition.CreateCompetitionAndContest(competition, contests, orgs);
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
		result=cBllCompetition.QueryAllCompetitionUser(page);
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
		result=cBllCompetition.QueryStuedntByComnaSub(CompetitionName, ContestSubject, page);
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
		 List<Organization> organizations = cBllCompetition.GetOrganizations();
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
		result=cBllCompetition.QueryALLCompetition();
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
		result=cBllCompetition.QueryAllSubByCompetitionName(CompetitionName);
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
		List<StudentScoreInfo> infos = cBllCompetition.GetStudentScore(name);
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
		List<CompetitionInfo> infos = cBllCompetition.ContestSearchByState(state);
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
		List<StudentScoreInfo> infos = cBllCompetition.GetStudentScore(comname, subname);
		return infos;
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
		int result=cBllCompetition.GetSearchTestParperCount(ContestSubject, CompetitionName, StudentGrade);
		return result; 
	}
//-----------------------------新闻管理----------------------------

//-----------------------------用户管理----------------------------
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-14下午16:28:34
	 *函数名：UserCreate
	 *功能：增加用户
	 *参数：User
	 *返回值：true/false
	 */
	public boolean UserCreate(User user){
		if(cBllUser.UserCreate(user)){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-14下午20:22:34
	 *函数名：UserSearchInfo
	 *功能：查询所有用户信息
	 *参数：无
	 *返回值：User
	 */
	public List<User> UserSearchInfo(int page){
		List<User> users=null;
		users=cBllUser.UserSearchInfo(page);
		return users;
	}
	
	/**
	 * 
	 *作者：ZhangHuanMing
	 *时间：2016-1-14下午20:48:34
	 *函数名：UserSearchSingelInfo
	 *功能：通过用户id查找单个用户所有信息
	 *参数：UserId
	 *返回值：User
	 */
	public User UserSearchSingelInfo(int UserId){
		User user=null;
		user=cBllUser.UserSearchSingelInfo(UserId);
		return user;
	}
	
	/**
	 * 
	 *作者：WangYuwei
	 *时间：2016-1-14下午02:53:11
	 *函数名：UserSearchSingelCompetitionInfo
	 *功能：查询单个用户信息的所有大赛信息
	 *参数：用户id：UserId
	 *返回值：CompetitionInfo
	 */
	public List<CompetitionInfo> UserSearchSingelCompetitionInfo(int UserId,int page){
		List<CompetitionInfo> competitionInfo=null;
		competitionInfo=cBllUser.UserSearchSingelCompetitionInfo(UserId,page);
		return competitionInfo;
	}
	
	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016年1月21日16:56:40
	 *函数名：UserSearchInfo
	 *功能：查询单个用户信息的所有大赛信息
	 *参数：JSONObject
	 *参数：page
	 *返回值：List<User>
	 */
	public List<User> UserSearchInfo(JSONObject obj, int page) {
		List<User> users = cBllUser.UserSearchInfo(obj, page);
		return users;
	}

	/**
	 * 
	 *作者：LiHuaYang
	 *时间：2016-1-22下午06:11:56
	 *函数名：ModifyUser
	 *功能：
	 *参数：@param type
	 *参数：@param id
	 *参数：@return
	 *返回值：boolean
	 */
	public boolean ModifyUser(int id, int type) {
		
		boolean flag = cBllUser.ModifyUser(id, type);
		return flag;
	}
	
	public boolean ImportUserData () {
		boolean flag = true;
		int i;
        Sheet sheet;
        Workbook book;
        Cell cell1,cell2,cell3;
        try { 
            //t.xls为要读取的excel文件名
            book = Workbook.getWorkbook(new File("D:\\t.xls")); 
             
            //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
            sheet = book.getSheet(0); 
            //获取左上角的单元格
            cell1 = sheet.getCell(0,0);
            System.out.println("标题："+cell1.getContents()); 
             
            i=1;
            while(true)
            {
                //获取每一行的单元格 
                cell1=sheet.getCell(0,i);//（列，行）
                cell2=sheet.getCell(1,i);
                cell3=sheet.getCell(2,i);
                if("".equals(cell1.getContents())==true)    //如果读取的数据为空
                    break;
                System.out.println(cell1.getContents()+"\t"+cell2.getContents()+"\t"+cell3.getContents()); 
                i++;
            }
            book.close(); 
        }
        catch(Exception e)  { }
        // System.out.println("nihao1");
        return flag;
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
		List<TestPaper> testpapers = cBllCompetition.SearchPaper(ContestSubject, CompetitionName, StudentGrade, page);
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
		int number = cBllCompetition.WeekNumber(StarTime, EndTime);
		return  number;
	}

	//短信验证码
	public int IsQualifiedSMS(String UserPhone, String SMSNumber) {
		// TODO Auto-generated method stub
		int res = cBllCompetition.IsQualifiedSMS(UserPhone, SMSNumber);
		return res;
	}

	//短信验证码
	public boolean pushSMS(SMS sms) {
		// TODO Auto-generated method stub
		boolean flag = cBllCompetition.pushSMS(sms);
		return flag;
	}

	public String IsExitUser(String UserPhone) {
		String result = cBllCompetition.IsExitUser(UserPhone);
		return result;
	}

	public boolean Add (Organization organization) {
		boolean flag = cBllCompetition.Add(organization);
		return flag;
	}

	//查询单个大赛的详细信息
	@Override
	public DetailedCompetition getCompetitionDetail(int competitionId) {

		return cBllCompetition.getCompetitionDetail(competitionId);
	}
	public BriefCompetitionSet getRecentCompetition(){
		return cBllCompetition.getRecentCompetition();
	}

	@Override
	public BriefCompetitionSet getCompetitionSet(int grade) {
		return cBllCompetition.getCompetitionSet(grade) ;
	}

	@Override
	public JSONArray getCompetitonNameByState(int state) {
		return cBllCompetition.getCompetitonNameByState(state);
		
	}
	@Override
	public JSONObject getCompetitonNumber() {
		return cBllCompetition.getCompetitonNumber();
	}

	@Override
	public BriefCompetitionSet getSet(String condition) {
		return cBllCompetition.getSet(condition);
	}

	@Override
	public Report searchScoreByInfo(Report checkInfo) {
		
		return cBllReport.searchScoreByInfo(checkInfo);
	}

	@Override
	public boolean updateScore(String path) {
		boolean result = cBllCompetition.updateScore(path);	
		return result;
	}

	@Override
	public boolean ChangeUserName(int UserId, String UserName) {
		boolean result=cBllUser.ChangeUserName(UserId, UserName);
		return result;
	}	
	
	@Override
	public boolean ChangeContactMan(int UserId, String ContactMan) {
		boolean result=cBllUser.ChangeContactMan(UserId, ContactMan);
		return result;
	}	
	
	
	
	@Override
	public boolean ChangeUserSchool(int UserId, String UserSchool) {
		boolean result=cBllUser.ChangeUserSchool(UserId, UserSchool);
		return result;
	}	
	
	
	public boolean ChangeUserIDNumber(int UserId, String UserIDNUmber) {
		boolean result=cBllUser.ChangeUserIDNumber(UserId, UserIDNUmber);
		return result;
	}

	@Override
	public boolean addReportSetToCache(String CompetitionName) {
		return cBllReport.addReportSetToCache(CompetitionName);
	}
	
	@Override
	public boolean clearScoreCache(String CompetitionName) {
		return cBllReport.clearScoreCache(CompetitionName);
	}
	

	
}
