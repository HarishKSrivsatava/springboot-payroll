package com.example.demo4;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JersyConfig extends ResourceConfig{

	public JersyConfig(){
		register(Endpoint.class);
	}
}
