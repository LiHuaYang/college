package com.nbut.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nbut.dao.ProgramDao;
import com.nbut.entity.Contest;
import com.nbut.entity.ContestSet;
import com.nbut.entity.Program;
import com.nbut.entity.ProgramSet;
import com.nbut.entity.Solution;
import com.nbut.entity.SolutionSet;
import com.nbut.utils.JdbcUtils_DBCP;

public class ProgramDaoImpl implements ProgramDao {

	@SuppressWarnings("finally")
	@Override
	public Program getAModel(String id) {
		Connection conn = JdbcUtils_DBCP.getConnection();
		Statement st = null;
		Program pro = null;
		ResultSet set = null;
		try {
			st = conn.createStatement();
			String sql = "select * from problem where problem_id='" + id + "' LIMIT 1;";
			st.executeQuery(sql);
			set = st.getResultSet();
			pro = new Program(set);
		} catch (SQLException e) {
			throw new RuntimeException("ProgramDaoImpl--getAModel ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, set);
			return pro;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public List<ProgramSet> getProgramSet_admin(int page) {
		int startPos = (page - 1) * 10;
		Connection conn = JdbcUtils_DBCP.getConnection();
		Statement st = null;
		ResultSet set = null;
		List<ProgramSet> list = null;
		ProgramSet pro = null;
		try {
			st = conn.createStatement();
			String sql = "select problem_id, title, source, accepted, submit,in_date,defunct from problem order by problem_id limit "
					+ startPos + "," + 50;
			st.executeQuery(sql);
			set = st.getResultSet();
			list = new ArrayList<ProgramSet>();
			while (set.next()) {
				pro = new ProgramSet(set);
				list.add(pro);
			}
		} catch (SQLException e) {
			throw new RuntimeException("ProgramDaoImpl--getProgramSet ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, set);
			return list;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public List<ProgramSet> getProgramSet_user(int page) {
		int startPos = (page - 1) * 10;
		Connection conn = JdbcUtils_DBCP.getConnection();
		Statement st = null;
		ResultSet set = null;
		List<ProgramSet> list = null;
		ProgramSet pro = null;
		try {
			st = conn.createStatement();
			String sql = "select problem_id, title, source, accepted, submit,in_date,defunct from problem where problem_id not in (select problem_id from contest_problem) and defunct='N' order by problem_id limit "
					+ startPos + "," + 10;
			st.executeQuery(sql);
			set = st.getResultSet();
			list = new ArrayList<ProgramSet>();
			while (set.next()) {
				pro = new ProgramSet(set);
				list.add(pro);
			}
		} catch (SQLException e) {
			throw new RuntimeException("ProgramDaoImpl--getProgramSet ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, set);
			return list;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public List<SolutionSet> getSolutionSet(int page) {
		int startPos = (page - 1) * 20;
		Connection conn = JdbcUtils_DBCP.getConnection();
		Statement st = null;
		ResultSet set = null;
		SolutionSet solu = null;
		List<SolutionSet> solus = null;
		try {
			st = conn.createStatement();
			String sql = "select solution_id,user_id,problem_id,result,memory,time,language,code_length,in_date, pass_rate from solution where problem_id >0 and contest_id is null Order by solution_id desc limit "
					+ startPos + "," + 20;
			st.executeQuery(sql);
			set = st.getResultSet();
			solus = new ArrayList<SolutionSet>();
			while (set.next()) {
				solu = new SolutionSet(set);
				solus.add(solu);
			}
		} catch (SQLException e) {
			throw new RuntimeException("ProgramDaoImpl--getSolutionSet ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, set);
			return solus;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean insertIntoSourceCcode(String code, int solutionId) {
		boolean result = false;
		Connection conn = JdbcUtils_DBCP.getConnection();
		Statement st = null;
		String sql = "insert into source_code values(" + solutionId + ",'" + code + "')";
		try {
			st = conn.createStatement();
			st.execute(sql);
			result = true;
		} catch (SQLException e) {
			result = false;
			throw new RuntimeException("ProgramDaoImpl--insertIntoSourceCcode ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, null);
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean insertIntoSourceUserCcode(String code, int solutionId) {
		boolean result = false;
		Connection conn = JdbcUtils_DBCP.getConnection();
		Statement st = null;
		try {
			st = conn.createStatement();
			String sql = "insert into source_code_user values(" + solutionId + ",'" + code + "')";
			st.execute(sql);
		} catch (SQLException e) {
			result = false;
			throw new RuntimeException("ProgramDaoImpl--insertIntoSourceUserCcode ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, null);
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public int insertIntoSolution(Solution solution) {
		boolean result = false;
		int solutionId = 0;
		Statement st = null;
		String sql = null;
		ResultSet set = null;
		Connection conn = JdbcUtils_DBCP.getConnection();
		try {
			st = conn.createStatement();
			if (solution.getContest_id() != 0) {
				sql = new String(
						"insert into solution (problem_id,user_id,in_date,language,ip,contest_id,num,code_length) values("
								+ solution.getProblem_id() + "," + solution.getUser_id() + ",'" + solution.getIn_date()
								+ "','" + solution.getLanguage() + "','" + solution.getIp() + "',"
								+ solution.getContest_id() + "," + solution.getNum() + "," + solution.getCode_length()
								+ ")");
			} else {
				sql = new String("insert into solution (problem_id,user_id,in_date,language,ip,num,code_length) values("
						+ solution.getProblem_id() + "," + solution.getUser_id() + ",'" + solution.getIn_date() + "','"
						+ solution.getLanguage() + "','" + solution.getIp() + "'," + solution.getNum() + ","
						+ solution.getCode_length() + ")");
			}
			st.execute(sql);
			result = true;
			if (result == true) {
				st.executeQuery("SELECT LAST_INSERT_ID()");
				set = st.getResultSet();
				while (set.next()) {
					solutionId = set.getInt(1);
				}
				JdbcUtils_DBCP.release(conn, st, set);
			} else {
				solutionId = 0;
			}
		} catch (SQLException e) {
			result = false;
			throw new RuntimeException("ProgramDaoImpl--insertIntoSolution ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, set);
			return solutionId;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public int[] selectContestByproblemId(int problemId) {
		int[] result = new int[2];
		Connection conn = JdbcUtils_DBCP.getConnection();
		Statement st = null;
		ResultSet set = null;
		try {
			st = conn.createStatement();
			String sql = "select contest_id,num from contest_problem where problem_id=" + problemId;
			st.executeQuery(sql);
			set = st.getResultSet();
			while (set.next()) {
				result[0] = (int) set.getObject("contest_id");
				result[1] = (int) set.getObject("num");
			}
		} catch (SQLException e) {
			throw new RuntimeException("ProgramDaoImpl--selectContestByproblemId ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, set);
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public List<ContestSet> getContestSet_admin() {
		Connection conn = JdbcUtils_DBCP.getConnection();
		Statement st = null;
		ResultSet set = null;
		ContestSet list = null;
		List<ContestSet> lists = null;
		try {
			st = conn.createStatement();
			String sql = "select c.contest_id,c.title,c.start_time,c.end_time,c.private,c.defunct from contest as c";
			st.executeQuery(sql);
			set = st.getResultSet();
			lists = new ArrayList<ContestSet>();
			while (set.next()) {
				list = new ContestSet(set);
				lists.add(list);
			}
		} catch (SQLException e) {
			list = null;
			throw new RuntimeException("ProgramDaoImpl--getContestSet ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, set);
			return lists;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public List<ContestSet> getContestSet_user() {
		Connection conn = JdbcUtils_DBCP.getConnection();
		Statement st = null;
		ResultSet set = null;
		ContestSet list = null;
		List<ContestSet> lists = null;
		try {
			st = conn.createStatement();
			String sql = "select c.contest_id,c.title,c.start_time,c.end_time,c.private,c.defunct, p.user_id from 	contest as c, 	privilege as p where 	c.contest_id in (select DISTINCT contest_id FROM contest) AND 	p.rightstr LIKE CONCAT('m',c.contest_id)";
			st.executeQuery(sql);
			set = st.getResultSet();
			lists = new ArrayList<ContestSet>();
			while (set.next()) {
				list = new ContestSet(set);
				lists.add(list);
			}
		} catch (SQLException e) {
			list = null;
			throw new RuntimeException("ProgramDaoImpl--getContestSet ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, set);
			return lists;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public List<SolutionSet> getSolutionSetByProblemId(int page, int problemId, int type) {
		int startPos = (page - 1) * 20;
		Connection conn = JdbcUtils_DBCP.getConnection();
		Statement st = null;
		String sql = null;
		ResultSet set = null;
		SolutionSet solu = null;
		List<SolutionSet> solus = null;
		try {
			st = conn.createStatement();
			if (type == 1) {
				sql = new String(
						"select solution_id,user_id,problem_id,result,memory,time,language,code_length,in_date, pass_rate from solution where problem_id >0 and contest_id is  null and result = 4 and problem_id = "
								+ problemId + " Order by solution_id desc limit " + startPos + "," + 20);
			} else {
				sql = new String(
						"select solution_id,user_id,problem_id,result,memory,time,language,code_length,in_date, pass_rate from solution where problem_id >0 and contest_id is  null and problem_id = "
								+ problemId + " Order by solution_id desc limit " + startPos + "," + 20);
			}
			st.executeQuery(sql);
			set = st.getResultSet();
			solus = new ArrayList<SolutionSet>();
			while (set.next()) {
				solu = new SolutionSet(set);
				solus.add(solu);
			}
		} catch (SQLException e) {
			throw new RuntimeException("ProgramDaoImpl--getSolutionSetByProblemId ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, set);
			return solus;
		}
	}

	@SuppressWarnings("finally")
	public int insertintoProblem(Program problem) {
		Connection conn = JdbcUtils_DBCP.getConnection();
		// Connection conn = TransactionUtil.getConnection();
		String sql = "insert into problem (title,description,input,output,sample_input,sample_output,spj,hint,source,in_date,time_limit,memory_limit) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement st = null;
		ResultSet set = null;
		int problemId = 0;
		try {
			st = conn.prepareStatement(sql);
			st.setObject(1, problem.getTitle());
			st.setObject(2, problem.getDescription());
			st.setObject(3, problem.getInput());
			st.setObject(4, problem.getOutput());
			st.setObject(5, problem.getSample_input());
			st.setObject(6, problem.getSample_output());
			st.setObject(7, problem.getSpj());
			st.setObject(8, problem.getHint());
			st.setObject(9, problem.getSource());
			st.setObject(10, problem.getIn_date());
			st.setObject(11, problem.getTime_limit());
			st.setObject(12, problem.getMemory_limit());
			int judge = st.executeUpdate();
			if (judge == 1) {
				st.executeQuery("SELECT LAST_INSERT_ID()");
				set = st.getResultSet();
				while (set.next()) {
					problemId = set.getInt(1);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("ProgramDaoImpl--insertIntoSourceUserCcode ERROR!!");
		} finally {
			// JdbcUtils_DBCP.release(conn, st, set);
			return problemId;
		}
	}

	@Override
	@SuppressWarnings("finally")
	public boolean insertintocontest_problem(int contestId, int problemId) {
		boolean result = false;
		Connection conn = JdbcUtils_DBCP.getConnection();
		String sql = "insert into contest_problem (problem_id,contest_id) values(?,?)";
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setObject(1, contestId);
			st.setObject(2, problemId);
			st.executeUpdate();
			result = true;
		} catch (SQLException e) {
			result = false;
			throw new RuntimeException("ProgramDaoImpl--insertIntoSourceUserCcode ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, null);
			return result;
		}
	}

	// @SuppressWarnings("finally")
	// @Override
	// public String selectCode(int solutionId) {
	// System.out.println(solutionId);
	// String result = null;
	// Connection conn = JdbcUtils_DBCP.getConnection();
	// PreparedStatement st = null;
	// ResultSet set = null;
	// String sql = "select * from source_code where solution_id=?";
	// try {
	// st = conn.prepareStatement(sql);
	// st.setInt(1,solutionId);
	// set = st.executeQuery(sql);
	//
	// System.out.println(result);
	// while (set.next()) {
	// result = (String)set.getObject("source");
	// System.out.println(result);
	// }
	// System.out.println("result" + result);
	// } catch(SQLException e) {
	// result = null;
	// throw new RuntimeException("ProgramDaoImpl--insertIntoSourceUserCcode
	// ERROR!!");
	// } finally {
	// JdbcUtils_DBCP.release(conn, st, set);
	// return result;
	// }
	// }

	@SuppressWarnings("finally")
	@Override
	public String selectCode(int solutionId) {
		System.out.println(solutionId);
		String result = null;
		Connection conn = JdbcUtils_DBCP.getConnection();
		PreparedStatement st = null;
		ResultSet set = null;
		String sql = "select * from source_code where solution_id=" + solutionId;
		try {
			st = conn.prepareStatement(sql);
			set = st.executeQuery(sql);
			while (set.next()) {
				result = (String) set.getObject("source");
			}
		} catch (SQLException e) {
			result = null;
			throw new RuntimeException("ProgramDaoImpl--insertIntoSourceUserCcode ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, set);
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Contest getContest(int contestId) {
		Connection conn = JdbcUtils_DBCP.getConnection();
		PreparedStatement st = null;
		ResultSet set = null;
		Contest contest = null;
		String sql = "select con.* , GROUP_CONCAT(pri.user_id) as user_ids, (SELECT GROUP_CONCAT(cop.problem_id) FROM contest_problem as cop WHERE cop.contest_id = con.contest_id) as problem_ids from 	contest as con, 	privilege as pri where 	con.contest_id=? AND 	pri.rightstr LIKE CONCAT('c',?);";
		try {
			st = conn.prepareStatement(sql);
			st.setObject(1, contestId);
			st.setObject(2, contestId);
			set = st.executeQuery();
			contest = new Contest(set);
		} catch (SQLException e) {
			contest = null;
			e.printStackTrace();
		} finally {
			JdbcUtils_DBCP.release(conn, st, set);
			return contest;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public List<ProgramSet> getContestProgramSet(int page, int contestId) {
		int startPos = (page - 1) * 10;
		Connection conn = JdbcUtils_DBCP.getConnection();
		Statement st = null;
		ResultSet set = null;
		List<ProgramSet> list = null;
		ProgramSet pro = null;
		try {
			st = conn.createStatement();
			String sql = "select p.problem_id, p.title, p.source, p.accepted, p.submit from problem p,contest_problem cp where cp.contest_id ="
					+ contestId + " and cp.problem_id = p.problem_id  order by problem_id limit " + startPos + "," + 10;
			st.executeQuery(sql);
			set = st.getResultSet();
			list = new ArrayList<ProgramSet>();
			while (set.next()) {
				pro = new ProgramSet(set);
				list.add(pro);
			}
		} catch (SQLException e) {
			throw new RuntimeException("ProgramDaoImpl--getProgramSet ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, set);
			return list;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean updateProblemDefunct(int problemId, String defunct) {
		boolean result = false;
		Connection conn = JdbcUtils_DBCP.getConnection();
		String sql = "update problem set defunct=? where problem_id=?";
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setObject(1, defunct);
			st.setObject(2, problemId);
			st.executeUpdate();
			result = true;
		} catch (SQLException e) {
			result = false;
			throw new RuntimeException("ProgramDaoImpl--insertIntoSourceUserCcode ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, null);
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public List<SolutionSet> getContestSolutionSet(int page, int contestId) {
		int startPos = (page - 1) * 20;
		Connection conn = JdbcUtils_DBCP.getConnection();
		Statement st = null;
		ResultSet set = null;
		SolutionSet solu = null;
		List<SolutionSet> solus = null;
		try {
			st = conn.createStatement();
			String sql = "select solution_id,user_id,problem_id,result,memory,time,language,code_length,in_date from solution where problem_id >0 and contest_id ="
					+ contestId + " Order by solution_id desc limit " + startPos + "," + 20;
			st.executeQuery(sql);
			set = st.getResultSet();
			solus = new ArrayList<SolutionSet>();
			while (set.next()) {
				solu = new SolutionSet(set);
				solus.add(solu);
			}
		} catch (SQLException e) {
			throw new RuntimeException("ProgramDaoImpl--getContestSolutionSet ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, set);
			return solus;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public int addContest(Contest contest) {
		int result = 0;
		Connection conn = JdbcUtils_DBCP.getConnection();
		String sql = "INSERT INTO contest(title,start_time,end_time,defunct,description,private,langmask,password) VALUES (?,?,?,?,?,?,?,?);";
		PreparedStatement st = null;
		ResultSet set = null;
		try {
			st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setObject(1, contest.getTitle());
			st.setObject(2, contest.getStart_time());
			st.setObject(3, contest.getEnd_time());
			st.setObject(4, contest.getDefunct());
			st.setObject(5, contest.getDescription());
			st.setObject(6, contest.getPrivate());
			st.setObject(7, contest.getLangmask());
			st.setObject(8, contest.getPassword());
			result = st.executeUpdate();
			set = st.getGeneratedKeys();
			while (set.next()) {
				result = set.getInt(1);
			}
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		} finally {
			JdbcUtils_DBCP.release(conn, st, null);
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean deleteProblemByProblemId(int problemId) {
		boolean result = false;
		Connection conn = JdbcUtils_DBCP.getConnection();
		String sql = "delete from problem where problem_id=?";
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setObject(1, problemId);
			st.executeUpdate();
			result = true;
		} catch (SQLException e) {
			result = false;
			throw new RuntimeException("ProgramDaoImpl--insertIntoSourceUserCcode ERROR!!");
		} finally {
			JdbcUtils_DBCP.release(conn, st, null);
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public int addContestJoiner(String[] userIds, int contestId) {
		Connection conn = JdbcUtils_DBCP.getConnection();
		String sql = "INSERT INTO privilege (user_id, rightstr) VALUES (?,?)";
		PreparedStatement st = null;
		int res = 0;
		try {
			// conn.setAutoCommit(false);
			st = conn.prepareStatement(sql);
			int length = userIds.length;
			for (int i = 0; i < length; i++) {
				st.setString(1, userIds[i]);
				st.setString(2, "c" + contestId); // c1001
													// 说明此人是竞赛或者是作业ID为1001的参与者
				// TODO: st.addBatch(sql); // 莫名报错
				// st.addBatch(sql);
				res = st.executeUpdate();
			}
			// st.executeBatch();
			// conn.commit(); //2,进行手动提交（commit）
			// conn.setAutoCommit(true);//3,提交完成后回复现场将Auto commit,还原为true,
		} catch (SQLException e) {
			// conn.rollback(); //4,当异常发生执行catch中SQLException时，记得要rollback(回滚)；
			// conn.setAutoCommit(true);
			res = 0;
			e.printStackTrace();
		} finally {
			JdbcUtils_DBCP.release(conn, st, null);
			return res;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public int addContestProblem(String[] problems, int contestId) {
		int result = 0;
		Connection conn = JdbcUtils_DBCP.getConnection();
		String sql = "INSERT INTO contest_problem(problem_id, contest_id, num) VALUES (?,?,?)";
		PreparedStatement st = null;
		try {
			conn.setAutoCommit(false);
			st = conn.prepareStatement(sql);
			int length = problems.length;
			for (int i = 0; i < length; i++) {
				st.setObject(1, problems[i]);
				st.setObject(2, contestId);
				st.setObject(3, i + 1);
				result = st.executeUpdate();
			}
			conn.commit();
		} catch (SQLException e) {
			result = 0;
			conn.rollback();
			conn.setAutoCommit(true);
			e.printStackTrace();
		} finally {
			JdbcUtils_DBCP.release(conn, st, null);
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public int updateContestPrivate(String contestId, String state) {
		int result = 0;
		Connection conn = JdbcUtils_DBCP.getConnection();
		String sql = "update contest set private=? WHERE contest_id=?";
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setObject(1, state);
			st.setObject(2, contestId);
			result = st.executeUpdate();
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		} finally {
			JdbcUtils_DBCP.release(conn, st, null);
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public int updateContestState(String contestId, String state) {
		int result = 0;
		Connection conn = JdbcUtils_DBCP.getConnection();
		String sql = "update contest set defunct=? WHERE contest_id=?";
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setObject(1, state);
			st.setObject(2, contestId);
			result = st.executeUpdate();
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		} finally {
			JdbcUtils_DBCP.release(conn, st, null);
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public int addContestCreator(String creatorId, int contesdId) {
		Connection conn = JdbcUtils_DBCP.getConnection();
		String sql = "INSERT INTO privilege (user_id, rightstr) VALUES (?,?)";
		PreparedStatement st = null;
		int res = 0;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, creatorId);
			st.setString(2, "m" + contesdId); // m1001 说明此人是竞赛或者是作业ID为1001的创建者
			res = st.executeUpdate();
		} catch (SQLException e) {
			res = 0;
			e.printStackTrace();
		} finally {
			JdbcUtils_DBCP.release(conn, st, null);
			return res;
		}
	}
}
