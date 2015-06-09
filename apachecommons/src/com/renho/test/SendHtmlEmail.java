package com.renho.test;

import java.io.File;
import java.net.MalformedURLException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class SendHtmlEmail {

	public static void main(String[] args) throws EmailException,
			MalformedURLException {
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.163.com");
		email.setSmtpPort(25);
		email.setAuthenticator(new DefaultAuthenticator("rho_i_xx@163.com",
				"password"));
		email.setSSLOnConnect(true);
		email.setFrom("rho_i_xx@163.com");
		email.setSubject("Test Html Mail");
		email.addTo("rho_i_xx@163.com");

		StringBuffer msg = new StringBuffer();
		msg.append("<html><body><div style='width: 200px; height: 200px; background-color: black;'></div>");
		
		File img = new File("D:/Uploaded/commons-logo.png");
		
		msg.append("<img src=cid:").append(email.embed(img)).append(">");
		msg.append("</body></html>");
		email.setHtmlMsg(msg.toString());

		email.send();
	}

}
