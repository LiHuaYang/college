package cn.usgame.service.impl;

import java.util.ArrayList;
import java.util.List;
import cn.usgame.dao.CompetitionDao;
import cn.usgame.dao.DaoFactory;
import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Applyorder;
import cn.usgame.entity.Competition;
import cn.usgame.service.CompetitionService;
import cn.usgame.utils.TransactionUtil;


public class CompetitionServiceImpl implements CompetitionService {
	
	 private static CompetitionServiceImpl instance = new CompetitionServiceImpl();
	 private CompetitionServiceImpl() {}
	 public static CompetitionServiceImpl getInstance() {
		 return instance;
	 }
	 
	CompetitionDao ddao = DaoFactory.getInstance().create("cn.usgame.dao.dbutils_impl.CompetitionDaoImply", CompetitionDao.class);
	
	@Override
	public boolean addCompetition(Competition com) {
		TransactionUtil.getConnection(); 
		boolean result = false;

		try {
			TransactionUtil.startTransaction(); 
			// ... 
			if(com.getCompetitionId().equals("")) {
				result =  ddao.addCompetition(com);
			} else {
				result = ddao.updateCompetition(com);
			}

		} catch (Exception e){
			TransactionUtil.roolback();
			e.printStackTrace();
			result = false;
			
		} finally {
			TransactionUtil.commit();
			TransactionUtil.release(); 
		}
		return result;
	}
	
	@Override
	public List<Competition> getCompetitionList(int page,int type) {
		List<Competition> competitions = new ArrayList<>();
		if(type==1) {
			competitions = ddao.getAllCompetition(page);
		}
		else if(type==2) {
			competitions = ddao.getEffecCompetition();
		}
		return competitions;
	}
	
	@Override
	public Competition getCompetitionDetail(int competitionId) {
		Competition competition = ddao.getCompetitionById(competitionId);
		return competition;
	}
	
	@Override
	public String getCompetitionDes(int competitionId) {
		String competitionDes = ddao.getCompetitionDetailDes(competitionId);
		return competitionDes;
	}
	
	@Override
	public int applyReport(ApplyReport applyReport) {
		int result = -1;
		boolean temp = false;
		TransactionUtil.getConnection(); 
		int applyReportId = ddao.getApplyReport(applyReport);
		try {
			TransactionUtil.startTransaction(); 
			// 首次报名
			if (applyReportId == 0) {
				// 生成报名记录
				temp = ddao.applyReport(applyReport);
				
				// 生成订单记录 
				boolean res = ddao.addApplyorder(applyReport.getOut_trade_no());
				result = 1;
			}
			else if(applyReportId == 1) {//用户已经支付过
				result = 2;
			}
			else { // 修改资料后报名
				applyReport.setApplyReportId(applyReportId); // 
				temp = ddao.updateApplyReport(applyReport);
				result = 3;
			}
			// ...
		} catch (Exception e){
			TransactionUtil.roolback();
			e.printStackTrace();

		} finally {
			TransactionUtil.commit();
			TransactionUtil.release(); 
		}
		return result;
	}
	
	@Override
	public boolean userPay(Applyorder applyOrder) {
		boolean temp = false;
		boolean result = false;
		TransactionUtil.getConnection(); 

		try {
			TransactionUtil.startTransaction(); 
			temp = ddao.updateApplyorder(applyOrder);
			result = ddao.updateSateApplyReport(applyOrder);
			if(result&&temp) {
				result = true;
			}
			else {
				result = false;
			}
		} catch (Exception e) {
			TransactionUtil.roolback();
			e.printStackTrace();

		} finally {
			TransactionUtil.commit();
			TransactionUtil.release(); 
		}
		return result;
	}
	
	@Override
	public String getCompetitionNum() {
		return ddao.countCompetitionNum();
	}
	@Override
	public boolean reviseCompetitionState(int competitionId,int competitionState) {
		boolean result = false;
		TransactionUtil.getConnection(); 
		try {
			TransactionUtil.startTransaction(); 
			result = ddao.updateCompetitionState(competitionId, competitionState);
			
		} catch (Exception e) {
			TransactionUtil.roolback();
			e.printStackTrace();

		} finally {
			TransactionUtil.commit();
			TransactionUtil.release(); 
		}
		return result;
	}
	
	@Override
	public List<ApplyReport> getAllApplyReport(int page) {
		return  ddao.getAllReport(page);
	}
	
	@Override
	public String getApplyReportNum() {
		return ddao.countApplyReportNum();
	}
	
	@Override
	public ApplyReport getApplyReportDetail(String phoneNum) {
		return ddao.getApplyReportDetail(phoneNum);
	}

	@Override
	public List<ApplyReport> getApplyReport(String starttime, String endtime, String options, String Info,
			int orderState,int page) {
		return ddao.getApplyReport(starttime, endtime, options,Info, orderState,page);
	}
	
	@Override
	public String getSearchNum(String starttime, String endtime, String options, String Info,
			int orderState) {
		String num = ddao.countApplyReportBySearch(starttime, endtime, options, Info, orderState);
		return num;
	}
}
