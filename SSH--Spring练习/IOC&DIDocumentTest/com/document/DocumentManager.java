package com.document;

public class DocumentManager {

	
	private Document doc;
	
	public DocumentManager(Document _doc) {
		this.doc = _doc;
	}
	
	public void read() {
		this.doc.read();
	}
	
	public void write() {
		this.doc.write();
	}
}
