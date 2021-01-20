package com.Tool.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test implements Runnable{

	public static void main(String[] args) {
		
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
//	    Calendar calendar = Calendar.getInstance();
//		System.out.println("start1----" + df.format(calendar.getTime()));
//		
//		System.out.println(DatabaseProperty.PASSWORD);
//		
//		System.out.println("end1----" + df.format(calendar.getTime()));
//		
//		System.out.println("start2----" + df.format(calendar.getTime()));
//		
//		System.out.println(Constant.DATABASEPASSWORD);
//		
//		System.out.println("end2----" + df.format(calendar.getTime()));

//	 try
//        {
//            new test().justTest();
//        }
//        catch(MyException e)
//        {
////            System.out.println(ex.getMessage());
//        	e.printStackTrace();
//        }
		
//		ThreadConnection a = new ThreadConnection();
		
//		
//		try {
//			long startTime = System.nanoTime(); 
//			Connection con = pool.getConnection();
//			System.out.println(System.nanoTime() - startTime);
//			long startTime1 = System.nanoTime(); 
//			Connection con1 = pool.getConnection();
//			System.out.println(System.nanoTime() - startTime1);
////			Connection con2 = pool.getConnection();
////			
//			pool.returnConnection(con);
////			pool.returnConnection(con1);
////			System.out.println("start2----" + df.format(calendar.getTime()));
//			long startTime2 = System.nanoTime(); 
//			con1 = pool.getConnection();
//			System.out.println(System.nanoTime() - startTime2);
////			System.out.println("end2----" + df.format(calendar.getTime()));
////			pool.returnConnection(con2);
////			con = pool.getConnection();
////			con2 = pool.getConnection();
//		} catch (MyException e) {
//			e.printStackTrace();
//		}
		
		test test1 = new test();
		for(int i=0; i<100; i++){
			Thread a = new Thread(test1, "线程"+i);
			a.start();
		}
//		System.out.println(new DatabaseProperty().getpath());
	}
	
	ConnectionPool pool = ConnectionPool.getIntense();

	@Override
	public void run() {
		String sql = "select * from user where UserId = 62";
		ResultSet rs = null;
		PreparedStatement statement = null;
		Connection conn = null;
			
		try {
			conn = pool.getConnection();
			statement = conn.prepareStatement(sql);
			rs = statement.executeQuery(sql);
			
			while(rs.next()){
				System.out.println(Thread.currentThread().getName() + 
						"--->" + "id:" + rs.getInt("UserId")+ "用户名" + rs.getString("UserName"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			pool.returnConnection(conn,statement,rs);
			pool.returnConnection(conn);
			pool.returnConnection(conn, statement);
		}
	}

//	public void justTest() throws MyException
//    {
//         int i = 0;
//        
//         if(i == 0)
//             throw new MyException("i为0!");
//    }
}
