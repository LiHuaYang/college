package com.Tool;

import java.io.File;
import java.io.IOException;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelHelper {
	
	private Workbook book;
	
	private Sheet sheet;
	
	
	public Workbook getBook() {
		return book;
	}


	public void setBook(Workbook book) {
		this.book = book;
	}


	public Sheet getSheet() {
		return sheet;
	}


	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}


	public boolean initExcleHelper(String Excelurl) throws JXLException, IOException {
	
		boolean flag = true;
		
		this.book = Workbook.getWorkbook(new File(Excelurl)); 
		
		return flag;
	}
	
}
