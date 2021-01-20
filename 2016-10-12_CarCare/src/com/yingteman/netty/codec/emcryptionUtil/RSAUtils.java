package com.yingteman.netty.codec.emcryptionUtil;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSAUtils {

	/** 指定key的大小 */
	public static final String CHAR_ENCODING = "UTF-8";
	public static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";
	private static int KEYSIZE = 1024;

	/* 客户端生成密钥对使用 */
	public static Map<String, byte[]> generateKeyPair() {
		/** RSA算法要求有一个可信任的随机数源 */
		SecureRandom sr = new SecureRandom();
		/** 为RSA算法创建一个KeyPairGenerator对象 */
		KeyPairGenerator kpg = null;
		try {
			kpg = KeyPairGenerator.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		/** 利用上面的随机数据源初始化这个KeyPairGenerator对象 */
		kpg.initialize(KEYSIZE, sr);
		/** 生成密匙对 */
		KeyPair kp = kpg.generateKeyPair();

		/** 得到公钥 */
		Key publicKey = kp.getPublic();
		byte[] pub = publicKey.getEncoded();
		/** 得到私钥 */
		Key privateKey = kp.getPrivate();
		byte[] pri = privateKey.getEncoded();

		Map<String, byte[]> map = new HashMap<String, byte[]>();
		map.put("publicKey", pub);
		map.put("privateKey", pri);

		return map;
	}

	/**
	 * 加密方法 source： 源数据
	 */
	public static byte[] encrypt(byte[] source, byte[] publicKey) {

		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKey);

		try {
			KeyFactory keyFactory = null;
			keyFactory = KeyFactory.getInstance("RSA");
			PublicKey puk = null;
			puk = keyFactory.generatePublic(keySpec);
			/** 得到Cipher对象来实现对源数据的RSA加密 */
			Cipher cipher = null;
			cipher = Cipher.getInstance(RSA_ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, puk);
			/** 执行加密操作 */
			byte[] buf = null;
			buf = cipher.doFinal(source);
			return buf;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e1) {
			e1.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 解密算法 cryptograph:密文
	 */
	public static byte[] decrypt(byte[] cryptograph, byte[] privateKey) {
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKey);

		try {
			KeyFactory keyFactory = null;
			keyFactory = KeyFactory.getInstance("RSA");
			PrivateKey prk = null;
			prk = keyFactory.generatePrivate(keySpec);
			/** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
			Cipher cipher = null;
			cipher = Cipher.getInstance(RSA_ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, prk);
			/** 执行解密操作 */
			byte[] buf = null;
			buf = cipher.doFinal(cryptograph);
			return buf;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
