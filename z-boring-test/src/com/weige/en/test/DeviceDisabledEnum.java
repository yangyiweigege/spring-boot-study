package com.weige.en.test;

import java.util.EnumSet;
/**
 * <pre>
 * 功       能: 枚举
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2017年11月30日 下午4:33:38
 * Q    Q: 2873824885
 * </pre>
 */
public enum DeviceDisabledEnum {
	
	ENABLED("启用", 0),
	DISABLED("禁用", 1),
	TEST,
	;

	private String name;
	private Integer code;

	DeviceDisabledEnum(String name,  Integer code) {
		this.name = name;
		this.code = code;
	}
	
	DeviceDisabledEnum() {
	
	}
	
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	public static String getTypeName(Integer code) {
		if (code == null) {
			return null;
		}
		return null;
	}
	
	public static DeviceDisabledEnum getResult(Integer code) {
		switch (code) {
		case 1:
			return DeviceDisabledEnum.DISABLED;
		case 2:
			return DeviceDisabledEnum.ENABLED;
		default:
			return null;
		}
	}
	
	public static void iterateEnum() {
		EnumSet<DeviceDisabledEnum> currEnumSet = EnumSet.allOf(DeviceDisabledEnum.class);

        for (DeviceDisabledEnum aLightSetElement : currEnumSet) {

            System.out.println("当前EnumSet中数据为：" + aLightSetElement + "值" +aLightSetElement.getName());

        }
	}
	
}

