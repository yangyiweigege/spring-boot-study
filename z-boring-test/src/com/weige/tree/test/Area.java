package com.weige.tree.test;

import java.util.ArrayList;
import java.util.List;


/**
 * 区域树
 * @author Administrator
 *
 */

public class Area
{
	/**
	 * 区域名称
	 */
	private String areaName;
	
	/**
	 * 区域id
	 */
	private Integer id;
	
	/**
	 * ������id
	 */
	private Integer parentId;
	
	private List<Area> areaList=new ArrayList<Area>();
	
	
	public Area()
	{
		
	}
	
	public Area(String areaName)
	{
		this.areaName=areaName;
	}
	public String getAreaName()
	{
		return areaName;
	}

	public void setAreaName(String areaName)
	{
		this.areaName = areaName;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getParentId()
	{
		return parentId;
	}

	public void setParentId(Integer parentId)
	{
		this.parentId = parentId;
	}

	public List<Area> getAreaList()
	{
		return areaList;
	}

	public void setAreaList(List<Area> areaList)
	{
		this.areaList = areaList;
	}

	@Override
	public String toString()
	{
		return "Area [areaName=" + areaName + ", id=" + id + ", parentId="
				+ parentId + "]";
	}
	
	
	
	
}
