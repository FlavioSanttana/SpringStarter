package org.studyeasy.SpringStarter.sevices;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.studyeasy.SpringStarter.models.Person;
import org.studyeasy.SpringStarter.models.Post;
import org.studyeasy.SpringStarter.repositories.PersonRepository;

@Service
public class PersonService {

    /*A anotação @Autowired no Spring Boot realiza a injeção de dependência automática, 
    permitindo que o framework instancie e injete beans gerenciados (como @Service ou @Component) 
    diretamente em atributos, construtores ou métodos setter. Isso elimina a necessidade de usar 
    new manualmente, facilitando o gerenciamento do ciclo de vida dos objetos e promovendo um 
    código mais desacoplado.  */
    @Autowired
    private PersonRepository personRepository;

    public Optional<Person> getById(Long id){
        return personRepository.findById(id);
    }
    
    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public void delete (Person person){
        personRepository.delete(person);
    }

    public Person save(Person person){
        /*
        if(person.getId() == null){
            person.setCreatedAt(LocalDateTime.now());;
        }
        */
        return personRepository.save(person);
    }
    
}
