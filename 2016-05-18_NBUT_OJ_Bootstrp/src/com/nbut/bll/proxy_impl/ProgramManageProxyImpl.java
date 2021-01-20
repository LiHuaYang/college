package com.nbut.bll.proxy_impl;

import java.util.List;
import com.nbut.bll.ProgramManage;
import com.nbut.entity.Contest;
import com.nbut.entity.ContestSet;
import com.nbut.entity.Program;
import com.nbut.entity.ProgramSet;
import com.nbut.entity.Solution;
import com.nbut.entity.SolutionSet;


/**
 * ProgramManage的权限代理类
 * 
 *
 * 作者：ariclee		时间：2016年6月14日下午8:40:34
 */
public class ProgramManageProxyImpl implements ProgramManage {
	
	// 可以代理任何实现ProgramManage接口的类
	private ProgramManage iPro = null;
	
	
	// 
	public ProgramManageProxyImpl (ProgramManage _pro) {
		this.iPro = _pro;
	}

	
	public Program getProgram(String problem_id) {
		return null;
	}

	@Override
	public List<ProgramSet> getProgramSet(int page, int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SolutionSet> getSolutionSet(int page) {
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContestSet> getContestSet(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean submitCode(Solution solution, String code) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SolutionSet> getSolutionSetByProblemId(int page, int problemId, int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addProblem(Program problem, int contestId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getSource(int solutionId) {
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
	public List<SolutionSet> getContestSolutionSet(int page, int contestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setProblemStatus(int problemId, String defunct) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProblemByProblemId(int problemId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addContest(Contest contest, String[] users, String[] problems, String creatorid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setContestState(String contestId, String key, String state) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
