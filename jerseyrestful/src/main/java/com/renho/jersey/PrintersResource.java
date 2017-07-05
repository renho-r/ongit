package com.renho.jersey;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Singleton
@Path("/printers")
public class PrintersResource {
 
    @GET
    @Produces({"application/json", "application/xml"})
    public WebResourceList getMyResources() {
    	System.out.println("getMyResources");
    	return null;
    }
 
    @GET @Path("/list")
    @Produces({"application/json", "application/xml"})
    public WebResourceList getListOfPrinters() {
    	System.out.println("getListOfPrinters");
    	return null;
    }
 
    @GET @Path("/jMakiTable")
    @Produces("application/json")
    public PrinterTableModel getTable() {
    	System.out.println("getTable");
    	return null;
    }
 
    @GET @Path("/jMakiTree")
    @Produces("application/json")
    public TreeModel getTree() {
    	System.out.println("getTree");
    	return null;
    }
 
    @GET @Path("/ids/{printerid}")
    @Produces({"application/json", "application/xml"})
    public Printer getPrinter(@PathParam("printerid") String printerId) {
    	System.out.println("getPrinter:" + printerId);
    	return null;
    }
 
    @PUT @Path("/ids/{printerid}")
    @Consumes({"application/json", "application/xml"})
    public void putPrinter(@PathParam("printerid") String printerId, Printer printer) {
    	System.out.println("putPrinter:" + printerId);
    }
 
    @DELETE @Path("/ids/{printerid}")
    public void deletePrinter(@PathParam("printerid") String printerId) {
    	System.out.println("deletePrinter:" + printerId);
    }
}

class WebResourceList {
	
}

class PrinterTableModel {
	
}

class TreeModel {
	
}

class Printer {
	
}