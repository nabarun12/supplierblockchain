
package com.ge.power.suppliermultichain.amazons3;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.transfer.Download;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;

@Service
public class SupplierChainS3ServiceImpl implements SupplierChainS3Service{
	
		protected Logger logger = LoggerFactory.getLogger(SupplierChainS3ServiceImpl.class);
		
		@Autowired
		protected TransferManager transferManager;
		
		@Autowired
		protected AmazonS3 s3Client;
	 
		@Value("${s3.bucket}")
		protected String bucketName;
		
		@Value("${s3.key}")
		protected String keyName;
	 
		/**
		 * UPLOAD FILE to Amazon S3
		 */
		@Override
		public void uploadFile(String keyNameVal, MultipartFile multipartUp) {
		
			
			try {
				
				
			final PutObjectRequest request = new PutObjectRequest(bucketName,keyNameVal, multipartUp.getInputStream(),new ObjectMetadata());
			 request.setCannedAcl(CannedAccessControlList.PublicRead);
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
			
			IOUtils.closeQuietly(multipartUp.getInputStream());
			
					
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
		public ResponseEntity<byte[]> downloadFile(HttpServletResponse response, String keyNameH) {
			
			GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, keyNameH);
			S3Object s3Object = s3Client.getObject(getObjectRequest);

	        S3ObjectInputStream objectInputStream = s3Object.getObjectContent();

	        byte[] bytes = new byte[100000];
			try {
				bytes = IOUtils.toByteArray(objectInputStream);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	        String fileName="";
			try {
				fileName = URLEncoder.encode(keyNameH, "UTF-8").replaceAll("\\+", "%20");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			/*response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName); */
	        HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        httpHeaders.setContentLength(bytes.length);
	        httpHeaders.setContentDispositionFormData("attachment", fileName);
			
			try {
		

	       // return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);
	        getObjectRequest.setGeneralProgressListener(new ProgressListener() {
				@Override
				public void progressChanged(ProgressEvent progressEvent) {
					String transferredBytes = "Downloaded bytes: " + progressEvent.getBytesTransferred();
					logger.info(transferredBytes);
				}
			});
			
				
				
				
			} catch (AmazonServiceException e) {
				logger.info(e.getMessage());
			} catch (AmazonClientException e) {
				logger.info(e.getMessage());
			}
			
			return new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);
		}

}