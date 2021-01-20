package com.annotation_document;

import org.springframework.stereotype.Component;

@Component("WordDocument")
public class Word implements Document {

	@Override
	public void read() {
		System.out.println("Word read");
	}

	@Override
	public void write() {
		System.out.println("Word write");
	}
}
