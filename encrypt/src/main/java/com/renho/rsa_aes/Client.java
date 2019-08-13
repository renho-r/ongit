package com.renho.rsa_aes;

import com.renho.aes.AESUtil;
import com.renho.rsa.RSAUtil;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.UUID;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class Client {

    public static void main(String[] args) throws Exception {

//        String sourceData = "renho";
//        String sourceData = UUID.randomUUID().toString();
        String sourceData = (new SimpleDateFormat("yyyyMMddHHmmss")).format(System.currentTimeMillis());
        //分段
//        String sourceData = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKXS00QQ7liQ34uU8nbwr4SBI0Ifceuw/uWvUGaGgxGklnEHouZrZF6QemIoZfQl8eb7wZhU/KDEsUPsxtIuIkRSLASZZxIEMukcu4fQ8lQ8he6sS3HMBrxrDsvtkR8vKQ89GpFhiARMq1+BessIBpy0d98fQ0QN+TeF0JEplkE/AgMBAAECgYAPKoscDJhgDVAEyiiq7DSBX/ZDk/CtZ9DIXRJzbhYKxQzlZZdmj6fsZjZrR9qbS+UmBRydvBgm9BZqaft9Oa70frD6irEO7hgB9LwKYCuEGvxm0rIl/2dFwa3qZ9L1cVQTnmYKsR47dlh2imCh+lsvT+o/idWhv0E/SgLloQwLcQJBAOt8CtURhvTwcRJ9UBDecVNqlh3NwZBrL1Ij3JI+jkfusX/j8i6J6Z1+XHX28G0Ma1zxkrajBJePsFM50r930SsCQQC0RSZIwBOYURLJfurzKagJHgCHRjjWKUv3tC2NfZAfSIFWo9NtCbJHI5P29uXWoqcWXm5m3hvj9kZlfY+Foz49AkEAugSAohN4YmDVUV/AMbMmHljiQKTatPSWqvI9OSFFT7lUacxs8Spsasb4zw7Emb/nx8HkvXVFGVyeUwAoZKuHhQJBAKT9fRKsqcKIwVcmEEfJ4n+ls/obbT2lwl/NyrtrJpNbOvVfL8zmSQMPLwej5axSZfb1Krp/oqs75iZRiyBWzkkCQBAIJnaSeQ0JL1JdgscJ0W+odvJp3/3dfAdqcAe2tRWTVToB1sgC4ascYXZ+alVz78JFIExM8kQw2FYkuZMcurw=";
        String aesKey = AESUtil.getRandomKey(128);
        System.out.printf("AES 秘钥: %s\n", aesKey);
        System.out.printf("原数据: %s\n\n", sourceData);

        String encryptAes = AESUtil.encrypt(sourceData, aesKey);
        System.out.printf("AES 加密后: %s\n\n", encryptAes);

        sourceData = encryptAes + "|" + aesKey;
        System.out.printf("原数据 | AES KEY处理后: %s\n\n", sourceData);

        System.out.printf("签名原数据: %s\n", sourceData);
        byte[] sign = RSAUtil.sign((PrivateKey) getPrivateKey(), sourceData.getBytes());
        String signStr = Base64.getEncoder().encodeToString(sign);
        System.out.printf("签名: %s\n\n", signStr);

        System.out.printf("RSA加密数据: %s\n", sourceData);
        byte[] encryptRsaByte = RSAUtil.encrypt(getPublicKey(), sourceData.getBytes());
        String encryptRsa = Base64.getEncoder().encodeToString(encryptRsaByte);
        System.out.printf("RSA加密后: %s\n\n", encryptRsa);

        byte[] decryptRsaByte = RSAUtil.decrypt(getPrivateKey(), encryptRsaByte);
        String decryptRsa = new String(decryptRsaByte);
        System.out.printf("RSA解密后: %s\n\n", decryptRsa);

        System.out.printf("验签原数据: %s\n", decryptRsa);
        System.out.printf("验签结果: %s\n\n", RSAUtil.verify((PublicKey) getPublicKey(), sign, decryptRsa.getBytes()));

        String decryptAes = AESUtil.decrypt(decryptRsa.split("\\|")[0], decryptRsa.split("\\|")[1]);
        System.out.printf("AES 解密后: %s\n", decryptAes);


    }

    public static Key getPublicKey() throws InvalidKeySpecException, NoSuchAlgorithmException {
        String publicRSAKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCl0tNEEO5YkN+LlPJ28K+EgSNCH3HrsP7lr1BmhoMRpJZxB6Lma2RekHpiKGX0JfHm+8GYVPygxLFD7MbSLiJEUiwEmWcSBDLpHLuH0PJUPIXurEtxzAa8aw7L7ZEfLykPPRqRYYgETKtfgXrLCAactHffH0NEDfk3hdCRKZZBPwIDAQAB";
        X509EncodedKeySpec pubX509 = new X509EncodedKeySpec(Base64.getDecoder().decode(publicRSAKey));
        KeyFactory keyFactory = KeyFactory.getInstance(RSAUtil.RSA_CRYPT_ALGORITHM_NAME);
        Key publicKey = keyFactory.generatePublic(pubX509);
        return publicKey;
    }

    public static Key getPrivateKey() throws InvalidKeySpecException, NoSuchAlgorithmException {
        String privateRSAKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKXS00QQ7liQ34uU8nbwr4SBI0Ifceuw/uWvUGaGgxGklnEHouZrZF6QemIoZfQl8eb7wZhU/KDEsUPsxtIuIkRSLASZZxIEMukcu4fQ8lQ8he6sS3HMBrxrDsvtkR8vKQ89GpFhiARMq1+BessIBpy0d98fQ0QN+TeF0JEplkE/AgMBAAECgYAPKoscDJhgDVAEyiiq7DSBX/ZDk/CtZ9DIXRJzbhYKxQzlZZdmj6fsZjZrR9qbS+UmBRydvBgm9BZqaft9Oa70frD6irEO7hgB9LwKYCuEGvxm0rIl/2dFwa3qZ9L1cVQTnmYKsR47dlh2imCh+lsvT+o/idWhv0E/SgLloQwLcQJBAOt8CtURhvTwcRJ9UBDecVNqlh3NwZBrL1Ij3JI+jkfusX/j8i6J6Z1+XHX28G0Ma1zxkrajBJePsFM50r930SsCQQC0RSZIwBOYURLJfurzKagJHgCHRjjWKUv3tC2NfZAfSIFWo9NtCbJHI5P29uXWoqcWXm5m3hvj9kZlfY+Foz49AkEAugSAohN4YmDVUV/AMbMmHljiQKTatPSWqvI9OSFFT7lUacxs8Spsasb4zw7Emb/nx8HkvXVFGVyeUwAoZKuHhQJBAKT9fRKsqcKIwVcmEEfJ4n+ls/obbT2lwl/NyrtrJpNbOvVfL8zmSQMPLwej5axSZfb1Krp/oqs75iZRiyBWzkkCQBAIJnaSeQ0JL1JdgscJ0W+odvJp3/3dfAdqcAe2tRWTVToB1sgC4ascYXZ+alVz78JFIExM8kQw2FYkuZMcurw=";
        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateRSAKey));
        KeyFactory keyFactory = KeyFactory.getInstance(RSAUtil.RSA_CRYPT_ALGORITHM_NAME);
        Key privateKey = keyFactory.generatePrivate(priPKCS8);
        return privateKey;
    }

}
