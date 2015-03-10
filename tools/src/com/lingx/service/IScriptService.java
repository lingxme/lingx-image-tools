package com.lingx.service;

import java.util.Map;

public interface IScriptService {
	public void init(Map<String,Object> param);
	public Object exe(String script);
}
