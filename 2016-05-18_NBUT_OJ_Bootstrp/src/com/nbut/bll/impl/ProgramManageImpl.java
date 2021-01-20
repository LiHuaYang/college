package com.nbut.bll.impl;

import java.util.List;
import com.factory.DaoFactory;
import com.nbut.bll.ProgramManage;
import com.nbut.dao.ProgramDao;
import com.nbut.entity.Contest;
import com.nbut.entity.ContestSet;
import com.nbut.entity.Program;
import com.nbut.entity.ProgramSet;
import com.nbut.entity.Solution;
import com.nbut.entity.SolutionSet;
import com.nbut.utils.TransactionUtil;

public class ProgramManageImpl implements ProgramManage {

	private ProgramDao pdao = DaoFactory.getInstance().create("com.nbut.dao.impl.ProgramDaoImpl", ProgramDao.class);
	protected static ProgramManageImpl pImpl = new ProgramManageImpl();

	protected ProgramManageImpl() {
	}

	public static ProgramManageImpl getInstance() {
		return pImpl;
	}

	@Override
	public Program getProgram(String problem_id) {
		return pdao.getAModel(problem_id);
	}

	@Override
	public List<ProgramSet> getProgramSet(int page, int type) {
		if (type == 1) { // 如果是前台用户
			return pdao.getProgramSet_user(page);
		} else { // 如果是管理员
			return pdao.getProgramSet_admin(page);
		}
	}

	@Override
	public List<SolutionSet> getSolutionSet(int page) {
		return pdao.getSolutionSet(page);
	}

	@Override
	public boolean submitCode(Solution solution, String code) {

		boolean result = false;
		int[] aboutContest = pdao.selectContestByproblemId(solution.getProblem_id());
		if (aboutContest[0] != 0) {
			solution.setNum(aboutContest[1]);
			solution.setContest_id(aboutContest[0]);
		} else {
			solution.setNum(-1);
		}
		int solutionId = pdao.insertIntoSolution(solution);

		if (solutionId != 0) {
			pdao.insertIntoSourceCcode(code, solutionId);
			pdao.insertIntoSourceUserCcode(code, solutionId);
			result = true;
		}
		return result;
	}

	@Override
	public List<ContestSet> getContestSet(String type) {
		if (type.equals("user")) {
			return pdao.getContestSet_user();
		} else if (type.equals("admin")) {
			return pdao.getContestSet_admin();
		} else {
			return null;
		}
	}

	@Override
	public List<SolutionSet> getSolutionSetByProblemId(int page, int problemId, int type) {
		return pdao.getSolutionSetByProblemId(page, problemId, type);
	}

	@Override
	public boolean addProblem(Program problem, int contestId) {
		boolean result = false;
		TransactionUtil.startTransaction();
		int problemId = pdao.insertintoProblem(problem);
		if (contestId != 0) {
			result = pdao.insertintocontest_problem(contestId, problemId);
		}
		return result;
		// }
	}

	@Override
	public String getSource(int solutionId) {
		return pdao.selectCode(solutionId);
	}

	@Override
	public Contest getContest(int contestId) {
		return pdao.getContest(contestId);
	}

	@Override
	public List<ProgramSet> getContestProgramSet(int page, int contestId) {
		return pdao.getContestProgramSet(page, contestId);
	}

	@Override
	public List<SolutionSet> getContestSolutionSet(int page, int contestId) {
		return pdao.getContestSolutionSet(page, contestId);
	}

	@Override
	public boolean setProblemStatus(int problemId, String defunct) {
		return pdao.updateProblemDefunct(problemId, defunct);
	}

	@Override
	public int addContest(Contest contest, String[] users, String[] problems, String creatorid) {
		// 1. 添加竞赛的基本信息
		int contestId = pdao.addContest(contest);
		// 2. 添加参与人员
		int res2 = pdao.addContestJoiner(users, contestId);
		// 3. 添加竞赛的问题
		int res3 = pdao.addContestProblem(problems, contestId);
		// 4. 添加竞赛创建人员
		int res4 = pdao.addContestCreator(creatorid, contestId);

		if (contestId != 0 & res2 != 0 & res3 != 0 & res4 != 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public boolean deleteProblemByProblemId(int problemId) {
		return pdao.deleteProblemByProblemId(problemId);
	}

	@Override
	public int setContestState(String contestId, String key, String state) {
		int res = 0;
		if (key.equals("p")) { //
			res = pdao.updateContestPrivate(contestId, state);
		} else { //
			res = pdao.updateContestState(contestId, state);
		}
		return res;
	}
}
