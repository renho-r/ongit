package com.renho.jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.renho.jersey.bean.User;

@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	
	@GET
	@Path("/{id}")  
	@Produces("application/json")
	public User getById(@PathParam("id") Integer id) {
		User user = new User();
		user.setId(id);
		user.setName("renho");
		return user ;
	}
}
