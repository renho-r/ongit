package com.renho.jersey.dynamicbinding;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("dynamicbinding/helloworld")
public class HelloWorldResource {
 
    @GET
    @Produces("text/plain")
    public String getHello() {
        return "Hello World!";
    }
 
    @GET
    @Path("too-much-data")
    public String getVeryLongString() {
    	String str = "very long string"; // very long string
    	for(int i=0; i<20; i++) {
    		str += str;
    	}
        return str;
    }
}