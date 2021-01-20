package com.nbut.bll;

import java.util.List;
import com.nbut.entity.Contest;
import com.nbut.entity.ContestSet;
import com.nbut.entity.Program;
import com.nbut.entity.ProgramSet;
import com.nbut.entity.Solution;
import com.nbut.entity.SolutionSet;

public interface ProgramManage {

	/**
	 * 函数名称：getProgram
	 * 功能描述：
	 * 参数说明：
	 * 返回值：Program
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月20日上午10:55:22
	 */
	Program getProgram(String problem_id);
	
	/**
	 * 函数名称：getProgramSet
	 * 功能描述：
	 * 参数说明：
	 * 返回值：Program
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月20日下午3:38:35
	 */
	List<ProgramSet> getProgramSet(int page, int type);

	/**
	 * 函数名称：getAllSolution
	 * 功能描述：得到所有的运行结果
	 * 参数说明：
	 * 返回值：List<Solution>
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年5月20日下午7:20:30
	 */
	List<SolutionSet> getSolutionSet(int page);
	
	/**
	 * 函数名称：getContestSet
	 * 功能描述：获取竞赛列表
	 * 参数说明：参数表明身份，管理员或者是普通用户
	 * 返回值：List<ContestSet>
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年5月22日下午4:52:54
	 */
	List<ContestSet> getContestSet(String type);
	/**
	 * 函数名称：submitCode
	 * 功能描述：提交代码
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年5月22日下午4:06:27
	 */
	boolean submitCode(Solution solution,String code);

	/**
	 * 函数名称：getSolutionSetByProblemId
	 * 功能描述：
	 * 参数说明：
	 * 返回值：List<SolutionSet>
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年5月23日下午8:04:29
	 */
	List<SolutionSet> getSolutionSetByProblemId(int page, int problemId, int type);

	/**
	 * 函数名称：addProblem
	 * 功能描述：
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年5月25日下午8:33:09
	 */
	boolean addProblem(Program problem,int contestId);

	/**
	 * 函数名称：getSource
	 * 功能描述：
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年5月26日下午8:40:05
	 */
	String getSource(int solutionId);
	
	/**
	 * 函数名称：getContest
	 * 功能描述：
	 * 参数说明：
	 * 返回值：Contest
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年5月27日下午8:45:10
	 */
	Contest getContest(int contestId);
	
	/**
	 * 函数名称：getContestProgramSet
	 * 功能描述：
	 * 参数说明：
	 * 返回值：List<ProgramSet>
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年5月28日下午8:47:40
	 */
	List<ProgramSet> getContestProgramSet(int page,int contestId);
	/**
	 * 
	 * 函数名称：getContestSolutionSet
	 * 功能描述：
	 * 参数说明：
	 * 返回值：List<SolutionSet>
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年5月31日下午8:35:29
	 */
	List<SolutionSet> getContestSolutionSet(int page , int contestId);

	/**
	 * 
	 * 函数名称：setProblemStatus
	 * 功能描述：修改问题状态
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年5月31日下午9:17:15
	 */
	boolean setProblemStatus(int problemId, String defunct);

	/**
	 * 
	 * 函数名称：deleteProblemByProblemId
	 * 功能描述：删除问题
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年5月31日下午9:48:55
	 */
	boolean deleteProblemByProblemId(int problemId);
	
	/**
	 * 
	 * 函数名称：addContest
	 * 功能描述：
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年6月1日下午9:25:56
	 */
	int addContest(Contest contest, String[] users, String[] problems, String creatorid);
	
	
	
	/**
	 * 函数名称：setContestState
	 * 功能描述：
	 * 参数说明：
	 * 返回值：int
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月8日下午9:34:55
	 */
	int setContestState(String contestId, String key, String state);

}