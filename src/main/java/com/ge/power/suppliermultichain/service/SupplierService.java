package com.ge.power.suppliermultichain.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ge.power.suppliermultichain.modelVO.SupplierinfoVO;

@Repository
@Component
public interface SupplierService {

	public void addSupplier(SupplierinfoVO SupplierVO);
	
	public List <SupplierinfoVO> findAllSuppliers();
	
	public List <SupplierinfoVO> updateSupplier(List <SupplierinfoVO> listSupplierVO);
	
	public List <SupplierinfoVO> deleteSuppliers(List<SupplierinfoVO> listSupplierVO);
	
	public void deleteAll();
	
	public SupplierinfoVO findByWalletAddress(String walletAddress);
	
}
