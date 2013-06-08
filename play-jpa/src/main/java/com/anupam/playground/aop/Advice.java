package com.anupam.playground.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class Advice implements MethodBeforeAdvice,AfterReturningAdvice , ThrowsAdvice {
public Audience audience;
	
	public void setAudience(Audience audience){
		this.audience = audience;
	}
	
	public Audience getAudience(){
		return audience;
	}

	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		this.audience.applause();		
	}
}
