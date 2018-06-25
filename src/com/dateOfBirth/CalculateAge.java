package com.dateOfBirth;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/dob")
public class CalculateAge {
	
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{dob}/findAge")
	public String findAge(@PathParam("dob") String dob) {
		System.out.println("inside age calc");
		int dd = Integer.parseInt(dob.substring(0,2));
		int mm = Integer.parseInt(dob.substring(3,5));
		int yyyy =  Integer.parseInt(dob.substring(6,10));
		LocalDate startDate = LocalDate.of(yyyy,mm,dd );
		 LocalDate todayDate = LocalDate.now();
		 
		 if ((startDate != null) && (todayDate != null)) {
			return String.valueOf(Period.between(startDate, todayDate).getYears());
	        }
		 
	    return null;
	}
}
