package com.aws.kms.demo.AwsKmsClientDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsKmsClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsKmsClientDemoApplication.class, args);

        String textToEncrypt = "ABCDEF";
        String encryptedResult = EncryptionClient.encryptText(textToEncrypt);
        EncryptionClient.decryptText(encryptedResult);
    }
}
