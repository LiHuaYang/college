package cn.usgame.service;


import java.util.List;

import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Applyorder;
import cn.usgame.entity.Competition;

public interface CompetitionService {

	
	public boolean addCompetition(Competition com);

	/**
	 * 
	 * 函数名称：getCompetitionList
	 * 功能描述：获取比赛列表
	 * 参数说明：page页号，type=1选出所以比赛列表，type＝2选出有效比赛
	 * 返回值：Competition
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月3日上午10:57:00
	 */
	List<Competition> getCompetitionList(int page,int type);

	/**
	 * 
	 * 函数名称：getCompetitionDetail
	 * 功能描述：通过比赛id获取比赛的详情
	 * 参数说明：
	 * 返回值：Competition
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月4日下午4:02:41
	 */
	Competition getCompetitionDetail(int competitionId);

	/**
	 * 
	 * 函数名称：getCompetitionDes
	 * 功能描述：获取比赛详细描述
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月5日下午1:41:44
	 */
	String getCompetitionDes(int competitionId);

	/**
	 * 
	 * 函数名称：applyReport
	 * 功能描述：用户报名
	 * 参数说明：
	 * 返回值：int
	 * 备注：1:首次报名2:已经支付过3:修改报名信息
	 * 
	 * 作者：joker		时间：2016年7月5日下午3:35:22
	 */
	int applyReport(ApplyReport applyReport);

	/**
	 * 
	 * 函数名称：userPay
	 * 功能描述：用户支付
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月8日上午11:26:34
	 */
	boolean userPay(Applyorder applyOrder);

	/**
	 * 
	 * 函数名称：getCompetitionNum
	 * 功能描述：获得比赛个数
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月11日下午11:08:45
	 */
	String getCompetitionNum();

	/**
	 * 
	 * 函数名称：reviseCompetitionState
	 * 功能描述：修改比赛状态
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：1:未开始报名2:正在报名3:比赛结束
	 * 
	 * 作者：joker		时间：2016年7月12日上午10:51:48
	 */
	boolean reviseCompetitionState(int competitionId, int competitionState);

	/**
	 * 
	 * 函数名称：getApplyReportNum
	 * 功能描述：	获取报名人数
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月13日下午8:45:27
	 */
	String getApplyReportNum();

	/**
	 * 
	 * 函数名称：getAllApplyReport
	 * 功能描述：按页码获取报名表
	 * 参数说明：
	 * 返回值：List<ApplyReport>
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月13日下午8:46:16
	 */
	List<ApplyReport> getAllApplyReport(int page);

	/**
	 * 
	 * 函数名称：getApplyReportDetail
	 * 功能描述：获取订单详细信息
	 * 参数说明：
	 * 返回值：ApplyReport
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月14日下午1:48:57
	 */
	ApplyReport getApplyReportDetail(String phoneNum);

//	/**
//	 * 
//	 * 函数名称：deleteCompetition
//	 * 功能描述：删除比赛
//	 * 参数说明：
//	 * 返回值：boolean
//	 * 备注：
//	 * 
//	 * 作者：joker		时间：2016年7月11日下午2:53:09
//	 */
//	boolean deleteCompetition(String competitionId);
	
	/**
	 * 
	 * 函数名称：getApplyReport
	 * 功能描述：按条件搜索
	 * 参数说明：
	 * 返回值：List<ApplyReport>
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年7月15日19:41:39
	 */
	List<ApplyReport> getApplyReport(String starttime , String endtime , String options , String Info , int orderState,int page);

	/**
	 * 
	 * 函数名称：getSearchNum
	 * 功能描述：获取搜索记录的总条数
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月16日下午7:46:27
	 */
	String getSearchNum(String starttime, String endtime, String options, String Info, int orderState);
	
}
