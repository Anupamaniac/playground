package com.anupam.playground.gotchas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anupam.playground.repo.AddressService;
@Service
public class RollbackWithChkdException {
	
	@Autowired
	AddressService addressService;

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void savesAddressCorrectly(String oldCity,String newCity) throws Exception{
		try {
			addressService.savesAddressCorrectly(oldCity, newCity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
}
