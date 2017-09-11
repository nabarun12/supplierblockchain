package com.ge.power.suppliermultichain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ge.power.suppliermultichain.model.Supplierinfo;


public interface SupplierRepository extends JpaRepository<Supplierinfo, Integer> {
	
	public Supplierinfo findByWalletAddress(String walletAddress);

}
