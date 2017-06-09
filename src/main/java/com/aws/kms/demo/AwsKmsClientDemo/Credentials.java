package com.aws.kms.demo.AwsKmsClientDemo;

import com.amazonaws.auth.AWSCredentials;

public class Credentials implements AWSCredentials {

    @Override
    public String getAWSAccessKeyId() {
        return "awsAccessKey";
    }

    @Override
    public String getAWSSecretKey() {
        return "awsSecretAccessKey";
    }
}
