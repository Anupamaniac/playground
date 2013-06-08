package com.anupam.playground.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

//	 public static void main(String[] args) {
//		   
//	      ProxyFactory factory = new ProxyFactory(new SimplePojo());
//	      factory.addInterface(Pojo.class);
//	      factory.addAdvice(new RetryAdvice());
//
//	      Pojo pojo = (Pojo) factory.getProxy();
//	      
//	      // this is a method call on the proxy!
//	      pojo.foo();
//	   }

	 public static void main(String [] args){
			ApplicationContext applicationContext = null;
			Performer obj = null;
			boolean bb = (args != null && args.length > 0 && args[0].equals("true")) ? true : false; 
			try{
				applicationContext = new ClassPathXmlApplicationContext("aop-context.xml");			
				obj = (Performer) applicationContext.getBean("performer");		
				obj.performerAppearsOnStage();
				obj.perform();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
}
class SimplePojo implements Pojo {

	   public void foo() {
	      // this next method invocation is a direct call on the 'this' reference
	      this.bar();
	   }
	   
	   public void bar() {
	      // some logic...
	   }
	}
interface Pojo{

	void foo();
	
}