package com.ge.power.suppliermultichain.amazons3;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public interface SupplierChainS3Service {
	
	public void uploadFile(String keyName, MultipartFile uploadfile);
	public void downloadFile(HttpServletResponse response,String keyName);

}
