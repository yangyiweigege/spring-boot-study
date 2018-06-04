package com.weige.ssm.plungin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <pre>
 * 功       能: 校验实体Bean属性
 * 涉及版本: V2.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2017年10月19日 上午10:08:58
 * Q     Q: 2873824885
 * </pre>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckValue {
	public String value() default "";
}
