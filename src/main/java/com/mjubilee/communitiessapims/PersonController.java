package com.mjubilee.communitiessapims;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
