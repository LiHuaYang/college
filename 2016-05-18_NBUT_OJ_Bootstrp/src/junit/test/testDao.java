package junit.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.factory.BllFactory;
import com.nbut.bll.ProgramManage;
import com.nbut.bll.impl.ProgramManageImpl;
import com.nbut.bll.impl.UserManageImpl;
import com.nbut.bll.proxy_impl.ProgramManageProxyImpl;
import com.nbut.dao.impl.ProgramDaoImpl;
import com.nbut.dao.impl.UserDaoImpl;
import com.nbut.entity.Contest;
import com.nbut.entity.ContestSet;
import com.nbut.entity.Program;
import com.nbut.entity.ProgramSet;
import com.nbut.entity.Solution;
import com.nbut.entity.SolutionSet;
import com.nbut.entity.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class testDao {

	@Test
	public void testgetAModel () {
		Program pro = new ProgramDaoImpl().getAModel("1000");
		System.out.println(pro.toString());
	}
	
	@Test
	public void testgetProgramSet_admin () {
		List<ProgramSet> pp	= new ProgramDaoImpl().getProgramSet_admin(1);
		JSONArray arr = JSONArray.fromObject(pp);
		System.out.println(pp);
	}
	
	
	@Test
	public void testgetProgramSet_user () {
		List<ProgramSet> pp	= new ProgramDaoImpl().getProgramSet_user(1);
		System.out.println(pp);
	}
	
	
	
	
	@Test
	public void testgetAllSolution()
	{
		try {
			int page=1;
			List<SolutionSet> solus = new ProgramDaoImpl().getSolutionSet(page);
			JSONArray jsonArray = new JSONArray();
			for(int i =0;i<solus.size();i++) {
				JSONObject jsonObject = new JSONObject();
				jsonObject = solus.get(i).toJson(0);
				jsonArray.add(jsonObject);
			}
			System.out.println(jsonArray);
		} catch (Exception e) {
		}
	}
	
	@Test
	public void testInsertIntoSourceCode() {
		boolean result;
		result = new ProgramDaoImpl().insertIntoSourceCcode("fdsf", 2000);
		System.out.println(result);
	}
	
	
	@Test
	public void testSelectcontest() {
		int[] result = new int[2];
		result = new ProgramDaoImpl().selectContestByproblemId(1);
		System.out.println(result[0]);
		System.out.println(result[1]);
		
	}
	
	@Test
	public void test1 () {
		String data = "administrator,c1000,m1001,c1001,c1002";
		String [] privileges = data.split(",");
		
		String[] arr = new String[] {"1", "2"};
		List list = Arrays.asList(privileges);		
		
		for (String name : privileges) {
			System.out.println(name);
		}
		
		System.out.println(list);
		
	}
	
	
	@Test
	public void testSubmit() {
		Solution solution = new Solution(10, "123412432532", 1, "2013-8-8", "127.9.9", 1);
		boolean result = BllFactory.getInstance().getProgramManage().submitCode(solution, "shibushissha");
		System.out.println(result);
	}
	@Test
	public void testgetsolutionbyproblemId() {
		List<SolutionSet> solus = BllFactory.getInstance().getProgramManage().getSolutionSetByProblemId(1, 1000, 2);
		System.out.println(solus);
	}
	
	@Test
	public void testgetuserbyuserid(){
			try {
			String UserId="111";
			User user = new UserDaoImpl().getUserByUserId(UserId);
			System.out.println(user);
			} catch (Exception e) {
		}
	}
	
	@Test
	public void testgetAllPrivilege(){
			try {
			JSONArray array = new UserDaoImpl().getAllPrivilege();
			System.out.println(array);
			} catch (Exception e) {
		}
	}
	@Test
	public void test21() {
		Program problem = new Program(0, "你好", "sfsdfdsf", "fdsgfsd", "dsfgsg", "fgdsgsdf", "gdhdf", "1", "fgsdfgdfs", "来自", "2013-8-9", 1, 1, "N", 0, 0, "0");
		boolean result = BllFactory.getInstance().getProgramManage().addProblem(problem,1000);
		System.out.println(result);
	}
	
	@Test
	public void testaddPrivilege() {
		boolean result = new UserDaoImpl().addPrivilege("13401010407", "problem_editor");
		System.out.println(result);
	}
	
	@Test
	public void test1234() {
		 BllFactory.getInstance().getProgramManage().getSource(1077);
	}
	@Test
	public void getcontest() {
		int contestId = 1000;
		Contest contest = new ProgramDaoImpl().getContest(contestId);
		JSONObject jsonObject = new JSONObject();
		jsonObject = contest.toJson();
		System.out.println("testDao--contest--" + jsonObject);
	}
	
	
	@Test
	public void testgetContestproblemSet () {
		List<ProgramSet> list = new ProgramDaoImpl().getContestProgramSet(1,1001);
		System.out.println(list);
		JSONArray jsonArray = new JSONArray();
		for(int i =0;i<list.size();i++) {
			JSONObject jsonObject = new JSONObject();
			jsonObject = list.get(i).toJson(1);
			jsonArray.add(jsonObject);
		}
		System.out.println(jsonArray);
	}
	

	@Test
	public void testgetContestSolution()
	{
		try {
			int page=1;
			int contestId=1001;
			List<SolutionSet> solus = new ProgramDaoImpl().getContestSolutionSet(page,contestId);
			JSONArray jsonArray = new JSONArray();
			for(int i =0;i<solus.size();i++) {
				JSONObject jsonObject = new JSONObject();
				jsonObject = solus.get(i).toJson(0);
				jsonArray.add(jsonObject);
			}
			System.out.println(jsonArray);
		} catch (Exception e) {
		}
	}
	@Test
	public void testDelPri () {
		boolean ff = new UserDaoImpl().delUserPrivilege("777", "contest_creator");
	}
	
	@Test
	public void testsetProblemDefunct () {
		boolean list = new ProgramDaoImpl().updateProblemDefunct(1000, "Y");
		System.out.println(list);
	}
	
	@Test
	public void testaddContest () {
		Contest contest = new Contest("2","2016-05-27 16:00:00","2016-05-27 16:00:00","N","dshfgd",1,2,"123456");
		int result = new ProgramDaoImpl().addContest(contest);
		System.out.println(result);
	}
	
	@Test
	public void testaddContest1 () {
		String [] userids = {"13401010401", "13401010402", "13401010403"};
		
		for (int i=0; i<userids.length; i++) {
			System.out.println(userids[i]);
		}
		
		int result = new ProgramDaoImpl().addContestJoiner(userids, 1001);
		System.out.println(result);
	}
	
	@Test
	public void testupdateContestPrivate() {
		
		int result = new ProgramDaoImpl().updateContestPrivate("1000", "2");
	}
	
	@Test
	public void testupdateContestState() {
		
		int result = new ProgramDaoImpl().updateContestState("1000", "Y");
	}
	
	@Test
	public void testgetUserPrivilege2() {
		System.out.println(new UserDaoImpl().getUserPrivilege("13401010407"));
	}
	
	@Test
	public void test2() {
		
		List<SolutionSet> list = BllFactory.getInstance().getProgramManage().getSolutionSet(1);
		
		for (SolutionSet set : list) {
			System.out.println(set.getPass_rate());
		}
		
	}
	
	
	
}
