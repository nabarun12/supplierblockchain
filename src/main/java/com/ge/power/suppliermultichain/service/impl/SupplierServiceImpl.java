package com.ge.power.suppliermultichain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.power.suppliermultichain.model.Supplierinfo;
import com.ge.power.suppliermultichain.modelVO.SupplierinfoVO;
import com.ge.power.suppliermultichain.repository.impl.SuplierInfoRepositoryImpl;
import com.ge.power.suppliermultichain.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	SuplierInfoRepositoryImpl suplierInfoRepositoryImpl;
	
	@Override
	public void addSupplier(SupplierinfoVO supplierVO) {
		// TODO Auto-generated method stub
				
			Supplierinfo supplierInfo = new Supplierinfo(supplierVO);
			/*
			if(supplierVO.getSupplierId()!=null)
				supplierInfo = suplierInfoRepositoryImpl.findSupplier(supplierVO.getSupplierId());
			*/suplierInfoRepositoryImpl.save(supplierInfo);
			
			
	}

	@Override
	public List<SupplierinfoVO> findAllSuppliers() {
		List <Supplierinfo>listSupplierinfo = new ArrayList<Supplierinfo>();
		List <SupplierinfoVO>listSupplierinfoVo = new ArrayList<SupplierinfoVO>();
		listSupplierinfo= suplierInfoRepositoryImpl.findAllSuppliers();
		for(Supplierinfo supplierInfo : listSupplierinfo){
						
			SupplierinfoVO supplierinfoVo = new SupplierinfoVO(supplierInfo);
			listSupplierinfoVo.add(supplierinfoVo);
		}
		return listSupplierinfoVo;
		
	}
	
	@Override
	public SupplierinfoVO findByWalletAddress(String walletAddress){
		Supplierinfo supplierinfo;
		SupplierinfoVO SupplierinfoVo;
		supplierinfo = suplierInfoRepositoryImpl.findSupplierByWalletAddress(walletAddress);
		SupplierinfoVO supplierinfoVo = new SupplierinfoVO(supplierinfo);
		return supplierinfoVo;
		
	}
	
	@Override
	public SupplierinfoVO findBySuppName(String suppName){
		Supplierinfo supplierinfo;
		SupplierinfoVO SupplierinfoVo;
		supplierinfo = suplierInfoRepositoryImpl.findSupplierBySupplierName(suppName);
		SupplierinfoVO supplierinfoVo = new SupplierinfoVO(supplierinfo);
		return supplierinfoVo;
		
	}
	@Override
	public List<SupplierinfoVO> findPendingApprovalSupp() {
		List <Supplierinfo>listSupplierinfo = new ArrayList<Supplierinfo>();
		List <SupplierinfoVO>listSupplierinfoVo = new ArrayList<SupplierinfoVO>();
		listSupplierinfo= suplierInfoRepositoryImpl.findAllPendingSuppliers();
		for(Supplierinfo supplierInfo : listSupplierinfo){
						
			SupplierinfoVO supplierinfoVo = new SupplierinfoVO(supplierInfo);
			listSupplierinfoVo.add(supplierinfoVo);
		}
		return listSupplierinfoVo;
		
	}
	@Override
	public List<SupplierinfoVO> updateSupplier(List<SupplierinfoVO> listSupplierVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SupplierinfoVO> deleteSuppliers(List<SupplierinfoVO> listSupplierVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	

}
