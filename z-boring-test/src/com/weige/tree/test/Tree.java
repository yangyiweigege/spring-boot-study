package com.weige.tree.test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.alibaba.fastjson.JSONObject;
/**
 * <pre>
 * 功       能:树节点 
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年3月9日 下午3:35:20
 * Q    Q: 2873824885
 * </pre>
 */
public class Tree<T extends BaseTree>
{
	/**
	 * 父节点
	 */
	private T parent;
	
	/**
	 * 子节点
	 */
	private List<Tree<T>> child=new ArrayList<Tree<T>>();
	
	public Tree()
	{
		
	}

	public T getParent()
	{
		return parent;
	}

	public void setParent(T parent)
	{
		this.parent = parent;
	}

	public List<Tree<T>> getChild()
	{
		return child;
	}

	public void setChild(List<Tree<T>> child)
	{
		this.child = child;
	}
	
	@Override
	public String toString() {
		return "Tree [parent=" + parent + ", child=" + child + "]";
	}


	public static void main(String[] args) {
		Tree<MeetArea> trees = new Tree<MeetArea>();
		//先查询第一级树
		Connection connection = Mysql.getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from t_area where parent_code = '0' ");
			while (resultSet.next()) {
				Tree<MeetArea> tree = new Tree<MeetArea>();
				MeetArea meetArea = new MeetArea(); 
				meetArea.setAreaName(resultSet.getString("area_name"));
				meetArea.setTid(resultSet.getString("tid"));
				meetArea.setParentCode(resultSet.getString("parent_code"));
				tree.setParent(meetArea); 
				trees.getChild().add(tree);
			}
			//递归形成二级树
			for(Tree<MeetArea> meetTree : trees.getChild()) {
				generateTree(meetTree);
			}
			trees.setParent(new MeetArea());
			readTree(trees);
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
	public static void  generateTree(Tree<MeetArea> tree) {
		Connection connection = Mysql.getConnection();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from t_area where parent_code ='"+tree.getParent().getTid()+"' " );
			while (resultSet.next()) {
				Tree<MeetArea> sonTree = new Tree<MeetArea>();
				MeetArea meetArea = new MeetArea(); 
				meetArea.setAreaName(resultSet.getString("area_name"));
				meetArea.setTid(resultSet.getString("tid"));
				meetArea.setParentCode(resultSet.getString("parent_code"));
				sonTree.setParent(meetArea);
				tree.getChild().add(sonTree);//将树挂载到这个节点
				generateTree(sonTree);//继续递归这个树
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * <pre>
	 * 功       能: 递归读出这棵树
	 * 涉及版本: V3.0.0 
	 * 创  建  者: yangyiwei
	 * 日       期: 2018年3月9日 下午3:05:25
	 * Q    Q: 2873824885
	 * </pre>
	 */
	public static void readTree(Tree<MeetArea> tree) {
		System.out.println("区域" + tree.getParent().getAreaName() + " tid " + tree.getParent().getTid() + " parentCode " + tree.getParent().getParentCode());
		for (Tree<MeetArea> son : tree.getChild()) {
			readTree(son);
		}
	}
	
	public void getT(Tree<T> tree) {
		tree.getParent().getName();
	}
	
	
	
}
