package com.renho.test;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class SendWithAttachments {

	public static void main(String[] args) throws EmailException {
		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("D:/Uploaded/git.txt");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("renho_git");
		attachment.setName("git.txt");

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.163.com");
		email.setSmtpPort(25);
		email.setAuthenticator(new DefaultAuthenticator("rho_i_xx@163.com",
				"password"));
		email.setSSLOnConnect(true);
		email.addTo("rho_i_xx@163.com");
		email.setFrom("rho_i_xx@163.com", "Me");
		email.setSubject("The txt");
		email.setMsg("Here is the git.txt");

		email.attach(attachment);

		email.send();

	}
}
