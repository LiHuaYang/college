package com.annotation_document;

import org.springframework.stereotype.Component;

@Component("ExcelDocument")
public class Excel implements Document {

	@Override
	public void read() {
		System.out.println("Excle read");
	}

	@Override
	public void write() {
		System.out.println("Excle write");
	}

}
