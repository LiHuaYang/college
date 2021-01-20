package com.ningbobw.service;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;

import com.ningbobw.dao.Dao;
import com.ningbobw.dao.DaoFactory;
import com.ningbobw.entity.Article;
import com.ningbobw.utils.FileUtils;
import com.ningbobw.utils.TransactionUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;




public class Service {
	
	private static Service service = null;
	public static Service getInstance () {
		if (service == null) {
			service = new Service();
			return service;
		} else {
			return service;
		}
	}
	private Service () {} 
	
	Dao ddao = DaoFactory.getInstance().create("com.ningbobw.dao.dbutilsImpl.DaoImpy", Dao.class);
	
	// 定义允许上传的文件扩展名
	private static HashMap<String, String>  extMap = new HashMap<String, String>();
	static {
		extMap.put("image", "gif,jpg,jpeg,png,bmp,doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2,xml");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "");
	}
	
	/**
	 * 函数名称：addArticle
	 * 功能描述：
	 * 参数说明：
	 * 返回值：boolean
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年7月23日下午9:03:54
	 */
	public boolean addArticle(Article art) {
		boolean flag = true;
		TransactionUtil.getConnection(); 
		try {
			TransactionUtil.startTransaction(); 
			ddao.add(art);
			
		} catch (Exception e){
			flag = false;
			TransactionUtil.roolback();
			e.printStackTrace();

		} finally {
			TransactionUtil.commit();
			TransactionUtil.release(); 
		}
		return flag;
	}
	
	/**
	 * 函数名称：getCategory
	 * 功能描述：
	 * 参数说明：
	 * 返回值：JSONArray
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年7月24日上午11:25:29
	 */
	public JSONArray getCategory () {
		return ddao.getCategory();
	}
	/**
	 * 函数名称：uploadAttach
	 * 功能描述：
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年7月25日下午2:22:18
	 */
	public String uploadAttach(String filename, String path, InputStream in) {
		
		String res = null;
		FileOutputStream out = null;
		
		filename = filename.substring(filename.lastIndexOf("\\") + 1); // 计科13408-李华洋-实验三表视图和表视图控制器实验报告.doc
		String fileExt = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase(); // 检查文件的扩展名 //doc
		
		if (!Arrays.<String> asList(extMap.get("image").split(",")).contains(fileExt)) {	// 上传的文件名不符合规范
			return res;
		}
		try {
			out = new FileOutputStream(path + "\\" + filename); 
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		boolean flag = FileUtils.writeToFile(out, in); // 写入文件
		if (flag) {  
			res = filename;
		}
		return res;
	}
	

	/**
	 * 函数名称：getArticle
	 * 功能描述：
	 * 参数说明：
	 * 返回值：JSONArray
	 * 备注：
	 *  [{"board_id": "102","article_list": [{"title": "考试技巧2","time": "2016-07-26"},{"title": "考试技巧1","time": "2016-07-26"}]}]
	 * 作者：ariclee		时间：2016年7月25日下午5:26:47
	 */
	public JSONObject getArticles () {
		JSONObject json = new JSONObject();
		json.element("board", ddao.getBoardArticles());
		json.element("categ", ddao.getCatgoryArticles());
		
		return json;
	}
	
	/**
	 * 
	 * 函数名称：getArticleList
	 * 功能描述：后台获取文章列表
	 * 参数说明：
	 * 返回值：JSONArray
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月25日下午10:25:16
	 */
	public JSONArray getArticleList (int page,int rows) {
		return ddao.getArticle(page,rows);
	}
	
	/**
	 * 函数名称：getArticleListNum
	 * 功能描述：用于获取页数
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月25日下午10:27:05
	 */
	public String getArticleListNum () {
		return ddao.getArticleNum();
	}
	
	/**
	 * 函数名称：getBoardTitle
	 * 功能描述：获取指定板块下的文章列表
	 * 参数说明：
	 * 返回值：JSONArray
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年7月26日下午7:22:11
	 */
	public JSONArray getTitleList(String condition_id, String type) {
		if (type.equalsIgnoreCase("b")) {
			return ddao.getBoardArticleTitles(condition_id);
		} else {
			return ddao.getCategoryArticleTitles(condition_id);
		}
	}
	
	/**
	 * 函数名称：getArticleDetail
	 * 功能描述：获取指定ID的文章详情
	 * 参数说明：
	 * 返回值：JSONObject
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年7月26日下午7:23:57
	 */
	public JSONObject getArticleDetail (String article_id) {
		return JSONObject.fromObject(ddao.getDetail(article_id));
	}
	
	
}
