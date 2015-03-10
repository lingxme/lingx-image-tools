package com.lingx.tools;

import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptTools {
	private ScriptEngine engine;
	public ScriptTools() {
		ScriptEngineManager sem = new ScriptEngineManager();
		engine = sem.getEngineByName("JavaScript");
	}
	public void init(Map<String,Object> param){
		if (param == null)
			return;
		for (String key : param.keySet()) {
			engine.put(key, param.get(key));
		}
	}
	public Object exe(String script){
		try {
			return this.engine.eval(script);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String args[]){
		ScriptTools st=new ScriptTools();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("width", 25);
		st.init(map);
		System.out.println(st.exe("width/3*2"));
	}
}
