package com.renho.des;

import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * Des加解密工具类
 *
 * @author Lee
 */
public class DesUtil {

//private  final byte[] DESkey = lmkProperties.getDesKey().getBytes();// 设置密钥，略去
//private  final byte[] DESkey = "abcdefgh".getBytes();// 设置密钥，略去  至少8位

//bbbb：偏移量
//private  final byte[] DESIV = lmkProperties.getDesIv().getBytes();// 设置向量，略去
//private  final byte[] DESIV = "12345678".getBytes();// 设置向量，略去  至少8位

    // 加密算法的参数接口，IvParameterSpec是它的一个实现
    static AlgorithmParameterSpec iv = null;
    private static SecretKey key = null;

    /**
     * 实例化
     *
     * @param desKey 秘钥
     * @param desIv  偏移量
     * @throws Exception
     */
    public DesUtil(String desKey, String desIv) throws Exception {
        byte[] DESkey = desKey.getBytes();
        byte[] DESIV = desIv.getBytes();
        // 设置密钥参数
        DESKeySpec keySpec = new DESKeySpec(DESkey);
        // 设置向量
        iv = new IvParameterSpec(DESIV);
        // 获得密钥工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 得到密钥对象
        key = keyFactory.generateSecret(keySpec);
    }

    /**
     * 加密
     *
     * @param data 待加密的数据
     * @return 加密后的数据
     * @throws Exception
     */
    public String encode(String data) throws Exception {
        // 得到加密对象Cipher
        Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        // 设置工作模式为加密模式，给出密钥和向量
        enCipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] pasByte = enCipher.doFinal(data.getBytes("utf-8"));
        //BASE64Encoder base64Encoder = new BASE64Encoder();
        return Base64.getEncoder().encodeToString(pasByte);
        //return base64Encoder.encode(pasByte);
    }

    /**
     * 解密
     *
     * @param data 解密前的数据
     * @return 解密后的数据
     * @throws Exception
     */
    public String decode(String data) throws Exception {
        Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        deCipher.init(Cipher.DECRYPT_MODE, key, iv);
        //BASE64Decoder base64Decoder = new BASE64Decoder();
        //byte[] pasByte = deCipher.doFinal(base64Decoder.decodeBuffer(data));
        byte[] pasByte = deCipher.doFinal(Base64.getDecoder().decode(data));
        return new String(pasByte, "UTF-8");
    }

    public static void main(String[] args) throws Exception {
        DesUtil tools = new DesUtil("abcdefgh", "12345678");
        String data = "renho";
        System.out.println("加密:" + tools.encode(data));

        String data1 = tools.encode(data);

        System.out.println("解密:" + tools.decode(data1));
    }


}
