package com.anupam.playground.gotchas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anupam.playground.core.Address;
import com.anupam.playground.repo.AddressRepository;
import com.anupam.playground.repo.ShippingAddressRepository;

@Service
public class ReadOnly {
	
	@Autowired
	public AddressRepository addRep; 
	public AddressRepository getAddRep() {
		return addRep;
	}
	public void setAddRep(AddressRepository addRep) {
		this.addRep = addRep;
	}
	
	@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
	public Address readOnlyByCity(String city){
		Address readAddress = addRep.findByCity(city);
		attempUpdate(readAddress);
		return readAddress;
	}
	private void attempUpdate(Address readAddress) {
		readAddress.setCity("chennai");
		addRep.save(readAddress);
	}
	
}
