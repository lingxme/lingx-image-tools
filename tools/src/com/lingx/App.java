package com.lingx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lingx.service.IAppService;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		IAppService app=ctx.getBean(IAppService.class);
		app.handler(args);
	}

}
