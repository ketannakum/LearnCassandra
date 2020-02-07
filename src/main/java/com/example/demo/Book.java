package com.example.demo;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.google.common.collect.ImmutableSet;

@Table(value = "book", forceQuote = false)
public class Book {
	
    public Book(UUID timeBased, String title, String publisher, ImmutableSet<String> bookTags) {
    	
    	this.id = timeBased;
		this.title = title;
		this.publisher = publisher;
		this.tags = bookTags;
  
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	@PrimaryKeyColumn(
      name = "isbn", 
      ordinal = 2, 
      type = PrimaryKeyType.CLUSTERED, 
      ordering = Ordering.DESCENDING)
     private UUID id;
    
    @PrimaryKeyColumn(
      name = "title", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String title;
    
    @PrimaryKeyColumn(
      name = "publisher", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String publisher;
    
    @Column
    private Set<String> tags = new HashSet<>();
   
}
