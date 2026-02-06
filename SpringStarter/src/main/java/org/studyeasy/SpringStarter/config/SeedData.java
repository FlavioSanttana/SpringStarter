package org.studyeasy.SpringStarter.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.studyeasy.SpringStarter.models.Person;
import org.studyeasy.SpringStarter.models.Post;
import org.studyeasy.SpringStarter.sevices.PersonService;
import org.studyeasy.SpringStarter.sevices.PostService;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService; 

    @Autowired
    private PersonService personService;

    @Override
    public void run(String ... args) throws Exception{

        List<Post> posts = postService.getAll();

        if(posts.size() == 0){
            
            Post post01 = new Post();
            post01.setTitle("Post 01");
            post01.setBody("Post 01.........................................");
            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("Post 02");
            post02.setBody("Post 02.........................................");
            postService.save(post02);

        }

        List<Person> person = personService.getAll();
        
        if(person.size() == 0){
            
            Person person01 = new Person();
            person01.setEmail("flavio.santana@ufsc.br");
            person01.setFirstName("Flávio");
            person01.setLastName("Santana");
            personService.save(person01);

            Person person02 = new Person();
            person02.setEmail("f.o.santana@gmail.com");
            person02.setFirstName("Flávio");
            person02.setLastName("Santana");
            personService.save(person02);

        }

    }

}
