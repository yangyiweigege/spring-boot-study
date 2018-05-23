package com.weige.tree.test;
/**
 * <pre>
 * 功       能: 生成一棵树的模板方法
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年3月9日 下午3:38:55
 * Q    Q: 2873824885
 * </pre>
 */
public abstract class GenerateTreeTemplate {
	
	public GenerateTreeTemplate() {
		
	}
	
	/**
	 *模板方法
	 * @param <T>
	 */
	public final <T extends BaseTree> void generateTree(T node) {
		
	}
	
	/**
	 *自己需要实现的方法
	 */
	public abstract void addSelfAttribute();
	
}
