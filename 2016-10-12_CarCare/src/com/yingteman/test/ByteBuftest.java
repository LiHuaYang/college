package com.yingteman.test;


import java.util.Arrays;

import org.junit.Test;

import com.yingteman.netty.bytebuf.ByteBufTools;
import com.yingteman.netty.message.MessageConstant;

public class ByteBuftest {

	
	@Test
	public void test() {
		String hexSt = "ff49434152001601000000310000000001010000001cf554aabb5c6e";
		byte[] buf = ByteBufTools.hexString2Bytes(hexSt);
		System.out.println(buf.length);
		
		String hexSt1 = "ff494341520132010000003100000000000201000000000000000000000000000000000000000000000000000000000000000039363934393030303133313600a230819f300d06092a864886f70d010101050003818d0030818902818100cd05ee3053c3018b2e256d90e2809e69d4b60fe4d96519f8a2066b59599b36e822975e246f7a0f43392a8b98290ffba2a1c465027c52aab490cedb7807621530c4ca23e548110bf1e5aa1bb45e16ce6c3112b925fe2029e6e116e379135ca7c4928353f39a74032c9397f589c00ceb83e88aa267b80e052203872b3dcef2cb910203010001303030303030303030303030303030383938363031313437393534303038333635363407312e302e302e3122342e33302d342e31342d382e31302d31362e30362d312e30312e3036302d312e31350000001cf554AABB5C6E";
		byte[] buf1 = ByteBufTools.hexString2Bytes(hexSt1);
		System.out.println(buf1.length);
		
		String hexSt2 = "000000000000000000000000000000000000000000000000000000000000000039363934393030303133313600a230819f300d06092a864886f70d010101050003818d0030818902818100cd05ee3053c3018b2e256d90e2809e69d4b60fe4d96519f8a2066b59599b36e822975e246f7a0f43392a8b98290ffba2a1c465027c52aab490cedb7807621530c4ca23e548110bf1e5aa1bb45e16ce6c3112b925fe2029e6e116e379135ca7c4928353f39a74032c9397f589c00ceb83e88aa267b80e052203872b3dcef2cb910203010001303030303030303030303030303030383938363031313437393534303038333635363407312e302e302e3122342e33302d342e31342d382e31302d31362e30362d312e30312e3036302d312e3135";
		byte[] buf2 = ByteBufTools.hexString2Bytes(hexSt2);
		System.out.println(buf2.length);
		
		String hexSt3 = "ff494341520132010000003100000000000201000000000000000000000000000000000000000000000000000000000000000039363934393030303133313600a230819f300d06092a864886f70d010101050003818d0030818902818100cd05ee3053c3018b2e256d90e2809e69d4b60fe4d96519f8a2066b59599b36e822975e246f7a0f43392a8b98290ffba2a1c465027c52aab490cedb7807621530c4ca23e548110bf1e5aa1bb45e16ce6c3112b925fe2029e6e116e379135ca7c4928353f39a74032c9397f589c00ceb83e88aa267b80e052203872b3dcef2cb910203010001303030303030303030303030303030383938363031313437393534303038333635363407312e302e302e3122342e33302d342e31342d382e31302d31362e30362d312e30312e3036302d312e31350000001cf554";
		byte[] buf3 = ByteBufTools.hexString2Bytes(hexSt3);
		System.out.println(buf3.length);
	}
	
	@Test
	public void test1() {
		// 保存255以上的数字
//		byte bb = (byte) 0x255;
//		byte bbb = (byte) 0x23333;
//		System.out.println(bb + "---" + bbb);
		
		String hexsz = "ff123";
		String hezzw = "中国";
		String hexyw = "english";
//		System.out.println(hex.getBytes().length); // 5个字节
		
		byte b1 = (byte)(255 & 0xff);
		byte b2 = (byte) 255;
		
		int i = (int)(b1 & 0xff) ;

//		System.getProperties().list(System.out);
		
		
		System.out.println(hexsz.length()); // 5
		System.out.println(hezzw.length()); // 2
		System.out.println(hexyw.length()); // 7
		
		System.out.println(hexsz.getBytes().length); // 5
		System.out.println(hezzw.getBytes().length); // 6 UTF-8编码，一个汉字 3 个字节
		System.out.println(hexyw.getBytes().length); // 7
	}
	
	@Test
	public void test3() {
		String ZHEN_BIAO_ZHI = "1096445804882"; // 13字节
		byte[] bytes = ZHEN_BIAO_ZHI.getBytes();
		// AABB5C6E
		byte[] zhentou = {(byte) 0xff, 0x49, 0x43, 0x41, 0x52}; // ff 49 43 41 52 : hex
		
		byte[] zhenwei1 = {(byte) 0xAA, (byte) 0xBB, 0x5C, 0x6E};
		byte[] zhenwei2 = MessageConstant.zhen_wei;
		
		String s1 = Arrays.toString(zhenwei1);
		String s2 = Arrays.toString(zhenwei2);
		
		for(byte b : zhenwei1) {
			System.out.println(b);
		}
		System.out.println("-------------------------");
		for(byte b : zhenwei2) {
			System.out.println(b);
		}
		
		System.out.println(zhenwei1.equals(zhenwei2));
		System.out.println(s1.equals(s2));
	}
	
	@Test
	public void test4() {
		Short sh = new Short((short) 10);
		
		int in = 10;
		
		System.out.println(sh - in);
		
		System.out.println(sh.shortValue());
		System.out.println(sh.SIZE); // 16 位，2 字节
	}
	
	@Test
	public void test5() {
		int i = 10;
		Integer I = 10;
		System.out.println(I.equals(i));
		
		
		byte b = 1;
		Byte B = 1;
		System.out.println(B.equals(b));
	}
	
	
	
}
