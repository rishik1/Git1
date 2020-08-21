package com.airilines.api.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airilines.api.flight.resources.FlightDBObjectNotFoundException;
import com.airilines.api.flight.resources.FlightSearchInvalidParamException;
import com.airilines.api.flight.resources.FlightSearchResults;
import com.airilines.api.flight.service.FlightService;

@Controller
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@RequestMapping(method=RequestMethod.GET , value="/search/{departureTime}" )
	public HttpEntity<FlightSearchResults> getFlightSearchResults(@PathVariable String departureTime) throws FlightDBObjectNotFoundException, FlightSearchInvalidParamException{
		
		FlightSearchResults flightSearchResults =flightService.filterFlightByDeparture(departureTime);
		
		return new ResponseEntity<FlightSearchResults>(flightSearchResults, HttpStatus.OK);
	}

}
