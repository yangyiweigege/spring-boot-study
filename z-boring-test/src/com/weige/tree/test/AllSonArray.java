package com.weige.tree.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AllSonArray {
	
	
	public static void main(String[] args) {
	
		//先查询第一级树
		Connection connection = Mysql.getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from t_area where tid='c023c2f6-c3a4-46c1-b084-bcd054737789' ");
			List<BaseTree> mainList = new ArrayList<BaseTree>();
			List<BaseTree> sonList = new ArrayList<BaseTree>();
			//ResultSet resultSet = statement.executeQuery("select * from t_area where parent_code = '0' ");
			while (resultSet.next()) { //查询主区域
				BaseTree mainArea = new BaseTree();
				mainArea.setName(resultSet.getString("area_name"));
				mainArea.setTid(resultSet.getString("tid"));
				mainArea.setParentCode(resultSet.getString("parent_code"));
				mainList.add(mainArea);
				sonList.add(mainArea);
			}
			//递归形成二级树
			for(BaseTree baseTree : mainList) {
				generateTree(baseTree, sonList);
			}

			System.out.println(sonList.toString());
		//	System.out.println(JSONObject.toJSONString(trees));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <pre>
	 * 功       能: 递归形成多级树
	 * 涉及版本: V3.0.0 
	 * 创  建  者: yangyiwei
	 * 日       期: 2018年3月9日 下午2:54:49
	 * Q    Q: 2873824885
	 * </pre>
	 */
	public static void  generateTree(BaseTree tree, List<BaseTree> baseTrees) {
		Connection connection = Mysql.getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("select * from t_area where parent_code ='"+tree.getTid()+"' " );
			while (resultSet.next()) {
				BaseTree sonArea = new BaseTree();
				sonArea.setName(resultSet.getString("area_name"));
				sonArea.setTid(resultSet.getString("tid"));
				sonArea.setParentCode(resultSet.getString("parent_code"));
				baseTrees.add(sonArea);//将树挂载到这个节点
				generateTree(sonArea, baseTrees);//继续递归这个树
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
