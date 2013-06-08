package com.anupam.playground.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

public class AudienceAdvice implements MethodBeforeAdvice,AfterReturningAdvice , ThrowsAdvice {
	
	public Audience audience;
	
	public void setAudience(Audience audience){
		this.audience = audience;
	}
	
	public Audience getAudience(){
		return audience;
	}
	
	public AudienceAdvice(){
		System.out.println(" AudienceAdvice instantiated.... ");
	}
	public void before(Method method, Object[] args, Object target)  throws Throwable {
		System.out.println(" METHODS-BEFORE-ADVICE ");
		this.audience.takeSeats();
		this.audience.turnOffCellPhones();
	}
	
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target)  throws Throwable{
		System.out.println(" METHODS-AFTER-ADVICE ");
		this.audience.applause();
	}
	
	
	public void afterThrowing(Exception exception){
		System.out.println(" AFTER-THROWING ");
		System.out.println(exception.getMessage());
		this.audience.demandRefund();
	}
	
}
