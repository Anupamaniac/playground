package com.anupam.playground.play;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anupam.playground.core.Address;
import com.anupam.playground.gotchas.ReadOnly;

public class GotchaTest {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		ReadOnly readOnly = ctx.getBean(ReadOnly.class);
		Address a = readOnly.readOnlyByCity("pune");
		System.out.println("***"+a.getCity());
	}

}
