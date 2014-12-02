package com.zetauma.complainloudly.ws.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.zetauma.complainloudly.ws.controller.ComplaintController;

@Path("/complaint")
public class ComplaintResource {
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public String getComplaint() {
		Gson gson = new Gson();
		return gson.toJson(new ComplaintController().list());
	}
}
