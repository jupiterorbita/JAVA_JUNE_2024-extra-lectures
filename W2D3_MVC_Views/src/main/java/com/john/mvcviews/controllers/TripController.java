package com.john.mvcviews.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.john.mvcviews.models.Trip;
import com.john.mvcviews.services.TripService;

import jakarta.validation.Valid;

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
		return "tripDashboard.jsp";
	}

//	READ ONE - DETAILS PAGE
//	GET /trips/3
	@GetMapping("/{id}")
	public String displayDetailsPage(@PathVariable("id") Long id, Model model) {
//		1. get the trip form the service using the id
		Trip oneTrip = tripService.getOneTrip(id);
//		2. pass it to the jsp with Model model
		model.addAttribute("oneTrip", oneTrip);
		return "tripDetails.jsp";
	}

//	CREATE - PAGE -------------------------------
//	GET /trips/new
	@GetMapping("/new")
	public String displayCreatePage(@ModelAttribute("newTrip") Trip newTrip) {
		return "newTrip.jsp";
	}

//	CREATE - METHOD
//	POST: /trips/new
	@PostMapping("/new")
	public String processCreateForm(@Valid @ModelAttribute("newTrip") Trip newTrip, BindingResult result) {
		System.out.println(result);
		if (result.hasErrors()) {
			return "newTrip.jsp"; // RENDER ERRORS
		} else {
			tripService.createTrip(newTrip);
			return "redirect:/trips";
		}
	}

//	UPDATE PAGE ---------------------------
	@GetMapping("/{id}/edit")
	public String renderEditPage(@PathVariable("id") Long id, Model model) {
//		1. get the id from path
//		2. get the trip from the service with the id
		Trip oneTrip = tripService.getOneTrip(id);
//		3. pass it to the jsp with model to be inside the form:form modelAttribute
		model.addAttribute("oneTrip", oneTrip);
		return "editTrip.jsp";
	}

//	UPDATE METHOD
	@PutMapping("/{id}/edit")
	public String update(@Valid @ModelAttribute("oneTrip") Trip oneTrip, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("oneTrip", oneTrip);
			return "editTrip.jsp";
		} else {
			tripService.updateTrip(oneTrip);
			return "redirect:/trips";
		}
	}

//	DELETE ------------------------------
	@DeleteMapping("/{id}/delete")
	public String deleteTrip(@PathVariable("id") Long id, RedirectAttributes flash) {
		tripService.deleteTrip(id);
		flash.addFlashAttribute("deleteSuccess", "deleted your trip!");
		return "redirect:/trips";
	}

}
