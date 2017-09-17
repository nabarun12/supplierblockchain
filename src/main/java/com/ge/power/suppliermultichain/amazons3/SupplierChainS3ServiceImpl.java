package com.ge.power.suppliermultichain.amazons3;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.Download;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;

@Service
public class SupplierChainS3ServiceImpl implements SupplierChainS3Service{
	
		protected Logger logger = LoggerFactory.getLogger(SupplierChainS3ServiceImpl.class);
		
		@Autowired
		protected TransferManager transferManager;
	 
		@Value("${s3.bucket}")
		protected String bucketName;
		
		@Value("${s3.key}")
		protected String keyName;
	 
		/**
		 * UPLOAD FILE to Amazon S3
		 */
		@Override
		public void uploadFile(String keyNameVal, MultipartFile multipartUp) {
		
			File uploadFile = new File(System.getProperty("java.io.tmpdir")+"/"+multipartUp.getOriginalFilename());
			try {
				multipartUp.transferTo(uploadFile);
				//uploadFile = new File("C:\\Users\\502439033\\Desktop\\Logic flow for Doc verification.docx");
			final PutObjectRequest request = new PutObjectRequest(bucketName, keyNameVal,uploadFile );
			
			
			request.setGeneralProgressListener(new ProgressListener() {
				@Override
				public void progressChanged(ProgressEvent progressEvent) {
					String transferredBytes = "Uploaded bytes: " + progressEvent.getBytesTransferred();
					logger.info(transferredBytes);
				}
			});
	 
			Upload upload = transferManager.upload(request);
			
			// Or you can block and wait for the upload to finish
			upload.waitForCompletion();
				
			} catch (AmazonServiceException e) {
				logger.info(e.getMessage());
			} catch (AmazonClientException e) {
				logger.info(e.getMessage());
			} catch (InterruptedException e) {
				logger.info(e.getMessage());
			} catch (IllegalStateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
	    
		}
		
		/**
		 * DOWNLOAD FILE from Amazon S3
		 */
		@Override
		public void downloadFile(HttpServletResponse response, String keyNameH) {
			
			String fileName = keyNameH;
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName); 
			
			final GetObjectRequest request = new GetObjectRequest(bucketName, keyNameH);
			
			request.setGeneralProgressListener(new ProgressListener() {
				@Override
				public void progressChanged(ProgressEvent progressEvent) {
					String transferredBytes = "Downloaded bytes: " + progressEvent.getBytesTransferred();
					logger.info(transferredBytes);
				}
			});
			
			File fileDownload = new File(fileName);
			Download download = transferManager.download(request, fileDownload);
			
			
			try {
				
				download.waitForCompletion();
				FileInputStream inStream  = new FileInputStream(fileDownload);
				OutputStream outputStream = response.getOutputStream();
				byte[] buffer = new byte[4096];
		        int bytesRead = -1;
		         
		        while ((bytesRead = inStream.read(buffer)) != -1) {
		        	outputStream.write(buffer, 0, bytesRead);
		        }
		         
		        inStream.close();
		        outputStream.close();
				
				
			} catch (AmazonServiceException e) {
				logger.info(e.getMessage());
			} catch (AmazonClientException e) {
				logger.info(e.getMessage());
			} catch (InterruptedException e) {
				logger.info(e.getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

}
