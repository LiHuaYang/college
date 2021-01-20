package com.ningbobw.dao.dbutilsImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import com.ningbobw.dao.Dao;
import com.ningbobw.entity.Article;
import com.ningbobw.utils.JdbcUtils_DBCP;
import com.ningbobw.utils.TransactionUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

// 
public class DaoImpy implements Dao {

	private static QueryRunner runerUpdate = new QueryRunner();
	private static QueryRunner runerQuery = new QueryRunner(JdbcUtils_DBCP.getDataSource());

	@Override
	public boolean add(Article art) {
		boolean flag = true;
		String sql = "INSERT INTO `bowen`.`article` (`board_id`, `title`, `source`, `content`, `attach`, `time`, `introduce`) VALUES (?, ?, ?, ?, ?, ?, ?);";
		Object[] param = { art.getBoard_id(), art.getTitle(), art.getSource(), art.getContent(), art.getAttach(), art.getTime(), art.getIntroduce()};

		try {
			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);

		} catch (SQLException e) {
			flag = false;
			throw new RuntimeException(e);
		}
		return flag;
	}

	
	@Override
	public JSONArray getCategory () {
		JSONArray list = new JSONArray();
		Connection conn = JdbcUtils_DBCP.getConnection();
		CallableStatement cstmt = null;
		ResultSet resultSet = null;
		
		try {
			cstmt = conn.prepareCall( "{call getAllCatgory()}");
			resultSet = cstmt.executeQuery();
			while(resultSet.next()) {
				JSONObject obj = new JSONObject();
				obj.put("id", resultSet.getString("id"));
				obj.put("titile", resultSet.getString("titile"));
				obj.element("item", JSONArray.fromObject(resultSet.getString("item")));
				list.add(obj);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils_DBCP.release(conn, cstmt, resultSet);
		}
		return list;
	}

	@Override
	public JSONArray getBoardArticles () {
		JSONArray list = new JSONArray();
		Connection conn = JdbcUtils_DBCP.getConnection();
		CallableStatement cstmt = null;
		ResultSet resultSet = null;

		try {
			cstmt = conn.prepareCall( "{call get_board_article()}");
			resultSet = cstmt.executeQuery();
			while(resultSet.next()) {
				JSONObject obj = new JSONObject();
				obj.put("board_id", resultSet.getString("board_id"));
				obj.element("article_list", JSONArray.fromObject(resultSet.getString("article_list")));
				list.add(obj);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils_DBCP.release(conn, cstmt, resultSet);
		}
		return list;
	}
	
	
	
	@Override
	public JSONArray getCatgoryArticles () {
		JSONArray list = new JSONArray();
		Connection conn = JdbcUtils_DBCP.getConnection();
		CallableStatement cstmt = null;
		ResultSet resultSet = null;

		try {
			cstmt = conn.prepareCall( "{call get_category_article()}");
			resultSet = cstmt.executeQuery();
			while(resultSet.next()) {
				JSONObject obj = new JSONObject();
				obj.put("catgory_id", resultSet.getString("catgory_id"));
				obj.element("article_list", JSONArray.fromObject(resultSet.getString("article_list")));
				list.add(obj);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils_DBCP.release(conn, cstmt, resultSet);
		}
		return list;
	}
	
	@Override
	public JSONArray getArticle(int page,int rows) {
		int startPage = (page-1) * rows;
		List<Map<String, Object>> m = null;
		JSONArray array = null;
		String sql = "select id,board_id,title,source,attach,time,CONCAT('<a onclick=edit(',id,')>Edit</a>') as edit from article limit ?,?";
		Object[] param = {startPage,rows};
		try {
			m = runerQuery.query(sql, param,new MapListHandler());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		array = JSONArray.fromObject(m);
		return array;
	}
	
	@Override
	public String getArticleNum() {
		Map a = null;
		String num =null;
		String sql = "select count(*) from article";
		try {
			a = runerQuery.query(sql, new MapHandler());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		num =  a.get("count(*)").toString();
		return num;
	}
	
	@Override
	public JSONArray getBoardArticleTitles(String board_id) {
		List<Map<String, Object>> m = null;
		JSONArray array = null;
		String sql = "select id,board_id, title, time, CONCAT('detail.html?article_id=',id) as link from article where board_id = ?";
		Object[] param = { board_id };
		try {
			m = runerQuery.query(sql, param,new MapListHandler());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		array = JSONArray.fromObject(m);
		return array;
	}
	
	@Override
	public JSONArray getCategoryArticleTitles(String catg_id) {
		List<Map<String, Object>> m = null;
		JSONArray array = null;
		String sql = "SELECT art.id,art.board_id, art.title, art.time , CONCAT('detail.html?article_id=',art.id) as link FROM board as boa, category AS ca, article as art WHERE boa.category_id = ca.id AND art.board_id = boa.id AND ca.id != \"100\" AND ca.id = ? ORDER BY ca.id";
		Object[] param = { catg_id };
		try {
			m = runerQuery.query(sql, param,new MapListHandler());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		array = JSONArray.fromObject(m);
		return array;
	}

	// 

	@Override
	public Article getDetail(String article_id) {
		Article article = null;
		JSONArray array = null;
		String sql = "select * from article where id = ?";
		Object[] param = { article_id };
		try {
			article = runerQuery.query(sql, param, new BeanHandler<Article>(Article.class));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
