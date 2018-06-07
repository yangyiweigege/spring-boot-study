package com.weige.ssm.domain;
/**
 * <pre>
 * 功       能:返回状态枚举类 
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年3月9日 下午1:12:21
 * Q    Q: 2873824885
 * </pre>
 */
public enum ResultStatus{
	/**
	 * 枚举类型
	 */
	DATA_NOT_FIND("数据没有找到", 0), 
	SUCCESS("返回结果成功", 1),
	LACK_PARAM("缺乏基本参数", 2),
	DEFINE_ERROR("自定义错误", 12580),
	UNKNOW("出现未知错误", -1),
	ONLY_SMALL("你可能还在上小学", 100),
	ONLY_MIDDLE("你可能还在上中学", 101),
	ONLY_BIG("你可能还在上大学", 102),
	ILLEGAL_PARAM("参数不合法", 10)
	;

	/**
	 * 消息
	 */
	private String message;

	/**
	 * 状态码
	 */
	private Integer code;

	ResultStatus(String message, Integer code) {
		this.code = code;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public static void showAllType() {
		for (ResultStatus e : ResultStatus.values()) {  
			System.out.println(e.getMessage() + "  " + e.getCode());
		}  
	}
	
	
	/*public static void main(String[] args) {
		//ResultStatus.DATA_NOT_FIND.setCode(500);
		//System.out.println(ResultStatus.DATA_NOT_FIND.getCode());
		showAllType();
	}*/
}
