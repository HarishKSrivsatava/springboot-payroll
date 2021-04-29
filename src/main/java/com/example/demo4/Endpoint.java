package com.example.demo4;


import org.springframework.stereotype.Component;
import javax.ws.rs.Path;
import javax.ws.rs.GET;

@Component
@Path("/hello")
public class Endpoint {
 
	@GET
	public String message(){
		return "Hello World";
	}
}
