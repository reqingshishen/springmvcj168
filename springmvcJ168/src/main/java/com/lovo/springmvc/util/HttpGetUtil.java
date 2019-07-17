package com.lovo.springmvc.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpGetUtil {
	
	public void client() {
	CloseableHttpClient httpClient = HttpClientBuilder.create().build();
	StringBuffer params = new StringBuffer();
	try {
		// 字符数据最好encoding以下;这样一来，某些特殊字符才能传过去(如:某人的名字就是“&”,不encoding的话,传不过去)
		params.append("name=" + URLEncoder.encode("&", "utf-8"));
		params.append("&");
		params.append("age=24");
	} catch (UnsupportedEncodingException e1) {
		e1.printStackTrace();
	}

	// 创建Get请求
	HttpGet httpGet = new HttpGet("http://localhost:12345/doGetControllerTwo" + "?" + params);
	// 响应模型
	CloseableHttpResponse response = null;
	try {
		// 配置信息
		RequestConfig requestConfig = RequestConfig.custom()
				// 设置连接超时时间(单位毫秒)
				.setConnectTimeout(5000)
				// 设置请求超时时间(单位毫秒)
				.setConnectionRequestTimeout(5000)
				// socket读写超时时间(单位毫秒)
				.setSocketTimeout(5000)
				// 设置是否允许重定向(默认为true)
				.setRedirectsEnabled(true).build();

		// 将上面的配置信息 运用到这个Get请求里
		httpGet.setConfig(requestConfig);

		// 由客户端执行(发送)Get请求
		response = httpClient.execute(httpGet);

		// 从响应模型中获取响应实体
		HttpEntity responseEntity = response.getEntity();
		System.out.println("响应状态为:" + response.getStatusLine());
		if (responseEntity != null) {
			System.out.println("响应内容长度为:" + responseEntity.getContentLength());
			System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			// 释放资源
			if (httpClient != null) {
				httpClient.close();
			}
			if (response != null) {
				response.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	}
}
