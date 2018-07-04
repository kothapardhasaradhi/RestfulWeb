package com.restClient;


import java.io.IOException;



import javax.ws.rs.core.MediaType;


import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


import com.controller.Album;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;





public class RestClient {
	
	 public static final String BASE_URI = "http://localhost:8083/RESTfulWeb/rest";
	    public static void main(String[] args) {
	        ClientConfig config = new DefaultClientConfig();

	        Client client = Client.create(config);
	        WebResource resource = client.resource(BASE_URI);
	        
	        validateCrediCard(resource);
	        
	        findAge(resource);
	        
	        doubleTheInt(resource);
	        
	        toLower(resource);
	        
	        getJsonAlbum(resource);
	        
	        

	        
	    }
		private static void validateCrediCard(WebResource resource) {
		
			String card = "15622222445566998877";
			WebResource intDouble = resource.path("/"+card+"/verify");
	        String output = intDouble.accept(MediaType.TEXT_PLAIN).get(String.class);
	        System.out.println("given credit card "+card+" is  = "+output);
			
		}
		private static void getJsonAlbum(WebResource resource) {
			try {
		        WebResource webResource = resource.path("/diplay");
		      
		        ClientResponse response = webResource.accept(
						"application/json").get(ClientResponse.class);

		        Album outputAlbum = response.getEntity(Album.class);
		        
		        ObjectMapper mapper = new ObjectMapper();
		        
		        String jsonInString = mapper.writeValueAsString(outputAlbum);
				System.out.println(jsonInString);
				
				} catch (JsonGenerationException e) {
				
					e.printStackTrace();
				} catch (JsonMappingException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
		      
		        
			
		}
		private static void toLower(WebResource resource) {
			String str="ParDha";
			WebResource toLowerResource = resource.path("/"+str);
	        String output = toLowerResource.accept(MediaType.TEXT_PLAIN).get(String.class);
	        System.out.println("After converting "+str+" to Lowercase : "+output);
			
		}
		private static void doubleTheInt(WebResource resource) {
			int i=7;
			WebResource intDouble = resource.path("/double/"+String.valueOf(i));
	        String output = intDouble.accept(MediaType.TEXT_PLAIN).get(String.class);
	        System.out.println("After doubling value of "+i+" = "+output);
			
		}
		private static void findAge(WebResource resource) {
			WebResource ageResource = resource.path("/07-07-1997/findAge");
	        String age = ageResource.accept(MediaType.TEXT_PLAIN).get(String.class);
	        System.out.println("finding age of 07-07-1997 birth date: "+age);
			
		}
	

}
