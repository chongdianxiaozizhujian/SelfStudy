package com.yonyou.ajax.servlet;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;

public class GsonTest {

	@Test
	public void testJSON() {
		Map<String, String> map = new HashMap<>();
		map.put("userName", "���С��");
		map.put("age", "25");
		Gson gson = new Gson();
		String json = gson.toJson(map);
		System.out.println(json);
	}
}
