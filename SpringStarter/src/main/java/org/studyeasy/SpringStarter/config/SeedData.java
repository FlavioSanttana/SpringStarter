package org.studyeasy.SpringStarter.config;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.studyeasy.SpringStarter.models.Account;
import org.studyeasy.SpringStarter.models.Authority;
import org.studyeasy.SpringStarter.models.Person;
import org.studyeasy.SpringStarter.models.Post;
import org.studyeasy.SpringStarter.sevices.AccountService;
import org.studyeasy.SpringStarter.sevices.AuthorityService;
import org.studyeasy.SpringStarter.sevices.PersonService;
import org.studyeasy.SpringStarter.sevices.PostService;
import org.studyeasy.SpringStarter.util.constants.Privillages;
import org.studyeasy.SpringStarter.util.constants.Roles;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired (required=true)
    private PostService postService; 

    @Autowired (required=true)
    private PersonService personService;

    @Autowired (required=true)
    private AccountService accountService;

    @Autowired (required=true)
    private AuthorityService authorityService;  

    @Override
    public void run(String ... args) throws Exception{

        for (Privillages auth: Privillages.values()){
            Authority authority = new  Authority();
            authority.setId(auth.getId());
            authority.setName(auth.getPrivillage());
            authorityService.save(authority);
        }

        Account account01 = new Account();
        account01.setFirstName("Flávio");
        account01.setLastName("Santana");
        account01.setEmail("flavio@santana.br");
        account01.setPassword("123456");
        account01.setRole(Roles.USER.getRole());
        
        Account account02 = new Account();
        account02.setFirstName("Admin");
        account02.setLastName("Teste");
        account02.setEmail("admin@teste.br");
        account02.setPassword("123456");
        account02.setRole(Roles.ADMIN.getRole());
        
        Account account03 = new Account();
        account03.setFirstName("Editir01");
        account03.setLastName("Teste");
        account03.setEmail("editor01@teste.br");
        account03.setPassword("123456");
        account03.setRole(Roles.EDITOR.getRole());
       
        Account account04 = new Account();
        account04.setFirstName("Editir02");
        account04.setLastName("Teste");
        account04.setEmail("editor02@teste.br");
        account04.setPassword("123456");
        account04.setRole(Roles.EDITOR.getRole());
        Set<Authority> authorities = new HashSet<>();
        authorityService.findById(Privillages.RESET_ANY_USER_PASSWORD.getId()).ifPresent(authorities::add);
        authorityService.findById(Privillages.ACCESS_ADMIN_PANEL.getId()).ifPresent(authorities::add);
        account04.setAuthorities(authorities);

        accountService.save(account01);
        accountService.save(account02);
        accountService.save(account03);
        accountService.save(account04);


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
