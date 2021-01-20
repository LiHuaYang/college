package com.annotation_document;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;


@Component("docManager")
public class DocumentManager {

	
	/**
	 * ��set����ע��
	 * <bean id="ExcelDocument" class="com.annotation_document.Excel" />
	 * <bean id="teacher" class="com.di_set.Teacher">
	 * 		<property name="doc" >
	 *			<ref bean="ExcelDocument" />
	 *		</property>
	 *	</bean>
	 *
	 * �ù��캯��ע��
	 * 
	 */ 
	@Resource(name="PdfDocument")
	private Document doc;
	
	public void read() {
		this.doc.read();
	}
	
	public void write() {
		this.doc.write();
	}
}
