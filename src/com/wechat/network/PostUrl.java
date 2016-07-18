package com.wechat.network;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;


public class PostUrl {
	
	public static void httpPost(String url,Map<String,Object> propsMap){
		
		HttpClient httpClient=new HttpClient();
		PostMethod postMethod = new PostMethod(url);//POST请求
		
		//参数设置
		Set<String> keySet=propsMap.keySet();
		NameValuePair[] postData=new NameValuePair[keySet.size()];
		int index=0;
		for(String key:keySet){
			postData[index++]=new NameValuePair(key,propsMap.get(key).toString());
		}
		postMethod.addParameters(postData);
		
		try{
			httpClient.executeMethod(postMethod);//发送请求
		}catch (HttpException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			postMethod.releaseConnection();//关闭连接
		}
	}
}
