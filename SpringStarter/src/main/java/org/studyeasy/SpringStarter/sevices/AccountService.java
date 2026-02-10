package org.studyeasy.SpringStarter.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.studyeasy.SpringStarter.models.Account;
import org.studyeasy.SpringStarter.repositories.AccountRepository;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;

    /* 
    public Optional<Account> getById(Long id){
        return accountRepository.findById(id);
    }
    
    public List<Account> getAll(){
        return accountRepository.findAll();
    }

    public void delete (Account account){
        accountRepository.delete(account);
    }
    */

    public Account save(Account account){
       
        return accountRepository.save(account);
    }

}
