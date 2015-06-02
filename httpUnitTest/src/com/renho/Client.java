package com.renho;

import java.io.IOException;

import org.xml.sax.SAXException;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class Client {

	public static void main(String[] args) throws IOException, SAXException {
		WebConversation wc = new WebConversation();
		String url="http://localhost:9090/testPhp/view/html/nojquery.html";
		WebRequest request = new GetMethodWebRequest( url );
		WebResponse response = wc.getResponse( request );
		WebLink httpunitLink = response.getFirstMatchingLink( WebLink.MATCH_CONTAINED_TEXT, "renho" );
		response = httpunitLink.click();
		System.out.println( "The HttpUnit main page '"+url+"' contains " + response.getLinks().length + " links" );
	}
}
