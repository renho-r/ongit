package com.renho.dubbotest.service.impl;

import com.renho.dubbotest.domain.User;
import com.renho.dubbotest.service.ISayHelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("user")
public class SayHelloServiceImpl implements ISayHelloService {

	private static Logger logger = LoggerFactory.getLogger(SayHelloServiceImpl.class);

	@POST
	@Path("regist")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	@Override
	public String regist(User user) {
		logger.info("regist: " + user.toString());
		return "{\"id\": \"" + UUID.randomUUID().toString() + "\"}";
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	@Override
	public User getUser(@PathParam("id")String id) {
		logger.info("getUser: " + id);
		return new User(id, "renho", "addr-" + UUID.randomUUID().toString());
	}
}
