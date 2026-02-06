package org.studyeasy.SpringStarter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.studyeasy.SpringStarter.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    
} 
