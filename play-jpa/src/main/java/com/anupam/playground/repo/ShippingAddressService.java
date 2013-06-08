package com.anupam.playground.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anupam.playground.core.ShippingAddress;
@Service
public class ShippingAddressService {

	@Autowired
	public ShippingAddressRepository addShipRep; 
	public ShippingAddressRepository getAddShipRep() {
		return addShipRep;
	}
	public void setAddShipRep(ShippingAddressRepository addShipRep) {
		this.addShipRep = addShipRep;
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void modifyShip() {
		ShippingAddress sa = addShipRep.findOne(Long.valueOf(1));
		sa.setCity("p");
		addShipRep.save(sa);
	}
}
