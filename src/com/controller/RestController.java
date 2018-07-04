package com.controller;

import java.time.LocalDate;
import java.time.Period;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/rest")
public class RestController {
	
	@Path("/diplay")
	@Produces({MediaType.APPLICATION_JSON})
	@GET
	public Album display() {
		System.out.println("inside display");
		Album album = new Album();
		album.setTitle("Sanju");
		album.setSinger("Sreya");
		return album;
		}
	
	
	@Path("/{cardNbr}/verify")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@GET
	public String validateCard(@PathParam("cardNbr") String cardNbr) {
		System.out.println("inside");
		int lastDigit = Integer.parseInt(cardNbr.substring(cardNbr.length()-1));
		if(lastDigit%2 == 0)
			return "valid";
	
		return "invalid";
		}
	
	
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
	
	@Path("/double/{intValue}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@GET
	public String doubleInt(@PathParam("intValue") String intVal) {
		System.out.println("inside");
		
		return String.valueOf(Integer.parseInt(intVal)*2);
		}
	
	@Path("/{inputVal}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@GET
	public String toLower(@PathParam("inputVal") String inputVal) {
		
		return inputVal.toLowerCase();
	}
	

}
