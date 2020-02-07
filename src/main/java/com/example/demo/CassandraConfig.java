package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.datastax.driver.core.AuthProvider;
import com.datastax.driver.core.PlainTextAuthProvider;

@Configuration
@EnableCassandraRepositories(basePackages = "com.example.demo")
public class CassandraConfig extends AbstractCassandraConfiguration {
 
	  @Value("${spring.data.cassandra.contact-points:0.0.0.0}")
	  private String contactPoints;

	  @Value("${spring.data.cassandra.port:0000}")
	  private int port;

	  @Value("${spring.data.cassandra.keyspace-name:default}")
	  private String keySpace;

	  @Value("${spring.data.cassandra.username}")
	  private String username;

	  @Value("${spring.data.cassandra.password}")
	  private String password;

	  @Value("${spring.data.cassandra.schema-action}")
	  private String schemaAction;

	  @Override
	  protected String getKeyspaceName() {
	    return keySpace;
	  }

	  @Override
	  protected String getContactPoints() {
	    return contactPoints;
	  }

	  @Override
	  protected int getPort() {
	    return port;
	  }

	  @Override
	  public SchemaAction getSchemaAction() {
	    return SchemaAction.valueOf(schemaAction);
	  }

	  @Override
	  protected AuthProvider getAuthProvider() {
	    return new PlainTextAuthProvider(username, password);
	  }

	  @Override
	  protected boolean getMetricsEnabled() { 
		  return false; 
		  }
	  
}