package com.ge.power.suppliermultichain.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ge.power.suppliermultichain.amazons3.SupplierChainS3Service;
import com.ge.power.suppliermultichain.modelVO.SupplierinfoVO;
import com.ge.power.suppliermultichain.service.SupplierService;

@CrossOrigin
@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {
	
	
	   
	@Autowired
	SupplierService supplierService;
	
	@Autowired
	SupplierChainS3Service supplierS3Service;
	
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
	
	@RequestMapping(value = "/findSupplierByName/{suppName}", method = RequestMethod.GET , produces = "application/json")
	public @ResponseBody SupplierinfoVO findSupplierByName(@PathVariable String suppName ) throws Exception {
		return supplierService.findBySuppName(suppName);
	}
	
	@RequestMapping(value = "/findPendingApprovalSupp", method = RequestMethod.GET , produces = "application/json")
	public @ResponseBody List<SupplierinfoVO> findPendingApprovalSupp() throws Exception {
		return supplierService.findPendingApprovalSupp();
	}
	
	@RequestMapping(value = "/uploadDocument/{keyName}", method = RequestMethod.POST ,consumes = "multipart/form-data")
	public void uploadDocument(@PathVariable("keyName") String keyName,@RequestParam("file") MultipartFile uploadFile, @RequestParam("name") String name)  throws UnsupportedEncodingException{
		supplierS3Service.uploadFile(keyName, uploadFile);
	}
	
	@RequestMapping(value = "/downloadDocument/{keyName}", method = RequestMethod.GET, produces = "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
	public ResponseEntity<byte[]> downloadDocument(HttpServletResponse response, @PathVariable("keyName") String keyName) throws UnsupportedEncodingException{
		return supplierS3Service.downloadFile(response, keyName);
	}
	
	
	
}
