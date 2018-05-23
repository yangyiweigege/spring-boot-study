package com.weige.tree.test;
/**
 * <pre>
 * 功       能: 基本数据(tree)
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年3月9日 下午3:20:23
 * Q    Q: 2873824885
 * </pre>
 */
public class BaseTree {
	/**
	 * 自身id
	 */
	private String tid;
	
	/**
	 * 父关联id
	 */
	private String parentCode;
	
	/**
	 * 节点名称
	 */
	private String name;
	
	public BaseTree() {
		
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BaseTree [tid=" + tid + ", parentCode=" + parentCode + ", name=" + name + "]";
	}

	
	
	
}
