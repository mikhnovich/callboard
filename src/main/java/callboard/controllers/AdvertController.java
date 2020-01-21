package callboard.controllers;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import callboard.domain.Advert;
import callboard.repositories.AdvertRepository;
import callboard.services.AdvertService;


@Path("/advert")
public class AdvertController
{
	AdvertService advertService;

	public AdvertController()
	{
		this.advertService = new AdvertService(new AdvertRepository());
	}

	@POST
	@Path("/user/{id}")
	public Response createAdvert(Advert advert, @PathParam("id") Long userId)
	{
		Advert createdAdvert = advertService.createAdvert(advert, userId);
		if (createdAdvert == null)
			return Response.status(Response.Status.BAD_REQUEST).build();
		return Response.accepted().entity(createdAdvert).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAdvert(@PathParam("id") Long id)
	{
		Advert advert = advertService.getAdvert(id);
		if (advert == null)
			return Response.status(Response.Status.BAD_REQUEST).build();
		return Response.accepted().entity(advert).build();
	}

	@DELETE
	@Path("/{id}")
	public void removeAdvert(@PathParam("id") Long id)
	{
		advertService.removeAdvert(id);
	}

	@GET
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAdvertsForUser(@PathParam("id") Long id)
	{
		return Response.ok().entity(advertService.getAllAdvertsForUser(id)).build();
	}
}
