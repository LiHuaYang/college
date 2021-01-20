package com.document;

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
