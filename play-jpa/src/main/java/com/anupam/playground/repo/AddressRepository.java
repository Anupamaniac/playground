package com.anupam.playground.repo;

import org.springframework.data.repository.CrudRepository;
import com.anupam.playground.core.Address;


public interface AddressRepository extends CrudRepository<Address,Long> {

	Address findByCity(String city);

}
