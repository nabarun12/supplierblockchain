package com.ge.power.suppliermultichain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ge.power.suppliermultichain.modelVO.SupplierinfoVO;
import com.ge.power.suppliermultichain.service.SupplierService;

@CrossOrigin
@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {
	
	
	   
	@Autowired
	SupplierService supplierService;
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET , produces = "application/json")
	public @ResponseBody List<SupplierinfoVO> findAllSuppliers() throws Exception {
		return supplierService.findAllSuppliers();
	}
	
	@RequestMapping(value = "/addSupplier", method = RequestMethod.POST , consumes = "application/json")
	public  @ResponseBody List <SupplierinfoVO> addSupplier(@RequestBody SupplierinfoVO supplierVO){
		supplierService.addSupplier(supplierVO);
		return supplierService.findAllSuppliers();
	}
	
	@RequestMapping(value = "/findSupplierByWallet/{walletAddress}", method = RequestMethod.GET , produces = "application/json")
	public @ResponseBody SupplierinfoVO findSupplierByWallet(@PathVariable String walletAddress ) throws Exception {
		return supplierService.findByWalletAddress(walletAddress);
	}
	
	
}
