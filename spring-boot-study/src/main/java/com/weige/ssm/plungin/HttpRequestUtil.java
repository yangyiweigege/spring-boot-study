package com.weige.ssm.plungin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

@Component
public class HttpRequestUtil {

	@Autowired
	private RestTemplate restTemplate;// 服务调用
	
	/**
	 *发送JSON请求 
	 */
	public JSONObject sendJSONRequest(String url, JSONObject param) {
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		HttpEntity<String> formEntity = new HttpEntity<String>(param.toString(), headers);
		JSONObject result = restTemplate.postForObject(url, formEntity, JSONObject.class);
		return result;
	}
}
