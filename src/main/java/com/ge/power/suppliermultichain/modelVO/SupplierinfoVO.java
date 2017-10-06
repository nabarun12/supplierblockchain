package com.ge.power.suppliermultichain.modelVO;

import java.io.Serializable;

import javax.persistence.Column;

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
	
	
	private String comments;
	
	
	private String emailAddress;
	
	
	private String phoneNo;
	
	
	private Integer isAdmin;
	
	private Integer isRegistered;	
	
	private String key;
	
	public Integer getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}
	public Integer getIsRegistered() {
		return isRegistered;
	}
	public void setIsRegistered(Integer isRegistered) {
		this.isRegistered = isRegistered;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	

	public SupplierinfoVO(){};
	public SupplierinfoVO(Supplierinfo supplierInfo) {
		
		this.supplierId = supplierInfo.getSupplierId();
		this.supplierName = supplierInfo.getSupplierName();
		this.supplierAddress = supplierInfo.getSupplierAddress();
		this.supplierRating = supplierInfo.getSupplierRating();
		this.walletAddress = supplierInfo.getWalletAddress();
		this.comments = supplierInfo.getComments();
		this.emailAddress = supplierInfo.getEmailAddress();
		this.phoneNo = supplierInfo.getPhoneNo();
		this.isAdmin = supplierInfo.getIsAdmin();
		this.isRegistered = supplierInfo.getIsRegistered();
		this.key = supplierInfo.getKey();
		
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
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	
}