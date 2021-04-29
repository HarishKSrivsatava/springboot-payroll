package com.example.demo4;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import com.mongodb.client.MongoDatabase;

@Component
public class MyBean {

	private final MongoDatabaseFactory mongo;
	
	@Autowired
	public MyBean(MongoDatabaseFactory mongo){
		this.mongo = mongo;
	}
	
	
	public void example(){
		MongoDatabase mdb = mongo.getMongoDatabase();
	}
}
