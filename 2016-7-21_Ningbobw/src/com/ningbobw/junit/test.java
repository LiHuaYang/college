package com.ningbobw.junit;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.ningbobw.dao.Dao;
import com.ningbobw.dao.DaoFactory;
import com.ningbobw.dao.dbutilsImpl.DaoImpy;
import com.ningbobw.entity.Article;

import net.sf.json.JSONArray;

public class test {
	
	@Test
	public void test1 () {
//		Article art = new Article(102, "测试题目", "测试来源", "测试介绍", "测试内容", "测试附件");
//		new DaoImpy().add(art); 
	}
	private static QueryRunner runerUpdate = new QueryRunner();
	
	@Test
	public void test2 () {
//		JSONArray array = new DaoImpy().getCategory();
//		System.out.println(array);
//		boolean flag = true;
//		
//		String sql = "INSERT INTO `bowen`.`board` (`content`, `category_id`) VALUES (?, ?)";
//		Object[] param = {"初中全科" , 107};
//		
//		try {
//			int res = runerUpdate.update(TransactionUtil.getConnection(), sql, param);
//
//		} catch (SQLException e) {
//			flag = false;
//			throw new RuntimeException(e);
//		}
		
		
		
//		System.out.println(dd.getTime());
		
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));

//		System.out.println(new DaoImpy().get(0));
		
	}
	
	@Test
	public void test3() {
//		DaoImpy dao  = new DaoImpy();
//		
//		System.out.println(dao.getArticleTitles("102"));
		System.out.println(new DaoImpy().getDetail("1034").toString());
	}
	
	
}
