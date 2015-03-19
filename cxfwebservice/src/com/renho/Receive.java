package com.renho;

import javax.jws.WebService;

@WebService
public interface Receive {
	public String sendXML(String text);
}
