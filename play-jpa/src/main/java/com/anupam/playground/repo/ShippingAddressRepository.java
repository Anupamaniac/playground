package com.anupam.playground.repo;

import org.springframework.data.repository.CrudRepository;

import com.anupam.playground.core.ShippingAddress;

public interface ShippingAddressRepository extends CrudRepository<ShippingAddress, Long> {

}
