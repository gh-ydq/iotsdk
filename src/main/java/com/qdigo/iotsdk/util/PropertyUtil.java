package com.qdigo.iotsdk.util;
import java.io.InputStream;
import java.util.Properties;

import com.qdigo.iotsdk.Connection;
/**
 * ��ȡ�����ļ�
 * @author yudengqiu
 *
 */
public class PropertyUtil {
	
	public static Properties load(String filePath){
		Properties pro = new Properties();
		try {
			//��ȡ�ļ���λ��  
	        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);	
			pro.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pro;
	}
	
	public static void main(String[] args) {
		Properties pro = load("config.properties");
		Connection.getInstance("172.16.48.246",8088);
		System.out.println("--------------"+pro.getProperty("ip"));
	}
	
}
