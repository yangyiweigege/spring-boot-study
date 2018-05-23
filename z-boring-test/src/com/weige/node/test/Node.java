package com.weige.node.test;
/**
 * 节点
 * @author Administrator
 *
 */
public class Node<T>
{
	/**
	 * 数据域
	 */
	private T data;
	
	/**
	 * 下一个节点
	 */
	private Node<T> nextNode;
	
	public Node()
	{
		
	}
	
	

	public T getData()
	{
		return data;
	}



	public void setData(T data)
	{
		this.data = data;
	}





	public Node<T> getNextNode()
	{
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode)
	{
		this.nextNode = nextNode;
	}

	@Override
	public String toString()
	{
		return "Node [data=" + data + ", nextNode=" + nextNode + "]";
	}
	
	
	
}
