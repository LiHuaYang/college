package com.Bll;

import net.sf.json.JSONObject;
import com.Dao.DaoErollmentOrder;
import com.Entity.V2.EnrollmentOrder;
import com.Utils.DaoFactory;



public class CBllEnrollment {

	private static CBllEnrollment cBllFrame = new CBllEnrollment();
	DaoErollmentOrder ddao = null;
	
	
	private CBllEnrollment () {
		// /CompetitionRegistration_V2/src/com/Dao/Imp/DaoErollmentOrderImp.java
		ddao = DaoFactory.getInstance().createDao("com.Dao.Imp.DaoErollmentOrderImp", DaoErollmentOrder.class);
	}
	
	public static CBllEnrollment getInstance () {
		return cBllFrame;
	}
	
	public void addEnrollmentOrder(EnrollmentOrder enrollmentOrder) {
		// 1.
		
		// 2. 
		ddao.add(enrollmentOrder);
	}
	
	
	
	public JSONObject queryEnrollmentOrder (String userid) {
		return ddao.query(userid);
	}
}
