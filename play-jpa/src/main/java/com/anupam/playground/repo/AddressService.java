package com.anupam.playground.repo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anupam.playground.core.Address;
import com.anupam.playground.core.ShippingAddress;
import com.anupam.playground.util.TransactionIndicatingUtil;
@Service
@Transactional(readOnly=true)
public class AddressService {
	
	@Autowired
	public AddressRepository addRep; 
	public AddressRepository getAddRep() {
		return addRep;
	}
	public void setAddRep(AddressRepository addRep) {
		this.addRep = addRep;
	}
	@Autowired
	public ShippingAddressRepository addShipRep; 
	@Autowired
	public ShippingAddressService shipAddService;

	@Transactional(propagation=Propagation.SUPPORTS)
	public void savesAddressCorrectly(String oldCity,String newCity) throws Exception {
		Address a = addRep.findByCity(oldCity);
		a.setCity(newCity);
		modifyShippingAddressCorrectly(a);
		
		System.out.println("d"+a.getCity());
		String status = TransactionIndicatingUtil.getTransactionStatus(true);
		System.out.println("status---->"+status);
		addRep.save(a);
		throw new Exception();
		//
	}
//	@Transactional(propagation=Propagation.REQUIRED)
	public void modifyShippingAddressCorrectly(Address a) {
		//shipAddService.
		modifyShip(a);
	}
	
	private void modifyShip(Address a) {
		ShippingAddress sa = addShipRep.findOne(Long.valueOf(1));
		sa.setCity(a.getCity());
		addShipRep.save(sa);
	}
	
	public void saveShippingAddress(){
		ShippingAddress a = new ShippingAddress();
		a.setCity("ffww");
		a.setHouseNo("houseNo1");
		a.setState("fws");
		addShipRep.save(a);
	}
	public ShippingAddressRepository getAddShipRep() {
		return addShipRep;
	}
	public void setAddShipRep(ShippingAddressRepository addShipRep) {
		this.addShipRep = addShipRep;
	}
	public ShippingAddressService getShipAddService() {
		return shipAddService;
	}
	public void setShipAddService(ShippingAddressService shipAddService) {
		this.shipAddService = shipAddService;
	}

}
