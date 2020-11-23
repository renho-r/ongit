package com.renho.test.mybatisplus.common.ext.idgenerator.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class IpAddressUtils {

	    public static final String INTRANET_IP = getIntranetIp(); // 内网IP
	    public static final String INTERNET_IP = getInternetIp(); // 外网IP
	    public static final byte[] INTERNET_IP_BYTES = getInternetIpBytes();//外网ip字节数组
	    public static final byte[] INTRANET_IP_BYTES = getIntranetIpBytes(); // 内网IP字节数组

	  

	    /**
	     * 获得内网IP
	     * @return 内网IP
	     */
	    private static String getIntranetIp(){
	        try{
	            return InetAddress.getLocalHost().getHostAddress();
	        } catch(Exception e){
	            throw new RuntimeException(e);
	        }
	    }

	    /**
	     * 获得外网IP
	     * @return 外网IP
	     */
	    private static String getInternetIp(){
	        try{
	            Enumeration<NetworkInterface> networks = NetworkInterface.getNetworkInterfaces();
	            InetAddress ip = null;
	            Enumeration<InetAddress> addrs;
	            while (networks.hasMoreElements())
	            {
	                addrs = networks.nextElement().getInetAddresses();
	                while (addrs.hasMoreElements())
	                {
	                    ip = addrs.nextElement();
	                    if (ip != null
	                            && ip instanceof Inet4Address
	                            && ip.isSiteLocalAddress()
	                            && !ip.getHostAddress().equals(INTRANET_IP))
	                    {
	                        return ip.getHostAddress();
	                    }
	                }
	            }

	            // 如果没有外网IP，就返回内网IP
	            return INTRANET_IP;
	        } catch(Exception e){
	            throw new RuntimeException(e);
	        }
	    }

	    /**
	     * 获得外网IP
	     * @return 外网IP
	     */
	    private static byte[] getInternetIpBytes(){
	        return ipv4Address2BinaryArray(getInternetIp());
	    }

	    /**
	     * 获取内网ip
	     * @return
	     */
	    private static byte[] getIntranetIpBytes() {
	        return ipv4Address2BinaryArray(getIntranetIp());
	    }

	    /**
	     * 将给定的用十进制分段格式表示的ipv4地址字符串转换成字节数组
	     * @param ipAdd
	     * @return
	     */
	    private static byte[] ipv4Address2BinaryArray(String ipAdd){
	        byte[] binIP = new byte[4];
	        String[] strs = ipAdd.split("\\.");
	        for(int i=0;i<strs.length;i++){
	            binIP[i] = (byte) Integer.parseInt(strs[i]);
	        }
	        return binIP;
	    }

	    public static void main(String[] args) {
	      
	        System.out.println(INTERNET_IP);
	        
	    }

}
 
