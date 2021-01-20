package com.document;

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
