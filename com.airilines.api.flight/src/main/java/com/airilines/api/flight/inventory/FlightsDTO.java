package com.airilines.api.flight.inventory;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class FlightsDTO {
	Set<FlightDetailsDTO> flights;

	public Set<FlightDetailsDTO> getFlights() {
		return flights;
	}

	public void setFlights(Set<FlightDetailsDTO> flights) {
		this.flights = flights;
	}


}
