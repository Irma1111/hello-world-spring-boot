package de.htwberlin.webtech.repository;

import de.htwberlin.webtech.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
