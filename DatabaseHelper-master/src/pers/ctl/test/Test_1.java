package pers.ctl.test;

import pers.ctl.DBHelper;
import pers.ctl.Parameter;
import pers.ctl.ParameterType;

public class Test_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBHelper helper = DBHelper.newInstance();
		// String sql = "insert into student(name)values(?)";
		// HashMap<Integer, Object> parameters = new HashMap<Integer, Object>();
		// parameters.put(1, "周七");
		// helper.excuteSQL(sql,parameters);

		// String sql = "select * from student";
		//
		// ArrayList<Object[]> list = helper.query(sql);
		// if (list != null) {
		// for (int i = 0; i < list.size(); i++) {
		// Object[] objs = list.get(i);
		// for(int j = 0;j<objs.length;j++)
		// {
		// System.err.println(objs[j].toString());
		// }
		// }
		// }

		// String[] sqls = new
		// String[]{"insert into student(name)values('吴十') ","insert into student(name)values('孙十一')"};
		// System.err.println(helper.doTransaction(sqls));
		// String sql = "call demoIO(?,?)";
		// Object[] excutes = helper.callProcedure(sql, new Parameter[] {
		// new Parameter(1, ParameterType.Integer),
		// new Parameter(ParameterType.String) });
		// if (excutes != null) {
		// System.out.println("执行成功...");
		// for (int i = 0; i < excutes.length; i++) {
		// System.out.println(excutes[i].toString());
		// }
		// } else {
		// System.err.println("执行失败...");
		// }
		
		// String sql = "insert into student(name)values(?)";
		// String key = helper.insertReturnKey(sql,new Parameter[] { new
		// Parameter('冯', ParameterType.String) });
		// if (key != null) {
		// System.out.println("插入成功...Key:" + key);
		// } else {
		// System.err.println("插入失败...");
		// }
		
		// String sql = "select count(1) from student";
		// Object result = helper.querySingle(sql);
		//
		// if (result != null) {
		// System.out.println("查询成功...查询值为:" + result.toString());
		// } else {
		// System.err.println("查询失败...");
		// }
		
		String sql = "select name from student where _id=?";
		Object result = helper.querySingle(sql,new Parameter[]{
				new Parameter(3, ParameterType.Integer)
		});

		if (result != null) {
			System.out.println("查询成功...查询值为:" + result.toString());
		} else {
			System.err.println("查询失败...");
		}
	}
	

}
