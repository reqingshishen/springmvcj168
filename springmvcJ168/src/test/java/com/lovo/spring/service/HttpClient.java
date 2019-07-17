package com.lovo.spring.service;

import com.lovo.springmvc.util.HttpGetUtil;

public class HttpClient {

	public static void main(String[] args) {
	String str=	HttpGetUtil.client("http://www.baidu.com");
	System.out.println(str);
	}
}
