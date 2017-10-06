package com.ge.power.suppliermultichain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ge.power.suppliermultichain.model.Supplierinfo;


public interface SupplierRepository extends JpaRepository<Supplierinfo, Integer> {
	
	
	@Override
	@Query("SELECT s FROM Supplierinfo s where s.isRegistered = 1")
	public List<Supplierinfo> findAll();
	
	public Supplierinfo findByWalletAddress(String walletAddress);
	
	public Supplierinfo findBySupplierName(String supplierName);
	
	@Query("SELECT s FROM Supplierinfo s where s.isRegistered = 0")
	public List<Supplierinfo> findAllPendingSuppliers();

}
