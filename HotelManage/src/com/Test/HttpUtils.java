package com.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtils {
	
	public static InputStream getInputStream(String path)
    {
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;

        try
        {
            URL url = new URL(path);
            if (null != url)
            {
                httpURLConnection = (HttpURLConnection) url.openConnection();

                // ������������ĳ�ʱʱ��
                httpURLConnection.setConnectTimeout(5000);

                // ��������
                httpURLConnection.setDoInput(true);

                // ���ñ���Http����ʹ�õķ���
                httpURLConnection.setRequestMethod("GET");

                if (200 == httpURLConnection.getResponseCode())
                {
                    // �ӷ��������һ��������
                    inputStream = httpURLConnection.getInputStream();

                }

            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return inputStream;
    }

    public static void saveInputStream(InputStream inputStream, String saveToPath){
        
    	byte[] data = new byte[1024];
        int len = 0;
        FileOutputStream fileOutputStream = null;
        try
        {
            fileOutputStream = new FileOutputStream(saveToPath);
            while (-1 != (len = inputStream.read(data)))
            {
                fileOutputStream.write(data, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        finally	{
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != fileOutputStream) {
                try
                {
                    fileOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
