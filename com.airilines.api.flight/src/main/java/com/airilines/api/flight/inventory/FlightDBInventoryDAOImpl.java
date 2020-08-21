package com.airilines.api.flight.inventory;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.airilines.api.flight.resources.FlightCreationException;
import com.airilines.api.flight.resources.FlightDBObjectNotFoundException;
import com.airilines.api.flight.utils.FligtServiceConstants;

@Component(FligtServiceConstants.FLIGHT_DB_INVENTORY)
public class FlightDBInventoryDAOImpl implements FlightDBInventoryDAO{
	
	@Autowired
	DBConnection dbConnection;

	@Override
	public Set<FlightDetailsDTO> getFlights() throws FlightDBObjectNotFoundException {
		try {
			return dbConnection.getALLFlightsInDb();
		} catch (IOException e) {
			throw new FlightDBObjectNotFoundException();
		}
	}

	@Override
	public void createFlight(FlightDetailsDTO flightDetailsDTO) throws FlightCreationException {
		try {
			dbConnection.appendFlight(flightDetailsDTO);
		} catch (IOException | ParseException e) {
			throw new FlightCreationException(); 
		} 
	}

	@Override
	public void addFlight(FlightDetailsDTO flightDetailsDTO ) throws FlightCreationException {
		try {
			dbConnection.appendFlight(flightDetailsDTO);
		} catch (IOException | ParseException e) {
			throw new FlightCreationException(); 
		} 
	}

	@Override
	public void removeFlight(FlightDetailsDTO flightDetailsDTO) throws FlightCreationException {
		try {
			dbConnection.removeFlight(flightDetailsDTO);
		} catch (IOException | ParseException e) {
			throw new FlightCreationException(); 
		} 
	}

}
