package com.weige.tree.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Mysql连接
 * @author yangyiwei
 *
 */
public class Mysql
{
	private static String uri="jdbc:mysql://localhost:3306/meeting?characterEncoding=utf8";
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动连接成功");
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
			conn = DriverManager.getConnection(uri,"root","123456");
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
			System.out.println("连接关闭");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	


}
