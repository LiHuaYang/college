package cn.usgame.dao;

import java.util.List;

import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Applyorder;
import cn.usgame.entity.Competition;



public interface CompetitionDao {

	
	public boolean addCompetition(Competition com);

	/**
	 * 
	 * 函数名称：getAllCompetition
	 * 功能描述：获取比赛列表
	 * 参数说明：页数
	 * 返回值：List<Competition>
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月3日上午10:12:50
	 */
	List<Competition> getAllCompetition(int page);

	/**
	 * 
	 * 函数名称：getEffecCompetition
	 * 功能描述：获取有效的比赛列表
	 * 参数说明：
	 * 返回值：List<Competition>
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月4日下午1:35:06
	 */
	List<Competition> getEffecCompetition();

	/**
	 * 
	 * 函数名称：getCompetitionById
	 * 功能描述：
	 * 参数说明：
	 * 返回值：Competition
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月4日下午3:48:26
	 */
	Competition getCompetitionById(int competitionId);

	/**
	 * 
	 * 函数名称：getCompetitionDetailDes
	 * 功能描述：获取比赛详细描述
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月5日下午1:39:24
	 */
	String getCompetitionDetailDes(int competitionId);

	/**
	 * 
	 * 函数名称：applyReport
	 * 功能描述：插入数据到报名表中
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月5日下午3:31:17
	 */
	boolean applyReport(ApplyReport applyReport);

	/**
	 * 
	 * 函数名称：getApplyReport
	 * 功能描述：根据身份证，年级，大赛名取出id
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月7日下午2:06:08
	 */
	int getApplyReport(ApplyReport a);

	/**
	 * 
	 * 函数名称：updateApplyReport
	 * 功能描述：修改报名表
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月7日下午2:21:33
	 */
	boolean updateApplyReport(ApplyReport applyReport);

	/**
	 * 
	 * 函数名称：insertIntoApplyorder
	 * 功能描述：向Applyorder表插入数据
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月8日上午11:14:42
	 */
	boolean updateApplyorder(Applyorder applyOrder);

	
	
	/**
	 * 函数名称：addApplyorder
	 * 功能描述：生成一条订单记录
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年7月8日下午4:27:37
	 */
	boolean addApplyorder(String out_trade_no);
	
	
	
	/**
	 * 
	 * 函数名称：updateSateApplyReport
	 * 功能描述：修改applyreport表中applyReportState
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月8日上午11:18:44
	 */
	boolean updateSateApplyReport(Applyorder applyOrder);

	/**
	 * 
	 * 函数名称：countCompetitionNum
	 * 功能描述：获取比赛个数
	 * 参数说明：
	 * 返回值：int
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月11日下午10:36:41
	 */
	String countCompetitionNum();

	/**
	 * 
	 * 函数名称：updateCompetitionState
	 * 功能描述：修改比赛状态
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：1:未开始报名2:正在报名3:比赛结束
	 * 
	 * 作者：joker		时间：2016年7月12日上午10:49:33
	 */
	boolean updateCompetitionState(int competitionId, int competitionState);

	/**
	 * 
	 * 函数名称：updateCompetition
	 * 功能描述：修改比赛表
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月13日下午7:29:43
	 */
	boolean updateCompetition(Competition com);

	/**
	 * 
	 * 函数名称：getAllReport
	 * 功能描述：获取报名列表
	 * 参数说明：页数
	 * 返回值：List<ApplyReport>
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月13日下午8:37:32
	 */
	List<ApplyReport> getAllReport(int page);

	/**
	 * 
	 * 函数名称：countApplyReportNum
	 * 功能描述：取出报名表的数据个数
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月13日下午8:39:24
	 */
	String countApplyReportNum();

	/**
	 * 
	 * 函数名称：getApplyReportDetail
	 * 功能描述：根据手机号获取报名信息
	 * 参数说明：
	 * 返回值：ApplyReport
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月14日下午1:46:48
	 */
	ApplyReport getApplyReportDetail(String phoneNum);

//	/**
//	 * 
//	 * 函数名称：updateCompetitionState
//	 * 功能描述：更新比赛状态  0:已经删除的比赛
//	 * 参数说明：
//	 * 返回值：boolean
//	 * 备注：
//	 * 
//	 * 作者：joker		时间：2016年7月11日下午2:49:58
//	 */
//	boolean updateCompetitionState(String competitionId);
	
	/**
	 * 
	 * 函数名称：getApplyReport
	 * 功能描述：按条件搜索
	 * 参数说明：根据时间，注册号码，大赛名称或者支付状态查询订单
	 * 返回值：List<ApplyReport>
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年7月15日19:41:39
	 */
	List<ApplyReport> getApplyReport(String starttime , String endtime , String options , String Info , int orderState,int page);

	/**
	 * 
	 * 函数名称：countApplyReportBySearch
	 * 功能描述：获取搜索记录总数
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月16日下午7:43:46
	 */
	String countApplyReportBySearch(String starttime, String endtime, String options, String Info, int orderState);
}
