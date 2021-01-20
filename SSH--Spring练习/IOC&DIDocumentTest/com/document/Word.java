package com.document;

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
