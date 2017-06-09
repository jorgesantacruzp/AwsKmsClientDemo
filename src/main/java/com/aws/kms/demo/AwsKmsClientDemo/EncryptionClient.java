package com.aws.kms.demo.AwsKmsClientDemo;

import com.amazonaws.services.kms.AWSKMSClient;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.services.kms.model.DecryptResult;
import com.amazonaws.services.kms.model.EncryptRequest;
import com.amazonaws.services.kms.model.EncryptResult;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class EncryptionClient {

    public static final String CHARSET_NAME = "ISO-8859-1";

    public static String encryptText(String textToEncrypt) {
        AWSKMSClient awskmsClient = new AWSKMSClient(new Credentials());

        ByteBuffer plainText = ByteBuffer.wrap(textToEncrypt.getBytes());
        String keyId = "awsKmsKeyId";
        EncryptRequest request = new EncryptRequest().withKeyId(keyId).withPlaintext(plainText);

        EncryptResult encryptResult = awskmsClient.encrypt(request);
        ByteBuffer cipherTextBlob = encryptResult.getCiphertextBlob();
        System.out.println("############ ENCRYPTED RESULT ################");
        String decodeByteBuffer = decodeByteBuffer(cipherTextBlob);
        System.out.println(decodeByteBuffer);

        return decodeByteBuffer;
    }

    public static String decryptText(String textToDecrypt) {
        AWSKMSClient awskmsClient = new AWSKMSClient(new Credentials());

        ByteBuffer ciphertextBlob = encodeToByteBuffer(textToDecrypt);
        DecryptRequest req = new DecryptRequest().withCiphertextBlob(ciphertextBlob);

        DecryptResult decryptResult = awskmsClient.decrypt(req);
        ByteBuffer byteBuffer = decryptResult.getPlaintext();

        System.out.println("############ DECRYPTED RESULT ################");
        String text = decodeByteBuffer(byteBuffer);
        System.out.println(text);

        return text;
    }

    private static String decodeByteBuffer(ByteBuffer byteBuffer) {
        Charset charset = Charset.forName(CHARSET_NAME);
        return charset.decode(byteBuffer).toString();
    }

    private static ByteBuffer encodeToByteBuffer(String text) {
        Charset charset = Charset.forName(CHARSET_NAME);
        return charset.encode(text);
    }

}
