package com.weige.ssm.domain;
/**
 * <pre>
 * 功       能:用于分析返回结果 http
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年3月9日 下午1:01:09
 * Q    Q: 2873824885
 * </pre>
 */
public class Result<T> {
	/**
	 * 状态码
	 */
	private Integer code;
	
	/**
	 * 返回消息
	 */
	private String message;
	
	/**
	 * 具体内容
	 */
	private T data;
	
	public Result() {
		
	}

	public Integer getCode() {
		return code;
	}


	public String getMessage() {
		return message;
	}

	public Result<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public T getData() {
		return data;
	}

	public Result<T> setData(T data) {
		this.data = data;
		return this;
	}
	
	public Result<T> setCode(ResultStatus resultStatus) {
		this.code = resultStatus.getCode();
		this.message = resultStatus.getMessage();
		return this;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", message=" + message + ", data=" + data + "]";
	}
	
	
}
