package com.wechat.utils;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import net.sf.json.JSONObject;

public class StringToJsonStr {
	
	@Test
	public void test(){
		String s = "{\"CityId\":18,\"CityName\":\"西安\",\"ProvinceId\":27,\"CityOrder\":1}";
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("CityId",18);
		hm.put("CityName","西安");
		hm.put("ProvinceId",27);
		hm.put("CityOrder",1);
		
		System.out.println(hm);
		JSONObject result = new JSONObject().fromObject(s);
		System.out.println(result.get("CityName"));
		
		Assert.assertEquals("西安", result.get("CityName"));
		
	}
	
}
