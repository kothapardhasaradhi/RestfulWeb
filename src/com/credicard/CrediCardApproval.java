package com.credicard;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path ("/card")
public class CrediCardApproval {

	@Path("/{cardNbr}/verify")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@GET
	public String validateCard(@PathParam("cardNbr") String cardNbr) {
		System.out.println("inside");
		int lastDigit = Integer.parseInt(cardNbr.substring(cardNbr.length()-1));
		if(lastDigit%2 == 0)
			return "true";
	
		return "false";
		}
}
