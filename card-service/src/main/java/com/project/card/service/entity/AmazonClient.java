package com.project.card.service.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import lombok.Data;

/**
 * @author lak1
 *
 * Class to store the s3 bucket(for logs) details and credentials 
 */

@Data
@Service
public class AmazonClient {
	@Value("${amazonProperties.endpointUrl}")
    private String endpointUrl;
	
    @Value("${amazonProperties.bucketName}")
    private String bucketName;
    
    @Value("${amazonProperties.accessKey}")
    private String accessKey;
    
    @Value("${amazonProperties.secretKey}")
    private String secretKey;
}