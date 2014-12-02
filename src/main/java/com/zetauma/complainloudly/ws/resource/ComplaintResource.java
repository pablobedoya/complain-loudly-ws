package com.zetauma.complainloudly.ws.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.zetauma.complainloudly.ws.model.Complaint;

@Path("/complaint")
public class ComplaintResource {
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public String getComplaint() {
		Complaint complaint = new Complaint("user", "image", "commentary", 1.000, 1.000);
		Gson gson = new Gson();
		return gson.toJson(complaint);
	}
}
