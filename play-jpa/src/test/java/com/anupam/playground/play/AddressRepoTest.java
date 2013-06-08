package com.anupam.playground.play;


import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anupam.playground.core.Address;
import com.anupam.playground.core.ShippingAddress;
import com.anupam.playground.repo.AddressRepository;
import com.anupam.playground.repo.AddressService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" })
@Transactional
public class AddressRepoTest {

	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		AddressRepository addRep = ctx.getBean(AddressRepository.class);
		AddressService addservice = ctx.getBean(AddressService.class);
		addservice.savesAddressCorrectly("pune","kanpur");
//		addservice.saveShippingAddress();
		
	}

}
