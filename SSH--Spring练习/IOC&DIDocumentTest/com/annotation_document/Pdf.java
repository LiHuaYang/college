package com.annotation_document;

import org.springframework.stereotype.Component;


@Component("PdfDocument")
// <bean id="PdfDocument" class="com.annotation_document.Pdf"></bean>
public class Pdf implements Document {

	@Override
	public void read() {
		System.out.println("Pdf read");
	}

	@Override
	public void write() {
		System.out.println("Pdf wirte");
	}

}
