package com.ge.power.suppliermultichain.amazons3;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface SupplierChainS3Service {
	
	public void uploadFile(String keyName, MultipartFile uploadfile);
	public ResponseEntity<byte[]> downloadFile(HttpServletResponse response,String keyName);

}
