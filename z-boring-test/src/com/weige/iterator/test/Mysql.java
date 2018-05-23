package com.weige.iterator.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 链接Mysql
 * @author yangyiwei
 *
 */
public class Mysql
{
	private static String uri="jdbc:mysql://192.168.10.148:3306/meeting?characterEncoding=utf8";
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动成功");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public Mysql()
	{
		
	}
	
	public static Connection getConnection()
	{
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(uri,"root","password");
		} 
    	catch (SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn,Statement stmt,ResultSet rs)
	{
		try
		{
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void close(Connection conn,Statement stmt)
	{
		try
		{
			conn.close();
			stmt.close();
			System.out.println("关闭链接");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
