package org.studyeasy.SpringStarter.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.studyeasy.SpringStarter.models.Account;
import org.studyeasy.SpringStarter.models.Authority;
import org.studyeasy.SpringStarter.models.Person;
import org.studyeasy.SpringStarter.models.Post;
import org.studyeasy.SpringStarter.sevices.AccountService;
import org.studyeasy.SpringStarter.sevices.AutorityService;
import org.studyeasy.SpringStarter.sevices.PersonService;
import org.studyeasy.SpringStarter.sevices.PostService;
import org.studyeasy.SpringStarter.util.constants.Authorities;
import org.studyeasy.SpringStarter.util.constants.Privillages;
import org.studyeasy.SpringStarter.util.constants.Roles;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService; 

    @Autowired
    private PersonService personService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AutorityService autorityService;  

    @Override
    public void run(String ... args) throws Exception{

        for (Privillages auth: Privillages.values()){
            Authority authority = new  Authority();
            authority.setId(auth.getId());
            authority.setName(auth.getPrivillage());
            autorityService.save(authority);
        }

        Account account01 = new Account();
        account01.setFirstName("Admin");
        account01.setLastName("Teste");
        account01.setEmail("admin@teste.br");
        account01.setPassword("123456");
        account01.setRole(Roles.ADMIN.getRole());
        accountService.save(account01);

        Account account02 = new Account();
        account02.setFirstName("Editor01");
        account02.setLastName("Teste");
        account02.setEmail("editor01@teste.br");
        account02.setPassword("123456");
        account02.setRole(Roles.EDITOR.getRole());
        accountService.save(account02);

        Account account03 = new Account();
        account03.setFirstName("Editor02");
        account03.setLastName("Teste");
        account03.setEmail("editor02@teste.br");
        account03.setPassword("123456");
        account03.setRole(Roles.EDITOR.getRole());
        accountService.save(account03);

        List<Post> posts = postService.getAll();

        if(posts.size() == 0){
            
            Post post01 = new Post();
            post01.setTitle("Post 01");
            post01.setBody("Post 01.........................................");
            post01.setAccount(account01);
            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("Post 02");
            post02.setBody("Post 02.........................................");
            post02.setAccount(account02);
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
