package org.studyeasy.SpringStarter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.studyeasy.SpringStarter.models.Account;
import org.studyeasy.SpringStarter.sevices.AccountService;

@Controller
public class AccountController {
    
    /*
    A anotação @Autowired serve para delegar ao Spring Framework a injeção automática 
    de dependências na sua classe. Ela elimina a necessidade de instanciar objetos 
    manualmente usando a palavra-chave new, permitindo que o contêiner de Inversão de 
    Controle (IoC) do Spring gerencie o ciclo de vida e forneça as instâncias 
    necessárias (beans) em tempo de execução. 

    O Spring procura de forma automatizada por um componente compatível criado no 
    ecossistema (geralmente classes anotadas com @Component, @Service, @Repository 
    ou @Controller) e o insere no local indicado.
    */
    @Autowired
    private AccountService accountService;

    /*
    A anotação @GetMapping serve para mapear requisições HTTP do tipo GET para métodos
    específicos dentro de uma classe controladora (anotada com @RestController ou @Controller) 
    no Spring Boot.

    Ela é uma especialização composta da anotação @RequestMapping(method = RequestMethod.GET), 
    servindo como um atalho mais curto, limpo e legível para expor endpoints de leitura que 
    buscam ou listam dados
    */
    @GetMapping("/register")
    public String register(Model model){

        Account acccount = new Account();
        model.addAttribute("account", acccount);
        return "register"; 

    }

    @PostMapping("/register")
    public String register_user(@ModelAttribute Account account){
        accountService.save(account);
        return "redirect:/";

    }

    @GetMapping("/login")
    public String login(Model model){
        return "login";

    }

    @GetMapping("/profile")
    public String profile(Model model){
        return "profile";

    }

    @GetMapping("/test")
    public String test(Model model){
        return "test";

    }

}