package com.renho.rsa;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.crypto.Cipher;

/**
 * RSA 工具类。提供加密，解密，签名，生成密钥对等方法。
 */

public final class RSAUtil {
    public static final String RSA_CRYPT_ALGORITHM_NAME = "RSA";

    public static final String RSA_SIGN_ALGORITHM_NAME = "MD5withRSA";

    private static final int RSA_KEY_LENGTH = 1024;

    /**
     * 生成密钥对
     *
     * @return KeyPair
     */

    private static KeyPair generateKeyPair() throws Exception {
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator
                    .getInstance(RSA_CRYPT_ALGORITHM_NAME);
            // 块加密的大小，值太大会影响效率
            final int KEY_SIZE = RSA_KEY_LENGTH;
            //这里的种子一定要随机，不然会产生相同的key，就没有安全性可言了。。。
            SecureRandom secrand = new SecureRandom();
            // 初始化随机产生器
            secrand.setSeed(RandomUtils.generateString(RSA_KEY_LENGTH).getBytes());
            keyPairGen.initialize(KEY_SIZE, secrand);
            KeyPair keyPair = keyPairGen.genKeyPair();
            return keyPair;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 生产RSA密钥对，并且保存到文件中
     */
    public static Map<String, String> keyRSA()
            throws Exception {
        KeyPair kp = generateKeyPair();
        // 获取公钥
        PublicKey pubkey = kp.getPublic();
        // 获取私钥
        PrivateKey prikey = kp.getPrivate();
        byte[] pubKeyBytes = pubkey.getEncoded();
        byte[] priKeyBytes = prikey.getEncoded();
        Map<String, String> keys = new HashMap<>();
        keys.put("public", Base64.getEncoder().encodeToString(pubKeyBytes));
        keys.put("private", Base64.getEncoder().encodeToString(priKeyBytes));
        return keys;
    }

    public static PublicKey generateRSAPublicKey(String publicKey) throws Exception {
        return generateRSAPublicKey(Base64.getDecoder().decode(publicKey));
    }

    /**
     * 生成公钥
     *
     * @return
     * @throws Exception
     */
    public static PublicKey generateRSAPublicKey(byte[] pubKeyByte) throws Exception {
        byte[] encodedKey = pubKeyByte;
        X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(encodedKey);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_CRYPT_ALGORITHM_NAME);
        return keyFactory.generatePublic(bobPubKeySpec);
    }

    public static PrivateKey generateRSAPrivateKey(String privateKey) throws Exception {
        return generateRSAPrivateKey(Base64.getDecoder().decode(privateKey));
    }

    /**
     * 生产私钥
     *
     * @param priKeyByte
     * @return
     * @throws Exception
     */
    public static PrivateKey generateRSAPrivateKey(byte[] priKeyByte) throws Exception {
        byte[] encodedKey = priKeyByte;
        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(encodedKey);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_CRYPT_ALGORITHM_NAME);
        return keyFactory.generatePrivate(priPKCS8);
    }

    /**
     * 加密
     *
     * @param key  加密的密钥
     * @param data 待加密的明文数据
     * @return 加密后的数据
     */
    public static byte[] encrypt(Key key, byte[] data) throws Exception {
        if (key != null) {
            try {
                Cipher cipher = Cipher.getInstance(RSA_CRYPT_ALGORITHM_NAME);
                cipher.init(Cipher.ENCRYPT_MODE, key);
                return cipher.doFinal(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 解密
     *
     * @param key        解密的密钥
     * @return 解密后的明文
     */
    public static byte[] decrypt(Key key, byte[] raw) throws Exception {
        if (key != null) {
            try {
                Cipher cipher = Cipher.getInstance(RSA_CRYPT_ALGORITHM_NAME);
                cipher.init(Cipher.DECRYPT_MODE, key);
                return cipher.doFinal(raw);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;

    }

    /**
     * 签名
     *
     * @param privateKey
     * @param data
     * @return
     */
    public static byte[] sign(PrivateKey privateKey, byte[] data)
            throws Exception {
        try {
            // 用私钥对信息生成数字签名
            Signature signet = Signature.getInstance(RSA_SIGN_ALGORITHM_NAME);
            signet.initSign(privateKey);
            signet.update(data);
            // 对信息的数字签名
            byte[] signed = signet.sign();
            return signed;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * 验证签名是否正确
     *
     * @param publicKey
     * @param signed
     * @param orig
     * @return
     */
    public static boolean verify(PublicKey publicKey, byte[] signed, byte[] orig)
            throws Exception {
        try {
            Signature signetcheck = Signature.getInstance(RSA_SIGN_ALGORITHM_NAME);
            signetcheck.initVerify(publicKey);
            signetcheck.update(orig);
            if (signetcheck.verify(signed)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    public static void main(String[] args) throws Exception {
        Map<String, String> keys = RSAUtil.keyRSA();
        System.out.printf("public: %s\n", keys.get("public"));
        System.out.printf("private: %s\n", keys.get("private"));

        String str = "renho";
        byte[] strByte = str.getBytes();
        System.out.println("原字符串：" + str);

        X509EncodedKeySpec pubX509 = new X509EncodedKeySpec(Base64.getDecoder().decode(keys.get("public")));
        KeyFactory keyFactory = KeyFactory.getInstance(RSA_CRYPT_ALGORITHM_NAME);
        Key publicKey = keyFactory.generatePublic(pubX509);

        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(keys.get("private")));
        Key privateKey = keyFactory.generatePrivate(priPKCS8);

        byte[] encrypt = RSAUtil.encrypt(publicKey, strByte);

        System.out.printf("encrypt: %s\n", Base64.getEncoder().encodeToString(encrypt));

        byte[] decrypt = RSAUtil.decrypt(privateKey, encrypt);
        System.out.printf("decrypt: %s\n", new String(decrypt));

        byte[] sign = RSAUtil.sign((PrivateKey) privateKey, strByte);
        System.out.println("原字符串验证签名：" + RSAUtil.verify((PublicKey) publicKey, sign, strByte));
        System.out.println("随机字符串验证签名：" + RSAUtil.verify((PublicKey) publicKey, sign, RandomUtils.generateString(20).getBytes()));
    }

}

class RandomUtils {
    public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 返回一个定长的随机字符串(只包含大小写字母、数字)
     *
     * @param length 随机字符串长度
     * @return 随机字符串
     */
    public static String generateString(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(allChar.charAt(random.nextInt(allChar.length())));
        }
        return sb.toString();
    }
}
