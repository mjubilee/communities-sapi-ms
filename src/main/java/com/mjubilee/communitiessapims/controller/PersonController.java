package com.mjubilee.communitiessapims.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mjubilee.communitiessapims.exception.PersonNotFoundException;
import com.mjubilee.communitiessapims.model.Person;
import com.mjubilee.communitiessapims.repository.PersonRepository;

import jakarta.validation.Valid;

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
	
	@GetMapping("/persons/profile")
	public ResponseEntity<Person> retrievePersonProfile(@RequestParam Long id) {
		String port = environment.getProperty("local.server.port");
		String host = environment.getProperty("HOSTNAME");
		
		this.log.info( host + " -- " + port + " -- retrievePersonProfile -- Retrieve a person profile");
		Optional<Person> person = this.personRepo.findById(id);

		if (person.isEmpty()) {			
			throw new PersonNotFoundException("Data with id = " + id + " can not be found.");
		}
		return new ResponseEntity<Person>(person.get(),HttpStatus.OK);
	}
	
	@GetMapping("/persons/{id}")
	public ResponseEntity<Person> retrievePersonById(@PathVariable Long id) {		
		String port = environment.getProperty("local.server.port");
		String host = environment.getProperty("HOSTNAME");
		
		this.log.info( host + " -- " + port + " -- retrievePersonById -- Retrieve specific person infromation by id");
		
		Optional<Person> person = this.personRepo.findById(id);

		if (person.isEmpty()) {			
			throw new PersonNotFoundException("Data with id = " + id + " can not be found.");
		}
		return new ResponseEntity<Person>(person.get(),HttpStatus.OK);
	}
	
	@PostMapping("/persons")
	public ResponseEntity<Person> createPerson(@Valid @RequestBody Person person) {		
		String port = environment.getProperty("local.server.port");
		String host = environment.getProperty("HOSTNAME");
		
		this.log.info( host + " -- " + port + " -- createPersonBy -- Input a person infromation");
		
		Person savedPerson = personRepo.save(person);				
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPerson.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/persons/{id}")
	public ResponseEntity<Person> deletePerson(@PathVariable Long id) {
		String port = environment.getProperty("local.server.port");
		String host = environment.getProperty("HOSTNAME");
		
		this.log.info( host + " -- " + port + " -- deletePerson -- Remove a person by id");
		
		Optional<Person> person = this.personRepo.findById(id);

		if (person.isEmpty()) {			
			throw new PersonNotFoundException("Data with id = " + id + " can not be found.");
		}
		
		this.personRepo.delete(person.get());
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(person.get().getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/persons")
	public ResponseEntity<Person> updatePerson(@Valid @RequestBody Person person) {		
		String port = environment.getProperty("local.server.port");
		String host = environment.getProperty("HOSTNAME");
		
		this.log.info( host + " -- " + port + " -- updatePerson -- Update a person infromation");
		
		Optional<Person> queryPerson = this.personRepo.findById(person.getId());

		if (queryPerson.isEmpty()) {			
			throw new PersonNotFoundException("Data with id = " + person.getId() + " can not be found.");
		}
		
		queryPerson.get().setFirstName(person.getFirstName());
		queryPerson.get().setLastName(person.getLastName());
		queryPerson.get().setDob(person.getDob());
		queryPerson.get().setEmail(person.getEmail());
		
		Person savedPerson = personRepo.save(queryPerson.get());				
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPerson.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
}
