package com.lingx.service.impl;

import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.lingx.service.IScriptService;

public class ScriptServiceImpl implements IScriptService {

	private ScriptEngine engine;

	public ScriptServiceImpl() {
		ScriptEngineManager sem = new ScriptEngineManager();
		engine = sem.getEngineByName("JavaScript");
	}

	public void init(Map<String, Object> param) {
		if (param == null)
			return;
		for (String key : param.keySet()) {
			engine.put(key, param.get(key));
		}
	}

	public Object exe(String script) {
		try {
			return this.engine.eval(script);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
