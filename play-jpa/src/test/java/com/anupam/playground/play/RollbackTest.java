package com.anupam.playground.play;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anupam.playground.gotchas.RollbackWithChkdException;

public class RollbackTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		RollbackWithChkdException rollBack = ctx.getBean(RollbackWithChkdException.class);
		rollBack.savesAddressCorrectly("pune", "kanpur");
	}
}
