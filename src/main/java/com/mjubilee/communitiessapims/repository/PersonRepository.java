package com.mjubilee.communitiessapims.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mjubilee.communitiessapims.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
