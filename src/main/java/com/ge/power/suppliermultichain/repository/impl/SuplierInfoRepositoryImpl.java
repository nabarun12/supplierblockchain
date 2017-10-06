package com.ge.power.suppliermultichain.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.ge.power.suppliermultichain.model.Supplierinfo;
import com.ge.power.suppliermultichain.repository.SupplierRepository;

@Transactional
@Configuration
public class SuplierInfoRepositoryImpl {

	@Autowired
	SupplierRepository supplierRepo;

	public void save(Supplierinfo supplier) {
		supplierRepo.save(supplier);
	}
	
	public Supplierinfo findSupplier(Integer supplierId) {
		return supplierRepo.findOne(supplierId);
	}
	
	public Supplierinfo findSupplierByWalletAddress(String walletAddress) {
		return supplierRepo.findByWalletAddress(walletAddress);
	}
	
	public Supplierinfo findSupplierBySupplierName(String supplierName) {
		return supplierRepo.findBySupplierName(supplierName);
	}

	public List<Supplierinfo> findAllSuppliers() {
		return supplierRepo.findAll();
	}
	
	public List<Supplierinfo> findAllPendingSuppliers() {
		return supplierRepo.findAllPendingSuppliers();
	}

	public void deleteAllSuppliers() {
		supplierRepo.deleteAll();
	}

	public void deleteSupplier(Supplierinfo supplier) {
		supplierRepo.delete(supplier);
	}
	
	public void deleteSuppliers(List<Supplierinfo> supplierList) {
		supplierRepo.deleteInBatch(supplierList);
	}
}
