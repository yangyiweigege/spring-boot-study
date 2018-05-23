package com.weige.ssm.domain;

import com.weige.ssm.domain.ResultStatus;

/**
 * <pre>
 * 功       能: 自定义项目中出现的异常
 * 涉及版本: V3.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2018年3月9日 下午2:19:46
 * Q    Q: 2873824885
 * </pre>
 */
public class ProjectException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer code;
	
	
	public ProjectException(String message, Integer code) {
		super(message);
		this.code = code;
	}
	
	public ProjectException(ResultStatus resultStatus) {
		super(resultStatus.getMessage());
		this.code = resultStatus.getCode();
	}


	public Integer getCode() {
		return code;
	}


	public void setCode(Integer code) {
		this.code = code;
	}

	
}
