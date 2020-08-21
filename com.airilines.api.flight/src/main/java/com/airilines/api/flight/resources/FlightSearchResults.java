package com.airilines.api.flight.resources;

import java.util.List;

import org.springframework.hateoas.Link;

import com.airilines.api.flight.inventory.FlightDetailsDTO;

public class FlightSearchResults {
	
	Link self;
	Link Up;
	
	List<FlightDetailsDTO> flights;
	
	
	public Link getSelf() {
		return self;
	}
	public void setSelf(Link self) {
		this.self = self;
	}
	public Link getUp() {
		return Up;
	}
	public void setUp(Link up) {
		Up = up;
	}
	public List<FlightDetailsDTO> getFlights() {
		return flights;
	}
	public void setFlights(List<FlightDetailsDTO> flights) {
		this.flights = flights;
	}

	

}
