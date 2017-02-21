package com.renho.jersey.namebinding;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("namebinding/helloworld")
public class HelloWorldResource {
 
    @GET
    @Produces("text/plain")
    public String getHello() {
        return "Hello World!";
    }
 
    @GET
    @Path("too-much-data")
    @Compress
    public String getVeryLongString() {
    	String str = "very long string"; // very long string
    	for(int i=0; i<20; i++) {
    		str += str;
    	}
        return str;
    }
}