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

                // 设置连接网络的超时时间
                httpURLConnection.setConnectTimeout(5000);

                // 打开输入流
                httpURLConnection.setDoInput(true);

                // 设置本次Http请求使用的方法
                httpURLConnection.setRequestMethod("GET");

                if (200 == httpURLConnection.getResponseCode())
                {
                    // 从服务器获得一个输入流
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
