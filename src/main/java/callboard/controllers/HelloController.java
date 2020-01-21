package callboard.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import callboard.domain.User;
import callboard.repositories.UserRepository;
import callboard.services.UserService;


@Path("/user")
public class HelloController
{
	UserService userService;

	public HelloController()
	{
		this.userService = new UserService(new UserRepository());
	}

	@POST
	public Response createUser(User user)
	{
		User createdUser = userService.createUser(user);
		if (createdUser == null)
			return Response.status(Response.Status.BAD_REQUEST).build();
		return Response.accepted().entity(createdUser).build();
	}

	@GET
	@Path("/ping")
	public Response ping()
	{
		return Response.ok().entity("Service online").build();
	}

	@GET
	@Path("/get/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotification(@PathParam("name") String name)
	{
		return Response.ok().entity("Hello, " + name + "!").build();
	}
}
