package com.weige.node.test;


public class NodeList<T> {

	private Node<T> firstNode;
	private int size = 0;
	
	public NodeList() {
		
	}

	public Node<T> getFirstNode() {
		return firstNode;
	}

	public void setFirstNode(Node<T> firstNode) {
		this.firstNode = firstNode;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void addNode(T data) {
		if (size == 0) { //设置头结点
			firstNode = new Node<T>();
			firstNode.setData(data);
			size++;
		} else {
			//遍历到末尾，添加一个结点
			Node<T> lastNode = getLastNode(firstNode);
			Node<T> nextNode = new Node<T>();
			nextNode.setData(data);
			lastNode.setNextNode(nextNode);
			size++;
		}
	}
	
	public Node<T> getLastNode(Node<T> node) {
		if (node.getNextNode() != null) {
			return getLastNode(node.getNextNode());
		}
		return node;
	}
	
	public void showList() {
		showCurrentNode(firstNode);
	}
	
	public void showCurrentNode(Node<T> node) {
		System.out.println(node.getData().toString());
		if (node.getNextNode() != null) {
			showCurrentNode(node.getNextNode());
		}
	}
}
