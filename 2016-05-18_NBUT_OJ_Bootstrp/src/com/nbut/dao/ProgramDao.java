package com.nbut.dao;

import java.util.List;
import com.nbut.entity.Contest;
import com.nbut.entity.ContestSet;
import com.nbut.entity.Program;
import com.nbut.entity.ProgramSet;
import com.nbut.entity.Solution;
import com.nbut.entity.SolutionSet;

public interface ProgramDao {

	/**
	 * 函数名称：getAModel
	 * 功能描述：
	 * 参数说明：
	 * 返回值：Program
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月20日上午9:52:29
	 */
	Program getAModel(String id);

	/**
	 * 函数名称：getSet
	 * 功能描述：
	 * 参数说明：
	 * 返回值：List<ProgramSet>
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月20日下午3:37:37
	 */
	public List<ProgramSet> getProgramSet_admin(int page);
	
	
	/**
	 * 函数名称：getProgramSet_admin
	 * 功能描述：
	 * 参数说明：
	 * 返回值：List<ProgramSet>
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月9日下午3:46:55
	 */
	public List<ProgramSet> getProgramSet_user(int page);

	/**
	 * 函数名称：getAllSolution
	 * 功能描述：得到所有的运行结果
	 * 参数说明：
	 * 返回值：List<Solution>
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年5月20日下午6:47:48
	 */
	public List<SolutionSet> getSolutionSet(int page);
	
	/**
	 * 函数名称：getContestSet
	 * 功能描述：
	 * 参数说明：
	 * 返回值：List<ContestSet>
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年5月22日下午4:55:16
	 */
	
	/**
	 * 函数名称：insertIntoSourceCcode
	 * 功能描述：往source_code表中插入数据
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年5月22日下午2:47:36
	 */
	boolean insertIntoSourceCcode(String code, int solutionId);

	/**
	 * 函数名称：insertIntoSourceUserCcode
	 * 功能描述：往source_code_user表中插入数据
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年5月22日下午2:57:37
	 */
	boolean insertIntoSourceUserCcode(String code, int solutionId);

	
	/**
	 * 函数名称：insertIntoSolution
	 * 功能描述：往solution表中插入数据
	 * 参数说明：
	 * 返回值：int
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年5月22日下午3:22:42
	 */
	int insertIntoSolution(Solution solution); 
	
	/**
	 * 函数名称：selectContestByproblemId
	 * 功能描述：通过problemId选出contestId和num
	 * 参数说明：
	 * 返回值：int[]
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年5月22日下午3:51:50
	 */
	int[] selectContestByproblemId(int problemId);

	/**
	 * 
	 * 函数名称：getSolutionSetByProblemId
	 * 功能描述：通过问题编号和类型选出solution
	 * 参数说明：
	 * 返回值：List<SolutionSet>
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年5月23日下午7:56:12
	 */
	List<SolutionSet> getSolutionSetByProblemId(int page, int problemId, int type) ;
	
	/**
	 * 函数名称：insertintoProblem
	 * 功能描述：
	 * 参数说明：
	 * 返回值：int
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年5月25日下午7:54:55
	 */
	int insertintoProblem(Program problem);

	/**
	 * 函数名称：insertintocontest_problem
	 * 功能描述：
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年5月25日下午9:19:42
	 */
	boolean insertintocontest_problem(int contestId, int problemId);

	/**
	 * 函数名称：selectCode
	 * 功能描述：
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年5月26日下午8:37:56
	 */
	String selectCode(int solutionId);
	/**
	 * 函数名称：getContest
	 * 功能描述：
	 * 参数说明：
	 * 返回值：Contest
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年5月27日下午8:47:18
	 */
	public Contest getContest ( int contestId );
	
	/**
	 * 函数名称：getContestProgramSet
	 * 功能描述：
	 * 参数说明：
	 * 返回值：List<ProgramSet>
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年5月28日下午8:49:11
	 */
	public List<ProgramSet> getContestProgramSet(int page, int contestId);
	
	/**
	 * 函数名称：getContestSet
	 * 功能描述：
	 * 参数说明：
	 * 返回值：List<ContestSet>
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月30日上午11:44:50
	 */
	public List<ContestSet> getContestSet_user();
	
	
	/**
	 * 函数名称：getContestSet
	 * 功能描述：
	 * 参数说明：
	 * 返回值：List<ContestSet>
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年5月30日上午11:44:50
	 */
	public List<ContestSet> getContestSet_admin();
	
	/**
	 * 
	 * 函数名称：updateProblemDefunct
	 * 功能描述：修改problem表中的defunct
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年5月31日下午8:49:50
	 */
	public boolean updateProblemDefunct(int problemId,String defunct);
	
	
	/**
	 * 
	 * 函数名称：getContestSolutionSet
	 * 功能描述：
	 * 参数说明：
	 * 返回值：List<SolutionSet>
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年5月31日下午8:36:40
	 */
	public List<SolutionSet> getContestSolutionSet(int page, int contestId);
	
	/**
	 * 
	 * 函数名称：addContest
	 * 功能描述：
	 * 参数说明：
	 * 返回值：int
	 * 备注：
	 * 
	 * 作者：lujinye		时间：2016年6月1日下午9:28:09
	 */
	public int addContest(Contest contest);
	
	/**
	 * 
	 * 函数名称：deleteProblemByProblemId
	 * 功能描述：删除问题
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年5月31日下午9:44:08
	 */
	public boolean deleteProblemByProblemId(int problemId);
	
	
	/**
	 * 函数名称：addContestJoiner
	 * 功能描述：增加竞赛、作业的参与者（多个）
	 * 参数说明：
	 * 返回值：int
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月2日下午2:23:36
	 */
	public int addContestJoiner(String[] userIds, int contestId);
	
	
	/**
	 * 函数名称：addContestCreator
	 * 功能描述：添加竞赛创建者
	 * 参数说明：
	 * 返回值：int
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月11日下午3:05:26
	 */
	public int addContestCreator(String creatorId, int contesid);
	
	/**
	 * 函数名称：addContestProblem
	 * 功能描述：增加竞赛题目
	 * 参数说明：
	 * 返回值：int
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月2日下午4:48:47
	 */
	public int addContestProblem(String[] problems, int contestId);
	
	
	/**
	 * 函数名称：updateContestPrivate
	 * 功能描述：
	 * 参数说明：
	 * 返回值：int
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月8日下午10:21:59
	 */
	int updateContestPrivate(String contestId, String state);
	
	/**
	 * 函数名称：updateContestState
	 * 功能描述：
	 * 参数说明：
	 * 返回值：int
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年6月8日下午10:22:02
	 */
	int updateContestState(String contestId, String state);
}