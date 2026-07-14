package org.studyeasy.SpringStarter.sevices;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.studyeasy.SpringStarter.models.Account;
import org.studyeasy.SpringStarter.models.Authority;
import org.studyeasy.SpringStarter.repositories.AccountRepository;
import org.studyeasy.SpringStarter.util.constants.Authorities;
import org.studyeasy.SpringStarter.util.constants.Roles;

@Service
public class AccountService implements UserDetailsService {
    
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*
    Sempre que um usuário se inscrever, marcaremos o usuário 
    com uma função de usuário. 
    */
    public Account save(Account account){
        
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        
        /*
        Se a conta não possuir um papel definido, atribuímos por default a conta o papel USER. 
        */
        if(account.getRole()==null){
            account.setRole(Roles.USER.getRole());
        }
               
        return accountRepository.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        Optional<Account> optionlAccount = accountRepository.findOneByEmailIgnoreCase(email);

        if(!optionlAccount.isPresent()){
            throw new UsernameNotFoundException("Account not found!");
        }

        Account account = optionlAccount.get();

        List<GrantedAuthority> grantedAuthority = new ArrayList<>();
        grantedAuthority.add(new SimpleGrantedAuthority(account.getRole()));

        for(Authority _auth:account.getAuthorities()){
             grantedAuthority.add(new SimpleGrantedAuthority(_auth.getName()));

        }

        return new User(account.getEmail(), account.getPassword(), grantedAuthority); 
    }

}
