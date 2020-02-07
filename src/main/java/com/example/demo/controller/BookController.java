package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;
import com.datastax.driver.core.utils.UUIDs;
import com.example.demo.Book;
import com.example.demo.BookRepository;
import com.example.demo.Emp;
import com.google.common.collect.ImmutableSet;

@RestController
@RequestMapping("/book")
public class BookController {
	
	  @Autowired
	  BookRepository bookRespository;
	  
	  @Autowired
	  private CassandraOperations cassandraTemplate;

	  /**
	   * Stores the given book in Cassandra
	   *
	   * @return boolean to indicate status of operation
	   */
	  @GetMapping("/save")
	  public Boolean saveNewBookHandler(
	      @RequestParam String title, @RequestParam String publisher) {
		  
		  
		  System.out.println(title);
		  System.out.println(publisher);
		  

		  System.out.println("Spring Cassandra Insert Example");
		  System.out.println("==============================");

		  
		  ImmutableSet<String> bookTags = ImmutableSet.of("Computer", "Software");
		  Book javaBook = new Book(UUIDs.timeBased(),title,publisher,bookTags);
		  bookRespository.insert(javaBook);
		  
		 /* Insert insertQueryBuider = QueryBuilder.insertInto("book")
				  .value("isbn", UUIDs.timeBased())
				  .value("title", title)
				  .value("publisher", publisher)
				  .value("tags", ImmutableSet.of("Computer","Software"));
		  cassandraTemplate.insert(insertQueryBuider);*/
		  
		 /* Insert insertQueryBuider1 = QueryBuilder.insertInto("emp")
				  .value("empid", 4)
				  .value("emp_dept", "fin")
				  .value("emp_first", "ketan")
				  .value("emp_last", "nakum");
		  cassandraTemplate.insert(insertQueryBuider1);*/
		  
		  printCassandra();
		  
	    return true;
	  }
	  
	  public void printCassandra()
	  {
			final String[] columns = new String[] { "empid", "emp_dept", "emp_first", "emp_last" };

			Select select = QueryBuilder.select(columns).from("emp");
			//select.where(QueryBuilder.eq("id101"));

			final List<Emp> results = cassandraTemplate.select(select, Emp.class);

			System.out.println("Spring Cassandra Query Example");
			System.out.println("==============================");

			for (Emp emp : results) {
				System.out.println("Employee: " + emp.getEmpid());
				System.out.println("Employee Department is: " + emp.getEmp_dept());
				System.out.println("Employee First Name is: " + emp.getEmp_first());
				System.out.println("Employee Last Name is: " + emp.getEmp_last());
			}

	  }

}
