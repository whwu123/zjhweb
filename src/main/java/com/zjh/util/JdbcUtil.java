package com.zjh.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * 数据库连接公共类
 * @author wuchunhui 
 * @time 2017年11月4日 09:14:13
 *
 */
public class JdbcUtil {
	//属性文件的路径   
    static String profilepath="/jdbc.properties";  
    /**
     * 取得数据库连接
     * @return
     */
    public static Connection getConnection(){
    	Properties properties = new Properties();
    	try {
    		InputStream in = JdbcUtil.class.getResourceAsStream(profilepath);
			properties.load(in);
			 // 用getProperty方法通过关键字获取信息
           String driver = properties.getProperty("jdbc.driver");
		   String url = properties.getProperty("jdbc.url");
		   String userName = properties.getProperty("jdbc.username");
		   String password = properties.getProperty("jdbc.password");;
    	   Class.forName(driver);
    		return DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			System.out.println("数据库连接失败！！！");
			e.printStackTrace();
		}
    	return null;
    }
    
    public static void colseResource(Connection connection,PreparedStatement ps,ResultSet rs){
    	try {
    		if(rs!=null){
    			rs.close();
    		}
    		if(ps!=null){
    			ps.close();
    		}
			if(connection!=null){
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    public static void main(String[] args) {
		 Connection connection=  getConnection();
		 System.out.println(connection);
	}
    
    
    
}
