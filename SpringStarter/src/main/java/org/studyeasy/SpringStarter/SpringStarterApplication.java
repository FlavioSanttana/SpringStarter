package org.studyeasy.SpringStarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.studyeasy.SpringStarter.models.Account;
import org.studyeasy.SpringStarter.sevices.AccountService;

@SpringBootApplication
public class SpringStarterApplication {

	@Autowired
	private AccountService accountService; 

	public static void main(String[] args) {
		SpringApplication.run(SpringStarterApplication.class, args);
	}

	@PostMapping("/register")
	public String register(@ModelAttribute Account account){

		accountService.save(account);

		return "redirect:/";

	}

}
