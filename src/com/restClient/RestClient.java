package com.restClient;


import java.net.URI;


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;





public class RestClient {
	
	 public static final String BASE_URI = "http://localhost:8083/RESTfulWeb/";
	    public static void main(String[] args) {
	        ClientConfig config = new DefaultClientConfig();

	        Client client = Client.create(config);
	        WebResource resource = client.resource(BASE_URI);
	        
	        WebResource ageResource = resource.path("dob/07-07-1997/findAge");
	        String age = ageResource.accept(MediaType.TEXT_PLAIN).get(String.class);
	        System.out.println(age);
	     
	    }
	

}
