package com.weige.tree.test;

public class MeetArea extends BaseTree{

	/**
	 * 区域名称
	 */
	private String areaName;
	
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Override
	public String toString() {
		return "MeetArea [areaName=" + areaName + ", toString()=" + super.toString() + "]";
	}

	
	
}
