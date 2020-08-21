package com.airilines.api.flight.inventory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.airilines.api.flight.utils.FligtServiceConstants;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class DBConnection {
	
	private static   File file = new File("/com.airilines.api.flight/src/main/resources/flightInvetory.json");
	
	private static ObjectMapper ObjectMapper = new ObjectMapper().setSerializationInclusion(Include.NON_NULL);
	

	public FlightsDTO getDBContents() throws JsonParseException, JsonMappingException, IOException {
		 File file = new File("/com.airilines.api.flight/src/main/resources/flightInvetory.json");
		FlightsDTO flights = ObjectMapper.readValue(file, FlightsDTO.class);
		return flights;
	}
	
	public Set<FlightDetailsDTO> getALLFlightsInDb() throws JsonParseException, JsonMappingException, IOException{
		FlightsDTO flights  = getDBContents();
		return flights.getFlights();
	}
	
	public List<FlightDetailsDTO> getFlightByName(String flightName) throws JsonParseException, JsonMappingException, IOException{
		FlightsDTO flights  = getDBContents();
		List<FlightDetailsDTO> flightList = flights.getFlights().stream().filter((v)->v.getFlight().equalsIgnoreCase(flightName)).collect(Collectors.toList());
		return flightList;
	}
	
   @SuppressWarnings("unchecked")
public synchronized void appendFlight(FlightDetailsDTO flightDetailsDTO) throws IOException, ParseException{
	 
	   Set<FlightDetailsDTO> flights = getALLFlightsInDb();
	   
	   Set<FlightDetailsDTO> flightList = flights.stream().filter((v)-> (!v.getFlight().equalsIgnoreCase(flightDetailsDTO.getFlight()))).collect(Collectors.toSet());
	   flightList.add(flightDetailsDTO);
	   FlightsDTO flightObbj = new FlightsDTO();
	   flightObbj.setFlights(flightList); 
	   
	   String jsonObj =ObjectMapper.writeValueAsString(flightObbj);
	   fileWriterJson(jsonObj);
	   
   }
   
   public synchronized void removeFlight(FlightDetailsDTO flightDetailsDTO) throws IOException, ParseException{
	   Set<FlightDetailsDTO> flights = getALLFlightsInDb();
	   
	   Set<FlightDetailsDTO> flightList = flights.stream().filter((v)-> (!v.getFlight().equalsIgnoreCase(flightDetailsDTO.getFlight()))).collect(Collectors.toSet());
	   FlightsDTO flightObbj = new FlightsDTO();
	   flightObbj.setFlights(flightList); 
	   
	   
	   String jsonObj =ObjectMapper.writeValueAsString(flightObbj);
	   fileWriterJson(jsonObj);
	   
   }
   
   private synchronized void fileWriterJson(String jsonObjToWrite) throws IOException{ 
	   FileWriter fw = new FileWriter(file);
	   fw.write(jsonObjToWrite);
	   fw.flush();
	   fw.close();
   }
}
