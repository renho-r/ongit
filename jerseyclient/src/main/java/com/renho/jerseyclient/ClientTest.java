package com.renho.jerseyclient;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.SslConfigurator;
import org.glassfish.jersey.client.ClientConfig;

import com.renho.jerseyclient.bean.User;

public class ClientTest {
	public static void main(String[] args) {
//		Client client = ClientBuilder.newClient();
//		WebTarget target = client.target("http://localhost:8080/jerseyrestful/").path("user/1");
//		
//		User bean = target.register(User.class).request(MediaType.APPLICATION_JSON_TYPE).get(User.class);// .post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE), User.class);
//		System.out.println(bean.getName());
		
		
		SslConfigurator sslConfig = SslConfigurator.newInstance()
		        .trustStoreFile("/Users/renho/software/apache-tomcat-9.0.0.M17/client.keystore")
		        .trustStorePassword("123456")
		        .keyStoreFile("/Users/renho/software/apache-tomcat-9.0.0.M17/client.keystore")
		        .keyPassword("123456");
		 
		SSLContext sslContext = sslConfig.createSSLContext();
		Client client = ClientBuilder.newBuilder().sslContext(sslContext).build();
		WebTarget target = client.target("http://localhost:8080/jerseyrestful/").path("user/1");		
		User bean = target.register(User.class).request(MediaType.APPLICATION_JSON_TYPE).get(User.class);// .post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE), User.class);
		System.out.println(bean.getName());
	}
	
}
