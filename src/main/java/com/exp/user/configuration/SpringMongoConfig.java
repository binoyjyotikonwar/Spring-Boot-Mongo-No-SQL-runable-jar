package com.exp.user.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * Spring MongoDB configuration file
 * 
 */
@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration{
	
	@Value("${spring.data.mongodb.database}")
	private String dbName;
	
	
	@Value("${spring.data.mongodb.uri}")
	private String mongoURI;
	
	@Bean
	public GridFsTemplate gridFsTemplate() throws Exception {
		return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
	}

	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		MongoClientURI uri = new MongoClientURI(mongoURI);
		return new MongoClient(uri);
	}

}
