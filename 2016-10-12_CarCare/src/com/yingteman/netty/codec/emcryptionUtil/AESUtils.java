package com.yingteman.netty.codec.emcryptionUtil;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {
	public static final String AES_ALGORITHM = "AES/ECB/PKCS5Padding";

	public static byte[] generateKey() {
		KeyGenerator kgen = null;
		try {
			kgen = KeyGenerator.getInstance("AES");
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		kgen.init(128);
		SecretKey secretKey = kgen.generateKey();
		return secretKey.getEncoded();

	}

	/**
	 * 加密方法 source： 源数据
	 */
	public static byte[] encrypt(byte[] source, byte[] rawKey) {

		SecretKeySpec key = new SecretKeySpec(rawKey, "AES");

		try {
			Cipher cipher = null;
			cipher = Cipher.getInstance("AES");
			// 创建密码器
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = null;
			result = cipher.doFinal(source);
			return result; // 加密

		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} // 初始化
		catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解密算法 cryptograph:密文
	 */
	public static byte[] decrypt(byte[] cryptograph, byte[] rawKey) {
		SecretKeySpec key = new SecretKeySpec(rawKey, "AES");
		Cipher cipher;
		try {
			// 创建密码器
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] result = null;
			result = cipher.doFinal(cryptograph);// 初始化
			return result; // 解密

		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
