package com.zetauma.complainloudly.ws.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.zetauma.complainloudly.ws.controller.ComplaintController;
import com.zetauma.complainloudly.ws.model.Complaint;

@Path("/complaint")
public class ComplaintResource {
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public String listComplaint() {
		Gson gson = new Gson();
		return gson.toJson(new ComplaintController().list());
	}
	
	@GET
	@Path("/create/{user}/{image}/{commentary}/{lat}/{lng}")
	@Produces(MediaType.APPLICATION_JSON)
	public String createComplaint(@PathParam("user") String user, @PathParam("image") String image, @PathParam("commentary") String commentary, @PathParam("lat") double lat, @PathParam("lng") double lng) {
		Complaint complaint = new Complaint();
		complaint.setUser(user);
		complaint.setImage(image);
		complaint.setCommentary(commentary);
		complaint.setLatitude(lat);
		complaint.setLongitude(lng);
		
		if (!new ComplaintController().create(complaint))
			return "(\"status\":\"ok\")";
		else
			return "(\"status\":\"not ok\")";
	}
}
