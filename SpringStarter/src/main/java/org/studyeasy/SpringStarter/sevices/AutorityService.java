package org.studyeasy.SpringStarter.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.studyeasy.SpringStarter.models.Authority;
import org.studyeasy.SpringStarter.repositories.AuthorityRepository;

public class AutorityService {
    
    @Autowired
    private AuthorityRepository authorityRepository;

    public Authority save (Authority authority){
        return authorityRepository.save(authority);
    }

}
