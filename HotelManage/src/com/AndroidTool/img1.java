package com.AndroidTool;


import java.io.*;
import java.awt.*;
import java.awt.image.*;
import com.sun.image.codec.jpeg.*;

public class img1 {
	private String destFile;
	private int width;
	private int height;
	private Image img;

	public img1(String fileName) throws IOException {
		File _file = new File(fileName); // �����ļ�
		_file.getName();
		this.destFile = "D:/dage2.jpg";// this.srcFile.substring(0,
										// this.srcFile.lastIndexOf("."))
										// +"_s.jpg";
		img = javax.imageio.ImageIO.read(_file); // ����Image����
		width = img.getWidth(null); // �õ�Դͼ��
		height = img.getHeight(null); // �õ�Դͼ��
	}

	/**
	 * /**
	 * 
	 * @param args
	 */
	public void resize(int w, int h) throws IOException {
		try {
			BufferedImage _image = new BufferedImage(w, h,
					BufferedImage.TYPE_INT_RGB);
			_image.getGraphics().drawImage(img, 0, 0, w, h, null); // ������С���ͼ
			FileOutputStream newimageout = new FileOutputStream(destFile); // ������ļ���
			/*
			 * JPEGImageEncoder ��ͼ�񻺳����ݱ���Ϊ JPEG ���������ýӿڵ��û�Ӧ�� Raster ��
			 * BufferedImage ���ṩͼ�����ݣ��� JPEGEncodeParams ���������ñ�Ҫ�Ĳ����� ���ɹ��ش�
			 * OutputStream������ JPEG ����Ŀ��������JPEGImageEncoder �ӿڿ� ��ͼ�����ݱ���Ϊ����������
			 * JPEG ������������������д���ṩ���������� OutputStream �С�
			 * ע�⣺com.sun.image.codec.jpeg ���е��ಢ�����ں��� Java API���������� Sun ������ JDK
			 * �� JRE ��Ʒ����ɲ��֡���Ȼ���������ɷ�����ѡ�񷢲���Щ�࣬��������Ա���ܼ� ϣ���ڴӷ� Sun
			 * ʵ�ֵ�����еõ����ǡ�����������ͬ�Ĺ������տ����ں��� API ���׼�� չ�еõ���
			 */
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimageout);
			encoder.encode(_image); // ��JPEG����
			newimageout.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * ���չ̶��ı�������ͼƬ
	 * 
	 * @param t
	 *            double ����
	 * @throws IOException
	 */
	public void resize(double t) throws IOException {
		int w = (int) (width * t);
		int h = (int) (height * t);
		resize(w, h);
	}

	/**
	 * �Կ��Ϊ��׼���ȱ�������ͼƬ
	 * 
	 * @param w
	 *            int �¿��
	 * @throws IOException
	 */
	public void resizeByWidth(int w) throws IOException {
		int h = (int) (height * w / width);
		resize(w, h);
	}

	/**
	 * �Ը߶�Ϊ��׼���ȱ�������ͼƬ
	 * 
	 * @param h
	 *            int �¸߶�
	 * @throws IOException
	 */
	public void resizeByHeight(int h) throws IOException {
		int w = (int) (width * h / height);
		resize(w, h);
	}

	/**
	 * �������߶����ƣ��������ĵȱ�������ͼ
	 * 
	 * @param w
	 *            int �����
	 * @param h
	 *            int ���߶�
	 * @throws IOException
	 */
	public void resizeFix(int w, int h) throws IOException {
		if (width / height > w / h) {
			resizeByWidth(w);
		} else {
			resizeByHeight(h);
		}
	}

	/**
	 * ����Ŀ���ļ��� setDestFile
	 * 
	 * @param fileName
	 *            String �ļ����ַ���
	 */
	public void setDestFile(String fileName) throws Exception {
		if (!fileName.endsWith(".jpg")) {
			throw new Exception("Dest File Must end with \".jpg\".");
		}
		destFile = fileName;
	}

	/**
	 * ��ȡĿ���ļ��� getDestFile
	 */
	public String getDestFile() {
		return destFile;
	}

	/**
	 * ��ȡͼƬԭʼ��� getSrcWidth
	 */
	public int getSrcWidth() {
		return width;
	}

	/**
	 * ��ȡͼƬԭʼ�߶� getSrcHeight
	 */
	public int getSrcHeight() {
		return height;
	}

	public static void main(String[] args) {
		try {
			img1 ccc = new img1("D:/dage.jpg");
			ccc.resizeFix(600, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

