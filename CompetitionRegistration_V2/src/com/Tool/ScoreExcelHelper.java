package com.Tool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import com.EntityWeb.Enrollment;

/**
 * 读取成绩Excel
 * 
 * 备注：
 * 		构造函数初始化，成员变量
 * 
 * 格式：
 *  大赛名	                             身份证号	                      查询成绩时候的密码	学生成绩
 *	浙江省中小学生数学竞赛	111111111111111111	10001				123
 *	浙江省中小学生数学竞赛	111111111111111112	10002				124
 *	浙江省中小学生数学竞赛	111111111111111113	10003				125
 * 
 *
 */
public class ScoreExcelHelper {
	private Workbook book;
	private Sheet sheet;
	private List<Enrollment>  enrollments; // 所要转换的实体类
	private String excelPath; // Excel表格的路径和文件名
	
	
	public ScoreExcelHelper (String excelPath) {
		this.excelPath = excelPath;
		 enrollments = new ArrayList<Enrollment>();
	}
	
	public List<Enrollment> ExceltoEntity () {
		Cell cell1,cell2,cell3,cell4, cell5;
	    try { 
	    	int i = 1;
	        book = Workbook.getWorkbook(new File(this.excelPath)); //t.xls为要读取的excel文件名
	        sheet = book.getSheet(0); //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
	        cell1 = sheet.getCell(0,0); //获取左上角的单元格

	        while(true)
	        {
	        	Enrollment enrollment = new Enrollment();
	        	// 大赛名字
	            cell1=sheet.getCell(0,i);//（列，行）
	            enrollment.setCompetitionName(cell1.getContents());
//	            System.out.println(sheet.getCell(0,i));
	            
	            // 学生的身份证号码
	            cell2=sheet.getCell(1,i);
	            enrollment.setStudentIDNumber(cell2.getContents());
//	            System.out.println(sheet.getCell(1,i));
	            
	            // 学生查询成绩时的密码--EnrollmentPassword
	            cell3=sheet.getCell(2,i);
	            enrollment.setEnrollmentPassword(cell3.getContents());
//	            System.out.println(sheet.getCell(2,i));
	            
	            // 学生的成绩
	            cell4=sheet.getCell(3,i);
	            int grade = Integer.parseInt(cell4.getContents());
	            enrollment.setStudentscore(grade);
//	            System.out.println(sheet.getCell(3,i));
	            
	            
	            cell5=sheet.getCell(4,i);
	            enrollment.setStudentTicket(cell5.getContents());
//	            System.out.println(sheet.getCell(4,i));
	            
	            enrollments.add(enrollment);
	            
	            if("".equals(cell1.getContents())==true)    //如果读取的数据为空
	                return null;
//	            System.out.println(cell1.getContents()+"\t"+cell2.getContents()+"\t"+cell3.getContents()+"\t"+cell4.getContents()); 
	            i++;
	        }
	       
	    }
	    catch(Exception e)  { 
	    	
	    } finally {
	    	 book.close(); 
	    }
	    return enrollments;
	}
	
	
	public List<Enrollment> getEnrollments() {
		return enrollments;
	}
}
