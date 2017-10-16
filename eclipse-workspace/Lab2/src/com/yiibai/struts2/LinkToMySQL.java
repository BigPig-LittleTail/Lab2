package com.yiibai.struts2;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class LinkToMySQL {
	Connection conn;
	Statement stmt;
	
	String driver = "com.mysql.jdbc.Driver";
	String username = System.getenv("ACCESSKEY");
	String password = System.getenv("SECRETKEY");
	String dbUrl = String.format("jdbc:mysql://%s:%s/%s", System.getenv("MYSQL_HOST"), System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));

	public LinkToMySQL()
	{
		conn = null;
		stmt = null;
	}
	
	public void Connect() 
	{
		try{
//			Class.forName("com.mysql.jdbc.Driver");
//			String url="jdbc:mysql://localhost:3306/bookdb?useUnicode=true&characterEncoding=utf-8&useSSL=false";
//			conn =  DriverManager.getConnection(url,"root","Whz970917");
			Class.forName(driver);
		    conn = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_littletail", "j13y05nm2o", "03mk11i1j0x3k5yy0j5ky552l2j413xjklxzmj5j");
			stmt =  conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 
			
		} catch (Exception e){
		    e.printStackTrace();
		}
	}
	
	public void close()
	{
		try
		{
			stmt.close();
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
