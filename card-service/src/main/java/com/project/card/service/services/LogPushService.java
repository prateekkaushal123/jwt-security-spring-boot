package com.project.card.service.services;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.project.card.service.entity.AmazonClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LogPushService {
	
	@Autowired
	private AmazonClient amazonClient;	
	
	
	@Scheduled(cron="0 1 10 * * *")
	public void moveLogsFromToS3() {
		AWSCredentials credentials = new BasicAWSCredentials(amazonClient.getAccessKey(),amazonClient.getSecretKey());	
		AmazonS3 s3client = AmazonS3ClientBuilder.standard()
				  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  .withRegion(Regions.US_EAST_1)
				  .build();
		try {
	        var logsDir = new File("./logs");
	        for (File logFile : logsDir.listFiles()) {
	            String fileName = logFile.getName();
	            if (fileName.endsWith(".log")) {

	                fileName = fileName.substring(0, fileName.length()-4);
		            fileName = "CardService/"+fileName + new Date() +".log";
		            log.info(fileName);

		            var request = new PutObjectRequest(amazonClient.getBucketName(), fileName, logFile);
		            var metadata = new ObjectMetadata();
		            metadata.setContentType("plain/text");
		            metadata.addUserMetadata("title", "someTitle");
		            request.setMetadata(metadata);
		            s3client.putObject(request);
		            var writer = new PrintWriter(logFile);
		            writer.print("");
		            writer.close();
	            }
	        }
	    } catch (Exception e) {
	        log.info("Error in moving log files! : {}", e);
	    }
	}
	
}
