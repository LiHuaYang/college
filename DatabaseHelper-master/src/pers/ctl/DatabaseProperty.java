package pers.ctl;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

class DatabaseProperty {

	private static String configFilePath = "src\\config.xml";
	// private static String configFilePath = "config.xml";
	
	private static String KEY_ROOT = "config";
	public static String DRIVER = null;
	private static String KEY_DRIVER = "driver";
	private static String URL = null;
	private static String KEY_URL = "url";
	// private static String DATABASE = null;
	// private static String KEY_DATABASE = "database";
	public static String USER = null;
	private static String KEY_USER = "user";
	public static String PASSWORD = null;
	private static String KEY_PASSWORD = "password";

	public static String connectString = null;

	public static boolean succeed = false;

	static {
		try {
			// String path = DatabaseProperty.class.getResource("/").getPath();
			// File f = new File(path + configFilePath);
			File f = new File(configFilePath);
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			NodeList nl = doc.getElementsByTagName(KEY_ROOT);
			if (nl.getLength() == 1) {

				DRIVER = doc.getElementsByTagName(KEY_DRIVER).item(0)
						.getFirstChild().getNodeValue();
				// DATABASE =
				// doc.getElementsByTagName(KEY_DATABASE).item(0).getFirstChild().getNodeValue();
				URL = doc.getElementsByTagName(KEY_URL).item(0).getFirstChild()
						.getNodeValue();
				USER = doc.getElementsByTagName(KEY_USER).item(0)
						.getFirstChild().getNodeValue();
				if (doc.getElementsByTagName(KEY_PASSWORD).item(0)
						.getFirstChild() == null) {
					PASSWORD = "";
				} else {
					PASSWORD = doc.getElementsByTagName(KEY_PASSWORD).item(0)
							.getFirstChild().getNodeValue();
				}
				connectString = URL;

				succeed = true;
			} else {
				succeed = false;
			}
		} catch (Exception e) {
			succeed = false;
		}
	}

}
