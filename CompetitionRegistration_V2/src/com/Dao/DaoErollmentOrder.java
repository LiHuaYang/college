package com.Dao;

import net.sf.json.JSONObject;
import com.Entity.V2.EnrollmentOrder;




public interface DaoErollmentOrder {

	public abstract void add(EnrollmentOrder enrollmentOrder);
	
	public abstract JSONObject query (String userid);
	
}