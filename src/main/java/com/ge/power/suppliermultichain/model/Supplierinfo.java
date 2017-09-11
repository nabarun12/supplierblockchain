package com.ge.power.suppliermultichain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import com.ge.power.suppliermultichain.modelVO.SupplierinfoVO;


/**
 * The persistent class for the supplierinfo database table.
 * 
 */
@Entity
@NamedQuery(name="Supplierinfo.findAll", query="SELECT s FROM Supplierinfo s")
public class Supplierinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "supplier_seq" , sequenceName="supplier_seq" ,initialValue = 2, allocationSize=1 )
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "supplier_seq")
	@Column(name="supplier_id")
	private Integer supplierId;

	@Column(name="supplier_address")
	private String supplierAddress;

	@Column(name="supplier_name")
	private String supplierName;

	@Column(name="supplier_rating")
	private Integer supplierRating;

	@Column(name="wallet_address")
	private String walletAddress;

	public Supplierinfo(){};
	public Supplierinfo(SupplierinfoVO supplierInfoVO) {
		this.supplierId = supplierInfoVO.getSupplierId();
		this.supplierName = supplierInfoVO.getSupplierName();
		this.supplierAddress = supplierInfoVO.getSupplierAddress();
		this.supplierRating = supplierInfoVO.getSupplierRating();
		this.walletAddress = supplierInfoVO.getWalletAddress();
		
	}

	public Integer getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierAddress() {
		return this.supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Integer getSupplierRating() {
		return this.supplierRating;
	}

	public void setSupplierRating(Integer supplierRating) {
		this.supplierRating = supplierRating;
	}

	public String getWalletAddress() {
		return this.walletAddress;
	}

	public void setWalletAddress(String walletAddress) {
		this.walletAddress = walletAddress;
	}

}