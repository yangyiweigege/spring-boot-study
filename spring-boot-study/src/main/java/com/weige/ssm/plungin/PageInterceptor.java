package com.weige.ssm.plungin;

import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;


/**
 * <pre>
 * 功       能:分页拦截器 
 * 涉及版本: V2.0.0 
 * 创  建  者: yangyiwei
 * 日       期: 2017年10月19日 上午9:25:33
 * Q     Q: 2873824885
 * </pre>
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = {
	Connection.class, Integer.class }) })
public class PageInterceptor implements Interceptor {

    @SuppressWarnings("unchecked")
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
	StatementHandler statementHandler = (StatementHandler) invocation
		.getTarget();
	MetaObject metaObject = MetaObject.forObject(statementHandler,
		SystemMetaObject.DEFAULT_OBJECT_FACTORY,
		SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,
		new DefaultReflectorFactory());
	MappedStatement mappedStatement = (MappedStatement) metaObject
		.getValue("delegate.mappedStatement");
	String id = mappedStatement.getId();
	if (id.matches(".+Page$")) {
	    System.out.println("执行到分页拦截器");
	    BoundSql boundSql = statementHandler.getBoundSql();
	    // 获取原始sql
	    String sql = boundSql.getSql();
	    // 查询数量sql
	    String countSql = "select count(1) from (" + sql + ") a ";
	    Connection connection = (Connection) invocation.getArgs()[0];
	    PreparedStatement countStatement = (PreparedStatement) connection
		    .prepareStatement(countSql);
	    ParameterHandler parameterHandler = (ParameterHandler) metaObject
		    .getValue("delegate.parameterHandler");
	    parameterHandler.setParameters(countStatement);
	    ResultSet rs = countStatement.executeQuery();
	    Map<String, Object> dataMap = (Map<String, Object>) boundSql
		    .getParameterObject();
	    if (rs.next()) {
		dataMap.put("count", rs.getInt(1));
	    }
	    int start = (Integer) dataMap.get("start");
	    int pageSize = (Integer) dataMap.get("pageSize");
	    String pageSql = sql + " LIMIT " + start + " , " + pageSize;
	    metaObject.setValue("delegate.boundSql.sql", pageSql);
	}
	return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
	return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties arg0) {

    }

}
