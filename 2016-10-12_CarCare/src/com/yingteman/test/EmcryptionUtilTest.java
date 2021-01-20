package com.yingteman.test;



import java.util.Map;

import com.yingteman.netty.codec.emcryptionUtil.AESUtils;
import com.yingteman.netty.codec.emcryptionUtil.HexUtil;
import com.yingteman.netty.codec.emcryptionUtil.RSAUtils;

public class EmcryptionUtilTest {
	public static void main(String[] args) {
		String str = "helloword!";
		// rsa测试代码
		Map<String, byte[]> rsaKey = RSAUtils.generateKeyPair();
		byte buf[] = str.getBytes();

		// 加密
		buf = RSAUtils.encrypt(str.getBytes(), rsaKey.get("publicKey"));
		System.out.println("解码后的密文：" + HexUtil.byte2Hex(buf));

		// 解密
		buf = RSAUtils.decrypt(buf, rsaKey.get("privateKey"));
		String res = new String(buf);
		System.out.println(res);

		
		// aes测试代码
		byte key[] = AESUtils.generateKey();
		byte buf2[] = AESUtils.generateKey();
		
		//加密
		buf2 = AESUtils.encrypt(str.getBytes(), key);
		System.out.println("解码后的密文：" + HexUtil.byte2Hex(key));
		
		//解密
		buf2 = AESUtils.decrypt(buf2, key);
		String res2 = new String(buf2);
		System.out.println(res2);
		

	}
}
