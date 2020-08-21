package com.airilines.api.flight.inventory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class FlightDetailsDTO {
	    @JsonInclude(Include.NON_NULL)
	    private String flight; 
	    
	    @JsonInclude(Include.NON_NULL)
		private String departure; 
	    
		
		public String getFlight() {
			return flight;
		}
		public void setFlight(String flight) {
			this.flight = flight;
		}
		public String getDeparture() {
			return departure;
		}
		public void setDeparture(String departure) {
			this.departure = departure;
		}
}
