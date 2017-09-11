package com.ge.power.suppliermultichain.modelVO;

import java.io.Serializable;

import com.ge.power.suppliermultichain.model.Supplierinfo;


/**
 * The persistent class for the supplierinfo database table.
 * 
 */

public class SupplierinfoVO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer supplierId;

	
	private String supplierAddress;

	
	private String supplierName;

	
	private Integer supplierRating;

	
	private String walletAddress;

	public SupplierinfoVO(){};
	public SupplierinfoVO(Supplierinfo supplierInfo) {
		
		this.supplierId = supplierInfo.getSupplierId();
		this.supplierName = supplierInfo.getSupplierName();
		this.supplierAddress = supplierInfo.getSupplierAddress();
		this.supplierRating = supplierInfo.getSupplierRating();
		this.walletAddress = supplierInfo.getWalletAddress();
		
		
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Integer getSupplierRating() {
		return supplierRating;
	}

	public void setSupplierRating(Integer supplierRating) {
		this.supplierRating = supplierRating;
	}

	public String getWalletAddress() {
		return walletAddress;
	}

	public void setWalletAddress(String walletAddress) {
		this.walletAddress = walletAddress;
	}

	
}