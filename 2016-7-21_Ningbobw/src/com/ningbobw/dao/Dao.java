package com.ningbobw.dao;

import com.ningbobw.entity.Article;

import net.sf.json.JSONArray;

// 
public interface Dao {

	public boolean add(Article art);
	
	public JSONArray getCategory ();
	
	public JSONArray getBoardArticles ();

	public JSONArray getCatgoryArticles();

	/**
	 * 函数名称：getArticle
	 * 功能描述：获取文章列表
	 * 参数说明：
	 * 返回值：List<Article>
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月25日下午10:23:11
	 */
	public JSONArray getArticle(int page,int rows);

	/**
	 * 函数名称：getArticleNum
	 * 功能描述：获取文章总数
	 * 参数说明：
	 * 返回值：String
	 * 备注：
	 * 
	 * 作者：joker		时间：2016年7月25日下午10:22:57
	 */
	public String getArticleNum();
	
	/**
	 * 函数名称：getArticleTitles
	 * 功能描述：根据板块ID获取，该板块下的文章简要信息
	 * 参数说明：
	 * 返回值：JSONArray
	 * 备注：
	 * 
	 * 作者：ariclee		时间：2016年7月26日下午7:07:42
	 */
	public JSONArray getBoardArticleTitles(String board_id);
	
	
	public Article getDetail(String article_id);

	public JSONArray getCategoryArticleTitles(String board_id);
}
