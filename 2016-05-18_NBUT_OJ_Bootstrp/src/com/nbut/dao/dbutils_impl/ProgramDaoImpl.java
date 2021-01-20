package com.nbut.dao.dbutils_impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import com.nbut.dao.ProgramDao;
import com.nbut.entity.Contest;
import com.nbut.entity.ContestSet;
import com.nbut.entity.Program;
import com.nbut.entity.ProgramSet;
import com.nbut.entity.Solution;
import com.nbut.entity.SolutionSet;
import com.nbut.utils.MyDBUtils;

/**
 * 用DBUtils实现ProgramDao接口
 *
 * 作者：ariclee 时间：2016年6月11日下午10:59:23
 */
public class ProgramDaoImpl implements ProgramDao {

	private static QueryRunner queruRunner = new QueryRunner(MyDBUtils.getDataSource());// 将数据源作为参数传入框架，框架自动管理连接（获取和关闭）

	@SuppressWarnings({ "finally", "deprecation" })
	@Override
	public Program getAModel(String id) {
		Program pro = null;
		try {
			String sql = "select * from problem where problem_id=? LIMIT 1";
			Object paras[] = { id };
			pro = queruRunner.query(sql, paras, new BeanHandler<Program>(Program.class));

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			return pro;
		}
	}

	@SuppressWarnings({ "finally", "deprecation" })
	@Override
	public List<ProgramSet> getProgramSet_admin(int page) {
		List<ProgramSet> list = null;
		try {
			int startPos = (page - 1) * 10;
			String sql = "select problem_id, title, source, accepted, submit,in_date,defunct from problem order by problem_id limit ?,?";
			Object paras[] = { startPos, 50 };
			list = queruRunner.query(sql, paras, new BeanListHandler<ProgramSet>(ProgramSet.class));

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			return list;
		}
	}

	@SuppressWarnings({ "finally", "deprecation" })
	@Override
	public List<ProgramSet> getProgramSet_user(int page) {
		List<ProgramSet> list = null;
		try {
			int startPos = (page - 1) * 10;
			String sql = "select problem_id, title, source, accepted, submit,in_date,defunct from problem where problem_id not in (select problem_id from contest_problem) and defunct='N' order by problem_id limit ?,?";
			Object paras[] = { startPos, 10 };
			list = queruRunner.query(sql, paras, new BeanListHandler<ProgramSet>(ProgramSet.class));

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			return list;
		}
	}

	@SuppressWarnings({ "finally", "deprecation" })
	@Override
	public List<SolutionSet> getSolutionSet(int page) {
		List<SolutionSet> list = null;
		try {
			int startPos = (page - 1) * 10;
			String sql = "select solution_id,user_id,problem_id,result,memory,time,language,code_length,in_date from solution where problem_id >0 and contest_id is null Order by solution_id desc limit ?,?";
			Object paras[] = { startPos, 20 };
			list = queruRunner.query(sql, paras, new BeanListHandler<SolutionSet>(SolutionSet.class));

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			return list;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean insertIntoSourceCcode(String code, int solutionId) {
		int res = 0;
		try {
			String sql = "insert into source_code(solution_id, source) values(?,?)";
			Object paras[] = { solutionId, code };
			res = queruRunner.update(MyDBUtils.getConnection(), sql, paras);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			return res > 0 ? true : false;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean insertIntoSourceUserCcode(String code, int solutionId) {
		int res = 0;
		try {
			String sql = "insert into source_code_user(solution_id, source) values(?, ?)";
			Object paras[] = { solutionId, code };
			res = queruRunner.update(MyDBUtils.getConnection(), sql, paras);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			return res > 0 ? true : false;
		}
	}

	@Override
	public int insertIntoSolution(Solution solution) {

		return 0;
	}

	@Override
	public int[] selectContestByproblemId(int problemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SolutionSet> getSolutionSetByProblemId(int page, int problemId, int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertintoProblem(Program problem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insertintocontest_problem(int contestId, int problemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String selectCode(int solutionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contest getContest(int contestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProgramSet> getContestProgramSet(int page, int contestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContestSet> getContestSet_user() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContestSet> getContestSet_admin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateProblemDefunct(int problemId, String defunct) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SolutionSet> getContestSolutionSet(int page, int contestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("finally")
	@Override
	public int addContest(Contest contest) {
		int res = 0;
		try {
			String sql = "INSERT INTO contest(title,start_time,end_time,defunct,description,private,langmask,password) VALUES (?,?,?,?,?,?,?,?)";
			Object paras[] = { contest.getTitle(), contest.getStart_time(), contest.getEnd_time(), contest.getDefunct(),
					contest.getDescription(), contest.getPrivate(), contest.getLangmask(), contest.getPassword() };
			res = queruRunner.update(MyDBUtils.getConnection(), sql, paras);

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			return res;
		}
	}

	@Test
	public void test4() {
		Contest contest = new Contest("2","2016-05-27 16:00:00","2016-05-27 16:00:00","N","dshfgd",1,2,"123456");
		System.out.println(this.addContest(contest));
	}

	@Override
	public boolean deleteProblemByProblemId(int problemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addContestJoiner(String[] userIds, int contestId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addContestCreator(String creatorId, int contesid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addContestProblem(String[] problems, int contestId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateContestPrivate(String contestId, String state) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateContestState(String contestId, String state) {
		// TODO Auto-generated method stub
		return 0;
	}

}
