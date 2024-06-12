package com.john.mvcviews.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.john.mvcviews.models.Trip;
import com.john.mvcviews.services.TripService;

@RestController
@RequestMapping("/api")
public class TripApiController {
	private final TripService tServ;
	
	public TripApiController(TripService serv) {
		this.tServ = serv;
	}
	
//	------------------------
	
//	Read All
//	return: List<Trip>
//	route: /api/trips
	@GetMapping("/trips")
	public List<Trip> getAllTrips(){
		return tServ.getAllTrips();
	}
	
	
//	Create
//	return: Trip
//	route: /api/trips
	@PostMapping("/trips")
	public Trip createTrip(
			@RequestParam("location") String location,
			@RequestParam("tripDuration") Integer tripDuration,
			@RequestParam("description") String description,
			@RequestParam("owner") String owner
			) {
		Trip newTrip = new Trip(location, tripDuration, description, owner);
		
		Trip newlyCreatedTrip = tServ.createTrip(newTrip);
		System.out.println(newlyCreatedTrip.getId());
		
		return newlyCreatedTrip;
	}
	
//	Read One
//	return: Trip
//	route: /api/trips/id
	@GetMapping("/trips/{id}")
	public Trip getOneTrip(@PathVariable("id") Long id) {
		return tServ.getOneTrip(id);
	}
	
	
//	Update
//	return: Trip
//	route: /api/trips/id
	@PutMapping("/trips/{id}")
	public Trip updateTrip(
			@PathVariable("id") Long id,
			@RequestParam("location") String location,
			@RequestParam("tripDuration") Integer tripDuration,
			@RequestParam("description") String description,
			@RequestParam("owner") String owner
			) {
//		1. Get the existing object from the database
		Trip tripToEdit = tServ.getOneTrip(id);
		
		if (tripToEdit == null) return null;
		
		
//		2. Update the fields object
		tripToEdit.setLocation(location);
		tripToEdit.setTripDuration(tripDuration);
		tripToEdit.setDescription(description);
		tripToEdit.setOwner(owner);
		
//		3. Save the changes to the database
		return tServ.updateTrip(tripToEdit);
	}
	
//	Delete
//	return: void
//	route: /api/trips/id
	@DeleteMapping("/trips/{id}")
	public void deleteTrip(@PathVariable("id") Long id) {
		tServ.deleteTrip(id);
	}
	
	
	
	
	
	
	
	
	
	
}