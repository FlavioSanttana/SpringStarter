package org.studyeasy.SpringStarter.Controller;

import java.util.List;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.studyeasy.SpringStarter.models.Person;
import org.studyeasy.SpringStarter.models.Post;
import org.studyeasy.SpringStarter.sevices.PersonService;
//import org.springframework.web.bind.annotation.RequestParam;
import org.studyeasy.SpringStarter.sevices.PostService;


@Controller
public class HomeController {

    @Autowired
    private PostService postService;
    
    @Autowired
    private PersonService personService;

    @GetMapping("/")    
    public String home (Model model){
        
        //List<Post> posts = postservice.getAll();
        List<Post> posts = postService.getAll();
        
        model.addAttribute("posts", posts);        
        //String attributeName;
        //model.addAttribute("posts", posts);

        List<Person> persons = personService.getAll();
        
        //model.addAttribute("persons", persons);

        return "Home";
    }
    
}
