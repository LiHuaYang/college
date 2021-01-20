package com.yingteman.test;

import java.text.MessageFormat;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.yingteman.database.RedisKeyHelper;

public class StringReplaceTest {

	
	@Test
	public void test1() {
		String text = "xcmap:?:?";
		String[] searchList = new String[]{"?", "?"};
		String[] replacementList = new String[]{"aaa", "bbb"};
		String res = StringUtils.replaceEach(text, searchList, replacementList);
		System.out.println(res);
	}
	
	@Test
	public void test2() {
		String str = MessageFormat.format("我是{0},我来自{1},今年{2}岁", "中国人", "北京", "22");
		String text = MessageFormat.format("xcmap:{0}:{1}", "aa", "bb");
		System.out.println(text);
	}
	
//	@Test
//	public void test3() {
//		RedisKeyHelper helper = new RedisKeyHelper();
//		String xcmp = helper.getRedisKey("xcmap");
//		System.out.println(xcmp);
//		System.out.println(MessageFormat.format(xcmp, "aaa", "bbb"));
//	}
	
	
	
}
