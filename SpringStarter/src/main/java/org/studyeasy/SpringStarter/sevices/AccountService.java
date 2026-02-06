package org.studyeasy.SpringStarter.sevices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.studyeasy.SpringStarter.models.Account;
import org.studyeasy.SpringStarter.models.Person;
import org.studyeasy.SpringStarter.repositories.AccountRepository;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;

    public Optional<Account> getById(Long id){
        return accountRepository.findById(id);
    }
    
    public List<Account> getAll(){
        return accountRepository.findAll();
    }

    public void delete (Account account){
        accountRepository.delete(account);
    }

    public Account save(Account account){
        /*
        if(person.getId() == null){
            person.setCreatedAt(LocalDateTime.now());;
        }
        */
        return AccountRepository.save(account);
    }

}
