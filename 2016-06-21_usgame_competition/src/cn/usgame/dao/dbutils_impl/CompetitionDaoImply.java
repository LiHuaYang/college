package cn.usgame.dao.dbutils_impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import cn.usgame.dao.CompetitionDao;
import cn.usgame.entity.ApplyReport;
import cn.usgame.entity.Applyorder;
import cn.usgame.entity.Competition;
import cn.usgame.utils.JdbcUtils_DBCP;
import cn.usgame.utils.TransactionUtil;


public class CompetitionDaoImply implements CompetitionDao {

	private static QueryRunner runerUpdate = new QueryRunner();
	private static QueryRunner runerQuery = new QueryRunner(JdbcUtils_DBCP.getDataSource());
	
	@Override
	public boolean addCompetition(Competition com) {
		boolean flag = true;
		String sql = "INSERT INTO competition (`competitionName`, `competitionSubject`, `competitionApplyStartTime`, `competitionApplyEndTime`, `competitionJoinerDes`, `competitionMoney`, `competitionType`, `competitionPrizeDes`, `competitionTestTimeDes`, `competitionApplyAddress`, `competitionTestAddress`, `competitionDetail`, `competitionSupportDesc`,`competitionForm`,`competitionState`,competitionGrade) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[ ] param = {
			com.getCompetitionName(),com.getCompetitionSubject(),com.getCompetitionApplyStartTime(),
			com.getCompetitionApplyEndTime(),com.getCompetitionJoinerDes(),com.getCompetitionMoney(),com.getCompetitionType(),
			com.getCompetitionPrizeDes(),com.getCompetitionTestTimeDes(),com.getCompetitionApplyAddress(),com.getCompetitionTestAddress(),
			com.getCompetitionDetail(),com.getCompetitionSupportDesc(),com.getCompetitionForm(),1,com.getCompetitionGrade()
		};
		
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
			
		} catch (SQLException e) {
			flag = false;
		}
		return flag;
	}
	
	@Override
	public List<Competition>  getAllCompetition(int page)  {
		//获取50条数据
		int startPos = (page - 1) * 30;
		List<Competition> competitions = null;
		String sql = "select * from competition order by competitionid limit ?,?"; 
		Object[] param = {startPos,30};
		
		try {
			competitions = runerQuery.query(sql, param, new BeanListHandler<Competition>(Competition.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competitions;
	}
	
	@Override
	public List<Competition> getEffecCompetition() {
		List<Competition> competitions = null;
		//competitionState=1为有限比赛，=0为无效比赛
		String sql = "select * from competition where competitionState=1";
		try {
			competitions = runerQuery.query(sql, new BeanListHandler<Competition>(Competition.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competitions;
	}
	
	@Override
	public Competition getCompetitionById(int competitionId) {
		Competition competition = new Competition();
		String sql = "select competitionId,competitionName,competitionSubject,competitionApplyStartTime,"
				+ "competitionApplyEndTime,competitionJoinerDes,competitionMoney,competitionType,"
				+ "competitionPrizeDes,competitionTestTimeDes,competitionApplyAddress,competitionTestAddress,"
				+ "competitionState,competitionSupportDesc,competitionForm,competitionGrade from competition where competitionId=?";
		Object[] param = {competitionId};
		try {
			competition = runerQuery.query(sql, param, new BeanHandler<>(Competition.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competition;
	}
	
	@Override
	public String getCompetitionDetailDes(int competitionId) {
		Competition competitionDetDes = null;
		String sql = "select competitionDetail from competition where competitionId=?";
		Object[] param = {competitionId};
		try {
			competitionDetDes = runerQuery.query(sql, param,new BeanHandler<>(Competition.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return competitionDetDes.getCompetitionDetail();
	}
	
	@Override
	public boolean applyReport(ApplyReport applyReport) {
		boolean result = true;
		String sql = "insert into applyreport (`applyReportId`,`name`,`idCard`,`school`,`grade`,`competitionName`,`competitionSubject`,`competitionGrade`,`contectName`,`contectPhone`,`phoneNumber`, out_trade_no,money,applyReportTime) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] param = {
				applyReport.getApplyReportId(),applyReport.getName(),applyReport.getIdCard(),applyReport.getSchool(),
				applyReport.getGrade(),applyReport.getCompetitionName(),applyReport.getCompetitionSubject(),applyReport.getCompetitionGrade(),
				applyReport.getContectName(),applyReport.getContectPhone(),applyReport.getPhoneNumber(),applyReport.getOut_trade_no(),applyReport.getMoney(),applyReport.getApplyReportTime()
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
		} catch(SQLException e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int getApplyReport(ApplyReport a) {
		ApplyReport applyReport = new ApplyReport();
		String sql = "select applyReportId,applyReportState from applyreport where idCard=? and competitionName=? and grade=? and competitionSubject=?";
		int applyReportId = 0;
		Object[] param = {
				a.getIdCard(),a.getCompetitionName(),a.getGrade(),a.getCompetitionSubject()
		};
		try {
			applyReport =  runerQuery.query(sql, param, new BeanHandler<>(ApplyReport.class));
		} catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			applyReportId = applyReport.getApplyReportId();
			if(applyReport.getApplyReportState()==1) {
				applyReportId = 1;
			}
			return applyReportId;
		} catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public boolean updateApplyReport(ApplyReport applyReport) {
		boolean result = true;
		String sql = "update applyreport set name=?,idCard=?,school=?,grade=?,competitionName=?,competitionSubject=?,competitionGrade=?,contectName=?,contectPhone=? where applyReportId=?";
		Object[] param = {
				applyReport.getName(),applyReport.getIdCard(),applyReport.getSchool(),applyReport.getGrade(),applyReport.getCompetitionName(),applyReport.getCompetitionSubject(),
				applyReport.getCompetitionGrade(),applyReport.getContectName(),applyReport.getContectPhone(),applyReport.getApplyReportId()
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
		} catch(SQLException e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	@Override
	public boolean updateApplyorder(Applyorder applyOrder) {
		boolean result = true;
		String sql = "update applyorder set openid=?,total_fee=?,transaction_id=?,time_end=? where out_trade_no=?";
		Object[] param = {
				applyOrder.getOpenid(),applyOrder.getTotal_fee(),
				applyOrder.getTransaction_id(), applyOrder.getTime_end(),applyOrder.getOut_trade_no()
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean updateSateApplyReport(Applyorder applyOrder) {
		boolean result = true;
		String sql = "update applyreport set applyReportState=? where out_trade_no=?";
		Object[] param = {
				1,applyOrder.getOut_trade_no()
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
		} catch(SQLException e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean addApplyorder(String out_trade_no) {
		boolean result = true;
		String sql = "insert into applyorder (out_trade_no) values (?)";
		Object[] param = {
				out_trade_no
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public String countCompetitionNum() {
		String number = null;
		Map a;
		String sql = "select count(*) from competition";
		try {
			a =  runerQuery.query(sql, new MapHandler());
			number = a.get("count(*)").toString();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return number;
	}
	@Override
	public boolean updateCompetitionState(int competitionId,int competitionState) {
		boolean result = true;
		String sql = "update competition set competitionState=? where competitionId=?";
		Object[] param = {
				competitionState,competitionId
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean updateCompetition(Competition com) {
		boolean result = true;
		String sql = "update competition set competitionName=?,competitionSubject=?,competitionApplyStartTime=?,competitionApplyEndTime=?,competitionJoinerDes=?,competitionMoney=?,competitionType=?,competitionPrizeDes=?,competitionTestTimeDes=?,competitionApplyAddress=?,competitionTestAddress=?,competitionDetail=?,competitionSupportDesc=?,competitionForm=? where competitionId=?";
		Object[] param = {
				com.getCompetitionName(),com.getCompetitionSubject(),com.getCompetitionApplyStartTime(),
				com.getCompetitionApplyEndTime(),com.getCompetitionJoinerDes(),com.getCompetitionMoney(),com.getCompetitionType(),
				com.getCompetitionPrizeDes(),com.getCompetitionTestTimeDes(),com.getCompetitionApplyAddress(),com.getCompetitionTestAddress(),
				com.getCompetitionDetail(),com.getCompetitionSupportDesc(),com.getCompetitionForm(),com.getCompetitionId()
		};
		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
		} catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<ApplyReport>  getAllReport(int page)  {
		//获取30条数据
		int startPos = (page - 1) * 30;
		List<ApplyReport> applyReport = null;
		String sql = "select * from applyreport limit ?,?"; 
		Object[] param = {startPos,30};
		
		try {
			applyReport = runerQuery.query(sql, param, new BeanListHandler<ApplyReport>(ApplyReport.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return applyReport;
	}
	
	@Override
	public String countApplyReportNum() {
		String number = null;
		Map a;
		String sql = "select count(*) from applyreport";
		try {
			a =  runerQuery.query(sql, new MapHandler());
			number = a.get("count(*)").toString();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return number;
	}
	
	@Override
	public ApplyReport getApplyReportDetail(String phoneNum) {
		ApplyReport applyReport = null;
		String sql = "select * from applyreport where phoneNumber=?";
		Object[] param= {phoneNum};
		try {
		applyReport = runerQuery.query(sql, param , new BeanHandler<ApplyReport>(ApplyReport.class));
		} catch(SQLException e){
			e.printStackTrace();
		}
		return applyReport;
	}

	@Override
	public List<ApplyReport> getApplyReport(String starttime, String endtime, String options, String Info,int orderState,int page) {
		int startPos = (page - 1) * 30;
		List<ApplyReport> applyReports = null;
		StringBuffer sql =new StringBuffer();
		sql.append("select * "); 
		sql.append(new ApplyReport().returnsql(starttime, endtime, options, Info, orderState));
		sql.append(" limit "+startPos+",30");
		try {
			applyReports = runerQuery.query(sql.toString(),new BeanListHandler<ApplyReport>(ApplyReport.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return applyReports;
	}
	
	@Override
	public String countApplyReportBySearch(String starttime, String endtime, String options, String Info,int orderState) {
		String number = null;
		Map a;
		StringBuffer sql =new StringBuffer();
		sql.append("select count(*) "); 
		sql.append(new ApplyReport().returnsql(starttime, endtime, options, Info, orderState));
		try {
			a =  runerQuery.query(sql.toString(),new MapHandler());
			number = a.get("count(*)").toString();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return number;
	}
	
	
	
	
//	@Override
//	public boolean updateCompetitionState(String competitionId) {
//		boolean result = true;
//		String sql = "update competition set competitionState=? where competitionId=?";
//		Object[] param = {0,competitionId};
//		try {
//			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
//		} catch(SQLException e) {
//			result = false;
//			e.printStackTrace();
//		}
//		return result;
//	}
	
	

	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
