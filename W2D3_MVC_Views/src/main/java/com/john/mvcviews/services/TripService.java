package com.john.mvcviews.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.john.mvcviews.models.Trip;
import com.john.mvcviews.repositories.TripRepository;

@Service
public class TripService {
	// Member variable that contains all our CRUD tools
	private final TripRepository tripRepo;
	
	public TripService(TripRepository tR) {
		this.tripRepo = tR;
	}
	
	// ----------
	
	// Read All
	public List<Trip> getAllTrips() {
		return tripRepo.findAll();
	}
	
	// Create
	public Trip createTrip(Trip t) {
		return tripRepo.save(t);
	}
	
	// Read One
	public Trip getOneTrip(Long id) {
		Optional<Trip> optTrip = tripRepo.findById(id);
		
//		if (optTrip.isPresent()) {
//			return optTrip.get();
//		} else {
//			return null;
//		}
		
//		ternary
//		return optTrip.isPresent() ? optTrip.get() : null;
//		optional
		return optTrip.orElse(null);
	}
	
	// Update
	public Trip updateTrip(Trip t) {
		return tripRepo.save(t);
	}
	
	// Delete
	public void deleteTrip(Long id) {
		tripRepo.deleteById(id);
	}
}

