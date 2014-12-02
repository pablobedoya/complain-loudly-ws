package com.zetauma.complainloudly.ws.controller;

import java.util.List;

import com.zetauma.complainloudly.ws.dao.ComplaintDAO;
import com.zetauma.complainloudly.ws.model.Complaint;

public class ComplaintController {
	public List<Complaint> list() {
		return ComplaintDAO.getInstance().list();
	}
}
