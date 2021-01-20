package com.ServletWeb;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import net.sf.json.JSONObject;

import com.Dao.DaoCompetition;

public class InportScore extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			
//			JSONObject jsonObject = JSONObject.fromObject(new String(request
//					.getParameter("json").getBytes("ISO-8859-1"), "utf-8"));
			JSONObject jsonObject = JSONObject.fromObject(request.getParameter("json"));
			
			String Path = jsonObject.getString("Path");
			String StudentScore = null;
			String StudentName = null;
			String StudentIDNumber = null;
			String ContestSubject = jsonObject.getString("ContestSubject");
			String CompetitionName = jsonObject.getString("CompetitionName");
			String a[] = null;
			
			
			
			jxl.Workbook readwb = null;
			try
			{
				// 构建Workbook对象, 只读Workbook对象
				// 直接从本地文件创建Workbook
				InputStream instream = new FileInputStream(Path);

				readwb = Workbook.getWorkbook(instream);

				// Sheet的下标是从0开始
				// 获取第一张Sheet表
				Sheet readsheet = readwb.getSheet(0);
				// 获取Sheet表中所包含的总列数
				int rsColumns = readsheet.getColumns();
				// 获取Sheet表中所包含的总行数
				int rsRows = readsheet.getRows();
				
				System.out.println("Excel的总行数" + rsRows);
				System.out.println("Excel的总列数" + rsColumns);
				
				// 按照单元格依次读取
				for (int i = 2; i < rsRows; i++) {
					for (int j = 0; j < rsColumns; j++) {
						Cell cell = readsheet.getCell(j, i);
						a[j] = cell.getContents();
						System.out.print(cell.getContents() + " ");
					}
					StudentName = a[0];
					StudentIDNumber = a[5];
					StudentScore = a[3];
					DaoCompetition daocompetition = new DaoCompetition();
					daocompetition.InportScore(StudentScore, StudentName, StudentIDNumber, ContestSubject, CompetitionName);
					System.out.println();
				}
				
				// 利用已经创建的Excel工作薄,创建新的可写入的Excel工作薄
//				jxl.write.WritableWorkbook wwb = Workbook.createWorkbook(new File(
//				"F:/红楼人物1.xls"), readwb);
//				// 读取第一张工作表
//				jxl.write.WritableSheet ws = wwb.getSheet(0);
//				// 获得第一个单元格对象
//				jxl.write.WritableCell wc = ws.getWritableCell(0, 0);
//				// 判断单元格的类型, 做出相应的转化
//				if (wc.getType() == CellType.LABEL)
//				{
//					Label l = (Label) wc;
//					l.setString("新姓名");
//				}
//				// 写入Excel对象
//				wwb.write();
//				wwb.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				readwb.close();
			}
			
			
			
			
			//System.out.println(news.toString());
			//System.out.println(newstitle+newscontent+newspic);
			
			PrintWriter out = response.getWriter();
			
			out.flush();
			out.close();
	}
}
