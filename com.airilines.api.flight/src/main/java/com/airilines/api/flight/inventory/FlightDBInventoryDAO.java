package com.airilines.api.flight.inventory;

import java.util.Set;

import com.airilines.api.flight.resources.FlightCreationException;
import com.airilines.api.flight.resources.FlightDBObjectNotFoundException;

public interface FlightDBInventoryDAO {
	
	public Set<FlightDetailsDTO> getFlights() throws FlightDBObjectNotFoundException;
	
	void addFlight(FlightDetailsDTO flightDetailsDTO) throws FlightCreationException;

	void createFlight(FlightDetailsDTO flightDetailsDTO) throws FlightCreationException;

	void removeFlight(FlightDetailsDTO flightDetailsDTO) throws FlightCreationException;
	

}

