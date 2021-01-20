package com.RunServlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import com.Bll.BllFame;
import com.Bll.IBllFrame;

public class RunActivityModel implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		IBllFrame bllFrame=new BllFame();
		bllFrame.getDateActivityModel();

	}
}
