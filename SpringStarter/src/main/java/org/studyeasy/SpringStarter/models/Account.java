package org.studyeasy.SpringStarter.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {
    
    /*Define o campo que será a Chave Primária (Primary Key) da tabela. */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) /*Define a estratégia de geração da chave primária (ex: GenerationType.IDENTITY para auto-incremento).*/
    private Long id;
    
    //@Column(name = "email", nullable = false, length = 100)
    private String email;

    //@Column(name = "password", nullable = false, length = 100)
    private String password;

    //@Column(name = "firstName", nullable = false, length = 100)
    private String firstName;

    //@Column(name = "lastName", nullable = false, length = 100)
    private String lastName;

    private String role; 

    @OneToMany(mappedBy = "account")
    private List<Post> posts;

    @ManyToMany
    @JoinTable(
        name = "account_authority", 
        joinColumns = {@JoinColumn(name="account_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    private Set<Authority> authorities = new HashSet<>();
    
}
