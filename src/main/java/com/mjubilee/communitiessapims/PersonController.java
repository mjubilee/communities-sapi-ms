package com.mjubilee.communitiessapims;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjubilee.communitiessapims.exception.PersonNotFoundException;
import com.mjubilee.communitiessapims.model.Person;
import com.mjubilee.communitiessapims.repository.PersonRepository;

@RestController
public class PersonController {
	Logger log = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private Environment environment;
	
	@Autowired
	private PersonRepository personRepo;
	
	@GetMapping("/persons")
	public List<Person> retrievePersonList() {
		String port = environment.getProperty("local.server.port");
		String host = environment.getProperty("HOSTNAME");
		
		this.log.info( host + " -- " + port + " -- retrievePersonList -- Retrieve all person");
		
		return this.personRepo.findAll();
	}
	
	@GetMapping("/persons/{id}")
	public Person retrievePersonById(@PathVariable Long id) {
		
		String port = environment.getProperty("local.server.port");
		String host = environment.getProperty("HOSTNAME");
		
		this.log.info( host + " -- " + port + " -- retrievePersonById -- Retrieve specific person infromation by id");
		
		Optional<Person> person = this.personRepo.findById(id);
		
		if (person.isEmpty()) {			
			throw new PersonNotFoundException("Data with id = " + id + " can not be found.");
		}
		
		return person.get();
	}
	
}
