package com.airilines.api.flight.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

import com.airilines.api.flight.controller.FlightController;
import com.airilines.api.flight.inventory.FlightDBInventoryDAO;
import com.airilines.api.flight.inventory.FlightDBInventoryDAOImpl;
import com.airilines.api.flight.inventory.FlightDetailsDTO;
import com.airilines.api.flight.resources.FlightDBObjectNotFoundException;
import com.airilines.api.flight.resources.FlightSearchInvalidParamException;
import com.airilines.api.flight.resources.FlightSearchResults;
import com.airilines.api.flight.utils.utils;

@Component
public class FlightService {
	
	@Autowired
	FlightDBInventoryDAO flightDBInventoryDAO;
	
	
	@SuppressWarnings("deprecation")
	public FlightSearchResults filterFlightByDeparture(String searchTime) throws FlightDBObjectNotFoundException, FlightSearchInvalidParamException{
		
		ControllerLinkBuilder controllerLinkBuilder = ControllerLinkBuilder.linkTo(FlightController.class);
		FlightSearchResults flightSearchResults= new FlightSearchResults();
		Set<FlightDetailsDTO> flights = flightDBInventoryDAO.getFlights();
		int searchTimeInMins = utils.convertAmPmTimeUtils(searchTime);
		if(searchTimeInMins < 0)
			throw new FlightSearchInvalidParamException();
		
		List<FlightDetailsDTO> flightList  = new ArrayList<>();
		flights.forEach((v)->{
			int timeInMins = utils.convertAmPmTimeUtils(v.getDeparture());
			
			if(Math.abs(timeInMins-searchTimeInMins) >0)
				flightList.add(v);
			
		}); 
		
		flightSearchResults.setFlights(flightList);
		flightSearchResults.setSelf(controllerLinkBuilder.slash("search").withSelfRel());
		flightSearchResults.setUp(controllerLinkBuilder.withRel("up"));
		
		return flightSearchResults;
	}
	

}
