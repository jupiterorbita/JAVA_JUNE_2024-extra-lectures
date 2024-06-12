package com.john.mvcviews.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.john.mvcviews.models.Trip;
import com.john.mvcviews.services.TripService;

@Controller
@RequestMapping("/trips")
public class TripController {
	
	@Autowired
	private TripService tripService;
	
//	READ ALL
//	GET: /trips
//	localhost:8080/
	@GetMapping("")
	public String displayDashboardPage(Model model) {
//		1. get akk the trips for the serivce
		List<Trip> tripList = tripService.getAllTrips();
//		2. store it in the View Model to pass it to the jsp
		model.addAttribute("tripList", tripList);
		return "index.jsp";
	}
	
	
//	READ ONE - DETAILS PAGE
//	GET /trips/3
	@GetMapping("/{id}")
	public String displayDetailsPage(@PathVariable("id") Long id,
									Model model) {
//		1. get the trip form the service using the id
		Trip oneTrip = tripService.getOneTrip(id);
//		2. pass it to the jsp with Model model
		model.addAttribute("oneTrip", oneTrip);
		return "tripDetails.jsp";
	}
	
	
	
	
	
	
	
	
	
	

}
