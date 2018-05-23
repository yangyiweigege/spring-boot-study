package com.weige.iterator.test;

import java.sql.*;

import com.mysql.jdbc.RowDataCursor;

public class AreaTest {
	public static void main(String[] args) throws SQLException {
		String tid = "e4207688-7e9c-484e-a956-5fc7f4bef950";
		Area area = new Area();
		area.setTid(tid);
		Connection connection = Mysql.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from t_area where tid='" + tid + "'");
		StringBuffer descrption = new StringBuffer();
		String parentId = null;
		/* 循环调用 查询父对象
		while (resultSet.next()) {
			System.out.println(resultSet.getString("area_name"));
			parentId = resultSet.getString("parent_code");
			while (!parentId.equals("0")) {
				Connection connection1 = Mysql.getConnection();
				Statement statement1 = connection.createStatement();
				ResultSet resultSet1 = statement.executeQuery("select * from t_area where tid='" + parentId + "'");
				while (resultSet1.next()) {
					System.out.println(resultSet1.getString("area_name"));
					parentId = resultSet1.getString("parent_code");
				}
			}

		}*/
		String s=iterator(tid);
		System.out.println(s);
	}

	public static String iterator(String tid) throws SQLException {
		if(!"0".equals(tid)) {
			Connection connection = Mysql.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from t_area where tid='" + tid + "'");
			while (resultSet.next()) {
				System.out.println(resultSet.getString("area_name"));
				return iterator(resultSet.getString("parent_code"))+resultSet.getString("area_name");
			}
		}
		return "";
	}
	
	//获取树的最后一层
	public static void getEndTree() {
		
	} 
}
